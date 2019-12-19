package bn.test.smlcs.testCase;

import java.net.MalformedURLException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import bn.test.smlcs.driver.DriverManager;
import bn.test.smlcs.step.HomeStep;
import bn.test.smlcs.step.LoginStep;
import bn.test.smlcs.step.PosterShareStep;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

/**
 * 海报分享
 * @date 2019年10月18日 下午4:51:38
 * @author zhaodong
 */
public class PosterShareCase {
	private AppiumDriver<MobileElement> driver = null;
	private LoginStep loginStep;
	private HomeStep homeStep;
	private PosterShareStep posterShareStep;
	
	@Test(description="海报分享-正向案例")
	public void testCase1(){
		
		loginStep = new LoginStep(driver);
		homeStep = new HomeStep(driver);
		posterShareStep = new PosterShareStep(driver);
		loginStep.unifyLoginFunction("zhaodong");
		homeStep.clickHaibaofenxiang();
		posterShareStep.clickFirstPoster();
		posterShareStep.clickPosterName();
		posterShareStep.clickSavePicture();
//		Assert.assertTrue(posterShareStep.assertResult());
		
		
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
