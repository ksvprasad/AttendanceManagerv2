package com.google.android.gms.p031b;

import android.content.Context;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.ads.internal.util.client.C1324b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@id
public class fu implements fl {
    private final AdRequestInfoParcel f4861a;
    private final fx f4862b;
    private final Context f4863c;
    private final fo f4864d;
    private final boolean f4865e;
    private final long f4866f;
    private final long f4867g;
    private final int f4868h;
    private final Object f4869i = new Object();
    private boolean f4870j = false;
    private final Map<kq<fs>, fr> f4871k = new HashMap();
    private final boolean f4872l;
    private List<fs> f4873m = new ArrayList();

    public fu(Context context, AdRequestInfoParcel adRequestInfoParcel, fx fxVar, fo foVar, boolean z, boolean z2, long j, long j2, int i) {
        this.f4863c = context;
        this.f4861a = adRequestInfoParcel;
        this.f4862b = fxVar;
        this.f4864d = foVar;
        this.f4865e = z;
        this.f4872l = z2;
        this.f4866f = j;
        this.f4867g = j2;
        this.f4868h = i;
    }

    private void m8373a(final kq<fs> kqVar) {
        jz.f5567a.post(new Runnable(this) {
            final /* synthetic */ fu f4860b;

            public void run() {
                for (kq kqVar : this.f4860b.f4871k.keySet()) {
                    if (kqVar != kqVar) {
                        ((fr) this.f4860b.f4871k.get(kqVar)).m8366a();
                    }
                }
            }
        });
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.google.android.gms.p031b.fs m8374b(java.util.List<com.google.android.gms.p031b.kq<com.google.android.gms.p031b.fs>> r5) {
        /*
        r4 = this;
        r2 = r4.f4869i;
        monitor-enter(r2);
        r0 = r4.f4870j;	 Catch:{ all -> 0x003c }
        if (r0 == 0) goto L_0x000f;
    L_0x0007:
        r1 = new com.google.android.gms.b.fs;	 Catch:{ all -> 0x003c }
        r0 = -1;
        r1.<init>(r0);	 Catch:{ all -> 0x003c }
        monitor-exit(r2);	 Catch:{ all -> 0x003c }
    L_0x000e:
        return r1;
    L_0x000f:
        monitor-exit(r2);	 Catch:{ all -> 0x003c }
        r2 = r5.iterator();
    L_0x0014:
        r0 = r2.hasNext();
        if (r0 == 0) goto L_0x003f;
    L_0x001a:
        r0 = r2.next();
        r0 = (com.google.android.gms.p031b.kq) r0;
        r1 = r0.get();	 Catch:{ InterruptedException -> 0x0035, ExecutionException -> 0x004a }
        r1 = (com.google.android.gms.p031b.fs) r1;	 Catch:{ InterruptedException -> 0x0035, ExecutionException -> 0x004a }
        r3 = r4.f4873m;	 Catch:{ InterruptedException -> 0x0035, ExecutionException -> 0x004a }
        r3.add(r1);	 Catch:{ InterruptedException -> 0x0035, ExecutionException -> 0x004a }
        if (r1 == 0) goto L_0x0014;
    L_0x002d:
        r3 = r1.f4850a;	 Catch:{ InterruptedException -> 0x0035, ExecutionException -> 0x004a }
        if (r3 != 0) goto L_0x0014;
    L_0x0031:
        r4.m8373a(r0);	 Catch:{ InterruptedException -> 0x0035, ExecutionException -> 0x004a }
        goto L_0x000e;
    L_0x0035:
        r0 = move-exception;
    L_0x0036:
        r1 = "Exception while processing an adapter; continuing with other adapters";
        com.google.android.gms.ads.internal.util.client.C1324b.m7235d(r1, r0);
        goto L_0x0014;
    L_0x003c:
        r0 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x003c }
        throw r0;
    L_0x003f:
        r0 = 0;
        r4.m8373a(r0);
        r1 = new com.google.android.gms.b.fs;
        r0 = 1;
        r1.<init>(r0);
        goto L_0x000e;
    L_0x004a:
        r0 = move-exception;
        goto L_0x0036;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.b.fu.b(java.util.List):com.google.android.gms.b.fs");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.google.android.gms.p031b.fs m8377c(java.util.List<com.google.android.gms.p031b.kq<com.google.android.gms.p031b.fs>> r16) {
        /*
        r15 = this;
        r1 = r15.f4869i;
        monitor-enter(r1);
        r0 = r15.f4870j;	 Catch:{ all -> 0x0080 }
        if (r0 == 0) goto L_0x000f;
    L_0x0007:
        r2 = new com.google.android.gms.b.fs;	 Catch:{ all -> 0x0080 }
        r0 = -1;
        r2.<init>(r0);	 Catch:{ all -> 0x0080 }
        monitor-exit(r1);	 Catch:{ all -> 0x0080 }
    L_0x000e:
        return r2;
    L_0x000f:
        monitor-exit(r1);	 Catch:{ all -> 0x0080 }
        r4 = -1;
        r3 = 0;
        r2 = 0;
        r0 = r15.f4864d;
        r0 = r0.f4823m;
        r6 = -1;
        r0 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1));
        if (r0 == 0) goto L_0x0083;
    L_0x001d:
        r0 = r15.f4864d;
        r0 = r0.f4823m;
    L_0x0021:
        r8 = r16.iterator();
        r6 = r0;
    L_0x0026:
        r0 = r8.hasNext();
        if (r0 == 0) goto L_0x00b9;
    L_0x002c:
        r0 = r8.next();
        r0 = (com.google.android.gms.p031b.kq) r0;
        r1 = com.google.android.gms.ads.internal.C1319u.m7187i();
        r10 = r1.mo1723a();
        r12 = 0;
        r1 = (r6 > r12 ? 1 : (r6 == r12 ? 0 : -1));
        if (r1 != 0) goto L_0x0086;
    L_0x0040:
        r1 = r0.isDone();	 Catch:{ InterruptedException -> 0x00c6, ExecutionException -> 0x00c8, RemoteException -> 0x008f, TimeoutException -> 0x00ca }
        if (r1 == 0) goto L_0x0086;
    L_0x0046:
        r1 = r0.get();	 Catch:{ InterruptedException -> 0x00c6, ExecutionException -> 0x00c8, RemoteException -> 0x008f, TimeoutException -> 0x00ca }
        r1 = (com.google.android.gms.p031b.fs) r1;	 Catch:{ InterruptedException -> 0x00c6, ExecutionException -> 0x00c8, RemoteException -> 0x008f, TimeoutException -> 0x00ca }
    L_0x004c:
        r5 = r15.f4873m;	 Catch:{ InterruptedException -> 0x00c6, ExecutionException -> 0x00c8, RemoteException -> 0x008f, TimeoutException -> 0x00ca }
        r5.add(r1);	 Catch:{ InterruptedException -> 0x00c6, ExecutionException -> 0x00c8, RemoteException -> 0x008f, TimeoutException -> 0x00ca }
        if (r1 == 0) goto L_0x00cc;
    L_0x0053:
        r5 = r1.f4850a;	 Catch:{ InterruptedException -> 0x00c6, ExecutionException -> 0x00c8, RemoteException -> 0x008f, TimeoutException -> 0x00ca }
        if (r5 != 0) goto L_0x00cc;
    L_0x0057:
        r5 = r1.f4855f;	 Catch:{ InterruptedException -> 0x00c6, ExecutionException -> 0x00c8, RemoteException -> 0x008f, TimeoutException -> 0x00ca }
        if (r5 == 0) goto L_0x00cc;
    L_0x005b:
        r9 = r5.mo1341a();	 Catch:{ InterruptedException -> 0x00c6, ExecutionException -> 0x00c8, RemoteException -> 0x008f, TimeoutException -> 0x00ca }
        if (r9 <= r4) goto L_0x00cc;
    L_0x0061:
        r2 = r5.mo1341a();	 Catch:{ InterruptedException -> 0x00c6, ExecutionException -> 0x00c8, RemoteException -> 0x008f, TimeoutException -> 0x00ca }
        r14 = r1;
        r1 = r0;
        r0 = r14;
    L_0x0068:
        r3 = com.google.android.gms.ads.internal.C1319u.m7187i();
        r4 = r3.mo1723a();
        r4 = r4 - r10;
        r4 = r6 - r4;
        r6 = 0;
        r4 = java.lang.Math.max(r4, r6);
        r3 = r1;
        r14 = r0;
        r0 = r4;
        r4 = r2;
        r2 = r14;
    L_0x007e:
        r6 = r0;
        goto L_0x0026;
    L_0x0080:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0080 }
        throw r0;
    L_0x0083:
        r0 = 10000; // 0x2710 float:1.4013E-41 double:4.9407E-320;
        goto L_0x0021;
    L_0x0086:
        r1 = java.util.concurrent.TimeUnit.MILLISECONDS;	 Catch:{ InterruptedException -> 0x00c6, ExecutionException -> 0x00c8, RemoteException -> 0x008f, TimeoutException -> 0x00ca }
        r1 = r0.get(r6, r1);	 Catch:{ InterruptedException -> 0x00c6, ExecutionException -> 0x00c8, RemoteException -> 0x008f, TimeoutException -> 0x00ca }
        r1 = (com.google.android.gms.p031b.fs) r1;	 Catch:{ InterruptedException -> 0x00c6, ExecutionException -> 0x00c8, RemoteException -> 0x008f, TimeoutException -> 0x00ca }
        goto L_0x004c;
    L_0x008f:
        r0 = move-exception;
    L_0x0090:
        r1 = "Exception while processing an adapter; continuing with other adapters";
        com.google.android.gms.ads.internal.util.client.C1324b.m7235d(r1, r0);	 Catch:{ all -> 0x00a7 }
        r0 = com.google.android.gms.ads.internal.C1319u.m7187i();
        r0 = r0.mo1723a();
        r0 = r0 - r10;
        r0 = r6 - r0;
        r6 = 0;
        r0 = java.lang.Math.max(r0, r6);
        goto L_0x007e;
    L_0x00a7:
        r0 = move-exception;
        r1 = com.google.android.gms.ads.internal.C1319u.m7187i();
        r2 = r1.mo1723a();
        r2 = r2 - r10;
        r2 = r6 - r2;
        r4 = 0;
        java.lang.Math.max(r2, r4);
        throw r0;
    L_0x00b9:
        r15.m8373a(r3);
        if (r2 != 0) goto L_0x000e;
    L_0x00be:
        r2 = new com.google.android.gms.b.fs;
        r0 = 1;
        r2.<init>(r0);
        goto L_0x000e;
    L_0x00c6:
        r0 = move-exception;
        goto L_0x0090;
    L_0x00c8:
        r0 = move-exception;
        goto L_0x0090;
    L_0x00ca:
        r0 = move-exception;
        goto L_0x0090;
    L_0x00cc:
        r0 = r2;
        r1 = r3;
        r2 = r4;
        goto L_0x0068;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.b.fu.c(java.util.List):com.google.android.gms.b.fs");
    }

    public fs mo1344a(List<fm> list) {
        C1324b.m7227a("Starting mediation.");
        ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
        List arrayList = new ArrayList();
        for (fm fmVar : list) {
            String str = "Trying mediation network: ";
            String valueOf = String.valueOf(fmVar.f4791b);
            C1324b.m7232c(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
            for (String frVar : fmVar.f4792c) {
                final fr frVar2 = new fr(this.f4863c, frVar, this.f4862b, this.f4864d, fmVar, this.f4861a.f3741c, this.f4861a.f3742d, this.f4861a.f3749k, this.f4865e, this.f4872l, this.f4861a.f3764z, this.f4861a.f3752n);
                kq a = jy.m9182a(newCachedThreadPool, new Callable<fs>(this) {
                    final /* synthetic */ fu f4858b;

                    public fs m8371a() {
                        synchronized (this.f4858b.f4869i) {
                            if (this.f4858b.f4870j) {
                                return null;
                            }
                            return frVar2.m8364a(this.f4858b.f4866f, this.f4858b.f4867g);
                        }
                    }

                    public /* synthetic */ Object call() {
                        return m8371a();
                    }
                });
                this.f4871k.put(a, frVar2);
                arrayList.add(a);
            }
        }
        switch (this.f4868h) {
            case 2:
                return m8377c(arrayList);
            default:
                return m8374b(arrayList);
        }
    }

    public void mo1345a() {
        synchronized (this.f4869i) {
            this.f4870j = true;
            for (fr a : this.f4871k.values()) {
                a.m8366a();
            }
        }
    }

    public List<fs> mo1346b() {
        return this.f4873m;
    }
}
