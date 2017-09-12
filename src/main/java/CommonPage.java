import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonPage {

    private static WebDriver webDriver;

    private static WebDriverWait wait;

    public CommonPage (WebDriver webDriver){

        this.webDriver = webDriver;
        wait = new WebDriverWait(webDriver, 20);
    }

    public static WebDriver getWebDriver() {
        return webDriver;
    }

    public static void setWebDriver(WebDriver webDriver) {
        CommonPage.webDriver = webDriver;
    }

    public static void waitForXpath(final String xpath) {

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
    }

    public static void waitForId(final String id) {

        wait.until(ExpectedConditions.elementToBeClickable(By.id(id)));
    }

    public static void clickOnXPath(final String xpath) {
        waitForXpath(xpath);
        webDriver.findElement(By.xpath(xpath)).click();
    }

    public static void writeOnXPath(final String xpath,final String text) {
        waitForXpath(xpath);
        webDriver.findElement(By.xpath(xpath)).sendKeys(text);
    }

    public static void clearAndWriteOnXPath(final String xpath,final String text) {
        waitForXpath(xpath);
        webDriver.findElement(By.xpath(xpath)).clear();
        webDriver.findElement(By.xpath(xpath)).sendKeys(text);
    }

    public static void clickOnId(final String id) {
        waitForId(id);
        webDriver.findElement(By.id(id)).click();
    }

    public static void writeOnId(final String id, final String text) {
        waitForId(id);
        webDriver.findElement(By.id(id)).sendKeys(text);
    }

    public static boolean isFullSeat(final String xpath) {

        return webDriver.findElements(By.xpath(xpath)).isEmpty();
    }

    public static String getErrorMessage(final String xpath){
        waitForXpath(xpath);
        return  webDriver.findElement(By.xpath(xpath)).getText();
    }
}
