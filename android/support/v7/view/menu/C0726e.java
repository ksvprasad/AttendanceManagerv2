package android.support.v7.view.menu;

import android.content.Context;
import android.support.v7.p019b.C0694a.C0690h;
import android.support.v7.view.menu.C0052m.C0050a;
import android.support.v7.view.menu.C0721l.C0654a;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import java.util.ArrayList;

public class C0726e implements C0721l, OnItemClickListener {
    Context f1832a;
    LayoutInflater f1833b;
    C0727f f1834c;
    ExpandedMenuView f1835d;
    int f1836e;
    int f1837f;
    C0725a f1838g;
    private int f1839h;
    private C0654a f1840i;

    private class C0725a extends BaseAdapter {
        final /* synthetic */ C0726e f1830a;
        private int f1831b = -1;

        public C0725a(C0726e c0726e) {
            this.f1830a = c0726e;
            m3785a();
        }

        public C0730h m3784a(int i) {
            ArrayList l = this.f1830a.f1834c.m3843l();
            int a = this.f1830a.f1839h + i;
            if (this.f1831b >= 0 && a >= this.f1831b) {
                a++;
            }
            return (C0730h) l.get(a);
        }

        void m3785a() {
            C0730h r = this.f1830a.f1834c.m3849r();
            if (r != null) {
                ArrayList l = this.f1830a.f1834c.m3843l();
                int size = l.size();
                for (int i = 0; i < size; i++) {
                    if (((C0730h) l.get(i)) == r) {
                        this.f1831b = i;
                        return;
                    }
                }
            }
            this.f1831b = -1;
        }

        public int getCount() {
            int size = this.f1830a.f1834c.m3843l().size() - this.f1830a.f1839h;
            return this.f1831b < 0 ? size : size - 1;
        }

        public /* synthetic */ Object getItem(int i) {
            return m3784a(i);
        }

        public long getItemId(int i) {
            return (long) i;
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            View inflate = view == null ? this.f1830a.f1833b.inflate(this.f1830a.f1837f, viewGroup, false) : view;
            ((C0050a) inflate).mo27a(m3784a(i), 0);
            return inflate;
        }

        public void notifyDataSetChanged() {
            m3785a();
            super.notifyDataSetChanged();
        }
    }

    public C0726e(int i, int i2) {
        this.f1837f = i;
        this.f1836e = i2;
    }

    public C0726e(Context context, int i) {
        this(i, 0);
        this.f1832a = context;
        this.f1833b = LayoutInflater.from(this.f1832a);
    }

    public C0052m m3787a(ViewGroup viewGroup) {
        if (this.f1835d == null) {
            this.f1835d = (ExpandedMenuView) this.f1833b.inflate(C0690h.abc_expanded_menu_layout, viewGroup, false);
            if (this.f1838g == null) {
                this.f1838g = new C0725a(this);
            }
            this.f1835d.setAdapter(this.f1838g);
            this.f1835d.setOnItemClickListener(this);
        }
        return this.f1835d;
    }

    public ListAdapter m3788a() {
        if (this.f1838g == null) {
            this.f1838g = new C0725a(this);
        }
        return this.f1838g;
    }

    public void mo636a(Context context, C0727f c0727f) {
        if (this.f1836e != 0) {
            this.f1832a = new ContextThemeWrapper(context, this.f1836e);
            this.f1833b = LayoutInflater.from(this.f1832a);
        } else if (this.f1832a != null) {
            this.f1832a = context;
            if (this.f1833b == null) {
                this.f1833b = LayoutInflater.from(this.f1832a);
            }
        }
        this.f1834c = c0727f;
        if (this.f1838g != null) {
            this.f1838g.notifyDataSetChanged();
        }
    }

    public void mo637a(C0727f c0727f, boolean z) {
        if (this.f1840i != null) {
            this.f1840i.mo570a(c0727f, z);
        }
    }

    public void m3791a(C0654a c0654a) {
        this.f1840i = c0654a;
    }

    public boolean mo638a(C0727f c0727f, C0730h c0730h) {
        return false;
    }

    public boolean mo639a(C0742p c0742p) {
        if (!c0742p.hasVisibleItems()) {
            return false;
        }
        new C0728g(c0742p).m3851a(null);
        if (this.f1840i != null) {
            this.f1840i.mo571a(c0742p);
        }
        return true;
    }

    public void mo640b(boolean z) {
        if (this.f1838g != null) {
            this.f1838g.notifyDataSetChanged();
        }
    }

    public boolean mo641b() {
        return false;
    }

    public boolean mo642b(C0727f c0727f, C0730h c0730h) {
        return false;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.f1834c.m3823a(this.f1838g.m3784a(i), (C0721l) this, 0);
    }
}
