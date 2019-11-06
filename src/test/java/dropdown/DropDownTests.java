package dropdown;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.DropdownPage;

import static org.testng.Assert.*;

public class DropDownTests extends BaseTests {
    @Test
    public void testSelectOption() {
        DropdownPage dropdownPage = homePage.clickDropDown();

        String option = "Option 1";
        dropdownPage.selectFromDropdown(option);
        var selectedOptions = dropdownPage.getSelectedOptions();
        assertEquals(selectedOptions.size(),1, "Incorrect number of selections");
        assertTrue(selectedOptions.contains(option), "Option not selected");
    }

    @Test
    public void testMultiSelect() {
        DropdownPage dropdownPage = homePage.clickDropDown();

        String option1 = "Option 1";
        String option2 = "Option 2";
        dropdownPage.allowMultipleSelection();
        dropdownPage.selectFromDropdown(option1);
        dropdownPage.selectFromDropdown(option2);
        var selectedOptions = dropdownPage.getSelectedOptions();
        assertEquals(selectedOptions.size(),2, "Incorrect number of selections");
        assertTrue(selectedOptions.contains(option1), "Option 1 not selected");
        assertTrue(selectedOptions.contains(option2), "Option 2 not selected");
    }
}
