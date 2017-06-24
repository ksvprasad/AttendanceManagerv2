package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.ads.p035c.C1025a;
import com.google.android.gms.ads.p035c.C1025a.C1023a;
import com.google.android.gms.common.internal.C1896c;
import com.google.firebase.iid.C2119c;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Locale;

class af extends C2019b {
    static final Pair<String, Long> f6770a = new Pair("", Long.valueOf(0));
    public final C2028c f6771b = new C2028c("health_monitor", mo1748y().m11841W());
    public final C2027b f6772c = new C2027b(this, "last_upload", 0);
    public final C2027b f6773d = new C2027b(this, "last_upload_attempt", 0);
    public final C2027b f6774e = new C2027b(this, "backoff", 0);
    public final C2027b f6775f = new C2027b(this, "last_delete_stale", 0);
    public final C2027b f6776g = new C2027b(this, "midnight_offset", 0);
    public final C2027b f6777h = new C2027b(this, "time_before_start", 10000);
    public final C2027b f6778i = new C2027b(this, "session_timeout", 1800000);
    public final C2026a f6779j = new C2026a(this, "start_new_session", true);
    public final C2027b f6780k = new C2027b(this, "last_pause_time", 0);
    public final C2027b f6781l = new C2027b(this, "time_active", 0);
    public boolean f6782m;
    private SharedPreferences f6783o;
    private String f6784p;
    private boolean f6785q;
    private long f6786r;
    private SecureRandom f6787s;

    public final class C2026a {
        final /* synthetic */ af f6755a;
        private final String f6756b;
        private final boolean f6757c;
        private boolean f6758d;
        private boolean f6759e;

        public C2026a(af afVar, String str, boolean z) {
            this.f6755a = afVar;
            C1896c.m10792a(str);
            this.f6756b = str;
            this.f6757c = z;
        }

        private void m11347b() {
            if (!this.f6758d) {
                this.f6758d = true;
                this.f6759e = this.f6755a.f6783o.getBoolean(this.f6756b, this.f6757c);
            }
        }

        public void m11348a(boolean z) {
            Editor edit = this.f6755a.f6783o.edit();
            edit.putBoolean(this.f6756b, z);
            edit.apply();
            this.f6759e = z;
        }

        public boolean m11349a() {
            m11347b();
            return this.f6759e;
        }
    }

    public final class C2027b {
        final /* synthetic */ af f6760a;
        private final String f6761b;
        private final long f6762c;
        private boolean f6763d;
        private long f6764e;

        public C2027b(af afVar, String str, long j) {
            this.f6760a = afVar;
            C1896c.m10792a(str);
            this.f6761b = str;
            this.f6762c = j;
        }

        private void m11350b() {
            if (!this.f6763d) {
                this.f6763d = true;
                this.f6764e = this.f6760a.f6783o.getLong(this.f6761b, this.f6762c);
            }
        }

        public long m11351a() {
            m11350b();
            return this.f6764e;
        }

        public void m11352a(long j) {
            Editor edit = this.f6760a.f6783o.edit();
            edit.putLong(this.f6761b, j);
            edit.apply();
            this.f6764e = j;
        }
    }

    public final class C2028c {
        final String f6765a;
        final /* synthetic */ af f6766b;
        private final String f6767c;
        private final String f6768d;
        private final long f6769e;

        private C2028c(af afVar, String str, long j) {
            this.f6766b = afVar;
            C1896c.m10792a(str);
            C1896c.m10798b(j > 0);
            this.f6765a = String.valueOf(str).concat(":start");
            this.f6767c = String.valueOf(str).concat(":count");
            this.f6768d = String.valueOf(str).concat(":value");
            this.f6769e = j;
        }

        private void m11353b() {
            this.f6766b.mo1733j();
            long a = this.f6766b.mo1739p().mo1723a();
            Editor edit = this.f6766b.f6783o.edit();
            edit.remove(this.f6767c);
            edit.remove(this.f6768d);
            edit.putLong(this.f6765a, a);
            edit.apply();
        }

        private long m11354c() {
            this.f6766b.mo1733j();
            long d = m11355d();
            if (d != 0) {
                return Math.abs(d - this.f6766b.mo1739p().mo1723a());
            }
            m11353b();
            return 0;
        }

        private long m11355d() {
            return this.f6766b.m11360F().getLong(this.f6765a, 0);
        }

        public Pair<String, Long> m11356a() {
            this.f6766b.mo1733j();
            long c = m11354c();
            if (c < this.f6769e) {
                return null;
            }
            if (c > this.f6769e * 2) {
                m11353b();
                return null;
            }
            String string = this.f6766b.m11360F().getString(this.f6768d, null);
            c = this.f6766b.m11360F().getLong(this.f6767c, 0);
            m11353b();
            return (string == null || c <= 0) ? af.f6770a : new Pair(string, Long.valueOf(c));
        }

        public void m11357a(String str) {
            m11358a(str, 1);
        }

