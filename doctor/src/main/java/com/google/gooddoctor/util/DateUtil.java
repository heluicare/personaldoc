package com.google.gooddoctor.util;

import android.annotation.SuppressLint;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

@SuppressLint({"SimpleDateFormat"})
public class DateUtil {
    public static final String FORMAT_DATE_HHMM = "HH:mm";
    public static final String FORMAT_DATE_MM = "MM";
    public static final String FORMAT_DATE_MMDD = "MM-dd";
    public static final String FORMAT_DATE_MMDD_HHMM = "MM-dd HH:mm";
    public static final String FORMAT_DATE_YESTERDAY = "昨天";
    public static final String FORMAT_DATE_YMD_HSZ = "yyyy年MM月dd日 HH:mm";
    public static final String FORMAT_DATE_YY = "yyyy";
    public static final String FORMAT_DATE_YYMM = "yyyy-MM";
    public static final String FORMAT_DATE_YYMMDD = "yyyy-MM-dd";
    public static final String FORMAT_DATE_YYMMDD_CHINA = "yyyy年MM月dd日";
    public static final String FORMAT_DATE_YYMMDD_DOT = "yyyy.MM.dd";
    public static final String FORMAT_DATE_YYMMDD_HHMM = "yyyy-MM-dd HH:mm";
    public static final String FORMAT_DATE_YYMMDD_HHMMSS = "yyyy-MM-dd HH:mm:ss";
    public static final String FORMAT_DATE_YYMMDD_SLASH = "yyyy/MM/dd";
    public static final String FORMAT_MMDD_HHMM = "MM-dd HH:mm";
    public static final long MILLIS_FOR_ONE_DAY = 86400000;

    public static long getIncrementMillis(int i) {
        return 86400000 * ((long) i);
    }

    public static String long2String(long j, String str) {
        if (str == null || "".equals(str)) {
            return "";
        }
        if (j <= 0) {
            Calendar instance = Calendar.getInstance();
            instance.set(1800, 0, 1);
            j = instance.getTimeInMillis();
        }
        return new SimpleDateFormat(str, Locale.CHINA).format(new Date(j));
    }

    public static Date String2Date(String str, String str2) {
        try {
            return new SimpleDateFormat(str2, Locale.CHINA).parse(str);
        } catch (ParseException unused) {
            return new Date(Calendar.getInstance().getTimeInMillis());
        }
    }

