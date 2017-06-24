package com.google.ads.mediation;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.C0970a;
import com.google.android.gms.ads.C1020b;
import com.google.android.gms.ads.C1020b.C1011a;
import com.google.android.gms.ads.C1026c;
import com.google.android.gms.ads.C1026c.C1022a;
import com.google.android.gms.ads.C1029d;
import com.google.android.gms.ads.C1032e;
import com.google.android.gms.ads.C1034h;
import com.google.android.gms.ads.internal.client.C0971a;
import com.google.android.gms.ads.internal.client.C1120y;
import com.google.android.gms.ads.internal.util.client.C1324b;
import com.google.android.gms.ads.mediation.C0957b.C1332a;
import com.google.android.gms.ads.mediation.C0959c;
import com.google.android.gms.ads.mediation.C0960g;
import com.google.android.gms.ads.mediation.C0966j;
import com.google.android.gms.ads.mediation.C0968k;
import com.google.android.gms.ads.mediation.C1331a;
import com.google.android.gms.ads.mediation.C1344d;
import com.google.android.gms.ads.mediation.C1345f;
import com.google.android.gms.ads.mediation.C1346h;
import com.google.android.gms.ads.mediation.C1347l;
import com.google.android.gms.ads.p029d.C0963b;
import com.google.android.gms.ads.p029d.C1028a;
import com.google.android.gms.ads.p029d.p030a.C0958a;
import com.google.android.gms.ads.p029d.p030a.C1027b;
import com.google.android.gms.ads.p032b.C1016b;
import com.google.android.gms.ads.p032b.C1017c;
import com.google.android.gms.ads.p032b.C1018d;
import com.google.android.gms.ads.p032b.C1018d.C0974a;
import com.google.android.gms.ads.p032b.C1019e;
import com.google.android.gms.ads.p032b.C1019e.C0975a;
import com.google.android.gms.p031b.id;
import com.google.android.gms.p031b.lm;
import java.util.Date;
import java.util.Set;

@id
public abstract class C0962a implements C0958a, C0959c, C0960g, lm {
    public static final String AD_UNIT_ID_PARAMETER = "pubid";
    protected C1032e zzfb;
    protected C1034h zzfc;
    private C1020b zzfd;
    private Context zzfe;
    private C1034h zzff;
    private C1027b zzfg;
    final C0963b zzfh = new C09641(this);

    class C09641 implements C0963b {
        final /* synthetic */ C0962a f2935a;

        C09641(C0962a c0962a) {
            this.f2935a = c0962a;
        }

        public void mo902a() {
            this.f2935a.zzfg.mo1224b(this.f2935a);
        }

        public void mo903a(int i) {
            this.f2935a.zzfg.mo1222a(this.f2935a, i);
        }

        public void mo904a(C1028a c1028a) {
            this.f2935a.zzfg.mo1223a(this.f2935a, c1028a);
        }

        public void mo905b() {
            this.f2935a.zzfg.mo1225c(this.f2935a);
        }

        public void mo906c() {
            this.f2935a.zzfg.mo1226d(this.f2935a);
        }

        public void mo907d() {
            this.f2935a.zzfg.mo1227e(this.f2935a);
            this.f2935a.zzff = null;
        }

        public void mo908e() {
            this.f2935a.zzfg.mo1228f(this.f2935a);
        }
    }

    static class C0967a extends C0966j {
        private final C1018d f2947d;

        public C0967a(C1018d c1018d) {
            this.f2947d = c1018d;
            m5628a(c1018d.mo1286b().toString());
            m5629a(c1018d.mo1287c());
            m5630b(c1018d.mo1288d().toString());
            m5627a(c1018d.mo1289e());
            m5631c(c1018d.mo1290f().toString());
            if (c1018d.mo1291g() != null) {
                m5626a(c1018d.mo1291g().doubleValue());
            }
            if (c1018d.mo1292h() != null) {
                m5632d(c1018d.mo1292h().toString());
            }
            if (c1018d.mo1293i() != null) {
                m5634e(c1018d.mo1293i().toString());
            }
            m5618a(true);
            m5621b(true);
        }

