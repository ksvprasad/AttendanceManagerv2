package com.google.android.gms.p031b;

import android.content.Context;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.ads.internal.C1123e;
import com.google.android.gms.ads.internal.C1319u;
import com.google.android.gms.ads.internal.client.C0971a;
import com.google.android.gms.ads.internal.overlay.AdLauncherIntentInfoParcel;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.C1040p;
import com.google.android.gms.ads.internal.overlay.C1047g;
import com.google.android.gms.ads.internal.overlay.C1201d;
import com.google.android.gms.ads.internal.overlay.C1202e;
import com.google.android.gms.ads.internal.util.client.C1324b;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

@id
public class lb extends WebViewClient {
    private static final String[] f5676c = new String[]{"UNKNOWN", "HOST_LOOKUP", "UNSUPPORTED_AUTH_SCHEME", "AUTHENTICATION", "PROXY_AUTHENTICATION", "CONNECT", "IO", "TIMEOUT", "REDIRECT_LOOP", "UNSUPPORTED_SCHEME", "FAILED_SSL_HANDSHAKE", "BAD_URL", "FILE", "FILE_NOT_FOUND", "TOO_MANY_REQUESTS"};
    private static final String[] f5677d = new String[]{"NOT_YET_VALID", "EXPIRED", "ID_MISMATCH", "UNTRUSTED", "DATE_INVALID", "INVALID"};
    protected la f5678a;
    protected jf f5679b;
    private final HashMap<String, List<eb>> f5680e;
    private final Object f5681f;
    private C0971a f5682g;
    private C1047g f5683h;
    private C1148a f5684i;
    private dx f5685j;
    private C1127b f5686k;
    private boolean f5687l;
    private ed f5688m;
    private ef f5689n;
    private boolean f5690o;
    private boolean f5691p;
    private C1040p f5692q;
    private final gt f5693r;
    private C1123e f5694s;
    private gp f5695t;
    private gv f5696u;
    private C1125d f5697v;
    private boolean f5698w;
    private boolean f5699x;
    private boolean f5700y;
    private int f5701z;

    public interface C1125d {
        void mo1046a();
    }

    public interface C1127b {
        void mo1047a();
    }

    public interface C1148a {
        void mo1096a(la laVar, boolean z);
    }

    class C16901 implements Runnable {
        final /* synthetic */ lb f5671a;

        C16901(lb lbVar) {
            this.f5671a = lbVar;
        }

        public void run() {
            if (this.f5671a.f5679b != null) {
                this.f5671a.f5679b.m9075a(this.f5671a.f5678a.mo1503b());
            }
        }
    }

    class C16912 implements Runnable {
        final /* synthetic */ lb f5672a;

        C16912(lb lbVar) {
            this.f5672a = lbVar;
        }

        public void run() {
            this.f5672a.f5678a.mo1489A();
            C1201d i = this.f5672a.f5678a.mo1516i();
            if (i != null) {
                i.m6675m();
            }
            if (this.f5672a.f5686k != null) {
                this.f5672a.f5686k.mo1047a();
                this.f5672a.f5686k = null;
            }
        }
    }

    private static class C1692c implements C1047g {
        private la f5673a;
        private C1047g f5674b;

        public C1692c(la laVar, C1047g c1047g) {
            this.f5673a = laVar;
            this.f5674b = c1047g;
        }

        public void d_() {
            this.f5674b.d_();
            this.f5673a.mo1508c();
        }

        public void e_() {
            this.f5674b.e_();
            this.f5673a.mo1510d();
        }

        public void f_() {
        }

        public void mo988g() {
        }
    }

    private class C1693e implements eb {
        final /* synthetic */ lb f5675a;

        private C1693e(lb lbVar) {
            this.f5675a = lbVar;
        }

        public void mo997a(la laVar, Map<String, String> map) {
            if (map.keySet().contains("start")) {
                this.f5675a.m9452j();
            } else if (map.keySet().contains("stop")) {
                this.f5675a.m9453k();
            } else if (map.keySet().contains("cancel")) {
                this.f5675a.m9454l();
            }
        }
    }

    public lb(la laVar, boolean z) {
        this(laVar, z, new gt(laVar, laVar.mo1514g(), new ch(laVar.getContext())), null);
    }

    lb(la laVar, boolean z, gt gtVar, gp gpVar) {
        this.f5680e = new HashMap();
        this.f5681f = new Object();
        this.f5687l = false;
        this.f5678a = laVar;
        this.f5690o = z;
        this.f5693r = gtVar;
        this.f5695t = gpVar;
    }

