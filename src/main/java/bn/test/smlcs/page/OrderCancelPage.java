package bn.test.smlcs.page;

import java.time.temporal.ChronoUnit;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.WithTimeout;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

/**
 * 订单撤销页
 * @date 2019年12月10日 上午11:22:06
 * @author zhaodong
 */
public class OrderCancelPage {

	
	
	/**订单撤销*/
	@WithTimeout(time=10,chronoUnit=ChronoUnit.SECONDS)
	@iOSXCUITFindBy(accessibility = "订单撤销")
	public MobileElement orderCancel;
	
	/**撤销原因输入框*/
	@WithTimeout(time=10,chronoUnit=ChronoUnit.SECONDS)
	@iOSXCUITFindBy(className = "XCUIElementTypeTextView")
	public MobileElement causeInputBox;
	
	/**"确认撤销请补充原因后再提交",点击该元素主要用于收起键盘*/
	@WithTimeout(time=10,chronoUnit=ChronoUnit.SECONDS)
	@iOSXCUITFindBy(accessibility = "确认撤销请补充原因后再提交")
	public MobileElement pageText;
	
	/**确认撤销操作按钮*/
	@WithTimeout(time=10,chronoUnit=ChronoUnit.SECONDS)
	@iOSXCUITFindBy(iOSNsPredicate = "name='确认撤销操作'  and visible=true")
	public MobileElement confirmCancel;
	
	/**订单撤销成功toast*/
	@WithTimeout(time=10,chronoUnit=ChronoUnit.SECONDS)
	@iOSXCUITFindBy(accessibility = "订单撤销成功")
	public MobileElement cancelSuccessToast;
	
	/**原因为空时弹出的toast提示*/
	@WithTimeout(time=10,chronoUnit=ChronoUnit.SECONDS)
	@iOSXCUITFindBy(accessibility = "请输入撤销的原因!")
	public MobileElement toastCause;
	
	
	
}
