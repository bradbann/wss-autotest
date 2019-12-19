package bn.test.smlcs.test;

import org.openqa.selenium.By;

import bn.test.smlcs.driver.DriverManager;
import bn.test.smlcs.step.DaiBanRenWuStep;
import bn.test.smlcs.step.HomeStep;
import bn.test.smlcs.step.LoginStep;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

/**
 * @date 2019年7月15日 下午4:55:38
 * @author zhaodong
 */
public class Test1 {

	
private static AppiumDriver<MobileElement> driver = null;
private static LoginStep loginStep;
private static HomeStep homeStep;
private static DaiBanRenWuStep daiBanRenWuStep;


	

	public static void main(String[] args) {
		try {
			driver = DriverManager.getIosDriver();
//			iosDriver = (IOSDriver<MobileElement>) driver;
			loginStep = new LoginStep(driver);
			daiBanRenWuStep = new DaiBanRenWuStep(driver);
			long start = System.currentTimeMillis(); // 获取开始时间
			
			loginStep.unifyLoginFunction("zhaod002");
//			MobileCommonUtil.sleep(5000);
//			homeStep2.clickDaibanrenwu();
			
			daiBanRenWuStep.getTitle();
			
			long end = System.currentTimeMillis(); // 获取结束时间
			System.out.println("执行案例耗时： " + (end - start) + "ms");
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}finally {
			driver.quit();
		}
		
		
		
		
	}


//	@Test(description="待办任务案例")
	public void daibanrenwuCase(){
		long start=System.currentTimeMillis();   //获取开始时间
		loginStep.unifyLoginFunction("zhaod002");
		homeStep.clickDaibanrenwu();
		daiBanRenWuStep.getTitle();
		long end=System.currentTimeMillis(); //获取结束时间
		System.out.println("执行案例耗时： "+(end-start)+"ms");
		driver.findElement(By.className(""));
		driver.findElementByClassName("");
		
		
	}
	
	
	
	
	
//	@BeforeMethod
//	public void befor() throws MalformedURLException{
//		driver = DriverManager.getIosDriver();
//		loginStep = new LoginStep(driver);
//		homeStep = new HomeStep(driver);
//		daiBanRenWuStep = new DaiBanRenWuStep(driver);
//	}
//	
//	@AfterMethod
//	public void quit(){
//		
//	}
	
	
}
