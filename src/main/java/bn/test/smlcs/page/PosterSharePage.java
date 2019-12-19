package bn.test.smlcs.page;

import java.time.temporal.ChronoUnit;
import java.util.List;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.WithTimeout;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

/**
 * 
 * 海报分享
 * @date 2019年10月18日 下午4:48:58
 * @author zhaodong
 */
public class PosterSharePage {
	
	/** 页面title */
	@WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
	@iOSXCUITFindBy(accessibility = "海报分享")
	public MobileElement title;
	
	/**海报列表，所有的海报*/
	@WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
	@iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeCell/XCUIElementTypeOther")
	public List<MobileElement> posters;
	
	/**第1张海报*/
	@WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
	@iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeCell/XCUIElementTypeOther[1]")
	public MobileElement firstPoster;
	
	
	/**海报下端的rm名字*/
	@WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
	@iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[2]")
	public MobileElement posterName;
	
	/**保存图片*/
	@WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
	@iOSXCUITFindBy(accessibility = "保存图片")
	public MobileElement savePicture;
	
	/**保存成功toast*/
	@WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
	@iOSXCUITFindBy(accessibility = "保存成功")
	public MobileElement saveSuccessToast;
	
	
	
	

}
