package com.roomorama.caldroid;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import com.p024a.C0916a.C0911a;
import java.util.ArrayList;
import java.util.Iterator;

public class CellView extends TextView {
    public static final int f7353a = C0911a.state_date_today;
    public static final int f7354b = C0911a.state_date_selected;
    public static final int f7355c = C0911a.state_date_disabled;
    public static final int f7356d = C0911a.state_date_prev_next_month;
    private ArrayList<Integer> f7357e = new ArrayList();

    public CellView(Context context) {
        super(context);
    }

    public CellView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m12431b();
    }

    public CellView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m12431b();
    }

    private void m12431b() {
        if (this.f7357e == null) {
            this.f7357e = new ArrayList();
        }
    }

    public void m12432a() {
        this.f7357e.clear();
    }

    public void m12433a(int i) {
        if (!this.f7357e.contains(Integer.valueOf(i))) {
            this.f7357e.add(Integer.valueOf(i));
        }
    }

    protected int[] onCreateDrawableState(int i) {
        m12431b();
        int size = this.f7357e.size();
        if (size <= 0) {
            return super.onCreateDrawableState(i);
        }
        int[] onCreateDrawableState = super.onCreateDrawableState(i + size);
        int[] iArr = new int[size];
        Iterator it = this.f7357e.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            iArr[i2] = ((Integer) it.next()).intValue();
            i2++;
        }
        mergeDrawableStates(onCreateDrawableState, iArr);
        return onCreateDrawableState;
    }
}
