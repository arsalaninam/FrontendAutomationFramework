package com.abc.testcase.trainerDocumentExplorer;

import com.abc.base.TestBase;
import com.abc.data.dataprovider.TrainerDocumentExplorerData;
import com.abc.page.ConsolePage;
import com.abc.page.LoginPage;
import com.abc.page.TrainerDocumentExplorerPage;
import com.abc.util.ObjectFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.Random;

import static com.abc.constant.Constant.*;

/**
 * Test Class to perform test cases related to Trainer Document Explorer Page
 *
 * @author Arsalan Inam
 */

public class TrainerDocumentExplorerTest extends TestBase {

    private static final Logger log = LoggerFactory.getLogger(TrainerDocumentExplorerTest.class);
    private LoginPage loginPage;
    private SoftAssert softAssert = ObjectFactory.getSoftAssert();

    /*************************************
     * generates 5 digit random value
     * @return - five digit integer value
     *************************************/

    private int generateNumber() {
        Random r = new Random(System.currentTimeMillis());
        return 10000 + r.nextInt(20000);
    }

    /********************
     * Upload file paths
     ********************/

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
     * - Then validate User is navigated to Console Page successfully.
     * - When User click on Annotation icon on Console Page.
     * - Then validate User is navigated to Trainer Document Explorer Page successfully.
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
     * - Then validate User is navigated to Console Page successfully.
     * - When User click on Annotation icon on Console Page.
     * - Then validate User is navigated to Trainer Document Explorer Page successfully.
     * - When User adds a new collection and adds a new document of pdf Type.
     * - Then validate upload document type is accepted successfully
     * - And validate that new document is added successfully.
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
        String collectionName = TEST_PREFIX + generateNumber();
        log.info("Collection Name: " + collectionName);

        loginPage.setUsername(username);
        loginPage.setPassword(password);
        ConsolePage consolePage = loginPage.clickLoginButton();
        String actualConsolePageHeading = consolePage.getPageHeading();
        softAssert.assertEquals(actualConsolePageHeading, expectedConsoleHeading);

        TrainerDocumentExplorerPage trainerDocumentExplorerPage = consolePage.clickOnAnnotateIcon();
        String actualDocumentExplorerPageHeading = trainerDocumentExplorerPage.getPageHeading();
        softAssert.assertEquals(actualDocumentExplorerPageHeading, expectedDocumentExplorerHeading);

        createCollectionAndUploadDocumentS(trainerDocumentExplorerPage, pdfFilePath, collectionName);
        boolean fileTypeAcceptedSuccessfully = trainerDocumentExplorerPage.fileTypeAcceptedSuccessfullyMessageDisplayed();
        softAssert.assertEquals(fileTypeAcceptedSuccessfully, true);

