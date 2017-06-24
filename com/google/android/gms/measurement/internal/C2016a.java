package com.google.android.gms.measurement.internal;

import android.text.TextUtils;
import com.google.android.gms.common.internal.C1896c;

class C2016a {
    private final aj f6685a;
    private final String f6686b;
    private String f6687c;
    private String f6688d;
    private String f6689e;
    private String f6690f;
    private long f6691g;
    private long f6692h;
    private long f6693i;
    private String f6694j;
    private long f6695k;
    private String f6696l;
    private long f6697m;
    private long f6698n;
    private boolean f6699o;
    private long f6700p;
    private long f6701q;
    private long f6702r;
    private long f6703s;
    private long f6704t;
    private boolean f6705u;
    private long f6706v;
    private long f6707w;

    C2016a(aj ajVar, String str) {
        C1896c.m10790a((Object) ajVar);
        C1896c.m10792a(str);
        this.f6685a = ajVar;
        this.f6686b = str;
        this.f6685a.m11521y();
    }

    public void m11202a() {
        this.f6685a.m11521y();
        this.f6705u = false;
    }

    public void m11203a(long j) {
        this.f6685a.m11521y();
        this.f6705u = (this.f6692h != j ? 1 : 0) | this.f6705u;
        this.f6692h = j;
    }

    public void m11204a(String str) {
        this.f6685a.m11521y();
        this.f6705u = (!C2082m.m11756c(this.f6687c, str) ? 1 : 0) | this.f6705u;
        this.f6687c = str;
    }

    public void m11205a(boolean z) {
        this.f6685a.m11521y();
        this.f6705u = (this.f6699o != z ? 1 : 0) | this.f6705u;
        this.f6699o = z;
    }

    public String m11206b() {
        this.f6685a.m11521y();
        return this.f6686b;
    }

    public void m11207b(long j) {
        this.f6685a.m11521y();
        this.f6705u = (this.f6693i != j ? 1 : 0) | this.f6705u;
        this.f6693i = j;
    }

    public void m11208b(String str) {
        this.f6685a.m11521y();
        if (TextUtils.isEmpty(str)) {
            str = null;
        }
        this.f6705u = (!C2082m.m11756c(this.f6688d, str) ? 1 : 0) | this.f6705u;
        this.f6688d = str;
    }

    public String m11209c() {
        this.f6685a.m11521y();
        return this.f6687c;
    }

    public void m11210c(long j) {
        this.f6685a.m11521y();
        this.f6705u = (this.f6695k != j ? 1 : 0) | this.f6705u;
        this.f6695k = j;
    }

    public void m11211c(String str) {
        this.f6685a.m11521y();
        this.f6705u = (!C2082m.m11756c(this.f6689e, str) ? 1 : 0) | this.f6705u;
        this.f6689e = str;
    }

    public String m11212d() {
        this.f6685a.m11521y();
        return this.f6688d;
    }

    public void m11213d(long j) {
        this.f6685a.m11521y();
        this.f6705u = (this.f6697m != j ? 1 : 0) | this.f6705u;
        this.f6697m = j;
    }

    public void m11214d(String str) {
        this.f6685a.m11521y();
        this.f6705u = (!C2082m.m11756c(this.f6690f, str) ? 1 : 0) | this.f6705u;
        this.f6690f = str;
    }

    public String m11215e() {
        this.f6685a.m11521y();
        return this.f6689e;
    }

    public void m11216e(long j) {
        this.f6685a.m11521y();
        this.f6705u = (this.f6698n != j ? 1 : 0) | this.f6705u;
        this.f6698n = j;
    }

    public void m11217e(String str) {
        this.f6685a.m11521y();
        this.f6705u = (!C2082m.m11756c(this.f6694j, str) ? 1 : 0) | this.f6705u;
        this.f6694j = str;
    }

    public String m11218f() {
        this.f6685a.m11521y();
        return this.f6690f;
    }

    public void m11219f(long j) {
        int i = 1;
        C1896c.m10798b(j >= 0);
        this.f6685a.m11521y();
        boolean z = this.f6705u;
        if (this.f6691g == j) {
            i = 0;
        }
        this.f6705u = z | i;
        this.f6691g = j;
    }

    public void m11220f(String str) {
        this.f6685a.m11521y();
        this.f6705u = (!C2082m.m11756c(this.f6696l, str) ? 1 : 0) | this.f6705u;
        this.f6696l = str;
    }

    public long m11221g() {
        this.f6685a.m11521y();
        return this.f6692h;
    }

    public void m11222g(long j) {
        this.f6685a.m11521y();
        this.f6705u = (this.f6706v != j ? 1 : 0) | this.f6705u;
        this.f6706v = j;
    }

    public long m11223h() {
        this.f6685a.m11521y();
        return this.f6693i;
    }

    public void m11224h(long j) {
        this.f6685a.m11521y();
        this.f6705u = (this.f6707w != j ? 1 : 0) | this.f6705u;
        this.f6707w = j;
    }

    public String m11225i() {
        this.f6685a.m11521y();
        return this.f6694j;
    }

    public void m11226i(long j) {
        this.f6685a.m11521y();
        this.f6705u = (this.f6700p != j ? 1 : 0) | this.f6705u;
        this.f6700p = j;
    }

    public long m11227j() {
        this.f6685a.m11521y();
        return this.f6695k;
    }

    public void m11228j(long j) {
        this.f6685a.m11521y();
        this.f6705u = (this.f6701q != j ? 1 : 0) | this.f6705u;
        this.f6701q = j;
    }

    public String m11229k() {
        this.f6685a.m11521y();
        return this.f6696l;
    }

    public void m11230k(long j) {
        this.f6685a.m11521y();
        this.f6705u = (this.f6702r != j ? 1 : 0) | this.f6705u;
        this.f6702r = j;
    }

    public long m11231l() {
        this.f6685a.m11521y();
        return this.f6697m;
    }

    public void m11232l(long j) {
        this.f6685a.m11521y();
        this.f6705u = (this.f6703s != j ? 1 : 0) | this.f6705u;
        this.f6703s = j;
    }

    public long m11233m() {
        this.f6685a.m11521y();
        return this.f6698n;
    }

    public void m11234m(long j) {
        this.f6685a.m11521y();
        this.f6705u = (this.f6704t != j ? 1 : 0) | this.f6705u;
        this.f6704t = j;
    }

    public boolean m11235n() {
        this.f6685a.m11521y();
        return this.f6699o;
    }

    public long m11236o() {
        this.f6685a.m11521y();
        return this.f6691g;
    }

    public long m11237p() {
        this.f6685a.m11521y();
        return this.f6706v;
    }

    public long m11238q() {
        this.f6685a.m11521y();
        return this.f6707w;
    }

    public void m11239r() {
        this.f6685a.m11521y();
        long j = this.f6691g + 1;
        if (j > 2147483647L) {
            this.f6685a.m11502f().m11310z().m11249a("Bundle index overflow");
            j = 0;
        }
        this.f6705u = true;
        this.f6691g = j;
    }

    public long m11240s() {
        this.f6685a.m11521y();
        return this.f6700p;
    }

    public long m11241t() {
        this.f6685a.m11521y();
        return this.f6701q;
    }

    public long m11242u() {
        this.f6685a.m11521y();
        return this.f6702r;
    }

    public long m11243v() {
        this.f6685a.m11521y();
        return this.f6703s;
    }

    public long m11244w() {
        this.f6685a.m11521y();
        return this.f6704t;
    }
}
