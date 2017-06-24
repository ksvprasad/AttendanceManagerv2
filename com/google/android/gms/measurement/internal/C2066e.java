package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.common.C1876j;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.C1268k.C1265b;
import com.google.android.gms.common.internal.C1268k.C1266c;
import com.google.android.gms.common.internal.C1896c;
import com.google.android.gms.common.stats.C1959b;
import com.google.android.gms.common.util.C1970c;
import com.google.android.gms.measurement.internal.C2046y.C2047a;
import java.util.ArrayList;
import java.util.List;

public class C2066e extends C2019b {
    private final C2065a f6922a;
    private C2046y f6923b;
    private Boolean f6924c;
    private final C2054r f6925d;
    private final C2078i f6926e;
    private final List<Runnable> f6927f = new ArrayList();
    private final C2054r f6928g;

    class C20573 implements Runnable {
        final /* synthetic */ C2066e f6905a;

        C20573(C2066e c2066e) {
            this.f6905a = c2066e;
        }

        public void run() {
            C2046y c = this.f6905a.f6923b;
            if (c == null) {
                this.f6905a.mo1746w().m11290f().m11249a("Failed to send measurementEnabled to service");
                return;
            }
            try {
                c.mo1758b(this.f6905a.mo1736m().m11995a(this.f6905a.mo1746w().m11284F()));
                this.f6905a.m11619D();
            } catch (RemoteException e) {
                this.f6905a.mo1746w().m11290f().m11250a("Failed to send measurementEnabled to AppMeasurementService", e);
            }
        }
    }

    class C20606 implements Runnable {
        final /* synthetic */ C2066e f6911a;

        C20606(C2066e c2066e) {
            this.f6911a = c2066e;
        }

        public void run() {
            C2046y c = this.f6911a.f6923b;
            if (c == null) {
                this.f6911a.mo1746w().m11290f().m11249a("Discarding data. Failed to send app launch");
                return;
            }
            try {
                c.mo1753a(this.f6911a.mo1736m().m11995a(this.f6911a.mo1746w().m11284F()));
                this.f6911a.m11619D();
            } catch (RemoteException e) {
                this.f6911a.mo1746w().m11290f().m11250a("Failed to send app launch to AppMeasurementService", e);
            }
        }
    }

    protected class C2065a implements ServiceConnection, C1265b, C1266c {
        final /* synthetic */ C2066e f6919a;
        private volatile boolean f6920b;
        private volatile aa f6921c;

        class C20644 implements Runnable {
            final /* synthetic */ C2065a f6918a;

            C20644(C2065a c2065a) {
                this.f6918a = c2065a;
            }

            public void run() {
                this.f6918a.f6919a.m11625a(new ComponentName(this.f6918a.f6919a.mo1740q(), "com.google.android.gms.measurement.AppMeasurementService"));
            }
        }

        protected C2065a(C2066e c2066e) {
            this.f6919a = c2066e;
        }

        public void m11614a() {
            this.f6919a.mo1733j();
            Context q = this.f6919a.mo1740q();
            synchronized (this) {
                if (this.f6920b) {
                    this.f6919a.mo1746w().m11283E().m11249a("Connection attempt already in progress");
                } else if (this.f6921c != null) {
                    this.f6919a.mo1746w().m11283E().m11249a("Already awaiting connection attempt");
                } else {
                    this.f6921c = new aa(q, Looper.getMainLooper(), this, this);
                    this.f6919a.mo1746w().m11283E().m11249a("Connecting to remote service");
                    this.f6920b = true;
                    this.f6921c.m6974n();
                }
            }
        }

        public void mo1178a(int i) {
            C1896c.m10797b("MeasurementServiceConnection.onConnectionSuspended");
            this.f6919a.mo1746w().m11282D().m11249a("Service connection suspended");
            this.f6919a.mo1745v().m11424a(new C20644(this));
        }

        public void m11616a(Intent intent) {
            this.f6919a.mo1733j();
            Context q = this.f6919a.mo1740q();
            C1959b a = C1959b.m11039a();
            synchronized (this) {
                if (this.f6920b) {
                    this.f6919a.mo1746w().m11283E().m11249a("Connection attempt already in progress");
                    return;
                }
                this.f6920b = true;
                a.m11052a(q, intent, this.f6919a.f6922a, 129);
            }
        }