    public static String String2String(String str, String str2) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str2);
        try {
            return simpleDateFormat.format(simpleDateFormat.parse(str));
        } catch (ParseException unused) {
            return str2;
        }
    }

    public static String getDateWithFormat(int i, int i2, int i3, String str) {
        Calendar instance = Calendar.getInstance();
        instance.set(1, i);
        instance.set(2, i2);
        instance.set(5, i3);
        return new SimpleDateFormat(str, Locale.CHINA).format(instance.getTime());
    }

    public static long string2Long(String str, String str2) {
        if (str == null || "".equals(str) || str2 == null || "".equals(str2)) {
            return 0;
        }
        try {
            return new SimpleDateFormat(str2, Locale.CHINA).parse(str).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static int daysOfTwo(Date date, Date date2) {
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        instance.set(11, 0);
        instance.set(12, 0);
        instance.set(13, 0);
        instance.set(14, 0);
        Calendar instance2 = Calendar.getInstance();
        instance2.setTime(date2);
        instance2.set(11, 0);
        instance2.set(12, 0);
        instance2.set(13, 0);
        instance2.set(14, 0);
        return (int) ((instance2.getTime().getTime() - instance.getTime().getTime()) / 86400000);
    }

    public static long addDate(Date date, int i) {
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(date.getTime());
        instance.add(5, i);
        return instance.getTimeInMillis();
    }

    public static int compareDate(String str, String str2, String str3) {
        long string2Long = string2Long(str, str3);
        long string2Long2 = string2Long(str2, str3);
        if (string2Long > string2Long2) {
            return 1;
        }
        return string2Long == string2Long2 ? 0 : -1;
    }

    public static String getCurrentDate(String str) {
        return new SimpleDateFormat(str, Locale.CHINA).format(new Date());
    }

    public static long getCurrentDateStartTimes() {
        Calendar instance = Calendar.getInstance();
        instance.set(11, 0);
        instance.set(12, 0);
        instance.set(13, 0);
        return instance.getTimeInMillis();
    }

    public static long getCurrentDateEndTimes() {
        Calendar instance = Calendar.getInstance();
        instance.set(11, 23);
        instance.set(12, 59);
        instance.set(13, 59);
        return instance.getTimeInMillis();
    }

    public static boolean isCurrentDay(long j) {
        return j > getCurrentDateStartTimes() - 1 && j < getCurrentDateEndTimes() + 1;
    }

    public static boolean compareTimes(long j, long j2) {
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(j);
        instance.set(11, 0);
        instance.set(12, 0);
        instance.set(13, 0);
        long timeInMillis = instance.getTimeInMillis();
        instance.setTimeInMillis(j2);
        instance.set(11, 0);
        instance.set(12, 0);
        instance.set(13, 0);
        if (Math.abs(instance.getTimeInMillis() - timeInMillis) < 1000) {
            return true;
        }
        return false;
    }

    public static boolean isYesterday(long j) {
        Calendar instance = Calendar.getInstance();
        int i = instance.get(5);
        boolean z = true;
        int i2 = instance.get(1);
        instance.setTimeInMillis(j);
        int i3 = instance.get(5);
        int i4 = instance.get(1);
        if (i == 1) {
            instance.set(5, 0);
            if (!(instance.get(5) == i3 && i2 == i4)) {
                z = false;
            }
            return z;
        }
        if (!(i - 1 == i3 && i2 == i4)) {
            z = false;
        }
        return z;
    }

    public static int differenceMonth(long j) {
        Calendar instance = Calendar.getInstance();
        int i = instance.get(1);
        int i2 = instance.get(2);
        instance.setTimeInMillis(j);
        int i3 = instance.get(1);
        int i4 = instance.get(2);
        return ((i - i3) * 12) + (i2 >= i4 ? (i2 - i4) + 1 : i2 - i4);
    }

    public static long getMondayOfThisWeek() {
        Calendar instance = Calendar.getInstance();
        int i = 7;
        int i2 = instance.get(7) - 1;
        if (i2 != 0) {
            i = i2;
        }
        instance.add(5, (-i) + 1);
        instance.set(instance.get(1), instance.get(2), instance.get(5), 0, 0, 0);
        return instance.getTimeInMillis();
    }

    public static long getSundayOfThisWeek() {
        Calendar instance = Calendar.getInstance();
        int i = instance.get(7) - 1;
        if (i == 0) {
            i = 7;
        }
        instance.add(5, (-i) + 7);
        instance.set(instance.get(1), instance.get(2), instance.get(5), 0, 0, 0);
        return instance.getTimeInMillis();
    }

    public static boolean isWeek(long j) {
        return j >= getMondayOfThisWeek() && j <= getSundayOfThisWeek();
    }

    public static String showWeekString(long j) {
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(j);
        if (2 == instance.get(7)) {
            return "星期一";
        }
        if (3 == instance.get(7)) {
            return "星期二";
        }
        if (4 == instance.get(7)) {
            return "星期三";
        }
        if (5 == instance.get(7)) {
            return "星期四";
        }
        if (6 == instance.get(7)) {
            return "星期五";
        }
        if (7 == instance.get(7)) {
            return "星期六";
        }
        return 1 == instance.get(7) ? "星期日" : "星期一";
    }

    public static boolean isYear(long j) {
        Calendar instance = Calendar.getInstance();
        int i = instance.get(1);
        instance.setTimeInMillis(j);
        if (i == instance.get(1)) {
            return true;
        }
        return false;
    }

    public static String CastsendTime(long j) {
        if (isCurrentDay(j)) {
            return long2String(j, FORMAT_DATE_HHMM);
        }
        if (isYesterday(j)) {
            return FORMAT_DATE_YESTERDAY;
        }
        if (isWeek(j)) {
            return showWeekString(j);
        }
        if (isYear(j)) {
            return long2String(j, FORMAT_DATE_MMDD);
        }
        return long2String(j, FORMAT_DATE_YYMMDD);
    }

    public static boolean isThanTime(long j, long j2, long j3) {
        return Math.abs(j - j2) >= j3;
    }

    public static String getIntervalTime(long j) {
        StringBuilder sb = new StringBuilder();
        if (isCurrentDay(j)) {
            return long2String(j, FORMAT_DATE_HHMM);
        }
        if (isYesterday(j)) {
            sb.append("昨天   ");
            sb.append(long2String(j, FORMAT_DATE_HHMM));
            return sb.toString();
        } else if (!isWeek(j)) {
            return long2String(j, FORMAT_DATE_YYMMDD_HHMM);
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(showWeekString(j));
            sb2.append("  ");
            sb.append(sb2.toString());
            sb.append(long2String(j, FORMAT_DATE_HHMM));
            return sb.toString();
        }
    }

    public static boolean sameYear(Calendar calendar, Calendar calendar2) {
        return calendar.get(1) == calendar2.get(1);
    }

    public static boolean sameMonth(Calendar calendar, Calendar calendar2) {
        if (calendar.get(1) == calendar2.get(1) && calendar.get(2) == calendar2.get(2)) {
            return true;
        }
        return false;
    }

    public static boolean sameDay(Calendar calendar, Calendar calendar2) {
        if (calendar.get(1) == calendar2.get(1) && calendar.get(2) == calendar2.get(2) && calendar.get(6) == calendar2.get(6)) {
            return true;
        }
        return false;
    }

    public static int getDayByMonth(Calendar calendar) {
        return getDayByMonth(calendar.get(1), calendar.get(2) + 1);
    }

    public static int getDayByMonth(int i, int i2) {
        if (i2 != 1) {
            switch (i2) {
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                    break;
                case 4:
                case 6:
                case 9:
                case 11:
                    return 30;
                default:
                    Calendar instance = Calendar.getInstance();
                    instance.set(i, i2 - 1, 1);
                    return instance.getActualMaximum(5);
            }
        }
        return 31;
    }

    public static boolean compareWithCurrentTime(long j) {
        return Calendar.getInstance().getTimeInMillis() <= j;
    }

    public static String getAge(long j) {
        String str;
        int ageMonth = getAgeMonth(new Date(j));
        if (ageMonth < 1) {
            return "";
        }
        if (ageMonth >= 12) {
            StringBuilder sb = new StringBuilder();
            sb.append(ageMonth / 12);
            sb.append("岁");
            str = sb.toString();
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(ageMonth);
            sb2.append("个月");
            str = sb2.toString();
        }
        return str;
    }

    public static int getAgeMonth(Date date) {
        try {
            Calendar instance = Calendar.getInstance();
            if (instance.before(date)) {
                return 0;
            }
            int i = instance.get(1);
            int i2 = instance.get(2);
            instance.get(5);
            instance.setTime(date);
            int i3 = instance.get(1);
            int i4 = instance.get(2);
            instance.get(5);
            return ((i - i3) * 12) + (i2 >= i4 ? (i2 - i4) + 1 : i2 - i4);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static String sec2Hour(long j) {
        String str;
        String str2;
        int i = (int) j;
        int i2 = i / 3600;
        int i3 = (int) ((j - ((long) (i2 * 3600))) / 60);
        int i4 = i % 60;
        String str3 = "";
        if (i2 < 10) {
            StringBuilder sb = new StringBuilder();
            sb.append("0");
            sb.append(i2);
            str = sb.toString();
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str3);
            sb2.append(i2);
            str = sb2.toString();
        }
        if (i3 < 10) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(str);
            sb3.append(":0");
            sb3.append(i3);
            str2 = sb3.toString();
        } else {
            StringBuilder sb4 = new StringBuilder();
            sb4.append(str);
            sb4.append(":");
            sb4.append(i3);
            str2 = sb4.toString();
        }
        if (i4 < 10) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append(str2);
            sb5.append(":0");
            sb5.append(i4);
            return sb5.toString();
        }
        StringBuilder sb6 = new StringBuilder();
        sb6.append(str2);
        sb6.append(":");
        sb6.append(i4);
        return sb6.toString();
    }

    public static String getIntervalTimeWithTodayOrYeaOrBefore(long j) {
        StringBuilder sb = new StringBuilder();
        if (isCurrentDay(j)) {
            return long2String(j, FORMAT_DATE_HHMM);
        }
        if (!isYesterday(j)) {
            return long2String(j, "MM-dd HH:mm");
        }
        sb.append("昨天   ");
        sb.append(long2String(j, FORMAT_DATE_HHMM));
        return sb.toString();
    }
}