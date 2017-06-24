package com.daimajia.swipe.p027b;

import android.support.v7.widget.RecyclerView.C0778a;
import android.view.View;
import com.daimajia.swipe.SwipeLayout;
import com.daimajia.swipe.SwipeLayout.C0933c;
import com.daimajia.swipe.SwipeLayout.C0939i;
import com.daimajia.swipe.p027b.C0949a.C0945a;
import com.daimajia.swipe.p027b.C0949a.C0947b;
import com.daimajia.swipe.p027b.C0949a.C0948c;

public class C0950b extends C0949a {
    protected C0778a f2913g;

    public C0950b(C0778a c0778a) {
        super(c0778a);
        this.f2913g = c0778a;
    }

    public void m5600a(View view, int i) {
        int a = m5595a(i);
        C0933c c0945a = new C0945a(this, i);
        SwipeLayout swipeLayout = (SwipeLayout) view.findViewById(a);
        if (swipeLayout == null) {
            throw new IllegalStateException("can not find SwipeLayout in target view");
        } else if (swipeLayout.getTag(a) == null) {
            C0939i c0947b = new C0947b(this, i);
            swipeLayout.m5567a(c0947b);
            swipeLayout.m5566a(c0945a);
            swipeLayout.setTag(a, new C0948c(this, i, c0947b, c0945a));
            this.d.add(swipeLayout);
        } else {
            C0948c c0948c = (C0948c) swipeLayout.getTag(a);
            c0948c.f2903b.m5590a(i);
            c0948c.f2902a.m5582a(i);
            c0948c.f2904c = i;
        }
    }
}
