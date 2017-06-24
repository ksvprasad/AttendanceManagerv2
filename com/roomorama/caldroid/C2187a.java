package com.roomorama.caldroid;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.C0255m;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager.C0115f;
import android.support.v4.view.ab;
import android.text.format.DateUtils;
import android.text.format.Time;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;
import com.antonyt.infiniteviewpager.C0917a;
import com.antonyt.infiniteviewpager.InfiniteViewPager;
import com.p024a.C0916a.C0912b;
import com.p024a.C0916a.C0913c;
import com.p024a.C0916a.C0914d;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Formatter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.TimeZone;
import p000a.p001a.C0004a;
import p000a.p001a.C0004a.C0000a;

@SuppressLint({"DefaultLocale"})
public class C2187a extends C0255m {
    public static int aj = 1;
    public static int ak = 2;
    public static int al = 3;
    public static int am = 4;
    public static int an = 5;
    public static int ao = 6;
    public static int ap = 7;
    public static int aq = -1;
    public static int ar = -7829368;
    protected HashMap<String, Object> aA = new HashMap();
    protected HashMap<String, Object> aB = new HashMap();
    protected HashMap<C0004a, Integer> aC = new HashMap();
    protected HashMap<C0004a, Integer> aD = new HashMap();
    protected int aE = aj;
    protected ArrayList<C2188b> aF = new ArrayList();
    protected boolean aG = true;
    protected boolean aH = true;
    protected boolean aI = false;
    protected boolean aJ;
    private Time aK = new Time();
    private final StringBuilder aL = new StringBuilder(50);
    private Formatter aM = new Formatter(this.aL, Locale.getDefault());
    private Button aN;
    private Button aO;
    private TextView aP;
    private GridView aQ;
    private InfiniteViewPager aR;
    private C2186a aS;
    private ArrayList<C2191e> aT;
    private int aU = C0914d.CaldroidDefault;
    private boolean aV = true;
    private OnItemClickListener aW;
    private OnItemLongClickListener aX;
    private C2189c aY;
    public String ai = "CaldroidFragment";
    protected String as;
    protected int at = -1;
    protected int au = -1;
    protected ArrayList<C0004a> av = new ArrayList();
    protected ArrayList<C0004a> aw = new ArrayList();
    protected C0004a ax;
    protected C0004a ay;
    protected ArrayList<C0004a> az;

    class C21821 implements OnItemClickListener {
        final /* synthetic */ C2187a f7358a;

        C21821(C2187a c2187a) {
            this.f7358a = c2187a;
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            C0004a c0004a = (C0004a) this.f7358a.az.get(i);
            if (this.f7358a.aY != null) {
                if (!this.f7358a.aI) {
                    if (this.f7358a.ax != null && c0004a.m23a(this.f7358a.ax)) {
                        return;
                    }
                    if (this.f7358a.ay != null && c0004a.m28b(this.f7358a.ay)) {
                        return;
                    }
                    if (!(this.f7358a.av == null || this.f7358a.av.indexOf(c0004a) == -1)) {
                        return;
                    }
                }
                this.f7358a.aY.mo1790a(C2190d.m12489a(c0004a), view);
            }
        }
    }

    class C21832 implements OnItemLongClickListener {
        final /* synthetic */ C2187a f7359a;

