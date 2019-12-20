package bn.test.smlcs.testCase;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import bn.test.smlcs.util.ElementOperation;
import bn.test.smlcs.util.MobileCommonUtil;

/**
 * 发放合同,通过pc端给rm发放合同,为ios私募理财师的合同移交案例做数据
 * @date 2019年12月18日 下午12:03:32
 * @author zhaodong
 */
public class ProvideContractCase {
	
	String url = "http://10.60.152.35:8080/#/login";//dev环境地址
	String username = "huzh002";
	String password = "1";
	WebDriver driver;
	
	
	
	@Test(description="发放合同案例-正向流程",priority=1)
	public void provideContractCase1(){
		ElementOperation operation = new ElementOperation(driver);
		SimpleDateFormat myFmt1=new SimpleDateFormat("HH"); 
		SimpleDateFormat myFmt2=new SimpleDateFormat("mm"); 
		Date now=new Date();
		String num = myFmt1.format(now);
		String num2 = myFmt2.format(now);
		int i = Integer.parseInt(num);
		int i2 = Integer.parseInt(num2);
		String num3 = String.valueOf(i+i2);
		num3 = num3+"01";
		driver.get(url);
		operation.initWebElement(By.id("userName")).sendKeys(username);//输入用户名
		operation.initWebElement(By.id("password")).sendKeys(password);//输入密码
		operation.initWebElement(By.xpath("//button[@type='submit']")).click();//点击登录
		operation.waitElementNotExist(By.xpath("//div[@id='loading']"));
		operation.initWebElement(By.xpath("//div[@id='wss-header']/div[2]/ul/li[6]")).click();//点击合同
		
		operation.waitElementNotExist(By.xpath("//div[@id='loading']"));
		operation.initWebElement(By.xpath("//div[@id='wss-sider']/div/ul/li[1]/a")).click();//点击空白合同入库
		operation.waitElementNotExist(By.xpath("//div[@id='loading']"));
		operation.initWebElement(By.xpath("//div[@id='wss-content']//span[text()='空白合同登记']/..")).click();//点击空白合同登记
		operation.initWebElement(By.xpath("//div[@id='wss-content']//span[text()='选 择']/..")).click();//点击选择
		ElementOperation.waitForElement(driver, By.xpath("//input[contains(@value,'钜宝2号')]")).click();
		operation.initWebElement(By.xpath("//span[text()='确 定']/..")).click();//点击确定
		operation.waitElementNotExist(By.xpath("//div[@id='loading']"));
		operation.initWebElement(By.xpath("//input[@placeholder='用印日期']")).click();//点击用印日期
		operation.initWebElement(By.xpath("//a[text()='今天']")).click();//点击日期弹框的今天按钮
		operation.initWebElement(By.xpath("//input[@placeholder='请输入合同后缀数字']")).sendKeys(num3);//输入合同开始序号
		operation.initWebElement(By.xpath("//input[@placeholder='请输入数目']")).sendKeys("30");//输入合同数量
		MobileCommonUtil.sleep(1000);
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");//滑动到页面最底部
		operation.initWebElement(By.xpath("//span[text()='保 存']/..")).click();//点击保存
		operation.waitElementNotExist(By.xpath("//div[@id='loading']"));
		operation.initWebElement(By.xpath("//span[text()='知道了']/..")).click();//点击弹框知道了
		
		operation.waitElementNotExist(By.xpath("//div[@id='loading']"));
		MobileCommonUtil.sleep(1000);
		((JavascriptExecutor) driver).executeScript("document.documentElement.scrollTop=0");
		operation.initWebElement(By.xpath("//a[contains(text(),'我的合同列表')]")).click();//点击我的合同列表
		operation.waitElementNotExist(By.xpath("//div[@id='loading']"));
		operation.initWebElement(By.xpath("//div/label[@title='产品名称']/../../div[2]//input")).sendKeys("钜宝2号母产品");
		operation.initWebElement(By.xpath("//form[contains(@class,'ant-form ant-form-horizontal my-contract-container')]//span[text()='查 询']/..")).click();//点击查询
		operation.waitElementNotExist(By.xpath("//div[@id='loading']"));
		operation.initWebElement(By.xpath("//thead[@class='ant-table-thead']/tr/th[1]/span/div/span/div/label")).click();//勾选全部
		operation.initWebElement(By.xpath("//span[text()='批量移交']/..")).click();//点击批量移交
		operation.waitElementNotExist(By.xpath("//div[@id='loading']"));
		operation.initWebElement(By.xpath("//span[text()='选择部门']")).click();//点击选择部门
		operation.initWebElement(By.xpath("//div[@role='listbox']/ul/li/span/i")).click();//点击展开按钮图标
		operation.initWebElement(By.xpath("//div[@role='listbox']/ul/li//span[text()='科技信息部']")).click();//点击科技信息部
		MobileCommonUtil.sleep(1000);
		ElementOperation.waitForElement(driver, By.xpath("//div[@id='recevieUmNo']/div/span")).click();;
//		operation.initWebElement(By.xpath("//div[@id='recevieUmNo']/div/span")).click();
		WebElement element = operation.initWebElement(By.xpath("//div[@id='recevieUmNo']/div"));//点击输入移交人姓名
		element.click();
		MobileCommonUtil.sleep(1000);
		ElementOperation.waitForElement(driver, By.xpath("//li[text()='赵东']")).click();
//		element.sendKeys("赵东");//点击输入移交人姓名
//		((JavascriptExecutor) driver).executeScript("arguments[0].value = '赵东';", element);
		MobileCommonUtil.sleep(1000);
//		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");//滑动到页面最底部
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);  

