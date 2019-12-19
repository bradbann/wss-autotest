package bn.test.smlcs.step;

import bn.test.smlcs.page.HomePage;
import bn.test.smlcs.util.ElementOperation;
import bn.test.smlcs.util.MobileCommonUtil;
import bn.test.smlcs.util.PageInit;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

/**
 * @date 2019年7月15日 下午4:01:22
 * @author zhaodong
 */
public class HomeStep extends BaseStep{
	
	HomePage homePage;
	
	public HomeStep(AppiumDriver<MobileElement> driver) {
		super(driver);
		homePage = new HomePage();
		PageInit.initPageElement(driver, homePage);
		
	}
	
	/** 点击待办任务*/
	public void clickDaibanrenwu(){
		ElementOperation.click(driver, homePage.daibanrenwu);
//		homePage.daibanrenwu.click();
	}
	
	/** 点击我的审批*/
	public void clickWodeshenpi(){
		ElementOperation.click(driver, homePage.wodeshenpi);
	}
	
	/** 点击转发助手*/
	public void clickZhuanfazhushou(){
		homePage.zhuanfazhushou.click();
	}
	
	/** 点击日历*/
	public void clickRili() {
		homePage.rili.click();
	}
	
	/** 点击我的订单*/
	public void clickMyOrder(){
		homePage.button.get(9).click();
	}
	
	/** 点击我要认购*/
	public void clickWoyaorengou() {
		homePage.button.get(10).click();
	}
	
	/** 点击我要赎回*/
	public void clickWoyaoshuhui() {
		homePage.button.get(11).click();
	}
	
	/** 点击产品转换*/
	public void clickChanpinzhuanhuan() {
		
		initElement(homePage.chanpinzhuanhuan).click();
		System.out.println("点击产品转换");
//		homePage.button.get(12).click();
//		homePage.other.get(3).click();
	}
	
	/** 点击到期变更*/
	public void clickDaoQiBianGeng() {
		
		MobileCommonUtil.slideThreeQuarters(driver);
		initElement(homePage.daoQiBianGeng).click();
	}
	
	/** 点击合同移交*/
	public void clickHeTongYiJiao() {
		MobileCommonUtil.slideThreeQuarters(driver);
		initElement(homePage.heTongYiJiao).click();
	}
	
	/** 点击海报分享*/
	public void clickHaibaofenxiang() {
		MobileCommonUtil.slideThreeQuarters(driver);
		initElement(homePage.haiBaoFenXiang).click();
	}
	
	/** 点击资金计划*/
	public void clickFundPlan() {
		MobileCommonUtil.slideThreeQuarters(driver);
		initElement(homePage.fundPlan).click();
	}
	
	/** 点击转介绍*/
	public void clickZhuanjieshao() {
		MobileCommonUtil.slideThreeQuarters(driver);
		initElement(homePage.zhuanJieShao).click();
	}
	
	/** 点击关闭公告弹窗*/
	public void clickNoticePopup(){
		initElement(homePage.noticePopup).click();
	}
	
	/**点击我知道了*/
	public void clickIKnow(){
		System.out.println(homePage.judgeIstooltip.size());
		if (homePage.judgeIstooltip.size()>1) {
			initElement(homePage.iKnow).click();
		}
		
	}
	
	
	
	

}
