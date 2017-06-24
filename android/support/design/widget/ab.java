package android.support.design.widget;

import android.support.v4.view.ag;
import android.view.View;

class ab {
    private final View f541a;
    private int f542b;
    private int f543c;
    private int f544d;
    private int f545e;

    public ab(View view) {
        this.f541a = view;
    }

    private void m880c() {
        ag.m2536e(this.f541a, this.f544d - (this.f541a.getTop() - this.f542b));
        ag.m2538f(this.f541a, this.f545e - (this.f541a.getLeft() - this.f543c));
    }

    public void m881a() {
        this.f542b = this.f541a.getTop();
        this.f543c = this.f541a.getLeft();
        m880c();
    }

    public boolean m882a(int i) {
        if (this.f544d == i) {
            return false;
        }
        this.f544d = i;
        m880c();
        return true;
    }

    public int m883b() {
        return this.f544d;
    }

    public boolean m884b(int i) {
        if (this.f545e == i) {
            return false;
        }
        this.f545e = i;
        m880c();
        return true;
    }
}
