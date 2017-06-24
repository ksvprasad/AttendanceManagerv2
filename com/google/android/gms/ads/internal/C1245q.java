package com.google.android.gms.ads.internal;

import android.content.Context;
import android.support.v4.p015g.C0369j;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.formats.C1137d;
import com.google.android.gms.ads.internal.formats.C1139e;
import com.google.android.gms.ads.internal.formats.C1141f;
import com.google.android.gms.ads.internal.formats.C1142h;
import com.google.android.gms.ads.internal.formats.C1142h.C1136a;
import com.google.android.gms.ads.internal.formats.C1144g;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.internal.util.client.C1324b;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.internal.C1896c;
import com.google.android.gms.p031b.cy;
import com.google.android.gms.p031b.dc;
import com.google.android.gms.p031b.dp;
import com.google.android.gms.p031b.dq;
import com.google.android.gms.p031b.dr;
import com.google.android.gms.p031b.ds;
import com.google.android.gms.p031b.fx;
import com.google.android.gms.p031b.gb;
import com.google.android.gms.p031b.gc;
import com.google.android.gms.p031b.hd;
import com.google.android.gms.p031b.id;
import com.google.android.gms.p031b.jl;
import com.google.android.gms.p031b.jl.C1632a;
import com.google.android.gms.p031b.jz;
import java.util.List;

@id
public class C1245q extends C1050b {
    public C1245q(Context context, C1122d c1122d, AdSizeParcel adSizeParcel, String str, fx fxVar, VersionInfoParcel versionInfoParcel) {
        super(context, adSizeParcel, str, fxVar, versionInfoParcel, c1122d);
    }

    private static C1137d m6859a(gb gbVar) {
        return new C1137d(gbVar.mo1370a(), gbVar.mo1372b(), gbVar.mo1374c(), gbVar.mo1376d() != null ? gbVar.mo1376d() : null, gbVar.mo1377e(), gbVar.mo1378f(), gbVar.mo1379g(), gbVar.mo1380h(), null, gbVar.mo1384l());
    }

    private static C1139e m6860a(gc gcVar) {
        return new C1139e(gcVar.mo1385a(), gcVar.mo1387b(), gcVar.mo1389c(), gcVar.mo1391d() != null ? gcVar.mo1391d() : null, gcVar.mo1392e(), gcVar.mo1393f(), null, gcVar.mo1397j());
    }

    private void m6861a(final C1137d c1137d) {
        jz.f5567a.post(new Runnable(this) {
            final /* synthetic */ C1245q f3671b;

            public void run() {
                try {
                    if (this.f3671b.f.f4006s != null) {
                        this.f3671b.f.f4006s.mo1303a(c1137d);
                    }
                } catch (Throwable e) {
                    C1324b.m7235d("Could not call OnAppInstallAdLoadedListener.onAppInstallAdLoaded().", e);
                }
            }
        });
    }

    private void m6862a(final C1139e c1139e) {
        jz.f5567a.post(new Runnable(this) {
            final /* synthetic */ C1245q f3673b;

            public void run() {
                try {
                    if (this.f3673b.f.f4007t != null) {
                        this.f3673b.f.f4007t.mo1304a(c1139e);
                    }
                } catch (Throwable e) {
                    C1324b.m7235d("Could not call OnContentAdLoadedListener.onContentAdLoaded().", e);
                }
            }
        });
    }

    private void m6863a(final jl jlVar, final String str) {
        jz.f5567a.post(new Runnable(this) {
            final /* synthetic */ C1245q f3676c;

            public void run() {
                try {
                    ((ds) this.f3676c.f.f4009v.get(str)).mo1306a((C1141f) jlVar.f5419D);
                } catch (Throwable e) {
                    C1324b.m7235d("Could not call onCustomTemplateAdLoadedListener.onCustomTemplateAdLoaded().", e);
                }
            }
        });
    }

    public C0369j<String, ds> m6864D() {
        C1896c.m10797b("getOnCustomTemplateAdLoadedListeners must be called on the main UI thread.");
        return this.f.f4009v;
    }

    public void m6865a(C0369j<String, ds> c0369j) {
        C1896c.m10797b("setOnCustomTemplateAdLoadedListeners must be called on the main UI thread.");
        this.f.f4009v = c0369j;
    }

    public void m6866a(NativeAdOptionsParcel nativeAdOptionsParcel) {
        C1896c.m10797b("setNativeAdOptions must be called on the main UI thread.");
        this.f.f4010w = nativeAdOptionsParcel;
    }

    public void m6867a(C1142h c1142h) {
        if (this.f.f3997j.f5432j != null) {
            C1319u.m7186h().m9135n().m7658a(this.f.f3996i, this.f.f3997j, c1142h);
        }
    }

