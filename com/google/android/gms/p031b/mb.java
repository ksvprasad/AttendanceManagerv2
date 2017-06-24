package com.google.android.gms.p031b;

import android.support.v4.p015g.C0370a;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.C1857g;
import com.google.android.gms.common.api.C1870m;
import com.google.android.gms.common.api.C1871l;
import com.google.android.gms.common.api.Status;
import java.util.Set;

public final class mb extends me<C1870m> {
    private int f5848d;
    private boolean f5849e;

    private void m9779a(ConnectionResult connectionResult) {
        C0370a c0370a = null;
        for (int i = 0; i < c0370a.size(); i++) {
            m9781a((lz) c0370a.m1900b(i), connectionResult);
        }
    }

    protected C1870m m9780a(Status status) {
        C1870m c1870m;
        synchronized (null) {
            try {
                m9779a(new ConnectionResult(8));
                C0370a c0370a = null;
                if (c0370a.size() != 1) {
                    c1870m = new C1870m(status, null);
                }
            } finally {
            }
        }
        return c1870m;
    }

    public void m9781a(lz<?> lzVar, ConnectionResult connectionResult) {
        synchronized (null) {
            C0370a c0370a = null;
            try {
                c0370a.put(lzVar, connectionResult);
                this.f5848d--;
                boolean b = connectionResult.m10547b();
                if (!b) {
                    this.f5849e = b;
                }
                if (this.f5848d == 0) {
                    Status status = this.f5849e ? new Status(13) : Status.f6333a;
                    c0370a = null;
                    m9647b(c0370a.size() == 1 ? new C1871l(status, null) : new C1870m(status, null));
                }
            } finally {
            }
        }
    }

    protected /* synthetic */ C1857g mo1554b(Status status) {
        return m9780a(status);
    }

    public Set<lz<?>> mo1550b() {
        C0370a c0370a = null;
        return c0370a.keySet();
    }
}
