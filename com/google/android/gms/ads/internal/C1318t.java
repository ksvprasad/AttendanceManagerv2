package com.google.android.gms.ads.internal;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.C1081c;
import com.google.android.gms.ads.internal.client.C1120y;
import com.google.android.gms.ads.internal.client.VideoOptionsParcel;
import com.google.android.gms.ads.internal.client.ab;
import com.google.android.gms.ads.internal.client.ac;
import com.google.android.gms.ads.internal.client.ag.C1039a;
import com.google.android.gms.ads.internal.client.ai;
import com.google.android.gms.ads.internal.client.ak;
import com.google.android.gms.ads.internal.reward.client.C1301d;
import com.google.android.gms.ads.internal.util.client.C1324b;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.internal.C1896c;
import com.google.android.gms.p031b.bi;
import com.google.android.gms.p031b.bj;
import com.google.android.gms.p031b.cq;
import com.google.android.gms.p031b.dc;
import com.google.android.gms.p031b.hd;
import com.google.android.gms.p031b.hh;
import com.google.android.gms.p031b.id;
import com.google.android.gms.p031b.jy;
import com.google.android.gms.p033a.C0998a;
import com.google.android.gms.p033a.C1001b;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@id
public class C1318t extends C1039a {
    private final VersionInfoParcel f3920a;
    private final AdSizeParcel f3921b;
    private final Future<bi> f3922c = m7150p();
    private final Context f3923d;
    private final C1317b f3924e;
    private WebView f3925f = new WebView(this.f3923d);
    private ac f3926g;
    private bi f3927h;
    private AsyncTask<Void, Void, Void> f3928i;

    class C13131 extends WebViewClient {
        final /* synthetic */ C1318t f3912a;

        C13131(C1318t c1318t) {
            this.f3912a = c1318t;
        }

