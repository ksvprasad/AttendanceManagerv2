package com.google.android.gms.p031b;

import android.util.Log;
import com.google.android.gms.ads.internal.util.client.C1324b;

@id
public final class jv extends C1324b {
    public static boolean m9150a() {
        return ((Boolean) cq.as.m7801c()).booleanValue();
    }

    private static boolean m9151b() {
        return C1324b.m7229a(2) && jv.m9150a();
    }

    public static void m9152e(String str) {
        if (jv.m9151b()) {
            Log.v("Ads", str);
        }
    }
}
