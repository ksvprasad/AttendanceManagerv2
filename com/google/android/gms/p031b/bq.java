package com.google.android.gms.p031b;

import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Rect;
import android.os.PowerManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.view.WindowManager;
import com.google.android.gms.ads.internal.C1319u;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.formats.C1142h;
import com.google.android.gms.ads.internal.util.client.C1324b;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONObject;

@id
public abstract class bq implements OnGlobalLayoutListener, OnScrollChangedListener {
    protected final Object f4228a = new Object();
    protected final bs f4229b;
    BroadcastReceiver f4230c;
    private final WeakReference<jl> f4231d;
    private WeakReference<ViewTreeObserver> f4232e;
    private final bx f4233f;
    private final Context f4234g;
    private final WindowManager f4235h;
    private final PowerManager f4236i;
    private final KeyguardManager f4237j;
    private bu f4238k;
    private boolean f4239l;
    private boolean f4240m = false;
    private boolean f4241n = false;
    private boolean f4242o;
    private boolean f4243p;
    private boolean f4244q;
    private final HashSet<br> f4245r = new HashSet();
    private kj f4246s;
    private final eb f4247t = new C13802(this);
    private final eb f4248u = new C13813(this);
    private final eb f4249v = new C13824(this);

    class C13791 extends BroadcastReceiver {
        final /* synthetic */ bq f4218a;

        C13791(bq bqVar) {
            this.f4218a = bqVar;
        }

        public void onReceive(Context context, Intent intent) {
            this.f4218a.m7622a(3);
        }
    }

    class C13802 implements eb {
        final /* synthetic */ bq f4219a;

        C13802(bq bqVar) {
            this.f4219a = bqVar;
        }

        public void mo997a(la laVar, Map<String, String> map) {
            if (this.f4219a.m7629a((Map) map)) {
                this.f4219a.m7623a(laVar.mo1503b(), (Map) map);
            }
        }
    }

    class C13813 implements eb {
        final /* synthetic */ bq f4220a;

        C13813(bq bqVar) {
            this.f4220a = bqVar;
        }

        public void mo997a(la laVar, Map<String, String> map) {
            if (this.f4220a.m7629a((Map) map)) {
                String str = "Received request to untrack: ";
                String valueOf = String.valueOf(this.f4220a.f4229b.m7651d());
                C1324b.m7227a(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
                this.f4220a.mo1262c();
            }
        }
    }

    class C13824 implements eb {
        final /* synthetic */ bq f4221a;

        C13824(bq bqVar) {
            this.f4221a = bqVar;
        }

        public void mo997a(la laVar, Map<String, String> map) {
            if (this.f4221a.m7629a((Map) map) && map.containsKey("isVisible")) {
                boolean z = "1".equals(map.get("isVisible")) || "true".equals(map.get("isVisible"));
                this.f4221a.m7628a(Boolean.valueOf(z).booleanValue());
            }
        }
    }

    public static class C1383a implements bx {
        private WeakReference<C1142h> f4222a;

        public C1383a(C1142h c1142h) {
            this.f4222a = new WeakReference(c1142h);
        }

        public View mo1257a() {
            C1142h c1142h = (C1142h) this.f4222a.get();
            return c1142h != null ? c1142h.mo1090e() : null;
        }

        public boolean mo1258b() {
            return this.f4222a.get() == null;
        }

        public bx mo1259c() {
            return new C1384b((C1142h) this.f4222a.get());
        }
    }

    public static class C1384b implements bx {
        private C1142h f4223a;

        public C1384b(C1142h c1142h) {
            this.f4223a = c1142h;
        }

        public View mo1257a() {
            return this.f4223a.mo1090e();
        }

        public boolean mo1258b() {
            return this.f4223a == null;
        }

        public bx mo1259c() {
            return this;
        }
    }

    public static class C1385c implements bx {
        private final View f4224a;
        private final jl f4225b;

        public C1385c(View view, jl jlVar) {
            this.f4224a = view;
            this.f4225b = jlVar;
        }

        public View mo1257a() {
            return this.f4224a;
        }

        public boolean mo1258b() {
            return this.f4225b == null || this.f4224a == null;
        }

        public bx mo1259c() {
            return this;
        }
    }

    public static class C1386d implements bx {
        private final WeakReference<View> f4226a;
        private final WeakReference<jl> f4227b;

        public C1386d(View view, jl jlVar) {
            this.f4226a = new WeakReference(view);
            this.f4227b = new WeakReference(jlVar);
        }

        public View mo1257a() {
            return (View) this.f4226a.get();
        }

        public boolean mo1258b() {
            return this.f4226a.get() == null || this.f4227b.get() == null;
        }

        public bx mo1259c() {
            return new C1385c((View) this.f4226a.get(), (jl) this.f4227b.get());
        }
    }

