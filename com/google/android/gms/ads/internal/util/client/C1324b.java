package com.google.android.gms.ads.internal.util.client;

import android.util.Log;
import com.google.android.gms.p031b.id;

@id
public class C1324b {
    public static void m7227a(String str) {
        if (C1324b.m7229a(3)) {
            Log.d("Ads", str);
        }
    }

    public static void m7228a(String str, Throwable th) {
        if (C1324b.m7229a(3)) {
            Log.d("Ads", str, th);
        }
    }

    public static boolean m7229a(int i) {
        return i >= 5 || Log.isLoggable("Ads", i);
    }

    public static void m7230b(String str) {
        if (C1324b.m7229a(6)) {
            Log.e("Ads", str);
        }
    }

    public static void m7231b(String str, Throwable th) {
        if (C1324b.m7229a(6)) {
            Log.e("Ads", str, th);
        }
    }

    public static void m7232c(String str) {
        if (C1324b.m7229a(4)) {
            Log.i("Ads", str);
        }
    }

    public static void m7233c(String str, Throwable th) {
        if (C1324b.m7229a(4)) {
            Log.i("Ads", str, th);
        }
    }

    public static void m7234d(String str) {
        if (C1324b.m7229a(5)) {
            Log.w("Ads", str);
        }
    }

    public static void m7235d(String str, Throwable th) {
        if (C1324b.m7229a(5)) {
            Log.w("Ads", str, th);
        }
    }
}
