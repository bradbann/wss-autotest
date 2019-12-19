package bn.test.smlcs.step;

import bn.test.smlcs.util.ElementOperation;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

/**
 * @date 2019年8月21日 下午3:33:12
 * @author zhaodong
 */
public class BaseStep {
	
	
	AppiumDriver<MobileElement> driver;
	public BaseStep(AppiumDriver<MobileElement> driver) {
		this.driver = driver;
	}
	
	
	
	public MobileElement initElement(MobileElement element){
		return ElementOperation.initElement(driver, element);
		
	}
	

}
