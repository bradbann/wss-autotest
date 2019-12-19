package bn.test.smlcs.util;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.NoSuchElementException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.touch.offset.PointOption;

/**
 * IOS 输入键盘坐标操作
 * 
 * @author jasonzhang 2017年4月17日 上午10:53:44
 *
 */
@Component
public class IOSKeyboard {

	private static Logger logger = LoggerFactory.getLogger(IOSKeyboard.class);

	private final int KeyBoard_Height_216 = 218; // 5s
	private final int KeyBoard_Height_236 = 236; // 6
	private final int KeyBoard_Height_260 = 260; // plus

	public enum Device {
		iPhone5(320, 568), iPhone6(375, 667), iPhone_Plus(414, 736);
		/**
		 * @param xPixel
		 * @param yPixel
		 */
		private Device(int xPixel, int yPixel) {
			this.xPixel = xPixel;
			this.yPixel = yPixel;
		}

		int xPixel;
		int yPixel;

		public int getxPixel() {
			return xPixel;
		}

		public void setxPixel(int xPixel) {
			this.xPixel = xPixel;
		}

		public int getyPixel() {
			return yPixel;
		}

		public void setyPixel(int yPixel) {
			this.yPixel = yPixel;
		}

	}

	/**
	 * 数字键盘(手机号、短信验证码、交易密码)
	 * 
	 * @param driver
	 * @param text
	 * @param phoneEditeText
	 *            手机号编辑区控件(若不需要调起键盘，则传null)
	 * @throws ATPException
	 */
	@SuppressWarnings("rawtypes")
	public void numberKeyboard(IOSDriver<MobileElement> driver, String text, MobileElement phoneEditeText)
			throws Exception {
		logger.info("driver:#{}, phone:#{}, phoneEditeText:#{}", driver, text, phoneEditeText);
		if (text == null || text.equals("")) {
			throw new Exception("method:numberKeyboard's arg 'text' can't be null!");
		}

		if (driver == null)
			throw new Exception("driver不能为null");

		if (phoneEditeText != null)
			phoneEditeText.click();

		int deviceWidth = MobileCommonUtil.getScreenWidth(driver);
		int deviceHeight = MobileCommonUtil.getScreenHeight(driver);

		int keyboardHeight = confirmDevice(deviceWidth, deviceHeight);

		logger.info("deviceWidth:#{}, deviceHeight:#{}, keyboardHeight:#{}", deviceWidth, deviceHeight, keyboardHeight);

		// 获取数字键盘所有位数坐标
		Map<String, int[]> phoneMap = new HashMap<>();
		phoneMap.put("1", new int[] { deviceWidth * 1 / 6, (deviceHeight - keyboardHeight + keyboardHeight * 1 / 8) });
		phoneMap.put("2", new int[] { deviceWidth * 3 / 6, (deviceHeight - keyboardHeight + keyboardHeight * 1 / 8) });
		phoneMap.put("3", new int[] { deviceWidth * 5 / 6, (deviceHeight - keyboardHeight + keyboardHeight * 1 / 8) });
		phoneMap.put("4", new int[] { deviceWidth * 1 / 6, (deviceHeight - keyboardHeight + keyboardHeight * 3 / 8) });
		phoneMap.put("5", new int[] { deviceWidth * 3 / 6, (deviceHeight - keyboardHeight + keyboardHeight * 3 / 8) });
		phoneMap.put("6", new int[] { deviceWidth * 5 / 6, (deviceHeight - keyboardHeight + keyboardHeight * 3 / 8) });
		phoneMap.put("7", new int[] { deviceWidth * 1 / 6, (deviceHeight - keyboardHeight + keyboardHeight * 5 / 8) });
		phoneMap.put("8", new int[] { deviceWidth * 3 / 6, (deviceHeight - keyboardHeight + keyboardHeight * 5 / 8) });
		phoneMap.put("9", new int[] { deviceWidth * 5 / 6, (deviceHeight - keyboardHeight + keyboardHeight * 5 / 8) });
		phoneMap.put("0", new int[] { deviceWidth * 3 / 6, (deviceHeight - keyboardHeight + keyboardHeight * 7 / 8) });
		phoneMap.put("delete", new int[] { deviceWidth * 5 / 6, (deviceHeight - keyboardHeight + keyboardHeight * 7 / 8) });

		// 如果手机号有内容，先删除
		if (phoneEditeText != null && !phoneEditeText.getText().equals("") && phoneEditeText.getText().matches("[0-9]*")) {
			logger.info("Delete original phoneNum");
			try {
				driver.findElementByAccessibilityId("清除文本").click();
			} catch (NoSuchElementException e) {
				logger.error("清除文本按钮没有找到：-->"+e.getMessage());
				int length = phoneEditeText.getText().length();
				for (int i = 0; i < length; i++) {
					new TouchAction(driver).tap(PointOption.point(phoneMap.get("delete")[0], phoneMap.get("delete")[1])).perform();
				}
				
			}
			
		}

		// 输入手机号
		String key = "";
		for (int i = 0; i < text.length(); i++) {
			logger.info("input original phoneNum");
			key = String.valueOf(text.charAt(i));
			new TouchAction(driver).tap(PointOption.point(phoneMap.get(key)[0], phoneMap.get(key)[1])).perform();
		}

	}