    public void mo956a(dc dcVar) {
        throw new IllegalStateException("CustomRendering is NOT supported by NativeAdManager.");
    }

    public void m6869a(dp dpVar) {
        C1896c.m10797b("setOnAppInstallAdLoadedListener must be called on the main UI thread.");
        this.f.f4006s = dpVar;
    }

    public void m6870a(dq dqVar) {
        C1896c.m10797b("setOnContentAdLoadedListener must be called on the main UI thread.");
        this.f.f4007t = dqVar;
    }

    public void mo957a(hd hdVar) {
        throw new IllegalStateException("In App Purchase is NOT supported by NativeAdManager.");
    }

    public void mo1002a(final C1632a c1632a, cy cyVar) {
        if (c1632a.f5411d != null) {
            this.f.f3996i = c1632a.f5411d;
        }
        if (c1632a.f5412e != -2) {
            jz.f5567a.post(new Runnable(this) {
                final /* synthetic */ C1245q f3669b;

                public void run() {
                    this.f3669b.mo966b(new jl(c1632a, null, null, null, null, null, null, null));
                }
            });
            return;
        }
        this.f.f3978E = 0;
        this.f.f3995h = C1319u.m7182d().m8766a(this.f.f3990c, this, c1632a, this.f.f3991d, null, this.j, this, cyVar);
        String str = "AdRenderer: ";
        String valueOf = String.valueOf(this.f.f3995h.getClass().getName());
        C1324b.m7227a(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
    }

    public void m6873a(List<String> list) {
        C1896c.m10797b("setNativeTemplates must be called on the main UI thread.");
        this.f.f3974A = list;
    }

    protected boolean mo1112a(AdRequestParcel adRequestParcel, jl jlVar, boolean z) {
        return this.e.m6889d();
    }

    protected boolean mo982a(jl jlVar, jl jlVar2) {
        gc gcVar = null;
        m6873a(null);
        if (this.f.m7250e()) {
            if (jlVar2.f5436n) {
                try {
                    gb h = jlVar2.f5438p != null ? jlVar2.f5438p.mo1365h() : null;
                    if (jlVar2.f5438p != null) {
                        gcVar = jlVar2.f5438p.mo1366i();
                    }
                    if (h == null || this.f.f4006s == null) {
                        if (gcVar != null) {
                            if (this.f.f4007t != null) {
                                C1139e a = C1245q.m6860a(gcVar);
                                a.mo1055a(new C1144g(this.f.f3990c, this, this.f.f3991d, gcVar));
                                m6862a(a);
                            }
                        }
                        C1324b.m7234d("No matching mapper/listener for retrieved native ad template.");
                        m5868a(0);
                        return false;
                    }
                    C1137d a2 = C1245q.m6859a(h);
                    a2.mo1055a(new C1144g(this.f.f3990c, this, this.f.f3991d, h));
                    m6861a(a2);
                } catch (Throwable e) {
                    C1324b.m7235d("Failed to get native ad mapper", e);
                }
            } else {
                C1136a c1136a = jlVar2.f5419D;
                if ((c1136a instanceof C1139e) && this.f.f4007t != null) {
                    m6862a((C1139e) jlVar2.f5419D);
                } else if ((c1136a instanceof C1137d) && this.f.f4006s != null) {
                    m6861a((C1137d) jlVar2.f5419D);
                } else if (!(c1136a instanceof C1141f) || this.f.f4009v == null || this.f.f4009v.get(((C1141f) c1136a).mo1065k()) == null) {
                    C1324b.m7234d("No matching listener for retrieved native ad template.");
                    m5868a(0);
                    return false;
                } else {
                    m6863a(jlVar2, ((C1141f) c1136a).mo1065k());
                }
            }
            return super.mo982a(jlVar, jlVar2);
        }
        throw new IllegalStateException("Native ad DOES NOT have custom rendering mode.");
    }

    public void m6876b(C0369j<String, dr> c0369j) {
        C1896c.m10797b("setOnCustomClickListener must be called on the main UI thread.");
        this.f.f4008u = c0369j;
    }

    public dr m6877c(String str) {
        C1896c.m10797b("getOnCustomClickListener must be called on the main UI thread.");
        return (dr) this.f.f4008u.get(str);
    }

    public void c_() {
        throw new IllegalStateException("Native Ad DOES NOT support resume().");
    }

    public void mo969d() {
        throw new IllegalStateException("Native Ad DOES NOT support pause().");
    }

    public void mo986f() {
        throw new IllegalStateException("Interstitial is NOT supported by NativeAdManager.");
    }
}
