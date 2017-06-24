package com.google.android.gms.common;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.Notification.BigTextStyle;
import android.app.Notification.Builder;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.support.v4.app.ae.C0204d;
import com.google.android.gms.C1004a.C0995a;
import com.google.android.gms.C1004a.C0996b;
import com.google.android.gms.common.internal.C1896c;
import com.google.android.gms.common.internal.C1928o;
import com.google.android.gms.common.util.C1973f;
import com.google.android.gms.common.util.C1979l;

public final class C1882e extends C1881l {
    @Deprecated
    public static final int f6395a = C1881l.f6387b;

    public static Resources m10654a(Context context) {
        return C1881l.m10647f(context);
    }

    static void m10655a(int i, Context context, PendingIntent pendingIntent) {
        C1882e.m10656a(i, context, null, pendingIntent);
    }

    @TargetApi(20)
    private static void m10656a(int i, Context context, String str, PendingIntent pendingIntent) {
        Notification build;
        int i2;
        Resources resources = context.getResources();
        String h = C1881l.m10649h(context);
        CharSequence b = C1928o.m10882b(context, i);
        if (b == null) {
            b = resources.getString(C0996b.common_google_play_services_notification_ticker);
        }
        CharSequence b2 = C1928o.m10883b(context, i, h);
        if (C1973f.m11091a(context)) {
            C1896c.m10794a(C1979l.m11111e());
            build = new Builder(context).setSmallIcon(C0995a.common_ic_googleplayservices).setPriority(2).setAutoCancel(true).setStyle(new BigTextStyle().bigText(new StringBuilder((String.valueOf(b).length() + 1) + String.valueOf(b2).length()).append(b).append(" ").append(b2).toString())).addAction(C0995a.common_full_open_on_phone, resources.getString(C0996b.common_open_on_phone), pendingIntent).build();
        } else {
            CharSequence string = resources.getString(C0996b.common_google_play_services_notification_ticker);
            if (C1979l.m11106a()) {
                Notification build2;
                Builder autoCancel = new Builder(context).setSmallIcon(17301642).setContentTitle(b).setContentText(b2).setContentIntent(pendingIntent).setTicker(string).setAutoCancel(true);
                if (C1979l.m11115i()) {
                    autoCancel.setLocalOnly(true);
                }
                if (C1979l.m11111e()) {
                    autoCancel.setStyle(new BigTextStyle().bigText(b2));
                    build2 = autoCancel.build();
                } else {
                    build2 = autoCancel.getNotification();
                }
                if (VERSION.SDK_INT == 19) {
                    build2.extras.putBoolean("android.support.localOnly", true);
                }
                build = build2;
            } else {
                build = new C0204d(context).m1253a(17301642).m1260c(string).m1254a(System.currentTimeMillis()).m1257a(true).m1255a(pendingIntent).m1256a(b).m1258b(b2).m1252a();
            }
        }
        if (C1881l.m10637a(i)) {
            f.set(false);
            i2 = 10436;
        } else {
            i2 = 39789;
        }
        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
        if (str != null) {
            notificationManager.notify(str, i2, build);
        } else {
            notificationManager.notify(i2, build);
        }
    }
}
