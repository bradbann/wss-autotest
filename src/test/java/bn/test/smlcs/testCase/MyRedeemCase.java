package bn.test.smlcs.testCase;

import java.net.MalformedURLException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import bn.test.smlcs.driver.DriverManager;
import bn.test.smlcs.step.HomeStep;
import bn.test.smlcs.step.LoginStep;
import bn.test.smlcs.step.MyRedeemStep;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

/**
 * 我要赎回
 * @date 2019年9月4日 下午4:10:50
 * @author zhaodong
 */
public class MyRedeemCase {
	
	private AppiumDriver<MobileElement> driver = null;
	private LoginStep loginStep;
	private HomeStep homeStep;
	private MyRedeemStep myRedeemStep;
	
	
	@Test(description="我要赎回-正向案例")
	public void myRedeemCase1(){
		
		loginStep = new LoginStep(driver);
		homeStep = new HomeStep(driver);
		myRedeemStep = new MyRedeemStep(driver);
		loginStep.unifyLoginFunction("zhaod002");
		homeStep.clickWoyaoshuhui();
		myRedeemStep.inputCustomerSearchBox("测试六一");
		myRedeemStep.clickCustomer();
		myRedeemStep.clickRedeemProduct();
		myRedeemStep.clickPublicDate();
		myRedeemStep.clickAllRedeem();
		myRedeemStep.clickFinish();
		Assert.assertEquals(myRedeemStep.getSuccessText(), "恭喜您!产品赎回成功 ");
		
		
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
