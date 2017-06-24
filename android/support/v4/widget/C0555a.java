package android.support.v4.widget;

import android.content.res.Resources;
import android.os.SystemClock;
import android.support.v4.view.C0543s;
import android.support.v4.view.ag;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;

public abstract class C0555a implements OnTouchListener {
    private static final int f1337r = ViewConfiguration.getTapTimeout();
    private final C0553a f1338a = new C0553a();
    private final Interpolator f1339b = new AccelerateInterpolator();
    private final View f1340c;
    private Runnable f1341d;
    private float[] f1342e = new float[]{0.0f, 0.0f};
    private float[] f1343f = new float[]{Float.MAX_VALUE, Float.MAX_VALUE};
    private int f1344g;
    private int f1345h;
    private float[] f1346i = new float[]{0.0f, 0.0f};
    private float[] f1347j = new float[]{0.0f, 0.0f};
    private float[] f1348k = new float[]{Float.MAX_VALUE, Float.MAX_VALUE};
    private boolean f1349l;
    private boolean f1350m;
    private boolean f1351n;
    private boolean f1352o;
    private boolean f1353p;
    private boolean f1354q;

    private static class C0553a {
        private int f1325a;
        private int f1326b;
        private float f1327c;
        private float f1328d;
        private long f1329e = Long.MIN_VALUE;
        private long f1330f = 0;
        private int f1331g = 0;
        private int f1332h = 0;
        private long f1333i = -1;
        private float f1334j;
        private int f1335k;

        private float m2957a(float f) {
            return ((-4.0f * f) * f) + (4.0f * f);
        }

        private float m2958a(long j) {
            if (j < this.f1329e) {
                return 0.0f;
            }
            if (this.f1333i < 0 || j < this.f1333i) {
                return C0555a.m2977b(((float) (j - this.f1329e)) / ((float) this.f1325a), 0.0f, 1.0f) * 0.5f;
            }
            long j2 = j - this.f1333i;
            return (C0555a.m2977b(((float) j2) / ((float) this.f1335k), 0.0f, 1.0f) * this.f1334j) + (1.0f - this.f1334j);
        }

        public void m2959a() {
            this.f1329e = AnimationUtils.currentAnimationTimeMillis();
            this.f1333i = -1;
            this.f1330f = this.f1329e;
            this.f1334j = 0.5f;
            this.f1331g = 0;
            this.f1332h = 0;
        }

        public void m2960a(float f, float f2) {
            this.f1327c = f;
            this.f1328d = f2;
        }

        public void m2961a(int i) {
            this.f1325a = i;
        }

        public void m2962b() {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            this.f1335k = C0555a.m2978b((int) (currentAnimationTimeMillis - this.f1329e), 0, this.f1326b);
            this.f1334j = m2958a(currentAnimationTimeMillis);
            this.f1333i = currentAnimationTimeMillis;
        }

        public void m2963b(int i) {
            this.f1326b = i;
        }

        public boolean m2964c() {
            return this.f1333i > 0 && AnimationUtils.currentAnimationTimeMillis() > this.f1333i + ((long) this.f1335k);
        }

        public void m2965d() {
            if (this.f1330f == 0) {
                throw new RuntimeException("Cannot compute scroll delta before calling start()");
            }
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            float a = m2957a(m2958a(currentAnimationTimeMillis));
            long j = currentAnimationTimeMillis - this.f1330f;
            this.f1330f = currentAnimationTimeMillis;
            this.f1331g = (int) ((((float) j) * a) * this.f1327c);
            this.f1332h = (int) ((((float) j) * a) * this.f1328d);
        }

        public int m2966e() {
            return (int) (this.f1327c / Math.abs(this.f1327c));
        }

        public int m2967f() {
            return (int) (this.f1328d / Math.abs(this.f1328d));
        }

        public int m2968g() {
            return this.f1331g;
        }

        public int m2969h() {
            return this.f1332h;
        }
    }

    private class C0554b implements Runnable {
        final /* synthetic */ C0555a f1336a;

        private C0554b(C0555a c0555a) {
            this.f1336a = c0555a;
        }

        public void run() {
            if (this.f1336a.f1352o) {
                if (this.f1336a.f1350m) {
                    this.f1336a.f1350m = false;
                    this.f1336a.f1338a.m2959a();
                }
                C0553a c = this.f1336a.f1338a;
                if (c.m2964c() || !this.f1336a.m2974a()) {
                    this.f1336a.f1352o = false;
                    return;
                }
                if (this.f1336a.f1351n) {
                    this.f1336a.f1351n = false;
                    this.f1336a.m2985d();
                }
                c.m2965d();
                this.f1336a.mo486a(c.m2968g(), c.m2969h());
                ag.m2519a(this.f1336a.f1340c, (Runnable) this);
            }
        }
    }

    public C0555a(View view) {
        this.f1340c = view;
        DisplayMetrics displayMetrics = Resources.getSystem().getDisplayMetrics();
        int i = (int) ((1575.0f * displayMetrics.density) + 0.5f);
        int i2 = (int) ((displayMetrics.density * 315.0f) + 0.5f);
        m2991a((float) i, (float) i);
        m2995b((float) i2, (float) i2);
        m2992a(1);
        m3001e(Float.MAX_VALUE, Float.MAX_VALUE);
        m2999d(0.2f, 0.2f);
        m2997c(1.0f, 1.0f);
        m2996b(f1337r);
        m2998c(500);
        m3000d(500);
    }

