package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri.Builder;
import android.text.TextUtils;
import com.google.android.gms.common.C1876j;
import com.google.android.gms.common.internal.C1896c;
import com.google.android.gms.common.util.C1970c;
import com.google.android.gms.common.util.C1980m;
import com.google.android.gms.measurement.internal.C2096x.C2095a;
import com.google.android.gms.p031b.ms;

public class C2085p extends al {
    static final String f6965a = String.valueOf(C1876j.f6382b / 1000).replaceAll("(\\d+)(\\d)(\\d\\d)", "$1.$2.$3");
    private Boolean f6966b;

    C2085p(aj ajVar) {
        super(ajVar);
    }

    private Boolean m11818g(String str) {
        Boolean bool = null;
        C1896c.m10792a(str);
        try {
            PackageManager packageManager = mo1740q().getPackageManager();
            if (packageManager == null) {
                mo1746w().m11290f().m11249a("Failed to load metadata: PackageManager is null");
            } else {
                ApplicationInfo applicationInfo = packageManager.getApplicationInfo(mo1740q().getPackageName(), 128);
                if (applicationInfo == null) {
                    mo1746w().m11290f().m11249a("Failed to load metadata: ApplicationInfo is null");
                } else if (applicationInfo.metaData == null) {
                    mo1746w().m11290f().m11249a("Failed to load metadata: Metadata bundle is null");
                } else if (applicationInfo.metaData.containsKey(str)) {
                    bool = Boolean.valueOf(applicationInfo.metaData.getBoolean(str));
                }
            }
        } catch (NameNotFoundException e) {
            mo1746w().m11290f().m11250a("Failed to load metadata: Package name not found", e);
        }
        return bool;
    }

    public int m11819A() {
        return 2048;
    }

    int m11820B() {
        return 500;
    }

    public long m11821C() {
        return (long) ((Integer) C2096x.f7006m.m11982b()).intValue();
    }

    public long m11822D() {
        return (long) ((Integer) C2096x.f7007n.m11982b()).intValue();
    }

    public long m11823E() {
        return 1000;
    }

    int m11824F() {
        return 25;
    }

    int m11825G() {
        return 50;
    }

    long m11826H() {
        return 3600000;
    }

    long m11827I() {
        return 60000;
    }

    long m11828J() {
        return 61000;
    }

    long m11829K() {
        return ((Long) C2096x.f6993A.m11982b()).longValue();
    }

    public String m11830L() {
        return "google_app_measurement.db";
    }

    public String m11831M() {
        return "google_app_measurement2.db";
    }

    public long m11832N() {
        return 9452;
    }

    public boolean m11833O() {
        return false;
    }

    public boolean m11834P() {
        if (this.f6966b == null) {
            synchronized (this) {
                if (this.f6966b == null) {
                    ApplicationInfo applicationInfo = mo1740q().getApplicationInfo();
                    String b = C1980m.m11121b();
                    if (applicationInfo != null) {
                        String str = applicationInfo.processName;
                        boolean z = str != null && str.equals(b);
                        this.f6966b = Boolean.valueOf(z);
                    }
                    if (this.f6966b == null) {
                        this.f6966b = Boolean.TRUE;
                        mo1746w().m11290f().m11249a("My process not in the list of running processes");
                    }
                }
            }
        }
        return this.f6966b.booleanValue();
    }

    public boolean m11835Q() {
        if (m11833O()) {
            return false;
        }
        Boolean g = m11818g("firebase_analytics_collection_deactivated");
        return (g == null || g.booleanValue()) ? false : true;
    }

    public Boolean m11836R() {
        return m11833O() ? null : m11818g("firebase_analytics_collection_enabled");
    }

    public boolean m11837S() {
        return ms.m10071b();
    }

    public long m11838T() {
        return ((Long) C2096x.f7018y.m11982b()).longValue();
    }

    public long m11839U() {
        return ((Long) C2096x.f7014u.m11982b()).longValue();
    }

    public long m11840V() {
        return 1000;
    }

