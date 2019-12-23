package bn.test.smlcs.util;

import java.time.Duration;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

/**
 * @date 2019年4月10日 下午3:58:57
 * @author zhaodong
 */
public class MobileCommonUtil {
	

	public static void sleep(int millisecond) {
		try {
			Thread.sleep(millisecond);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/** 获取屏幕高度 */
	public static int getScreenHeight(AppiumDriver<?> driver) {
		return driver.manage().window().getSize().height;
	}

	/** 获取屏幕宽度 */
	public static int getScreenWidth(AppiumDriver<?> driver) {
		return driver.manage().window().getSize().width;
	}

	/**
	 * 滑动方法-从下往上滑，从屏幕四分之三滑动到四分之一处
	 * @param driver
	 */
	public static void slideThreeQuarters(AppiumDriver<MobileElement> driver){
		int x = getScreenWidth(driver);
		int y = getScreenHeight(driver);
		int x1 = x/2;
		int y1 = y*3/4;
		int y2 = y*1/4;
		slide(driver, x1,y1 , x1, y2-y1);
	}
	
	/**
	 * 滑动方法-从右往滑，从屏幕四分之三滑动到四分之一处
	 * @param driver
	 */
	public static void slideRightToLeftThreeQuarters(AppiumDriver<MobileElement> driver){
		int x = getScreenWidth(driver);
		int y = getScreenHeight(driver);
		int x1 = x*3/4;
		int x2 = x*1/4;
		int y1 = y/2;
		slide(driver, x1,y1 , x2, y1);
	}
	
	/**
	 * 滑动方法-从右往滑，指定高度，从屏幕四分之三滑动到四分之一处
	 * @param driver
	 */
	public static void slideRightToLeftThreeQuarters(AppiumDriver<MobileElement> driver,int higt){
		int x = getScreenWidth(driver);
//		int y = getScreenHeight(driver);
//		System.out.println("屏幕的宽和高分别是："+x+", "+y);//屏幕的宽和高分别是：320, 568
		int x1 = x*3/4;
		int x2 = x*1/4;
		int y1 = higt;
		slide(driver, x1,y1 , x2, y1);
	}
	
	/**
	 * 滑动方法-从右往滑，指定高度，传入元素，从元素的高度开始，从屏幕四分之三滑动到四分之一处
	 * @param driver
	 * @param element
	 */
	public static void slideRightToLeftThreeQuarters(AppiumDriver<MobileElement> driver,MobileElement element){
		int x = getScreenWidth(driver);
//		int y = getScreenHeight(driver);
//		System.out.println("屏幕的宽和高分别是："+x+", "+y);
		int x1 = x*3/4;
		int x2 = x*1/4;
		int y1 = element.getCenter().y;
		slide(driver, x1,y1 , x2, y1);
	}
	
	/**
	 * 获取元素坐标高度
	 * @param driver
	 * @param element
	 * @return
	 */
	public static int getElementPointY(AppiumDriver<MobileElement> driver,MobileElement element){
		int y = element.getCenter().y;
		return y;
	}
	
	/**
	 * 获取元素坐标宽度
	 * @param driver
	 * @param element
	 * @return
	 */
	public static int getElementPointX(AppiumDriver<MobileElement> driver,MobileElement element){
		int x = element.getCenter().x;
		return x;
	}
	
	@SuppressWarnings("rawtypes")
	public static void tapPoint(AppiumDriver<MobileElement> driver,int x,int y){
		TouchAction action = new TouchAction(driver);
		PointOption option1 = PointOption.point(x,y);
		action.tap(option1).release().perform();;
		
	}
	
	@SuppressWarnings("rawtypes")
	public static void pressPoint(AppiumDriver<MobileElement> driver,int x,int y){
		TouchAction action = new TouchAction(driver);
		PointOption option1 = PointOption.point(x,y);
		action.tap(option1).release().perform();
//		action.press(option1).perform().release();
		
	}
	
	
	/**
	 * 滑动方法-从下往上滑，从屏幕十分之九滑动到十分之一处
	 * @param driver
	 */
	public static void slideNineTenthToOneTenth(AppiumDriver<MobileElement> driver){
		int x = getScreenWidth(driver);
		int y = getScreenHeight(driver);
		int x1 = x/2;
		int y1 = y*9/10;
		int y2 = y*1/10;
		slide(driver, x1,y1 , x1, y2-y1);
	}
	
	
	
	
	/**
	 * 屏幕滑动，x1和y1为开始位置，x2和y2为结束位置
	 * @param driver
	 * @param x1
	 * @param y1
	 * @param x2
	 * @param y2
	 */
	@SuppressWarnings("rawtypes")
	public static void slide(AppiumDriver<MobileElement> driver,int x1,int y1,int x2,int y2){
		
		TouchAction action = new TouchAction(driver);
		PointOption option1 = PointOption.point(x1, y1);
		PointOption option2 = PointOption.point(x2, y2);
		WaitOptions waitOptions = WaitOptions.waitOptions(Duration.ofMillis(500));
		action.press(option1).waitAction(waitOptions).moveTo(option2).release().perform();
		
	}
	
	

}
