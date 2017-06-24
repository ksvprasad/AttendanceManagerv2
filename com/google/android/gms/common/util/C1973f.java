package com.google.android.gms.common.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;

public final class C1973f {
    private static Boolean f6602a;
    private static Boolean f6603b;
    private static Boolean f6604c;
    private static Boolean f6605d;

    @TargetApi(20)
    public static boolean m11091a(Context context) {
        if (f6604c == null) {
            boolean z = C1979l.m11115i() && context.getPackageManager().hasSystemFeature("android.hardware.type.watch");
            f6604c = Boolean.valueOf(z);
        }
        return f6604c.booleanValue();
    }

    public static boolean m11092a(Resources resources) {
        boolean z = false;
        if (resources == null) {
            return false;
        }
        if (f6602a == null) {
            boolean z2 = (resources.getConfiguration().screenLayout & 15) > 3;
            if ((C1979l.m11106a() && z2) || C1973f.m11094b(resources)) {
                z = true;
            }
            f6602a = Boolean.valueOf(z);
        }
        return f6602a.booleanValue();
    }

    @TargetApi(21)
    public static boolean m11093b(Context context) {
        if (f6605d == null) {
            boolean z = C1979l.m11117k() && context.getPackageManager().hasSystemFeature("cn.google");
            f6605d = Boolean.valueOf(z);
        }
        return f6605d.booleanValue();
    }

    @TargetApi(13)
    private static boolean m11094b(Resources resources) {
        if (f6603b == null) {
            Configuration configuration = resources.getConfiguration();
            boolean z = C1979l.m11109c() && (configuration.screenLayout & 15) <= 3 && configuration.smallestScreenWidthDp >= 600;
            f6603b = Boolean.valueOf(z);
        }
        return f6603b.booleanValue();
    }
}
