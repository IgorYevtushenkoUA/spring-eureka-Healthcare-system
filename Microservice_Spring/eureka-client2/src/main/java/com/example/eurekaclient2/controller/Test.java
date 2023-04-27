package com.example.eurekaclient2.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.UUID;

public class Test {
    public static void main(String[] args) throws ParseException {
        String day = "2020-02-02";
        String hour = "14:50";
        System.out.println(parseStringToDate(day, hour));
        System.out.println();
    }

    private static LocalDateTime parseStringToDate(String day, String hour) {
//        return LocalDateTime.parse(day + " " + hour, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        return LocalDateTime.parse(String.format("%s %s", day, hour), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
    }

}
