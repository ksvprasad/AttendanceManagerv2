package com.google.android.gms.p031b;

import java.util.concurrent.TimeUnit;

@id
public class ko<T> implements kq<T> {
    private final T f5636a;
    private final kr f5637b = new kr();

    public ko(T t) {
        this.f5636a = t;
        this.f5637b.m9367a();
    }

    public void mo1314a(Runnable runnable) {
        this.f5637b.m9368a(runnable);
    }

    public boolean cancel(boolean z) {
        return false;
    }

    public T get() {
        return this.f5636a;
    }

    public T get(long j, TimeUnit timeUnit) {
        return this.f5636a;
    }

    public boolean isCancelled() {
        return false;
    }

    public boolean isDone() {
        return true;
    }
}
