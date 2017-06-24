package android.support.design.widget;

import android.content.Context;
import android.support.v4.view.C0543s;
import android.support.v4.view.ae;
import android.support.v4.view.ag;
import android.support.v4.widget.C0599u;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;

abstract class C0060l<V extends View> extends aa<V> {
    private Runnable f252a;
    private C0599u f253b;
    private boolean f254c;
    private int f255d = -1;
    private int f256e;
    private int f257f = -1;
    private VelocityTracker f258g;

    private class C0151a implements Runnable {
        final /* synthetic */ C0060l f647a;
        private final CoordinatorLayout f648b;
        private final V f649c;

        C0151a(C0060l c0060l, CoordinatorLayout coordinatorLayout, V v) {
            this.f647a = c0060l;
            this.f648b = coordinatorLayout;
            this.f649c = v;
        }

        public void run() {
            if (this.f649c != null && this.f647a.f253b != null) {
                if (this.f647a.f253b.m3202g()) {
                    this.f647a.a_(this.f648b, this.f649c, this.f647a.f253b.m3198c());
                    ag.m2519a(this.f649c, (Runnable) this);
                    return;
                }
                this.f647a.mo48a(this.f648b, this.f649c);
            }
        }
    }

    public C0060l(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private void m373c() {
        if (this.f258g == null) {
            this.f258g = VelocityTracker.obtain();
        }
    }

    int mo45a() {
        return mo57b();
    }

    int mo46a(CoordinatorLayout coordinatorLayout, V v, int i, int i2, int i3) {
        int b = mo57b();
        if (i2 == 0 || b < i2 || b > i3) {
            return 0;
        }
        int a = C0152n.m1009a(i, i2, i3);
        if (b == a) {
            return 0;
        }
        mo53a(a);
        return b - a;
    }

    int mo47a(V v) {
        return v.getHeight();
    }

    void mo48a(CoordinatorLayout coordinatorLayout, V v) {
    }

    final boolean m378a(CoordinatorLayout coordinatorLayout, V v, int i, int i2, float f) {
        if (this.f252a != null) {
            v.removeCallbacks(this.f252a);
            this.f252a = null;
        }
        if (this.f253b == null) {
            this.f253b = C0599u.m3189a(v.getContext());
        }
        this.f253b.m3193a(0, mo57b(), 0, Math.round(f), 0, 0, i, i2);
        if (this.f253b.m3202g()) {
            this.f252a = new C0151a(this, coordinatorLayout, v);
            ag.m2519a((View) v, this.f252a);
            return true;
        }
        mo48a(coordinatorLayout, v);
        return false;
    }

    public boolean mo43a(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        if (this.f257f < 0) {
            this.f257f = ViewConfiguration.get(coordinatorLayout.getContext()).getScaledTouchSlop();
        }
        if (motionEvent.getAction() == 2 && this.f254c) {
            return true;
        }
        int y;
        switch (C0543s.m2893a(motionEvent)) {
            case 0:
                this.f254c = false;
                int x = (int) motionEvent.getX();
                y = (int) motionEvent.getY();
                if (mo60c(v) && coordinatorLayout.m598a((View) v, x, y)) {
                    this.f256e = y;
                    this.f255d = C0543s.m2896b(motionEvent, 0);
                    m373c();
                    break;
                }
            case 1:
            case 3:
                this.f254c = false;
                this.f255d = -1;
                if (this.f258g != null) {
                    this.f258g.recycle();
                    this.f258g = null;
                    break;
                }
                break;
            case 2:
                y = this.f255d;
                if (y != -1) {
                    y = C0543s.m2894a(motionEvent, y);
                    if (y != -1) {
                        y = (int) C0543s.m2899d(motionEvent, y);
                        if (Math.abs(y - this.f256e) > this.f257f) {
                            this.f254c = true;
                            this.f256e = y;
                            break;
                        }
                    }
                }
                break;
        }
        if (this.f258g != null) {
            this.f258g.addMovement(motionEvent);
        }
        return this.f254c;
    }

    int a_(CoordinatorLayout coordinatorLayout, V v, int i) {
        return mo46a(coordinatorLayout, (View) v, i, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    final int m380b(CoordinatorLayout coordinatorLayout, V v, int i, int i2, int i3) {
        return mo46a(coordinatorLayout, (View) v, mo45a() - i, i2, i3);
    }

    int mo58b(V v) {
        return -v.getHeight();
    }

    public boolean mo44b(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        if (this.f257f < 0) {
            this.f257f = ViewConfiguration.get(coordinatorLayout.getContext()).getScaledTouchSlop();
        }
        switch (C0543s.m2893a(motionEvent)) {
            case 0:
                int y = (int) motionEvent.getY();
                if (coordinatorLayout.m598a((View) v, (int) motionEvent.getX(), y) && mo60c(v)) {
                    this.f256e = y;
                    this.f255d = C0543s.m2896b(motionEvent, 0);
                    m373c();
                    break;
                }
                return false;
                break;
            case 1:
                if (this.f258g != null) {
                    this.f258g.addMovement(motionEvent);
                    this.f258g.computeCurrentVelocity(1000);
                    m378a(coordinatorLayout, (View) v, -mo47a((View) v), 0, ae.m2318b(this.f258g, this.f255d));
                    break;
                }
                break;
            case 2:
                int a = C0543s.m2894a(motionEvent, this.f255d);
                if (a != -1) {
                    a = (int) C0543s.m2899d(motionEvent, a);
                    int i = this.f256e - a;
                    if (!this.f254c && Math.abs(i) > this.f257f) {
                        this.f254c = true;
                        i = i > 0 ? i - this.f257f : i + this.f257f;
                    }
                    if (this.f254c) {
                        this.f256e = a;
                        m380b(coordinatorLayout, v, i, mo58b(v), 0);
                        break;
                    }
                }
                return false;
                break;
            case 3:
                break;
        }
        this.f254c = false;
        this.f255d = -1;
        if (this.f258g != null) {
            this.f258g.recycle();
            this.f258g = null;
        }
        if (this.f258g != null) {
            this.f258g.addMovement(motionEvent);
        }
        return true;
    }

    boolean mo60c(V v) {
        return false;
    }
}
