package bn.test.smlcs.step;

import bn.test.smlcs.page.SetGesturePasswordPage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

/**
 * @date 2019年4月11日 下午2:19:22
 * @author zhaodong
 */
public class SetGesturePasswordStep {
	
	public SetGesturePasswordPage setGesturePasswordPage;
	public LoginUnlockStep loginUnlockStep;
	
	public SetGesturePasswordStep(AppiumDriver<MobileElement> driver) {
		setGesturePasswordPage = new SetGesturePasswordPage(driver);
		loginUnlockStep = new LoginUnlockStep(driver);
		
	}
	
	/**设置手势密码*/
	public void setGesturePassword(){
		try {
			setGesturePasswordPage.setGesturePageTitle.isDisplayed();
			loginUnlockStep.gesturenlock();
			loginUnlockStep.gesturenlock();
			
		} catch (Exception e) {
			
			System.out.println("设置手势密码失败");
		}
		
	}
	

}
