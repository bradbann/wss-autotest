package bn.test.smlcs.testCase;

import java.net.MalformedURLException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import bn.test.smlcs.driver.DriverManager;
import bn.test.smlcs.step.DaoQiBianGengStep;
import bn.test.smlcs.step.HomeStep;
import bn.test.smlcs.step.LoginStep;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

/**
 * 到期变更
 * @date 2019年10月14日 下午6:11:39
 * @author zhaodong
 */
public class DaoQiBianGengCase {
	
	private AppiumDriver<MobileElement> driver = null;
	private LoginStep loginStep;
	private HomeStep homeStep;
	private DaoQiBianGengStep daoQiBianStep;
	
	
	@Test(description="到期变更-正向案例")
	public void daoQiBianGengCase1(){
		loginStep = new LoginStep(driver);
		homeStep = new HomeStep(driver);
		daoQiBianStep = new DaoQiBianGengStep(driver);
		loginStep.unifyLoginFunction("zhaodong");
		homeStep.clickDaoQiBianGeng();
		daoQiBianStep.clickAddBtn();
		daoQiBianStep.inputCustomerSearchBox("测试六四");
		daoQiBianStep.clickCustomer();
		daoQiBianStep.clickFirstProduct();
		daoQiBianStep.selectDaoQiChuLiType();
		daoQiBianStep.selectShouYiFenPeiType();
		daoQiBianStep.clickNextStep();
		daoQiBianStep.clickFinishOrder();
		Assert.assertEquals(daoQiBianStep.getSuccessText(), "恭喜您!到期转换成功 ");
		
	}
	
	//, dependsOnMethods="daoQiBianGengCase1"
	@Test(description="到期变更撤销订单-正向案例")
	public void daoQiBianGengCase2(){
		loginStep = new LoginStep(driver);
		homeStep = new HomeStep(driver);
		daoQiBianStep = new DaoQiBianGengStep(driver);
		loginStep.unifyLoginFunction("zhaodong");
		homeStep.clickDaoQiBianGeng();
		daoQiBianStep.clickSearchField();
		daoQiBianStep.inputSearchPageCustomer("测试六四");
		daoQiBianStep.clickDaiShangChuanYingXiang();
		daoQiBianStep.clickDaiShenHe();
		daoQiBianStep.clickDaiShenPi();
		daoQiBianStep.clickDaiXiuGai();
		daoQiBianStep.clickConfirm();
		daoQiBianStep.clickFirstOne();
		daoQiBianStep.clickCancelChange();
		daoQiBianStep.inputCause();
		daoQiBianStep.clickConfirmCancel();
		Assert.assertTrue(daoQiBianStep.result());
		
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
