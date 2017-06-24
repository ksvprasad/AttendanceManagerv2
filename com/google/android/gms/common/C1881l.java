package com.google.android.gms.common;

import android.annotation.TargetApi;
import android.app.NotificationManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageInstaller.SessionInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.os.UserManager;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.C1004a.C0996b;
import com.google.android.gms.common.C1956k.C1955d;
import com.google.android.gms.common.internal.C1914l;
import com.google.android.gms.common.util.C1969b;
import com.google.android.gms.common.util.C1973f;
import com.google.android.gms.common.util.C1975h;
import com.google.android.gms.common.util.C1979l;
import com.google.android.gms.common.util.C1983p;
import com.google.android.gms.p031b.nn;
import java.util.concurrent.atomic.AtomicBoolean;

public class C1881l {
    private static String f6386a = null;
    @Deprecated
    public static final int f6387b = C1881l.m10640b();
    public static boolean f6388c = false;
    public static boolean f6389d = false;
    static boolean f6390e = false;
    static final AtomicBoolean f6391f = new AtomicBoolean();
    private static int f6392g = 0;
    private static boolean f6393h = false;
    private static final AtomicBoolean f6394i = new AtomicBoolean();

    private static void m10635a(Context context) {
        if (!f6394i.get()) {
            C1881l.m10652k(context);
            if (f6392g == 0) {
                throw new IllegalStateException("A required meta-data tag in your app's AndroidManifest.xml does not exist.  You must have the following declaration within the <application> element:     <meta-data android:name=\"com.google.android.gms.version\" android:value=\"@integer/google_play_services_version\" />");
            } else if (f6392g != f6387b) {
                int i = f6387b;
                int i2 = f6392g;
                String valueOf = String.valueOf("com.google.android.gms.version");
                throw new IllegalStateException(new StringBuilder(String.valueOf(valueOf).length() + 290).append("The meta-data tag in your app's AndroidManifest.xml does not have the right value.  Expected ").append(i).append(" but found ").append(i2).append(".  You must have the following declaration within the <application> element:     <meta-data android:name=\"").append(valueOf).append("\" android:value=\"@integer/google_play_services_version\" />").toString());
            }
        }
    }

    @Deprecated
    public static boolean m10636a() {
        return "user".equals(Build.TYPE);
    }

    static boolean m10637a(int i) {
        switch (i) {
            case 1:
            case 2:
            case 3:
            case 18:
            case 42:
                return true;
            default:
                return false;
        }
    }

    @Deprecated
    public static boolean m10638a(Context context, int i) {
        return C1983p.m11125a(context, i);
    }

