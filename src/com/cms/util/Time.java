package com.cms.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Time  {
	
	public static String getTime() {
		Date d = new Date();
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String udata = sf.format(d);
		return udata;
	}


}
