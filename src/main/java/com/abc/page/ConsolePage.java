package com.abc.page;

import com.abc.base.TestBase;
import com.abc.util.TestUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConsolePage extends TestBase {

    //Initializing the Page Elements with Constructor
    ConsolePage() {
        PageFactory.initElements(driver, this);
    }

    /************************************************************
     * Defining Page Factory : Object Repository of Console Page
     ************************************************************/

    @FindBy(xpath = "//label[contains(text(),'Data modeler')]")
    private WebElement dataModelerIcon;

    @FindBy(xpath = "//label[contains(text(),'Annotate')]")
    private WebElement annotateIcon;

    @FindBy(xpath = "//label[contains(text(),'Train')]")
    private WebElement trainIcon;

    @FindBy(xpath = "//label[contains(text(),'Model evaluation')]")
    private WebElement modelEvaluationIcon;

    @FindBy(xpath = "//a[@href='/trainer/ui/import-export']")
    private WebElement trainerImportExportIcon;

    @FindBy(xpath = "//label[contains(text(),'Case reviewer')]")
    private WebElement caseReviewerIcon;

    @FindBy(xpath = "//a[@href='https://omniustest.omnius.com/engine/ui/import-export']")
    private WebElement engineImportExportIcon;

    @FindBy(xpath = "//chunk[contains(text(),'Trainer')]")
    private WebElement consolePageHeading;

    /**************************************
     * Methods : Actions of Console Page
     ***************************************/

    public String getPageTitle() {
        TestUtil.waitForVisibilityOfElement(driver, consolePageHeading);
        return driver.getTitle();
    }

    public TrainerDocumentExplorerPage clickOnAnnotateIcon() {
        TestUtil.waitForVisibilityOfElement(driver, annotateIcon);
        annotateIcon.click();
        return new TrainerDocumentExplorerPage();
    }
}
