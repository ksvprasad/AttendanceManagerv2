package com.google.android.gms.p031b;

import android.os.Bundle;
import android.view.View;
import com.google.android.gms.ads.internal.formats.C1134c;
import com.google.android.gms.ads.mediation.C0966j;
import com.google.android.gms.ads.p032b.C1013a.C1012a;
import com.google.android.gms.p031b.gb.C1544a;
import com.google.android.gms.p033a.C0998a;
import com.google.android.gms.p033a.C1001b;
import java.util.ArrayList;
import java.util.List;

@id
public class gg extends C1544a {
    private final C0966j f4916a;

    public gg(C0966j c0966j) {
        this.f4916a = c0966j;
    }

    public String mo1370a() {
        return this.f4916a.m5633e();
    }

    public void mo1371a(C0998a c0998a) {
        this.f4916a.m5624c((View) C1001b.m5714a(c0998a));
    }

    public List mo1372b() {
        List<C1012a> f = this.f4916a.m5635f();
        if (f == null) {
            return null;
        }
        List arrayList = new ArrayList();
        for (C1012a c1012a : f) {
            arrayList.add(new C1134c(c1012a.mo1281a(), c1012a.mo1282b(), c1012a.mo1283c()));
        }
        return arrayList;
    }

    public void mo1373b(C0998a c0998a) {
        this.f4916a.mo909a((View) C1001b.m5714a(c0998a));
    }

    public String mo1374c() {
        return this.f4916a.m5636g();
    }

    public void mo1375c(C0998a c0998a) {
        this.f4916a.m5620b((View) C1001b.m5714a(c0998a));
    }

    public df mo1376d() {
        C1012a h = this.f4916a.m5637h();
        return h != null ? new C1134c(h.mo1281a(), h.mo1282b(), h.mo1283c()) : null;
    }

    public String mo1377e() {
        return this.f4916a.m5638i();
    }

    public double mo1378f() {
        return this.f4916a.m5639j();
    }

    public String mo1379g() {
        return this.f4916a.m5640k();
    }

    public String mo1380h() {
        return this.f4916a.m5641l();
    }

    public void mo1381i() {
        this.f4916a.m5625d();
    }

    public boolean mo1382j() {
        return this.f4916a.m5619a();
    }

    public boolean mo1383k() {
        return this.f4916a.m5622b();
    }

    public Bundle mo1384l() {
        return this.f4916a.m5623c();
    }
}
