package com.google.android.gms.p033a;

import android.content.Context;
import android.os.IBinder;
import com.google.android.gms.common.C1881l;
import com.google.android.gms.common.internal.C1896c;

public abstract class C1003c<T> {
    private final String f2979a;
    private T f2980b;

    public static class C1002a extends Exception {
        public C1002a(String str) {
            super(str);
        }

        public C1002a(String str, Throwable th) {
            super(str, th);
        }
    }

    protected C1003c(String str) {
        this.f2979a = str;
    }

    protected final T m5715a(Context context) {
        if (this.f2980b == null) {
            C1896c.m10790a((Object) context);
            Context g = C1881l.m10648g(context);
            if (g == null) {
                throw new C1002a("Could not get remote context.");
            }
            try {
                this.f2980b = mo1043b((IBinder) g.getClassLoader().loadClass(this.f2979a).newInstance());
            } catch (Throwable e) {
                throw new C1002a("Could not load creator class.", e);
            } catch (Throwable e2) {
                throw new C1002a("Could not instantiate creator.", e2);
            } catch (Throwable e22) {
                throw new C1002a("Could not access creator.", e22);
            }
        }
        return this.f2980b;
    }

    protected abstract T mo1043b(IBinder iBinder);
}
