import org.openqa.selenium.WebDriver;

public class PaymentPage extends CommonPage{

    public static String XPATH_TITLE_SELECTOR_1 = ".//*[@id='checkout']/div/form/div[1]/div[1]/div/div[2]/ng-form/passenger-input-group[1]/div/ng-form/div[1]/div[1]/div/select";

    public static String XPATH_FIRST_NAME_1 = "//*[@id='checkout']/div/form/div[1]/div[1]/div/div[2]/ng-form/passenger-input-group[1]/div/ng-form/div[1]/div[2]/input";

    public static String XPATH_SURNAME_1= "//*[@id='checkout']/div/form/div[1]/div[1]/div/div[2]/ng-form/passenger-input-group[1]/div/ng-form/div[1]/div[3]/input";

    public static String XPATH_TITLE_SELECTOR_2 = "//*[@id='checkout']/div/form/div[1]/div[1]/div/div[2]/ng-form/passenger-input-group[2]/div/ng-form/div[1]/div[1]/div/select";

    public static String XPATH_FIRST_NAME_2 = ".//*[@id='checkout']/div/form/div[1]/div[1]/div/div[2]/ng-form/passenger-input-group[2]/div/ng-form/div[1]/div[2]/input";

    public static String XPATH_SURNAME_2= "//*[@id='checkout']/div/form/div[1]/div[1]/div/div[2]/ng-form/passenger-input-group[2]/div/ng-form/div[1]/div[3]/input";

    public static String XPATH_NAME_CHILD = "//*[@id='checkout']/div/form/div[1]/div[1]/div/div[2]/ng-form/passenger-input-group[3]/div/ng-form/div[1]/div[1]/input";

    public static String XPATH_SURNAME_CHILD= "//*[@id='checkout']/div/form/div[1]/div[1]/div/div[2]/ng-form/passenger-input-group[3]/div/ng-form/div[1]/div[2]/input";

    public static String XPATH_CARD_NUMBER= "//*[@id='checkout']/div/form/div[1]/div[2]/div[2]/div[4]/div/div[2]/div[1]/div/div/payment-method-retrieved-cards/payment-method-card/div[1]/input";

    public static String XPATH_CARD_TYPE= "//*[@id='checkout']/div/form/div[1]/div[2]/div[2]/div[4]/div/div[2]/div[1]/div/div/payment-method-retrieved-cards/payment-method-card/div[2]/div/div/select";

    public static String XPATH_EXPIRE_MONTH= "//*[@id='checkout']/div/form/div[1]/div[2]/div[2]/div[4]/div/div[2]/div[1]/div/div/payment-method-retrieved-cards/payment-method-card/div[3]/div[1]/div[1]/div/select";

    public static String XPATH_YEAR= ".//*[@id='checkout']/div/form/div[1]/div[2]/div[2]/div[4]/div/div[2]/div[1]/div/div/payment-method-retrieved-cards/payment-method-card/div[3]/div[1]/div[2]/div/div/select";

    public static String XPATH_SECURITY_CODE= ".//*[@id='checkout']/div/form/div[1]/div[2]/div[2]/div[4]/div/div[2]/div[1]/div/div/payment-method-retrieved-cards/payment-method-card/div[3]/div[2]/div[2]/input";

    public static String XPATH_CARD_HOLDER= ".//*[@id='checkout']/div/form/div[1]/div[2]/div[2]/div[4]/div/div[2]/div[1]/div/div/payment-method-retrieved-cards/payment-method-card/div[4]/div[1]/input";

    public static String XPATH_BILLING_ADDRESS = ".//*[@id='checkout']/div/form/div[1]/div[2]/div[2]/div[4]/div/div[2]/div[2]/address-form/div[1]/input";

    public static String XPATH_BILLING_CITY = ".//*[@id='checkout']/div/form/div[1]/div[2]/div[2]/div[4]/div/div[2]/div[2]/address-form/div[3]/div[1]/input";

    public static String XPATH_ACCEPT_CONDITIONS = ".//*[@id='checkout']/div/form/div[1]/div[2]/div[2]/div[6]/div/input";


    public PaymentPage(WebDriver webDriver){
        super(webDriver);
    }

    public void fillPersonalData() throws InterruptedException {

        writeOnXPath(XPATH_TITLE_SELECTOR_1,"Mr");
        writeOnXPath(XPATH_FIRST_NAME_1,"Rick");
        writeOnXPath(XPATH_SURNAME_1,"Deckard");

        writeOnXPath(XPATH_TITLE_SELECTOR_2,"Mr");
        writeOnXPath(XPATH_FIRST_NAME_2,"Roy");
        writeOnXPath(XPATH_SURNAME_2,"Batty");

        writeOnXPath(XPATH_NAME_CHILD,"Eldon");
        writeOnXPath(XPATH_SURNAME_CHILD,"Tyrell");

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
    }

}
