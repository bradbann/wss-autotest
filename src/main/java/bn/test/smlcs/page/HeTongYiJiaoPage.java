package bn.test.smlcs.page;

import java.time.temporal.ChronoUnit;
import java.util.List;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.WithTimeout;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

/**
 * 
 * 合同移交
 * @date 2019年10月16日 下午5:06:01
 * @author zhaodong
 */
public class HeTongYiJiaoPage {

	/** 合同移交列表,查询所有待确认数据 */
	@WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
	@iOSXCUITFindBy(className = "XCUIElementTypeCell")
	public List<MobileElement> contracts;
	
	
	/** 确认按钮 */
	@WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
	@iOSXCUITFindBy(accessibility = "确认")
	public MobileElement confirmBtn;

	/** 拒绝按钮 */
	@WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
	@iOSXCUITFindBy(accessibility = "拒绝")
	public MobileElement refuse;
	
	/** 合同移交查询页，用于判断页面是否有合同数据*/
	@WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
	@iOSXCUITFindBy(className = "XCUIElementTypeTable")
	public MobileElement inquire;
	
	//XCUIElementTypeOther/XCUIElementTypeTable
	//下拉可以刷新, 最后更新：今天 17:00, 已经全部加载完毕
	
	
	
	
	
}
