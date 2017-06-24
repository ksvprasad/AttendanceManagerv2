package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build;
import android.os.Build.VERSION;
import com.google.android.gms.common.util.C1970c;
import java.util.Calendar;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class C2090s extends C2019b {
    private long f6976a;
    private String f6977b;
    private Boolean f6978c;

    C2090s(aj ajVar) {
        super(ajVar);
    }

    public String m11938A() {
        m11273c();
        return this.f6977b;
    }

    public boolean m11939a(Context context) {
        if (this.f6978c == null) {
            if (mo1748y().m11833O()) {
                this.f6978c = Boolean.valueOf(true);
            } else {
                this.f6978c = Boolean.valueOf(false);
                try {
                    PackageManager packageManager = context.getPackageManager();
                    if (packageManager != null) {
                        packageManager.getPackageInfo("com.google.android.gms", 128);
                        this.f6978c = Boolean.valueOf(true);
                    }
                } catch (NameNotFoundException e) {
                }
            }
        }
        return this.f6978c.booleanValue();
    }

    protected void mo1730e() {
        Calendar instance = Calendar.getInstance();
        this.f6976a = TimeUnit.MINUTES.convert((long) (instance.get(16) + instance.get(15)), TimeUnit.MILLISECONDS);
        Locale locale = Locale.getDefault();
        String valueOf = String.valueOf(locale.getLanguage().toLowerCase(Locale.ENGLISH));
        String valueOf2 = String.valueOf(locale.getCountry().toLowerCase(Locale.ENGLISH));
        this.f6977b = new StringBuilder((String.valueOf(valueOf).length() + 1) + String.valueOf(valueOf2).length()).append(valueOf).append("-").append(valueOf2).toString();
    }

    public String m11941f() {
        m11273c();
        return Build.MODEL;
    }

    public String m11942g() {
        m11273c();
        return VERSION.RELEASE;
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

    public long m11961z() {
        m11273c();
        return this.f6976a;
    }
}
