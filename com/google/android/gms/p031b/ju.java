package com.google.android.gms.p031b;

import java.util.concurrent.Future;

@id
public abstract class ju implements kb<Future> {
    private final Runnable f3437a;
    private volatile Thread f3438b;
    private boolean f3439c;

    class C16391 implements Runnable {
        final /* synthetic */ ju f5523a;

        C16391(ju juVar) {
            this.f5523a = juVar;
        }

        public final void run() {
            this.f5523a.f3438b = Thread.currentThread();
            this.f5523a.mo1108a();
        }
    }

    public ju() {
        this.f3437a = new C16391(this);
        this.f3439c = false;
    }

    public ju(boolean z) {
        this.f3437a = new C16391(this);
        this.f3439c = z;
    }

    public abstract void mo1108a();

    public abstract void mo1109b();

    public final void mo1106d() {
        mo1109b();
        if (this.f3438b != null) {
            this.f3438b.interrupt();
        }
    }

    public /* synthetic */ Object mo1107e() {
        return m6523g();
    }

    public final Future m6523g() {
        return this.f3439c ? jy.m9179a(1, this.f3437a) : jy.m9180a(this.f3437a);
    }
}
