package android.support.v4.widget;

import android.content.Context;
import android.support.v4.view.C0543s;
import android.support.v4.view.ae;
import android.support.v4.view.ag;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import java.util.Arrays;

public class ad {
    private static final Interpolator f1356v = new C05561();
    private int f1357a;
    private int f1358b;
    private int f1359c = -1;
    private float[] f1360d;
    private float[] f1361e;
    private float[] f1362f;
    private float[] f1363g;
    private int[] f1364h;
    private int[] f1365i;
    private int[] f1366j;
    private int f1367k;
    private VelocityTracker f1368l;
    private float f1369m;
    private float f1370n;
    private int f1371o;
    private int f1372p;
    private C0599u f1373q;
    private final C0064a f1374r;
    private View f1375s;
    private boolean f1376t;
    private final ViewGroup f1377u;
    private final Runnable f1378w = new C05572(this);

    public static abstract class C0064a {
        public int mo67a(View view) {
            return 0;
        }

        public int mo68a(View view, int i, int i2) {
            return 0;
        }

        public void mo69a(int i) {
        }

        public void m469a(int i, int i2) {
        }

        public void mo70a(View view, float f, float f2) {
        }

        public void mo71a(View view, int i, int i2, int i3, int i4) {
        }

        public abstract boolean mo72a(View view, int i);

        public int mo102b(View view) {
            return 0;
        }

        public int mo73b(View view, int i, int i2) {
            return 0;
        }

        public void m475b(int i, int i2) {
        }

        public void mo103b(View view, int i) {
        }

        public boolean m477b(int i) {
            return false;
        }

        public int m478c(int i) {
            return i;
        }
    }

    static class C05561 implements Interpolator {
        C05561() {
        }

