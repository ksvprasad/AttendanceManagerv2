package com.google.android.gms.p031b;

import android.os.Bundle;
import android.view.View;
import com.google.android.gms.ads.internal.formats.C1134c;
import com.google.android.gms.ads.mediation.C0968k;
import com.google.android.gms.ads.p032b.C1013a.C1012a;
import com.google.android.gms.p031b.gc.C1546a;
import com.google.android.gms.p033a.C0998a;
import com.google.android.gms.p033a.C1001b;
import java.util.ArrayList;
import java.util.List;

@id
public class gh extends C1546a {
    private final C0968k f4917a;

    public gh(C0968k c0968k) {
        this.f4917a = c0968k;
    }

    public String mo1385a() {
        return this.f4917a.m5649e();
    }

    public void mo1386a(C0998a c0998a) {
        this.f4917a.m5624c((View) C1001b.m5714a(c0998a));
    }

    public List mo1387b() {
        List<C1012a> f = this.f4917a.m5650f();
        if (f == null) {
            return null;
        }
        List arrayList = new ArrayList();
        for (C1012a c1012a : f) {
            arrayList.add(new C1134c(c1012a.mo1281a(), c1012a.mo1282b(), c1012a.mo1283c()));
        }
        return arrayList;
    }

    public void mo1388b(C0998a c0998a) {
        this.f4917a.mo909a((View) C1001b.m5714a(c0998a));
    }

    public String mo1389c() {
        return this.f4917a.m5651g();
    }

    public void mo1390c(C0998a c0998a) {
        this.f4917a.m5620b((View) C1001b.m5714a(c0998a));
    }

    public df mo1391d() {
        C1012a h = this.f4917a.m5652h();
        return h != null ? new C1134c(h.mo1281a(), h.mo1282b(), h.mo1283c()) : null;
    }

    public String mo1392e() {
        return this.f4917a.m5653i();
    }

    public String mo1393f() {
        return this.f4917a.m5654j();
    }

    public void mo1394g() {
        this.f4917a.m5625d();
    }

    public boolean mo1395h() {
        return this.f4917a.m5619a();
    }

    public boolean mo1396i() {
        return this.f4917a.m5622b();
    }

    public Bundle mo1397j() {
        return this.f4917a.m5623c();
    }
}
