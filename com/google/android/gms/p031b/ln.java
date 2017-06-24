package com.google.android.gms.p031b;

import com.google.android.gms.p031b.ar.C1369a;

public class ln<T> {
    public final T f5769a;
    public final C1369a f5770b;
    public final nj f5771c;
    public boolean f5772d;

    public interface C1676a {
        void mo1483a(nj njVar);
    }

    public interface C1681b<T> {
        void mo1486a(T t);
    }

    private ln(nj njVar) {
        this.f5772d = false;
        this.f5769a = null;
        this.f5770b = null;
        this.f5771c = njVar;
    }

    private ln(T t, C1369a c1369a) {
        this.f5772d = false;
        this.f5769a = t;
        this.f5770b = c1369a;
        this.f5771c = null;
    }

    public static <T> ln<T> m9631a(nj njVar) {
        return new ln(njVar);
    }

    public static <T> ln<T> m9632a(T t, C1369a c1369a) {
        return new ln(t, c1369a);
    }

    public boolean m9633a() {
        return this.f5771c == null;
    }
}
