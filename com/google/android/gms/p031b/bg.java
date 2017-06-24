package com.google.android.gms.p031b;

import com.google.android.gms.p031b.al.C1366a;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class bg {
    protected static final String f4193a = bg.class.getSimpleName();
    private final ao f4194b;
    private final String f4195c;
    private final String f4196d;
    private final int f4197e = 2;
    private volatile Method f4198f = null;
    private List<Class> f4199g;
    private CountDownLatch f4200h = new CountDownLatch(1);

    class C13711 implements Runnable {
        final /* synthetic */ bg f4192a;

        C13711(bg bgVar) {
            this.f4192a = bgVar;
        }

        public void run() {
            this.f4192a.m7541b();
        }
    }

    public bg(ao aoVar, String str, String str2, List<Class> list) {
        this.f4194b = aoVar;
        this.f4195c = str;
        this.f4196d = str2;
        this.f4199g = new ArrayList(list);
        this.f4194b.m7496b().submit(new C13711(this));
    }

    private String m7539a(byte[] bArr, String str) {
        return new String(this.f4194b.m7498d().m7445a(bArr, str), "UTF-8");
    }

    private void m7541b() {
        try {
            Class loadClass = this.f4194b.m7497c().loadClass(m7539a(this.f4194b.m7499e(), this.f4195c));
            if (loadClass != null) {
                this.f4198f = loadClass.getMethod(m7539a(this.f4194b.m7499e(), this.f4196d), (Class[]) this.f4199g.toArray(new Class[this.f4199g.size()]));
                if (this.f4198f == null) {
                    this.f4200h.countDown();
                } else {
                    this.f4200h.countDown();
                }
            }
        } catch (C1366a e) {
        } catch (UnsupportedEncodingException e2) {
        } catch (ClassNotFoundException e3) {
        } catch (NoSuchMethodException e4) {
        } catch (NullPointerException e5) {
        } finally {
            this.f4200h.countDown();
        }
    }

    public Method m7542a() {
        if (this.f4198f != null) {
            return this.f4198f;
        }
        try {
            return this.f4200h.await(2, TimeUnit.SECONDS) ? this.f4198f : null;
        } catch (InterruptedException e) {
            return null;
        }
    }
}
