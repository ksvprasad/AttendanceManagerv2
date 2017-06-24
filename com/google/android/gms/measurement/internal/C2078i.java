package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.C1896c;
import com.google.android.gms.common.util.C1970c;

class C2078i {
    private final C1970c f6957a;
    private long f6958b;

    public C2078i(C1970c c1970c) {
        C1896c.m10790a((Object) c1970c);
        this.f6957a = c1970c;
    }

    public void m11706a() {
        this.f6958b = this.f6957a.mo1724b();
    }

    public boolean m11707a(long j) {
        return this.f6958b == 0 || this.f6957a.mo1724b() - this.f6958b >= j;
    }

    public void m11708b() {
        this.f6958b = 0;
    }
}
