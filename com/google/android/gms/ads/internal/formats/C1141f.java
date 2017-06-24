package com.google.android.gms.ads.internal.formats;

import android.support.v4.p015g.C0369j;
import com.google.android.gms.ads.internal.formats.C1142h.C1136a;
import com.google.android.gms.ads.internal.util.client.C1324b;
import com.google.android.gms.p031b.df;
import com.google.android.gms.p031b.dn.C1140a;
import com.google.android.gms.p031b.id;
import java.util.Arrays;
import java.util.List;

@id
public class C1141f extends C1140a implements C1136a {
    private final C1131a f3341a;
    private final String f3342b;
    private final C0369j<String, C1134c> f3343c;
    private final C0369j<String, String> f3344d;
    private final Object f3345e = new Object();
    private C1142h f3346f;

    public C1141f(String str, C0369j<String, C1134c> c0369j, C0369j<String, String> c0369j2, C1131a c1131a) {
        this.f3342b = str;
        this.f3343c = c0369j;
        this.f3344d = c0369j2;
        this.f3341a = c1131a;
    }

    public String mo1078a(String str) {
        return (String) this.f3344d.get(str);
    }

    public List<String> mo1079a() {
        int i = 0;
        String[] strArr = new String[(this.f3343c.size() + this.f3344d.size())];
        int i2 = 0;
        for (int i3 = 0; i3 < this.f3343c.size(); i3++) {
            strArr[i2] = (String) this.f3343c.m1900b(i3);
            i2++;
        }
        while (i < this.f3344d.size()) {
            strArr[i2] = (String) this.f3344d.m1900b(i);
            i++;
            i2++;
        }
        return Arrays.asList(strArr);
    }

    public void mo1055a(C1142h c1142h) {
        synchronized (this.f3345e) {
            this.f3346f = c1142h;
        }
    }

    public df mo1080b(String str) {
        return (df) this.f3343c.get(str);
    }

    public void mo1081b() {
        synchronized (this.f3345e) {
            if (this.f3346f == null) {
                C1324b.m7230b("Attempt to perform recordImpression before ad initialized.");
                return;
            }
            this.f3346f.mo1083a();
        }
    }

    public void mo1082c(String str) {
        synchronized (this.f3345e) {
            if (this.f3346f == null) {
                C1324b.m7230b("Attempt to call performClick before ad initialized.");
                return;
            }
            this.f3346f.mo1088a(str, null, null, null);
        }
    }

    public String mo1064j() {
        return "3";
    }

    public String mo1065k() {
        return this.f3342b;
    }

    public C1131a mo1066l() {
        return this.f3341a;
    }
}
