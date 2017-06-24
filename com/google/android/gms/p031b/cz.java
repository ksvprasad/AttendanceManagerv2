package com.google.android.gms.p031b;

import android.view.View;
import com.google.android.gms.ads.internal.C1056h;
import com.google.android.gms.p031b.db.C1411a;
import com.google.android.gms.p033a.C0998a;
import com.google.android.gms.p033a.C1001b;

@id
public final class cz extends C1411a {
    private final C1056h f4442a;
    private final String f4443b;
    private final String f4444c;

    public cz(C1056h c1056h, String str, String str2) {
        this.f4442a = c1056h;
        this.f4443b = str;
        this.f4444c = str2;
    }

    public String mo1275a() {
        return this.f4443b;
    }

    public void mo1276a(C0998a c0998a) {
        if (c0998a != null) {
            this.f4442a.mo1003b((View) C1001b.m5714a(c0998a));
        }
    }

    public String mo1277b() {
        return this.f4444c;
    }

    public void mo1278c() {
        this.f4442a.mo998D();
    }

    public void mo1279d() {
        this.f4442a.mo999E();
    }
}
