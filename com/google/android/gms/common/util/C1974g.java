package com.google.android.gms.common.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.PowerManager;
import android.os.SystemClock;

public final class C1974g {
    private static IntentFilter f6606a = new IntentFilter("android.intent.action.BATTERY_CHANGED");
    private static long f6607b;
    private static float f6608c = Float.NaN;

    @TargetApi(20)
    public static int m11095a(Context context) {
        int i = 1;
        if (context == null || context.getApplicationContext() == null) {
            return -1;
        }
        Intent registerReceiver = context.getApplicationContext().registerReceiver(null, f6606a);
        int i2 = ((registerReceiver == null ? 0 : registerReceiver.getIntExtra("plugged", 0)) & 7) != 0 ? 1 : 0;
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        if (powerManager == null) {
            return -1;
        }
        int i3 = (C1974g.m11096a(powerManager) ? 1 : 0) << 1;
        if (i2 == 0) {
            i = 0;
        }
        return i3 | i;
    }

    @TargetApi(20)
    public static boolean m11096a(PowerManager powerManager) {
        return C1979l.m11115i() ? powerManager.isInteractive() : powerManager.isScreenOn();
    }

    public static synchronized float m11097b(Context context) {
        float f;
        synchronized (C1974g.class) {
            if (SystemClock.elapsedRealtime() - f6607b >= 60000 || Float.isNaN(f6608c)) {
                Intent registerReceiver = context.getApplicationContext().registerReceiver(null, f6606a);
                if (registerReceiver != null) {
                    f6608c = ((float) registerReceiver.getIntExtra("level", -1)) / ((float) registerReceiver.getIntExtra("scale", -1));
                }
                f6607b = SystemClock.elapsedRealtime();
                f = f6608c;
            } else {
                f = f6608c;
            }
        }
        return f;
    }
}
