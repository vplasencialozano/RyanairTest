import org.openqa.selenium.WebDriver;

/**
 * Page to select specific fly
 */
public class SelectFlyPage extends CommonPage{


    private static String  selectedSeatPath = "//*[@id='continue']";

    private static String  selectedContinueButtonPath = "/html/body/div[2]/main/div[1]/section/div/div/div/button";

    /**
     * Instantiates a new Select fly page.
     *
     * @param webDriver the web driver
     */
    public SelectFlyPage(WebDriver webDriver) {

            super(webDriver);
    }

    /**
     * Select first fly.
     *
     * @param date the date
     */
    public void selectFirstFly(final String date){


        final String selectedFlyPath = "//*[@id='flight-FR~8558~ ~~DUB~" + date + " 14:20~SXF~" + date + " 17:40~']/div/div[2]/flights-table-price/div/div" ;

        clickOnXPath(selectedFlyPath);

    }

    /**
     * Select seat fly.
     */
    public void selectSeatFly() {
        clickOnXPath(selectedSeatPath);

    }

    /**
     * Click continue button fly.
     */
    public void clickContinueButtonFly()  {
        clickOnXPath(selectedContinueButtonPath);
    }

    /**
     * Selectflies and continue seat selection page.
     *
     * @param date the date
     * @return the seat selection page
     * @throws InterruptedException the interrupted exception
     */
    public SeatSelectionPage selectfliesAndContinue(final String date) throws InterruptedException {

        selectFirstFly(date);
        Thread.sleep(500);
        selectSeatFly();
        clickContinueButtonFly();
        return new SeatSelectionPage(getWebDriver());

    }
}
