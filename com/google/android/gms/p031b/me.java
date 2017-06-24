package com.google.android.gms.p031b;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.common.api.C1458f;
import com.google.android.gms.common.api.C1713d;
import com.google.android.gms.common.api.C1713d.C1709a;
import com.google.android.gms.common.api.C1767c;
import com.google.android.gms.common.api.C1780h;
import com.google.android.gms.common.api.C1857g;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.C1896c;
import com.google.android.gms.common.internal.C1946x;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;

public abstract class me<R extends C1857g> extends C1713d<R> {
    static final ThreadLocal<Boolean> f5781a = new C17391();
    protected final C1740a<R> f5782b;
    protected final WeakReference<C1767c> f5783c;
    private final Object f5784d;
    private final CountDownLatch f5785e;
    private final ArrayList<C1709a> f5786f;
    private C1780h<? super R> f5787g;
    private R f5788h;
    private C1741b f5789i;
    private volatile boolean f5790j;
    private boolean f5791k;
    private boolean f5792l;
    private C1946x f5793m;
    private volatile ng<R> f5794n;
    private boolean f5795o;

    class C17391 extends ThreadLocal<Boolean> {
        C17391() {
        }

        protected Boolean m9786a() {
            return Boolean.valueOf(false);
        }

        protected /* synthetic */ Object initialValue() {
            return m9786a();
        }
    }

    public static class C1740a<R extends C1857g> extends Handler {
        public C1740a() {
            this(Looper.getMainLooper());
        }

        public C1740a(Looper looper) {
            super(looper);
        }

        public void m9787a() {
            removeMessages(2);
        }

        public void m9788a(C1780h<? super R> c1780h, R r) {
            sendMessage(obtainMessage(1, new Pair(c1780h, r)));
        }

