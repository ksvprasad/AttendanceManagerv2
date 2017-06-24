package com.google.android.gms.common.api;

import android.content.Context;
import com.google.android.gms.common.api.C1864a.C1830a;
import com.google.android.gms.p031b.lz;
import com.google.android.gms.p031b.mq;
import com.google.android.gms.p031b.na;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class C1872n<O extends C1830a> {
    private final Context f6370a;
    private final na f6371b;
    private final C1864a<O> f6372c;
    private final O f6373d;
    private final lz<O> f6374e;
    private final int f6375f;
    private final mq f6376g;
    private final AtomicBoolean f6377h;
    private final AtomicInteger f6378i;

    public void m10593a() {
        boolean z = true;
        if (!this.f6377h.getAndSet(true)) {
            this.f6371b.m10088a();
            mq mqVar = this.f6376g;
            int i = this.f6375f;
            if (this.f6378i.get() <= 0) {
                z = false;
            }
            mqVar.m10059a(i, z);
        }
    }

    public C1864a<O> m10594b() {
        return this.f6372c;
    }

    public O m10595c() {
        return this.f6373d;
    }

    public lz<O> m10596d() {
        return this.f6374e;
    }

    public Context m10597e() {
        return this.f6370a;
    }
}
