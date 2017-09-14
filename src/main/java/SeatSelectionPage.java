import org.openqa.selenium.WebDriver;

public class SeatSelectionPage extends CommonPage{

    private static final String ADD_PRIORITY_XPATH = ".//*[@id='ngdialog4']/div/div[2]/div[5]/button[2]";

    private static String XPATH_OK_DIALOG = ".//*[@id='ngdialog3']/div/div[2]/div/button";

    private static String XPATH_SEAT_ADULT1 = ".//*[@id='scrollable']/div[1]/div/div[2]/div[6]/div[5]/span/span";

    private static String XPATH_SEAT_ADULT2 = ".//*[@id='scrollable']/div[1]/div/div[2]/div[6]/div[6]/span/span";

    private static String XPATH_SEAT_CHILD = ".//*[@id='scrollable']/div[1]/div/div[2]/div[6]/div[7]/span/span";

    private static String XPATH_CONFIRM_BUTTON = ".//*[@id='ngdialog2']/div[2]/div[1]/div/div[4]/dialog-footer/dialog-overlay-footer/div/div[3]/disabled-tooltip/span/ng-transclude/tooltip-target/button-spinner/button";

    private static String XPATH_CONFIRM_BUTTON2 = ".//*[@id='ngdialog2']/div[2]/div[1]/div/div[4]/dialog-footer/dialog-overlay-footer/div/div[3]/disabled-tooltip/span/ng-transclude/tooltip-target/button-spinner/button/span[2]/translate/span";

    private static String XPATH_CHECKOUT_BUTTON = ".//*[@id='booking-selection']/article/div[2]/section/div[2]/button";

    public SeatSelectionPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void closeMessageChild() throws InterruptedException {

        clickOnXPath(XPATH_OK_DIALOG);
    }

    public PaymentPage selectSeat() throws InterruptedException {

        Integer i = 6;
        while ( isFullSeat(XPATH_SEAT_ADULT1) && i<=12) {

            i++;
            XPATH_SEAT_ADULT1 = ".//*[@id='scrollable']/div[1]/div/div[2]/div[" + i +"]/div[5]/span/span";

        }
        clickOnXPath(XPATH_SEAT_ADULT1);


        i = 6;
        while (isFullSeat(XPATH_SEAT_CHILD)  && i<12) {

            i++;
            XPATH_SEAT_CHILD = ".//*[@id='scrollable']/div[1]/div/div[2]/div[" + i +"]/div[7]/span/span";

        }

        clickOnXPath(XPATH_SEAT_CHILD);

        i = 6;
        while (isFullSeat(XPATH_SEAT_ADULT2)  && i<12) {

            i++;
            XPATH_SEAT_ADULT2 = ".//*[@id='scrollable']/div[1]/div/div[2]/div[" + i +"]/div[6]/span/span";

        }

        clickOnXPath(XPATH_SEAT_ADULT2);

        clickOnXPath(XPATH_CONFIRM_BUTTON);
        Thread.sleep(500);
        clickOnXPath(XPATH_CONFIRM_BUTTON2);
        clickOnXPath(ADD_PRIORITY_XPATH);
        Thread.sleep(500);
        clickOnXPath(XPATH_CHECKOUT_BUTTON);

        return new PaymentPage(getWebDriver());

    }
}
