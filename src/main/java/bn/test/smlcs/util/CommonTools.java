package bn.test.smlcs.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @date 2019年12月30日 下午3:58:37
 * @author zhaodong
 */
public class CommonTools {
	
	/**
	 * 
	 * @param datetime
	 * @return
	 * @throws java.text.ParseException
	 * 传入日期字符串，返回周几，如"2019-12-8"则返回"星期日"
	 */
	public static String dateToWeek(String datetime) throws java.text.ParseException {
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
		String[] weekDays = { "星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六" };
		Calendar cal = Calendar.getInstance(); // 获得一个日历
		Date datet = null;
		datet = (Date) f.parse(datetime);
		cal.setTime(datet);
		int w = cal.get(Calendar.DAY_OF_WEEK) - 1; // 指示一个星期中的某天。
		if (w < 0)
		w = 0;
//		System.out.println(w);
//		System.out.println(weekDays[w]);
		return weekDays[w];
		}

}
