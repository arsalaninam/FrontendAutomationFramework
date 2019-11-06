package com.abc.page;

import com.abc.base.TestBase;
import com.abc.util.TestUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends TestBase {

    //Initializing the Page Elements with Constructor
    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    /**********************************************************
     * Defining Page Factory : Object Repository of Login Page
     **********************************************************/

    @FindBy(id = "username")
    private WebElement usernameField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "kc-login")
    private WebElement loginBtn;

    @FindBy(id = "kc-page-title")
    private WebElement loginPageTitle;

    @FindBy(className = "kc-feedback-text")
    private WebElement loginFailMessage;

    /***********************************
     * Methods : Actions of Login Page
     ***********************************/

    public void setUsername(String username) {
        TestUtil.sendKeysToTextBox(driver,usernameField,username);
    }

    public void setPassword(String password) {
        TestUtil.sendKeysToTextBox(driver,passwordField,password);
    }

    public ConsolePage clickLoginButton(){
        TestUtil.waitForVisibilityOfElement(driver, loginBtn);
        loginBtn.click();
        return new ConsolePage();
    }

    public String getLoginFailMessage() {
        TestUtil.waitForVisibilityOfElement(driver, loginFailMessage);
        return loginFailMessage.getText();
    }
}