        public void mo909a(View view) {
            if (view instanceof C1017c) {
                ((C1017c) view).setNativeAd(this.f2947d);
            }
        }
    }

    static class C0969b extends C0968k {
        private final C1019e f2954d;

        public C0969b(C1019e c1019e) {
            this.f2954d = c1019e;
            m5644a(c1019e.mo1294b().toString());
            m5645a(c1019e.mo1295c());
            m5646b(c1019e.mo1296d().toString());
            if (c1019e.mo1297e() != null) {
                m5643a(c1019e.mo1297e());
            }
            m5647c(c1019e.mo1298f().toString());
            m5648d(c1019e.mo1299g().toString());
            m5618a(true);
            m5621b(true);
        }

        public void mo909a(View view) {
            if (view instanceof C1017c) {
                ((C1017c) view).setNativeAd(this.f2954d);
            }
        }
    }

    static final class C0972c extends C0970a implements C0971a {
        final C0962a f2955a;
        final C1344d f2956b;

        public C0972c(C0962a c0962a, C1344d c1344d) {
            this.f2955a = c0962a;
            this.f2956b = c1344d;
        }

        public void mo910a() {
            this.f2956b.mo1405a(this.f2955a);
        }

        public void mo911a(int i) {
            this.f2956b.mo1406a(this.f2955a, i);
        }

        public void mo912b() {
            this.f2956b.mo1412b(this.f2955a);
        }

        public void mo913c() {
            this.f2956b.mo1415c(this.f2955a);
        }

        public void mo914d() {
            this.f2956b.mo1418d(this.f2955a);
        }

        public void mo915e() {
            this.f2956b.mo1421e(this.f2955a);
        }
    }

    static final class C0973d extends C0970a implements C0971a {
        final C0962a f2957a;
        final C1345f f2958b;

        public C0973d(C0962a c0962a, C1345f c1345f) {
            this.f2957a = c0962a;
            this.f2958b = c1345f;
        }

        public void mo910a() {
            this.f2958b.mo1407a(this.f2957a);
        }

        public void mo911a(int i) {
            this.f2958b.mo1408a(this.f2957a, i);
        }

        public void mo912b() {
            this.f2958b.mo1413b(this.f2957a);
        }

        public void mo913c() {
            this.f2958b.mo1416c(this.f2957a);
        }

        public void mo914d() {
            this.f2958b.mo1419d(this.f2957a);
        }

        public void mo915e() {
            this.f2958b.mo1422e(this.f2957a);
        }
    }

    static final class C0976e extends C0970a implements C0974a, C0975a, C0971a {
        final C0962a f2959a;
        final C1346h f2960b;

        public C0976e(C0962a c0962a, C1346h c1346h) {
            this.f2959a = c0962a;
            this.f2960b = c1346h;
        }

        public void mo910a() {
        }

        public void mo911a(int i) {
            this.f2960b.mo1410a(this.f2959a, i);
        }

        public void mo916a(C1018d c1018d) {
            this.f2960b.mo1411a(this.f2959a, new C0967a(c1018d));
        }

        public void mo917a(C1019e c1019e) {
            this.f2960b.mo1411a(this.f2959a, new C0969b(c1019e));
        }

        public void mo912b() {
            this.f2960b.mo1409a(this.f2959a);
        }

        public void mo913c() {
            this.f2960b.mo1414b(this.f2959a);
        }

        public void mo914d() {
            this.f2960b.mo1417c(this.f2959a);
        }

        public void mo915e() {
            this.f2960b.mo1420d(this.f2959a);
        }
    }

    public String getAdUnitId(Bundle bundle) {
        return bundle.getString(AD_UNIT_ID_PARAMETER);
    }

    public View getBannerView() {
        return this.zzfb;
    }

    public Bundle getInterstitialAdapterInfo() {
        return new C1332a().m7266a(1).m7265a();
    }

    public void initialize(Context context, C1331a c1331a, String str, C1027b c1027b, Bundle bundle, Bundle bundle2) {
        this.zzfe = context.getApplicationContext();
        this.zzfg = c1027b;
        this.zzfg.mo1221a(this);
    }

    public boolean isInitialized() {
        return this.zzfg != null;
    }

