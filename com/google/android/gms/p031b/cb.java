package com.google.android.gms.p031b;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.KeyguardManager;
import android.content.Context;
import android.graphics.Rect;
import android.os.PowerManager;
import android.os.Process;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.TextView;
import com.google.android.gms.ads.internal.util.client.C1324b;
import com.google.android.gms.common.util.C1979l;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

@id
@TargetApi(14)
public class cb extends Thread {
    private boolean f4317a = false;
    private boolean f4318b = false;
    private boolean f4319c = false;
    private final Object f4320d;
    private final ca f4321e;
    private final bz f4322f;
    private final ic f4323g;
    private final int f4324h;
    private final int f4325i;
    private final int f4326j;
    private final int f4327k;
    private final int f4328l;

    @id
    class C1397a {
        final int f4314a;
        final int f4315b;
        final /* synthetic */ cb f4316c;

        C1397a(cb cbVar, int i, int i2) {
            this.f4316c = cbVar;
            this.f4314a = i;
            this.f4315b = i2;
        }
    }

    public cb(ca caVar, bz bzVar, ic icVar) {
        this.f4321e = caVar;
        this.f4322f = bzVar;
        this.f4323g = icVar;
        this.f4320d = new Object();
        this.f4325i = ((Integer) cq.f4371L.m7801c()).intValue();
        this.f4326j = ((Integer) cq.f4372M.m7801c()).intValue();
        this.f4327k = ((Integer) cq.f4373N.m7801c()).intValue();
        this.f4328l = ((Integer) cq.f4374O.m7801c()).intValue();
        this.f4324h = ((Integer) cq.f4375P.m7801c()).intValue();
        setName("ContentFetchTask");
    }

    C1397a m7745a(View view, by byVar) {
        int i = 0;
        if (view == null) {
            return new C1397a(this, 0, 0);
        }
        boolean globalVisibleRect = view.getGlobalVisibleRect(new Rect());
        if ((view instanceof TextView) && !(view instanceof EditText)) {
            CharSequence text = ((TextView) view).getText();
            if (TextUtils.isEmpty(text)) {
                return new C1397a(this, 0, 0);
            }
            byVar.m7691b(text.toString(), globalVisibleRect);
            return new C1397a(this, 1, 0);
        } else if ((view instanceof WebView) && !(view instanceof la)) {
            byVar.m7695f();
            return m7752a((WebView) view, byVar, globalVisibleRect) ? new C1397a(this, 0, 1) : new C1397a(this, 0, 0);
        } else if (!(view instanceof ViewGroup)) {
            return new C1397a(this, 0, 0);
        } else {
            ViewGroup viewGroup = (ViewGroup) view;
            int i2 = 0;
            int i3 = 0;
            while (i < viewGroup.getChildCount()) {
                C1397a a = m7745a(viewGroup.getChildAt(i), byVar);
                i3 += a.f4314a;
                i2 += a.f4315b;
                i++;
            }
            return new C1397a(this, i3, i2);
        }
    }

    public void m7746a() {
        synchronized (this.f4320d) {
            if (this.f4317a) {
                C1324b.m7227a("Content hash thread already started, quiting...");
                return;
            }
            this.f4317a = true;
            start();
        }
    }

    void m7747a(Activity activity) {
        if (activity != null) {
            View view = null;
            try {
                if (!(activity.getWindow() == null || activity.getWindow().getDecorView() == null)) {
                    view = activity.getWindow().getDecorView().findViewById(16908290);
                }
            } catch (Throwable th) {
                C1324b.m7227a("Failed getting root view of activity. Content not extracted.");
            }
            if (view != null) {
                m7751a(view);
            }
        }
    }

    void m7748a(by byVar, WebView webView, String str, boolean z) {
        byVar.m7694e();
        try {
            if (!TextUtils.isEmpty(str)) {
                String optString = new JSONObject(str).optString("text");
                if (TextUtils.isEmpty(webView.getTitle())) {
                    byVar.m7688a(optString, z);
                } else {
                    String valueOf = String.valueOf(webView.getTitle());
                    byVar.m7688a(new StringBuilder((String.valueOf(valueOf).length() + 1) + String.valueOf(optString).length()).append(valueOf).append("\n").append(optString).toString(), z);
                }
            }
            if (byVar.m7689a()) {
                this.f4322f.m7701b(byVar);
            }
        } catch (JSONException e) {
            C1324b.m7227a("Json string may be malformed.");
        } catch (Throwable th) {
            C1324b.m7228a("Failed to get webview content.", th);
            this.f4323g.m8872a(th, true);
        }
    }

