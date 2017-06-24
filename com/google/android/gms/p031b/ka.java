package com.google.android.gms.p031b;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.DownloadManager.Request;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.net.http.SslError;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.Callable;

@id
@TargetApi(8)
public class ka {

    @TargetApi(9)
    public static class C1661a extends ka {
        public C1661a() {
            super();
        }

        public int mo1463a() {
            return 6;
        }

        public boolean mo1464a(Request request) {
            request.setShowRunningNotification(true);
            return true;
        }

        public int mo1465b() {
            return 7;
        }
    }

    @TargetApi(11)
    public static class C1663b extends C1661a {
        public lb mo1466a(la laVar, boolean z) {
            return new li(laVar, z);
        }

        public Set<String> mo1467a(Uri uri) {
            return uri.getQueryParameterNames();
        }

        public boolean mo1464a(Request request) {
            request.allowScanningByMediaScanner();
            request.setNotificationVisibility(1);
            return true;
        }

        public boolean mo1468a(final Context context, final WebSettings webSettings) {
            super.mo1468a(context, webSettings);
            return ((Boolean) kl.m9352a(new Callable<Boolean>(this) {
                final /* synthetic */ C1663b f5578c;

                public Boolean m9285a() {
                    if (context.getCacheDir() != null) {
                        webSettings.setAppCachePath(context.getCacheDir().getAbsolutePath());
                        webSettings.setAppCacheMaxSize(0);
                        webSettings.setAppCacheEnabled(true);
                    }
                    webSettings.setDatabasePath(context.getDatabasePath("com.google.android.gms.ads.db").getAbsolutePath());
                    webSettings.setDatabaseEnabled(true);
                    webSettings.setDomStorageEnabled(true);
                    webSettings.setDisplayZoomControls(false);
                    webSettings.setBuiltInZoomControls(true);
                    webSettings.setSupportZoom(true);
                    webSettings.setAllowContentAccess(false);
                    return Boolean.valueOf(true);
                }

                public /* synthetic */ Object call() {
                    return m9285a();
                }
            })).booleanValue();
        }

        public boolean mo1469a(Window window) {
            window.setFlags(16777216, 16777216);
            return true;
        }

        public boolean mo1470b(View view) {
            view.setLayerType(0, null);
            return true;
        }

        public WebChromeClient mo1471c(la laVar) {
            return new lh(laVar);
        }

        public boolean mo1472c(View view) {
            view.setLayerType(1, null);
            return true;
        }
    }

    @TargetApi(14)
    public static class C1664c extends C1663b {
        public String mo1473a(SslError sslError) {
            return sslError.getUrl();
        }

        public WebChromeClient mo1471c(la laVar) {
            return new lj(laVar);
        }
    }

    @TargetApi(16)
    public static class C1665f extends C1664c {
        public void mo1474a(Activity activity, OnGlobalLayoutListener onGlobalLayoutListener) {
            Window window = activity.getWindow();
            if (window != null && window.getDecorView() != null && window.getDecorView().getViewTreeObserver() != null) {
                mo1476a(window.getDecorView().getViewTreeObserver(), onGlobalLayoutListener);
            }
        }

        public void mo1475a(View view, Drawable drawable) {
            view.setBackground(drawable);
        }

        public void mo1476a(ViewTreeObserver viewTreeObserver, OnGlobalLayoutListener onGlobalLayoutListener) {
            viewTreeObserver.removeOnGlobalLayoutListener(onGlobalLayoutListener);
        }

        public boolean mo1468a(Context context, WebSettings webSettings) {
            super.mo1468a(context, webSettings);
            webSettings.setAllowFileAccessFromFileURLs(false);
            webSettings.setAllowUniversalAccessFromFileURLs(false);
            return true;
        }
    }

    @TargetApi(17)
    public static class C1666d extends C1665f {
        public Drawable mo1477a(Context context, Bitmap bitmap, boolean z, float f) {
            if (!z || f <= 0.0f || f > 25.0f) {
                return new BitmapDrawable(context.getResources(), bitmap);
            }
            try {
                Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, bitmap.getWidth(), bitmap.getHeight(), false);
                Bitmap createBitmap = Bitmap.createBitmap(createScaledBitmap);
                RenderScript create = RenderScript.create(context);
                ScriptIntrinsicBlur create2 = ScriptIntrinsicBlur.create(create, Element.U8_4(create));
                Allocation createFromBitmap = Allocation.createFromBitmap(create, createScaledBitmap);
                Allocation createFromBitmap2 = Allocation.createFromBitmap(create, createBitmap);
                create2.setRadius(f);
                create2.setInput(createFromBitmap);
                create2.forEach(createFromBitmap2);
                createFromBitmap2.copyTo(createBitmap);
                return new BitmapDrawable(context.getResources(), createBitmap);
            } catch (RuntimeException e) {
                return new BitmapDrawable(context.getResources(), bitmap);
            }
        }