    public long m11841W() {
        return Math.max(0, ((Long) C2096x.f6998e.m11982b()).longValue());
    }

    public int m11842X() {
        return Math.max(0, ((Integer) C2096x.f7004k.m11982b()).intValue());
    }

    public int m11843Y() {
        return Math.max(1, ((Integer) C2096x.f7005l.m11982b()).intValue());
    }

    public String m11844Z() {
        return (String) C2096x.f7010q.m11982b();
    }

    public int m11845a(String str) {
        return m11850b(str, C2096x.f7008o);
    }

    public long m11846a(String str, C2095a<Long> c2095a) {
        if (str == null) {
            return ((Long) c2095a.m11982b()).longValue();
        }
        Object a = mo1743t().m11385a(str, c2095a.m11981a());
        if (TextUtils.isEmpty(a)) {
            return ((Long) c2095a.m11982b()).longValue();
        }
        try {
            return ((Long) c2095a.m11980a(Long.valueOf(Long.valueOf(a).longValue()))).longValue();
        } catch (NumberFormatException e) {
            return ((Long) c2095a.m11982b()).longValue();
        }
    }

    String m11847a() {
        return (String) C2096x.f6996c.m11982b();
    }

    public String m11848a(String str, String str2) {
        Builder builder = new Builder();
        Builder encodedAuthority = builder.scheme((String) C2096x.f7000g.m11982b()).encodedAuthority((String) C2096x.f7001h.m11982b());
        String str3 = "config/app/";
        String valueOf = String.valueOf(str);
        encodedAuthority.path(valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3)).appendQueryParameter("app_instance_id", str2).appendQueryParameter("platform", "android").appendQueryParameter("gmp_version", String.valueOf(m11832N()));
        return builder.build().toString();
    }

    public long aa() {
        return ((Long) C2096x.f6999f.m11982b()).longValue();
    }

    public long ab() {
        return Math.max(0, ((Long) C2096x.f7011r.m11982b()).longValue());
    }

    public long ac() {
        return Math.max(0, ((Long) C2096x.f7013t.m11982b()).longValue());
    }

    public long ad() {
        return ((Long) C2096x.f7012s.m11982b()).longValue();
    }

    public long ae() {
        return Math.max(0, ((Long) C2096x.f7015v.m11982b()).longValue());
    }

    public long af() {
        return Math.max(0, ((Long) C2096x.f7016w.m11982b()).longValue());
    }

    public int ag() {
        return Math.min(20, Math.max(0, ((Integer) C2096x.f7017x.m11982b()).intValue()));
    }

    public int m11849b() {
        return 25;
    }

    public int m11850b(String str, C2095a<Integer> c2095a) {
        if (str == null) {
            return ((Integer) c2095a.m11982b()).intValue();
        }
        Object a = mo1743t().m11385a(str, c2095a.m11981a());
        if (TextUtils.isEmpty(a)) {
            return ((Integer) c2095a.m11982b()).intValue();
        }
        try {
            return ((Integer) c2095a.m11980a(Integer.valueOf(Integer.valueOf(a).intValue()))).intValue();
        } catch (NumberFormatException e) {
            return ((Integer) c2095a.m11982b()).intValue();
        }
    }

    long m11851b(String str) {
        return m11846a(str, C2096x.f6997d);
    }

    public int m11852c() {
        return 32;
    }

    int m11853c(String str) {
        return m11850b(str, C2096x.f7019z);
    }

    public int m11854d() {
        return 24;
    }

    public int m11855d(String str) {
        return m11850b(str, C2096x.f7002i);
    }

    int m11856e() {
        return 24;
    }

    public int m11857e(String str) {
        return Math.max(0, m11850b(str, C2096x.f7003j));
    }

    int m11858f() {
        return 36;
    }

    public int m11859f(String str) {
        return Math.max(0, Math.min(1000000, m11850b(str, C2096x.f7009p)));
    }

    int m11860g() {
        return 256;
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

    public int m11879z() {
        return 36;
    }
}
