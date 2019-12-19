package bn.test.smlcs.util;

import java.time.Duration;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

/**
 * @date 2019年4月11日 下午2:44:16
 * @author zhaodong
 */
public class StepCommonOperation {
	
	public AppiumDriver<MobileElement> driver;
	
	/**ios 私募理财师手势解锁*/
	@SuppressWarnings("rawtypes")
	public void gesturenlock(){
		int x1 = 61;
		int y1 = 190;
		int x2 = x1;
		int y2 = y1+198;
		int x3 = x1+198;
		int y3 = y2;
		System.out.println("x1: "+x1+" , y1: "+y1);
		System.out.println("x2: "+x2+" , y2: "+y2);
		System.out.println("x3: "+x3+" , y3: "+y3);
		TouchAction action = new TouchAction(driver);
		PointOption option1 = PointOption.point(x1, y1);
		PointOption option2 = PointOption.point(x2, y2);
		PointOption option3 = PointOption.point(x3, y3);
		WaitOptions waitOptions = WaitOptions.waitOptions(Duration.ofMillis(500));
		action.press(option1).waitAction(waitOptions).moveTo(option2).waitAction(waitOptions).moveTo(option3).release().perform();
	}

}
