import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Class to share common Methods
 */
public class CommonPage {

    private static WebDriver webDriver;

    private static WebDriverWait wait;

    /**
     * Instantiates a new Common page.
     *
     * @param webDriver the web driver
     */
    public CommonPage (WebDriver webDriver){

        this.webDriver = webDriver;
        wait = new WebDriverWait(webDriver, 20);
    }

    /**
     * Gets web driver.
     *
     * @return the web driver
     */
    public static WebDriver getWebDriver() {
        return webDriver;
    }

    /**
     * Sets web driver.
     *
     * @param webDriver the web driver
     */
    public static void setWebDriver(WebDriver webDriver) {
        CommonPage.webDriver = webDriver;
    }

    /**
     * Wait for xpath.
     *
     * @param xpath the xpath
     */
    public static void waitForXpath(final String xpath) {

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
    }

    /**
     * Wait for id.
     *
     * @param id the id
     */
    public static void waitForId(final String id) {

        wait.until(ExpectedConditions.elementToBeClickable(By.id(id)));
    }

    /**
     * Click on x path.
     *
     * @param xpath the xpath
     */
    public static void clickOnXPath(final String xpath) {
        waitForXpath(xpath);
        webDriver.findElement(By.xpath(xpath)).click();
    }

    /**
     * Write on x path.
     *
     * @param xpath the xpath
     * @param text  the text
     */
    public static void writeOnXPath(final String xpath,final String text) {
        waitForXpath(xpath);
        webDriver.findElement(By.xpath(xpath)).sendKeys(text);
    }

    /**
     * Clear and write on x path.
     *
     * @param xpath the xpath
     * @param text  the text
     */
    public static void clearAndWriteOnXPath(final String xpath,final String text) {
        waitForXpath(xpath);
        webDriver.findElement(By.xpath(xpath)).clear();
        webDriver.findElement(By.xpath(xpath)).sendKeys(text);
    }

    /**
     * Click on id.
     *
     * @param id the id
     */
    public static void clickOnId(final String id) {
        waitForId(id);
        webDriver.findElement(By.id(id)).click();
    }

    /**
     * Write on id.
     *
     * @param id   the id
     * @param text the text
     */
    public static void writeOnId(final String id, final String text) {
        waitForId(id);
        webDriver.findElement(By.id(id)).sendKeys(text);
    }

    /**
     * Is full seat boolean.
     *
     * @param xpath the xpath
     * @return the boolean
     */
    public static boolean isFullSeat(final String xpath) {

        return webDriver.findElements(By.xpath(xpath)).isEmpty();
    }

    /**
     * Get error message string.
     *
     * @param xpath the xpath
     * @return the string
     */
    public static String getErrorMessage(final String xpath){
        waitForXpath(xpath);
        return  webDriver.findElement(By.xpath(xpath)).getText();
    }
}
