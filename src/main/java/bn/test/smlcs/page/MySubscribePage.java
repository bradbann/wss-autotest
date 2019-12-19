package bn.test.smlcs.page;

import java.time.temporal.ChronoUnit;
import java.util.List;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.WithTimeout;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

/**
 * 我要认购
 * @date 2019年8月13日 下午4:07:45
 * @author zhaodong
 */
public class MySubscribePage {

	
	/**title*/
	@WithTimeout(time=10,chronoUnit=ChronoUnit.SECONDS)
	@iOSXCUITFindBy(iOSNsPredicate="value=='我的订单'")
	public MobileElement title;
	
	/**添加客户按钮*/
	@WithTimeout(time=10,chronoUnit=ChronoUnit.SECONDS)
	@iOSXCUITFindBy(accessibility="bar add")
	public MobileElement addCustomerBtn;
	
	/**搜索输入框*/
	@WithTimeout(time=10,chronoUnit=ChronoUnit.SECONDS)
	@iOSXCUITFindBy(className="XCUIElementTypeSearchField")
	public MobileElement searchInputBox;
	
	/**客户列表-只展示1条客户数据，通过精确搜索后的客户*/
	@WithTimeout(time=10,chronoUnit=ChronoUnit.SECONDS)
	@iOSXCUITFindBy(className="XCUIElementTypeCell")
	public MobileElement customer;
	
	/**客户列表是否有数据判断，获取该元素的属性值，如果是‘空列表’，那说明就没有客户*/
	@WithTimeout(time=10,chronoUnit=ChronoUnit.SECONDS)
	@iOSXCUITFindBy(className="XCUIElementTypeTable")
	public MobileElement typeTable;
	
	/**客户列表-展示客户数据列表*/
	@WithTimeout(time=10,chronoUnit=ChronoUnit.SECONDS)
	@iOSXCUITFindBy(className="XCUIElementTypeCell")
	public List<MobileElement> customers;
	
	/**键盘上的‘搜索’按钮*/
	@WithTimeout(time=10,chronoUnit=ChronoUnit.SECONDS)
	@iOSXCUITFindBy(accessibility="Search")
	public MobileElement searchBtn;
	
	/**点击添加客户按钮的提示框，提示文本“”*/
	@WithTimeout(time=10,chronoUnit=ChronoUnit.SECONDS)
	@iOSXCUITFindBy(accessibility="请选择需要创建的客户类型")
	public MobileElement hint;
	
	/**提示框-个人按钮*/
	@WithTimeout(time=10,chronoUnit=ChronoUnit.SECONDS)
	@iOSXCUITFindBy(accessibility="个人")
	public MobileElement personal;
	
	/**提示框-企业机构按钮*/
	@WithTimeout(time=10,chronoUnit=ChronoUnit.SECONDS)
	@iOSXCUITFindBy(accessibility="企业/机构")
	public MobileElement enterprise;
	
	/**提示框-取消按钮*/
	@WithTimeout(time=10,chronoUnit=ChronoUnit.SECONDS)
	@iOSXCUITFindBy(accessibility="取消")
	public MobileElement cancel;
	
	
	
	
}