        public void m11358a(String str, long j) {
            this.f6766b.mo1733j();
            if (m11355d() == 0) {
                m11353b();
            }
            if (str == null) {
                str = "";
            }
            long j2 = this.f6766b.f6783o.getLong(this.f6767c, 0);
            if (j2 <= 0) {
                Editor edit = this.f6766b.f6783o.edit();
                edit.putString(this.f6768d, str);
                edit.putLong(this.f6767c, j);
                edit.apply();
                return;
            }
            Object obj = (this.f6766b.m11359E().nextLong() & Long.MAX_VALUE) < (Long.MAX_VALUE / (j2 + j)) * j ? 1 : null;
            Editor edit2 = this.f6766b.f6783o.edit();
            if (obj != null) {
                edit2.putString(this.f6768d, str);
            }
            edit2.putLong(this.f6767c, j2 + j);
            edit2.apply();
        }
    }

    af(aj ajVar) {
        super(ajVar);
    }

    private SecureRandom m11359E() {
        mo1733j();
        if (this.f6787s == null) {
            this.f6787s = new SecureRandom();
        }
        return this.f6787s;
    }

    private SharedPreferences m11360F() {
        mo1733j();
        m11273c();
        return this.f6783o;
    }

    String m11364A() {
        mo1733j();
        return m11360F().getString("gmp_app_id", null);
    }

    Boolean m11365B() {
        mo1733j();
        return !m11360F().contains("use_service") ? null : Boolean.valueOf(m11360F().getBoolean("use_service", false));
    }

    void m11366C() {
        boolean z = true;
        mo1733j();
        mo1746w().m11283E().m11249a("Clearing collection preferences.");
        boolean contains = m11360F().contains("measurement_enabled");
        if (contains) {
            z = m11373c(true);
        }
        Editor edit = m11360F().edit();
        edit.clear();
        edit.apply();
        if (contains) {
            m11371b(z);
        }
    }

    protected String m11367D() {
        mo1733j();
        String string = m11360F().getString("previous_os_version", null);
        String g = mo1737n().m11942g();
        if (!(TextUtils.isEmpty(g) || g.equals(string))) {
            Editor edit = m11360F().edit();
            edit.putString("previous_os_version", g);
            edit.apply();
        }
        return string;
    }

    Pair<String, Boolean> m11368a(String str) {
        mo1733j();
        long b = mo1739p().mo1724b();
        if (this.f6784p != null && b < this.f6786r) {
            return new Pair(this.f6784p, Boolean.valueOf(this.f6785q));
        }
        this.f6786r = b + mo1748y().m11851b(str);
        C1025a.m5784b(true);
        try {
            C1023a b2 = C1025a.m5783b(mo1740q());
            this.f6784p = b2.m5776a();
            if (this.f6784p == null) {
                this.f6784p = "";
            }
            this.f6785q = b2.m5777b();
        } catch (Throwable th) {
            mo1746w().m11282D().m11250a("Unable to get advertising id", th);
            this.f6784p = "";
        }
        C1025a.m5784b(false);
        return new Pair(this.f6784p, Boolean.valueOf(this.f6785q));
    }

    void m11369a(boolean z) {
        mo1733j();
        mo1746w().m11283E().m11250a("Setting useService", Boolean.valueOf(z));
        Editor edit = m11360F().edit();
        edit.putBoolean("use_service", z);
        edit.apply();
    }

    String m11370b(String str) {
        String str2 = (String) m11368a(str).first;
        if (C2082m.m11757i("MD5") == null) {
            return null;
        }
        return String.format(Locale.US, "%032X", new Object[]{new BigInteger(1, C2082m.m11757i("MD5").digest(str2.getBytes()))});
    }

    void m11371b(boolean z) {
        mo1733j();
        mo1746w().m11283E().m11250a("Setting measurementEnabled", Boolean.valueOf(z));
        Editor edit = m11360F().edit();
        edit.putBoolean("measurement_enabled", z);
        edit.apply();
    }

    void m11372c(String str) {
        mo1733j();
        Editor edit = m11360F().edit();
        edit.putString("gmp_app_id", str);
        edit.apply();
    }

    boolean m11373c(boolean z) {
        mo1733j();
        return m11360F().getBoolean("measurement_enabled", z);
    }

    protected void mo1730e() {
        this.f6783o = mo1740q().getSharedPreferences("com.google.android.gms.measurement.prefs", 0);
        this.f6782m = this.f6783o.getBoolean("has_been_opened", false);
        if (!this.f6782m) {
            Editor edit = this.f6783o.edit();
            edit.putBoolean("has_been_opened", true);
            edit.apply();
        }
    }

    String m11375f() {
        m11359E().nextBytes(new byte[16]);
        return String.format(Locale.US, "%032x", new Object[]{new BigInteger(1, r0)});
    }

    String m11376g() {
        mo1733j();
        return C2119c.m12154a().m12155b();
    }

    long m11377z() {
        m11273c();
        mo1733j();
        long a = this.f6776g.m11351a();
        if (a != 0) {
            return a;
        }
        a = (long) (m11359E().nextInt(86400000) + 1);
        this.f6776g.m11352a(a);
        return a;
    }
}
