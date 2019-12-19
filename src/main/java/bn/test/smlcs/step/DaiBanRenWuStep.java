package bn.test.smlcs.step;

import bn.test.smlcs.page.DaiBanRenWuPage;
import bn.test.smlcs.util.ElementOperation;
import bn.test.smlcs.util.PageInit;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

/**
 * @date 2019年7月16日 上午11:35:09
 * @author zhaodong
 */
public class DaiBanRenWuStep {

	
	 DaiBanRenWuPage daiBanRenWuPage;
	
	AppiumDriver<MobileElement> driver;
	public DaiBanRenWuStep(AppiumDriver<MobileElement> driver) {
		this.driver = driver;
		daiBanRenWuPage = new DaiBanRenWuPage();
		PageInit.initPageElement(driver, daiBanRenWuPage);
	}
	
	public String getTitle() {
		
		String text = ElementOperation.getElementText(driver, daiBanRenWuPage.title);
		System.out.println(text);
		return text;
	}
	
}
