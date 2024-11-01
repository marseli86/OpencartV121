package testCases;


import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;



public class TC001_AccountRegistrationTest extends BaseClass {



    @Test(groups = {"Regression","Master"})
    public void verify_account_registration() {
        logger.info("*****Starting TC001_AccountRegistrationTest****");
        try {


            HomePage homePage = new HomePage(driver);
            homePage.clickMyAccount();
            logger.info("Clicked on the My Account link");
            homePage.clickRegister();
            logger.info("Clicked on the Register link");


            AccountRegistrationPage ac = new AccountRegistrationPage(driver);
            logger.info("Providing Customer Details");
            ac.setFirstName(randomString().toUpperCase());
            ac.setLastName(randomString().toUpperCase());
            ac.setEmail(randomString() + "@gmail.com");
            ac.setTelephone(randomNumber());
            String password = randomAlphaNumeric();
            ac.setPassword(password);
            ac.setConfirmPassword(password);
            ac.setPrivacyPolicy();
            ac.clickContinue();
            logger.info("Validating Expected Message");
            String conf_message = ac.getConfirmationMsg();
            if (conf_message.equals("Your Account Has Been Created!")) {
                Assert.assertTrue(true);
            } else {
                logger.error("Test failed...");
                logger.debug("Debug logs...");
                Assert.assertTrue(false);
            }
            // Assert.assertEquals(conf_message, "Your Account Has Been NOT Created!");
        } catch (Exception e) {

            Assert.fail();
        }
        logger.info("****Test Finished****");
    }


}
