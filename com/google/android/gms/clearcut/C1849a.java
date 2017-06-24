package com.google.android.gms.clearcut;

import android.content.Context;

public class C1849a {
    public static final C1849a f6289a = new C1849a();
    private static int f6290b = -1;

    protected C1849a() {
    }

    public int m10511a(Context context) {
        if (f6290b < 0) {
            f6290b = context.getSharedPreferences("bootCount", 0).getInt("bootCount", 1);
        }
        return f6290b;
    }
}
