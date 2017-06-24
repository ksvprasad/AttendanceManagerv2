package com.google.android.gms.measurement.internal;

import android.content.Context;
import com.google.android.gms.common.internal.C1896c;
import com.google.android.gms.common.util.C1970c;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicLong;

public class ai extends C2019b {
    private static final AtomicLong f6805j = new AtomicLong(Long.MIN_VALUE);
    private C2032d f6806a;
    private C2032d f6807b;
    private final PriorityBlockingQueue<FutureTask<?>> f6808c = new PriorityBlockingQueue();
    private final BlockingQueue<FutureTask<?>> f6809d = new LinkedBlockingQueue();
    private final UncaughtExceptionHandler f6810e = new C2030b(this, "Thread death: Uncaught exception on worker thread");
    private final UncaughtExceptionHandler f6811f = new C2030b(this, "Thread death: Uncaught exception on network thread");
    private final Object f6812g = new Object();
    private final Semaphore f6813h = new Semaphore(2);
    private volatile boolean f6814i;

    static class C2029a extends RuntimeException {
    }

    private final class C2030b implements UncaughtExceptionHandler {
        final /* synthetic */ ai f6796a;
        private final String f6797b;

        public C2030b(ai aiVar, String str) {
            this.f6796a = aiVar;
            C1896c.m10790a((Object) str);
            this.f6797b = str;
        }

        public synchronized void uncaughtException(Thread thread, Throwable th) {
            this.f6796a.mo1746w().m11290f().m11250a(this.f6797b, th);
        }
    }

    private final class C2031c<V> extends FutureTask<V> implements Comparable<C2031c> {
        final /* synthetic */ ai f6798a;
        private final long f6799b = ai.f6805j.getAndIncrement();
        private final boolean f6800c;
        private final String f6801d;

        C2031c(ai aiVar, Runnable runnable, boolean z, String str) {
            this.f6798a = aiVar;
            super(runnable, null);
            C1896c.m10790a((Object) str);
            this.f6801d = str;
            this.f6800c = z;
            if (this.f6799b == Long.MAX_VALUE) {
                aiVar.mo1746w().m11290f().m11249a("Tasks index overflow");
            }
        }

        C2031c(ai aiVar, Callable<V> callable, boolean z, String str) {
            this.f6798a = aiVar;
            super(callable);
            C1896c.m10790a((Object) str);
            this.f6801d = str;
            this.f6800c = z;
            if (this.f6799b == Long.MAX_VALUE) {
                aiVar.mo1746w().m11290f().m11249a("Tasks index overflow");
            }
        }

        public int m11410a(C2031c c2031c) {
            if (this.f6800c != c2031c.f6800c) {
                return this.f6800c ? -1 : 1;
            } else {
                if (this.f6799b < c2031c.f6799b) {
                    return -1;
                }
                if (this.f6799b > c2031c.f6799b) {
                    return 1;
                }
                this.f6798a.mo1746w().m11291g().m11250a("Two tasks share the same index. index", Long.valueOf(this.f6799b));
                return 0;
            }
        }

        public /* synthetic */ int compareTo(Object obj) {
            return m11410a((C2031c) obj);
        }

        protected void setException(Throwable th) {
            this.f6798a.mo1746w().m11290f().m11250a(this.f6801d, th);
            if (th instanceof C2029a) {
                Thread.getDefaultUncaughtExceptionHandler().uncaughtException(Thread.currentThread(), th);
            }
            super.setException(th);
        }
    }

    private final class C2032d extends Thread {
        final /* synthetic */ ai f6802a;
        private final Object f6803b = new Object();
        private final BlockingQueue<FutureTask<?>> f6804c;

        public C2032d(ai aiVar, String str, BlockingQueue<FutureTask<?>> blockingQueue) {
            this.f6802a = aiVar;
            C1896c.m10790a((Object) str);
            C1896c.m10790a((Object) blockingQueue);
            this.f6804c = blockingQueue;
            setName(str);
        }

        private void m11411a(InterruptedException interruptedException) {
            this.f6802a.mo1746w().m11310z().m11250a(String.valueOf(getName()).concat(" was interrupted"), interruptedException);
        }

        public void m11412a() {
            synchronized (this.f6803b) {
                this.f6803b.notifyAll();
            }
        }

