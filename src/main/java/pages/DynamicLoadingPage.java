package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DynamicLoadingPage {

    private WebDriver driver;
    private String linkXpath_Format = ".//a[contains(text(), '%s')]";
    private By link_Example1 = By.xpath(String.format(linkXpath_Format, "Example 1"));
    private By link_Example2 = By.xpath(String.format(linkXpath_Format, "Example 2"));

    public DynamicLoadingPage(WebDriver driver) {
        this.driver = driver;
    }

    public DynamicLoadingExample1Page clickExample1() {
        driver.findElement(link_Example1).click();
        return new DynamicLoadingExample1Page(driver);
    }

    public DynamicLoadingExample2Page clickExample2() {
        driver.findElement(link_Example2).click();
        return new DynamicLoadingExample2Page(driver);
    }

    public class DynamicLoadingExample1Page {

        private WebDriver driver;
        private By startButton = By.cssSelector(("#start button"));
        private By loadingIndicator = By.id("loading");
        private By loadedText = By.id("finish");

        public DynamicLoadingExample1Page(WebDriver driver) {
            this.driver = driver;
        }

        public void clickStartButton() {
            driver.findElement(startButton).click();
           //WebDriverWait wait = new WebDriverWait(driver, 5);
           //wait.until(ExpectedConditions.invisibilityOf(driver.findElement(loadingIndicator)));
            FluentWait wait = new FluentWait(driver)
                    .withTimeout(Duration.ofSeconds(5))
                    .pollingEvery(Duration.ofSeconds(1))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOf(driver.findElement(loadingIndicator)));
        }

        public String getLoadedText() {
            return driver.findElement(loadedText).getText();
        }


    }

    public class DynamicLoadingExample2Page {

        private WebDriver driver;
        private By startButton = By.cssSelector(("#start button"));
        private By loadedText = By.id("finish");

        public DynamicLoadingExample2Page(WebDriver driver) {
            this.driver = driver;
        }

        public void clickStartButton() {
            driver.findElement(startButton).click();
            WebDriverWait wait = new WebDriverWait(driver, 5);
            wait.until(ExpectedConditions.presenceOfElementLocated(loadedText));
        }

        public String getLoadedText() {
            return driver.findElement(loadedText).getText();
        }


    }
}
