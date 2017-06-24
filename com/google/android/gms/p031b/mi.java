package com.google.android.gms.p031b;

import android.os.Bundle;
import android.os.DeadObjectException;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.C1857g;
import com.google.android.gms.common.api.C1864a;
import com.google.android.gms.common.api.C1864a.C1721c;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.C1899f;
import com.google.android.gms.p031b.mc.C1714a;
import com.google.android.gms.p031b.mo.C1747a;

public class mi implements mm {
    private final mo f5877a;
    private boolean f5878b = false;

    public mi(mo moVar) {
        this.f5877a = moVar;
    }

    private <A extends C1721c> void m9860c(C1714a<? extends C1857g, A> c1714a) {
        this.f5877a.f5954g.f5931i.m10135a((C1714a) c1714a);
        C1721c a = this.f5877a.f5954g.m9967a(c1714a.mo1550b());
        if (a.m9692d() || !this.f5877a.f5949b.containsKey(c1714a.mo1550b())) {
            if (a instanceof C1899f) {
                a = ((C1899f) a).mo1702k();
            }
            c1714a.m9661b(a);
            return;
        }
        c1714a.m9663c(new Status(17));
    }

    public <A extends C1721c, R extends C1857g, T extends C1714a<R, A>> T mo1587a(T t) {
        return mo1592b(t);
    }

    public void mo1588a() {
    }

    public void mo1589a(int i) {
        this.f5877a.m9994a(null);
        this.f5877a.f5955h.mo1576a(i, this.f5878b);
    }

    public void mo1590a(Bundle bundle) {
    }

    public void mo1591a(ConnectionResult connectionResult, C1864a<?> c1864a, int i) {
    }

    public <A extends C1721c, T extends C1714a<? extends C1857g, A>> T mo1592b(T t) {
        try {
            m9860c(t);
        } catch (DeadObjectException e) {
            this.f5877a.m9993a(new C1747a(this, this) {
                final /* synthetic */ mi f5875a;

                public void mo1586a() {
                    this.f5875a.mo1589a(1);
                }
            });
        }
        return t;
    }

    public boolean mo1593b() {
        if (this.f5878b) {
            return false;
        }
        if (this.f5877a.f5954g.m9984i()) {
            this.f5878b = true;
            for (ng a : this.f5877a.f5954g.f5930h) {
                a.m10124a();
            }
            return false;
        }
        this.f5877a.m9994a(null);
        return true;
    }

    public void mo1594c() {
        if (this.f5878b) {
            this.f5878b = false;
            this.f5877a.m9993a(new C1747a(this, this) {
                final /* synthetic */ mi f5876a;

                public void mo1586a() {
                    this.f5876a.f5877a.f5955h.mo1577a(null);
                }
            });
        }
    }

    void m9869d() {
        if (this.f5878b) {
            this.f5878b = false;
            this.f5877a.f5954g.f5931i.m10134a();
            mo1593b();
        }
    }
}
