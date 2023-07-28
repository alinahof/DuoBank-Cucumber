package Pages;

import io.cucumber.java.zh_cn.假如;
import lombok.Data;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

@Data
public class SummaryPage2 {

    public SummaryPage2(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (xpath = "//a//span[@class='d-block'][.='Summary']")
    private WebElement summarySection;

//    @FindBy (xpath = "//div[@class='PreApprovalDetails']")
//    private WebElement preApproval;

    @FindBy (xpath = "//a[@id='PreApprovalEdit']")
    private WebElement preApprovalEditButton;

    @FindBy (xpath = "//a[@id='PersonalnformationEdit']")
    private WebElement personalDetailsEditButton;

    @FindBy (xpath = "//a[@id='ExpenseEdit']")
    private WebElement expensesEditButton;

    @FindBy (xpath = "//a[@id='EmploymentIncomeEdit']")
    private WebElement employmentAndIncomeEditButton;

    @FindBy (xpath = "//a[@id='OrderCreditEdit']")
    private WebElement orderCreditEditButton;

    @FindBy (xpath = "//a[@id='eConsentEdit']")
    private WebElement eConsentEditButton;

    @FindBy (xpath = "//a[@id='steps-uid-0-t-4']//span[@class='d-block']")
    private WebElement creditReportSection;

    @FindBy (xpath = "//label[@for='creditreport2']")
    private WebElement creditNoButton;

    @FindBy (xpath = "//a[@href='#finish']")
    private WebElement saveButton;







}
