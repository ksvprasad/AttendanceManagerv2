package com.google.android.gms.p031b;

import android.annotation.TargetApi;
import android.content.Context;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.google.android.gms.ads.internal.C1319u;
import com.google.android.gms.ads.internal.util.client.C1324b;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@id
@TargetApi(11)
public class li extends lb {
    public li(la laVar, boolean z) {
        super(laVar, z);
    }

    protected WebResourceResponse m9627a(Context context, String str, String str2) {
        Map hashMap = new HashMap();
        hashMap.put("User-Agent", C1319u.m7183e().m9204a(context, str));
        hashMap.put("Cache-Control", "max-stale=3600");
        String str3 = (String) new kf(context).m9339a(str2, hashMap).get(60, TimeUnit.SECONDS);
        return str3 == null ? null : new WebResourceResponse("application/javascript", "UTF-8", new ByteArrayInputStream(str3.getBytes("UTF-8")));
    }

    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        String str2;
        Exception e;
        String valueOf;
        if (this.b != null) {
            this.b.m9077b(str);
        }
        try {
            if (!"mraid.js".equalsIgnoreCase(new File(str).getName())) {
                return super.shouldInterceptRequest(webView, str);
            }
            if (webView instanceof la) {
                la laVar = (la) webView;
                laVar.mo1519l().m9479i();
                str2 = laVar.mo1518k().f3107e ? (String) cq.f4366G.m7801c() : laVar.mo1528p() ? (String) cq.f4365F.m7801c() : (String) cq.f4364E.m7801c();
                jv.m9152e(new StringBuilder(String.valueOf(str2).length() + 24).append("shouldInterceptRequest(").append(str2).append(")").toString());
                return m9627a(laVar.getContext(), this.a.mo1525o().f3957b, str2);
            }
            C1324b.m7234d("Tried to intercept request from a WebView that wasn't an AdWebView.");
            return super.shouldInterceptRequest(webView, str);
        } catch (IOException e2) {
            e = e2;
            str2 = "Could not fetch MRAID JS. ";
            valueOf = String.valueOf(e.getMessage());
            C1324b.m7234d(valueOf.length() == 0 ? str2.concat(valueOf) : new String(str2));
            return super.shouldInterceptRequest(webView, str);
        } catch (ExecutionException e3) {
            e = e3;
            str2 = "Could not fetch MRAID JS. ";
            valueOf = String.valueOf(e.getMessage());
            if (valueOf.length() == 0) {
            }
            C1324b.m7234d(valueOf.length() == 0 ? str2.concat(valueOf) : new String(str2));
            return super.shouldInterceptRequest(webView, str);
        } catch (InterruptedException e4) {
            e = e4;
            str2 = "Could not fetch MRAID JS. ";
            valueOf = String.valueOf(e.getMessage());
            if (valueOf.length() == 0) {
            }
            C1324b.m7234d(valueOf.length() == 0 ? str2.concat(valueOf) : new String(str2));
            return super.shouldInterceptRequest(webView, str);
        } catch (TimeoutException e5) {
            e = e5;
            str2 = "Could not fetch MRAID JS. ";
            valueOf = String.valueOf(e.getMessage());
            if (valueOf.length() == 0) {
            }
            C1324b.m7234d(valueOf.length() == 0 ? str2.concat(valueOf) : new String(str2));
            return super.shouldInterceptRequest(webView, str);
        }
    }
}
