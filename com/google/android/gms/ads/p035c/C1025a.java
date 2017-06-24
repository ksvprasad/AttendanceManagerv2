package com.google.android.gms.ads.p035c;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager.NameNotFoundException;
import android.util.Log;
import com.google.android.gms.common.C1876j;
import com.google.android.gms.common.C1878c;
import com.google.android.gms.common.C1884h;
import com.google.android.gms.common.internal.C1896c;
import com.google.android.gms.common.stats.C1959b;
import com.google.android.gms.p031b.bp;
import com.google.android.gms.p031b.bp.C1378a;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class C1025a {
    C1884h f3006a;
    bp f3007b;
    boolean f3008c;
    Object f3009d;
    C1024b f3010e;
    final long f3011f;
    private final Context f3012g;

    public static final class C1023a {
        private final String f3000a;
        private final boolean f3001b;

        public C1023a(String str, boolean z) {
            this.f3000a = str;
            this.f3001b = z;
        }

        public String m5776a() {
            return this.f3000a;
        }

        public boolean m5777b() {
            return this.f3001b;
        }

        public String toString() {
            String str = this.f3000a;
            return new StringBuilder(String.valueOf(str).length() + 7).append("{").append(str).append("}").append(this.f3001b).toString();
        }
    }

    static class C1024b extends Thread {
        CountDownLatch f3002a = new CountDownLatch(1);
        boolean f3003b = false;
        private WeakReference<C1025a> f3004c;
        private long f3005d;

        public C1024b(C1025a c1025a, long j) {
            this.f3004c = new WeakReference(c1025a);
            this.f3005d = j;
            start();
        }

        private void m5778c() {
            C1025a c1025a = (C1025a) this.f3004c.get();
            if (c1025a != null) {
                c1025a.m5789c();
                this.f3003b = true;
            }
        }

        public void m5779a() {
            this.f3002a.countDown();
        }

        public boolean m5780b() {
            return this.f3003b;
        }

        public void run() {
            try {
                if (!this.f3002a.await(this.f3005d, TimeUnit.MILLISECONDS)) {
                    m5778c();
                }
            } catch (InterruptedException e) {
                m5778c();
            }
        }
    }

    public C1025a(Context context) {
        this(context, 30000);
    }

    public C1025a(Context context, long j) {
        this.f3009d = new Object();
        C1896c.m10790a((Object) context);
        this.f3012g = context;
        this.f3008c = false;
        this.f3011f = j;
    }

    static bp m5781a(Context context, C1884h c1884h) {
        try {
            return C1378a.m7600a(c1884h.m10660a(10000, TimeUnit.MILLISECONDS));
        } catch (InterruptedException e) {
            throw new IOException("Interrupted exception");
        } catch (Throwable th) {
            IOException iOException = new IOException(th);
        }
    }

    static C1884h m5782a(Context context) {
        try {
            context.getPackageManager().getPackageInfo("com.android.vending", 0);
            switch (C1876j.m10605b().mo1643a(context)) {
                case 0:
                case 2:
                    ServiceConnection c1884h = new C1884h();
                    Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
                    intent.setPackage("com.google.android.gms");
                    try {
                        if (C1959b.m11039a().m11052a(context, intent, c1884h, 1)) {
                            return c1884h;
                        }
                        throw new IOException("Connection failure");
                    } catch (Throwable th) {
                        IOException iOException = new IOException(th);
                    }
                default:
                    throw new IOException("Google Play services not available");
            }
        } catch (NameNotFoundException e) {
            throw new C1878c(9);
        }
    }

    public static C1023a m5783b(Context context) {
        C1025a c1025a = new C1025a(context, -1);
        try {
            c1025a.m5787a(false);
            C1023a b = c1025a.m5788b();
            return b;
        } finally {
            c1025a.m5789c();
        }
    }

    public static void m5784b(boolean z) {
    }

    private void m5785d() {
        synchronized (this.f3009d) {
            if (this.f3010e != null) {
                this.f3010e.m5779a();
                try {
                    this.f3010e.join();
                } catch (InterruptedException e) {
                }
            }
            if (this.f3011f > 0) {
                this.f3010e = new C1024b(this, this.f3011f);
            }
        }
    }

    public void m5786a() {
        m5787a(true);
    }

    protected void m5787a(boolean z) {
        C1896c.m10800c("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            if (this.f3008c) {
                m5789c();
            }
            this.f3006a = C1025a.m5782a(this.f3012g);
            this.f3007b = C1025a.m5781a(this.f3012g, this.f3006a);
            this.f3008c = true;
            if (z) {
                m5785d();
            }
        }
    }

    public C1023a m5788b() {
        C1023a c1023a;
        C1896c.m10800c("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            if (!this.f3008c) {
                synchronized (this.f3009d) {
                    if (this.f3010e == null || !this.f3010e.m5780b()) {
                        throw new IOException("AdvertisingIdClient is not connected.");
                    }
                }
                try {
                    m5787a(false);
                    if (!this.f3008c) {
                        throw new IOException("AdvertisingIdClient cannot reconnect.");
                    }
                } catch (Throwable e) {
                    Log.i("AdvertisingIdClient", "GMS remote exception ", e);
                    throw new IOException("Remote exception");
                } catch (Throwable e2) {
                    throw new IOException("AdvertisingIdClient cannot reconnect.", e2);
                }
            }
            C1896c.m10790a(this.f3006a);
            C1896c.m10790a(this.f3007b);
            c1023a = new C1023a(this.f3007b.mo1253a(), this.f3007b.mo1256a(true));
        }
        m5785d();
        return c1023a;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m5789c() {
        /*
        r3 = this;
        r0 = "Calling this from your main thread can lead to deadlock";
        com.google.android.gms.common.internal.C1896c.m10800c(r0);
        monitor-enter(r3);
        r0 = r3.f3012g;	 Catch:{ all -> 0x002a }
        if (r0 == 0) goto L_0x000e;
    L_0x000a:
        r0 = r3.f3006a;	 Catch:{ all -> 0x002a }
        if (r0 != 0) goto L_0x0010;
    L_0x000e:
        monitor-exit(r3);	 Catch:{ all -> 0x002a }
    L_0x000f:
        return;
    L_0x0010:
        r0 = r3.f3008c;	 Catch:{ IllegalArgumentException -> 0x002d }
        if (r0 == 0) goto L_0x001f;
    L_0x0014:
        r0 = com.google.android.gms.common.stats.C1959b.m11039a();	 Catch:{ IllegalArgumentException -> 0x002d }
        r1 = r3.f3012g;	 Catch:{ IllegalArgumentException -> 0x002d }
        r2 = r3.f3006a;	 Catch:{ IllegalArgumentException -> 0x002d }
        r0.m11050a(r1, r2);	 Catch:{ IllegalArgumentException -> 0x002d }
    L_0x001f:
        r0 = 0;
        r3.f3008c = r0;	 Catch:{ all -> 0x002a }
        r0 = 0;
        r3.f3007b = r0;	 Catch:{ all -> 0x002a }
        r0 = 0;
        r3.f3006a = r0;	 Catch:{ all -> 0x002a }
        monitor-exit(r3);	 Catch:{ all -> 0x002a }
        goto L_0x000f;
    L_0x002a:
        r0 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x002a }
        throw r0;
    L_0x002d:
        r0 = move-exception;
        r1 = "AdvertisingIdClient";
        r2 = "AdvertisingIdClient unbindService failed.";
        android.util.Log.i(r1, r2, r0);	 Catch:{ all -> 0x002a }
        goto L_0x001f;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.c.a.c():void");
    }

    protected void finalize() {
        m5789c();
        super.finalize();
    }
}
