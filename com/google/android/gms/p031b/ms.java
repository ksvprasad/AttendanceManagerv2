package com.google.android.gms.p031b;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.google.android.gms.C1004a.C0996b;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.C1896c;
import com.google.android.gms.common.internal.C1900g;
import com.google.android.gms.common.internal.ad;

@Deprecated
public final class ms {
    private static Object f6002a = new Object();
    private static ms f6003b;
    private final String f6004c;
    private final String f6005d;
    private final Status f6006e;
    private final String f6007f;
    private final String f6008g;
    private final String f6009h;
    private final boolean f6010i;
    private final boolean f6011j;

    ms(Context context) {
        boolean z = true;
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier("google_app_measurement_enable", "integer", resources.getResourcePackageName(C0996b.common_google_play_services_unknown_issue));
        if (identifier != 0) {
            boolean z2 = resources.getInteger(identifier) != 0;
            if (z2) {
                z = false;
            }
            this.f6011j = z;
            z = z2;
        } else {
            this.f6011j = false;
        }
        this.f6010i = z;
        C1900g c1900g = new C1900g(context);
        this.f6007f = c1900g.m10812a("firebase_database_url");
        this.f6009h = c1900g.m10812a("google_storage_bucket");
        this.f6008g = c1900g.m10812a("gcm_defaultSenderId");
        this.f6005d = c1900g.m10812a("google_api_key");
        Object a = ad.m10783a(context);
        if (a == null) {
            a = c1900g.m10812a("google_app_id");
        }
        if (TextUtils.isEmpty(a)) {
            this.f6006e = new Status(10, "Missing google app id value from from string resources with name google_app_id.");
            this.f6004c = null;
            return;
        }
        this.f6004c = a;
        this.f6006e = Status.f6333a;
    }

    ms(String str, boolean z) {
        this(str, z, null, null, null);
    }

    ms(String str, boolean z, String str2, String str3, String str4) {
        this.f6004c = str;
        this.f6005d = null;
        this.f6006e = Status.f6333a;
        this.f6010i = z;
        this.f6011j = !z;
        this.f6007f = str2;
        this.f6008g = str4;
        this.f6009h = str3;
    }

    public static Status m10067a(Context context) {
        Status status;
        C1896c.m10791a((Object) context, (Object) "Context must not be null.");
        synchronized (f6002a) {
            if (f6003b == null) {
                f6003b = new ms(context);
            }
            status = f6003b.f6006e;
        }
        return status;
    }

    public static Status m10068a(Context context, String str, boolean z) {
        Status a;
        C1896c.m10791a((Object) context, (Object) "Context must not be null.");
        C1896c.m10793a(str, (Object) "App ID must be nonempty.");
        synchronized (f6002a) {
            if (f6003b != null) {
                a = f6003b.m10072a(str);
            } else {
                f6003b = new ms(str, z);
                a = f6003b.f6006e;
            }
        }
        return a;
    }

    public static String m10069a() {
        return ms.m10070b("getGoogleAppId").f6004c;
    }

    private static ms m10070b(String str) {
        ms msVar;
        synchronized (f6002a) {
            if (f6003b == null) {
                throw new IllegalStateException(new StringBuilder(String.valueOf(str).length() + 34).append("Initialize must be called before ").append(str).append(".").toString());
            }
            msVar = f6003b;
        }
        return msVar;
    }

    public static boolean m10071b() {
        return ms.m10070b("isMeasurementExplicitlyDisabled").f6011j;
    }

    Status m10072a(String str) {
        if (this.f6004c == null || this.f6004c.equals(str)) {
            return Status.f6333a;
        }
        String str2 = this.f6004c;
        return new Status(10, new StringBuilder(String.valueOf(str2).length() + 97).append("Initialize was called with two different Google App IDs.  Only the first app ID will be used: '").append(str2).append("'.").toString());
    }
}
