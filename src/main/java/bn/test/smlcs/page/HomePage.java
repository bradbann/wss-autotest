package bn.test.smlcs.page;

import java.time.temporal.ChronoUnit;
import java.util.List;

import org.openqa.selenium.WebElement;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.WithTimeout;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

/**
 * @date 2019年7月15日 下午3:11:46
 * @author zhaodong
 */
public class HomePage {
	
	
	
	/**待办任务*/
	@WithTimeout(time =10, chronoUnit = ChronoUnit.SECONDS)
	@iOSXCUITFindBy(iOSClassChain="**/XCUIElementTypeButton[6]")
	public MobileElement daibanrenwu;
	
	
	/**
	 * 我的审批
	 */
	@WithTimeout(time =10, chronoUnit = ChronoUnit.SECONDS)
	@iOSXCUITFindBy(iOSClassChain="**/XCUIElementTypeButton[7]")
	public MobileElement wodeshenpi;
	
	/**
	 * 转发助手
	 */
	@WithTimeout(time =10, chronoUnit = ChronoUnit.SECONDS)
	@iOSXCUITFindBy(iOSClassChain="**/XCUIElementTypeButton[8]")
	public MobileElement zhuanfazhushou;
	
	
	/**产品转换*/
	@WithTimeout(time =20, chronoUnit = ChronoUnit.SECONDS)
	@iOSXCUITFindBy(iOSClassChain="**/XCUIElementTypeButton[13]")
	public MobileElement chanpinzhuanhuan;
	
	/**到期变更*/
	@WithTimeout(time =20, chronoUnit = ChronoUnit.SECONDS)
	@iOSXCUITFindBy(iOSClassChain="**/XCUIElementTypeButton[14]")
	public MobileElement daoQiBianGeng;
	
	/**合同移交*/
	@WithTimeout(time =20, chronoUnit = ChronoUnit.SECONDS)
	@iOSXCUITFindBy(iOSClassChain="**/XCUIElementTypeButton[15]")
	public MobileElement heTongYiJiao;
	
	/**海报分享*/
	@WithTimeout(time =20, chronoUnit = ChronoUnit.SECONDS)
	@iOSXCUITFindBy(iOSClassChain="**/XCUIElementTypeButton[16]")
	public MobileElement haiBaoFenXiang;
	
	/**资金计划*/
	@WithTimeout(time =20, chronoUnit = ChronoUnit.SECONDS)
	@iOSXCUITFindBy(iOSClassChain="**/XCUIElementTypeButton[17]")
	public MobileElement fundPlan;
	
	/**转介绍*/
	@WithTimeout(time =20, chronoUnit = ChronoUnit.SECONDS)
	@iOSXCUITFindBy(iOSClassChain="**/XCUIElementTypeButton[18]")
	public MobileElement zhuanJieShao;
	
	/**
	 * 日历
	 */
	@WithTimeout(time =10, chronoUnit = ChronoUnit.SECONDS)
//	@iOSXCUITFindBy(xpath="//XCUIElementTypeApplication[@name='私募理财师']/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther[3]/XCUIElementTypeButton[4]")
	@iOSXCUITFindBy(iOSClassChain="**/XCUIElementTypeButton[9]")
	public MobileElement rili;
	

	/**
	 * 待办任务-转介绍，从下标5开始
	 * [5]待办任务；[6]我的审批；[7]转发助手；[8]日历；[9]我的订单；[10]我要认购; [11]我要赎回; [12]产品转换; [13]到期变更；[14]海边分享；[15]资金计划；[16]转介绍
	 */
	@WithTimeout(time =10, chronoUnit = ChronoUnit.SECONDS)
	@iOSXCUITFindBy(iOSClassChain="**/XCUIElementTypeButton")
	public List<WebElement> button;
	
	/**我知道按钮，问题登记提示框*/
	@WithTimeout(time =10, chronoUnit = ChronoUnit.SECONDS)
	@iOSXCUITFindBy(accessibility = "我知道了")
	public MobileElement iKnow;
	
	
	/**判断是否有问题登记的弹窗提示*/
	@WithTimeout(time =10, chronoUnit = ChronoUnit.SECONDS)
	@iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeWindow[1]/XCUIElementTypeOther")
	public List<MobileElement> judgeIstooltip;
	
	
	/**进入首页后弹出的合规公告-提示到11月9日*/
	@WithTimeout(time =10, chronoUnit = ChronoUnit.SECONDS)
	@iOSXCUITFindBy(accessibility = "已知晓，并严格按照规定执行")
	public MobileElement noticePopup;

}
