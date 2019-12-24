package bn.test.smlcs.testCase;

import java.net.MalformedURLException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import bn.test.smlcs.driver.DriverManager;
import bn.test.smlcs.step.HeTongYiJiaoStep;
import bn.test.smlcs.step.HomeStep;
import bn.test.smlcs.step.LoginStep;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

/**
 * 合同移交-测试案例
 * @date 2019年10月17日 下午6:06:38
 * @author zhaodong
 */
public class HeTongYiJiaoCase {
	
	private AppiumDriver<MobileElement> driver = null;
	private LoginStep loginStep;
	private HomeStep homeStep;
	private HeTongYiJiaoStep heTongYiJiaoStep;
	
	
	@Test(description="合同移交-正向案例")
	public void case1(){
		loginStep = new LoginStep(driver);
		homeStep = new HomeStep(driver);
		heTongYiJiaoStep = new HeTongYiJiaoStep(driver);
		loginStep.unifyLoginFunction("zhaod002");
		homeStep.clickHeTongYiJiao();
		heTongYiJiaoStep.clickFirstContract();
		heTongYiJiaoStep.clickConfirmBtn();
		Assert.assertTrue(heTongYiJiaoStep.assertResult());
		
		
	}
	
	@Test(description="合同移交-反向案例")
	public void case2(){
		loginStep = new LoginStep(driver);
		homeStep = new HomeStep(driver);
		heTongYiJiaoStep = new HeTongYiJiaoStep(driver);
		loginStep.unifyLoginFunction("zhaodong");
		homeStep.clickHeTongYiJiao();
		heTongYiJiaoStep.clickFirstContract();
		heTongYiJiaoStep.clickRefuseBtn();
		Assert.assertTrue(heTongYiJiaoStep.assertResult());
		
		
	}
	
	
	@BeforeMethod
	public void befor() throws MalformedURLException {
		driver = DriverManager.getIosDriver();
	}

	@AfterMethod
	public void quit() {
		if (driver != null) {
			driver.quit();
			System.out.println("关闭driver");
		}
	}
	

}
