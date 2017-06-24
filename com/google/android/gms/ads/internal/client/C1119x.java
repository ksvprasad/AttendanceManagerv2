package com.google.android.gms.ads.internal.client;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import com.google.android.gms.ads.internal.client.aj.C1037a;
import com.google.android.gms.ads.internal.reward.client.C1305f;
import com.google.android.gms.ads.internal.util.client.C1324b;
import com.google.android.gms.common.internal.C1914l;
import com.google.android.gms.p031b.dt;
import com.google.android.gms.p031b.fx;
import com.google.android.gms.p031b.gw;
import com.google.android.gms.p031b.gx;
import com.google.android.gms.p031b.he;
import com.google.android.gms.p031b.hj;
import com.google.android.gms.p031b.id;
import com.google.android.gms.p033a.C1001b;

@id
public class C1119x {
    private aj f3268a;
    private final Object f3269b = new Object();
    private final C1105q f3270c;
    private final C1104p f3271d;
    private final C1092h f3272e;
    private final dt f3273f;
    private final C1305f f3274g;
    private final hj f3275h;
    private final gw f3276i;

    private abstract class C1112a<T> {
        final /* synthetic */ C1119x f3245f;

        private C1112a(C1119x c1119x) {
            this.f3245f = c1119x;
        }

        protected abstract T mo1044b();

        protected abstract T mo1045b(aj ajVar);

        protected final T m6251c() {
            T t = null;
            aj a = this.f3245f.m6282b();
            if (a == null) {
                C1324b.m7234d("ClientApi class cannot be loaded.");
            } else {
                try {
                    t = mo1045b(a);
                } catch (Throwable e) {
                    C1324b.m7235d("Cannot invoke local loader using ClientApi class", e);
                }
            }
            return t;
        }
    }

    public C1119x(C1105q c1105q, C1104p c1104p, C1092h c1092h, dt dtVar, C1305f c1305f, hj hjVar, gw gwVar) {
        this.f3270c = c1105q;
        this.f3271d = c1104p;
        this.f3272e = c1092h;
        this.f3273f = dtVar;
        this.f3274g = c1305f;
        this.f3275h = hjVar;
        this.f3276i = gwVar;
    }

    private static aj m6276a() {
        try {
            Object newInstance = C1119x.class.getClassLoader().loadClass("com.google.android.gms.ads.internal.ClientApi").newInstance();
            if (newInstance instanceof IBinder) {
                return C1037a.asInterface((IBinder) newInstance);
            }
            C1324b.m7234d("ClientApi class is not an instance of IBinder");
            return null;
        } catch (Throwable e) {
            C1324b.m7235d("Failed to instantiate ClientApi class.", e);
            return null;
        }
    }

    private <T> T m6278a(Context context, boolean z, C1112a<T> c1112a) {
        if (!(z || C1120y.m6293a().m7223b(context))) {
            C1324b.m7227a("Google Play Services is not available");
            z = true;
        }
        T c;
        if (z) {
            c = c1112a.m6251c();
            return c == null ? c1112a.mo1044b() : c;
        } else {
            c = c1112a.mo1044b();
            return c == null ? c1112a.m6251c() : c;
        }
    }

    private void m6279a(Context context, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("action", "no_ads_fallback");
        bundle.putString("flow", str);
        C1120y.m6293a().m7214a(context, null, "gmob-apps", bundle, true);
    }

    private static boolean m6281a(Activity activity, String str) {
        Intent intent = activity.getIntent();
        if (intent.hasExtra(str)) {
            return intent.getBooleanExtra(str, false);
        }
        C1324b.m7230b("useClientJar flag not found in activity intent extras.");
        return false;
    }

    private aj m6282b() {
        aj ajVar;
        synchronized (this.f3269b) {
            if (this.f3268a == null) {
                this.f3268a = C1119x.m6276a();
            }
            ajVar = this.f3268a;
        }
        return ajVar;
    }

    public ae m6287a(final Context context, final String str, final fx fxVar) {
        return (ae) m6278a(context, false, new C1112a<ae>(this) {
            final /* synthetic */ C1119x f3263d;

            public ae m6264a() {
                ae a = this.f3263d.f3271d.m6228a(context, str, fxVar);
                if (a != null) {
                    return a;
                }
                this.f3263d.m6279a(context, "native_ad");
                return new C1096i();
            }

            public ae m6265a(aj ajVar) {
                return ajVar.createAdLoaderBuilder(C1001b.m5713a(context), str, fxVar, C1914l.f6455a);
            }

            public /* synthetic */ Object mo1044b() {
                return m6264a();
            }

            public /* synthetic */ Object mo1045b(aj ajVar) {
                return m6265a(ajVar);
            }
        });
    }

