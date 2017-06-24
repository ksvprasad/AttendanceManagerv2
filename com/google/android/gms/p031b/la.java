package com.google.android.gms.p031b;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.ads.internal.C1049s;
import com.google.android.gms.ads.internal.C1122d;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.overlay.C1201d;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import java.util.Map;
import org.json.JSONObject;

@id
public interface la extends C1049s, br, fg {
    void mo1489A();

    void mo1490D();

    OnClickListener mo1491E();

    WebView mo1492a();

    void mo1493a(int i);

    void mo1494a(Context context);

    void mo1495a(Context context, AdSizeParcel adSizeParcel, cy cyVar);

    void mo1496a(AdSizeParcel adSizeParcel);

    void mo1497a(C1201d c1201d);

    void mo1499a(lf lfVar);

    void mo1500a(String str);

    void mo1320a(String str, String str2);

    void mo1501a(String str, Map<String, ?> map);

    void mo1321a(String str, JSONObject jSONObject);

    void mo1502a(boolean z);

    View mo1503b();

    void mo1504b(int i);

    void mo1505b(C1201d c1201d);

    void mo1506b(String str);

    void mo1507b(boolean z);

    void mo1508c();

    void mo1509c(boolean z);

    void mo1510d();

    void destroy();

    void mo1512e();

    Activity mo1513f();

    Context mo1514g();

    Context getContext();

    LayoutParams getLayoutParams();

    void getLocationOnScreen(int[] iArr);

    int getMeasuredHeight();

    int getMeasuredWidth();

    ViewParent getParent();

    C1122d mo1515h();

    C1201d mo1516i();

    C1201d mo1517j();

    AdSizeParcel mo1518k();

    lb mo1519l();

    void loadData(String str, String str2, String str3);

    void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5);

    void loadUrl(String str);

    boolean mo1523m();

    void measure(int i, int i2);

    aj mo1524n();

    VersionInfoParcel mo1525o();

    void onPause();

    void onResume();

    boolean mo1528p();

    int mo1529q();

    boolean mo1530r();

    void mo1531s();

    void setBackgroundColor(int i);

    void setOnClickListener(OnClickListener onClickListener);

    void setOnTouchListener(OnTouchListener onTouchListener);

    void setWebChromeClient(WebChromeClient webChromeClient);

    void setWebViewClient(WebViewClient webViewClient);

    void stopLoading();

    boolean mo1538t();

    boolean mo1539u();

    String mo1540v();

    kz mo1541w();

    cw mo1542x();

    cx mo1543y();

    lf mo1544z();
}