		MobileCommonUtil.sleep(1000);
		
		operation.initWebElement(By.xpath("//span[text()='提 交']/..")).click();//点击提交
		operation.waitElementNotExist(By.xpath("//div[@id='loading']"));
		Boolean result = false;
		List<WebElement> elements = driver.findElements(By.xpath("//td[text()='移交锁定']"));
		System.out.println(elements.size());
		if (elements.size()==10) {
			result = true;
		}
		Assert.assertTrue(result);
		
		operation.waitElementNotExist(By.xpath("//div[@id='loading']"));
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");//滑动到页面最底部
		MobileCommonUtil.sleep(1000);
		operation.initWebElement(By.xpath("//div[@class='ant-spin-container']/ul/li[@title='向后 5 页']/../li[3]/a")).click();//点击第2页
		operation.waitElementNotExist(By.xpath("//div[@id='loading']"));
		((JavascriptExecutor) driver).executeScript("document.documentElement.scrollTop=0");//滑动到页面最顶部
		MobileCommonUtil.sleep(1000);
		operation.initWebElement(By.xpath("//thead[@class='ant-table-thead']/tr/th[1]/span/div/span/div/label")).click();//勾选全部
		operation.initWebElement(By.xpath("//span[text()='批量移交']/..")).click();//点击批量移交
		operation.waitElementNotExist(By.xpath("//div[@id='loading']"));
		operation.initWebElement(By.xpath("//span[text()='选择部门']")).click();//点击选择部门
//		operation.initWebElement(By.xpath("//div[@role='listbox']/ul/li/span/i")).click();//点击展开按钮图标
		MobileCommonUtil.sleep(1000);
		operation.initWebElement(By.xpath("//div[@role='listbox']/ul/li//span[text()='科技信息部']")).click();//点击科技信息部
		MobileCommonUtil.sleep(1000);
		ElementOperation.waitForElement(driver, By.xpath("//div[@id='recevieUmNo']/div/span")).click();;
		WebElement element2 = operation.initWebElement(By.xpath("//div[@id='recevieUmNo']/div"));//点击输入移交人姓名
		element2.click();
		MobileCommonUtil.sleep(1000);
		ElementOperation.waitForElement(driver, By.xpath("//li[text()='赵东']")).click();
//		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);  //把元素滑动到页面顶部方向
//		MobileCommonUtil.sleep(1000);
		operation.initWebElement(By.xpath("//span[text()='提 交']/..")).click();//点击提交
		operation.waitElementNotExist(By.xpath("//div[@id='loading']"));
		Boolean result2 = false;
		List<WebElement> elements2 = driver.findElements(By.xpath("//td[text()='移交锁定']"));
		System.out.println(elements2.size());
		if (elements2.size()==10) {
			result2 = true;
		}
		Assert.assertTrue(result2);
//		MobileCommonUtil.sleep(3000);
		
	}
	
	
