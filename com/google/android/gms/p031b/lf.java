package com.google.android.gms.p031b;

import com.google.android.gms.ads.internal.C1319u;
import com.google.android.gms.ads.internal.client.C1081c.C1083a;
import com.google.android.gms.ads.internal.client.C1084d;
import com.google.android.gms.ads.internal.util.client.C1324b;
import com.google.android.gms.common.util.C1971d;
import java.util.HashMap;
import java.util.Map;

@id
public class lf extends C1083a {
    private final la f5746a;
    private final Object f5747b = new Object();
    private final float f5748c;
    private int f5749d;
    private C1084d f5750e;
    private boolean f5751f;
    private boolean f5752g;
    private float f5753h;
    private boolean f5754i = true;

    public lf(la laVar, float f) {
        this.f5746a = laVar;
        this.f5748c = f;
    }

    private void m9604a(final int i, final int i2) {
        C1319u.m7183e().m9222a(new Runnable(this) {
            final /* synthetic */ lf f5745c;

            public void run() {
                boolean z = false;
                synchronized (this.f5745c.f5747b) {
                    boolean z2 = i != i2;
                    boolean z3 = !this.f5745c.f5751f && i2 == 1;
                    boolean z4 = z2 && i2 == 1;
                    boolean z5 = z2 && i2 == 2;
                    z2 = z2 && i2 == 3;
                    lf lfVar = this.f5745c;
                    if (this.f5745c.f5751f || z3) {
                        z = true;
                    }
                    lfVar.f5751f = z;
                    if (this.f5745c.f5750e == null) {
                        return;
                    }
                    if (z3) {
                        try {
                            this.f5745c.f5750e.mo1039a();
                        } catch (Throwable e) {
                            C1324b.m7235d("Unable to call onVideoStart()", e);
                        }
                    }
                    if (z4) {
                        try {
                            this.f5745c.f5750e.mo1040b();
                        } catch (Throwable e2) {
                            C1324b.m7235d("Unable to call onVideoPlay()", e2);
                        }
                    }
                    if (z5) {
                        try {
                            this.f5745c.f5750e.mo1041c();
                        } catch (Throwable e22) {
                            C1324b.m7235d("Unable to call onVideoPause()", e22);
                        }
                    }
                    if (z2) {
                        try {
                            this.f5745c.f5750e.mo1042d();
                        } catch (Throwable e222) {
                            C1324b.m7235d("Unable to call onVideoEnd()", e222);
                        }
                    }
                }
            }
        });
    }

    private void m9605a(String str) {
        m9606a(str, null);
    }

    private void m9606a(String str, Map<String, String> map) {
        final Map hashMap = map == null ? new HashMap() : new HashMap(map);
        hashMap.put("action", str);
        C1319u.m7183e().m9222a(new Runnable(this) {
            final /* synthetic */ lf f5742b;

            public void run() {
                this.f5742b.f5746a.mo1501a("pubVideoCmd", hashMap);
            }
        });
    }

    public void mo1031a() {
        m9605a("play");
    }

    public void m9612a(float f, int i, boolean z) {
        int i2;
        synchronized (this.f5747b) {
            this.f5753h = f;
            this.f5752g = z;
            i2 = this.f5749d;
            this.f5749d = i;
        }
        m9604a(i2, i);
    }

    public void mo1032a(C1084d c1084d) {
        synchronized (this.f5747b) {
            this.f5750e = c1084d;
        }
    }

    public void mo1033a(boolean z) {
        m9605a(z ? "mute" : "unmute");
    }

    public void mo1034b() {
        m9605a("pause");
    }

    public void m9616b(boolean z) {
        synchronized (this.f5747b) {
            this.f5754i = z;
        }
        m9606a("initialState", C1971d.m11084b((Object) "muteStart", z ? "1" : "0"));
    }

    public boolean mo1035c() {
        boolean z;
        synchronized (this.f5747b) {
            z = this.f5752g;
        }
        return z;
    }

    public int mo1036d() {
        int i;
        synchronized (this.f5747b) {
            i = this.f5749d;
        }
        return i;
    }

    public float mo1037e() {
        return this.f5748c;
    }

    public float mo1038f() {
        float f;
        synchronized (this.f5747b) {
            f = this.f5753h;
        }
        return f;
    }
}
