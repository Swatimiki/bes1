package pages;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import common.BasePage;
import common.WaitUtils;
import utilities.CommonUtils;

public class PSLCreatedfromONCOSTPage extends BasePage {

	public PSLCreatedfromONCOSTPage(WebDriver driver) {
		super(driver);

	}

		WaitUtils waits = new WaitUtils(driver);

		public static final By ESTIMATES = By.xpath("//div[@aria-label='Estimates']//span[@class='dx-button-text']");
		public static final By SEARCH = By.xpath("//input[@placeholder='Search']");
		public static final By ManageRevisions = By.xpath("//span[normalize-space()='Manage Revisions']");
		public static final By AddRevision = By.xpath("//span[normalize-space()='Add Revision']");
		public static final By SUBMIT = By.xpath("//span[normalize-space()='Submit']");
		public static final By CHEVRON = By.xpath("//i[@class='fa-solid fa-chevron-up']");
		public static final By NewRevisions = By.xpath("//span[normalize-space()='Estimate Number']");
//	public static final By NEWREVISION = By.xpath("//tr[contains(@class,'dx-data-row')]//td[text()='Automation_Project2-CT1']");
		public static final By allrows = By.xpath("//tr[contains(@class,'dx-data-row')]");
		public static final By SECTION = By.xpath("//label[@title='Sewerage Non Infrastructure']");
//	public static final By CHEVRON = By.xpath("//td[@title='Meenal - Markup Testing - Carbon UAT']");
//	public static final By SECTION = By.xpath("//label[@title='Sewerage Non Infrastructure']");
//	public static final By EXPANDALL = By.xpath("//div[@aria-label='Expand All']/div");

		public static final By Collapse = By.xpath("//button[@aria-label='Collapse']");
		public static final By PSLTAB = By.xpath("//span[normalize-space()='Project-Specific Library']");
		public static final By ViewPSLoption = By.xpath("//span[normalize-space()='View Project-Specific Library']");
		public static final By THREEDOTS = By.xpath("//div[@id='section-context-menu-button']");
		public static final By ONCOSTS = By.xpath("//span[@title='On Costs']");
		public static final By ONCOSTSSearch = By.xpath("//input[@aria-label='Search in the tree list']");
		public static final By HVORESULT = By.xpath("//table[contains(@class,'dx-treelist-table')]//tr[@role='row'][7]");
		public static final By EDITBUTN = By.xpath(("(//*[@id='gridContainer']//span[@title='Edit']/button)[3]"));
		public static final By Scrollverical = By.xpath("//div[contains(@class,'dx-popup-content')]//div[contains(@class,'dx-scrollable-scrollbar') and contains(@class,'dx-scrollbar-vertical')]");
		public static final By PAS2080 = By.xpath("//div[@role='radio']//div[contains(@class,'dx-accordion-item-title-caption') and normalize-space()='PAS2080 A1-A5']");
		public static final By RADIOBUTTON = By.xpath("//div[@role='radio'][.//div[contains(@class,'dx-accordion-item-title-caption') and normalize-space()='PAS2080 A1-A5']]//div[contains(@class,'dx-radio-value-container')]");
		public static final By SELECTFILE = By.xpath("//span[contains(text(),'Select a file')]");
		public static final By PdfUpload = By.xpath("//input[@type='file' and @class='dx-fileuploader-input']");
		public static final By fileUpload = By.xpath("//input[@type='file' and @name='files[]']");
		public static final By EPDCODE = By.xpath("//span[contains(text(),'EPD Code')]/preceding::input[1]");
		public static final By EPDDESCRIPTION = By.xpath("//span[contains(text(),'EPD Description')]/preceding::input[1]");
		public static final By IssueDate = By.xpath("//span[contains(text(),'Issue Date')]/preceding::input[1]/following::div[@role='button'][1]");
		public static final By issueDateValue = By.xpath("//td[@data-value='2026/06/20']");

