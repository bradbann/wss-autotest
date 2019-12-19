package bn.test.smlcs.step;

import bn.test.smlcs.page.ProductionPage;
import bn.test.smlcs.util.MobileCommonUtil;
import bn.test.smlcs.util.PageInit;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

/**
 * 产品tab step
 * @date 2019年12月12日 上午11:34:20
 * @author zhaodong
 */
public class ProductionStep extends BaseStep {

	ProductionPage productionPage;
	
	public ProductionStep(AppiumDriver<MobileElement> driver) {
		super(driver);
		productionPage = new ProductionPage();
		PageInit.initPageElement(driver, productionPage);
	}
	
	/**点击现金管理*/
	public void clickXianJinGuanLi(){
		initElement(productionPage.xianJinGuanLi).click();
	}
	
	/**点击固定收益*/
	public void clickGuDingShouYi(){
		initElement(productionPage.guDingShouYi).click();
	}
	
	/**点击阳光私募*/
	public void clickYangGuangSiMu(){
		initElement(productionPage.yangGuangSiMu).click();
	}
	
	/**点击股权投资*/
	public void clickGuQuanTouZi() {
		initElement(productionPage.guQuanTouZi).click();
	}
	
	/**点击海外*/
	public void clickHaiWai(){
//		int high = getElemenGetY();
//		System.out.println(high);
//		Point center = initElement(productionPage.guQuanTouZi).getCenter();
//		System.out.println("center-y : "+center.y);
		MobileCommonUtil.slideRightToLeftThreeQuarters(driver, initElement(productionPage.guQuanTouZi));
		initElement(productionPage.haiWai).click();
		
	}
	
	/**获取元素坐标的高度位置*/
	public int getElemenGetY(){
		return initElement(productionPage.guQuanTouZi).getLocation().getY();
		
	}
	
	/**输入搜索内容*/
	public void inputSerachBox(String text){
		initElement(productionPage.searchBox).sendKeys(text);
	}
	
	/**点击手机键盘上的回车键*/
	public void clickReturnBtn(){
		initElement(productionPage.returnBtn).click();
	}
	
	/**获取元素文本，通过文本判断页面是否有数据*/
	public String getText(){
		String text = initElement(productionPage.dataContent).getText();
		System.out.println(text);
		return text;
	}
	
	/**点击列表第1条数据*/
	public void clickListFirstOne(){
		initElement(productionPage.listFirstOne).click();
	}
	
	public boolean result(){
		if (getText().contains("下拉可以刷新")) {
			return true;
		}else {
			return false;
		}
	}
	
	/**立即认购按钮是否显示*/
	public boolean isDisplayedLiJiRenGou(){
		return productionPage.liJiRenGou.isDisplayed();
	}

	
	
}
