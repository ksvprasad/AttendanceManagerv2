package android.support.v7.widget;

import android.support.v4.p009a.C0182a;
import android.support.v4.view.ag;
import android.support.v4.view.aw;
import android.support.v4.view.ba;
import android.support.v7.widget.RecyclerView.C0801u;
import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ak extends ba {
    private ArrayList<C0801u> f2413b = new ArrayList();
    private ArrayList<C0801u> f2414c = new ArrayList();
    private ArrayList<C0837b> f2415d = new ArrayList();
    private ArrayList<C0836a> f2416e = new ArrayList();
    private ArrayList<ArrayList<C0801u>> f2417f = new ArrayList();
    private ArrayList<ArrayList<C0837b>> f2418g = new ArrayList();
    private ArrayList<ArrayList<C0836a>> f2419h = new ArrayList();
    private ArrayList<C0801u> f2420i = new ArrayList();
    private ArrayList<C0801u> f2421j = new ArrayList();
    private ArrayList<C0801u> f2422k = new ArrayList();
    private ArrayList<C0801u> f2423l = new ArrayList();

    private static class C0830c implements ba {
        private C0830c() {
        }

        public void mo98a(View view) {
        }

        public void mo99b(View view) {
        }

        public void mo100c(View view) {
        }
    }

    private static class C0836a {
        public C0801u f2401a;
        public C0801u f2402b;
        public int f2403c;
        public int f2404d;
        public int f2405e;
        public int f2406f;

        private C0836a(C0801u c0801u, C0801u c0801u2) {
            this.f2401a = c0801u;
            this.f2402b = c0801u2;
        }

        private C0836a(C0801u c0801u, C0801u c0801u2, int i, int i2, int i3, int i4) {
            this(c0801u, c0801u2);
            this.f2403c = i;
            this.f2404d = i2;
            this.f2405e = i3;
            this.f2406f = i4;
        }

        public String toString() {
            return "ChangeInfo{oldHolder=" + this.f2401a + ", newHolder=" + this.f2402b + ", fromX=" + this.f2403c + ", fromY=" + this.f2404d + ", toX=" + this.f2405e + ", toY=" + this.f2406f + '}';
        }
    }

    private static class C0837b {
        public C0801u f2407a;
        public int f2408b;
        public int f2409c;
        public int f2410d;
        public int f2411e;

        private C0837b(C0801u c0801u, int i, int i2, int i3, int i4) {
            this.f2407a = c0801u;
            this.f2408b = i;
            this.f2409c = i2;
            this.f2410d = i3;
            this.f2411e = i4;
        }
    }

    private void m4989a(final C0836a c0836a) {
        View view = null;
        C0801u c0801u = c0836a.f2401a;
        View view2 = c0801u == null ? null : c0801u.f2183a;
        C0801u c0801u2 = c0836a.f2402b;
        if (c0801u2 != null) {
            view = c0801u2.f2183a;
        }
        if (view2 != null) {
            final aw a = ag.m2549q(view2).m2728a(m4434g());
            this.f2423l.add(c0836a.f2401a);
            a.m2732b((float) (c0836a.f2405e - c0836a.f2403c));
            a.m2735c((float) (c0836a.f2406f - c0836a.f2404d));
            a.m2727a(0.0f).m2729a(new C0830c(this) {
                final /* synthetic */ ak f2396c;

                public void mo98a(View view) {
                    this.f2396c.m4969b(c0836a.f2401a, true);
                }

                public void mo99b(View view) {
                    a.m2729a(null);
                    ag.m2528c(view, 1.0f);
                    ag.m2511a(view, 0.0f);
                    ag.m2524b(view, 0.0f);
                    this.f2396c.m4963a(c0836a.f2401a, true);
                    this.f2396c.f2423l.remove(c0836a.f2401a);
                    this.f2396c.m5004j();
                }
            }).m2736c();
        }
        if (view != null) {
            a = ag.m2549q(view);
            this.f2423l.add(c0836a.f2402b);
            a.m2732b(0.0f).m2735c(0.0f).m2728a(m4434g()).m2727a(1.0f).m2729a(new C0830c(this) {
                final /* synthetic */ ak f2400d;

                public void mo98a(View view) {
                    this.f2400d.m4969b(c0836a.f2402b, false);
                }

                public void mo99b(View view) {
                    a.m2729a(null);
                    ag.m2528c(view, 1.0f);
                    ag.m2511a(view, 0.0f);
                    ag.m2524b(view, 0.0f);
                    this.f2400d.m4963a(c0836a.f2402b, false);
                    this.f2400d.f2423l.remove(c0836a.f2402b);
                    this.f2400d.m5004j();
                }
            }).m2736c();
        }
    }

    private void m4993a(List<C0836a> list, C0801u c0801u) {
        for (int size = list.size() - 1; size >= 0; size--) {
            C0836a c0836a = (C0836a) list.get(size);
            if (m4994a(c0836a, c0801u) && c0836a.f2401a == null && c0836a.f2402b == null) {
                list.remove(c0836a);
            }
        }
    }

    private boolean m4994a(C0836a c0836a, C0801u c0801u) {
        boolean z = false;
        if (c0836a.f2402b == c0801u) {
            c0836a.f2402b = null;
        } else if (c0836a.f2401a != c0801u) {
            return false;
        } else {
            c0836a.f2401a = null;
            z = true;
        }
        ag.m2528c(c0801u.f2183a, 1.0f);
        ag.m2511a(c0801u.f2183a, 0.0f);
        ag.m2524b(c0801u.f2183a, 0.0f);
        m4963a(c0801u, z);
        return true;
    }

    private void m4996b(C0801u c0801u, int i, int i2, int i3, int i4) {
        View view = c0801u.f2183a;
        final int i5 = i3 - i;
        final int i6 = i4 - i2;
        if (i5 != 0) {
            ag.m2549q(view).m2732b(0.0f);
        }
        if (i6 != 0) {
            ag.m2549q(view).m2735c(0.0f);
        }
        final aw q = ag.m2549q(view);
        this.f2421j.add(c0801u);
        final C0801u c0801u2 = c0801u;
        q.m2728a(m4429d()).m2729a(new C0830c(this) {
            final /* synthetic */ ak f2393e;

            public void mo98a(View view) {
                this.f2393e.m4980l(c0801u2);
            }

            public void mo99b(View view) {
                q.m2729a(null);
                this.f2393e.m4977i(c0801u2);
                this.f2393e.f2421j.remove(c0801u2);
                this.f2393e.m5004j();
            }

            public void mo100c(View view) {
                if (i5 != 0) {
                    ag.m2511a(view, 0.0f);
                }
                if (i6 != 0) {
                    ag.m2524b(view, 0.0f);
                }
            }
        }).m2736c();
    }

    private void m4997b(C0836a c0836a) {
        if (c0836a.f2401a != null) {
            m4994a(c0836a, c0836a.f2401a);
        }
        if (c0836a.f2402b != null) {
            m4994a(c0836a, c0836a.f2402b);
        }
    }

    private void m5004j() {
        if (!mo798b()) {
            m4436h();
        }
    }

    private void m5005t(final C0801u c0801u) {
        final aw q = ag.m2549q(c0801u.f2183a);
        this.f2422k.add(c0801u);
        q.m2728a(m4432f()).m2727a(0.0f).m2729a(new C0830c(this) {
            final /* synthetic */ ak f2385c;

            public void mo98a(View view) {
                this.f2385c.m4979k(c0801u);
            }

            public void mo99b(View view) {
                q.m2729a(null);
                ag.m2528c(view, 1.0f);
                this.f2385c.m4976h(c0801u);
                this.f2385c.f2422k.remove(c0801u);
                this.f2385c.m5004j();
            }
        }).m2736c();
    }

    private void m5006u(final C0801u c0801u) {
        final aw q = ag.m2549q(c0801u.f2183a);
        this.f2420i.add(c0801u);
        q.m2727a(1.0f).m2728a(m4430e()).m2729a(new C0830c(this) {
            final /* synthetic */ ak f2388c;

            public void mo98a(View view) {
                this.f2388c.m4981m(c0801u);
            }

            public void mo99b(View view) {
                q.m2729a(null);
                this.f2388c.m4978j(c0801u);
                this.f2388c.f2420i.remove(c0801u);
                this.f2388c.m5004j();
            }

            public void mo100c(View view) {
                ag.m2528c(view, 1.0f);
            }
        }).m2736c();
    }

    private void m5007v(C0801u c0801u) {
        C0182a.m1123a(c0801u.f2183a);
        mo801c(c0801u);
    }

    public void mo793a() {
        int i = !this.f2413b.isEmpty() ? 1 : 0;
        int i2 = !this.f2415d.isEmpty() ? 1 : 0;
        int i3 = !this.f2416e.isEmpty() ? 1 : 0;
        int i4 = !this.f2414c.isEmpty() ? 1 : 0;
        if (i != 0 || i2 != 0 || i4 != 0 || i3 != 0) {
            final ArrayList arrayList;
            Runnable c08271;
            Iterator it = this.f2413b.iterator();
            while (it.hasNext()) {
                m5005t((C0801u) it.next());
            }
            this.f2413b.clear();
            if (i2 != 0) {
                arrayList = new ArrayList();
                arrayList.addAll(this.f2415d);
                this.f2418g.add(arrayList);
                this.f2415d.clear();
                c08271 = new Runnable(this) {
                    final /* synthetic */ ak f2378b;

                    public void run() {
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            C0837b c0837b = (C0837b) it.next();
                            this.f2378b.m4996b(c0837b.f2407a, c0837b.f2408b, c0837b.f2409c, c0837b.f2410d, c0837b.f2411e);
                        }
                        arrayList.clear();
                        this.f2378b.f2418g.remove(arrayList);
                    }
                };
                if (i != 0) {
                    ag.m2520a(((C0837b) arrayList.get(0)).f2407a.f2183a, c08271, m4432f());
                } else {
                    c08271.run();
                }
            }
            if (i3 != 0) {
                arrayList = new ArrayList();
                arrayList.addAll(this.f2416e);
                this.f2419h.add(arrayList);
                this.f2416e.clear();
                c08271 = new Runnable(this) {
                    final /* synthetic */ ak f2380b;

                    public void run() {
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            this.f2380b.m4989a((C0836a) it.next());
                        }
                        arrayList.clear();
                        this.f2380b.f2419h.remove(arrayList);
                    }
                };
                if (i != 0) {
                    ag.m2520a(((C0836a) arrayList.get(0)).f2401a.f2183a, c08271, m4432f());
                } else {
                    c08271.run();
                }
            }
            if (i4 != 0) {
                final ArrayList arrayList2 = new ArrayList();
                arrayList2.addAll(this.f2414c);
                this.f2417f.add(arrayList2);
                this.f2414c.clear();
                Runnable c08293 = new Runnable(this) {
                    final /* synthetic */ ak f2382b;

                    public void run() {
                        Iterator it = arrayList2.iterator();
                        while (it.hasNext()) {
                            this.f2382b.m5006u((C0801u) it.next());
                        }
                        arrayList2.clear();
                        this.f2382b.f2417f.remove(arrayList2);
                    }
                };
                if (i == 0 && i2 == 0 && i3 == 0) {
                    c08293.run();
                } else {
                    ag.m2520a(((C0801u) arrayList2.get(0)).f2183a, c08293, (i != 0 ? m4432f() : 0) + Math.max(i2 != 0 ? m4429d() : 0, i3 != 0 ? m4434g() : 0));
                }
            }
        }
    }

    void m5009a(List<C0801u> list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            ag.m2549q(((C0801u) list.get(size)).f2183a).m2734b();
        }
    }

    public boolean mo794a(C0801u c0801u) {
        m5007v(c0801u);
        this.f2413b.add(c0801u);
        return true;
    }

    public boolean mo795a(C0801u c0801u, int i, int i2, int i3, int i4) {
        View view = c0801u.f2183a;
        int m = (int) (((float) i) + ag.m2545m(c0801u.f2183a));
        int n = (int) (((float) i2) + ag.m2546n(c0801u.f2183a));
        m5007v(c0801u);
        int i5 = i3 - m;
        int i6 = i4 - n;
        if (i5 == 0 && i6 == 0) {
            m4977i(c0801u);
            return false;
        }
        if (i5 != 0) {
            ag.m2511a(view, (float) (-i5));
        }
        if (i6 != 0) {
            ag.m2524b(view, (float) (-i6));
        }
        this.f2415d.add(new C0837b(c0801u, m, n, i3, i4));
        return true;
    }

    public boolean mo796a(C0801u c0801u, C0801u c0801u2, int i, int i2, int i3, int i4) {
        if (c0801u == c0801u2) {
            return mo795a(c0801u, i, i2, i3, i4);
        }
        float m = ag.m2545m(c0801u.f2183a);
        float n = ag.m2546n(c0801u.f2183a);
        float f = ag.m2537f(c0801u.f2183a);
        m5007v(c0801u);
        int i5 = (int) (((float) (i3 - i)) - m);
        int i6 = (int) (((float) (i4 - i2)) - n);
        ag.m2511a(c0801u.f2183a, m);
        ag.m2524b(c0801u.f2183a, n);
        ag.m2528c(c0801u.f2183a, f);
        if (c0801u2 != null) {
            m5007v(c0801u2);
            ag.m2511a(c0801u2.f2183a, (float) (-i5));
            ag.m2524b(c0801u2.f2183a, (float) (-i6));
            ag.m2528c(c0801u2.f2183a, 0.0f);
        }
        this.f2416e.add(new C0836a(c0801u, c0801u2, i, i2, i3, i4));
        return true;
    }

    public boolean mo797a(C0801u c0801u, List<Object> list) {
        return !list.isEmpty() || super.mo797a(c0801u, (List) list);
    }

    public boolean mo798b() {
        return (this.f2414c.isEmpty() && this.f2416e.isEmpty() && this.f2415d.isEmpty() && this.f2413b.isEmpty() && this.f2421j.isEmpty() && this.f2422k.isEmpty() && this.f2420i.isEmpty() && this.f2423l.isEmpty() && this.f2418g.isEmpty() && this.f2417f.isEmpty() && this.f2419h.isEmpty()) ? false : true;
    }

    public boolean mo799b(C0801u c0801u) {
        m5007v(c0801u);
        ag.m2528c(c0801u.f2183a, 0.0f);
        this.f2414c.add(c0801u);
        return true;
    }

    public void mo800c() {
        int size;
        for (size = this.f2415d.size() - 1; size >= 0; size--) {
            C0837b c0837b = (C0837b) this.f2415d.get(size);
            View view = c0837b.f2407a.f2183a;
            ag.m2524b(view, 0.0f);
            ag.m2511a(view, 0.0f);
            m4977i(c0837b.f2407a);
            this.f2415d.remove(size);
        }
        for (size = this.f2413b.size() - 1; size >= 0; size--) {
            m4976h((C0801u) this.f2413b.get(size));
            this.f2413b.remove(size);
        }
        for (size = this.f2414c.size() - 1; size >= 0; size--) {
            C0801u c0801u = (C0801u) this.f2414c.get(size);
            ag.m2528c(c0801u.f2183a, 1.0f);
            m4978j(c0801u);
            this.f2414c.remove(size);
        }
        for (size = this.f2416e.size() - 1; size >= 0; size--) {
            m4997b((C0836a) this.f2416e.get(size));
        }
        this.f2416e.clear();
        if (mo798b()) {
            int size2;
            ArrayList arrayList;
            int size3;
            for (size2 = this.f2418g.size() - 1; size2 >= 0; size2--) {
                arrayList = (ArrayList) this.f2418g.get(size2);
                for (size3 = arrayList.size() - 1; size3 >= 0; size3--) {
                    C0837b c0837b2 = (C0837b) arrayList.get(size3);
                    View view2 = c0837b2.f2407a.f2183a;
                    ag.m2524b(view2, 0.0f);
                    ag.m2511a(view2, 0.0f);
                    m4977i(c0837b2.f2407a);
                    arrayList.remove(size3);
                    if (arrayList.isEmpty()) {
                        this.f2418g.remove(arrayList);
                    }
                }
            }
            for (size2 = this.f2417f.size() - 1; size2 >= 0; size2--) {
                arrayList = (ArrayList) this.f2417f.get(size2);
                for (size3 = arrayList.size() - 1; size3 >= 0; size3--) {
                    C0801u c0801u2 = (C0801u) arrayList.get(size3);
                    ag.m2528c(c0801u2.f2183a, 1.0f);
                    m4978j(c0801u2);
                    arrayList.remove(size3);
                    if (arrayList.isEmpty()) {
                        this.f2417f.remove(arrayList);
                    }
                }
            }
            for (size2 = this.f2419h.size() - 1; size2 >= 0; size2--) {
                arrayList = (ArrayList) this.f2419h.get(size2);
                for (size3 = arrayList.size() - 1; size3 >= 0; size3--) {
                    m4997b((C0836a) arrayList.get(size3));
                    if (arrayList.isEmpty()) {
                        this.f2419h.remove(arrayList);
                    }
                }
            }
            m5009a(this.f2422k);
            m5009a(this.f2421j);
            m5009a(this.f2420i);
            m5009a(this.f2423l);
            m4436h();
        }
    }

    public void mo801c(C0801u c0801u) {
        int size;
        View view = c0801u.f2183a;
        ag.m2549q(view).m2734b();
        for (size = this.f2415d.size() - 1; size >= 0; size--) {
            if (((C0837b) this.f2415d.get(size)).f2407a == c0801u) {
                ag.m2524b(view, 0.0f);
                ag.m2511a(view, 0.0f);
                m4977i(c0801u);
                this.f2415d.remove(size);
            }
        }
        m4993a(this.f2416e, c0801u);
        if (this.f2413b.remove(c0801u)) {
            ag.m2528c(view, 1.0f);
            m4976h(c0801u);
        }
        if (this.f2414c.remove(c0801u)) {
            ag.m2528c(view, 1.0f);
            m4978j(c0801u);
        }
        for (size = this.f2419h.size() - 1; size >= 0; size--) {
            List list = (ArrayList) this.f2419h.get(size);
            m4993a(list, c0801u);
            if (list.isEmpty()) {
                this.f2419h.remove(size);
            }
        }
        for (int size2 = this.f2418g.size() - 1; size2 >= 0; size2--) {
            ArrayList arrayList = (ArrayList) this.f2418g.get(size2);
            int size3 = arrayList.size() - 1;
            while (size3 >= 0) {
                if (((C0837b) arrayList.get(size3)).f2407a == c0801u) {
                    ag.m2524b(view, 0.0f);
                    ag.m2511a(view, 0.0f);
                    m4977i(c0801u);
                    arrayList.remove(size3);
                    if (arrayList.isEmpty()) {
                        this.f2418g.remove(size2);
                    }
                } else {
                    size3--;
                }
            }
        }
        for (size = this.f2417f.size() - 1; size >= 0; size--) {
            arrayList = (ArrayList) this.f2417f.get(size);
            if (arrayList.remove(c0801u)) {
                ag.m2528c(view, 1.0f);
                m4978j(c0801u);
                if (arrayList.isEmpty()) {
                    this.f2417f.remove(size);
                }
            }
        }
        if (this.f2422k.remove(c0801u)) {
        }
        if (this.f2420i.remove(c0801u)) {
        }
        if (this.f2423l.remove(c0801u)) {
        }
        if (this.f2421j.remove(c0801u)) {
            m5004j();
        } else {
            m5004j();
        }
    }
}
