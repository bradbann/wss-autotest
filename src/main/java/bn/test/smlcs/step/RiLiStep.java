package bn.test.smlcs.step;

import bn.test.smlcs.page.RiLiPage;
import bn.test.smlcs.util.PageInit;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

/**
 * 日历 步骤
 * @date 2019年12月13日 上午11:59:26
 * @author zhaodong
 */
public class RiLiStep extends BaseStep {

	RiLiPage riLiPage;
	public RiLiStep(AppiumDriver<MobileElement> driver) {
		super(driver);
		riLiPage = new RiLiPage();
		PageInit.initPageElement(driver, riLiPage);
	}
	
	public String getTitle() {
		return initElement(riLiPage.title).getText();

	}
	

}
