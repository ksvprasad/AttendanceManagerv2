package com.google.android.gms.p031b;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import com.google.android.gms.ads.internal.C1122d;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.overlay.C1201d;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import java.util.Map;
import org.json.JSONObject;

@id
class ld extends FrameLayout implements la {
    private final la f5702a;
    private final kz f5703b;

    public ld(la laVar) {
        super(laVar.getContext());
        this.f5702a = laVar;
        this.f5703b = new kz(laVar.mo1514g(), this, this);
        lb l = this.f5702a.mo1519l();
        if (l != null) {
            l.m9462a((la) this);
        }
        addView(this.f5702a.mo1503b());
    }

    public void mo1489A() {
        this.f5702a.mo1489A();
    }

    public void mo976B() {
        this.f5702a.mo976B();
    }

    public void mo977C() {
        this.f5702a.mo977C();
    }

    public void mo1490D() {
        this.f5702a.mo1490D();
    }

    public OnClickListener mo1491E() {
        return this.f5702a.mo1491E();
    }

    public WebView mo1492a() {
        return this.f5702a.mo1492a();
    }

    public void mo1493a(int i) {
        this.f5702a.mo1493a(i);
    }

    public void mo1494a(Context context) {
        this.f5702a.mo1494a(context);
    }

    public void mo1495a(Context context, AdSizeParcel adSizeParcel, cy cyVar) {
        this.f5703b.m9392c();
        this.f5702a.mo1495a(context, adSizeParcel, cyVar);
    }

    public void mo1496a(AdSizeParcel adSizeParcel) {
        this.f5702a.mo1496a(adSizeParcel);
    }

    public void mo1497a(C1201d c1201d) {
        this.f5702a.mo1497a(c1201d);
    }

    public void mo1498a(bq bqVar, boolean z) {
        this.f5702a.mo1498a(bqVar, z);
    }

    public void mo1499a(lf lfVar) {
        this.f5702a.mo1499a(lfVar);
    }

    public void mo1500a(String str) {
        this.f5702a.mo1500a(str);
    }

    public void mo1319a(String str, eb ebVar) {
        this.f5702a.mo1319a(str, ebVar);
    }

    public void mo1320a(String str, String str2) {
        this.f5702a.mo1320a(str, str2);
    }

    public void mo1501a(String str, Map<String, ?> map) {
        this.f5702a.mo1501a(str, (Map) map);
    }

    public void mo1321a(String str, JSONObject jSONObject) {
        this.f5702a.mo1321a(str, jSONObject);
    }

    public void mo1502a(boolean z) {
        this.f5702a.mo1502a(z);
    }

    public View mo1503b() {
        return this;
    }

    public void mo1504b(int i) {
        this.f5702a.mo1504b(i);
    }

    public void mo1505b(C1201d c1201d) {
        this.f5702a.mo1505b(c1201d);
    }

    public void mo1506b(String str) {
        this.f5702a.mo1506b(str);
    }

    public void mo1324b(String str, eb ebVar) {
        this.f5702a.mo1324b(str, ebVar);
    }

    public void mo1325b(String str, JSONObject jSONObject) {
        this.f5702a.mo1325b(str, jSONObject);
    }

    public void mo1507b(boolean z) {
        this.f5702a.mo1507b(z);
    }

    public void mo1508c() {
        this.f5702a.mo1508c();
    }

    public void mo1509c(boolean z) {
        this.f5702a.mo1509c(z);
    }

    public void mo1510d() {
        this.f5702a.mo1510d();
    }

    public void destroy() {
        this.f5702a.destroy();
    }

    public void mo1512e() {
        this.f5702a.mo1512e();
    }

    public Activity mo1513f() {
        return this.f5702a.mo1513f();
    }

    public Context mo1514g() {
        return this.f5702a.mo1514g();
    }

    public C1122d mo1515h() {
        return this.f5702a.mo1515h();
    }

    public C1201d mo1516i() {
        return this.f5702a.mo1516i();
    }

    public C1201d mo1517j() {
        return this.f5702a.mo1517j();
    }

    public AdSizeParcel mo1518k() {
        return this.f5702a.mo1518k();
    }

    public lb mo1519l() {
        return this.f5702a.mo1519l();
    }

    public void loadData(String str, String str2, String str3) {
        this.f5702a.loadData(str, str2, str3);
    }

    public void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        this.f5702a.loadDataWithBaseURL(str, str2, str3, str4, str5);
    }

    public void loadUrl(String str) {
        this.f5702a.loadUrl(str);
    }

    public boolean mo1523m() {
        return this.f5702a.mo1523m();
    }

    public aj mo1524n() {
        return this.f5702a.mo1524n();
    }

    public VersionInfoParcel mo1525o() {
        return this.f5702a.mo1525o();
    }

    public void onPause() {
        this.f5703b.m9391b();
        this.f5702a.onPause();
    }

    public void onResume() {
        this.f5702a.onResume();
    }

    public boolean mo1528p() {
        return this.f5702a.mo1528p();
    }

    public int mo1529q() {
        return this.f5702a.mo1529q();
    }

    public boolean mo1530r() {
        return this.f5702a.mo1530r();
    }

    public void mo1531s() {
        this.f5703b.m9392c();
        this.f5702a.mo1531s();
    }

    public void setBackgroundColor(int i) {
        this.f5702a.setBackgroundColor(i);
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        this.f5702a.setOnClickListener(onClickListener);
    }

    public void setOnTouchListener(OnTouchListener onTouchListener) {
        this.f5702a.setOnTouchListener(onTouchListener);
    }

    public void setWebChromeClient(WebChromeClient webChromeClient) {
        this.f5702a.setWebChromeClient(webChromeClient);
    }

    public void setWebViewClient(WebViewClient webViewClient) {
        this.f5702a.setWebViewClient(webViewClient);
    }

    public void stopLoading() {
        this.f5702a.stopLoading();
    }

    public boolean mo1538t() {
        return this.f5702a.mo1538t();
    }

    public boolean mo1539u() {
        return this.f5702a.mo1539u();
    }

    public String mo1540v() {
        return this.f5702a.mo1540v();
    }

    public kz mo1541w() {
        return this.f5703b;
    }

    public cw mo1542x() {
        return this.f5702a.mo1542x();
    }

    public cx mo1543y() {
        return this.f5702a.mo1543y();
    }

    public lf mo1544z() {
        return this.f5702a.mo1544z();
    }
}
