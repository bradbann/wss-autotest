package bn.test.smlcs.step;

import bn.test.smlcs.page.CustomerDetailPage;
import bn.test.smlcs.util.ElementOperation;
import bn.test.smlcs.util.MobileCommonUtil;
import bn.test.smlcs.util.PageInit;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

/**
 * @date 2019年8月16日 上午11:50:30
 * @author zhaodong
 */
public class CustomerDetailStep {

	CustomerDetailPage customerDetailPage;
	AppiumDriver<MobileElement> driver;

	public CustomerDetailStep(AppiumDriver<MobileElement> driver) {
		this.driver = driver;
		customerDetailPage = new CustomerDetailPage();
		PageInit.initPageElement(driver, customerDetailPage);

	}

	public MobileElement initElement(MobileElement element) {
		return ElementOperation.initElement(driver, element);

	}

	/** 点击选择受益账户 */
	public void clickSelectAccount() {
		initElement(customerDetailPage.customerInfo);
		MobileCommonUtil.slideThreeQuarters(driver);
		initElement(customerDetailPage.selectAccount).click();
	}

	/** 点击下一步 */
	public void clickNextStep() {

		MobileCommonUtil.slideThreeQuarters(driver);
		initElement(customerDetailPage.nextStep).click();

	}

}
