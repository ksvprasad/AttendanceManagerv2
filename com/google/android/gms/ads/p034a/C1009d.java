package com.google.android.gms.ads.p034a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.C0970a;
import com.google.android.gms.ads.C1029d;
import com.google.android.gms.ads.C1033g;
import com.google.android.gms.ads.internal.client.C1090f;

public final class C1009d extends ViewGroup {
    private final C1090f f2983a;

    public C0970a getAdListener() {
        return this.f2983a.m6150b();
    }

    public C1029d getAdSize() {
        return this.f2983a.m6152c();
    }

    public C1029d[] getAdSizes() {
        return this.f2983a.m6153d();
    }

    public String getAdUnitId() {
        return this.f2983a.m6154e();
    }

    public C1006a getAppEventListener() {
        return this.f2983a.m6155f();
    }

    public String getMediationAdapterClassName() {
        return this.f2983a.m6160k();
    }

    public C1008c getOnCustomRenderedAdLoadedListener() {
        return this.f2983a.m6157h();
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        View childAt = getChildAt(0);
        if (childAt != null && childAt.getVisibility() != 8) {
            int measuredWidth = childAt.getMeasuredWidth();
            int measuredHeight = childAt.getMeasuredHeight();
            int i5 = ((i3 - i) - measuredWidth) / 2;
            int i6 = ((i4 - i2) - measuredHeight) / 2;
            childAt.layout(i5, i6, measuredWidth + i5, measuredHeight + i6);
        }
    }

    protected void onMeasure(int i, int i2) {
        int b;
        int i3 = 0;
        View childAt = getChildAt(0);
        if (childAt == null || childAt.getVisibility() == 8) {
            C1029d adSize = getAdSize();
            if (adSize != null) {
                Context context = getContext();
                b = adSize.m5804b(context);
                i3 = adSize.m5802a(context);
            } else {
                b = 0;
            }
        } else {
            measureChild(childAt, i, i2);
            b = childAt.getMeasuredWidth();
            i3 = childAt.getMeasuredHeight();
        }
        setMeasuredDimension(View.resolveSize(Math.max(b, getSuggestedMinimumWidth()), i), View.resolveSize(Math.max(i3, getSuggestedMinimumHeight()), i2));
    }

    public void setAdListener(C0970a c0970a) {
        this.f2983a.m6140a(c0970a);
    }

    public void setAdSizes(C1029d... c1029dArr) {
        if (c1029dArr == null || c1029dArr.length < 1) {
            throw new IllegalArgumentException("The supported ad sizes must contain at least one valid ad size.");
        }
        this.f2983a.m6151b(c1029dArr);
    }

    public void setAdUnitId(String str) {
        this.f2983a.m6146a(str);
    }

    public void setAppEventListener(C1006a c1006a) {
        this.f2983a.m6138a(c1006a);
    }

    public void setCorrelator(C1033g c1033g) {
        this.f2983a.m6141a(c1033g);
    }

    public void setManualImpressionsEnabled(boolean z) {
        this.f2983a.m6147a(z);
    }

    public void setOnCustomRenderedAdLoadedListener(C1008c c1008c) {
        this.f2983a.m6139a(c1008c);
    }
}
