package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.google.android.gms.common.internal.C1902i;
import com.google.android.gms.p031b.cw;
import com.google.android.gms.p031b.cy;
import com.google.android.gms.p031b.id;
import com.google.android.gms.p031b.jz;
import com.google.android.gms.p031b.la;
import java.util.HashMap;
import java.util.Map;

@id
public class C1208k extends FrameLayout implements C1204h {
    private final la f3549a;
    private final FrameLayout f3550b;
    private final C1222y f3551c;
    private C1191i f3552d;
    private boolean f3553e;
    private boolean f3554f;
    private TextView f3555g;
    private long f3556h;
    private long f3557i;
    private String f3558j;
    private String f3559k;

    class C12061 implements Runnable {
        final /* synthetic */ C1208k f3547a;

        C12061(C1208k c1208k) {
            this.f3547a = c1208k;
        }

        public void run() {
            this.f3547a.m6697a("surfaceCreated", new String[0]);
        }
    }

    class C12072 implements Runnable {
        final /* synthetic */ C1208k f3548a;

        C12072(C1208k c1208k) {
            this.f3548a = c1208k;
        }

        public void run() {
            this.f3548a.m6697a("surfaceDestroyed", new String[0]);
        }
    }

    public C1208k(Context context, la laVar, int i, boolean z, cy cyVar, cw cwVar) {
        super(context);
        this.f3549a = laVar;
        this.f3550b = new FrameLayout(context);
        addView(this.f3550b, new LayoutParams(-1, -1));
        C1902i.m10816a(laVar.mo1515h());
        this.f3552d = laVar.mo1515h().f3283b.mo1153a(context, laVar, i, z, cyVar, cwVar);
        if (this.f3552d != null) {
            this.f3550b.addView(this.f3552d, new LayoutParams(-1, -1, 17));
        }
        this.f3555g = new TextView(context);
        this.f3555g.setBackgroundColor(-16777216);
        m6698o();
        this.f3551c = new C1222y(this);
        this.f3551c.m6782b();
        if (this.f3552d != null) {
            this.f3552d.mo1121a((C1204h) this);
        }
        if (this.f3552d == null) {
            mo1147a("AdVideoUnderlay Error", "Allocating player failed.");
        }
    }

    public static void m6696a(la laVar) {
        Map hashMap = new HashMap();
        hashMap.put("event", "no_video_view");
        laVar.mo1501a("onVideoEvent", hashMap);
    }

    private void m6697a(String str, String... strArr) {
        Map hashMap = new HashMap();
        hashMap.put("event", str);
        int length = strArr.length;
        int i = 0;
        Object obj = null;
        while (i < length) {
            Object obj2 = strArr[i];
            if (obj != null) {
                hashMap.put(obj, obj2);
                obj2 = null;
            }
            i++;
            obj = obj2;
        }
        this.f3549a.mo1501a("onVideoEvent", hashMap);
    }

    private void m6698o() {
        if (!m6700q()) {
            this.f3550b.addView(this.f3555g, new LayoutParams(-1, -1));
            this.f3550b.bringChildToFront(this.f3555g);
        }
    }

    private void m6699p() {
        if (m6700q()) {
            this.f3550b.removeView(this.f3555g);
        }
    }

    private boolean m6700q() {
        return this.f3555g.getParent() != null;
    }

    private void m6701r() {
        if (this.f3549a.mo1513f() != null && !this.f3553e) {
            this.f3554f = (this.f3549a.mo1513f().getWindow().getAttributes().flags & 128) != 0;
            if (!this.f3554f) {
                this.f3549a.mo1513f().getWindow().addFlags(128);
                this.f3553e = true;
            }
        }
    }

    private void m6702s() {
        if (this.f3549a.mo1513f() != null && this.f3553e && !this.f3554f) {
            this.f3549a.mo1513f().getWindow().clearFlags(128);
            this.f3553e = false;
        }
    }

