package com.google.android.gms.ads.internal;

import android.content.Context;
import android.support.v4.p015g.C0369j;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.ac;
import com.google.android.gms.ads.internal.client.ad.C1063a;
import com.google.android.gms.ads.internal.client.ak;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.p031b.dp;
import com.google.android.gms.p031b.dq;
import com.google.android.gms.p031b.dr;
import com.google.android.gms.p031b.ds;
import com.google.android.gms.p031b.fx;
import com.google.android.gms.p031b.id;
import com.google.android.gms.p031b.jz;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

@id
public class C1168j extends C1063a {
    private final Context f3408a;
    private final ac f3409b;
    private final fx f3410c;
    private final dp f3411d;
    private final dq f3412e;
    private final C0369j<String, ds> f3413f;
    private final C0369j<String, dr> f3414g;
    private final NativeAdOptionsParcel f3415h;
    private final List<String> f3416i;
    private final ak f3417j;
    private final String f3418k;
    private final VersionInfoParcel f3419l;
    private WeakReference<C1245q> f3420m;
    private final C1122d f3421n;
    private final Object f3422o = new Object();

    C1168j(Context context, String str, fx fxVar, VersionInfoParcel versionInfoParcel, ac acVar, dp dpVar, dq dqVar, C0369j<String, ds> c0369j, C0369j<String, dr> c0369j2, NativeAdOptionsParcel nativeAdOptionsParcel, ak akVar, C1122d c1122d) {
        this.f3408a = context;
        this.f3418k = str;
        this.f3410c = fxVar;
        this.f3419l = versionInfoParcel;
        this.f3409b = acVar;
        this.f3412e = dqVar;
        this.f3411d = dpVar;
        this.f3413f = c0369j;
        this.f3414g = c0369j2;
        this.f3415h = nativeAdOptionsParcel;
        this.f3416i = m6498d();
        this.f3417j = akVar;
        this.f3421n = c1122d;
    }

    private List<String> m6498d() {
        List<String> arrayList = new ArrayList();
        if (this.f3412e != null) {
            arrayList.add("1");
        }
        if (this.f3411d != null) {
            arrayList.add("2");
        }
        if (this.f3413f.size() > 0) {
            arrayList.add("3");
        }
        return arrayList;
    }

    public void mo1011a(final AdRequestParcel adRequestParcel) {
        m6505a(new Runnable(this) {
            final /* synthetic */ C1168j f3407b;

            public void run() {
                synchronized (this.f3407b.f3422o) {
                    C1245q c = this.f3407b.m6508c();
                    this.f3407b.f3420m = new WeakReference(c);
                    c.m6869a(this.f3407b.f3411d);
                    c.m6870a(this.f3407b.f3412e);
                    c.m6865a(this.f3407b.f3413f);
                    c.mo952a(this.f3407b.f3409b);
                    c.m6876b(this.f3407b.f3414g);
                    c.m6873a(this.f3407b.m6498d());
                    c.m6866a(this.f3407b.f3415h);
                    c.mo954a(this.f3407b.f3417j);
                    c.mo964a(adRequestParcel);
                }
            }
        });
    }

    protected void m6505a(Runnable runnable) {
        jz.f5567a.post(runnable);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean mo1012a() {
        /*
        r3 = this;
        r1 = 0;
        r2 = r3.f3422o;
        monitor-enter(r2);
        r0 = r3.f3420m;	 Catch:{ all -> 0x001d }
        if (r0 == 0) goto L_0x001a;
    L_0x0008:
        r0 = r3.f3420m;	 Catch:{ all -> 0x001d }
        r0 = r0.get();	 Catch:{ all -> 0x001d }
        r0 = (com.google.android.gms.ads.internal.C1245q) r0;	 Catch:{ all -> 0x001d }
        if (r0 == 0) goto L_0x0018;
    L_0x0012:
        r0 = r0.mo973k();	 Catch:{ all -> 0x001d }
    L_0x0016:
        monitor-exit(r2);	 Catch:{ all -> 0x001d }
    L_0x0017:
        return r0;
    L_0x0018:
        r0 = r1;
        goto L_0x0016;
    L_0x001a:
        monitor-exit(r2);	 Catch:{ all -> 0x001d }
        r0 = r1;
        goto L_0x0017;
    L_0x001d:
        r0 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x001d }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.j.a():boolean");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String mo1013b() {
        /*
        r3 = this;
        r1 = 0;
        r2 = r3.f3422o;
        monitor-enter(r2);
        r0 = r3.f3420m;	 Catch:{ all -> 0x001d }
        if (r0 == 0) goto L_0x001a;
    L_0x0008:
        r0 = r3.f3420m;	 Catch:{ all -> 0x001d }
        r0 = r0.get();	 Catch:{ all -> 0x001d }
        r0 = (com.google.android.gms.ads.internal.C1245q) r0;	 Catch:{ all -> 0x001d }
        if (r0 == 0) goto L_0x0018;
    L_0x0012:
        r0 = r0.mo989j();	 Catch:{ all -> 0x001d }
    L_0x0016:
        monitor-exit(r2);	 Catch:{ all -> 0x001d }
    L_0x0017:
        return r0;
    L_0x0018:
        r0 = r1;
        goto L_0x0016;
    L_0x001a:
        monitor-exit(r2);	 Catch:{ all -> 0x001d }
        r0 = r1;
        goto L_0x0017;
    L_0x001d:
        r0 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x001d }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.j.b():java.lang.String");
    }

    protected C1245q m6508c() {
        return new C1245q(this.f3408a, this.f3421n, AdSizeParcel.m5968a(this.f3408a), this.f3418k, this.f3410c, this.f3419l);
    }
}
