package com.google.android.gms.common.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.util.Log;
import com.google.android.gms.common.C1957m;
import com.google.android.gms.p031b.nn;

public final class C1983p {
    public static boolean m11125a(Context context, int i) {
        boolean z = false;
        if (!C1983p.m11126a(context, i, "com.google.android.gms")) {
            return z;
        }
        try {
            return C1957m.m11001a(context).m11004a(context.getPackageManager(), context.getPackageManager().getPackageInfo("com.google.android.gms", 64));
        } catch (NameNotFoundException e) {
            if (!Log.isLoggable("UidVerifier", 3)) {
                return z;
            }
            Log.d("UidVerifier", "Package manager can't find google play services package, defaulting to false");
            return z;
        }
    }

    @TargetApi(19)
    public static boolean m11126a(Context context, int i, String str) {
        return nn.m10162b(context).m10160a(i, str);
    }
}
