package com.google.android.gms.p031b;

import android.content.Context;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import java.util.ArrayList;
import java.util.List;

@id
public class fv implements fl {
    private final AdRequestInfoParcel f4876a;
    private final fx f4877b;
    private final Context f4878c;
    private final Object f4879d = new Object();
    private final fo f4880e;
    private final boolean f4881f;
    private final long f4882g;
    private final long f4883h;
    private final cy f4884i;
    private final boolean f4885j;
    private boolean f4886k = false;
    private fr f4887l;
    private List<fs> f4888m = new ArrayList();

    public fv(Context context, AdRequestInfoParcel adRequestInfoParcel, fx fxVar, fo foVar, boolean z, boolean z2, long j, long j2, cy cyVar) {
        this.f4878c = context;
        this.f4876a = adRequestInfoParcel;
        this.f4877b = fxVar;
        this.f4880e = foVar;
        this.f4881f = z;
        this.f4885j = z2;
        this.f4882g = j;
        this.f4883h = j2;
        this.f4884i = cyVar;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.android.gms.p031b.fs mo1344a(java.util.List<com.google.android.gms.p031b.fm> r22) {
        /*
        r21 = this;
        r2 = "Starting mediation.";
        com.google.android.gms.ads.internal.util.client.C1324b.m7227a(r2);
        r15 = new java.util.ArrayList;
        r15.<init>();
        r0 = r21;
        r2 = r0.f4884i;
        r16 = r2.m7861a();
        r17 = r22.iterator();
    L_0x0016:
        r2 = r17.hasNext();
        if (r2 == 0) goto L_0x0133;
    L_0x001c:
        r7 = r17.next();
        r7 = (com.google.android.gms.p031b.fm) r7;
        r3 = "Trying mediation network: ";
        r2 = r7.f4791b;
        r2 = java.lang.String.valueOf(r2);
        r4 = r2.length();
        if (r4 == 0) goto L_0x0066;
    L_0x0030:
        r2 = r3.concat(r2);
    L_0x0034:
        com.google.android.gms.ads.internal.util.client.C1324b.m7232c(r2);
        r2 = r7.f4792c;
        r18 = r2.iterator();
    L_0x003d:
        r2 = r18.hasNext();
        if (r2 == 0) goto L_0x0016;
    L_0x0043:
        r4 = r18.next();
        r4 = (java.lang.String) r4;
        r0 = r21;
        r2 = r0.f4884i;
        r19 = r2.m7861a();
        r0 = r21;
        r0 = r0.f4879d;
        r20 = r0;
        monitor-enter(r20);
        r0 = r21;
        r2 = r0.f4886k;	 Catch:{ all -> 0x010a }
        if (r2 == 0) goto L_0x006c;
    L_0x005e:
        r2 = new com.google.android.gms.b.fs;	 Catch:{ all -> 0x010a }
        r3 = -1;
        r2.<init>(r3);	 Catch:{ all -> 0x010a }
        monitor-exit(r20);	 Catch:{ all -> 0x010a }
    L_0x0065:
        return r2;
    L_0x0066:
        r2 = new java.lang.String;
        r2.<init>(r3);
        goto L_0x0034;
    L_0x006c:
        r2 = new com.google.android.gms.b.fr;	 Catch:{ all -> 0x010a }
        r0 = r21;
        r3 = r0.f4878c;	 Catch:{ all -> 0x010a }
        r0 = r21;
        r5 = r0.f4877b;	 Catch:{ all -> 0x010a }
        r0 = r21;
        r6 = r0.f4880e;	 Catch:{ all -> 0x010a }
        r0 = r21;
        r8 = r0.f4876a;	 Catch:{ all -> 0x010a }
        r8 = r8.f3741c;	 Catch:{ all -> 0x010a }
        r0 = r21;
        r9 = r0.f4876a;	 Catch:{ all -> 0x010a }
        r9 = r9.f3742d;	 Catch:{ all -> 0x010a }
        r0 = r21;
        r10 = r0.f4876a;	 Catch:{ all -> 0x010a }
        r10 = r10.f3749k;	 Catch:{ all -> 0x010a }
        r0 = r21;
        r11 = r0.f4881f;	 Catch:{ all -> 0x010a }
        r0 = r21;
        r12 = r0.f4885j;	 Catch:{ all -> 0x010a }
        r0 = r21;
        r13 = r0.f4876a;	 Catch:{ all -> 0x010a }
        r13 = r13.f3764z;	 Catch:{ all -> 0x010a }
        r0 = r21;
        r14 = r0.f4876a;	 Catch:{ all -> 0x010a }
        r14 = r14.f3752n;	 Catch:{ all -> 0x010a }
        r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14);	 Catch:{ all -> 0x010a }
        r0 = r21;
        r0.f4887l = r2;	 Catch:{ all -> 0x010a }
        monitor-exit(r20);	 Catch:{ all -> 0x010a }
        r0 = r21;
        r2 = r0.f4887l;
        r0 = r21;
        r8 = r0.f4882g;
        r0 = r21;
        r10 = r0.f4883h;
        r2 = r2.m8364a(r8, r10);
        r0 = r21;
        r3 = r0.f4888m;
        r3.add(r2);
        r3 = r2.f4850a;
        if (r3 != 0) goto L_0x010d;
    L_0x00c3:
        r3 = "Adapter succeeded.";
        com.google.android.gms.ads.internal.util.client.C1324b.m7227a(r3);
        r0 = r21;
        r3 = r0.f4884i;
        r5 = "mediation_network_succeed";
        r3.m7865a(r5, r4);
        r3 = r15.isEmpty();
        if (r3 != 0) goto L_0x00e6;
    L_0x00d7:
        r0 = r21;
        r3 = r0.f4884i;
        r4 = "mediation_networks_fail";
        r5 = ",";
        r5 = android.text.TextUtils.join(r5, r15);
        r3.m7865a(r4, r5);
    L_0x00e6:
        r0 = r21;
        r3 = r0.f4884i;
        r4 = 1;
        r4 = new java.lang.String[r4];
        r5 = 0;
        r6 = "mls";
        r4[r5] = r6;
        r0 = r19;
        r3.m7867a(r0, r4);
        r0 = r21;
        r3 = r0.f4884i;
        r4 = 1;
        r4 = new java.lang.String[r4];
        r5 = 0;
        r6 = "ttm";
        r4[r5] = r6;
        r0 = r16;
        r3.m7867a(r0, r4);
        goto L_0x0065;
    L_0x010a:
        r2 = move-exception;
        monitor-exit(r20);	 Catch:{ all -> 0x010a }
        throw r2;
    L_0x010d:
        r15.add(r4);
        r0 = r21;
        r3 = r0.f4884i;
        r4 = 1;
        r4 = new java.lang.String[r4];
        r5 = 0;
        r6 = "mlf";
        r4[r5] = r6;
        r0 = r19;
        r3.m7867a(r0, r4);
        r3 = r2.f4852c;
        if (r3 == 0) goto L_0x003d;
    L_0x0125:
        r3 = com.google.android.gms.p031b.jz.f5567a;
        r4 = new com.google.android.gms.b.fv$1;
        r0 = r21;
        r4.<init>(r0, r2);
        r3.post(r4);
        goto L_0x003d;
    L_0x0133:
        r2 = r15.isEmpty();
        if (r2 != 0) goto L_0x0148;
    L_0x0139:
        r0 = r21;
        r2 = r0.f4884i;
        r3 = "mediation_networks_fail";
        r4 = ",";
        r4 = android.text.TextUtils.join(r4, r15);
        r2.m7865a(r3, r4);
    L_0x0148:
        r2 = new com.google.android.gms.b.fs;
        r3 = 1;
        r2.<init>(r3);
        goto L_0x0065;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.b.fv.a(java.util.List):com.google.android.gms.b.fs");
    }

    public void mo1345a() {
        synchronized (this.f4879d) {
            this.f4886k = true;
            if (this.f4887l != null) {
                this.f4887l.m8366a();
            }
        }
    }

    public List<fs> mo1346b() {
        return this.f4888m;
    }
}