    public bq(Context context, AdSizeParcel adSizeParcel, jl jlVar, VersionInfoParcel versionInfoParcel, bx bxVar) {
        this.f4231d = new WeakReference(jlVar);
        this.f4233f = bxVar;
        this.f4232e = new WeakReference(null);
        this.f4242o = true;
        this.f4244q = false;
        this.f4246s = new kj(200);
        this.f4229b = new bs(UUID.randomUUID().toString(), versionInfoParcel, adSizeParcel.f3104b, jlVar.f5432j, jlVar.m9083a(), adSizeParcel.f3111i);
        this.f4235h = (WindowManager) context.getSystemService("window");
        this.f4236i = (PowerManager) context.getApplicationContext().getSystemService("power");
        this.f4237j = (KeyguardManager) context.getSystemService("keyguard");
        this.f4234g = context;
    }

    protected int m7619a(int i, DisplayMetrics displayMetrics) {
        return (int) (((float) i) / displayMetrics.density);
    }

    protected JSONObject m7620a(View view) {
        if (view == null) {
            return m7641k();
        }
        boolean a = C1319u.m7185g().mo1479a(view);
        int[] iArr = new int[2];
        int[] iArr2 = new int[2];
        try {
            view.getLocationOnScreen(iArr);
            view.getLocationInWindow(iArr2);
        } catch (Throwable e) {
            C1324b.m7231b("Failure getting view location.", e);
        }
        DisplayMetrics displayMetrics = view.getContext().getResources().getDisplayMetrics();
        Rect rect = new Rect();
        rect.left = iArr[0];
        rect.top = iArr[1];
        rect.right = rect.left + view.getWidth();
        rect.bottom = rect.top + view.getHeight();
        Rect rect2 = new Rect();
        rect2.right = this.f4235h.getDefaultDisplay().getWidth();
        rect2.bottom = this.f4235h.getDefaultDisplay().getHeight();
        Rect rect3 = new Rect();
        boolean globalVisibleRect = view.getGlobalVisibleRect(rect3, null);
        Rect rect4 = new Rect();
        boolean localVisibleRect = view.getLocalVisibleRect(rect4);
        Rect rect5 = new Rect();
        view.getHitRect(rect5);
        JSONObject i = m7639i();
        i.put("windowVisibility", view.getWindowVisibility()).put("isAttachedToWindow", a).put("viewBox", new JSONObject().put("top", m7619a(rect2.top, displayMetrics)).put("bottom", m7619a(rect2.bottom, displayMetrics)).put("left", m7619a(rect2.left, displayMetrics)).put("right", m7619a(rect2.right, displayMetrics))).put("adBox", new JSONObject().put("top", m7619a(rect.top, displayMetrics)).put("bottom", m7619a(rect.bottom, displayMetrics)).put("left", m7619a(rect.left, displayMetrics)).put("right", m7619a(rect.right, displayMetrics))).put("globalVisibleBox", new JSONObject().put("top", m7619a(rect3.top, displayMetrics)).put("bottom", m7619a(rect3.bottom, displayMetrics)).put("left", m7619a(rect3.left, displayMetrics)).put("right", m7619a(rect3.right, displayMetrics))).put("globalVisibleBoxVisible", globalVisibleRect).put("localVisibleBox", new JSONObject().put("top", m7619a(rect4.top, displayMetrics)).put("bottom", m7619a(rect4.bottom, displayMetrics)).put("left", m7619a(rect4.left, displayMetrics)).put("right", m7619a(rect4.right, displayMetrics))).put("localVisibleBoxVisible", localVisibleRect).put("hitBox", new JSONObject().put("top", m7619a(rect5.top, displayMetrics)).put("bottom", m7619a(rect5.bottom, displayMetrics)).put("left", m7619a(rect5.left, displayMetrics)).put("right", m7619a(rect5.right, displayMetrics))).put("screenDensity", (double) displayMetrics.density).put("isVisible", C1319u.m7183e().m9228a(view, this.f4236i, this.f4237j));
        return i;
    }

