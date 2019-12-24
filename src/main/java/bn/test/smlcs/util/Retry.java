package bn.test.smlcs.util;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * @date 2019年12月24日 下午2:45:01
 * @author zhaodong
 */
public class Retry implements IRetryAnalyzer {

	private int count = 1;

	@Override
	public boolean retry(ITestResult result) {
		if (count < 2) {// 设置重跑次数
			count++;
			System.out.println(result.getName());
			return true;
		}
		return false;

	}
	
	
	
	
	
	
	
	

}