	private int confirmDevice(int deviceWidth, int deviceHeight) throws Exception {
		if (deviceWidth == Device.iPhone5.xPixel && deviceHeight == Device.iPhone5.yPixel) {
			return KeyBoard_Height_216;
		}
		if (deviceWidth == Device.iPhone6.xPixel && deviceHeight == Device.iPhone6.yPixel) {
			return KeyBoard_Height_236;
		}
		if (deviceWidth == Device.iPhone_Plus.xPixel && deviceHeight == Device.iPhone_Plus.yPixel) {
			return KeyBoard_Height_260;
		} else {
			throw new Exception("未兼容的设备");
		}
	}

	/**
	 * 登录密码键盘(a~z 0~9 暂不支持大写，删除键)
	 * 
	 * @param driver
	 * @param password
	 * @throws ATPException
	 */
	@SuppressWarnings("rawtypes")
	public void passwordKeyboard(IOSDriver<MobileElement> driver, String password) throws Exception {
//		if (driver == null || password.length() < 6) {
//			logger.warn("driver:#{}, password:#{}", driver, password);
//			throw new Exception("driver不能为null|密码长度不能小于6位");
//		}

		int deviceWidth = driver.manage().window().getSize().width;
		int deviceHeight = driver.manage().window().getSize().height;
		//iPhone5(320, 568) 
		int keyboardHeight = confirmDevice(deviceWidth, deviceHeight);
		//216 352
		logger.info("deviceWidth:#{}, deviceHeight:#{}, keyboardHeight:#{}", deviceWidth, deviceHeight, keyboardHeight);
		Map<String, int[]> loginPasswordMap = new HashMap<>();
		loginPasswordMap.put("q", new int[] { deviceWidth * 1 / 20, (deviceHeight - keyboardHeight + keyboardHeight * 1 / 8) });
		loginPasswordMap.put("w", new int[] { deviceWidth * 3 / 20, (deviceHeight - keyboardHeight + keyboardHeight * 1 / 8) });
		loginPasswordMap.put("e", new int[] { deviceWidth * 5 / 20, (deviceHeight - keyboardHeight + keyboardHeight * 1 / 8) });
		loginPasswordMap.put("r", new int[] { deviceWidth * 7 / 20, (deviceHeight - keyboardHeight + keyboardHeight * 1 / 8) });
		loginPasswordMap.put("t", new int[] { deviceWidth * 9 / 20, (deviceHeight - keyboardHeight + keyboardHeight * 1 / 8) });
		loginPasswordMap.put("y", new int[] { deviceWidth * 11 / 20, (deviceHeight - keyboardHeight + keyboardHeight * 1 / 8) });
		loginPasswordMap.put("u", new int[] { deviceWidth * 13 / 20, (deviceHeight - keyboardHeight + keyboardHeight * 1 / 8) });
		loginPasswordMap.put("i", new int[] { deviceWidth * 15 / 20, (deviceHeight - keyboardHeight + keyboardHeight * 1 / 8) });
		loginPasswordMap.put("o", new int[] { deviceWidth * 17 / 20, (deviceHeight - keyboardHeight + keyboardHeight * 1 / 8) });
		loginPasswordMap.put("p", new int[] { deviceWidth * 19 / 20, (deviceHeight - keyboardHeight + keyboardHeight * 1 / 8) });
		loginPasswordMap.put("a", new int[] { deviceWidth * 2 / 20, (deviceHeight - keyboardHeight + keyboardHeight * 3 / 8) });
		loginPasswordMap.put("s", new int[] { deviceWidth * 4 / 20, (deviceHeight - keyboardHeight + keyboardHeight * 3 / 8) });
		loginPasswordMap.put("d", new int[] { deviceWidth * 6 / 20, (deviceHeight - keyboardHeight + keyboardHeight * 3 / 8) });
		loginPasswordMap.put("f", new int[] { deviceWidth * 8 / 20, (deviceHeight - keyboardHeight + keyboardHeight * 3 / 8) });
		loginPasswordMap.put("g", new int[] { deviceWidth * 10 / 20, (deviceHeight - keyboardHeight + keyboardHeight * 3 / 8) });
		loginPasswordMap.put("h", new int[] { deviceWidth * 12 / 20, (deviceHeight - keyboardHeight + keyboardHeight * 3 / 8) });
		loginPasswordMap.put("j", new int[] { deviceWidth * 14 / 20, (deviceHeight - keyboardHeight + keyboardHeight * 3 / 8) });
		loginPasswordMap.put("k", new int[] { deviceWidth * 16 / 20, (deviceHeight - keyboardHeight + keyboardHeight * 3 / 8) });
		loginPasswordMap.put("l", new int[] { deviceWidth * 18 / 20, (deviceHeight - keyboardHeight + keyboardHeight * 3 / 8) });
		loginPasswordMap.put("z", new int[] { deviceWidth * 4 / 20, (deviceHeight - keyboardHeight + keyboardHeight * 5 / 8) });
		loginPasswordMap.put("x", new int[] { deviceWidth * 6 / 20, (deviceHeight - keyboardHeight + keyboardHeight * 5 / 8) });
		loginPasswordMap.put("c", new int[] { deviceWidth * 8 / 20, (deviceHeight - keyboardHeight + keyboardHeight * 5 / 8) });
		loginPasswordMap.put("v", new int[] { deviceWidth * 10 / 20, (deviceHeight - keyboardHeight + keyboardHeight * 5 / 8) });
		loginPasswordMap.put("b", new int[] { deviceWidth * 12 / 20, (deviceHeight - keyboardHeight + keyboardHeight * 5 / 8) });
		loginPasswordMap.put("n", new int[] { deviceWidth * 14 / 20, (deviceHeight - keyboardHeight + keyboardHeight * 5 / 8) });
		loginPasswordMap.put("m", new int[] { deviceWidth * 16 / 20, (deviceHeight - keyboardHeight + keyboardHeight * 5 / 8) });
		loginPasswordMap.put("changeToNum", new int[] { deviceWidth * 3 / 20, (deviceHeight - keyboardHeight + keyboardHeight * 7 / 8) });
		//iPhone5(320, 568) 218
		loginPasswordMap.put("1", new int[] { deviceWidth * 1 / 5, (deviceHeight - keyboardHeight + keyboardHeight * 1 / 8) });
		loginPasswordMap.put("2", new int[] { deviceWidth * 1 / 2, (deviceHeight - keyboardHeight + keyboardHeight * 1 / 8) });
		loginPasswordMap.put("3", new int[] { deviceWidth * 5 / 6, (deviceHeight - keyboardHeight + keyboardHeight * 1 / 8) });
		loginPasswordMap.put("4", new int[] { deviceWidth * 1 / 5, (deviceHeight - keyboardHeight + keyboardHeight * 3 / 8) });
		loginPasswordMap.put("5", new int[] { deviceWidth * 1 / 2, (deviceHeight - keyboardHeight + keyboardHeight * 3 / 8) });
		loginPasswordMap.put("6", new int[] { deviceWidth * 5 / 6, (deviceHeight - keyboardHeight + keyboardHeight * 3 / 8) });
		loginPasswordMap.put("7", new int[] { deviceWidth * 1 / 5, (deviceHeight - keyboardHeight + keyboardHeight * 5 / 8) });
		loginPasswordMap.put("8", new int[] { deviceWidth * 1 / 2, (deviceHeight - keyboardHeight + keyboardHeight * 5 / 8) });
		loginPasswordMap.put("9", new int[] { deviceWidth * 5 / 6, (deviceHeight - keyboardHeight + keyboardHeight * 5 / 8) });
		loginPasswordMap.put("0", new int[] { deviceWidth * 1 / 2, (deviceHeight - keyboardHeight + keyboardHeight * 7 / 8) });
		loginPasswordMap.put("changeToABC", new int[] { deviceWidth * 1 / 8, (deviceHeight - keyboardHeight + keyboardHeight * 7 / 8) });

		String key = "";

		int keyboardType = 1;
		int abcKeyboard = 1;
		int numKeyboard = 2;
		int currentKeyboard = 0;

		for (int i = 0; i < password.length(); i++) {
			key = String.valueOf(password.charAt(i));
			if (key.matches("[0-9]")) { // 数字
				currentKeyboard = numKeyboard;
			} else { // 字母
				currentKeyboard = abcKeyboard;
			}

			if (keyboardType != currentKeyboard) {
				if (currentKeyboard == abcKeyboard) {
					new TouchAction(driver).tap(PointOption.point(loginPasswordMap.get("changeToNum")[0], loginPasswordMap.get("changeToNum")[1])).perform();
				}
				if (currentKeyboard == numKeyboard) {
					new TouchAction(driver).tap(PointOption.point(loginPasswordMap.get("changeToABC")[0], loginPasswordMap.get("changeToABC")[1])).perform();
				}
				keyboardType = currentKeyboard;
			}

			new TouchAction(driver).tap(PointOption.point(loginPasswordMap.get(key)[0], loginPasswordMap.get(key)[1])).perform();
		}
	}

