package com.google.android.gms.p031b;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.MutableContextWrapper;
import android.graphics.Canvas;
import android.net.Uri;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.WindowManager;
import android.webkit.DownloadListener;
import android.webkit.ValueCallback;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.ads.internal.C1049s;
import com.google.android.gms.ads.internal.C1122d;
import com.google.android.gms.ads.internal.C1319u;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.C1120y;
import com.google.android.gms.ads.internal.overlay.C1201d;
import com.google.android.gms.ads.internal.util.client.C1324b;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.util.C1979l;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

@id
class le extends WebView implements OnGlobalLayoutListener, DownloadListener, la {
    private km f5708A;
    private int f5709B = -1;
    private int f5710C = -1;
    private int f5711D = -1;
    private int f5712E = -1;
    private Map<String, eq> f5713F;
    private final WindowManager f5714G;
    boolean f5715a = false;
    private final C1695a f5716b;
    private final Object f5717c = new Object();
    private final aj f5718d;
    private final VersionInfoParcel f5719e;
    private final C1049s f5720f;
    private final C1122d f5721g;
    private lb f5722h;
    private C1201d f5723i;
    private AdSizeParcel f5724j;
    private boolean f5725k;
    private boolean f5726l;
    private boolean f5727m;
    private boolean f5728n;
    private Boolean f5729o;
    private int f5730p;
    private boolean f5731q = true;
    private String f5732r = "";
    private lf f5733s;
    private boolean f5734t;
    private cw f5735u;
    private cw f5736v;
    private cw f5737w;
    private cx f5738x;
    private WeakReference<OnClickListener> f5739y;
    private C1201d f5740z;

    class C16941 implements Runnable {
        final /* synthetic */ le f5704a;

        C16941(le leVar) {
            this.f5704a = leVar;
        }

        public void run() {
            super.destroy();
        }
    }

    @id
    public static class C1695a extends MutableContextWrapper {
        private Activity f5705a;
        private Context f5706b;
        private Context f5707c;

        public C1695a(Context context) {
            super(context);
            setBaseContext(context);
        }

        public Activity m9533a() {
            return this.f5705a;
        }

        public Context m9534b() {
            return this.f5707c;
        }

        public Object getSystemService(String str) {
            return this.f5707c.getSystemService(str);
        }

        public void setBaseContext(Context context) {
            this.f5706b = context.getApplicationContext();
            this.f5705a = context instanceof Activity ? (Activity) context : null;
            this.f5707c = context;
            super.setBaseContext(this.f5706b);
        }

        public void startActivity(Intent intent) {
            if (this.f5705a != null) {
                this.f5705a.startActivity(intent);
                return;
            }
            intent.setFlags(268435456);
            this.f5706b.startActivity(intent);
        }
    }

