package android.support.v4.view.p016a;

import android.os.Build.VERSION;

public class C0450l {
    private static final C0445c f1238a;
    private final Object f1239b;

    interface C0445c {
        void mo351a(Object obj, int i);

        void mo352a(Object obj, boolean z);

        void mo353b(Object obj, int i);

        void mo354c(Object obj, int i);

        void mo355d(Object obj, int i);

        void mo356e(Object obj, int i);

        void mo357f(Object obj, int i);

        void mo358g(Object obj, int i);
    }

    static class C0446e implements C0445c {
        C0446e() {
        }

        public void mo351a(Object obj, int i) {
        }

        public void mo352a(Object obj, boolean z) {
        }

        public void mo353b(Object obj, int i) {
        }

        public void mo354c(Object obj, int i) {
        }

        public void mo355d(Object obj, int i) {
        }

        public void mo356e(Object obj, int i) {
        }

        public void mo357f(Object obj, int i) {
        }

        public void mo358g(Object obj, int i) {
        }
    }

    static class C0447a extends C0446e {
        C0447a() {
        }

        public void mo351a(Object obj, int i) {
            C0451m.m2303a(obj, i);
        }

        public void mo352a(Object obj, boolean z) {
            C0451m.m2304a(obj, z);
        }

        public void mo353b(Object obj, int i) {
            C0451m.m2305b(obj, i);
        }

        public void mo354c(Object obj, int i) {
            C0451m.m2306c(obj, i);
        }

        public void mo355d(Object obj, int i) {
            C0451m.m2307d(obj, i);
        }

        public void mo356e(Object obj, int i) {
            C0451m.m2308e(obj, i);
        }
    }

    static class C0448b extends C0447a {
        C0448b() {
        }

        public void mo357f(Object obj, int i) {
            C0452n.m2309a(obj, i);
        }

        public void mo358g(Object obj, int i) {
            C0452n.m2310b(obj, i);
        }
    }

    static class C0449d extends C0448b {
        C0449d() {
        }
    }

    static {
        if (VERSION.SDK_INT >= 16) {
            f1238a = new C0449d();
        } else if (VERSION.SDK_INT >= 15) {
            f1238a = new C0448b();
        } else if (VERSION.SDK_INT >= 14) {
            f1238a = new C0447a();
        } else {
            f1238a = new C0446e();
        }
    }

    public C0450l(Object obj) {
        this.f1239b = obj;
    }

    public void m2295a(int i) {
        f1238a.mo353b(this.f1239b, i);
    }

    public void m2296a(boolean z) {
        f1238a.mo352a(this.f1239b, z);
    }

    public void m2297b(int i) {
        f1238a.mo351a(this.f1239b, i);
    }

    public void m2298c(int i) {
        f1238a.mo356e(this.f1239b, i);
    }

    public void m2299d(int i) {
        f1238a.mo354c(this.f1239b, i);
    }

    public void m2300e(int i) {
        f1238a.mo355d(this.f1239b, i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        C0450l c0450l = (C0450l) obj;
        return this.f1239b == null ? c0450l.f1239b == null : this.f1239b.equals(c0450l.f1239b);
    }

    public void m2301f(int i) {
        f1238a.mo357f(this.f1239b, i);
    }

    public void m2302g(int i) {
        f1238a.mo358g(this.f1239b, i);
    }

    public int hashCode() {
        return this.f1239b == null ? 0 : this.f1239b.hashCode();
    }
}
