package com.google.android.gms.p031b;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.ads.p035c.C1025a;
import com.google.android.gms.clearcut.C1854b;
import com.google.android.gms.common.C1876j;
import com.google.android.gms.common.C1878c;
import com.google.android.gms.common.C1880d;
import com.google.android.gms.common.api.C1767c;
import com.google.android.gms.common.api.C1767c.C1866a;
import com.google.android.gms.gass.internal.C1997a;
import com.google.android.gms.p031b.C1493f.C1487a;
import com.google.android.gms.p031b.C1493f.C1490d;
import com.google.android.gms.p031b.al.C1366a;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class ao {
    protected static final Object f4135c = new Object();
    private static final String f4136f = ao.class.getSimpleName();
    private static C1876j f4137r = null;
    protected Context f4138a;
    protected boolean f4139b = false;
    protected boolean f4140d = false;
    protected boolean f4141e = false;
    private ExecutorService f4142g;
    private DexClassLoader f4143h;
    private al f4144i;
    private byte[] f4145j;
    private volatile C1025a f4146k = null;
    private volatile boolean f4147l = false;
    private Future f4148m = null;
    private volatile C1487a f4149n = null;
    private Future f4150o = null;
    private C1732m f4151p;
    private C1767c f4152q = null;
    private Map<Pair<String, String>, bg> f4153s;

    class C13671 implements Runnable {
        final /* synthetic */ ao f4133a;

        C13671(ao aoVar) {
            this.f4133a = aoVar;
        }

        public void run() {
            this.f4133a.m7490q();
        }
    }

    class C13682 implements Runnable {
        final /* synthetic */ ao f4134a;

        C13682(ao aoVar) {
            this.f4134a = aoVar;
        }

        public void run() {
            this.f4134a.m7491r();
        }
    }

    private ao(Context context) {
        this.f4138a = context;
        this.f4153s = new HashMap();
    }

    public static ao m7479a(Context context, String str, String str2, boolean z) {
        ao aoVar = new ao(context);
        try {
            if (aoVar.m7486a(str, str2, z)) {
                return aoVar;
            }
        } catch (an e) {
        }
        return null;
    }

    private File m7480a(String str, File file, String str2) {
        File file2 = new File(String.format("%s/%s.jar", new Object[]{file, str2}));
        if (!file2.exists()) {
            byte[] a = this.f4144i.m7445a(this.f4145j, str);
            file2.createNewFile();
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            fileOutputStream.write(a, 0, a.length);
            fileOutputStream.close();
        }
        return file2;
    }

    private void m7482a(File file) {
        if (file.exists()) {
            file.delete();
            return;
        }
        Log.d(f4136f, String.format("File %s not found. No need for deletion", new Object[]{file.getAbsolutePath()}));
    }

    private void m7483a(File file, String str) {
        Throwable th;
        File file2 = new File(String.format("%s/%s.tmp", new Object[]{file, str}));
        if (!file2.exists()) {
            File file3 = new File(String.format("%s/%s.dex", new Object[]{file, str}));
            if (file3.exists()) {
                FileInputStream fileInputStream = null;
                long length = file3.length();
                if (length > 0) {
                    byte[] bArr = new byte[((int) length)];
                    FileInputStream fileInputStream2;
                    try {
                        fileInputStream2 = new FileInputStream(file3);
                        try {
                            if (fileInputStream2.read(bArr) <= 0) {
                                if (fileInputStream2 != null) {
                                    try {
                                        fileInputStream2.close();
                                    } catch (IOException e) {
                                    }
                                }
                                m7482a(file3);
                                return;
                            }
                            C1357z c1490d = new C1490d();
                            c1490d.f4691d = VERSION.SDK.getBytes();
                            c1490d.f4690c = str.getBytes();
                            bArr = this.f4144i.m7443a(this.f4145j, bArr).getBytes();
                            c1490d.f4688a = bArr;
                            c1490d.f4689b = C1597i.m8855a(bArr);
                            file2.createNewFile();
                            FileOutputStream fileOutputStream = new FileOutputStream(file2);
                            byte[] a = C1357z.m7342a(c1490d);
                            fileOutputStream.write(a, 0, a.length);
                            fileOutputStream.close();
                            if (fileInputStream2 != null) {
                                try {
                                    fileInputStream2.close();
                                } catch (IOException e2) {
                                }
                            }
                            m7482a(file3);
                        } catch (IOException e3) {
                            if (fileInputStream2 != null) {
                                try {
                                    fileInputStream2.close();
                                } catch (IOException e4) {
                                }
                            }
                            m7482a(file3);
                        } catch (NoSuchAlgorithmException e5) {
                            if (fileInputStream2 != null) {
                                fileInputStream2.close();
                            }
                            m7482a(file3);
                        } catch (C1366a e6) {
                            if (fileInputStream2 != null) {
                                fileInputStream2.close();
                            }
                            m7482a(file3);
                        } catch (Throwable th2) {
                            Throwable th3 = th2;
                            fileInputStream = fileInputStream2;
                            th = th3;
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (IOException e7) {
                                }
                            }
                            m7482a(file3);
                            throw th;
                        }
                    } catch (IOException e8) {
                        fileInputStream2 = null;
                        if (fileInputStream2 != null) {
                            fileInputStream2.close();
                        }
                        m7482a(file3);
                    } catch (NoSuchAlgorithmException e9) {
                        fileInputStream2 = null;
                        if (fileInputStream2 != null) {
                            fileInputStream2.close();
                        }
                        m7482a(file3);
                    } catch (C1366a e10) {
                        fileInputStream2 = null;
                        if (fileInputStream2 != null) {
                            fileInputStream2.close();
                        }
                        m7482a(file3);
                    } catch (Throwable th4) {
                        th = th4;
                        if (fileInputStream != null) {
                            fileInputStream.close();
                        }
                        m7482a(file3);
                        throw th;
                    }
                }
            }
        }
    }

    private void m7484a(boolean z) {
        this.f4147l = z;
        if (z) {
            this.f4148m = this.f4142g.submit(new C13671(this));
        }
    }

    private boolean m7485a(String str) {
        File file;
        String b;
        File a;
        try {
            File cacheDir = this.f4138a.getCacheDir();
            if (cacheDir == null) {
                cacheDir = this.f4138a.getDir("dex", 0);
                if (cacheDir == null) {
                    throw new an();
                }
            }
            file = cacheDir;
            b = am.m7454b();
            a = m7480a(str, file, b);
            m7489b(file, b);
            this.f4143h = new DexClassLoader(a.getAbsolutePath(), file.getAbsolutePath(), null, this.f4138a.getClassLoader());
            m7482a(a);
            m7483a(file, b);
            m7488b(String.format("%s/%s.dex", new Object[]{file, b}));
            return true;
        } catch (Throwable e) {
            throw new an(e);
        } catch (Throwable e2) {
            throw new an(e2);
        } catch (Throwable e22) {
            throw new an(e22);
        } catch (Throwable e222) {
            throw new an(e222);
        } catch (Throwable th) {
            m7482a(a);
            m7483a(file, b);
            m7488b(String.format("%s/%s.dex", new Object[]{file, b}));
        }
    }

    private boolean m7486a(String str, String str2, boolean z) {
        this.f4142g = Executors.newCachedThreadPool();
        m7484a(z);
        m7492s();
        m7506l();
        this.f4144i = new al(null);
        try {
            this.f4145j = this.f4144i.m7444a(str);
            boolean a = m7485a(str2);
            this.f4151p = new C1732m(this);
            return a;
        } catch (Throwable e) {
            throw new an(e);
        }
    }

    private void m7488b(String str) {
        m7482a(new File(str));
    }

    private boolean m7489b(File file, String str) {
        File file2 = new File(String.format("%s/%s.tmp", new Object[]{file, str}));
        if (!file2.exists()) {
            return false;
        }
        File file3 = new File(String.format("%s/%s.dex", new Object[]{file, str}));
        if (file3.exists()) {
            return false;
        }
        try {
            long length = file2.length();
            if (length <= 0) {
                m7482a(file2);
                return false;
            }
            byte[] bArr = new byte[((int) length)];
            if (new FileInputStream(file2).read(bArr) <= 0) {
                Log.d(f4136f, "Cannot read the cache data.");
                m7482a(file2);
                return false;
            }
            C1490d a = C1490d.m8178a(bArr);
            if (str.equals(new String(a.f4690c)) && Arrays.equals(a.f4689b, C1597i.m8855a(a.f4688a)) && Arrays.equals(a.f4691d, VERSION.SDK.getBytes())) {
                byte[] a2 = this.f4144i.m7445a(this.f4145j, new String(a.f4688a));
                file3.createNewFile();
                FileOutputStream fileOutputStream = new FileOutputStream(file3);
                fileOutputStream.write(a2, 0, a2.length);
                fileOutputStream.close();
                return true;
            }
            m7482a(file2);
            return false;
        } catch (IOException e) {
            return false;
        } catch (NoSuchAlgorithmException e2) {
            return false;
        } catch (C1366a e3) {
            return false;
        }
    }

    private void m7490q() {
        try {
            if (this.f4146k == null) {
                C1025a c1025a = new C1025a(this.f4138a);
                c1025a.m5786a();
                this.f4146k = c1025a;
            }
        } catch (C1878c e) {
            this.f4146k = null;
        } catch (IOException e2) {
            this.f4146k = null;
        } catch (C1880d e3) {
            this.f4146k = null;
        }
    }

    private void m7491r() {
        if (this.f4140d) {
            try {
                this.f4149n = C1997a.m11162a(this.f4138a, this.f4138a.getPackageName(), Integer.toString(this.f4138a.getPackageManager().getPackageInfo(this.f4138a.getPackageName(), 0).versionCode));
            } catch (NameNotFoundException e) {
            }
        }
    }

    private void m7492s() {
        boolean z = true;
        f4137r = C1876j.m10605b();
        this.f4139b = f4137r.mo1649b(this.f4138a) > 0;
        if (f4137r.mo1643a(this.f4138a) != 0) {
            z = false;
        }
        this.f4140d = z;
        if (this.f4138a.getApplicationContext() != null) {
            this.f4152q = new C1866a(this.f4138a).m10584a(C1854b.f6307c).m10586b();
        }
        cq.m7828a(this.f4138a);
    }

    public Context m7493a() {
        return this.f4138a;
    }

    public Method m7494a(String str, String str2) {
        bg bgVar = (bg) this.f4153s.get(new Pair(str, str2));
        return bgVar == null ? null : bgVar.m7542a();
    }

    public boolean m7495a(String str, String str2, List<Class> list) {
        if (this.f4153s.containsKey(new Pair(str, str2))) {
            return false;
        }
        this.f4153s.put(new Pair(str, str2), new bg(this, str, str2, list));
        return true;
    }

    public ExecutorService m7496b() {
        return this.f4142g;
    }

    public DexClassLoader m7497c() {
        return this.f4143h;
    }

    public al m7498d() {
        return this.f4144i;
    }

    public byte[] m7499e() {
        return this.f4145j;
    }

    public C1767c m7500f() {
        return this.f4152q;
    }

    public boolean m7501g() {
        return this.f4139b;
    }

    public boolean m7502h() {
        return this.f4141e;
    }

    public C1732m m7503i() {
        return this.f4151p;
    }

    public C1487a m7504j() {
        return this.f4149n;
    }

    public Future m7505k() {
        return this.f4150o;
    }

    void m7506l() {
        if (((Boolean) cq.aX.m7801c()).booleanValue()) {
            this.f4150o = this.f4142g.submit(new C13682(this));
        }
    }

    public C1025a m7507m() {
        if (!this.f4147l) {
            return null;
        }
        if (this.f4146k != null) {
            return this.f4146k;
        }
        if (this.f4148m != null) {
            try {
                this.f4148m.get(2000, TimeUnit.MILLISECONDS);
                this.f4148m = null;
            } catch (InterruptedException e) {
            } catch (ExecutionException e2) {
            } catch (TimeoutException e3) {
                this.f4148m.cancel(true);
            }
        }
        return this.f4146k;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m7508n() {
        /*
        r2 = this;
        r1 = f4135c;
        monitor-enter(r1);
        r0 = r2.f4141e;	 Catch:{ all -> 0x001b }
        if (r0 == 0) goto L_0x0009;
    L_0x0007:
        monitor-exit(r1);	 Catch:{ all -> 0x001b }
    L_0x0008:
        return;
    L_0x0009:
        r0 = r2.f4140d;	 Catch:{ all -> 0x001b }
        if (r0 == 0) goto L_0x001e;
    L_0x000d:
        r0 = r2.f4152q;	 Catch:{ all -> 0x001b }
        if (r0 == 0) goto L_0x001e;
    L_0x0011:
        r0 = r2.f4152q;	 Catch:{ all -> 0x001b }
        r0.mo1611b();	 Catch:{ all -> 0x001b }
        r0 = 1;
        r2.f4141e = r0;	 Catch:{ all -> 0x001b }
    L_0x0019:
        monitor-exit(r1);	 Catch:{ all -> 0x001b }
        goto L_0x0008;
    L_0x001b:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x001b }
        throw r0;
    L_0x001e:
        r0 = 0;
        r2.f4141e = r0;	 Catch:{ all -> 0x001b }
        goto L_0x0019;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.b.ao.n():void");
    }

    public void m7509o() {
        synchronized (f4135c) {
            if (this.f4141e && this.f4152q != null) {
                this.f4152q.mo1614c();
                this.f4141e = false;
            }
        }
    }

    public int m7510p() {
        C1732m i = m7503i();
        return i != null ? i.m9746a() : Integer.MIN_VALUE;
    }
}