		//	public static final By expiryDate = By.xpath("//span[contains(text(),'Expiry Date')]/preceding::input[1]/following::div[@role='button'][1]");
		public static final By expiryDate = By.xpath("//span[contains(text(),'Expiry Date')]/preceding::input[1]/following::div[@role='button'][1]");
		public static final By expiryDateValue = By.xpath("//td[@data-value='2026/06/25']");
		public static final By expandRadio = By.xpath("(//div[@role='radiogroup']//div[@role='radio']/div)[1]/following::div[@class='dx-accordion-wrapper'][1]");
		public static final By a1A3Factor = By.xpath("//input[@id='carbA1A3Factor']");
		public static final By a4Factor = By.xpath("//input[@id='carbA4Factor']");
		public static final By a5_1Factor = By.xpath("//input[@id='carbA51Factor']");
		public static final By a5_2Factor = By.xpath("//input[@id='carbA52Factor']");
		public static final By a5_3Factor = By.xpath("//span[contains(text(),'A5.3 KgCO2e/unit')]/preceding::input[contains(@class,'dx-texteditor-input')][1]");
		public static final By a5_4Factor = By.xpath("//input[@id='carbA54Factor']");
		public static final By applyButton = By.xpath("//div[@aria-label='Apply']");
		public static final By container = By.xpath("(//div[@class='dx-scrollable-wrapper']//div[@role='treegrid'])[1]");
		public static final By CARBON_OVERRIDE_BOX = By.xpath("//input[@placeholder='Select carbon override notes...']");
		public static final By CARBON_OVERRIDE_LIST_ITEM = By.xpath("//div[contains(@class,'dx-list-item')][normalize-space()='Manual Input']");
		public static final By CARBON_OVERRIDE_SUBMIT = By.xpath("//div[@role='button' and @aria-label='Submit']");
		public CommonUtils commonUtils = new CommonUtils(driver);

