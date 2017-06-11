package com.vilens.linzi.em.crm.utils;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import jodd.datetime.JDateTime;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.commons.lang.time.DateUtils;
import org.apache.log4j.Logger;

/**
 * Created by vilens on 2017/6/1.
 */
public class TimeUtil extends DateUtils {
    private static final Logger logger = Logger.getLogger(TimeUtil.class);
    /** @deprecated */
    @Deprecated
    public static final String dateFormatMonth = "yyyy-MM";
    /** @deprecated */
    @Deprecated
    public static final String dateFormatYear = "yyyy-MM-dd";
    /** @deprecated */
    @Deprecated
    public static final String dateFormatDay = "yyyy-MM-dd";
    public static final String dateFormateHour = "yyyy-MM-dd HH";
    public static final String dateFormateMinu = "yyyy-MM-dd HH:mm";
    /** @deprecated */
    @Deprecated
    public static final String dateFormatStr = "yyyy-MM-dd HH:mm:ss";
    /** @deprecated */
    @Deprecated
    public static final String dateFormatStr2 = "yyyy-MM-dd";
    /** @deprecated */
    @Deprecated
    public static final String SHORT_FORMAT_YEAR = "yyyyMMdd";
    /** @deprecated */
    @Deprecated
    public static final String SHORT_DATE_STR = "yyyy-MM-dd";
    /** @deprecated */
    @Deprecated
    public static final String SHORT_MONTH_STR = "yyyy-MM";
    public static final String FORMAT_FULL_ZONE = "yyyy.MM.dd G 'at' hh:mm:ss z";
    public static final String FORMAT_FULL_ZONE_FOR_T = "yyyy-MM-dd'T'HH:mm:ss.SSSZ";
    public static final String FORMAT_SHORT_NO_SIGN = "yyyyMMdd";
    public static final String FORMAT_SHORT_SLASH = "yyyy/MM/dd";
    public static final String FORMAT_SHORT = "yyyy-MM-dd";
    public static final String FORMAT_CSV_DATA = "yyyy/MM/dd HH:mm";
    public static final String FORMAT_YEAR_MONTH = "yyyy-MM";
    public static final String FORMAT_LONG_MIN = "yyyy-MM-dd HH:mm";
    public static final String FORMAT_LONG = "yyyy-MM-dd HH:mm:ss";
    public static final String FORMAT_FULL = "yyyy-MM-dd HH:mm:ss.S";
    public static final String FORMAT_SHORT_CN = "yyyy年MM月dd";
    public static final String FORMAT_LONG_CN = "yyyy年MM月dd日  HH时mm分ss秒";
    public static final String FORMAT_FULL_CN = "yyyy年MM月dd日  HH时mm分ss秒SSS毫秒";
    public static final String[] TIME_TYPES = new String[]{"s", "S", "m", "h", "E", "H", "M", "d", "D", "y", "Y"};
    public static final String[] parsePatterns = new String[]{"yyyy-MM-dd'T'HH:mm:ss.SSSZ", "yyyy.MM.dd G 'at' hh:mm:ss z", "yyyy-MM-dd HH:mm:ss.S", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd", "yyyyMMdd", "yyyy/MM/dd", "yyyy/MM/dd HH:mm", "yyyy-MM-dd HH:mm"};

    public TimeUtil() {
    }

    /** @deprecated */
    public static String getNowDateStr() {
        return DateFormatUtils.format(calendar(), "yyyy-MM-dd HH:mm:ss");
    }

    /** @deprecated */
    public static String getStrFromDate(Date date) {
        return DateFormatUtils.format(date, "yyyy-MM-dd HH:mm:ss");
    }

    /** @deprecated */
    public static String getStrFromDate(Calendar date) {
        return DateFormatUtils.format(date, "yyyy-MM-dd HH:mm:ss");
    }

    /** @deprecated */
    public static String getStrDateByFormate(Date date, String formate) {
        return DateFormatUtils.format(date, formate);
    }

    public static String format() {
        return DateFormatUtils.format(millis(), "yyyy-MM-dd HH:mm:ss");
    }

    public static String format(Date date) {
        return DateFormatUtils.format(date, "yyyy-MM-dd HH:mm:ss");
    }

    public static String format(Calendar date) {
        return DateFormatUtils.format(date, "yyyy-MM-dd HH:mm:ss");
    }

    public static String format(long millis) {
        return format(new Date(millis), "yyyy-MM-dd HH:mm:ss");
    }

    public static String format(Date date, String pattern) {
        return DateFormatUtils.format(date, pattern);
    }

    public static String format(long millis, String pattern) {
        return DateFormatUtils.format(new Date(millis), pattern, (TimeZone)null, (Locale)null);
    }

    public static String format(Calendar calendar, String pattern) {
        return DateFormatUtils.format(calendar, pattern, (TimeZone)null, (Locale)null);
    }

    public static Date getDateFromStr(String dateStr) {
        Date resultDate = null;

        try {
            resultDate = DateUtils.parseDate(dateStr, parsePatterns);
        } catch (ParseException var3) {
            logger.error("dateStr = " + dateStr + " can't change to Date!");
            logger.error(var3.getMessage());
            resultDate = new Date();
        }

        return resultDate;
    }

    public static Date getDateByString(String str) {
        Date time = null;

        try {
            SimpleDateFormat sf = new SimpleDateFormat("yyyyMMddHHmm");
            time = sf.parse(str);
            return time;
        } catch (Exception var3) {
            logger.error(var3.getMessage());
            return null;
        }
    }

    public static Date getDateByString(String str, String formate) {
        Date time = null;

        try {
            SimpleDateFormat sf = new SimpleDateFormat(formate);
            time = sf.parse(str);
            return time;
        } catch (Exception var4) {
            logger.error(var4.getMessage());
            return null;
        }
    }

    public static String getTodayStr() {
        return DateFormatUtils.format(calendar(), "yyMMdd");
    }

    public static Date getBeforeDay(Date date, int day) {
        return DateUtils.addDays(date, day);
    }

    public static Date getBeforeDay(int day) {
        return getBeforeDay(new Date(), day);
    }

    public static Date getBeforeMonth(Date date, int month) {
        return DateUtils.addMonths(date, month);
    }

    public static Date getBeforeMonth(String date, int month) {
        return getBeforeMonth(calendar(date).getTime(), month);
    }

    public static Date getBeforeHour(Date date, int hour) {
        return DateUtils.addHours(date, hour);
    }

    public static Date getBeforeMin(Date date, int min) {
        return DateUtils.addMinutes(date, min);
    }

    public static Date getBeforeSec(Date date, int sec) {
        return DateUtils.addSeconds(date, sec);
    }

    public static Timestamp toTimestamp(Date date) {
        return new Timestamp(date.getTime());
    }

    public static long millis() {
        return System.currentTimeMillis();
    }

    public static int month(Calendar calendar) {
        return calendar.get(2) + 1;
    }

    public static int dayOfMonth(Calendar calendar) {
        return calendar.get(5);
    }

    public static int dayOfWeek(Calendar calendar) {
        return calendar.get(7);
    }

    public static int dayOfYear(Calendar calendar) {
        return calendar.get(6);
    }

    public static boolean isBefore(Date src, Date dst) {
        return src.before(dst);
    }

    public static boolean isAfter(Date src, Date dst) {
        return src.after(dst);
    }

    public static boolean isEqual(Date date1, Date date2) {
        return date1.compareTo(date2) == 0;
    }

    public static int compareDate(Date source, Date target) {
        return source.compareTo(target);
    }

    public static boolean compareDate(Date source, Date target, int... arr) {
        return ArrayUtils.contains(arr, source.compareTo(target));
    }

    public static Date today() {
        JDateTime jdt = new JDateTime(System.currentTimeMillis());
        jdt = new JDateTime(jdt.getYear(), jdt.getMonth(), jdt.getDay());
        return jdt.convertToDate();
    }

    public static Date tomorrow() {
        JDateTime jdt = new JDateTime(System.currentTimeMillis());
        jdt = new JDateTime(jdt.getYear(), jdt.getMonth(), jdt.getDay());
        return jdt.addDay(1).convertToDate();
    }

    public static Date yesterday() {
        JDateTime jdt = new JDateTime(System.currentTimeMillis());
        jdt = new JDateTime(jdt.getYear(), jdt.getMonth(), jdt.getDay());
        return jdt.subDay(1).convertToDate();
    }

    public static Date now() {
        JDateTime jdt = new JDateTime(System.currentTimeMillis());
        return jdt.convertToDate();
    }

    public static Calendar calendar() {
        Calendar calendar = GregorianCalendar.getInstance();
        return calendar;
    }

    public static Calendar calendar(String dateStr) {
        return calendar(dateStr, (Calendar)null);
    }

    public static Calendar calendar(String dateStr, Calendar reserve) {
        Date date = parseDate(dateStr, (String[])parsePatterns, (Date)null);
        return date == null?reserve:calendar(date);
    }

    public static Date trueTime(Object obj) {
        return trueTime(obj, (Date)null);
    }

    public static Date trueTime(Object obj, Date reserve) {
        return obj == null?reserve:(obj instanceof String?parseDate(obj.toString(), parsePatterns, reserve):(obj instanceof Date?(Date)obj:(obj instanceof Long?new Date(((Long)obj).longValue()):(obj instanceof Calendar?((Calendar)obj).getTime():reserve))));
    }

    public static Date parseDate(String str) throws ParseException {
        return DateUtils.parseDate(str, parsePatterns);
    }

    public static Date softParseDate(String str) {
        try {
            return DateUtils.parseDate(str, parsePatterns);
        } catch (Exception var2) {
            return null;
        }
    }

    public static Date softParseDate(String str, String... parsePatterns) {
        try {
            return DateUtils.parseDate(str, parsePatterns);
        } catch (Exception var3) {
            return null;
        }
    }

    public static Date softParseDate(String str, Date reserve) {
        return parseDate(str, reserve);
    }

    public static Date parseDate(String str, String parsePattern) throws ParseException {
        String[] stringArray = { parsePattern };
        return DateUtils.parseDate(str, stringArray);
    }

    public static Date parseDate(String str, Date reserve) {
        return parseDate(str, parsePatterns, reserve);
    }

    public static Date parseDate(String str, String parsePattern, Date reserve) {
        String[] stringArray = { parsePattern };
        return parseDate(str, stringArray, reserve);
    }

    public static Date parseDate(String str, String[] parsePatterns, Date reserve) {
        try {
            return StringUtil.isBlank(str)?reserve:(ArrayUtils.isEmpty(parsePatterns)?reserve:DateUtils.parseDate(str, parsePatterns));
        } catch (ParseException var4) {
            return reserve;
        }
    }

    public static Calendar calendar(Date date) {
        if(date == null) {
            return null;
        } else {
            Calendar calendar = GregorianCalendar.getInstance();
            calendar.setTime(date);
            return calendar;
        }
    }

    public static Calendar calendar(Date date, int firstDayOfWeek) {
        Calendar calendar = GregorianCalendar.getInstance();
        calendar.setTime(date);
        calendar.setFirstDayOfWeek(firstDayOfWeek);
        return calendar;
    }

    public static boolean between(Date beginDate, Date endDate, Date src) {
        return beginDate.before(src) && endDate.after(src);
    }

    public static Calendar firstDayOfMonth(Calendar calendar) {
        calendar.set(5, calendar.getActualMinimum(5));
        calendar.set(11, calendar.getActualMinimum(11));
        calendar.set(12, calendar.getActualMinimum(12));
        calendar.set(13, calendar.getActualMinimum(13));
        calendar.set(14, calendar.getActualMinimum(14));
        return firstTimeOfDay(calendar);
    }

    public static Calendar lastDayOfMonth(Calendar calendar) {
        calendar.set(5, calendar.getActualMaximum(5));
        return lastTimeOfDay(calendar);
    }

    public static Calendar firstDayOfWeek(Calendar calendar, Integer firstDayOfWeek) {
        if(firstDayOfWeek != null) {
            calendar.setFirstDayOfWeek(firstDayOfWeek.intValue());
        }

        int d = calendar.get(7);
        int s = calendar.getFirstDayOfWeek();
        int day_of_week = d > s?d - s:s - d;
        calendar.add(5, -day_of_week);
        return firstTimeOfDay(calendar);
    }

    public static Calendar lastDayOfWeek(Calendar calendar, Integer firstDayOfWeek) {
        calendar = firstDayOfWeek(calendar, firstDayOfWeek);
        calendar.add(5, 6);
        return lastTimeOfDay(calendar);
    }

    public static Calendar firstDayOfYear(Calendar calendar) {
        calendar.set(2, calendar.getActualMinimum(2));
        return firstDayOfMonth(calendar);
    }

    public static Calendar lastDayOfYear(Calendar calendar) {
        calendar.set(2, calendar.getActualMaximum(2));
        return lastDayOfMonth(calendar);
    }

    public static Calendar firstTimeOfDay(Calendar calendar) {
        calendar.set(11, calendar.getActualMinimum(11));
        return firstTimeOfHour(calendar);
    }

    public static Calendar lastTimeOfDay(Calendar calendar) {
        calendar.set(11, calendar.getActualMaximum(11));
        return lastTimeOfHour(calendar);
    }

    public static Calendar firstTimeOfHour(Calendar calendar) {
        calendar.set(12, calendar.getActualMinimum(12));
        calendar.set(13, calendar.getActualMinimum(13));
        calendar.set(14, calendar.getActualMinimum(14));
        return calendar;
    }

    public static Calendar lastTimeOfHour(Calendar calendar) {
        calendar.set(12, calendar.getActualMaximum(12));
        calendar.set(13, calendar.getActualMaximum(13));
        calendar.set(14, calendar.getActualMaximum(14));
        return calendar;
    }

    public static Calendar firstTimeOrDate(Calendar calendar, int field) {
        if(calendar == null) {
            return null;
        } else {
            switch(field) {
                case 1:
                    return firstDayOfYear(calendar);
                case 2:
                    return firstDayOfMonth(calendar);
                case 3:
                case 6:
                case 7:
                case 8:
                case 9:
                case 10:
                default:
                    return null;
                case 4:
                    return firstDayOfWeek(calendar, Integer.valueOf(2));
                case 5:
                    return firstTimeOfDay(calendar);
                case 11:
                    return firstTimeOfHour(calendar);
            }
        }
    }

    public static Calendar lastTimeOrDate(Calendar calendar, int field) {
        if(calendar == null) {
            return null;
        } else {
            switch(field) {
                case 1:
                    return lastDayOfYear(calendar);
                case 2:
                    return lastDayOfMonth(calendar);
                case 3:
                case 6:
                case 7:
                case 8:
                case 9:
                case 10:
                default:
                    return null;
                case 4:
                    return lastDayOfWeek(calendar, Integer.valueOf(2));
                case 5:
                    return lastTimeOfDay(calendar);
                case 11:
                    return lastTimeOfHour(calendar);
            }
        }
    }

    public static long fromDateStringToLong(String inVal) {
        Date date = null;
        SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        try {
            date = inputFormat.parse(inVal);
        } catch (Exception var4) {
            var4.printStackTrace();
        }

        return date.getTime();
    }

    public static String fromLongToDate(long inVal) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date currentTime = new Date(inVal);
        return sdf.format(currentTime);
    }