    public void mo1146a() {
        jz.f5567a.post(new C12061(this));
    }

    public void m6704a(float f) {
        if (this.f3552d != null) {
            this.f3552d.mo1118a(f);
        }
    }

    public void m6705a(float f, float f2) {
        if (this.f3552d != null) {
            this.f3552d.mo1119a(f, f2);
        }
    }

    public void m6706a(int i) {
        if (this.f3552d != null) {
            this.f3552d.mo1120a(i);
        }
    }

    public void m6707a(int i, int i2, int i3, int i4) {
        if (i3 != 0 && i4 != 0) {
            ViewGroup.LayoutParams layoutParams = new LayoutParams(i3 + 2, i4 + 2);
            layoutParams.setMargins(i - 1, i2 - 1, 0, 0);
            this.f3550b.setLayoutParams(layoutParams);
            requestLayout();
        }
    }

    public void m6708a(MotionEvent motionEvent) {
        if (this.f3552d != null) {
            this.f3552d.dispatchTouchEvent(motionEvent);
        }
    }

    public void m6709a(String str) {
        this.f3559k = str;
    }

    public void mo1147a(String str, String str2) {
        m6697a("error", "what", str, "extra", str2);
    }

    public void mo1148b() {
        if (this.f3552d != null && this.f3557i == 0) {
            float duration = ((float) this.f3552d.getDuration()) / 1000.0f;
            int videoWidth = this.f3552d.getVideoWidth();
            int videoHeight = this.f3552d.getVideoHeight();
            m6697a("canplaythrough", "duration", String.valueOf(duration), "videoWidth", String.valueOf(videoWidth), "videoHeight", String.valueOf(videoHeight));
        }
    }

    public void mo1149c() {
        m6701r();
    }

    public void mo1150d() {
        m6697a("pause", new String[0]);
        m6702s();
    }

    public void mo1151e() {
        m6697a("ended", new String[0]);
        m6702s();
    }

    public void mo1152f() {
        m6698o();
        this.f3557i = this.f3556h;
        jz.f5567a.post(new C12072(this));
    }

    public void m6716g() {
        if (this.f3552d != null) {
            if (TextUtils.isEmpty(this.f3559k)) {
                m6697a("no_src", new String[0]);
                return;
            }
            this.f3552d.setMimeType(this.f3558j);
            this.f3552d.setVideoPath(this.f3559k);
        }
    }

    public void m6717h() {
        if (this.f3552d != null) {
            this.f3552d.mo1124d();
        }
    }

    public void m6718i() {
        if (this.f3552d != null) {
            this.f3552d.mo1123c();
        }
    }

    public void m6719j() {
        if (this.f3552d != null) {
            this.f3552d.mo1125e();
        }
    }

    public void m6720k() {
        if (this.f3552d != null) {
            this.f3552d.mo1126f();
        }
    }

    public void m6721l() {
        if (this.f3552d != null) {
            View textView = new TextView(this.f3552d.getContext());
            String str = "AdMob - ";
            String valueOf = String.valueOf(this.f3552d.mo1117a());
            textView.setText(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
            textView.setTextColor(-65536);
            textView.setBackgroundColor(-256);
            this.f3550b.addView(textView, new LayoutParams(-2, -2, 17));
            this.f3550b.bringChildToFront(textView);
        }
    }

    public void m6722m() {
        this.f3551c.m6781a();
        if (this.f3552d != null) {
            this.f3552d.mo1122b();
        }
        m6702s();
    }

    void m6723n() {
        if (this.f3552d != null) {
            long currentPosition = (long) this.f3552d.getCurrentPosition();
            if (this.f3556h != currentPosition && currentPosition > 0) {
                m6699p();
                float f = ((float) currentPosition) / 1000.0f;
                m6697a("timeupdate", "time", String.valueOf(f));
                this.f3556h = currentPosition;
            }
        }
    }

    public void setMimeType(String str) {
        this.f3558j = str;
    }
}
