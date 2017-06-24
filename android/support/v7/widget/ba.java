package android.support.v7.widget;

import android.support.v7.widget.RecyclerView.C0785e;
import android.support.v7.widget.RecyclerView.C0785e.C0784c;
import android.support.v7.widget.RecyclerView.C0801u;
import android.view.View;

public abstract class ba extends C0785e {
    boolean f2412a = true;

    public final void m4963a(C0801u c0801u, boolean z) {
        m4974d(c0801u, z);
        m4431e(c0801u);
    }

    public abstract boolean mo794a(C0801u c0801u);

    public abstract boolean mo795a(C0801u c0801u, int i, int i2, int i3, int i4);

    public boolean mo788a(C0801u c0801u, C0784c c0784c, C0784c c0784c2) {
        int i = c0784c.f2122a;
        int i2 = c0784c.f2123b;
        View view = c0801u.f2183a;
        int left = c0784c2 == null ? view.getLeft() : c0784c2.f2122a;
        int top = c0784c2 == null ? view.getTop() : c0784c2.f2123b;
        if (c0801u.m4590q() || (i == left && i2 == top)) {
            return mo794a(c0801u);
        }
        view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
        return mo795a(c0801u, i, i2, left, top);
    }

    public abstract boolean mo796a(C0801u c0801u, C0801u c0801u2, int i, int i2, int i3, int i4);

    public boolean mo789a(C0801u c0801u, C0801u c0801u2, C0784c c0784c, C0784c c0784c2) {
        int i;
        int i2;
        int i3 = c0784c.f2122a;
        int i4 = c0784c.f2123b;
        if (c0801u2.m4576c()) {
            i = c0784c.f2122a;
            i2 = c0784c.f2123b;
        } else {
            i = c0784c2.f2122a;
            i2 = c0784c2.f2123b;
        }
        return mo796a(c0801u, c0801u2, i3, i4, i, i2);
    }

    public final void m4969b(C0801u c0801u, boolean z) {
        m4972c(c0801u, z);
    }

    public abstract boolean mo799b(C0801u c0801u);

    public boolean mo790b(C0801u c0801u, C0784c c0784c, C0784c c0784c2) {
        if (c0784c == null || (c0784c.f2122a == c0784c2.f2122a && c0784c.f2123b == c0784c2.f2123b)) {
            return mo799b(c0801u);
        }
        return mo795a(c0801u, c0784c.f2122a, c0784c.f2123b, c0784c2.f2122a, c0784c2.f2123b);
    }

    public void m4972c(C0801u c0801u, boolean z) {
    }

    public boolean mo791c(C0801u c0801u, C0784c c0784c, C0784c c0784c2) {
        if (c0784c.f2122a == c0784c2.f2122a && c0784c.f2123b == c0784c2.f2123b) {
            m4977i(c0801u);
            return false;
        }
        return mo795a(c0801u, c0784c.f2122a, c0784c.f2123b, c0784c2.f2122a, c0784c2.f2123b);
    }

    public void m4974d(C0801u c0801u, boolean z) {
    }

    public boolean mo792g(C0801u c0801u) {
        return !this.f2412a || c0801u.m4587n();
    }

    public final void m4976h(C0801u c0801u) {
        m4983o(c0801u);
        m4431e(c0801u);
    }

    public final void m4977i(C0801u c0801u) {
        m4987s(c0801u);
        m4431e(c0801u);
    }

    public final void m4978j(C0801u c0801u) {
        m4985q(c0801u);
        m4431e(c0801u);
    }

    public final void m4979k(C0801u c0801u) {
        m4982n(c0801u);
    }

    public final void m4980l(C0801u c0801u) {
        m4986r(c0801u);
    }

    public final void m4981m(C0801u c0801u) {
        m4984p(c0801u);
    }

    public void m4982n(C0801u c0801u) {
    }

    public void m4983o(C0801u c0801u) {
    }

    public void m4984p(C0801u c0801u) {
    }

    public void m4985q(C0801u c0801u) {
    }

    public void m4986r(C0801u c0801u) {
    }

    public void m4987s(C0801u c0801u) {
    }
}
