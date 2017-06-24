package com.google.android.gms.p031b;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.C1324b;
import com.google.android.gms.p031b.ln.C1676a;
import com.google.android.gms.p031b.ln.C1681b;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Map;

@id
public class kf {
    public static final C1591a<Void> f5613a = new C16751();
    private static ks f5614b;
    private static final Object f5615c = new Object();

    public interface C1591a<T> {
        T mo1441b();

        T mo1442b(InputStream inputStream);
    }

    class C16751 implements C1591a<Void> {
        C16751() {
        }

        public Void m9322a() {
            return null;
        }

        public Void m9323a(InputStream inputStream) {
            return null;
        }

        public /* synthetic */ Object mo1441b() {
            return m9322a();
        }

        public /* synthetic */ Object mo1442b(InputStream inputStream) {
            return m9323a(inputStream);
        }
    }

    private static class C1680b<T> extends jr<InputStream> {
        private final C1591a<T> f5610a;
        private final C1681b<T> f5611b;

        class C16791 implements C1676a {
            final /* synthetic */ C1681b f5608a;
            final /* synthetic */ C1591a f5609b;

            C16791(C1681b c1681b, C1591a c1591a) {
                this.f5608a = c1681b;
                this.f5609b = c1591a;
            }

            public void mo1483a(nj njVar) {
                this.f5608a.mo1486a(this.f5609b.mo1441b());
            }
        }

        public C1680b(String str, C1591a<T> c1591a, C1681b<T> c1681b) {
            super(0, str, new C16791(c1681b, c1591a));
            this.f5610a = c1591a;
            this.f5611b = c1681b;
        }

        protected ln<InputStream> mo1265a(hp hpVar) {
            return ln.m9632a(new ByteArrayInputStream(hpVar.f5049b), oe.m10361a(hpVar));
        }

        protected void m9332a(InputStream inputStream) {
            this.f5611b.mo1486a(this.f5610a.mo1442b(inputStream));
        }

        protected /* synthetic */ void mo1266a(Object obj) {
            m9332a((InputStream) obj);
        }
    }

    private class C1682c<T> extends kn<T> implements C1681b<T> {
        final /* synthetic */ kf f5612a;

        private C1682c(kf kfVar) {
            this.f5612a = kfVar;
        }

        public void mo1486a(T t) {
            super.m8236b((Object) t);
        }
    }

    public kf(Context context) {
        kf.m9336a(context);
    }

    private static ks m9336a(Context context) {
        ks ksVar;
        synchronized (f5615c) {
            if (f5614b == null) {
                f5614b = C1412d.m7883a(context.getApplicationContext());
            }
            ksVar = f5614b;
        }
        return ksVar;
    }

    public kq<String> m9337a(int i, final String str, Map<String, String> map, byte[] bArr) {
        final Object c1682c = new C1682c();
        final byte[] bArr2 = bArr;
        final Map<String, String> map2 = map;
        f5614b.m9371a(new C1393c(this, i, str, c1682c, new C1676a(this) {
            final /* synthetic */ kf f5604c;

            public void mo1483a(nj njVar) {
                String str = str;
                String valueOf = String.valueOf(njVar.toString());
                C1324b.m7234d(new StringBuilder((String.valueOf(str).length() + 21) + String.valueOf(valueOf).length()).append("Failed to load URL: ").append(str).append("\n").append(valueOf).toString());
                c1682c.mo1486a(null);
            }
        }) {
            final /* synthetic */ kf f5607c;

            public Map<String, String> mo1484g() {
                return map2 == null ? super.mo1484g() : map2;
            }

            public byte[] mo1485o() {
                return bArr2 == null ? super.mo1485o() : bArr2;
            }
        });
        return c1682c;
    }

    public <T> kq<T> m9338a(String str, C1591a<T> c1591a) {
        Object c1682c = new C1682c();
        f5614b.m9371a(new C1680b(str, c1591a, c1682c));
        return c1682c;
    }

    public kq<String> m9339a(String str, Map<String, String> map) {
        return m9337a(0, str, map, null);
    }
}
