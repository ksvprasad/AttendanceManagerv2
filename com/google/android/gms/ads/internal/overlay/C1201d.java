package com.google.android.gms.ads.internal.overlay;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.Window;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.google.android.gms.ads.internal.C1122d;
import com.google.android.gms.ads.internal.C1319u;
import com.google.android.gms.ads.internal.util.client.C1324b;
import com.google.android.gms.p031b.cq;
import com.google.android.gms.p031b.gx.C1199a;
import com.google.android.gms.p031b.id;
import com.google.android.gms.p031b.ju;
import com.google.android.gms.p031b.jz;
import com.google.android.gms.p031b.kc;
import com.google.android.gms.p031b.la;
import com.google.android.gms.p031b.lb;
import com.google.android.gms.p031b.lb.C1148a;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.Future;

@id
public class C1201d extends C1199a implements C1200u {
    static final int f3529a = Color.argb(0, 0, 0, 0);
    AdOverlayInfoParcel f3530b;
    la f3531c;
    C1196c f3532d;
    C1212o f3533e;
    boolean f3534f = false;
    FrameLayout f3535g;
    CustomViewCallback f3536h;
    boolean f3537i = false;
    boolean f3538j = false;
    C1195b f3539k;
    boolean f3540l = false;
    int f3541m = 0;
    C1209l f3542n;
    private final Activity f3543o;
    private boolean f3544p;
    private boolean f3545q = false;
    private boolean f3546r = true;

    class C11931 implements C1148a {
        final /* synthetic */ C1201d f3519a;

        C11931(C1201d c1201d) {
            this.f3519a = c1201d;
        }

        public void mo1096a(la laVar, boolean z) {
            laVar.mo1510d();
        }
    }

    @id
    private static final class C1194a extends Exception {
        public C1194a(String str) {
            super(str);
        }
    }

    @id
    static class C1195b extends RelativeLayout {
        kc f3520a;
        boolean f3521b;

        public C1195b(Context context, String str) {
            super(context);
            this.f3520a = new kc(context, str);
        }

