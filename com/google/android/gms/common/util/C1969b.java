package com.google.android.gms.common.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import com.google.android.gms.p031b.nn;

public class C1969b {
    public static boolean m11070a() {
        return false;
    }

    @TargetApi(12)
    public static boolean m11071a(Context context, String str) {
        if (!C1979l.m11108b()) {
            return false;
        }
        if ("com.google.android.gms".equals(str) && C1969b.m11070a()) {
            return false;
        }
        try {
            return (nn.m10162b(context).m10159a(str, 0).flags & 2097152) != 0;
        } catch (NameNotFoundException e) {
            return false;
        }
    }
}