        protected void m9789b(C1780h<? super R> c1780h, R r) {
            try {
                c1780h.mo1621a(r);
            } catch (RuntimeException e) {
                me.m9642c(r);
                throw e;
            }
        }

        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    Pair pair = (Pair) message.obj;
                    m9789b((C1780h) pair.first, (C1857g) pair.second);
                    return;
                case 2:
                    ((me) message.obj).m9648d(Status.f6336d);
                    return;
                default:
                    Log.wtf("BasePendingResult", "Don't know how to handle message: " + message.what, new Exception());
                    return;
            }
        }
    }

    private final class C1741b {
        final /* synthetic */ me f5853a;

        private C1741b(me meVar) {
            this.f5853a = meVar;
        }

        protected void finalize() {
            me.m9642c(this.f5853a.f5788h);
            super.finalize();
        }
    }

    @Deprecated
    me() {
        this.f5784d = new Object();
        this.f5785e = new CountDownLatch(1);
        this.f5786f = new ArrayList();
        this.f5795o = false;
        this.f5782b = new C1740a(Looper.getMainLooper());
        this.f5783c = new WeakReference(null);
    }

    @Deprecated
    protected me(Looper looper) {
        this.f5784d = new Object();
        this.f5785e = new CountDownLatch(1);
        this.f5786f = new ArrayList();
        this.f5795o = false;
        this.f5782b = new C1740a(looper);
        this.f5783c = new WeakReference(null);
    }

    protected me(C1767c c1767c) {
        this.f5784d = new Object();
        this.f5785e = new CountDownLatch(1);
        this.f5786f = new ArrayList();
        this.f5795o = false;
        this.f5782b = new C1740a(c1767c != null ? c1767c.mo1604a() : Looper.getMainLooper());
        this.f5783c = new WeakReference(c1767c);
    }

    private void mo1549a(R r) {
        this.f5788h = r;
        this.f5793m = null;
        this.f5785e.countDown();
        Status a = this.f5788h.mo1642a();
        if (this.f5791k) {
            this.f5787g = null;
        } else if (this.f5787g != null) {
            this.f5782b.m9787a();
            this.f5782b.m9788a(this.f5787g, mo1550b());
        } else if (this.f5788h instanceof C1458f) {
            this.f5789i = new C1741b();
        }
        Iterator it = this.f5786f.iterator();
        while (it.hasNext()) {
            ((C1709a) it.next()).mo1545a(a);
        }
        this.f5786f.clear();
    }

    private R mo1550b() {
        R r;
        boolean z = true;
        synchronized (this.f5784d) {
            if (this.f5790j) {
                z = false;
            }
            C1896c.m10795a(z, (Object) "Result has already been consumed.");
            C1896c.m10795a(m9650f(), (Object) "Result is not ready.");
            r = this.f5788h;
            this.f5788h = null;
            this.f5787g = null;
            this.f5790j = true;
        }
        mo1551e();
        return r;
    }

    public static void m9642c(C1857g c1857g) {
        if (c1857g instanceof C1458f) {
            try {
                ((C1458f) c1857g).mo1308a();
            } catch (Throwable e) {
                String valueOf = String.valueOf(c1857g);
                Log.w("BasePendingResult", new StringBuilder(String.valueOf(valueOf).length() + 18).append("Unable to release ").append(valueOf).toString(), e);
            }
        }
    }

    public Integer mo1546a() {
        return null;
    }

    public final void mo1547a(C1709a c1709a) {
        boolean z = true;
        C1896c.m10795a(!this.f5790j, (Object) "Result has already been consumed.");
        if (c1709a == null) {
            z = false;
        }
        C1896c.m10799b(z, "Callback cannot be null.");
        synchronized (this.f5784d) {
            if (m9650f()) {
                c1709a.mo1545a(this.f5788h.mo1642a());
            } else {
                this.f5786f.add(c1709a);
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void mo1548a(com.google.android.gms.common.api.C1780h<? super R> r6) {
        /*
        r5 = this;
        r0 = 1;
        r1 = 0;
        r3 = r5.f5784d;
        monitor-enter(r3);
        if (r6 != 0) goto L_0x000c;
    L_0x0007:
        r0 = 0;
        r5.f5787g = r0;	 Catch:{ all -> 0x0027 }
        monitor-exit(r3);	 Catch:{ all -> 0x0027 }
    L_0x000b:
        return;
    L_0x000c:
        r2 = r5.f5790j;	 Catch:{ all -> 0x0027 }
        if (r2 != 0) goto L_0x002a;
    L_0x0010:
        r2 = r0;
    L_0x0011:
        r4 = "Result has already been consumed.";
        com.google.android.gms.common.internal.C1896c.m10795a(r2, r4);	 Catch:{ all -> 0x0027 }
        r2 = r5.f5794n;	 Catch:{ all -> 0x0027 }
        if (r2 != 0) goto L_0x002c;
    L_0x001a:
        r1 = "Cannot set callbacks if then() has been called.";
        com.google.android.gms.common.internal.C1896c.m10795a(r0, r1);	 Catch:{ all -> 0x0027 }
        r0 = r5.m9653i();	 Catch:{ all -> 0x0027 }
        if (r0 == 0) goto L_0x002e;
    L_0x0025:
        monitor-exit(r3);	 Catch:{ all -> 0x0027 }
        goto L_0x000b;
    L_0x0027:
        r0 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x0027 }
        throw r0;
    L_0x002a:
        r2 = r1;
        goto L_0x0011;
    L_0x002c:
        r0 = r1;
        goto L_0x001a;
    L_0x002e:
        r0 = r5.m9650f();	 Catch:{ all -> 0x0027 }
        if (r0 == 0) goto L_0x003f;
    L_0x0034:
        r0 = r5.f5782b;	 Catch:{ all -> 0x0027 }
        r1 = r5.mo1550b();	 Catch:{ all -> 0x0027 }
        r0.m9788a(r6, r1);	 Catch:{ all -> 0x0027 }
    L_0x003d:
        monitor-exit(r3);	 Catch:{ all -> 0x0027 }
        goto L_0x000b;
    L_0x003f:
        r5.f5787g = r6;	 Catch:{ all -> 0x0027 }
        goto L_0x003d;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.b.me.a(com.google.android.gms.common.api.h):void");
    }

    protected abstract R mo1554b(Status status);

    public final void m9647b(R r) {
        boolean z = true;
        synchronized (this.f5784d) {
            if (this.f5792l || this.f5791k || (m9650f() && m9655k())) {
                me.m9642c(r);
                return;
            }
            C1896c.m10795a(!m9650f(), (Object) "Results have already been set");
            if (this.f5790j) {
                z = false;
            }
            C1896c.m10795a(z, (Object) "Result has already been consumed");
            mo1549a((C1857g) r);
        }
    }

    public final void m9648d(Status status) {
        synchronized (this.f5784d) {
            if (!m9650f()) {
                m9647b(mo1554b(status));
                this.f5792l = true;
            }
        }
    }

    protected void mo1551e() {
    }

    public final boolean m9650f() {
        return this.f5785e.getCount() == 0;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m9651g() {
        /*
        r2 = this;
        r1 = r2.f5784d;
        monitor-enter(r1);
        r0 = r2.f5791k;	 Catch:{ all -> 0x0029 }
        if (r0 != 0) goto L_0x000b;
    L_0x0007:
        r0 = r2.f5790j;	 Catch:{ all -> 0x0029 }
        if (r0 == 0) goto L_0x000d;
    L_0x000b:
        monitor-exit(r1);	 Catch:{ all -> 0x0029 }
    L_0x000c:
        return;
    L_0x000d:
        r0 = r2.f5793m;	 Catch:{ all -> 0x0029 }
        if (r0 == 0) goto L_0x0016;
    L_0x0011:
        r0 = r2.f5793m;	 Catch:{ RemoteException -> 0x002c }
        r0.m10986a();	 Catch:{ RemoteException -> 0x002c }
    L_0x0016:
        r0 = r2.f5788h;	 Catch:{ all -> 0x0029 }
        com.google.android.gms.p031b.me.m9642c(r0);	 Catch:{ all -> 0x0029 }
        r0 = 1;
        r2.f5791k = r0;	 Catch:{ all -> 0x0029 }
        r0 = com.google.android.gms.common.api.Status.f6337e;	 Catch:{ all -> 0x0029 }
        r0 = r2.mo1554b(r0);	 Catch:{ all -> 0x0029 }
        r2.mo1549a(r0);	 Catch:{ all -> 0x0029 }
        monitor-exit(r1);	 Catch:{ all -> 0x0029 }
        goto L_0x000c;
    L_0x0029:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0029 }
        throw r0;
    L_0x002c:
        r0 = move-exception;
        goto L_0x0016;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.b.me.g():void");
    }

    public boolean m9652h() {
        boolean i;
        synchronized (this.f5784d) {
            if (((C1767c) this.f5783c.get()) == null || !this.f5795o) {
                m9651g();
            }
            i = m9653i();
        }
        return i;
    }

    public boolean m9653i() {
        boolean z;
        synchronized (this.f5784d) {
            z = this.f5791k;
        }
        return z;
    }

    public void m9654j() {
        boolean z = this.f5795o || ((Boolean) f5781a.get()).booleanValue();
        this.f5795o = z;
    }

    boolean m9655k() {
        return false;
    }
}
