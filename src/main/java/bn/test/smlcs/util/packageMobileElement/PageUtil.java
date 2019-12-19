package bn.test.smlcs.util.packageMobileElement;






import java.lang.reflect.Field;

import org.openqa.selenium.WebDriver;


/**
 * 
 * @date 2019年7月17日下午4:09:33
 * @author zhaodong
 */
public class PageUtil {
	
	public static void initialWebElement(WebDriver driver,Object obj) {
		try{
			Field[] fields = obj.getClass().getDeclaredFields();
			for (Field field : fields) {
				if(field.isAnnotationPresent(iOSXCUITFindByE.class) && field.getType().equals(MobileElementE.class)){
					iOSXCUITFindByE findBy = field.getAnnotation(iOSXCUITFindByE.class);
					FindElement findElement = new FindElement();
					
					if(!"".equals(findBy.iOSNsPredicate())){
						findElement.setiOSNsPredicate(findBy.iOSNsPredicate());
					}else if(!"".equals(findBy.accessibility())){
						findElement.setAccessibility(findBy.accessibility());
					}else if(!"".equals(findBy.xpath())){
						findElement.setXpath(findBy.xpath());
					}else if(!"".equals(findBy.iOSClassChain())){
						findElement.setiOSClassChain(findBy.iOSClassChain());
					}else if(!"".equals(findBy.className())){
						findElement.setClassName(findBy.className());
					}
					MobileElementE mE = new MobileElementE(driver,findElement);
					field.setAccessible(true);
					field.set(obj, mE);
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	

}
