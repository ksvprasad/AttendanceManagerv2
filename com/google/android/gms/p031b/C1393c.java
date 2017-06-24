package com.google.android.gms.p031b;

import com.google.android.gms.p031b.ln.C1676a;
import com.google.android.gms.p031b.ln.C1681b;
import java.io.UnsupportedEncodingException;

public class C1393c extends jr<String> {
    private final C1681b<String> f4302a;

    public C1393c(int i, String str, C1681b<String> c1681b, C1676a c1676a) {
        super(i, str, c1676a);
        this.f4302a = c1681b;
    }

    protected ln<String> mo1265a(hp hpVar) {
        Object str;
        try {
            str = new String(hpVar.f5049b, oe.m10362a(hpVar.f5050c));
        } catch (UnsupportedEncodingException e) {
            str = new String(hpVar.f5049b);
        }
        return ln.m9632a(str, oe.m10361a(hpVar));
    }

    protected /* synthetic */ void mo1266a(Object obj) {
        mo1267a((String) obj);
    }

    protected void mo1267a(String str) {
        this.f4302a.mo1486a(str);
    }
}
