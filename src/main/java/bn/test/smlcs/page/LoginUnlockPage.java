package bn.test.smlcs.page;

import java.time.temporal.ChronoUnit;
import java.util.List;

import org.openqa.selenium.WebElement;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.WithTimeout;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

/**
 * @date 2019年4月9日 下午3:43:16
 * @author zhaodong
 */
public class LoginUnlockPage {
	

	/**忘记手势密码*/
	@WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
	@iOSXCUITFindBy(accessibility="忘记手势密码")
	public MobileElement forgetGesturePassword;
	
	
	@WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
	@iOSXCUITFindBy(accessibility="切换登录方式")
	public MobileElement changeLoginType;
	
//	@WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
//	@iOSXCUITFindBy(accessibility="circle normal")
//	public List<WebElement> points2;
	
	@WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
	@iOSXCUITFindBy(accessibility="circle normal")
	public List<WebElement> points;
	
	

}
