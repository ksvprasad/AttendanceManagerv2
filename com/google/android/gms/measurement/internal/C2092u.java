package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.C1896c;

class C2092u {
    final String f6985a;
    final String f6986b;
    final long f6987c;
    final long f6988d;
    final long f6989e;

    C2092u(String str, String str2, long j, long j2, long j3) {
        boolean z = true;
        C1896c.m10792a(str);
        C1896c.m10792a(str2);
        C1896c.m10798b(j >= 0);
        if (j2 < 0) {
            z = false;
        }
        C1896c.m10798b(z);
        this.f6985a = str;
        this.f6986b = str2;
        this.f6987c = j;
        this.f6988d = j2;
        this.f6989e = j3;
    }

    C2092u m11964a() {
        return new C2092u(this.f6985a, this.f6986b, this.f6987c + 1, this.f6988d + 1, this.f6989e);
    }

    C2092u m11965a(long j) {
        return new C2092u(this.f6985a, this.f6986b, this.f6987c, this.f6988d, j);
    }
}
