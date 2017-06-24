package com.google.android.gms.p031b;

import com.google.android.gms.ads.internal.C1319u;
import java.util.concurrent.CancellationException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@id
public class kn<T> implements kq<T> {
    private final Object f4716a = new Object();
    private T f4717b;
    private boolean f4718c;
    private boolean f4719d;
    private final kr f4720e = new kr();

    private boolean m8234a() {
        return null != null || this.f4718c;
    }

    public void mo1314a(Runnable runnable) {
        this.f4720e.m9368a(runnable);
    }

    public void m8236b(T t) {
        synchronized (this.f4716a) {
            if (this.f4719d) {
            } else if (m8234a()) {
                C1319u.m7186h().m9117a(new IllegalStateException("Provided CallbackFuture with multiple values."), true);
            } else {
                this.f4718c = true;
                this.f4717b = t;
                this.f4716a.notifyAll();
                this.f4720e.m9367a();
            }
        }
    }

    public void m8237b(Runnable runnable) {
        this.f4720e.m9369b(runnable);
    }

    public boolean cancel(boolean z) {
        if (!z) {
            return false;
        }
        synchronized (this.f4716a) {
            if (m8234a()) {
                return false;
            }
            this.f4719d = true;
            this.f4718c = true;
            this.f4716a.notifyAll();
            this.f4720e.m9367a();
            return true;
        }
    }

    public T get() {
        T t;
        synchronized (this.f4716a) {
            if (!m8234a()) {
                try {
                    this.f4716a.wait();
                } catch (InterruptedException e) {
                    throw e;
                }
            }
            if (this.f4719d) {
                throw new CancellationException("CallbackFuture was cancelled.");
            }
            t = this.f4717b;
        }
        return t;
    }

    public T get(long j, TimeUnit timeUnit) {
        T t;
        synchronized (this.f4716a) {
            if (!m8234a()) {
                try {
                    long toMillis = timeUnit.toMillis(j);
                    if (toMillis != 0) {
                        this.f4716a.wait(toMillis);
                    }
                } catch (InterruptedException e) {
                    throw e;
                }
            }
            if (!this.f4718c) {
                throw new TimeoutException("CallbackFuture timed out.");
            } else if (this.f4719d) {
                throw new CancellationException("CallbackFuture was cancelled.");
            } else {
                t = this.f4717b;
            }
        }
        return t;
    }

    public boolean isCancelled() {
        boolean z;
        synchronized (this.f4716a) {
            z = this.f4719d;
        }
        return z;
    }

    public boolean isDone() {
        boolean a;
        synchronized (this.f4716a) {
            a = m8234a();
        }
        return a;
    }
}
