package utilities;

import org.openqa.selenium.WebDriver;

import pages.*;

public class PageManager {

	private WebDriver driver;
	private LoginPage loginPage;
	private EstimateRevisionsManagementPage estimatePage;
	private CommonUtils commonUtils;
	private PSLCreatedfromONCOSTPage psloncostPage;
	private PSLManagementPage pslManagementPage;
	private RestrictAccessToRevisionsPage AccessToRevisionsPage;
	private ViewandUpdatePSLPage viewandUpdatePSLPage;
	private NominatingtheRevisionToPreferredStatus NominateRevisionsPage;

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

	public PSLManagementPage getPSLManagementPage() {
		if (pslManagementPage == null)
			pslManagementPage = new PSLManagementPage(driver);
		return pslManagementPage;
	}

	public ViewandUpdatePSLPage getViewandUpdatePSLPage() {
		if (viewandUpdatePSLPage == null)
		viewandUpdatePSLPage = new ViewandUpdatePSLPage(driver);
		return viewandUpdatePSLPage;
	}
	public  NominatingtheRevisionToPreferredStatus getNominatingtheRevisionToPreferredStatus() {
		if (NominateRevisionsPage == null)
			NominateRevisionsPage = new NominatingtheRevisionToPreferredStatus(driver);
		return NominateRevisionsPage;
	}

}