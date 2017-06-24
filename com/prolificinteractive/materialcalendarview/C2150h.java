package com.prolificinteractive.materialcalendarview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.prolificinteractive.materialcalendarview.p039a.C2133h;
import com.prolificinteractive.materialcalendarview.p039a.C2136e;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

@SuppressLint({"ViewConstructor"})
class C2150h extends LinearLayout implements OnClickListener {
    private C2126a f7204a;
    private final ArrayList<C2160m> f7205b = new ArrayList();
    private final ArrayList<C2144c> f7206c = new ArrayList();
    private final CalendarDay f7207d;
    private int f7208e;
    private final Calendar f7209f = C2142b.m12274a();
    private CalendarDay f7210g = null;
    private CalendarDay f7211h = null;
    private CalendarDay f7212i = null;
    private boolean f7213j = false;
    private final ArrayList<C2148f> f7214k = new ArrayList();

    public interface C2126a {
        void mo1778a(CalendarDay calendarDay);
    }

    public C2150h(Context context, CalendarDay calendarDay, int i) {
        int i2;
        super(context);
        this.f7207d = calendarDay;
        this.f7208e = i;
        setOrientation(1);
        setClipChildren(false);
        setClipToPadding(false);
        Calendar b = m12306b();
        LinearLayout a = C2150h.m12305a((LinearLayout) this);
        for (i2 = 0; i2 < 7; i2++) {
            View c2160m = new C2160m(context, C2142b.m12281e(b));
            this.f7205b.add(c2160m);
            a.addView(c2160m, new LayoutParams(0, -1, 1.0f));
            b.add(5, 1);
        }
        Calendar b2 = m12306b();
        for (int i3 = 0; i3 < 6; i3++) {
            LinearLayout a2 = C2150h.m12305a((LinearLayout) this);
            for (i2 = 0; i2 < 7; i2++) {
                View c2144c = new C2144c(context, CalendarDay.m12207a(b2));
                c2144c.setOnClickListener(this);
                this.f7206c.add(c2144c);
                a2.addView(c2144c, new LayoutParams(0, -1, 1.0f));
                b2.add(5, 1);
            }
        }
        m12320c(CalendarDay.m12205a());
    }

    private static LinearLayout m12305a(LinearLayout linearLayout) {
        View linearLayout2 = new LinearLayout(linearLayout.getContext());
        linearLayout2.setOrientation(0);
        linearLayout.addView(linearLayout2, new LayoutParams(-1, 0, 1.0f));
        return linearLayout2;
    }

    private Calendar m12306b() {
        Object obj = 1;
        this.f7207d.m12213b(this.f7209f);
        this.f7209f.setFirstDayOfWeek(this.f7208e);
        int e = this.f7208e - C2142b.m12281e(this.f7209f);
        if (this.f7213j) {
            if (e < 0) {
                obj = null;
            }
        } else if (e <= 0) {
            obj = null;
        }
        if (obj != null) {
            e -= 7;
        }
        this.f7209f.add(5, e);
        return this.f7209f;
    }

    private void m12307c() {
        int c = this.f7207d.m12215c();
        Iterator it = this.f7206c.iterator();
        while (it.hasNext()) {
            C2144c c2144c = (C2144c) it.next();
            CalendarDay b = c2144c.m12293b();
            c2144c.m12292a(this.f7213j, b.m12211a(this.f7211h, this.f7212i), b.m12215c() == c);
            c2144c.setChecked(b.equals(this.f7210g));
        }
        postInvalidate();
    }

    private void m12308d() {
        C2147e c2147e = new C2147e();
        Iterator it = this.f7206c.iterator();
        while (it.hasNext()) {
            C2144c c2144c = (C2144c) it.next();
            c2147e.m12296a();
            Iterator it2 = this.f7214k.iterator();
            while (it2.hasNext()) {
                C2148f c2148f = (C2148f) it2.next();
                if (c2148f.f7202a.m12295a(c2144c.m12293b())) {
                    c2148f.f7203b.m12298a(c2147e);
                }
            }
            c2144c.m12291a(c2147e);
        }
    }

    public CalendarDay m12309a() {
        return this.f7207d;
    }

    public void m12310a(int i) {
        Iterator it = this.f7205b.iterator();
        while (it.hasNext()) {
            ((C2160m) it.next()).setTextAppearance(getContext(), i);
        }
    }

    public void m12311a(CalendarDay calendarDay) {
        this.f7211h = calendarDay;
        m12307c();
    }

    public void m12312a(C2136e c2136e) {
        Iterator it = this.f7206c.iterator();
        while (it.hasNext()) {
            ((C2144c) it.next()).m12290a(c2136e);
        }
    }

    public void m12313a(C2133h c2133h) {
        Iterator it = this.f7205b.iterator();
        while (it.hasNext()) {
            ((C2160m) it.next()).m12332a(c2133h);
        }
    }

    public void m12314a(C2126a c2126a) {
        this.f7204a = c2126a;
    }

    void m12315a(List<C2148f> list) {
        this.f7214k.clear();
        if (list != null) {
            this.f7214k.addAll(list);
        }
        m12308d();
    }

    public void m12316a(boolean z) {
        this.f7213j = z;
        m12307c();
    }

    public void m12317b(int i) {
        Iterator it = this.f7206c.iterator();
        while (it.hasNext()) {
            ((C2144c) it.next()).setTextAppearance(getContext(), i);
        }
    }

    public void m12318b(CalendarDay calendarDay) {
        this.f7212i = calendarDay;
        m12307c();
    }

    public void m12319c(int i) {
        Iterator it = this.f7206c.iterator();
        while (it.hasNext()) {
            ((C2144c) it.next()).m12287a(i);
        }
    }

    public void m12320c(CalendarDay calendarDay) {
        this.f7210g = calendarDay;
        m12307c();
    }

    public void m12321d(int i) {
        this.f7208e = i;
        Calendar b = m12306b();
        b.set(7, i);
        Iterator it = this.f7205b.iterator();
        while (it.hasNext()) {
            ((C2160m) it.next()).m12333a(b);
            b.add(5, 1);
        }
        b = m12306b();
        it = this.f7206c.iterator();
        while (it.hasNext()) {
            ((C2144c) it.next()).m12289a(CalendarDay.m12207a(b));
            b.add(5, 1);
        }
        m12307c();
    }

    public void onClick(View view) {
        if (view instanceof C2144c) {
            Iterator it = this.f7206c.iterator();
            while (it.hasNext()) {
                ((C2144c) it.next()).setChecked(false);
            }
            C2144c c2144c = (C2144c) view;
            c2144c.setChecked(true);
            CalendarDay b = c2144c.m12293b();
            if (!b.equals(this.f7210g)) {
                this.f7210g = b;
                if (this.f7204a != null) {
                    this.f7204a.mo1778a(c2144c.m12293b());
                }
            }
        }
    }
}
