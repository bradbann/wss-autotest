package bn.test.smlcs.page;

import java.time.temporal.ChronoUnit;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.WithTimeout;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

/**
 * @date 2018年1月24日 上午10:19:08
 * @author zhaodong
 */
public class LoginPage {

	
	@WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name='账号']/../XCUIElementTypeOther/XCUIElementTypeTextField")
	public MobileElement username;
	
	@WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
	@iOSXCUITFindBy(accessibility="请输入OA密码")
	public MobileElement password;
	
	@WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name='密码']/../XCUIElementTypeOther/XCUIElementTypeSecureTextField")
	public MobileElement password2;
	
	@WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
	@iOSXCUITFindBy(accessibility="登录")
	public MobileElement loginBtn;
	
	@WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
	@iOSXCUITFindBy(accessibility="忘记密码")
	public MobileElement forgetPassword;
	
	@WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
	@iOSXCUITFindBy(accessibility="password nosee")
	public MobileElement noseePassword;
	
	
	

}
