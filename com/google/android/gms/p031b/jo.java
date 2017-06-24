package com.google.android.gms.p031b;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.security.NetworkSecurityPolicy;
import com.google.android.gms.ads.internal.C1319u;
import com.google.android.gms.ads.internal.util.client.C1324b;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.util.C1979l;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import com.google.android.gms.p031b.jx.C1636b;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.Future;

@id
public class jo implements C1636b {
    private long f5474A = 0;
    private final Object f5475a = new Object();
    private final String f5476b;
    private final jp f5477c;
    private bt f5478d;
    private BigInteger f5479e = BigInteger.ONE;
    private final HashSet<jm> f5480f = new HashSet();
    private final HashMap<String, js> f5481g = new HashMap();
    private boolean f5482h = false;
    private boolean f5483i = true;
    private int f5484j = 0;
    private boolean f5485k = false;
    private Context f5486l;
    private VersionInfoParcel f5487m;
    private cs f5488n = null;
    private boolean f5489o = true;
    private ca f5490p = null;
    private cb f5491q = null;
    private bz f5492r = null;
    private String f5493s;
    private Boolean f5494t = null;
    private String f5495u;
    private boolean f5496v = false;
    private boolean f5497w = false;
    private boolean f5498x = false;
    private boolean f5499y = false;
    private String f5500z = "";

    public jo(jz jzVar) {
        this.f5476b = jzVar.m9243d();
        this.f5477c = new jp(this.f5476b);
    }

