package com.google.android.gms.p031b;

import android.content.Context;
import com.google.android.gms.ads.internal.C1245q;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.ads.internal.util.client.C1324b;
import com.google.android.gms.p031b.hs.C1042a;
import com.google.android.gms.p031b.jl.C1632a;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@id
public class hw extends ju {
    private final C1042a f5078a;
    private final AdResponseParcel f5079b;
    private final C1632a f5080c;
    private final hy f5081d;
    private final Object f5082e;
    private Future<jl> f5083f;

    public hw(Context context, C1245q c1245q, C1632a c1632a, aj ajVar, C1042a c1042a) {
        this(c1632a, c1042a, new hy(context, c1245q, new kf(context), ajVar, c1632a));
    }

    hw(C1632a c1632a, C1042a c1042a, hy hyVar) {
        this.f5082e = new Object();
        this.f5080c = c1632a;
        this.f5079b = c1632a.f5409b;
        this.f5078a = c1042a;
        this.f5081d = hyVar;
    }

    private jl m8785a(int i) {
        return new jl(this.f5080c.f5408a.f3741c, null, null, i, null, null, this.f5079b.f3790l, this.f5079b.f3789k, this.f5080c.f5408a.f3747i, false, null, null, null, null, null, this.f5079b.f3787i, this.f5080c.f5411d, this.f5079b.f3785g, this.f5080c.f5413f, this.f5079b.f3792n, this.f5079b.f3793o, this.f5080c.f5415h, null, null, null, null, this.f5080c.f5409b.f3770F, this.f5080c.f5409b.f3771G, null, null);
    }

    public void mo1108a() {
        jl jlVar;
        int i;
        try {
            synchronized (this.f5082e) {
                this.f5083f = jy.m9181a(this.f5081d);
            }
            jlVar = (jl) this.f5083f.get(60000, TimeUnit.MILLISECONDS);
            i = -2;
        } catch (TimeoutException e) {
            C1324b.m7234d("Timed out waiting for native ad.");
            this.f5083f.cancel(true);
            i = 2;
            jlVar = null;
        } catch (ExecutionException e2) {
            jlVar = null;
            i = 0;
        } catch (InterruptedException e3) {
            jlVar = null;
            i = 0;
        } catch (CancellationException e4) {
            jlVar = null;
            i = 0;
        }
        if (jlVar == null) {
            jlVar = m8785a(i);
        }
        jz.f5567a.post(new Runnable(this) {
            final /* synthetic */ hw f5077b;

            public void run() {
                this.f5077b.f5078a.mo966b(jlVar);
            }
        });
    }

    public void mo1109b() {
        synchronized (this.f5082e) {
            if (this.f5083f != null) {
                this.f5083f.cancel(true);
            }
        }
    }
}