        public void mo1179a(Bundle bundle) {
            C1896c.m10797b("MeasurementServiceConnection.onConnected");
            synchronized (this) {
                try {
                    final C2046y c2046y = (C2046y) this.f6921c.m6981u();
                    this.f6921c = null;
                    this.f6919a.mo1745v().m11424a(new Runnable(this) {
                        final /* synthetic */ C2065a f6917b;

                        public void run() {
                            synchronized (this.f6917b) {
                                this.f6917b.f6920b = false;
                                if (!this.f6917b.f6919a.m11639f()) {
                                    this.f6917b.f6919a.mo1746w().m11282D().m11249a("Connected to remote service");
                                    this.f6917b.f6919a.m11628a(c2046y);
                                }
                            }
                        }
                    });
                } catch (DeadObjectException e) {
                    this.f6921c = null;
                    this.f6920b = false;
                } catch (IllegalStateException e2) {
                    this.f6921c = null;
                    this.f6920b = false;
                }
            }
        }

        public void mo1180a(ConnectionResult connectionResult) {
            C1896c.m10797b("MeasurementServiceConnection.onConnectionFailed");
            ab g = this.f6919a.n.m11503g();
            if (g != null) {
                g.m11310z().m11250a("Service connection failed", connectionResult);
            }
            synchronized (this) {
                this.f6920b = false;
                this.f6921c = null;
            }
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            C1896c.m10797b("MeasurementServiceConnection.onServiceConnected");
            synchronized (this) {
                if (iBinder == null) {
                    this.f6920b = false;
                    this.f6919a.mo1746w().m11290f().m11249a("Service connected with null binder");
                    return;
                }
                C2046y c2046y = null;
                try {
                    String interfaceDescriptor = iBinder.getInterfaceDescriptor();
                    if ("com.google.android.gms.measurement.internal.IMeasurementService".equals(interfaceDescriptor)) {
                        c2046y = C2047a.m11532a(iBinder);
                        this.f6919a.mo1746w().m11283E().m11249a("Bound to IMeasurementService interface");
                    } else {
                        this.f6919a.mo1746w().m11290f().m11250a("Got binder with a wrong descriptor", interfaceDescriptor);
                    }
                } catch (RemoteException e) {
                    this.f6919a.mo1746w().m11290f().m11249a("Service connect failed to get IMeasurementService");
                }
                if (c2046y == null) {
                    this.f6920b = false;
                    try {
                        C1959b.m11039a().m11050a(this.f6919a.mo1740q(), this.f6919a.f6922a);
                    } catch (IllegalArgumentException e2) {
                    }
                } else {
                    this.f6919a.mo1745v().m11424a(new Runnable(this) {
                        final /* synthetic */ C2065a f6913b;

                        public void run() {
                            synchronized (this.f6913b) {
                                this.f6913b.f6920b = false;
                                if (!this.f6913b.f6919a.m11639f()) {
                                    this.f6913b.f6919a.mo1746w().m11283E().m11249a("Connected to service");
                                    this.f6913b.f6919a.m11628a(c2046y);
                                }
                            }
                        }
                    });
                }
            }
        }

        public void onServiceDisconnected(final ComponentName componentName) {
            C1896c.m10797b("MeasurementServiceConnection.onServiceDisconnected");
            this.f6919a.mo1746w().m11282D().m11249a("Service disconnected");
            this.f6919a.mo1745v().m11424a(new Runnable(this) {
                final /* synthetic */ C2065a f6915b;

                public void run() {
                    this.f6915b.f6919a.m11625a(componentName);
                }
            });
        }
    }

    protected C2066e(aj ajVar) {
        super(ajVar);
        this.f6926e = new C2078i(ajVar.m11514r());
        this.f6922a = new C2065a(this);
        this.f6925d = new C2054r(this, ajVar) {
            final /* synthetic */ C2066e f6903a;

            public void mo1759a() {
                this.f6903a.m11621F();
            }
        };
        this.f6928g = new C2054r(this, ajVar) {
            final /* synthetic */ C2066e f6904a;

            public void mo1759a() {
                this.f6904a.mo1746w().m11310z().m11249a("Tasks have been queued for a long time");
            }
        };
    }

