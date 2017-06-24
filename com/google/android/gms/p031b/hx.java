package com.google.android.gms.p031b;

import android.content.Context;
import com.google.android.gms.ads.internal.C1245q;
import com.google.android.gms.ads.internal.util.client.C1324b;
import com.google.android.gms.p031b.ff.C1515b;
import com.google.android.gms.p031b.ff.C1525e;
import com.google.android.gms.p031b.jl.C1632a;
import com.google.android.gms.p031b.kt.C1161c;
import com.google.android.gms.p031b.kt.C1261a;
import java.util.concurrent.TimeUnit;

@id
public class hx {
    private static final long f5089a = TimeUnit.SECONDS.toMillis(60);
    private static final Object f5090b = new Object();
    private static boolean f5091c = false;
    private static ff f5092d = null;
    private final Context f5093e;
    private final C1632a f5094f;
    private final C1245q f5095g;
    private final aj f5096h;
    private fd f5097i;
    private C1525e f5098j;
    private fc f5099k;
    private boolean f5100l = false;

    public static abstract class C1145a {
        public void mo1439a() {
        }

        public abstract void mo1095a(fg fgVar);
    }

    class C15833 implements kd<fc> {
        final /* synthetic */ hx f5088a;

        C15833(hx hxVar) {
            this.f5088a = hxVar;
        }

        public void m8791a(fc fcVar) {
            fcVar.mo1316a(this.f5088a.f5095g, this.f5088a.f5095g, this.f5088a.f5095g, this.f5088a.f5095g, false, null, null, null, null);
        }

        public /* synthetic */ void mo1187a(Object obj) {
            m8791a((fc) obj);
        }
    }

    public hx(Context context, C1632a c1632a, C1245q c1245q, aj ajVar) {
        this.f5093e = context;
        this.f5094f = c1632a;
        this.f5095g = c1245q;
        this.f5096h = ajVar;
        this.f5100l = ((Boolean) cq.bi.m7801c()).booleanValue();
    }

    private String m8794a(C1632a c1632a) {
        String str = (String) cq.af.m7801c();
        String valueOf = String.valueOf(c1632a.f5409b.f3780b.indexOf("https") == 0 ? "https:" : "http:");
        str = String.valueOf(str);
        return str.length() != 0 ? valueOf.concat(str) : new String(valueOf);
    }

    private void m8795g() {
        synchronized (f5090b) {
            if (!f5091c) {
                f5092d = new ff(this.f5093e.getApplicationContext() != null ? this.f5093e.getApplicationContext() : this.f5093e, this.f5094f.f5408a.f3749k, m8794a(this.f5094f), new C15833(this), new C1515b());
                f5091c = true;
            }
        }
    }

    private void m8796h() {
        this.f5098j = new C1525e(m8804e().m8301b(this.f5096h));
    }

    private void m8797i() {
        this.f5097i = new fd();
    }

    private void m8798j() {
        this.f5099k = (fc) m8802c().m8240a(this.f5093e, this.f5094f.f5408a.f3749k, m8794a(this.f5094f), this.f5096h).get(f5089a, TimeUnit.MILLISECONDS);
        this.f5099k.mo1316a(this.f5095g, this.f5095g, this.f5095g, this.f5095g, false, null, null, null, null);
    }

    public void m8799a() {
        if (this.f5100l) {
            m8795g();
        } else {
            m8797i();
        }
    }

    public void m8800a(final C1145a c1145a) {
        if (this.f5100l) {
            C1525e f = m8805f();
            if (f == null) {
                C1324b.m7234d("SharedJavascriptEngine not initialized");
                return;
            } else {
                f.mo1327a(new C1161c<fg>(this) {
                    final /* synthetic */ hx f5085b;

                    public void m8788a(fg fgVar) {
                        c1145a.mo1095a(fgVar);
                    }

                    public /* synthetic */ void mo1101a(Object obj) {
                        m8788a((fg) obj);
                    }
                }, new C1261a(this) {
                    final /* synthetic */ hx f5087b;

                    public void mo1175a() {
                        c1145a.mo1439a();
                    }
                });
                return;
            }
        }
        fg d = m8803d();
        if (d == null) {
            C1324b.m7234d("JavascriptEngine not initialized");
        } else {
            c1145a.mo1095a(d);
        }
    }

    public void m8801b() {
        if (this.f5100l) {
            m8796h();
        } else {
            m8798j();
        }
    }

    protected fd m8802c() {
        return this.f5097i;
    }

    protected fc m8803d() {
        return this.f5099k;
    }

    protected ff m8804e() {
        return f5092d;
    }

    protected C1525e m8805f() {
        return this.f5098j;
    }
}