//	@Test(priority = 2)
	public void provideContractCase2(){
		ElementOperation operation = new ElementOperation(driver);
		driver.get(url);
		operation.initWebElement(By.id("userName")).sendKeys(username);//输入用户名
		operation.initWebElement(By.id("password")).sendKeys(password);//输入密码
		operation.initWebElement(By.xpath("//button[@type='submit']")).click();//点击登录
		operation.waitElementNotExist(By.xpath("//div[@id='loading']"));
		operation.initWebElement(By.xpath("//div[@id='wss-header']/div[2]/ul/li[6]")).click();//点击合同
		
		
		operation.waitElementNotExist(By.xpath("//div[@id='loading']"));
		MobileCommonUtil.sleep(2000);
		((JavascriptExecutor) driver).executeScript("document.documentElement.scrollTop=0");
		operation.initWebElement(By.xpath("//a[contains(text(),'我的合同列表')]")).click();//点击我的合同列表
		operation.waitElementNotExist(By.xpath("//div[@id='loading']"));
		operation.initWebElement(By.xpath("//div/label[@title='产品名称']/../../div[2]//input")).sendKeys("钜宝2号母产品");
		operation.initWebElement(By.xpath("//form[contains(@class,'ant-form ant-form-horizontal my-contract-container')]//span[text()='查 询']/..")).click();//点击查询
		operation.waitElementNotExist(By.xpath("//div[@id='loading']"));
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");//滑动到页面最底部
		MobileCommonUtil.sleep(1000);
		operation.initWebElement(By.xpath("//div[@class='ant-spin-container']/ul/li[@title='向后 5 页']/../li[3]/a")).click();//点击第2页
		operation.waitElementNotExist(By.xpath("//div[@id='loading']"));
		operation.initWebElement(By.xpath("//thead[@class='ant-table-thead']/tr/th[1]/span/div/span/div/label")).click();//勾选全部
		operation.initWebElement(By.xpath("//span[text()='批量移交']/..")).click();//点击批量移交
		operation.waitElementNotExist(By.xpath("//div[@id='loading']"));
		operation.initWebElement(By.xpath("//span[text()='选择部门']")).click();//点击选择部门
		operation.initWebElement(By.xpath("//div[@role='listbox']/ul/li/span/i")).click();//点击展开按钮图标
		operation.initWebElement(By.xpath("//div[@role='listbox']/ul/li//span[text()='科技信息部']")).click();//点击科技信息部
		MobileCommonUtil.sleep(1000);
		ElementOperation.waitForElement(driver, By.xpath("//div[@id='recevieUmNo']/div/span")).click();;
		WebElement element = operation.initWebElement(By.xpath("//div[@id='recevieUmNo']/div"));//点击输入移交人姓名
		element.click();
		MobileCommonUtil.sleep(1000);
		ElementOperation.waitForElement(driver, By.xpath("//li[text()='赵东']")).click();
		MobileCommonUtil.sleep(1000);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);  
		MobileCommonUtil.sleep(1000);
		operation.initWebElement(By.xpath("//span[text()='提 交']/..")).click();//点击提交
		operation.waitElementNotExist(By.xpath("//div[@id='loading']"));
		Boolean result = false;
		List<WebElement> elements = driver.findElements(By.xpath("//td[text()='移交锁定']"));
		System.out.println(elements.size());
		if (elements.size()==10) {
			result = true;
		}
		Assert.assertTrue(result);
	}
	
	
	
	
	
	
	
	@BeforeMethod
	public void beforMethod() {
		
		System.setProperty("webdriver.chrome.driver", "/Users/zhaodong/Documents/AutoTestTools/webbrowerdriver/chromedriver");
		driver = new ChromeDriver();
		
	}
	
	
	@AfterMethod
	public void afterMethod() {
		
		if (driver != null) {
			driver.quit();
		}

	}
	
	

}
