package com.prolificinteractive.materialcalendarview;

import java.util.Calendar;
import java.util.Date;

public class C2142b {
    public static Calendar m12274a() {
        Calendar instance = Calendar.getInstance();
        C2142b.m12277a(instance, instance);
        return instance;
    }

    public static Calendar m12275a(Date date) {
        Calendar instance = Calendar.getInstance();
        if (date != null) {
            instance.setTime(date);
        }
        C2142b.m12277a(instance, instance);
        return instance;
    }

    public static void m12276a(Calendar calendar) {
        int b = C2142b.m12278b(calendar);
        int c = C2142b.m12279c(calendar);
        calendar.clear();
        calendar.set(b, c, 1);
        calendar.getTimeInMillis();
    }

    public static void m12277a(Calendar calendar, Calendar calendar2) {
        int b = C2142b.m12278b(calendar);
        int c = C2142b.m12279c(calendar);
        int d = C2142b.m12280d(calendar);
        calendar2.clear();
        calendar2.set(b, c, d);
        calendar2.getTimeInMillis();
    }

    public static int m12278b(Calendar calendar) {
        return calendar.get(1);
    }

    public static int m12279c(Calendar calendar) {
        return calendar.get(2);
    }

    public static int m12280d(Calendar calendar) {
        return calendar.get(5);
    }

    public static int m12281e(Calendar calendar) {
        return calendar.get(7);
    }
}
