package bn.test.smlcs.util;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WrapsDriver;

import bn.test.smlcs.driver.DriverManager;

/**
 * 
 * @author ZD 报错屏幕捕获，以及错误日志
 */
public class ScreenShot {

	public static String getCurrentSystemTime() {
		Date now = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
		String time = dateFormat.format(now);
		return time;
	}

	public static String errorScreenshot(WebDriver driver, String path, String pictureFormat) throws IOException {

		String systemTime = getCurrentSystemTime();
		String pictureName = systemTime + pictureFormat;
		File jpg = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(jpg, new File(path + pictureName));
		return pictureName;
	}

	public static String errorScreenshot(WebDriver driver, String pictureFormat) throws IOException {
		String path = "/Users/zhaodong/Documents/AutoTestTools/screenShot/";
		String systemTime = getCurrentSystemTime();
		String pictureName = systemTime + pictureFormat;
		File jpg = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(jpg, new File(path + pictureName));
		return pictureName;
	}

	/**
	 * 
	 * @param driver
	 * @return 返回图片绝对路径
	 * @throws IOException
	 */
	public static String errorScreenshot(WebDriver driver) throws IOException {
		String path = "/Users/zhaodong/Documents/AutoTestTools/screenShot/";
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMddhhmmss");
		// String systemTime = getCurrentSystemTime();
		String sdate = dateFormat.format(new Date());
		String picturePaht = path + sdate + ".jpg";
		File jpg = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(jpg, new File(picturePaht));
		System.out.println(picturePaht);
		return picturePaht;
	}
	
	
	/**
	 * 
	 * @param driver
	 * @return 返回图片绝对路径
	 * @throws IOException
	 */
	public static String errorScreenshot() throws IOException {
		Date date=new Date();//此时date为当前的时间 
		SimpleDateFormat dateFormat2 = new SimpleDateFormat("YYYY-MM-dd");
		String string = dateFormat2.format(date);
		String path = "/Users/zhaodong/Documents/AutoTestTools/screenShot/"+string+"/";
		//创建当前日期的文件夹
		File file=new File(path);
		if(!file.exists()){//如果文件夹不存在
			file.mkdir();//创建文件夹
		}
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMddhhmmss");
		// String systemTime = getCurrentSystemTime();
		String sdate = dateFormat.format(new Date());
		String picturePath = path + sdate + ".jpg";
		File jpg = ((TakesScreenshot) DriverManager.getAppiumDriver()).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(jpg, new File(picturePath));
		System.out.println(picturePath);
		return picturePath;
	}
	

	/**
	 * 
	 * @author ZD 截取某个元素的图片
	 */
	public static File captureElement(WebElement element) throws Exception {
		WrapsDriver wrapsDriver = (WrapsDriver) element;
		// 截取整个页面
		File screen = ((TakesScreenshot) wrapsDriver.getWrappedDriver()).getScreenshotAs(OutputType.FILE);
		BufferedImage img = ImageIO.read(screen);
		// 获得元素的高度和宽度
		int width = element.getSize().width;
		int height = element.getSize().height;
		// 创建一个矩形使面上面的高度，和宽度
		Rectangle rect = new Rectangle(width, height);
		// 得到元素的坐标
		Point p = element.getLocation();
		BufferedImage desk = img.getSubimage(p.getX(), p.getY(), rect.width, rect.height);
		// 存为jpg格式
		ImageIO.write(desk, "jpg", screen);
		// FileUtils.copyFile(screen, new
		// File("/Users/zhaodong/Documents/AutoTestTools/screenShot/test1.jpg"));
		return screen;

	}
}
