package com.prolificinteractive.materialcalendarview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build.VERSION;
import android.widget.TextView;
import com.prolificinteractive.materialcalendarview.p039a.C2133h;
import java.util.Calendar;

@SuppressLint({"ViewConstructor"})
class C2160m extends TextView {
    private C2133h f7226a = C2133h.f7182a;
    private int f7227b;

    public C2160m(Context context, int i) {
        super(context);
        setGravity(17);
        if (VERSION.SDK_INT >= 17) {
            setTextAlignment(4);
        }
        m12331a(i);
    }

    public void m12331a(int i) {
        this.f7227b = i;
        setText(this.f7226a.mo1781a(i));
    }

    public void m12332a(C2133h c2133h) {
        if (c2133h == null) {
            c2133h = C2133h.f7182a;
        }
        this.f7226a = c2133h;
        m12331a(this.f7227b);
    }

    public void m12333a(Calendar calendar) {
        m12331a(C2142b.m12281e(calendar));
    }
}
