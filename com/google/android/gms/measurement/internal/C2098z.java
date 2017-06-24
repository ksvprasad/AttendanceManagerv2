package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.text.TextUtils;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.util.C1970c;
import com.google.android.gms.p031b.ms;
import java.io.ByteArrayInputStream;
import java.security.MessageDigest;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import javax.security.auth.x500.X500Principal;

public class C2098z extends C2019b {
    private static final X500Principal f7021a = new X500Principal("CN=Android Debug,O=Android,C=US");
    private String f7022b;
    private String f7023c;
    private int f7024d;
    private String f7025e;
    private String f7026f;
    private long f7027g;
    private String f7028h;

    C2098z(aj ajVar) {
        super(ajVar);
    }

    int m11990A() {
        m11273c();
        return this.f7024d;
    }

    String m11991B() {
        m11273c();
        return this.f7025e;
    }

    long m11992C() {
        return mo1748y().m11832N();
    }

    long m11993D() {
        m11273c();
        return this.f7027g;
    }

    boolean m11994E() {
        try {
            PackageInfo packageInfo = mo1740q().getPackageManager().getPackageInfo(mo1740q().getPackageName(), 64);
            if (!(packageInfo == null || packageInfo.signatures == null || packageInfo.signatures.length <= 0)) {
                return ((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(packageInfo.signatures[0].toByteArray()))).getSubjectX500Principal().equals(f7021a);
            }
        } catch (CertificateException e) {
            mo1746w().m11290f().m11250a("Error obtaining certificate", e);
        } catch (NameNotFoundException e2) {
            mo1746w().m11290f().m11250a("Package name not found", e2);
        }
        return true;
    }

    AppMetadata m11995a(String str) {
        return new AppMetadata(m11998f(), m11999g(), m12018z(), (long) m11990A(), m11991B(), m11992C(), m11993D(), str, this.n.m11470D(), !mo1747x().f6782m, mo1747x().m11376g());
    }

    protected void m11996a(Status status) {
        if (status == null) {
            mo1746w().m11290f().m11249a("GoogleService failed to initialize (no status)");
        } else {
            mo1746w().m11290f().m11251a("GoogleService failed to initialize, status", Integer.valueOf(status.m10566f()), status.m10563c());
        }
    }

    protected void mo1730e() {
        String str = "Unknown";
        int i = Integer.MIN_VALUE;
        String str2 = "Unknown";
        PackageManager packageManager = mo1740q().getPackageManager();
        String packageName = mo1740q().getPackageName();
        String installerPackageName = packageManager.getInstallerPackageName(packageName);
        if (installerPackageName == null) {
            installerPackageName = "manual_install";
        } else if ("com.android.vending".equals(installerPackageName)) {
            installerPackageName = "";
        }
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(mo1740q().getPackageName(), 0);
            if (packageInfo != null) {
                CharSequence applicationLabel = packageManager.getApplicationLabel(packageInfo.applicationInfo);
                if (!TextUtils.isEmpty(applicationLabel)) {
                    str2 = applicationLabel.toString();
                }
                str = packageInfo.versionName;
                i = packageInfo.versionCode;
            }
        } catch (NameNotFoundException e) {
            mo1746w().m11290f().m11250a("Error retrieving package info: appName", str2);
        }
        this.f7022b = packageName;
        this.f7025e = installerPackageName;
        this.f7023c = str;
        this.f7024d = i;
        this.f7026f = str2;
        MessageDigest i2 = C2082m.m11757i("MD5");
        if (i2 == null) {
            mo1746w().m11290f().m11249a("Could not get MD5 instance");
            this.f7027g = -1;
        } else {
            this.f7027g = 0;
            try {
                if (!m11994E()) {
                    PackageInfo packageInfo2 = packageManager.getPackageInfo(mo1740q().getPackageName(), 64);
                    if (packageInfo2.signatures != null && packageInfo2.signatures.length > 0) {
                        this.f7027g = C2082m.m11755c(i2.digest(packageInfo2.signatures[0].toByteArray()));
                    }
                }
            } catch (NameNotFoundException e2) {
                mo1746w().m11290f().m11250a("Package name not found", e2);
            }
        }
        Status a = mo1748y().m11833O() ? ms.m10068a(mo1740q(), "-", true) : ms.m10067a(mo1740q());
        boolean z = a != null && a.m10565e();
        if (!z) {
            m11996a(a);
        }
        if (z) {
            Boolean R = mo1748y().m11836R();
            if (mo1748y().m11835Q()) {
                mo1746w().m11281C().m11249a("Collection disabled with firebase_analytics_collection_deactivated=1");
                z = false;
            } else if (R != null && !R.booleanValue()) {
                mo1746w().m11281C().m11249a("Collection disabled with firebase_analytics_collection_enabled=0");
                z = false;
            } else if (R == null && mo1748y().m11837S()) {
                mo1746w().m11281C().m11249a("Collection disabled with google_app_measurement_enable=0");
                z = false;
            } else {
                mo1746w().m11283E().m11249a("Collection enabled");
                z = true;
            }
        } else {
            z = false;
        }
        this.f7028h = "";
        if (!mo1748y().m11833O()) {
            try {
                String a2 = ms.m10069a();
                if (TextUtils.isEmpty(a2)) {
                    a2 = "";
                }
                this.f7028h = a2;
                if (z) {
                    mo1746w().m11283E().m11251a("App package, google app id", this.f7022b, this.f7028h);
                }
            } catch (IllegalStateException e3) {
                mo1746w().m11290f().m11250a("getGoogleAppId or isMeasurementEnabled failed with exception", e3);
            }
        }
    }

    String m11998f() {
        m11273c();
        return this.f7022b;
    }

    String m11999g() {
        m11273c();
        return this.f7028h;
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

    String m12018z() {
        m11273c();
        return this.f7023c;
    }
}
