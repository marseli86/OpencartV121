package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {

    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h2[text()='My Account']") // MyAccount Page heading
    WebElement myAccount;

    @FindBy(xpath = "//div[@class='list-group']//a[text()='Logout']")
    WebElement lnkLogout;

    //method to check if the myaccount page exists
    public boolean isMyAccountPageExists() {
        try {
            return (myAccount.isDisplayed());
        } catch (Exception e) {
            return false;
        }

    }

    public void clickLogout() {
        lnkLogout.click();

    }

}
