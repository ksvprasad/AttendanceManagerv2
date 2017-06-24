package com.google.android.gms.p031b;

import android.os.Process;
import com.google.android.gms.ads.internal.C1319u;
import com.google.android.gms.ads.internal.util.client.C1324b;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

@id
public final class jy {
    private static final ExecutorService f5555a = Executors.newFixedThreadPool(10, jy.m9183a("Default"));
    private static final ExecutorService f5556b = Executors.newFixedThreadPool(5, jy.m9183a("Loader"));

    class C16501 implements Callable<Void> {
        final /* synthetic */ Runnable f5547a;

        C16501(Runnable runnable) {
            this.f5547a = runnable;
        }

        public Void m9177a() {
            this.f5547a.run();
            return null;
        }

        public /* synthetic */ Object call() {
            return m9177a();
        }
    }

    class C16512 implements Callable<Void> {
        final /* synthetic */ Runnable f5548a;

        C16512(Runnable runnable) {
            this.f5548a = runnable;
        }

        public Void m9178a() {
            this.f5548a.run();
            return null;
        }

        public /* synthetic */ Object call() {
            return m9178a();
        }
    }

    class C16523 implements Runnable {
        final /* synthetic */ kn f5549a;
        final /* synthetic */ Callable f5550b;

        C16523(kn knVar, Callable callable) {
            this.f5549a = knVar;
            this.f5550b = callable;
        }

        public void run() {
            try {
                Process.setThreadPriority(10);
                this.f5549a.m8236b(this.f5550b.call());
            } catch (Throwable e) {
                C1319u.m7186h().m9117a(e, true);
                this.f5549a.cancel(true);
            }
        }
    }

    class C16534 implements Runnable {
        final /* synthetic */ kn f5551a;
        final /* synthetic */ Future f5552b;

        C16534(kn knVar, Future future) {
            this.f5551a = knVar;
            this.f5552b = future;
        }

        public void run() {
            if (this.f5551a.isCancelled()) {
                this.f5552b.cancel(true);
            }
        }
    }

    class C16545 implements ThreadFactory {
        final /* synthetic */ String f5553a;
        private final AtomicInteger f5554b = new AtomicInteger(1);

        C16545(String str) {
            this.f5553a = str;
        }

        public Thread newThread(Runnable runnable) {
            String str = this.f5553a;
            return new Thread(runnable, new StringBuilder(String.valueOf(str).length() + 23).append("AdWorker(").append(str).append(") #").append(this.f5554b.getAndIncrement()).toString());
        }
    }

    public static kq<Void> m9179a(int i, Runnable runnable) {
        return i == 1 ? jy.m9182a(f5556b, new C16501(runnable)) : jy.m9182a(f5555a, new C16512(runnable));
    }

    public static kq<Void> m9180a(Runnable runnable) {
        return jy.m9179a(0, runnable);
    }

    public static <T> kq<T> m9181a(Callable<T> callable) {
        return jy.m9182a(f5555a, (Callable) callable);
    }

    public static <T> kq<T> m9182a(ExecutorService executorService, Callable<T> callable) {
        Object knVar = new kn();
        try {
            knVar.m8237b(new C16534(knVar, executorService.submit(new C16523(knVar, callable))));
        } catch (Throwable e) {
            C1324b.m7235d("Thread execution is rejected.", e);
            knVar.cancel(true);
        }
        return knVar;
    }

    private static ThreadFactory m9183a(String str) {
        return new C16545(str);
    }
}
