package bn.test.smlcs.page;

import java.time.temporal.ChronoUnit;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.WithTimeout;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

/**
 * 客户详情页，包含认购流程进入的客户详情页和客户列表进入的客户详情页
 * @date 2019年8月16日 上午10:24:28
 * @author zhaodong
 */
public class CustomerDetailPage {
	
	//=============客户详情页面=====================================
	/**选择受益账户，元素在最下边要先向上滑动可见时才能对元素操作*/
	@WithTimeout(time=10,chronoUnit=ChronoUnit.SECONDS)
//	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name='下一步']/preceding-sibling::XCUIElementTypeOther[1]")
	@iOSXCUITFindBy(iOSClassChain="**/XCUIElementTypeOther/XCUIElementTypeButton[-1]")
	public MobileElement selectAccount;
	
	/**客户信息模块标题*/
	@WithTimeout(time=10,chronoUnit=ChronoUnit.SECONDS)
	@iOSXCUITFindBy(accessibility="客户层级")
	public MobileElement customerInfo;
	
	/**下一步*/
	@WithTimeout(time=10,chronoUnit=ChronoUnit.SECONDS)
	@iOSXCUITFindBy(accessibility="下一步")
	public MobileElement nextStep;
	
	
	
	

}