    public void loadAd(C1331a c1331a, Bundle bundle, Bundle bundle2) {
        if (this.zzfe == null || this.zzfg == null) {
            C1324b.m7230b("AdMobAdapter.loadAd called before initialize.");
            return;
        }
        this.zzff = new C1034h(this.zzfe);
        this.zzff.m5830a(true);
        this.zzff.m5829a(getAdUnitId(bundle));
        this.zzff.m5828a(this.zzfh);
        this.zzff.m5827a(zza(this.zzfe, c1331a, bundle2, bundle));
    }

    public void onDestroy() {
        if (this.zzfb != null) {
            this.zzfb.mo928c();
            this.zzfb = null;
        }
        if (this.zzfc != null) {
            this.zzfc = null;
        }
        if (this.zzfd != null) {
            this.zzfd = null;
        }
        if (this.zzff != null) {
            this.zzff = null;
        }
    }

    public void onPause() {
        if (this.zzfb != null) {
            this.zzfb.mo927b();
        }
    }

    public void onResume() {
        if (this.zzfb != null) {
            this.zzfb.mo925a();
        }
    }

    public void requestBannerAd(Context context, C1344d c1344d, Bundle bundle, C1029d c1029d, C1331a c1331a, Bundle bundle2) {
        this.zzfb = new C1032e(context);
        this.zzfb.setAdSize(new C1029d(c1029d.m5803b(), c1029d.m5801a()));
        this.zzfb.setAdUnitId(getAdUnitId(bundle));
        this.zzfb.setAdListener(new C0972c(this, c1344d));
        this.zzfb.mo926a(zza(context, c1331a, bundle2, bundle));
    }

    public void requestInterstitialAd(Context context, C1345f c1345f, Bundle bundle, C1331a c1331a, Bundle bundle2) {
        this.zzfc = new C1034h(context);
        this.zzfc.m5829a(getAdUnitId(bundle));
        this.zzfc.m5826a(new C0973d(this, c1345f));
        this.zzfc.m5827a(zza(context, c1331a, bundle2, bundle));
    }

    public void requestNativeAd(Context context, C1346h c1346h, Bundle bundle, C1347l c1347l, Bundle bundle2) {
        C0975a c0976e = new C0976e(this, c1346h);
        C1011a a = zza(context, bundle.getString(AD_UNIT_ID_PARAMETER)).m5729a((C0970a) c0976e);
        C1016b h = c1347l.mo1423h();
        if (h != null) {
            a.m5730a(h);
        }
        if (c1347l.mo1424i()) {
            a.m5731a((C0974a) c0976e);
        }
        if (c1347l.mo1425j()) {
            a.m5732a(c0976e);
        }
        this.zzfd = a.m5733a();
        this.zzfd.m5765a(zza(context, c1347l, bundle2, bundle));
    }

    public void showInterstitial() {
        this.zzfc.m5825a();
    }

    public void showVideo() {
        this.zzff.m5825a();
    }

    protected abstract Bundle zza(Bundle bundle, Bundle bundle2);

    C1011a zza(Context context, String str) {
        return new C1011a(context, str);
    }

    C1026c zza(Context context, C1331a c1331a, Bundle bundle, Bundle bundle2) {
        C1022a c1022a = new C1022a();
        Date a = c1331a.mo1398a();
        if (a != null) {
            c1022a.m5771a(a);
        }
        int b = c1331a.mo1399b();
        if (b != 0) {
            c1022a.m5767a(b);
        }
        Set<String> c = c1331a.mo1400c();
        if (c != null) {
            for (String a2 : c) {
                c1022a.m5770a(a2);
            }
        }
        Location d = c1331a.mo1401d();
        if (d != null) {
            c1022a.m5768a(d);
        }
        if (c1331a.mo1403f()) {
            c1022a.m5774b(C1120y.m6293a().m7210a(context));
        }
        if (c1331a.mo1402e() != -1) {
            c1022a.m5772a(c1331a.mo1402e() == 1);
        }
        c1022a.m5775b(c1331a.mo1404g());
        c1022a.m5769a(AdMobAdapter.class, zza(bundle, bundle2));
        return c1022a.m5773a();
    }
}
