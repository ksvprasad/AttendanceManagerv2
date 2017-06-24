package com.prolificinteractive.materialcalendarview.p039a;

import android.text.SpannableStringBuilder;
import com.prolificinteractive.materialcalendarview.CalendarDay;

public class C2140f implements C2138g {
    private final CharSequence[] f7188a;

    public C2140f(CharSequence[] charSequenceArr) {
        if (charSequenceArr == null) {
            throw new IllegalArgumentException("Label array cannot be null");
        } else if (charSequenceArr.length < 12) {
            throw new IllegalArgumentException("Label array is too short");
        } else {
            this.f7188a = charSequenceArr;
        }
    }

    public CharSequence mo1783a(CalendarDay calendarDay) {
        return new SpannableStringBuilder().append(this.f7188a[calendarDay.m12215c()]).append(" ").append(String.valueOf(calendarDay.m12212b()));
    }
}
