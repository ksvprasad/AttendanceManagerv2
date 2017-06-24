package com.google.android.gms.p031b;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.C1319u;
import java.math.BigInteger;
import java.util.Locale;

@id
public final class jt {
    private static final Object f5521a = new Object();
    private static String f5522b;

    public static String m9147a() {
        String str;
        synchronized (f5521a) {
            str = f5522b;
        }
        return str;
    }

    public static String m9148a(Context context, String str, String str2) {
        String str3;
        synchronized (f5521a) {
            if (f5522b == null && !TextUtils.isEmpty(str)) {
                jt.m9149b(context, str, str2);
            }
            str3 = f5522b;
        }
        return str3;
    }

    private static void m9149b(Context context, String str, String str2) {
        try {
            ClassLoader classLoader = context.createPackageContext(str2, 3).getClassLoader();
            Class cls = Class.forName("com.google.ads.mediation.MediationAdapter", false, classLoader);
            BigInteger bigInteger = new BigInteger(new byte[1]);
            String[] split = str.split(",");
            BigInteger bigInteger2 = bigInteger;
            for (int i = 0; i < split.length; i++) {
                if (C1319u.m7183e().m9229a(classLoader, cls, split[i])) {
                    bigInteger2 = bigInteger2.setBit(i);
                }
            }
            f5522b = String.format(Locale.US, "%X", new Object[]{bigInteger2});
        } catch (Throwable th) {
            f5522b = "err";
        }
    }
}