    @TargetApi(21)
    static boolean m10639a(Context context, String str) {
        boolean equals = str.equals("com.google.android.gms");
        if (equals && C1969b.m11070a()) {
            return false;
        }
        if (C1979l.m11117k()) {
            for (SessionInfo appPackageName : context.getPackageManager().getPackageInstaller().getAllSessions()) {
                if (str.equals(appPackageName.getAppPackageName())) {
                    return true;
                }
            }
        }
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(str, 8192);
            if (equals) {
                return applicationInfo.enabled;
            }
            boolean z = applicationInfo.enabled && !C1881l.m10651j(context);
            return z;
        } catch (NameNotFoundException e) {
            return false;
        }
    }

    private static int m10640b() {
        return C1914l.f6455a;
    }

    @Deprecated
    public static int m10641b(Context context) {
        PackageManager packageManager = context.getPackageManager();
        try {
            context.getResources().getString(C0996b.common_google_play_services_unknown_issue);
        } catch (Throwable th) {
            Log.e("GooglePlayServicesUtil", "The Google Play services resources were not found. Check your project configuration to ensure that the resources are included.");
        }
        if (!"com.google.android.gms".equals(context.getPackageName())) {
            C1881l.m10635a(context);
        }
        int i = !C1973f.m11091a(context) ? 1 : 0;
        PackageInfo packageInfo = null;
        if (i != 0) {
            try {
                packageInfo = packageManager.getPackageInfo("com.android.vending", 8256);
            } catch (NameNotFoundException e) {
                Log.w("GooglePlayServicesUtil", "Google Play Store is missing.");
                return 9;
            }
        }
        try {
            PackageInfo packageInfo2 = packageManager.getPackageInfo("com.google.android.gms", 64);
            C1957m a = C1957m.m11001a(context);
            if (i != 0) {
                if (a.m11002a(packageInfo, C1955d.f6535a) == null) {
                    Log.w("GooglePlayServicesUtil", "Google Play Store signature invalid.");
                    return 9;
                }
                if (a.m11002a(packageInfo2, a.m11002a(packageInfo, C1955d.f6535a)) == null) {
                    Log.w("GooglePlayServicesUtil", "Google Play services signature invalid.");
                    return 9;
                }
            } else if (a.m11002a(packageInfo2, C1955d.f6535a) == null) {
                Log.w("GooglePlayServicesUtil", "Google Play services signature invalid.");
                return 9;
            }
            if (C1975h.m11098a(packageInfo2.versionCode) < C1975h.m11098a(f6387b)) {
                Log.w("GooglePlayServicesUtil", "Google Play services out of date.  Requires " + f6387b + " but found " + packageInfo2.versionCode);
                return 2;
            }
            ApplicationInfo applicationInfo = packageInfo2.applicationInfo;
            if (applicationInfo == null) {
                try {
                    applicationInfo = packageManager.getApplicationInfo("com.google.android.gms", 0);
                } catch (Throwable e2) {
                    Log.wtf("GooglePlayServicesUtil", "Google Play services missing when getting application info.", e2);
                    return 1;
                }
            }
            return !applicationInfo.enabled ? 3 : 0;
        } catch (NameNotFoundException e3) {
            Log.w("GooglePlayServicesUtil", "Google Play services is missing.");
            return 1;
        }
    }

    @Deprecated
    public static boolean m10642b(int i) {
        switch (i) {
            case 1:
            case 2:
            case 3:
            case 9:
                return true;
            default:
                return false;
        }
    }

    @Deprecated
    public static boolean m10643b(Context context, int i) {
        return i == 18 ? true : i == 1 ? C1881l.m10639a(context, "com.google.android.gms") : false;
    }

    public static boolean m10644c(Context context) {
        C1881l.m10652k(context);
        return f6390e;
    }

    public static boolean m10645d(Context context) {
        return C1881l.m10644c(context) || !C1881l.m10636a();
    }

    @Deprecated
    public static void m10646e(Context context) {
        if (!f6391f.getAndSet(true)) {
            try {
                NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
                if (notificationManager != null) {
                    notificationManager.cancel(10436);
                }
            } catch (SecurityException e) {
            }
        }
    }

    public static Resources m10647f(Context context) {
        try {
            return context.getPackageManager().getResourcesForApplication("com.google.android.gms");
        } catch (NameNotFoundException e) {
            return null;
        }
    }

    public static Context m10648g(Context context) {
        try {
            return context.createPackageContext("com.google.android.gms", 3);
        } catch (NameNotFoundException e) {
            return null;
        }
    }

    public static String m10649h(Context context) {
        Object obj = context.getApplicationInfo().name;
        if (!TextUtils.isEmpty(obj)) {
            return obj;
        }
        ApplicationInfo a;
        String packageName = context.getPackageName();
        PackageManager packageManager = context.getApplicationContext().getPackageManager();
        try {
            a = nn.m10162b(context).m10159a(context.getPackageName(), 0);
        } catch (NameNotFoundException e) {
            a = null;
        }
        return a != null ? packageManager.getApplicationLabel(a).toString() : packageName;
    }

    @Deprecated
    public static int m10650i(Context context) {
        int i = 0;
        try {
            return context.getPackageManager().getPackageInfo("com.google.android.gms", 0).versionCode;
        } catch (NameNotFoundException e) {
            Log.w("GooglePlayServicesUtil", "Google Play services is missing.");
            return i;
        }
    }

    @TargetApi(18)
    public static boolean m10651j(Context context) {
        if (C1979l.m11113g()) {
            Bundle applicationRestrictions = ((UserManager) context.getSystemService("user")).getApplicationRestrictions(context.getPackageName());
            if (applicationRestrictions != null && "true".equals(applicationRestrictions.getString("restricted_profile"))) {
                return true;
            }
        }
        return false;
    }

    private static void m10652k(Context context) {
        if (!f6393h) {
            C1881l.m10653l(context);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void m10653l(android.content.Context r7) {
        /*
        r6 = 1;
        r0 = r7.getPackageName();	 Catch:{ NameNotFoundException -> 0x003a }
        f6386a = r0;	 Catch:{ NameNotFoundException -> 0x003a }
        r0 = com.google.android.gms.p031b.nn.m10162b(r7);	 Catch:{ NameNotFoundException -> 0x003a }
        r1 = com.google.android.gms.common.internal.ad.m10784b(r7);	 Catch:{ NameNotFoundException -> 0x003a }
        f6392g = r1;	 Catch:{ NameNotFoundException -> 0x003a }
        r1 = "com.google.android.gms";
        r2 = 64;
        r0 = r0.m10161b(r1, r2);	 Catch:{ NameNotFoundException -> 0x003a }
        if (r0 == 0) goto L_0x0036;
    L_0x001b:
        r1 = com.google.android.gms.common.C1957m.m11001a(r7);	 Catch:{ NameNotFoundException -> 0x003a }
        r2 = 1;
        r2 = new com.google.android.gms.common.C1956k.C1950a[r2];	 Catch:{ NameNotFoundException -> 0x003a }
        r3 = 0;
        r4 = com.google.android.gms.common.C1956k.C1955d.f6535a;	 Catch:{ NameNotFoundException -> 0x003a }
        r5 = 1;
        r4 = r4[r5];	 Catch:{ NameNotFoundException -> 0x003a }
        r2[r3] = r4;	 Catch:{ NameNotFoundException -> 0x003a }
        r0 = r1.m11002a(r0, r2);	 Catch:{ NameNotFoundException -> 0x003a }
        if (r0 == 0) goto L_0x0036;
    L_0x0030:
        r0 = 1;
        f6390e = r0;	 Catch:{ NameNotFoundException -> 0x003a }
    L_0x0033:
        f6393h = r6;
    L_0x0035:
        return;
    L_0x0036:
        r0 = 0;
        f6390e = r0;	 Catch:{ NameNotFoundException -> 0x003a }
        goto L_0x0033;
    L_0x003a:
        r0 = move-exception;
        r1 = "GooglePlayServicesUtil";
        r2 = "Cannot find Google Play services package name.";
        android.util.Log.w(r1, r2, r0);	 Catch:{ all -> 0x0045 }
        f6393h = r6;
        goto L_0x0035;
    L_0x0045:
        r0 = move-exception;
        f6393h = r6;
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.l.l(android.content.Context):void");
    }
}
