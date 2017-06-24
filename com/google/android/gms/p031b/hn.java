package com.google.android.gms.p031b;

import android.content.Context;
import com.google.android.gms.ads.internal.C1319u;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.ads.internal.util.client.C1324b;
import com.google.android.gms.common.internal.C1896c;
import com.google.android.gms.p031b.hs.C1042a;
import com.google.android.gms.p031b.jl.C1632a;
import com.google.android.gms.p031b.lb.C1148a;
import java.util.concurrent.atomic.AtomicBoolean;

@id
public abstract class hn implements kb<Void>, C1148a {
    protected final C1042a f5028a;
    protected final Context f5029b;
    protected final la f5030c;
    protected final C1632a f5031d;
    protected AdResponseParcel f5032e;
    protected final Object f5033f = new Object();
    private Runnable f5034g;
    private AtomicBoolean f5035h = new AtomicBoolean(true);

    class C15741 implements Runnable {
        final /* synthetic */ hn f5027a;

        C15741(hn hnVar) {
            this.f5027a = hnVar;
        }

        public void run() {
            if (this.f5027a.f5035h.get()) {
                C1324b.m7230b("Timed out waiting for WebView to finish loading.");
                this.f5027a.mo1106d();
            }
        }
    }

    protected hn(Context context, C1632a c1632a, la laVar, C1042a c1042a) {
        this.f5029b = context;
        this.f5031d = c1632a;
        this.f5032e = this.f5031d.f5409b;
        this.f5030c = laVar;
        this.f5028a = c1042a;
    }

    private jl m8735b(int i) {
        AdRequestInfoParcel adRequestInfoParcel = this.f5031d.f5408a;
        return new jl(adRequestInfoParcel.f3741c, this.f5030c, this.f5032e.f3782d, i, this.f5032e.f3784f, this.f5032e.f3788j, this.f5032e.f3790l, this.f5032e.f3789k, adRequestInfoParcel.f3747i, this.f5032e.f3786h, null, null, null, null, null, this.f5032e.f3787i, this.f5031d.f5411d, this.f5032e.f3785g, this.f5031d.f5413f, this.f5032e.f3792n, this.f5032e.f3793o, this.f5031d.f5415h, null, this.f5032e.f3767C, this.f5032e.f3768D, this.f5032e.f3769E, this.f5032e.f3770F, this.f5032e.f3771G, null, this.f5032e.f3774J);
    }

    public final Void m8736a() {
        C1896c.m10797b("Webview render task needs to be called on UI thread.");
        this.f5034g = new C15741(this);
        jz.f5567a.postDelayed(this.f5034g, ((Long) cq.aK.m7801c()).longValue());
        mo1433b();
        return null;
    }

    protected void mo1435a(int i) {
        if (i != -2) {
            this.f5032e = new AdResponseParcel(i, this.f5032e.f3789k);
        }
        this.f5030c.mo1512e();
        this.f5028a.mo966b(m8735b(i));
    }

    public void mo1096a(la laVar, boolean z) {
        int i = 0;
        C1324b.m7227a("WebView finished loading.");
        if (this.f5035h.getAndSet(false)) {
            if (z) {
                i = mo1434c();
            }
            mo1435a(i);
            jz.f5567a.removeCallbacks(this.f5034g);
        }
    }

    protected abstract void mo1433b();

    protected int mo1434c() {
        return -2;
    }

    public void mo1106d() {
        if (this.f5035h.getAndSet(false)) {
            this.f5030c.stopLoading();
            C1319u.m7185g().m9273a(this.f5030c);
            mo1435a(-1);
            jz.f5567a.removeCallbacks(this.f5034g);
        }
    }

    public /* synthetic */ Object mo1107e() {
        return m8736a();
    }
}
