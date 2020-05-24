package com.projects.lms.utils;

import java.util.Calendar;
import java.util.Date;

public class LibraryDateUtils {
    public static final int DAYS_ALLOWED = 14;

    public static Date findDueDate(Date checkOutDate)
    {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(checkOutDate);
        calendar.add(Calendar.DATE, DAYS_ALLOWED);
        return calendar.getTime();
    }
}
