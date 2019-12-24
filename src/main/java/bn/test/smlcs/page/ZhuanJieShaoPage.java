package bn.test.smlcs.page;

import java.time.temporal.ChronoUnit;
import java.util.List;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.WithTimeout;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

/**
 * 转介绍
 * @date 2019年12月4日 下午3:30:49
 * @author zhaodong
 */
public class ZhuanJieShaoPage {
	
	
	/**搜索输入框*/
	@WithTimeout(time=10,chronoUnit=ChronoUnit.SECONDS)
	@iOSXCUITFindBy(className="XCUIElementTypeTextField")
	public MobileElement search;
	
	/**手机系统键盘的搜索按钮*/
	@WithTimeout(time=10,chronoUnit=ChronoUnit.SECONDS)
	@iOSXCUITFindBy(accessibility = "Search")
	public MobileElement keyboardSearch;
	
	/**所有立即认购*/
	@WithTimeout(time=10,chronoUnit=ChronoUnit.SECONDS)
	@iOSXCUITFindBy(accessibility = "立即认购")
	public List<MobileElement> buyNows;
	
	/**第1个立即认购按钮*/
	@WithTimeout(time=10,chronoUnit=ChronoUnit.SECONDS)
	@iOSXCUITFindBy(iOSNsPredicate = "name ='立即认购'and  rect.y = 252")
	public MobileElement firstBuyNow;
	
	/**我的转介绍*/
	@WithTimeout(time=10,chronoUnit=ChronoUnit.SECONDS)
	@iOSXCUITFindBy(accessibility = "btn external order")
	public MobileElement myZhuanJieShao;
	
	/**在途tab-第1笔订单*/
	@WithTimeout(time=10,chronoUnit=ChronoUnit.SECONDS)
	@iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTable/XCUIElementTypeCell[1]")
	public MobileElement zaiTufirstOne;
	
	/**在途tab-所有订单*/
	@WithTimeout(time=10,chronoUnit=ChronoUnit.SECONDS)
	@iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTable/XCUIElementTypeCell[1]")
	public List<MobileElement> zaiTuList;
	
//	/**订单撤销成功toast*/
//	@WithTimeout(time=10,chronoUnit=ChronoUnit.SECONDS)
//	@iOSXCUITFindBy(accessibility = "订单撤销成功")
//	public MobileElement cancelSuccessToast;
	
	
	//=========================外部订单详情=======================================
	
	/**客户类型，用于判断页面信息是否加载出来*/
	@WithTimeout(time=10,chronoUnit=ChronoUnit.SECONDS)
	@iOSXCUITFindBy(accessibility = "客户类型")
	public MobileElement customerType;
	
	/**订单撤销*/
	@WithTimeout(time=10,chronoUnit=ChronoUnit.SECONDS)
	@iOSXCUITFindBy(accessibility = "订单撤销")
	public MobileElement orderCancel;
	
	
	/**搜索输入框*/
	@WithTimeout(time=10,chronoUnit=ChronoUnit.SECONDS)
	@iOSXCUITFindBy(className="XCUIElementTypeSearchField")
	public MobileElement customerSearchInputBox;
	
	/**客户列表-只展示1条客户数据，通过精确搜索后的客户*/
	@WithTimeout(time=10,chronoUnit=ChronoUnit.SECONDS)
	@iOSXCUITFindBy(className="XCUIElementTypeCell")
	public MobileElement customer;
	
	//==========================认购下单页========================================
	/** 选择开放日 */
	@WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
	@iOSXCUITFindBy(iOSNsPredicate="value='请选择开放日'")
	public MobileElement publicDate;
	
	/** 弹窗-确定按钮*/
	@WithTimeout(time = 15, chronoUnit = ChronoUnit.SECONDS)
	@iOSXCUITFindBy(accessibility="确定")
	public MobileElement confirmBtn2;
	
	/** 金额输入框*/
	@WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
	@iOSXCUITFindBy(iOSNsPredicate = "value='请输入金额'")
	public MobileElement moneyInputBox;
	
	/** 金额输入键盘-完成按钮*/
	@WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
	@iOSXCUITFindBy(accessibility="Done")
	public MobileElement finishBtn;
	
	/**外部单-选择期限*/
	@WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
	@iOSXCUITFindBy(accessibility = "请选择期限")
	public MobileElement selectDeadline;
	
	/**外部单-推荐类型*/
	@WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
	@iOSXCUITFindBy(iOSNsPredicate = "type='XCUIElementTypeTextField' and rect.y=266")
	public MobileElement recommendType;
	
	/**外部单-选择期限后的期限单位，如月、日、年*/
	@WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
	@iOSXCUITFindBy(iOSNsPredicate = "name= '月' or name='日' or name='年' or name='天'")
	public MobileElement deadline;

}
