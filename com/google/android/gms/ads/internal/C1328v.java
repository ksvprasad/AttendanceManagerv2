package com.google.android.gms.ads.internal;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.os.RemoteException;
import android.support.v4.p015g.C0369j;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.widget.ViewSwitcher;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.C1120y;
import com.google.android.gms.ads.internal.client.VideoOptionsParcel;
import com.google.android.gms.ads.internal.client.ab;
import com.google.android.gms.ads.internal.client.ac;
import com.google.android.gms.ads.internal.client.ai;
import com.google.android.gms.ads.internal.client.ak;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.internal.purchase.C1239k;
import com.google.android.gms.ads.internal.reward.client.C1301d;
import com.google.android.gms.ads.internal.util.client.C1324b;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.p031b.aj;
import com.google.android.gms.p031b.cq;
import com.google.android.gms.p031b.dc;
import com.google.android.gms.p031b.dp;
import com.google.android.gms.p031b.dq;
import com.google.android.gms.p031b.dr;
import com.google.android.gms.p031b.ds;
import com.google.android.gms.p031b.hd;
import com.google.android.gms.p031b.hh;
import com.google.android.gms.p031b.id;
import com.google.android.gms.p031b.jl;
import com.google.android.gms.p031b.jl.C1632a;
import com.google.android.gms.p031b.jm;
import com.google.android.gms.p031b.js;
import com.google.android.gms.p031b.ju;
import com.google.android.gms.p031b.jv;
import com.google.android.gms.p031b.kb;
import com.google.android.gms.p031b.kc;
import com.google.android.gms.p031b.kj;
import com.google.android.gms.p031b.km;
import com.google.android.gms.p031b.la;
import com.google.android.gms.p031b.lb;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.UUID;

@id
public final class C1328v implements OnGlobalLayoutListener, OnScrollChangedListener {
    List<String> f3974A;
    C1239k f3975B;
    public js f3976C;
    View f3977D;
    public int f3978E;
    boolean f3979F;
    boolean f3980G;
    private HashSet<jm> f3981H;
    private int f3982I;
    private int f3983J;
    private kj f3984K;
    private boolean f3985L;
    private boolean f3986M;
    private boolean f3987N;
    final String f3988a;
    public String f3989b;
    public final Context f3990c;
    final aj f3991d;
    public final VersionInfoParcel f3992e;
    C1327a f3993f;
    public ju f3994g;
    public kb f3995h;
    public AdSizeParcel f3996i;
    public jl f3997j;
    public C1632a f3998k;
    public jm f3999l;
    ab f4000m;
    ac f4001n;
    ai f4002o;
    ak f4003p;
    hd f4004q;
    hh f4005r;
    dp f4006s;
    dq f4007t;
    C0369j<String, dr> f4008u;
    C0369j<String, ds> f4009v;
    NativeAdOptionsParcel f4010w;
    VideoOptionsParcel f4011x;
    dc f4012y;
    C1301d f4013z;

    public static class C1327a extends ViewSwitcher {
        private final kc f3972a;
        private final km f3973b;

        public C1327a(Context context, OnGlobalLayoutListener onGlobalLayoutListener, OnScrollChangedListener onScrollChangedListener) {
            super(context);
            this.f3972a = new kc(context);
            if (context instanceof Activity) {
                this.f3973b = new km((Activity) context, this, onGlobalLayoutListener, onScrollChangedListener);
            } else {
                this.f3973b = new km(null, this, onGlobalLayoutListener, onScrollChangedListener);
            }
            this.f3973b.m9355a();
        }

        public kc m7240a() {
            return this.f3972a;
        }

        public void m7241b() {
            jv.m9152e("Disable position monitoring on adFrame.");
            if (this.f3973b != null) {
                this.f3973b.m9357b();
            }
        }

        protected void onAttachedToWindow() {
            super.onAttachedToWindow();
            if (this.f3973b != null) {
                this.f3973b.m9358c();
            }
        }

        protected void onDetachedFromWindow() {
            super.onDetachedFromWindow();
            if (this.f3973b != null) {
                this.f3973b.m9359d();
            }
        }

        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            this.f3972a.m9312a(motionEvent);
            return false;
        }

