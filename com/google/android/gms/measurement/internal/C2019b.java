package com.google.android.gms.measurement.internal;

abstract class C2019b extends al {
    private boolean f6715a;

    C2019b(aj ajVar) {
        super(ajVar);
        this.n.m11485a(this);
    }

    boolean m11271a() {
        return this.f6715a;
    }

    boolean m11272b() {
        return false;
    }

    protected void m11273c() {
        if (!m11271a()) {
            throw new IllegalStateException("Not initialized");
        }
    }

    public final void m11274d() {
        if (this.f6715a) {
            throw new IllegalStateException("Can't initialize twice");
        }
        mo1730e();
        this.n.m11475I();
        this.f6715a = true;
    }

    protected abstract void mo1730e();
}
