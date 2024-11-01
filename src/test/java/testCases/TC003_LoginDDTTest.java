package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC003_LoginDDTTest extends BaseClass {

    @Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class,groups = "datadriven")
    //getting data provider from a different class
    public void verify_loginDDT(String email, String password, String exp) {
        logger.info("****Starting TC003_LoginDDTTest****");
        //HomePage
        try {
            HomePage homePage = new HomePage(driver);
            logger.info("Clicking MyAccount");
            homePage.clickMyAccount();
            logger.info("Clicking Login");
            homePage.clickLogin();

            //LoginPage
            LoginPage lp = new LoginPage(driver);
            logger.info("Fill in the email");
            lp.setEmail(email);
            logger.info("Fill in the password");
            lp.setPassword(password);
            lp.clickLogin();

            //MyAccountPage
            MyAccountPage mp = new MyAccountPage(driver);
            boolean targetPage = mp.isMyAccountPageExists();
            //validations
            // Data is valid  - logins success - test pass - logout
            //                - logins failed - test fail
            //Data is invalid - login success - test failed - logout
            //                - login failed - test success
            // first part, data is valid
            if (exp.equalsIgnoreCase("Valid")) {
                if (targetPage == true) {
                    Assert.assertTrue(true);
                    mp.clickLogout();
                } else {
                    Assert.assertTrue(false);
                }
            }
            // second part, data is invalid
            if (exp.equalsIgnoreCase("Invalid")) {
                if (targetPage == true) {

                    mp.clickLogout();
                    Assert.assertTrue(false);
                } else {
                    Assert.assertTrue(true);
                }
            }
        }catch (Exception e){
            Assert.fail();
        }
        logger.info("****FINISHED TC003_LoginDDTTest****");
    }
}
