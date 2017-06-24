package com.google.android.gms.ads.internal.request;

import android.content.Context;
import android.os.Binder;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Looper;
import com.google.android.gms.ads.internal.C1319u;
import com.google.android.gms.ads.internal.request.C1259c.C1255a;
import com.google.android.gms.ads.internal.util.client.C1324b;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.C1268k.C1265b;
import com.google.android.gms.common.internal.C1268k.C1266c;
import com.google.android.gms.p031b.C1605if;
import com.google.android.gms.p031b.ci;
import com.google.android.gms.p031b.cq;
import com.google.android.gms.p031b.id;
import com.google.android.gms.p031b.ie;
import com.google.android.gms.p031b.kb;
import com.google.android.gms.p031b.kt;
import com.google.android.gms.p031b.kt.C1161c;
import com.google.android.gms.p031b.kt.C1261a;

@id
public abstract class C1263d implements C1255a, kb<Void> {
    private final kt<AdRequestInfoParcel> f3839a;
    private final C1255a f3840b;
    private final Object f3841c = new Object();

    class C12622 implements C1261a {
        final /* synthetic */ C1263d f3838a;

        C12622(C1263d c1263d) {
            this.f3838a = c1263d;
        }

        public void mo1175a() {
            this.f3838a.mo1176a();
        }
    }

    @id
    public static final class C1264a extends C1263d {
        private final Context f3842a;

        public C1264a(Context context, kt<AdRequestInfoParcel> ktVar, C1255a c1255a) {
            super(ktVar, c1255a);
            this.f3842a = context;
        }

        public void mo1176a() {
        }

        public C1277k mo1177b() {
            return C1605if.m8886a(this.f3842a, new ci((String) cq.f4387b.m7801c()), ie.m8876a());
        }

        public /* synthetic */ Object mo1107e() {
            return super.m6923c();
        }
    }

    @id
    public static class C1267b extends C1263d implements C1265b, C1266c {
        protected C1269e f3843a;
        private Context f3844b;
        private VersionInfoParcel f3845c;
        private kt<AdRequestInfoParcel> f3846d;
        private final C1255a f3847e;
        private final Object f3848f = new Object();
        private boolean f3849g;

        public C1267b(Context context, VersionInfoParcel versionInfoParcel, kt<AdRequestInfoParcel> ktVar, C1255a c1255a) {
            Looper a;
            super(ktVar, c1255a);
            this.f3844b = context;
            this.f3845c = versionInfoParcel;
            this.f3846d = ktVar;
            this.f3847e = c1255a;
            if (((Boolean) cq.f4361B.m7801c()).booleanValue()) {
                this.f3849g = true;
                a = C1319u.m7195q().m9342a();
            } else {
                a = context.getMainLooper();
            }
            this.f3843a = new C1269e(context, a, this, this, this.f3845c.f3959d);
            m6938f();
        }

        public void mo1176a() {
            synchronized (this.f3848f) {
                if (this.f3843a.m6966d() || this.f3843a.m6967e()) {
                    this.f3843a.m6965c();
                }
                Binder.flushPendingCommands();
                if (this.f3849g) {
                    C1319u.m7195q().m9343b();
                    this.f3849g = false;
                }
            }
        }

        public void mo1178a(int i) {
            C1324b.m7227a("Disconnected from remote ad request service.");
        }

        public void mo1179a(Bundle bundle) {
            Void voidR = (Void) mo1107e();
        }

        public void mo1180a(ConnectionResult connectionResult) {
            C1324b.m7227a("Cannot connect to remote service, fallback to local instance.");
            m6939g().mo1107e();
            Bundle bundle = new Bundle();
            bundle.putString("action", "gms_connection_failed_fallback_to_local");
            C1319u.m7183e().m9235b(this.f3844b, this.f3845c.f3957b, "gmob-apps", bundle, true);
        }

        public C1277k mo1177b() {
            C1277k b_;
            synchronized (this.f3848f) {
                try {
                    b_ = this.f3843a.b_();
                } catch (IllegalStateException e) {
                    b_ = null;
                    return b_;
                } catch (DeadObjectException e2) {
                    b_ = null;
                    return b_;
                }
            }
            return b_;
        }

        public /* synthetic */ Object mo1107e() {
            return super.m6923c();
        }

        protected void m6938f() {
            this.f3843a.m6974n();
        }

        kb m6939g() {
            return new C1264a(this.f3844b, this.f3846d, this.f3847e);
        }
    }

    public C1263d(kt<AdRequestInfoParcel> ktVar, C1255a c1255a) {
        this.f3839a = ktVar;
        this.f3840b = c1255a;
    }

    public abstract void mo1176a();

    public void mo1173a(AdResponseParcel adResponseParcel) {
        synchronized (this.f3841c) {
            this.f3840b.mo1173a(adResponseParcel);
            mo1176a();
        }
    }

    boolean m6921a(C1277k c1277k, AdRequestInfoParcel adRequestInfoParcel) {
        try {
            c1277k.mo1186a(adRequestInfoParcel, new C1273g(this));
            return true;
        } catch (Throwable e) {
            C1324b.m7235d("Could not fetch ad response from ad request service.", e);
            C1319u.m7186h().m9117a(e, true);
        } catch (Throwable e2) {
            C1324b.m7235d("Could not fetch ad response from ad request service due to an Exception.", e2);
            C1319u.m7186h().m9117a(e2, true);
        } catch (Throwable e22) {
            C1324b.m7235d("Could not fetch ad response from ad request service due to an Exception.", e22);
            C1319u.m7186h().m9117a(e22, true);
        } catch (Throwable e222) {
            C1324b.m7235d("Could not fetch ad response from ad request service due to an Exception.", e222);
            C1319u.m7186h().m9117a(e222, true);
        }
        this.f3840b.mo1173a(new AdResponseParcel(0));
        return false;
    }

    public abstract C1277k mo1177b();

    public Void m6923c() {
        final C1277k b = mo1177b();
        if (b == null) {
            this.f3840b.mo1173a(new AdResponseParcel(0));
            mo1176a();
        } else {
            this.f3839a.mo1327a(new C1161c<AdRequestInfoParcel>(this) {
                final /* synthetic */ C1263d f3837b;

                public void m6915a(AdRequestInfoParcel adRequestInfoParcel) {
                    if (!this.f3837b.m6921a(b, adRequestInfoParcel)) {
                        this.f3837b.mo1176a();
                    }
                }

                public /* synthetic */ void mo1101a(Object obj) {
                    m6915a((AdRequestInfoParcel) obj);
                }
            }, new C12622(this));
        }
        return null;
    }

    public void mo1106d() {
        mo1176a();
    }

    public /* synthetic */ Object mo1107e() {
        return m6923c();
    }
}
