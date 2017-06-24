package com.prolificinteractive.materialcalendarview.p039a;

import com.prolificinteractive.materialcalendarview.CalendarDay;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class C2139d implements C2138g {
    private final DateFormat f7187a = new SimpleDateFormat("MMMM yyyy", Locale.getDefault());

    public CharSequence mo1783a(CalendarDay calendarDay) {
        return this.f7187a.format(calendarDay.m12217e());
    }
}
