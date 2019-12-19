package bn.test.smlcs.util.packageMobileElement;

import java.lang.reflect.Field;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import bn.test.smlcs.log.Log;
//import bn.test.smlcs.util.packageMobileElement.FindBy;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

/**
 * @date 2018年9月12日 上午9:48:08
 * @author zhaodong
 */
public class PageUtil2 {

	protected ElementLocatorFactory factory;
	public static int time =10;
	public static void initialWebElement(WebDriver driver, Object obj) {
		
		WebElement element = null;
		List<WebElement> elements = null;
		boolean isDisplay = false;
		try {
			Field[] fields = obj.getClass().getDeclaredFields();
			for (Field field : fields) {
//				System.out.print("field: " + field.getName()+" ---->");
//				System.out.println("set前的属性值为："+field.get(obj));
				boolean b1 = field.isAnnotationPresent(iOSXCUITFindBy.class) && field.getType().equals(MobileElement.class);
				boolean b2 = field.isAnnotationPresent(iOSXCUITFindBy.class) && field.getType().equals(List.class);
				if (b1 || b2) {
//					FindBy findBy = field.getAnnotation(FindBy.class);
					iOSXCUITFindBy findBy = field.getAnnotation(iOSXCUITFindBy.class);
//					FindElement findElement = new FindElement();
					
					if(!"".equals(findBy.accessibility())){
						if (b1) {
							element = waitForElement(driver, MobileBy.AccessibilityId(findBy.accessibility()));
							isDisplay = waitElementToBeDisplayed(driver, element);
						}else if (b2) {
							elements = waitForElements(driver, MobileBy.AccessibilityId(findBy.accessibility()));
							isDisplay = waitElementToBeDisplayed(driver, elements);
						}
					}else if (!"".equals(findBy.xpath())) {
						if (b1) {
							element = waitForElement(driver, MobileBy.xpath(findBy.xpath()));
							isDisplay = waitElementToBeDisplayed(driver, element);
						}else if (b2) {
							elements = waitForElements(driver, MobileBy.xpath(findBy.xpath()));
							isDisplay = waitElementToBeDisplayed(driver, elements);
						}
					} else if (!"".equals(findBy.iOSClassChain())) {
						if (b1) {
							element = waitForElement(driver, MobileBy.iOSClassChain(findBy.iOSClassChain()));
							isDisplay = waitElementToBeDisplayed(driver, element);
						}else if (b2) {
							elements = waitForElements(driver, MobileBy.iOSClassChain(findBy.iOSClassChain()));
							isDisplay = waitElementToBeDisplayed(driver, elements);
						}
					}else if (!"".equals(findBy.iOSNsPredicate())) {
						if (b1) {
							element = waitForElement(driver, MobileBy.iOSNsPredicateString(findBy.iOSNsPredicate()));
							isDisplay = waitElementToBeDisplayed(driver, element);
						}else if (b2) {
							elements = waitForElements(driver, MobileBy.iOSNsPredicateString(findBy.iOSNsPredicate()));
							isDisplay = waitElementToBeDisplayed(driver, elements);
						}
					} else if (!"".equals(findBy.id())) {
						if (b1) {
							element = waitForElement(driver, MobileBy.id(findBy.id()));
							isDisplay = waitElementToBeDisplayed(driver, element);
						}else if (b2) {
							elements = waitForElements(driver, MobileBy.id(findBy.id()));
							isDisplay = waitElementToBeDisplayed(driver, elements);
						}
						
					}  else if (!"".equals(findBy.className())) {
						if (b1) {
							element = waitForElement(driver, MobileBy.className(findBy.className()));
							isDisplay = waitElementToBeDisplayed(driver, element);
						}else if (b2) {
							elements = waitForElements(driver, MobileBy.className(findBy.className()));
							isDisplay = waitElementToBeDisplayed(driver, elements);
						}
					}  else if (!"".equals(findBy.tagName())) {
						if (b1) {
							element = waitForElement(driver, MobileBy.tagName(findBy.tagName()));
							isDisplay = waitElementToBeDisplayed(driver, element);
						}else if (b2) {
							elements = waitForElements(driver, MobileBy.tagName(findBy.tagName()));
							isDisplay = waitElementToBeDisplayed(driver, elements);
						}
					} 
					
					field.setAccessible(true);
//					isDisplay = waitElementToBeDisplayed(driver, element);
					if (b1 && isDisplay) {
						field.set(obj, element);
					}else if (b2 && isDisplay) {
						field.set(obj, elements);
					}
//					System.out.println("==============================");
//					System.out.print("field: " + field.getName()+" ---->");
//					System.out.println("set后的属性值为："+field.get(obj));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	 public static WebElement waitForElement(WebDriver webdriver,final By by) {
	        WebElement element = null;
	        try {
	            element = new WebDriverWait(webdriver, time).until(new ExpectedCondition<WebElement>() {
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
	            wait = new WebDriverWait(webdriver, time).until(new ExpectedCondition<Boolean>() {
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
	    
	    public static List<WebElement> waitForElements(WebDriver webdriver,final By by) {
	    	List<WebElement> elements = null;
	        try {

				elements = new WebDriverWait(webdriver, time).until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
	            Log.info(by+":元素列表存在");
	        } catch (Exception e) {
	        	e.printStackTrace();
	        	Log.error(by+":元素列表不存在");
	        }
	        
	        return elements;
	    } 
	    
	    public static boolean waitElementToBeDisplayed(WebDriver webdriver,final List<WebElement> elements) {
	        boolean wait = false;
	        int i = 0;
	        if (elements == null)
	            return wait;
	       
	        try {  
	        	
	        	for (WebElement webElement : elements) {
	  	    	  boolean b = waitElementToBeDisplayed(webdriver,webElement);
	  	    	  if (b) {
					i++;
	  	    	  }
	  	    	  
	  	       	}
//	        	System.out.println("i:"+i+",elements.size: "+elements.size());
	        	if (i == elements.size()) {
					wait = true;
				}
	            Log.info(elements+":元素列表可见");
	        } catch (Exception e) {        	
	           e.printStackTrace();
	           Log.error(elements+":元素列表不可见");
	        }
	        return wait;
	    }
	    
	
	
	
	

}
