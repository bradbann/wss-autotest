package bn.test.smlcs.testCase;

import java.net.MalformedURLException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import bn.test.smlcs.driver.DriverManager;
import bn.test.smlcs.step.DaiBanRenWuStep;
import bn.test.smlcs.step.HomeStep;
import bn.test.smlcs.step.LoginStep;
import bn.test.smlcs.step.MyApprovalStep;
import bn.test.smlcs.step.RiLiStep;
import bn.test.smlcs.step.ZhuanFaZhuShouStep;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

/**
 * @date 2019年7月15日 下午4:55:38
 * @author zhaodong
 */
public class HomeCase {

	private AppiumDriver<MobileElement> driver = null;
	private LoginStep loginStep;
	private HomeStep homeStep;
	private DaiBanRenWuStep daiBanRenWuStep;
	private MyApprovalStep myApproval;
	private RiLiStep riLiStep;
	private ZhuanFaZhuShouStep zhuanFaZhuShouStep;

	@Test(description = "点击待办任务案例")
	public void clickDaibanrenwu() {
		
		loginStep = new LoginStep(driver);
		homeStep = new HomeStep(driver);
		daiBanRenWuStep = new DaiBanRenWuStep(driver);
//		long start = System.currentTimeMillis(); // 获取开始时间
		loginStep.unifyLoginFunction("zhaod002");
		homeStep.clickDaibanrenwu();
		daiBanRenWuStep.getTitle();
		Assert.assertEquals(daiBanRenWuStep.getTitle(), "待办任务");
//		long end = System.currentTimeMillis(); // 获取结束时间
//		System.out.println("执行案例耗时： " + (end - start) + "ms");
		
	}

	
	@Test(description = "点击我的审批案例")
	public void myApproval() {
		
		loginStep = new LoginStep(driver);
		homeStep = new HomeStep(driver);
		myApproval = new MyApprovalStep(driver);
		loginStep.unifyLoginFunction("zhaod002");
		homeStep.clickWodeshenpi();
		Assert.assertEquals(myApproval.getTtile(), "审批");
		
	}
	
	
	@Test(description = "点击转发助手案例")
	public void zhuanFaZhuShou() {
		
		loginStep = new LoginStep(driver);
		homeStep = new HomeStep(driver);
		zhuanFaZhuShouStep = new ZhuanFaZhuShouStep(driver);
		loginStep.unifyLoginFunction("zhaod002");
		homeStep.clickZhuanfazhushou();
		Assert.assertEquals(zhuanFaZhuShouStep.getTitle(), "转发助手");

	}
	
	@Test(description = "日历案例")
	public void riLiCase() {
		
		loginStep = new LoginStep(driver);
		homeStep = new HomeStep(driver);
		riLiStep = new RiLiStep(driver);
		loginStep.unifyLoginFunction("zhaod002");
		homeStep.clickRili();
		Assert.assertEquals(riLiStep.getTitle(), "我的日历");

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
