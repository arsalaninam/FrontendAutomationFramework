package com.abc.testcase.trainerDocumentExplorer;

import com.abc.base.TestBase;
import com.abc.data.dataprovider.TrainerDocumentExplorerData;
import com.abc.page.ConsolePage;
import com.abc.page.LoginPage;
import com.abc.page.TrainerDocumentExplorerPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.Random;

import static com.abc.util.Constant.*;

/**
 * Test Class to perform test cases related to Trainer Document Explorer Page
 *
 * @author Arsalan Inam
 */

public class TrainerDocumentExplorerTest extends TestBase {

    private LoginPage loginPage;
    private SoftAssert softAssert = new SoftAssert();

    TrainerDocumentExplorerTest() {
        super();
    }

    /*************************************
     * generates 5 digit random value
     * @return - five digit integer value
     *************************************/

    private int gen() {
        Random r = new Random(System.currentTimeMillis());
        return 10000 + r.nextInt(20000);
    }

    /*******************
     * Upload file paths
     *******************/

    private String pdfFilePath = PDF_FILE_PATH;
    private String pngFilePath = PNG_FILE_PATH;
    private String jpgFilePath = JPG_FILE_PATH;
    private String tiffFilePath = TIFF_FILE_PATH;
    private String txtFilePath = TXT_FILE_PATH;

    @BeforeMethod
    public void setUp() {
        initialization();
        loginPage = new LoginPage();
    }

    /***********************************************************************************
     * Test scenario:
     * - When User enters valid credentials to Login to application successfully.
     * - Then User is navigated to Console Page successfully.
     * - When User click on Annotation icon on Console Page.
     * - Then User is navigated to Trainer Document Explorer Page successfully.
     *
     * @param username - A valid Username
     * @param password - A valid Password
     * @param expectedConsoleHeading - Console Page Heading
     * @param expectedDocumentExplorerHeading - Trainer Document Explorer Page Heading
     ***********************************************************************************/

    @Test(dataProvider = "validUsernamePasswordAndPageHeadings",
            dataProviderClass = TrainerDocumentExplorerData.class)
    public void testUserNavigatesToTrainerDocumentExplorerPage(String username, String password,
                                                               String expectedConsoleHeading,
                                                               String expectedDocumentExplorerHeading) {
        loginPage.setUsername(username);
        loginPage.setPassword(password);
        ConsolePage consolePage = loginPage.clickLoginButton();
        String actualConsolePageHeading = consolePage.getPageHeading();
        softAssert.assertEquals(actualConsolePageHeading, expectedConsoleHeading);

        TrainerDocumentExplorerPage trainerDocumentExplorerPage = consolePage.clickOnAnnotateIcon();
        String actualDocumentExplorerPageHeading = trainerDocumentExplorerPage.getPageHeading();
        softAssert.assertEquals(actualDocumentExplorerPageHeading, expectedDocumentExplorerHeading);

        softAssert.assertAll();
    }


    /***********************************************************************************
     * Test scenario:
     * - When User enters valid credentials to Login to application successfully.
     * - Then User is navigated to Console Page successfully.
     * - When User click on Annotation icon on Console Page.
     * - Then User is navigated to Trainer Document Explorer Page successfully.
     * - When User adds a new collection and adds a new document of pdf Type.
     * - Then validate that new document is added successfully.
     *
     * @param username - A valid Username
     * @param password - A valid Password
     * @param expectedConsoleHeading - Console Page Heading
     * @param expectedDocumentExplorerHeading - Trainer Document Explorer Page Heading
     ***********************************************************************************/

