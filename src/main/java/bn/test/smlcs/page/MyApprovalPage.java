package bn.test.smlcs.page;

import java.time.temporal.ChronoUnit;
import java.util.List;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.WithTimeout;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

/**
 * 我的审批页
 * @date 2019年8月12日 下午12:05:30
 * @author zhaodong
 */
public class MyApprovalPage {
	
	
	/**title*/
	@WithTimeout(time=10,chronoUnit=ChronoUnit.SECONDS)
	@iOSXCUITFindBy(iOSNsPredicate="value=='审批'")
	public MobileElement title;
	
	/**搜索*/
	@WithTimeout(time=10,chronoUnit=ChronoUnit.SECONDS)
	@iOSXCUITFindBy(accessibility="搜索")
	public MobileElement search;
	
	/**待审批*/
	@WithTimeout(time=10,chronoUnit=ChronoUnit.SECONDS)
	@iOSXCUITFindBy(accessibility="待审批")
	public MobileElement daiShenPi;
	
	/**已审批*/
	@WithTimeout(time=10,chronoUnit=ChronoUnit.SECONDS)
	@iOSXCUITFindBy(accessibility="已审批")
	public MobileElement yiShenPi;
	
	/**审批任务列表，包含待审批和已审批*/
	@WithTimeout(time=10,chronoUnit=ChronoUnit.SECONDS)
	@iOSXCUITFindBy(iOSClassChain="**/XCUIElementTypeTable/XCUIElementTypeCell")
	public List<MobileElement> shenPiList;
	
	/**待审批或已审批，如果该菜单下没有数据，name属性会返回‘空列表’文本*/
	@iOSXCUITFindBy(iOSClassChain="**/XCUIElementTypeTable")
	public MobileElement emptyList;
	

}