	/**
	 * 数字键盘(用于输入金额)
	 * 2017年6月23日下午3:58:48
	 *luther
	 *@param driver
	 *@param password
	 *@throws ATPException
	 */
	@SuppressWarnings("rawtypes")
	public void amountKeyboard(IOSDriver<MobileElement>driver,String amount) throws Exception{
		
		if (driver == null || amount==null) {
			logger.warn("driver:#{}", driver);
			throw new Exception("driver不能为null或amount未输入");
		}

		int deviceWidth = driver.manage().window().getSize().width;
		int deviceHeight = driver.manage().window().getSize().height;

		int keyboardHeight = confirmDevice(deviceWidth, deviceHeight);

		logger.info("deviceWidth:#{}, deviceHeight:#{}, keyboardHeight:#{}", deviceWidth, deviceHeight, keyboardHeight);

		Map<String, int[]> loginPasswordMap = new HashMap<>();
		loginPasswordMap.put("1", new int[] { deviceWidth * 1 / 8, (deviceHeight - keyboardHeight + keyboardHeight * 1 / 8) });
		loginPasswordMap.put("2", new int[] { deviceWidth * 3 / 8, (deviceHeight - keyboardHeight + keyboardHeight * 1 / 8) });
		loginPasswordMap.put("3", new int[] { deviceWidth * 5 / 8, (deviceHeight - keyboardHeight + keyboardHeight * 1 / 8) });
		loginPasswordMap.put("4", new int[] { deviceWidth * 1 / 8, (deviceHeight - keyboardHeight + keyboardHeight * 3 / 8) });
		loginPasswordMap.put("5", new int[] { deviceWidth * 3 / 8, (deviceHeight - keyboardHeight + keyboardHeight * 3 / 8) });
		loginPasswordMap.put("6", new int[] { deviceWidth * 5 / 8, (deviceHeight - keyboardHeight + keyboardHeight * 3 / 8) });
		loginPasswordMap.put("7", new int[] { deviceWidth * 1 / 8, (deviceHeight - keyboardHeight + keyboardHeight * 5 / 8) });
		loginPasswordMap.put("8", new int[] { deviceWidth * 3 / 8, (deviceHeight - keyboardHeight + keyboardHeight * 5 / 8) });
		loginPasswordMap.put("9", new int[] { deviceWidth * 5 / 8, (deviceHeight - keyboardHeight + keyboardHeight * 5 / 8) });
		loginPasswordMap.put("0", new int[] { deviceWidth * 3 / 8, (deviceHeight - keyboardHeight + keyboardHeight * 7 / 8) });
		loginPasswordMap.put(".", new int[] { deviceWidth * 1 / 8, (deviceHeight - keyboardHeight + keyboardHeight * 7 / 8) });
		
		String key = "";
		for (int i = 0; i < amount.length(); i++) {
			key = String.valueOf(amount.charAt(i));
			new TouchAction(driver).tap(PointOption.point(loginPasswordMap.get(key)[0], loginPasswordMap.get(key)[1])).perform();
		}
		
	}
	
	
	/**ios输入金额键盘*/
	public static void moneyKeyboard(AppiumDriver<MobileElement> driver,int inputMoney){
	
		String money = String.valueOf(inputMoney);
		String key = "";
		for (int i = 0; i < money.length(); i++) {
			key = String.valueOf(money.charAt(i));
			
			if ("1".equals(key)) {
				driver.findElementByAccessibilityId("1").click();
			}else if ("2".equals(key)) {
				driver.findElementByAccessibilityId("2").click();
			}else if ("3".equals(key)) {
				driver.findElementByAccessibilityId("3").click();
			}else if ("4".equals(key)) {
				driver.findElementByAccessibilityId("4").click();
			}else if ("5".equals(key)) {
				driver.findElementByAccessibilityId("5").click();
			}else if ("6".equals(key)) {
				driver.findElementByAccessibilityId("6").click();
			}else if ("7".equals(key)) {
				driver.findElementByAccessibilityId("7").click();
			}else if ("8".equals(key)) {
				driver.findElementByAccessibilityId("8").click();
			}else if ("9".equals(key)) {
				driver.findElementByAccessibilityId("9").click();
			}else if ("0".equals(key)) {
				driver.findElementByAccessibilityId("0").click();
			}
			
		}
		driver.findElementByAccessibilityId("确定").click();
		
		
	}
	
	
	

}
