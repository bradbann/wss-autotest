package bn.test.smlcs.testCase;

import java.net.MalformedURLException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import bn.test.smlcs.driver.DriverManager;
import bn.test.smlcs.step.HomeStep;
import bn.test.smlcs.step.LoginStep;
import bn.test.smlcs.step.MyApprovalStep;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

/**
 * 我的审批-案例
 * @date 2019年7月15日 下午4:55:38
 * @author zhaodong
 */
public class MyApprovalCase {

	private AppiumDriver<MobileElement> driver = null;
	private LoginStep loginStep;
	private HomeStep homeStep;
	private MyApprovalStep myApprovalStep;


	/**
	 * 审批列表为空案例
	 */
	@Test(description="我的审批列表为空-案例")
	public void MyApproval1() {
		loginStep = new LoginStep(driver);
		homeStep = new HomeStep(driver);
		myApprovalStep = new MyApprovalStep(driver);
		long start = System.currentTimeMillis(); // 获取开始时间
		loginStep.userPasswordLogin("zhaod002", "q");
		homeStep.clickWodeshenpi();
		String text = myApprovalStep.getTtile();
		System.out.println(text);
		boolean b = myApprovalStep.isEmptyList();
		Assert.assertEquals(b, false);
		long end = System.currentTimeMillis(); // 获取结束时间
		System.out.println("执行案例耗时： " + (end - start) + "ms");

	}
	
	
	/**
	 * 审批列表不为空案例
	 */
//	@Test(description="我的审批列表不为空-案例")
	public void MyApproval2() {
		loginStep = new LoginStep(driver);
		homeStep = new HomeStep(driver);
		myApprovalStep = new MyApprovalStep(driver);
		long start = System.currentTimeMillis(); // 获取开始时间
		loginStep.userPasswordLogin("huzh002", "q");
		homeStep.clickWodeshenpi();
		String text = myApprovalStep.getTtile();
		System.out.println(text);
		boolean b = myApprovalStep.isEmptyList();
		Assert.assertEquals(b, true);
		long end = System.currentTimeMillis(); // 获取结束时间
		System.out.println("执行案例耗时： " + (end - start) + "ms");

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
