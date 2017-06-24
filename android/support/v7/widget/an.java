package android.support.v7.widget;

import android.support.v7.widget.RecyclerView.C0793n;
import android.support.v7.widget.RecyclerView.C0798r;
import android.view.View;

class an {
    boolean f2426a = true;
    int f2427b;
    int f2428c;
    int f2429d;
    int f2430e;
    int f2431f = 0;
    int f2432g = 0;
    boolean f2433h;
    boolean f2434i;

    an() {
    }

    View m5022a(C0793n c0793n) {
        View c = c0793n.m4480c(this.f2428c);
        this.f2428c += this.f2429d;
        return c;
    }

    boolean m5023a(C0798r c0798r) {
        return this.f2428c >= 0 && this.f2428c < c0798r.m4540e();
    }

    public String toString() {
        return "LayoutState{mAvailable=" + this.f2427b + ", mCurrentPosition=" + this.f2428c + ", mItemDirection=" + this.f2429d + ", mLayoutDirection=" + this.f2430e + ", mStartLine=" + this.f2431f + ", mEndLine=" + this.f2432g + '}';
    }
}
