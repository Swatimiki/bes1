package utilities;

import org.openqa.selenium.WebDriver;

import pages.EstimateRevisionsManagementPage;
import pages.LoginPage;
import pages.PSLCreatedfromONCOSTPage;
import pages.RestrictAccessToRevisionsPage;

public class PageManager {

	private WebDriver driver;
	private LoginPage loginPage;
	private EstimateRevisionsManagementPage estimatePage;
	private CommonUtils commonUtils;
	private PSLCreatedfromONCOSTPage psloncostPage;
	private RestrictAccessToRevisionsPage AccessToRevisionsPage;

	public PageManager(WebDriver driver) {
		this.driver = driver;
	}

	public LoginPage getLoginPage() {
		if (loginPage == null)
			loginPage = new LoginPage(driver);
		return loginPage;
	}

	public EstimateRevisionsManagementPage getEstimateRevisionsManagementPage() {
		if (estimatePage == null)
			estimatePage = new EstimateRevisionsManagementPage(driver);
		return estimatePage;
	}

	public CommonUtils getCommonUtils() {
		if (commonUtils == null)
			commonUtils = new CommonUtils(driver);
		return commonUtils;
	}

	public PSLCreatedfromONCOSTPage getPSLCreatedfromONCOSTPage() {
		if (psloncostPage == null)
			psloncostPage = new PSLCreatedfromONCOSTPage(driver);
		return psloncostPage;
	}
	
	public RestrictAccessToRevisionsPage getRestrictAccessToRevisionsPage() {
		if (AccessToRevisionsPage == null)
			AccessToRevisionsPage = new RestrictAccessToRevisionsPage(driver);
		return AccessToRevisionsPage;
	}

}