    protected le(C1695a c1695a, AdSizeParcel adSizeParcel, boolean z, boolean z2, aj ajVar, VersionInfoParcel versionInfoParcel, cy cyVar, C1049s c1049s, C1122d c1122d) {
        super(c1695a);
        this.f5716b = c1695a;
        this.f5724j = adSizeParcel;
        this.f5727m = z;
        this.f5730p = -1;
        this.f5718d = ajVar;
        this.f5719e = versionInfoParcel;
        this.f5720f = c1049s;
        this.f5721g = c1122d;
        this.f5714G = (WindowManager) getContext().getSystemService("window");
        setBackgroundColor(0);
        WebSettings settings = getSettings();
        settings.setAllowFileAccess(false);
        settings.setJavaScriptEnabled(true);
        settings.setSavePassword(false);
        settings.setSupportMultipleWindows(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        if (VERSION.SDK_INT >= 21) {
            settings.setMixedContentMode(2);
        }
        C1319u.m7183e().m9215a((Context) c1695a, versionInfoParcel.f3957b, settings);
        C1319u.m7185g().mo1468a(getContext(), settings);
        setDownloadListener(this);
        m9537J();
        if (C1979l.m11112f()) {
            addJavascriptInterface(new lg(this), "googleAdsJsInterface");
        }
        if (C1979l.m11106a()) {
            removeJavascriptInterface("accessibility");
            removeJavascriptInterface("accessibilityTraversal");
        }
        this.f5708A = new km(this.f5716b.m9533a(), this, this, null);
        m9543a(cyVar);
    }

    private void m9535H() {
        synchronized (this.f5717c) {
            this.f5729o = C1319u.m7186h().m9131j();
            if (this.f5729o == null) {
                try {
                    evaluateJavascript("(function(){})()", null);
                    m9561a(Boolean.valueOf(true));
                } catch (IllegalStateException e) {
                    m9561a(Boolean.valueOf(false));
                }
            }
        }
    }

    private void m9536I() {
        cu.m7848a(this.f5738x.m7858a(), this.f5736v, "aeh2");
    }

    private void m9537J() {
        synchronized (this.f5717c) {
            if (this.f5727m || this.f5724j.f3107e) {
                if (VERSION.SDK_INT < 14) {
                    C1324b.m7227a("Disabling hardware acceleration on an overlay.");
                    m9538K();
                } else {
                    C1324b.m7227a("Enabling hardware acceleration on an overlay.");
                    m9539L();
                }
            } else if (VERSION.SDK_INT < 18) {
                C1324b.m7227a("Disabling hardware acceleration on an AdView.");
                m9538K();
            } else {
                C1324b.m7227a("Enabling hardware acceleration on an AdView.");
                m9539L();
            }
        }
    }

    private void m9538K() {
        synchronized (this.f5717c) {
            if (!this.f5728n) {
                C1319u.m7185g().mo1472c((View) this);
            }
            this.f5728n = true;
        }
    }

    private void m9539L() {
        synchronized (this.f5717c) {
            if (this.f5728n) {
                C1319u.m7185g().mo1470b((View) this);
            }
            this.f5728n = false;
        }
    }

    private void m9540M() {
        synchronized (this.f5717c) {
            this.f5713F = null;
        }
    }

    private void m9541N() {
        if (this.f5738x != null) {
            cy a = this.f5738x.m7858a();
            if (a != null && C1319u.m7186h().m9126e() != null) {
                C1319u.m7186h().m9126e().m7843a(a);
            }
        }
    }

    static le m9542a(Context context, AdSizeParcel adSizeParcel, boolean z, boolean z2, aj ajVar, VersionInfoParcel versionInfoParcel, cy cyVar, C1049s c1049s, C1122d c1122d) {
        return new le(new C1695a(context), adSizeParcel, z, z2, ajVar, versionInfoParcel, cyVar, c1049s, c1122d);
    }

    private void m9543a(cy cyVar) {
        m9541N();
        this.f5738x = new cx(new cy(true, "make_wv", this.f5724j.f3104b));
        this.f5738x.m7858a().m7863a(cyVar);
        this.f5736v = cu.m7845a(this.f5738x.m7858a());
        this.f5738x.m7859a("native:view_create", this.f5736v);
        this.f5737w = null;
        this.f5735u = null;
    }

    private void m9545d(boolean z) {
        Map hashMap = new HashMap();
        hashMap.put("isVisible", z ? "1" : "0");
        mo1501a("onAdVisibilityChanged", hashMap);
    }

    public void mo1489A() {
        this.f5708A.m9355a();
    }

    public void mo976B() {
        synchronized (this.f5717c) {
            this.f5715a = true;
            if (this.f5720f != null) {
                this.f5720f.mo976B();
            }
        }
    }

    public void mo977C() {
        synchronized (this.f5717c) {
            this.f5715a = false;
            if (this.f5720f != null) {
                this.f5720f.mo977C();
            }
        }
    }

    public void mo1490D() {
        if (this.f5737w == null) {
            this.f5737w = cu.m7845a(this.f5738x.m7858a());
            this.f5738x.m7859a("native:view_load", this.f5737w);
        }
    }

    public OnClickListener mo1491E() {
        return (OnClickListener) this.f5739y.get();
    }

    public boolean m9551F() {
        if (!mo1519l().m9472b()) {
            return false;
        }
        int i;
        int i2;
        DisplayMetrics a = C1319u.m7183e().m9199a(this.f5714G);
        int b = C1120y.m6293a().m7221b(a, a.widthPixels);
        int b2 = C1120y.m6293a().m7221b(a, a.heightPixels);
        Activity f = mo1513f();
        if (f == null || f.getWindow() == null) {
            i = b2;
            i2 = b;
        } else {
            int[] a2 = C1319u.m7183e().m9230a(f);
            i2 = C1120y.m6293a().m7221b(a, a2[0]);
            i = C1120y.m6293a().m7221b(a, a2[1]);
        }
        if (this.f5710C == b && this.f5709B == b2 && this.f5711D == i2 && this.f5712E == i) {
            return false;
        }
        boolean z = (this.f5710C == b && this.f5709B == b2) ? false : true;
        this.f5710C = b;
        this.f5709B = b2;
        this.f5711D = i2;
        this.f5712E = i;
        new gu(this).m8634a(b, b2, i2, i, a.density, this.f5714G.getDefaultDisplay().getRotation());
        return z;
    }

    Boolean m9552G() {
        Boolean bool;
        synchronized (this.f5717c) {
            bool = this.f5729o;
        }
        return bool;
    }

    public WebView mo1492a() {
        return this;
    }

    public void mo1493a(int i) {
        m9536I();
        Map hashMap = new HashMap(2);
        hashMap.put("closetype", String.valueOf(i));
        hashMap.put("version", this.f5719e.f3957b);
        mo1501a("onhide", hashMap);
    }

    public void mo1494a(Context context) {
        this.f5716b.setBaseContext(context);
        this.f5708A.m9356a(this.f5716b.m9533a());
    }

    public void mo1495a(Context context, AdSizeParcel adSizeParcel, cy cyVar) {
        synchronized (this.f5717c) {
            this.f5708A.m9357b();
            mo1494a(context);
            this.f5723i = null;
            this.f5724j = adSizeParcel;
            this.f5727m = false;
            this.f5725k = false;
            this.f5732r = "";
            this.f5730p = -1;
            C1319u.m7185g().m9277b((la) this);
            loadUrl("about:blank");
            this.f5722h.m9477g();
            setOnTouchListener(null);
            setOnClickListener(null);
            this.f5731q = true;
            this.f5715a = false;
            this.f5733s = null;
            m9543a(cyVar);
            this.f5734t = false;
            C1319u.m7202x().m8058a((la) this);
            m9540M();
        }
    }

    public void mo1496a(AdSizeParcel adSizeParcel) {
        synchronized (this.f5717c) {
            this.f5724j = adSizeParcel;
            requestLayout();
        }
    }

    public void mo1497a(C1201d c1201d) {
        synchronized (this.f5717c) {
            this.f5723i = c1201d;
        }
    }

    public void mo1498a(bq bqVar, boolean z) {
        synchronized (this.f5717c) {
            this.f5734t = z;
        }
        m9545d(z);
    }

    public void mo1499a(lf lfVar) {
        synchronized (this.f5717c) {
            if (this.f5733s != null) {
                C1324b.m7230b("Attempt to create multiple AdWebViewVideoControllers.");
                return;
            }
            this.f5733s = lfVar;
        }
    }

    void m9561a(Boolean bool) {
        synchronized (this.f5717c) {
            this.f5729o = bool;
        }
        C1319u.m7186h().m9114a(bool);
    }

    public void mo1500a(String str) {
        synchronized (this.f5717c) {
            try {
                super.loadUrl(str);
            } catch (Throwable th) {
                String valueOf = String.valueOf(th);
                C1324b.m7234d(new StringBuilder(String.valueOf(valueOf).length() + 24).append("Could not call loadUrl. ").append(valueOf).toString());
            }
        }
    }

    @TargetApi(19)
    protected void m9563a(String str, ValueCallback<String> valueCallback) {
        synchronized (this.f5717c) {
            if (mo1530r()) {
                C1324b.m7234d("The webview is destroyed. Ignoring action.");
                if (valueCallback != null) {
                    valueCallback.onReceiveValue(null);
                }
            } else {
                evaluateJavascript(str, valueCallback);
            }
        }
    }

    public void mo1319a(String str, eb ebVar) {
        if (this.f5722h != null) {
            this.f5722h.m9466a(str, ebVar);
        }
    }

    public void mo1320a(String str, String str2) {
        m9580d(new StringBuilder((String.valueOf(str).length() + 3) + String.valueOf(str2).length()).append(str).append("(").append(str2).append(");").toString());
    }

    public void mo1501a(String str, Map<String, ?> map) {
        try {
            mo1325b(str, C1319u.m7183e().m9211a((Map) map));
        } catch (JSONException e) {
            C1324b.m7234d("Could not convert parameters to JSON.");
        }
    }

    public void mo1321a(String str, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        mo1320a(str, jSONObject.toString());
    }

    public void mo1502a(boolean z) {
        synchronized (this.f5717c) {
            this.f5727m = z;
            m9537J();
        }
    }

    public View mo1503b() {
        return this;
    }

    public void mo1504b(int i) {
        synchronized (this.f5717c) {
            this.f5730p = i;
            if (this.f5723i != null) {
                this.f5723i.m6654a(this.f5730p);
            }
        }
    }

    public void mo1505b(C1201d c1201d) {
        synchronized (this.f5717c) {
            this.f5740z = c1201d;
        }
    }

    public void mo1506b(String str) {
        synchronized (this.f5717c) {
            if (str == null) {
                str = "";
            }
            this.f5732r = str;
        }
    }

    public void mo1324b(String str, eb ebVar) {
        if (this.f5722h != null) {
            this.f5722h.m9471b(str, ebVar);
        }
    }

    public void mo1325b(String str, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String jSONObject2 = jSONObject.toString();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("AFMA_ReceiveMessage('");
        stringBuilder.append(str);
        stringBuilder.append("'");
        stringBuilder.append(",");
        stringBuilder.append(jSONObject2);
        stringBuilder.append(");");
        String str2 = "Dispatching AFMA event: ";
        jSONObject2 = String.valueOf(stringBuilder.toString());
        jv.m9152e(jSONObject2.length() != 0 ? str2.concat(jSONObject2) : new String(str2));
        m9580d(stringBuilder.toString());
    }

    public void mo1507b(boolean z) {
        synchronized (this.f5717c) {
            if (this.f5723i != null) {
                this.f5723i.m6660a(this.f5722h.m9472b(), z);
            } else {
                this.f5725k = z;
            }
        }
    }

    public void mo1508c() {
        m9536I();
        Map hashMap = new HashMap(1);
        hashMap.put("version", this.f5719e.f3957b);
        mo1501a("onhide", hashMap);
    }

    protected void m9577c(String str) {
        synchronized (this.f5717c) {
            if (mo1530r()) {
                C1324b.m7234d("The webview is destroyed. Ignoring action.");
            } else {
                loadUrl(str);
            }
        }
    }

    public void mo1509c(boolean z) {
        synchronized (this.f5717c) {
            this.f5731q = z;
        }
    }

    public void mo1510d() {
        if (this.f5735u == null) {
            cu.m7848a(this.f5738x.m7858a(), this.f5737w, "aes");
            this.f5735u = cu.m7845a(this.f5738x.m7858a());
            this.f5738x.m7859a("native:view_show", this.f5735u);
        }
        Map hashMap = new HashMap(1);
        hashMap.put("version", this.f5719e.f3957b);
        mo1501a("onshow", hashMap);
    }

    protected void m9580d(String str) {
        if (C1979l.m11114h()) {
            if (m9552G() == null) {
                m9535H();
            }
            if (m9552G().booleanValue()) {
                m9563a(str, null);
                return;
            }
            String str2 = "javascript:";
            String valueOf = String.valueOf(str);
            m9577c(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
            return;
        }
        str2 = "javascript:";
        valueOf = String.valueOf(str);
        m9577c(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
    }

    public void destroy() {
        synchronized (this.f5717c) {
            m9541N();
            this.f5708A.m9357b();
            if (this.f5723i != null) {
                this.f5723i.m6653a();
                this.f5723i.mo1144k();
                this.f5723i = null;
            }
            this.f5722h.m9477g();
            if (this.f5726l) {
                return;
            }
            C1319u.m7202x().m8058a((la) this);
            m9540M();
            this.f5726l = true;
            jv.m9152e("Initiating WebView self destruct sequence in 3...");
            this.f5722h.m9474d();
        }
    }

    public void mo1512e() {
        Map hashMap = new HashMap(3);
        hashMap.put("app_muted", String.valueOf(C1319u.m7183e().m9252h()));
        hashMap.put("app_volume", String.valueOf(C1319u.m7183e().m9249g()));
        hashMap.put("device_volume", String.valueOf(C1319u.m7183e().m9255j(getContext())));
        mo1501a("volume", hashMap);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    @android.annotation.TargetApi(19)
    public void evaluateJavascript(java.lang.String r3, android.webkit.ValueCallback<java.lang.String> r4) {
        /*
        r2 = this;
        r1 = r2.f5717c;
        monitor-enter(r1);
        r0 = r2.mo1530r();	 Catch:{ all -> 0x001b }
        if (r0 == 0) goto L_0x0016;
    L_0x0009:
        r0 = "The webview is destroyed. Ignoring action.";
        com.google.android.gms.ads.internal.util.client.C1324b.m7234d(r0);	 Catch:{ all -> 0x001b }
        if (r4 == 0) goto L_0x0014;
    L_0x0010:
        r0 = 0;
        r4.onReceiveValue(r0);	 Catch:{ all -> 0x001b }
    L_0x0014:
        monitor-exit(r1);	 Catch:{ all -> 0x001b }
    L_0x0015:
        return;
    L_0x0016:
        super.evaluateJavascript(r3, r4);	 Catch:{ all -> 0x001b }
        monitor-exit(r1);	 Catch:{ all -> 0x001b }
        goto L_0x0015;
    L_0x001b:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x001b }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.b.le.evaluateJavascript(java.lang.String, android.webkit.ValueCallback):void");
    }

    public Activity mo1513f() {
        return this.f5716b.m9533a();
    }

    protected void finalize() {
        synchronized (this.f5717c) {
            if (!this.f5726l) {
                this.f5722h.m9477g();
                C1319u.m7202x().m8058a((la) this);
                m9540M();
            }
        }
        super.finalize();
    }

    public Context mo1514g() {
        return this.f5716b.m9534b();
    }

    public C1122d mo1515h() {
        return this.f5721g;
    }

    public C1201d mo1516i() {
        C1201d c1201d;
        synchronized (this.f5717c) {
            c1201d = this.f5723i;
        }
        return c1201d;
    }

    public C1201d mo1517j() {
        C1201d c1201d;
        synchronized (this.f5717c) {
            c1201d = this.f5740z;
        }
        return c1201d;
    }

    public AdSizeParcel mo1518k() {
        AdSizeParcel adSizeParcel;
        synchronized (this.f5717c) {
            adSizeParcel = this.f5724j;
        }
        return adSizeParcel;
    }

    public lb mo1519l() {
        return this.f5722h;
    }

    public void loadData(String str, String str2, String str3) {
        synchronized (this.f5717c) {
            if (mo1530r()) {
                C1324b.m7234d("The webview is destroyed. Ignoring action.");
            } else {
                super.loadData(str, str2, str3);
            }
        }
    }

    public void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        synchronized (this.f5717c) {
            if (mo1530r()) {
                C1324b.m7234d("The webview is destroyed. Ignoring action.");
            } else {
                super.loadDataWithBaseURL(str, str2, str3, str4, str5);
            }
        }
    }

    public void loadUrl(String str) {
        synchronized (this.f5717c) {
            if (mo1530r()) {
                C1324b.m7234d("The webview is destroyed. Ignoring action.");
            } else {
                try {
                    super.loadUrl(str);
                } catch (Throwable th) {
                    String valueOf = String.valueOf(th);
                    C1324b.m7234d(new StringBuilder(String.valueOf(valueOf).length() + 24).append("Could not call loadUrl. ").append(valueOf).toString());
                }
            }
        }
    }

    public boolean mo1523m() {
        boolean z;
        synchronized (this.f5717c) {
            z = this.f5725k;
        }
        return z;
    }

    public aj mo1524n() {
        return this.f5718d;
    }

    public VersionInfoParcel mo1525o() {
        return this.f5719e;
    }

    protected void onAttachedToWindow() {
        synchronized (this.f5717c) {
            super.onAttachedToWindow();
            if (!mo1530r()) {
                this.f5708A.m9358c();
            }
            m9545d(this.f5734t);
        }
    }

    protected void onDetachedFromWindow() {
        synchronized (this.f5717c) {
            if (!mo1530r()) {
                this.f5708A.m9359d();
            }
            super.onDetachedFromWindow();
        }
        m9545d(false);
    }

    public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setDataAndType(Uri.parse(str), str4);
            C1319u.m7183e().m9214a(getContext(), intent);
        } catch (ActivityNotFoundException e) {
            C1324b.m7227a(new StringBuilder((String.valueOf(str).length() + 51) + String.valueOf(str4).length()).append("Couldn't find an Activity to view url/mimetype: ").append(str).append(" / ").append(str4).toString());
        }
    }

    @TargetApi(21)
    protected void onDraw(Canvas canvas) {
        if (!mo1530r()) {
            if (VERSION.SDK_INT != 21 || !canvas.isHardwareAccelerated() || isAttachedToWindow()) {
                super.onDraw(canvas);
                if (mo1519l() != null && mo1519l().m9478h() != null) {
                    mo1519l().m9478h().mo1046a();
                }
            }
        }
    }

    public void onGlobalLayout() {
        boolean F = m9551F();
        C1201d i = mo1516i();
        if (i != null && F) {
            i.m6677o();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected void onMeasure(int r10, int r11) {
        /*
        r9 = this;
        r0 = 2147483647; // 0x7fffffff float:NaN double:1.060997895E-314;
        r8 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r7 = 8;
        r6 = -2147483648; // 0xffffffff80000000 float:-0.0 double:NaN;
        r4 = r9.f5717c;
        monitor-enter(r4);
        r1 = r9.mo1530r();	 Catch:{ all -> 0x0034 }
        if (r1 == 0) goto L_0x0019;
    L_0x0012:
        r0 = 0;
        r1 = 0;
        r9.setMeasuredDimension(r0, r1);	 Catch:{ all -> 0x0034 }
        monitor-exit(r4);	 Catch:{ all -> 0x0034 }
    L_0x0018:
        return;
    L_0x0019:
        r1 = r9.isInEditMode();	 Catch:{ all -> 0x0034 }
        if (r1 != 0) goto L_0x002f;
    L_0x001f:
        r1 = r9.f5727m;	 Catch:{ all -> 0x0034 }
        if (r1 != 0) goto L_0x002f;
    L_0x0023:
        r1 = r9.f5724j;	 Catch:{ all -> 0x0034 }
        r1 = r1.f3111i;	 Catch:{ all -> 0x0034 }
        if (r1 != 0) goto L_0x002f;
    L_0x0029:
        r1 = r9.f5724j;	 Catch:{ all -> 0x0034 }
        r1 = r1.f3112j;	 Catch:{ all -> 0x0034 }
        if (r1 == 0) goto L_0x0037;
    L_0x002f:
        super.onMeasure(r10, r11);	 Catch:{ all -> 0x0034 }
        monitor-exit(r4);	 Catch:{ all -> 0x0034 }
        goto L_0x0018;
    L_0x0034:
        r0 = move-exception;
        monitor-exit(r4);	 Catch:{ all -> 0x0034 }
        throw r0;
    L_0x0037:
        r1 = r9.f5724j;	 Catch:{ all -> 0x0034 }
        r1 = r1.f3107e;	 Catch:{ all -> 0x0034 }
        if (r1 == 0) goto L_0x0054;
    L_0x003d:
        r0 = new android.util.DisplayMetrics;	 Catch:{ all -> 0x0034 }
        r0.<init>();	 Catch:{ all -> 0x0034 }
        r1 = r9.f5714G;	 Catch:{ all -> 0x0034 }
        r1 = r1.getDefaultDisplay();	 Catch:{ all -> 0x0034 }
        r1.getMetrics(r0);	 Catch:{ all -> 0x0034 }
        r1 = r0.widthPixels;	 Catch:{ all -> 0x0034 }
        r0 = r0.heightPixels;	 Catch:{ all -> 0x0034 }
        r9.setMeasuredDimension(r1, r0);	 Catch:{ all -> 0x0034 }
        monitor-exit(r4);	 Catch:{ all -> 0x0034 }
        goto L_0x0018;
    L_0x0054:
        r2 = android.view.View.MeasureSpec.getMode(r10);	 Catch:{ all -> 0x0034 }
        r3 = android.view.View.MeasureSpec.getSize(r10);	 Catch:{ all -> 0x0034 }
        r5 = android.view.View.MeasureSpec.getMode(r11);	 Catch:{ all -> 0x0034 }
        r1 = android.view.View.MeasureSpec.getSize(r11);	 Catch:{ all -> 0x0034 }
        if (r2 == r6) goto L_0x0068;
    L_0x0066:
        if (r2 != r8) goto L_0x00ff;
    L_0x0068:
        r2 = r3;
    L_0x0069:
        if (r5 == r6) goto L_0x006d;
    L_0x006b:
        if (r5 != r8) goto L_0x006e;
    L_0x006d:
        r0 = r1;
    L_0x006e:
        r5 = r9.f5724j;	 Catch:{ all -> 0x0034 }
        r5 = r5.f3109g;	 Catch:{ all -> 0x0034 }
        if (r5 > r2) goto L_0x007a;
    L_0x0074:
        r2 = r9.f5724j;	 Catch:{ all -> 0x0034 }
        r2 = r2.f3106d;	 Catch:{ all -> 0x0034 }
        if (r2 <= r0) goto L_0x00e9;
    L_0x007a:
        r0 = r9.f5716b;	 Catch:{ all -> 0x0034 }
        r0 = r0.getResources();	 Catch:{ all -> 0x0034 }
        r0 = r0.getDisplayMetrics();	 Catch:{ all -> 0x0034 }
        r0 = r0.density;	 Catch:{ all -> 0x0034 }
        r2 = r9.f5724j;	 Catch:{ all -> 0x0034 }
        r2 = r2.f3109g;	 Catch:{ all -> 0x0034 }
        r2 = (float) r2;	 Catch:{ all -> 0x0034 }
        r2 = r2 / r0;
        r2 = (int) r2;	 Catch:{ all -> 0x0034 }
        r5 = r9.f5724j;	 Catch:{ all -> 0x0034 }
        r5 = r5.f3106d;	 Catch:{ all -> 0x0034 }
        r5 = (float) r5;	 Catch:{ all -> 0x0034 }
        r5 = r5 / r0;
        r5 = (int) r5;	 Catch:{ all -> 0x0034 }
        r3 = (float) r3;	 Catch:{ all -> 0x0034 }
        r3 = r3 / r0;
        r3 = (int) r3;	 Catch:{ all -> 0x0034 }
        r1 = (float) r1;	 Catch:{ all -> 0x0034 }
        r0 = r1 / r0;
        r0 = (int) r0;	 Catch:{ all -> 0x0034 }
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0034 }
        r6 = 103; // 0x67 float:1.44E-43 double:5.1E-322;
        r1.<init>(r6);	 Catch:{ all -> 0x0034 }
        r6 = "Not enough space to show ad. Needs ";
        r1 = r1.append(r6);	 Catch:{ all -> 0x0034 }
        r1 = r1.append(r2);	 Catch:{ all -> 0x0034 }
        r2 = "x";
        r1 = r1.append(r2);	 Catch:{ all -> 0x0034 }
        r1 = r1.append(r5);	 Catch:{ all -> 0x0034 }
        r2 = " dp, but only has ";
        r1 = r1.append(r2);	 Catch:{ all -> 0x0034 }
        r1 = r1.append(r3);	 Catch:{ all -> 0x0034 }
        r2 = "x";
        r1 = r1.append(r2);	 Catch:{ all -> 0x0034 }
        r0 = r1.append(r0);	 Catch:{ all -> 0x0034 }
        r1 = " dp.";
        r0 = r0.append(r1);	 Catch:{ all -> 0x0034 }
        r0 = r0.toString();	 Catch:{ all -> 0x0034 }
        com.google.android.gms.ads.internal.util.client.C1324b.m7234d(r0);	 Catch:{ all -> 0x0034 }
        r0 = r9.getVisibility();	 Catch:{ all -> 0x0034 }
        if (r0 == r7) goto L_0x00e1;
    L_0x00dd:
        r0 = 4;
        r9.setVisibility(r0);	 Catch:{ all -> 0x0034 }
    L_0x00e1:
        r0 = 0;
        r1 = 0;
        r9.setMeasuredDimension(r0, r1);	 Catch:{ all -> 0x0034 }
    L_0x00e6:
        monitor-exit(r4);	 Catch:{ all -> 0x0034 }
        goto L_0x0018;
    L_0x00e9:
        r0 = r9.getVisibility();	 Catch:{ all -> 0x0034 }
        if (r0 == r7) goto L_0x00f3;
    L_0x00ef:
        r0 = 0;
        r9.setVisibility(r0);	 Catch:{ all -> 0x0034 }
    L_0x00f3:
        r0 = r9.f5724j;	 Catch:{ all -> 0x0034 }
        r0 = r0.f3109g;	 Catch:{ all -> 0x0034 }
        r1 = r9.f5724j;	 Catch:{ all -> 0x0034 }
        r1 = r1.f3106d;	 Catch:{ all -> 0x0034 }
        r9.setMeasuredDimension(r0, r1);	 Catch:{ all -> 0x0034 }
        goto L_0x00e6;
    L_0x00ff:
        r2 = r0;
        goto L_0x0069;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.b.le.onMeasure(int, int):void");
    }

    public void onPause() {
        if (!mo1530r()) {
            try {
                if (C1979l.m11106a()) {
                    super.onPause();
                }
            } catch (Throwable e) {
                C1324b.m7231b("Could not pause webview.", e);
            }
        }
    }

    public void onResume() {
        if (!mo1530r()) {
            try {
                if (C1979l.m11106a()) {
                    super.onResume();
                }
            } catch (Throwable e) {
                C1324b.m7231b("Could not resume webview.", e);
            }
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f5718d != null) {
            this.f5718d.m7433a(motionEvent);
        }
        return mo1530r() ? false : super.onTouchEvent(motionEvent);
    }

    public boolean mo1528p() {
        boolean z;
        synchronized (this.f5717c) {
            z = this.f5727m;
        }
        return z;
    }

    public int mo1529q() {
        int i;
        synchronized (this.f5717c) {
            i = this.f5730p;
        }
        return i;
    }

    public boolean mo1530r() {
        boolean z;
        synchronized (this.f5717c) {
            z = this.f5726l;
        }
        return z;
    }

    public void mo1531s() {
        synchronized (this.f5717c) {
            jv.m9152e("Destroying WebView!");
            jz.f5567a.post(new C16941(this));
        }
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        this.f5739y = new WeakReference(onClickListener);
        super.setOnClickListener(onClickListener);
    }

    public void setWebViewClient(WebViewClient webViewClient) {
        super.setWebViewClient(webViewClient);
        if (webViewClient instanceof lb) {
            this.f5722h = (lb) webViewClient;
        }
    }

    public void stopLoading() {
        if (!mo1530r()) {
            try {
                super.stopLoading();
            } catch (Throwable e) {
                C1324b.m7231b("Could not stop loading webview.", e);
            }
        }
    }

    public boolean mo1538t() {
        boolean z;
        synchronized (this.f5717c) {
            cu.m7848a(this.f5738x.m7858a(), this.f5736v, "aebb2");
            z = this.f5731q;
        }
        return z;
    }

    public boolean mo1539u() {
        boolean z;
        synchronized (this.f5717c) {
            z = this.f5715a;
        }
        return z;
    }

    public String mo1540v() {
        String str;
        synchronized (this.f5717c) {
            str = this.f5732r;
        }
        return str;
    }

    public kz mo1541w() {
        return null;
    }

    public cw mo1542x() {
        return this.f5737w;
    }

    public cx mo1543y() {
        return this.f5738x;
    }

    public lf mo1544z() {
        lf lfVar;
        synchronized (this.f5717c) {
            lfVar = this.f5733s;
        }
        return lfVar;
    }
}
