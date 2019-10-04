/**
 * 
 */
package com.learntech.teamtracker.manageprofile.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @author UthirNew
 *
 */
public class DateConverterUtil {
	
	public static LocalDate convertTimeStamp(String date){
		
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		return LocalDate.parse(date,dateTimeFormatter);
		
	}

}
