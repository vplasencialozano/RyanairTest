
import org.openqa.selenium.WebDriver;
/**
 * Init page to insert fly data
 */
public class InitPage extends CommonPage {

   private static String FROM_XPATH = "/html/body/div[2]/main/article/div[2]/smart-search/div/div[2]/div[1]/div/form/div[2]/div/div/div[1]/div[2]/div[2]/div/div[1]/input";

   private static String FROM_POPUP = "/html/body/div[2]/main/article/div[2]/smart-search/div/div[2]/div[1]/div/form/div[2]/div/div/div[1]/div[3]/div/div/div[2]/popup-content/core-linked-list/div[2]/div[1]/div[3]/span/strong";

   private static String TO_XPATH = "/html/body/div[2]/main/article/div[2]/smart-search/div/div[2]/div[1]/div/form/div[2]/div/div/div[2]/div[2]/div[2]/div/div[1]/input";

   private static String TO_POPUP = "/html/body/div[2]/main/article/div[2]/smart-search/div/div[2]/div[1]/div/form/div[2]/div/div/div[2]/div[3]/div/div/div[2]/popup-content/core-linked-list/div[2]/div[1]/div[3]/span";

   private static String OnWayID = "lbl-flight-search-type-one-way";

   private static String XPathFlyOutDD = "/html/body/div[2]/main/article/div[2]/smart-search/div/div[2]/div[1]/div/form/div[2]/div[2]/div[1]/div/div[1]/div/div[2]/div[2]/div/input[1]";

   private static String XPathFlyOutMM = "/html/body/div[2]/main/article/div[2]/smart-search/div/div[2]/div[1]/div/form/div[2]/div[2]/div[1]/div/div[1]/div/div[2]/div[2]/div/input[2]";

   private static String XPathFlyOutYYYY = "/html/body/div[2]/main/article/div[2]/smart-search/div/div[2]/div[1]/div/form/div[2]/div[2]/div[1]/div/div[1]/div/div[2]/div[2]/div/input[3]";

   private static String XPathTravellerSelector = "/html/body/div[2]/main/article/div[2]/smart-search/div/div[2]/div[1]/div/form/div[2]/div[2]/div[2]/div[2]/div[2]/div/div[1]";

   private static String XpathAcceptButton = "/html/body/div[2]/main/article/div[2]/smart-search/div/div[2]/div[1]/div/form/div[2]/div[2]/div[2]/div[3]/div/div/div[2]/popup-content/div[6]/div/div[3]/core-inc-dec/button[2]";

   private static String XpathChildTraveller = "/html/body/div[2]/main/article/div[2]/smart-search/div/div[2]/div[1]/div/form/div[2]/div[2]/div[2]/div[3]/div/div/div[2]/popup-content/div[8]/div/div[3]/core-inc-dec/button[2]";

   private static String XpathContinueButton = "/html/body/div[2]/main/article/div[2]/smart-search/div/div[2]/div[1]/div/form/div[4]/button[2]";

    public InitPage(final WebDriver driver ){
        super(driver);
        }

    public void setFrom(final String from){

        clearAndWriteOnXPath(FROM_XPATH,from);
        clickOnXPath(FROM_POPUP);
    }

    public void setTo(final String to){

        clearAndWriteOnXPath(TO_XPATH,to);
        clickOnXPath(TO_POPUP);

    }


    public void setDates(final String date){

        if(date.substring(6,10).equalsIgnoreCase("2018")) {
            clearAndWriteOnXPath(XPathFlyOutYYYY, date.substring(6, 10));
            clearAndWriteOnXPath(XPathFlyOutDD, date.substring(3, 5));
            clearAndWriteOnXPath(XPathFlyOutMM, date.substring(0, 2));
            clearAndWriteOnXPath(XPathFlyOutYYYY, date.substring(6, 10));
        }else{
            clearAndWriteOnXPath(XPathFlyOutDD, date.substring(3, 5));
            clearAndWriteOnXPath(XPathFlyOutMM, date.substring(0, 2));
            clearAndWriteOnXPath(XPathFlyOutYYYY,date.substring(6,10));
        }

    }

    public void setTravelers(final Integer numAdults,final Integer numChild){

        clickOnXPath(XPathTravellerSelector);

        for (int i = 1; i <numAdults ; i++) {
            clickOnXPath(XpathAcceptButton);
            }

        for (int i = 0; i <numChild ; i++) {
            clickOnXPath(XpathChildTraveller);
        }
    }

    public void onWay(){
        clickOnId(OnWayID);
    }

    public void clickContinue(){

        clickOnXPath(XpathContinueButton);
    }

    public SelectFlyPage fillTripDatesAndContinue(final String from, final String to, final String date, final Integer numAdults, final Integer numChild){

        onWay();
        setFrom(from);
        setTo(to);
        setDates(date);
        setTravelers(numAdults,numChild);
        clickContinue();
        return new SelectFlyPage(getWebDriver());

    }
}
