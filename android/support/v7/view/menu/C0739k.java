package android.support.v7.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.p019b.C0694a.C0683a;
import android.support.v7.p019b.C0694a.C0686d;
import android.support.v7.p019b.C0694a.C0690h;
import android.support.v7.view.menu.C0052m.C0050a;
import android.support.v7.view.menu.C0721l.C0654a;
import android.support.v7.widget.ap;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnKeyListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.PopupWindow.OnDismissListener;
import java.util.ArrayList;

public class C0739k implements C0721l, OnKeyListener, OnGlobalLayoutListener, OnItemClickListener, OnDismissListener {
    static final int f1908a = C0690h.abc_popup_menu_item_layout;
    boolean f1909b;
    private final Context f1910c;
    private final LayoutInflater f1911d;
    private final C0727f f1912e;
    private final C0738a f1913f;
    private final boolean f1914g;
    private final int f1915h;
    private final int f1916i;
    private final int f1917j;
    private View f1918k;
    private ap f1919l;
    private ViewTreeObserver f1920m;
    private C0654a f1921n;
    private ViewGroup f1922o;
    private boolean f1923p;
    private int f1924q;
    private int f1925r;

    private class C0738a extends BaseAdapter {
        final /* synthetic */ C0739k f1905a;
        private C0727f f1906b;
        private int f1907c = -1;

        public C0738a(C0739k c0739k, C0727f c0727f) {
            this.f1905a = c0739k;
            this.f1906b = c0727f;
            m3901a();
        }

        public C0730h m3900a(int i) {
            ArrayList l = this.f1905a.f1914g ? this.f1906b.m3843l() : this.f1906b.m3840i();
            if (this.f1907c >= 0 && i >= this.f1907c) {
                i++;
            }
            return (C0730h) l.get(i);
        }

        void m3901a() {
            C0730h r = this.f1905a.f1912e.m3849r();
            if (r != null) {
                ArrayList l = this.f1905a.f1912e.m3843l();
                int size = l.size();
                for (int i = 0; i < size; i++) {
                    if (((C0730h) l.get(i)) == r) {
                        this.f1907c = i;
                        return;
                    }
                }
            }
            this.f1907c = -1;
        }

        public int getCount() {
            ArrayList l = this.f1905a.f1914g ? this.f1906b.m3843l() : this.f1906b.m3840i();
            return this.f1907c < 0 ? l.size() : l.size() - 1;
        }

        public /* synthetic */ Object getItem(int i) {
            return m3900a(i);
        }

        public long getItemId(int i) {
            return (long) i;
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            View inflate = view == null ? this.f1905a.f1911d.inflate(C0739k.f1908a, viewGroup, false) : view;
            C0050a c0050a = (C0050a) inflate;
            if (this.f1905a.f1909b) {
                ((ListMenuItemView) inflate).setForceShowIcon(true);
            }
            c0050a.mo27a(m3900a(i), 0);
            return inflate;
        }

        public void notifyDataSetChanged() {
            m3901a();
            super.notifyDataSetChanged();
        }
    }

    public C0739k(Context context, C0727f c0727f, View view) {
        this(context, c0727f, view, false, C0683a.popupMenuStyle);
    }

    public C0739k(Context context, C0727f c0727f, View view, boolean z, int i) {
        this(context, c0727f, view, z, i, 0);
    }

