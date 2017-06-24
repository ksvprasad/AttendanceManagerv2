package android.support.v4.widget;

import android.content.Context;
import android.os.Build.VERSION;
import android.view.animation.Interpolator;
import android.widget.Scroller;

public final class C0599u {
    Object f1404a;
    C0595a f1405b;

    interface C0595a {
        Object mo494a(Context context, Interpolator interpolator);

        void mo495a(Object obj, int i, int i2, int i3, int i4);

        void mo496a(Object obj, int i, int i2, int i3, int i4, int i5);

        void mo497a(Object obj, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8);

        void mo498a(Object obj, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10);

        boolean mo499a(Object obj);

        boolean mo500a(Object obj, int i, int i2, int i3, int i4, int i5, int i6);

        int mo501b(Object obj);

        int mo502c(Object obj);

        float mo503d(Object obj);

        boolean mo504e(Object obj);

        void mo505f(Object obj);

        int mo506g(Object obj);

        int mo507h(Object obj);
    }

    static class C0596b implements C0595a {
        C0596b() {
        }

        public Object mo494a(Context context, Interpolator interpolator) {
            return interpolator != null ? new Scroller(context, interpolator) : new Scroller(context);
        }

        public void mo495a(Object obj, int i, int i2, int i3, int i4) {
            ((Scroller) obj).startScroll(i, i2, i3, i4);
        }

        public void mo496a(Object obj, int i, int i2, int i3, int i4, int i5) {
            ((Scroller) obj).startScroll(i, i2, i3, i4, i5);
        }

        public void mo497a(Object obj, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            ((Scroller) obj).fling(i, i2, i3, i4, i5, i6, i7, i8);
        }

        public void mo498a(Object obj, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
            ((Scroller) obj).fling(i, i2, i3, i4, i5, i6, i7, i8);
        }

        public boolean mo499a(Object obj) {
            return ((Scroller) obj).isFinished();
        }

        public boolean mo500a(Object obj, int i, int i2, int i3, int i4, int i5, int i6) {
            return false;
        }

        public int mo501b(Object obj) {
            return ((Scroller) obj).getCurrX();
        }

        public int mo502c(Object obj) {
            return ((Scroller) obj).getCurrY();
        }

        public float mo503d(Object obj) {
            return 0.0f;
        }

        public boolean mo504e(Object obj) {
            return ((Scroller) obj).computeScrollOffset();
        }

        public void mo505f(Object obj) {
            ((Scroller) obj).abortAnimation();
        }

        public int mo506g(Object obj) {
            return ((Scroller) obj).getFinalX();
        }

        public int mo507h(Object obj) {
            return ((Scroller) obj).getFinalY();
        }
    }

    static class C0597c implements C0595a {
        C0597c() {
        }

        public Object mo494a(Context context, Interpolator interpolator) {
            return C0600v.m3204a(context, interpolator);
        }

        public void mo495a(Object obj, int i, int i2, int i3, int i4) {
            C0600v.m3205a(obj, i, i2, i3, i4);
        }

        public void mo496a(Object obj, int i, int i2, int i3, int i4, int i5) {
            C0600v.m3206a(obj, i, i2, i3, i4, i5);
        }

        public void mo497a(Object obj, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            C0600v.m3207a(obj, i, i2, i3, i4, i5, i6, i7, i8);
        }

        public void mo498a(Object obj, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
            C0600v.m3208a(obj, i, i2, i3, i4, i5, i6, i7, i8, i9, i10);
        }

        public boolean mo499a(Object obj) {
            return C0600v.m3209a(obj);
        }

        public boolean mo500a(Object obj, int i, int i2, int i3, int i4, int i5, int i6) {
            return C0600v.m3210a(obj, i, i2, i3, i4, i5, i6);
        }

        public int mo501b(Object obj) {
            return C0600v.m3211b(obj);
        }

        public int mo502c(Object obj) {
            return C0600v.m3212c(obj);
        }

        public float mo503d(Object obj) {
            return 0.0f;
        }

        public boolean mo504e(Object obj) {
            return C0600v.m3213d(obj);
        }

        public void mo505f(Object obj) {
            C0600v.m3214e(obj);
        }

        public int mo506g(Object obj) {
            return C0600v.m3215f(obj);
        }

        public int mo507h(Object obj) {
            return C0600v.m3216g(obj);
        }
    }

    static class C0598d extends C0597c {
        C0598d() {
        }

        public float mo503d(Object obj) {
            return C0601w.m3217a(obj);
        }
    }

    private C0599u(int i, Context context, Interpolator interpolator) {
        if (i >= 14) {
            this.f1405b = new C0598d();
        } else if (i >= 9) {
            this.f1405b = new C0597c();
        } else {
            this.f1405b = new C0596b();
        }
        this.f1404a = this.f1405b.mo494a(context, interpolator);
    }

    public static C0599u m3189a(Context context) {
        return C0599u.m3190a(context, null);
    }

    public static C0599u m3190a(Context context, Interpolator interpolator) {
        return new C0599u(VERSION.SDK_INT, context, interpolator);
    }

    public void m3191a(int i, int i2, int i3, int i4) {
        this.f1405b.mo495a(this.f1404a, i, i2, i3, i4);
    }

    public void m3192a(int i, int i2, int i3, int i4, int i5) {
        this.f1405b.mo496a(this.f1404a, i, i2, i3, i4, i5);
    }

    public void m3193a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        this.f1405b.mo497a(this.f1404a, i, i2, i3, i4, i5, i6, i7, i8);
    }

    public void m3194a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        this.f1405b.mo498a(this.f1404a, i, i2, i3, i4, i5, i6, i7, i8, i9, i10);
    }

    public boolean m3195a() {
        return this.f1405b.mo499a(this.f1404a);
    }

    public boolean m3196a(int i, int i2, int i3, int i4, int i5, int i6) {
        return this.f1405b.mo500a(this.f1404a, i, i2, i3, i4, i5, i6);
    }

    public int m3197b() {
        return this.f1405b.mo501b(this.f1404a);
    }

    public int m3198c() {
        return this.f1405b.mo502c(this.f1404a);
    }

    public int m3199d() {
        return this.f1405b.mo506g(this.f1404a);
    }

    public int m3200e() {
        return this.f1405b.mo507h(this.f1404a);
    }

    public float m3201f() {
        return this.f1405b.mo503d(this.f1404a);
    }

    public boolean m3202g() {
        return this.f1405b.mo504e(this.f1404a);
    }

    public void m3203h() {
        this.f1405b.mo505f(this.f1404a);
    }
}
