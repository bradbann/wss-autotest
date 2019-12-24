package bn.test.smlcs.util;

import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import bn.test.smlcs.log.Log;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

/**
 * @date 2019年4月10日 下午2:44:09
 * @author zhaodong
 */
public class ElementOperation {
	
	WebDriver driver;
	
	public ElementOperation(WebDriver driver) {
		this.driver = driver;
	}
	
	
	/**
	 * 元素输入通用操作，入参为元素和输入的内容
	 * @param element
	 * @param content
	 */
	public static void input(MobileElement element,String content){
		element.clear();
		element.sendKeys(content);
	
	}
	
	/**
	 * 点击操作
	 * @param element
	 */
	public static void click(AppiumDriver<MobileElement> driver,MobileElement element){
		WebDriverWait wait = new WebDriverWait(driver, 20);
		element = (MobileElement) wait.until(ExpectedConditions.visibilityOf(element));
		element.click();
	}
	
	/**
	 * @param driver
	 * @param element
	 * @return 返回可见元素
	 */
	public static MobileElement getVisibleElement(AppiumDriver<MobileElement> driver,MobileElement element){
	
		element	= (MobileElement) new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(element));
		return element;
	}
	
	/**
	 * @param driver
	 * @param elements
	 * @return 返回可见元素集合
	 */
	public static List<WebElement> getVisibleElements(AppiumDriver<MobileElement> driver,List<WebElement> elements){
//		List<MobileElement> elements2;
		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfAllElements(elements));
		return  elements;
	}
	
	/**
	 * 
	 * @param driver
	 * @param element
	 * @return
	 */
	public static String getElementText(AppiumDriver<MobileElement> driver,MobileElement element){
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(element));
		return element.getText();
		
	}
	
	public static MobileElement initElement(AppiumDriver<MobileElement> driver,MobileElement element){
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOf(element));
		return element;
	}
	
	
	/**判断页面元素是否存在*/
	public static boolean elmentIsDisplay(AppiumDriver<MobileElement> driver,String accessibility){
		Boolean boolean1 = false;
//		WebDriverWait wait = new WebDriverWait(driver, 5);
		try {
			WebElement element = driver.findElementByAccessibilityId(accessibility);
//					wait.until(ExpectedConditions.presenceOfElementLocated(by));
			element.isDisplayed();
			boolean1 = true;
		} catch(Exception e)  {
			System.out.println("此元素不存在于本页面");
		} 
		System.out.println(boolean1);
		return boolean1;
		
	}
	
	
	/**判断页面元素是否存在*/
	public static boolean elmentIsDisplay(AppiumDriver<MobileElement> driver,By by){
		Boolean boolean1 = false;
		WebDriverWait wait = new WebDriverWait(driver, 5);
		try {
			WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(by));
			element.isDisplayed();
			boolean1 = true;
		} catch(Exception e)  {
			System.out.println("此元素不存在于本页面");
		} 
		return boolean1;
		
	}
	
	
	
	/**判断页面元素是否存在*/
	public static boolean elmentIsDisplay2(MobileElement element){
		Boolean boolean1 = false;
	
		try {
			element.isDisplayed();
			boolean1 = true;
		} catch (NoSuchElementException e) {
			System.out.println("此元素不存在于本页面");
		} 
		return boolean1;
		
	}
	
	public static WebElement waitForElement(WebDriver webdriver,final By by) {
        WebElement element = null;
        try {
            element = new WebDriverWait(webdriver, 5).until(new ExpectedCondition<WebElement>() {
                public WebElement apply(WebDriver d) {
                    return d.findElement(by);
                }
            });
            Log.info(by+":元素存在");
        } catch (Exception e) {
        	e.printStackTrace();
        	Log.error(by+":元素不存在");
        }
        return element;
    } 
    
    public static boolean waitElementToBeDisplayed(WebDriver webdriver,final WebElement element) {
        boolean wait = false;
        if (element == null)
            return wait;
        try {        	
            wait = new WebDriverWait(webdriver, 5).until(new ExpectedCondition<Boolean>() {
                public Boolean apply(WebDriver d) {
                    return element.isDisplayed();
                }
            });
            Log.info(element+":元素可见");
        } catch (Exception e) {        	
           e.printStackTrace();
           Log.error(element+":元素不可见");
        }
        return wait;
    }
    
    /**初始化元素*/
    public static WebElement initWebElement(WebDriver webdriver,final By by){
    	WebElement element = waitForElement(webdriver, by);
		WebDriverWait wait = new WebDriverWait(webdriver, 15);
		wait.until(ExpectedConditions.visibilityOf(element));
		return element;
	}
    
    /**初始化元素*/
    public  WebElement initWebElement(final By by){
    	WebElement element = null;
        try {
            element = new WebDriverWait(driver, 8).until(new ExpectedCondition<WebElement>() {
                public WebElement apply(WebDriver d) {
                    return d.findElement(by);
                }
            });
            Log.info(by+":元素存在");
        } catch (Exception e) {
        	e.printStackTrace();
        	Log.error(by+":元素不存在");
        }
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOf(element));
		if (element.isDisplayed()) {
			Log.info(by+":元素可见");
			element = wait.until(ExpectedConditions.elementToBeClickable(element));
			
		}
		return element;
	}
    
    /**初始化元素*/
    public  WebElement uninitWebElement(final By by){
    	WebElement element = null;
        try {
            element = new WebDriverWait(driver, 5).until(new ExpectedCondition<WebElement>() {
                public WebElement apply(WebDriver d) {
                    return d.findElement(by);
                }
            });
            Log.info(by+":元素存在");
        } catch (Exception e) {
        	e.printStackTrace();
        	Log.error(by+":元素不存在");
        }
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOf(element));
		return element;
	}
    
    /** 返回存在并不可见元素 */
	public boolean waitElementNotExist(final By by) {
		boolean b = false ;
		WebElement element = null;
		WebDriverWait wait = new WebDriverWait(driver, 5);
		// System.out.println("=========================================");
		for (int i = 0; i < 20; i++) {
			try {
				element = wait.until(ExpectedConditions.presenceOfElementLocated(by));
				if (element.isDisplayed()) {
					timeOut(500);
					// System.out.println("等待"+i);
					if (!element.isDisplayed()) {
						// System.out.println("元素不可见"+element);
						b = true;
						break;
					}
				} else if (!element.isDisplayed()) {
					// System.out.println("元素不可见"+element);
					b = true;
					break;
				}

			} catch (NoSuchElementException e) {
				break;
			} catch (ElementNotVisibleException e) {
				break;
			}
		}
		return b;
	}
    
	
	public void timeOut(int time) {
		try {
			Thread.sleep(time);
		} catch (Exception e) {

		}
	}
	
    public static WebElement initWebElement(WebDriver webdriver,WebElement element){
		WebDriverWait wait = new WebDriverWait(webdriver, 15);
		wait.until(ExpectedConditions.visibilityOf(element));
		return element;
	}
	
	
   

}
