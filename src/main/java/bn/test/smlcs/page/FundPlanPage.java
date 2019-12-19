package bn.test.smlcs.page;

import java.time.temporal.ChronoUnit;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.WithTimeout;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

/**
 * 资金计划
 * @date 2019年11月4日 上午10:34:48
 * @author zhaodong
 */
public class FundPlanPage {
	
	
	/** 搜索输入框 */
	@WithTimeout(time = 20, chronoUnit = ChronoUnit.SECONDS)
	@iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther")
	public MobileElement searchBox;
	
	//=============================搜索页================================
	
	
	/** 客户名称搜索框*/
	@WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
	@iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[1]")
	public MobileElement customerName;
	
	/** 产品名称搜索框*/
	@WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
	@iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[2]")
	public MobileElement productName;
	
	/** 今天*/
	@WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
	@iOSXCUITFindBy(accessibility = "今天")
	public MobileElement today;
	
	/** 三天内*/
	@WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
	@iOSXCUITFindBy(accessibility = "3天内")
	public MobileElement threeDay;
	
	/** 七天内*/
	@WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
	@iOSXCUITFindBy(accessibility = "7天内")
	public MobileElement sevenDay;
	
	/** 1个月内*/
	@WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
	@iOSXCUITFindBy(accessibility = "1个月内")
	public MobileElement oneMonth;
	
	/** 3个月内*/
	@WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
	@iOSXCUITFindBy(accessibility = "3个月内")
	public MobileElement threeMonth;
	
	/** 一年内*/
	@WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
	@iOSXCUITFindBy(accessibility = "一年内")
	public MobileElement oneYear;
	
	/** 分配类型-全部*/
	@WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
	@iOSXCUITFindBy(accessibility = "全部")
	public MobileElement all;
	
	/** 分配类型-到期*/
	@WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
	@iOSXCUITFindBy(accessibility = "到期")
	public MobileElement expire;
	
	/** 分配类型-分红*/
	@WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
	@iOSXCUITFindBy(accessibility = "分红")
	public MobileElement dividend;
	
	/** 确定*/
	@WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
	@iOSXCUITFindBy(accessibility = "确定")
	public MobileElement confirm;
	
	/** 重置*/
	@WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
	@iOSXCUITFindBy(accessibility = "重置")
	public MobileElement reset;
	
	/** 分享*/
	@WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
	@iOSXCUITFindBy(accessibility = "分享")
	public MobileElement share;
	
	/** 取消分享*/
	@WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
	@iOSXCUITFindBy(accessibility = "取消")
	public MobileElement cancelShare;
	
	/** 第1条资金计划，点击可进入分配详情页*/
	@WithTimeout(time = 20, chronoUnit = ChronoUnit.SECONDS)
	@iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTable/XCUIElementTypeCell[2]")
	public MobileElement firstFundPlan;
	
	/**第1个复选框*/
	@WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
	@iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeSwitch[1]")
	public MobileElement firstCheckBox;
	
	/** 全选按钮*/
	@WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
	@iOSXCUITFindBy(accessibility = "全选")
	public MobileElement selectAll;
	
	/** 分享icon，点击分享好友*/
	@WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
	@iOSXCUITFindBy(accessibility = "icon share")
	public MobileElement shareIcon;
	
	/** 点击分享后，弹出列表中的微信按钮*/
	@WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
	@iOSXCUITFindBy(accessibility = "微信")
	public MobileElement shareWechat;
	
	/**分配计划表整体页面，作为后期截图用*/
	@WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
	@iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeWebView/XCUIElementTypeOther")
	public MobileElement pdfPage;
	
	/**分配计划表上的页码*/
	@WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
	@iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[2]")
	public MobileElement pdfPageNo;


}
