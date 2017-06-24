package android.support.v7.view.menu;

import android.content.Context;
import android.support.v7.view.menu.C0727f.C0719b;
import android.support.v7.widget.bh;
import android.util.AttributeSet;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public final class ExpandedMenuView extends ListView implements C0719b, C0052m, OnItemClickListener {
    private static final int[] f1785a = new int[]{16842964, 16843049};
    private C0727f f1786b;
    private int f1787c;

    public ExpandedMenuView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842868);
    }

    public ExpandedMenuView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        setOnItemClickListener(this);
        bh a = bh.m5210a(context, attributeSet, f1785a, i, 0);
        if (a.m5225f(0)) {
            setBackgroundDrawable(a.m5213a(0));
        }
        if (a.m5225f(1)) {
            setDivider(a.m5213a(1));
        }
        a.m5214a();
    }

    public void mo37a(C0727f c0727f) {
        this.f1786b = c0727f;
    }

    public boolean mo624a(C0730h c0730h) {
        return this.f1786b.m3822a((MenuItem) c0730h, 0);
    }

    public int getWindowAnimations() {
        return this.f1787c;
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        setChildrenDrawingCacheEnabled(false);
    }

    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        mo624a((C0730h) getAdapter().getItem(i));
    }
}
