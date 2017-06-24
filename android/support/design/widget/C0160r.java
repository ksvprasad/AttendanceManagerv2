package android.support.design.widget;

import android.util.StateSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

final class C0160r {
    private final ArrayList<C0159a> f679a = new ArrayList();
    private C0159a f680b = null;
    private Animation f681c = null;
    private WeakReference<View> f682d;
    private AnimationListener f683e = new C01581(this);

    class C01581 implements AnimationListener {
        final /* synthetic */ C0160r f676a;

        C01581(C0160r c0160r) {
            this.f676a = c0160r;
        }

        public void onAnimationEnd(Animation animation) {
            if (this.f676a.f681c == animation) {
                this.f676a.f681c = null;
            }
        }

        public void onAnimationRepeat(Animation animation) {
        }

        public void onAnimationStart(Animation animation) {
        }
    }

    static class C0159a {
        final int[] f677a;
        final Animation f678b;

        private C0159a(int[] iArr, Animation animation) {
            this.f677a = iArr;
            this.f678b = animation;
        }
    }

    C0160r() {
    }

    private void m1045a(C0159a c0159a) {
        this.f681c = c0159a.f678b;
        View a = m1048a();
        if (a != null) {
            a.startAnimation(this.f681c);
        }
    }

    private void m1046c() {
        View a = m1048a();
        int size = this.f679a.size();
        for (int i = 0; i < size; i++) {
            if (a.getAnimation() == ((C0159a) this.f679a.get(i)).f678b) {
                a.clearAnimation();
            }
        }
        this.f682d = null;
        this.f680b = null;
        this.f681c = null;
    }

    private void m1047d() {
        if (this.f681c != null) {
            View a = m1048a();
            if (a != null && a.getAnimation() == this.f681c) {
                a.clearAnimation();
            }
            this.f681c = null;
        }
    }

    View m1048a() {
        return this.f682d == null ? null : (View) this.f682d.get();
    }

    void m1049a(View view) {
        View a = m1048a();
        if (a != view) {
            if (a != null) {
                m1046c();
            }
            if (view != null) {
                this.f682d = new WeakReference(view);
            }
        }
    }

    void m1050a(int[] iArr) {
        C0159a c0159a = null;
        int size = this.f679a.size();
        for (int i = 0; i < size; i++) {
            C0159a c0159a2 = (C0159a) this.f679a.get(i);
            if (StateSet.stateSetMatches(c0159a2.f677a, iArr)) {
                c0159a = c0159a2;
                break;
            }
        }
        if (c0159a != this.f680b) {
            if (this.f680b != null) {
                m1047d();
            }
            this.f680b = c0159a;
            View view = (View) this.f682d.get();
            if (c0159a != null && view != null && view.getVisibility() == 0) {
                m1045a(c0159a);
            }
        }
    }

    public void m1051a(int[] iArr, Animation animation) {
        C0159a c0159a = new C0159a(iArr, animation);
        animation.setAnimationListener(this.f683e);
        this.f679a.add(c0159a);
    }

    public void m1052b() {
        if (this.f681c != null) {
            View a = m1048a();
            if (a != null && a.getAnimation() == this.f681c) {
                a.clearAnimation();
            }
        }
    }
}
