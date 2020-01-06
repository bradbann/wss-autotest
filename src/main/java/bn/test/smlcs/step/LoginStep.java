package bn.test.smlcs.step;

import bn.test.smlcs.page.CommonPage;
import bn.test.smlcs.page.HomePage;
import bn.test.smlcs.page.LoginPage;
import bn.test.smlcs.page.LoginUnlockPage;
import bn.test.smlcs.page.SetGesturePasswordPage;
import bn.test.smlcs.util.ElementOperation;
import bn.test.smlcs.util.IOSKeyboard;
import bn.test.smlcs.util.PageInit;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;

/**
 * @date 2018年1月24日 上午10:19:08
 * @author zhaodong
 */
public class LoginStep {

	LoginPage loginPage;
	LoginUnlockPage loginUnlockPage;
	AppiumDriver<MobileElement> driver;
	CommonPage commonPage;
	LoginUnlockStep loginUnlockStep;
	SetGesturePasswordStep setGesturePasswordStep;
	SetGesturePasswordPage setGesturePasswordPage;
	HomePage homePage;
	HomeStep homeStep;
	CommonStep commonStep;

	public LoginStep(AppiumDriver<MobileElement> driver) {
		this.driver = driver;
		loginPage = new LoginPage();
		loginUnlockPage = new LoginUnlockPage();
		commonPage = new CommonPage();
		loginUnlockStep = new LoginUnlockStep(driver);
		setGesturePasswordStep = new SetGesturePasswordStep(driver);
		commonStep = new CommonStep(driver);
		homeStep = new HomeStep(driver);
		homePage = new HomePage();
		PageInit.initPageElement(driver, loginPage,loginUnlockPage,commonPage,homePage);
	}
	
	public MobileElement initElement(MobileElement element){
		return ElementOperation.initElement(driver, element);
		
	}

	/** 输入登录账号 */
	public void inputUsername(String username) {
		initElement(loginPage.username);
		ElementOperation.input(loginPage.username, username);
	}

	/** 输入登录密码 */
	public void inputPassword() {
		System.out.println("loginPage.password是："+loginPage.password);
		loginPage.password.click();
		IOSKeyboard iosKeyboard = new IOSKeyboard();
		try {
			iosKeyboard.passwordKeyboard((IOSDriver<MobileElement>) driver, "q");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/** 输入登录密码 */
	public void inputPassword2(String password) {
		ElementOperation.input(loginPage.password2, password);
//		loginPage.password2.clearAndInput("a12345");
	}

	/** 点击登录按钮 */
	public void clickLoginBtn() {
		loginPage.loginBtn.click();
	}

	/** 点击忘记密码 */
	public void clickForgetPassword() {
		loginPage.forgetPassword.click();
	}

	/** 隐藏密码-可见密码 */
	public void clickNoseePassword() {
		loginPage.noseePassword.click();
	}

	/**使用用户名和密码登录*/
	public void userPasswordLogin(String username,String password){
		initElement(loginUnlockPage.changeLoginType).click();
		String value = initElement(loginPage.username).getAttribute("value");
		System.out.println("usernameInput: "+value);
		inputUsername(username);
		inputPassword();
		clickLoginBtn();
		if (!username.equals(value)) {
			loginUnlockStep.gesturenlock();
			loginUnlockStep.gesturenlock();
		}
		
	}
	
	/** 此方法为统一登录功能，不用考虑是手势登录或是账号密码登录 */
	public void unifyLoginFunction(String username) {
		System.out.println("commonPage.forget是："+commonPage.forget);
		String text = ElementOperation.getElementText(driver, commonPage.forget);
		if ("忘记手势密码".equals(text)) {
			loginUnlockStep.gesturenlock();
			int count = commonPage.prompt.size();
			if (count>4) {
				ElementOperation.click(driver, commonPage.confirm);
//				commonPage.confirm.click();
//				MobileCommonUtil.sleep(3000);
				inputUsername(username);
				inputPassword();
				clickLoginBtn();
			}
		} else if ("忘记密码".equals(text)) {
			inputUsername(username);
			inputPassword();
			clickLoginBtn();
			//如果在设置手势密码页面，就设置手势密码
			
			if (ElementOperation.getVisibleElement(driver, commonPage.setGesturePassword).isDisplayed()) {
				System.out.println("第1次设置手势密码");
				loginUnlockStep.gesturenlock();
				System.out.println("第2次设置手势密码");
				loginUnlockStep.gesturenlock();
				
			}
		}
		commonStep.waitUploadIsNotDisplay();
		homeStep.clickIKnow();
//		initElement(homePage.noticePopup).click();

	}
	
	
	
	
	

}
