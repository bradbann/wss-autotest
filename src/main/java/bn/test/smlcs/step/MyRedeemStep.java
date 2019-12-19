package bn.test.smlcs.step;

import bn.test.smlcs.page.MyRedeemPage;
import bn.test.smlcs.util.PageInit;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

/**
 * 我要赎回
 * @date 2019年8月30日 下午6:00:06
 * @author zhaodong
 */
public class MyRedeemStep extends BaseStep{

	MyRedeemPage myRedeemPage;
	public MyRedeemStep(AppiumDriver<MobileElement> driver) {
		super(driver);
		myRedeemPage = new MyRedeemPage();
		PageInit.initPageElement(driver, myRedeemPage);
	}
	
	/** 输入客户到客户搜索框*/
	public void inputCustomerSearchBox(String customer){
		initElement(myRedeemPage.customerSearchBox).clear();
		myRedeemPage.customerSearchBox.sendKeys(customer);
	}
	
	/** 点击客户*/
	public void clickCustomer(){
		initElement(myRedeemPage.customer).click();
	}
	
	/** 点击第一个产品*/
	public void clickRedeemProduct(){
//		initElement(myRedeemPage.redeemProducts);
//		MobileCommonUtil.sleep(3000);
//		System.out.println("可赎回产品数量： "+myRedeemPage.redeemProducts.size());
		myRedeemPage.redeemProducts.get(0).click();
//		initElement(myRedeemPage.redeemProducts).click();
	}
	
	/**点击开放日-默认选第1个*/
	public void clickPublicDate(){
		initElement(myRedeemPage.publicDate).click();
		initElement(myRedeemPage.finish).click();
	}
	
	/**输入赎回份额*/
	public void inputRedeemMoney(int money){
		
		initElement(myRedeemPage.redeemMoney).sendKeys(String.valueOf(money));
	}
	
	/**点击全部赎回*/
	public void clickAllRedeem(){
		initElement(myRedeemPage.allRedeem).click();
	}
	
	/**点击完成*/
	public void clickFinish() {
		initElement(myRedeemPage.finish).click();
	}
	
	/**获取下单完成页成功提示文本*/
	public String getSuccessText(){
		return initElement(myRedeemPage.finishReminder).getText();
	}

}
