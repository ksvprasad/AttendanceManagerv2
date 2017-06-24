package com.google.android.gms.ads.p032b;

import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import com.google.android.gms.ads.internal.util.client.C1324b;
import com.google.android.gms.p031b.dh;
import com.google.android.gms.p033a.C0998a;

public abstract class C1017c extends FrameLayout {
    private final FrameLayout f2994a;
    private final dh f2995b;

    public void addView(View view, int i, LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
        super.bringChildToFront(this.f2994a);
    }

    public void bringChildToFront(View view) {
        super.bringChildToFront(view);
        if (this.f2994a != view) {
            super.bringChildToFront(this.f2994a);
        }
    }

    public void removeAllViews() {
        super.removeAllViews();
        super.addView(this.f2994a);
    }

    public void removeView(View view) {
        if (this.f2994a != view) {
            super.removeView(view);
        }
    }

    public void setNativeAd(C1013a c1013a) {
        try {
            this.f2995b.mo1099a((C0998a) c1013a.mo1285a());
        } catch (Throwable e) {
            C1324b.m7231b("Unable to call setNativeAd on delegate", e);
        }
    }
}
