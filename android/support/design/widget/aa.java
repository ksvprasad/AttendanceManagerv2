package android.support.design.widget;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout.C0059b;
import android.util.AttributeSet;
import android.view.View;

class aa<V extends View> extends C0059b<V> {
    private ab f249a;
    private int f250b = 0;
    private int f251c = 0;

    public aa(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public boolean mo53a(int i) {
        if (this.f249a != null) {
            return this.f249a.m882a(i);
        }
        this.f250b = i;
        return false;
    }

    public boolean mo42a(CoordinatorLayout coordinatorLayout, V v, int i) {
        mo61b(coordinatorLayout, v, i);
        if (this.f249a == null) {
            this.f249a = new ab(v);
        }
        this.f249a.m881a();
        if (this.f250b != 0) {
            this.f249a.m882a(this.f250b);
            this.f250b = 0;
        }
        if (this.f251c != 0) {
            this.f249a.m884b(this.f251c);
            this.f251c = 0;
        }
        return true;
    }

    public int mo57b() {
        return this.f249a != null ? this.f249a.m883b() : 0;
    }

    protected void mo61b(CoordinatorLayout coordinatorLayout, V v, int i) {
        coordinatorLayout.m592a((View) v, i);
    }
}
