package android.support.design.widget;

import android.support.design.widget.CoordinatorLayout.C0059b;
import android.support.v4.view.C0543s;
import android.support.v4.view.ag;
import android.support.v4.widget.ad;
import android.support.v4.widget.ad.C0064a;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

public class SwipeDismissBehavior<V extends View> extends C0059b<V> {
    private ad f414a;
    private C0092a f415b;
    private boolean f416c;
    private float f417d = 0.0f;
    private boolean f418e;
    private int f419f = 2;
    private float f420g = 0.5f;
    private float f421h = 0.0f;
    private float f422i = 0.5f;
    private final C0064a f423j = new C01041(this);

    public interface C0092a {
        void mo93a(int i);

        void mo94a(View view);
    }

    class C01041 extends C0064a {
        final /* synthetic */ SwipeDismissBehavior f433a;
        private int f434b;
        private int f435c = -1;

        C01041(SwipeDismissBehavior swipeDismissBehavior) {
            this.f433a = swipeDismissBehavior;
        }

        private boolean m728a(View view, float f) {
            if (f != 0.0f) {
                boolean z = ag.m2540h(view) == 1;
                return this.f433a.f419f == 2 ? true : this.f433a.f419f == 0 ? z ? f < 0.0f : f > 0.0f : this.f433a.f419f == 1 ? z ? f > 0.0f : f < 0.0f : false;
            } else {
                return Math.abs(view.getLeft() - this.f434b) >= Math.round(((float) view.getWidth()) * this.f433a.f420g);
            }
        }

        public int mo68a(View view, int i, int i2) {
            return view.getTop();
        }

        public void mo69a(int i) {
            if (this.f433a.f415b != null) {
                this.f433a.f415b.mo93a(i);
            }
        }

        public void mo70a(View view, float f, float f2) {
            this.f435c = -1;
            int width = view.getWidth();
            boolean z = false;
            if (m728a(view, f)) {
                width = view.getLeft() < this.f434b ? this.f434b - width : this.f434b + width;
                z = true;
            } else {
                width = this.f434b;
            }
            if (this.f433a.f414a.m3030a(width, view.getTop())) {
                ag.m2519a(view, new C0105b(this.f433a, view, z));
            } else if (z && this.f433a.f415b != null) {
                this.f433a.f415b.mo94a(view);
            }
        }

        public void mo71a(View view, int i, int i2, int i3, int i4) {
            float width = ((float) this.f434b) + (((float) view.getWidth()) * this.f433a.f421h);
            float width2 = ((float) this.f434b) + (((float) view.getWidth()) * this.f433a.f422i);
            if (((float) i) <= width) {
                ag.m2528c(view, 1.0f);
            } else if (((float) i) >= width2) {
                ag.m2528c(view, 0.0f);
            } else {
                ag.m2528c(view, SwipeDismissBehavior.m689c(0.0f, 1.0f - SwipeDismissBehavior.m682a(width, width2, (float) i), 1.0f));
            }
        }

        public boolean mo72a(View view, int i) {
            return this.f435c == -1 && this.f433a.mo101a(view);
        }

        public int mo102b(View view) {
            return view.getWidth();
        }

        public int mo73b(View view, int i, int i2) {
            int width;
            int i3;
            Object obj = ag.m2540h(view) == 1 ? 1 : null;
            if (this.f433a.f419f == 0) {
                if (obj != null) {
                    width = this.f434b - view.getWidth();
                    i3 = this.f434b;
                } else {
                    width = this.f434b;
                    i3 = this.f434b + view.getWidth();
                }
            } else if (this.f433a.f419f != 1) {
                width = this.f434b - view.getWidth();
                i3 = this.f434b + view.getWidth();
            } else if (obj != null) {
                width = this.f434b;
                i3 = this.f434b + view.getWidth();
            } else {
                width = this.f434b - view.getWidth();
                i3 = this.f434b;
            }
            return SwipeDismissBehavior.m687b(width, i, i3);
        }

        public void mo103b(View view, int i) {
            this.f435c = i;
            this.f434b = view.getLeft();
            ViewParent parent = view.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
        }
    }

    private class C0105b implements Runnable {
        final /* synthetic */ SwipeDismissBehavior f436a;
        private final View f437b;
        private final boolean f438c;

        C0105b(SwipeDismissBehavior swipeDismissBehavior, View view, boolean z) {
            this.f436a = swipeDismissBehavior;
            this.f437b = view;
            this.f438c = z;
        }

        public void run() {
            if (this.f436a.f414a != null && this.f436a.f414a.m3033a(true)) {
                ag.m2519a(this.f437b, (Runnable) this);
            } else if (this.f438c && this.f436a.f415b != null) {
                this.f436a.f415b.mo94a(this.f437b);
            }
        }
    }

    static float m682a(float f, float f2, float f3) {
        return (f3 - f) / (f2 - f);
    }

    private void m685a(ViewGroup viewGroup) {
        if (this.f414a == null) {
            this.f414a = this.f418e ? ad.m3010a(viewGroup, this.f417d, this.f423j) : ad.m3011a(viewGroup, this.f423j);
        }
    }

    private static int m687b(int i, int i2, int i3) {
        return Math.min(Math.max(i, i2), i3);
    }

    private static float m689c(float f, float f2, float f3) {
        return Math.min(Math.max(f, f2), f3);
    }

    public void m694a(float f) {
        this.f421h = m689c(0.0f, f, 1.0f);
    }

    public void m695a(int i) {
        this.f419f = i;
    }

    public void m696a(C0092a c0092a) {
        this.f415b = c0092a;
    }

    public boolean mo43a(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        switch (C0543s.m2893a(motionEvent)) {
            case 1:
            case 3:
                if (this.f416c) {
                    this.f416c = false;
                    return false;
                }
                break;
            default:
                this.f416c = !coordinatorLayout.m598a((View) v, (int) motionEvent.getX(), (int) motionEvent.getY());
                break;
        }
        if (this.f416c) {
            return false;
        }
        m685a((ViewGroup) coordinatorLayout);
        return this.f414a.m3031a(motionEvent);
    }

    public boolean mo101a(View view) {
        return true;
    }

    public void m699b(float f) {
        this.f422i = m689c(0.0f, f, 1.0f);
    }

    public boolean mo44b(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        if (this.f414a == null) {
            return false;
        }
        this.f414a.m3036b(motionEvent);
        return true;
    }
}
