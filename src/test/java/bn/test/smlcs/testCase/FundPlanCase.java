package bn.test.smlcs.testCase;

import java.net.MalformedURLException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import bn.test.smlcs.driver.DriverManager;
import bn.test.smlcs.step.FundPlanStep;
import bn.test.smlcs.step.HomeStep;
import bn.test.smlcs.step.LoginStep;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

/**
 * 资金计划-案例
 * @date 2019年11月4日 上午10:31:12
 * @author zhaodong
 */
public class FundPlanCase {
	
	private AppiumDriver<MobileElement> driver = null;
	private LoginStep loginStep;
	private HomeStep homeStep;
	private FundPlanStep fundPlanStep;
	
	@Test(description="资金计划-正向案例")
	public void fundPlanCase1(){
		
		loginStep = new LoginStep(driver);
		homeStep = new HomeStep(driver);
		fundPlanStep = new FundPlanStep(driver);
		
		loginStep.unifyLoginFunction("zhaod002");
		homeStep.clickFundPlan();
		fundPlanStep.clickSearchBox();
		fundPlanStep.clickAllCheckBox();
		fundPlanStep.clickConfirm();
		fundPlanStep.clickShareBtn();
		fundPlanStep.clickFirstCheckBox();
		fundPlanStep.clickConfirm();
		fundPlanStep.fundPlanPDF();
		fundPlanStep.clickShareIcon();
		Assert.assertTrue(fundPlanStep.isDisplayWechat());
		
		
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
