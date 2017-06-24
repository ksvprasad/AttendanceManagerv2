package com.google.android.gms.p031b;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import com.google.android.gms.ads.internal.C1319u;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.C1120y;
import com.google.android.gms.ads.internal.util.client.C1324b;
import com.google.android.gms.common.util.C1971d;
import java.util.Map;
import java.util.Set;

@id
public class gp extends gu {
    static final Set<String> f4956a = C1971d.m11082a("top-left", "top-right", "top-center", "center", "bottom-left", "bottom-right", "bottom-center");
    private String f4957b = "top-right";
    private boolean f4958c = true;
    private int f4959d = 0;
    private int f4960e = 0;
    private int f4961f = -1;
    private int f4962g = 0;
    private int f4963h = 0;
    private int f4964i = -1;
    private final Object f4965j = new Object();
    private final la f4966k;
    private final Activity f4967l;
    private AdSizeParcel f4968m;
    private ImageView f4969n;
    private LinearLayout f4970o;
    private gv f4971p;
    private PopupWindow f4972q;
    private RelativeLayout f4973r;
    private ViewGroup f4974s;

    class C15551 implements OnClickListener {
        final /* synthetic */ gp f4955a;

        C15551(gp gpVar) {
            this.f4955a = gpVar;
        }

        public void onClick(View view) {
            this.f4955a.m8650a(true);
        }
    }

    public gp(la laVar, gv gvVar) {
        super(laVar, "resize");
        this.f4966k = laVar;
        this.f4967l = laVar.mo1513f();
        this.f4971p = gvVar;
    }

    private void m8645b(Map<String, String> map) {
        if (!TextUtils.isEmpty((CharSequence) map.get("width"))) {
            this.f4964i = C1319u.m7183e().m9232b((String) map.get("width"));
        }
        if (!TextUtils.isEmpty((CharSequence) map.get("height"))) {
            this.f4961f = C1319u.m7183e().m9232b((String) map.get("height"));
        }
        if (!TextUtils.isEmpty((CharSequence) map.get("offsetX"))) {
            this.f4962g = C1319u.m7183e().m9232b((String) map.get("offsetX"));
        }
        if (!TextUtils.isEmpty((CharSequence) map.get("offsetY"))) {
            this.f4963h = C1319u.m7183e().m9232b((String) map.get("offsetY"));
        }
        if (!TextUtils.isEmpty((CharSequence) map.get("allowOffscreen"))) {
            this.f4958c = Boolean.parseBoolean((String) map.get("allowOffscreen"));
        }
        String str = (String) map.get("customClosePosition");
        if (!TextUtils.isEmpty(str)) {
            this.f4957b = str;
        }
    }

    private int[] m8646d() {
        if (!m8655c()) {
            return null;
        }
        if (this.f4958c) {
            return new int[]{this.f4959d + this.f4962g, this.f4960e + this.f4963h};
        }
        int[] b = C1319u.m7183e().m9237b(this.f4967l);
        int[] d = C1319u.m7183e().m9244d(this.f4967l);
        int i = b[0];
        int i2 = this.f4959d + this.f4962g;
        int i3 = this.f4960e + this.f4963h;
        if (i2 < 0) {
            i2 = 0;
        } else if (this.f4964i + i2 > i) {
            i2 = i - this.f4964i;
        }
        if (i3 < d[0]) {
            i3 = d[0];
        } else if (this.f4961f + i3 > d[1]) {
            i3 = d[1] - this.f4961f;
        }
        return new int[]{i2, i3};
    }

    void m8647a(int i, int i2) {
        if (this.f4971p != null) {
            this.f4971p.mo1001a(i, i2, this.f4964i, this.f4961f);
        }
    }

