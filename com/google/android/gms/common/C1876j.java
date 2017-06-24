package com.google.android.gms.common;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.text.TextUtils;
import com.google.android.gms.common.internal.C1944v;
import com.google.android.gms.common.util.C1973f;

public class C1876j {
    private static final C1876j f6381a = new C1876j();
    public static final int f6382b = C1881l.f6387b;

    C1876j() {
    }

    public static C1876j m10605b() {
        return f6381a;
    }

    private String m10606b(Context context, String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("gcore_");
        stringBuilder.append(f6382b);
        stringBuilder.append("-");
        if (!TextUtils.isEmpty(str)) {
            stringBuilder.append(str);
        }
        stringBuilder.append("-");
        if (context != null) {
            stringBuilder.append(context.getPackageName());
        }
        stringBuilder.append("-");
        if (context != null) {
            try {
                stringBuilder.append(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode);
            } catch (NameNotFoundException e) {
            }
        }
        return stringBuilder.toString();
    }

    public int mo1643a(Context context) {
        int b = C1881l.m10641b(context);
        return C1881l.m10643b(context, b) ? 18 : b;
    }

    public PendingIntent mo1644a(Context context, int i, int i2) {
        return mo1645a(context, i, i2, null);
    }

    public PendingIntent mo1645a(Context context, int i, int i2, String str) {
        if (C1973f.m11091a(context) && i == 2) {
            i = 42;
        }
        Intent a = mo1646a(context, i, str);
        return a == null ? null : PendingIntent.getActivity(context, i2, a, 268435456);
    }

    public Intent mo1646a(Context context, int i, String str) {
        switch (i) {
            case 1:
            case 2:
                return C1944v.m10983a("com.google.android.gms", m10606b(context, str));
            case 3:
                return C1944v.m10982a("com.google.android.gms");
            case 42:
                return C1944v.m10981a();
            default:
                return null;
        }
    }

    public boolean mo1647a(int i) {
        return C1881l.m10642b(i);
    }

    public boolean mo1648a(Context context, int i) {
        return C1881l.m10643b(context, i);
    }

    public boolean m10613a(Context context, String str) {
        return C1881l.m10639a(context, str);
    }

    public int mo1649b(Context context) {
        return C1881l.m10650i(context);
    }

    @Deprecated
    public Intent mo1650b(int i) {
        return mo1646a(null, i, null);
    }

    public void m10616c(Context context) {
        C1881l.m10646e(context);
    }
}
