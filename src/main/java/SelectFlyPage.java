import org.openqa.selenium.WebDriver;

/**
 * Page to select specific fly
 */
public class SelectFlyPage extends CommonPage{


    private static String  selectedSeatPath = "//*[@id='continue']";

    private static String  selectedContinueButtonPath = "/html/body/div[2]/main/div[1]/section/div/div/div/button";

    public SelectFlyPage(WebDriver webDriver) {

            super(webDriver);
    }

    public void selectFirstFly(final String date){


        final String selectedFlyPath = "//*[@id='flight-FR~8558~ ~~DUB~" + date + " 14:20~SXF~" + date + " 17:40~']/div/div[2]/flights-table-price/div/div" ;

        clickOnXPath(selectedFlyPath);

    }
    public void selectSeatFly() {
        clickOnXPath(selectedSeatPath);

    }
    public void clickContinueButtonFly()  {
        clickOnXPath(selectedContinueButtonPath);
    }

    public SeatSelectionPage selectfliesAndContinue(final String date) throws InterruptedException {

        selectFirstFly(date);
        Thread.sleep(500);
        selectSeatFly();
        clickContinueButtonFly();
        return new SeatSelectionPage(getWebDriver());

    }
}