        public String mo1478a(Context context) {
            return WebSettings.getDefaultUserAgent(context);
        }

        public boolean mo1468a(Context context, WebSettings webSettings) {
            super.mo1468a(context, webSettings);
            webSettings.setMediaPlaybackRequiresUserGesture(false);
            return true;
        }
    }

    @TargetApi(18)
    public static class C1667e extends C1666d {
        public boolean mo1479a(View view) {
            return super.mo1479a(view) || view.getWindowId() != null;
        }

        public int mo1480c() {
            return 14;
        }
    }

    @TargetApi(19)
    public static class C1668g extends C1667e {
        public boolean mo1479a(View view) {
            return view.isAttachedToWindow();
        }

        public LayoutParams mo1481d() {
            return new LayoutParams(-1, -1);
        }
    }

    @TargetApi(21)
    public static class C1669h extends C1668g {
        public CookieManager mo1482b(Context context) {
            return CookieManager.getInstance();
        }
    }

    private ka() {
    }

    public static ka m9259a(int i) {
        return i >= 21 ? new C1669h() : i >= 19 ? new C1668g() : i >= 18 ? new C1667e() : i >= 17 ? new C1666d() : i >= 16 ? new C1665f() : i >= 14 ? new C1664c() : i >= 11 ? new C1663b() : i >= 9 ? new C1661a() : new ka();
    }

    public int mo1463a() {
        return 0;
    }

    public Drawable mo1477a(Context context, Bitmap bitmap, boolean z, float f) {
        return new BitmapDrawable(context.getResources(), bitmap);
    }

    public lb mo1466a(la laVar, boolean z) {
        return new lb(laVar, z);
    }

    public String mo1478a(Context context) {
        return "";
    }

    public String mo1473a(SslError sslError) {
        return "";
    }

    public Set<String> mo1467a(Uri uri) {
        if (uri.isOpaque()) {
            return Collections.emptySet();
        }
        String encodedQuery = uri.getEncodedQuery();
        if (encodedQuery == null) {
            return Collections.emptySet();
        }
        Set linkedHashSet = new LinkedHashSet();
        int i = 0;
        do {
            int indexOf = encodedQuery.indexOf(38, i);
            if (indexOf == -1) {
                indexOf = encodedQuery.length();
            }
            int indexOf2 = encodedQuery.indexOf(61, i);
            if (indexOf2 > indexOf || indexOf2 == -1) {
                indexOf2 = indexOf;
            }
            linkedHashSet.add(Uri.decode(encodedQuery.substring(i, indexOf2)));
            i = indexOf + 1;
        } while (i < encodedQuery.length());
        return Collections.unmodifiableSet(linkedHashSet);
    }

    public void mo1474a(Activity activity, OnGlobalLayoutListener onGlobalLayoutListener) {
        Window window = activity.getWindow();
        if (window != null && window.getDecorView() != null && window.getDecorView().getViewTreeObserver() != null) {
            mo1476a(window.getDecorView().getViewTreeObserver(), onGlobalLayoutListener);
        }
    }

    public void mo1475a(View view, Drawable drawable) {
        view.setBackgroundDrawable(drawable);
    }

    public void mo1476a(ViewTreeObserver viewTreeObserver, OnGlobalLayoutListener onGlobalLayoutListener) {
        viewTreeObserver.removeGlobalOnLayoutListener(onGlobalLayoutListener);
    }

    public boolean mo1464a(Request request) {
        return false;
    }

    public boolean mo1468a(Context context, WebSettings webSettings) {
        return false;
    }

    public boolean mo1479a(View view) {
        return (view.getWindowToken() == null && view.getWindowVisibility() == 8) ? false : true;
    }

    public boolean mo1469a(Window window) {
        return false;
    }

    public boolean m9273a(la laVar) {
        if (laVar == null) {
            return false;
        }
        laVar.onPause();
        return true;
    }

    public int mo1465b() {
        return 1;
    }

    public CookieManager mo1482b(Context context) {
        CookieSyncManager.createInstance(context);
        return CookieManager.getInstance();
    }

    public boolean mo1470b(View view) {
        return false;
    }

    public boolean m9277b(la laVar) {
        if (laVar == null) {
            return false;
        }
        laVar.onResume();
        return true;
    }

    public int mo1480c() {
        return 5;
    }

    public WebChromeClient mo1471c(la laVar) {
        return null;
    }

    public boolean mo1472c(View view) {
        return false;
    }

    public LayoutParams mo1481d() {
        return new LayoutParams(-2, -2);
    }
}