        public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            if (this.f3912a.f3926g != null) {
                try {
                    this.f3912a.f3926g.mo1007a(0);
                } catch (Throwable e) {
                    C1324b.m7235d("Could not call AdListener.onAdFailedToLoad().", e);
                }
            }
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (str.startsWith(this.f3912a.m7177n())) {
                return false;
            }
            if (str.startsWith((String) cq.bB.m7801c())) {
                if (this.f3912a.f3926g != null) {
                    try {
                        this.f3912a.f3926g.mo1007a(3);
                    } catch (Throwable e) {
                        C1324b.m7235d("Could not call AdListener.onAdFailedToLoad().", e);
                    }
                }
                this.f3912a.m7152a(0);
                return true;
            } else if (str.startsWith((String) cq.bC.m7801c())) {
                if (this.f3912a.f3926g != null) {
                    try {
                        this.f3912a.f3926g.mo1007a(0);
                    } catch (Throwable e2) {
                        C1324b.m7235d("Could not call AdListener.onAdFailedToLoad().", e2);
                    }
                }
                this.f3912a.m7152a(0);
                return true;
            } else if (str.startsWith((String) cq.bD.m7801c())) {
                if (this.f3912a.f3926g != null) {
                    try {
                        this.f3912a.f3926g.mo1009c();
                    } catch (Throwable e22) {
                        C1324b.m7235d("Could not call AdListener.onAdLoaded().", e22);
                    }
                }
                this.f3912a.m7152a(this.f3912a.m7166b(str));
                return true;
            } else if (str.startsWith("gmsg://")) {
                return true;
            } else {
                if (this.f3912a.f3926g != null) {
                    try {
                        this.f3912a.f3926g.mo1008b();
                    } catch (Throwable e222) {
                        C1324b.m7235d("Could not call AdListener.onAdLeftApplication().", e222);
                    }
                }
                this.f3912a.m7146d(this.f3912a.m7144c(str));
                return true;
            }
        }
    }

    class C13142 implements OnTouchListener {
        final /* synthetic */ C1318t f3913a;

        C13142(C1318t c1318t) {
            this.f3913a = c1318t;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (this.f3913a.f3927h != null) {
                try {
                    this.f3913a.f3927h.m7544a(motionEvent);
                } catch (Throwable e) {
                    C1324b.m7235d("Unable to process ad data", e);
                }
            }
            return false;
        }
    }

    class C13153 implements Callable<bi> {
        final /* synthetic */ C1318t f3914a;

        C13153(C1318t c1318t) {
            this.f3914a = c1318t;
        }

        public bi m7130a() {
            return new bi(this.f3914a.f3920a.f3957b, this.f3914a.f3923d, false);
        }

        public /* synthetic */ Object call() {
            return m7130a();
        }
    }

    private class C1316a extends AsyncTask<Void, Void, Void> {
        final /* synthetic */ C1318t f3915a;

        private C1316a(C1318t c1318t) {
            this.f3915a = c1318t;
        }

        protected Void m7131a(Void... voidArr) {
            Throwable e;
            try {
                this.f3915a.f3927h = (bi) this.f3915a.f3922c.get(((Long) cq.bG.m7801c()).longValue(), TimeUnit.MILLISECONDS);
            } catch (InterruptedException e2) {
                e = e2;
                C1324b.m7235d("Failed to load ad data", e);
            } catch (ExecutionException e3) {
                e = e3;
                C1324b.m7235d("Failed to load ad data", e);
            } catch (TimeoutException e4) {
                C1324b.m7234d("Timed out waiting for ad data");
            }
            return null;
        }

        protected void m7132a(Void voidR) {
            String m = this.f3915a.m7176m();
            if (this.f3915a.f3925f != null) {
                this.f3915a.f3925f.loadUrl(m);
            }
        }

        protected /* synthetic */ Object doInBackground(Object[] objArr) {
            return m7131a((Void[]) objArr);
        }

        protected /* synthetic */ void onPostExecute(Object obj) {
            m7132a((Void) obj);
        }
    }

    private static class C1317b {
        private final String f3916a;
        private final Map<String, String> f3917b = new TreeMap();
        private String f3918c;
        private String f3919d;

        public C1317b(String str) {
            this.f3916a = str;
        }

        public String m7133a() {
            return this.f3919d;
        }

        public void m7134a(AdRequestParcel adRequestParcel) {
            this.f3918c = adRequestParcel.f3094j.f3128o;
            Bundle bundle = adRequestParcel.f3097m != null ? adRequestParcel.f3097m.getBundle(AdMobAdapter.class.getName()) : null;
            if (bundle != null) {
                String str = (String) cq.bF.m7801c();
                for (String str2 : bundle.keySet()) {
                    if (str.equals(str2)) {
                        this.f3919d = bundle.getString(str2);
                    } else if (str2.startsWith("csa_")) {
                        this.f3917b.put(str2.substring("csa_".length()), bundle.getString(str2));
                    }
                }
            }
        }

        public String m7135b() {
            return this.f3918c;
        }

        public String m7136c() {
            return this.f3916a;
        }

        public Map<String, String> m7137d() {
            return this.f3917b;
        }
    }

    public C1318t(Context context, AdSizeParcel adSizeParcel, String str, VersionInfoParcel versionInfoParcel) {
        this.f3923d = context;
        this.f3920a = versionInfoParcel;
        this.f3921b = adSizeParcel;
        this.f3924e = new C1317b(str);
        m7149o();
    }

    private String m7144c(String str) {
        if (this.f3927h == null) {
            return str;
        }
        Uri parse = Uri.parse(str);
        try {
            parse = this.f3927h.m7545b(parse, this.f3923d);
        } catch (Throwable e) {
            C1324b.m7235d("Unable to process ad data", e);
        } catch (Throwable e2) {
            C1324b.m7235d("Unable to parse ad click url", e2);
        }
        return parse.toString();
    }

    private void m7146d(String str) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(str));
        this.f3923d.startActivity(intent);
    }

    private void m7149o() {
        m7152a(0);
        this.f3925f.setVerticalScrollBarEnabled(false);
        this.f3925f.getSettings().setJavaScriptEnabled(true);
        this.f3925f.setWebViewClient(new C13131(this));
        this.f3925f.setOnTouchListener(new C13142(this));
    }

    private Future<bi> m7150p() {
        return jy.m9181a(new C13153(this));
    }

    public C0998a mo948a() {
        C1896c.m10797b("getAdFrame must be called on the main UI thread.");
        return C1001b.m5713a(this.f3925f);
    }

    void m7152a(int i) {
        if (this.f3925f != null) {
            this.f3925f.setLayoutParams(new LayoutParams(-1, i));
        }
    }

    public void mo949a(AdSizeParcel adSizeParcel) {
        throw new IllegalStateException("AdSize must be set before initialization");
    }

    public void mo950a(VideoOptionsParcel videoOptionsParcel) {
        throw new IllegalStateException("Unused method");
    }

    public void mo951a(ab abVar) {
        throw new IllegalStateException("Unused method");
    }

    public void mo952a(ac acVar) {
        this.f3926g = acVar;
    }

    public void mo953a(ai aiVar) {
        throw new IllegalStateException("Unused method");
    }

    public void mo954a(ak akVar) {
        throw new IllegalStateException("Unused method");
    }

    public void mo955a(C1301d c1301d) {
        throw new IllegalStateException("Unused method");
    }

    public void mo956a(dc dcVar) {
        throw new IllegalStateException("Unused method");
    }

    public void mo957a(hd hdVar) {
        throw new IllegalStateException("Unused method");
    }

    public void mo958a(hh hhVar, String str) {
        throw new IllegalStateException("Unused method");
    }

    public void mo960a(String str) {
        throw new IllegalStateException("Unused method");
    }

    public void mo963a(boolean z) {
    }

    public boolean mo964a(AdRequestParcel adRequestParcel) {
        C1896c.m10791a(this.f3925f, (Object) "This Search Ad has already been torn down");
        this.f3924e.m7134a(adRequestParcel);
        this.f3928i = new C1316a().execute(new Void[0]);
        return true;
    }

    int m7166b(String str) {
        int i = 0;
        Object queryParameter = Uri.parse(str).getQueryParameter("height");
        if (!TextUtils.isEmpty(queryParameter)) {
            try {
                i = C1120y.m6293a().m7208a(this.f3923d, Integer.parseInt(queryParameter));
            } catch (NumberFormatException e) {
            }
        }
        return i;
    }

    public void mo965b() {
        C1896c.m10797b("destroy must be called on the main UI thread.");
        this.f3928i.cancel(true);
        this.f3922c.cancel(true);
        this.f3925f.destroy();
        this.f3925f = null;
    }

    public boolean mo967c() {
        return false;
    }

    public void c_() {
        C1896c.m10797b("resume must be called on the main UI thread.");
    }

    public void mo969d() {
        C1896c.m10797b("pause must be called on the main UI thread.");
    }

    public void mo986f() {
        throw new IllegalStateException("Unused method");
    }

    public void g_() {
    }

    public void mo971h() {
        throw new IllegalStateException("Unused method");
    }

    public AdSizeParcel mo972i() {
        return this.f3921b;
    }

    public String mo989j() {
        return null;
    }

    public boolean mo973k() {
        return false;
    }

    public C1081c mo974l() {
        return null;
    }

    String m7176m() {
        String valueOf;
        Uri a;
        Throwable e;
        String valueOf2;
        Builder builder = new Builder();
        builder.scheme("https://").appendEncodedPath((String) cq.bE.m7801c());
        builder.appendQueryParameter("query", this.f3924e.m7135b());
        builder.appendQueryParameter("pubId", this.f3924e.m7136c());
        Map d = this.f3924e.m7137d();
        for (String valueOf3 : d.keySet()) {
            builder.appendQueryParameter(valueOf3, (String) d.get(valueOf3));
        }
        Uri build = builder.build();
        if (this.f3927h != null) {
            try {
                a = this.f3927h.m7543a(build, this.f3923d);
            } catch (bj e2) {
                e = e2;
                C1324b.m7235d("Unable to process ad data", e);
                a = build;
                valueOf2 = String.valueOf(m7177n());
                valueOf3 = String.valueOf(a.getEncodedQuery());
                return new StringBuilder((String.valueOf(valueOf2).length() + 1) + String.valueOf(valueOf3).length()).append(valueOf2).append("#").append(valueOf3).toString();
            } catch (RemoteException e3) {
                e = e3;
                C1324b.m7235d("Unable to process ad data", e);
                a = build;
                valueOf2 = String.valueOf(m7177n());
                valueOf3 = String.valueOf(a.getEncodedQuery());
                return new StringBuilder((String.valueOf(valueOf2).length() + 1) + String.valueOf(valueOf3).length()).append(valueOf2).append("#").append(valueOf3).toString();
            }
            valueOf2 = String.valueOf(m7177n());
            valueOf3 = String.valueOf(a.getEncodedQuery());
            return new StringBuilder((String.valueOf(valueOf2).length() + 1) + String.valueOf(valueOf3).length()).append(valueOf2).append("#").append(valueOf3).toString();
        }
        a = build;
        valueOf2 = String.valueOf(m7177n());
        valueOf3 = String.valueOf(a.getEncodedQuery());
        return new StringBuilder((String.valueOf(valueOf2).length() + 1) + String.valueOf(valueOf3).length()).append(valueOf2).append("#").append(valueOf3).toString();
    }

    String m7177n() {
        String str;
        CharSequence a = this.f3924e.m7133a();
        if (TextUtils.isEmpty(a)) {
            str = "www.google.com";
        } else {
            CharSequence charSequence = a;
        }
        String valueOf = String.valueOf("https://");
        String str2 = (String) cq.bE.m7801c();
        return new StringBuilder(((String.valueOf(valueOf).length() + 0) + String.valueOf(str).length()) + String.valueOf(str2).length()).append(valueOf).append(str).append(str2).toString();
    }
}
