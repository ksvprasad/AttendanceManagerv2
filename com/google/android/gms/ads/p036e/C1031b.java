package com.google.android.gms.ads.p036e;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.C0970a;
import com.google.android.gms.ads.C1029d;
import com.google.android.gms.ads.internal.client.C1090f;
import com.google.android.gms.p031b.id;

@id
public final class C1031b extends ViewGroup {
    private final C1090f f3042a;

    public C0970a getAdListener() {
        return this.f3042a.m6150b();
    }

    public C1029d getAdSize() {
        return this.f3042a.m6152c();
    }

    public String getAdUnitId() {
        return this.f3042a.m6154e();
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
        this.f3042a.m6140a(c0970a);
    }

    public void setAdSize(C1029d c1029d) {
        this.f3042a.m6148a(c1029d);
    }

    public void setAdUnitId(String str) {
        this.f3042a.m6146a(str);
    }
}
