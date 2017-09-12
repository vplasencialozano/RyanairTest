import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends CommonPage{

    public static final String EMAIL_ADDRESS = "vplasencialozano@gmail.com";
    public static final String PASSWORD = "Testing2000";
    public static String LOGIN_XPATH = ".//*[@id='myryanair-auth-login']/a";

  public static String EMAIL_XPATH = ".//*[@name='emailAddress']";

  public static String PASSWORD_XPATH = ".//*[@id='ngdialog1']/div[2]/signup-home-form/div/div/div[2]/div/dialog-body/div[2]/signup-home-tabs/div[2]/div/div/div/form/div[2]/password-input/input";

  public static String LOGIN_BUTTON_CONFIRM_XPATH = ".//*[@id='ngdialog1']/div[2]/signup-home-form/div/div/div[2]/div/dialog-body/div[2]/signup-home-tabs/div[2]/div/div/div/form/div[4]/button-spinner/button";

    public LoginPage(final WebDriver driver ){
        super(driver);

    }

    public void loginUSer(){

        clickOnXPath(LOGIN_XPATH);
        writeOnXPath(EMAIL_XPATH,EMAIL_ADDRESS);
        writeOnXPath(PASSWORD_XPATH,PASSWORD);
        clickOnXPath(LOGIN_BUTTON_CONFIRM_XPATH);

    }

}
