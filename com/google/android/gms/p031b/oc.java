package com.google.android.gms.p031b;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.os.WorkSource;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.C1896c;
import com.google.android.gms.common.util.C1979l;
import com.google.android.gms.common.util.C1981n;
import com.google.android.gms.common.util.C1984q;

public class oc {
    private static String f6231a = "WakeLock";
    private static String f6232b = "*gcore*:";
    private static boolean f6233c = false;
    private final WakeLock f6234d;
    private WorkSource f6235e;
    private final int f6236f;
    private final String f6237g;
    private final String f6238h;
    private final String f6239i;
    private final Context f6240j;
    private boolean f6241k;
    private int f6242l;
    private int f6243m;

    public oc(Context context, int i, String str) {
        this(context, i, str, null, context == null ? null : context.getPackageName());
    }

    @SuppressLint({"UnwrappedWakeLock"})
    public oc(Context context, int i, String str, String str2, String str3) {
        this(context, i, str, str2, str3, null);
    }

    @SuppressLint({"UnwrappedWakeLock"})
    public oc(Context context, int i, String str, String str2, String str3, String str4) {
        this.f6241k = true;
        C1896c.m10793a(str, (Object) "Wake lock name can NOT be empty");
        this.f6236f = i;
        this.f6238h = str2;
        this.f6239i = str4;
        this.f6240j = context.getApplicationContext();
        if ("com.google.android.gms".equals(context.getPackageName())) {
            this.f6237g = str;
        } else {
            String valueOf = String.valueOf(f6232b);
            String valueOf2 = String.valueOf(str);
            this.f6237g = valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
        }
        this.f6234d = ((PowerManager) context.getSystemService("power")).newWakeLock(i, str);
        if (C1984q.m11133a(this.f6240j)) {
            if (C1981n.m11122a(str3)) {
                str3 = context.getPackageName();
            }
            this.f6235e = C1984q.m11129a(context, str3);
            m10351a(this.f6235e);
        }
    }

