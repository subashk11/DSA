package com.functionalprogramming;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

public class DateTimeProblems {

    // Local Date APIs
    public static void main(String[] args) {
        // Get local date and time
        LocalDate localDate = LocalDate.now();
        System.out.println(" 1. Using localDate API to get current date : "+ localDate);

        LocalTime localTime = LocalTime.now();
        System.out.println(" 2. Using localTime API to get current time : "+ localTime);

        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(" 3. Using localDateTime API to get current date and time : "+ localDateTime);



    }
}
