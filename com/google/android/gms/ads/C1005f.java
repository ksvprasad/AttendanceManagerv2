package com.google.android.gms.ads;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.internal.client.C0971a;
import com.google.android.gms.ads.internal.client.C1090f;
import com.google.android.gms.ads.purchase.C1350b;

class C1005f extends ViewGroup {
    protected final C1090f f2982a;

    public C1005f(Context context, int i) {
        super(context);
        this.f2982a = new C1090f(this, C1005f.m5718a(i));
    }

    public C1005f(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.f2982a = new C1090f(this, attributeSet, false, C1005f.m5718a(i));
    }

    public C1005f(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i);
        this.f2982a = new C1090f(this, attributeSet, false, C1005f.m5718a(i2));
    }

    private static boolean m5718a(int i) {
        return i == 2;
    }

    public void mo925a() {
        this.f2982a.m6159j();
    }

    public void mo926a(C1026c c1026c) {
        this.f2982a.m6143a(c1026c.m5790a());
    }

    public void mo927b() {
        this.f2982a.m6158i();
    }

    public void mo928c() {
        this.f2982a.m6137a();
    }

    public C0970a getAdListener() {
        return this.f2982a.m6150b();
    }

    public C1029d getAdSize() {
        return this.f2982a.m6152c();
    }

    public String getAdUnitId() {
        return this.f2982a.m6154e();
    }

    public C1350b getInAppPurchaseListener() {
        return this.f2982a.m6156g();
    }

    public String getMediationAdapterClassName() {
        return this.f2982a.m6160k();
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
        this.f2982a.m6140a(c0970a);
        if (c0970a != null && (c0970a instanceof C0971a)) {
            this.f2982a.m6142a((C0971a) c0970a);
        } else if (c0970a == null) {
            this.f2982a.m6142a(null);
        }
    }

    public void setAdSize(C1029d c1029d) {
        this.f2982a.m6148a(c1029d);
    }

    public void setAdUnitId(String str) {
        this.f2982a.m6146a(str);
    }

    public void setInAppPurchaseListener(C1350b c1350b) {
        this.f2982a.m6145a(c1350b);
    }
}
