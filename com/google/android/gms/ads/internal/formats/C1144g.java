package com.google.android.gms.ads.internal.formats;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import com.google.android.gms.ads.internal.C1245q;
import com.google.android.gms.ads.internal.util.client.C1324b;
import com.google.android.gms.common.internal.C1896c;
import com.google.android.gms.p031b.aj;
import com.google.android.gms.p031b.gb;
import com.google.android.gms.p031b.gc;
import com.google.android.gms.p031b.id;
import com.google.android.gms.p031b.la;
import com.google.android.gms.p033a.C1001b;
import java.lang.ref.WeakReference;
import java.util.Map;
import org.json.JSONObject;

@id
public class C1144g extends C1143i {
    private gb f3360a;
    private gc f3361b;
    private final C1245q f3362c;
    private C1142h f3363d;
    private boolean f3364e;
    private Object f3365f;

    private C1144g(Context context, C1245q c1245q, aj ajVar) {
        super(context, c1245q, null, ajVar, null, null, null, null);
        this.f3364e = false;
        this.f3365f = new Object();
        this.f3362c = c1245q;
    }

    public C1144g(Context context, C1245q c1245q, aj ajVar, gb gbVar) {
        this(context, c1245q, ajVar);
        this.f3360a = gbVar;
    }

    public C1144g(Context context, C1245q c1245q, aj ajVar, gc gcVar) {
        this(context, c1245q, ajVar);
        this.f3361b = gcVar;
    }

    public C1132b mo1092a(OnClickListener onClickListener) {
        return null;
    }

    public void mo1083a() {
        C1896c.m10797b("recordImpression must be called on the main UI thread.");
        synchronized (this.f3365f) {
            m6425a(true);
            if (this.f3363d != null) {
                this.f3363d.mo1083a();
                this.f3362c.m5923A();
            } else {
                try {
                    if (this.f3360a != null && !this.f3360a.mo1382j()) {
                        this.f3360a.mo1381i();
                        this.f3362c.m5923A();
                    } else if (!(this.f3361b == null || this.f3361b.mo1395h())) {
                        this.f3361b.mo1394g();
                        this.f3362c.m5923A();
                    }
                } catch (Throwable e) {
                    C1324b.m7235d("Failed to call recordImpression", e);
                }
            }
        }
    }

    public void mo1086a(View view, Map<String, WeakReference<View>> map) {
        synchronized (this.f3365f) {
            try {
                if (this.f3360a != null) {
                    this.f3360a.mo1375c(C1001b.m5713a((Object) view));
                } else if (this.f3361b != null) {
                    this.f3361b.mo1390c(C1001b.m5713a((Object) view));
                }
            } catch (Throwable e) {
                C1324b.m7235d("Failed to call untrackView", e);
            }
        }
    }

    public void mo1093a(View view, Map<String, WeakReference<View>> map, OnTouchListener onTouchListener, OnClickListener onClickListener) {
        synchronized (this.f3365f) {
            this.f3364e = true;
            try {
                if (this.f3360a != null) {
                    this.f3360a.mo1373b(C1001b.m5713a((Object) view));
                } else if (this.f3361b != null) {
                    this.f3361b.mo1388b(C1001b.m5713a((Object) view));
                }
            } catch (Throwable e) {
                C1324b.m7235d("Failed to call prepareAd", e);
            }
            this.f3364e = false;
        }
    }

    public void mo1087a(View view, Map<String, WeakReference<View>> map, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3) {
        C1896c.m10797b("performClick must be called on the main UI thread.");
        synchronized (this.f3365f) {
            if (this.f3363d != null) {
                this.f3363d.mo1087a(view, map, jSONObject, jSONObject2, jSONObject3);
                this.f3362c.mo915e();
            } else {
                try {
                    if (!(this.f3360a == null || this.f3360a.mo1383k())) {
                        this.f3360a.mo1371a(C1001b.m5713a((Object) view));
                        this.f3362c.mo915e();
                    }
                    if (!(this.f3361b == null || this.f3361b.mo1396i())) {
                        this.f3361b.mo1386a(C1001b.m5713a((Object) view));
                        this.f3362c.mo915e();
                    }
                } catch (Throwable e) {
                    C1324b.m7235d("Failed to call performClick", e);
                }
            }
        }
    }

    public void m6436a(C1142h c1142h) {
        synchronized (this.f3365f) {
            this.f3363d = c1142h;
        }
    }

    public boolean m6437b() {
        boolean z;
        synchronized (this.f3365f) {
            z = this.f3364e;
        }
        return z;
    }

    public C1142h m6438c() {
        C1142h c1142h;
        synchronized (this.f3365f) {
            c1142h = this.f3363d;
        }
        return c1142h;
    }

    public la mo1094d() {
        return null;
    }
}
