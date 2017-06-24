package com.google.android.gms.p031b;

import android.app.Activity;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import com.google.android.gms.ads.internal.C1319u;

@id
public final class km {
    private final View f5629a;
    private Activity f5630b;
    private boolean f5631c;
    private boolean f5632d;
    private boolean f5633e;
    private OnGlobalLayoutListener f5634f;
    private OnScrollChangedListener f5635g;

    public km(Activity activity, View view, OnGlobalLayoutListener onGlobalLayoutListener, OnScrollChangedListener onScrollChangedListener) {
        this.f5630b = activity;
        this.f5629a = view;
        this.f5634f = onGlobalLayoutListener;
        this.f5635g = onScrollChangedListener;
    }

    private void m9353e() {
        if (!this.f5631c) {
            if (this.f5634f != null) {
                if (this.f5630b != null) {
                    C1319u.m7183e().m9212a(this.f5630b, this.f5634f);
                }
                C1319u.m7203y().m9377a(this.f5629a, this.f5634f);
            }
            if (this.f5635g != null) {
                if (this.f5630b != null) {
                    C1319u.m7183e().m9213a(this.f5630b, this.f5635g);
                }
                C1319u.m7203y().m9378a(this.f5629a, this.f5635g);
            }
            this.f5631c = true;
        }
    }

    private void m9354f() {
        if (this.f5630b != null && this.f5631c) {
            if (!(this.f5634f == null || this.f5630b == null)) {
                C1319u.m7185g().mo1474a(this.f5630b, this.f5634f);
            }
            if (!(this.f5635g == null || this.f5630b == null)) {
                C1319u.m7183e().m9234b(this.f5630b, this.f5635g);
            }
            this.f5631c = false;
        }
    }

    public void m9355a() {
        this.f5633e = true;
        if (this.f5632d) {
            m9353e();
        }
    }

    public void m9356a(Activity activity) {
        this.f5630b = activity;
    }

    public void m9357b() {
        this.f5633e = false;
        m9354f();
    }

    public void m9358c() {
        this.f5632d = true;
        if (this.f5633e) {
            m9353e();
        }
    }

    public void m9359d() {
        this.f5632d = false;
        m9354f();
    }
}
