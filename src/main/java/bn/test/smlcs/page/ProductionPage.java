package bn.test.smlcs.page;

import java.time.temporal.ChronoUnit;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.WithTimeout;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

/**
 * 产品tab页
 * @date 2019年7月15日 下午3:11:46
 * @author zhaodong
 */
public class ProductionPage {
	
	/**现金管理*/
	@WithTimeout(time = 10 , chronoUnit = ChronoUnit.SECONDS)
	@iOSXCUITFindBy(accessibility = "现金管理")
	public MobileElement xianJinGuanLi;
	
	/**固定收益*/
	@WithTimeout(time = 10 , chronoUnit = ChronoUnit.SECONDS)
	@iOSXCUITFindBy(accessibility = "固定收益")
	public MobileElement guDingShouYi;
	
	/**阳光私募*/
	@WithTimeout(time = 10 , chronoUnit = ChronoUnit.SECONDS)
	@iOSXCUITFindBy(accessibility = "阳光私募")
	public MobileElement yangGuangSiMu;
	
	/**股权投资*/
	@WithTimeout(time = 10 , chronoUnit = ChronoUnit.SECONDS)
	@iOSXCUITFindBy(accessibility = "股权投资")
	public MobileElement guQuanTouZi;
	
	/**海外*/
	@WithTimeout(time = 10 , chronoUnit = ChronoUnit.SECONDS)
	@iOSXCUITFindBy(accessibility = "海外")
	public MobileElement haiWai;
	
	/**搜索框*/
	@WithTimeout(time = 10 , chronoUnit = ChronoUnit.SECONDS)
	@iOSXCUITFindBy(className = "XCUIElementTypeTextField")
	public MobileElement searchBox;
	
	/**手机键盘上的回车键*/
	@WithTimeout(time = 10 , chronoUnit = ChronoUnit.SECONDS)
	@iOSXCUITFindBy(accessibility = "Return")
	public MobileElement returnBtn;
	
	/**判断页面是否有数据元素，通过getText方法获取文本判断，是否包括"下拉可以刷新"文本，包括说明没数据*/
	@WithTimeout(time = 10 , chronoUnit = ChronoUnit.SECONDS)
	@iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeScrollView[-1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable")
	public MobileElement dataContent;
	
	
	/**列表第1条数据*/
	@WithTimeout(time = 10 , chronoUnit = ChronoUnit.SECONDS)
	@iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeScrollView[-1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[1]")
	public MobileElement listFirstOne;
	
	/**产品详情-立即认购按钮*/
	@WithTimeout(time = 10 , chronoUnit = ChronoUnit.SECONDS)
	@iOSXCUITFindBy(accessibility = "立即认购")
	public MobileElement liJiRenGou;
	
	

}
