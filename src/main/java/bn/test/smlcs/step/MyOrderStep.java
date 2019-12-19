package bn.test.smlcs.step;

import bn.test.smlcs.page.MyOrderPage;
import bn.test.smlcs.util.PageInit;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

/**
 * @date 2019年12月11日 下午4:44:50
 * @author zhaodong
 */
public class MyOrderStep extends BaseStep {

	MyOrderPage myOrderPage;
	
	public MyOrderStep(AppiumDriver<MobileElement> driver) {
		super(driver);
		myOrderPage = new MyOrderPage();
		PageInit.initPageElement(driver, myOrderPage);
		
	}
	
	/**点击搜索*/
	public void clickSearchBtn(){
		initElement(myOrderPage.search).click();
	}
	
	/**点击待修改*/
	public void clickDaiXiuGai(){
		initElement(myOrderPage.daiXiuGai).click();
	}
	
	/**点击待补录*/
	public void clickDaiBuLu(){
		initElement(myOrderPage.daiBuLu).click();
	}
	
	/**点击审核中*/
	public void clickShenHeZhong(){
		initElement(myOrderPage.shenHeZhong).click();
	}
	
	/**点击确定*/
	public void clickConfirm(){
		initElement(myOrderPage.confirmBtn).click();
	}
	
	/**点击搜索结果页第1条数据*/
	public void clickSearchResultFristOne(){
		initElement(myOrderPage.resultFirstOne).click();
	}
	
	/**点击订单撤销*/
	public void clickOrderRevocation(){
		initElement(myOrderPage.orderRevocation).click();
	}
	
	
	
	

}
