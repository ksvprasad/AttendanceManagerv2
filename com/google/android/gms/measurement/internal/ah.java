package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.support.v4.p015g.C0370a;
import com.google.android.gms.common.internal.C1896c;
import com.google.android.gms.common.util.C1970c;
import com.google.android.gms.measurement.AppMeasurement.C2009a;
import com.google.android.gms.p031b.C1841r;
import com.google.android.gms.p031b.C1843s;
import com.google.android.gms.p031b.nw.C1813a;
import com.google.android.gms.p031b.nw.C1814b;
import com.google.android.gms.p031b.nw.C1815c;
import java.io.IOException;
import java.util.Map;

public class ah extends C2019b {
    private final Map<String, Map<String, String>> f6791a = new C0370a();
    private final Map<String, Map<String, Boolean>> f6792b = new C0370a();
    private final Map<String, Map<String, Boolean>> f6793c = new C0370a();
    private final Map<String, C1814b> f6794d = new C0370a();
    private final Map<String, String> f6795e = new C0370a();

    ah(aj ajVar) {
        super(ajVar);
    }

    private C1814b m11380a(String str, byte[] bArr) {
        if (bArr == null) {
            return new C1814b();
        }
        C1841r a = C1841r.m10379a(bArr);
        C1814b c1814b = new C1814b();
        try {
            C1814b c1814b2 = (C1814b) c1814b.mo1234b(a);
            mo1746w().m11283E().m11251a("Parsed config. version, gmp_app_id", c1814b.f6132a, c1814b.f6133b);
            return c1814b;
        } catch (IOException e) {
            mo1746w().m11310z().m11251a("Unable to merge remote config", str, e);
            return null;
        }
    }

    private Map<String, String> m11381a(C1814b c1814b) {
        Map<String, String> c0370a = new C0370a();
        if (!(c1814b == null || c1814b.f6135d == null)) {
            for (C1815c c1815c : c1814b.f6135d) {
                if (c1815c != null) {
                    c0370a.put(c1815c.f6139a, c1815c.f6140b);
                }
            }
        }
        return c0370a;
    }

    private void m11382a(String str, C1814b c1814b) {
        Map c0370a = new C0370a();
        Map c0370a2 = new C0370a();
        if (!(c1814b == null || c1814b.f6136e == null)) {
            for (C1813a c1813a : c1814b.f6136e) {
                if (c1813a != null) {
                    String str2 = (String) C2009a.f6650a.get(c1813a.f6129a);
                    if (str2 != null) {
                        c1813a.f6129a = str2;
                    }
                    c0370a.put(c1813a.f6129a, c1813a.f6130b);
                    c0370a2.put(c1813a.f6129a, c1813a.f6131c);
                }
            }
        }
        this.f6792b.put(str, c0370a);
        this.f6793c.put(str, c0370a2);
    }

    private void m11383d(String str) {
        m11273c();
        mo1733j();
        C1896c.m10792a(str);
        if (!this.f6794d.containsKey(str)) {
            byte[] d = mo1741r().m11927d(str);
            if (d == null) {
                this.f6791a.put(str, null);
                this.f6792b.put(str, null);
                this.f6793c.put(str, null);
                this.f6794d.put(str, null);
                this.f6795e.put(str, null);
                return;
            }
            C1814b a = m11380a(str, d);
            this.f6791a.put(str, m11381a(a));
            m11382a(str, a);
            this.f6794d.put(str, a);
            this.f6795e.put(str, null);
        }
    }

    protected C1814b m11384a(String str) {
        m11273c();
        mo1733j();
        C1896c.m10792a(str);
        m11383d(str);
        return (C1814b) this.f6794d.get(str);
    }

    String m11385a(String str, String str2) {
        mo1733j();
        m11383d(str);
        Map map = (Map) this.f6791a.get(str);
        return map != null ? (String) map.get(str2) : null;
    }

    protected boolean m11386a(String str, byte[] bArr, String str2) {
        m11273c();
        mo1733j();
        C1896c.m10792a(str);
        C1814b a = m11380a(str, bArr);
        if (a == null) {
            return false;
        }
        m11382a(str, a);
        this.f6794d.put(str, a);
        this.f6795e.put(str, str2);
        this.f6791a.put(str, m11381a(a));
        mo1734k().m11813a(str, a.f6137f);
        try {
            a.f6137f = null;
            byte[] bArr2 = new byte[a.m7349f()];
            a.mo1231a(C1843s.m10412a(bArr2));
            bArr = bArr2;
        } catch (IOException e) {
            mo1746w().m11310z().m11250a("Unable to serialize reduced-size config.  Storing full config instead.", e);
        }
        mo1741r().m11914a(str, bArr);
        return true;
    }

    protected String m11387b(String str) {
        mo1733j();
        return (String) this.f6795e.get(str);
    }

    boolean m11388b(String str, String str2) {
        mo1733j();
        m11383d(str);
        Map map = (Map) this.f6792b.get(str);
        if (map == null) {
            return false;
        }
        Boolean bool = (Boolean) map.get(str2);
        return bool == null ? false : bool.booleanValue();
    }

    protected void m11389c(String str) {
        mo1733j();
        this.f6795e.put(str, null);
    }

    boolean m11390c(String str, String str2) {
        mo1733j();
        m11383d(str);
        Map map = (Map) this.f6793c.get(str);
        if (map == null) {
            return false;
        }
        Boolean bool = (Boolean) map.get(str2);
        return bool == null ? false : bool.booleanValue();
    }

    protected void mo1730e() {
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