    public ag m6288a(final Context context, final AdSizeParcel adSizeParcel, final String str) {
        return (ag) m6278a(context, false, new C1112a<ag>(this) {
            final /* synthetic */ C1119x f3254d;

            public ag m6256a() {
                ag a = this.f3254d.f3270c.m6231a(context, adSizeParcel, str, null, 3);
                if (a != null) {
                    return a;
                }
                this.f3254d.m6279a(context, "search");
                return new C1098j();
            }

            public ag m6257a(aj ajVar) {
                return ajVar.createSearchAdManager(C1001b.m5713a(context), adSizeParcel, str, C1914l.f6455a);
            }

            public /* synthetic */ Object mo1044b() {
                return m6256a();
            }

            public /* synthetic */ Object mo1045b(aj ajVar) {
                return m6257a(ajVar);
            }
        });
    }

    public ag m6289a(Context context, AdSizeParcel adSizeParcel, String str, fx fxVar) {
        final Context context2 = context;
        final AdSizeParcel adSizeParcel2 = adSizeParcel;
        final String str2 = str;
        final fx fxVar2 = fxVar;
        return (ag) m6278a(context, false, new C1112a<ag>(this) {
            final /* synthetic */ C1119x f3250e;

            public ag m6252a() {
                ag a = this.f3250e.f3270c.m6231a(context2, adSizeParcel2, str2, fxVar2, 1);
                if (a != null) {
                    return a;
                }
                this.f3250e.m6279a(context2, "banner");
                return new C1098j();
            }

            public ag m6253a(aj ajVar) {
                return ajVar.createBannerAdManager(C1001b.m5713a(context2), adSizeParcel2, str2, fxVar2, C1914l.f6455a);
            }

            public /* synthetic */ Object mo1044b() {
                return m6252a();
            }

            public /* synthetic */ Object mo1045b(aj ajVar) {
                return m6253a(ajVar);
            }
        });
    }

    public he m6290a(final Activity activity) {
        return (he) m6278a((Context) activity, C1119x.m6281a(activity, "com.google.android.gms.ads.internal.purchase.useClientJar"), new C1112a<he>(this) {
            final /* synthetic */ C1119x f3265b;

            public he m6268a() {
                he a = this.f3265b.f3275h.m8729a(activity);
                if (a != null) {
                    return a;
                }
                this.f3265b.m6279a(activity, "iap");
                return null;
            }

            public he m6269a(aj ajVar) {
                return ajVar.createInAppPurchaseManager(C1001b.m5713a(activity));
            }

            public /* synthetic */ Object mo1044b() {
                return m6268a();
            }

            public /* synthetic */ Object mo1045b(aj ajVar) {
                return m6269a(ajVar);
            }
        });
    }

    public ag m6291b(Context context, AdSizeParcel adSizeParcel, String str, fx fxVar) {
        final Context context2 = context;
        final AdSizeParcel adSizeParcel2 = adSizeParcel;
        final String str2 = str;
        final fx fxVar2 = fxVar;
        return (ag) m6278a(context, false, new C1112a<ag>(this) {
            final /* synthetic */ C1119x f3259e;

            public ag m6260a() {
                ag a = this.f3259e.f3270c.m6231a(context2, adSizeParcel2, str2, fxVar2, 2);
                if (a != null) {
                    return a;
                }
                this.f3259e.m6279a(context2, "interstitial");
                return new C1098j();
            }

            public ag m6261a(aj ajVar) {
                return ajVar.createInterstitialAdManager(C1001b.m5713a(context2), adSizeParcel2, str2, fxVar2, C1914l.f6455a);
            }

            public /* synthetic */ Object mo1044b() {
                return m6260a();
            }

            public /* synthetic */ Object mo1045b(aj ajVar) {
                return m6261a(ajVar);
            }
        });
    }

    public gx m6292b(final Activity activity) {
        return (gx) m6278a((Context) activity, C1119x.m6281a(activity, "com.google.android.gms.ads.internal.overlay.useClientJar"), new C1112a<gx>(this) {
            final /* synthetic */ C1119x f3267b;

            public gx m6272a() {
                gx a = this.f3267b.f3276i.m8684a(activity);
                if (a != null) {
                    return a;
                }
                this.f3267b.m6279a(activity, "ad_overlay");
                return null;
            }

            public gx m6273a(aj ajVar) {
                return ajVar.createAdOverlay(C1001b.m5713a(activity));
            }

            public /* synthetic */ Object mo1044b() {
                return m6272a();
            }

            public /* synthetic */ Object mo1045b(aj ajVar) {
                return m6273a(ajVar);
            }
        });
    }
}
