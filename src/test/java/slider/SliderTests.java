package slider;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class SliderTests extends BaseTests {

    @Test
    public void testSliderRight() {
        var sliderPage = homePage.clickHorizontalSlider();
        sliderPage.moveSliderRight(8);
        assertEquals(sliderPage.getSliderValue(), "4");
    }
}