		public void psloncost() throws InterruptedException {

			try {
				waits.waitForVisible(ESTIMATES);
				System.out.println("I am on Estimates page");
				click(ESTIMATES);
				System.out.println("Clicked on Estimates");
				Thread.sleep(2000);
				waits.waitForVisible(SEARCH);
				click(SEARCH);
				find(SEARCH).sendKeys("101808.01");
				System.err.println("Entered estimates");
				click(SEARCH);
				WebElement PROJECTNO = driver.findElement(By.xpath("//tr[contains(@class,'dx-data-row')]//td[@aria-colindex='3']//span[text()='101808.01']"));
				waits.waitForVisible(PROJECTNO);
				Actions actions1 = new Actions(driver);
				actions1.contextClick(PROJECTNO).perform();
				click(ManageRevisions);
//			click(AddRevision);
//			click(SUBMIT);
				click(CHEVRON);
				Thread.sleep(2000);
				selectProject();
//			Thread.sleep(2000);
//			click(description);
//			Thread.sleep(4000);
//		click(Collapse);
				waits.waitForVisible(THREEDOTS);
				click(THREEDOTS);
				waits.waitForVisible(ONCOSTS);
				click(ONCOSTS);
				Thread.sleep(5000);
				click(ONCOSTSSearch);
				Thread.sleep(5000);
				find(ONCOSTSSearch).sendKeys("HVO");
				Thread.sleep(4000);
				click(HVORESULT);
				click(EDITBUTN);
//			commonUtils.scrollToElement(driver.findElement(By.xpath("//div[contains(@class,'dx-popup-content')]//div[contains(@class,'dx-scrollable-scroll-content')]")));
//			commonUtils.scrollToMiddle();
				// Wait for the edit popup radio to be interactive before selecting PAS2080
				waits.waitForClickable(RADIOBUTTON);
				Thread.sleep(2000);
				click(RADIOBUTTON);
				Thread.sleep(1000);
				// Re-click if the first selection did not register (DevExtreme radios are timing-sensitive)
				if (!"true".equals(driver.findElement(By.xpath("//div[@role='radio'][.//div[normalize-space()='PAS2080 A1-A5']]")).getAttribute("aria-checked"))) {
					click(RADIOBUTTON);
				}
				System.out.println("Selected PAS2080 radio button");
				click(PAS2080);
				Thread.sleep(1000);

				try {

					// 'Select a file' button is disabled; send the path directly to the hidden file input
					find(fileUpload).sendKeys("/Users/roshanpanda/Downloads/8057387_Claim_Request_Form_Blank.pdf");
					System.out.println("Uploaded file to ONCOST EPD");
					Thread.sleep(5000);

				}
				catch (Exception e) {

					System.out.println("Element not found: " + e.getMessage());

				}

			     click(EPDCODE);
	             find(EPDCODE).click();
			    enterText(EPDCODE, "3");
				click(EPDDESCRIPTION);
	            find(EPDDESCRIPTION).click();
				enterText(EPDDESCRIPTION,"test");
				click(IssueDate);
				click(issueDateValue);
				Thread.sleep(2000);

				click(expiryDate);
				click(expiryDateValue);

				click(expandRadio);
				commonUtils.scrollToElement(driver.findElement(By.xpath("//input[@id='carbA1A3Factor']")));
				enterText(a1A3Factor, "34");
				Thread.sleep(1000);
				commonUtils.scrollToElement(find(a4Factor));
				enterText(a4Factor, "55");
				Thread.sleep(1000);
				enterText(a5_1Factor, "34");
				Thread.sleep(1000);
				enterText(a5_2Factor, "55");
				Thread.sleep(1000);
				commonUtils.scrollToElement(find(a5_3Factor));
				enterText(a5_3Factor, "54");
				Thread.sleep(1000);
				commonUtils.scrollToElement(find(a5_4Factor));
				enterText(a5_4Factor, "50");
				Thread.sleep(2000);
				click(applyButton);
				Thread.sleep(4000);

				// Carbon Override Notes popup: open the select box, pick a note, submit
				click(CARBON_OVERRIDE_BOX);
				System.out.println("Clicked Carbon Override Notes box");
				Thread.sleep(2000);
				click(CARBON_OVERRIDE_LIST_ITEM);
				System.out.println("Selected carbon override note from list");
				Thread.sleep(1000);
				click(CARBON_OVERRIDE_SUBMIT);
				System.out.println("Clicked Submit on Carbon Override Notes");
				Thread.sleep(2000);


			} catch (Exception e) {

				System.err.println(e.getLocalizedMessage());

			}

		}

		private void SelectScroll() {
			// TODO Auto-generated method stub
//		 Actions actions = new Actions(driver);
//		 WebElement scrollbar = driver.findElement(By.xpath("//div[contains(@class,'dx-scrollbar-vertical')]//div[contains(@class,'dx-scrollable-scroll')]"));
//		 actions.clickAndHold(scrollbar).moveByOffset(0, 150).release().perform();
			WebElement scrollContainer = driver.findElement(By.xpath("//div[contains(@class,'dx-popup-content')]//div[contains(@class,'dx-scrollable-scrollbar') and contains(@class,'dx-scrollbar-vertical')]"));
			scrollContainer.sendKeys(Keys.END);
		}

		void selectProject() {
			// TODO Auto-generated method stub
			try {

				CommonUtils utils = new CommonUtils(driver);
				int noOfRows = findElements(allrows).size();
				int row = utils.getRandomNumber(noOfRows);

//					String xpath = String.format("(//tr[contains(@class,'dx-data-row')][%d]/td[3])", row);
				String xpath = "(//tr[contains(@class,'dx-data-row')][1]/td[3])";

				click(By.xpath(xpath));
				System.err.println("select project completed");

			} catch (Exception e) {

				System.err.println("select project not completed");
				System.err.println(e.getLocalizedMessage());

			}

		}

	}