        C21832(C2187a c2187a) {
            this.f7359a = c2187a;
        }

        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
            C0004a c0004a = (C0004a) this.f7359a.az.get(i);
            if (this.f7359a.aY != null) {
                if (!this.f7359a.aI && ((this.f7359a.ax != null && c0004a.m23a(this.f7359a.ax)) || ((this.f7359a.ay != null && c0004a.m28b(this.f7359a.ay)) || (this.f7359a.av != null && this.f7359a.av.indexOf(c0004a) != -1)))) {
                    return false;
                }
                this.f7359a.aY.m12486b(C2190d.m12489a(c0004a), view);
            }
            return true;
        }
    }

    class C21843 implements OnClickListener {
        final /* synthetic */ C2187a f7360a;

        C21843(C2187a c2187a) {
            this.f7360a = c2187a;
        }

        public void onClick(View view) {
            this.f7360a.m12451S();
        }
    }

    class C21854 implements OnClickListener {
        final /* synthetic */ C2187a f7361a;

        C21854(C2187a c2187a) {
            this.f7361a = c2187a;
        }

        public void onClick(View view) {
            this.f7361a.m12452T();
        }
    }

    public class C2186a implements C0115f {
        final /* synthetic */ C2187a f7362a;
        private int f7363b = 1000;
        private C0004a f7364c;
        private ArrayList<C2188b> f7365d;

        public C2186a(C2187a c2187a) {
            this.f7362a = c2187a;
        }

        private int m12434e(int i) {
            return (i + 1) % 4;
        }

        private int m12435f(int i) {
            return (i + 3) % 4;
        }

        public int m12436a() {
            return this.f7363b;
        }

        public void mo107a(int i) {
        }

        public void mo108a(int i, float f, int i2) {
        }

        public void m12439a(C0004a c0004a) {
            this.f7364c = c0004a;
            this.f7362a.m12463a(this.f7364c);
        }

        public void m12440a(ArrayList<C2188b> arrayList) {
            this.f7365d = arrayList;
        }

        public void mo109b(int i) {
            m12443d(i);
            this.f7362a.m12463a(this.f7364c);
            C2188b c2188b = (C2188b) this.f7365d.get(i % 4);
            this.f7362a.az.clear();
            this.f7362a.az.addAll(c2188b.m12474a());
        }

        public int m12442c(int i) {
            return i % 4;
        }

        public void m12443d(int i) {
            C2188b c2188b = (C2188b) this.f7365d.get(m12442c(i));
            C2188b c2188b2 = (C2188b) this.f7365d.get(m12435f(i));
            C2188b c2188b3 = (C2188b) this.f7365d.get(m12434e(i));
            if (i == this.f7363b) {
                c2188b.m12476a(this.f7364c);
                c2188b.notifyDataSetChanged();
                c2188b2.m12476a(this.f7364c.m26b(Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), C0000a.LastDay));
                c2188b2.notifyDataSetChanged();
                c2188b3.m12476a(this.f7364c.m20a(Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), C0000a.LastDay));
                c2188b3.notifyDataSetChanged();
            } else if (i > this.f7363b) {
                this.f7364c = this.f7364c.m20a(Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), C0000a.LastDay);
                c2188b3.m12476a(this.f7364c.m20a(Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), C0000a.LastDay));
                c2188b3.notifyDataSetChanged();
            } else {
                this.f7364c = this.f7364c.m26b(Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), C0000a.LastDay);
                c2188b2.m12476a(this.f7364c.m26b(Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), C0000a.LastDay));
                c2188b2.notifyDataSetChanged();
            }
            this.f7363b = i;
        }
    }

    public static LayoutInflater m12444a(Context context, LayoutInflater layoutInflater, int i) {
        return layoutInflater.cloneInContext(new ContextThemeWrapper(context, i));
    }

    private void m12446a(View view) {
        C0004a c0004a = new C0004a(Integer.valueOf(this.au), Integer.valueOf(this.at), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0));
        this.aS = new C2186a(this);
        this.aS.m12439a(c0004a);
        C2188b a = m12460a(c0004a.m27b().intValue(), c0004a.m21a().intValue());
        this.az = a.m12474a();
        C0004a a2 = c0004a.m20a(Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), C0000a.LastDay);
        C2188b a3 = m12460a(a2.m27b().intValue(), a2.m21a().intValue());
        a2 = a2.m20a(Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), C0000a.LastDay);
        C2188b a4 = m12460a(a2.m27b().intValue(), a2.m21a().intValue());
        c0004a = c0004a.m26b(Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), C0000a.LastDay);
        C2188b a5 = m12460a(c0004a.m27b().intValue(), c0004a.m21a().intValue());
        this.aF.add(a);
        this.aF.add(a3);
        this.aF.add(a4);
        this.aF.add(a5);
        this.aS.m12440a(this.aF);
        this.aR = (InfiniteViewPager) view.findViewById(C0912b.months_infinite_pager);
        this.aR.setEnabled(this.aG);
        this.aR.setSixWeeksInCalendar(this.aV);
        this.aR.setDatesInMonth(this.az);
        ab c2192f = new C2192f(m1205m());
        this.aT = c2192f.m12501d();
        for (int i = 0; i < 4; i++) {
            C2191e c2191e = (C2191e) this.aT.get(i);
            C2188b c2188b = (C2188b) this.aF.get(i);
            c2191e.m12495a(m12458Z());
            c2191e.m12498a(c2188b);
            c2191e.m12496a(m12453U());
            c2191e.m12497a(m12454V());
        }
        this.aR.setAdapter(new C0917a(c2192f));
        this.aR.setOnPageChangeListener(this.aS);
    }

    public Button m12447O() {
        return this.aN;
    }

    public Button m12448P() {
        return this.aO;
    }

    public TextView m12449Q() {
        return this.aP;
    }

    public HashMap<String, Object> m12450R() {
        this.aA.clear();
        this.aA.put("disableDates", this.av);
        this.aA.put("selectedDates", this.aw);
        this.aA.put("_minDateTime", this.ax);
        this.aA.put("_maxDateTime", this.ay);
        this.aA.put("startDayOfWeek", Integer.valueOf(this.aE));
        this.aA.put("sixWeeksInCalendar", Boolean.valueOf(this.aV));
        this.aA.put("squareTextViewCell", Boolean.valueOf(this.aJ));
        this.aA.put("themeResource", Integer.valueOf(this.aU));
        this.aA.put("_backgroundForDateTimeMap", this.aC);
        this.aA.put("_textColorForDateTimeMap", this.aD);
        return this.aA;
    }

    public void m12451S() {
        this.aR.setCurrentItem(this.aS.m12436a() - 1);
    }

    public void m12452T() {
        this.aR.setCurrentItem(this.aS.m12436a() + 1);
    }

    public OnItemClickListener m12453U() {
        if (this.aW == null) {
            this.aW = new C21821(this);
        }
        return this.aW;
    }

    public OnItemLongClickListener m12454V() {
        if (this.aX == null) {
            this.aX = new C21832(this);
        }
        return this.aX;
    }

    protected void m12455W() {
        this.aK.year = this.au;
        this.aK.month = this.at - 1;
        this.aK.monthDay = 15;
        long toMillis = this.aK.toMillis(true);
        this.aL.setLength(0);
        this.aP.setText(DateUtils.formatDateRange(m1200j(), this.aM, toMillis, toMillis, 52).toString().toUpperCase(Locale.getDefault()));
    }

    public void m12456X() {
        if (this.at != -1 && this.au != -1) {
            m12455W();
            Iterator it = this.aF.iterator();
            while (it.hasNext()) {
                C2188b c2188b = (C2188b) it.next();
                c2188b.m12478a(m12450R());
                c2188b.m12480b(this.aB);
                c2188b.m12481c();
                c2188b.notifyDataSetChanged();
            }
        }
    }

    protected void m12457Y() {
        Bundle h = m1196h();
        C2190d.m12491a();
        if (h != null) {
            Iterator it;
            this.at = h.getInt("month", -1);
            this.au = h.getInt("year", -1);
            this.as = h.getString("dialogTitle");
            Dialog a = m1398a();
            if (a != null) {
                if (this.as != null) {
                    a.setTitle(this.as);
                } else {
                    a.requestWindowFeature(1);
                }
            }
            this.aE = h.getInt("startDayOfWeek", 1);
            if (this.aE > 7) {
                this.aE %= 7;
            }
            this.aH = h.getBoolean("showNavigationArrows", true);
            this.aG = h.getBoolean("enableSwipe", true);
            this.aV = h.getBoolean("sixWeeksInCalendar", true);
            if (m1202k().getConfiguration().orientation == 1) {
                this.aJ = h.getBoolean("squareTextViewCell", true);
            } else {
                this.aJ = h.getBoolean("squareTextViewCell", false);
            }
            this.aI = h.getBoolean("enableClickOnDisabledDates", false);
            ArrayList stringArrayList = h.getStringArrayList("disableDates");
            if (stringArrayList != null && stringArrayList.size() > 0) {
                this.av.clear();
                it = stringArrayList.iterator();
                while (it.hasNext()) {
                    this.av.add(C2190d.m12492b((String) it.next(), null));
                }
            }
            stringArrayList = h.getStringArrayList("selectedDates");
            if (stringArrayList != null && stringArrayList.size() > 0) {
                this.aw.clear();
                it = stringArrayList.iterator();
                while (it.hasNext()) {
                    this.aw.add(C2190d.m12492b((String) it.next(), null));
                }
            }
            String string = h.getString("minDate");
            if (string != null) {
                this.ax = C2190d.m12492b(string, null);
            }
            string = h.getString("maxDate");
            if (string != null) {
                this.ay = C2190d.m12492b(string, null);
            }
            this.aU = h.getInt("themeResource", C0914d.CaldroidDefault);
        }
        if (this.at == -1 || this.au == -1) {
            C0004a b = C0004a.m8b(TimeZone.getDefault());
            this.at = b.m27b().intValue();
            this.au = b.m21a().intValue();
        }
    }

    protected int m12458Z() {
        return C0913c.date_grid_fragment;
    }

    public View mo1786a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        m12457Y();
        if (m1398a() != null) {
            try {
                m1186d(true);
            } catch (IllegalStateException e) {
                e.printStackTrace();
            }
        }
        View inflate = C2187a.m12444a(m1200j(), layoutInflater, this.aU).inflate(C0913c.calendar_view, viewGroup, false);
        this.aP = (TextView) inflate.findViewById(C0912b.calendar_month_year_textview);
        this.aN = (Button) inflate.findViewById(C0912b.calendar_left_arrow);
        this.aO = (Button) inflate.findViewById(C0912b.calendar_right_arrow);
        this.aN.setOnClickListener(new C21843(this));
        this.aO.setOnClickListener(new C21854(this));
        m12470g(this.aH);
        this.aQ = (GridView) inflate.findViewById(C0912b.weekday_gridview);
        this.aQ.setAdapter(m12461a(this.aU));
        m12446a(inflate);
        m12456X();
        return inflate;
    }

    public C2188b m12460a(int i, int i2) {
        return new C2188b(m1200j(), i, i2, m12450R(), this.aB);
    }

    public C2193g m12461a(int i) {
        return new C2193g(m1200j(), 17367043, aa(), i);
    }

    public void m12462a(int i, Date date) {
        this.aC.put(C2190d.m12487a(date), Integer.valueOf(i));
    }

    public void m12463a(C0004a c0004a) {
        this.at = c0004a.m27b().intValue();
        this.au = c0004a.m21a().intValue();
        if (this.aY != null) {
            this.aY.m12484a(this.at, this.au);
        }
        m12456X();
    }

    public void mo1787a(View view, Bundle bundle) {
        super.mo1787a(view, bundle);
        if (this.aY != null) {
            this.aY.mo1789a();
        }
    }

    public void m12465a(C2189c c2189c) {
        this.aY = c2189c;
    }

    public void m12466a(Date date) {
        if (date == null) {
            this.ay = null;
        } else {
            this.ay = C2190d.m12487a(date);
        }
    }

    protected ArrayList<String> aa() {
        ArrayList<String> arrayList = new ArrayList();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE", Locale.getDefault());
        C0004a a = new C0004a(Integer.valueOf(2013), Integer.valueOf(2), Integer.valueOf(17), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0)).m19a(Integer.valueOf(this.aE - aj));
        for (int i = 0; i < 7; i++) {
            arrayList.add(simpleDateFormat.format(C2190d.m12489a(a)).toUpperCase());
            a = a.m19a(Integer.valueOf(1));
        }
        return arrayList;
    }

    public void m12467b(int i, Date date) {
        this.aD.put(C2190d.m12487a(date), Integer.valueOf(i));
    }

    public void mo200c() {
        super.mo200c();
        try {
            Field declaredField = Fragment.class.getDeclaredField("D");
            declaredField.setAccessible(true);
            declaredField.set(this, null);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        } catch (Throwable e2) {
            throw new RuntimeException(e2);
        }
    }

    public void mo205f() {
        if (m1398a() != null && m1209q()) {
            m1398a().setDismissMessage(null);
        }
        super.mo205f();
    }

    public void m12470g(boolean z) {
        this.aH = z;
        if (z) {
            this.aN.setVisibility(0);
            this.aO.setVisibility(0);
            return;
        }
        this.aN.setVisibility(4);
        this.aO.setVisibility(4);
    }
}
