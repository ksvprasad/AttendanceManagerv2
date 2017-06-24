package com.prolificinteractive.materialcalendarview;

import android.graphics.drawable.Drawable;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public final class C2147e {
    private boolean f7198a = false;
    private Drawable f7199b = null;
    private Drawable f7200c = null;
    private final LinkedList<C2146a> f7201d = new LinkedList();

    protected static class C2146a {
        final Object f7197a;
    }

    protected void m12296a() {
        this.f7199b = null;
        this.f7200c = null;
        this.f7201d.clear();
        this.f7198a = false;
    }

    public void m12297a(Drawable drawable) {
        if (drawable == null) {
            throw new IllegalArgumentException("Cannot be null");
        }
        this.f7199b = drawable;
        this.f7198a = true;
    }

    protected void m12298a(C2147e c2147e) {
        if (this.f7200c != null) {
            c2147e.m12300b(this.f7200c);
        }
        if (this.f7199b != null) {
            c2147e.m12297a(this.f7199b);
        }
        c2147e.f7201d.addAll(this.f7201d);
        c2147e.f7198a |= this.f7198a;
    }

    protected Drawable m12299b() {
        return this.f7200c;
    }

    public void m12300b(Drawable drawable) {
        if (drawable == null) {
            throw new IllegalArgumentException("Cannot be null");
        }
        this.f7200c = drawable;
        this.f7198a = true;
    }

    protected Drawable m12301c() {
        return this.f7199b;
    }

    protected List<C2146a> m12302d() {
        return Collections.unmodifiableList(this.f7201d);
    }
}