        boolean fileUploadSuccessMessage = trainerDocumentExplorerPage.fileUploadSuccessfullyIsDisplayed();
        softAssert.assertEquals(fileUploadSuccessMessage, true);
        softAssert.assertAll();
    }

    /***********************************************************************************
     * Test scenario:
     * - When User enters valid credentials to Login to application successfully.
     * - Then validate User is navigated to Console Page successfully.
     * - When User click on Annotation icon on Console Page.
     * - Then validate User is navigated to Trainer Document Explorer Page successfully.
     * - When User adds a new collection and adds a new document of jpg Type.
     * - Then validate upload document type is accepted successfully
     * - And validate that new document is not added successfully.
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
        String collectionName = TEST_PREFIX + generateNumber();
        log.info("Collection Name: " + collectionName);

        loginPage.setUsername(username);
        loginPage.setPassword(password);
        ConsolePage consolePage = loginPage.clickLoginButton();
        String actualConsolePageHeading = consolePage.getPageHeading();
        softAssert.assertEquals(actualConsolePageHeading, expectedConsoleHeading);

        TrainerDocumentExplorerPage trainerDocumentExplorerPage = consolePage.clickOnAnnotateIcon();
        String actualDocumentExplorerPageHeading = trainerDocumentExplorerPage.getPageHeading();
        softAssert.assertEquals(actualDocumentExplorerPageHeading, expectedDocumentExplorerHeading);

        createCollectionAndUploadDocumentS(trainerDocumentExplorerPage, jpgFilePath, collectionName);
        boolean fileTypeAcceptedSuccessfully = trainerDocumentExplorerPage.fileTypeAcceptedSuccessfullyMessageDisplayed();
        softAssert.assertEquals(fileTypeAcceptedSuccessfully, true);

        boolean fileUploadFailedMessage = trainerDocumentExplorerPage.fileUploadFailedIsDisplayed();
        softAssert.assertEquals(fileUploadFailedMessage, true);
        softAssert.assertAll();
    }

    /***********************************************************************************
     * Test scenario:
     * - When User enters valid credentials to Login to application successfully.
     * - Then validate User is navigated to Console Page successfully.
     * - When User click on Annotation icon on Console Page.
     * - Then validate User is navigated to Trainer Document Explorer Page successfully.
     * - When User adds a new collection and adds a new document of png Type.
     * - Then validate upload document type is accepted successfully
     * - And validate that new document is not added successfully.
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
        String collectionName = TEST_PREFIX + generateNumber();
        log.info("Collection Name: " + collectionName);

        loginPage.setUsername(username);
        loginPage.setPassword(password);
        ConsolePage consolePage = loginPage.clickLoginButton();
        String actualConsolePageHeading = consolePage.getPageHeading();
        softAssert.assertEquals(actualConsolePageHeading, expectedConsoleHeading);

        TrainerDocumentExplorerPage trainerDocumentExplorerPage = consolePage.clickOnAnnotateIcon();
        String actualDocumentExplorerPageHeading = trainerDocumentExplorerPage.getPageHeading();
        softAssert.assertEquals(actualDocumentExplorerPageHeading, expectedDocumentExplorerHeading);

        createCollectionAndUploadDocumentS(trainerDocumentExplorerPage, pngFilePath, collectionName);
        boolean fileTypeAcceptedSuccessfully = trainerDocumentExplorerPage.fileTypeAcceptedSuccessfullyMessageDisplayed();
        softAssert.assertEquals(fileTypeAcceptedSuccessfully, true);

        boolean fileUploadFailedMessage = trainerDocumentExplorerPage.fileUploadFailedIsDisplayed();
        softAssert.assertEquals(fileUploadFailedMessage, true);
        softAssert.assertAll();
        softAssert.assertAll();
    }

    /***********************************************************************************
     * Test scenario:
     * - When User enters valid credentials to Login to application successfully.
     * - Then validate User is navigated to Console Page successfully.
     * - When User click on Annotation icon on Console Page.
     * - Then validate User is navigated to Trainer Document Explorer Page successfully.
     * - When User adds a new collection and adds a new document of tiff Type.
     * - Then validate upload document type is accepted successfully
     * - And validate that new document is not added successfully.
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
        String collectionName = TEST_PREFIX + generateNumber();
        log.info("Collection Name: " + collectionName);

        loginPage.setUsername(username);
        loginPage.setPassword(password);
        ConsolePage consolePage = loginPage.clickLoginButton();
        String actualConsolePageHeading = consolePage.getPageHeading();
        softAssert.assertEquals(actualConsolePageHeading, expectedConsoleHeading);

        TrainerDocumentExplorerPage trainerDocumentExplorerPage = consolePage.clickOnAnnotateIcon();
        String actualDocumentExplorerPageHeading = trainerDocumentExplorerPage.getPageHeading();
        softAssert.assertEquals(actualDocumentExplorerPageHeading, expectedDocumentExplorerHeading);

        createCollectionAndUploadDocumentS(trainerDocumentExplorerPage, tiffFilePath, collectionName);
        boolean fileTypeAcceptedSuccessfully = trainerDocumentExplorerPage.fileTypeAcceptedSuccessfullyMessageDisplayed();
        softAssert.assertEquals(fileTypeAcceptedSuccessfully, true);

        boolean fileUploadFailedMessage = trainerDocumentExplorerPage.fileUploadFailedIsDisplayed();
        softAssert.assertEquals(fileUploadFailedMessage, true);
        softAssert.assertAll();
    }

    /***********************************************************************************
     * Test scenario:
     * - When User enters valid credentials to Login to application successfully.
     * - Then validate User is navigated to Console Page successfully.
     * - When User click on Annotation icon on Console Page.
     * - Then validate User is navigated to Trainer Document Explorer Page successfully.
     * - When User adds a new collection and adds a new document of txt Type.
     * - Then validate message "Rejected (because of type)" is displayed.
     *
     * @param username - A valid Username
     * @param password - A valid Password
     * @param expectedConsoleHeading - Console Page Heading
     * @param expectedDocumentExplorerHeading - Trainer Document Explorer Page Heading
     ***********************************************************************************/

    @Test(dataProvider = "validUsernamePasswordAndPageHeadings",
            dataProviderClass = TrainerDocumentExplorerData.class,
            dependsOnMethods = "testUserNavigatesToTrainerDocumentExplorerPage")
    public void testUploadTxtFileType(String username, String password,
                                      String expectedConsoleHeading,
                                      String expectedDocumentExplorerHeading) {
        String collectionName = TEST_PREFIX + generateNumber();
        log.info("Collection Name: " + collectionName);

        loginPage.setUsername(username);
        loginPage.setPassword(password);
        ConsolePage consolePage = loginPage.clickLoginButton();
        String actualConsolePageHeading = consolePage.getPageHeading();
        softAssert.assertEquals(actualConsolePageHeading, expectedConsoleHeading);

        TrainerDocumentExplorerPage trainerDocumentExplorerPage = consolePage.clickOnAnnotateIcon();
        String actualDocumentExplorerPageHeading = trainerDocumentExplorerPage.getPageHeading();
        softAssert.assertEquals(actualDocumentExplorerPageHeading, expectedDocumentExplorerHeading);

        createCollectionAndUploadDocumentS(trainerDocumentExplorerPage, txtFilePath, collectionName);
        boolean fileTypeRejectedMessageDisplayed = trainerDocumentExplorerPage.fileTypeRejectedMessageDisplayed();
        softAssert.assertEquals(fileTypeRejectedMessageDisplayed, true);
        softAssert.assertAll();
    }

    /**********************************************************************
     * This method creates a new collection and
     * Uploads a valid new document in the collection.
     *
     * @param trainerDocumentExplorerPage - Trainer Document Page instance
     * @param filePath - Absolute file path to upload file
     * @param collectionName - Name of new collection
     **********************************************************************/

    private void createCollectionAndUploadDocumentS(TrainerDocumentExplorerPage trainerDocumentExplorerPage,
                                                    String filePath,
                                                    String collectionName) {
        trainerDocumentExplorerPage.clickOnCollectionsBtn();
        trainerDocumentExplorerPage.createNewCollection(collectionName);
        trainerDocumentExplorerPage.clickCreateNewCollectionBtn();
        trainerDocumentExplorerPage.searchCreatedCollectionFromCollectionTable(collectionName);
        trainerDocumentExplorerPage.clickOnSearchedDocumentFromCollectionsTable();
        trainerDocumentExplorerPage.checkVisibilityOfUploadButton();
        trainerDocumentExplorerPage.uploadFile(filePath);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
