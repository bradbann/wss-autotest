package bn.test.smlcs.page;

import java.time.temporal.ChronoUnit;
import java.util.List;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.WithTimeout;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

/**
 * 认购下单流程相关页面
 * 
 * @date 2019年8月21日 下午3:25:55
 * @author zhaodong
 */
public class OrdersFlowPage {

	// ==============选择受益账户页面==========================
	/** 选择账户，选择第一个 */
	@WithTimeout(time = 20, chronoUnit = ChronoUnit.SECONDS)
	@iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeCell[1]")
	public MobileElement firstAccount;

	// ==============选择产品页面=============================
	/** 搜索输入框 */
	@WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
	@iOSXCUITFindBy(className = "XCUIElementTypeSearchField")
	public MobileElement searchInputBox;

	/** 产品 */
	@WithTimeout(time = 20, chronoUnit = ChronoUnit.SECONDS)
	@iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeCell[1]")
	public MobileElement product;

	/** 立即认购 */
	@WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
	@iOSXCUITFindBy(accessibility = "立即认购")
	public MobileElement lijirengou;
	
	// ==============认购下单页面=============================

	/** 开放日 */
	@WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name='开放日']/../XCUIElementTypeOther[2]")
	public MobileElement publicDate;
	
	/** 金额输入框，不能直接输入，要点击后通过安全键盘输入*/
	@WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
	@iOSXCUITFindBy(iOSClassChain="**/XCUIElementTypeTextField[2]")
	public MobileElement money;
	
	/** 是否重签复选框-是*/
	@WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
//	@iOSXCUITFindBy(iOSClassChain="**/XCUIElementTypeButton[-3]")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='是']/..")
	public MobileElement yesCheckBox;
	
	/** 是否重签复选框-否*/
	@WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
//	@iOSXCUITFindBy(iOSClassChain="**/XCUIElementTypeButton[-2]")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='否']/..")
	public MobileElement noCheckBox;
	
	/** 完成下单按钮*/
	@WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
	@iOSXCUITFindBy(accessibility="完成下单")
	public MobileElement finishOrdersBtn;
	
	/** 弹窗-确认按钮*/
	@WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
	@iOSXCUITFindBy(accessibility="确认")
	public MobileElement confirmBtn;
	
	/** 点完成下单，验证是否又2次确认弹框*/
	@WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
	@iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeOther/XCUIElementTypeButton")
	public List<MobileElement> elementsCount;
	
	/** 弹窗-确定按钮*/
	@WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
	@iOSXCUITFindBy(accessibility="确定")
	public MobileElement confirmBtn2;
	
	/** 点击推荐类型*/
	@WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
	@iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeOther/XCUIElementTypeTextField[1]")
	public MobileElement tuiJianType;
	
	/**开放日字段*/
	@WithTimeout(time = 20, chronoUnit = ChronoUnit.SECONDS)
	@iOSXCUITFindBy(accessibility = "开放日")
	public MobileElement publicDateText;
	
	/**外部单-选择期限*/
	@WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
	@iOSXCUITFindBy(accessibility = "请选择期限")
	public MobileElement selectDeadline;
	
	/**外部单-推荐类型*/
	@WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
	@iOSXCUITFindBy(iOSNsPredicate = "type='XCUIElementTypeTextField' and rect.y=266")
	public MobileElement recommendType;
	
	
	// ==============日期插件============================================================================
	/** 日期插件-完成按钮*/
	@WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
	@iOSXCUITFindBy(accessibility="完成")
	public MobileElement finishBtn;
	
	/** 日期插件-取消按钮*/
	@WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
	@iOSXCUITFindBy(accessibility="取消")
	public MobileElement cancelBtn;
	
	/**下一步*/
	@WithTimeout(time=10,chronoUnit=ChronoUnit.SECONDS)
	@iOSXCUITFindBy(accessibility="下一步")
	public MobileElement nextStep;
	
	
	// ==============下单完成页==========================================================================
	/** 下单完成页-恭喜您下单完成*/
	@WithTimeout(time=10,chronoUnit=ChronoUnit.SECONDS)
	@iOSXCUITFindBy(iOSNsPredicate="name CONTAINS '恭喜您'")
	public MobileElement finishReminder;
	
	/** 补充影像资料*/
	@WithTimeout(time=10,chronoUnit=ChronoUnit.SECONDS)
	@iOSXCUITFindBy(accessibility="补充影像资料")
	public MobileElement buChongYingXiang;
	
	/** 订单详情-跳转链接*/
	@WithTimeout(time=10,chronoUnit=ChronoUnit.SECONDS)
	@iOSXCUITFindBy(accessibility="订单可点击订单详情或在首页进入我的订单进行查看")
	public MobileElement ordersDetail;
	
	
	
	

	
}