    public C0739k(Context context, C0727f c0727f, View view, boolean z, int i, int i2) {
        this.f1925r = 0;
        this.f1910c = context;
        this.f1911d = LayoutInflater.from(context);
        this.f1912e = c0727f;
        this.f1913f = new C0738a(this, this.f1912e);
        this.f1914g = z;
        this.f1916i = i;
        this.f1917j = i2;
        Resources resources = context.getResources();
        this.f1915h = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(C0686d.abc_config_prefDialogWidth));
        this.f1918k = view;
        c0727f.m3817a((C0721l) this, context);
    }

    private int m3905g() {
        ListAdapter listAdapter = this.f1913f;
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
        int makeMeasureSpec2 = MeasureSpec.makeMeasureSpec(0, 0);
        int count = listAdapter.getCount();
        int i = 0;
        int i2 = 0;
        View view = null;
        int i3 = 0;
        while (i < count) {
            View view2;
            int itemViewType = listAdapter.getItemViewType(i);
            if (itemViewType != i2) {
                i2 = itemViewType;
                view2 = null;
            } else {
                view2 = view;
            }
            if (this.f1922o == null) {
                this.f1922o = new FrameLayout(this.f1910c);
            }
            view = listAdapter.getView(i, view2, this.f1922o);
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            itemViewType = view.getMeasuredWidth();
            if (itemViewType >= this.f1915h) {
                return this.f1915h;
            }
            if (itemViewType <= i3) {
                itemViewType = i3;
            }
            i++;
            i3 = itemViewType;
        }
        return i3;
    }

    public void m3906a() {
        if (!m3919d()) {
            throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
        }
    }

    public void m3907a(int i) {
        this.f1925r = i;
    }

    public void mo636a(Context context, C0727f c0727f) {
    }

    public void mo637a(C0727f c0727f, boolean z) {
        if (c0727f == this.f1912e) {
            m3920e();
            if (this.f1921n != null) {
                this.f1921n.mo570a(c0727f, z);
            }
        }
    }

    public void m3910a(C0654a c0654a) {
        this.f1921n = c0654a;
    }

    public void m3911a(View view) {
        this.f1918k = view;
    }

    public void m3912a(boolean z) {
        this.f1909b = z;
    }

    public boolean mo638a(C0727f c0727f, C0730h c0730h) {
        return false;
    }

    public boolean mo639a(C0742p c0742p) {
        if (c0742p.hasVisibleItems()) {
            boolean z;
            C0739k c0739k = new C0739k(this.f1910c, c0742p, this.f1918k);
            c0739k.m3910a(this.f1921n);
            int size = c0742p.size();
            for (int i = 0; i < size; i++) {
                MenuItem item = c0742p.getItem(i);
                if (item.isVisible() && item.getIcon() != null) {
                    z = true;
                    break;
                }
            }
            z = false;
            c0739k.m3912a(z);
            if (c0739k.m3919d()) {
                if (this.f1921n == null) {
                    return true;
                }
                this.f1921n.mo571a(c0742p);
                return true;
            }
        }
        return false;
    }

    public void mo640b(boolean z) {
        this.f1923p = false;
        if (this.f1913f != null) {
            this.f1913f.notifyDataSetChanged();
        }
    }

    public boolean mo641b() {
        return false;
    }

    public boolean mo642b(C0727f c0727f, C0730h c0730h) {
        return false;
    }

    public ap m3918c() {
        return this.f1919l;
    }

    public boolean m3919d() {
        boolean z = false;
        this.f1919l = new ap(this.f1910c, null, this.f1916i, this.f1917j);
        this.f1919l.m5052a((OnDismissListener) this);
        this.f1919l.m5050a((OnItemClickListener) this);
        this.f1919l.mo872a(this.f1913f);
        this.f1919l.m5053a(true);
        View view = this.f1918k;
        if (view == null) {
            return false;
        }
        if (this.f1920m == null) {
            z = true;
        }
        this.f1920m = view.getViewTreeObserver();
        if (z) {
            this.f1920m.addOnGlobalLayoutListener(this);
        }
        this.f1919l.m5049a(view);
        this.f1919l.m5058d(this.f1925r);
        if (!this.f1923p) {
            this.f1924q = m3905g();
            this.f1923p = true;
        }
        this.f1919l.m5062f(this.f1924q);
        this.f1919l.m5064g(2);
        this.f1919l.mo874c();
        this.f1919l.m5071m().setOnKeyListener(this);
        return true;
    }

    public void m3920e() {
        if (m3921f()) {
            this.f1919l.m5067i();
        }
    }

    public boolean m3921f() {
        return this.f1919l != null && this.f1919l.m5069k();
    }

    public void onDismiss() {
        this.f1919l = null;
        this.f1912e.close();
        if (this.f1920m != null) {
            if (!this.f1920m.isAlive()) {
                this.f1920m = this.f1918k.getViewTreeObserver();
            }
            this.f1920m.removeGlobalOnLayoutListener(this);
            this.f1920m = null;
        }
    }

    public void onGlobalLayout() {
        if (m3921f()) {
            View view = this.f1918k;
            if (view == null || !view.isShown()) {
                m3920e();
            } else if (m3921f()) {
                this.f1919l.mo874c();
            }
        }
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        C0738a c0738a = this.f1913f;
        c0738a.f1906b.m3822a(c0738a.m3900a(i), 0);
    }

    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i != 82) {
            return false;
        }
        m3920e();
        return true;
    }
}