    @Test(dataProvider = "validUsernamePasswordAndPageHeadings",
            dataProviderClass = TrainerDocumentExplorerData.class,
            dependsOnMethods = "testUserNavigatesToTrainerDocumentExplorerPage")
    public void testUploadPdfFileType(String username, String password,
                                      String expectedConsoleHeading,
                                      String expectedDocumentExplorerHeading) {
        int number = gen();
        String collectionName = TEST_PREFIX + number;
        boolean scenarioType = true;

        loginPage.setUsername(username);
        loginPage.setPassword(password);
        ConsolePage consolePage = loginPage.clickLoginButton();
        String actualConsolePageHeading = consolePage.getPageHeading();
        softAssert.assertEquals(actualConsolePageHeading, expectedConsoleHeading);

        TrainerDocumentExplorerPage trainerDocumentExplorerPage = consolePage.clickOnAnnotateIcon();
        String actualDocumentExplorerPageHeading = trainerDocumentExplorerPage.getPageHeading();
        softAssert.assertEquals(actualDocumentExplorerPageHeading, expectedDocumentExplorerHeading);

        boolean fileUploadSuccessMessage = createCollectionAndUploadDocumentS(trainerDocumentExplorerPage,
                pdfFilePath, collectionName, scenarioType);

        softAssert.assertEquals(fileUploadSuccessMessage, true);
        softAssert.assertAll();
    }

    /***********************************************************************************
     * Test scenario:
     * - When User enters valid credentials to Login to application successfully.
     * - Then User is navigated to Console Page successfully.
     * - When User click on Annotation icon on Console Page.
     * - Then User is navigated to Trainer Document Explorer Page successfully.
     * - When User adds a new collection and adds a new document of jpg Type.
     * - Then validate that new document is not added successfully.
     *
     * @param username - A valid Username
     * @param password - A valid Password
     * @param expectedConsoleHeading - Console Page Heading
     * @param expectedDocumentExplorerHeading - Trainer Document Explorer Page Heading
     ***********************************************************************************/

    @Test(dataProvider = "validUsernamePasswordAndPageHeadings",
            dataProviderClass = TrainerDocumentExplorerData.class,
            dependsOnMethods = "testUserNavigatesToTrainerDocumentExplorerPage")
    public void testUploadJpgFileType(String username, String password,
                                      String expectedConsoleHeading,
                                      String expectedDocumentExplorerHeading) {
        int number = gen();
        String collectionName = TEST_PREFIX + number;
        boolean scenarioType = false;

        loginPage.setUsername(username);
        loginPage.setPassword(password);
        ConsolePage consolePage = loginPage.clickLoginButton();
        String actualConsolePageHeading = consolePage.getPageHeading();
        softAssert.assertEquals(actualConsolePageHeading, expectedConsoleHeading);

        TrainerDocumentExplorerPage trainerDocumentExplorerPage = consolePage.clickOnAnnotateIcon();
        String actualDocumentExplorerPageHeading = trainerDocumentExplorerPage.getPageHeading();
        softAssert.assertEquals(actualDocumentExplorerPageHeading, expectedDocumentExplorerHeading);

        boolean fileUploadFailedMessage = createCollectionAndUploadDocumentS(trainerDocumentExplorerPage,
                jpgFilePath, collectionName, scenarioType);

        softAssert.assertEquals(fileUploadFailedMessage, true);
        softAssert.assertAll();
    }

    /***********************************************************************************
     * Test scenario:
     * - When User enters valid credentials to Login to application successfully.
     * - Then User is navigated to Console Page successfully.
     * - When User click on Annotation icon on Console Page.
     * - Then User is navigated to Trainer Document Explorer Page successfully.
     * - When User adds a new collection and adds a new document of png Type.
     * - Then validate that new document is added successfully.
     *
     * @param username - A valid Username
     * @param password - A valid Password
     * @param expectedConsoleHeading - Console Page Heading
     * @param expectedDocumentExplorerHeading - Trainer Document Explorer Page Heading
     ***********************************************************************************/