        public void run() {
            Object obj = null;
            while (obj == null) {
                try {
                    this.f6802a.f6813h.acquire();
                    obj = 1;
                } catch (InterruptedException e) {
                    m11411a(e);
                }
            }
            while (true) {
                try {
                    FutureTask futureTask = (FutureTask) this.f6804c.poll();
                    if (futureTask != null) {
                        futureTask.run();
                    } else {
                        synchronized (this.f6803b) {
                            if (this.f6804c.peek() == null && !this.f6802a.f6814i) {
                                try {
                                    this.f6803b.wait(30000);
                                } catch (InterruptedException e2) {
                                    m11411a(e2);
                                }
                            }
                        }
                        synchronized (this.f6802a.f6812g) {
                            if (this.f6804c.peek() == null) {
                                break;
                            }
                        }
                    }
                } catch (Throwable th) {
                    synchronized (this.f6802a.f6812g) {
                        this.f6802a.f6813h.release();
                        this.f6802a.f6812g.notifyAll();
                        if (this == this.f6802a.f6806a) {
                            this.f6802a.f6806a = null;
                        } else if (this == this.f6802a.f6807b) {
                            this.f6802a.f6807b = null;
                        } else {
                            this.f6802a.mo1746w().m11290f().m11249a("Current scheduler thread is neither worker nor network");
                        }
                    }
                }
            }
            synchronized (this.f6802a.f6812g) {
                this.f6802a.f6813h.release();
                this.f6802a.f6812g.notifyAll();
                if (this == this.f6802a.f6806a) {
                    this.f6802a.f6806a = null;
                } else if (this == this.f6802a.f6807b) {
                    this.f6802a.f6807b = null;
                } else {
                    this.f6802a.mo1746w().m11290f().m11249a("Current scheduler thread is neither worker nor network");
                }
            }
        }
    }

    ai(aj ajVar) {
        super(ajVar);
    }

    private void m11415a(C2031c<?> c2031c) {
        synchronized (this.f6812g) {
            this.f6808c.add(c2031c);
            if (this.f6806a == null) {
                this.f6806a = new C2032d(this, "Measurement Worker", this.f6808c);
                this.f6806a.setUncaughtExceptionHandler(this.f6810e);
                this.f6806a.start();
            } else {
                this.f6806a.m11412a();
            }
        }
    }

    private void m11416a(FutureTask<?> futureTask) {
        synchronized (this.f6812g) {
            this.f6809d.add(futureTask);
            if (this.f6807b == null) {
                this.f6807b = new C2032d(this, "Measurement Network", this.f6809d);
                this.f6807b.setUncaughtExceptionHandler(this.f6811f);
                this.f6807b.start();
            } else {
                this.f6807b.m11412a();
            }
        }
    }

    public <V> Future<V> m11423a(Callable<V> callable) {
        m11273c();
        C1896c.m10790a((Object) callable);
        C2031c c2031c = new C2031c(this, (Callable) callable, false, "Task exception on worker thread");
        if (Thread.currentThread() == this.f6806a) {
            c2031c.run();
        } else {
            m11415a(c2031c);
        }
        return c2031c;
    }

    public void m11424a(Runnable runnable) {
        m11273c();
        C1896c.m10790a((Object) runnable);
        m11415a(new C2031c(this, runnable, false, "Task exception on worker thread"));
    }

    public <V> Future<V> m11425b(Callable<V> callable) {
        m11273c();
        C1896c.m10790a((Object) callable);
        C2031c c2031c = new C2031c(this, (Callable) callable, true, "Task exception on worker thread");
        if (Thread.currentThread() == this.f6806a) {
            c2031c.run();
        } else {
            m11415a(c2031c);
        }
        return c2031c;
    }

    public void m11426b(Runnable runnable) {
        m11273c();
        C1896c.m10790a((Object) runnable);
        m11416a(new C2031c(this, runnable, false, "Task exception on network thread"));
    }

    protected void mo1730e() {
    }

    public /* bridge */ /* synthetic */ void mo1731h() {
        super.mo1731h();
    }

    public void mo1732i() {
        if (Thread.currentThread() != this.f6807b) {
            throw new IllegalStateException("Call expected from network thread");
        }
    }

    public void mo1733j() {
        if (Thread.currentThread() != this.f6806a) {
            throw new IllegalStateException("Call expected from worker thread");
        }
    }

    public /* bridge */ /* synthetic */ C2084o mo1734k() {
        return super.mo1734k();
    }

    public /* bridge */ /* synthetic */ C2053d mo1735l() {
        return super.mo1735l();
    }

    public /* bridge */ /* synthetic */ C2098z mo1736m() {
        return super.mo1736m();
    }

    public /* bridge */ /* synthetic */ C2090s mo1737n() {
        return super.mo1737n();
    }

    public /* bridge */ /* synthetic */ C2066e mo1738o() {
        return super.mo1738o();
    }

    public /* bridge */ /* synthetic */ C1970c mo1739p() {
        return super.mo1739p();
    }

    public /* bridge */ /* synthetic */ Context mo1740q() {
        return super.mo1740q();
    }

    public /* bridge */ /* synthetic */ C2088q mo1741r() {
        return super.mo1741r();
    }

    public /* bridge */ /* synthetic */ C2082m mo1742s() {
        return super.mo1742s();
    }

    public /* bridge */ /* synthetic */ ah mo1743t() {
        return super.mo1743t();
    }

    public /* bridge */ /* synthetic */ C2076g mo1744u() {
        return super.mo1744u();
    }

    public /* bridge */ /* synthetic */ ai mo1745v() {
        return super.mo1745v();
    }

    public /* bridge */ /* synthetic */ ab mo1746w() {
        return super.mo1746w();
    }

    public /* bridge */ /* synthetic */ af mo1747x() {
        return super.mo1747x();
    }

    public /* bridge */ /* synthetic */ C2085p mo1748y() {
        return super.mo1748y();
    }
}
