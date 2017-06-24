package com.google.android.gms.p031b;

import com.google.android.gms.p031b.C1493f.C1487a;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.Callable;

public abstract class bh implements Callable {
    protected final String f4155a = getClass().getSimpleName();
    protected final ao f4156b;
    protected final String f4157c;
    protected final String f4158d;
    protected final C1487a f4159e;
    protected Method f4160f;
    protected final int f4161g;
    protected final int f4162h;

    public bh(ao aoVar, String str, String str2, C1487a c1487a, int i, int i2) {
        this.f4156b = aoVar;
        this.f4157c = str;
        this.f4158d = str2;
        this.f4159e = c1487a;
        this.f4161g = i;
        this.f4162h = i2;
    }

    protected abstract void mo1239a();

    public Void m7514b() {
        try {
            long nanoTime = System.nanoTime();
            this.f4160f = this.f4156b.m7494a(this.f4157c, this.f4158d);
            if (this.f4160f != null) {
                mo1239a();
                C1732m i = this.f4156b.m7503i();
                if (!(i == null || this.f4161g == Integer.MIN_VALUE)) {
                    i.m9747a(this.f4162h, this.f4161g, (System.nanoTime() - nanoTime) / 1000);
                }
            }
        } catch (IllegalAccessException e) {
        } catch (InvocationTargetException e2) {
        }
        return null;
    }

    public /* synthetic */ Object call() {
        return m7514b();
    }
}
