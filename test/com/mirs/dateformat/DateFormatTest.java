/**
 * 
 */
package com.mirs.dateformat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
		System.out.println(isValidDate("2014-09-12"));
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
	
	
	
}
