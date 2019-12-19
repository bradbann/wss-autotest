package bn.test.smlcs.step;

import bn.test.smlcs.page.ZhuanJieShaoPage;
import bn.test.smlcs.util.MobileCommonUtil;
import bn.test.smlcs.util.PageInit;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

/**
 * 转介绍
 * @date 2019年12月4日 下午3:33:37
 * @author zhaodong
 */
public class ZhuanJieShaoStep extends BaseStep {

	ZhuanJieShaoPage zhuanJieShaoPage;
	public int count;
	
	public ZhuanJieShaoStep(AppiumDriver<MobileElement> driver) {
		super(driver);
		zhuanJieShaoPage = new ZhuanJieShaoPage();
		PageInit.initPageElement(driver, zhuanJieShaoPage);
		
	}
	
	/**点击第1个立即认购*/
	public void clickBuyNow(){
		initElement(zhuanJieShaoPage.firstBuyNow).click();
	}
	
	/**点击我的转介绍*/
	public void clickMyZhuanJieShao(){
		initElement(zhuanJieShaoPage.myZhuanJieShao).click();
	}
	
	/**点击在途tb第1笔订单*/
	public void clickZaiTuFirstOne(){
//		count = getZaiTuOrderCount();
//		System.out.println("在途的外部单有："+count);
		initElement(zhuanJieShaoPage.zaiTufirstOne).click();
	}
	
	/**获取在途tab订单的数量*/
	public int getZaiTuOrderCount(){
		int count = zhuanJieShaoPage.zaiTuList.size();
		return count;
	}
	
	/**点击订单撤销*/
	public void clickOrderCancel(){
		initElement(zhuanJieShaoPage.customerType).isDisplayed();
		MobileElement element = zhuanJieShaoPage.orderCancel;
//		initElement(zhuanJieShaoPage.orderCancel).click();
		for (int i = 0; i < 5; i++) {
			if (element.isDisplayed()) {
				element.click();
				break;
			}else {
				MobileCommonUtil.slideNineTenthToOneTenth(driver);
			}
			
		}
	}
	
	
	
	/**验证最后的弹出撤销成功的toast*/
	public boolean result(){
		boolean b = false;
		if ((getZaiTuOrderCount()+1)==count) {
			b = true;
		}
		 return b;
	}
	
	/**验证最后的弹出撤销成功的toast*/
//	public boolean result2(){
//		return initElement(zhuanJieShaoPage.cancelSuccessToast).isDisplayed();
//	}
	
	/** 点击下拉选择开放日*/
	public void selectPublicDate(){
		initElement(zhuanJieShaoPage.publicDate).click();
		initElement(zhuanJieShaoPage.confirmBtn2).click();
	}

	/** 输入认购金额*/
	public void inputMoney(String money){
		initElement(zhuanJieShaoPage.moneyInputBox).sendKeys(money);
		initElement(zhuanJieShaoPage.finishBtn).click();
	}
	
	/**外部单-点击选择期限*/
	public void selectDeadline(){
		initElement(zhuanJieShaoPage.selectDeadline).click();
		initElement(zhuanJieShaoPage.confirmBtn2).click();;
		initElement(zhuanJieShaoPage.deadline).isDisplayed();
	}
	
	/**外部单-点击下拉选择推荐类型*/
	public void selectRecommendType(){
		
		MobileCommonUtil.slideThreeQuarters(driver);
		initElement(zhuanJieShaoPage.recommendType).click();//默认选择无
		initElement(zhuanJieShaoPage.confirmBtn2).click();;
	}
	

}
