
import com.google.common.base.Verify;
import com.thoughtworks.selenium.Selenium;
import com.thoughtworks.selenium.webdriven.WebDriverBackedSelenium;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.context.Context;
import org.jbehave.core.reporters.TemplateableViewGenerator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.lift.TestContext;
import org.openqa.selenium.lift.WebDriverTestContext;
import org.openqa.selenium.support.PageFactory;

import java.sql.Driver;

/*

 */
public class MainPage {

    private String URL = "https://www.ryanair.com/ie/en/";

    private WebDriver driver;


    @Given ("I make a booking from $from to $to on $date for $numAdult adults and $numChild child")
    public void makebooking(final String from, final String to,final String Date,  final Integer numAdults, final Integer numChild ) throws InterruptedException {

        System.out.println("I make a booking from "+ from + " to " + to + " on 12/03/2017 for 2 adults and 1 child");
        System.setProperty("webdriver.chrome.driver", "C:/Users/Leti-Josevi/Selenium Server/chromedriver.exe");

        driver = new ChromeDriver();
        driver.get(URL);

        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginUSer();

        Thread.sleep(2000);

        HomePage homePage = new HomePage(driver);
        SelectFlyPage selectFlyPage = homePage.fillTripDatesAndContinue(from,to);
        SeatSelectionPage seatSelectionPage = selectFlyPage.selectfliesAndContinue();


        seatSelectionPage.closeMessageChild();
        Thread.sleep(1000);
        PaymentPage paymentPage = seatSelectionPage.selectSeat();

        paymentPage.fillPersonalData();


    }
    @When ("I pay for booking with card details “5555 5555 5555 5557”, “10/18” and “265”")
    public void introduceCardDetails(){
        System.out.println("I pay for booking with card details “5555 5555 5555 5557”, “10/18” and “265”");
        PaymentPage paymentPage = new PaymentPage(driver);
        paymentPage.fillPaymentData("5555 5555 5555 5555","10", "2018","265");

    }
    @Then ("I should get payment declined message")
    public void checkResoults(){
        System.out.println("I should get payment declined message");
        PaymentPage paymentPage = new PaymentPage(driver);
        paymentPage.checkErrorMessage();

    }
}
