package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.C1876j;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.C1865b;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.C1907z.C1908a;
import com.google.android.gms.common.internal.aa.C1890a;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class C1268k<T extends IInterface> {
    public static final String[] f3850d = new String[]{"service_esmobile", "service_googleme"};
    private int f3851a;
    final Handler f3852b;
    protected AtomicInteger f3853c;
    private long f3854e;
    private long f3855f;
    private int f3856g;
    private long f3857h;
    private final Context f3858i;
    private final Looper f3859j;
    private final C1939t f3860k;
    private final C1876j f3861l;
    private final Object f3862m;
    private final Object f3863n;
    private aa f3864o;
    private C1751f f3865p;
    private T f3866q;
    private final ArrayList<C1904e<?>> f3867r;
    private C1910h f3868s;
    private int f3869t;
    private final C1265b f3870u;
    private final C1266c f3871v;
    private final int f3872w;
    private final String f3873x;

    public interface C1265b {
        void mo1178a(int i);

        void mo1179a(Bundle bundle);
    }

    public interface C1266c {
        void mo1180a(ConnectionResult connectionResult);
    }

    public interface C1751f {
        void mo1595a(ConnectionResult connectionResult);
    }

    protected abstract class C1904e<TListener> {
        private TListener f6440a;
        private boolean f6441b = false;
        final /* synthetic */ C1268k f6442d;

        public C1904e(C1268k c1268k, TListener tListener) {
            this.f6442d = c1268k;
            this.f6440a = tListener;
        }

        protected abstract void mo1703a(TListener tListener);

        protected abstract void mo1704b();

        public void m10822c() {
            synchronized (this) {
                Object obj = this.f6440a;
                if (this.f6441b) {
                    String valueOf = String.valueOf(this);
                    Log.w("GmsClient", new StringBuilder(String.valueOf(valueOf).length() + 47).append("Callback proxy ").append(valueOf).append(" being reused. This is not safe.").toString());
                }
            }
            if (obj != null) {
                try {
                    mo1703a(obj);
                } catch (RuntimeException e) {
                    mo1704b();
                    throw e;
                }
            }
            mo1704b();
            synchronized (this) {
                this.f6441b = true;
            }
            m10823d();
        }

        public void m10823d() {
            m10824e();
            synchronized (this.f6442d.f3867r) {
                this.f6442d.f3867r.remove(this);
            }
        }

        public void m10824e() {
            synchronized (this) {
                this.f6440a = null;
            }
        }
    }

    private abstract class C1905a extends C1904e<Boolean> {
        public final int f6443a;
        public final Bundle f6444b;
        final /* synthetic */ C1268k f6445c;

        protected C1905a(C1268k c1268k, int i, Bundle bundle) {
            this.f6445c = c1268k;
            super(c1268k, Boolean.valueOf(true));
            this.f6443a = i;
            this.f6444b = bundle;
        }

        protected abstract void mo1707a(ConnectionResult connectionResult);

        protected void m10826a(Boolean bool) {
            PendingIntent pendingIntent = null;
            if (bool == null) {
                this.f6445c.m6946b(1, null);
                return;
            }
            switch (this.f6443a) {
                case 0:
                    if (!mo1708a()) {
                        this.f6445c.m6946b(1, null);
                        mo1707a(new ConnectionResult(8, null));
                        return;
                    }
                    return;
                case 10:
                    this.f6445c.m6946b(1, null);
                    throw new IllegalStateException("A fatal developer error has occurred. Check the logs for further information.");
                default:
                    this.f6445c.m6946b(1, null);
                    if (this.f6444b != null) {
                        pendingIntent = (PendingIntent) this.f6444b.getParcelable("pendingIntent");
                    }
                    mo1707a(new ConnectionResult(this.f6443a, pendingIntent));
                    return;
            }
        }

        protected /* synthetic */ void mo1703a(Object obj) {
            m10826a((Boolean) obj);
        }

        protected abstract boolean mo1708a();

        protected void mo1704b() {
        }
    }

    final class C1906d extends Handler {
        final /* synthetic */ C1268k f6446a;

        public C1906d(C1268k c1268k, Looper looper) {
            this.f6446a = c1268k;
            super(looper);
        }

        private void m10830a(Message message) {
            C1904e c1904e = (C1904e) message.obj;
            c1904e.mo1704b();
            c1904e.m10823d();
        }

        private boolean m10831b(Message message) {
            return message.what == 2 || message.what == 1 || message.what == 5;
        }

        public void handleMessage(Message message) {
            PendingIntent pendingIntent = null;
            if (this.f6446a.f3853c.get() != message.arg1) {
                if (m10831b(message)) {
                    m10830a(message);
                }
            } else if ((message.what == 1 || message.what == 5) && !this.f6446a.m6967e()) {
                m10830a(message);
            } else if (message.what == 3) {
                if (message.obj instanceof PendingIntent) {
                    pendingIntent = (PendingIntent) message.obj;
                }
                ConnectionResult connectionResult = new ConnectionResult(message.arg2, pendingIntent);
                this.f6446a.f3865p.mo1595a(connectionResult);
                this.f6446a.m6958a(connectionResult);
            } else if (message.what == 4) {
                this.f6446a.m6946b(4, null);
                if (this.f6446a.f3870u != null) {
                    this.f6446a.f3870u.mo1178a(message.arg2);
                }
                this.f6446a.m6953a(message.arg2);
                this.f6446a.m6943a(4, 1, null);
            } else if (message.what == 2 && !this.f6446a.m6966d()) {
                m10830a(message);
            } else if (m10831b(message)) {
                ((C1904e) message.obj).m10822c();
            } else {
                Log.wtf("GmsClient", "Don't know how to handle message: " + message.what, new Exception());
            }
        }
    }

    public static final class C1909g extends C1908a {
        private C1268k f6447a;
        private final int f6448b;

        public C1909g(C1268k c1268k, int i) {
            this.f6447a = c1268k;
            this.f6448b = i;
        }

        private void m10835a() {
            this.f6447a = null;
        }

        public void mo1705a(int i, Bundle bundle) {
            Log.wtf("GmsClient", "received deprecated onAccountValidationComplete callback, ignoring", new Exception());
        }

        public void mo1706a(int i, IBinder iBinder, Bundle bundle) {
            C1896c.m10791a(this.f6447a, (Object) "onPostInitComplete can be called only once per call to getRemoteService");
            this.f6447a.m6955a(i, iBinder, bundle, this.f6448b);
            m10835a();
        }
    }

    public final class C1910h implements ServiceConnection {
        final /* synthetic */ C1268k f6449a;
        private final int f6450b;

        public C1910h(C1268k c1268k, int i) {
            this.f6449a = c1268k;
            this.f6450b = i;
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            C1896c.m10791a((Object) iBinder, (Object) "Expecting a valid IBinder");
            synchronized (this.f6449a.f3863n) {
                this.f6449a.f3864o = C1890a.m10775a(iBinder);
            }
            this.f6449a.m6954a(0, null, this.f6450b);
        }

        public void onServiceDisconnected(ComponentName componentName) {
            synchronized (this.f6449a.f3863n) {
                this.f6449a.f3864o = null;
            }
            this.f6449a.f3852b.sendMessage(this.f6449a.f3852b.obtainMessage(4, this.f6450b, 1));
        }
    }

    protected class C1911i implements C1751f {
        final /* synthetic */ C1268k f6451a;

        public C1911i(C1268k c1268k) {
            this.f6451a = c1268k;
        }

        public void mo1595a(ConnectionResult connectionResult) {
            if (connectionResult.m10547b()) {
                this.f6451a.m6960a(null, this.f6451a.mo1557w());
            } else if (this.f6451a.f3871v != null) {
                this.f6451a.f3871v.mo1180a(connectionResult);
            }
        }
    }

    protected final class C1912j extends C1905a {
        public final IBinder f6452e;
        final /* synthetic */ C1268k f6453f;

        public C1912j(C1268k c1268k, int i, IBinder iBinder, Bundle bundle) {
            this.f6453f = c1268k;
            super(c1268k, i, bundle);
            this.f6452e = iBinder;
        }

        protected void mo1707a(ConnectionResult connectionResult) {
            if (this.f6453f.f3871v != null) {
                this.f6453f.f3871v.mo1180a(connectionResult);
            }
            this.f6453f.m6958a(connectionResult);
        }

        protected boolean mo1708a() {
            try {
                String interfaceDescriptor = this.f6452e.getInterfaceDescriptor();
                if (this.f6453f.mo1183b().equals(interfaceDescriptor)) {
                    IInterface b = this.f6453f.mo1182b(this.f6452e);
                    if (b == null || !this.f6453f.m6943a(2, 3, b)) {
                        return false;
                    }
                    Bundle t = this.f6453f.m6980t();
                    if (this.f6453f.f3870u != null) {
                        this.f6453f.f3870u.mo1179a(t);
                    }
                    return true;
                }
                String valueOf = String.valueOf(this.f6453f.mo1183b());
                Log.e("GmsClient", new StringBuilder((String.valueOf(valueOf).length() + 34) + String.valueOf(interfaceDescriptor).length()).append("service descriptor mismatch: ").append(valueOf).append(" vs. ").append(interfaceDescriptor).toString());
                return false;
            } catch (RemoteException e) {
                Log.w("GmsClient", "service probably died");
                return false;
            }
        }
    }

    protected final class C1913k extends C1905a {
        final /* synthetic */ C1268k f6454e;

        public C1913k(C1268k c1268k, int i, Bundle bundle) {
            this.f6454e = c1268k;
            super(c1268k, i, bundle);
        }

        protected void mo1707a(ConnectionResult connectionResult) {
            this.f6454e.f3865p.mo1595a(connectionResult);
            this.f6454e.m6958a(connectionResult);
        }

        protected boolean mo1708a() {
            this.f6454e.f3865p.mo1595a(ConnectionResult.f6323a);
            return true;
        }
    }

    protected C1268k(Context context, Looper looper, int i, C1265b c1265b, C1266c c1266c, String str) {
        this(context, looper, C1939t.m10955a(context), C1876j.m10605b(), i, (C1265b) C1896c.m10790a((Object) c1265b), (C1266c) C1896c.m10790a((Object) c1266c), str);
    }

    protected C1268k(Context context, Looper looper, C1939t c1939t, C1876j c1876j, int i, C1265b c1265b, C1266c c1266c, String str) {
        this.f3862m = new Object();
        this.f3863n = new Object();
        this.f3867r = new ArrayList();
        this.f3869t = 1;
        this.f3853c = new AtomicInteger(0);
        this.f3858i = (Context) C1896c.m10791a((Object) context, (Object) "Context must not be null");
        this.f3859j = (Looper) C1896c.m10791a((Object) looper, (Object) "Looper must not be null");
        this.f3860k = (C1939t) C1896c.m10791a((Object) c1939t, (Object) "Supervisor must not be null");
        this.f3861l = (C1876j) C1896c.m10791a((Object) c1876j, (Object) "API availability must not be null");
        this.f3852b = new C1906d(this, looper);
        this.f3872w = i;
        this.f3870u = c1265b;
        this.f3871v = c1266c;
        this.f3873x = str;
    }

    private boolean m6943a(int i, int i2, T t) {
        boolean z;
        synchronized (this.f3862m) {
            if (this.f3869t != i) {
                z = false;
            } else {
                m6946b(i2, t);
                z = true;
            }
        }
        return z;
    }

    private void m6946b(int i, T t) {
        boolean z = true;
        if ((i == 3) != (t != null)) {
            z = false;
        }
        C1896c.m10798b(z);
        synchronized (this.f3862m) {
            this.f3869t = i;
            this.f3866q = t;
            mo1701a(i, (IInterface) t);
            switch (i) {
                case 1:
                    m6951x();
                    break;
                case 2:
                    mo1702k();
                    break;
                case 3:
                    m6957a((IInterface) t);
                    break;
            }
        }
    }

    private void mo1702k() {
        if (this.f3868s != null) {
            String valueOf = String.valueOf(mo1181a());
            String valueOf2 = String.valueOf(k_());
            Log.e("GmsClient", new StringBuilder((String.valueOf(valueOf).length() + 70) + String.valueOf(valueOf2).length()).append("Calling connect() while still connected, missing disconnect() for ").append(valueOf).append(" on ").append(valueOf2).toString());
            this.f3860k.mo1714b(mo1181a(), k_(), this.f3868s, m6973m());
            this.f3853c.incrementAndGet();
        }
        this.f3868s = new C1910h(this, this.f3853c.get());
        if (!this.f3860k.mo1713a(mo1181a(), k_(), this.f3868s, m6973m())) {
            valueOf = String.valueOf(mo1181a());
            valueOf2 = String.valueOf(k_());
            Log.e("GmsClient", new StringBuilder((String.valueOf(valueOf).length() + 34) + String.valueOf(valueOf2).length()).append("unable to connect to service: ").append(valueOf).append(" on ").append(valueOf2).toString());
            m6954a(16, null, this.f3853c.get());
        }
    }

    private void m6951x() {
        if (this.f3868s != null) {
            this.f3860k.mo1714b(mo1181a(), k_(), this.f3868s, m6973m());
            this.f3868s = null;
        }
    }

    protected abstract String mo1181a();

    protected void m6953a(int i) {
        this.f3851a = i;
        this.f3854e = System.currentTimeMillis();
    }

    protected void m6954a(int i, Bundle bundle, int i2) {
        this.f3852b.sendMessage(this.f3852b.obtainMessage(5, i2, -1, new C1913k(this, i, bundle)));
    }

    protected void m6955a(int i, IBinder iBinder, Bundle bundle, int i2) {
        this.f3852b.sendMessage(this.f3852b.obtainMessage(1, i2, -1, new C1912j(this, i, iBinder, bundle)));
    }

    void mo1701a(int i, T t) {
    }

    protected void m6957a(T t) {
        this.f3855f = System.currentTimeMillis();
    }

    protected void m6958a(ConnectionResult connectionResult) {
        this.f3856g = connectionResult.m10548c();
        this.f3857h = System.currentTimeMillis();
    }

    public void m6959a(C1751f c1751f) {
        this.f3865p = (C1751f) C1896c.m10791a((Object) c1751f, (Object) "Connection progress callbacks cannot be null.");
        m6946b(2, null);
    }

    public void m6960a(C1886w c1886w, Set<Scope> set) {
        try {
            GetServiceRequest a = new GetServiceRequest(this.f3872w).m10668a(this.f3858i.getPackageName()).m10666a(mo1774r());
            if (set != null) {
                a.m10669a((Collection) set);
            }
            if (mo1772f()) {
                a.m10665a(m6977q()).m10667a(c1886w);
            } else if (m6982v()) {
                a.m10665a(mo1556p());
            }
            synchronized (this.f3863n) {
                if (this.f3864o != null) {
                    this.f3864o.mo1667a(new C1909g(this, this.f3853c.get()), a);
                } else {
                    Log.w("GmsClient", "mServiceBroker is null, client disconnected");
                }
            }
        } catch (DeadObjectException e) {
            Log.w("GmsClient", "service died");
            m6964b(1);
        } catch (Throwable e2) {
            Log.w("GmsClient", "Remote exception occurred", e2);
        }
    }

    public void m6961a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        synchronized (this.f3862m) {
            int i = this.f3869t;
            IInterface iInterface = this.f3866q;
        }
        printWriter.append(str).append("mConnectState=");
        switch (i) {
            case 1:
                printWriter.print("DISCONNECTED");
                break;
            case 2:
                printWriter.print("CONNECTING");
                break;
            case 3:
                printWriter.print("CONNECTED");
                break;
            case 4:
                printWriter.print("DISCONNECTING");
                break;
            default:
                printWriter.print("UNKNOWN");
                break;
        }
        printWriter.append(" mService=");
        if (iInterface == null) {
            printWriter.println("null");
        } else {
            printWriter.append(mo1183b()).append("@").println(Integer.toHexString(System.identityHashCode(iInterface.asBinder())));
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.US);
        if (this.f3855f > 0) {
            PrintWriter append = printWriter.append(str).append("lastConnectedTime=");
            long j = this.f3855f;
            String valueOf = String.valueOf(simpleDateFormat.format(new Date(this.f3855f)));
            append.println(new StringBuilder(String.valueOf(valueOf).length() + 21).append(j).append(" ").append(valueOf).toString());
        }
        if (this.f3854e > 0) {
            printWriter.append(str).append("lastSuspendedCause=");
            switch (this.f3851a) {
                case 1:
                    printWriter.append("CAUSE_SERVICE_DISCONNECTED");
                    break;
                case 2:
                    printWriter.append("CAUSE_NETWORK_LOST");
                    break;
                default:
                    printWriter.append(String.valueOf(this.f3851a));
                    break;
            }
            append = printWriter.append(" lastSuspendedTime=");
            j = this.f3854e;
            valueOf = String.valueOf(simpleDateFormat.format(new Date(this.f3854e)));
            append.println(new StringBuilder(String.valueOf(valueOf).length() + 21).append(j).append(" ").append(valueOf).toString());
        }
        if (this.f3857h > 0) {
            printWriter.append(str).append("lastFailedStatus=").append(C1865b.m10579a(this.f3856g));
            append = printWriter.append(" lastFailedTime=");
            j = this.f3857h;
            String valueOf2 = String.valueOf(simpleDateFormat.format(new Date(this.f3857h)));
            append.println(new StringBuilder(String.valueOf(valueOf2).length() + 21).append(j).append(" ").append(valueOf2).toString());
        }
    }

    protected abstract T mo1182b(IBinder iBinder);

    protected abstract String mo1183b();

    public void m6964b(int i) {
        this.f3852b.sendMessage(this.f3852b.obtainMessage(4, this.f3853c.get(), i));
    }

    public void m6965c() {
        this.f3853c.incrementAndGet();
        synchronized (this.f3867r) {
            int size = this.f3867r.size();
            for (int i = 0; i < size; i++) {
                ((C1904e) this.f3867r.get(i)).m10824e();
            }
            this.f3867r.clear();
        }
        synchronized (this.f3863n) {
            this.f3864o = null;
        }
        m6946b(1, null);
    }

    public boolean m6966d() {
        boolean z;
        synchronized (this.f3862m) {
            z = this.f3869t == 3;
        }
        return z;
    }

    public boolean m6967e() {
        boolean z;
        synchronized (this.f3862m) {
            z = this.f3869t == 2;
        }
        return z;
    }

    public boolean mo1772f() {
        return false;
    }

    public boolean m6969g() {
        return true;
    }

    public boolean m6970h() {
        return false;
    }

    public Intent m6971i() {
        throw new UnsupportedOperationException("Not a sign in API");
    }

    public IBinder m6972j() {
        IBinder iBinder;
        synchronized (this.f3863n) {
            if (this.f3864o == null) {
                iBinder = null;
            } else {
                iBinder = this.f3864o.asBinder();
            }
        }
        return iBinder;
    }

    protected String k_() {
        return "com.google.android.gms";
    }

    protected final String m6973m() {
        return this.f3873x == null ? this.f3858i.getClass().getName() : this.f3873x;
    }

    public void m6974n() {
        int a = this.f3861l.mo1643a(this.f3858i);
        if (a != 0) {
            m6946b(1, null);
            this.f3865p = new C1911i(this);
            this.f3852b.sendMessage(this.f3852b.obtainMessage(3, this.f3853c.get(), a));
            return;
        }
        m6959a(new C1911i(this));
    }

    public final Context m6975o() {
        return this.f3858i;
    }

    public Account mo1556p() {
        return null;
    }

    public final Account m6977q() {
        return mo1556p() != null ? mo1556p() : new Account("<<default account>>", "com.google");
    }

    protected Bundle mo1774r() {
        return new Bundle();
    }

    protected final void m6979s() {
        if (!m6966d()) {
            throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
        }
    }

    public Bundle m6980t() {
        return null;
    }

    public final T m6981u() {
        T t;
        synchronized (this.f3862m) {
            if (this.f3869t == 4) {
                throw new DeadObjectException();
            }
            m6979s();
            C1896c.m10795a(this.f3866q != null, (Object) "Client is connected but service is null");
            t = this.f3866q;
        }
        return t;
    }

    public boolean m6982v() {
        return false;
    }

    protected Set<Scope> mo1557w() {
        return Collections.EMPTY_SET;
    }
}
