package com.google.android.gms.ads.internal.formats;

import android.os.Bundle;
import com.google.android.gms.ads.internal.formats.C1142h.C1136a;
import com.google.android.gms.p031b.df;
import com.google.android.gms.p031b.dj.C1135a;
import com.google.android.gms.p031b.id;
import com.google.android.gms.p033a.C0998a;
import com.google.android.gms.p033a.C1001b;
import java.util.List;

@id
public class C1137d extends C1135a implements C1136a {
    private String f3319a;
    private List<C1134c> f3320b;
    private String f3321c;
    private df f3322d;
    private String f3323e;
    private double f3324f;
    private String f3325g;
    private String f3326h;
    private C1131a f3327i;
    private Bundle f3328j;
    private Object f3329k = new Object();
    private C1142h f3330l;

    public C1137d(String str, List list, String str2, df dfVar, String str3, double d, String str4, String str5, C1131a c1131a, Bundle bundle) {
        this.f3319a = str;
        this.f3320b = list;
        this.f3321c = str2;
        this.f3322d = dfVar;
        this.f3323e = str3;
        this.f3324f = d;
        this.f3325g = str4;
        this.f3326h = str5;
        this.f3327i = c1131a;
        this.f3328j = bundle;
    }

    public String mo1054a() {
        return this.f3319a;
    }

    public void mo1055a(C1142h c1142h) {
        synchronized (this.f3329k) {
            this.f3330l = c1142h;
        }
    }

    public List mo1056b() {
        return this.f3320b;
    }

    public String mo1057c() {
        return this.f3321c;
    }

    public df mo1058d() {
        return this.f3322d;
    }

    public String mo1059e() {
        return this.f3323e;
    }

    public double mo1060f() {
        return this.f3324f;
    }

    public String mo1061g() {
        return this.f3325g;
    }

    public String mo1062h() {
        return this.f3326h;
    }

    public C0998a mo1063i() {
        return C1001b.m5713a(this.f3330l);
    }

    public String mo1064j() {
        return "2";
    }

    public String mo1065k() {
        return "";
    }

    public C1131a mo1066l() {
        return this.f3327i;
    }

    public Bundle mo1067m() {
        return this.f3328j;
    }

    public void mo1068n() {
        this.f3319a = null;
        this.f3320b = null;
        this.f3321c = null;
        this.f3322d = null;
        this.f3323e = null;
        this.f3324f = 0.0d;
        this.f3325g = null;
        this.f3326h = null;
        this.f3327i = null;
        this.f3328j = null;
        this.f3329k = null;
        this.f3330l = null;
    }
}