    public static Date fromDateStringToDate(String inVal) {
        Date date = null;
        SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        try {
            date = inputFormat.parse(inVal);
        } catch (Exception var4) {
            var4.printStackTrace();
        }

        return date;
    }

    public static List<String> buildPeriodTimeList(String startTime, String endTime, int per_hour_frequency) {
        int countTime = countPeriodTimeDuring1Day(startTime, endTime, per_hour_frequency);
        int addTimeSecond = 3600 / per_hour_frequency;
        List<String> timeList = new ArrayList();
        int i = 0;

        for(int count = countTime + 1; i < count; ++i) {
            String time = null;
            if(i == 0) {
                time = startTime;
            } else {
                time = (String)timeList.get(i - 1);
                time = DateFormatUtils.format(DateUtils.addSeconds(fromDateStringToDate(time), addTimeSecond), "yyyy-MM-dd HH:mm:ss");
            }

            timeList.add(time);
        }

        return timeList;
    }

    public static int countPeriodTimeDuring1Day(String startTime, String endTime, int per_hour_frequency) {
        int countNumber = 0;
        long startT = fromDateStringToLong(startTime);
        long endT = fromDateStringToLong(endTime);
        long mint = (endT - startT) / 1000L;
        countNumber = (int)(mint / (long)(3600 / per_hour_frequency));
        return countNumber;
    }

