package bn.test.smlcs.util.packageMobileElement;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 
 * @date 2019年7月17日下午4:09:16
 * @author zhaodong
 */

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface TimeOut {
	
	int time();


}
