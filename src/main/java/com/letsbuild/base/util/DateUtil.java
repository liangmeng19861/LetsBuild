package com.letsbuild.base.util;

import java.sql.Timestamp;
import java.util.Date;

public class DateUtil {
	public static Timestamp getSysDate(){
		return new Timestamp(new Date().getTime());
	}
}
