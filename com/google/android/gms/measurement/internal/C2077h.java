package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.C1896c;
import com.google.android.gms.p031b.nv.C1812f;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;

class C2077h {
    final int f6951a;
    final boolean f6952b;
    final String f6953c;
    final List<String> f6954d;
    final String f6955e;
    final boolean f6956f;

    public C2077h(C1812f c1812f) {
        boolean z;
        boolean z2 = false;
        C1896c.m10790a((Object) c1812f);
        if (c1812f.f6124a == null || c1812f.f6124a.intValue() == 0) {
            z = false;
        } else {
            if (c1812f.f6124a.intValue() == 6) {
                if (c1812f.f6127d == null || c1812f.f6127d.length == 0) {
                    z = false;
                }
            } else if (c1812f.f6125b == null) {
                z = false;
            }
            z = true;
        }
        if (z) {
            this.f6951a = c1812f.f6124a.intValue();
            if (c1812f.f6126c != null && c1812f.f6126c.booleanValue()) {
                z2 = true;
            }
            this.f6952b = z2;
            if (this.f6952b || this.f6951a == 1 || this.f6951a == 6) {
                this.f6953c = c1812f.f6125b;
            } else {
                this.f6953c = c1812f.f6125b.toUpperCase(Locale.ENGLISH);
            }
            this.f6954d = c1812f.f6127d == null ? null : m11704a(c1812f.f6127d, this.f6952b);
            if (this.f6951a == 1) {
                this.f6955e = this.f6953c;
            } else {
                this.f6955e = null;
            }
        } else {
            this.f6951a = 0;
            this.f6952b = false;
            this.f6953c = null;
            this.f6954d = null;
            this.f6955e = null;
        }
        this.f6956f = z;
    }

    private List<String> m11704a(String[] strArr, boolean z) {
        if (z) {
            return Arrays.asList(strArr);
        }
        List<String> arrayList = new ArrayList();
        for (String toUpperCase : strArr) {
            arrayList.add(toUpperCase.toUpperCase(Locale.ENGLISH));
        }
        return arrayList;
    }

    public Boolean m11705a(String str) {
        if (!this.f6956f || str == null) {
            return null;
        }
        if (!(this.f6952b || this.f6951a == 1)) {
            str = str.toUpperCase(Locale.ENGLISH);
        }
        switch (this.f6951a) {
            case 1:
                return Boolean.valueOf(Pattern.compile(this.f6955e, this.f6952b ? 0 : 66).matcher(str).matches());
            case 2:
                return Boolean.valueOf(str.startsWith(this.f6953c));
            case 3:
                return Boolean.valueOf(str.endsWith(this.f6953c));
            case 4:
                return Boolean.valueOf(str.contains(this.f6953c));
            case 5:
                return Boolean.valueOf(str.equals(this.f6953c));
            case 6:
                return Boolean.valueOf(this.f6954d.contains(str));
            default:
                return null;
        }
    }
}
