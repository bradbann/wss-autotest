package bn.test.smlcs.step;

import bn.test.smlcs.page.MyApprovalPage;
import bn.test.smlcs.util.ElementOperation;
import bn.test.smlcs.util.PageInit;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

/**
 * 我的审批
 * @date 2019年8月12日 下午4:41:04
 * @author zhaodong
 */
public class MyApprovalStep {

	MyApprovalPage myApprovalPage;
	AppiumDriver<MobileElement> driver;
	public MyApprovalStep(AppiumDriver<MobileElement> driver) {
		this.driver = driver;
		myApprovalPage = new MyApprovalPage();
		PageInit.initPageElement(driver, myApprovalPage);
	}
	
	
	public String getTtile() {
		return ElementOperation.getElementText(driver, myApprovalPage.title);
	}
	
	/**判断审批列表是否为空*/
	public boolean isEmptyList(){
		
		String text = ElementOperation.getElementText(driver, myApprovalPage.emptyList);
		System.out.println(text);
		if ("空列表".equals(text)) {
			return false;
		}else {
			return true;
		}
	}
	
}
