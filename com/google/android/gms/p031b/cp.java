package com.google.android.gms.p031b;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.android.gms.ads.internal.C1319u;
import com.google.android.gms.common.C1881l;
import java.util.concurrent.Callable;

@id
public class cp {
    private final Object f4356a = new Object();
    private boolean f4357b = false;
    private SharedPreferences f4358c = null;

    public <T> T m7824a(final cl<T> clVar) {
        synchronized (this.f4356a) {
            if (this.f4357b) {
                return kl.m9352a(new Callable<T>(this) {
                    final /* synthetic */ cp f4355b;

                    public T call() {
                        return clVar.mo1270a(this.f4355b.f4358c);
                    }
                });
            }
            T b = clVar.m7800b();
            return b;
        }
    }

    public void m7825a(Context context) {
        synchronized (this.f4356a) {
            if (this.f4357b) {
                return;
            }
            Context g = C1881l.m10648g(context);
            if (g == null) {
                return;
            }
            this.f4358c = C1319u.m7190l().m7822a(g);
            this.f4357b = true;
        }
    }
}
