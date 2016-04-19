package com.letsbuild.base.util;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.letsbuild.base.exception.SystemException;

public class DateUtil {
    public static final String DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

    public static final String DATETIME_FORMAT2 = "yyyyMMdd HH:mm:ss";

    public static final String DATE_FORMAT = "yyyy-MM-dd";

    public static final String YYYYMMDD = "yyyyMMdd";

    public static final String YYYYMM = "yyyyMM";

    public static final String YYYYMMDDHHMM = "yyyyMMddHHmm";

    public static final String YYYYMMDDHHMMS = "yyyy年MM月dd日HH时mm分ss秒";

    public static final String YYYYMMDDHHMMSS = "yyyyMMddHHmmss";

    public static final String yyyyMMddHHmmssSSS = "yyyyMMddHHmmssSSS";

    public static Timestamp getSysDate() {
        return new Timestamp(new Date().getTime());
    }

    public static Timestamp getTimestamp(String date, String format) {
        DateFormat df = new SimpleDateFormat(format);
        try {
            Date temp = df.parse(date);
            Timestamp d = new Timestamp(temp.getTime());
            return d;
        } catch (Exception e) {
            throw new SystemException("系统转换日期字符串时出错！", e);
        }
    }
}