    private float m2971a(float f, float f2, float f3, float f4) {
        float f5;
        float b = C0555a.m2977b(f * f2, 0.0f, f3);
        b = m2988f(f2 - f4, b) - m2988f(f4, b);
        if (b < 0.0f) {
            f5 = -this.f1339b.getInterpolation(-b);
        } else if (b <= 0.0f) {
            return 0.0f;
        } else {
            f5 = this.f1339b.getInterpolation(b);
        }
        return C0555a.m2977b(f5, -1.0f, 1.0f);
    }

    private float m2972a(int i, float f, float f2, float f3) {
        float a = m2971a(this.f1342e[i], f2, this.f1343f[i], f);
        if (a == 0.0f) {
            return 0.0f;
        }
        float f4 = this.f1346i[i];
        float f5 = this.f1347j[i];
        float f6 = this.f1348k[i];
        f4 *= f3;
        return a > 0.0f ? C0555a.m2977b(a * f4, f5, f6) : -C0555a.m2977b((-a) * f4, f5, f6);
    }

    private boolean m2974a() {
        C0553a c0553a = this.f1338a;
        int f = c0553a.m2967f();
        int e = c0553a.m2966e();
        return (f != 0 && mo488f(f)) || (e != 0 && mo487e(e));
    }

    private static float m2977b(float f, float f2, float f3) {
        return f > f3 ? f3 : f < f2 ? f2 : f;
    }

    private static int m2978b(int i, int i2, int i3) {
        return i > i3 ? i3 : i < i2 ? i2 : i;
    }

    private void m2979b() {
        if (this.f1341d == null) {
            this.f1341d = new C0554b();
        }
        this.f1352o = true;
        this.f1350m = true;
        if (this.f1349l || this.f1345h <= 0) {
            this.f1341d.run();
        } else {
            ag.m2520a(this.f1340c, this.f1341d, (long) this.f1345h);
        }
        this.f1349l = true;
    }

    private void m2983c() {
        if (this.f1350m) {
            this.f1352o = false;
        } else {
            this.f1338a.m2962b();
        }
    }

    private void m2985d() {
        long uptimeMillis = SystemClock.uptimeMillis();
        MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
        this.f1340c.onTouchEvent(obtain);
        obtain.recycle();
    }

    private float m2988f(float f, float f2) {
        if (f2 == 0.0f) {
            return 0.0f;
        }
        switch (this.f1344g) {
            case 0:
            case 1:
                return f < f2 ? f >= 0.0f ? 1.0f - (f / f2) : (this.f1352o && this.f1344g == 1) ? 1.0f : 0.0f : 0.0f;
            case 2:
                return f < 0.0f ? f / (-f2) : 0.0f;
            default:
                return 0.0f;
        }
    }

    public C0555a m2991a(float f, float f2) {
        this.f1348k[0] = f / 1000.0f;
        this.f1348k[1] = f2 / 1000.0f;
        return this;
    }

    public C0555a m2992a(int i) {
        this.f1344g = i;
        return this;
    }

    public C0555a m2993a(boolean z) {
        if (this.f1353p && !z) {
            m2983c();
        }
        this.f1353p = z;
        return this;
    }

    public abstract void mo486a(int i, int i2);

    public C0555a m2995b(float f, float f2) {
        this.f1347j[0] = f / 1000.0f;
        this.f1347j[1] = f2 / 1000.0f;
        return this;
    }

    public C0555a m2996b(int i) {
        this.f1345h = i;
        return this;
    }

    public C0555a m2997c(float f, float f2) {
        this.f1346i[0] = f / 1000.0f;
        this.f1346i[1] = f2 / 1000.0f;
        return this;
    }

    public C0555a m2998c(int i) {
        this.f1338a.m2961a(i);
        return this;
    }

    public C0555a m2999d(float f, float f2) {
        this.f1342e[0] = f;
        this.f1342e[1] = f2;
        return this;
    }

    public C0555a m3000d(int i) {
        this.f1338a.m2963b(i);
        return this;
    }

    public C0555a m3001e(float f, float f2) {
        this.f1343f[0] = f;
        this.f1343f[1] = f2;
        return this;
    }

    public abstract boolean mo487e(int i);

    public abstract boolean mo488f(int i);

    public boolean onTouch(View view, MotionEvent motionEvent) {
        boolean z = true;
        if (!this.f1353p) {
            return false;
        }
        switch (C0543s.m2893a(motionEvent)) {
            case 0:
                this.f1351n = true;
                this.f1349l = false;
                break;
            case 1:
            case 3:
                m2983c();
                break;
            case 2:
                break;
        }
        this.f1338a.m2960a(m2972a(0, motionEvent.getX(), (float) view.getWidth(), (float) this.f1340c.getWidth()), m2972a(1, motionEvent.getY(), (float) view.getHeight(), (float) this.f1340c.getHeight()));
        if (!this.f1352o && m2974a()) {
            m2979b();
        }
        if (!(this.f1354q && this.f1352o)) {
            z = false;
        }
        return z;
    }
}