    boolean m7749a(RunningAppProcessInfo runningAppProcessInfo) {
        return runningAppProcessInfo.importance == 100;
    }

    boolean m7750a(Context context) {
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        return powerManager == null ? false : powerManager.isScreenOn();
    }

    boolean m7751a(final View view) {
        if (view == null) {
            return false;
        }
        view.post(new Runnable(this) {
            final /* synthetic */ cb f4307b;

            public void run() {
                this.f4307b.m7753b(view);
            }
        });
        return true;
    }

    @TargetApi(19)
    boolean m7752a(final WebView webView, final by byVar, final boolean z) {
        if (!C1979l.m11114h()) {
            return false;
        }
        byVar.m7695f();
        webView.post(new Runnable(this) {
            ValueCallback<String> f4309a = new C13951(this);
            final /* synthetic */ cb f4313e;

            class C13951 implements ValueCallback<String> {
                final /* synthetic */ C13962 f4308a;

                C13951(C13962 c13962) {
                    this.f4308a = c13962;
                }

                public void m7744a(String str) {
                    this.f4308a.f4313e.m7748a(byVar, webView, str, z);
                }

                public /* synthetic */ void onReceiveValue(Object obj) {
                    m7744a((String) obj);
                }
            }

            public void run() {
                if (webView.getSettings().getJavaScriptEnabled()) {
                    try {
                        webView.evaluateJavascript("(function() { return  {text:document.body.innerText}})();", this.f4309a);
                    } catch (Throwable th) {
                        this.f4309a.onReceiveValue("");
                    }
                }
            }
        });
        return true;
    }

    void m7753b(View view) {
        try {
            by byVar = new by(this.f4325i, this.f4326j, this.f4327k, this.f4328l);
            C1397a a = m7745a(view, byVar);
            byVar.m7696g();
            if (a.f4314a != 0 || a.f4315b != 0) {
                if (a.f4315b != 0 || byVar.m7698i() != 0) {
                    if (a.f4315b != 0 || !this.f4322f.m7700a(byVar)) {
                        this.f4322f.m7702c(byVar);
                    }
                }
            }
        } catch (Throwable e) {
            C1324b.m7231b("Exception in fetchContentOnUIThread", e);
            this.f4323g.m8872a(e, true);
        }
    }

    boolean m7754b() {
        try {
            Context b = this.f4321e.m7743b();
            if (b == null) {
                return false;
            }
            ActivityManager activityManager = (ActivityManager) b.getSystemService("activity");
            KeyguardManager keyguardManager = (KeyguardManager) b.getSystemService("keyguard");
            if (activityManager == null || keyguardManager == null) {
                return false;
            }
            List<RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
            if (runningAppProcesses == null) {
                return false;
            }
            for (RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (Process.myPid() == runningAppProcessInfo.pid) {
                    if (m7749a(runningAppProcessInfo) && !keyguardManager.inKeyguardRestrictedInputMode() && m7750a(b)) {
                        return true;
                    }
                    return false;
                }
            }
            return false;
        } catch (Throwable th) {
            return false;
        }
    }

    public by m7755c() {
        return this.f4322f.m7699a();
    }

    public void m7756d() {
        synchronized (this.f4320d) {
            this.f4318b = false;
            this.f4320d.notifyAll();
            C1324b.m7227a("ContentFetchThread: wakeup");
        }
    }

    public void m7757e() {
        synchronized (this.f4320d) {
            this.f4318b = true;
            C1324b.m7227a("ContentFetchThread: paused, mPause = " + this.f4318b);
        }
    }

    public boolean m7758f() {
        return this.f4318b;
    }

    public void run() {
        while (true) {
            try {
                if (m7754b()) {
                    Activity a = this.f4321e.m7742a();
                    if (a == null) {
                        C1324b.m7227a("ContentFetchThread: no activity. Sleeping.");
                        m7757e();
                    } else {
                        m7747a(a);
                    }
                } else {
                    C1324b.m7227a("ContentFetchTask: sleeping");
                    m7757e();
                }
                Thread.sleep((long) (this.f4324h * 1000));
            } catch (Throwable th) {
                C1324b.m7231b("Error in ContentFetchTask", th);
                this.f4323g.m8872a(th, true);
            }
            synchronized (this.f4320d) {
                while (this.f4318b) {
                    try {
                        C1324b.m7227a("ContentFetchTask: waiting");
                        this.f4320d.wait();
                    } catch (InterruptedException e) {
                    }
                }
            }
        }
    }
}
