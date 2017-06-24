package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.content.Intent;
import com.google.android.gms.common.internal.C1896c;
import com.google.android.gms.p031b.oc;

public final class ag {
    static final Object f6788a = new Object();
    static oc f6789b;
    static Boolean f6790c;

    public static boolean m11378a(Context context) {
        C1896c.m10790a((Object) context);
        if (f6790c != null) {
            return f6790c.booleanValue();
        }
        boolean a = C2082m.m11749a(context, "com.google.android.gms.measurement.AppMeasurementReceiver", false);
        f6790c = Boolean.valueOf(a);
        return a;
    }

    public void m11379a(Context context, Intent intent) {
        aj a = aj.m11458a(context);
        ab f = a.m11502f();
        if (intent == null) {
            f.m11310z().m11249a("AppMeasurementReceiver called with null intent");
            return;
        }
        String action = intent.getAction();
        if (a.m11499d().m11833O()) {
            f.m11283E().m11250a("Device AppMeasurementReceiver got", action);
        } else {
            f.m11283E().m11250a("Local AppMeasurementReceiver got", action);
        }
        if ("com.google.android.gms.measurement.UPLOAD".equals(action)) {
            boolean a2 = C2069f.m11661a(context);
            Intent className = new Intent().setClassName(context, "com.google.android.gms.measurement.AppMeasurementService");
            className.setAction("com.google.android.gms.measurement.UPLOAD");
            synchronized (f6788a) {
                context.startService(className);
                if (a2) {
                    try {
                        if (f6789b == null) {
                            f6789b = new oc(context, 1, "AppMeasurement WakeLock");
                            f6789b.m10352a(false);
                        }
                        f6789b.m10350a(1000);
                    } catch (SecurityException e) {
                        f.m11310z().m11249a("AppMeasurementService at risk of not starting. For more reliable app measurements, add the WAKE_LOCK permission to your manifest.");
                    }
                    return;
                }
            }
        }
    }
}
