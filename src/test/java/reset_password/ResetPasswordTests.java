package reset_password;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.EmailSentPage;
import pages.ForgotPasswordPage;
import pages.HomePage;

import static org.testng.Assert.assertEquals;

public class ResetPasswordTests extends BaseTests {

    @Test
    public void testResetPassword() {
        ForgotPasswordPage forgotPasswordPage = homePage.clickForgotPassword();
        forgotPasswordPage.enterEmail("TAU@example.com");
        EmailSentPage emailSentPage = forgotPasswordPage.clickButton();
        assertEquals(emailSentPage.confirmationText(), "Your e-mail's been sent!");
    }
}
