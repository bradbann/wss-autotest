package bn.test.smlcs.step;

import bn.test.smlcs.page.FundPlanPage;
import bn.test.smlcs.util.MobileCommonUtil;
import bn.test.smlcs.util.PageInit;
import bn.test.smlcs.util.ScreenShot;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

/**
 * @date 2019年11月4日 上午10:33:39
 * @author zhaodong
 */
public class FundPlanStep extends BaseStep{

	FundPlanPage fundPlanPage;
	public FundPlanStep(AppiumDriver<MobileElement> driver) {
		super(driver);
		fundPlanPage = new FundPlanPage();
		PageInit.initPageElement(driver, fundPlanPage);
		
	}
	
	/**点击搜索框*/
	public void clickSearchBox(){
		
		initElement(fundPlanPage.searchBox).click();
	}
	
	/**勾选全部复选框*/
	public void clickAllCheckBox(){
		initElement(fundPlanPage.all).click();
	}
	
	/**点击确定*/
	public void clickConfirm(){
		initElement(fundPlanPage.confirm).click();
	}
	
	/**点击分享按钮*/
	public void clickShareBtn(){
		initElement(fundPlanPage.firstFundPlan).isDisplayed();
		initElement(fundPlanPage.share).click();
		
	}
	
	/**勾选第1条资金计划*/
	public void clickFirstCheckBox(){
		initElement(fundPlanPage.firstCheckBox).click();
	}
	
	/**点击分享icon*/
	public void clickShareIcon(){
		initElement(fundPlanPage.shareIcon).click();
	}
	
	public void fundPlanPDF(){
		MobileCommonUtil.sleep(3000);
		MobileElement element = initElement(fundPlanPage.pdfPage);
		try {
			ScreenShot.captureElement(element);
			System.out.println("截图成功");
		} catch (Exception e) {
			System.out.println("截图失败");
			e.printStackTrace();
		}
	}
	
	/**判断分享列表中是否有微信*/
	public boolean isDisplayWechat(){
		return initElement(fundPlanPage.shareWechat).isDisplayed();
	}
	

	
	
	
	
	
	
	
	
	
	
	
	

}
