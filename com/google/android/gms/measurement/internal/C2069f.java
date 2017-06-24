package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import com.google.android.gms.common.internal.C1896c;
import com.google.android.gms.p031b.oc;

public final class C2069f {
    private static Boolean f6934d;
    private final Handler f6935a = new Handler();
    private final Context f6936b;
    private final C2014a f6937c;

    public interface C2014a {
        Context mo1728a();

        boolean mo1729a(int i);
    }

    public C2069f(C2014a c2014a) {
        this.f6936b = c2014a.mo1728a();
        C1896c.m10790a(this.f6936b);
        this.f6937c = c2014a;
    }

    public static boolean m11661a(Context context) {
        C1896c.m10790a((Object) context);
        if (f6934d != null) {
            return f6934d.booleanValue();
        }
        boolean a = C2082m.m11748a(context, "com.google.android.gms.measurement.AppMeasurementService");
        f6934d = Boolean.valueOf(a);
        return a;
    }

    private void m11663c() {
        try {
            synchronized (ag.f6788a) {
                oc ocVar = ag.f6789b;
                if (ocVar != null && ocVar.m10353b()) {
                    ocVar.m10349a();
                }
            }
        } catch (SecurityException e) {
        }
    }

    private ab m11664d() {
        return aj.m11458a(this.f6936b).m11502f();
    }

    public int m11665a(Intent intent, int i, final int i2) {
        m11663c();
        final aj a = aj.m11458a(this.f6936b);
        final ab f = a.m11502f();
        if (intent == null) {
            f.m11310z().m11249a("AppMeasurementService started with null intent");
        } else {
            String action = intent.getAction();
            if (a.m11499d().m11833O()) {
                f.m11283E().m11251a("Device AppMeasurementService called. startId, action", Integer.valueOf(i2), action);
            } else {
                f.m11283E().m11251a("Local AppMeasurementService called. startId, action", Integer.valueOf(i2), action);
            }
            if ("com.google.android.gms.measurement.UPLOAD".equals(action)) {
                a.m11504h().m11424a(new Runnable(this) {
                    final /* synthetic */ C2069f f6933d;

                    class C20671 implements Runnable {
                        final /* synthetic */ C20681 f6929a;

                        C20671(C20681 c20681) {
                            this.f6929a = c20681;
                        }

                        public void run() {
                            if (!this.f6929a.f6933d.f6937c.mo1729a(i2)) {
                                return;
                            }
                            if (a.m11499d().m11833O()) {
                                f.m11283E().m11249a("Device AppMeasurementService processed last upload request");
                            } else {
                                f.m11283E().m11249a("Local AppMeasurementService processed last upload request");
                            }
                        }
                    }

                    public void run() {
                        a.m11476J();
                        a.m11474H();
                        this.f6933d.f6935a.post(new C20671(this));
                    }
                });
            }
        }
        return 2;
    }

    public IBinder m11666a(Intent intent) {
        if (intent == null) {
            m11664d().m11290f().m11249a("onBind called with null intent");
            return null;
        }
        String action = intent.getAction();
        if ("com.google.android.gms.measurement.START".equals(action)) {
            return new ak(aj.m11458a(this.f6936b));
        }
        m11664d().m11310z().m11250a("onBind received unknown action", action);
        return null;
    }

    public void m11667a() {
        aj a = aj.m11458a(this.f6936b);
        ab f = a.m11502f();
        if (a.m11499d().m11833O()) {
            f.m11283E().m11249a("Device AppMeasurementService is starting up");
        } else {
            f.m11283E().m11249a("Local AppMeasurementService is starting up");
        }
    }

    public void m11668b() {
        aj a = aj.m11458a(this.f6936b);
        ab f = a.m11502f();
        if (a.m11499d().m11833O()) {
            f.m11283E().m11249a("Device AppMeasurementService is shutting down");
        } else {
            f.m11283E().m11249a("Local AppMeasurementService is shutting down");
        }
    }

    public boolean m11669b(Intent intent) {
        if (intent == null) {
            m11664d().m11290f().m11249a("onUnbind called with null intent");
        } else {
            m11664d().m11283E().m11250a("onUnbind called for intent. action", intent.getAction());
        }
        return true;
    }

    public void m11670c(Intent intent) {
        if (intent == null) {
            m11664d().m11290f().m11249a("onRebind called with null intent");
            return;
        }
        m11664d().m11283E().m11250a("onRebind called. action", intent.getAction());
    }
}
