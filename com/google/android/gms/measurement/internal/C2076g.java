package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.util.C1970c;

public class C2076g extends C2019b {
    private Handler f6946a;
    private long f6947b;
    private final Runnable f6948c = new C20711(this);
    private final C2054r f6949d = new C2054r(this, this.n) {
        final /* synthetic */ C2076g f6940a;

        public void mo1759a() {
            this.f6940a.m11674B();
        }
    };
    private final C2054r f6950e = new C2054r(this, this.n) {
        final /* synthetic */ C2076g f6941a;

        public void mo1759a() {
            this.f6941a.m11675C();
        }
    };

    class C20711 implements Runnable {
        final /* synthetic */ C2076g f6939a;

        class C20701 implements Runnable {
            final /* synthetic */ C20711 f6938a;

            C20701(C20711 c20711) {
                this.f6938a = c20711;
            }

            public void run() {
                this.f6938a.f6939a.m11703z();
            }
        }

        C20711(C2076g c2076g) {
            this.f6939a = c2076g;
        }

        public void run() {
            this.f6939a.mo1745v().m11424a(new C20701(this));
        }
    }

    C2076g(aj ajVar) {
        super(ajVar);
    }

    private void m11673A() {
        synchronized (this) {
            if (this.f6946a == null) {
                this.f6946a = new Handler(Looper.getMainLooper());
            }
        }
    }

    private void m11674B() {
        mo1733j();
        mo1746w().m11283E().m11250a("Session started, time", Long.valueOf(mo1739p().mo1724b()));
        mo1747x().f6779j.m11348a(false);
        mo1735l().m11579a("auto", "_s", new Bundle());
    }

    private void m11675C() {
        mo1733j();
        long b = mo1739p().mo1724b();
        if (this.f6947b == 0) {
            this.f6947b = b - 3600000;
        }
        long a = mo1747x().f6781l.m11351a() + (b - this.f6947b);
        mo1747x().f6781l.m11352a(a);
        mo1746w().m11283E().m11250a("Recording user engagement, ms", Long.valueOf(a));
        Bundle bundle = new Bundle();
        bundle.putLong("_et", a);
        mo1735l().m11579a("auto", "_e", bundle);
        mo1747x().f6781l.m11352a(0);
        this.f6947b = b;
        this.f6950e.m11608a(Math.max(0, 3600000 - mo1747x().f6781l.m11351a()));
    }

    private void m11676a(long j) {
        mo1733j();
        m11673A();
        this.f6949d.m11610c();
        this.f6950e.m11610c();
        mo1746w().m11283E().m11250a("Activity resumed, time", Long.valueOf(j));
        this.f6947b = j;
        if (mo1739p().mo1723a() - mo1747x().f6778i.m11351a() > mo1747x().f6780k.m11351a()) {
            mo1747x().f6779j.m11348a(true);
            mo1747x().f6781l.m11352a(0);
        }
        if (mo1747x().f6779j.m11349a()) {
            this.f6949d.m11608a(Math.max(0, mo1747x().f6777h.m11351a() - mo1747x().f6781l.m11351a()));
        } else {
            this.f6950e.m11608a(Math.max(0, 3600000 - mo1747x().f6781l.m11351a()));
        }
    }

    private void m11679b(long j) {
        mo1733j();
        m11673A();
        this.f6949d.m11610c();
        this.f6950e.m11610c();
        mo1746w().m11283E().m11250a("Activity paused, time", Long.valueOf(j));
        if (this.f6947b != 0) {
            mo1747x().f6781l.m11352a(mo1747x().f6781l.m11351a() + (j - this.f6947b));
        }
        mo1747x().f6780k.m11352a(mo1739p().mo1723a());
        synchronized (this) {
            if (!mo1747x().f6779j.m11349a()) {
                this.f6946a.postDelayed(this.f6948c, 1000);
            }
        }
    }

    protected void mo1730e() {
    }

    protected void m11683f() {
        synchronized (this) {
            m11673A();
            this.f6946a.removeCallbacks(this.f6948c);
        }
        final long b = mo1739p().mo1724b();
        mo1745v().m11424a(new Runnable(this) {
            final /* synthetic */ C2076g f6943b;

            public void run() {
                this.f6943b.m11676a(b);
            }
        });
    }

    protected void m11684g() {
        final long b = mo1739p().mo1724b();
        mo1745v().m11424a(new Runnable(this) {
            final /* synthetic */ C2076g f6945b;

            public void run() {
                this.f6945b.m11679b(b);
            }
        });
    }

    public /* bridge */ /* synthetic */ void mo1731h() {
        super.mo1731h();
    }

    public /* bridge */ /* synthetic */ void mo1732i() {
        super.mo1732i();
    }

    public /* bridge */ /* synthetic */ void mo1733j() {
        super.mo1733j();
    }

    public /* bridge */ /* synthetic */ C2084o mo1734k() {
        return super.mo1734k();
    }

    public /* bridge */ /* synthetic */ C2053d mo1735l() {
        return super.mo1735l();
    }

    public /* bridge */ /* synthetic */ C2098z mo1736m() {
        return super.mo1736m();
    }

    public /* bridge */ /* synthetic */ C2090s mo1737n() {
        return super.mo1737n();
    }

    public /* bridge */ /* synthetic */ C2066e mo1738o() {
        return super.mo1738o();
    }

    public /* bridge */ /* synthetic */ C1970c mo1739p() {
        return super.mo1739p();
    }

    public /* bridge */ /* synthetic */ Context mo1740q() {
        return super.mo1740q();
    }

    public /* bridge */ /* synthetic */ C2088q mo1741r() {
        return super.mo1741r();
    }

    public /* bridge */ /* synthetic */ C2082m mo1742s() {
        return super.mo1742s();
    }

    public /* bridge */ /* synthetic */ ah mo1743t() {
        return super.mo1743t();
    }

    public /* bridge */ /* synthetic */ C2076g mo1744u() {
        return super.mo1744u();
    }

    public /* bridge */ /* synthetic */ ai mo1745v() {
        return super.mo1745v();
    }

    public /* bridge */ /* synthetic */ ab mo1746w() {
        return super.mo1746w();
    }

    public /* bridge */ /* synthetic */ af mo1747x() {
        return super.mo1747x();
    }

    public /* bridge */ /* synthetic */ C2085p mo1748y() {
        return super.mo1748y();
    }

    public void m11703z() {
        mo1733j();
        mo1746w().m11282D().m11249a("Application backgrounded. Logging engagement");
        long a = mo1747x().f6781l.m11351a();
        if (a > 0) {
            Bundle bundle = new Bundle();
            bundle.putLong("_et", a);
            mo1735l().m11579a("auto", "_e", bundle);
            mo1747x().f6781l.m11352a(0);
            return;
        }
        mo1746w().m11310z().m11250a("Not logging non-positive engagement time", Long.valueOf(a));
    }
}
