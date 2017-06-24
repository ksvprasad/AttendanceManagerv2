package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.api.C1767c.C1733c;
import com.google.android.gms.common.api.C1767c.C1742b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;

public final class C1935s implements Callback {
    final ArrayList<C1742b> f6499a = new ArrayList();
    private final C1723a f6500b;
    private final ArrayList<C1742b> f6501c = new ArrayList();
    private final ArrayList<C1733c> f6502d = new ArrayList();
    private volatile boolean f6503e = false;
    private final AtomicInteger f6504f = new AtomicInteger(0);
    private boolean f6505g = false;
    private final Handler f6506h;
    private final Object f6507i = new Object();

    public interface C1723a {
        boolean mo1602d();

        Bundle mo1603t();
    }

    public C1935s(Looper looper, C1723a c1723a) {
        this.f6500b = c1723a;
        this.f6506h = new Handler(looper, this);
    }

    public void m10896a() {
        this.f6503e = false;
        this.f6504f.incrementAndGet();
    }

    public void m10897a(int i) {
        boolean z = false;
        if (Looper.myLooper() == this.f6506h.getLooper()) {
            z = true;
        }
        C1896c.m10795a(z, (Object) "onUnintentionalDisconnection must only be called on the Handler thread");
        this.f6506h.removeMessages(1);
        synchronized (this.f6507i) {
            this.f6505g = true;
            ArrayList arrayList = new ArrayList(this.f6501c);
            int i2 = this.f6504f.get();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                C1742b c1742b = (C1742b) it.next();
                if (!this.f6503e || this.f6504f.get() != i2) {
                    break;
                } else if (this.f6501c.contains(c1742b)) {
                    c1742b.mo1574a(i);
                }
            }
            this.f6499a.clear();
            this.f6505g = false;
        }
    }

    public void m10898a(Bundle bundle) {
        boolean z = true;
        C1896c.m10795a(Looper.myLooper() == this.f6506h.getLooper(), (Object) "onConnectionSuccess must only be called on the Handler thread");
        synchronized (this.f6507i) {
            C1896c.m10794a(!this.f6505g);
            this.f6506h.removeMessages(1);
            this.f6505g = true;
            if (this.f6499a.size() != 0) {
                z = false;
            }
            C1896c.m10794a(z);
            ArrayList arrayList = new ArrayList(this.f6501c);
            int i = this.f6504f.get();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                C1742b c1742b = (C1742b) it.next();
                if (!this.f6503e || !this.f6500b.mo1602d() || this.f6504f.get() != i) {
                    break;
                } else if (!this.f6499a.contains(c1742b)) {
                    c1742b.mo1575a(bundle);
                }
            }
            this.f6499a.clear();
            this.f6505g = false;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m10899a(com.google.android.gms.common.ConnectionResult r6) {
        /*
        r5 = this;
        r1 = 1;
        r0 = android.os.Looper.myLooper();
        r2 = r5.f6506h;
        r2 = r2.getLooper();
        if (r0 != r2) goto L_0x0046;
    L_0x000d:
        r0 = r1;
    L_0x000e:
        r2 = "onConnectionFailure must only be called on the Handler thread";
        com.google.android.gms.common.internal.C1896c.m10795a(r0, r2);
        r0 = r5.f6506h;
        r0.removeMessages(r1);
        r1 = r5.f6507i;
        monitor-enter(r1);
        r0 = new java.util.ArrayList;	 Catch:{ all -> 0x0054 }
        r2 = r5.f6502d;	 Catch:{ all -> 0x0054 }
        r0.<init>(r2);	 Catch:{ all -> 0x0054 }
        r2 = r5.f6504f;	 Catch:{ all -> 0x0054 }
        r2 = r2.get();	 Catch:{ all -> 0x0054 }
        r3 = r0.iterator();	 Catch:{ all -> 0x0054 }
    L_0x002c:
        r0 = r3.hasNext();	 Catch:{ all -> 0x0054 }
        if (r0 == 0) goto L_0x0057;
    L_0x0032:
        r0 = r3.next();	 Catch:{ all -> 0x0054 }
        r0 = (com.google.android.gms.common.api.C1767c.C1733c) r0;	 Catch:{ all -> 0x0054 }
        r4 = r5.f6503e;	 Catch:{ all -> 0x0054 }
        if (r4 == 0) goto L_0x0044;
    L_0x003c:
        r4 = r5.f6504f;	 Catch:{ all -> 0x0054 }
        r4 = r4.get();	 Catch:{ all -> 0x0054 }
        if (r4 == r2) goto L_0x0048;
    L_0x0044:
        monitor-exit(r1);	 Catch:{ all -> 0x0054 }
    L_0x0045:
        return;
    L_0x0046:
        r0 = 0;
        goto L_0x000e;
    L_0x0048:
        r4 = r5.f6502d;	 Catch:{ all -> 0x0054 }
        r4 = r4.contains(r0);	 Catch:{ all -> 0x0054 }
        if (r4 == 0) goto L_0x002c;
    L_0x0050:
        r0.mo1564a(r6);	 Catch:{ all -> 0x0054 }
        goto L_0x002c;
    L_0x0054:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0054 }
        throw r0;
    L_0x0057:
        monitor-exit(r1);	 Catch:{ all -> 0x0054 }
        goto L_0x0045;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.internal.s.a(com.google.android.gms.common.ConnectionResult):void");
    }

    public void m10900a(C1742b c1742b) {
        C1896c.m10790a((Object) c1742b);
        synchronized (this.f6507i) {
            if (this.f6501c.contains(c1742b)) {
                String valueOf = String.valueOf(c1742b);
                Log.w("GmsClientEvents", new StringBuilder(String.valueOf(valueOf).length() + 62).append("registerConnectionCallbacks(): listener ").append(valueOf).append(" is already registered").toString());
            } else {
                this.f6501c.add(c1742b);
            }
        }
        if (this.f6500b.mo1602d()) {
            this.f6506h.sendMessage(this.f6506h.obtainMessage(1, c1742b));
        }
    }

    public void m10901a(C1733c c1733c) {
        C1896c.m10790a((Object) c1733c);
        synchronized (this.f6507i) {
            if (this.f6502d.contains(c1733c)) {
                String valueOf = String.valueOf(c1733c);
                Log.w("GmsClientEvents", new StringBuilder(String.valueOf(valueOf).length() + 67).append("registerConnectionFailedListener(): listener ").append(valueOf).append(" is already registered").toString());
            } else {
                this.f6502d.add(c1733c);
            }
        }
    }

    public void m10902b() {
        this.f6503e = true;
    }

    public void m10903b(C1733c c1733c) {
        C1896c.m10790a((Object) c1733c);
        synchronized (this.f6507i) {
            if (!this.f6502d.remove(c1733c)) {
                String valueOf = String.valueOf(c1733c);
                Log.w("GmsClientEvents", new StringBuilder(String.valueOf(valueOf).length() + 57).append("unregisterConnectionFailedListener(): listener ").append(valueOf).append(" not found").toString());
            }
        }
    }

    public boolean handleMessage(Message message) {
        if (message.what == 1) {
            C1742b c1742b = (C1742b) message.obj;
            synchronized (this.f6507i) {
                if (this.f6503e && this.f6500b.mo1602d() && this.f6501c.contains(c1742b)) {
                    c1742b.mo1575a(this.f6500b.mo1603t());
                }
            }
            return true;
        }
        Log.wtf("GmsClientEvents", "Don't know how to handle message: " + message.what, new Exception());
        return false;
    }
}
