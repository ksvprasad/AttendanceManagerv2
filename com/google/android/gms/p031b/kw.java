package com.google.android.gms.p031b;

import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.google.android.gms.ads.internal.C1319u;
import java.lang.ref.WeakReference;

@id
class kw extends ky implements OnGlobalLayoutListener {
    private final WeakReference<OnGlobalLayoutListener> f5664a;

    public kw(View view, OnGlobalLayoutListener onGlobalLayoutListener) {
        super(view);
        this.f5664a = new WeakReference(onGlobalLayoutListener);
    }

    protected void mo1487a(ViewTreeObserver viewTreeObserver) {
        viewTreeObserver.addOnGlobalLayoutListener(this);
    }

    protected void mo1488b(ViewTreeObserver viewTreeObserver) {
        C1319u.m7185g().mo1476a(viewTreeObserver, (OnGlobalLayoutListener) this);
    }

    public void onGlobalLayout() {
        OnGlobalLayoutListener onGlobalLayoutListener = (OnGlobalLayoutListener) this.f5664a.get();
        if (onGlobalLayoutListener != null) {
            onGlobalLayoutListener.onGlobalLayout();
        } else {
            m9381b();
        }
    }
}
