package com.google.android.gms.p031b;

import android.annotation.TargetApi;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.os.Message;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.ConsoleMessage.MessageLevel;
import android.webkit.GeolocationPermissions.Callback;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.webkit.WebStorage.QuotaUpdater;
import android.webkit.WebView;
import android.webkit.WebView.WebViewTransport;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.gms.ads.internal.C1319u;
import com.google.android.gms.ads.internal.overlay.C1201d;
import com.google.android.gms.ads.internal.util.client.C1324b;

@id
@TargetApi(11)
public class lh extends WebChromeClient {
    private final la f5764a;

    class C16981 implements OnCancelListener {
        final /* synthetic */ JsResult f5756a;

        C16981(JsResult jsResult) {
            this.f5756a = jsResult;
        }

        public void onCancel(DialogInterface dialogInterface) {
            this.f5756a.cancel();
        }
    }

    class C16992 implements OnClickListener {
        final /* synthetic */ JsResult f5757a;

        C16992(JsResult jsResult) {
            this.f5757a = jsResult;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.f5757a.cancel();
        }
    }

    class C17003 implements OnClickListener {
        final /* synthetic */ JsResult f5758a;

        C17003(JsResult jsResult) {
            this.f5758a = jsResult;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.f5758a.confirm();
        }
    }

    class C17014 implements OnCancelListener {
        final /* synthetic */ JsPromptResult f5759a;

        C17014(JsPromptResult jsPromptResult) {
            this.f5759a = jsPromptResult;
        }

        public void onCancel(DialogInterface dialogInterface) {
            this.f5759a.cancel();
        }
    }

    class C17025 implements OnClickListener {
        final /* synthetic */ JsPromptResult f5760a;

        C17025(JsPromptResult jsPromptResult) {
            this.f5760a = jsPromptResult;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.f5760a.cancel();
        }
    }

    class C17036 implements OnClickListener {
        final /* synthetic */ JsPromptResult f5761a;
        final /* synthetic */ EditText f5762b;

        C17036(JsPromptResult jsPromptResult, EditText editText) {
            this.f5761a = jsPromptResult;
            this.f5762b = editText;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.f5761a.confirm(this.f5762b.getText().toString());
        }
    }

