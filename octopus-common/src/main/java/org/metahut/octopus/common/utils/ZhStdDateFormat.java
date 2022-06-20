package org.metahut.octopus.common.utils;

import com.fasterxml.jackson.databind.util.StdDateFormat;

import java.text.ParseException;
import java.text.ParsePosition;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ZhStdDateFormat extends StdDateFormat {

    private static Pattern ZH_DEFAULT_YYYY_MM_DD_HH_MM_SS_SSS = Pattern.compile("\\d\\d\\d\\d[-/.]\\d\\d[-/.]\\d\\d \\d\\d[:]\\d\\d(?:[:]\\d\\d)?(?:[\\.]\\d{1,3})?");

    private static TimeZone ZH_TIMEZONE = TimeZone.getTimeZone("GMT+8");

    private static final int YYYY_MM_DD_LENGTH = 10;

    private static final int YYYY_MM_DD_HH_MM_SS_LENGTH = 16;

    private static final int MILLI_SECOND_LEN = 19;

    private static final char TIME_SECOND_SPLIT_SIGN = ':';

    private static final char TIME_MILLISECOND_SPLIT_SIGN = '.';

    public ZhStdDateFormat() {
    }

    public ZhStdDateFormat(TimeZone tz, Locale loc, Boolean lenient, boolean formatTzOffsetWithColon) {
        super(tz, loc, lenient, formatTzOffsetWithColon);
    }

    @Override
    protected boolean looksLikeISO8601(String dateStr) {
        if (dateStr.length() >= 7 && Character.isDigit(dateStr.charAt(0))
            && Character.isDigit(dateStr.charAt(3))
            && (dateStr.charAt(4) == '-' || dateStr.charAt(4) == '/' || dateStr.charAt(4) == '.')
            && Character.isDigit(dateStr.charAt(5))) {
            return true;
        }
        return false;
    }

    @Override
    protected Date parseAsISO8601(String dateStr, ParsePosition bogus) throws IllegalArgumentException, ParseException {
        final int totalLen = dateStr.length();
        if (totalLen > YYYY_MM_DD_LENGTH) {
            Matcher m = ZH_DEFAULT_YYYY_MM_DD_HH_MM_SS_SSS.matcher(dateStr);
            if (!m.matches()) {
                return super.parseAsISO8601(dateStr, bogus);
            }
            Calendar cal = _getCalendar(ZH_TIMEZONE);
            int year = parse4D1(dateStr, 0);
            int month = parse2D1(dateStr, 5) - 1;
            int day = parse2D1(dateStr, 8);

            int hour = parse2D1(dateStr, 11);
            int minute = parse2D1(dateStr, 14);

            int seconds = 0;
            if ((totalLen > YYYY_MM_DD_HH_MM_SS_LENGTH) && dateStr.charAt(YYYY_MM_DD_HH_MM_SS_LENGTH) == TIME_SECOND_SPLIT_SIGN) {
                seconds = parse2D1(dateStr, 17);
            }
            int millisecond = 0;

            if ((totalLen > MILLI_SECOND_LEN) && dateStr.charAt(MILLI_SECOND_LEN) == TIME_MILLISECOND_SPLIT_SIGN) {
                millisecond = parse3D1(dateStr, 20);
            }
            cal.set(Calendar.MILLISECOND, 0);
            cal.set(year, month, day, hour, minute, seconds);
            cal.set(Calendar.MILLISECOND, millisecond);
            return cal.getTime();

        }
        return super.parseAsISO8601(dateStr, bogus);
    }

    @Override
    public StdDateFormat clone() {
        return new ZhStdDateFormat(super._timezone, super._locale, super._lenient, super.isColonIncludedInTimeZone());
    }

    private static int parse4D1(String str, int index) {
        return (1000 * (str.charAt(index) - '0'))
            + (100 * (str.charAt(index + 1) - '0'))
            + (10 * (str.charAt(index + 2) - '0'))
            + (str.charAt(index + 3) - '0');
    }

    private static int parse2D1(String str, int index) {
        return (10 * (str.charAt(index) - '0'))
            + (str.charAt(index + 1) - '0');
    }

    private static int parse3D1(String str, int index) {
        return (100 * (str.charAt(index) - '0'))
            + (10 * (str.charAt(index + 1) - '0'))
            + (str.charAt(index + 2) - '0');
    }
}