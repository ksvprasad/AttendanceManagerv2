package com.daimajia.swipe.p027b;

import android.support.v7.widget.RecyclerView.C0778a;
import android.widget.BaseAdapter;
import com.daimajia.swipe.C0946b;
import com.daimajia.swipe.SwipeLayout;
import com.daimajia.swipe.SwipeLayout.C0933c;
import com.daimajia.swipe.p025c.C0941a;
import com.daimajia.swipe.p025c.C0942b;
import com.daimajia.swipe.p028d.C0952a.C0951a;
import java.util.HashSet;
import java.util.Set;

public abstract class C0949a implements C0942b {
    public final int f2906a = -1;
    protected int f2907b = -1;
    protected Set<Integer> f2908c = new HashSet();
    protected Set<SwipeLayout> f2909d = new HashSet();
    protected BaseAdapter f2910e;
    protected C0778a f2911f;
    private C0951a f2912g = C0951a.Single;

    class C0945a implements C0933c {
        final /* synthetic */ C0949a f2898a;
        private int f2899b;

        C0945a(C0949a c0949a, int i) {
            this.f2898a = c0949a;
            this.f2899b = i;
        }

        public void m5582a(int i) {
            this.f2899b = i;
        }

        public void mo880a(SwipeLayout swipeLayout) {
            if (this.f2898a.m5599b(this.f2899b)) {
                swipeLayout.m5568a(false, false);
            } else {
                swipeLayout.m5572b(false, false);
            }
        }
    }

    class C0947b extends C0946b {
        final /* synthetic */ C0949a f2900a;
        private int f2901b;

        C0947b(C0949a c0949a, int i) {
            this.f2900a = c0949a;
            this.f2901b = i;
        }

        public void m5590a(int i) {
            this.f2901b = i;
        }

        public void mo881a(SwipeLayout swipeLayout) {
            if (this.f2900a.f2912g == C0951a.Single) {
                this.f2900a.m5597a(swipeLayout);
            }
        }

        public void mo884b(SwipeLayout swipeLayout) {
            if (this.f2900a.f2912g == C0951a.Multiple) {
                this.f2900a.f2908c.add(Integer.valueOf(this.f2901b));
                return;
            }
            this.f2900a.m5597a(swipeLayout);
            this.f2900a.f2907b = this.f2901b;
        }

        public void mo886d(SwipeLayout swipeLayout) {
            if (this.f2900a.f2912g == C0951a.Multiple) {
                this.f2900a.f2908c.remove(Integer.valueOf(this.f2901b));
            } else {
                this.f2900a.f2907b = -1;
            }
        }
    }

    class C0948c {
        C0945a f2902a;
        C0947b f2903b;
        int f2904c;
        final /* synthetic */ C0949a f2905d;

        C0948c(C0949a c0949a, int i, C0947b c0947b, C0945a c0945a) {
            this.f2905d = c0949a;
            this.f2903b = c0947b;
            this.f2902a = c0945a;
            this.f2904c = i;
        }
    }

    public C0949a(C0778a c0778a) {
        if (c0778a == null) {
            throw new IllegalArgumentException("Adapter can not be null");
        } else if (c0778a instanceof C0942b) {
            this.f2911f = c0778a;
        } else {
            throw new IllegalArgumentException("adapter should implement the SwipeAdapterInterface");
        }
    }

    public int m5595a(int i) {
        return this.f2910e != null ? ((C0941a) this.f2910e).a_(i) : this.f2911f != null ? ((C0941a) this.f2911f).a_(i) : -1;
    }

    public void m5596a() {
        if (this.f2912g == C0951a.Multiple) {
            this.f2908c.clear();
        } else {
            this.f2907b = -1;
        }
        for (SwipeLayout i : this.f2909d) {
            i.m5580i();
        }
    }

    public void m5597a(SwipeLayout swipeLayout) {
        for (SwipeLayout swipeLayout2 : this.f2909d) {
            if (swipeLayout2 != swipeLayout) {
                swipeLayout2.m5580i();
            }
        }
    }

    public void m5598a(C0951a c0951a) {
        this.f2912g = c0951a;
        this.f2908c.clear();
        this.f2909d.clear();
        this.f2907b = -1;
    }

    public boolean m5599b(int i) {
        return this.f2912g == C0951a.Multiple ? this.f2908c.contains(Integer.valueOf(i)) : this.f2907b == i;
    }
}
