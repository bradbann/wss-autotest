package bn.test.smlcs.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import bn.test.smlcs.util.packageMobileElement.PageUtil;
import bn.test.smlcs.util.packageMobileElement.PageUtil2;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

/**
 * @date 2019年7月17日 上午9:25:34
 * @author zhaodong
 */
public class PageInit {
	
	
	
	
	/**
	 * 找到page定义的所有元素属性
	 * @param driver
	 * @param objects
	 */
	public static void initPageElement3(AppiumDriver<?> driver, Object... objects) {
		if (driver == null) {
			new Exception("driver is null");

		}
		for (Object object : objects) {
			PageUtil2.initialWebElement(driver, object);
		}

	}
	

	/**appium自带初始化页面方法*/
	public static void initPageElement(AppiumDriver<?> driver, Object... objects) {
		if (driver == null) {
			new Exception("driver is null");

		}
		for (Object object : objects) {
			PageFactory.initElements(new AppiumFieldDecorator(driver), object);
		}

	}

	public static void initPageElement1(WebDriver driver, Object... objects) {

		if (driver == null) {
			new Exception("driver is null");

		}
		for (Object obj : objects) {

			PageUtil.initialWebElement(driver, obj);
		}

	}

}
