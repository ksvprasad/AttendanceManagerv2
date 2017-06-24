package com.google.android.gms.p031b;

import android.content.Context;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.ads.internal.util.client.C1324b;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@id
public class hb implements gz {
    final Set<WebView> f5015a = Collections.synchronizedSet(new HashSet());
    private final Context f5016b;

    public hb(Context context) {
        this.f5016b = context;
    }

    public WebView m8706a() {
        WebView webView = new WebView(this.f5016b);
        webView.getSettings().setJavaScriptEnabled(true);
        return webView;
    }

    public void mo1429a(String str, final String str2, final String str3) {
        C1324b.m7227a("Fetching assets for the given html");
        jz.f5567a.post(new Runnable(this) {
            final /* synthetic */ hb f5014c;

            public void run() {
                final WebView a = this.f5014c.m8706a();
                a.setWebViewClient(new WebViewClient(this) {
                    final /* synthetic */ C15651 f5011b;

                    public void onPageFinished(WebView webView, String str) {
                        C1324b.m7227a("Loading assets have finished");
                        this.f5011b.f5014c.f5015a.remove(a);
                    }

                    public void onReceivedError(WebView webView, int i, String str, String str2) {
                        C1324b.m7234d("Loading assets have failed.");
                        this.f5011b.f5014c.f5015a.remove(a);
                    }
                });
                this.f5014c.f5015a.add(a);
                a.loadDataWithBaseURL(str2, str3, "text/html", "UTF-8", null);
                C1324b.m7227a("Fetching assets finished.");
            }
        });
    }
}
