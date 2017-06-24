package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.internal.C1896c;
import java.util.Iterator;

public class C2091t {
    final String f6979a;
    final String f6980b;
    final String f6981c;
    final long f6982d;
    final long f6983e;
    final EventParams f6984f;

    C2091t(aj ajVar, String str, String str2, String str3, long j, long j2, Bundle bundle) {
        C1896c.m10792a(str2);
        C1896c.m10792a(str3);
        this.f6979a = str2;
        this.f6980b = str3;
        if (TextUtils.isEmpty(str)) {
            str = null;
        }
        this.f6981c = str;
        this.f6982d = j;
        this.f6983e = j2;
        if (this.f6983e != 0 && this.f6983e > this.f6982d) {
            ajVar.m11502f().m11310z().m11249a("Event created with reverse previous/current timestamps");
        }
        this.f6984f = m11962a(ajVar, bundle);
    }

    private C2091t(aj ajVar, String str, String str2, String str3, long j, long j2, EventParams eventParams) {
        C1896c.m10792a(str2);
        C1896c.m10792a(str3);
        C1896c.m10790a((Object) eventParams);
        this.f6979a = str2;
        this.f6980b = str3;
        if (TextUtils.isEmpty(str)) {
            str = null;
        }
        this.f6981c = str;
        this.f6982d = j;
        this.f6983e = j2;
        if (this.f6983e != 0 && this.f6983e > this.f6982d) {
            ajVar.m11502f().m11310z().m11249a("Event created with reverse previous/current timestamps");
        }
        this.f6984f = eventParams;
    }

    EventParams m11962a(aj ajVar, Bundle bundle) {
        if (bundle == null || bundle.isEmpty()) {
            return new EventParams(new Bundle());
        }
        Bundle bundle2 = new Bundle(bundle);
        Iterator it = bundle2.keySet().iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (str == null) {
                ajVar.m11502f().m11290f().m11249a("Param name can't be null");
                it.remove();
            } else {
                Object b = ajVar.m11510n().m11776b(str, bundle2.get(str));
                if (b == null) {
                    ajVar.m11502f().m11310z().m11250a("Param value can't be null", str);
                    it.remove();
                } else {
                    ajVar.m11510n().m11763a(bundle2, str, b);
                }
            }
        }
        return new EventParams(bundle2);
    }

    C2091t m11963a(aj ajVar, long j) {
        return new C2091t(ajVar, this.f6981c, this.f6979a, this.f6980b, this.f6982d, j, this.f6984f);
    }

    public String toString() {
        String str = this.f6979a;
        String str2 = this.f6980b;
        String valueOf = String.valueOf(this.f6984f);
        return new StringBuilder(((String.valueOf(str).length() + 33) + String.valueOf(str2).length()) + String.valueOf(valueOf).length()).append("Event{appId='").append(str).append("'").append(", name='").append(str2).append("'").append(", params=").append(valueOf).append("}").toString();
    }
}
