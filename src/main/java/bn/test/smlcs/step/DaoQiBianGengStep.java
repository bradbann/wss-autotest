package bn.test.smlcs.step;

import bn.test.smlcs.page.DaoQiBianGengPage;
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
	String daoQiChuLiType = null;

	public DaoQiBianGengStep(AppiumDriver<MobileElement> driver) {
		super(driver);
		daoQiBianGengPage = new DaoQiBianGengPage();
		PageInit.initPageElement(driver, daoQiBianGengPage);
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
	}
	
	
	/**获取下单完成页成功提示文本*/
	public String getSuccessText(){
		return initElement(daoQiBianGengPage.finishReminder).getText();
	}
	
	
	
	
	
	

}
