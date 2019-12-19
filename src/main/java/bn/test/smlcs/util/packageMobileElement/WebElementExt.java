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
import org.openqa.selenium.support.ui.WebDriverWait;

import bn.test.smlcs.log.Log;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;


/**
 * 
 * @date 2019年7月17日下午3:54:43
 * @author zhaodong
 */
public class WebElementExt implements WebElement {
	
	private WebDriver webdriver ;
	private FindElement findElement;
	
    public WebElementExt(WebDriver webdriver ,FindElement findElement) {
		this.webdriver = webdriver;
        this.findElement = findElement;
    }
    
    private WebElement element;
    private MobileElement mobileElement;
    
    private WebElement getWebElement(){
    	if(mobileElement != null){
    		return mobileElement;
    	}
    	
    	if (findElement.getAccessibility() !=null) {
			mobileElement = this.waitForMobileElement((MobileBy) MobileBy.AccessibilityId(findElement.getAccessibility()));
		}else if(findElement.getiOSNsPredicate() != null){
			mobileElement = this.waitForMobileElement((MobileBy) MobileBy.iOSNsPredicateString(findElement.getAccessibility()));
		}else if(findElement.getiOSClassChain() != null){
			mobileElement = this.waitForMobileElement((MobileBy) MobileBy.iOSClassChain(findElement.getAccessibility()));
		}else if(findElement.getXpath() != null){
			mobileElement = this.waitForMobileElement((MobileBy) MobileBy.xpath(findElement.getXpath()));
		}else if(findElement.getId()  != null){
	    	mobileElement = this.waitForMobileElement((MobileBy) MobileBy.id(findElement.getId()));
		} else if(findElement.getClassName() != null){
			mobileElement = this.waitForMobileElement((MobileBy) MobileBy.className(findElement.getClassName()));
		}
	    
	    if(this.waitMobileElementToBeDisplayed(mobileElement)){
    		return mobileElement;
    	}
	    return null;
    }
	
	
    @SuppressWarnings("unused")
	private WebElement waitForElement(final By by) {
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
    
    private MobileElement waitForMobileElement(final MobileBy by) {
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
        return (MobileElement)element;
    }  
    
    
    @SuppressWarnings("unused")
	private boolean waitElementToBeDisplayed(final WebElement element) {
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
    
    private boolean waitMobileElementToBeDisplayed(final MobileElement element) {
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
    
    
    

	@Override
	public <X> X getScreenshotAs(OutputType<X> target) throws WebDriverException {
		this.getWebElement();
		return element.getScreenshotAs(target);
	}

	@Override
	public void click() {
		this.getWebElement();
		element.click();
		Log.info(element+":元素点击操作");
		
	}

	@Override
	public void submit() {
		this.getWebElement();
		element.submit();
		
	}

	@Override
	public void sendKeys(CharSequence... keysToSend) {
		this.getWebElement();
		element.sendKeys(keysToSend);
		Log.info(element+":元素输入操作");
		
	}

	@Override
	public void clear() {
		this.getWebElement();
		element.clear();
		Log.info(element+":元素清空操作");
		
	}

	@Override
	public String getTagName() {
		this.getWebElement();
		return element.getTagName();
	}

	@Override
	public String getAttribute(String name) {
		this.getWebElement();
		return element.getAttribute(name);
	}

	@Override
	public boolean isSelected() {
		this.getWebElement();
		return element.isSelected();
	}

	@Override
	public boolean isEnabled() {
		this.getWebElement();
		return element.isEnabled();
	}

	@Override
	public String getText() {
		this.getWebElement();
		return element.getText();
	}

	@Override
	public List<WebElement> findElements(By by) {
		this.getWebElement();
		return element.findElements(by);
	}

	@SuppressWarnings("unchecked")
	@Override
	public WebElement findElement(By by) {
		this.getWebElement();
		return element.findElement(by);
	}

	@Override
	public boolean isDisplayed() {
		this.getWebElement();
		return element.isDisplayed();
	}

	@Override
	public Point getLocation() {
		this.getWebElement();
		return element.getLocation();
	}

	@Override
	public Dimension getSize() {
		this.getWebElement();
		return element.getSize();
	}

	@Override
	public Rectangle getRect() {
		this.getWebElement();
		return element.getRect();
	}

	@Override
	public String getCssValue(String propertyName) {
		this.getWebElement();
		return element.getCssValue(propertyName);
	}

}
