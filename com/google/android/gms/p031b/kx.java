package com.google.android.gms.p031b;

import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import java.lang.ref.WeakReference;

@id
class kx extends ky implements OnScrollChangedListener {
    private final WeakReference<OnScrollChangedListener> f5665a;

    public kx(View view, OnScrollChangedListener onScrollChangedListener) {
        super(view);
        this.f5665a = new WeakReference(onScrollChangedListener);
    }

    protected void mo1487a(ViewTreeObserver viewTreeObserver) {
        viewTreeObserver.addOnScrollChangedListener(this);
    }

    protected void mo1488b(ViewTreeObserver viewTreeObserver) {
        viewTreeObserver.removeOnScrollChangedListener(this);
    }

    public void onScrollChanged() {
        OnScrollChangedListener onScrollChangedListener = (OnScrollChangedListener) this.f5665a.get();
        if (onScrollChangedListener != null) {
            onScrollChangedListener.onScrollChanged();
        } else {
            m9381b();
        }
    }
}