        public float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * (((f2 * f2) * f2) * f2)) + 1.0f;
        }
    }

    class C05572 implements Runnable {
        final /* synthetic */ ad f1355a;

        C05572(ad adVar) {
            this.f1355a = adVar;
        }

        public void run() {
            this.f1355a.m3035b(0);
        }
    }

    private ad(Context context, ViewGroup viewGroup, C0064a c0064a) {
        if (viewGroup == null) {
            throw new IllegalArgumentException("Parent view may not be null");
        } else if (c0064a == null) {
            throw new IllegalArgumentException("Callback may not be null");
        } else {
            this.f1377u = viewGroup;
            this.f1374r = c0064a;
            ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
            this.f1371o = (int) ((context.getResources().getDisplayMetrics().density * 20.0f) + 0.5f);
            this.f1358b = viewConfiguration.getScaledTouchSlop();
            this.f1369m = (float) viewConfiguration.getScaledMaximumFlingVelocity();
            this.f1370n = (float) viewConfiguration.getScaledMinimumFlingVelocity();
            this.f1373q = C0599u.m3190a(context, f1356v);
        }
    }

    private float m3006a(float f) {
        return (float) Math.sin((double) ((float) (((double) (f - 0.5f)) * 0.4712389167638204d)));
    }

    private float m3007a(float f, float f2, float f3) {
        float abs = Math.abs(f);
        return abs < f2 ? 0.0f : abs > f3 ? f <= 0.0f ? -f3 : f3 : f;
    }

    private int m3008a(int i, int i2, int i3) {
        if (i == 0) {
            return 0;
        }
        int width = this.f1377u.getWidth();
        int i4 = width / 2;
        float a = (m3006a(Math.min(1.0f, ((float) Math.abs(i)) / ((float) width))) * ((float) i4)) + ((float) i4);
        i4 = Math.abs(i2);
        return Math.min(i4 > 0 ? Math.round(Math.abs(a / ((float) i4)) * 1000.0f) * 4 : (int) (((((float) Math.abs(i)) / ((float) i3)) + 1.0f) * 256.0f), 600);
    }

    private int m3009a(View view, int i, int i2, int i3, int i4) {
        int b = m3017b(i3, (int) this.f1370n, (int) this.f1369m);
        int b2 = m3017b(i4, (int) this.f1370n, (int) this.f1369m);
        int abs = Math.abs(i);
        int abs2 = Math.abs(i2);
        int abs3 = Math.abs(b);
        int abs4 = Math.abs(b2);
        int i5 = abs3 + abs4;
        int i6 = abs + abs2;
        return (int) (((b2 != 0 ? ((float) abs4) / ((float) i5) : ((float) abs2) / ((float) i6)) * ((float) m3008a(i2, b2, this.f1374r.mo67a(view)))) + ((b != 0 ? ((float) abs3) / ((float) i5) : ((float) abs) / ((float) i6)) * ((float) m3008a(i, b, this.f1374r.mo102b(view)))));
    }

    public static ad m3010a(ViewGroup viewGroup, float f, C0064a c0064a) {
        ad a = m3011a(viewGroup, c0064a);
        a.f1358b = (int) (((float) a.f1358b) * (1.0f / f));
        return a;
    }

    public static ad m3011a(ViewGroup viewGroup, C0064a c0064a) {
        return new ad(viewGroup.getContext(), viewGroup, c0064a);
    }

    private void m3012a(float f, float f2) {
        this.f1376t = true;
        this.f1374r.mo70a(this.f1375s, f, f2);
        this.f1376t = false;
        if (this.f1357a == 1) {
            m3035b(0);
        }
    }

    private void m3013a(float f, float f2, int i) {
        m3024d(i);
        float[] fArr = this.f1360d;
        this.f1362f[i] = f;
        fArr[i] = f;
        fArr = this.f1361e;
        this.f1363g[i] = f2;
        fArr[i] = f2;
        this.f1364h[i] = m3022d((int) f, (int) f2);
        this.f1367k |= 1 << i;
    }

    private boolean m3014a(float f, float f2, int i, int i2) {
        float abs = Math.abs(f);
        float abs2 = Math.abs(f2);
        if ((this.f1364h[i] & i2) != i2 || (this.f1372p & i2) == 0 || (this.f1366j[i] & i2) == i2 || (this.f1365i[i] & i2) == i2) {
            return false;
        }
        if (abs <= ((float) this.f1358b) && abs2 <= ((float) this.f1358b)) {
            return false;
        }
        if (abs >= abs2 * 0.5f || !this.f1374r.m477b(i2)) {
            return (this.f1365i[i] & i2) == 0 && abs > ((float) this.f1358b);
        } else {
            int[] iArr = this.f1366j;
            iArr[i] = iArr[i] | i2;
            return false;
        }
    }

    private boolean m3015a(int i, int i2, int i3, int i4) {
        int left = this.f1375s.getLeft();
        int top = this.f1375s.getTop();
        int i5 = i - left;
        int i6 = i2 - top;
        if (i5 == 0 && i6 == 0) {
            this.f1373q.m3203h();
            m3035b(0);
            return false;
        }
        this.f1373q.m3192a(left, top, i5, i6, m3009a(this.f1375s, i5, i6, i3, i4));
        m3035b(2);
        return true;
    }

    private boolean m3016a(View view, float f, float f2) {
        if (view == null) {
            return false;
        }
        boolean z = this.f1374r.mo102b(view) > 0;
        boolean z2 = this.f1374r.mo67a(view) > 0;
        return (z && z2) ? (f * f) + (f2 * f2) > ((float) (this.f1358b * this.f1358b)) : z ? Math.abs(f) > ((float) this.f1358b) : z2 ? Math.abs(f2) > ((float) this.f1358b) : false;
    }

    private int m3017b(int i, int i2, int i3) {
        int abs = Math.abs(i);
        return abs < i2 ? 0 : abs > i3 ? i <= 0 ? -i3 : i3 : i;
    }

    private void m3018b(float f, float f2, int i) {
        int i2 = 1;
        if (!m3014a(f, f2, i, 1)) {
            i2 = 0;
        }
        if (m3014a(f2, f, i, 4)) {
            i2 |= 4;
        }
        if (m3014a(f, f2, i, 2)) {
            i2 |= 2;
        }
        if (m3014a(f2, f, i, 8)) {
            i2 |= 8;
        }
        if (i2 != 0) {
            int[] iArr = this.f1365i;
            iArr[i] = iArr[i] | i2;
            this.f1374r.m475b(i2, i);
        }
    }

    private void m3019b(int i, int i2, int i3, int i4) {
        int b;
        int a;
        int left = this.f1375s.getLeft();
        int top = this.f1375s.getTop();
        if (i3 != 0) {
            b = this.f1374r.mo73b(this.f1375s, i, i3);
            ag.m2538f(this.f1375s, b - left);
        } else {
            b = i;
        }
        if (i4 != 0) {
            a = this.f1374r.mo68a(this.f1375s, i2, i4);
            ag.m2536e(this.f1375s, a - top);
        } else {
            a = i2;
        }
        if (i3 != 0 || i4 != 0) {
            this.f1374r.mo71a(this.f1375s, b, a, b - left, a - top);
        }
    }

    private void m3020c(int i) {
        if (this.f1360d != null) {
            this.f1360d[i] = 0.0f;
            this.f1361e[i] = 0.0f;
            this.f1362f[i] = 0.0f;
            this.f1363g[i] = 0.0f;
            this.f1364h[i] = 0;
            this.f1365i[i] = 0;
            this.f1366j[i] = 0;
            this.f1367k &= (1 << i) ^ -1;
        }
    }

    private void m3021c(MotionEvent motionEvent) {
        int c = C0543s.m2898c(motionEvent);
        for (int i = 0; i < c; i++) {
            int b = C0543s.m2896b(motionEvent, i);
            float c2 = C0543s.m2897c(motionEvent, i);
            float d = C0543s.m2899d(motionEvent, i);
            this.f1362f[b] = c2;
            this.f1363g[b] = d;
        }
    }

    private int m3022d(int i, int i2) {
        int i3 = 0;
        if (i < this.f1377u.getLeft() + this.f1371o) {
            i3 = 1;
        }
        if (i2 < this.f1377u.getTop() + this.f1371o) {
            i3 |= 4;
        }
        if (i > this.f1377u.getRight() - this.f1371o) {
            i3 |= 2;
        }
        return i2 > this.f1377u.getBottom() - this.f1371o ? i3 | 8 : i3;
    }

    private void m3023d() {
        if (this.f1360d != null) {
            Arrays.fill(this.f1360d, 0.0f);
            Arrays.fill(this.f1361e, 0.0f);
            Arrays.fill(this.f1362f, 0.0f);
            Arrays.fill(this.f1363g, 0.0f);
            Arrays.fill(this.f1364h, 0);
            Arrays.fill(this.f1365i, 0);
            Arrays.fill(this.f1366j, 0);
            this.f1367k = 0;
        }
    }

    private void m3024d(int i) {
        if (this.f1360d == null || this.f1360d.length <= i) {
            Object obj = new float[(i + 1)];
            Object obj2 = new float[(i + 1)];
            Object obj3 = new float[(i + 1)];
            Object obj4 = new float[(i + 1)];
            Object obj5 = new int[(i + 1)];
            Object obj6 = new int[(i + 1)];
            Object obj7 = new int[(i + 1)];
            if (this.f1360d != null) {
                System.arraycopy(this.f1360d, 0, obj, 0, this.f1360d.length);
                System.arraycopy(this.f1361e, 0, obj2, 0, this.f1361e.length);
                System.arraycopy(this.f1362f, 0, obj3, 0, this.f1362f.length);
                System.arraycopy(this.f1363g, 0, obj4, 0, this.f1363g.length);
                System.arraycopy(this.f1364h, 0, obj5, 0, this.f1364h.length);
                System.arraycopy(this.f1365i, 0, obj6, 0, this.f1365i.length);
                System.arraycopy(this.f1366j, 0, obj7, 0, this.f1366j.length);
            }
            this.f1360d = obj;
            this.f1361e = obj2;
            this.f1362f = obj3;
            this.f1363g = obj4;
            this.f1364h = obj5;
            this.f1365i = obj6;
            this.f1366j = obj7;
        }
    }

    private void m3025e() {
        this.f1368l.computeCurrentVelocity(1000, this.f1369m);
        m3012a(m3007a(ae.m2317a(this.f1368l, this.f1359c), this.f1370n, this.f1369m), m3007a(ae.m2318b(this.f1368l, this.f1359c), this.f1370n, this.f1369m));
    }

    private boolean m3026e(int i) {
        if (m3029a(i)) {
            return true;
        }
        Log.e("ViewDragHelper", "Ignoring pointerId=" + i + " because ACTION_DOWN was not received " + "for this pointer before ACTION_MOVE. It likely happened because " + " ViewDragHelper did not receive all the events in the event stream.");
        return false;
    }

    public float m3027a() {
        return this.f1370n;
    }

    public void m3028a(View view, int i) {
        if (view.getParent() != this.f1377u) {
            throw new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + this.f1377u + ")");
        }
        this.f1375s = view;
        this.f1359c = i;
        this.f1374r.mo103b(view, i);
        m3035b(1);
    }

    public boolean m3029a(int i) {
        return (this.f1367k & (1 << i)) != 0;
    }

    public boolean m3030a(int i, int i2) {
        if (this.f1376t) {
            return m3015a(i, i2, (int) ae.m2317a(this.f1368l, this.f1359c), (int) ae.m2318b(this.f1368l, this.f1359c));
        }
        throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean m3031a(android.view.MotionEvent r14) {
        /*
        r13 = this;
        r0 = android.support.v4.view.C0543s.m2893a(r14);
        r1 = android.support.v4.view.C0543s.m2895b(r14);
        if (r0 != 0) goto L_0x000d;
    L_0x000a:
        r13.m3041c();
    L_0x000d:
        r2 = r13.f1368l;
        if (r2 != 0) goto L_0x0017;
    L_0x0011:
        r2 = android.view.VelocityTracker.obtain();
        r13.f1368l = r2;
    L_0x0017:
        r2 = r13.f1368l;
        r2.addMovement(r14);
        switch(r0) {
            case 0: goto L_0x0026;
            case 1: goto L_0x0128;
            case 2: goto L_0x0092;
            case 3: goto L_0x0128;
            case 4: goto L_0x001f;
            case 5: goto L_0x005a;
            case 6: goto L_0x011f;
            default: goto L_0x001f;
        };
    L_0x001f:
        r0 = r13.f1357a;
        r1 = 1;
        if (r0 != r1) goto L_0x012d;
    L_0x0024:
        r0 = 1;
    L_0x0025:
        return r0;
    L_0x0026:
        r0 = r14.getX();
        r1 = r14.getY();
        r2 = 0;
        r2 = android.support.v4.view.C0543s.m2896b(r14, r2);
        r13.m3013a(r0, r1, r2);
        r0 = (int) r0;
        r1 = (int) r1;
        r0 = r13.m3040c(r0, r1);
        r1 = r13.f1375s;
        if (r0 != r1) goto L_0x0048;
    L_0x0040:
        r1 = r13.f1357a;
        r3 = 2;
        if (r1 != r3) goto L_0x0048;
    L_0x0045:
        r13.m3038b(r0, r2);
    L_0x0048:
        r0 = r13.f1364h;
        r0 = r0[r2];
        r1 = r13.f1372p;
        r1 = r1 & r0;
        if (r1 == 0) goto L_0x001f;
    L_0x0051:
        r1 = r13.f1374r;
        r3 = r13.f1372p;
        r0 = r0 & r3;
        r1.m469a(r0, r2);
        goto L_0x001f;
    L_0x005a:
        r0 = android.support.v4.view.C0543s.m2896b(r14, r1);
        r2 = android.support.v4.view.C0543s.m2897c(r14, r1);
        r1 = android.support.v4.view.C0543s.m2899d(r14, r1);
        r13.m3013a(r2, r1, r0);
        r3 = r13.f1357a;
        if (r3 != 0) goto L_0x007f;
    L_0x006d:
        r1 = r13.f1364h;
        r1 = r1[r0];
        r2 = r13.f1372p;
        r2 = r2 & r1;
        if (r2 == 0) goto L_0x001f;
    L_0x0076:
        r2 = r13.f1374r;
        r3 = r13.f1372p;
        r1 = r1 & r3;
        r2.m469a(r1, r0);
        goto L_0x001f;
    L_0x007f:
        r3 = r13.f1357a;
        r4 = 2;
        if (r3 != r4) goto L_0x001f;
    L_0x0084:
        r2 = (int) r2;
        r1 = (int) r1;
        r1 = r13.m3040c(r2, r1);
        r2 = r13.f1375s;
        if (r1 != r2) goto L_0x001f;
    L_0x008e:
        r13.m3038b(r1, r0);
        goto L_0x001f;
    L_0x0092:
        r0 = r13.f1360d;
        if (r0 == 0) goto L_0x001f;
    L_0x0096:
        r0 = r13.f1361e;
        if (r0 == 0) goto L_0x001f;
    L_0x009a:
        r2 = android.support.v4.view.C0543s.m2898c(r14);
        r0 = 0;
        r1 = r0;
    L_0x00a0:
        if (r1 >= r2) goto L_0x0107;
    L_0x00a2:
        r3 = android.support.v4.view.C0543s.m2896b(r14, r1);
        r0 = r13.m3026e(r3);
        if (r0 != 0) goto L_0x00b0;
    L_0x00ac:
        r0 = r1 + 1;
        r1 = r0;
        goto L_0x00a0;
    L_0x00b0:
        r0 = android.support.v4.view.C0543s.m2897c(r14, r1);
        r4 = android.support.v4.view.C0543s.m2899d(r14, r1);
        r5 = r13.f1360d;
        r5 = r5[r3];
        r5 = r0 - r5;
        r6 = r13.f1361e;
        r6 = r6[r3];
        r6 = r4 - r6;
        r0 = (int) r0;
        r4 = (int) r4;
        r4 = r13.m3040c(r0, r4);
        if (r4 == 0) goto L_0x010c;
    L_0x00cc:
        r0 = r13.m3016a(r4, r5, r6);
        if (r0 == 0) goto L_0x010c;
    L_0x00d2:
        r0 = 1;
    L_0x00d3:
        if (r0 == 0) goto L_0x010e;
    L_0x00d5:
        r7 = r4.getLeft();
        r8 = (int) r5;
        r8 = r8 + r7;
        r9 = r13.f1374r;
        r10 = (int) r5;
        r8 = r9.mo73b(r4, r8, r10);
        r9 = r4.getTop();
        r10 = (int) r6;
        r10 = r10 + r9;
        r11 = r13.f1374r;
        r12 = (int) r6;
        r10 = r11.mo68a(r4, r10, r12);
        r11 = r13.f1374r;
        r11 = r11.mo102b(r4);
        r12 = r13.f1374r;
        r12 = r12.mo67a(r4);
        if (r11 == 0) goto L_0x0101;
    L_0x00fd:
        if (r11 <= 0) goto L_0x010e;
    L_0x00ff:
        if (r8 != r7) goto L_0x010e;
    L_0x0101:
        if (r12 == 0) goto L_0x0107;
    L_0x0103:
        if (r12 <= 0) goto L_0x010e;
    L_0x0105:
        if (r10 != r9) goto L_0x010e;
    L_0x0107:
        r13.m3021c(r14);
        goto L_0x001f;
    L_0x010c:
        r0 = 0;
        goto L_0x00d3;
    L_0x010e:
        r13.m3018b(r5, r6, r3);
        r5 = r13.f1357a;
        r6 = 1;
        if (r5 == r6) goto L_0x0107;
    L_0x0116:
        if (r0 == 0) goto L_0x00ac;
    L_0x0118:
        r0 = r13.m3038b(r4, r3);
        if (r0 == 0) goto L_0x00ac;
    L_0x011e:
        goto L_0x0107;
    L_0x011f:
        r0 = android.support.v4.view.C0543s.m2896b(r14, r1);
        r13.m3020c(r0);
        goto L_0x001f;
    L_0x0128:
        r13.m3041c();
        goto L_0x001f;
    L_0x012d:
        r0 = 0;
        goto L_0x0025;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.widget.ad.a(android.view.MotionEvent):boolean");
    }

    public boolean m3032a(View view, int i, int i2) {
        this.f1375s = view;
        this.f1359c = -1;
        boolean a = m3015a(i, i2, 0, 0);
        if (!(a || this.f1357a != 0 || this.f1375s == null)) {
            this.f1375s = null;
        }
        return a;
    }

    public boolean m3033a(boolean z) {
        if (this.f1357a == 2) {
            int i;
            boolean g = this.f1373q.m3202g();
            int b = this.f1373q.m3197b();
            int c = this.f1373q.m3198c();
            int left = b - this.f1375s.getLeft();
            int top = c - this.f1375s.getTop();
            if (left != 0) {
                ag.m2538f(this.f1375s, left);
            }
            if (top != 0) {
                ag.m2536e(this.f1375s, top);
            }
            if (!(left == 0 && top == 0)) {
                this.f1374r.mo71a(this.f1375s, b, c, left, top);
            }
            if (g && b == this.f1373q.m3199d() && c == this.f1373q.m3200e()) {
                this.f1373q.m3203h();
                i = 0;
            } else {
                boolean z2 = g;
            }
            if (i == 0) {
                if (z) {
                    this.f1377u.post(this.f1378w);
                } else {
                    m3035b(0);
                }
            }
        }
        return this.f1357a == 2;
    }

    public int m3034b() {
        return this.f1358b;
    }

    void m3035b(int i) {
        this.f1377u.removeCallbacks(this.f1378w);
        if (this.f1357a != i) {
            this.f1357a = i;
            this.f1374r.mo69a(i);
            if (this.f1357a == 0) {
                this.f1375s = null;
            }
        }
    }

    public void m3036b(MotionEvent motionEvent) {
        int i = 0;
        int a = C0543s.m2893a(motionEvent);
        int b = C0543s.m2895b(motionEvent);
        if (a == 0) {
            m3041c();
        }
        if (this.f1368l == null) {
            this.f1368l = VelocityTracker.obtain();
        }
        this.f1368l.addMovement(motionEvent);
        float x;
        float y;
        View c;
        int i2;
        switch (a) {
            case 0:
                x = motionEvent.getX();
                y = motionEvent.getY();
                i = C0543s.m2896b(motionEvent, 0);
                c = m3040c((int) x, (int) y);
                m3013a(x, y, i);
                m3038b(c, i);
                i2 = this.f1364h[i];
                if ((this.f1372p & i2) != 0) {
                    this.f1374r.m469a(i2 & this.f1372p, i);
                    return;
                }
                return;
            case 1:
                if (this.f1357a == 1) {
                    m3025e();
                }
                m3041c();
                return;
            case 2:
                if (this.f1357a != 1) {
                    i2 = C0543s.m2898c(motionEvent);
                    while (i < i2) {
                        a = C0543s.m2896b(motionEvent, i);
                        if (m3026e(a)) {
                            float c2 = C0543s.m2897c(motionEvent, i);
                            float d = C0543s.m2899d(motionEvent, i);
                            float f = c2 - this.f1360d[a];
                            float f2 = d - this.f1361e[a];
                            m3018b(f, f2, a);
                            if (this.f1357a != 1) {
                                c = m3040c((int) c2, (int) d);
                                if (m3016a(c, f, f2) && m3038b(c, a)) {
                                }
                            }
                            m3021c(motionEvent);
                            return;
                        }
                        i++;
                    }
                    m3021c(motionEvent);
                    return;
                } else if (m3026e(this.f1359c)) {
                    i = C0543s.m2894a(motionEvent, this.f1359c);
                    x = C0543s.m2897c(motionEvent, i);
                    i2 = (int) (x - this.f1362f[this.f1359c]);
                    i = (int) (C0543s.m2899d(motionEvent, i) - this.f1363g[this.f1359c]);
                    m3019b(this.f1375s.getLeft() + i2, this.f1375s.getTop() + i, i2, i);
                    m3021c(motionEvent);
                    return;
                } else {
                    return;
                }
            case 3:
                if (this.f1357a == 1) {
                    m3012a(0.0f, 0.0f);
                }
                m3041c();
                return;
            case 5:
                i = C0543s.m2896b(motionEvent, b);
                x = C0543s.m2897c(motionEvent, b);
                y = C0543s.m2899d(motionEvent, b);
                m3013a(x, y, i);
                if (this.f1357a == 0) {
                    m3038b(m3040c((int) x, (int) y), i);
                    i2 = this.f1364h[i];
                    if ((this.f1372p & i2) != 0) {
                        this.f1374r.m469a(i2 & this.f1372p, i);
                        return;
                    }
                    return;
                } else if (m3037b((int) x, (int) y)) {
                    m3038b(this.f1375s, i);
                    return;
                } else {
                    return;
                }
            case 6:
                a = C0543s.m2896b(motionEvent, b);
                if (this.f1357a == 1 && a == this.f1359c) {
                    b = C0543s.m2898c(motionEvent);
                    while (i < b) {
                        int b2 = C0543s.m2896b(motionEvent, i);
                        if (b2 != this.f1359c) {
                            if (m3040c((int) C0543s.m2897c(motionEvent, i), (int) C0543s.m2899d(motionEvent, i)) == this.f1375s && m3038b(this.f1375s, b2)) {
                                i = this.f1359c;
                                if (i == -1) {
                                    m3025e();
                                }
                            }
                        }
                        i++;
                    }
                    i = -1;
                    if (i == -1) {
                        m3025e();
                    }
                }
                m3020c(a);
                return;
            default:
                return;
        }
    }

    public boolean m3037b(int i, int i2) {
        return m3039b(this.f1375s, i, i2);
    }

    boolean m3038b(View view, int i) {
        if (view == this.f1375s && this.f1359c == i) {
            return true;
        }
        if (view == null || !this.f1374r.mo72a(view, i)) {
            return false;
        }
        this.f1359c = i;
        m3028a(view, i);
        return true;
    }

    public boolean m3039b(View view, int i, int i2) {
        return view != null && i >= view.getLeft() && i < view.getRight() && i2 >= view.getTop() && i2 < view.getBottom();
    }

    public View m3040c(int i, int i2) {
        for (int childCount = this.f1377u.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = this.f1377u.getChildAt(this.f1374r.m478c(childCount));
            if (i >= childAt.getLeft() && i < childAt.getRight() && i2 >= childAt.getTop() && i2 < childAt.getBottom()) {
                return childAt;
            }
        }
        return null;
    }

    public void m3041c() {
        this.f1359c = -1;
        m3023d();
        if (this.f1368l != null) {
            this.f1368l.recycle();
            this.f1368l = null;
        }
    }
}
