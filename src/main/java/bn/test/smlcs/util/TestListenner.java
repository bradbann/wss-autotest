package bn.test.smlcs.util;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.ITestAnnotation;

/**
 * @date 2019年12月24日 下午4:21:08
 * @author zhaodong
 */
public class TestListenner implements IAnnotationTransformer{

	@Override
	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
		IRetryAnalyzer retryAnalyzer = annotation.getRetryAnalyzer();//获取到retryAnalyzer的注解
		if (retryAnalyzer == null){ 
			annotation.setRetryAnalyzer(Retry.class); 
			} //如果注解为空，则动态设置注解，以确保用例失败后重跑。

	}
	

}
