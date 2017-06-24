package com.google.android.gms.p031b;

import android.os.Bundle;
import com.google.android.gms.ads.internal.C1319u;

@id
public class js {
    private final Object f5516a;
    private int f5517b;
    private int f5518c;
    private final jo f5519d;
    private final String f5520e;

    js(jo joVar, String str) {
        this.f5516a = new Object();
        this.f5519d = joVar;
        this.f5520e = str;
    }

    public js(String str) {
        this(C1319u.m7186h(), str);
    }

    public Bundle m9145a() {
        Bundle bundle;
        synchronized (this.f5516a) {
            bundle = new Bundle();
            bundle.putInt("pmnli", this.f5517b);
            bundle.putInt("pmnll", this.f5518c);
        }
        return bundle;
    }

    public void m9146a(int i, int i2) {
        synchronized (this.f5516a) {
            this.f5517b = i;
            this.f5518c = i2;
            this.f5519d.m9115a(this.f5520e, this);
        }
    }
}
