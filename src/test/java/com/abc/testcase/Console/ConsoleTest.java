package com.abc.testcase.Console;

import com.abc.base.TestBase;
import com.abc.data.dataprovider.ConsolePageData;
import com.abc.page.ConsolePage;
import com.abc.page.LoginPage;
import com.abc.page.TrainerDocumentExplorerPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

/**
 * Test Class to perform test cases related to Console Page
 *
 * @author Arsalan Inam
 */
public class ConsoleTest extends TestBase {

    private LoginPage loginPage;
    private SoftAssert softAssert = new SoftAssert();

    ConsoleTest() {
        super();
    }

    @BeforeMethod
    public void setUp() {
        initialization();
        loginPage = new LoginPage();
    }

    /******************************************************************************************
     * Test scenario:
     * - A user logs in successfully
     * - Then he successfully lands on Console Page
     * - When he clicks on Annotation Icon to navigate to Trainer - Document Explorer Page
     * - Then validate that he is successfully landed on Trainer - Document Explorer Page
     *
     * @param username - A valid username
     * @param password - A valid password
     * @param consolePageTitle - Title of Console Page
     * @param trainerDocumentExplorerPageTitle - Title of Trainer Document Explorer Page
     ******************************************************************************************/
    @Test(dataProvider = "validLoginUsernamePasswordAndPageTitle", dataProviderClass = ConsolePageData.class, priority = 1)
    public void testLoginWithValidCredentials(String username, String password, String consolePageTitle,
                                              String trainerDocumentExplorerPageTitle) {
        loginPage.setUsername(username);
        loginPage.setPassword(password);
        ConsolePage consolePage = loginPage.clickLoginButton();
        softAssert.assertEquals(consolePage.getPageTitle(), consolePageTitle);
        TrainerDocumentExplorerPage trainerDocumentExplorerPage = consolePage.clickOnAnnotateIcon();
        softAssert.assertEquals(trainerDocumentExplorerPage.getPageTitle(), trainerDocumentExplorerPageTitle);
        softAssert.assertAll();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
