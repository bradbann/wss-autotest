package bn.test.smlcs.report;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import java.util.regex.Matcher;

import org.testng.IReporter;
import org.testng.IResultMap;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.TestListenerAdapter;
import org.testng.xml.XmlSuite;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import bn.test.smlcs.util.ScreenShot;
import bn.test.smlcs.util.SendMail;


public class ZTestReport extends TestListenerAdapter implements IReporter {
	
	private String path = System.getProperty("user.dir")+File.separator+"report/report.html";
	
	private String templatePath = System.getProperty("user.dir")+File.separator+"report/template";
	
	private int testsPass = 0;

	private int testsFail = 0;

	private int testsSkip = 0;
	
	private String beginTime;
	
	private long endTime;
	
	private String endTimes;
	
	private long totalTime;
	
	private String name;
	
	List<String> picturesPath = new ArrayList<String>();
	
	String picturePath;
	
	public ZTestReport(){
		SimpleDateFormat formatter = new SimpleDateFormat ("yyyyMMddHHmmssSSS");
		name = formatter.format(System.currentTimeMillis());
	}
	
	public ZTestReport(String name){
		this.name = name;
		if(this.name==null){
			SimpleDateFormat formatter = new SimpleDateFormat ("yyyyMMddHHmmssSSS");
			this.name = formatter.format(System.currentTimeMillis());
		}
	}
	