    private void m11619D() {
        mo1733j();
        this.f6926e.m11706a();
        if (!this.n.m11469C()) {
            this.f6925d.m11608a(mo1748y().m11829K());
        }
    }

    private boolean m11620E() {
        List queryIntentServices = mo1740q().getPackageManager().queryIntentServices(new Intent().setClassName(mo1740q(), "com.google.android.gms.measurement.AppMeasurementService"), 65536);
        return queryIntentServices != null && queryIntentServices.size() > 0;
    }

    private void m11621F() {
        mo1733j();
        if (m11639f()) {
            mo1746w().m11283E().m11249a("Inactivity, disconnecting from AppMeasurementService");
            m11635C();
        }
    }

    private void m11622G() {
        mo1733j();
        m11633A();
    }

    private void m11623H() {
        mo1733j();
        mo1746w().m11283E().m11250a("Processing queued up service tasks", Integer.valueOf(this.f6927f.size()));
        for (Runnable a : this.f6927f) {
            mo1745v().m11424a(a);
        }
        this.f6927f.clear();
        this.f6928g.m11610c();
    }

    private void m11625a(ComponentName componentName) {
        mo1733j();
        if (this.f6923b != null) {
            this.f6923b = null;
            mo1746w().m11283E().m11250a("Disconnected from device MeasurementService", componentName);
            m11622G();
        }
    }

    private void m11628a(C2046y c2046y) {
        mo1733j();
        C1896c.m10790a((Object) c2046y);
        this.f6923b = c2046y;
        m11619D();
        m11623H();
    }

    private void m11629a(Runnable runnable) {
        mo1733j();
        if (m11639f()) {
            runnable.run();
        } else if (((long) this.f6927f.size()) >= mo1748y().m11840V()) {
            mo1746w().m11290f().m11249a("Discarding data. Max runnable queue size reached");
        } else {
            this.f6927f.add(runnable);
            if (!this.n.m11469C()) {
                this.f6928g.m11608a(60000);
            }
            m11633A();
        }
    }

    void m11633A() {
        mo1733j();
        m11273c();
        if (!m11639f()) {
            if (this.f6924c == null) {
                this.f6924c = mo1747x().m11365B();
                if (this.f6924c == null) {
                    mo1746w().m11283E().m11249a("State of service unknown");
                    this.f6924c = Boolean.valueOf(m11634B());
                    mo1747x().m11369a(this.f6924c.booleanValue());
                }
            }
            if (this.f6924c.booleanValue()) {
                mo1746w().m11283E().m11249a("Using measurement service");
                this.f6922a.m11614a();
            } else if (!this.n.m11469C() && m11620E()) {
                mo1746w().m11283E().m11249a("Using local app measurement service");
                Intent intent = new Intent("com.google.android.gms.measurement.START");
                intent.setComponent(new ComponentName(mo1740q(), "com.google.android.gms.measurement.AppMeasurementService"));
                this.f6922a.m11616a(intent);
            } else if (mo1748y().m11834P()) {
                mo1746w().m11283E().m11249a("Using direct local measurement implementation");
                m11628a(new ak(this.n, true));
            } else {
                mo1746w().m11290f().m11249a("Not in main process. Unable to use local measurement implementation. Please register the AppMeasurementService service in the app manifest");
            }
        }
    }

    protected boolean m11634B() {
        mo1733j();
        m11273c();
        if (mo1748y().m11833O()) {
            return true;
        }
        mo1746w().m11283E().m11249a("Checking service availability");
        switch (C1876j.m10605b().mo1643a(mo1740q())) {
            case 0:
                mo1746w().m11283E().m11249a("Service available");
                return true;
            case 1:
                mo1746w().m11283E().m11249a("Service missing");
                return false;
            case 2:
                mo1746w().m11282D().m11249a("Service container out of date");
                return true;
            case 3:
                mo1746w().m11310z().m11249a("Service disabled");
                return false;
            case 9:
                mo1746w().m11310z().m11249a("Service invalid");
                return false;
            case 18:
                mo1746w().m11310z().m11249a("Service updating");
                return true;
            default:
                return false;
        }
    }

