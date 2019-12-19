package bn.test.smlcs.util.packageMobileElement;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import bn.test.smlcs.log.Log;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;


/**
 * 
 * @date 2019年7月17日下午3:54:43
 * @author zhaodong
 */
public class MobileElementE implements WebElement {
	
	private WebDriver webdriver ;
	private FindElement findElement;
	
    public MobileElementE(WebDriver webdriver ,FindElement findElement) {
		this.webdriver = webdriver;
        this.findElement = findElement;
    }
    
    private WebElement element;
    private MobileElement mobileElement;
//    private List<MobileElement> mobileElements;
    
    private MobileElement getWebElement(){
    	if(mobileElement != null){
    		return mobileElement;
    	}
    	
    	if (findElement.getAccessibility() !=null) {
    		element = this.waitForMobileElement((MobileBy) MobileBy.AccessibilityId(findElement.getAccessibility()));
		}else if(findElement.getiOSNsPredicate() != null){
			element = this.waitForMobileElement((MobileBy) MobileBy.iOSNsPredicateString(findElement.getiOSNsPredicate()));
		}else if(findElement.getiOSClassChain() != null){
			element =  this.waitForMobileElement((MobileBy)MobileBy.iOSClassChain(findElement.getiOSClassChain()));
		}else if(findElement.getXpath() != null){
			element = this.waitForMobileElement( By.xpath(findElement.getXpath()));
		}else if(findElement.getId()  != null){
			element = this.waitForMobileElement((MobileBy) MobileBy.id(findElement.getId()));
		} else if(findElement.getClassName() != null){
			element = this.waitForMobileElement((MobileBy) MobileBy.className(findElement.getClassName()));
		}
	    
	    return mobileElement = (MobileElement) element;
    }
	
//    @SuppressWarnings("unused")
//	private List<MobileElement> getWebElements(){
//    	if(mobileElements != null){
//    		return mobileElements;
//    	}
//    	
//    	if (findElement.getAccessibility() !=null) {
//			mobileElements = this.waitForMobileElements((MobileBy) MobileBy.AccessibilityId(findElement.getAccessibility()));
//    	}else if(findElement.getiOSNsPredicate() != null){
//			mobileElements = this.waitForMobileElements((MobileBy) MobileBy.iOSNsPredicateString(findElement.getiOSNsPredicate()));
//		}else if(findElement.getiOSClassChain() != null){
//			mobileElements = this.waitForMobileElements((MobileBy)MobileBy.iOSClassChain(findElement.getiOSClassChain()));
//		}else if(findElement.getXpath() != null){
//			 this.waitForMobileElements(By.xpath(findElement.getXpath()));
//		}else if(findElement.getId()  != null){
//	    	mobileElements = this.waitForMobileElements((MobileBy) MobileBy.id(findElement.getId()));
//		} else if(findElement.getClassName() != null){
//			mobileElements = this.waitForMobileElements((MobileBy) MobileBy.className(findElement.getClassName()));
//		}
//	    
//	    return mobileElements;
//    }
//    
    
    
    private WebElement waitForMobileElement(final By by) {
        WebElement element = null;
        try {
            element = new WebDriverWait(webdriver, 10).until(new ExpectedCondition<WebElement>() {
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
    
    @SuppressWarnings({ "unused", "unchecked" })
	private List<MobileElement> waitForMobileElements(final MobileBy by) {
        List<MobileElement> elements = null;
        WebDriverWait wait = new WebDriverWait(webdriver, 10);
        elements = ((List<MobileElement>) wait.until(new ExpectedCondition<WebElement>() {
            public WebElement apply( WebDriver d) {
                return (WebElement) d.findElements(by);
 
            }
        }));
        return elements;
    }  
    
    
    private boolean waitMobileElementToBeDisplayed(final MobileElement element) {
        boolean wait = false;
        if (element == null)
            return wait;
        try {        	
            wait = new WebDriverWait(webdriver, 10).until(new ExpectedCondition<Boolean>() {
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
    
    @SuppressWarnings("unused")
	private List<WebElement> waitMobileElementToBeDisplayed(final List<WebElement> elements) {
      new WebDriverWait(webdriver, 10).until(ExpectedConditions.visibilityOfAllElements(elements));
      return elements;
        
    }
    

	@Override
	public <X> X getScreenshotAs(OutputType<X> target) throws WebDriverException {
		this.getWebElement();
		return mobileElement.getScreenshotAs(target);
	}

	@Override
	public void click() {
		this.getVisibleElement();
		if (mobileElement!=null) {
			mobileElement.click();
			Log.info(mobileElement+":元素点击操作");
		}else {
			Log.info("The element is null");
		}
		
	}

	@Override
	public void submit() {
		this.getVisibleElement();
		mobileElement.submit();
		
	}

	@Override
	public void sendKeys(CharSequence... keysToSend) {
		this.getVisibleElement();
		mobileElement.sendKeys(keysToSend);
		Log.info(mobileElement+":元素输入操作");
		
	}
	
	public void clearAndInput(CharSequence... keysToSend) {
		this.getVisibleElement();
		mobileElement.clear();
		mobileElement.sendKeys(keysToSend);
		Log.info(mobileElement+":元素清空并输入操作");
		
	}
	
	@Override
	public void clear() {
		this.getVisibleElement();
		mobileElement.clear();
		Log.info(mobileElement+":元素清空操作");
		
	}

	@Override
	public String getTagName() {
		this.getVisibleElement();
		return mobileElement.getTagName();
	}

	@Override
	public String getAttribute(String name) {
		this.getVisibleElement();
		return mobileElement.getAttribute(name);
	}

	@Override
	public boolean isSelected() {
		this.getVisibleElement();
		return mobileElement.isSelected();
	}

	@Override
	public boolean isEnabled() {
		this.getVisibleElement();
		return mobileElement.isEnabled();
	}

	@Override
	public String getText() {
		this.getVisibleElement();
		return mobileElement.getText();
	}
	
	public WebElement getElement(){
		return this.getWebElement();
	}
	
	
	public MobileElement getVisibleElement(){
		this.getWebElement();
		if (this.waitMobileElementToBeDisplayed(mobileElement)) {
			return mobileElement;
		}
		return null;
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<MobileElement> findElements(By by) {
		this.getWebElement();
		return mobileElement.findElements(by);
	}

	@SuppressWarnings("unchecked")
	@Override
	public MobileElement findElement(By by) {
		this.getWebElement();
		return mobileElement.findElement(by);
	}

	@Override
	public boolean isDisplayed() {
		this.getWebElement();
		return mobileElement.isDisplayed();
	}

	@Override
	public Point getLocation() {
		this.getWebElement();
		return mobileElement.getLocation();
	}

	@Override
	public Dimension getSize() {
		this.getWebElement();
		return mobileElement.getSize();
	}

	@Override
	public Rectangle getRect() {
		this.getWebElement();
		return mobileElement.getRect();
	}

	@Override
	public String getCssValue(String propertyName) {
		this.getWebElement();
		return mobileElement.getCssValue(propertyName);
	}

}
