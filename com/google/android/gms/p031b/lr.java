package com.google.android.gms.p031b;

import android.os.Process;
import android.util.Log;
import com.google.android.gms.clearcut.C1720c;
import com.google.android.gms.clearcut.C1854b;
import com.google.android.gms.clearcut.LogEventParcelable;
import com.google.android.gms.common.api.C1713d;
import com.google.android.gms.common.api.C1713d.C1709a;
import com.google.android.gms.common.api.C1767c;
import com.google.android.gms.common.api.C1857g;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.util.C1970c;
import com.google.android.gms.common.util.C1972e;
import com.google.android.gms.p031b.lu.C1716a;
import com.google.android.gms.p031b.mc.C1714a;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

public class lr implements C1720c {
    private static final Object f5802a = new Object();
    private static ScheduledExecutorService f5803b;
    private static final C1719e f5804c = new C1719e();
    private static final long f5805d = TimeUnit.MILLISECONDS.convert(2, TimeUnit.MINUTES);
    private final C1970c f5806e;
    private final C1711a f5807f;
    private final Object f5808g;
    private long f5809h;
    private final long f5810i;
    private ScheduledFuture<?> f5811j;
    private C1767c f5812k;
    private final Runnable f5813l;

    class C17051 implements Runnable {
        final /* synthetic */ lr f5773a;

        C17051(lr lrVar) {
            this.f5773a = lrVar;
        }

        public void run() {
            synchronized (this.f5773a.f5808g) {
                if (0 <= this.f5773a.f5806e.mo1724b() && this.f5773a.f5812k != null) {
                    Log.i("ClearcutLoggerApiImpl", "disconnect managed GoogleApiClient");
                    this.f5773a.f5812k.mo1614c();
                    this.f5773a.f5812k = null;
                }
            }
        }
    }

    class C17072 implements ThreadFactory {
        final /* synthetic */ lr f5776a;

        C17072(lr lrVar) {
            this.f5776a = lrVar;
        }

        public Thread newThread(final Runnable runnable) {
            return new Thread(new Runnable(this) {
                final /* synthetic */ C17072 f5775b;

                public void run() {
                    Process.setThreadPriority(10);
                    runnable.run();
                }
            }, "ClearcutLoggerApiImpl");
        }
    }

    class C17104 implements C1709a {
        final /* synthetic */ lr f5780a;

        C17104(lr lrVar) {
            this.f5780a = lrVar;
        }

        public void mo1545a(Status status) {
            lr.f5804c.m9674b();
        }
    }

    public interface C1711a {
    }

    public static class C1712b implements C1711a {
    }

    static abstract class C1715c<R extends C1857g> extends C1714a<R, ls> {
        public C1715c(C1767c c1767c) {
            super(C1854b.f6307c, c1767c);
        }
    }

    static final class C1718d extends C1715c<Status> {
        private final LogEventParcelable f5800d;

        class C17171 extends C1716a {
            final /* synthetic */ C1718d f5799a;

            C17171(C1718d c1718d) {
                this.f5799a = c1718d;
            }

            public void mo1552a(Status status) {
                this.f5799a.m9647b((C1857g) status);
            }
        }

        C1718d(LogEventParcelable logEventParcelable, C1767c c1767c) {
            super(c1767c);
            this.f5800d = logEventParcelable;
        }

        protected Status m9669a(Status status) {
            return status;
        }

        protected void m9670a(ls lsVar) {
            lu c17171 = new C17171(this);
            try {
                lr.m9684b(this.f5800d);
                lsVar.m9709a(c17171, this.f5800d);
            } catch (Throwable e) {
                Log.e("ClearcutLoggerApiImpl", "derived ClearcutLogger.MessageProducer ", e);
                m9663c(new Status(10, "MessageProducer"));
            }
        }

        protected /* synthetic */ C1857g mo1554b(Status status) {
            return m9669a(status);
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof C1718d)) {
                return false;
            }
            return this.f5800d.equals(((C1718d) obj).f5800d);
        }

        public String toString() {
            String valueOf = String.valueOf(this.f5800d);
            return new StringBuilder(String.valueOf(valueOf).length() + 12).append("MethodImpl(").append(valueOf).append(")").toString();
        }
    }

    private static final class C1719e {
        private int f5801a;

        private C1719e() {
            this.f5801a = 0;
        }

        public synchronized void m9673a() {
            this.f5801a++;
        }

        public synchronized void m9674b() {
            if (this.f5801a == 0) {
                throw new RuntimeException("too many decrements");
            }
            this.f5801a--;
            if (this.f5801a == 0) {
                notifyAll();
            }
        }
    }

    public lr() {
        this(new C1972e(), f5805d, new C1712b());
    }

    public lr(C1970c c1970c, long j, C1711a c1711a) {
        this.f5808g = new Object();
        this.f5809h = 0;
        this.f5811j = null;
        this.f5812k = null;
        this.f5813l = new C17051(this);
        this.f5806e = c1970c;
        this.f5810i = j;
        this.f5807f = c1711a;
    }

    private C1713d<Status> m9678a(final C1767c c1767c, final C1715c<Status> c1715c) {
        m9683b().execute(new Runnable(this) {
            final /* synthetic */ lr f5779c;

            public void run() {
                c1767c.mo1605a(c1715c);
            }
        });
        return c1715c;
    }

    private C1718d m9682b(C1767c c1767c, LogEventParcelable logEventParcelable) {
        f5804c.m9673a();
        C1718d c1718d = new C1718d(logEventParcelable, c1767c);
        c1718d.mo1547a(new C17104(this));
        return c1718d;
    }

    private ScheduledExecutorService m9683b() {
        synchronized (f5802a) {
            if (f5803b == null) {
                f5803b = Executors.newSingleThreadScheduledExecutor(new C17072(this));
            }
        }
        return f5803b;
    }

    private static void m9684b(LogEventParcelable logEventParcelable) {
        if (logEventParcelable.f6287j != null && logEventParcelable.f6286i.f4083k.length == 0) {
            logEventParcelable.f6286i.f4083k = logEventParcelable.f6287j.m10518a();
        }
        if (logEventParcelable.f6288k != null && logEventParcelable.f6286i.f4090r.length == 0) {
            logEventParcelable.f6286i.f4090r = logEventParcelable.f6288k.m10518a();
        }
        logEventParcelable.f6280c = C1357z.m7342a(logEventParcelable.f6286i);
    }

    public C1713d<Status> mo1555a(C1767c c1767c, LogEventParcelable logEventParcelable) {
        return m9678a(c1767c, m9682b(c1767c, logEventParcelable));
    }
}
