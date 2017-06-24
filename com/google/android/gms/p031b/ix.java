package com.google.android.gms.p031b;

import android.content.Context;
import com.google.android.gms.ads.internal.C1319u;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.util.client.C1323a;
import com.google.android.gms.ads.internal.util.client.C1324b;
import com.google.android.gms.p031b.jl.C1632a;
import com.google.android.gms.p033a.C1001b;

@id
public class ix extends ju implements iy, jb {
    private final C1632a f5318a;
    private final Context f5319b;
    private final jd f5320c;
    private final jb f5321d;
    private final Object f5322e;
    private final String f5323f;
    private final String f5324g;
    private final String f5325h;
    private int f5326i = 0;
    private int f5327j = 3;

    public ix(Context context, String str, String str2, String str3, C1632a c1632a, jd jdVar, jb jbVar) {
        this.f5319b = context;
        this.f5323f = str;
        this.f5324g = str2;
        this.f5325h = str3;
        this.f5318a = c1632a;
        this.f5320c = jdVar;
        this.f5322e = new Object();
        this.f5321d = jbVar;
    }

    private void m9022a(AdRequestParcel adRequestParcel, fy fyVar) {
        try {
            if ("com.google.ads.mediation.admob.AdMobAdapter".equals(this.f5323f)) {
                fyVar.mo1358a(adRequestParcel, this.f5324g, this.f5325h);
            } else {
                fyVar.mo1357a(adRequestParcel, this.f5324g);
            }
        } catch (Throwable e) {
            C1324b.m7235d("Fail to load ad from adapter.", e);
            mo1456a(this.f5323f, 0);
        }
    }

    private void m9025b(long j) {
        while (true) {
            synchronized (this.f5322e) {
                if (this.f5326i != 0) {
                    return;
                } else if (!m9031a(j)) {
                    return;
                }
            }
        }
    }

    public void mo1108a() {
        if (this.f5320c != null && this.f5320c.m9071b() != null && this.f5320c.m9070a() != null) {
            final ja b = this.f5320c.m9071b();
            b.m9052a((jb) this);
            b.m9051a((iy) this);
            final AdRequestParcel adRequestParcel = this.f5318a.f5408a.f3741c;
            final fy a = this.f5320c.m9070a();
            try {
                if (a.mo1364g()) {
                    C1323a.f3964a.post(new Runnable(this) {
                        final /* synthetic */ ix f5313c;

                        public void run() {
                            this.f5313c.m9022a(adRequestParcel, a);
                        }
                    });
                } else {
                    C1323a.f3964a.post(new Runnable(this) {
                        final /* synthetic */ ix f5317d;

                        public void run() {
                            try {
                                a.mo1351a(C1001b.m5713a(this.f5317d.f5319b), adRequestParcel, null, b, this.f5317d.f5324g);
                            } catch (Throwable e) {
                                Throwable th = e;
                                String str = "Fail to initialize adapter ";
                                String valueOf = String.valueOf(this.f5317d.f5323f);
                                C1324b.m7235d(valueOf.length() != 0 ? str.concat(valueOf) : new String(str), th);
                                this.f5317d.mo1456a(this.f5317d.f5323f, 0);
                            }
                        }
                    });
                }
            } catch (Throwable e) {
                C1324b.m7235d("Fail to check if adapter is initialized.", e);
                mo1456a(this.f5323f, 0);
            }
            m9025b(C1319u.m7187i().mo1724b());
            b.m9052a(null);
            b.m9051a(null);
            if (this.f5326i == 1) {
                this.f5321d.mo1455a(this.f5323f);
            } else {
                this.f5321d.mo1456a(this.f5323f, this.f5327j);
            }
        }
    }

    public void mo1454a(int i) {
        mo1456a(this.f5323f, 0);
    }

    public void mo1455a(String str) {
        synchronized (this.f5322e) {
            this.f5326i = 1;
            this.f5322e.notify();
        }
    }

    public void mo1456a(String str, int i) {
        synchronized (this.f5322e) {
            this.f5326i = 2;
            this.f5327j = i;
            this.f5322e.notify();
        }
    }

    protected boolean m9031a(long j) {
        long b = 20000 - (C1319u.m7187i().mo1724b() - j);
        if (b <= 0) {
            return false;
        }
        try {
            this.f5322e.wait(b);
            return true;
        } catch (InterruptedException e) {
            return false;
        }
    }

    public void mo1109b() {
    }

    public void mo1457c() {
        m9022a(this.f5318a.f5408a.f3741c, this.f5320c.m9070a());
    }
}
