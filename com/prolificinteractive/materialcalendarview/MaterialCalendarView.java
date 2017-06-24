package com.prolificinteractive.materialcalendarview;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.C0115f;
import android.support.v4.view.ViewPager.C0397g;
import android.support.v4.view.ab;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.prolificinteractive.materialcalendarview.C2150h.C2126a;
import com.prolificinteractive.materialcalendarview.C2157k.C2153a;
import com.prolificinteractive.materialcalendarview.C2157k.C2154b;
import com.prolificinteractive.materialcalendarview.C2157k.C2155c;
import com.prolificinteractive.materialcalendarview.C2157k.C2156d;
import com.prolificinteractive.materialcalendarview.p039a.C2133h;
import com.prolificinteractive.materialcalendarview.p039a.C2134a;
import com.prolificinteractive.materialcalendarview.p039a.C2136e;
import com.prolificinteractive.materialcalendarview.p039a.C2138g;
import com.prolificinteractive.materialcalendarview.p039a.C2139d;
import com.prolificinteractive.materialcalendarview.p039a.C2140f;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class MaterialCalendarView extends FrameLayout {
    private static final C2138g f7163a = new C2139d();
    private final C2159l f7164b;
    private final TextView f7165c;
    private final C2149g f7166d;
    private final C2149g f7167e;
    private final ViewPager f7168f;
    private final C2132a f7169g;
    private CalendarDay f7170h;
    private final ArrayList<C2145d> f7171i;
    private final C2126a f7172j;
    private final OnClickListener f7173k;
    private final C0115f f7174l;
    private CalendarDay f7175m;
    private CalendarDay f7176n;
    private C2151i f7177o;
    private C2152j f7178p;
    private int f7179q;
    private int f7180r;
    private LinearLayout f7181s;

    class C21271 implements C2126a {
        final /* synthetic */ MaterialCalendarView f7136a;

        C21271(MaterialCalendarView materialCalendarView) {
            this.f7136a = materialCalendarView;
        }

        public void mo1778a(CalendarDay calendarDay) {
            this.f7136a.setSelectedDate(calendarDay);
            if (this.f7136a.f7177o != null) {
                this.f7136a.f7177o.mo1792a(this.f7136a, calendarDay);
            }
        }
    }

    class C21282 implements OnClickListener {
        final /* synthetic */ MaterialCalendarView f7137a;

        C21282(MaterialCalendarView materialCalendarView) {
            this.f7137a = materialCalendarView;
        }

        public void onClick(View view) {
            if (view == this.f7137a.f7167e) {
                this.f7137a.f7168f.m2001a(this.f7137a.f7168f.getCurrentItem() + 1, true);
            } else if (view == this.f7137a.f7166d) {
                this.f7137a.f7168f.m2001a(this.f7137a.f7168f.getCurrentItem() - 1, true);
            }
        }
    }

    class C21293 implements C0115f {
        final /* synthetic */ MaterialCalendarView f7138a;

        C21293(MaterialCalendarView materialCalendarView) {
            this.f7138a = materialCalendarView;
        }

        public void mo107a(int i) {
        }

        public void mo108a(int i, float f, int i2) {
        }

        public void mo109b(int i) {
            this.f7138a.f7164b.m12330b(this.f7138a.f7170h);
            this.f7138a.f7170h = this.f7138a.f7169g.m12248g(i);
            this.f7138a.m12256b();
            if (this.f7138a.f7178p != null) {
                this.f7138a.f7178p.m12323a(this.f7138a, this.f7138a.f7170h);
            }
        }
    }

    class C21304 implements C0397g {
        final /* synthetic */ MaterialCalendarView f7139a;

        C21304(MaterialCalendarView materialCalendarView) {
            this.f7139a = materialCalendarView;
        }

        public void mo1779a(View view, float f) {
            view.setAlpha((float) Math.sqrt((double) (1.0f - Math.abs(f))));
        }
    }

    public static class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR = new C21311();
        int f7140a;
        int f7141b;
        int f7142c;
        boolean f7143d;
        CalendarDay f7144e;
        CalendarDay f7145f;
        CalendarDay f7146g;

        static class C21311 implements Creator<SavedState> {
            C21311() {
            }

            public SavedState m12225a(Parcel parcel) {
                return new SavedState(parcel);
            }

            public SavedState[] m12226a(int i) {
                return new SavedState[i];
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return m12225a(parcel);
            }

            public /* synthetic */ Object[] newArray(int i) {
                return m12226a(i);
            }
        }

        private SavedState(Parcel parcel) {
            boolean z = true;
            super(parcel);
            this.f7140a = 0;
            this.f7141b = 0;
            this.f7142c = 0;
            this.f7143d = false;
            this.f7144e = null;
            this.f7145f = null;
            this.f7146g = null;
            this.f7140a = parcel.readInt();
            this.f7141b = parcel.readInt();
            this.f7142c = parcel.readInt();
            if (parcel.readInt() != 1) {
                z = false;
            }
            this.f7143d = z;
            ClassLoader classLoader = CalendarDay.class.getClassLoader();
            this.f7144e = (CalendarDay) parcel.readParcelable(classLoader);
            this.f7145f = (CalendarDay) parcel.readParcelable(classLoader);
            this.f7146g = (CalendarDay) parcel.readParcelable(classLoader);
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
            this.f7140a = 0;
            this.f7141b = 0;
            this.f7142c = 0;
            this.f7143d = false;
            this.f7144e = null;
            this.f7145f = null;
            this.f7146g = null;
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f7140a);
            parcel.writeInt(this.f7141b);
            parcel.writeInt(this.f7142c);
            parcel.writeInt(this.f7143d ? 1 : 0);
            parcel.writeParcelable(this.f7144e, 0);
            parcel.writeParcelable(this.f7145f, 0);
            parcel.writeParcelable(this.f7146g, 0);
        }
    }

    private static class C2132a extends ab {
        private final MaterialCalendarView f7147a;
        private final LinkedList<C2150h> f7148b;
        private final ArrayList<CalendarDay> f7149c;
        private C2126a f7150d;
        private Integer f7151e;
        private Integer f7152f;
        private Integer f7153g;
        private Boolean f7154h;
        private CalendarDay f7155i;
        private CalendarDay f7156j;
        private CalendarDay f7157k;
        private C2133h f7158l;
        private C2136e f7159m;
        private List<C2145d> f7160n;
        private List<C2148f> f7161o;
        private int f7162p;

        private C2132a(MaterialCalendarView materialCalendarView) {
            this.f7150d = null;
            this.f7151e = null;
            this.f7152f = null;
            this.f7153g = null;
            this.f7154h = null;
            this.f7155i = null;
            this.f7156j = null;
            this.f7157k = null;
            this.f7158l = C2133h.f7182a;
            this.f7159m = C2136e.f7185a;
            this.f7160n = null;
            this.f7161o = null;
            this.f7162p = 1;
            this.f7147a = materialCalendarView;
            this.f7148b = new LinkedList();
            this.f7149c = new ArrayList();
            m12233a(null, null);
        }

        private CalendarDay m12227c(CalendarDay calendarDay) {
            return calendarDay == null ? null : (this.f7155i == null || !this.f7155i.m12214b(calendarDay)) ? (this.f7156j == null || !this.f7156j.m12210a(calendarDay)) ? calendarDay : this.f7156j : this.f7155i;
        }

        public int m12228a(CalendarDay calendarDay) {
            if (calendarDay == null) {
                return mo879b() / 2;
            }
            if (this.f7155i != null && calendarDay.m12210a(this.f7155i)) {
                return 0;
            }
            if (this.f7156j != null && calendarDay.m12214b(this.f7156j)) {
                return mo879b() - 1;
            }
            for (int i = 0; i < this.f7149c.size(); i++) {
                CalendarDay calendarDay2 = (CalendarDay) this.f7149c.get(i);
                if (calendarDay.m12212b() == calendarDay2.m12212b() && calendarDay.m12215c() == calendarDay2.m12215c()) {
                    return i;
                }
            }
            return mo879b() / 2;
        }

        public int mo1780a(Object obj) {
            if (!(obj instanceof C2150h)) {
                return -2;
            }
            CalendarDay a = ((C2150h) obj).m12309a();
            if (a == null) {
                return -2;
            }
            int indexOf = this.f7149c.indexOf(a);
            return indexOf >= 0 ? indexOf : -2;
        }

        public Object mo232a(ViewGroup viewGroup, int i) {
            View c2150h = new C2150h(viewGroup.getContext(), (CalendarDay) this.f7149c.get(i), this.f7162p);
            c2150h.m12313a(this.f7158l);
            c2150h.m12312a(this.f7159m);
            c2150h.m12314a(this.f7150d);
            if (this.f7151e != null) {
                c2150h.m12319c(this.f7151e.intValue());
            }
            if (this.f7152f != null) {
                c2150h.m12317b(this.f7152f.intValue());
            }
            if (this.f7153g != null) {
                c2150h.m12310a(this.f7153g.intValue());
            }
            if (this.f7154h != null) {
                c2150h.m12316a(this.f7154h.booleanValue());
            }
            c2150h.m12311a(this.f7155i);
            c2150h.m12318b(this.f7156j);
            c2150h.m12320c(this.f7157k);
            viewGroup.addView(c2150h);
            this.f7148b.add(c2150h);
            c2150h.m12315a(this.f7161o);
            return c2150h;
        }

        public void m12231a(int i) {
            this.f7162p = i;
            Iterator it = this.f7148b.iterator();
            while (it.hasNext()) {
                ((C2150h) it.next()).m12321d(this.f7162p);
            }
        }

        public void mo235a(ViewGroup viewGroup, int i, Object obj) {
            C2150h c2150h = (C2150h) obj;
            this.f7148b.remove(c2150h);
            viewGroup.removeView(c2150h);
        }

        public void m12233a(CalendarDay calendarDay, CalendarDay calendarDay2) {
            CalendarDay a;
            this.f7155i = calendarDay;
            this.f7156j = calendarDay2;
            Iterator it = this.f7148b.iterator();
            while (it.hasNext()) {
                C2150h c2150h = (C2150h) it.next();
                c2150h.m12311a(calendarDay);
                c2150h.m12318b(calendarDay2);
            }
            if (calendarDay == null) {
                Calendar a2 = C2142b.m12274a();
                a2.add(1, -200);
                calendarDay = CalendarDay.m12207a(a2);
            }
            if (calendarDay2 == null) {
                a2 = C2142b.m12274a();
                a2.add(1, 200);
                calendarDay2 = CalendarDay.m12207a(a2);
            }
            Calendar a3 = C2142b.m12274a();
            calendarDay.m12213b(a3);
            C2142b.m12276a(a3);
            this.f7149c.clear();
            for (a = CalendarDay.m12207a(a3); !calendarDay2.m12210a(a); a = CalendarDay.m12207a(a3)) {
                this.f7149c.add(CalendarDay.m12207a(a3));
                a3.add(2, 1);
            }
            a = this.f7157k;
            m1592c();
            m12241b(a);
            if (a != null && !a.equals(this.f7157k)) {
                this.f7150d.mo1778a(this.f7157k);
            }
        }

        public void m12234a(C2136e c2136e) {
            this.f7159m = c2136e;
            Iterator it = this.f7148b.iterator();
            while (it.hasNext()) {
                ((C2150h) it.next()).m12312a(c2136e);
            }
        }

        public void m12235a(C2133h c2133h) {
            this.f7158l = c2133h;
            Iterator it = this.f7148b.iterator();
            while (it.hasNext()) {
                ((C2150h) it.next()).m12313a(c2133h);
            }
        }

        public void m12236a(C2126a c2126a) {
            this.f7150d = c2126a;
            Iterator it = this.f7148b.iterator();
            while (it.hasNext()) {
                ((C2150h) it.next()).m12314a(c2126a);
            }
        }

        public void m12237a(boolean z) {
            this.f7154h = Boolean.valueOf(z);
            Iterator it = this.f7148b.iterator();
            while (it.hasNext()) {
                ((C2150h) it.next()).m12316a(z);
            }
        }

        public boolean mo236a(View view, Object obj) {
            return view == obj;
        }

        public int mo879b() {
            return this.f7149c.size();
        }

        public void m12240b(int i) {
            this.f7151e = Integer.valueOf(i);
            Iterator it = this.f7148b.iterator();
            while (it.hasNext()) {
                ((C2150h) it.next()).m12319c(i);
            }
        }

        public void m12241b(CalendarDay calendarDay) {
            CalendarDay calendarDay2 = this.f7157k;
            this.f7157k = m12227c(calendarDay);
            Iterator it = this.f7148b.iterator();
            while (it.hasNext()) {
                ((C2150h) it.next()).m12320c(this.f7157k);
            }
            if (calendarDay == null && calendarDay2 != null) {
                this.f7150d.mo1778a(null);
            }
        }

        public boolean m12242d() {
            return this.f7154h.booleanValue();
        }

        public CalendarDay m12243e() {
            return this.f7157k;
        }

        public void m12244e(int i) {
            if (i != 0) {
                this.f7152f = Integer.valueOf(i);
                Iterator it = this.f7148b.iterator();
                while (it.hasNext()) {
                    ((C2150h) it.next()).m12317b(i);
                }
            }
        }

        protected int m12245f() {
            return this.f7152f == null ? 0 : this.f7152f.intValue();
        }

        public void m12246f(int i) {
            if (i != 0) {
                this.f7153g = Integer.valueOf(i);
                Iterator it = this.f7148b.iterator();
                while (it.hasNext()) {
                    ((C2150h) it.next()).m12310a(i);
                }
            }
        }

        protected int m12247g() {
            return this.f7153g == null ? 0 : this.f7153g.intValue();
        }

        public CalendarDay m12248g(int i) {
            return (CalendarDay) this.f7149c.get(i);
        }

        public int m12249h() {
            return this.f7162p;
        }
    }

    public MaterialCalendarView(Context context) {
        this(context, null);
    }

    public MaterialCalendarView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f7171i = new ArrayList();
        this.f7172j = new C21271(this);
        this.f7173k = new C21282(this);
        this.f7174l = new C21293(this);
        this.f7175m = null;
        this.f7176n = null;
        this.f7179q = 0;
        this.f7180r = -16777216;
        setClipChildren(false);
        setClipToPadding(false);
        this.f7166d = new C2149g(getContext());
        this.f7165c = new TextView(getContext());
        this.f7167e = new C2149g(getContext());
        this.f7168f = new ViewPager(getContext());
        m12253a();
        this.f7165c.setOnClickListener(this.f7173k);
        this.f7166d.setOnClickListener(this.f7173k);
        this.f7167e.setOnClickListener(this.f7173k);
        this.f7164b = new C2159l(this.f7165c);
        this.f7164b.m12329a(f7163a);
        this.f7169g = new C2132a();
        this.f7168f.setAdapter(this.f7169g);
        this.f7168f.setOnPageChangeListener(this.f7174l);
        this.f7168f.m2005a(false, new C21304(this));
        this.f7169g.m12236a(this.f7172j);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, C2156d.MaterialCalendarView, 0, 0);
        try {
            int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(C2156d.MaterialCalendarView_mcv_tileSize, -1);
            if (dimensionPixelSize > 0) {
                setTileSize(dimensionPixelSize);
            }
            setArrowColor(obtainStyledAttributes.getColor(C2156d.MaterialCalendarView_mcv_arrowColor, -16777216));
            setSelectionColor(obtainStyledAttributes.getColor(C2156d.MaterialCalendarView_mcv_selectionColor, m12250a(context)));
            CharSequence[] textArray = obtainStyledAttributes.getTextArray(C2156d.MaterialCalendarView_mcv_weekDayLabels);
            if (textArray != null) {
                setWeekDayFormatter(new C2134a(textArray));
            }
            textArray = obtainStyledAttributes.getTextArray(C2156d.MaterialCalendarView_mcv_monthLabels);
            if (textArray != null) {
                setTitleFormatter(new C2140f(textArray));
            }
            setHeaderTextAppearance(obtainStyledAttributes.getResourceId(C2156d.MaterialCalendarView_mcv_headerTextAppearance, C2155c.TextAppearance_MaterialCalendarWidget_Header));
            setWeekDayTextAppearance(obtainStyledAttributes.getResourceId(C2156d.MaterialCalendarView_mcv_weekDayTextAppearance, C2155c.TextAppearance_MaterialCalendarWidget_WeekDay));
            setDateTextAppearance(obtainStyledAttributes.getResourceId(C2156d.MaterialCalendarView_mcv_dateTextAppearance, C2155c.TextAppearance_MaterialCalendarWidget_Date));
            setShowOtherDates(obtainStyledAttributes.getBoolean(C2156d.MaterialCalendarView_mcv_showOtherDates, false));
            setFirstDayOfWeek(obtainStyledAttributes.getInt(C2156d.MaterialCalendarView_mcv_firstDayOfWeek, 1));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            obtainStyledAttributes.recycle();
        }
        this.f7170h = CalendarDay.m12205a();
        setCurrentDate(this.f7170h);
    }

    private static int m12250a(Context context) {
        int identifier = VERSION.SDK_INT >= 21 ? 16843829 : context.getResources().getIdentifier("colorAccent", "attr", context.getPackageName());
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(identifier, typedValue, true);
        return typedValue.data;
    }

    private void m12253a() {
        int applyDimension = (int) TypedValue.applyDimension(1, 44.0f, getResources().getDisplayMetrics());
        this.f7181s = new LinearLayout(getContext());
        this.f7181s.setOrientation(1);
        this.f7181s.setClipChildren(false);
        this.f7181s.setClipToPadding(false);
        LayoutParams layoutParams = new FrameLayout.LayoutParams(applyDimension * 7, applyDimension * 8);
        layoutParams.gravity = 17;
        addView(this.f7181s, layoutParams);
        View linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(0);
        linearLayout.setClipChildren(false);
        linearLayout.setClipToPadding(false);
        this.f7181s.addView(linearLayout, new LinearLayout.LayoutParams(-1, 0, 1.0f));
        this.f7166d.setScaleType(ScaleType.CENTER_INSIDE);
        this.f7166d.setImageResource(C2153a.mcv_action_previous);
        linearLayout.addView(this.f7166d, new LinearLayout.LayoutParams(0, -1, 1.0f));
        this.f7165c.setGravity(17);
        linearLayout.addView(this.f7165c, new LinearLayout.LayoutParams(0, -1, 5.0f));
        this.f7167e.setScaleType(ScaleType.CENTER_INSIDE);
        this.f7167e.setImageResource(C2153a.mcv_action_next);
        linearLayout.addView(this.f7167e, new LinearLayout.LayoutParams(0, -1, 1.0f));
        this.f7168f.setId(C2154b.mcv_pager);
        this.f7168f.setOffscreenPageLimit(1);
        this.f7181s.addView(this.f7168f, new LinearLayout.LayoutParams(-1, 0, 7.0f));
    }

    private void m12254a(CalendarDay calendarDay, CalendarDay calendarDay2) {
        CalendarDay calendarDay3 = this.f7170h;
        this.f7169g.m12233a(calendarDay, calendarDay2);
        this.f7170h = calendarDay3;
        this.f7168f.m2001a(this.f7169g.m12228a(calendarDay3), false);
    }

    private void m12256b() {
        this.f7164b.m12328a(this.f7170h);
        this.f7166d.setEnabled(m12260d());
        this.f7167e.setEnabled(m12258c());
    }

    private boolean m12258c() {
        return this.f7168f.getCurrentItem() < this.f7169g.mo879b() + -1;
    }

    private boolean m12260d() {
        return this.f7168f.getCurrentItem() > 0;
    }

    protected void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        super.dispatchThawSelfOnly(sparseArray);
    }

    protected void dispatchSaveInstanceState(SparseArray<Parcelable> sparseArray) {
        super.dispatchFreezeSelfOnly(sparseArray);
    }

    public int getArrowColor() {
        return this.f7180r;
    }

    public CalendarDay getCurrentDate() {
        return this.f7169g.m12248g(this.f7168f.getCurrentItem());
    }

    public int getFirstDayOfWeek() {
        return this.f7169g.m12249h();
    }

    public CalendarDay getMaximumDate() {
        return this.f7176n;
    }

    public CalendarDay getMinimumDate() {
        return this.f7175m;
    }

    public CalendarDay getSelectedDate() {
        return this.f7169g.m12243e();
    }

    public int getSelectionColor() {
        return this.f7179q;
    }

    public boolean getShowOtherDates() {
        return this.f7169g.m12242d();
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setSelectionColor(savedState.f7140a);
        setDateTextAppearance(savedState.f7141b);
        setWeekDayTextAppearance(savedState.f7142c);
        setShowOtherDates(savedState.f7143d);
        m12254a(savedState.f7144e, savedState.f7145f);
        setSelectedDate(savedState.f7146g);
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        savedState.f7140a = getSelectionColor();
        savedState.f7141b = this.f7169g.m12245f();
        savedState.f7142c = this.f7169g.m12247g();
        savedState.f7143d = getShowOtherDates();
        savedState.f7144e = getMinimumDate();
        savedState.f7145f = getMaximumDate();
        savedState.f7146g = getSelectedDate();
        return savedState;
    }

    public void setArrowColor(int i) {
        if (i != 0) {
            this.f7180r = i;
            this.f7166d.m12304a(i);
            this.f7167e.m12304a(i);
            invalidate();
        }
    }

    public void setCurrentDate(CalendarDay calendarDay) {
        if (calendarDay != null) {
            this.f7168f.setCurrentItem(this.f7169g.m12228a(calendarDay));
            m12256b();
        }
    }

    public void setCurrentDate(Calendar calendar) {
        setCurrentDate(CalendarDay.m12207a(calendar));
    }

    public void setCurrentDate(Date date) {
        setCurrentDate(CalendarDay.m12208a(date));
    }

    public void setDateTextAppearance(int i) {
        this.f7169g.m12244e(i);
    }

    public void setDayFormatter(C2136e c2136e) {
        C2132a c2132a = this.f7169g;
        if (c2136e == null) {
            c2136e = C2136e.f7185a;
        }
        c2132a.m12234a(c2136e);
    }

    public void setFirstDayOfWeek(int i) {
        this.f7169g.m12231a(i);
    }

    public void setHeaderTextAppearance(int i) {
        this.f7165c.setTextAppearance(getContext(), i);
    }

    public void setMaximumDate(CalendarDay calendarDay) {
        this.f7176n = calendarDay;
        m12254a(this.f7175m, this.f7176n);
    }

    public void setMaximumDate(Calendar calendar) {
        setMaximumDate(CalendarDay.m12207a(calendar));
    }

    public void setMaximumDate(Date date) {
        setMaximumDate(CalendarDay.m12208a(date));
    }

    public void setMinimumDate(CalendarDay calendarDay) {
        this.f7175m = calendarDay;
        m12254a(this.f7175m, this.f7176n);
    }

    public void setMinimumDate(Calendar calendar) {
        setMinimumDate(CalendarDay.m12207a(calendar));
    }

    public void setMinimumDate(Date date) {
        setMinimumDate(CalendarDay.m12208a(date));
    }

    public void setOnDateChangedListener(C2151i c2151i) {
        this.f7177o = c2151i;
    }

    public void setOnMonthChangedListener(C2152j c2152j) {
        this.f7178p = c2152j;
    }

    public void setSelectedDate(CalendarDay calendarDay) {
        this.f7169g.m12241b(calendarDay);
        setCurrentDate(calendarDay);
    }

    public void setSelectedDate(Calendar calendar) {
        setSelectedDate(CalendarDay.m12207a(calendar));
    }

    public void setSelectedDate(Date date) {
        setSelectedDate(CalendarDay.m12208a(date));
    }

    public void setSelectionColor(int i) {
        if (i != 0) {
            this.f7179q = i;
            this.f7169g.m12240b(i);
            invalidate();
        }
    }

    public void setShowOtherDates(boolean z) {
        this.f7169g.m12237a(z);
    }

    public void setTileSize(int i) {
        LayoutParams layoutParams = new FrameLayout.LayoutParams(i * 7, i * 8);
        layoutParams.gravity = 17;
        this.f7181s.setLayoutParams(layoutParams);
    }

    public void setTileSizeDp(int i) {
        setTileSize((int) TypedValue.applyDimension(1, (float) i, getResources().getDisplayMetrics()));
    }

    public void setTitleFormatter(C2138g c2138g) {
        C2159l c2159l = this.f7164b;
        if (c2138g == null) {
            c2138g = f7163a;
        }
        c2159l.m12329a(c2138g);
        m12256b();
    }

    public void setTitleMonths(int i) {
        setTitleMonths(getResources().getTextArray(i));
    }

    public void setTitleMonths(CharSequence[] charSequenceArr) {
        setTitleFormatter(new C2140f(charSequenceArr));
    }

    public void setWeekDayFormatter(C2133h c2133h) {
        C2132a c2132a = this.f7169g;
        if (c2133h == null) {
            c2133h = C2133h.f7182a;
        }
        c2132a.m12235a(c2133h);
    }

    public void setWeekDayLabels(int i) {
        setWeekDayLabels(getResources().getTextArray(i));
    }

    public void setWeekDayLabels(CharSequence[] charSequenceArr) {
        setWeekDayFormatter(new C2134a(charSequenceArr));
    }

    public void setWeekDayTextAppearance(int i) {
        this.f7169g.m12246f(i);
    }
}
