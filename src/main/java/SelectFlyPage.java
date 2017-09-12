import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SelectFlyPage extends CommonPage{


    //public static final  String selectedFlyPath = "//div[2]flights-table-price/div/div/span[2]";

    public static final  String selectedFlyPath = ".//*[@id='flight-FR~8558~ ~~DUB~12/23/2017 14:20~SXF~12/23/2017 17:40~']/div/div[2]/flights-table-price/div/div";

    public static final  String selectedSeatPath = ".//*[@id='continue']";

    public static final  String selectedContinueButtonPath = "/html/body/div[2]/main/div[1]/section/div/div/div/button";

    public SelectFlyPage(WebDriver webDriver) {

            super(webDriver);
    }

    public void selectFirstFly(){
        clickOnXPath(selectedFlyPath);

    }
    public void selectSeatFly() {
        clickOnXPath(selectedSeatPath);

    }
    public void clickContinueButtonFly()  {
        clickOnXPath(selectedContinueButtonPath);
    }

    public SeatSelectionPage selectfliesAndContinue() {

        selectFirstFly();
        selectSeatFly();
        clickContinueButtonFly();
        return new SeatSelectionPage(getWebDriver());

    }
}
