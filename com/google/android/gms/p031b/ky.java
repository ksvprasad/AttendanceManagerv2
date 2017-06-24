package com.google.android.gms.p031b;

import android.view.View;
import android.view.ViewTreeObserver;
import java.lang.ref.WeakReference;

@id
abstract class ky {
    private final WeakReference<View> f5663a;

    public ky(View view) {
        this.f5663a = new WeakReference(view);
    }

    public final void m9379a() {
        ViewTreeObserver c = m9383c();
        if (c != null) {
            mo1487a(c);
        }
    }

    protected abstract void mo1487a(ViewTreeObserver viewTreeObserver);

    public final void m9381b() {
        ViewTreeObserver c = m9383c();
        if (c != null) {
            mo1488b(c);
        }
    }

    protected abstract void mo1488b(ViewTreeObserver viewTreeObserver);

    protected ViewTreeObserver m9383c() {
        View view = (View) this.f5663a.get();
        if (view == null) {
            return null;
        }
        ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
        return (viewTreeObserver == null || !viewTreeObserver.isAlive()) ? null : viewTreeObserver;
    }
}