        void m6635a() {
            this.f3521b = true;
        }

        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            if (!this.f3521b) {
                this.f3520a.m9312a(motionEvent);
            }
            return false;
        }
    }

    @id
    public static class C1196c {
        public final int f3522a;
        public final LayoutParams f3523b;
        public final ViewGroup f3524c;
        public final Context f3525d;

        public C1196c(la laVar) {
            this.f3523b = laVar.getLayoutParams();
            ViewParent parent = laVar.getParent();
            this.f3525d = laVar.mo1514g();
            if (parent == null || !(parent instanceof ViewGroup)) {
                throw new C1194a("Could not get the parent of the WebView for an overlay.");
            }
            this.f3524c = (ViewGroup) parent;
            this.f3522a = this.f3524c.indexOfChild(laVar.mo1503b());
            this.f3524c.removeView(laVar.mo1503b());
            laVar.mo1502a(true);
        }
    }

    @id
    private class C1198d extends ju {
        final /* synthetic */ C1201d f3528a;

        private C1198d(C1201d c1201d) {
            this.f3528a = c1201d;
        }

        public void mo1108a() {
            Bitmap a = C1319u.m7200v().m9345a(Integer.valueOf(this.f3528a.f3530b.f3490q.f3054g));
            if (a != null) {
                final Drawable a2 = C1319u.m7185g().mo1477a(this.f3528a.f3543o, a, this.f3528a.f3530b.f3490q.f3052e, this.f3528a.f3530b.f3490q.f3053f);
                jz.f5567a.post(new Runnable(this) {
                    final /* synthetic */ C1198d f3527b;

                    public void run() {
                        this.f3527b.f3528a.f3543o.getWindow().setBackgroundDrawable(a2);
                    }
                });
            }
        }

        public void mo1109b() {
        }
    }

    public C1201d(Activity activity) {
        this.f3543o = activity;
        this.f3542n = new C1215s();
    }

    public void m6653a() {
        this.f3541m = 2;
        this.f3543o.finish();
    }

    public void m6654a(int i) {
        this.f3543o.setRequestedOrientation(i);
    }

    public void mo1133a(int i, int i2, Intent intent) {
    }

    public void mo1134a(Bundle bundle) {
        boolean z = false;
        this.f3543o.requestWindowFeature(1);
        if (bundle != null) {
            z = bundle.getBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", false);
        }
        this.f3537i = z;
        try {
            this.f3530b = AdOverlayInfoParcel.m6587a(this.f3543o.getIntent());
            if (this.f3530b == null) {
                throw new C1194a("Could not get info for ad overlay.");
            }
            if (this.f3530b.f3487n.f3959d > 7500000) {
                this.f3541m = 3;
            }
            if (this.f3543o.getIntent() != null) {
                this.f3546r = this.f3543o.getIntent().getBooleanExtra("shouldCallOnOverlayOpened", true);
            }
            if (this.f3530b.f3490q != null) {
                this.f3538j = this.f3530b.f3490q.f3049b;
            } else {
                this.f3538j = false;
            }
            if (((Boolean) cq.bd.m7801c()).booleanValue() && this.f3538j && this.f3530b.f3490q.f3054g != -1) {
                Future future = (Future) new C1198d().mo1107e();
            }
            if (bundle == null) {
                if (this.f3530b.f3477d != null && this.f3546r) {
                    this.f3530b.f3477d.e_();
                }
                if (!(this.f3530b.f3485l == 1 || this.f3530b.f3476c == null)) {
                    this.f3530b.f3476c.mo915e();
                }
            }
            this.f3539k = new C1195b(this.f3543o, this.f3530b.f3489p);
            this.f3539k.setId(1000);
            switch (this.f3530b.f3485l) {
                case 1:
                    m6664b(false);
                    return;
                case 2:
                    this.f3532d = new C1196c(this.f3530b.f3478e);
                    m6664b(false);
                    return;
                case 3:
                    m6664b(true);
                    return;
                case 4:
                    if (this.f3537i) {
                        this.f3541m = 3;
                        this.f3543o.finish();
                        return;
                    } else if (!C1319u.m7180b().m6596a(this.f3543o, this.f3530b.f3475b, this.f3530b.f3483j)) {
                        this.f3541m = 3;
                        this.f3543o.finish();
                        return;
                    } else {
                        return;
                    }
                default:
                    throw new C1194a("Could not determine ad overlay type.");
            }
        } catch (C1194a e) {
            C1324b.m7234d(e.getMessage());
            this.f3541m = 3;
            this.f3543o.finish();
        }
    }

    public void m6657a(View view, CustomViewCallback customViewCallback) {
        this.f3535g = new FrameLayout(this.f3543o);
        this.f3535g.setBackgroundColor(-16777216);
        this.f3535g.addView(view, -1, -1);
        this.f3543o.setContentView(this.f3535g);
        mo1145l();
        this.f3536h = customViewCallback;
        this.f3534f = true;
    }

    public void m6658a(la laVar, Map<String, String> map) {
        this.f3542n.mo1155a(laVar, map);
    }

    public void m6659a(boolean z) {
        this.f3533e = new C1212o(this.f3543o, z ? 50 : 32, this);
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(10);
        layoutParams.addRule(z ? 11 : 9);
        this.f3533e.m6732a(z, this.f3530b.f3481h);
        this.f3539k.addView(this.f3533e, layoutParams);
    }

    public void m6660a(boolean z, boolean z2) {
        if (this.f3533e != null) {
            this.f3533e.m6732a(z, z2);
        }
    }

    public void m6661b() {
        if (this.f3530b != null && this.f3534f) {
            m6654a(this.f3530b.f3484k);
        }
        if (this.f3535g != null) {
            this.f3543o.setContentView(this.f3539k);
            mo1145l();
            this.f3535g.removeAllViews();
            this.f3535g = null;
        }
        if (this.f3536h != null) {
            this.f3536h.onCustomViewHidden();
            this.f3536h = null;
        }
        this.f3534f = false;
    }

    protected void m6662b(int i) {
        this.f3531c.mo1493a(i);
    }

    public void mo1135b(Bundle bundle) {
        bundle.putBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", this.f3537i);
    }

    protected void m6664b(boolean z) {
        if (!this.f3544p) {
            this.f3543o.requestWindowFeature(1);
        }
        Window window = this.f3543o.getWindow();
        if (window == null) {
            throw new C1194a("Invalid activity, no window available.");
        }
        if (!this.f3538j || (this.f3530b.f3490q != null && this.f3530b.f3490q.f3050c)) {
            window.setFlags(1024, 1024);
        }
        lb l = this.f3530b.f3478e.mo1519l();
        boolean b = l != null ? l.m9472b() : false;
        this.f3540l = false;
        if (b) {
            if (this.f3530b.f3484k == C1319u.m7185g().mo1463a()) {
                this.f3540l = this.f3543o.getResources().getConfiguration().orientation == 1;
            } else if (this.f3530b.f3484k == C1319u.m7185g().mo1465b()) {
                this.f3540l = this.f3543o.getResources().getConfiguration().orientation == 2;
            }
        }
        C1324b.m7227a("Delay onShow to next orientation change: " + this.f3540l);
        m6654a(this.f3530b.f3484k);
        if (C1319u.m7185g().mo1469a(window)) {
            C1324b.m7227a("Hardware acceleration on the AdActivity window enabled.");
        }
        if (this.f3538j) {
            this.f3539k.setBackgroundColor(f3529a);
        } else {
            this.f3539k.setBackgroundColor(-16777216);
        }
        this.f3543o.setContentView(this.f3539k);
        mo1145l();
        if (z) {
            this.f3531c = C1319u.m7184f().m9481a(this.f3543o, this.f3530b.f3478e.mo1518k(), true, b, null, this.f3530b.f3487n, null, null, this.f3530b.f3478e.mo1515h());
            this.f3531c.mo1519l().m9459a(null, null, this.f3530b.f3479f, this.f3530b.f3483j, true, this.f3530b.f3488o, null, this.f3530b.f3478e.mo1519l().m9455a(), null, null);
            this.f3531c.mo1519l().m9463a(new C11931(this));
            if (this.f3530b.f3486m != null) {
                this.f3531c.loadUrl(this.f3530b.f3486m);
            } else if (this.f3530b.f3482i != null) {
                this.f3531c.loadDataWithBaseURL(this.f3530b.f3480g, this.f3530b.f3482i, "text/html", "UTF-8", null);
            } else {
                throw new C1194a("No URL or HTML to display in ad overlay.");
            }
            if (this.f3530b.f3478e != null) {
                this.f3530b.f3478e.mo1505b(this);
            }
        } else {
            this.f3531c = this.f3530b.f3478e;
            this.f3531c.mo1494a(this.f3543o);
        }
        this.f3531c.mo1497a(this);
        ViewParent parent = this.f3531c.getParent();
        if (parent != null && (parent instanceof ViewGroup)) {
            ((ViewGroup) parent).removeView(this.f3531c.mo1503b());
        }
        if (this.f3538j) {
            this.f3531c.setBackgroundColor(f3529a);
        }
        this.f3539k.addView(this.f3531c.mo1503b(), -1, -1);
        if (!(z || this.f3540l)) {
            m6678p();
        }
        m6659a(b);
        if (this.f3531c.mo1523m()) {
            m6660a(b, true);
        }
        C1122d h = this.f3531c.mo1515h();
        C1210m c1210m = h != null ? h.f3284c : null;
        if (c1210m != null) {
            this.f3542n = c1210m.mo1159a(this.f3543o, this.f3531c, this.f3539k);
        } else {
            C1324b.m7234d("Appstreaming controller is null.");
        }
    }

    public void mo1136c() {
        this.f3541m = 1;
        this.f3543o.finish();
    }

    public void mo1137d() {
        this.f3541m = 0;
    }

    public boolean mo1138e() {
        boolean z = true;
        this.f3541m = 0;
        if (this.f3531c != null) {
            if (!(this.f3531c.mo1538t() && this.f3542n.mo1158d())) {
                z = false;
            }
            if (!z) {
                this.f3531c.mo1501a("onbackblocked", Collections.emptyMap());
            }
        }
        return z;
    }

    public void mo1139f() {
    }

    public void mo1140g() {
    }

    public void mo1141h() {
        if (this.f3530b != null && this.f3530b.f3485l == 4) {
            if (this.f3537i) {
                this.f3541m = 3;
                this.f3543o.finish();
            } else {
                this.f3537i = true;
            }
        }
        if (this.f3530b.f3477d != null) {
            this.f3530b.f3477d.mo988g();
        }
        if (this.f3531c == null || this.f3531c.mo1530r()) {
            C1324b.m7234d("The webview does not exit. Ignoring action.");
        } else {
            C1319u.m7185g().m9277b(this.f3531c);
        }
        this.f3542n.mo1156b();
    }

    public void mo1142i() {
        this.f3542n.mo1154a();
        m6661b();
        if (this.f3530b.f3477d != null) {
            this.f3530b.f3477d.f_();
        }
        if (this.f3531c != null && (!this.f3543o.isFinishing() || this.f3532d == null)) {
            C1319u.m7185g().m9273a(this.f3531c);
        }
        m6676n();
    }

    public void mo1143j() {
        m6676n();
    }

    public void mo1144k() {
        if (this.f3531c != null) {
            this.f3539k.removeView(this.f3531c.mo1503b());
        }
        m6676n();
    }

    public void mo1145l() {
        this.f3544p = true;
    }

    public void m6675m() {
        this.f3539k.removeView(this.f3533e);
        m6659a(true);
    }

    protected void m6676n() {
        if (this.f3543o.isFinishing() && !this.f3545q) {
            this.f3545q = true;
            if (this.f3531c != null) {
                m6662b(this.f3541m);
                this.f3539k.removeView(this.f3531c.mo1503b());
                if (this.f3532d != null) {
                    this.f3531c.mo1494a(this.f3532d.f3525d);
                    this.f3531c.mo1502a(false);
                    this.f3532d.f3524c.addView(this.f3531c.mo1503b(), this.f3532d.f3522a, this.f3532d.f3523b);
                    this.f3532d = null;
                } else if (this.f3543o.getApplicationContext() != null) {
                    this.f3531c.mo1494a(this.f3543o.getApplicationContext());
                }
                this.f3531c = null;
            }
            if (!(this.f3530b == null || this.f3530b.f3477d == null)) {
                this.f3530b.f3477d.d_();
            }
            this.f3542n.mo1157c();
        }
    }

    public void m6677o() {
        if (this.f3540l) {
            this.f3540l = false;
            m6678p();
        }
    }

    protected void m6678p() {
        this.f3531c.mo1510d();
    }

    public void m6679q() {
        this.f3539k.m6635a();
    }
}
