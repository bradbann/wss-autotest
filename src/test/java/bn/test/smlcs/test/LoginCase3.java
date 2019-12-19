package bn.test.smlcs.test;

import java.net.MalformedURLException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import bn.test.smlcs.driver.DriverManager;
import bn.test.smlcs.step.LoginStep;
import bn.test.smlcs.step.LoginUnlockStep;
import bn.test.smlcs.step.SetGesturePasswordStep;
import bn.test.smlcs.util.MobileCommonUtil;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class LoginCase3 {

	AppiumDriver<MobileElement> driver = null;
	
	
	
	/**
	 * 调用加载整个页面元素方法
	 */
//	@Test(description="统一登录案例")
	public void loginCase3(){
		LoginStep loginStep = new LoginStep(driver);
		loginStep.unifyLoginFunction("zhaod002");
		
	}
	
	/**
	 * 调用哪个就加载哪个元素
	 */
//	@Test(description="统一登录案例")
	public void loginCase2(){
		LoginStep loginStep = new LoginStep(driver);
		loginStep.unifyLoginFunction("zhaod002");
		
	}
	
	
//	@Test(description="账号密码登录")
	public void loginCase1(){
		
		LoginStep loginStep = new LoginStep(driver);
		SetGesturePasswordStep setGesturePasswordStep = new SetGesturePasswordStep(driver);
		loginStep.inputUsername("zhaod002");
		loginStep.inputPassword();
		loginStep.clickLoginBtn();
//		loginStep.clickNoseePassword();
		MobileCommonUtil.sleep(3000);
		setGesturePasswordStep.setGesturePassword();
		MobileCommonUtil.sleep(5000);
		
	}
	
	@Test(description="手势解锁登录")
	public void unlockLogin(){
		LoginUnlockStep loginlockPatternStep = new LoginUnlockStep(driver);
		loginlockPatternStep.gesturenlock();
		MobileCommonUtil.sleep(2000);
	}
	
	
	
	
	@BeforeMethod
	public void befor() throws MalformedURLException{
		driver = DriverManager.getIosDriver();
	}
	
	@AfterMethod
	public void quit(){
		if (driver!=null) {
			driver.quit();
			System.out.println("关闭driver");
		}
	}




	

}
