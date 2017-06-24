package com.antonyt.infiniteviewpager;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ab;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import java.util.ArrayList;
import p000a.p001a.C0004a;

public class InfiniteViewPager extends ViewPager {
    private ArrayList<C0004a> f2781a;
    private boolean f2782b = true;
    private boolean f2783c = false;
    private int f2784d = 0;

    public InfiniteViewPager(Context context) {
        super(context);
    }

    public InfiniteViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ArrayList<C0004a> getDatesInMonth() {
        return this.f2781a;
    }

    public boolean isEnabled() {
        return this.f2782b;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.f2782b ? super.onInterceptTouchEvent(motionEvent) : false;
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int size = this.f2781a.size() / 7;
        if (getChildCount() > 0 && this.f2784d == 0) {
            View childAt = getChildAt(0);
            i = MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824);
            childAt.measure(i, MeasureSpec.makeMeasureSpec(0, 0));
            this.f2784d = childAt.getMeasuredHeight();
        }
        super.onMeasure(i, MeasureSpec.makeMeasureSpec((this.f2783c ? this.f2784d * 6 : size * this.f2784d) - 12, 1073741824));
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.f2782b ? super.onTouchEvent(motionEvent) : false;
    }

    public void setAdapter(ab abVar) {
        super.setAdapter(abVar);
        setCurrentItem(1000);
    }

    public void setDatesInMonth(ArrayList<C0004a> arrayList) {
        this.f2781a = arrayList;
    }

    public void setEnabled(boolean z) {
        this.f2782b = z;
    }

    public void setSixWeeksInCalendar(boolean z) {
        this.f2783c = z;
        this.f2784d = 0;
    }
}
