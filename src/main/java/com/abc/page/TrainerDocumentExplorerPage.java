package com.abc.page;

import com.abc.base.TestBase;
import com.abc.util.TestUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static com.abc.constant.Constant.LONGEST_PAGE_LOAD_TIMEOUT;
import static com.abc.constant.Constant.LONG_PAGE_LOAD_TIMEOUT;

public class TrainerDocumentExplorerPage extends TestBase {

    //Initializing the Page Elements with Constructor
    public TrainerDocumentExplorerPage() {
        PageFactory.initElements(driver, this);
    }

    /*******************************************************************************
     * Defining Page Factory : Object Repository of Trainer Document Explorer Page
     *******************************************************************************/
    @FindBy(className = "iconPlus")
    private WebElement collectionsAddBtn;

    @FindBy(xpath = "//input[@placeholder='Name']")
    private WebElement newCollectionNameFiled;

    @FindBy(xpath = "//chunk[contains(text(),'Document explorer')]")
    private WebElement trainerDocumentExplorerPageHeading;

    @FindBy(xpath = "//button[contains(text(),'Create')]")
    private WebElement newCollectionCreateBtn;

    @FindBy(xpath = "//input[@placeholder='Search...']")
    private WebElement collectionSearchField;

    @FindBy(xpath = "//button[text()='Upload']")
    private WebElement uploadBtn;

    @FindBy(xpath = "//input[@type='file']")
    private WebElement fileUpload;

    @FindBy(xpath = "//img[@src='platform/omnibus/source/assets/images/check-full-green.svg']")
    private WebElement fileUploadSuccessfulGreenCheck;

    @FindBy(xpath = "//img[@src='platform/omnibus/source/assets/images/problem-full-red.svg']")
    private WebElement fileUploadProblemRedCheck;

    @FindBy(xpath = "//chunk[contains(text(),'failed')]")
    private WebElement fileUploadFailedMessage;

    @FindBy(xpath = "//chunk[contains(text(),'finished uploading')]")
    private WebElement fileUploadFinishedMessageIcon;

    @FindBy(xpath = "//succeeded[contains(text(),'Succeeded')]")
    private WebElement fileUploadFinishedSucceededMessage;

    @FindBy(xpath = "//rejected[contains(text(),'Rejected (because of type)')]")
    private WebElement fileUploadFinishedRejectedMessage;

    @FindAll({
            @FindBy(className = "picnicTableReactiveRows")
    })
    private List<WebElement> listOfUploadedDocuments;

    @FindBy(xpath = "/html/body/application-standalone/omnibus-application-standalone" +
            "/main/echo-application-standalone/platform-document-explorer-page/main/grid" +
            "/collections/echo-table-standalone/main/table/tbody/tr/td[1]/echo-table-table-cell/block")
    private WebElement collectionSpecificRow;

    /******************************************************
     * Methods : Actions of Trainer Document Explorer Page
     ******************************************************/

    public String getPageHeading() {
        TestUtil.waitForVisibilityOfElement(driver, trainerDocumentExplorerPageHeading);
        return trainerDocumentExplorerPageHeading.getText();
    }

    public void clickOnCollectionsBtn() {
        TestUtil.waitForVisibilityOfElement(driver, collectionsAddBtn);
        collectionsAddBtn.click();
    }

    public void createNewCollection(String name) {
        TestUtil.sendKeysToTextBox(driver, newCollectionNameFiled, name);
    }

    public void clickCreateNewCollectionBtn() {
        TestUtil.waitForVisibilityOfElement(driver, newCollectionCreateBtn);
        newCollectionCreateBtn.click();
    }

    public void searchCreatedCollectionFromCollectionTable(String documentNumber) {
        TestUtil.sendKeysToTextBox(driver, collectionSearchField, documentNumber);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void clickOnSearchedDocumentFromCollectionsTable() {
        TestUtil.waitForVisibilityOfElement(driver, collectionSpecificRow);
        collectionSpecificRow.click();
    }

    public void clickOnUploadDocumentsBtn() {
        TestUtil.waitForVisibilityOfElement(driver, uploadBtn);
        uploadBtn.click();
    }

    public boolean checkVisibilityOfUploadButton() {
        TestUtil.waitForVisibilityOfElement(driver, uploadBtn);
        return uploadBtn.isDisplayed();
    }

    public void uploadFile(String path) {
        fileUpload.sendKeys(path);
    }

    public boolean fileUploadSuccessfullyIsDisplayed() {
        TestUtil.waitForVisibilityOfElement(driver, fileUploadSuccessfulGreenCheck, LONG_PAGE_LOAD_TIMEOUT);
        return fileUploadSuccessfulGreenCheck.isDisplayed();
    }

    public boolean fileUploadFailedIsDisplayed() {
        TestUtil.waitForVisibilityOfElement(driver, fileUploadFailedMessage, LONGEST_PAGE_LOAD_TIMEOUT);
        return fileUploadFailedMessage.isDisplayed();
    }

    public boolean fileTypeAcceptedSuccessfullyMessageDisplayed() {
        TestUtil.waitForVisibilityOfElement(driver, fileUploadFinishedMessageIcon);
        Actions action = new Actions(driver);
        action.moveToElement(fileUploadFinishedMessageIcon).build().perform();
        return fileUploadFinishedSucceededMessage.isDisplayed();
    }

    public boolean fileTypeRejectedMessageDisplayed() {
        TestUtil.waitForVisibilityOfElement(driver, fileUploadFinishedMessageIcon);
        Actions action = new Actions(driver);
        action.moveToElement(fileUploadFinishedMessageIcon).build().perform();
        return fileUploadFinishedRejectedMessage.isDisplayed();
    }

    public boolean checkFileUploadProblemIsDisplayed() {
        TestUtil.waitForVisibilityOfElement(driver, fileUploadProblemRedCheck, LONG_PAGE_LOAD_TIMEOUT);
        return fileUploadProblemRedCheck.isDisplayed();
    }
}
