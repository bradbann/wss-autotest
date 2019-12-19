package bn.test.smlcs.step;

import bn.test.smlcs.page.ProductTransformPage;
import bn.test.smlcs.util.PageInit;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

/**
 * 产品转换
 * @date 2019年9月18日 下午2:50:50
 * @author zhaodong
 */
public class ProductTransformStep extends BaseStep{

	ProductTransformPage productTransformPage;
	public ProductTransformStep(AppiumDriver<MobileElement> driver) {
		super(driver);
		productTransformPage = new ProductTransformPage();
		PageInit.initPageElement(driver, productTransformPage);
		
	}
	
	
	/** 输入客户到客户搜索框*/
	public void inputCustomerSearchBox(String customer){
		
		initElement(productTransformPage.customerSearchBox).click();
		System.out.println("点击客户输入框");
		productTransformPage.customerSearchBox.sendKeys(customer);
		
	}
	
	/** 点击客户*/
	public void clickCustomer(){
		initElement(productTransformPage.customer).click();
	}
	
	/** 点击要转换的产品*/
	public void clickBeforeProduct(){
		initElement(productTransformPage.beforeProducts).click();
	}
	
	/** 点击转换后的产品*/
	public void clickAfterProduct(){
		initElement(productTransformPage.afterProducts).click();
	}
	
	/**点击开放日-默认选第1个*/
	public void clickPublicDate(){
		initElement(productTransformPage.publicDate).click();
		initElement(productTransformPage.finish).click();
	}
	
	/**点击全部转换*/
	public void clickAllTransform(){
		initElement(productTransformPage.allTransform).click();
	}
	
	/**点击下一步*/
	public void clickNextStep(){
		initElement(productTransformPage.nextStep).click();
	}
	
	/**点击完成下单*/
	public void clickFinishOrder(){
		initElement(productTransformPage.finishOrder).click();
	}
	
	/**点击-确认弹窗-确认按钮*/
	public void clickConfirmBtn(){
		initElement(productTransformPage.confirmBtn).click();
	}
	
	/**获取下单完成页成功提示文本*/
	public String getSuccessText(){
		return initElement(productTransformPage.finishReminder).getText();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
