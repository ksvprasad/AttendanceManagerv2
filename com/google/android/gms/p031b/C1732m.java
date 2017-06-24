package com.google.android.gms.p031b;

import com.google.android.gms.clearcut.C1854b;
import com.google.android.gms.clearcut.C1854b.C1851a;
import com.google.android.gms.p031b.C1436e.C1435a;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class C1732m {
    protected static volatile C1854b f5831a = null;
    private static volatile Random f5832d = null;
    private static final Object f5833e = new Object();
    protected boolean f5834b = false;
    private ao f5835c;

    public C1732m(ao aoVar) {
        this.f5835c = aoVar;
        cq.m7828a(aoVar.m7493a());
        this.f5834b = ((Boolean) cq.aL.m7801c()).booleanValue();
        if (this.f5834b && f5831a == null) {
            synchronized (f5833e) {
                if (f5831a == null) {
                    f5831a = new C1854b(aoVar.m7493a(), "ADSHIELD", null);
                }
            }
        }
    }

    private static Random m9745b() {
        if (f5832d == null) {
            synchronized (f5833e) {
                if (f5832d == null) {
                    f5832d = new Random();
                }
            }
        }
        return f5832d;
    }

    public int m9746a() {
        try {
            return ThreadLocalRandom.current().nextInt();
        } catch (NoClassDefFoundError e) {
            return C1732m.m9745b().nextInt();
        } catch (RuntimeException e2) {
            return C1732m.m9745b().nextInt();
        }
    }

    public void m9747a(int i, int i2, long j) {
        try {
            if (this.f5834b && f5831a != null && this.f5835c.m7502h()) {
                C1357z c1435a = new C1435a();
                c1435a.f4483a = this.f5835c.m7493a().getPackageName();
                c1435a.f4484b = Long.valueOf(j);
                C1851a a = f5831a.m10541a(C1357z.m7342a(c1435a));
                a.m10517b(i2);
                a.m10515a(i);
                a.m10516a(this.f5835c.m7500f());
            }
        } catch (Exception e) {
        }
    }
}
