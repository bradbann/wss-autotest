package bn.test.smlcs.driver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.remote.DesiredCapabilities;
import bn.test.smlcs.util.PropertyUtil;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

/**
 * @date 2019年3月29日 下午3:15:19
 * @author zhaodong
 */
public class DriverManager {
	
	public static String deviceURL = null;
	private static AppiumDriver<MobileElement> appiumDriver;
	
	
	/**
	 * 获取ios driver
	 */
	public static AppiumDriver<MobileElement> getIosDriver(){
		AppiumDriver<MobileElement> driver = null;
		DesiredCapabilities capabilities = getCapabilities("/bn/test/smlcs/config/ios.properties");
		try {
			driver = new IOSDriver<MobileElement>(new URL(deviceURL), capabilities);
		} catch (MalformedURLException e) {
			
			e.printStackTrace();
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		appiumDriver = driver;
		return driver;
	}
	
	/**
	 * 获取Android driver
	 */
	public static AppiumDriver<MobileElement> getAndroidDriver(){
		AppiumDriver<MobileElement> driver = null;
		DesiredCapabilities capabilities = getCapabilities("/bn/test/smlcs/config/ios.properties");
		try {
			driver = new AndroidDriver<MobileElement>(new URL(deviceURL), capabilities);
		} catch (MalformedURLException e) {
			
			e.printStackTrace();
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
	
	
	
	public static DesiredCapabilities getCapabilities(String filePath){
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		Map<String, String> deviceInfo = PropertyUtil.GetAllProperties(filePath);
		
		for (Map.Entry<String, String> entry:deviceInfo.entrySet()){
			
			if ("deviceURL".equals(entry.getKey())) {
				deviceURL = entry.getValue();
				continue;
			}
			capabilities.setCapability(entry.getKey(), entry.getValue());
		}
		return capabilities;
	}

	public static AppiumDriver<MobileElement> getAppiumDriver() {
		return appiumDriver;
	}

	
	
	
	
	
	
	
	
	

}
