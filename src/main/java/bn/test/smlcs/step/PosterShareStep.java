package bn.test.smlcs.step;

import bn.test.smlcs.page.PosterSharePage;
import bn.test.smlcs.util.PageInit;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

/**
 * 海报分享
 * @date 2019年10月18日 下午4:50:55
 * @author zhaodong
 */
public class PosterShareStep extends BaseStep {

	PosterSharePage posterSharePage;
	public PosterShareStep(AppiumDriver<MobileElement> driver) {
		super(driver);
		posterSharePage = new PosterSharePage();
		PageInit.initPageElement(driver, posterSharePage);
	}
	
	/**点击第1张海报*/
	public void clickFirstPoster(){
		initElement(posterSharePage.firstPoster).click();
	}
	
	/**点击海报下端的rm姓名*/
	public void clickPosterName(){
		initElement(posterSharePage.posterName).click();
	}
	
	/**点击保存图片*/
	public void clickSavePicture(){
		initElement(posterSharePage.savePicture).click();
	}
	
	public String getToastText(){
		return initElement(posterSharePage.saveSuccessToast).getText();
	}
	
	public boolean assertResult(){
		boolean b = false;
		if (posterSharePage.saveSuccessToast.isDisplayed()) {
			b = true;
		}
		System.out.println(b);
		return b;
	}
	
	

}
