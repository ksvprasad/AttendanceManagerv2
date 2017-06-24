package com.google.android.gms.ads.internal;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.al.C1077a;
import com.google.android.gms.ads.internal.util.client.C1324b;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.p031b.cq;
import com.google.android.gms.p031b.id;

@id
public class C1181o extends C1077a {
    private static final Object f3457b = new Object();
    private static C1181o f3458c;
    private final Context f3459a;
    private final Object f3460d = new Object();
    private boolean f3461e;
    private boolean f3462f;
    private float f3463g = -1.0f;
    private VersionInfoParcel f3464h;

    C1181o(Context context, VersionInfoParcel versionInfoParcel) {
        this.f3459a = context;
        this.f3464h = versionInfoParcel;
        this.f3461e = false;
    }

    public static C1181o m6578a(Context context, VersionInfoParcel versionInfoParcel) {
        C1181o c1181o;
        synchronized (f3457b) {
            if (f3458c == null) {
                f3458c = new C1181o(context.getApplicationContext(), versionInfoParcel);
            }
            c1181o = f3458c;
        }
        return c1181o;
    }

    public static C1181o m6579b() {
        C1181o c1181o;
        synchronized (f3457b) {
            c1181o = f3458c;
        }
        return c1181o;
    }

    public void mo1026a() {
        synchronized (f3457b) {
            if (this.f3461e) {
                C1324b.m7234d("Mobile ads is initialized already.");
                return;
            }
            this.f3461e = true;
        }
    }

    public void mo1027a(float f) {
        synchronized (this.f3460d) {
            this.f3463g = f;
        }
    }

    public void mo1028a(String str) {
        cq.m7828a(this.f3459a);
        if (!TextUtils.isEmpty(str) && ((Boolean) cq.bw.m7801c()).booleanValue()) {
            C1319u.m7201w().m6479a(this.f3459a, this.f3464h, true, null, str, null);
        }
    }

    public void mo1029a(boolean z) {
        synchronized (this.f3460d) {
            this.f3462f = z;
        }
    }

    public float m6584c() {
        float f;
        synchronized (this.f3460d) {
            f = this.f3463g;
        }
        return f;
    }

    public boolean m6585d() {
        boolean z;
        synchronized (this.f3460d) {
            z = this.f3463g >= 0.0f;
        }
        return z;
    }

    public boolean m6586e() {
        boolean z;
        synchronized (this.f3460d) {
            z = this.f3462f;
        }
        return z;
    }
}
