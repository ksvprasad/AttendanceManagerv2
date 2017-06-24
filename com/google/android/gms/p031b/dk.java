package com.google.android.gms.p031b;

import android.os.IBinder;
import com.google.android.gms.ads.internal.util.client.C1324b;
import com.google.android.gms.ads.p032b.C1013a.C1012a;
import com.google.android.gms.ads.p032b.C1018d;
import com.google.android.gms.p031b.df.C1133a;
import com.google.android.gms.p033a.C0998a;
import java.util.ArrayList;
import java.util.List;

@id
public class dk extends C1018d {
    private final dj f4461a;
    private final List<C1012a> f4462b = new ArrayList();
    private final dg f4463c;

    public dk(dj djVar) {
        dg dgVar;
        this.f4461a = djVar;
        try {
            List<Object> b = this.f4461a.mo1056b();
            if (b != null) {
                for (Object a : b) {
                    df a2 = m7923a(a);
                    if (a2 != null) {
                        this.f4462b.add(new dg(a2));
                    }
                }
            }
        } catch (Throwable e) {
            C1324b.m7231b("Failed to get image.", e);
        }
        try {
            df d = this.f4461a.mo1058d();
            if (d != null) {
                dgVar = new dg(d);
                this.f4463c = dgVar;
            }
        } catch (Throwable e2) {
            C1324b.m7231b("Failed to get icon.", e2);
        }
        dgVar = null;
        this.f4463c = dgVar;
    }

    df m7923a(Object obj) {
        return obj instanceof IBinder ? C1133a.m6331a((IBinder) obj) : null;
    }

    protected /* synthetic */ Object mo1285a() {
        return m7933j();
    }

    public CharSequence mo1286b() {
        try {
            return this.f4461a.mo1054a();
        } catch (Throwable e) {
            C1324b.m7231b("Failed to get headline.", e);
            return null;
        }
    }

    public List<C1012a> mo1287c() {
        return this.f4462b;
    }

    public CharSequence mo1288d() {
        try {
            return this.f4461a.mo1057c();
        } catch (Throwable e) {
            C1324b.m7231b("Failed to get body.", e);
            return null;
        }
    }

    public C1012a mo1289e() {
        return this.f4463c;
    }

    public CharSequence mo1290f() {
        try {
            return this.f4461a.mo1059e();
        } catch (Throwable e) {
            C1324b.m7231b("Failed to get call to action.", e);
            return null;
        }
    }

    public Double mo1291g() {
        Double d = null;
        try {
            double f = this.f4461a.mo1060f();
            if (f != -1.0d) {
                d = Double.valueOf(f);
            }
        } catch (Throwable e) {
            C1324b.m7231b("Failed to get star rating.", e);
        }
        return d;
    }

    public CharSequence mo1292h() {
        try {
            return this.f4461a.mo1061g();
        } catch (Throwable e) {
            C1324b.m7231b("Failed to get store", e);
            return null;
        }
    }

    public CharSequence mo1293i() {
        try {
            return this.f4461a.mo1062h();
        } catch (Throwable e) {
            C1324b.m7231b("Failed to get price.", e);
            return null;
        }
    }

    protected C0998a m7933j() {
        try {
            return this.f4461a.mo1063i();
        } catch (Throwable e) {
            C1324b.m7231b("Failed to retrieve native ad engine.", e);
            return null;
        }
    }
}
