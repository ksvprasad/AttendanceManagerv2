package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.ServiceConnection;

public abstract class C1939t {
    private static final Object f6508a = new Object();
    private static C1939t f6509b;

    public static C1939t m10955a(Context context) {
        synchronized (f6508a) {
            if (f6509b == null) {
                f6509b = new C1943u(context.getApplicationContext());
            }
        }
        return f6509b;
    }

    public abstract boolean mo1713a(String str, String str2, ServiceConnection serviceConnection, String str3);

    public abstract void mo1714b(String str, String str2, ServiceConnection serviceConnection, String str3);
}
