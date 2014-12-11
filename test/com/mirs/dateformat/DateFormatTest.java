/**
 * 
 */
package com.mirs.dateformat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 获取指定格式的日期
 * @author guangpeng.zhao
 *
 */
public class DateFormatTest {
	public static String dateFormat ="yyyy-MM-dd";
	// String - Date    Date -- String 
	
	public static void main(String[] args) {
//		baseConvert();
//		System.out.println(isValidDate("2014-09-12"));
		Calendar cal = Calendar.getInstance();
		Date date = cal.getTime();
		String regionDateFormat = "yyyyMMdd";
		SimpleDateFormat sdf = new SimpleDateFormat(regionDateFormat);
		String dateStr = sdf.format(date);
		
		System.out.println(dateStr+cal.get(Calendar.HOUR_OF_DAY));
//		
		for(int i=0;i<90000;i++){
			System.out.println(i);
			System.out.println(cal.get(Calendar.MINUTE));
		}
//		
		
		
	}
	
	
	public static void baseConvert(){
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		
		try {
			//String  ---- Date
			Date date = sdf.parse("2014-12-02");
			System.out.println(date);
			
			//date --> String
			String dateStr = sdf.format(new Date());
			System.out.println(dateStr);
			
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void getpreDate(){
		
	}
	
	/**
	 * 验证是否为有效的日期格式
	 * @param dateStr
	 * @return
	 */
	public static boolean isValidDate(String dateStr){
		if(dateStr == null)return false;
		boolean isFormFile = false;
		//正则表达式
		Pattern pattern = Pattern.compile("^[0-9]{4}-[01][0-9]-[0-3][0-9]$");
		Matcher match = pattern.matcher(dateStr);
		
		isFormFile =match.find();
		return isFormFile;
	   }
	/**
	 * Matcher 匹配模式下的API解读
	 * matches 方法尝试将整个输入序列与该模式匹配。 
		lookingAt 尝试将输入序列从头开始与该模式匹配。 
		find 方法扫描输入序列以查找与该模式匹配的下一个子序列。
	 * 
	 */
	
	
}
