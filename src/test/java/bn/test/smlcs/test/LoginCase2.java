package bn.test.smlcs.test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;

public class LoginCase2 {


	public static void main(String[] args) throws MalformedURLException {
		AppiumDriver<MobileElement> driver = null;
		try {
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability("platformName", "iOS");
			capabilities.setCapability("platformVersion", "11.4");
			capabilities.setCapability("deviceName", "iPhone 5s");
			capabilities.setCapability("udid", "fa3785ccd41cbee54bc91a733eea506e18df7102");
			capabilities.setCapability("bundleId", "com.baoneng.simulicaishi");// com.baoneng.simulicaishi //com.tencent.xin
			capabilities.setCapability("automationName", "XCUITest");
			capabilities.setCapability("noReset", true);

			driver = new IOSDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			waitTime(2000);
			driver.findElementByAccessibilityId("切换登录方式").click();
			waitTime(2000);

		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if (driver!=null) {
				driver.quit();
				System.out.println("关闭driver");
			}
			
		}

		
		
	}
	
	

	
	



	public static void waitTime(int time) {

		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}

}
