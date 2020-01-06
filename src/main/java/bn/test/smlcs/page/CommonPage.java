package bn.test.smlcs.page;

import java.time.temporal.ChronoUnit;
import java.util.List;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.WithTimeout;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

/**
 * @date 2019年4月11日 下午5:41:50
 * @author zhaodong
 */

public class CommonPage {


	/**手势登录页面或账号密码登录页面的忘记密码按钮，通过获取文本可以知道是在哪个页面*/
	@WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
//	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[contains(@name,'忘记')]")
	@iOSXCUITFindBy(iOSNsPredicate="name  CONTAINS '忘记'")
	public MobileElement forget;
	
	/**确认按钮*/
	@WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
	@iOSXCUITFindBy(iOSNsPredicate="name=='确定'")
	public MobileElement confirm;
	
	/**判断手势密码后，账户是否被踢，被踢后会有重新登录提示*/
	@WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
	@iOSXCUITFindBy(xpath="//XCUIElementTypeApplication[@name='私募理财师']/XCUIElementTypeWindow[1]/XCUIElementTypeOther/child::*")
	public List<MobileElement> prompt;
		
	
	/**
	 * 首页tab
	 */
	@WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
	@iOSXCUITFindBy(accessibility="home normal")
	public MobileElement homePage;
	
	/**
	 * 产品tab
	 */
	@WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
	@iOSXCUITFindBy(accessibility="production normal")
	public MobileElement production;
	
	/**
	 * 客户tab
	 */
	@WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
	@iOSXCUITFindBy(accessibility="customer normal")
	public MobileElement customer;
	
	/**
	 * 我的tab
	 */
	@WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
	@iOSXCUITFindBy(accessibility="my normal")
	public MobileElement my;
	
	@WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
	@iOSXCUITFindBy(id="设置手势密码")
	public MobileElement setGesturePassword;
	
	/**ios 顶部栏，加载图标，通过获取该元素文本，判断是否是该文本"正在进行网络连接"*/
	@WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
	@iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeWindow[3]/XCUIElementTypeStatusBar/XCUIElementTypeOther[2]/XCUIElementTypeOther[3]")
	public MobileElement upload;

}