    public static double exchangeTime(String[] array, String toTimeType) {
        toTimeType = StringUtil.defaultIfBlank(toTimeType, "m");
        array = ArrayUtils.nullToEmpty(array);
        double result = 0.0D;
        double timeValue = 0.0D;
        String timeType = "";
        if(array.length % 2 != 0) {
            return result;
        } else {
            for(int i = 1; i < array.length + 1; ++i) {
                String object = array[i - 1];
                if(i % 2 == 0) {
                    timeType = StringUtil.defaultIfBlank(object, "");
                    result += exchangeTime(timeValue, timeType, toTimeType);
                } else {
                    try {
                        timeValue = (double)Long.parseLong(StringUtil.defaultIfBlank(object, "0"));
                    } catch (NumberFormatException var10) {
                        return (double)Long.valueOf(0L).longValue();
                    }
                }
            }

            return result;
        }
    }

    public static double exchangeTime(double timeValue, String timeType, String toTimeType) {
        if(!ArrayUtils.contains(TIME_TYPES, timeType)) {
            return (double)Long.valueOf(0L).longValue();
        } else if(!ArrayUtils.contains(TIME_TYPES, toTimeType)) {
            return (double)Long.valueOf(0L).longValue();
        } else if(timeType == toTimeType) {
            return timeValue;
        } else {
            double one = getExchangeRate(timeType);
            double two = getExchangeRate(toTimeType);
            double rate;
            if(one > two) {
                rate = two == 0.0D?one:one / two;
                return timeValue * rate;
            } else {
                rate = one == 0.0D?two:two / one;
                return timeValue / rate;
            }
        }
    }

