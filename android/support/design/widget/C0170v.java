package android.support.design.widget;

import android.view.animation.Interpolator;

class C0170v {
    private final C0169e f695a;

    interface C0054c {
        void mo39a(C0170v c0170v);
    }

    interface C0110a {
        void mo104a(C0170v c0170v);

        void mo105b(C0170v c0170v);

        void mo106c(C0170v c0170v);
    }

    static class C0111b implements C0110a {
        C0111b() {
        }

        public void mo104a(C0170v c0170v) {
        }

        public void mo105b(C0170v c0170v) {
        }

        public void mo106c(C0170v c0170v) {
        }
    }

    interface C0128d {
        C0170v mo116a();
    }

    static abstract class C0169e {

        interface C0165b {
            void mo148a();
        }

        interface C0167a {
            void mo149a();

            void mo150b();

            void mo151c();
        }

        C0169e() {
        }

        abstract void mo152a();

        abstract void mo153a(float f, float f2);

        abstract void mo154a(int i);

        abstract void mo155a(int i, int i2);

        abstract void mo156a(C0167a c0167a);

        abstract void mo157a(C0165b c0165b);

        abstract void mo158a(Interpolator interpolator);

        abstract boolean mo159b();

        abstract int mo160c();

        abstract float mo161d();

        abstract void mo162e();

        abstract float mo163f();

        abstract long mo164g();
    }

    C0170v(C0169e c0169e) {
        this.f695a = c0169e;
    }

    public void m1075a() {
        this.f695a.mo152a();
    }

    public void m1076a(float f, float f2) {
        this.f695a.mo153a(f, f2);
    }

    public void m1077a(int i) {
        this.f695a.mo154a(i);
    }

    public void m1078a(int i, int i2) {
        this.f695a.mo155a(i, i2);
    }

    public void m1079a(final C0110a c0110a) {
        if (c0110a != null) {
            this.f695a.mo156a(new C0167a(this) {
                final /* synthetic */ C0170v f694b;

                public void mo149a() {
                    c0110a.mo105b(this.f694b);
                }

                public void mo150b() {
                    c0110a.mo104a(this.f694b);
                }

                public void mo151c() {
                    c0110a.mo106c(this.f694b);
                }
            });
        } else {
            this.f695a.mo156a(null);
        }
    }

    public void m1080a(final C0054c c0054c) {
        if (c0054c != null) {
            this.f695a.mo157a(new C0165b(this) {
                final /* synthetic */ C0170v f692b;

                public void mo148a() {
                    c0054c.mo39a(this.f692b);
                }
            });
        } else {
            this.f695a.mo157a(null);
        }
    }

    public void m1081a(Interpolator interpolator) {
        this.f695a.mo158a(interpolator);
    }

    public boolean m1082b() {
        return this.f695a.mo159b();
    }

    public int m1083c() {
        return this.f695a.mo160c();
    }

    public float m1084d() {
        return this.f695a.mo161d();
    }

    public void m1085e() {
        this.f695a.mo162e();
    }

    public float m1086f() {
        return this.f695a.mo163f();
    }

    public long m1087g() {
        return this.f695a.mo164g();
    }
}
