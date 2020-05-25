package com.projects.lms.utils;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import static com.projects.lms.utils.Constants.LATE_DAYS_ALLOWED;

public class LibraryDateUtils {

    public static Date findDueDate(Date checkOutDate)
    {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(checkOutDate);
        calendar.add(Calendar.DATE, LATE_DAYS_ALLOWED);
        return calendar.getTime();
    }

    public static Long findDaysElapsed(Date date)
    {
        long dateDiffInMillis = date.getTime() - new Date().getTime();
        return TimeUnit.DAYS.convert(dateDiffInMillis, TimeUnit.MILLISECONDS);
    }
}
