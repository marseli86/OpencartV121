package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002LoginTest extends BaseClass {


    @Test(groups = {"Sanity","Master"})
    public void verify_login() {
        logger.info("****STARTING TC002LoginTest****");
        try {
            //HomePage
            HomePage homePage = new HomePage(driver);
            logger.info("Clicking MyAccount");
            homePage.clickMyAccount();
            logger.info("Clicking Login");
            homePage.clickLogin();

            //LoginPage
            LoginPage lp = new LoginPage(driver);
            logger.info("Fill in the email");
            lp.setEmail(p.getProperty("email"));
            logger.info("Fill in the password");
            lp.setPassword(p.getProperty("password"));
            lp.clickLogin();

            //MyAccountPage
            MyAccountPage mp = new MyAccountPage(driver);
            boolean targetPage = mp.isMyAccountPageExists();
            Assert.assertTrue(targetPage);

        } catch (Exception e) {
            Assert.fail();
        }
        logger.info("****FINISHED TC002LoginTest****");
    }
}
