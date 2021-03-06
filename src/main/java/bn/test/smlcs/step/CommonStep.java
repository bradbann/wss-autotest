package bn.test.smlcs.step;

import bn.test.smlcs.page.CommonPage;
import bn.test.smlcs.util.MobileCommonUtil;
import bn.test.smlcs.util.PageInit;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

/**
 * 公共常用步骤
 * @date 2019年12月12日 下午6:23:54
 * @author zhaodong
 */
public class CommonStep extends BaseStep {

	CommonPage commonPage;
	
	public CommonStep(AppiumDriver<MobileElement> driver) {
		super(driver);
		commonPage = new CommonPage();
		PageInit.initPageElement(driver, commonPage);
		
	}
	
	/**点击产品tab*/
	public void clickProduction(){
		initElement(commonPage.production).click();
	}
	
	/**点击客户tab*/
	public void clickCustomer(){
		initElement(commonPage.customer).click();
	}
	
	/**点击我的tab*/
	public void clickMine(){
		initElement(commonPage.my).click();
	}
	
	/**等待ios顶部的加载图片消失*/
	public void waitUploadIsNotDisplay(){
		for (int i = 0; i < 100; i++) {
			if ("正在进行网络连接".equals(initElement(commonPage.upload).getText())) {
				MobileCommonUtil.sleep(1000);
			}else {
				break;
			}
		}
		
	}
	

	
}
