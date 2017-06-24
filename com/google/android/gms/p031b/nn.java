package com.google.android.gms.p031b;

import android.content.Context;

public class nn {
    private static nn f6066b = new nn();
    private nm f6067a = null;

    public static nm m10162b(Context context) {
        return f6066b.m10163a(context);
    }

    public synchronized nm m10163a(Context context) {
        if (this.f6067a == null) {
            if (context.getApplicationContext() != null) {
                context = context.getApplicationContext();
            }
            this.f6067a = new nm(context);
        }
        return this.f6067a;
    }
}
