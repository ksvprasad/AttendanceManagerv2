package com.google.android.gms.ads.internal;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import com.google.android.gms.ads.C1029d;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.C1081c;
import com.google.android.gms.ads.internal.client.C1120y;
import com.google.android.gms.ads.internal.util.client.C1324b;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.internal.C1896c;
import com.google.android.gms.p031b.cq;
import com.google.android.gms.p031b.fx;
import com.google.android.gms.p031b.id;
import com.google.android.gms.p031b.jf;
import com.google.android.gms.p031b.jl;
import com.google.android.gms.p031b.jl.C1632a;
import com.google.android.gms.p031b.jz;
import com.google.android.gms.p031b.la;
import com.google.android.gms.p031b.lb;
import com.google.android.gms.p031b.lb.C1125d;
import com.google.android.gms.p031b.lb.C1127b;
import com.google.android.gms.p031b.lf;
import java.util.List;

@id
public class C1130f extends C1057c implements OnGlobalLayoutListener, OnScrollChangedListener {
    private boolean f3296l;

    class C11241 implements Runnable {
        final /* synthetic */ C1130f f3289a;

        C11241(C1130f c1130f) {
            this.f3289a = c1130f;
        }

        public void run() {
            this.f3289a.m6316d(this.f3289a.f.f3997j);
        }
    }

    public class C1129a {
        final /* synthetic */ C1130f f3295a;

        public C1129a(C1130f c1130f) {
            this.f3295a = c1130f;
        }

        public void m6306a() {
            this.f3295a.mo915e();
        }
    }

    public C1130f(Context context, AdSizeParcel adSizeParcel, String str, fx fxVar, VersionInfoParcel versionInfoParcel, C1122d c1122d) {
        super(context, adSizeParcel, str, fxVar, versionInfoParcel, c1122d);
    }