    static /* synthetic */ class C17047 {
        static final /* synthetic */ int[] f5763a = new int[MessageLevel.values().length];

        static {
            try {
                f5763a[MessageLevel.ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f5763a[MessageLevel.WARNING.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f5763a[MessageLevel.LOG.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f5763a[MessageLevel.TIP.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f5763a[MessageLevel.DEBUG.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    public lh(la laVar) {
        this.f5764a = laVar;
    }

    private final Context m9621a(WebView webView) {
        if (!(webView instanceof la)) {
            return webView.getContext();
        }
        la laVar = (la) webView;
        Context f = laVar.mo1513f();
        return f == null ? laVar.getContext() : f;
    }

    private static void m9622a(Builder builder, String str, JsResult jsResult) {
        builder.setMessage(str).setPositiveButton(17039370, new C17003(jsResult)).setNegativeButton(17039360, new C16992(jsResult)).setOnCancelListener(new C16981(jsResult)).create().show();
    }

    private static void m9623a(Context context, Builder builder, String str, String str2, JsPromptResult jsPromptResult) {
        View linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        View textView = new TextView(context);
        textView.setText(str);
        View editText = new EditText(context);
        editText.setText(str2);
        linearLayout.addView(textView);
        linearLayout.addView(editText);
        builder.setView(linearLayout).setPositiveButton(17039370, new C17036(jsPromptResult, editText)).setNegativeButton(17039360, new C17025(jsPromptResult)).setOnCancelListener(new C17014(jsPromptResult)).create().show();
    }

    private final boolean m9624a() {
        return C1319u.m7183e().m9226a(this.f5764a.getContext().getPackageManager(), this.f5764a.getContext().getPackageName(), "android.permission.ACCESS_FINE_LOCATION") || C1319u.m7183e().m9226a(this.f5764a.getContext().getPackageManager(), this.f5764a.getContext().getPackageName(), "android.permission.ACCESS_COARSE_LOCATION");
    }

    protected final void m9625a(View view, int i, CustomViewCallback customViewCallback) {
        C1201d i2 = this.f5764a.mo1516i();
        if (i2 == null) {
            C1324b.m7234d("Could not get ad overlay when showing custom view.");
            customViewCallback.onCustomViewHidden();
            return;
        }
        i2.m6657a(view, customViewCallback);
        i2.m6654a(i);
    }

    protected boolean m9626a(Context context, String str, String str2, String str3, JsResult jsResult, JsPromptResult jsPromptResult, boolean z) {
        try {
            Builder builder = new Builder(context);
            builder.setTitle(str);
            if (z) {
                lh.m9623a(context, builder, str2, str3, jsPromptResult);
            } else {
                lh.m9622a(builder, str2, jsResult);
            }
        } catch (Throwable e) {
            C1324b.m7235d("Fail to display Dialog.", e);
        }
        return true;
    }

    public final void onCloseWindow(WebView webView) {
        if (webView instanceof la) {
            C1201d i = ((la) webView).mo1516i();
            if (i == null) {
                C1324b.m7234d("Tried to close an AdWebView not associated with an overlay.");
                return;
            } else {
                i.m6653a();
                return;
            }
        }
        C1324b.m7234d("Tried to close a WebView that wasn't an AdWebView.");
    }

    public final boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        String valueOf = String.valueOf(consoleMessage.message());
        String valueOf2 = String.valueOf(consoleMessage.sourceId());
        valueOf = new StringBuilder((String.valueOf(valueOf).length() + 19) + String.valueOf(valueOf2).length()).append("JS: ").append(valueOf).append(" (").append(valueOf2).append(":").append(consoleMessage.lineNumber()).append(")").toString();
        if (valueOf.contains("Application Cache")) {
            return super.onConsoleMessage(consoleMessage);
        }
        switch (C17047.f5763a[consoleMessage.messageLevel().ordinal()]) {
            case 1:
                C1324b.m7230b(valueOf);
                break;
            case 2:
                C1324b.m7234d(valueOf);
                break;
            case 3:
            case 4:
                C1324b.m7232c(valueOf);
                break;
            case 5:
                C1324b.m7227a(valueOf);
                break;
            default:
                C1324b.m7232c(valueOf);
                break;
        }
        return super.onConsoleMessage(consoleMessage);
    }

    public final boolean onCreateWindow(WebView webView, boolean z, boolean z2, Message message) {
        WebViewTransport webViewTransport = (WebViewTransport) message.obj;
        WebView webView2 = new WebView(webView.getContext());
        webView2.setWebViewClient(this.f5764a.mo1519l());
        webViewTransport.setWebView(webView2);
        message.sendToTarget();
        return true;
    }

    public final void onExceededDatabaseQuota(String str, String str2, long j, long j2, long j3, QuotaUpdater quotaUpdater) {
        long j4 = 5242880 - j3;
        if (j4 <= 0) {
            quotaUpdater.updateQuota(j);
            return;
        }
        if (j == 0) {
            if (j2 > j4 || j2 > 1048576) {
                j2 = 0;
            }
        } else if (j2 == 0) {
            j2 = Math.min(Math.min(131072, j4) + j, 1048576);
        } else {
            if (j2 <= Math.min(1048576 - j, j4)) {
                j += j2;
            }
            j2 = j;
        }
        quotaUpdater.updateQuota(j2);
    }

    public final void onGeolocationPermissionsShowPrompt(String str, Callback callback) {
        if (callback != null) {
            callback.invoke(str, m9624a(), true);
        }
    }

    public final void onHideCustomView() {
        C1201d i = this.f5764a.mo1516i();
        if (i == null) {
            C1324b.m7234d("Could not get ad overlay when hiding custom view.");
        } else {
            i.m6661b();
        }
    }

    public final boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
        return m9626a(m9621a(webView), str, str2, null, jsResult, null, false);
    }

    public final boolean onJsBeforeUnload(WebView webView, String str, String str2, JsResult jsResult) {
        return m9626a(m9621a(webView), str, str2, null, jsResult, null, false);
    }

    public final boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
        return m9626a(m9621a(webView), str, str2, null, jsResult, null, false);
    }

    public final boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        return m9626a(m9621a(webView), str, str2, str3, null, jsPromptResult, true);
    }

    public final void onReachedMaxAppCacheSize(long j, long j2, QuotaUpdater quotaUpdater) {
        long j3 = 131072 + j;
        if (5242880 - j2 < j3) {
            quotaUpdater.updateQuota(0);
        } else {
            quotaUpdater.updateQuota(j3);
        }
    }

    public final void onShowCustomView(View view, CustomViewCallback customViewCallback) {
        m9625a(view, -1, customViewCallback);
    }
}
