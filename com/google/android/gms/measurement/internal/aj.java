package com.google.android.gms.measurement.internal;

import android.app.Application;
import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.provider.Settings.Secure;
import android.support.v4.p015g.C0370a;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.common.internal.C1896c;
import com.google.android.gms.common.util.C1970c;
import com.google.android.gms.measurement.AppMeasurement;
import com.google.android.gms.measurement.internal.C2088q.C2036b;
import com.google.android.gms.measurement.internal.C2088q.C2086a;
import com.google.android.gms.measurement.internal.ac.C2021a;
import com.google.android.gms.p031b.C1843s;
import com.google.android.gms.p031b.nw.C1814b;
import com.google.android.gms.p031b.nx.C1816a;
import com.google.android.gms.p031b.nx.C1817b;
import com.google.android.gms.p031b.nx.C1818c;
import com.google.android.gms.p031b.nx.C1819d;
import com.google.android.gms.p031b.nx.C1820e;
import com.google.android.gms.p031b.nx.C1822g;
import com.google.firebase.p038a.C2111a;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class aj {
    private static volatile aj f6823b;
    private List<Long> f6824A;
    private int f6825B;
    private int f6826C;
    public final C2111a f6827a = new C2111a(this);
    private final Context f6828c;
    private final C2085p f6829d;
    private final af f6830e;
    private final ab f6831f;
    private final ai f6832g;
    private final C2076g f6833h;
    private final ah f6834i;
    private final AppMeasurement f6835j;
    private final C2082m f6836k;
    private final C2088q f6837l;
    private final ac f6838m;
    private final C1970c f6839n;
    private final C2066e f6840o;
    private final C2090s f6841p;
    private final C2053d f6842q;
    private final C2098z f6843r;
    private final ad f6844s;
    private final C2079j f6845t;
    private final C2084o f6846u;
    private final boolean f6847v;
    private boolean f6848w;
    private Boolean f6849x;
    private FileLock f6850y;
    private FileChannel f6851z;

    class C20331 implements Runnable {
        final /* synthetic */ aj f6815a;

        C20331(aj ajVar) {
            this.f6815a = ajVar;
        }

        public void run() {
            this.f6815a.m11497c();
        }
    }

    class C20342 implements C2021a {
        final /* synthetic */ aj f6816a;

        C20342(aj ajVar) {
            this.f6816a = ajVar;
        }

        public void mo1749a(String str, int i, Throwable th, byte[] bArr, Map<String, List<String>> map) {
            this.f6816a.m11459a(i, th, bArr);
        }
    }

    class C20353 implements C2021a {
        final /* synthetic */ aj f6817a;

        C20353(aj ajVar) {
            this.f6817a = ajVar;
        }

        public void mo1749a(String str, int i, Throwable th, byte[] bArr, Map<String, List<String>> map) {
            this.f6817a.m11487a(str, i, th, bArr, map);
        }
    }

    private class C2037a implements C2036b {
        C1820e f6818a;
        List<Long> f6819b;
        List<C1817b> f6820c;
        long f6821d;
        final /* synthetic */ aj f6822e;

        private C2037a(aj ajVar) {
            this.f6822e = ajVar;
        }

        private long m11450a(C1817b c1817b) {
            return ((c1817b.f6149c.longValue() / 1000) / 60) / 60;
        }

        public void mo1750a(C1820e c1820e) {
            C1896c.m10790a((Object) c1820e);
            this.f6818a = c1820e;
        }

        boolean m11452a() {
            return this.f6820c == null || this.f6820c.isEmpty();
        }

        public boolean mo1751a(long j, C1817b c1817b) {
            C1896c.m10790a((Object) c1817b);
            if (this.f6820c == null) {
                this.f6820c = new ArrayList();
            }
            if (this.f6819b == null) {
                this.f6819b = new ArrayList();
            }
            if (this.f6820c.size() > 0 && m11450a((C1817b) this.f6820c.get(0)) != m11450a(c1817b)) {
                return false;
            }
            long f = this.f6821d + ((long) c1817b.m7349f());
            if (f >= ((long) this.f6822e.m11499d().m11842X())) {
                return false;
            }
            this.f6821d = f;
            this.f6820c.add(c1817b);
            this.f6819b.add(Long.valueOf(j));
            return this.f6820c.size() < this.f6822e.m11499d().m11843Y();
        }
    }

    aj(C2048c c2048c) {
        C1896c.m10790a((Object) c2048c);
        this.f6828c = c2048c.f6876a;
        this.f6839n = c2048c.m11557l(this);
        this.f6829d = c2048c.m11546a(this);
        af b = c2048c.m11547b(this);
        b.m11274d();
        this.f6830e = b;
        ab c = c2048c.m11548c(this);
        c.m11274d();
        this.f6831f = c;
        m11502f().m11281C().m11250a("App measurement is starting up, version", Long.valueOf(m11499d().m11832N()));
        m11502f().m11281C().m11249a("To enable debug logging run: adb shell setprop log.tag.FA VERBOSE");
        m11502f().m11282D().m11249a("Debug logging enabled");
        m11502f().m11282D().m11250a("AppMeasurement singleton hash", Integer.valueOf(System.identityHashCode(this)));
        this.f6836k = c2048c.m11554i(this);
        C2090s n = c2048c.m11559n(this);
        n.m11274d();
        this.f6841p = n;
        C2098z o = c2048c.m11560o(this);
        o.m11274d();
        this.f6843r = o;
        C2088q j = c2048c.m11555j(this);
        j.m11274d();
        this.f6837l = j;
        C2084o r = c2048c.m11563r(this);
        r.m11274d();
        this.f6846u = r;
        ac k = c2048c.m11556k(this);
        k.m11274d();
        this.f6838m = k;
        C2066e m = c2048c.m11558m(this);
        m.m11274d();
        this.f6840o = m;
        C2053d h = c2048c.m11553h(this);
        h.m11274d();
        this.f6842q = h;
        C2079j q = c2048c.m11562q(this);
        q.m11274d();
        this.f6845t = q;
        this.f6844s = c2048c.m11561p(this);
        this.f6835j = c2048c.m11552g(this);
        C2076g e = c2048c.m11550e(this);
        e.m11274d();
        this.f6833h = e;
        ah f = c2048c.m11551f(this);
        f.m11274d();
        this.f6834i = f;
        ai d = c2048c.m11549d(this);
        d.m11274d();
        this.f6832g = d;
        if (this.f6825B != this.f6826C) {
            m11502f().m11290f().m11251a("Not all components initialized", Integer.valueOf(this.f6825B), Integer.valueOf(this.f6826C));
        }
        this.f6847v = true;
        if (!(this.f6829d.m11833O() || m11469C())) {
            if (!(this.f6828c.getApplicationContext() instanceof Application)) {
                m11502f().m11310z().m11249a("Application context is not an Application");
            } else if (VERSION.SDK_INT >= 14) {
                m11508l().m11583f();
            } else {
                m11502f().m11282D().m11249a("Not tracking deep linking pre-ICS");
            }
        }
        this.f6832g.m11424a(new C20331(this));
    }

    private boolean m11454L() {
        m11521y();
        return this.f6824A != null;
    }

    private boolean m11455M() {
        m11521y();
        m11479a();
        return m11511o().m11900H() || !TextUtils.isEmpty(m11511o().m11895C());
    }

    private void m11456N() {
        m11521y();
        m11479a();
        if (!m11477K()) {
            return;
        }
        if (m11495b() && m11455M()) {
            long O = m11457O();
            if (O == 0) {
                m11518v().m11343b();
                m11519w().m11712f();
                return;
            } else if (m11512p().m11319f()) {
                long a = m11501e().f6774e.m11351a();
                long ab = m11499d().ab();
                if (!m11510n().m11766a(a, ab)) {
                    O = Math.max(O, a + ab);
                }
                m11518v().m11343b();
                O -= m11514r().mo1723a();
                if (O <= 0) {
                    m11519w().m11710a(1);
                    return;
                }
                m11502f().m11283E().m11250a("Upload scheduled in approximately ms", Long.valueOf(O));
                m11519w().m11710a(O);
                return;
            } else {
                m11518v().m11342a();
                m11519w().m11712f();
                return;
            }
        }
        m11518v().m11343b();
        m11519w().m11712f();
    }

    private long m11457O() {
        long a = m11514r().mo1723a();
        long ae = m11499d().ae();
        long ac = m11499d().ac();
        long a2 = m11501e().f6772c.m11351a();
        long a3 = m11501e().f6773d.m11351a();
        long max = Math.max(m11511o().m11898F(), m11511o().m11899G());
        if (max == 0) {
            return 0;
        }
        max = a - Math.abs(max - a);
        a3 = a - Math.abs(a3 - a);
        a = Math.max(a - Math.abs(a2 - a), a3);
        ae += max;
        if (!m11510n().m11766a(a, ac)) {
            ae = a + ac;
        }
        if (a3 == 0 || a3 < max) {
            return ae;
        }
        for (int i = 0; i < m11499d().ag(); i++) {
            ae += ((long) (1 << i)) * m11499d().af();
            if (ae > a3) {
                return ae;
            }
        }
        return 0;
    }

    public static aj m11458a(Context context) {
        C1896c.m10790a((Object) context);
        C1896c.m10790a(context.getApplicationContext());
        if (f6823b == null) {
            synchronized (aj.class) {
                if (f6823b == null) {
                    f6823b = new C2048c(context).m11545a();
                }
            }
        }
        return f6823b;
    }

    private void m11459a(int i, Throwable th, byte[] bArr) {
        int i2 = 0;
        m11521y();
        m11479a();
        if (bArr == null) {
            bArr = new byte[0];
        }
        List<Long> list = this.f6824A;
        this.f6824A = null;
        if ((i == 200 || i == 204) && th == null) {
            m11501e().f6772c.m11352a(m11514r().mo1723a());
            m11501e().f6773d.m11352a(0);
            m11456N();
            m11502f().m11283E().m11251a("Successful upload. Got network response. code, size", Integer.valueOf(i), Integer.valueOf(bArr.length));
            m11511o().m11932f();
            try {
                for (Long longValue : list) {
                    m11511o().m11905a(longValue.longValue());
                }
                m11511o().m11933g();
                if (m11512p().m11319f() && m11455M()) {
                    m11474H();
                } else {
                    m11456N();
                }
            } finally {
                m11511o().m11937z();
            }
        } else {
            m11502f().m11283E().m11251a("Network upload failed. Will retry later. code, error", Integer.valueOf(i), th);
            m11501e().f6773d.m11352a(m11514r().mo1723a());
            if (i == 503 || i == 429) {
                i2 = 1;
            }
            if (i2 != 0) {
                m11501e().f6774e.m11352a(m11514r().mo1723a());
            }
            m11456N();
        }
    }

    private void m11461a(al alVar) {
        if (alVar == null) {
            throw new IllegalStateException("Component not created");
        }
    }

    private void m11462a(List<Long> list) {
        C1896c.m10798b(!list.isEmpty());
        if (this.f6824A != null) {
            m11502f().m11290f().m11249a("Set uploading progress before finishing the previous upload");
        } else {
            this.f6824A = new ArrayList(list);
        }
    }

    private boolean m11463a(String str, long j) {
        m11511o().m11932f();
        try {
            aj ajVar = this;
            C2036b c2037a = new C2037a();
            m11511o().m11913a(str, j, c2037a);
            if (c2037a.m11452a()) {
                m11511o().m11933g();
                m11511o().m11937z();
                return false;
            }
            int i;
            C1820e c1820e = c2037a.f6818a;
            c1820e.f6167b = new C1817b[c2037a.f6820c.size()];
            int i2 = 0;
            int i3 = 0;
            while (i3 < c2037a.f6820c.size()) {
                if (m11506j().m11388b(c2037a.f6818a.f6180o, ((C1817b) c2037a.f6820c.get(i3)).f6148b)) {
                    m11502f().m11310z().m11250a("Dropping blacklisted raw event", ((C1817b) c2037a.f6820c.get(i3)).f6148b);
                    m11510n().m11762a(11, "_ev", ((C1817b) c2037a.f6820c.get(i3)).f6148b);
                    i = i2;
                } else {
                    int i4;
                    if (m11506j().m11390c(c2037a.f6818a.f6180o, ((C1817b) c2037a.f6820c.get(i3)).f6148b)) {
                        int i5;
                        Object obj;
                        C1818c c1818c;
                        if (((C1817b) c2037a.f6820c.get(i3)).f6147a == null) {
                            ((C1817b) c2037a.f6820c.get(i3)).f6147a = new C1818c[0];
                        }
                        for (C1818c c1818c2 : ((C1817b) c2037a.f6820c.get(i3)).f6147a) {
                            if ("_c".equals(c1818c2.f6153a)) {
                                c1818c2.f6155c = Long.valueOf(1);
                                obj = 1;
                                break;
                            }
                        }
                        obj = null;
                        if (obj == null) {
                            m11502f().m11283E().m11250a("Marking event as conversion", ((C1817b) c2037a.f6820c.get(i3)).f6148b);
                            C1818c[] c1818cArr = (C1818c[]) Arrays.copyOf(((C1817b) c2037a.f6820c.get(i3)).f6147a, ((C1817b) c2037a.f6820c.get(i3)).f6147a.length + 1);
                            c1818c = new C1818c();
                            c1818c.f6153a = "_c";
                            c1818c.f6155c = Long.valueOf(1);
                            c1818cArr[c1818cArr.length - 1] = c1818c;
                            ((C1817b) c2037a.f6820c.get(i3)).f6147a = c1818cArr;
                        }
                        boolean a = C2082m.m11751a(((C1817b) c2037a.f6820c.get(i3)).f6148b);
                        if (a && m11511o().m11901a(m11471E(), c2037a.f6818a.f6180o, false, a, false).f6969c - ((long) m11499d().m11845a(c2037a.f6818a.f6180o)) > 0) {
                            m11502f().m11310z().m11249a("Too many conversions. Not logging as conversion.");
                            C1817b c1817b = (C1817b) c2037a.f6820c.get(i3);
                            Object obj2 = null;
                            C1818c c1818c3 = null;
                            C1818c[] c1818cArr2 = ((C1817b) c2037a.f6820c.get(i3)).f6147a;
                            int length = c1818cArr2.length;
                            int i6 = 0;
                            while (i6 < length) {
                                Object obj3;
                                c1818c = c1818cArr2[i6];
                                if ("_c".equals(c1818c.f6153a)) {
                                    obj3 = obj2;
                                } else if ("_err".equals(c1818c.f6153a)) {
                                    C1818c c1818c4 = c1818c3;
                                    int i7 = 1;
                                    c1818c = c1818c4;
                                } else {
                                    c1818c = c1818c3;
                                    obj3 = obj2;
                                }
                                i6++;
                                obj2 = obj3;
                                c1818c3 = c1818c;
                            }
                            if (obj2 != null && c1818c3 != null) {
                                C1818c[] c1818cArr3 = new C1818c[(c1817b.f6147a.length - 1)];
                                i4 = 0;
                                c1818cArr2 = c1817b.f6147a;
                                length = c1818cArr2.length;
                                i5 = 0;
                                while (i5 < length) {
                                    C1818c c1818c5 = c1818cArr2[i5];
                                    if (c1818c5 != c1818c3) {
                                        i = i4 + 1;
                                        c1818cArr3[i4] = c1818c5;
                                    } else {
                                        i = i4;
                                    }
                                    i5++;
                                    i4 = i;
                                }
                                ((C1817b) c2037a.f6820c.get(i3)).f6147a = c1818cArr3;
                            } else if (c1818c3 != null) {
                                c1818c3.f6153a = "_err";
                                c1818c3.f6155c = Long.valueOf(10);
                            } else {
                                m11502f().m11290f().m11249a("Did not find conversion parameter. Error not tracked");
                            }
                        }
                    }
                    i4 = i2 + 1;
                    c1820e.f6167b[i2] = (C1817b) c2037a.f6820c.get(i3);
                    i = i4;
                }
                i3++;
                i2 = i;
            }
            if (i2 < c2037a.f6820c.size()) {
                c1820e.f6167b = (C1817b[]) Arrays.copyOf(c1820e.f6167b, i2);
            }
            c1820e.f6160A = m11464a(c2037a.f6818a.f6180o, c2037a.f6818a.f6168c, c1820e.f6167b);
            c1820e.f6170e = c1820e.f6167b[0].f6149c;
            c1820e.f6171f = c1820e.f6167b[0].f6149c;
            for (i = 1; i < c1820e.f6167b.length; i++) {
                C1817b c1817b2 = c1820e.f6167b[i];
                if (c1817b2.f6149c.longValue() < c1820e.f6170e.longValue()) {
                    c1820e.f6170e = c1817b2.f6149c;
                }
                if (c1817b2.f6149c.longValue() > c1820e.f6171f.longValue()) {
                    c1820e.f6171f = c1817b2.f6149c;
                }
            }
            String str2 = c2037a.f6818a.f6180o;
            C2016a b = m11511o().m11919b(str2);
            if (b == null) {
                m11502f().m11290f().m11249a("Bundling raw events w/o app info");
            } else {
                long h = b.m11223h();
                c1820e.f6173h = h != 0 ? Long.valueOf(h) : null;
                long g = b.m11221g();
                if (g != 0) {
                    h = g;
                }
                c1820e.f6172g = h != 0 ? Long.valueOf(h) : null;
                b.m11239r();
                c1820e.f6188w = Integer.valueOf((int) b.m11236o());
                b.m11203a(c1820e.f6170e.longValue());
                b.m11207b(c1820e.f6171f.longValue());
                m11511o().m11908a(b);
            }
            c1820e.f6189x = m11502f().m11284F();
            m11511o().m11907a(c1820e);
            m11511o().m11916a(c2037a.f6819b);
            m11511o().m11935h(str2);
            m11511o().m11933g();
            return true;
        } finally {
            m11511o().m11937z();
        }
    }

    private C1816a[] m11464a(String str, C1822g[] c1822gArr, C1817b[] c1817bArr) {
        C1896c.m10792a(str);
        return m11520x().m11815a(str, c1817bArr, c1822gArr);
    }

    private void m11465b(C2019b c2019b) {
        if (c2019b == null) {
            throw new IllegalStateException("Component not created");
        } else if (!c2019b.m11271a()) {
            throw new IllegalStateException("Component not initialized");
        }
    }

    private void m11466c(AppMetadata appMetadata) {
        Object obj = 1;
        m11521y();
        m11479a();
        C1896c.m10790a((Object) appMetadata);
        C1896c.m10792a(appMetadata.f6657b);
        C2016a b = m11511o().m11919b(appMetadata.f6657b);
        String b2 = m11501e().m11370b(appMetadata.f6657b);
        Object obj2 = null;
        if (b == null) {
            C2016a c2016a = new C2016a(this, appMetadata.f6657b);
            c2016a.m11204a(m11501e().m11375f());
            c2016a.m11211c(b2);
            b = c2016a;
            obj2 = 1;
        } else if (!b2.equals(b.m11215e())) {
            b.m11211c(b2);
            b.m11204a(m11501e().m11375f());
            int i = 1;
        }
        if (!(TextUtils.isEmpty(appMetadata.f6658c) || appMetadata.f6658c.equals(b.m11212d()))) {
            b.m11208b(appMetadata.f6658c);
            obj2 = 1;
        }
        if (!(TextUtils.isEmpty(appMetadata.f6667l) || appMetadata.f6667l.equals(b.m11218f()))) {
            b.m11214d(appMetadata.f6667l);
            obj2 = 1;
        }
        if (!(appMetadata.f6661f == 0 || appMetadata.f6661f == b.m11231l())) {
            b.m11213d(appMetadata.f6661f);
            obj2 = 1;
        }
        if (!(TextUtils.isEmpty(appMetadata.f6659d) || appMetadata.f6659d.equals(b.m11225i()))) {
            b.m11217e(appMetadata.f6659d);
            obj2 = 1;
        }
        if (appMetadata.f6666k != b.m11227j()) {
            b.m11210c(appMetadata.f6666k);
            obj2 = 1;
        }
        if (!(TextUtils.isEmpty(appMetadata.f6660e) || appMetadata.f6660e.equals(b.m11229k()))) {
            b.m11220f(appMetadata.f6660e);
            obj2 = 1;
        }
        if (appMetadata.f6662g != b.m11233m()) {
            b.m11216e(appMetadata.f6662g);
            obj2 = 1;
        }
        if (appMetadata.f6664i != b.m11235n()) {
            b.m11205a(appMetadata.f6664i);
        } else {
            obj = obj2;
        }
        if (obj != null) {
            m11511o().m11908a(b);
        }
    }

    void m11467A() {
        m11521y();
        m11479a();
        if (m11477K() && m11468B()) {
            m11489a(m11478a(m11522z()), m11517u().m11990A());
        }
    }

    boolean m11468B() {
        m11521y();
        try {
            this.f6851z = new RandomAccessFile(new File(m11513q().getFilesDir(), this.f6837l.m11894B()), "rw").getChannel();
            this.f6850y = this.f6851z.tryLock();
            if (this.f6850y != null) {
                m11502f().m11283E().m11249a("Storage concurrent access okay");
                return true;
            }
            m11502f().m11290f().m11249a("Storage concurrent data access panic");
            return false;
        } catch (FileNotFoundException e) {
            m11502f().m11290f().m11250a("Failed to acquire storage lock", e);
        } catch (IOException e2) {
            m11502f().m11290f().m11250a("Failed to access storage lock file", e2);
        }
    }

    protected boolean m11469C() {
        return false;
    }

    public boolean m11470D() {
        boolean z = false;
        m11521y();
        m11479a();
        if (m11499d().m11835Q()) {
            return false;
        }
        Boolean R = m11499d().m11836R();
        if (R != null) {
            z = R.booleanValue();
        } else if (!m11499d().m11837S()) {
            z = true;
        }
        return m11501e().m11373c(z);
    }

    long m11471E() {
        return ((((m11514r().mo1723a() + m11501e().m11377z()) / 1000) / 60) / 60) / 24;
    }

    void m11472F() {
        if (m11499d().m11833O()) {
            throw new IllegalStateException("Unexpected call on package side");
        }
    }

    void m11473G() {
        if (!m11499d().m11833O()) {
            throw new IllegalStateException("Unexpected call on client side");
        }
    }

    public void m11474H() {
        Map map = null;
        int i = 0;
        m11521y();
        m11479a();
        if (!m11499d().m11833O()) {
            Boolean B = m11501e().m11365B();
            if (B == null) {
                m11502f().m11310z().m11249a("Upload data called on the client side before use of service was decided");
                return;
            } else if (B.booleanValue()) {
                m11502f().m11290f().m11249a("Upload called in the client side when service should be used");
                return;
            }
        }
        if (m11454L()) {
            m11502f().m11310z().m11249a("Uploading requested multiple times");
        } else if (m11512p().m11319f()) {
            long a = m11514r().mo1723a();
            m11491a(a - m11499d().aa());
            long a2 = m11501e().f6772c.m11351a();
            if (a2 != 0) {
                m11502f().m11282D().m11250a("Uploading events. Elapsed time since last upload attempt (ms)", Long.valueOf(Math.abs(a - a2)));
            }
            String C = m11511o().m11895C();
            if (TextUtils.isEmpty(C)) {
                String b = m11511o().m11921b(a - m11499d().aa());
                if (!TextUtils.isEmpty(b)) {
                    C2016a b2 = m11511o().m11919b(b);
                    if (b2 != null) {
                        String a3 = m11499d().m11848a(b2.m11212d(), b2.m11209c());
                        try {
                            URL url = new URL(a3);
                            m11502f().m11283E().m11250a("Fetching remote configuration", b2.m11206b());
                            C1814b a4 = m11506j().m11384a(b2.m11206b());
                            CharSequence b3 = m11506j().m11387b(b2.m11206b());
                            if (!(a4 == null || TextUtils.isEmpty(b3))) {
                                map = new C0370a();
                                map.put("If-Modified-Since", b3);
                            }
                            m11512p().m11316a(b, url, map, new C20353(this));
                            return;
                        } catch (MalformedURLException e) {
                            m11502f().m11290f().m11250a("Failed to parse config URL. Not fetching", a3);
                            return;
                        }
                    }
                    return;
                }
                return;
            }
            List<Pair> a5 = m11511o().m11904a(C, m11499d().m11855d(C), m11499d().m11857e(C));
            if (!a5.isEmpty()) {
                C1820e c1820e;
                Object obj;
                List subList;
                for (Pair pair : a5) {
                    c1820e = (C1820e) pair.first;
                    if (!TextUtils.isEmpty(c1820e.f6184s)) {
                        obj = c1820e.f6184s;
                        break;
                    }
                }
                obj = null;
                if (obj != null) {
                    for (int i2 = 0; i2 < a5.size(); i2++) {
                        c1820e = (C1820e) ((Pair) a5.get(i2)).first;
                        if (!TextUtils.isEmpty(c1820e.f6184s) && !c1820e.f6184s.equals(obj)) {
                            subList = a5.subList(0, i2);
                            break;
                        }
                    }
                }
                subList = a5;
                C1819d c1819d = new C1819d();
                c1819d.f6158a = new C1820e[subList.size()];
                List arrayList = new ArrayList(subList.size());
                while (i < c1819d.f6158a.length) {
                    c1819d.f6158a[i] = (C1820e) ((Pair) subList.get(i)).first;
                    arrayList.add((Long) ((Pair) subList.get(i)).second);
                    c1819d.f6158a[i].f6183r = Long.valueOf(m11499d().m11832N());
                    c1819d.f6158a[i].f6169d = Long.valueOf(a);
                    c1819d.f6158a[i].f6191z = Boolean.valueOf(m11499d().m11833O());
                    i++;
                }
                Object b4 = m11502f().m11288a(2) ? C2082m.m11754b(c1819d) : null;
                byte[] a6 = m11510n().m11773a(c1819d);
                String Z = m11499d().m11844Z();
                try {
                    URL url2 = new URL(Z);
                    m11462a(arrayList);
                    m11501e().f6773d.m11352a(a);
                    Object obj2 = "?";
                    if (c1819d.f6158a.length > 0) {
                        obj2 = c1819d.f6158a[0].f6180o;
                    }
                    m11502f().m11283E().m11252a("Uploading data. app, uncompressed size, data", obj2, Integer.valueOf(a6.length), b4);
                    m11512p().m11317a(C, url2, a6, null, new C20342(this));
                } catch (MalformedURLException e2) {
                    m11502f().m11290f().m11250a("Failed to parse upload URL. Not uploading", Z);
                }
            }
        } else {
            m11502f().m11310z().m11249a("Network not connected, ignoring upload request");
            m11456N();
        }
    }

    void m11475I() {
        this.f6826C++;
    }

    void m11476J() {
        m11521y();
        m11479a();
        if (!this.f6848w) {
            m11502f().m11281C().m11249a("This instance being marked as an uploader");
            m11467A();
        }
        this.f6848w = true;
    }

    boolean m11477K() {
        m11521y();
        m11479a();
        return this.f6848w || m11469C();
    }

    int m11478a(FileChannel fileChannel) {
        int i = 0;
        m11521y();
        if (fileChannel == null || !fileChannel.isOpen()) {
            m11502f().m11290f().m11249a("Bad chanel to read from");
        } else {
            ByteBuffer allocate = ByteBuffer.allocate(4);
            try {
                fileChannel.position(0);
                int read = fileChannel.read(allocate);
                if (read != 4) {
                    m11502f().m11310z().m11250a("Unexpected data length or empty data in channel. Bytes read", Integer.valueOf(read));
                } else {
                    allocate.flip();
                    i = allocate.getInt();
                }
            } catch (IOException e) {
                m11502f().m11290f().m11250a("Failed to read from channel", e);
            }
        }
        return i;
    }

    void m11479a() {
        if (!this.f6847v) {
            throw new IllegalStateException("AppMeasurement is not initialized");
        }
    }

    void m11480a(AppMetadata appMetadata) {
        m11521y();
        m11479a();
        C1896c.m10792a(appMetadata.f6657b);
        m11466c(appMetadata);
    }

    void m11481a(AppMetadata appMetadata, long j) {
        C2016a b = m11511o().m11919b(appMetadata.f6657b);
        if (!(b == null || b.m11212d() == null || b.m11212d().equals(appMetadata.f6658c))) {
            m11502f().m11310z().m11249a("New GMP App Id passed in. Removing cached database data.");
            m11511o().m11934g(b.m11206b());
            b = null;
        }
        if (b != null && b.m11225i() != null && !b.m11225i().equals(appMetadata.f6659d)) {
            Bundle bundle = new Bundle();
            bundle.putString("_pv", b.m11225i());
            m11482a(new EventParcel("_au", new EventParams(bundle), "auto", j), appMetadata);
        }
    }

    void m11482a(EventParcel eventParcel, AppMetadata appMetadata) {
        long nanoTime = System.nanoTime();
        m11521y();
        m11479a();
        String str = appMetadata.f6657b;
        C1896c.m10792a(str);
        if (!TextUtils.isEmpty(appMetadata.f6658c)) {
            if (!appMetadata.f6664i) {
                m11466c(appMetadata);
            } else if (m11506j().m11388b(str, eventParcel.f6673b)) {
                m11502f().m11310z().m11250a("Dropping blacklisted event", eventParcel.f6673b);
                m11510n().m11762a(11, "_ev", eventParcel.f6673b);
            } else {
                if (m11502f().m11288a(2)) {
                    m11502f().m11283E().m11250a("Logging event", eventParcel);
                }
                m11511o().m11932f();
                try {
                    Bundle b = eventParcel.f6674c.m11200b();
                    m11466c(appMetadata);
                    if ("_iap".equals(eventParcel.f6673b) || "ecommerce_purchase".equals(eventParcel.f6673b)) {
                        long round;
                        Object string = b.getString("currency");
                        if ("ecommerce_purchase".equals(eventParcel.f6673b)) {
                            double d = b.getDouble("value") * 1000000.0d;
                            if (d == 0.0d) {
                                d = ((double) b.getLong("value")) * 1000000.0d;
                            }
                            if (d > 9.223372036854776E18d || d < -9.223372036854776E18d) {
                                m11502f().m11310z().m11250a("Data lost. Currency value is too big", Double.valueOf(d));
                                m11511o().m11933g();
                                m11511o().m11937z();
                                return;
                            }
                            round = Math.round(d);
                        } else {
                            round = b.getLong("value");
                        }
                        if (!TextUtils.isEmpty(string)) {
                            String toUpperCase = string.toUpperCase(Locale.US);
                            if (toUpperCase.matches("[A-Z]{3}")) {
                                C2081l c2081l;
                                String valueOf = String.valueOf("_ltv_");
                                toUpperCase = String.valueOf(toUpperCase);
                                String concat = toUpperCase.length() != 0 ? valueOf.concat(toUpperCase) : new String(valueOf);
                                C2081l c = m11511o().m11925c(str, concat);
                                if (c == null || !(c.f6964d instanceof Long)) {
                                    m11511o().m11911a(str, m11499d().m11853c(str) - 1);
                                    c2081l = new C2081l(str, concat, m11514r().mo1723a(), Long.valueOf(round));
                                } else {
                                    c2081l = new C2081l(str, concat, m11514r().mo1723a(), Long.valueOf(round + ((Long) c.f6964d).longValue()));
                                }
                                if (!m11511o().m11917a(c2081l)) {
                                    m11502f().m11290f().m11251a("Too many unique user properties are set. Ignoring user property.", c2081l.f6962b, c2081l.f6964d);
                                    m11510n().m11762a(9, null, null);
                                }
                            }
                        }
                    }
                    boolean a = C2082m.m11751a(eventParcel.f6673b);
                    C2082m.m11750a(b);
                    boolean equals = "_err".equals(eventParcel.f6673b);
                    C2086a a2 = m11511o().m11901a(m11471E(), str, a, false, equals);
                    long C = a2.f6968b - m11499d().m11821C();
                    if (C > 0) {
                        if (C % 1000 == 1) {
                            m11502f().m11290f().m11250a("Data loss. Too many events logged. count", Long.valueOf(a2.f6968b));
                        }
                        m11510n().m11762a(16, "_ev", eventParcel.f6673b);
                        m11511o().m11933g();
                        return;
                    }
                    C2092u a3;
                    if (a) {
                        C = a2.f6967a - m11499d().m11822D();
                        if (C > 0) {
                            if (C % 1000 == 1) {
                                m11502f().m11290f().m11250a("Data loss. Too many public events logged. count", Long.valueOf(a2.f6967a));
                            }
                            m11510n().m11762a(16, "_ev", eventParcel.f6673b);
                            m11511o().m11933g();
                            m11511o().m11937z();
                            return;
                        }
                    }
                    if (equals) {
                        C = a2.f6970d - m11499d().m11823E();
                        if (C > 0) {
                            if (C == 1) {
                                m11502f().m11290f().m11250a("Too many error events logged. count", Long.valueOf(a2.f6970d));
                            }
                            m11511o().m11933g();
                            m11511o().m11937z();
                            return;
                        }
                    }
                    m11510n().m11763a(b, "_o", eventParcel.f6675d);
                    long c2 = m11511o().m11924c(str);
                    if (c2 > 0) {
                        m11502f().m11310z().m11250a("Data lost. Too many events stored on disk, deleted", Long.valueOf(c2));
                    }
                    C2091t c2091t = new C2091t(this, eventParcel.f6675d, str, eventParcel.f6673b, eventParcel.f6676e, 0, b);
                    C2092u a4 = m11511o().m11902a(str, c2091t.f6980b);
                    if (a4 != null) {
                        c2091t = c2091t.m11963a(this, a4.f6989e);
                        a3 = a4.m11965a(c2091t.f6982d);
                    } else if (m11511o().m11936i(str) >= ((long) m11499d().m11820B())) {
                        m11502f().m11290f().m11251a("Too many event names used, ignoring event. name, supported count", c2091t.f6980b, Integer.valueOf(m11499d().m11820B()));
                        m11510n().m11762a(8, null, null);
                        m11511o().m11937z();
                        return;
                    } else {
                        a3 = new C2092u(str, c2091t.f6980b, 0, 0, c2091t.f6982d);
                    }
                    m11511o().m11910a(a3);
                    m11486a(c2091t, appMetadata);
                    m11511o().m11933g();
                    if (m11502f().m11288a(2)) {
                        m11502f().m11283E().m11250a("Event recorded", c2091t);
                    }
                    m11511o().m11937z();
                    m11456N();
                    m11502f().m11283E().m11250a("Background event processing time, ms", Long.valueOf(((System.nanoTime() - nanoTime) + 500000) / 1000000));
                } finally {
                    m11511o().m11937z();
                }
            }
        }
    }

    void m11483a(EventParcel eventParcel, String str) {
        C2016a b = m11511o().m11919b(str);
        if (b == null || TextUtils.isEmpty(b.m11225i())) {
            m11502f().m11282D().m11250a("No app data available; dropping event", str);
            return;
        }
        try {
            String str2 = m11513q().getPackageManager().getPackageInfo(str, 0).versionName;
            if (!(b.m11225i() == null || b.m11225i().equals(str2))) {
                m11502f().m11310z().m11250a("App version does not match; dropping event", str);
                return;
            }
        } catch (NameNotFoundException e) {
            if (!"_ui".equals(eventParcel.f6673b)) {
                m11502f().m11310z().m11250a("Could not find package", str);
            }
        }
        EventParcel eventParcel2 = eventParcel;
        m11482a(eventParcel2, new AppMetadata(str, b.m11212d(), b.m11225i(), b.m11227j(), b.m11229k(), b.m11231l(), b.m11233m(), null, b.m11235n(), false, b.m11218f()));
    }

    void m11484a(UserAttributeParcel userAttributeParcel, AppMetadata appMetadata) {
        m11521y();
        m11479a();
        if (!TextUtils.isEmpty(appMetadata.f6658c)) {
            if (appMetadata.f6664i) {
                int d = m11510n().m11781d(userAttributeParcel.f6678b);
                if (d != 0) {
                    m11510n().m11762a(d, "_ev", m11510n().m11761a(userAttributeParcel.f6678b, m11499d().m11854d(), true));
                    return;
                }
                d = m11510n().m11780c(userAttributeParcel.f6678b, userAttributeParcel.m11201a());
                if (d != 0) {
                    m11510n().m11762a(d, "_ev", m11510n().m11761a(userAttributeParcel.f6678b, m11499d().m11854d(), true));
                    return;
                }
                Object d2 = m11510n().m11783d(userAttributeParcel.f6678b, userAttributeParcel.m11201a());
                if (d2 != null) {
                    C2081l c2081l = new C2081l(appMetadata.f6657b, userAttributeParcel.f6678b, userAttributeParcel.f6679c, d2);
                    m11502f().m11282D().m11251a("Setting user property", c2081l.f6962b, d2);
                    m11511o().m11932f();
                    try {
                        m11466c(appMetadata);
                        boolean a = m11511o().m11917a(c2081l);
                        m11511o().m11933g();
                        if (a) {
                            m11502f().m11282D().m11251a("User property set", c2081l.f6962b, c2081l.f6964d);
                        } else {
                            m11502f().m11290f().m11251a("Too many unique user properties are set. Ignoring user property.", c2081l.f6962b, c2081l.f6964d);
                            m11510n().m11762a(9, null, null);
                        }
                        m11511o().m11937z();
                        return;
                    } catch (Throwable th) {
                        m11511o().m11937z();
                    }
                } else {
                    return;
                }
            }
            m11466c(appMetadata);
        }
    }

    void m11485a(C2019b c2019b) {
        this.f6825B++;
    }

    void m11486a(C2091t c2091t, AppMetadata appMetadata) {
        m11521y();
        m11479a();
        C1896c.m10790a((Object) c2091t);
        C1896c.m10790a((Object) appMetadata);
        C1896c.m10792a(c2091t.f6979a);
        C1896c.m10798b(c2091t.f6979a.equals(appMetadata.f6657b));
        C1820e c1820e = new C1820e();
        c1820e.f6166a = Integer.valueOf(1);
        c1820e.f6174i = "android";
        c1820e.f6180o = appMetadata.f6657b;
        c1820e.f6179n = appMetadata.f6660e;
        c1820e.f6181p = appMetadata.f6659d;
        c1820e.f6162C = Integer.valueOf((int) appMetadata.f6666k);
        c1820e.f6182q = Long.valueOf(appMetadata.f6661f);
        c1820e.f6190y = appMetadata.f6658c;
        c1820e.f6187v = appMetadata.f6662g == 0 ? null : Long.valueOf(appMetadata.f6662g);
        Pair a = m11501e().m11368a(appMetadata.f6657b);
        if (a != null && !TextUtils.isEmpty((CharSequence) a.first)) {
            c1820e.f6184s = (String) a.first;
            c1820e.f6185t = (Boolean) a.second;
        } else if (!m11516t().m11939a(this.f6828c)) {
            String string = Secure.getString(this.f6828c.getContentResolver(), "android_id");
            if (string == null) {
                m11502f().m11310z().m11249a("null secure ID");
                string = "null";
            } else if (string.isEmpty()) {
                m11502f().m11310z().m11249a("empty secure ID");
            }
            c1820e.f6165F = string;
        }
        c1820e.f6176k = m11516t().m11941f();
        c1820e.f6175j = m11516t().m11942g();
        c1820e.f6178m = Integer.valueOf((int) m11516t().m11961z());
        c1820e.f6177l = m11516t().m11938A();
        c1820e.f6183r = null;
        c1820e.f6169d = null;
        c1820e.f6170e = null;
        c1820e.f6171f = null;
        C2016a b = m11511o().m11919b(appMetadata.f6657b);
        if (b == null) {
            b = new C2016a(this, appMetadata.f6657b);
            b.m11204a(m11501e().m11375f());
            b.m11214d(appMetadata.f6667l);
            b.m11208b(appMetadata.f6658c);
            b.m11211c(m11501e().m11370b(appMetadata.f6657b));
            b.m11219f(0);
            b.m11203a(0);
            b.m11207b(0);
            b.m11217e(appMetadata.f6659d);
            b.m11210c(appMetadata.f6666k);
            b.m11220f(appMetadata.f6660e);
            b.m11213d(appMetadata.f6661f);
            b.m11216e(appMetadata.f6662g);
            b.m11205a(appMetadata.f6664i);
            m11511o().m11908a(b);
        }
        c1820e.f6186u = b.m11209c();
        c1820e.f6161B = b.m11218f();
        List a2 = m11511o().m11903a(appMetadata.f6657b);
        c1820e.f6168c = new C1822g[a2.size()];
        for (int i = 0; i < a2.size(); i++) {
            C1822g c1822g = new C1822g();
            c1820e.f6168c[i] = c1822g;
            c1822g.f6196b = ((C2081l) a2.get(i)).f6962b;
            c1822g.f6195a = Long.valueOf(((C2081l) a2.get(i)).f6963c);
            m11510n().m11765a(c1822g, ((C2081l) a2.get(i)).f6964d);
        }
        try {
            m11511o().m11909a(c2091t, m11511o().m11918b(c1820e));
        } catch (IOException e) {
            m11502f().m11290f().m11250a("Data loss. Failed to insert raw event metadata", e);
        }
    }

    void m11487a(String str, int i, Throwable th, byte[] bArr, Map<String, List<String>> map) {
        int i2 = 0;
        m11521y();
        m11479a();
        C1896c.m10792a(str);
        if (bArr == null) {
            bArr = new byte[0];
        }
        m11511o().m11932f();
        try {
            C2016a b = m11511o().m11919b(str);
            int i3 = ((i == 200 || i == 204 || i == 304) && th == null) ? 1 : 0;
            if (b == null) {
                m11502f().m11310z().m11250a("App does not exist in onConfigFetched", str);
            } else if (i3 != 0 || i == 404) {
                List list = map != null ? (List) map.get("Last-Modified") : null;
                String str2 = (list == null || list.size() <= 0) ? null : (String) list.get(0);
                if (i == 404 || i == 304) {
                    if (m11506j().m11384a(str) == null && !m11506j().m11386a(str, null, null)) {
                        m11511o().m11937z();
                        return;
                    }
                } else if (!m11506j().m11386a(str, bArr, str2)) {
                    m11511o().m11937z();
                    return;
                }
                b.m11222g(m11514r().mo1723a());
                m11511o().m11908a(b);
                if (i == 404) {
                    m11502f().m11310z().m11249a("Config not found. Using empty config");
                } else {
                    m11502f().m11283E().m11251a("Successfully fetched config. Got network response. code, size", Integer.valueOf(i), Integer.valueOf(bArr.length));
                }
                if (m11512p().m11319f() && m11455M()) {
                    m11474H();
                } else {
                    m11456N();
                }
            } else {
                b.m11224h(m11514r().mo1723a());
                m11511o().m11908a(b);
                m11502f().m11283E().m11251a("Fetching config failed. code, error", Integer.valueOf(i), th);
                m11506j().m11389c(str);
                m11501e().f6773d.m11352a(m11514r().mo1723a());
                if (i == 503 || i == 429) {
                    i2 = 1;
                }
                if (i2 != 0) {
                    m11501e().f6774e.m11352a(m11514r().mo1723a());
                }
                m11456N();
            }
            m11511o().m11933g();
        } finally {
            m11511o().m11937z();
        }
    }

    public void m11488a(boolean z) {
        m11456N();
    }

    boolean m11489a(int i, int i2) {
        m11521y();
        if (i > i2) {
            m11502f().m11290f().m11251a("Panic: can't downgrade version. Previous, current version", Integer.valueOf(i), Integer.valueOf(i2));
            return false;
        }
        if (i < i2) {
            if (m11490a(i2, m11522z())) {
                m11502f().m11283E().m11251a("Storage version upgraded. Previous, current version", Integer.valueOf(i), Integer.valueOf(i2));
            } else {
                m11502f().m11290f().m11251a("Storage version upgrade failed. Previous, current version", Integer.valueOf(i), Integer.valueOf(i2));
                return false;
            }
        }
        return true;
    }

    boolean m11490a(int i, FileChannel fileChannel) {
        m11521y();
        if (fileChannel == null || !fileChannel.isOpen()) {
            m11502f().m11290f().m11249a("Bad chanel to read from");
            return false;
        }
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.putInt(i);
        allocate.flip();
        try {
            fileChannel.truncate(0);
            fileChannel.write(allocate);
            fileChannel.force(true);
            if (fileChannel.size() == 4) {
                return true;
            }
            m11502f().m11290f().m11250a("Error writing to channel. Bytes written", Long.valueOf(fileChannel.size()));
            return true;
        } catch (IOException e) {
            m11502f().m11290f().m11250a("Failed to write to channel", e);
            return false;
        }
    }

    boolean m11491a(long j) {
        return m11463a(null, j);
    }

    public void m11492b(AppMetadata appMetadata) {
        m11521y();
        m11479a();
        C1896c.m10790a((Object) appMetadata);
        C1896c.m10792a(appMetadata.f6657b);
        if (!TextUtils.isEmpty(appMetadata.f6658c)) {
            if (appMetadata.f6664i) {
                long a = m11514r().mo1723a();
                m11511o().m11932f();
                try {
                    m11481a(appMetadata, a);
                    m11466c(appMetadata);
                    if (m11511o().m11902a(appMetadata.f6657b, "_f") == null) {
                        m11484a(new UserAttributeParcel("_fot", a, Long.valueOf((1 + (a / 3600000)) * 3600000), "auto"), appMetadata);
                        m11493b(appMetadata, a);
                        m11498c(appMetadata, a);
                    } else if (appMetadata.f6665j) {
                        m11500d(appMetadata, a);
                    }
                    m11511o().m11933g();
                } finally {
                    m11511o().m11937z();
                }
            } else {
                m11466c(appMetadata);
            }
        }
    }

    void m11493b(AppMetadata appMetadata, long j) {
        Bundle bundle = new Bundle();
        bundle.putLong("_c", 1);
        m11482a(new EventParcel("_f", new EventParams(bundle), "auto", j), appMetadata);
    }

    void m11494b(UserAttributeParcel userAttributeParcel, AppMetadata appMetadata) {
        m11521y();
        m11479a();
        if (!TextUtils.isEmpty(appMetadata.f6658c)) {
            if (appMetadata.f6664i) {
                m11502f().m11282D().m11250a("Removing user property", userAttributeParcel.f6678b);
                m11511o().m11932f();
                try {
                    m11466c(appMetadata);
                    m11511o().m11923b(appMetadata.f6657b, userAttributeParcel.f6678b);
                    m11511o().m11933g();
                    m11502f().m11282D().m11250a("User property removed", userAttributeParcel.f6678b);
                } finally {
                    m11511o().m11937z();
                }
            } else {
                m11466c(appMetadata);
            }
        }
    }

    protected boolean m11495b() {
        m11479a();
        m11521y();
        if (this.f6849x == null) {
            boolean z = m11510n().m11791j("android.permission.INTERNET") && m11510n().m11791j("android.permission.ACCESS_NETWORK_STATE") && ag.m11378a(m11513q()) && C2069f.m11661a(m11513q());
            this.f6849x = Boolean.valueOf(z);
            if (this.f6849x.booleanValue() && !m11499d().m11833O()) {
                this.f6849x = Boolean.valueOf(m11510n().m11786g(m11517u().m11999g()));
            }
        }
        return this.f6849x.booleanValue();
    }

    public byte[] m11496b(EventParcel eventParcel, String str) {
        m11479a();
        m11521y();
        m11473G();
        C1896c.m10790a((Object) eventParcel);
        C1896c.m10792a(str);
        C1819d c1819d = new C1819d();
        m11511o().m11932f();
        try {
            C2016a b = m11511o().m11919b(str);
            byte[] bArr;
            if (b == null) {
                m11502f().m11282D().m11250a("Log and bundle not available. package_name", str);
                bArr = new byte[0];
                return bArr;
            } else if (b.m11235n()) {
                long j;
                C1820e c1820e = new C1820e();
                c1819d.f6158a = new C1820e[]{c1820e};
                c1820e.f6166a = Integer.valueOf(1);
                c1820e.f6174i = "android";
                c1820e.f6180o = b.m11206b();
                c1820e.f6179n = b.m11229k();
                c1820e.f6181p = b.m11225i();
                c1820e.f6162C = Integer.valueOf((int) b.m11227j());
                c1820e.f6182q = Long.valueOf(b.m11231l());
                c1820e.f6190y = b.m11212d();
                c1820e.f6187v = Long.valueOf(b.m11233m());
                Pair a = m11501e().m11368a(b.m11206b());
                if (!(a == null || TextUtils.isEmpty((CharSequence) a.first))) {
                    c1820e.f6184s = (String) a.first;
                    c1820e.f6185t = (Boolean) a.second;
                }
                c1820e.f6176k = m11516t().m11941f();
                c1820e.f6175j = m11516t().m11942g();
                c1820e.f6178m = Integer.valueOf((int) m11516t().m11961z());
                c1820e.f6177l = m11516t().m11938A();
                c1820e.f6186u = b.m11209c();
                c1820e.f6161B = b.m11218f();
                List a2 = m11511o().m11903a(b.m11206b());
                c1820e.f6168c = new C1822g[a2.size()];
                for (int i = 0; i < a2.size(); i++) {
                    C1822g c1822g = new C1822g();
                    c1820e.f6168c[i] = c1822g;
                    c1822g.f6196b = ((C2081l) a2.get(i)).f6962b;
                    c1822g.f6195a = Long.valueOf(((C2081l) a2.get(i)).f6963c);
                    m11510n().m11765a(c1822g, ((C2081l) a2.get(i)).f6964d);
                }
                Bundle b2 = eventParcel.f6674c.m11200b();
                if ("_iap".equals(eventParcel.f6673b)) {
                    b2.putLong("_c", 1);
                }
                b2.putString("_o", eventParcel.f6675d);
                C2092u a3 = m11511o().m11902a(str, eventParcel.f6673b);
                if (a3 == null) {
                    m11511o().m11910a(new C2092u(str, eventParcel.f6673b, 1, 0, eventParcel.f6676e));
                    j = 0;
                } else {
                    j = a3.f6989e;
                    m11511o().m11910a(a3.m11965a(eventParcel.f6676e).m11964a());
                }
                C2091t c2091t = new C2091t(this, eventParcel.f6675d, str, eventParcel.f6673b, eventParcel.f6676e, j, b2);
                C1817b c1817b = new C1817b();
                c1820e.f6167b = new C1817b[]{c1817b};
                c1817b.f6149c = Long.valueOf(c2091t.f6982d);
                c1817b.f6148b = c2091t.f6980b;
                c1817b.f6150d = Long.valueOf(c2091t.f6983e);
                c1817b.f6147a = new C1818c[c2091t.f6984f.m11198a()];
                Iterator it = c2091t.f6984f.iterator();
                int i2 = 0;
                while (it.hasNext()) {
                    String str2 = (String) it.next();
                    C1818c c1818c = new C1818c();
                    int i3 = i2 + 1;
                    c1817b.f6147a[i2] = c1818c;
                    c1818c.f6153a = str2;
                    m11510n().m11764a(c1818c, c2091t.f6984f.m11199a(str2));
                    i2 = i3;
                }
                c1820e.f6160A = m11464a(b.m11206b(), c1820e.f6168c, c1820e.f6167b);
                c1820e.f6170e = c1817b.f6149c;
                c1820e.f6171f = c1817b.f6149c;
                long h = b.m11223h();
                c1820e.f6173h = h != 0 ? Long.valueOf(h) : null;
                long g = b.m11221g();
                if (g != 0) {
                    h = g;
                }
                c1820e.f6172g = h != 0 ? Long.valueOf(h) : null;
                b.m11239r();
                c1820e.f6188w = Integer.valueOf((int) b.m11236o());
                c1820e.f6183r = Long.valueOf(m11499d().m11832N());
                c1820e.f6169d = Long.valueOf(m11514r().mo1723a());
                c1820e.f6191z = Boolean.TRUE;
                b.m11203a(c1820e.f6170e.longValue());
                b.m11207b(c1820e.f6171f.longValue());
                m11511o().m11908a(b);
                m11511o().m11933g();
                m11511o().m11937z();
                try {
                    bArr = new byte[c1819d.m7349f()];
                    C1843s a4 = C1843s.m10412a(bArr);
                    c1819d.mo1231a(a4);
                    a4.m10458b();
                    return m11510n().m11774a(bArr);
                } catch (IOException e) {
                    m11502f().m11290f().m11250a("Data loss. Failed to bundle and serialize", e);
                    return null;
                }
            } else {
                m11502f().m11282D().m11250a("Log and bundle disabled. package_name", str);
                bArr = new byte[0];
                m11511o().m11937z();
                return bArr;
            }
        } finally {
            m11511o().m11937z();
        }
    }

    protected void m11497c() {
        m11521y();
        if (!m11469C() || (this.f6832g.m11271a() && !this.f6832g.m11272b())) {
            m11511o().m11896D();
            if (m11495b()) {
                if (!(m11499d().m11833O() || TextUtils.isEmpty(m11517u().m11999g()))) {
                    String A = m11501e().m11364A();
                    if (A == null) {
                        m11501e().m11372c(m11517u().m11999g());
                    } else if (!A.equals(m11517u().m11999g())) {
                        m11502f().m11281C().m11249a("Rechecking which service to use due to a GMP App Id change");
                        m11501e().m11366C();
                        this.f6840o.m11635C();
                        this.f6840o.m11633A();
                        m11501e().m11372c(m11517u().m11999g());
                    }
                }
                if (!(m11499d().m11833O() || m11469C() || TextUtils.isEmpty(m11517u().m11999g()))) {
                    m11508l().m11584g();
                }
            } else if (m11470D()) {
                if (!m11510n().m11791j("android.permission.INTERNET")) {
                    m11502f().m11290f().m11249a("App is missing INTERNET permission");
                }
                if (!m11510n().m11791j("android.permission.ACCESS_NETWORK_STATE")) {
                    m11502f().m11290f().m11249a("App is missing ACCESS_NETWORK_STATE permission");
                }
                if (!ag.m11378a(m11513q())) {
                    m11502f().m11290f().m11249a("AppMeasurementReceiver not registered/enabled");
                }
                if (!C2069f.m11661a(m11513q())) {
                    m11502f().m11290f().m11249a("AppMeasurementService not registered/enabled");
                }
                m11502f().m11290f().m11249a("Uploading is not possible. App measurement disabled");
            }
            m11456N();
            return;
        }
        m11502f().m11290f().m11249a("Scheduler shutting down before Scion.start() called");
    }

    void m11498c(AppMetadata appMetadata, long j) {
        Bundle bundle = new Bundle();
        bundle.putLong("_et", 1);
        m11482a(new EventParcel("_e", new EventParams(bundle), "auto", j), appMetadata);
    }

    public C2085p m11499d() {
        return this.f6829d;
    }

    void m11500d(AppMetadata appMetadata, long j) {
        m11482a(new EventParcel("_cd", new EventParams(new Bundle()), "auto", j), appMetadata);
    }

    public af m11501e() {
        m11461a(this.f6830e);
        return this.f6830e;
    }

    public ab m11502f() {
        m11465b(this.f6831f);
        return this.f6831f;
    }

    public ab m11503g() {
        return (this.f6831f == null || !this.f6831f.m11271a()) ? null : this.f6831f;
    }

    public ai m11504h() {
        m11465b(this.f6832g);
        return this.f6832g;
    }

    public C2076g m11505i() {
        m11465b(this.f6833h);
        return this.f6833h;
    }

    public ah m11506j() {
        m11465b(this.f6834i);
        return this.f6834i;
    }

    ai m11507k() {
        return this.f6832g;
    }

    public C2053d m11508l() {
        m11465b(this.f6842q);
        return this.f6842q;
    }

    public AppMeasurement m11509m() {
        return this.f6835j;
    }

    public C2082m m11510n() {
        m11461a(this.f6836k);
        return this.f6836k;
    }

    public C2088q m11511o() {
        m11465b(this.f6837l);
        return this.f6837l;
    }

    public ac m11512p() {
        m11465b(this.f6838m);
        return this.f6838m;
    }

    public Context m11513q() {
        return this.f6828c;
    }

    public C1970c m11514r() {
        return this.f6839n;
    }

    public C2066e m11515s() {
        m11465b(this.f6840o);
        return this.f6840o;
    }

    public C2090s m11516t() {
        m11465b(this.f6841p);
        return this.f6841p;
    }

    public C2098z m11517u() {
        m11465b(this.f6843r);
        return this.f6843r;
    }

    public ad m11518v() {
        if (this.f6844s != null) {
            return this.f6844s;
        }
        throw new IllegalStateException("Network broadcast receiver not created");
    }

    public C2079j m11519w() {
        m11465b(this.f6845t);
        return this.f6845t;
    }

    public C2084o m11520x() {
        m11465b(this.f6846u);
        return this.f6846u;
    }

    public void m11521y() {
        m11504h().mo1733j();
    }

    FileChannel m11522z() {
        return this.f6851z;
    }
}
