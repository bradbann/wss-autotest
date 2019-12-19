package bn.test.smlcs.page;

import java.time.temporal.ChronoUnit;
import java.util.List;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.WithTimeout;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

/**
 * 我的订单页
 * @date 2019年8月13日 上午10:52:04
 * @author zhaodong
 */
public class MyOrderPage {

	//======================我的订单页======================================
	/**title*/
	@WithTimeout(time=10,chronoUnit=ChronoUnit.SECONDS)
	@iOSXCUITFindBy(iOSNsPredicate="value=='我的订单'")
	public MobileElement title;
	
	/**搜索*/
	@WithTimeout(time=10,chronoUnit=ChronoUnit.SECONDS)
	@iOSXCUITFindBy(accessibility = "搜索")
	public MobileElement search;
	
	/**订单撤销*/
	@WithTimeout(time=10,chronoUnit=ChronoUnit.SECONDS)
	@iOSXCUITFindBy(accessibility = "订单撤销")
	public  MobileElement orderRevocation;
	
	//======================搜索页======================================
	
	/**订单状态-待修改*/
	@WithTimeout(time=10,chronoUnit=ChronoUnit.SECONDS)
	@iOSXCUITFindBy(accessibility = "待修改")
	public MobileElement daiXiuGai;
	
	/**订单状态-审核中*/
	@WithTimeout(time=10,chronoUnit=ChronoUnit.SECONDS)
	@iOSXCUITFindBy(accessibility = "审核中")
	public MobileElement shenHeZhong;
	
	/**订单状态-待补录*/
	@WithTimeout(time=10,chronoUnit=ChronoUnit.SECONDS)
	@iOSXCUITFindBy(accessibility = "待补录")
	public MobileElement daiBuLu;
	
	/**确定*/
	@WithTimeout(time=10,chronoUnit=ChronoUnit.SECONDS)
	@iOSXCUITFindBy(accessibility = "确定")
	public MobileElement confirmBtn;
	
	/**搜索结果，判断是否结果页是否有数据，通过list个数判断，如果是2则有数据*/
	@WithTimeout(time=10,chronoUnit=ChronoUnit.SECONDS)
	@iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/*")
	public List<MobileElement> searchResult;
	
	/**搜索结果-第1条数据*/
	@WithTimeout(time=10,chronoUnit=ChronoUnit.SECONDS)
	@iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[1]")
	public MobileElement resultFirstOne;
	
	
	
	
}
