package com.prolificinteractive.materialcalendarview.p039a;

import com.prolificinteractive.materialcalendarview.C2142b;
import java.util.Calendar;
import java.util.Locale;

public class C2135b implements C2133h {
    private final Calendar f7184b;

    public C2135b() {
        this.f7184b = C2142b.m12274a();
    }

    public C2135b(Calendar calendar) {
        this.f7184b = calendar;
    }

    public CharSequence mo1781a(int i) {
        this.f7184b.set(7, i);
        return this.f7184b.getDisplayName(7, 1, Locale.getDefault());
    }
}