    @Test(dataProvider = "validUsernamePasswordAndPageHeadings",
            dataProviderClass = TrainerDocumentExplorerData.class,
            dependsOnMethods = "testUserNavigatesToTrainerDocumentExplorerPage")
    public void testUploadPngFileType(String username, String password,
                                      String expectedConsoleHeading,
                                      String expectedDocumentExplorerHeading) {
        int number = gen();
        String collectionName = TEST_PREFIX + number;
        boolean scenarioType = false;

        loginPage.setUsername(username);
        loginPage.setPassword(password);
        ConsolePage consolePage = loginPage.clickLoginButton();
        String actualConsolePageHeading = consolePage.getPageHeading();
        softAssert.assertEquals(actualConsolePageHeading, expectedConsoleHeading);

        TrainerDocumentExplorerPage trainerDocumentExplorerPage = consolePage.clickOnAnnotateIcon();
        String actualDocumentExplorerPageHeading = trainerDocumentExplorerPage.getPageHeading();
        softAssert.assertEquals(actualDocumentExplorerPageHeading, expectedDocumentExplorerHeading);

        boolean fileUploadFailedMessage = createCollectionAndUploadDocumentS(trainerDocumentExplorerPage,
                pngFilePath, collectionName, scenarioType);

        softAssert.assertEquals(fileUploadFailedMessage, true);
        softAssert.assertAll();
    }

    /***********************************************************************************
     * Test scenario:
     * - When User enters valid credentials to Login to application successfully.
     * - Then User is navigated to Console Page successfully.
     * - When User click on Annotation icon on Console Page.
     * - Then User is navigated to Trainer Document Explorer Page successfully.
     * - When User adds a new collection and adds a new document of tiff Type.
     * - Then validate that new document is added successfully.
     *
     * @param username - A valid Username
     * @param password - A valid Password
     * @param expectedConsoleHeading - Console Page Heading
     * @param expectedDocumentExplorerHeading - Trainer Document Explorer Page Heading
     ***********************************************************************************/

    @Test(dataProvider = "validUsernamePasswordAndPageHeadings",
            dataProviderClass = TrainerDocumentExplorerData.class,
            dependsOnMethods = "testUserNavigatesToTrainerDocumentExplorerPage")
    public void testUploadTiffFileType(String username, String password,
                                       String expectedConsoleHeading,
                                       String expectedDocumentExplorerHeading) {
        int number = gen();
        String collectionName = TEST_PREFIX + number;
        boolean scenarioType = false;

        loginPage.setUsername(username);
        loginPage.setPassword(password);
        ConsolePage consolePage = loginPage.clickLoginButton();
        String actualConsolePageHeading = consolePage.getPageHeading();
        softAssert.assertEquals(actualConsolePageHeading, expectedConsoleHeading);

        TrainerDocumentExplorerPage trainerDocumentExplorerPage = consolePage.clickOnAnnotateIcon();
        String actualDocumentExplorerPageHeading = trainerDocumentExplorerPage.getPageHeading();
        softAssert.assertEquals(actualDocumentExplorerPageHeading, expectedDocumentExplorerHeading);

        boolean fileUploadFailedMessage = createCollectionAndUploadDocumentS(trainerDocumentExplorerPage,
                tiffFilePath, collectionName, scenarioType);

        softAssert.assertEquals(fileUploadFailedMessage, true);
        softAssert.assertAll();
    }

    /***
     * This method with create a new collection and Upload a new document in the collection.
     *
     * @param trainerDocumentExplorerPage - Trainer Document Page instance
     * @param filePath - Absolute file path to upload file
     * @param collectionName - Name of new collection
     * @param scenarioType - Type of Scenario to return successful or failed image check
     * @return - Returns success image check if scenario Type is true
     * @return - Or Returns faik image check if scenario Type is false
     */

    private boolean createCollectionAndUploadDocumentS(TrainerDocumentExplorerPage trainerDocumentExplorerPage,
                                                       String filePath,
                                                       String collectionName,
                                                       boolean scenarioType) {
        trainerDocumentExplorerPage.clickOnCollectionsBtn();
        trainerDocumentExplorerPage.createNewCollection(collectionName);
        trainerDocumentExplorerPage.clickCreateNewCollectionBtn();
        trainerDocumentExplorerPage.searchCreatedCollectionFromCollectionTable(collectionName);
        trainerDocumentExplorerPage.clickOnSearchedDocumentFromCollectionsTable();
        trainerDocumentExplorerPage.checkVisibilityOfUploadButton();
        trainerDocumentExplorerPage.uploadFile(filePath);
        if (scenarioType) {
            return trainerDocumentExplorerPage.checkFileUploadSuccessfullyIsDisplayed();
        }
        return trainerDocumentExplorerPage.checkFileUploadFailedIsDisplayed();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
