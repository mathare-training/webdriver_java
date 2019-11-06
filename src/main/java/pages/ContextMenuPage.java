package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ContextMenuPage {

    private WebDriver driver;
    private By hotSpot = By.id("hot-spot");

    public ContextMenuPage(WebDriver driver) {
        this.driver = driver;
    }

    public void contextMenuClickHotSpot() {
       WebElement element = driver.findElement(hotSpot);

       Actions actions = new Actions(driver);
       actions.contextClick(element).perform();
    }

    public String alert_GetAlertText() {
        return driver.switchTo().alert().getText();
    }

    public void alert_AcceptAlert() {
        driver.switchTo().alert().accept();
    }

}
