package bn.test.smlcs.step;

import bn.test.smlcs.page.MySubscribePage;
import bn.test.smlcs.util.ElementOperation;
import bn.test.smlcs.util.PageInit;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

/**
 * 我要认购页面
 * @date 2019年8月15日 下午6:22:17
 * @author zhaodong
 */
public class MySubscribeStep {
	
	MySubscribePage mySubscribePage;
	AppiumDriver<MobileElement> driver;
	public MySubscribeStep(AppiumDriver<MobileElement> driver) {
		this.driver = driver;
		mySubscribePage = new MySubscribePage();
		PageInit.initPageElement(driver, mySubscribePage);
		
	}
	
	public MobileElement initElement(MobileElement element){
		return ElementOperation.initElement(driver, element);
		
	}
	
	/**返回页面title*/
	public String getTitle() {
		return initElement(mySubscribePage.title).getText();
	}
	
	/**点击添加按钮*/
	public void clickAddCustomerBtn(){
		initElement(mySubscribePage.addCustomerBtn).click();
	}
	
	/**输入内容到搜索框*/
	public void inputSearchBox(String input){
		initElement(mySubscribePage.searchInputBox).clear();
		mySubscribePage.searchInputBox.sendKeys(input);
	}
	
	/**点击选择下单客户*/
	public void clickCustomer(){
		initElement(mySubscribePage.customer).click();
	}
	
	/**点击键盘上的搜索按钮*/
	public void clickSearchBtn(){
		initElement(mySubscribePage.searchBtn).click();
	}
	
	
	
	
	
	
	
	
	

}