    public void m11635C() {
        mo1733j();
        m11273c();
        try {
            C1959b.m11039a().m11050a(mo1740q(), this.f6922a);
        } catch (IllegalStateException e) {
        } catch (IllegalArgumentException e2) {
        }
        this.f6923b = null;
    }

    protected void m11636a(final EventParcel eventParcel, final String str) {
        C1896c.m10790a((Object) eventParcel);
        mo1733j();
        m11273c();
        m11629a(new Runnable(this) {
            final /* synthetic */ C2066e f6908c;

            public void run() {
                C2046y c = this.f6908c.f6923b;
                if (c == null) {
                    this.f6908c.mo1746w().m11290f().m11249a("Discarding data. Failed to send event to service");
                    return;
                }
                try {
                    if (TextUtils.isEmpty(str)) {
                        c.mo1754a(eventParcel, this.f6908c.mo1736m().m11995a(this.f6908c.mo1746w().m11284F()));
                    } else {
                        c.mo1755a(eventParcel, str, this.f6908c.mo1746w().m11284F());
                    }
                    this.f6908c.m11619D();
                } catch (RemoteException e) {
                    this.f6908c.mo1746w().m11290f().m11250a("Failed to send event to AppMeasurementService", e);
                }
            }
        });
    }

    protected void m11637a(final UserAttributeParcel userAttributeParcel) {
        mo1733j();
        m11273c();
        m11629a(new Runnable(this) {
            final /* synthetic */ C2066e f6910b;

            public void run() {
                C2046y c = this.f6910b.f6923b;
                if (c == null) {
                    this.f6910b.mo1746w().m11290f().m11249a("Discarding data. Failed to set user attribute");
                    return;
                }
                try {
                    c.mo1756a(userAttributeParcel, this.f6910b.mo1736m().m11995a(this.f6910b.mo1746w().m11284F()));
                    this.f6910b.m11619D();
                } catch (RemoteException e) {
                    this.f6910b.mo1746w().m11290f().m11250a("Failed to send attribute to AppMeasurementService", e);
                }
            }
        });
    }

    protected void mo1730e() {
    }

    public boolean m11639f() {
        mo1733j();
        m11273c();
        return this.f6923b != null;
    }

    protected void m11640g() {
        mo1733j();
        m11273c();
        m11629a(new C20573(this));
    }

    public /* bridge */ /* synthetic */ void mo1731h() {
        super.mo1731h();
    }

    public /* bridge */ /* synthetic */ void mo1732i() {
        super.mo1732i();
    }

    public /* bridge */ /* synthetic */ void mo1733j() {
        super.mo1733j();
    }

    public /* bridge */ /* synthetic */ C2084o mo1734k() {
        return super.mo1734k();
    }

    public /* bridge */ /* synthetic */ C2053d mo1735l() {
        return super.mo1735l();
    }

    public /* bridge */ /* synthetic */ C2098z mo1736m() {
        return super.mo1736m();
    }

    public /* bridge */ /* synthetic */ C2090s mo1737n() {
        return super.mo1737n();
    }

    public /* bridge */ /* synthetic */ C2066e mo1738o() {
        return super.mo1738o();
    }

    public /* bridge */ /* synthetic */ C1970c mo1739p() {
        return super.mo1739p();
    }

    public /* bridge */ /* synthetic */ Context mo1740q() {
        return super.mo1740q();
    }

    public /* bridge */ /* synthetic */ C2088q mo1741r() {
        return super.mo1741r();
    }

    public /* bridge */ /* synthetic */ C2082m mo1742s() {
        return super.mo1742s();
    }

    public /* bridge */ /* synthetic */ ah mo1743t() {
        return super.mo1743t();
    }

    public /* bridge */ /* synthetic */ C2076g mo1744u() {
        return super.mo1744u();
    }

    public /* bridge */ /* synthetic */ ai mo1745v() {
        return super.mo1745v();
    }

    public /* bridge */ /* synthetic */ ab mo1746w() {
        return super.mo1746w();
    }

    public /* bridge */ /* synthetic */ af mo1747x() {
        return super.mo1747x();
    }

    public /* bridge */ /* synthetic */ C2085p mo1748y() {
        return super.mo1748y();
    }

    protected void m11659z() {
        mo1733j();
        m11273c();
        m11629a(new C20606(this));
    }
}
