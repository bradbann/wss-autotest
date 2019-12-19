package bn.test.smlcs.page;

import java.time.temporal.ChronoUnit;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.WithTimeout;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

/**
 * 转发助手页
 * @date 2019年8月13日上午10:49:10
 * @author zhaodong
 */
public class ZhuanFaZhuShouPage {
	
	
	/**title*/
	@WithTimeout(time=10,chronoUnit=ChronoUnit.SECONDS)
	@iOSXCUITFindBy(iOSNsPredicate="value=='转发助手'")
	public MobileElement title;
	

}
