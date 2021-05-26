package com.example.admin.utils;

import java.time.format.DateTimeFormatter;

public class CommonUtil {

    public static DateTimeFormatter DEFAULT_DATETIME_FORMAT = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
    public static DateTimeFormatter DEFAULT_DATE_FORMAT = DateTimeFormatter.ofPattern("yyyyMMdd");
}
