package bn.test.smlcs.step;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebElement;

import bn.test.smlcs.page.LoginUnlockPage;
import bn.test.smlcs.util.ElementOperation;
import bn.test.smlcs.util.PageInit;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

/**
 * @date 2019年4月9日 下午4:14:42
 * @author zhaodong
 */
public class LoginUnlockStep {
	
	LoginUnlockPage loginUnlockPage;
	AppiumDriver<MobileElement> driver;
	
	public LoginUnlockStep(AppiumDriver<MobileElement> driver) {
		loginUnlockPage = new LoginUnlockPage();
		PageInit.initPageElement(driver, loginUnlockPage);
		this.driver = driver;
		
	}
	
	/**切换登录方式*/
	public void clickChangeLoginType(){
		loginUnlockPage.changeLoginType.click();
	}
	
	/**忘记手势密码*/
	public void clickForgetGesturePassword(){
		loginUnlockPage.forgetGesturePassword.click();
	}
	
	/**ios 私募理财师手势解锁*/
	@SuppressWarnings("rawtypes")
	public void gesturenlock(){
		List<WebElement> points = ElementOperation.getVisibleElements(driver, loginUnlockPage.points);
		
//		try {
//			ScreenShot.errorScreenshot(driver, "-p2.jpg");
//		} catch (IOException e) {
//			
//			e.printStackTrace();
//		}
		
//		List<MobileElementE> points =loginUnlockPage.;
//		int x1 = points.get(0).getRect().getX();
//		int y1 = points.get(0).getRect().getY();
		int x1 = ((MobileElement) points.get(0)).getCenter().getX();
		int y1 = ((MobileElement) points.get(0)).getCenter().getY();
		int x2 = x1;
		int y2 = y1+198;
		int x3 = x1+198;
		int y3 = y2;
		System.out.println("x1: "+x1+" , y1: "+y1);
		System.out.println("x2: "+x2+" , y2: "+y2);
		System.out.println("x3: "+x3+" , y3: "+y3);
		TouchAction action = new TouchAction(driver);
		PointOption option1 = PointOption.point(x1, y1);
		PointOption option2 = PointOption.point(x2, y2);
		PointOption option3 = PointOption.point(x3, y3);
		WaitOptions waitOptions = WaitOptions.waitOptions(Duration.ofMillis(500));
		action.press(option1).waitAction(waitOptions).moveTo(option2).waitAction(waitOptions).moveTo(option3).release().perform();
	}
	
	
	
	
	
	

}
