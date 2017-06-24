package android.support.design.widget;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.support.design.widget.C0170v.C0169e;
import android.support.design.widget.C0170v.C0169e.C0165b;
import android.support.design.widget.C0170v.C0169e.C0167a;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;

class C0172w extends C0169e {
    private static final Handler f697a = new Handler(Looper.getMainLooper());
    private long f698b;
    private boolean f699c;
    private final int[] f700d = new int[2];
    private final float[] f701e = new float[2];
    private int f702f = 200;
    private Interpolator f703g;
    private C0167a f704h;
    private C0165b f705i;
    private float f706j;
    private final Runnable f707k = new C01711(this);

    class C01711 implements Runnable {
        final /* synthetic */ C0172w f696a;

        C01711(C0172w c0172w) {
            this.f696a = c0172w;
        }

        public void run() {
            this.f696a.m1089h();
        }
    }

    C0172w() {
    }

    private void m1089h() {
        if (this.f699c) {
            float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.f698b)) / ((float) this.f702f);
            if (this.f703g != null) {
                uptimeMillis = this.f703g.getInterpolation(uptimeMillis);
            }
            this.f706j = uptimeMillis;
            if (this.f705i != null) {
                this.f705i.mo148a();
            }
            if (SystemClock.uptimeMillis() >= this.f698b + ((long) this.f702f)) {
                this.f699c = false;
                if (this.f704h != null) {
                    this.f704h.mo150b();
                }
            }
        }
        if (this.f699c) {
            f697a.postDelayed(this.f707k, 10);
        }
    }

    public void mo152a() {
        if (!this.f699c) {
            if (this.f703g == null) {
                this.f703g = new AccelerateDecelerateInterpolator();
            }
            this.f698b = SystemClock.uptimeMillis();
            this.f699c = true;
            if (this.f704h != null) {
                this.f704h.mo149a();
            }
            f697a.postDelayed(this.f707k, 10);
        }
    }

    public void mo153a(float f, float f2) {
        this.f701e[0] = f;
        this.f701e[1] = f2;
    }

    public void mo154a(int i) {
        this.f702f = i;
    }

    public void mo155a(int i, int i2) {
        this.f700d[0] = i;
        this.f700d[1] = i2;
    }

    public void mo156a(C0167a c0167a) {
        this.f704h = c0167a;
    }

    public void mo157a(C0165b c0165b) {
        this.f705i = c0165b;
    }

    public void mo158a(Interpolator interpolator) {
        this.f703g = interpolator;
    }

    public boolean mo159b() {
        return this.f699c;
    }

    public int mo160c() {
        return C0127a.m879a(this.f700d[0], this.f700d[1], mo163f());
    }

    public float mo161d() {
        return C0127a.m878a(this.f701e[0], this.f701e[1], mo163f());
    }

    public void mo162e() {
        this.f699c = false;
        f697a.removeCallbacks(this.f707k);
        if (this.f704h != null) {
            this.f704h.mo151c();
        }
    }

    public float mo163f() {
        return this.f706j;
    }

    public long mo164g() {
        return (long) this.f702f;
    }
}
