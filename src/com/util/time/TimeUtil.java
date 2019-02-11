package com.util.time;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class TimeUtil {

    public static String convertToBasic(LocalDate localDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        return localDate.format(formatter);
    }

    public static String convertToMMdd(LocalDate localDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMdd");
        return localDate.format(formatter);
    }

    public static String convertToHHmmss(LocalTime localTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HHmmss");
        return localTime.format(formatter);
    }

    public static String convertToBasic(LocalDateTime localDateTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        return localDateTime.format(formatter);
    }

    public static String convertToYyyyMMddHHmmss(LocalDateTime localDateTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        return localDateTime.format(formatter);
    }

    public static String convertToYyyyMMddHHmmss2(LocalDateTime localDateTime) {
        if (null == localDateTime) {
            return null;
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd HH:mm:ss");
        return localDateTime.format(formatter);
    }

    public static String convertToYyyyMMddHHmmss3(LocalDateTime localDateTime) {
        if (null == localDateTime) {
            return null;
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        return localDateTime.format(formatter);
    }

    public static LocalDate convertFromBasic(String date) {
        return LocalDate.parse(date, DateTimeFormatter.BASIC_ISO_DATE);
    }

    public static LocalDate convertFromYyMMdd(String date) {
        return LocalDate.parse(date, DateTimeFormatter.ofPattern("yyMMdd"));
    }

    public static LocalDate convertFromYyyyMMdd(String date) {
        return LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyyMMdd"));
    }

    public static LocalDate getStartOfMonth(LocalDate localDate) {
        Month month = localDate.getMonth();
        int year = localDate.getYear();
        return LocalDate.of(year, month, 1);
    }

    public static LocalDateTime convertToUtc(LocalDateTime ldt) {
        ZonedDateTime ldtZoned = ldt.atZone(ZoneId.systemDefault());
        ZonedDateTime utcZoned = ldtZoned.withZoneSameInstant(ZoneId.of("UTC"));

//        log.debug("local time zone: ", ldtZoned.toLocalDateTime().toString());
//        log.debug("utc time zone: ", utcZoned.toLocalDateTime().toString());

        return utcZoned.toLocalDateTime();
    }

    public static String convertToMMddHHmmss(LocalDateTime ldt) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMddHHmmss");
        return ldt.format(dtf);
    }

    public static String convertToUtcMMddHHmmss(LocalDateTime ldt) {
        LocalDateTime utcLdt = convertToUtc(ldt);
        return convertToMMddHHmmss(utcLdt);
    }

    public static LocalDateTime convertToLocalDateTime(Date date) {
        return LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
    }

    public static Date convertToDate(LocalDateTime ldt) {
        return Date.from(ldt.atZone(ZoneId.systemDefault()).toInstant());
    }

    public static LocalDateTime convertFromMMddHHmmss(String date) {
        return LocalDateTime.parse(date, DateTimeFormatter.ofPattern("MMddHHmmss"));
    }

    public static LocalDateTime convertFromYyyyMMddHHmmss(String date) {
        return LocalDateTime.parse(date, DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
    }

    public static String convertToYyyyMM(LocalDate localDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMM");
        return localDate.format(formatter);
    }

    public static String convertToYyyyMMdd(LocalDate localDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        return localDate.format(formatter);
    }

}