    public Bundle m9105a(Context context, jq jqVar, String str) {
        Bundle bundle;
        synchronized (this.f5475a) {
            bundle = new Bundle();
            bundle.putBundle("app", this.f5477c.m9141a(context, str));
            Bundle bundle2 = new Bundle();
            for (String str2 : this.f5481g.keySet()) {
                bundle2.putBundle(str2, ((js) this.f5481g.get(str2)).m9145a());
            }
            bundle.putBundle("slots", bundle2);
            ArrayList arrayList = new ArrayList();
            Iterator it = this.f5480f.iterator();
            while (it.hasNext()) {
                arrayList.add(((jm) it.next()).m9096d());
            }
            bundle.putParcelableArrayList("ads", arrayList);
            jqVar.mo962a(this.f5480f);
            this.f5480f.clear();
        }
        return bundle;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.android.gms.p031b.cb m9106a(android.content.Context r11) {
        /*
        r10 = this;
        r2 = 0;
        r1 = com.google.android.gms.p031b.cq.f4370K;
        r1 = r1.m7801c();
        r1 = (java.lang.Boolean) r1;
        r1 = r1.booleanValue();
        if (r1 == 0) goto L_0x001b;
    L_0x000f:
        r1 = com.google.android.gms.common.util.C1979l.m11110d();
        if (r1 == 0) goto L_0x001b;
    L_0x0015:
        r1 = r10.m9122b();
        if (r1 == 0) goto L_0x001d;
    L_0x001b:
        r1 = r2;
    L_0x001c:
        return r1;
    L_0x001d:
        r3 = r10.f5475a;
        monitor-enter(r3);
        r1 = android.os.Looper.getMainLooper();	 Catch:{ all -> 0x0070 }
        if (r1 == 0) goto L_0x0028;
    L_0x0026:
        if (r11 != 0) goto L_0x002b;
    L_0x0028:
        monitor-exit(r3);	 Catch:{ all -> 0x0070 }
        r1 = r2;
        goto L_0x001c;
    L_0x002b:
        r1 = r10.f5490p;	 Catch:{ all -> 0x0070 }
        if (r1 != 0) goto L_0x0042;
    L_0x002f:
        r1 = r11.getApplicationContext();	 Catch:{ all -> 0x0070 }
        r1 = (android.app.Application) r1;	 Catch:{ all -> 0x0070 }
        r2 = new com.google.android.gms.b.ca;	 Catch:{ all -> 0x0070 }
        if (r1 != 0) goto L_0x003d;
    L_0x0039:
        r0 = r11;
        r0 = (android.app.Application) r0;	 Catch:{ all -> 0x0070 }
        r1 = r0;
    L_0x003d:
        r2.<init>(r1, r11);	 Catch:{ all -> 0x0070 }
        r10.f5490p = r2;	 Catch:{ all -> 0x0070 }
    L_0x0042:
        r1 = r10.f5492r;	 Catch:{ all -> 0x0070 }
        if (r1 != 0) goto L_0x004d;
    L_0x0046:
        r1 = new com.google.android.gms.b.bz;	 Catch:{ all -> 0x0070 }
        r1.<init>();	 Catch:{ all -> 0x0070 }
        r10.f5492r = r1;	 Catch:{ all -> 0x0070 }
    L_0x004d:
        r1 = r10.f5491q;	 Catch:{ all -> 0x0070 }
        if (r1 != 0) goto L_0x0067;
    L_0x0051:
        r1 = new com.google.android.gms.b.cb;	 Catch:{ all -> 0x0070 }
        r2 = r10.f5490p;	 Catch:{ all -> 0x0070 }
        r4 = r10.f5492r;	 Catch:{ all -> 0x0070 }
        r5 = new com.google.android.gms.b.ic;	 Catch:{ all -> 0x0070 }
        r6 = r10.f5486l;	 Catch:{ all -> 0x0070 }
        r7 = r10.f5487m;	 Catch:{ all -> 0x0070 }
        r8 = 0;
        r9 = 0;
        r5.<init>(r6, r7, r8, r9);	 Catch:{ all -> 0x0070 }
        r1.<init>(r2, r4, r5);	 Catch:{ all -> 0x0070 }
        r10.f5491q = r1;	 Catch:{ all -> 0x0070 }
    L_0x0067:
        r1 = r10.f5491q;	 Catch:{ all -> 0x0070 }
        r1.m7746a();	 Catch:{ all -> 0x0070 }
        r1 = r10.f5491q;	 Catch:{ all -> 0x0070 }
        monitor-exit(r3);	 Catch:{ all -> 0x0070 }
        goto L_0x001c;
    L_0x0070:
        r1 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x0070 }
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.b.jo.a(android.content.Context):com.google.android.gms.b.cb");
    }

    public String m9107a() {
        return this.f5476b;
    }

    public Future m9108a(Context context, String str) {
        Future a;
        this.f5474A = C1319u.m7187i().mo1723a();
        synchronized (this.f5475a) {
            if (str != null) {
                if (!str.equals(this.f5500z)) {
                    this.f5500z = str;
                    a = jx.m9168a(context, str, this.f5474A);
                }
            }
            a = null;
        }
        return a;
    }

    public Future m9109a(Context context, boolean z) {
        Future a;
        synchronized (this.f5475a) {
            if (z != this.f5483i) {
                this.f5483i = z;
                a = jx.m9169a(context, z);
            } else {
                a = null;
            }
        }
        return a;
    }

    public Future m9110a(String str) {
        Future a;
        synchronized (this.f5475a) {
            if (str != null) {
                if (!str.equals(this.f5493s)) {
                    this.f5493s = str;
                    a = jx.m9167a(this.f5486l, str);
                }
            }
            a = null;
        }
        return a;
    }

    @TargetApi(23)
    public void m9111a(Context context, VersionInfoParcel versionInfoParcel) {
        synchronized (this.f5475a) {
            if (!this.f5485k) {
                this.f5486l = context.getApplicationContext();
                this.f5487m = versionInfoParcel;
                jx.m9166a(context, (C1636b) this);
                jx.m9170b(context, (C1636b) this);
                jx.m9172c(context, (C1636b) this);
                jx.m9174d(context, this);
                jx.m9175e(context, this);
                jx.m9176f(context, this);
                m9116a(Thread.currentThread());
                this.f5495u = C1319u.m7183e().m9204a(context, versionInfoParcel.f3957b);
                if (C1979l.m11118l() && !NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted()) {
                    this.f5497w = true;
                }
                this.f5478d = new bt(context.getApplicationContext(), this.f5487m, C1319u.m7183e().m9201a(context, versionInfoParcel));
                m9138q();
                C1319u.m7193o().m6849a(this.f5486l);
                this.f5485k = true;
            }
        }
    }

    public void mo1462a(Bundle bundle) {
        synchronized (this.f5475a) {
            this.f5483i = bundle.containsKey("use_https") ? bundle.getBoolean("use_https") : this.f5483i;
            this.f5484j = bundle.containsKey("webview_cache_version") ? bundle.getInt("webview_cache_version") : this.f5484j;
            if (bundle.containsKey("content_url_opted_out")) {
                m9119a(bundle.getBoolean("content_url_opted_out"));
            }
            if (bundle.containsKey("content_url_hashes")) {
                this.f5493s = bundle.getString("content_url_hashes");
            }
            this.f5498x = bundle.containsKey("auto_collect_location") ? bundle.getBoolean("auto_collect_location") : this.f5498x;
            this.f5500z = bundle.containsKey("app_settings_json") ? bundle.getString("app_settings_json") : this.f5500z;
            this.f5474A = bundle.containsKey("app_settings_last_update_ms") ? bundle.getLong("app_settings_last_update_ms") : 0;
        }
    }

    public void m9113a(jm jmVar) {
        synchronized (this.f5475a) {
            this.f5480f.add(jmVar);
        }
    }

    public void m9114a(Boolean bool) {
        synchronized (this.f5475a) {
            this.f5494t = bool;
        }
    }

    public void m9115a(String str, js jsVar) {
        synchronized (this.f5475a) {
            this.f5481g.put(str, jsVar);
        }
    }

    public void m9116a(Thread thread) {
        ic.m8868a(this.f5486l, thread, this.f5487m);
    }

    public void m9117a(Throwable th, boolean z) {
        new ic(this.f5486l, this.f5487m, null, null).m8872a(th, z);
    }

    public void m9118a(HashSet<jm> hashSet) {
        synchronized (this.f5475a) {
            this.f5480f.addAll(hashSet);
        }
    }

    public void m9119a(boolean z) {
        synchronized (this.f5475a) {
            if (this.f5489o != z) {
                jx.m9171b(this.f5486l, z);
            }
            this.f5489o = z;
            cb a = m9106a(this.f5486l);
            if (!(a == null || a.isAlive())) {
                C1324b.m7232c("start fetching content...");
                a.m7746a();
            }
        }
    }

    public Future m9120b(Context context, boolean z) {
        Future c;
        synchronized (this.f5475a) {
            if (z != this.f5498x) {
                this.f5498x = z;
                c = jx.m9173c(context, z);
            } else {
                c = null;
            }
        }
        return c;
    }

    public void m9121b(boolean z) {
        this.f5499y = z;
    }

    public boolean m9122b() {
        boolean z;
        synchronized (this.f5475a) {
            z = this.f5489o;
        }
        return z;
    }

    public String m9123c() {
        String bigInteger;
        synchronized (this.f5475a) {
            bigInteger = this.f5479e.toString();
            this.f5479e = this.f5479e.add(BigInteger.ONE);
        }
        return bigInteger;
    }

    public void m9124c(boolean z) {
        synchronized (this.f5475a) {
            this.f5496v = z;
        }
    }

    public jp m9125d() {
        jp jpVar;
        synchronized (this.f5475a) {
            jpVar = this.f5477c;
        }
        return jpVar;
    }

    public cs m9126e() {
        cs csVar;
        synchronized (this.f5475a) {
            csVar = this.f5488n;
        }
        return csVar;
    }

    public boolean m9127f() {
        boolean z;
        synchronized (this.f5475a) {
            z = this.f5482h;
            this.f5482h = true;
        }
        return z;
    }

    public boolean m9128g() {
        boolean z;
        synchronized (this.f5475a) {
            z = this.f5483i || this.f5497w;
        }
        return z;
    }

    public String m9129h() {
        String str;
        synchronized (this.f5475a) {
            str = this.f5495u;
        }
        return str;
    }

    public String m9130i() {
        String str;
        synchronized (this.f5475a) {
            str = this.f5493s;
        }
        return str;
    }

    public Boolean m9131j() {
        Boolean bool;
        synchronized (this.f5475a) {
            bool = this.f5494t;
        }
        return bool;
    }

    public boolean m9132k() {
        boolean z;
        synchronized (this.f5475a) {
            z = this.f5498x;
        }
        return z;
    }

    public boolean m9133l() {
        return this.f5499y;
    }

    public jn m9134m() {
        jn jnVar;
        synchronized (this.f5475a) {
            jnVar = new jn(this.f5500z, this.f5474A);
        }
        return jnVar;
    }

    public bt m9135n() {
        return this.f5478d;
    }

    public Resources m9136o() {
        if (this.f5487m.f3960e) {
            return this.f5486l.getResources();
        }
        try {
            np a = np.m10186a(this.f5486l, np.f6080a, ModuleDescriptor.MODULE_ID);
            return a != null ? a.m10190a().getResources() : null;
        } catch (Throwable e) {
            C1324b.m7235d("Cannot load resource from dynamite apk or local jar", e);
            return null;
        }
    }

    public boolean m9137p() {
        boolean z;
        synchronized (this.f5475a) {
            z = this.f5496v;
        }
        return z;
    }

    void m9138q() {
        try {
            this.f5488n = C1319u.m7188j().m7844a(new cr(this.f5486l, this.f5487m.f3957b));
        } catch (Throwable e) {
            C1324b.m7235d("Cannot initialize CSI reporter.", e);
        }
    }
}
