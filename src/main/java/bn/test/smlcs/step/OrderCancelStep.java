package bn.test.smlcs.step;

import java.time.temporal.ChronoUnit;

import bn.test.smlcs.page.OrderCancelPage;
import bn.test.smlcs.util.PageInit;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.WithTimeout;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

/**
 * 订单撤销
 * @date 2019年12月10日 上午11:40:15
 * @author zhaodong
 */
public class OrderCancelStep extends BaseStep {

	OrderCancelPage orderCancelPage;
	public OrderCancelStep(AppiumDriver<MobileElement> driver) {
		super(driver);
		orderCancelPage = new OrderCancelPage();
		PageInit.initPageElement(driver, orderCancelPage);
	}
	
	/**输入撤销原因*/
	public void inputCause(){
		initElement(orderCancelPage.causeInputBox).sendKeys("测试");
	}
	
	/**点击页面文本，收起键盘*/
//	public void clickText(){
//		initElement(orderCancelPage.pageText).click();
//	}
	
	/**点击确认撤销操作*/
	public void clickConfirmCancel(){
		initElement(orderCancelPage.pageText).click();
		initElement(orderCancelPage.confirmCancel).click();
	}
	
	/**订单撤销成功toast*/
	@WithTimeout(time=10,chronoUnit=ChronoUnit.SECONDS)
	@iOSXCUITFindBy(accessibility = "订单撤销成功")
	public MobileElement cancelSuccessToast;
	
	/**验证最后的弹出撤销成功的toast*/
	public boolean result(){
		return orderCancelPage.cancelSuccessToast.isDisplayed();
	}
	

}
