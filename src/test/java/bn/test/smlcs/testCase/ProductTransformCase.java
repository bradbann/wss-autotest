package bn.test.smlcs.testCase;

import java.net.MalformedURLException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import bn.test.smlcs.driver.DriverManager;
import bn.test.smlcs.step.HomeStep;
import bn.test.smlcs.step.LoginStep;
import bn.test.smlcs.step.ProductTransformStep;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

/**
 * 产品转换
 * @date 2019年10月11日 下午5:54:04
 * @author zhaodong
 */
public class ProductTransformCase {
	
	
	private AppiumDriver<MobileElement> driver = null;
	private LoginStep loginStep;
	private HomeStep homeStep;
	private ProductTransformStep productTransformStep;
	
	
	@Test(description="产品转换-正向案例")
	public void productTransformCase1(){
		
		loginStep = new LoginStep(driver);
		homeStep = new HomeStep(driver);
		productTransformStep = new ProductTransformStep(driver);
		
		loginStep.unifyLoginFunction("zhaod002");
		homeStep.clickChanpinzhuanhuan();
		productTransformStep.inputCustomerSearchBox("测试六一");
		productTransformStep.clickCustomer();
		productTransformStep.clickBeforeProduct();
		productTransformStep.clickAfterProduct();
		productTransformStep.clickPublicDate();
		productTransformStep.clickAllTransform();
		productTransformStep.clickNextStep();
		productTransformStep.clickFinishOrder();
		productTransformStep.clickConfirmBtn();
		Assert.assertEquals(productTransformStep.getSuccessText(), "恭喜您!产品转换成功 ");
		
		
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
