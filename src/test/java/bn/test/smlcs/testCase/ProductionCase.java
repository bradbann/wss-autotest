package bn.test.smlcs.testCase;

import java.net.MalformedURLException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import bn.test.smlcs.driver.DriverManager;
import bn.test.smlcs.step.CommonStep;
import bn.test.smlcs.step.LoginStep;
import bn.test.smlcs.step.ProductionStep;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

/**
 * 产品tab 测试案例
 * @date 2019年12月12日 下午5:58:04
 * @author zhaodong
 */
public class ProductionCase {
	
	private AppiumDriver<MobileElement> driver = null;
	private LoginStep loginStep;
	private ProductionStep productionStep;
	private CommonStep commonStep;
	
	@Test(description="产品tab-股权投资类展示-正向流程")
	public void productionCase1(){
		loginStep = new LoginStep(driver);
		productionStep = new ProductionStep(driver);
		commonStep = new CommonStep(driver);
		loginStep.unifyLoginFunction("zhaod002");
		commonStep.clickProduction();
		productionStep.clickGuQuanTouZi();
		productionStep.clickListFirstOne();
		Assert.assertTrue(productionStep.isDisplayedLiJiRenGou());
	}
	
	
	
	@Test(description="产品tab-海外类展示-正向流程")
	public void productionCase2(){
		loginStep = new LoginStep(driver);
		productionStep = new ProductionStep(driver);
		commonStep = new CommonStep(driver);
		loginStep.unifyLoginFunction("zhaod002");
		commonStep.clickProduction();
		productionStep.clickHaiWai();
		Assert.assertTrue(productionStep.result());
	}
	
	@Test(description="产品tab-现金管理类展示-正向流程")
	public void productionCase3(){
		loginStep = new LoginStep(driver);
		productionStep = new ProductionStep(driver);
		commonStep = new CommonStep(driver);
		loginStep.unifyLoginFunction("zhaod002");
		commonStep.clickProduction();
		productionStep.clickXianJinGuanLi();
		productionStep.clickListFirstOne();
		Assert.assertTrue(productionStep.isDisplayedLiJiRenGou());
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
