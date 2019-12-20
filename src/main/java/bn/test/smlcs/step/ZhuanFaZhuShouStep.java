package bn.test.smlcs.step;

import bn.test.smlcs.page.ZhuanFaZhuShouPage;
import bn.test.smlcs.util.ElementOperation;
import bn.test.smlcs.util.PageInit;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

/**
 * 转发助手
 * @date 2019年12月20日 上午9:13:24
 * @author zhaodong
 */
public class ZhuanFaZhuShouStep extends BaseStep {

	ZhuanFaZhuShouPage zhuanFaZhuShouPage;
	public ZhuanFaZhuShouStep(AppiumDriver<MobileElement> driver) {
		super(driver);
		zhuanFaZhuShouPage = new ZhuanFaZhuShouPage();
		PageInit.initPageElement(driver, zhuanFaZhuShouPage);
	}
	
	/**获取title*/
	public String getTitle() {
		return ElementOperation.getElementText(driver, zhuanFaZhuShouPage.title);
	}

}
