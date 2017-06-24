package com.google.android.gms.ads.internal.client;

import com.google.android.gms.ads.C0970a;
import com.google.android.gms.p031b.id;

@id
public class aa extends C0970a {
    private final Object f3131a = new Object();
    private C0970a f3132b;

    public void mo910a() {
        synchronized (this.f3131a) {
            if (this.f3132b != null) {
                this.f3132b.mo910a();
            }
        }
    }

    public void mo911a(int i) {
        synchronized (this.f3131a) {
            if (this.f3132b != null) {
                this.f3132b.mo911a(i);
            }
        }
    }

    public void m5975a(C0970a c0970a) {
        synchronized (this.f3131a) {
            this.f3132b = c0970a;
        }
    }

    public void mo912b() {
        synchronized (this.f3131a) {
            if (this.f3132b != null) {
                this.f3132b.mo912b();
            }
        }
    }

    public void mo913c() {
        synchronized (this.f3131a) {
            if (this.f3132b != null) {
                this.f3132b.mo913c();
            }
        }
    }

    public void mo914d() {
        synchronized (this.f3131a) {
            if (this.f3132b != null) {
                this.f3132b.mo914d();
            }
        }
    }
}
