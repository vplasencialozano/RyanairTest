import org.jbehave.core.annotations.*;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Class to hold all the driver lifecycle management code
 */
public class FunctionalTest {

    private static String URL = "https://www.ryanair.com/ie/en/";

    private static String DRIVER_PATH = "./chromedriver.exe";

    private static String CHROME_DRIVER = "webdriver.chrome.driver";

    private StoryReporterBuilder Reporter = new StoryReporterBuilder();


    /**
     * The constant driver.
     */
    protected static WebDriver driver;

    /**
     * Set up stories.
     */
    @BeforeStories
    public static void setUpStories(){

        System.setProperty(CHROME_DRIVER, DRIVER_PATH);

    }

    /**
     * Set up story.
     */
    @BeforeScenario (uponType = ScenarioType.ANY)
    public static void setUpStory( ){

        driver = new ChromeDriver();
        driver.get(URL);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginUSer();

    }

    /**
     * Clean up story.
     */
    @AfterScenario (uponType = ScenarioType.ANY)
    public void cleanUpStory(){
        driver.manage().deleteAllCookies();
        driver.close();
    }

    /**
     * Clean up.
     */
    @AfterStories
    public void cleanUp(){
        driver.quit();
    }
}