        public void removeAllViews() {
            List<la> arrayList = new ArrayList();
            for (int i = 0; i < getChildCount(); i++) {
                View childAt = getChildAt(i);
                if (childAt != null && (childAt instanceof la)) {
                    arrayList.add((la) childAt);
                }
            }
            super.removeAllViews();
            for (la destroy : arrayList) {
                destroy.destroy();
            }
        }
    }

    public C1328v(Context context, AdSizeParcel adSizeParcel, String str, VersionInfoParcel versionInfoParcel) {
        this(context, adSizeParcel, str, versionInfoParcel, null);
    }

    C1328v(Context context, AdSizeParcel adSizeParcel, String str, VersionInfoParcel versionInfoParcel, aj ajVar) {
        this.f3976C = null;
        this.f3977D = null;
        this.f3978E = 0;
        this.f3979F = false;
        this.f3980G = false;
        this.f3981H = null;
        this.f3982I = -1;
        this.f3983J = -1;
        this.f3985L = true;
        this.f3986M = true;
        this.f3987N = false;
        cq.m7828a(context);
        if (C1319u.m7186h().m9126e() != null) {
            List b = cq.m7829b();
            if (versionInfoParcel.f3958c != 0) {
                b.add(Integer.toString(versionInfoParcel.f3958c));
            }
            C1319u.m7186h().m9126e().m7842a(b);
        }
        this.f3988a = UUID.randomUUID().toString();
        if (adSizeParcel.f3107e || adSizeParcel.f3111i) {
            this.f3993f = null;
        } else {
            this.f3993f = new C1327a(context, this, this);
            this.f3993f.setMinimumWidth(adSizeParcel.f3109g);
            this.f3993f.setMinimumHeight(adSizeParcel.f3106d);
            this.f3993f.setVisibility(4);
        }
        this.f3996i = adSizeParcel;
        this.f3989b = str;
        this.f3990c = context;
        this.f3992e = versionInfoParcel;
        if (ajVar == null) {
            ajVar = new aj(new C1166i(this));
        }
        this.f3991d = ajVar;
        this.f3984K = new kj(200);
        this.f4009v = new C0369j();
    }

    private void m7242b(boolean z) {
        boolean z2 = true;
        if (this.f3993f != null && this.f3997j != null && this.f3997j.f5424b != null && this.f3997j.f5424b.mo1519l() != null) {
            if (!z || this.f3984K.m9349a()) {
                if (this.f3997j.f5424b.mo1519l().m9472b()) {
                    int[] iArr = new int[2];
                    this.f3993f.getLocationOnScreen(iArr);
                    int b = C1120y.m6293a().m7220b(this.f3990c, iArr[0]);
                    int b2 = C1120y.m6293a().m7220b(this.f3990c, iArr[1]);
                    if (!(b == this.f3982I && b2 == this.f3983J)) {
                        this.f3982I = b;
                        this.f3983J = b2;
                        lb l = this.f3997j.f5424b.mo1519l();
                        b = this.f3982I;
                        int i = this.f3983J;
                        if (z) {
                            z2 = false;
                        }
                        l.m9457a(b, i, z2);
                    }
                }
                m7243k();
            }
        }
    }

    private void m7243k() {
        if (this.f3993f != null) {
            View findViewById = this.f3993f.getRootView().findViewById(16908290);
            if (findViewById != null) {
                Rect rect = new Rect();
                Rect rect2 = new Rect();
                this.f3993f.getGlobalVisibleRect(rect);
                findViewById.getGlobalVisibleRect(rect2);
                if (rect.top != rect2.top) {
                    this.f3985L = false;
                }
                if (rect.bottom != rect2.bottom) {
                    this.f3986M = false;
                }
            }
        }
    }

    public HashSet<jm> m7244a() {
        return this.f3981H;
    }

    public void m7245a(HashSet<jm> hashSet) {
        this.f3981H = hashSet;
    }

    public void m7246a(boolean z) {
        if (this.f3978E == 0) {
            m7248c();
        }
        if (this.f3994g != null) {
            this.f3994g.mo1106d();
        }
        if (this.f3995h != null) {
            this.f3995h.mo1106d();
        }
        if (z) {
            this.f3997j = null;
        }
    }

    public void m7247b() {
        if (this.f3997j != null && this.f3997j.f5424b != null) {
            this.f3997j.f5424b.destroy();
        }
    }

    public void m7248c() {
        if (this.f3997j != null && this.f3997j.f5424b != null) {
            this.f3997j.f5424b.stopLoading();
        }
    }

    public void m7249d() {
        if (this.f3997j != null && this.f3997j.f5438p != null) {
            try {
                this.f3997j.f5438p.mo1360c();
            } catch (RemoteException e) {
                C1324b.m7234d("Could not destroy mediation adapter.");
            }
        }
    }

    public boolean m7250e() {
        return this.f3978E == 0;
    }

    public boolean m7251f() {
        return this.f3978E == 1;
    }

    public void m7252g() {
        if (this.f3993f != null) {
            this.f3993f.m7241b();
        }
    }

    public String m7253h() {
        return (this.f3985L && this.f3986M) ? "" : this.f3985L ? this.f3987N ? "top-scrollable" : "top-locked" : this.f3986M ? this.f3987N ? "bottom-scrollable" : "bottom-locked" : "";
    }

    public void m7254i() {
        if (this.f3997j != null) {
            this.f3999l.m9089a(this.f3997j.f5416A);
            this.f3999l.m9093b(this.f3997j.f5417B);
            this.f3999l.m9094b(this.f3997j.f5436n);
        }
        this.f3999l.m9091a(this.f3996i.f3107e);
    }

    public void m7255j() {
        m7252g();
        this.f4001n = null;
        this.f4002o = null;
        this.f4005r = null;
        this.f4004q = null;
        this.f4012y = null;
        this.f4003p = null;
        m7246a(false);
        if (this.f3993f != null) {
            this.f3993f.removeAllViews();
        }
        m7247b();
        m7249d();
        this.f3997j = null;
    }

    public void onGlobalLayout() {
        m7242b(false);
    }

    public void onScrollChanged() {
        m7242b(true);
        this.f3987N = true;
    }
}
