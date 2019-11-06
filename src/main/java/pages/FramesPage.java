package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FramesPage {

    private WebDriver driver;
    private By nestedFramesLink = By.linkText("Nested Frames");
    private By body = By.tagName("body");

    public FramesPage(WebDriver driver) {
        this.driver = driver;
    }

    public NestedFramesPage clickNestedFrames(){
        driver.findElement(nestedFramesLink).click();
        return new NestedFramesPage(driver);
    }

    public class NestedFramesPage {

        private WebDriver driver;

        public NestedFramesPage(WebDriver driver) {
            this.driver = driver;
        }

        public String getLeftFrameText() {
            driver.switchTo().frame("frame-top");
            driver.switchTo().frame("frame-left");
            String text = driver.findElement(body).getText();
            driver.switchTo().parentFrame();
            driver.switchTo().parentFrame();
            return text;
        }

        public String getBottomFrameText() {
            driver.switchTo().frame("frame-bottom");
            String text = driver.findElement(body).getText();
            driver.switchTo().parentFrame();
            return text;
        }
    }
}
