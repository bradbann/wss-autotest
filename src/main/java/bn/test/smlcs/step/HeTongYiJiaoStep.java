package bn.test.smlcs.step;

import bn.test.smlcs.page.HeTongYiJiaoPage;
import bn.test.smlcs.util.MobileCommonUtil;
import bn.test.smlcs.util.PageInit;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

/**
 * 合同移交
 * @date 2019年10月17日 下午5:25:06
 * @author zhaodong
 */
public class HeTongYiJiaoStep extends BaseStep {

	
	HeTongYiJiaoPage heTongYiJiaoPage;
	int beforContracts=0;
	int afterContracts=0;
	boolean isExistData;
	public HeTongYiJiaoStep(AppiumDriver<MobileElement> driver) {
		super(driver);
		heTongYiJiaoPage = new HeTongYiJiaoPage();
		PageInit.initPageElement(driver, heTongYiJiaoPage);
	}
	
	/** 判断合同移交查询页是否存在待移交确认数据*/
	public boolean isExistData(){
		boolean b = false;
		String text = initElement(heTongYiJiaoPage.inquire).getText();
		System.out.println("text: "+text);
		if ("".equals(text) || text==null) {
			b = true;
		}
		return b;
	}
	
	/**点击第1条合同数据*/
	public void clickFirstContract(){
		if (isExistData()) {
			beforContracts = heTongYiJiaoPage.contracts.size();
			System.out.println("beforContracts: "+beforContracts);
			heTongYiJiaoPage.contracts.get(0).click();
			isExistData = true;
		}else {
			isExistData = false;
		}
		
		
	}
	
	/** 点击确认按钮*/
	public void clickConfirmBtn(){
		if (isExistData) {
			initElement(heTongYiJiaoPage.confirmBtn).click();
		}
		
	}
	
	/** 点击拒绝按钮*/
	public void clickRefuseBtn(){
		if (isExistData) {
			initElement(heTongYiJiaoPage.confirmBtn).click();
		}
		
	}
	
	/** 确认或拒绝后-获取合同数量*/
	public int getCount(){
		if (isExistData) {
//			MobileCommonUtil.sleep(2000);
			for (int i = 0; i < 10; i++) {
				int y = MobileCommonUtil.getElementPointY(driver, heTongYiJiaoPage.firstOne);
				System.out.println("y: " + y);
				if (y == 119) {
					afterContracts = heTongYiJiaoPage.contracts.size();
					System.out.println("afterContracts: " + afterContracts);
					break;
				} 
				MobileCommonUtil.sleep(1000);
			}
			
				
		}
		
		return afterContracts;
	}
	
	public boolean assertResult(){
		boolean b = false;
		if (!isExistData) {
			b = true;
			System.out.println("移交合同列表无数据");
		}else if (beforContracts-1 == getCount()) {
			b = true;
		}
		return b;
	}
	
	
	
	
	
	

}
