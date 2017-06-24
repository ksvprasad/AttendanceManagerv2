package com.google.android.gms.p031b;

import android.text.TextUtils;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.ads.internal.util.client.C1324b;
import com.google.android.gms.common.internal.C1895b;
import java.net.URI;
import java.net.URISyntaxException;

@id
public class lk extends WebViewClient {
    private final String f5765a;
    private boolean f5766b = false;
    private final la f5767c;
    private final ho f5768d;

    public lk(ho hoVar, la laVar, String str) {
        this.f5765a = m9628b(str);
        this.f5767c = laVar;
        this.f5768d = hoVar;
    }

    private String m9628b(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                if (str.endsWith("/")) {
                    str = str.substring(0, str.length() - 1);
                }
            } catch (IndexOutOfBoundsException e) {
                C1324b.m7230b(e.getMessage());
            }
        }
        return str;
    }

    protected boolean m9629a(String str) {
        Object b = m9628b(str);
        if (TextUtils.isEmpty(b)) {
            return false;
        }
        try {
            URI uri = new URI(b);
            if ("passback".equals(uri.getScheme())) {
                C1324b.m7227a("Passback received");
                this.f5768d.m8755b();
                return true;
            } else if (TextUtils.isEmpty(this.f5765a)) {
                return false;
            } else {
                URI uri2 = new URI(this.f5765a);
                String host = uri2.getHost();
                String host2 = uri.getHost();
                String path = uri2.getPath();
                String path2 = uri.getPath();
                if (!C1895b.m10789a(host, host2) || !C1895b.m10789a(path, path2)) {
                    return false;
                }
                C1324b.m7227a("Passback received");
                this.f5768d.m8755b();
                return true;
            }
        } catch (URISyntaxException e) {
            C1324b.m7230b(e.getMessage());
            return false;
        }
    }

    public void onLoadResource(WebView webView, String str) {
        String str2 = "JavascriptAdWebViewClient::onLoadResource: ";
        String valueOf = String.valueOf(str);
        C1324b.m7227a(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
        if (!m9629a(str)) {
            this.f5767c.mo1519l().onLoadResource(this.f5767c.mo1492a(), str);
        }
    }

    public void onPageFinished(WebView webView, String str) {
        String str2 = "JavascriptAdWebViewClient::onPageFinished: ";
        String valueOf = String.valueOf(str);
        C1324b.m7227a(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
        if (!this.f5766b) {
            this.f5768d.m8752a();
            this.f5766b = true;
        }
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        String str2 = "JavascriptAdWebViewClient::shouldOverrideUrlLoading: ";
        String valueOf = String.valueOf(str);
        C1324b.m7227a(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
        if (!m9629a(str)) {
            return this.f5767c.mo1519l().shouldOverrideUrlLoading(this.f5767c.mo1492a(), str);
        }
        C1324b.m7227a("shouldOverrideUrlLoading: received passback url");
        return true;
    }
}
