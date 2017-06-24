package com.google.android.gms.common.api;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.C1767c.C1733c;
import com.google.android.gms.common.api.C1767c.C1742b;
import com.google.android.gms.common.internal.C1268k.C1751f;
import com.google.android.gms.common.internal.C1886w;
import com.google.android.gms.common.internal.C1896c;
import com.google.android.gms.common.internal.C1927n;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public final class C1864a<O extends C1830a> {
    private final C1827b<?, O> f6344a;
    private final C1862i<?, O> f6345b = null;
    private final C1860g<?> f6346c;
    private final C1863j<?> f6347d;
    private final String f6348e;

    public interface C1721c {
    }

    public interface C1722f extends C1721c {
        void m9688a(C1751f c1751f);

        void m9689a(C1886w c1886w, Set<Scope> set);

        void m9690a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

        void m9691c();

        boolean m9692d();

        boolean m9693e();

        boolean mo1772f();

        boolean m9695g();

        boolean m9696h();

        Intent m9697i();

        IBinder m9698j();
    }

    public static abstract class C1826e<T extends C1721c, O> {
        public int m10323a() {
            return Integer.MAX_VALUE;
        }

        public List<Scope> m10324a(O o) {
            return Collections.emptyList();
        }
    }

    public static abstract class C1827b<T extends C1722f, O> extends C1826e<T, O> {
        public abstract T mo1639a(Context context, Looper looper, C1927n c1927n, O o, C1742b c1742b, C1733c c1733c);
    }

    public interface C1830a {

        public interface C1831a extends C1830a {
        }

        public interface C1835c extends C1830a {
        }

        public interface C1836d extends C1831a, C1835c {
        }

        public static final class C1858b implements C1835c {
            private C1858b() {
            }
        }
    }

    public static class C1859d<C extends C1721c> {
    }

    public static final class C1860g<C extends C1722f> extends C1859d<C> {
    }

    public interface C1861h<T extends IInterface> extends C1721c {
        T m10567a(IBinder iBinder);

        String m10568a();

        void m10569a(int i, T t);

        String m10570b();
    }

    public static abstract class C1862i<T extends C1861h, O> extends C1826e<T, O> {
        public abstract int m10571b();

        public abstract T m10572b(O o);
    }

    public static final class C1863j<C extends C1861h> extends C1859d<C> {
    }

    public <C extends C1722f> C1864a(String str, C1827b<C, O> c1827b, C1860g<C> c1860g) {
        C1896c.m10791a((Object) c1827b, (Object) "Cannot construct an Api with a null ClientBuilder");
        C1896c.m10791a((Object) c1860g, (Object) "Cannot construct an Api with a null ClientKey");
        this.f6348e = str;
        this.f6344a = c1827b;
        this.f6346c = c1860g;
        this.f6347d = null;
    }

    public C1826e<?, O> m10573a() {
        return m10577e() ? null : this.f6344a;
    }

    public C1827b<?, O> m10574b() {
        C1896c.m10795a(this.f6344a != null, (Object) "This API was constructed with a SimpleClientBuilder. Use getSimpleClientBuilder");
        return this.f6344a;
    }

    public C1862i<?, O> m10575c() {
        C1896c.m10795a(false, (Object) "This API was constructed with a ClientBuilder. Use getClientBuilder");
        return null;
    }

    public C1859d<?> m10576d() {
        if (this.f6346c != null) {
            return this.f6346c;
        }
        throw new IllegalStateException("This API was constructed with null client keys. This should not be possible.");
    }

    public boolean m10577e() {
        return false;
    }

    public String m10578f() {
        return this.f6348e;
    }
}
