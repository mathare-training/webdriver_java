package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HorizontalSliderPage {

    private WebDriver driver;
    private By slider = By.tagName("input");
    private By sliderValue = By.id("range");

    public HorizontalSliderPage(WebDriver driver) {
        this.driver = driver;
    }

    public void moveSliderRight(int num) {
        WebElement sliderElement = driver.findElement(slider);
        for (int i = 0; i < num; i++) {
            sliderElement.sendKeys(Keys.ARROW_RIGHT);
        }
    }

    public String getSliderValue() {
        return driver.findElement(sliderValue).getText();
    }
}
