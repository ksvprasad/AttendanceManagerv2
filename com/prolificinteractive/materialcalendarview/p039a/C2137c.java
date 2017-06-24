package com.prolificinteractive.materialcalendarview.p039a;

import com.prolificinteractive.materialcalendarview.CalendarDay;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class C2137c implements C2136e {
    private final DateFormat f7186b = new SimpleDateFormat("d", Locale.getDefault());

    public String mo1782a(CalendarDay calendarDay) {
        return this.f7186b.format(calendarDay.m12217e());
    }
}
