package com.abc.testcase.login;

import com.abc.base.TestBase;
import com.abc.data.dataprovider.LoginPageData;
import com.abc.page.ConsolePage;
import com.abc.page.LoginPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.abc.util.Constant.*;

/**
 * Test Class to perform test cases related to Login Page
 *
 * @author Arsalan Inam
 */

public class LoginTest extends TestBase {

    private static final Logger log = LoggerFactory.getLogger(LoginTest.class);
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
     * @param username - username test data
     * @param password - password test data
     * @param consolePageTitle - Page Title of console page
     ********************************************************************/

    @Test(dataProvider = "validLoginUsernamePasswordWithPageTitle", dataProviderClass = LoginPageData.class)
    public void testSuccessfulLogin(String username, String password, String consolePageTitle) {
        log.info(TEST_SUCCESSFUL_LOGIN);
        loginPage.setUsername(username);
        loginPage.setPassword(password);
        ConsolePage consolePage = loginPage.clickLoginButton();
        Assert.assertEquals(consolePage.getPageTitle(), consolePageTitle);
    }

    /*************************************************************************
     * Test to validate unsuccessful login with
     * - invalid username and invalid password
     * - case sensitive username and password
     *
     * @param username    - username test data
     * @param password    - password test data
     * @param expectedFailMessage - Invalid username or password fail message
     *************************************************************************/

    @Test(dataProvider = "invalidLoginUsernamePasswordWithFailMessage", dataProviderClass = LoginPageData.class)
    public void testUnsuccessfulLogin(String username, String password, String expectedFailMessage) {
        log.info(TEST_UNSUCCESSFUL_LOGIN);
        loginPage.setUsername(username);
        loginPage.setPassword(password);
        loginPage.clickLoginButton();
        String actualFailMessage = loginPage.getLoginFailMessage();
        Assert.assertEquals(actualFailMessage, expectedFailMessage);
    }

    /*******************************************************
     * Test to validate Title of Login Page
     *
     * @param expectedPageTitle - Login Page Title test data
     *******************************************************/

    @Test(dataProvider = "validLoginPageTitle", dataProviderClass = LoginPageData.class)
    public void testLoginPageTitle(String expectedPageTitle) {
        log.info(TEST_LOGIN_PAGE_TITLE);
        String actualPageTitle = loginPage.getPageTitle();
        Assert.assertEquals(actualPageTitle, expectedPageTitle);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