	@Override
	public void onTestFailure(ITestResult tr) {
		
		super.onTestFailure(tr);
		try {
			String path= ScreenShot.errorScreenshot();
//			picturePath = path;
			picturesPath.add(path);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
	

	@Override
	public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
		List<ITestResult> list = new ArrayList<ITestResult>();
		for (ISuite suite : suites) {
			Map<String, ISuiteResult> suiteResults = suite.getResults();
			for (ISuiteResult suiteResult : suiteResults.values()) {
				ITestContext testContext = suiteResult.getTestContext();
				IResultMap passedTests = testContext.getPassedTests();
				testsPass = testsPass + passedTests.size();
				IResultMap failedTests = testContext.getFailedTests();
				testsFail = testsFail + failedTests.size();
				IResultMap skippedTests = testContext.getSkippedTests();
				testsSkip = testsSkip + skippedTests.size();
				IResultMap failedConfig = testContext.getFailedConfigurations();
				list.addAll(this.listTestResult(passedTests));
				list.addAll(this.listTestResult(failedTests));
				list.addAll(this.listTestResult(skippedTests));
				list.addAll(this.listTestResult(failedConfig));
			}
		}
		this.sort(list);
		this.outputResult(list);
	}

	private ArrayList<ITestResult> listTestResult(IResultMap resultMap) {
		Set<ITestResult> results = resultMap.getAllResults();
		return new ArrayList<ITestResult>(results);
	}

	private void sort(List<ITestResult> list) {
		Collections.sort(list, new Comparator<ITestResult>() {
			@Override
			public int compare(ITestResult r1, ITestResult r2) {
				if (r1.getStartMillis() > r2.getStartMillis()) {
					return 1;
				} else {
					return -1;
				}
			}
		});
	}
	
	
	

	private void outputResult(List<ITestResult> list) {
		try {
			List<ReportInfo> listInfo = new ArrayList<ReportInfo>();
			int index = 0;
			int errorNo = 0;
			for (ITestResult result : list) {
				String tn = result.getTestContext().getCurrentXmlTest().getParameter("testCase");
				if(index==0){
					SimpleDateFormat formatter = new SimpleDateFormat ("yyyy-MM-dd HH:mm:ss.SSS");
					beginTime = formatter.format(new Date(result.getStartMillis()));
					index++;
				}
				SimpleDateFormat formatter = new SimpleDateFormat ("yyyy-MM-dd HH:mm:ss.SSS");
				endTime = result.getEndMillis();
				endTimes = formatter.format(new Date(endTime));
				long spendTime = endTime - result.getStartMillis();
				totalTime += spendTime;
				String status = this.getStatus(result.getStatus());
				List<String> log = Reporter.getOutput(result);
				
				for (int i = 0; i < log.size(); i++) {
					log.set(i, log.get(i).replaceAll("\"", "\\\\\""));
				}
				Throwable throwable = result.getThrowable();
				if(throwable!=null){
					log.add(throwable.toString().replaceAll("\"", "\\\\\""));
					StackTraceElement[] st = throwable.getStackTrace();
					for (StackTraceElement stackTraceElement : st) {
						log.add(("    " + stackTraceElement).replaceAll("\"", "\\\\\""));
					}
				}
				ReportInfo info = new ReportInfo();
				info.setName(tn);
				info.setSpendTime(spendTime+"ms");
				info.setStatus(status);
				System.out.println("status: "+status);
				info.setClassName(result.getInstanceName());
				info.setMethodName(result.getName());
				info.setDescription(result.getMethod().getDescription());
				info.setLog(log);
				if (status.equals("失败")) {
					info.setScreenShot(picturesPath.get(errorNo));
					System.out.println("设置图片路径成功");
					errorNo++;
				}
				
				listInfo.add(info);
			}
			
			Map<String, Object> result = new HashMap<String, Object>();
			result.put("testName", name);
			result.put("testPass", testsPass);
			result.put("testFail", testsFail);
			result.put("testSkip", testsSkip);
			result.put("testAll", testsPass+testsFail+testsSkip);
			result.put("beginTime", beginTime);
			result.put("endTime", endTimes);
			result.put("totalTime", changeTime(totalTime));
			result.put("testResult", listInfo);
			Gson gson = new GsonBuilder().disableHtmlEscaping().setPrettyPrinting().create();
			String template = this.read(templatePath);
			BufferedWriter output = new BufferedWriter( new OutputStreamWriter(new FileOutputStream(new File(path)),"UTF-8"));
			template = template.replaceFirst("\\$\\{resultData\\}", Matcher.quoteReplacement(gson.toJson(result)));
			output.write(template);
			output.flush();
			output.close();
			
			if(testsFail >0 || testsSkip > 0 || testsPass > 0){
				SendMail.sendMail("smtp.qq.com","zhaodong6092@qq.com","ibmroxffmkqdeche", "测试报告","zhaodong6092@qq.com",
						new String[]{"zhaodong185@163.com","3509360682@qq.com"}, new String[0], new String[0], new String[]{path},new String[0],"测试报告");
			}
//			SendMail.sendMail(sHost, sUser, sPwd, sSubject, sFrom, sTo, sCc, sBcc, sAttachsPath, sImgs_Path, sContentFormat);
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public String changeTime(long totalTime){
		SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");//初始化Formatter的转换格式。
		formatter.setTimeZone(TimeZone.getTimeZone("GMT+00:00"));
		String hms = formatter.format(totalTime);
		return hms;
	}

	private String getStatus(int status) {
		String statusString = null;
		switch (status) {
		case 1:
			statusString = "成功";
			break;
		case 2:
			statusString = "失败";
			break;
		case 3:
			statusString = "跳过";
			break;
		default:
			break;
		}
		return statusString;
	}
	
	public static class ReportInfo {
		
		private String name;
		
		private String className;
	
		private String methodName;
		
		private String description;
		
		private String spendTime;
				
		private String status;
		
		private List<String> log;
		
		private String screenShot;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getClassName() {
			return className;
		}

		public void setClassName(String className) {
			this.className = className;
		}

		public String getMethodName() {
			return methodName;
		}

		public void setMethodName(String methodName) {
			this.methodName = methodName;
		}

		public String getSpendTime() {
			return spendTime;
		}

		public void setSpendTime(String spendTime) {
			this.spendTime = spendTime;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		public List<String> getLog() {
			return log;
		}

		public void setLog(List<String> log) {
			this.log = log;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public String getScreenShot() {
			return screenShot;
		}

		public void setScreenShot(String screenShot) {
			this.screenShot = screenShot;
		}
		
	}
	
	private String read(String path) {
		File file = new File(path);
		InputStream is = null;
		StringBuffer sb = new StringBuffer();
		try {
			is = new FileInputStream(file);
			int index = 0;
			byte[] b = new byte[1024];
			while ((index = is.read(b)) != -1) {
				sb.append(new String(b, 0, index));
			}
			return sb.toString();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (is != null) {
					is.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}


}
