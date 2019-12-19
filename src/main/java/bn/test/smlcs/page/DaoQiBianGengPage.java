package bn.test.smlcs.page;

import java.time.temporal.ChronoUnit;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.WithTimeout;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

/**
 * 到期变更
 * 
 * @date 2019年10月14日 下午6:14:47
 * @author zhaodong
 */
public class DaoQiBianGengPage {

	/** +按钮 */
	@WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
	@iOSXCUITFindBy(accessibility = "bar add")
	public MobileElement addBtn;

	// ====================选择客户页=======================================
	/** 客户搜索输入框 */
	@WithTimeout(time = 20, chronoUnit = ChronoUnit.SECONDS)
	@iOSXCUITFindBy(className = "XCUIElementTypeSearchField")
	public MobileElement customerSearchBox;

	/** 客户列表-只展示1条客户数据，通过精确搜索后的客户 */
	@WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
	@iOSXCUITFindBy(className = "XCUIElementTypeCell")
	public MobileElement customer;

	// ====================选择产品页=======================================
	/** 选择产品列表-第1条产品 */
	@WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
	@iOSXCUITFindBy(className = "XCUIElementTypeCell")
	public MobileElement firstProduct;

	// ====================到期变更页=======================================

	/** 到期处理 */
	@WithTimeout(time = 20, chronoUnit = ChronoUnit.SECONDS)
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='到期处理']/../../XCUIElementTypeOther[2]")
	public MobileElement daoQiChuLi;

	/** 选择到期处理方式-当前选择的处理方式，用于获取当前处理方式文本 */
	@WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
	@iOSXCUITFindBy(className = "XCUIElementTypePickerWheel")
	public MobileElement currentType;

	/** 收益分配 */
	@WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='收益分配']/../../XCUIElementTypeOther[2]")
	public MobileElement shouYiFenPei;

	/** 选择收益分配方式-当前选择的分配方式，用于获取当前分配方式文本 */
	@WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
	@iOSXCUITFindBy(className = "XCUIElementTypePickerWheel")
	public MobileElement currentType2;

	// ==============选择处理方法下拉框==================================================
	/** 选择处理方法下拉框-完成按钮 */
	@WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
	@iOSXCUITFindBy(accessibility = "完成")
	public MobileElement finishBtn;

	/** 选择处理方法下拉框-取消按钮 */
	@WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
	@iOSXCUITFindBy(accessibility = "取消")
	public MobileElement cancelBtn;

	/** 下一步 */
	@WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
	@iOSXCUITFindBy(accessibility = "下一步")
	public MobileElement nextStep;

	/** 完成-按钮 */
	@WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
	@iOSXCUITFindBy(accessibility = "完成下单")
	public MobileElement finishOrder;

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
