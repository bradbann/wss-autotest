package bn.test.smlcs.step;

import java.text.ParseException;

import bn.test.smlcs.page.OrdersFlowPage;
import bn.test.smlcs.util.CommonTools;
import bn.test.smlcs.util.IOSKeyboard;
import bn.test.smlcs.util.MobileCommonUtil;
import bn.test.smlcs.util.PageInit;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

/**
 * 下单流程相关步骤
 * @date 2019年8月21日 下午3:28:03
 * @author zhaodong
 */
public class OrdersFlowStep extends BaseStep{
	
	

	OrdersFlowPage ordersFlowPage;
	private String week;
	
	public OrdersFlowStep(AppiumDriver<MobileElement> driver) {
		super(driver);
		ordersFlowPage = new OrdersFlowPage(); 
		PageInit.initPageElement(driver, ordersFlowPage);
		
	}
	
	/**点击受益账户，如果有多个默认第1个*/
	public void clickFirstAccount(){
		initElement(ordersFlowPage.firstAccount).click();
	}
	
	/**输入产品名称*/
	public void inputProduct(String product){
		String s1 = product.substring(0,product.length()-1);
		String s2 = product.substring(product.length()-1);
		initElement(ordersFlowPage.searchInputBox).sendKeys(s1);
		ordersFlowPage.searchInputBox.sendKeys(s2);
	}
	
	/**点击产品*/
	public void clickProduct(){
		initElement(ordersFlowPage.product).click();
	}
	
	/**选择产品期限-默认选第1个期限的产品*/
	public void clickFirstProductType(){
		initElement(ordersFlowPage.productDeadline).click();
	}
	
	
	/**点击立即认购*/
	public void clickLiJiRenGou(){
		initElement(ordersFlowPage.lijirengou).click();
		
	}
	
	/** 点击下拉选择开放日*/
	public void selectPublicDate(){
		initElement(ordersFlowPage.publicDate).click();
		initElement(ordersFlowPage.finishBtn).click();
	}
	
	/**外部单-点击选择期限*/
	public void selectDeadline(){
		initElement(ordersFlowPage.selectDeadline).click();
		initElement(ordersFlowPage.confirmBtn2).click();
	}
	
	/**外部单-点击下拉选择推荐类型*/
	public void selectRecommendType(){
		
		MobileCommonUtil.slideThreeQuarters(driver);
		initElement(ordersFlowPage.recommendType).click();//默认选择无
		initElement(ordersFlowPage.confirmBtn2).click();
	}
	
	/** 金额输入*/
	public void inputMoney(int money){
		initElement(ordersFlowPage.money).click();
		IOSKeyboard.moneyKeyboard(driver, money);
	}
	
	/** 点击下一步*/
	public void clickNextStep(){
		initElement(ordersFlowPage.nextStep).click();
		
	}
	
	/**定期订单-获取到期日*/
	public void getWeekDay(){
		String text = (ordersFlowPage.daoQiRiText).getText();
		System.out.println(text);
		try {
			week = CommonTools.dateToWeek(text);
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
	}
	
	/** 点击-是-复选框*/
	public void clickYesCheckBox(){
		MobileCommonUtil.slideThreeQuarters(driver);
		initElement(ordersFlowPage.yesCheckBox).click();
	}
	
	/** 点击-否-复选框*/
	public void clickNoCheckBox(){
		
		if (initElement(ordersFlowPage.publicDateText).isDisplayed()) {
			MobileCommonUtil.slideThreeQuarters(driver);
		}
		
		initElement(ordersFlowPage.noCheckBox).click();
	}
	
	
	/** 点击选择推荐类型-默认选择无*/
	public void selectTuiJianType(){
		
		initElement(ordersFlowPage.tuiJianType).click();
		initElement(ordersFlowPage.confirmBtn2).click();
	}
	
	
	/**点击-完成下单按钮*/
	public void clickFinishOrdersBtn(){
		
		
		initElement(ordersFlowPage.finishOrdersBtn).click();
	}
	
	/**点击-弹窗确认按钮*/
	public void clickConfirmBtn(){
		if ("星期六".equals(week) || "星期日".equals(week)) {
			initElement(ordersFlowPage.confirmBtn).click();
		}
//		MobileCommonUtil.sleep(1000);
		if (verifySecondConfirmationBox()) {
			initElement(ordersFlowPage.confirmBtn).click();
		}
		
	}
	
	/**验证下单时是否有二次确认弹框*/
	public boolean verifySecondConfirmationBox(){
		int count = ordersFlowPage.elementsCount.size();
		boolean b = (count > 7)? true : false;
		return b;
	}
	
	
	/** 判断是否下单成功*/
	public boolean isSuccessful(){
		initElement(ordersFlowPage.finishReminder);
		return true;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
