package bn.test.smlcs.step;

import bn.test.smlcs.page.DaoQiBianGengPage;
import bn.test.smlcs.page.OrderCancelPage;
import bn.test.smlcs.util.MobileCommonUtil;
import bn.test.smlcs.util.PageInit;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

/**
 * 到期变更
 * 
 * @date 2019年10月15日 下午3:49:54
 * @author zhaodong
 */
public class DaoQiBianGengStep extends BaseStep {

	DaoQiBianGengPage daoQiBianGengPage;
	OrderCancelPage orderCancelPage;
	String daoQiChuLiType = null;

	public DaoQiBianGengStep(AppiumDriver<MobileElement> driver) {
		super(driver);
		daoQiBianGengPage = new DaoQiBianGengPage();
		orderCancelPage = new OrderCancelPage();
		PageInit.initPageElement(driver, daoQiBianGengPage,orderCancelPage);
	}

	/** 点击-右上角的‘+’加号 */
	public void clickAddBtn() {
		initElement(daoQiBianGengPage.addBtn).click();
	}

	/** 输入客户到客户搜索框 */
	public void inputCustomerSearchBox(String customer) {

		initElement(daoQiBianGengPage.customerSearchBox).click();
		System.out.println("点击客户输入框");
		daoQiBianGengPage.customerSearchBox.sendKeys(customer);

	}

	/** 点击客户 */
	public void clickCustomer() {
		initElement(daoQiBianGengPage.customer).click();
	}
	
	/** 点击第1个产品*/
	public void clickFirstProduct(){
		initElement(daoQiBianGengPage.firstProduct).click();
		
	}
	
	/** 获取当前选择的处理方式*/
	public String getCurrentType(){
		return initElement(daoQiBianGengPage.currentType).getAttribute("value");
	}
	
	/** 选择到期处理方式,默认选择的第1个方式*/
	public void selectDaoQiChuLiType(){
		initElement(daoQiBianGengPage.daoQiChuLi).click();
		daoQiChuLiType = initElement(daoQiBianGengPage.currentType).getAttribute("value");
		System.out.println("选择的到期处理方式： "+daoQiChuLiType);
		daoQiBianGengPage.finishBtn.click();
	}
	
	/** 选择收益分配方式*/
	public boolean selectShouYiFenPeiType(){
		boolean type = false;
		if (!"到期自动赎回".equals(daoQiChuLiType)) {
			initElement(daoQiBianGengPage.shouYiFenPei).click();
			daoQiBianGengPage.finishBtn.click();
			type = true;
		}
		return type;
	}
	
	/**点击下一步*/
	public void clickNextStep(){
		initElement(daoQiBianGengPage.nextStep).click();
	}
	
	/**点击完成下单*/
	public void clickFinishOrder(){
		initElement(daoQiBianGengPage.finishOrder).click();
		
		System.out.println(daoQiBianGengPage.isDialog.size());
		
		
		if (daoQiBianGengPage.isDialog.size() > 1) {
			//判断是否有加载图标
			for (int i = 0; i < 8; i++) {
				if (daoQiBianGengPage.isDialog2.size() > 2) {
					System.out.println("等等加载图标消失");
					MobileCommonUtil.sleep(1000);
				}else{
					break;
				}
				
			}
			if (daoQiBianGengPage.isDialog.size() > 1) {
				initElement(daoQiBianGengPage.confirmBtn).click();
			}
			
		}
		
	}
	
	
	/**获取下单完成页成功提示文本*/
	public String getSuccessText(){
		return initElement(daoQiBianGengPage.finishReminder).getText();
	}
	
	/**点击搜索框*/
	public void clickSearchField(){
//		MobileElement element = initElement(daoQiBianGengPage.zaiTu);
		MobileElement element = daoQiBianGengPage.searchField;
		int y = MobileCommonUtil.getElementPointY(driver, element);
		int x = MobileCommonUtil.getElementPointX(driver, element);
		
		System.out.println("Y: "+y);
		System.out.println("x: "+x);
//		y = y+50;
		System.out.println("Y: "+y);
		MobileCommonUtil.tapPoint(driver, x, y);
//		daoQiBianGengPage.searchField.click();
	}
	
	/**搜索页-输入客户名称，并点击手机键盘完成按钮收起键盘*/
	public void inputSearchPageCustomer(String customer){
		initElement(daoQiBianGengPage.customerInput).sendKeys(customer);
		initElement(daoQiBianGengPage.keyboardFinish).click();
	}
	
	/**待修改*/
	public void clickDaiXiuGai(){
		initElement(daoQiBianGengPage.daiXiuGai).click();
	}
	
	/**点击待上传影像*/
	public void clickDaiShangChuanYingXiang(){
		initElement(daoQiBianGengPage.daiShangChuanYingXiang).click();
	}
	
	/**点击待审批*/
	public void clickDaiShenPi(){
		initElement(daoQiBianGengPage.daiSehenPi).click();
	}
	
	/**点击待审核*/
	public void clickDaiShenHe(){
		initElement(daoQiBianGengPage.daiSehenHe).click();
	}
	
	/**点击确定*/
	public void clickConfirm(){
		initElement(daoQiBianGengPage.confirmBtn2).click();
	}
	
	/**点击搜索结果页第1条数据*/
	public void clickFirstOne(){
		initElement(daoQiBianGengPage.resultFirstOne).click();
	}
	
	/**点击取消变更按钮*/
	public void clickCancelChange(){
		initElement(daoQiBianGengPage.customerText);
		MobileCommonUtil.slideThreeQuarters(driver);
		initElement(daoQiBianGengPage.cancelChange).click();
	}
	
	/**输入撤销原因*/
	public void inputCause(){
		initElement(orderCancelPage.causeInputBox).sendKeys("测试");
	}
	
	/**点击页面文本，收起键盘*/
	public void clickText(){
		initElement(orderCancelPage.pageText).click();
	}
	
	/**点击确认撤销操作*/
	public void clickConfirmCancel(){
		clickText();
		initElement(orderCancelPage.confirmCancel).click();
	}
	
	
	
	/**验证结果，跳转到期变更页*/
	public boolean result(){
		return daoQiBianGengPage.title.isDisplayed();
	}
	
	

}