    private static double getExchangeRate(String timeType) {
        double exchangeRate = 0.0D;
        if(StringUtil.equals(timeType, "S")) {
            exchangeRate = 1.0D;
        }

        if(StringUtil.equals(timeType, "s")) {
            exchangeRate = 1000.0D;
        }

        if(StringUtil.equals(timeType, "m")) {
            exchangeRate = 60000.0D;
        }

        if(StringUtil.equalsIgnoreCase(timeType, "h")) {
            exchangeRate = 3600000.0D;
        }

        if(StringUtil.equalsIgnoreCase(timeType, "d")) {
            exchangeRate = 8.64E7D;
        }

        if(StringUtil.equals(timeType, "E")) {
            exchangeRate = 6.048E8D;
        }

        if(StringUtil.equals(timeType, "M")) {
            exchangeRate = 2.592E9D;
        }

        if(StringUtil.equalsIgnoreCase(timeType, "y")) {
            exchangeRate = 3.1536E10D;
        }

        return exchangeRate;
    }

    public static Date getEndDayForMonth(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(5, 1);
        cal.roll(5, -1);
        return cal.getTime();
    }

    public static long getTimeDistance(TimeUnit unit, Date one, Date two) {
        long diff = one.getTime() - two.getTime();
        return unit.convert(diff, TimeUnit.MILLISECONDS);
    }

    public static long getTimeDistance(TimeUnit unit, Long diff) {
        return unit.convert(diff.longValue(), TimeUnit.MILLISECONDS);
    }

    public static List<Date> splitTimeForDay(Date beginTime, Date endTime) {
        return splitTime(beginTime, endTime, 5, 1);
    }

    public static List<Date> splitTime(Date beginTime, Date endTime, int field, int amount) {
        if(beginTime.after(endTime)) {
            return new ArrayList();
        } else {
            List<Date> days = new ArrayList();
            Calendar b = calendar(beginTime);
            Calendar e = calendar(endTime);

            while(b.getTimeInMillis() <= e.getTimeInMillis()) {
                days.add(b.getTime());
                b.add(field, amount);
            }

            return days;
        }
    }


    public static void main(String[] args) {
        System.out.println(new Date());
    }

}