    protected void m7621a() {
        synchronized (this.f4228a) {
            if (this.f4230c != null) {
                return;
            }
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.SCREEN_ON");
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            this.f4230c = new C13791(this);
            this.f4234g.registerReceiver(this.f4230c, intentFilter);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected void m7622a(int r8) {
        /*
        r7 = this;
        r0 = 0;
        r1 = 1;
        r3 = r7.f4228a;
        monitor-enter(r3);
        r2 = r7.mo1264j();	 Catch:{ all -> 0x0043 }
        if (r2 == 0) goto L_0x000f;
    L_0x000b:
        r2 = r7.f4242o;	 Catch:{ all -> 0x0043 }
        if (r2 != 0) goto L_0x0011;
    L_0x000f:
        monitor-exit(r3);	 Catch:{ all -> 0x0043 }
    L_0x0010:
        return;
    L_0x0011:
        r2 = r7.f4233f;	 Catch:{ all -> 0x0043 }
        r4 = r2.mo1257a();	 Catch:{ all -> 0x0043 }
        if (r4 == 0) goto L_0x0046;
    L_0x0019:
        r2 = com.google.android.gms.ads.internal.C1319u.m7183e();	 Catch:{ all -> 0x0043 }
        r5 = r7.f4236i;	 Catch:{ all -> 0x0043 }
        r6 = r7.f4237j;	 Catch:{ all -> 0x0043 }
        r2 = r2.m9228a(r4, r5, r6);	 Catch:{ all -> 0x0043 }
        if (r2 == 0) goto L_0x0046;
    L_0x0027:
        r2 = new android.graphics.Rect;	 Catch:{ all -> 0x0043 }
        r2.<init>();	 Catch:{ all -> 0x0043 }
        r5 = 0;
        r2 = r4.getGlobalVisibleRect(r2, r5);	 Catch:{ all -> 0x0043 }
        if (r2 == 0) goto L_0x0046;
    L_0x0033:
        r2 = r1;
    L_0x0034:
        r7.f4244q = r2;	 Catch:{ all -> 0x0043 }
        r5 = r7.f4233f;	 Catch:{ all -> 0x0043 }
        r5 = r5.mo1258b();	 Catch:{ all -> 0x0043 }
        if (r5 == 0) goto L_0x0048;
    L_0x003e:
        r7.mo1263d();	 Catch:{ all -> 0x0043 }
        monitor-exit(r3);	 Catch:{ all -> 0x0043 }
        goto L_0x0010;
    L_0x0043:
        r0 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x0043 }
        throw r0;
    L_0x0046:
        r2 = r0;
        goto L_0x0034;
    L_0x0048:
        if (r8 != r1) goto L_0x004b;
    L_0x004a:
        r0 = r1;
    L_0x004b:
        if (r0 == 0) goto L_0x005b;
    L_0x004d:
        r0 = r7.f4246s;	 Catch:{ all -> 0x0043 }
        r0 = r0.m9349a();	 Catch:{ all -> 0x0043 }
        if (r0 != 0) goto L_0x005b;
    L_0x0055:
        r0 = r7.f4244q;	 Catch:{ all -> 0x0043 }
        if (r2 != r0) goto L_0x005b;
    L_0x0059:
        monitor-exit(r3);	 Catch:{ all -> 0x0043 }
        goto L_0x0010;
    L_0x005b:
        if (r2 != 0) goto L_0x0065;
    L_0x005d:
        r0 = r7.f4244q;	 Catch:{ all -> 0x0043 }
        if (r0 != 0) goto L_0x0065;
    L_0x0061:
        if (r8 != r1) goto L_0x0065;
    L_0x0063:
        monitor-exit(r3);	 Catch:{ all -> 0x0043 }
        goto L_0x0010;
    L_0x0065:
        r0 = r7.m7620a(r4);	 Catch:{ JSONException -> 0x007b, RuntimeException -> 0x0074 }
        r7.m7627a(r0);	 Catch:{ JSONException -> 0x007b, RuntimeException -> 0x0074 }
    L_0x006c:
        r7.m7637g();	 Catch:{ all -> 0x0043 }
        r7.m7635e();	 Catch:{ all -> 0x0043 }
        monitor-exit(r3);	 Catch:{ all -> 0x0043 }
        goto L_0x0010;
    L_0x0074:
        r0 = move-exception;
    L_0x0075:
        r1 = "Active view update failed.";
        com.google.android.gms.ads.internal.util.client.C1324b.m7228a(r1, r0);	 Catch:{ all -> 0x0043 }
        goto L_0x006c;
    L_0x007b:
        r0 = move-exception;
        goto L_0x0075;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.b.bq.a(int):void");
    }

    protected void m7623a(View view, Map<String, String> map) {
        m7622a(3);
    }

    public void m7624a(br brVar) {
        this.f4245r.add(brVar);
    }

    public void m7625a(bu buVar) {
        synchronized (this.f4228a) {
            this.f4238k = buVar;
        }
    }

    protected void m7626a(fg fgVar) {
        fgVar.mo1319a("/updateActiveView", this.f4247t);
        fgVar.mo1319a("/untrackActiveViewUnit", this.f4248u);
        fgVar.mo1319a("/visibilityChanged", this.f4249v);
    }

    protected void m7627a(JSONObject jSONObject) {
        try {
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject2 = new JSONObject();
            jSONArray.put(jSONObject);
            jSONObject2.put("units", jSONArray);
            mo1261b(jSONObject2);
        } catch (Throwable th) {
            C1324b.m7231b("Skipping active view message.", th);
        }
    }

    protected void m7628a(boolean z) {
        Iterator it = this.f4245r.iterator();
        while (it.hasNext()) {
            ((br) it.next()).mo1498a(this, z);
        }
    }

    protected boolean m7629a(Map<String, String> map) {
        if (map == null) {
            return false;
        }
        String str = (String) map.get("hashCode");
        boolean z = !TextUtils.isEmpty(str) && str.equals(this.f4229b.m7651d());
        return z;
    }

    protected void m7630b() {
        synchronized (this.f4228a) {
            if (this.f4230c != null) {
                try {
                    this.f4234g.unregisterReceiver(this.f4230c);
                } catch (Throwable e) {
                    C1324b.m7231b("Failed trying to unregister the receiver", e);
                } catch (Throwable e2) {
                    C1319u.m7186h().m9117a(e2, true);
                }
                this.f4230c = null;
            }
        }
    }

    protected void m7631b(fg fgVar) {
        fgVar.mo1324b("/visibilityChanged", this.f4249v);
        fgVar.mo1324b("/untrackActiveViewUnit", this.f4248u);
        fgVar.mo1324b("/updateActiveView", this.f4247t);
    }

    protected abstract void mo1261b(JSONObject jSONObject);

    protected void mo1262c() {
        synchronized (this.f4228a) {
            m7638h();
            m7630b();
            this.f4242o = false;
            m7635e();
        }
    }

    public void mo1263d() {
        synchronized (this.f4228a) {
            if (this.f4242o) {
                this.f4243p = true;
                try {
                    m7627a(m7643m());
                } catch (Throwable e) {
                    C1324b.m7231b("JSON failure while processing active view data.", e);
                } catch (Throwable e2) {
                    C1324b.m7231b("Failure while processing active view data.", e2);
                }
                String str = "Untracking ad unit: ";
                String valueOf = String.valueOf(this.f4229b.m7651d());
                C1324b.m7227a(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
            }
        }
    }

    protected void m7635e() {
        if (this.f4238k != null) {
            this.f4238k.mo1260a(this);
        }
    }

    public boolean m7636f() {
        boolean z;
        synchronized (this.f4228a) {
            z = this.f4242o;
        }
        return z;
    }

    protected void m7637g() {
        View a = this.f4233f.mo1259c().mo1257a();
        if (a != null) {
            ViewTreeObserver viewTreeObserver = (ViewTreeObserver) this.f4232e.get();
            ViewTreeObserver viewTreeObserver2 = a.getViewTreeObserver();
            if (viewTreeObserver2 != viewTreeObserver) {
                m7638h();
                if (!this.f4239l || (viewTreeObserver != null && viewTreeObserver.isAlive())) {
                    this.f4239l = true;
                    viewTreeObserver2.addOnScrollChangedListener(this);
                    viewTreeObserver2.addOnGlobalLayoutListener(this);
                }
                this.f4232e = new WeakReference(viewTreeObserver2);
            }
        }
    }

    protected void m7638h() {
        ViewTreeObserver viewTreeObserver = (ViewTreeObserver) this.f4232e.get();
        if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
            viewTreeObserver.removeOnScrollChangedListener(this);
            viewTreeObserver.removeGlobalOnLayoutListener(this);
        }
    }

    protected JSONObject m7639i() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("afmaVersion", this.f4229b.m7649b()).put("activeViewJSON", this.f4229b.m7650c()).put("timestamp", C1319u.m7187i().mo1724b()).put("adFormat", this.f4229b.m7648a()).put("hashCode", this.f4229b.m7651d()).put("isMraid", this.f4229b.m7652e()).put("isStopped", this.f4241n).put("isPaused", this.f4240m).put("isScreenOn", m7642l()).put("isNative", this.f4229b.m7653f());
        return jSONObject;
    }

    protected abstract boolean mo1264j();

    protected JSONObject m7641k() {
        return m7639i().put("isAttachedToWindow", false).put("isScreenOn", m7642l()).put("isVisible", false);
    }

    boolean m7642l() {
        return this.f4236i.isScreenOn();
    }

    protected JSONObject m7643m() {
        JSONObject i = m7639i();
        i.put("doneReasonCode", "u");
        return i;
    }

    public void m7644n() {
        synchronized (this.f4228a) {
            this.f4241n = true;
            m7622a(3);
        }
    }

    public void m7645o() {
        synchronized (this.f4228a) {
            this.f4240m = true;
            m7622a(3);
        }
    }

    public void onGlobalLayout() {
        m7622a(2);
    }

    public void onScrollChanged() {
        m7622a(1);
    }

    public void m7646p() {
        synchronized (this.f4228a) {
            this.f4240m = false;
            m7622a(3);
        }
    }
}
