package com.google.android.gms.common.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.C1767c.C1733c;
import com.google.android.gms.common.api.C1767c.C1742b;
import com.google.android.gms.common.api.C1864a.C1861h;

public class C1899f<T extends IInterface> extends C1724r<T> {
    private final C1861h<T> f6437a;

    public C1899f(Context context, Looper looper, int i, C1742b c1742b, C1733c c1733c, C1927n c1927n, C1861h<T> c1861h) {
        super(context, looper, i, c1927n, c1742b, c1733c);
        this.f6437a = c1861h;
    }

    protected String mo1181a() {
        return this.f6437a.m10568a();
    }

    protected void mo1701a(int i, T t) {
        this.f6437a.m10569a(i, t);
    }

    protected T mo1182b(IBinder iBinder) {
        return this.f6437a.m10567a(iBinder);
    }

    protected String mo1183b() {
        return this.f6437a.m10570b();
    }

    public C1861h<T> mo1702k() {
        return this.f6437a;
    }
}
