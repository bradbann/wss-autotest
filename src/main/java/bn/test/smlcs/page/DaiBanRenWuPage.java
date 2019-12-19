package bn.test.smlcs.page;

import java.time.temporal.ChronoUnit;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.WithTimeout;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

/**
 * 待办任务页
 * @date 2019年7月16日 上午11:03:37
 * @author zhaodong
 */
public class DaiBanRenWuPage {
	
		
		
		/**title*/
		@WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
		@iOSXCUITFindBy(iOSNsPredicate="value=='待办任务'")
		public MobileElement title;
		
		
		
		
		
		
		
		

}
