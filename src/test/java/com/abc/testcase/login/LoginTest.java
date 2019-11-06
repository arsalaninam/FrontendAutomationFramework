package com.abc.testcase.login;

import com.abc.base.TestBase;
import com.abc.data.dataprovider.LoginPageData;
import com.abc.page.ConsolePage;
import com.abc.page.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Test Class to perform test cases related to Login Page
 *
 * @author Arsalan Inam
 */

public class LoginTest extends TestBase {

    private LoginPage loginPage;

    LoginTest() {
        super();
    }

    @BeforeMethod
    public void setUp() {
        initialization();
        loginPage = new LoginPage();
    }

    /*********************************************************************
     * Test to validate successful login with valid username and password
     *
     * @param username - A valid username
     * @param password - A valid password
     * @param consolePageTitle - Page Title of console page
     ********************************************************************/
    @Test(dataProvider = "validLoginUsernamePasswordWithPageTitle", dataProviderClass = LoginPageData.class, priority = 1)
    public void testLoginWithValidCredentials(String username, String password, String consolePageTitle) {
        loginPage.setUsername(username);
        loginPage.setPassword(password);
        ConsolePage consolePage = loginPage.clickLoginButton();
        Assert.assertEquals(consolePage.getPageTitle(), consolePageTitle);
    }

    /**************************************************************************
     * Test to validate unsuccessful login with invalid username and password
     *
     * @param username    - An invalid username
     * @param password    - An invalid password
     * @param failMessage - Invalid username or password fail message
     *************************************************************************/

    @Test(dataProvider = "invalidLoginUsernamePasswordWithFailMessage", dataProviderClass = LoginPageData.class, priority = 1)
    public void testLoginWithInValidCredentials(String username, String password, String failMessage) {
        loginPage.setUsername(username);
        loginPage.setPassword(password);
        loginPage.clickLoginButton();
        Assert.assertEquals(loginPage.getLoginFailMessage(), failMessage);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
