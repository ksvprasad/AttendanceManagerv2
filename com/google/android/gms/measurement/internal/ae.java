package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.C1896c;
import com.google.android.gms.p031b.nv.C1810d;

class ae {
    final boolean f6746a;
    final int f6747b;
    long f6748c;
    double f6749d;
    long f6750e;
    double f6751f;
    long f6752g;
    double f6753h;
    final boolean f6754i;

    public ae(C1810d c1810d) {
        boolean z;
        boolean z2 = true;
        C1896c.m10790a((Object) c1810d);
        if (c1810d.f6115a == null || c1810d.f6115a.intValue() == 0) {
            z = false;
        } else {
            if (c1810d.f6115a.intValue() != 4) {
                if (c1810d.f6117c == null) {
                    z = false;
                }
            } else if (c1810d.f6118d == null || c1810d.f6119e == null) {
                z = false;
            }
            z = true;
        }
        if (z) {
            this.f6747b = c1810d.f6115a.intValue();
            if (c1810d.f6116b == null || !c1810d.f6116b.booleanValue()) {
                z2 = false;
            }
            this.f6746a = z2;
            if (c1810d.f6115a.intValue() == 4) {
                if (this.f6746a) {
                    this.f6751f = Double.parseDouble(c1810d.f6118d);
                    this.f6753h = Double.parseDouble(c1810d.f6119e);
                } else {
                    this.f6750e = Long.parseLong(c1810d.f6118d);
                    this.f6752g = Long.parseLong(c1810d.f6119e);
                }
            } else if (this.f6746a) {
                this.f6749d = Double.parseDouble(c1810d.f6117c);
            } else {
                this.f6748c = Long.parseLong(c1810d.f6117c);
            }
        } else {
            this.f6747b = 0;
            this.f6746a = false;
        }
        this.f6754i = z;
    }

    public Boolean m11345a(double d) {
        boolean z = true;
        boolean z2 = false;
        if (!this.f6754i) {
            return null;
        }
        if (!this.f6746a) {
            return null;
        }
        switch (this.f6747b) {
            case 1:
                if (d >= this.f6749d) {
                    z = false;
                }
                return Boolean.valueOf(z);
            case 2:
                if (d <= this.f6749d) {
                    z = false;
                }
                return Boolean.valueOf(z);
            case 3:
                if (d == this.f6749d || Math.abs(d - this.f6749d) < 2.0d * Math.max(Math.ulp(d), Math.ulp(this.f6749d))) {
                    z2 = true;
                }
                return Boolean.valueOf(z2);
            case 4:
                if (d < this.f6751f || d > this.f6753h) {
                    z = false;
                }
                return Boolean.valueOf(z);
            default:
                return null;
        }
    }

    public Boolean m11346a(long j) {
        boolean z = true;
        if (!this.f6754i) {
            return null;
        }
        if (this.f6746a) {
            return null;
        }
        switch (this.f6747b) {
            case 1:
                if (j >= this.f6748c) {
                    z = false;
                }
                return Boolean.valueOf(z);
            case 2:
                if (j <= this.f6748c) {
                    z = false;
                }
                return Boolean.valueOf(z);
            case 3:
                if (j != this.f6748c) {
                    z = false;
                }
                return Boolean.valueOf(z);
            case 4:
                if (j < this.f6750e || j > this.f6752g) {
                    z = false;
                }
                return Boolean.valueOf(z);
            default:
                return null;
        }
    }
}
