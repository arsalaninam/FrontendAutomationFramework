package com.abc.testcase.console;

import com.abc.base.TestBase;
import com.abc.data.dataprovider.ConsolePageData;
import com.abc.page.ConsolePage;
import com.abc.page.LoginPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.abc.constant.Constant.TEST_USER_LANDS_ON_CONSOLE_PAGE;

/**
 * Test Class to perform test cases related to Console Page
 *
 * @author Arsalan Inam
 */
public class ConsoleTest extends TestBase {

    private static final Logger log = LoggerFactory.getLogger(ConsoleTest.class);
    private LoginPage loginPage;

    @BeforeMethod
    public void setUp() {
        initialization();
        loginPage = new LoginPage();
    }

    /******************************************************************************************
     * Test scenario:
     * - When A user logs in successfully
     * - Then he successfully lands on Console Page
     *
     * @param username - A valid username
     * @param password - A valid password
     * @param expectedPageTitle - Title of Console Page
     ******************************************************************************************/

    @Test(dataProvider = "validLoginUsernamePasswordAndPageTitle", dataProviderClass = ConsolePageData.class, priority = 1)
    public void testUserNavigatesToConsolePage(String username, String password, String expectedPageTitle) {
        log.info(TEST_USER_LANDS_ON_CONSOLE_PAGE);
        loginPage.setUsername(username);
        loginPage.setPassword(password);
        ConsolePage consolePage = loginPage.clickLoginButton();
        String actualPageTitle = consolePage.getPageTitle();
        Assert.assertEquals(actualPageTitle, expectedPageTitle);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
