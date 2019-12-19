package bn.test.smlcs.test;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.validator.routines.checkdigit.ISBN10CheckDigit;
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
public class Test2 {

	
private static AppiumDriver<MobileElement> driver = null;
private static LoginStep loginStep;
private static HomeStep homeStep;
private static DaiBanRenWuStep daiBanRenWuStep;


	

	public static void main(String[] args) {
		
		SimpleDateFormat myFmt1=new SimpleDateFormat("mm"); 
		SimpleDateFormat myFmt2=new SimpleDateFormat("HH");
		Date now=new Date();
		String time = myFmt1.format(now);
		
		String s2 = myFmt2.format(now);
		int i = Integer.parseInt(time);
		int i2 = Integer.parseInt(s2);
		System.out.println(i+i2);
		System.out.println(s2);
		System.out.println(time+s2);
		time = time+"30";
		System.out.println(time);
//		int i = 3500000;
//		String string = String.valueOf(i);
//		System.out.println(string);
//		
//		String s1 = "abdcasdjkfa";
//		System.out.println(s1.substring(0, s1.length()-1));
//		System.out.println(s1.substring(s1.length()-1));
		
		
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
