package bn.test.smlcs.util.packageMobileElement;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @date 2018年9月12日 上午9:50:23
 * @author zhaodong
 */

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface iOSXCUITFindByE {
	
	String iOSClassChain() default "";
	String accessibility() default "";
	String iOSNsPredicate() default "";
	String id() default "";
	String className() default "";
    String tagName() default "";
    String xpath() default "";
    String name() default "";
    int priority() default 0;

}
