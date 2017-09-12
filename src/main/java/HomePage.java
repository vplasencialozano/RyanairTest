import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/*

 */
public class HomePage extends CommonPage {

    private static WebDriverWait wait;

    public static String FROM_XPATH = "/html/body/div[2]/main/article/div[2]/smart-search/div/div[2]/div[1]/div/form/div[2]/div/div/div[1]/div[2]/div[2]/div/div[1]/input";
    public static String FROM_POPUP = "/html/body/div[2]/main/article/div[2]/smart-search/div/div[2]/div[1]/div/form/div[2]/div/div/div[1]/div[3]/div/div/div[2]/popup-content/core-linked-list/div[2]/div[1]/div[3]/span/strong";

    public static String TO_XPATH = "/html/body/div[2]/main/article/div[2]/smart-search/div/div[2]/div[1]/div/form/div[2]/div/div/div[2]/div[2]/div[2]/div/div[1]/input";
    public static String TO_POPUP = "/html/body/div[2]/main/article/div[2]/smart-search/div/div[2]/div[1]/div/form/div[2]/div/div/div[2]/div[3]/div/div/div[2]/popup-content/core-linked-list/div[2]/div[1]/div[3]/span";

    public static String OnWayID = "lbl-flight-search-type-one-way";

    public static String XPathFlyOut = "/html/body/div[2]/main/article/div[2]/smart-search/div/div[2]/div[1]/div/form/div[2]/div[2]/div[1]/div/div[1]/div/div[2]/div[2]/div/input[3]";
    public static String XPathFlyOutDD = "/html/body/div[2]/main/article/div[2]/smart-search/div/div[2]/div[1]/div/form/div[2]/div[2]/div[1]/div/div[1]/div/div[2]/div[2]/div/input[1]";
    public static String XPathFlyOutMM = "/html/body/div[2]/main/article/div[2]/smart-search/div/div[2]/div[1]/div/form/div[2]/div[2]/div[1]/div/div[1]/div/div[2]/div[2]/div/input[2]";
    public static String XPathFlyOutYYYY = "/html/body/div[2]/main/article/div[2]/smart-search/div/div[2]/div[1]/div/form/div[2]/div[2]/div[1]/div/div[1]/div/div[2]/div[2]/div/input[3]";


    public static String XPathTravellerSelector = "/html/body/div[2]/main/article/div[2]/smart-search/div/div[2]/div[1]/div/form/div[2]/div[2]/div[2]/div[2]/div[2]/div/div[1]";

    public static String XpathAcceptButton = "/html/body/div[2]/main/article/div[2]/smart-search/div/div[2]/div[1]/div/form/div[2]/div[2]/div[2]/div[3]/div/div/div[2]/popup-content/div[6]/div/div[3]/core-inc-dec/button[2]";
    public static String XpathChildTraveller = "/html/body/div[2]/main/article/div[2]/smart-search/div/div[2]/div[1]/div/form/div[2]/div[2]/div[2]/div[3]/div/div/div[2]/popup-content/div[8]/div/div[3]/core-inc-dec/button[2]";

    public static String XpathContinueButton = "/html/body/div[2]/main/article/div[2]/smart-search/div/div[2]/div[1]/div/form/div[4]/button[2]";

    public HomePage(final WebDriver driver ){
        super(driver);
        }

    public void setFrom(final String from){

        clearAndWriteOnXPath(FROM_XPATH,from.replace("“","").replace("”",""));
        clickOnXPath(FROM_POPUP);
    }

    public void setTo(final String to){

        clearAndWriteOnXPath(TO_XPATH,to.replace("“","").replace("”",""));
        clickOnXPath(TO_POPUP);

    }


    public void setDates(){

        clearAndWriteOnXPath(XPathFlyOutDD,"23");
        clearAndWriteOnXPath(XPathFlyOutMM,"12");
        clearAndWriteOnXPath(XPathFlyOutYYYY,"2017");

    }

    public void setTravelers(){

        clickOnXPath(XPathTravellerSelector);
        clickOnXPath(XpathAcceptButton);
        clickOnXPath(XpathChildTraveller);

    }

    public void onWay(){
        clickOnId(OnWayID);
    }

    public void clickContinue(){

        clickOnXPath(XpathContinueButton);
    }

    public SelectFlyPage fillTripDatesAndContinue(String from, String to){

        onWay();
        setFrom(from);
        setTo(to);
        setDates();
        setTravelers();
        clickContinue();
        return new SelectFlyPage(getWebDriver());

    }
}
