package com.roomorama.caldroid;

import android.support.v4.app.C0263r;
import android.support.v4.app.C0273t;
import android.support.v4.app.Fragment;
import java.util.ArrayList;

public class C2192f extends C0273t {
    private ArrayList<C2191e> f7393a;

    public C2192f(C0263r c0263r) {
        super(c0263r);
    }

    public Fragment mo1788a(int i) {
        return (C2191e) m12501d().get(i);
    }

    public int mo879b() {
        return 4;
    }

    public ArrayList<C2191e> m12501d() {
        if (this.f7393a == null) {
            this.f7393a = new ArrayList();
            for (int i = 0; i < mo879b(); i++) {
                this.f7393a.add(new C2191e());
            }
        }
        return this.f7393a;
    }
}