    private String m9445a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        Uri parse = Uri.parse(str);
        return parse.getHost() != null ? parse.getHost() : "";
    }

    private void m9446a(Context context, String str, String str2, String str3) {
        if (((Boolean) cq.ay.m7801c()).booleanValue()) {
            Bundle bundle = new Bundle();
            bundle.putString("err", str);
            bundle.putString("code", str2);
            bundle.putString("host", m9445a(str3));
            C1319u.m7183e().m9217a(context, this.f5678a.mo1525o().f3957b, "gmob-apps", bundle, true);
        }
    }

    private static boolean m9449b(Uri uri) {
        String scheme = uri.getScheme();
        return "http".equalsIgnoreCase(scheme) || "https".equalsIgnoreCase(scheme);
    }

    private void m9452j() {
        synchronized (this.f5681f) {
            this.f5691p = true;
        }
        this.f5701z++;
        m9476f();
    }

    private void m9453k() {
        this.f5701z--;
        m9476f();
    }

    private void m9454l() {
        this.f5700y = true;
        m9476f();
    }

    public C1123e m9455a() {
        return this.f5694s;
    }

    public void m9456a(int i, int i2) {
        if (this.f5695t != null) {
            this.f5695t.m8654c(i, i2);
        }
    }

    public void m9457a(int i, int i2, boolean z) {
        this.f5693r.m8677a(i, i2);
        if (this.f5695t != null) {
            this.f5695t.m8648a(i, i2, z);
        }
    }

    public void m9458a(Uri uri) {
        String path = uri.getPath();
        List<eb> list = (List) this.f5680e.get(path);
        if (list != null) {
            Map a = C1319u.m7183e().m9209a(uri);
            if (C1324b.m7229a(2)) {
                String str = "Received GMSG: ";
                path = String.valueOf(path);
                jv.m9152e(path.length() != 0 ? str.concat(path) : new String(str));
                for (String path2 : a.keySet()) {
                    str = (String) a.get(path2);
                    jv.m9152e(new StringBuilder((String.valueOf(path2).length() + 4) + String.valueOf(str).length()).append("  ").append(path2).append(": ").append(str).toString());
                }
            }
            for (eb a2 : list) {
                a2.mo997a(this.f5678a, a);
            }
            return;
        }
        String valueOf = String.valueOf(uri);
        jv.m9152e(new StringBuilder(String.valueOf(valueOf).length() + 32).append("No GMSG handler found for GMSG: ").append(valueOf).toString());
    }

    public void m9459a(C0971a c0971a, C1047g c1047g, dx dxVar, C1040p c1040p, boolean z, ed edVar, ef efVar, C1123e c1123e, gv gvVar, jf jfVar) {
        if (c1123e == null) {
            c1123e = new C1123e(this.f5678a.getContext());
        }
        this.f5695t = new gp(this.f5678a, gvVar);
        this.f5679b = jfVar;
        m9466a("/appEvent", new dw(dxVar));
        m9466a("/backButton", ea.f4503k);
        m9466a("/refresh", ea.f4504l);
        m9466a("/canOpenURLs", ea.f4494b);
        m9466a("/canOpenIntents", ea.f4495c);
        m9466a("/click", ea.f4496d);
        m9466a("/close", ea.f4497e);
        m9466a("/customClose", ea.f4499g);
        m9466a("/instrument", ea.f4508p);
        m9466a("/delayPageLoaded", new C1693e());
        m9466a("/httpTrack", ea.f4500h);
        m9466a("/log", ea.f4501i);
        m9466a("/mraid", new eh(c1123e, this.f5695t));
        m9466a("/mraidLoaded", this.f5693r);
        m9466a("/open", new ei(edVar, c1123e, this.f5695t));
        m9466a("/precache", ea.f4507o);
        m9466a("/touch", ea.f4502j);
        m9466a("/video", ea.f4505m);
        m9466a("/videoMeta", ea.f4506n);
        m9466a("/appStreaming", ea.f4498f);
        if (efVar != null) {
            m9466a("/setInterstitialProperties", new ee(efVar));
        }
        this.f5682g = c0971a;
        this.f5683h = c1047g;
        this.f5685j = dxVar;
        this.f5688m = edVar;
        this.f5692q = c1040p;
        this.f5694s = c1123e;
        this.f5696u = gvVar;
        this.f5689n = efVar;
        m9467a(z);
    }

    public final void m9460a(AdLauncherIntentInfoParcel adLauncherIntentInfoParcel) {
        C1047g c1047g = null;
        boolean p = this.f5678a.mo1528p();
        C0971a c0971a = (!p || this.f5678a.mo1518k().f3107e) ? this.f5682g : null;
        if (!p) {
            c1047g = this.f5683h;
        }
        m9461a(new AdOverlayInfoParcel(adLauncherIntentInfoParcel, c0971a, c1047g, this.f5692q, this.f5678a.mo1525o()));
    }

    public void m9461a(AdOverlayInfoParcel adOverlayInfoParcel) {
        boolean z = false;
        boolean b = this.f5695t != null ? this.f5695t.m8653b() : false;
        C1202e c = C1319u.m7181c();
        Context context = this.f5678a.getContext();
        if (!b) {
            z = true;
        }
        c.m6681a(context, adOverlayInfoParcel, z);
        if (this.f5679b != null) {
            String str = adOverlayInfoParcel.f3486m;
            if (str == null && adOverlayInfoParcel.f3475b != null) {
                str = adOverlayInfoParcel.f3475b.f3467c;
            }
            this.f5679b.m9076a(str);
        }
    }

    public void m9462a(la laVar) {
        this.f5678a = laVar;
    }

    public void m9463a(C1148a c1148a) {
        this.f5684i = c1148a;
    }

    public void m9464a(C1127b c1127b) {
        this.f5686k = c1127b;
    }

    public void m9465a(C1125d c1125d) {
        this.f5697v = c1125d;
    }

    public void m9466a(String str, eb ebVar) {
        synchronized (this.f5681f) {
            List list = (List) this.f5680e.get(str);
            if (list == null) {
                list = new CopyOnWriteArrayList();
                this.f5680e.put(str, list);
            }
            list.add(ebVar);
        }
    }

    public void m9467a(boolean z) {
        this.f5687l = z;
    }

    public final void m9468a(boolean z, int i) {
        C0971a c0971a = (!this.f5678a.mo1528p() || this.f5678a.mo1518k().f3107e) ? this.f5682g : null;
        m9461a(new AdOverlayInfoParcel(c0971a, this.f5683h, this.f5692q, this.f5678a, z, i, this.f5678a.mo1525o()));
    }

    public final void m9469a(boolean z, int i, String str) {
        C1047g c1047g = null;
        boolean p = this.f5678a.mo1528p();
        C0971a c0971a = (!p || this.f5678a.mo1518k().f3107e) ? this.f5682g : null;
        if (!p) {
            c1047g = new C1692c(this.f5678a, this.f5683h);
        }
        m9461a(new AdOverlayInfoParcel(c0971a, c1047g, this.f5685j, this.f5692q, this.f5678a, z, i, str, this.f5678a.mo1525o(), this.f5688m));
    }

    public final void m9470a(boolean z, int i, String str, String str2) {
        boolean p = this.f5678a.mo1528p();
        C0971a c0971a = (!p || this.f5678a.mo1518k().f3107e) ? this.f5682g : null;
        m9461a(new AdOverlayInfoParcel(c0971a, p ? null : new C1692c(this.f5678a, this.f5683h), this.f5685j, this.f5692q, this.f5678a, z, i, str, str2, this.f5678a.mo1525o(), this.f5688m));
    }

    public void m9471b(String str, eb ebVar) {
        synchronized (this.f5681f) {
            List list = (List) this.f5680e.get(str);
            if (list == null) {
                return;
            }
            list.remove(ebVar);
        }
    }

    public boolean m9472b() {
        boolean z;
        synchronized (this.f5681f) {
            z = this.f5690o;
        }
        return z;
    }

    public boolean m9473c() {
        boolean z;
        synchronized (this.f5681f) {
            z = this.f5691p;
        }
        return z;
    }

    public void m9474d() {
        synchronized (this.f5681f) {
            jv.m9152e("Loading blank page in WebView, 2...");
            this.f5698w = true;
            this.f5678a.mo1500a("about:blank");
        }
    }

    public void m9475e() {
        if (this.f5679b != null) {
            jz.f5567a.post(new C16901(this));
        }
    }

    public final void m9476f() {
        if (this.f5684i != null && ((this.f5699x && this.f5701z <= 0) || this.f5700y)) {
            this.f5684i.mo1096a(this.f5678a, !this.f5700y);
            this.f5684i = null;
        }
        this.f5678a.mo1490D();
    }

    public final void m9477g() {
        if (this.f5679b != null) {
            this.f5679b.m9074a();
            this.f5679b = null;
        }
        synchronized (this.f5681f) {
            this.f5680e.clear();
            this.f5682g = null;
            this.f5683h = null;
            this.f5684i = null;
            this.f5685j = null;
            this.f5687l = false;
            this.f5690o = false;
            this.f5691p = false;
            this.f5688m = null;
            this.f5692q = null;
            this.f5686k = null;
            if (this.f5695t != null) {
                this.f5695t.m8650a(true);
                this.f5695t = null;
            }
        }
    }

    public C1125d m9478h() {
        return this.f5697v;
    }

    public final void m9479i() {
        synchronized (this.f5681f) {
            this.f5687l = false;
            this.f5690o = true;
            C1319u.m7183e().m9222a(new C16912(this));
        }
    }

    public final void onLoadResource(WebView webView, String str) {
        String str2 = "Loading resource: ";
        String valueOf = String.valueOf(str);
        jv.m9152e(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
        Uri parse = Uri.parse(str);
        if ("gmsg".equalsIgnoreCase(parse.getScheme()) && "mobileads.google.com".equalsIgnoreCase(parse.getHost())) {
            m9458a(parse);
        }
    }

    public final void onPageFinished(WebView webView, String str) {
        synchronized (this.f5681f) {
            if (this.f5698w) {
                jv.m9152e("Blank page loaded, 1...");
                this.f5678a.mo1531s();
                return;
            }
            this.f5699x = true;
            m9476f();
        }
    }

    public final void onReceivedError(WebView webView, int i, String str, String str2) {
        String valueOf = (i >= 0 || (-i) - 1 >= f5676c.length) ? String.valueOf(i) : f5676c[(-i) - 1];
        m9446a(this.f5678a.getContext(), "http_err", valueOf, str2);
        super.onReceivedError(webView, i, str, str2);
    }

    public final void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        if (sslError != null) {
            int primaryError = sslError.getPrimaryError();
            String valueOf = (primaryError < 0 || primaryError >= f5677d.length) ? String.valueOf(primaryError) : f5677d[primaryError];
            m9446a(this.f5678a.getContext(), "ssl_err", valueOf, C1319u.m7185g().mo1473a(sslError));
        }
        super.onReceivedSslError(webView, sslErrorHandler, sslError);
    }

    public boolean shouldOverrideKeyEvent(WebView webView, KeyEvent keyEvent) {
        switch (keyEvent.getKeyCode()) {
            case 79:
            case 85:
            case 86:
            case 87:
            case 88:
            case 89:
            case 90:
            case 91:
            case 126:
            case 127:
            case 128:
            case 129:
            case 130:
            case 222:
                return true;
            default:
                return false;
        }
    }

    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        String str2 = "AdWebView shouldOverrideUrlLoading: ";
        String valueOf = String.valueOf(str);
        jv.m9152e(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
        Uri parse = Uri.parse(str);
        if ("gmsg".equalsIgnoreCase(parse.getScheme()) && "mobileads.google.com".equalsIgnoreCase(parse.getHost())) {
            m9458a(parse);
        } else if (this.f5687l && webView == this.f5678a.mo1492a() && lb.m9449b(parse)) {
            if (this.f5682g != null && ((Boolean) cq.f4383X.m7801c()).booleanValue()) {
                this.f5682g.mo915e();
                if (this.f5679b != null) {
                    this.f5679b.m9076a(str);
                }
                this.f5682g = null;
            }
            return super.shouldOverrideUrlLoading(webView, str);
        } else if (this.f5678a.mo1492a().willNotDraw()) {
            str2 = "AdWebView unable to handle URL: ";
            valueOf = String.valueOf(str);
            C1324b.m7234d(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
        } else {
            Uri uri;
            try {
                aj n = this.f5678a.mo1524n();
                if (n != null && n.m7439c(parse)) {
                    parse = n.m7437b(parse, this.f5678a.getContext());
                }
                uri = parse;
            } catch (ak e) {
                String str3 = "Unable to append parameter to URL: ";
                str2 = String.valueOf(str);
                C1324b.m7234d(str2.length() != 0 ? str3.concat(str2) : new String(str3));
                uri = parse;
            }
            if (this.f5694s == null || this.f5694s.m6301b()) {
                m9460a(new AdLauncherIntentInfoParcel("android.intent.action.VIEW", uri.toString(), null, null, null, null, null));
            } else {
                this.f5694s.m6300a(str);
            }
        }
        return true;
    }
}
