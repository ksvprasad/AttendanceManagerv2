package android.support.v7.widget;

import android.support.v7.widget.RecyclerView.C0761i;
import android.support.v7.widget.RecyclerView.C0763h;
import android.view.View;

public abstract class as {
    protected final C0763h f2493a;
    private int f2494b;

    private as(C0763h c0763h) {
        this.f2494b = Integer.MIN_VALUE;
        this.f2493a = c0763h;
    }

    public static as m5081a(C0763h c0763h) {
        return new as(c0763h) {
            public int mo807a(View view) {
                return this.a.m4185h(view) - ((C0761i) view.getLayoutParams()).leftMargin;
            }

            public void mo808a(int i) {
                this.a.mo768i(i);
            }

            public int mo809b(View view) {
                C0761i c0761i = (C0761i) view.getLayoutParams();
                return c0761i.rightMargin + this.a.m4189j(view);
            }

            public int mo810c() {
                return this.a.m4209y();
            }

            public int mo811c(View view) {
                C0761i c0761i = (C0761i) view.getLayoutParams();
                return c0761i.rightMargin + (this.a.m4179f(view) + c0761i.leftMargin);
            }

            public int mo812d() {
                return this.a.m4207w() - this.a.m4091A();
            }

            public int mo813d(View view) {
                C0761i c0761i = (C0761i) view.getLayoutParams();
                return c0761i.bottomMargin + (this.a.m4183g(view) + c0761i.topMargin);
            }

            public int mo814e() {
                return this.a.m4207w();
            }

            public int mo815f() {
                return (this.a.m4207w() - this.a.m4209y()) - this.a.m4091A();
            }

            public int mo816g() {
                return this.a.m4091A();
            }

            public int mo817h() {
                return this.a.m4205u();
            }

            public int mo818i() {
                return this.a.m4206v();
            }
        };
    }

    public static as m5082a(C0763h c0763h, int i) {
        switch (i) {
            case 0:
                return m5081a(c0763h);
            case 1:
                return m5083b(c0763h);
            default:
                throw new IllegalArgumentException("invalid orientation");
        }
    }

    public static as m5083b(C0763h c0763h) {
        return new as(c0763h) {
            public int mo807a(View view) {
                return this.a.m4187i(view) - ((C0761i) view.getLayoutParams()).topMargin;
            }

            public void mo808a(int i) {
                this.a.mo769j(i);
            }

            public int mo809b(View view) {
                C0761i c0761i = (C0761i) view.getLayoutParams();
                return c0761i.bottomMargin + this.a.m4191k(view);
            }

            public int mo810c() {
                return this.a.m4210z();
            }

            public int mo811c(View view) {
                C0761i c0761i = (C0761i) view.getLayoutParams();
                return c0761i.bottomMargin + (this.a.m4183g(view) + c0761i.topMargin);
            }

            public int mo812d() {
                return this.a.m4208x() - this.a.m4092B();
            }

            public int mo813d(View view) {
                C0761i c0761i = (C0761i) view.getLayoutParams();
                return c0761i.rightMargin + (this.a.m4179f(view) + c0761i.leftMargin);
            }

            public int mo814e() {
                return this.a.m4208x();
            }

            public int mo815f() {
                return (this.a.m4208x() - this.a.m4210z()) - this.a.m4092B();
            }

            public int mo816g() {
                return this.a.m4092B();
            }

            public int mo817h() {
                return this.a.m4206v();
            }

            public int mo818i() {
                return this.a.m4205u();
            }
        };
    }

    public abstract int mo807a(View view);

    public void m5085a() {
        this.f2494b = mo815f();
    }

    public abstract void mo808a(int i);

    public int m5087b() {
        return Integer.MIN_VALUE == this.f2494b ? 0 : mo815f() - this.f2494b;
    }

    public abstract int mo809b(View view);

    public abstract int mo810c();

    public abstract int mo811c(View view);

    public abstract int mo812d();

    public abstract int mo813d(View view);

    public abstract int mo814e();

    public abstract int mo815f();

    public abstract int mo816g();

    public abstract int mo817h();

    public abstract int mo818i();
}
