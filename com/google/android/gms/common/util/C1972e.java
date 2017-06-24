package com.google.android.gms.common.util;

import android.os.SystemClock;

public final class C1972e implements C1970c {
    private static C1972e f6601a;

    public static synchronized C1970c m11087d() {
        C1970c c1970c;
        synchronized (C1972e.class) {
            if (f6601a == null) {
                f6601a = new C1972e();
            }
            c1970c = f6601a;
        }
        return c1970c;
    }

    public long mo1723a() {
        return System.currentTimeMillis();
    }

    public long mo1724b() {
        return SystemClock.elapsedRealtime();
    }

    public long mo1725c() {
        return System.nanoTime();
    }
}