    private String m10344a(String str, boolean z) {
        return this.f6241k ? z ? str : this.f6238h : this.f6238h;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m10345a(java.lang.String r10) {
        /*
        r9 = this;
        r0 = r9.m10348b(r10);
        r5 = r9.m10344a(r10, r0);
        monitor-enter(r9);
        r1 = r9.f6241k;	 Catch:{ all -> 0x0045 }
        if (r1 == 0) goto L_0x0017;
    L_0x000d:
        r1 = r9.f6242l;	 Catch:{ all -> 0x0045 }
        r1 = r1 + -1;
        r9.f6242l = r1;	 Catch:{ all -> 0x0045 }
        if (r1 == 0) goto L_0x0020;
    L_0x0015:
        if (r0 != 0) goto L_0x0020;
    L_0x0017:
        r0 = r9.f6241k;	 Catch:{ all -> 0x0045 }
        if (r0 != 0) goto L_0x0043;
    L_0x001b:
        r0 = r9.f6243m;	 Catch:{ all -> 0x0045 }
        r1 = 1;
        if (r0 != r1) goto L_0x0043;
    L_0x0020:
        r0 = com.google.android.gms.common.stats.C1967h.m11064a();	 Catch:{ all -> 0x0045 }
        r1 = r9.f6240j;	 Catch:{ all -> 0x0045 }
        r2 = r9.f6234d;	 Catch:{ all -> 0x0045 }
        r2 = com.google.android.gms.common.stats.C1965f.m11058a(r2, r5);	 Catch:{ all -> 0x0045 }
        r3 = 8;
        r4 = r9.f6237g;	 Catch:{ all -> 0x0045 }
        r6 = r9.f6239i;	 Catch:{ all -> 0x0045 }
        r7 = r9.f6236f;	 Catch:{ all -> 0x0045 }
        r8 = r9.f6235e;	 Catch:{ all -> 0x0045 }
        r8 = com.google.android.gms.common.util.C1984q.m11135b(r8);	 Catch:{ all -> 0x0045 }
        r0.m11067a(r1, r2, r3, r4, r5, r6, r7, r8);	 Catch:{ all -> 0x0045 }
        r0 = r9.f6243m;	 Catch:{ all -> 0x0045 }
        r0 = r0 + -1;
        r9.f6243m = r0;	 Catch:{ all -> 0x0045 }
    L_0x0043:
        monitor-exit(r9);	 Catch:{ all -> 0x0045 }
        return;
    L_0x0045:
        r0 = move-exception;
        monitor-exit(r9);	 Catch:{ all -> 0x0045 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.b.oc.a(java.lang.String):void");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m10346a(java.lang.String r13, long r14) {
        /*
        r12 = this;
        r0 = r12.m10348b(r13);
        r6 = r12.m10344a(r13, r0);
        monitor-enter(r12);
        r1 = r12.f6241k;	 Catch:{ all -> 0x0044 }
        if (r1 == 0) goto L_0x0017;
    L_0x000d:
        r1 = r12.f6242l;	 Catch:{ all -> 0x0044 }
        r2 = r1 + 1;
        r12.f6242l = r2;	 Catch:{ all -> 0x0044 }
        if (r1 == 0) goto L_0x001f;
    L_0x0015:
        if (r0 != 0) goto L_0x001f;
    L_0x0017:
        r0 = r12.f6241k;	 Catch:{ all -> 0x0044 }
        if (r0 != 0) goto L_0x0042;
    L_0x001b:
        r0 = r12.f6243m;	 Catch:{ all -> 0x0044 }
        if (r0 != 0) goto L_0x0042;
    L_0x001f:
        r1 = com.google.android.gms.common.stats.C1967h.m11064a();	 Catch:{ all -> 0x0044 }
        r2 = r12.f6240j;	 Catch:{ all -> 0x0044 }
        r0 = r12.f6234d;	 Catch:{ all -> 0x0044 }
        r3 = com.google.android.gms.common.stats.C1965f.m11058a(r0, r6);	 Catch:{ all -> 0x0044 }
        r4 = 7;
        r5 = r12.f6237g;	 Catch:{ all -> 0x0044 }
        r7 = r12.f6239i;	 Catch:{ all -> 0x0044 }
        r8 = r12.f6236f;	 Catch:{ all -> 0x0044 }
        r0 = r12.f6235e;	 Catch:{ all -> 0x0044 }
        r9 = com.google.android.gms.common.util.C1984q.m11135b(r0);	 Catch:{ all -> 0x0044 }
        r10 = r14;
        r1.m11068a(r2, r3, r4, r5, r6, r7, r8, r9, r10);	 Catch:{ all -> 0x0044 }
        r0 = r12.f6243m;	 Catch:{ all -> 0x0044 }
        r0 = r0 + 1;
        r12.f6243m = r0;	 Catch:{ all -> 0x0044 }
    L_0x0042:
        monitor-exit(r12);	 Catch:{ all -> 0x0044 }
        return;
    L_0x0044:
        r0 = move-exception;
        monitor-exit(r12);	 Catch:{ all -> 0x0044 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.b.oc.a(java.lang.String, long):void");
    }

    private void m10347b(WorkSource workSource) {
        try {
            this.f6234d.setWorkSource(workSource);
        } catch (IllegalArgumentException e) {
            Log.wtf(f6231a, e.toString());
        }
    }

    private boolean m10348b(String str) {
        return (TextUtils.isEmpty(str) || str.equals(this.f6238h)) ? false : true;
    }

    public void m10349a() {
        m10345a(null);
        this.f6234d.release();
    }

    public void m10350a(long j) {
        if (!C1979l.m11110d() && this.f6241k) {
            String str = f6231a;
            String str2 = "Do not acquire with timeout on reference counted WakeLocks before ICS. wakelock: ";
            String valueOf = String.valueOf(this.f6237g);
            Log.wtf(str, valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
        }
        m10346a(null, j);
        this.f6234d.acquire(j);
    }

    public void m10351a(WorkSource workSource) {
        if (workSource != null && C1984q.m11133a(this.f6240j)) {
            if (this.f6235e != null) {
                this.f6235e.add(workSource);
            } else {
                this.f6235e = workSource;
            }
            m10347b(this.f6235e);
        }
    }

    public void m10352a(boolean z) {
        this.f6234d.setReferenceCounted(z);
        this.f6241k = z;
    }

    public boolean m10353b() {
        return this.f6234d.isHeld();
    }
}
