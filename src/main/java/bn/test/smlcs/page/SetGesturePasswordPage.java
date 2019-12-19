package bn.test.smlcs.page;

import java.time.temporal.ChronoUnit;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.WithTimeout;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

/**
 * @date 2019年4月11日 下午2:12:06
 * @author zhaodong
 */
public class SetGesturePasswordPage {
	
	public SetGesturePasswordPage(AppiumDriver<MobileElement> driver) {
		
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		
	}
	
	/**设置手势密码页面的标题，用此元素判断是不是在设置收益页面*/
	@WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
	@iOSXCUITFindBy(accessibility="设置手势密码")
	public  MobileElement setGesturePageTitle;
	

}
