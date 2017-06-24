package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.common.internal.C1896c;
import com.google.android.gms.common.util.C1970c;
import com.google.android.gms.measurement.AppMeasurement;

public class ab extends C2019b {
    private final String f6716a = mo1748y().m11847a();
    private final char f6717b;
    private final long f6718c = mo1748y().m11832N();
    private final C2018a f6719d;
    private final C2018a f6720e;
    private final C2018a f6721f;
    private final C2018a f6722g;
    private final C2018a f6723h;
    private final C2018a f6724i;
    private final C2018a f6725j;
    private final C2018a f6726k;
    private final C2018a f6727l;

    public class C2018a {
        final /* synthetic */ ab f6710a;
        private final int f6711b;
        private final boolean f6712c;
        private final boolean f6713d;

        C2018a(ab abVar, int i, boolean z, boolean z2) {
            this.f6710a = abVar;
            this.f6711b = i;
            this.f6712c = z;
            this.f6713d = z2;
        }

        public void m11249a(String str) {
            this.f6710a.m11287a(this.f6711b, this.f6712c, this.f6713d, str, null, null, null);
        }

        public void m11250a(String str, Object obj) {
            this.f6710a.m11287a(this.f6711b, this.f6712c, this.f6713d, str, obj, null, null);
        }

        public void m11251a(String str, Object obj, Object obj2) {
            this.f6710a.m11287a(this.f6711b, this.f6712c, this.f6713d, str, obj, obj2, null);
        }

        public void m11252a(String str, Object obj, Object obj2, Object obj3) {
            this.f6710a.m11287a(this.f6711b, this.f6712c, this.f6713d, str, obj, obj2, obj3);
        }
    }

    ab(aj ajVar) {
        super(ajVar);
        if (mo1748y().m11834P()) {
            this.f6717b = mo1748y().m11833O() ? 'P' : 'C';
        } else {
            this.f6717b = mo1748y().m11833O() ? 'p' : 'c';
        }
        this.f6719d = new C2018a(this, 6, false, false);
        this.f6720e = new C2018a(this, 6, true, false);
        this.f6721f = new C2018a(this, 6, false, true);
        this.f6722g = new C2018a(this, 5, false, false);
        this.f6723h = new C2018a(this, 5, true, false);
        this.f6724i = new C2018a(this, 5, false, true);
        this.f6725j = new C2018a(this, 4, false, false);
        this.f6726k = new C2018a(this, 3, false, false);
        this.f6727l = new C2018a(this, 2, false, false);
    }

