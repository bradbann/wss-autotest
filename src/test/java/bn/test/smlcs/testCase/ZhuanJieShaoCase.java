package bn.test.smlcs.testCase;

import java.net.MalformedURLException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import bn.test.smlcs.driver.DriverManager;
import bn.test.smlcs.step.CustomerDetailStep;
import bn.test.smlcs.step.HomeStep;
import bn.test.smlcs.step.LoginStep;
import bn.test.smlcs.step.MySubscribeStep;
import bn.test.smlcs.step.OrderCancelStep;
import bn.test.smlcs.step.OrdersFlowStep;
import bn.test.smlcs.step.ZhuanJieShaoStep;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

/**
 * @date 2019年12月4日 下午3:36:07
 * @author zhaodong
 */
public class ZhuanJieShaoCase {
	
	private AppiumDriver<MobileElement> driver = null;
	private LoginStep loginStep;
	private HomeStep homeStep;
	private ZhuanJieShaoStep zhuanJieShaoStep;
	private CustomerDetailStep customerDeailStep;
	private OrdersFlowStep ordersFlowStep;
	private MySubscribeStep mySubscribeStep;
	private OrderCancelStep orderCancelStep;
	
	/**下单流程*/
	@Test(description="外部下单流程-正向案例")
	public void ZhuanJieShaoCase1(){
		loginStep = new LoginStep(driver);
		homeStep = new HomeStep(driver);
		mySubscribeStep = new MySubscribeStep(driver);
		zhuanJieShaoStep = new ZhuanJieShaoStep(driver);
		customerDeailStep = new CustomerDetailStep(driver);
		ordersFlowStep = new OrdersFlowStep(driver);
		loginStep.unifyLoginFunction("zhaod002");
		homeStep.clickZhuanjieshao();
		zhuanJieShaoStep.inputProductName("赵小妍儿测试-银信");
		zhuanJieShaoStep.clickBuyNow();
		mySubscribeStep.inputSearchBox("测试七零");
		mySubscribeStep.clickCustomer();
		customerDeailStep.clickSelectAccount();
		ordersFlowStep.clickFirstAccount();
		customerDeailStep.clickNextStep();
		zhuanJieShaoStep.selectPublicDate();
		zhuanJieShaoStep.inputMoney("400000");
		zhuanJieShaoStep.selectDeadline();
		zhuanJieShaoStep.selectRecommendType();
		ordersFlowStep.clickFinishOrdersBtn();
		Assert.assertTrue(ordersFlowStep.isSuccessful());
	}
	
	@Test(description="外部单撤单流程-正向流程")
	public void ZhuanJieShaoCase2(){
		loginStep = new LoginStep(driver);
		homeStep = new HomeStep(driver);
		mySubscribeStep = new MySubscribeStep(driver);
		zhuanJieShaoStep = new ZhuanJieShaoStep(driver);
		orderCancelStep = new OrderCancelStep(driver);
		loginStep.unifyLoginFunction("zhaod002");
		homeStep.clickZhuanjieshao();
		zhuanJieShaoStep.clickMyZhuanJieShao();
		zhuanJieShaoStep.clickZaiTuFirstOne();
		zhuanJieShaoStep.clickOrderCancel();
		orderCancelStep.inputCause();
		orderCancelStep.clickConfirmCancel();
		Assert.assertFalse(orderCancelStep.result());
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
