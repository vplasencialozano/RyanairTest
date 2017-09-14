
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*
	Main Page to define the steps
 */
public class StepLibrary {

    private String URL = "https://www.ryanair.com/ie/en/";

    private String DRIVER_PATH = "./chromedriver.exe";

    private String CHROME_DRIVER = "webdriver.chrome.driver";

    private WebDriver driver;

    @Given ("I make a booking from $from to $to on $date for $numAdult adults and $numChild child")
    public void makebooking(final String from, final String to,final String date,  final Integer numAdults, final Integer numChild ) throws InterruptedException {

        System.setProperty(CHROME_DRIVER, DRIVER_PATH);
        driver = new ChromeDriver();
        driver.get(URL);

        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginUSer();

        Thread.sleep(2000);
        InitPage initPage = new InitPage(driver);
        SelectFlyPage selectFlyPage = initPage.fillTripDatesAndContinue(from,to,date,numAdults,numChild);

        SeatSelectionPage seatSelectionPage = selectFlyPage.selectfliesAndContinue();
        seatSelectionPage.closeMessageChild();

        Thread.sleep(1000);
        PaymentPage paymentPage = seatSelectionPage.selectSeat();
        paymentPage.fillPersonalData();


    }
    @When("I pay for booking with card details $cardNumber month $month year $year cvs $cvs")
    public void insertCardDetails(final String cardNumber, final String month, final String year, final String cvs){
        PaymentPage paymentPage = new PaymentPage(driver);
        paymentPage.fillPaymentData(cardNumber,month, year,cvs);

    }
    @Then ("I should get payment declined message $message")
    public void checkResults(final String message){
        PaymentPage paymentPage = new PaymentPage(driver);
        paymentPage.checkErrorMessage(message);
        driver.close();
    }
}
