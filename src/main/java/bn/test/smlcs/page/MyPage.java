package bn.test.smlcs.page;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

/**
 * @date 2019年7月15日 下午3:11:46
 * @author zhaodong
 */
public class MyPage {
	
	public MyPage(AppiumDriver<MobileElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver),this);
	}
	
	
	
	

}
