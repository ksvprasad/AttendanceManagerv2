package android.support.v7.view.menu;

import android.content.Context;
import android.support.v4.view.ag;
import android.support.v7.view.menu.C0052m.C0050a;
import android.support.v7.view.menu.C0721l.C0654a;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

public abstract class C0722b implements C0721l {
    protected Context f1816a;
    protected Context f1817b;
    protected C0727f f1818c;
    protected LayoutInflater f1819d;
    protected LayoutInflater f1820e;
    protected C0052m f1821f;
    private C0654a f1822g;
    private int f1823h;
    private int f1824i;
    private int f1825j;

    public C0722b(Context context, int i, int i2) {
        this.f1816a = context;
        this.f1819d = LayoutInflater.from(context);
        this.f1823h = i;
        this.f1824i = i2;
    }

    public C0654a m3762a() {
        return this.f1822g;
    }

    public C0052m mo859a(ViewGroup viewGroup) {
        if (this.f1821f == null) {
            this.f1821f = (C0052m) this.f1819d.inflate(this.f1823h, viewGroup, false);
            this.f1821f.mo37a(this.f1818c);
            mo640b(true);
        }
        return this.f1821f;
    }

    public View mo860a(C0730h c0730h, View view, ViewGroup viewGroup) {
        C0050a b = view instanceof C0050a ? (C0050a) view : m3775b(viewGroup);
        mo861a(c0730h, b);
        return (View) b;
    }

    public void m3765a(int i) {
        this.f1825j = i;
    }

    public void mo636a(Context context, C0727f c0727f) {
        this.f1817b = context;
        this.f1820e = LayoutInflater.from(this.f1817b);
        this.f1818c = c0727f;
    }

    public void mo637a(C0727f c0727f, boolean z) {
        if (this.f1822g != null) {
            this.f1822g.mo570a(c0727f, z);
        }
    }

    public abstract void mo861a(C0730h c0730h, C0050a c0050a);

    public void m3769a(C0654a c0654a) {
        this.f1822g = c0654a;
    }

    protected void m3770a(View view, int i) {
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        if (viewGroup != null) {
            viewGroup.removeView(view);
        }
        ((ViewGroup) this.f1821f).addView(view, i);
    }

    public boolean mo863a(int i, C0730h c0730h) {
        return true;
    }

    public boolean mo638a(C0727f c0727f, C0730h c0730h) {
        return false;
    }

    public boolean mo639a(C0742p c0742p) {
        return this.f1822g != null ? this.f1822g.mo571a(c0742p) : false;
    }

    protected boolean mo864a(ViewGroup viewGroup, int i) {
        viewGroup.removeViewAt(i);
        return true;
    }

    public C0050a m3775b(ViewGroup viewGroup) {
        return (C0050a) this.f1819d.inflate(this.f1824i, viewGroup, false);
    }

    public void mo640b(boolean z) {
        ViewGroup viewGroup = (ViewGroup) this.f1821f;
        if (viewGroup != null) {
            int i;
            if (this.f1818c != null) {
                this.f1818c.m3841j();
                ArrayList i2 = this.f1818c.m3840i();
                int size = i2.size();
                int i3 = 0;
                i = 0;
                while (i3 < size) {
                    int i4;
                    C0730h c0730h = (C0730h) i2.get(i3);
                    if (mo863a(i, c0730h)) {
                        View childAt = viewGroup.getChildAt(i);
                        C0730h itemData = childAt instanceof C0050a ? ((C0050a) childAt).getItemData() : null;
                        View a = mo860a(c0730h, childAt, viewGroup);
                        if (c0730h != itemData) {
                            a.setPressed(false);
                            ag.m2553u(a);
                        }
                        if (a != childAt) {
                            m3770a(a, i);
                        }
                        i4 = i + 1;
                    } else {
                        i4 = i;
                    }
                    i3++;
                    i = i4;
                }
            } else {
                i = 0;
            }
            while (i < viewGroup.getChildCount()) {
                if (!mo864a(viewGroup, i)) {
                    i++;
                }
            }
        }
    }

    public boolean mo641b() {
        return false;
    }

    public boolean mo642b(C0727f c0727f, C0730h c0730h) {
        return false;
    }
}
