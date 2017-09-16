import com.google.common.base.Verify;
import org.openqa.selenium.WebDriver;

/**
 * Page to insert payments data
 */
public class PaymentPage extends CommonPage{

    private static final String THE_ERROR_MESSAGE_IS_THE_EXPECTED = "The error message is the expected";

    private static String XPATH_TITLE_SELECTOR_1 = "//*[@id='checkout']/div/form/div[1]/div[1]/div/div[2]/ng-form/passenger-input-group[1]/div/ng-form/div[1]/div[1]/div/select";

    private static String XPATH_FIRST_NAME_1 = "//*[@id='checkout']/div/form/div[1]/div[1]/div/div[2]/ng-form/passenger-input-group[1]/div/ng-form/div[1]/div[2]/input";

    private static String XPATH_SURNAME_1= "//*[@id='checkout']/div/form/div[1]/div[1]/div/div[2]/ng-form/passenger-input-group[1]/div/ng-form/div[1]/div[3]/input";

    private static String XPATH_TITLE_SELECTOR_2 = "//*[@id='checkout']/div/form/div[1]/div[1]/div/div[2]/ng-form/passenger-input-group[2]/div/ng-form/div[1]/div[1]/div/select";

    private static String XPATH_FIRST_NAME_2 = "//*[@id='checkout']/div/form/div[1]/div[1]/div/div[2]/ng-form/passenger-input-group[2]/div/ng-form/div[1]/div[2]/input";

    private static String XPATH_SURNAME_2= "//*[@id='checkout']/div/form/div[1]/div[1]/div/div[2]/ng-form/passenger-input-group[2]/div/ng-form/div[1]/div[3]/input";

    private static String XPATH_NAME_CHILD = "//*[@id='checkout']/div/form/div[1]/div[1]/div/div[2]/ng-form/passenger-input-group[3]/div/ng-form/div[1]/div[1]/input";

    private static String XPATH_SURNAME_CHILD= "//*[@id='checkout']/div/form/div[1]/div[1]/div/div[2]/ng-form/passenger-input-group[3]/div/ng-form/div[1]/div[2]/input";

    private static String XPATH_CARD_NUMBER= "//*[@id='checkout']/div/form/div[1]/div[2]/div[2]/div[4]/div/div[2]/div[1]/div/div/payment-method-retrieved-cards/payment-method-card/div[1]/input";

    private static String XPATH_CARD_TYPE= "//*[@id='checkout']/div/form/div[1]/div[2]/div[2]/div[4]/div/div[2]/div[1]/div/div/payment-method-retrieved-cards/payment-method-card/div[2]/div/div/select";

    private static String XPATH_EXPIRE_MONTH= "//*[@id='checkout']/div/form/div[1]/div[2]/div[2]/div[4]/div/div[2]/div[1]/div/div/payment-method-retrieved-cards/payment-method-card/div[3]/div[1]/div[1]/div/select";

    private static String XPATH_YEAR= "//*[@id='checkout']/div/form/div[1]/div[2]/div[2]/div[4]/div/div[2]/div[1]/div/div/payment-method-retrieved-cards/payment-method-card/div[3]/div[1]/div[2]/div/div/select";

    private static String XPATH_SECURITY_CODE= "//*[@id='checkout']/div/form/div[1]/div[2]/div[2]/div[4]/div/div[2]/div[1]/div/div/payment-method-retrieved-cards/payment-method-card/div[3]/div[2]/div[2]/input";

    private static String XPATH_CARD_HOLDER= "//*[@id='checkout']/div/form/div[1]/div[2]/div[2]/div[4]/div/div[2]/div[1]/div/div/payment-method-retrieved-cards/payment-method-card/div[4]/div[1]/input";

    private static String XPATH_BILLING_ADDRESS = "//*[@id='checkout']/div/form/div[1]/div[2]/div[2]/div[4]/div/div[2]/div[2]/address-form/div[1]/input";

    private static String XPATH_BILLING_CITY = "//*[@id='checkout']/div/form/div[1]/div[2]/div[2]/div[4]/div/div[2]/div[2]/address-form/div[3]/div[1]/input";

    private static String XPATH_ACCEPT_CONDITIONS = "//*[@id='checkout']/div/form/div[1]/div[2]/div[2]/div[6]/div";

    private static String XPATH_ACCEPT_CONDITIONS_BUTTON = "//*[@id='checkout']/div/form/div[1]/div[2]/div[2]/div[6]/button";

    private static String XPATH_ERROR_MESSAGE= "//*[@id='checkout']/div/form/div[1]/div[2]/div[2]/div[4]/div/div[2]/div[1]/div/div/payment-method-retrieved-cards/payment-method-card/div[1]/ul/li/span";


    public PaymentPage(WebDriver webDriver){
        super(webDriver);
    }

    public void fillPersonalData() throws InterruptedException {

        writeOnXPath(XPATH_TITLE_SELECTOR_1,"Mr");
        writeOnXPath(XPATH_FIRST_NAME_1,"Rickk");
        writeOnXPath(XPATH_SURNAME_1,"Deckardd");

        writeOnXPath(XPATH_TITLE_SELECTOR_2,"Mr");
        writeOnXPath(XPATH_FIRST_NAME_2,"Royy");
        writeOnXPath(XPATH_SURNAME_2,"Battyy");

        writeOnXPath(XPATH_NAME_CHILD,"Eldonn");
        writeOnXPath(XPATH_SURNAME_CHILD,"Tyrelll");

    }

    public void fillPaymentData(final String creditCard, final String dateCardMonth,final String dateCardYear, final String cvsCard){
        writeOnXPath(XPATH_CARD_NUMBER,creditCard.replaceAll(" ",""));
        writeOnXPath(XPATH_CARD_TYPE,"MasterCard");
        writeOnXPath(XPATH_EXPIRE_MONTH,dateCardMonth);
        writeOnXPath(XPATH_YEAR,dateCardYear);
        writeOnXPath(XPATH_SECURITY_CODE,cvsCard);
        writeOnXPath(XPATH_CARD_HOLDER,"Rick Deckard");

        writeOnXPath(XPATH_BILLING_ADDRESS,"Castellana 1");
        writeOnXPath(XPATH_BILLING_CITY,"Madrid");
        clickOnXPath(XPATH_ACCEPT_CONDITIONS);
        clickOnXPath(XPATH_ACCEPT_CONDITIONS_BUTTON);
    }

    public void checkErrorMessage(final String message) {

        Verify.verify(getErrorMessage(XPATH_ERROR_MESSAGE).equalsIgnoreCase(message), THE_ERROR_MESSAGE_IS_THE_EXPECTED);

    }

    public void loginOut() {
        clickOnXPath("//*[@id='menu-container']/ul[2]/li/a/span");
        clickOnXPath("//*[@id='menu-container']/ul[2]/li/div/ul/li[9]/a");
    }
}
