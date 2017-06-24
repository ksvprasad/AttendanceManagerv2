package com.google.android.gms.common.stats;

import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.stats.C1962c.C1961b;
import com.google.android.gms.common.util.C1969b;
import com.google.android.gms.common.util.C1974g;
import java.util.List;

public class C1967h {
    private static String f6597a = "WakeLockTracker";
    private static C1967h f6598b = new C1967h();
    private static Boolean f6599c;

    public static C1967h m11064a() {
        return f6598b;
    }

    private static boolean m11065a(Context context) {
        if (f6599c == null) {
            f6599c = Boolean.valueOf(C1967h.m11066b(context));
        }
        return f6599c.booleanValue();
    }

    private static boolean m11066b(Context context) {
        try {
            if (!C1969b.m11070a()) {
                return false;
            }
            return ((Integer) C1961b.f6581a.m10145a()).intValue() != C1963d.f6586b;
        } catch (SecurityException e) {
            return false;
        }
    }

    public void m11067a(Context context, String str, int i, String str2, String str3, String str4, int i2, List<String> list) {
        m11068a(context, str, i, str2, str3, str4, i2, list, 0);
    }

    public void m11068a(Context context, String str, int i, String str2, String str3, String str4, int i2, List<String> list, long j) {
        if (!C1967h.m11065a(context)) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            String str5 = f6597a;
            String str6 = "missing wakeLock key. ";
            String valueOf = String.valueOf(str);
            Log.e(str5, valueOf.length() != 0 ? str6.concat(valueOf) : new String(str6));
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (7 == i || 8 == i || 10 == i || 11 == i) {
            try {
                context.startService(new Intent().setComponent(C1963d.f6585a).putExtra("com.google.android.gms.common.stats.EXTRA_LOG_EVENT", new WakeLockEvent(currentTimeMillis, i, str2, i2, C1965f.m11060a((List) list), str, SystemClock.elapsedRealtime(), C1974g.m11095a(context), str3, C1965f.m11059a(context.getPackageName()), C1974g.m11097b(context), j, str4)));
            } catch (Throwable e) {
                Log.wtf(f6597a, e);
            }
        }
    }
}
