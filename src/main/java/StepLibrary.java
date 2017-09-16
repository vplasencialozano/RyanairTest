
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

/**
 * Main Page to define the steps
 */
public class StepLibrary extends FunctionalTest{

    /**
     * Makebooking.
     *
     * @param from      the from
     * @param to        the to
     * @param date      the date
     * @param numAdults the num adults
     * @param numChild  the num child
     * @throws InterruptedException the interrupted exception
     */
    @Given ("I make a booking from $from to $to on $date for $numAdult adults and $numChild child")
    public void makebooking(final String from, final String to,final String date,  final Integer numAdults, final Integer numChild ) throws InterruptedException {

        Thread.sleep(2000);
        InitPage initPage = new InitPage(driver);
        SelectFlyPage selectFlyPage = initPage.fillTripDatesAndContinue(from,to,date,numAdults,numChild);

        SeatSelectionPage seatSelectionPage = selectFlyPage.selectfliesAndContinue(date);
        seatSelectionPage.closeMessageChild();

        Thread.sleep(1000);
        PaymentPage paymentPage = seatSelectionPage.selectSeat();
        paymentPage.fillPersonalData();


    }

    /**
     * Insert card details.
     *
     * @param cardNumber the card number
     * @param month      the month
     * @param year       the year
     * @param cvs        the cvs
     */
    @When("I pay for booking with card details $cardNumber month $month year $year cvs $cvs")
    public void insertCardDetails(final String cardNumber, final String month, final String year, final String cvs){
        PaymentPage paymentPage = new PaymentPage(driver);
        paymentPage.fillPaymentData(cardNumber,month, year,cvs);

    }

    /**
     * Check results.
     *
     * @param message the message
     */
    @Then ("I should get payment declined message $message")
    public void checkResults(final String message){
        PaymentPage paymentPage = new PaymentPage(driver);
        paymentPage.checkErrorMessage(message);

    }
}
