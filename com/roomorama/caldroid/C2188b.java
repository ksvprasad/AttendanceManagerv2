package com.roomorama.caldroid;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.p024a.C0916a.C0911a;
import com.p024a.C0916a.C0913c;
import com.p024a.C0916a.C0915e;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import p000a.p001a.C0004a;

public class C2188b extends BaseAdapter {
    protected ArrayList<C0004a> f7366a;
    protected int f7367b;
    protected int f7368c;
    protected Context f7369d;
    protected ArrayList<C0004a> f7370e;
    protected ArrayList<C0004a> f7371f;
    protected HashMap<C0004a, Integer> f7372g = new HashMap();
    protected HashMap<C0004a, Integer> f7373h = new HashMap();
    protected C0004a f7374i;
    protected C0004a f7375j;
    protected C0004a f7376k;
    protected int f7377l;
    protected boolean f7378m;
    protected boolean f7379n;
    protected int f7380o;
    protected Resources f7381p;
    protected int f7382q = -1;
    protected ColorStateList f7383r;
    protected HashMap<String, Object> f7384s;
    protected HashMap<String, Object> f7385t;

    public C2188b(Context context, int i, int i2, HashMap<String, Object> hashMap, HashMap<String, Object> hashMap2) {
        this.f7367b = i;
        this.f7368c = i2;
        this.f7369d = context;
        this.f7384s = hashMap;
        this.f7385t = hashMap2;
        this.f7381p = context.getResources();
        m12472e();
    }

    private void m12471a(CellView cellView) {
        cellView.setBackgroundResource(this.f7382q);
        cellView.setTextColor(this.f7383r);
    }

    private void m12472e() {
        Iterator it;
        this.f7370e = (ArrayList) this.f7384s.get("disableDates");
        if (this.f7370e != null) {
            this.f7372g.clear();
            it = this.f7370e.iterator();
            while (it.hasNext()) {
                this.f7372g.put((C0004a) it.next(), Integer.valueOf(1));
            }
        }
        this.f7371f = (ArrayList) this.f7384s.get("selectedDates");
        if (this.f7371f != null) {
            this.f7373h.clear();
            it = this.f7371f.iterator();
            while (it.hasNext()) {
                this.f7373h.put((C0004a) it.next(), Integer.valueOf(1));
            }
        }
        this.f7374i = (C0004a) this.f7384s.get("_minDateTime");
        this.f7375j = (C0004a) this.f7384s.get("_maxDateTime");
        this.f7377l = ((Integer) this.f7384s.get("startDayOfWeek")).intValue();
        this.f7378m = ((Boolean) this.f7384s.get("sixWeeksInCalendar")).booleanValue();
        this.f7379n = ((Boolean) this.f7384s.get("squareTextViewCell")).booleanValue();
        this.f7380o = ((Integer) this.f7384s.get("themeResource")).intValue();
        this.f7366a = C2190d.m12488a(this.f7367b, this.f7368c, this.f7377l, this.f7378m);
        m12473f();
    }

    private void m12473f() {
        Context contextThemeWrapper = new ContextThemeWrapper(this.f7369d, this.f7380o);
        Theme theme = contextThemeWrapper.getTheme();
        TypedValue typedValue = new TypedValue();
        if (this.f7379n) {
            theme.resolveAttribute(C0911a.styleCaldroidSquareCell, typedValue, true);
        } else {
            theme.resolveAttribute(C0911a.styleCaldroidNormalCell, typedValue, true);
        }
        TypedArray obtainStyledAttributes = contextThemeWrapper.obtainStyledAttributes(typedValue.data, C0915e.Cell);
        this.f7382q = obtainStyledAttributes.getResourceId(C0915e.Cell_android_background, -1);
        this.f7383r = obtainStyledAttributes.getColorStateList(C0915e.Cell_android_textColor);
        obtainStyledAttributes.recycle();
    }

    public ArrayList<C0004a> m12474a() {
        return this.f7366a;
    }

    protected void m12475a(int i, CellView cellView) {
        int paddingTop = cellView.getPaddingTop();
        int paddingLeft = cellView.getPaddingLeft();
        int paddingBottom = cellView.getPaddingBottom();
        int paddingRight = cellView.getPaddingRight();
        C0004a c0004a = (C0004a) this.f7366a.get(i);
        cellView.m12432a();
        m12471a(cellView);
        if (c0004a.equals(m12482d())) {
            cellView.m12433a(CellView.f7353a);
        }
        if (c0004a.m27b().intValue() != this.f7367b) {
            cellView.m12433a(CellView.f7356d);
        }
        if ((this.f7374i != null && c0004a.m23a(this.f7374i)) || ((this.f7375j != null && c0004a.m28b(this.f7375j)) || (this.f7370e != null && this.f7372g.containsKey(c0004a)))) {
            cellView.m12433a(CellView.f7355c);
        }
        if (this.f7371f != null && this.f7373h.containsKey(c0004a)) {
            cellView.m12433a(CellView.f7354b);
        }
        cellView.refreshDrawableState();
        cellView.setText("" + c0004a.m31c());
        m12477a(c0004a, cellView, cellView);
        cellView.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
    }

    public void m12476a(C0004a c0004a) {
        this.f7367b = c0004a.m27b().intValue();
        this.f7368c = c0004a.m21a().intValue();
        this.f7366a = C2190d.m12488a(this.f7367b, this.f7368c, this.f7377l, this.f7378m);
    }

    protected void m12477a(C0004a c0004a, View view, TextView textView) {
        Integer num;
        HashMap hashMap = (HashMap) this.f7384s.get("_backgroundForDateTimeMap");
        if (hashMap != null) {
            num = (Integer) hashMap.get(c0004a);
            if (num != null) {
                view.setBackgroundResource(num.intValue());
            }
        }
        hashMap = (HashMap) this.f7384s.get("_textColorForDateTimeMap");
        if (hashMap != null) {
            num = (Integer) hashMap.get(c0004a);
            if (num != null) {
                textView.setTextColor(this.f7381p.getColor(num.intValue()));
            }
        }
    }

    public void m12478a(HashMap<String, Object> hashMap) {
        this.f7384s = hashMap;
        m12472e();
    }

    public int m12479b() {
        return this.f7380o;
    }

    public void m12480b(HashMap<String, Object> hashMap) {
        this.f7385t = hashMap;
    }

    public void m12481c() {
        this.f7376k = C2190d.m12487a(new Date());
    }

    protected C0004a m12482d() {
        if (this.f7376k == null) {
            this.f7376k = C2190d.m12487a(new Date());
        }
        return this.f7376k;
    }

    public int getCount() {
        return this.f7366a.size();
    }

    public Object getItem(int i) {
        return this.f7366a.get(i);
    }

    public long getItemId(int i) {
        return 0;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        View view3 = (CellView) view;
        LayoutInflater a = C2187a.m12444a(this.f7369d, (LayoutInflater) this.f7369d.getSystemService("layout_inflater"), this.f7380o);
        if (view != null) {
            view2 = view3;
        } else if (this.f7379n) {
            view2 = (CellView) a.inflate(C0913c.square_date_cell, null);
        } else {
            CellView cellView = (CellView) a.inflate(C0913c.normal_date_cell, null);
        }
        m12475a(i, view2);
        return view2;
    }
}
