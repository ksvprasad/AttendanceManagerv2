package com.google.android.gms.p031b;

import com.google.android.gms.ads.internal.C1173l;
import com.google.android.gms.ads.internal.C1319u;
import com.google.android.gms.ads.internal.client.ab;
import com.google.android.gms.ads.internal.client.ac;
import com.google.android.gms.ads.internal.client.ac.C1061a;
import com.google.android.gms.ads.internal.client.ai;
import com.google.android.gms.ads.internal.reward.client.C1301d;

@id
class ew {
    ac f4611a;
    ai f4612b;
    hd f4613c;
    dc f4614d;
    ab f4615e;
    C1301d f4616f;

    private class C1484a extends C1061a {
        ac f4609a;
        final /* synthetic */ ew f4610b;

        C1484a(ew ewVar, ac acVar) {
            this.f4610b = ewVar;
            this.f4609a = acVar;
        }

        public void mo1006a() {
            this.f4609a.mo1006a();
            C1319u.m7194p().m8138a();
        }

        public void mo1007a(int i) {
            this.f4609a.mo1007a(i);
        }

        public void mo1008b() {
            this.f4609a.mo1008b();
        }

        public void mo1009c() {
            this.f4609a.mo1009c();
        }

        public void mo1010d() {
            this.f4609a.mo1010d();
        }
    }

    ew() {
    }

    void m8127a(C1173l c1173l) {
        if (this.f4611a != null) {
            c1173l.mo952a(new C1484a(this, this.f4611a));
        }
        if (this.f4612b != null) {
            c1173l.mo953a(this.f4612b);
        }
        if (this.f4613c != null) {
            c1173l.mo957a(this.f4613c);
        }
        if (this.f4614d != null) {
            c1173l.mo956a(this.f4614d);
        }
        if (this.f4615e != null) {
            c1173l.mo951a(this.f4615e);
        }
        if (this.f4616f != null) {
            c1173l.mo955a(this.f4616f);
        }
    }
}
