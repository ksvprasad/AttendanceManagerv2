package com.google.android.gms.measurement.internal;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.common.internal.C1896c;
import com.google.android.gms.common.util.C1970c;

public class C2079j extends C2019b {
    private boolean f6959a;
    private final AlarmManager f6960b = ((AlarmManager) mo1740q().getSystemService("alarm"));

    protected C2079j(aj ajVar) {
        super(ajVar);
    }

    private PendingIntent m11709g() {
        Intent className = new Intent().setClassName(mo1740q(), "com.google.android.gms.measurement.AppMeasurementReceiver");
        className.setAction("com.google.android.gms.measurement.UPLOAD");
        return PendingIntent.getBroadcast(mo1740q(), 0, className, 0);
    }

    public void m11710a(long j) {
        m11273c();
        C1896c.m10798b(j > 0);
        C1896c.m10795a(ag.m11378a(mo1740q()), (Object) "Receiver not registered/enabled");
        C1896c.m10795a(C2069f.m11661a(mo1740q()), (Object) "Service not registered/enabled");
        m11712f();
        long b = mo1739p().mo1724b() + j;
        this.f6959a = true;
        this.f6960b.setInexactRepeating(2, b, Math.max(mo1748y().ad(), j), m11709g());
    }

    protected void mo1730e() {
        this.f6960b.cancel(m11709g());
    }

    public void m11712f() {
        m11273c();
        this.f6959a = false;
        this.f6960b.cancel(m11709g());
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
}
