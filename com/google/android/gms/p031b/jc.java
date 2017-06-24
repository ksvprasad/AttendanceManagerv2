package com.google.android.gms.p031b;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.C1323a;
import com.google.android.gms.ads.internal.util.client.C1324b;
import com.google.android.gms.p031b.jl.C1632a;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.concurrent.Future;
import org.json.JSONObject;

@id
public class jc extends ju implements jb {
    private final C1632a f5399a;
    private final Context f5400b;
    private final ArrayList<Future> f5401c = new ArrayList();
    private final ArrayList<String> f5402d = new ArrayList();
    private final HashSet<String> f5403e = new HashSet();
    private final Object f5404f = new Object();
    private final iw f5405g;

    public jc(Context context, C1632a c1632a, iw iwVar) {
        this.f5400b = context;
        this.f5399a = c1632a;
        this.f5405g = iwVar;
    }

    private jl m9061a(int i, String str, fm fmVar) {
        return new jl(this.f5399a.f5408a.f3741c, null, this.f5399a.f5409b.f3782d, i, this.f5399a.f5409b.f3784f, this.f5399a.f5409b.f3788j, this.f5399a.f5409b.f3790l, this.f5399a.f5409b.f3789k, this.f5399a.f5408a.f3747i, this.f5399a.f5409b.f3786h, fmVar, null, str, this.f5399a.f5410c, null, this.f5399a.f5409b.f3787i, this.f5399a.f5411d, this.f5399a.f5409b.f3785g, this.f5399a.f5413f, this.f5399a.f5409b.f3792n, this.f5399a.f5409b.f3793o, this.f5399a.f5415h, null, this.f5399a.f5409b.f3767C, this.f5399a.f5409b.f3768D, this.f5399a.f5409b.f3769E, this.f5399a.f5409b.f3770F, this.f5399a.f5409b.f3771G, null, this.f5399a.f5409b.f3774J);
    }

    private jl m9062a(String str, fm fmVar) {
        return m9061a(-2, str, fmVar);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m9063a(java.lang.String r4, java.lang.String r5, java.lang.String r6) {
        /*
        r3 = this;
        r1 = r3.f5404f;
        monitor-enter(r1);
        r0 = r3.f5405g;	 Catch:{ all -> 0x002f }
        r0 = r0.m9015c(r4);	 Catch:{ all -> 0x002f }
        if (r0 == 0) goto L_0x0017;
    L_0x000b:
        r2 = r0.m9071b();	 Catch:{ all -> 0x002f }
        if (r2 == 0) goto L_0x0017;
    L_0x0011:
        r2 = r0.m9070a();	 Catch:{ all -> 0x002f }
        if (r2 != 0) goto L_0x0019;
    L_0x0017:
        monitor-exit(r1);	 Catch:{ all -> 0x002f }
    L_0x0018:
        return;
    L_0x0019:
        r0 = r3.m9065a(r4, r5, r6, r0);	 Catch:{ all -> 0x002f }
        r2 = r3.f5401c;	 Catch:{ all -> 0x002f }
        r0 = r0.mo1107e();	 Catch:{ all -> 0x002f }
        r0 = (java.util.concurrent.Future) r0;	 Catch:{ all -> 0x002f }
        r2.add(r0);	 Catch:{ all -> 0x002f }
        r0 = r3.f5402d;	 Catch:{ all -> 0x002f }
        r0.add(r4);	 Catch:{ all -> 0x002f }
        monitor-exit(r1);	 Catch:{ all -> 0x002f }
        goto L_0x0018;
    L_0x002f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x002f }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.b.jc.a(java.lang.String, java.lang.String, java.lang.String):void");
    }

    private jl m9064c() {
        return m9061a(3, null, null);
    }

    protected ix m9065a(String str, String str2, String str3, jd jdVar) {
        return new ix(this.f5400b, str, str2, str3, this.f5399a, jdVar, this);
    }

    public void mo1108a() {
        final jl a;
        for (fm fmVar : this.f5399a.f5410c.f4811a) {
            String str = fmVar.f4798i;
            for (String str2 : fmVar.f4792c) {
                String str22;
                if ("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter".equals(str22)) {
                    try {
                        str22 = new JSONObject(str).getString("class_name");
                    } catch (Throwable e) {
                        C1324b.m7231b("Unable to determine custom event class name, skipping...", e);
                    }
                }
                m9063a(str22, str, fmVar.f4790a);
            }
        }
        int i = 0;
        while (i < this.f5401c.size()) {
            try {
                ((Future) this.f5401c.get(i)).get();
                synchronized (this.f5404f) {
                    if (this.f5403e.contains(this.f5402d.get(i))) {
                        a = m9062a((String) this.f5402d.get(i), (fm) this.f5399a.f5410c.f4811a.get(i));
                        C1323a.f3964a.post(new Runnable(this) {
                            final /* synthetic */ jc f5396b;

                            public void run() {
                                this.f5396b.f5405g.mo966b(a);
                            }
                        });
                        return;
                    }
                }
            } catch (InterruptedException e2) {
            } catch (Exception e3) {
            }
        }
        a = m9064c();
        C1323a.f3964a.post(new Runnable(this) {
            final /* synthetic */ jc f5398b;

            public void run() {
                this.f5398b.f5405g.mo966b(a);
            }
        });
        return;
        i++;
    }

    public void mo1455a(String str) {
        synchronized (this.f5404f) {
            this.f5403e.add(str);
        }
    }

    public void mo1456a(String str, int i) {
    }

    public void mo1109b() {
    }
}
