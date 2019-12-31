package bn.test.smlcs.testCase;

import java.net.MalformedURLException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import bn.test.smlcs.driver.DriverManager;
import bn.test.smlcs.step.HomeStep;
import bn.test.smlcs.step.LoginStep;
import bn.test.smlcs.step.MyOrderStep;
import bn.test.smlcs.step.OrderCancelStep;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

/**
 * 我的订单
 * @date 2019年12月11日 下午6:19:15
 * @author zhaodong
 */
public class MyOrderCase {
	
	private AppiumDriver<MobileElement> driver = null;
	private LoginStep loginStep;
	private HomeStep homeStep;
	private MyOrderStep myOrderStep;
	private OrderCancelStep orderCancelStep;
	
//	@Test(description = "我的订单-撤销订单案例")
	public void myOrder_orderCancelCase() {
		
		loginStep = new LoginStep(driver);
		homeStep = new HomeStep(driver);
		myOrderStep = new MyOrderStep(driver);
		orderCancelStep = new OrderCancelStep(driver);
		loginStep.unifyLoginFunction("zhaod002");
		homeStep.clickMyOrder();
		myOrderStep.clickSearchBtn();
		myOrderStep.clickDaiXiuGai();
		myOrderStep.clickDaiBuLu();
		myOrderStep.clickShenHeZhong();
		myOrderStep.clickConfirm();
		myOrderStep.clickSearchResultFristOne();
		myOrderStep.clickOrderRevocation();
		orderCancelStep.inputCause();
		orderCancelStep.clickConfirmCancel();
		Assert.assertTrue(orderCancelStep.result());
		
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
