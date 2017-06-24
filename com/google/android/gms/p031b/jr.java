package com.google.android.gms.p031b;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import com.google.android.gms.p031b.ar.C1369a;
import com.google.android.gms.p031b.ln.C1676a;
import com.google.android.gms.p031b.no.C1790a;
import java.net.URLEncoder;
import java.util.Collections;
import java.util.Map;
import java.util.Map.Entry;

public abstract class jr<T> implements Comparable<jr<T>> {
    private final C1790a f4289a;
    private final int f4290b;
    private final String f4291c;
    private final int f4292d;
    private final C1676a f4293e;
    private Integer f4294f;
    private ks f4295g;
    private boolean f4296h;
    private boolean f4297i;
    private boolean f4298j;
    private long f4299k;
    private lp f4300l;
    private C1369a f4301m;

    public enum C1638a {
        LOW,
        NORMAL,
        HIGH,
        IMMEDIATE
    }

    public jr(int i, String str, C1676a c1676a) {
        this.f4289a = C1790a.f6071a ? new C1790a() : null;
        this.f4296h = true;
        this.f4297i = false;
        this.f4298j = false;
        this.f4299k = 0;
        this.f4301m = null;
        this.f4290b = i;
        this.f4291c = str;
        this.f4293e = c1676a;
        m7711a(new cn());
        this.f4292d = jr.mo1267a(str);
    }

    private static int mo1267a(String str) {
        if (!TextUtils.isEmpty(str)) {
            Uri parse = Uri.parse(str);
            if (parse != null) {
                String host = parse.getHost();
                if (host != null) {
                    return host.hashCode();
                }
            }
        }
        return 0;
    }

    private byte[] m7704a(Map<String, String> map, String str) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            for (Entry entry : map.entrySet()) {
                stringBuilder.append(URLEncoder.encode((String) entry.getKey(), str));
                stringBuilder.append('=');
                stringBuilder.append(URLEncoder.encode((String) entry.getValue(), str));
                stringBuilder.append('&');
            }
            return stringBuilder.toString().getBytes(str);
        } catch (Throwable e) {
            Throwable th = e;
            String str2 = "Encoding not supported: ";
            String valueOf = String.valueOf(str);
            throw new RuntimeException(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2), th);
        }
    }

    public int m7706a() {
        return this.f4290b;
    }

    public int m7707a(jr<T> jrVar) {
        C1638a q = m7733q();
        C1638a q2 = jrVar.m7733q();
        return q == q2 ? this.f4294f.intValue() - jrVar.f4294f.intValue() : q2.ordinal() - q.ordinal();
    }

    public final jr<?> m7708a(int i) {
        this.f4294f = Integer.valueOf(i);
        return this;
    }

    public jr<?> m7709a(C1369a c1369a) {
        this.f4301m = c1369a;
        return this;
    }

    public jr<?> m7710a(ks ksVar) {
        this.f4295g = ksVar;
        return this;
    }

    public jr<?> m7711a(lp lpVar) {
        this.f4300l = lpVar;
        return this;
    }

    protected abstract ln<T> mo1265a(hp hpVar);

    protected nj m7713a(nj njVar) {
        return njVar;
    }

    protected abstract void mo1266a(T t);

    public int m7715b() {
        return this.f4292d;
    }

    public void m7716b(nj njVar) {
        if (this.f4293e != null) {
            this.f4293e.mo1483a(njVar);
        }
    }

    public void m7717b(String str) {
        if (C1790a.f6071a) {
            this.f4289a.m10166a(str, Thread.currentThread().getId());
        } else if (this.f4299k == 0) {
            this.f4299k = SystemClock.elapsedRealtime();
        }
    }

    public String m7718c() {
        return this.f4291c;
    }

    void m7719c(final String str) {
        if (this.f4295g != null) {
            this.f4295g.m9374b(this);
        }
        if (C1790a.f6071a) {
            final long id = Thread.currentThread().getId();
            if (Looper.myLooper() != Looper.getMainLooper()) {
                new Handler(Looper.getMainLooper()).post(new Runnable(this) {
                    final /* synthetic */ jr f5510c;

                    public void run() {
                        this.f5510c.f4289a.m10166a(str, id);
                        this.f5510c.f4289a.m10165a(toString());
                    }
                });
                return;
            }
            this.f4289a.m10166a(str, id);
            this.f4289a.m10165a(toString());
            return;
        }
        if (SystemClock.elapsedRealtime() - this.f4299k >= 3000) {
            no.m10169b("%d ms: %s", Long.valueOf(SystemClock.elapsedRealtime() - this.f4299k), toString());
        }
    }

    public /* synthetic */ int compareTo(Object obj) {
        return m7707a((jr) obj);
    }

    public String m7720d() {
        return m7718c();
    }

    public C1369a m7721e() {
        return this.f4301m;
    }

    public boolean m7722f() {
        return false;
    }

    public Map<String, String> mo1484g() {
        return Collections.emptyMap();
    }

    @Deprecated
    protected Map<String, String> m7724h() {
        return m7728l();
    }

    @Deprecated
    protected String m7725i() {
        return m7729m();
    }

    @Deprecated
    public String m7726j() {
        return m7730n();
    }

    @Deprecated
    public byte[] m7727k() {
        Map h = m7724h();
        return (h == null || h.size() <= 0) ? null : m7704a(h, m7725i());
    }

    protected Map<String, String> m7728l() {
        return null;
    }

    protected String m7729m() {
        return "UTF-8";
    }

    public String m7730n() {
        String str = "application/x-www-form-urlencoded; charset=";
        String valueOf = String.valueOf(m7729m());
        return valueOf.length() != 0 ? str.concat(valueOf) : new String(str);
    }

    public byte[] mo1485o() {
        Map l = m7728l();
        return (l == null || l.size() <= 0) ? null : m7704a(l, m7729m());
    }

    public final boolean m7732p() {
        return this.f4296h;
    }

    public C1638a m7733q() {
        return C1638a.NORMAL;
    }

    public final int m7734r() {
        return this.f4300l.mo1271a();
    }

    public lp m7735s() {
        return this.f4300l;
    }

    public void m7736t() {
        this.f4298j = true;
    }

    public String toString() {
        String str = "0x";
        String valueOf = String.valueOf(Integer.toHexString(m7715b()));
        valueOf = valueOf.length() != 0 ? str.concat(valueOf) : new String(str);
        str = "[ ] ";
        String valueOf2 = String.valueOf(m7718c());
        String valueOf3 = String.valueOf(m7733q());
        String valueOf4 = String.valueOf(this.f4294f);
        return new StringBuilder(((((String.valueOf(str).length() + 3) + String.valueOf(valueOf2).length()) + String.valueOf(valueOf).length()) + String.valueOf(valueOf3).length()) + String.valueOf(valueOf4).length()).append(str).append(valueOf2).append(" ").append(valueOf).append(" ").append(valueOf3).append(" ").append(valueOf4).toString();
    }

    public boolean m7737u() {
        return this.f4298j;
    }
}
