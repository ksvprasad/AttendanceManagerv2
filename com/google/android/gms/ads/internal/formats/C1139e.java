package com.google.android.gms.ads.internal.formats;

import android.os.Bundle;
import com.google.android.gms.ads.internal.formats.C1142h.C1136a;
import com.google.android.gms.p031b.df;
import com.google.android.gms.p031b.dl.C1138a;
import com.google.android.gms.p031b.id;
import com.google.android.gms.p033a.C0998a;
import com.google.android.gms.p033a.C1001b;
import java.util.List;

@id
public class C1139e extends C1138a implements C1136a {
    private String f3331a;
    private List<C1134c> f3332b;
    private String f3333c;
    private df f3334d;
    private String f3335e;
    private String f3336f;
    private C1131a f3337g;
    private Bundle f3338h;
    private Object f3339i = new Object();
    private C1142h f3340j;

    public C1139e(String str, List list, String str2, df dfVar, String str3, String str4, C1131a c1131a, Bundle bundle) {
        this.f3331a = str;
        this.f3332b = list;
        this.f3333c = str2;
        this.f3334d = dfVar;
        this.f3335e = str3;
        this.f3336f = str4;
        this.f3337g = c1131a;
        this.f3338h = bundle;
    }

    public String mo1069a() {
        return this.f3331a;
    }

    public void mo1055a(C1142h c1142h) {
        synchronized (this.f3339i) {
            this.f3340j = c1142h;
        }
    }

    public List mo1070b() {
        return this.f3332b;
    }

    public String mo1071c() {
        return this.f3333c;
    }

    public df mo1072d() {
        return this.f3334d;
    }

    public String mo1073e() {
        return this.f3335e;
    }

    public String mo1074f() {
        return this.f3336f;
    }

    public C0998a mo1075g() {
        return C1001b.m5713a(this.f3340j);
    }

    public Bundle mo1076h() {
        return this.f3338h;
    }

    public void mo1077i() {
        this.f3331a = null;
        this.f3332b = null;
        this.f3333c = null;
        this.f3334d = null;
        this.f3335e = null;
        this.f3336f = null;
        this.f3337g = null;
        this.f3338h = null;
        this.f3339i = null;
        this.f3340j = null;
    }

    public String mo1064j() {
        return "1";
    }

    public String mo1065k() {
        return "";
    }

    public C1131a mo1066l() {
        return this.f3337g;
    }
}
