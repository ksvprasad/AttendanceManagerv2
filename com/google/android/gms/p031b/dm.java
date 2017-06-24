package com.google.android.gms.p031b;

import android.os.IBinder;
import com.google.android.gms.ads.internal.util.client.C1324b;
import com.google.android.gms.ads.p032b.C1013a.C1012a;
import com.google.android.gms.ads.p032b.C1019e;
import com.google.android.gms.p031b.df.C1133a;
import com.google.android.gms.p033a.C0998a;
import java.util.ArrayList;
import java.util.List;

@id
public class dm extends C1019e {
    private final dl f4465a;
    private final List<C1012a> f4466b = new ArrayList();
    private final dg f4467c;

    public dm(dl dlVar) {
        dg dgVar;
        this.f4465a = dlVar;
        try {
            List<Object> b = this.f4465a.mo1070b();
            if (b != null) {
                for (Object a : b) {
                    df a2 = m7943a(a);
                    if (a2 != null) {
                        this.f4466b.add(new dg(a2));
                    }
                }
            }
        } catch (Throwable e) {
            C1324b.m7231b("Failed to get image.", e);
        }
        try {
            df d = this.f4465a.mo1072d();
            if (d != null) {
                dgVar = new dg(d);
                this.f4467c = dgVar;
            }
        } catch (Throwable e2) {
            C1324b.m7231b("Failed to get icon.", e2);
        }
        dgVar = null;
        this.f4467c = dgVar;
    }

    df m7943a(Object obj) {
        return obj instanceof IBinder ? C1133a.m6331a((IBinder) obj) : null;
    }

    protected /* synthetic */ Object mo1285a() {
        return m7951h();
    }

    public CharSequence mo1294b() {
        try {
            return this.f4465a.mo1069a();
        } catch (Throwable e) {
            C1324b.m7231b("Failed to get headline.", e);
            return null;
        }
    }

    public List<C1012a> mo1295c() {
        return this.f4466b;
    }

    public CharSequence mo1296d() {
        try {
            return this.f4465a.mo1071c();
        } catch (Throwable e) {
            C1324b.m7231b("Failed to get body.", e);
            return null;
        }
    }

    public C1012a mo1297e() {
        return this.f4467c;
    }

    public CharSequence mo1298f() {
        try {
            return this.f4465a.mo1073e();
        } catch (Throwable e) {
            C1324b.m7231b("Failed to get call to action.", e);
            return null;
        }
    }

    public CharSequence mo1299g() {
        try {
            return this.f4465a.mo1074f();
        } catch (Throwable e) {
            C1324b.m7231b("Failed to get attribution.", e);
            return null;
        }
    }

    protected C0998a m7951h() {
        try {
            return this.f4465a.mo1075g();
        } catch (Throwable e) {
            C1324b.m7231b("Failed to retrieve native ad engine.", e);
            return null;
        }
    }
}
