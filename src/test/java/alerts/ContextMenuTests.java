package alerts;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ContextMenuTests extends BaseTests {

    @Test
    public void testContextMenuAlert() {
        var contextMenuPage = homePage.clickContextMenu();
        contextMenuPage.contextMenuClickHotSpot();
        String text = contextMenuPage.alert_GetAlertText();
        contextMenuPage.alert_AcceptAlert();
        assertEquals(text, "You selected a context menu");
    }
}
