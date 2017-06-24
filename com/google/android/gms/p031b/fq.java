package com.google.android.gms.p031b;

import com.google.android.gms.p031b.fs.C1530a;
import com.google.android.gms.p031b.fz.C1526a;

@id
public final class fq extends C1526a {
    private final Object f4827a = new Object();
    private C1530a f4828b;
    private fp f4829c;

    public void mo1333a() {
        synchronized (this.f4827a) {
            if (this.f4829c != null) {
                this.f4829c.mo991u();
            }
        }
    }

    public void mo1334a(int i) {
        synchronized (this.f4827a) {
            if (this.f4828b != null) {
                this.f4828b.mo1342a(i == 3 ? 1 : 2);
                this.f4828b = null;
            }
        }
    }

    public void m8329a(fp fpVar) {
        synchronized (this.f4827a) {
            this.f4829c = fpVar;
        }
    }

    public void m8330a(C1530a c1530a) {
        synchronized (this.f4827a) {
            this.f4828b = c1530a;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo1335a(com.google.android.gms.p031b.ga r4) {
        /*
        r3 = this;
        r1 = r3.f4827a;
        monitor-enter(r1);
        r0 = r3.f4828b;	 Catch:{ all -> 0x001d }
        if (r0 == 0) goto L_0x0012;
    L_0x0007:
        r0 = r3.f4828b;	 Catch:{ all -> 0x001d }
        r2 = 0;
        r0.mo1343a(r2, r4);	 Catch:{ all -> 0x001d }
        r0 = 0;
        r3.f4828b = r0;	 Catch:{ all -> 0x001d }
        monitor-exit(r1);	 Catch:{ all -> 0x001d }
    L_0x0011:
        return;
    L_0x0012:
        r0 = r3.f4829c;	 Catch:{ all -> 0x001d }
        if (r0 == 0) goto L_0x001b;
    L_0x0016:
        r0 = r3.f4829c;	 Catch:{ all -> 0x001d }
        r0.mo995y();	 Catch:{ all -> 0x001d }
    L_0x001b:
        monitor-exit(r1);	 Catch:{ all -> 0x001d }
        goto L_0x0011;
    L_0x001d:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x001d }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.b.fq.a(com.google.android.gms.b.ga):void");
    }

    public void mo1336b() {
        synchronized (this.f4827a) {
            if (this.f4829c != null) {
                this.f4829c.mo992v();
            }
        }
    }

    public void mo1337c() {
        synchronized (this.f4827a) {
            if (this.f4829c != null) {
                this.f4829c.mo993w();
            }
        }
    }

    public void mo1338d() {
        synchronized (this.f4827a) {
            if (this.f4829c != null) {
                this.f4829c.mo994x();
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo1339e() {
        /*
        r3 = this;
        r1 = r3.f4827a;
        monitor-enter(r1);
        r0 = r3.f4828b;	 Catch:{ all -> 0x001d }
        if (r0 == 0) goto L_0x0012;
    L_0x0007:
        r0 = r3.f4828b;	 Catch:{ all -> 0x001d }
        r2 = 0;
        r0.mo1342a(r2);	 Catch:{ all -> 0x001d }
        r0 = 0;
        r3.f4828b = r0;	 Catch:{ all -> 0x001d }
        monitor-exit(r1);	 Catch:{ all -> 0x001d }
    L_0x0011:
        return;
    L_0x0012:
        r0 = r3.f4829c;	 Catch:{ all -> 0x001d }
        if (r0 == 0) goto L_0x001b;
    L_0x0016:
        r0 = r3.f4829c;	 Catch:{ all -> 0x001d }
        r0.mo995y();	 Catch:{ all -> 0x001d }
    L_0x001b:
        monitor-exit(r1);	 Catch:{ all -> 0x001d }
        goto L_0x0011;
    L_0x001d:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x001d }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.b.fq.e():void");
    }

    public void mo1340f() {
        synchronized (this.f4827a) {
            if (this.f4829c != null) {
                this.f4829c.mo996z();
            }
        }
    }
}