    private static String m11276a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        int lastIndexOf = str.lastIndexOf(46);
        return lastIndexOf != -1 ? str.substring(0, lastIndexOf) : str;
    }

    static String m11277a(boolean z, Object obj) {
        if (obj == null) {
            return "";
        }
        Object valueOf = obj instanceof Integer ? Long.valueOf((long) ((Integer) obj).intValue()) : obj;
        if (valueOf instanceof Long) {
            if (!z) {
                return String.valueOf(valueOf);
            }
            if (Math.abs(((Long) valueOf).longValue()) < 100) {
                return String.valueOf(valueOf);
            }
            String str = String.valueOf(valueOf).charAt(0) == '-' ? "-" : "";
            String valueOf2 = String.valueOf(Math.abs(((Long) valueOf).longValue()));
            return new StringBuilder((String.valueOf(str).length() + 43) + String.valueOf(str).length()).append(str).append(Math.round(Math.pow(10.0d, (double) (valueOf2.length() - 1)))).append("...").append(str).append(Math.round(Math.pow(10.0d, (double) valueOf2.length()) - 1.0d)).toString();
        } else if (valueOf instanceof Boolean) {
            return String.valueOf(valueOf);
        } else {
            if (!(valueOf instanceof Throwable)) {
                return z ? "-" : String.valueOf(valueOf);
            } else {
                Throwable th = (Throwable) valueOf;
                StringBuilder stringBuilder = new StringBuilder(z ? th.getClass().getName() : th.toString());
                String a = m11276a(AppMeasurement.class.getCanonicalName());
                String a2 = m11276a(aj.class.getCanonicalName());
                for (StackTraceElement stackTraceElement : th.getStackTrace()) {
                    if (!stackTraceElement.isNativeMethod()) {
                        String className = stackTraceElement.getClassName();
                        if (className != null) {
                            className = m11276a(className);
                            if (className.equals(a) || className.equals(a2)) {
                                stringBuilder.append(": ");
                                stringBuilder.append(stackTraceElement);
                                break;
                            }
                        } else {
                            continue;
                        }
                    }
                }
                return stringBuilder.toString();
            }
        }
    }

    static String m11278a(boolean z, String str, Object obj, Object obj2, Object obj3) {
        if (str == null) {
            Object obj4 = "";
        }
        Object a = m11277a(z, obj);
        Object a2 = m11277a(z, obj2);
        Object a3 = m11277a(z, obj3);
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "";
        if (!TextUtils.isEmpty(obj4)) {
            stringBuilder.append(obj4);
            str2 = ": ";
        }
        if (!TextUtils.isEmpty(a)) {
            stringBuilder.append(str2);
            stringBuilder.append(a);
            str2 = ", ";
        }
        if (!TextUtils.isEmpty(a2)) {
            stringBuilder.append(str2);
            stringBuilder.append(a2);
            str2 = ", ";
        }
        if (!TextUtils.isEmpty(a3)) {
            stringBuilder.append(str2);
            stringBuilder.append(a3);
        }
        return stringBuilder.toString();
    }

    public C2018a m11279A() {
        return this.f6723h;
    }

    public C2018a m11280B() {
        return this.f6724i;
    }

    public C2018a m11281C() {
        return this.f6725j;
    }

    public C2018a m11282D() {
        return this.f6726k;
    }

    public C2018a m11283E() {
        return this.f6727l;
    }

    public String m11284F() {
        Pair a = mo1747x().f6771b.m11356a();
        if (a == null || a == af.f6770a) {
            return null;
        }
        String valueOf = String.valueOf(String.valueOf(a.second));
        String str = (String) a.first;
        return new StringBuilder((String.valueOf(valueOf).length() + 1) + String.valueOf(str).length()).append(valueOf).append(":").append(str).toString();
    }

    protected void m11285a(int i, String str) {
        Log.println(i, this.f6716a, str);
    }

    public void m11286a(int i, String str, Object obj, Object obj2, Object obj3) {
        C1896c.m10790a((Object) str);
        ai k = this.n.m11507k();
        if (k == null) {
            m11285a(6, "Scheduler not set. Not logging error/warn.");
        } else if (!k.m11271a()) {
            m11285a(6, "Scheduler not initialized. Not logging error/warn.");
        } else if (k.m11272b()) {
            m11285a(6, "Scheduler shutdown. Not logging error/warn.");
        } else {
            if (i < 0) {
                i = 0;
            }
            if (i >= "01VDIWEA?".length()) {
                i = "01VDIWEA?".length() - 1;
            }
            String valueOf = String.valueOf("1");
            char charAt = "01VDIWEA?".charAt(i);
            char c = this.f6717b;
            long j = this.f6718c;
            String valueOf2 = String.valueOf(m11278a(true, str, obj, obj2, obj3));
            valueOf = new StringBuilder((String.valueOf(valueOf).length() + 23) + String.valueOf(valueOf2).length()).append(valueOf).append(charAt).append(c).append(j).append(":").append(valueOf2).toString();
            if (valueOf.length() > 1024) {
                valueOf = str.substring(0, 1024);
            }
            k.m11424a(new Runnable(this) {
                final /* synthetic */ ab f6709b;

                public void run() {
                    af e = this.f6709b.n.m11501e();
                    if (!e.m11271a() || e.m11272b()) {
                        this.f6709b.m11285a(6, "Persisted config not initialized . Not logging error/warn.");
                    } else {
                        e.f6771b.m11357a(valueOf);
                    }
                }
            });
        }
    }

    protected void m11287a(int i, boolean z, boolean z2, String str, Object obj, Object obj2, Object obj3) {
        if (!z && m11288a(i)) {
            m11285a(i, m11278a(false, str, obj, obj2, obj3));
        }
        if (!z2 && i >= 5) {
            m11286a(i, str, obj, obj2, obj3);
        }
    }

    protected boolean m11288a(int i) {
        return Log.isLoggable(this.f6716a, i);
    }

    protected void mo1730e() {
    }

    public C2018a m11290f() {
        return this.f6719d;
    }

    public C2018a m11291g() {
        return this.f6720e;
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

    public C2018a m11310z() {
        return this.f6722g;
    }
}
