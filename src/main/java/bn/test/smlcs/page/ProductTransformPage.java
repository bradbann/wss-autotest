package bn.test.smlcs.page;

import java.time.temporal.ChronoUnit;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.WithTimeout;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

/**
 * 产品转换
 * 
 * @date 2019年9月18日 下午2:55:24
 * @author zhaodong
 */
public class ProductTransformPage {

	// ====================选择客户页=======================================
	/** 客户搜索输入框 */
	@WithTimeout(time = 20, chronoUnit = ChronoUnit.SECONDS)
	@iOSXCUITFindBy(className = "XCUIElementTypeSearchField")
	public MobileElement customerSearchBox;

	/** 客户列表-只展示1条客户数据，通过精确搜索后的客户 */
	@WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
	@iOSXCUITFindBy(className = "XCUIElementTypeCell")
	public MobileElement customer;

	// ====================选择转换前产品页=======================================

	/** 转换前产品列表 */
	@WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
	@iOSXCUITFindBy(className = "XCUIElementTypeCell")
	public MobileElement beforeProducts;

	// ====================选择转换后产品页=======================================
	/** 转换后产品列表 */
	@WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
	@iOSXCUITFindBy(className = "XCUIElementTypeCell")
	public MobileElement afterProducts;

	// ====================产品转换下单页==========================================

	/** 开放日 */
	@WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='开放日']/../../XCUIElementTypeOther[2]")
	public MobileElement publicDate;

	/** 转换份额输入框 */
	@WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
	@iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[3]")
	public MobileElement transformMoney;

	/** 全部转换-按钮 */
	@WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
	@iOSXCUITFindBy(iOSNsPredicate = "name CONTAINS '全部转换'")
	public MobileElement allTransform;

	// ==============日期插件==================================================
	/** 日期插件-完成按钮 */
	@WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
	@iOSXCUITFindBy(accessibility = "完成")
	public MobileElement finishBtn;

	/** 日期插件-取消按钮 */
	@WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
	@iOSXCUITFindBy(accessibility = "取消")
	public MobileElement cancelBtn;

	/** 完成-按钮 */
	@WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
	@iOSXCUITFindBy(accessibility = "完成")
	public MobileElement finish;

	/** 下一步 */
	@WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
	@iOSXCUITFindBy(accessibility = "下一步")
	public MobileElement nextStep;

	/** 完成-按钮 */
	@WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
	@iOSXCUITFindBy(accessibility = "完成下单")
	public MobileElement finishOrder;

	/** 确认弹窗-确认按钮 */
	@WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
	@iOSXCUITFindBy(accessibility = "确认")
	public MobileElement confirmBtn;

	// ==============下单完成页==========================================================================
	/** 下单完成页-恭喜您下单完成 */
	@WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
	@iOSXCUITFindBy(iOSNsPredicate = "name CONTAINS '恭喜您'")
	public MobileElement finishReminder;

	/** 补充影像资料 */
	@WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
	@iOSXCUITFindBy(accessibility = "补充影像资料")
	public MobileElement buChongYingXiang;

	/** 订单详情-跳转链接 */
	@WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
	@iOSXCUITFindBy(accessibility = "订单可点击订单详情或在首页进入我的订单进行查看")
	public MobileElement ordersDetail;

}
