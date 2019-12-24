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
import bn.test.smlcs.step.MyOrderStep;
import bn.test.smlcs.step.MySubscribeStep;
import bn.test.smlcs.step.OrderCancelStep;
import bn.test.smlcs.step.OrdersFlowStep;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

/**
 * 产品认购流程案例
 * @date 2019年8月16日 上午10:22:32
 * @author zhaodong
 */
public class SbuscribeForProductCase {
	
	
	private AppiumDriver<MobileElement> driver = null;
	private LoginStep loginStep;
	private HomeStep homeStep;
	private MySubscribeStep mySubscribeStep;
	private CustomerDetailStep customerDeailStep;
	private OrdersFlowStep ordersFlowStep;
	private MyOrderStep myOrderStep;
	private OrderCancelStep orderCancelStep;
	
	
	
	@Test(description="内部下单流程-活期-正向案例",groups = {"buyOrder"})
	public void testCase2(){
		loginStep = new LoginStep(driver);
		homeStep = new HomeStep(driver);
		mySubscribeStep = new MySubscribeStep(driver);
		customerDeailStep = new CustomerDetailStep(driver);
		ordersFlowStep = new OrdersFlowStep(driver);
		loginStep.unifyLoginFunction("zhaodong");
		homeStep.clickWoyaorengou();
		mySubscribeStep.inputSearchBox("测试六六");
		mySubscribeStep.clickCustomer();
		customerDeailStep.clickSelectAccount();
		ordersFlowStep.clickFirstAccount();
		customerDeailStep.clickNextStep();
		ordersFlowStep.inputProduct("钜宝2号私募投资基金—A1类");
		ordersFlowStep.clickProduct();
		ordersFlowStep.clickLiJiRenGou();
		ordersFlowStep.selectPublicDate();
		ordersFlowStep.inputMoney(3300000);
		ordersFlowStep.clickNextStep();
		ordersFlowStep.clickNoCheckBox();
		ordersFlowStep.selectTuiJianType();
		ordersFlowStep.clickFinishOrdersBtn();
//		ordersFlowStep.clickConfirmBtn();
		Assert.assertTrue(ordersFlowStep.isSuccessful());
		
		
	}
	
	
	
	
	@Test(description="内部下单流程-定期-正向案例")
	public void testCase1(){
		loginStep = new LoginStep(driver);
		homeStep = new HomeStep(driver);
		mySubscribeStep = new MySubscribeStep(driver);
		customerDeailStep = new CustomerDetailStep(driver);
		ordersFlowStep = new OrdersFlowStep(driver);
		loginStep.unifyLoginFunction("zhaodong");
		homeStep.clickWoyaorengou();
		mySubscribeStep.inputSearchBox("测试六六");
		mySubscribeStep.clickCustomer();
		customerDeailStep.clickSelectAccount();
		ordersFlowStep.clickFirstAccount();
		customerDeailStep.clickNextStep();
		ordersFlowStep.inputProduct("钜宝2号私募投资基金—A2类");
		ordersFlowStep.clickProduct();
		ordersFlowStep.clickFirstProductType();
		ordersFlowStep.clickLiJiRenGou();
		ordersFlowStep.selectPublicDate();
		ordersFlowStep.inputMoney(4300000);
		ordersFlowStep.clickNextStep();
		ordersFlowStep.clickNoCheckBox();
		ordersFlowStep.selectTuiJianType();
		ordersFlowStep.clickFinishOrdersBtn();
		ordersFlowStep.clickConfirmBtn();
		Assert.assertTrue(ordersFlowStep.isSuccessful());
		
		
	}
	
	//,dependsOnMethods = {"testCase2"}
	@Test(description = "我的订单-撤销订单案例")
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
