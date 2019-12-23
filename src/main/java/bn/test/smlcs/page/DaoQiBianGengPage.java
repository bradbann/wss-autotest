package bn.test.smlcs.page;

import java.time.temporal.ChronoUnit;
import java.util.List;

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
	
	/**输入框区域*/
	@WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
	@iOSXCUITFindBy(className = "XCUIElementTypeSearchField")
	public MobileElement searchField;
	
	/**在途tab*/
	@WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
	@iOSXCUITFindBy(accessibility = "在途")
	public MobileElement zaiTu;
	
	/**到期变更页title*/
	@WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
	@iOSXCUITFindBy(accessibility = "到期变更")
	public MobileElement title;

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
	
	/** 判断是否有确认弹窗,通过获取返回数量判断是否有弹窗，1是没有，2是有弹窗*/
	@WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
	@iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeWindow[1]/XCUIElementTypeOther")
	public List<MobileElement> isDialog;
	
	/** 判断是否有确认弹窗,通过获取返回数量判断是否有弹窗，1是没有，2是有弹窗 ,3是加载图标*/
	@WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
	@iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther/*")
	public List<MobileElement> isDialog2;
	
	/** 弹窗-确认按钮*/
	@WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
	@iOSXCUITFindBy(accessibility="确认")
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
	
	
	//======================搜索页======================================
	
		/**订单状态-待修改*/
		@WithTimeout(time=10,chronoUnit=ChronoUnit.SECONDS)
		@iOSXCUITFindBy(accessibility = "待修改")
		public MobileElement daiXiuGai;
		
		/**订单状态-待审核*/
		@WithTimeout(time=10,chronoUnit=ChronoUnit.SECONDS)
		@iOSXCUITFindBy(accessibility = "待审核")
		public MobileElement daiSehenHe;
		
		/**订单状态-待审批*/
		@WithTimeout(time=10,chronoUnit=ChronoUnit.SECONDS)
		@iOSXCUITFindBy(accessibility = "待审批")
		public MobileElement daiSehenPi;
		
		/**订单状态-待上传影像*/
		@WithTimeout(time=10,chronoUnit=ChronoUnit.SECONDS)
		@iOSXCUITFindBy(accessibility = "待上传影像")
		public MobileElement daiShangChuanYingXiang;
		
		/**确定*/
		@WithTimeout(time=10,chronoUnit=ChronoUnit.SECONDS)
		@iOSXCUITFindBy(accessibility = "确定")
		public MobileElement confirmBtn2;
		
		/**客户名称输入框*/
		@WithTimeout(time=10,chronoUnit=ChronoUnit.SECONDS)
		@iOSXCUITFindBy(iOSClassChain ="**/XCUIElementTypeTextField[1]")
		public MobileElement customerInput;
		
		/**键盘的完成按钮*/
		@WithTimeout(time=10,chronoUnit=ChronoUnit.SECONDS)
		@iOSXCUITFindBy(accessibility = "Done")
		public MobileElement keyboardFinish;
		
		/**搜索结果，判断是否结果页是否有数据，通过list个数判断，如果是2则有数据*/
		@WithTimeout(time=10,chronoUnit=ChronoUnit.SECONDS)
		@iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/*")
		public List<MobileElement> searchResult;
		
		/**搜索结果-第1条数据*/
		@WithTimeout(time=10,chronoUnit=ChronoUnit.SECONDS)
		@iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTable/XCUIElementTypeCell[1]")
		public MobileElement resultFirstOne;
		
		//================到期变更详情页==========================================================
		
		/**客户文本，用于判断页面是否加载完*/
		@WithTimeout(time=10,chronoUnit=ChronoUnit.SECONDS)
		@iOSXCUITFindBy(accessibility = "客户")
		public MobileElement customerText;
		
		/**取消变更按钮*/
		@WithTimeout(time=10,chronoUnit=ChronoUnit.SECONDS)
		@iOSXCUITFindBy(accessibility = "取消变更")
		public MobileElement cancelChange;
		
	
	

}