    public void m8648a(int i, int i2, boolean z) {
        synchronized (this.f4965j) {
            this.f4959d = i;
            this.f4960e = i2;
            if (this.f4972q != null && z) {
                int[] d = m8646d();
                if (d != null) {
                    this.f4972q.update(C1120y.m6293a().m7208a(this.f4967l, d[0]), C1120y.m6293a().m7208a(this.f4967l, d[1]), this.f4972q.getWidth(), this.f4972q.getHeight());
                    m8652b(d[0], d[1]);
                } else {
                    m8650a(true);
                }
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m8649a(java.util.Map<java.lang.String, java.lang.String> r13) {
        /*
        r12 = this;
        r4 = -1;
        r5 = 1;
        r3 = 0;
        r6 = r12.f4965j;
        monitor-enter(r6);
        r1 = r12.f4967l;	 Catch:{ all -> 0x0020 }
        if (r1 != 0) goto L_0x0011;
    L_0x000a:
        r1 = "Not an activity context. Cannot resize.";
        r12.m8636b(r1);	 Catch:{ all -> 0x0020 }
        monitor-exit(r6);	 Catch:{ all -> 0x0020 }
    L_0x0010:
        return;
    L_0x0011:
        r1 = r12.f4966k;	 Catch:{ all -> 0x0020 }
        r1 = r1.mo1518k();	 Catch:{ all -> 0x0020 }
        if (r1 != 0) goto L_0x0023;
    L_0x0019:
        r1 = "Webview is not yet available, size is not set.";
        r12.m8636b(r1);	 Catch:{ all -> 0x0020 }
        monitor-exit(r6);	 Catch:{ all -> 0x0020 }
        goto L_0x0010;
    L_0x0020:
        r1 = move-exception;
        monitor-exit(r6);	 Catch:{ all -> 0x0020 }
        throw r1;
    L_0x0023:
        r1 = r12.f4966k;	 Catch:{ all -> 0x0020 }
        r1 = r1.mo1518k();	 Catch:{ all -> 0x0020 }
        r1 = r1.f3107e;	 Catch:{ all -> 0x0020 }
        if (r1 == 0) goto L_0x0034;
    L_0x002d:
        r1 = "Is interstitial. Cannot resize an interstitial.";
        r12.m8636b(r1);	 Catch:{ all -> 0x0020 }
        monitor-exit(r6);	 Catch:{ all -> 0x0020 }
        goto L_0x0010;
    L_0x0034:
        r1 = r12.f4966k;	 Catch:{ all -> 0x0020 }
        r1 = r1.mo1528p();	 Catch:{ all -> 0x0020 }
        if (r1 == 0) goto L_0x0043;
    L_0x003c:
        r1 = "Cannot resize an expanded banner.";
        r12.m8636b(r1);	 Catch:{ all -> 0x0020 }
        monitor-exit(r6);	 Catch:{ all -> 0x0020 }
        goto L_0x0010;
    L_0x0043:
        r12.m8645b(r13);	 Catch:{ all -> 0x0020 }
        r1 = r12.m8651a();	 Catch:{ all -> 0x0020 }
        if (r1 != 0) goto L_0x0053;
    L_0x004c:
        r1 = "Invalid width and height options. Cannot resize.";
        r12.m8636b(r1);	 Catch:{ all -> 0x0020 }
        monitor-exit(r6);	 Catch:{ all -> 0x0020 }
        goto L_0x0010;
    L_0x0053:
        r1 = r12.f4967l;	 Catch:{ all -> 0x0020 }
        r7 = r1.getWindow();	 Catch:{ all -> 0x0020 }
        if (r7 == 0) goto L_0x0061;
    L_0x005b:
        r1 = r7.getDecorView();	 Catch:{ all -> 0x0020 }
        if (r1 != 0) goto L_0x0068;
    L_0x0061:
        r1 = "Activity context is not ready, cannot get window or decor view.";
        r12.m8636b(r1);	 Catch:{ all -> 0x0020 }
        monitor-exit(r6);	 Catch:{ all -> 0x0020 }
        goto L_0x0010;
    L_0x0068:
        r8 = r12.m8646d();	 Catch:{ all -> 0x0020 }
        if (r8 != 0) goto L_0x0075;
    L_0x006e:
        r1 = "Resize location out of screen or close button is not visible.";
        r12.m8636b(r1);	 Catch:{ all -> 0x0020 }
        monitor-exit(r6);	 Catch:{ all -> 0x0020 }
        goto L_0x0010;
    L_0x0075:
        r1 = com.google.android.gms.ads.internal.client.C1120y.m6293a();	 Catch:{ all -> 0x0020 }
        r2 = r12.f4967l;	 Catch:{ all -> 0x0020 }
        r9 = r12.f4964i;	 Catch:{ all -> 0x0020 }
        r9 = r1.m7208a(r2, r9);	 Catch:{ all -> 0x0020 }
        r1 = com.google.android.gms.ads.internal.client.C1120y.m6293a();	 Catch:{ all -> 0x0020 }
        r2 = r12.f4967l;	 Catch:{ all -> 0x0020 }
        r10 = r12.f4961f;	 Catch:{ all -> 0x0020 }
        r10 = r1.m7208a(r2, r10);	 Catch:{ all -> 0x0020 }
        r1 = r12.f4966k;	 Catch:{ all -> 0x0020 }
        r1 = r1.mo1503b();	 Catch:{ all -> 0x0020 }
        r2 = r1.getParent();	 Catch:{ all -> 0x0020 }
        if (r2 == 0) goto L_0x01d5;
    L_0x0099:
        r1 = r2 instanceof android.view.ViewGroup;	 Catch:{ all -> 0x0020 }
        if (r1 == 0) goto L_0x01d5;
    L_0x009d:
        r0 = r2;
        r0 = (android.view.ViewGroup) r0;	 Catch:{ all -> 0x0020 }
        r1 = r0;
        r11 = r12.f4966k;	 Catch:{ all -> 0x0020 }
        r11 = r11.mo1503b();	 Catch:{ all -> 0x0020 }
        r1.removeView(r11);	 Catch:{ all -> 0x0020 }
        r1 = r12.f4972q;	 Catch:{ all -> 0x0020 }
        if (r1 != 0) goto L_0x01ce;
    L_0x00ae:
        r2 = (android.view.ViewGroup) r2;	 Catch:{ all -> 0x0020 }
        r12.f4974s = r2;	 Catch:{ all -> 0x0020 }
        r1 = com.google.android.gms.ads.internal.C1319u.m7183e();	 Catch:{ all -> 0x0020 }
        r2 = r12.f4966k;	 Catch:{ all -> 0x0020 }
        r2 = r2.mo1503b();	 Catch:{ all -> 0x0020 }
        r1 = r1.m9198a(r2);	 Catch:{ all -> 0x0020 }
        r2 = new android.widget.ImageView;	 Catch:{ all -> 0x0020 }
        r11 = r12.f4967l;	 Catch:{ all -> 0x0020 }
        r2.<init>(r11);	 Catch:{ all -> 0x0020 }
        r12.f4969n = r2;	 Catch:{ all -> 0x0020 }
        r2 = r12.f4969n;	 Catch:{ all -> 0x0020 }
        r2.setImageBitmap(r1);	 Catch:{ all -> 0x0020 }
        r1 = r12.f4966k;	 Catch:{ all -> 0x0020 }
        r1 = r1.mo1518k();	 Catch:{ all -> 0x0020 }
        r12.f4968m = r1;	 Catch:{ all -> 0x0020 }
        r1 = r12.f4974s;	 Catch:{ all -> 0x0020 }
        r2 = r12.f4969n;	 Catch:{ all -> 0x0020 }
        r1.addView(r2);	 Catch:{ all -> 0x0020 }
    L_0x00dd:
        r1 = new android.widget.RelativeLayout;	 Catch:{ all -> 0x0020 }
        r2 = r12.f4967l;	 Catch:{ all -> 0x0020 }
        r1.<init>(r2);	 Catch:{ all -> 0x0020 }
        r12.f4973r = r1;	 Catch:{ all -> 0x0020 }
        r1 = r12.f4973r;	 Catch:{ all -> 0x0020 }
        r2 = 0;
        r1.setBackgroundColor(r2);	 Catch:{ all -> 0x0020 }
        r1 = r12.f4973r;	 Catch:{ all -> 0x0020 }
        r2 = new android.view.ViewGroup$LayoutParams;	 Catch:{ all -> 0x0020 }
        r2.<init>(r9, r10);	 Catch:{ all -> 0x0020 }
        r1.setLayoutParams(r2);	 Catch:{ all -> 0x0020 }
        r1 = com.google.android.gms.ads.internal.C1319u.m7183e();	 Catch:{ all -> 0x0020 }
        r2 = r12.f4973r;	 Catch:{ all -> 0x0020 }
        r11 = 0;
        r1 = r1.m9200a(r2, r9, r10, r11);	 Catch:{ all -> 0x0020 }
        r12.f4972q = r1;	 Catch:{ all -> 0x0020 }
        r1 = r12.f4972q;	 Catch:{ all -> 0x0020 }
        r2 = 1;
        r1.setOutsideTouchable(r2);	 Catch:{ all -> 0x0020 }
        r1 = r12.f4972q;	 Catch:{ all -> 0x0020 }
        r2 = 1;
        r1.setTouchable(r2);	 Catch:{ all -> 0x0020 }
        r2 = r12.f4972q;	 Catch:{ all -> 0x0020 }
        r1 = r12.f4958c;	 Catch:{ all -> 0x0020 }
        if (r1 != 0) goto L_0x01dd;
    L_0x0115:
        r1 = r5;
    L_0x0116:
        r2.setClippingEnabled(r1);	 Catch:{ all -> 0x0020 }
        r1 = r12.f4973r;	 Catch:{ all -> 0x0020 }
        r2 = r12.f4966k;	 Catch:{ all -> 0x0020 }
        r2 = r2.mo1503b();	 Catch:{ all -> 0x0020 }
        r9 = -1;
        r10 = -1;
        r1.addView(r2, r9, r10);	 Catch:{ all -> 0x0020 }
        r1 = new android.widget.LinearLayout;	 Catch:{ all -> 0x0020 }
        r2 = r12.f4967l;	 Catch:{ all -> 0x0020 }
        r1.<init>(r2);	 Catch:{ all -> 0x0020 }
        r12.f4970o = r1;	 Catch:{ all -> 0x0020 }
        r2 = new android.widget.RelativeLayout$LayoutParams;	 Catch:{ all -> 0x0020 }
        r1 = com.google.android.gms.ads.internal.client.C1120y.m6293a();	 Catch:{ all -> 0x0020 }
        r9 = r12.f4967l;	 Catch:{ all -> 0x0020 }
        r10 = 50;
        r1 = r1.m7208a(r9, r10);	 Catch:{ all -> 0x0020 }
        r9 = com.google.android.gms.ads.internal.client.C1120y.m6293a();	 Catch:{ all -> 0x0020 }
        r10 = r12.f4967l;	 Catch:{ all -> 0x0020 }
        r11 = 50;
        r9 = r9.m7208a(r10, r11);	 Catch:{ all -> 0x0020 }
        r2.<init>(r1, r9);	 Catch:{ all -> 0x0020 }
        r1 = r12.f4957b;	 Catch:{ all -> 0x0020 }
        r9 = r1.hashCode();	 Catch:{ all -> 0x0020 }
        switch(r9) {
            case -1364013995: goto L_0x01f6;
            case -1012429441: goto L_0x01e0;
            case -655373719: goto L_0x0201;
            case 1163912186: goto L_0x0217;
            case 1288627767: goto L_0x020c;
            case 1755462605: goto L_0x01eb;
            default: goto L_0x0155;
        };	 Catch:{ all -> 0x0020 }
    L_0x0155:
        r1 = r4;
    L_0x0156:
        switch(r1) {
            case 0: goto L_0x0222;
            case 1: goto L_0x022e;
            case 2: goto L_0x023a;
            case 3: goto L_0x0241;
            case 4: goto L_0x024d;
            case 5: goto L_0x0259;
            default: goto L_0x0159;
        };	 Catch:{ all -> 0x0020 }
    L_0x0159:
        r1 = 10;
        r2.addRule(r1);	 Catch:{ all -> 0x0020 }
        r1 = 11;
        r2.addRule(r1);	 Catch:{ all -> 0x0020 }
    L_0x0163:
        r1 = r12.f4970o;	 Catch:{ all -> 0x0020 }
        r3 = new com.google.android.gms.b.gp$1;	 Catch:{ all -> 0x0020 }
        r3.<init>(r12);	 Catch:{ all -> 0x0020 }
        r1.setOnClickListener(r3);	 Catch:{ all -> 0x0020 }
        r1 = r12.f4970o;	 Catch:{ all -> 0x0020 }
        r3 = "Close button";
        r1.setContentDescription(r3);	 Catch:{ all -> 0x0020 }
        r1 = r12.f4973r;	 Catch:{ all -> 0x0020 }
        r3 = r12.f4970o;	 Catch:{ all -> 0x0020 }
        r1.addView(r3, r2);	 Catch:{ all -> 0x0020 }
        r1 = r12.f4972q;	 Catch:{ RuntimeException -> 0x0265 }
        r2 = r7.getDecorView();	 Catch:{ RuntimeException -> 0x0265 }
        r3 = 0;
        r4 = com.google.android.gms.ads.internal.client.C1120y.m6293a();	 Catch:{ RuntimeException -> 0x0265 }
        r5 = r12.f4967l;	 Catch:{ RuntimeException -> 0x0265 }
        r7 = 0;
        r7 = r8[r7];	 Catch:{ RuntimeException -> 0x0265 }
        r4 = r4.m7208a(r5, r7);	 Catch:{ RuntimeException -> 0x0265 }
        r5 = com.google.android.gms.ads.internal.client.C1120y.m6293a();	 Catch:{ RuntimeException -> 0x0265 }
        r7 = r12.f4967l;	 Catch:{ RuntimeException -> 0x0265 }
        r9 = 1;
        r9 = r8[r9];	 Catch:{ RuntimeException -> 0x0265 }
        r5 = r5.m7208a(r7, r9);	 Catch:{ RuntimeException -> 0x0265 }
        r1.showAtLocation(r2, r3, r4, r5);	 Catch:{ RuntimeException -> 0x0265 }
        r1 = 0;
        r1 = r8[r1];	 Catch:{ all -> 0x0020 }
        r2 = 1;
        r2 = r8[r2];	 Catch:{ all -> 0x0020 }
        r12.m8647a(r1, r2);	 Catch:{ all -> 0x0020 }
        r1 = r12.f4966k;	 Catch:{ all -> 0x0020 }
        r2 = new com.google.android.gms.ads.internal.client.AdSizeParcel;	 Catch:{ all -> 0x0020 }
        r3 = r12.f4967l;	 Catch:{ all -> 0x0020 }
        r4 = new com.google.android.gms.ads.d;	 Catch:{ all -> 0x0020 }
        r5 = r12.f4964i;	 Catch:{ all -> 0x0020 }
        r7 = r12.f4961f;	 Catch:{ all -> 0x0020 }
        r4.<init>(r5, r7);	 Catch:{ all -> 0x0020 }
        r2.<init>(r3, r4);	 Catch:{ all -> 0x0020 }
        r1.mo1496a(r2);	 Catch:{ all -> 0x0020 }
        r1 = 0;
        r1 = r8[r1];	 Catch:{ all -> 0x0020 }
        r2 = 1;
        r2 = r8[r2];	 Catch:{ all -> 0x0020 }
        r12.m8652b(r1, r2);	 Catch:{ all -> 0x0020 }
        r1 = "resized";
        r12.m8638d(r1);	 Catch:{ all -> 0x0020 }
        monitor-exit(r6);	 Catch:{ all -> 0x0020 }
        goto L_0x0010;
    L_0x01ce:
        r1 = r12.f4972q;	 Catch:{ all -> 0x0020 }
        r1.dismiss();	 Catch:{ all -> 0x0020 }
        goto L_0x00dd;
    L_0x01d5:
        r1 = "Webview is detached, probably in the middle of a resize or expand.";
        r12.m8636b(r1);	 Catch:{ all -> 0x0020 }
        monitor-exit(r6);	 Catch:{ all -> 0x0020 }
        goto L_0x0010;
    L_0x01dd:
        r1 = r3;
        goto L_0x0116;
    L_0x01e0:
        r5 = "top-left";
        r1 = r1.equals(r5);	 Catch:{ all -> 0x0020 }
        if (r1 == 0) goto L_0x0155;
    L_0x01e8:
        r1 = r3;
        goto L_0x0156;
    L_0x01eb:
        r3 = "top-center";
        r1 = r1.equals(r3);	 Catch:{ all -> 0x0020 }
        if (r1 == 0) goto L_0x0155;
    L_0x01f3:
        r1 = r5;
        goto L_0x0156;
    L_0x01f6:
        r3 = "center";
        r1 = r1.equals(r3);	 Catch:{ all -> 0x0020 }
        if (r1 == 0) goto L_0x0155;
    L_0x01fe:
        r1 = 2;
        goto L_0x0156;
    L_0x0201:
        r3 = "bottom-left";
        r1 = r1.equals(r3);	 Catch:{ all -> 0x0020 }
        if (r1 == 0) goto L_0x0155;
    L_0x0209:
        r1 = 3;
        goto L_0x0156;
    L_0x020c:
        r3 = "bottom-center";
        r1 = r1.equals(r3);	 Catch:{ all -> 0x0020 }
        if (r1 == 0) goto L_0x0155;
    L_0x0214:
        r1 = 4;
        goto L_0x0156;
    L_0x0217:
        r3 = "bottom-right";
        r1 = r1.equals(r3);	 Catch:{ all -> 0x0020 }
        if (r1 == 0) goto L_0x0155;
    L_0x021f:
        r1 = 5;
        goto L_0x0156;
    L_0x0222:
        r1 = 10;
        r2.addRule(r1);	 Catch:{ all -> 0x0020 }
        r1 = 9;
        r2.addRule(r1);	 Catch:{ all -> 0x0020 }
        goto L_0x0163;
    L_0x022e:
        r1 = 10;
        r2.addRule(r1);	 Catch:{ all -> 0x0020 }
        r1 = 14;
        r2.addRule(r1);	 Catch:{ all -> 0x0020 }
        goto L_0x0163;
    L_0x023a:
        r1 = 13;
        r2.addRule(r1);	 Catch:{ all -> 0x0020 }
        goto L_0x0163;
    L_0x0241:
        r1 = 12;
        r2.addRule(r1);	 Catch:{ all -> 0x0020 }
        r1 = 9;
        r2.addRule(r1);	 Catch:{ all -> 0x0020 }
        goto L_0x0163;
    L_0x024d:
        r1 = 12;
        r2.addRule(r1);	 Catch:{ all -> 0x0020 }
        r1 = 14;
        r2.addRule(r1);	 Catch:{ all -> 0x0020 }
        goto L_0x0163;
    L_0x0259:
        r1 = 12;
        r2.addRule(r1);	 Catch:{ all -> 0x0020 }
        r1 = 11;
        r2.addRule(r1);	 Catch:{ all -> 0x0020 }
        goto L_0x0163;
    L_0x0265:
        r1 = move-exception;
        r2 = "Cannot show popup window: ";
        r1 = r1.getMessage();	 Catch:{ all -> 0x0020 }
        r1 = java.lang.String.valueOf(r1);	 Catch:{ all -> 0x0020 }
        r3 = r1.length();	 Catch:{ all -> 0x0020 }
        if (r3 == 0) goto L_0x02a8;
    L_0x0276:
        r1 = r2.concat(r1);	 Catch:{ all -> 0x0020 }
    L_0x027a:
        r12.m8636b(r1);	 Catch:{ all -> 0x0020 }
        r1 = r12.f4973r;	 Catch:{ all -> 0x0020 }
        r2 = r12.f4966k;	 Catch:{ all -> 0x0020 }
        r2 = r2.mo1503b();	 Catch:{ all -> 0x0020 }
        r1.removeView(r2);	 Catch:{ all -> 0x0020 }
        r1 = r12.f4974s;	 Catch:{ all -> 0x0020 }
        if (r1 == 0) goto L_0x02a5;
    L_0x028c:
        r1 = r12.f4974s;	 Catch:{ all -> 0x0020 }
        r2 = r12.f4969n;	 Catch:{ all -> 0x0020 }
        r1.removeView(r2);	 Catch:{ all -> 0x0020 }
        r1 = r12.f4974s;	 Catch:{ all -> 0x0020 }
        r2 = r12.f4966k;	 Catch:{ all -> 0x0020 }
        r2 = r2.mo1503b();	 Catch:{ all -> 0x0020 }
        r1.addView(r2);	 Catch:{ all -> 0x0020 }
        r1 = r12.f4966k;	 Catch:{ all -> 0x0020 }
        r2 = r12.f4968m;	 Catch:{ all -> 0x0020 }
        r1.mo1496a(r2);	 Catch:{ all -> 0x0020 }
    L_0x02a5:
        monitor-exit(r6);	 Catch:{ all -> 0x0020 }
        goto L_0x0010;
    L_0x02a8:
        r1 = new java.lang.String;	 Catch:{ all -> 0x0020 }
        r1.<init>(r2);	 Catch:{ all -> 0x0020 }
        goto L_0x027a;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.b.gp.a(java.util.Map):void");
    }

    public void m8650a(boolean z) {
        synchronized (this.f4965j) {
            if (this.f4972q != null) {
                this.f4972q.dismiss();
                this.f4973r.removeView(this.f4966k.mo1503b());
                if (this.f4974s != null) {
                    this.f4974s.removeView(this.f4969n);
                    this.f4974s.addView(this.f4966k.mo1503b());
                    this.f4966k.mo1496a(this.f4968m);
                }
                if (z) {
                    m8638d("default");
                    if (this.f4971p != null) {
                        this.f4971p.mo1000F();
                    }
                }
                this.f4972q = null;
                this.f4973r = null;
                this.f4974s = null;
                this.f4970o = null;
            }
        }
    }

    boolean m8651a() {
        return this.f4964i > -1 && this.f4961f > -1;
    }

    void m8652b(int i, int i2) {
        m8633a(i, i2 - C1319u.m7183e().m9244d(this.f4967l)[0], this.f4964i, this.f4961f);
    }

    public boolean m8653b() {
        boolean z;
        synchronized (this.f4965j) {
            z = this.f4972q != null;
        }
        return z;
    }

    public void m8654c(int i, int i2) {
        this.f4959d = i;
        this.f4960e = i2;
    }

    boolean m8655c() {
        int[] b = C1319u.m7183e().m9237b(this.f4967l);
        int[] d = C1319u.m7183e().m9244d(this.f4967l);
        int i = b[0];
        int i2 = b[1];
        if (this.f4964i < 50 || this.f4964i > i) {
            C1324b.m7234d("Width is too small or too large.");
            return false;
        } else if (this.f4961f < 50 || this.f4961f > i2) {
            C1324b.m7234d("Height is too small or too large.");
            return false;
        } else if (this.f4961f == i2 && this.f4964i == i) {
            C1324b.m7234d("Cannot resize to a full-screen ad.");
            return false;
        } else {
            if (this.f4958c) {
                int i3;
                String str = this.f4957b;
                boolean z = true;
                switch (str.hashCode()) {
                    case -1364013995:
                        if (str.equals("center")) {
                            z = true;
                            break;
                        }
                        break;
                    case -1012429441:
                        if (str.equals("top-left")) {
                            z = false;
                            break;
                        }
                        break;
                    case -655373719:
                        if (str.equals("bottom-left")) {
                            z = true;
                            break;
                        }
                        break;
                    case 1163912186:
                        if (str.equals("bottom-right")) {
                            z = true;
                            break;
                        }
                        break;
                    case 1288627767:
                        if (str.equals("bottom-center")) {
                            z = true;
                            break;
                        }
                        break;
                    case 1755462605:
                        if (str.equals("top-center")) {
                            z = true;
                            break;
                        }
                        break;
                }
                switch (z) {
                    case false:
                        i3 = this.f4962g + this.f4959d;
                        i2 = this.f4960e + this.f4963h;
                        break;
                    case true:
                        i3 = ((this.f4959d + this.f4962g) + (this.f4964i / 2)) - 25;
                        i2 = this.f4960e + this.f4963h;
                        break;
                    case true:
                        i3 = ((this.f4959d + this.f4962g) + (this.f4964i / 2)) - 25;
                        i2 = ((this.f4960e + this.f4963h) + (this.f4961f / 2)) - 25;
                        break;
                    case true:
                        i3 = this.f4962g + this.f4959d;
                        i2 = ((this.f4960e + this.f4963h) + this.f4961f) - 50;
                        break;
                    case true:
                        i3 = ((this.f4959d + this.f4962g) + (this.f4964i / 2)) - 25;
                        i2 = ((this.f4960e + this.f4963h) + this.f4961f) - 50;
                        break;
                    case true:
                        i3 = ((this.f4959d + this.f4962g) + this.f4964i) - 50;
                        i2 = ((this.f4960e + this.f4963h) + this.f4961f) - 50;
                        break;
                    default:
                        i3 = ((this.f4959d + this.f4962g) + this.f4964i) - 50;
                        i2 = this.f4960e + this.f4963h;
                        break;
                }
                if (i3 < 0 || i3 + 50 > i || r2 < d[0] || r2 + 50 > d[1]) {
                    return false;
                }
            }
            return true;
        }
    }
}