    private AdSizeParcel m6307b(C1632a c1632a) {
        if (c1632a.f5409b.f3765A) {
            return this.f.f3996i;
        }
        C1029d c1029d;
        String str = c1632a.f5409b.f3791m;
        if (str != null) {
            String[] split = str.split("[xX]");
            split[0] = split[0].trim();
            split[1] = split[1].trim();
            c1029d = new C1029d(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
        } else {
            c1029d = this.f.f3996i.m5972b();
        }
        return new AdSizeParcel(this.f.f3990c, c1029d);
    }

    private boolean m6308b(jl jlVar, jl jlVar2) {
        if (jlVar2.f5436n) {
            View a = C1180n.m6556a(jlVar2);
            if (a == null) {
                C1324b.m7234d("Could not get mediation view");
                return false;
            }
            View nextView = this.f.f3993f.getNextView();
            if (nextView != null) {
                if (nextView instanceof la) {
                    ((la) nextView).destroy();
                }
                this.f.f3993f.removeView(nextView);
            }
            if (!C1180n.m6576b(jlVar2)) {
                try {
                    m5869a(a);
                } catch (Throwable th) {
                    C1324b.m7235d("Could not add mediation view to view hierarchy.", th);
                    return false;
                }
            }
        } else if (!(jlVar2.f5444v == null || jlVar2.f5424b == null)) {
            jlVar2.f5424b.mo1496a(jlVar2.f5444v);
            this.f.f3993f.removeAllViews();
            this.f.f3993f.setMinimumWidth(jlVar2.f5444v.f3109g);
            this.f.f3993f.setMinimumHeight(jlVar2.f5444v.f3106d);
            m5869a(jlVar2.f5424b.mo1503b());
        }
        if (this.f.f3993f.getChildCount() > 1) {
            this.f.f3993f.showNext();
        }
        if (jlVar != null) {
            View nextView2 = this.f.f3993f.getNextView();
            if (nextView2 instanceof la) {
                ((la) nextView2).mo1495a(this.f.f3990c, this.f.f3996i, this.a);
            } else if (nextView2 != null) {
                this.f.f3993f.removeView(nextView2);
            }
            this.f.m7249d();
        }
        this.f.f3993f.setVisibility(0);
        return true;
    }

    private void m6309e(final jl jlVar) {
        if (this.f.m7250e()) {
            if (jlVar.f5424b != null) {
                if (jlVar.f5432j != null) {
                    this.h.m7655a(this.f.f3996i, jlVar);
                }
                if (jlVar.m9083a()) {
                    this.h.m7655a(this.f.f3996i, jlVar).m7624a(jlVar.f5424b);
                } else {
                    jlVar.f5424b.mo1519l().m9464a(new C1127b(this) {
                        final /* synthetic */ C1130f f3294b;

                        public void mo1047a() {
                            this.f3294b.h.m7655a(this.f3294b.f.f3996i, jlVar).m7624a(jlVar.f5424b);
                        }
                    });
                }
            }
        } else if (this.f.f3977D != null && jlVar.f5432j != null) {
            this.h.m7656a(this.f.f3996i, jlVar, this.f.f3977D);
        }
    }

    protected la mo1048a(C1632a c1632a, C1123e c1123e, jf jfVar) {
        if (this.f.f3996i.f3110h == null && this.f.f3996i.f3112j) {
            this.f.f3996i = m6307b(c1632a);
        }
        return super.mo1048a(c1632a, c1123e, jfVar);
    }

    protected void mo1049a(jl jlVar, boolean z) {
        super.mo1049a(jlVar, z);
        if (C1180n.m6576b(jlVar)) {
            C1180n.m6565a(jlVar, new C1129a(this));
        }
    }

    public void mo963a(boolean z) {
        C1896c.m10797b("setManualImpressionsEnabled must be called from the main thread.");
        this.f3296l = z;
    }

    public boolean mo964a(AdRequestParcel adRequestParcel) {
        return super.mo964a(mo1050d(adRequestParcel));
    }

    public boolean mo982a(jl jlVar, final jl jlVar2) {
        if (!super.mo982a(jlVar, jlVar2)) {
            return false;
        }
        if (!this.f.m7250e() || m6308b(jlVar, jlVar2)) {
            lf z;
            if (jlVar2.f5433k) {
                m6316d(jlVar2);
                C1319u.m7203y().m9377a(this.f.f3993f, (OnGlobalLayoutListener) this);
                C1319u.m7203y().m9378a(this.f.f3993f, (OnScrollChangedListener) this);
                if (!jlVar2.f5435m) {
                    final Runnable c11241 = new C11241(this);
                    lb l = jlVar2.f5424b != null ? jlVar2.f5424b.mo1519l() : null;
                    if (l != null) {
                        l.m9465a(new C1125d(this) {
                            final /* synthetic */ C1130f f3292c;

                            public void mo1046a() {
                                if (!jlVar2.f5435m) {
                                    C1319u.m7183e();
                                    jz.m9194b(c11241);
                                }
                            }
                        });
                    }
                }
            } else if (!this.f.m7251f() || ((Boolean) cq.bh.m7801c()).booleanValue()) {
                mo1049a(jlVar2, false);
            }
            if (jlVar2.f5424b != null) {
                z = jlVar2.f5424b.mo1544z();
                lb l2 = jlVar2.f5424b.mo1519l();
                if (l2 != null) {
                    l2.m9475e();
                }
            } else {
                z = null;
            }
            if (!(this.f.f4011x == null || z == null)) {
                z.m9616b(this.f.f4011x.f3130b);
            }
            m6309e(jlVar2);
            return true;
        }
        m5868a(0);
        return false;
    }

    AdRequestParcel mo1050d(AdRequestParcel adRequestParcel) {
        if (adRequestParcel.f3092h == this.f3296l) {
            return adRequestParcel;
        }
        int i = adRequestParcel.f3085a;
        long j = adRequestParcel.f3086b;
        Bundle bundle = adRequestParcel.f3087c;
        int i2 = adRequestParcel.f3088d;
        List list = adRequestParcel.f3089e;
        boolean z = adRequestParcel.f3090f;
        int i3 = adRequestParcel.f3091g;
        boolean z2 = adRequestParcel.f3092h || this.f3296l;
        return new AdRequestParcel(i, j, bundle, i2, list, z, i3, z2, adRequestParcel.f3093i, adRequestParcel.f3094j, adRequestParcel.f3095k, adRequestParcel.f3096l, adRequestParcel.f3097m, adRequestParcel.f3098n, adRequestParcel.f3099o, adRequestParcel.f3100p, adRequestParcel.f3101q, adRequestParcel.f3102r);
    }

    void m6316d(jl jlVar) {
        if (jlVar != null && !jlVar.f5435m && this.f.f3993f != null && C1319u.m7183e().m9227a(this.f.f3993f, this.f.f3990c) && this.f.f3993f.getGlobalVisibleRect(new Rect(), null)) {
            if (!(jlVar == null || jlVar.f5424b == null || jlVar.f5424b.mo1519l() == null)) {
                jlVar.f5424b.mo1519l().m9465a(null);
            }
            mo1049a(jlVar, false);
            jlVar.f5435m = true;
        }
    }

    public void mo986f() {
        throw new IllegalStateException("Interstitial is NOT supported by BannerAdManager.");
    }

    public C1081c mo974l() {
        C1896c.m10797b("getVideoController must be called from the main thread.");
        return (this.f.f3997j == null || this.f.f3997j.f5424b == null) ? null : this.f.f3997j.f5424b.mo1544z();
    }

    public void onGlobalLayout() {
        m6316d(this.f.f3997j);
    }

    public void onScrollChanged() {
        m6316d(this.f.f3997j);
    }

    protected boolean mo990t() {
        boolean z = true;
        if (!C1319u.m7183e().m9226a(this.f.f3990c.getPackageManager(), this.f.f3990c.getPackageName(), "android.permission.INTERNET")) {
            C1120y.m6293a().m7217a(this.f.f3993f, this.f.f3996i, "Missing internet permission in AndroidManifest.xml.", "Missing internet permission in AndroidManifest.xml. You must have the following declaration: <uses-permission android:name=\"android.permission.INTERNET\" />");
            z = false;
        }
        if (!C1319u.m7183e().m9225a(this.f.f3990c)) {
            C1120y.m6293a().m7217a(this.f.f3993f, this.f.f3996i, "Missing AdActivity with android:configChanges in AndroidManifest.xml.", "Missing AdActivity with android:configChanges in AndroidManifest.xml. You must have the following declaration within the <application> element: <activity android:name=\"com.google.android.gms.ads.AdActivity\" android:configChanges=\"keyboard|keyboardHidden|orientation|screenLayout|uiMode|screenSize|smallestScreenSize\" />");
            z = false;
        }
        if (!(z || this.f.f3993f == null)) {
            this.f.f3993f.setVisibility(0);
        }
        return z;
    }
}
