package com.google.android.gms.p031b;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.C0260n;
import android.support.v4.app.Fragment;
import android.support.v4.p015g.C0370a;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.Map.Entry;
import java.util.WeakHashMap;

public final class nf extends Fragment implements mw {
    private static WeakHashMap<C0260n, WeakReference<nf>> f6027a = new WeakHashMap();
    private Map<String, mv> f6028b = new C0370a();
    private int f6029c = 0;
    private Bundle f6030d;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.p031b.nf m10098a(android.support.v4.app.C0260n r3) {
        /*
        r0 = f6027a;
        r0 = r0.get(r3);
        r0 = (java.lang.ref.WeakReference) r0;
        if (r0 == 0) goto L_0x0013;
    L_0x000a:
        r0 = r0.get();
        r0 = (com.google.android.gms.p031b.nf) r0;
        if (r0 == 0) goto L_0x0013;
    L_0x0012:
        return r0;
    L_0x0013:
        r0 = r3.m1461f();	 Catch:{ ClassCastException -> 0x0048 }
        r1 = "SupportLifecycleFragmentImpl";
        r0 = r0.mo223a(r1);	 Catch:{ ClassCastException -> 0x0048 }
        r0 = (com.google.android.gms.p031b.nf) r0;	 Catch:{ ClassCastException -> 0x0048 }
        if (r0 == 0) goto L_0x0027;
    L_0x0021:
        r1 = r0.m1207o();
        if (r1 == 0) goto L_0x003d;
    L_0x0027:
        r0 = new com.google.android.gms.b.nf;
        r0.<init>();
        r1 = r3.m1461f();
        r1 = r1.mo224a();
        r2 = "SupportLifecycleFragmentImpl";
        r1 = r1.mo191a(r0, r2);
        r1.mo192b();
    L_0x003d:
        r1 = f6027a;
        r2 = new java.lang.ref.WeakReference;
        r2.<init>(r0);
        r1.put(r3, r2);
        goto L_0x0012;
    L_0x0048:
        r0 = move-exception;
        r1 = new java.lang.IllegalStateException;
        r2 = "Fragment with tag SupportLifecycleFragmentImpl is not a SupportLifecycleFragmentImpl";
        r1.<init>(r2, r0);
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.b.nf.a(android.support.v4.app.n):com.google.android.gms.b.nf");
    }

    private void m10100b(final String str, final mv mvVar) {
        if (this.f6029c > 0) {
            new Handler(Looper.getMainLooper()).post(new Runnable(this) {
                final /* synthetic */ nf f6026c;

                public void run() {
                    if (this.f6026c.f6029c >= 1) {
                        mvVar.mo1567a(this.f6026c.f6030d != null ? this.f6026c.f6030d.getBundle(str) : null);
                    }
                    if (this.f6026c.f6029c >= 2) {
                        mvVar.mo1565a();
                    }
                    if (this.f6026c.f6029c >= 3) {
                        mvVar.mo1568b();
                    }
                }
            });
        }
    }

    public /* synthetic */ Activity mo1616a() {
        return m10107b();
    }

    public <T extends mv> T mo1617a(String str, Class<T> cls) {
        return (mv) cls.cast(this.f6028b.get(str));
    }

    public void mo1619a(int i, int i2, Intent intent) {
        super.mo1619a(i, i2, intent);
        for (mv a : this.f6028b.values()) {
            a.mo1566a(i, i2, intent);
        }
    }

    public void mo198a(Bundle bundle) {
        super.mo198a(bundle);
        this.f6029c = 1;
        this.f6030d = bundle;
        for (Entry entry : this.f6028b.entrySet()) {
            ((mv) entry.getValue()).mo1567a(bundle != null ? bundle.getBundle((String) entry.getKey()) : null);
        }
    }

    public void mo1618a(String str, mv mvVar) {
        if (this.f6028b.containsKey(str)) {
            throw new IllegalArgumentException(new StringBuilder(String.valueOf(str).length() + 59).append("LifecycleCallback with tag ").append(str).append(" already added to this fragment.").toString());
        }
        this.f6028b.put(str, mvVar);
        m10100b(str, mvVar);
    }

    public void mo1620a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.mo1620a(str, fileDescriptor, printWriter, strArr);
        for (mv a : this.f6028b.values()) {
            a.mo1571a(str, fileDescriptor, printWriter, strArr);
        }
    }

    public C0260n m10107b() {
        return m1200j();
    }

    public void mo201d() {
        super.mo203e();
        this.f6029c = 2;
        for (mv a : this.f6028b.values()) {
            a.mo1565a();
        }
    }

    public void mo203e() {
        super.mo203e();
        this.f6029c = 3;
        for (mv b : this.f6028b.values()) {
            b.mo1568b();
        }
    }

    public void mo204e(Bundle bundle) {
        super.mo204e(bundle);
        if (bundle != null) {
            for (Entry entry : this.f6028b.entrySet()) {
                Bundle bundle2 = new Bundle();
                ((mv) entry.getValue()).mo1569b(bundle2);
                bundle.putBundle((String) entry.getKey(), bundle2);
            }
        }
    }
}
