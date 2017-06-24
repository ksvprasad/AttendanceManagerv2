package com.google.android.gms.p031b;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import com.google.android.gms.ads.internal.util.client.C1324b;
import com.google.android.gms.p031b.hs.C1042a;
import com.google.android.gms.p031b.jl.C1632a;

@id
@TargetApi(19)
public class hu extends ht {
    private Object f5064g = new Object();
    private PopupWindow f5065h;
    private boolean f5066i = false;

    hu(Context context, C1632a c1632a, la laVar, C1042a c1042a) {
        super(context, c1632a, laVar, c1042a);
    }

    private void m8770g() {
        synchronized (this.f5064g) {
            this.f5066i = true;
            if ((this.b instanceof Activity) && ((Activity) this.b).isDestroyed()) {
                this.f5065h = null;
            }
            if (this.f5065h != null) {
                if (this.f5065h.isShowing()) {
                    this.f5065h.dismiss();
                }
                this.f5065h = null;
            }
        }
    }

    protected void mo1435a(int i) {
        m8770g();
        super.mo1435a(i);
    }

    public void mo1106d() {
        m8770g();
        super.mo1106d();
    }

    protected void mo1436f() {
        Window window = this.b instanceof Activity ? ((Activity) this.b).getWindow() : null;
        if (window != null && window.getDecorView() != null && !((Activity) this.b).isDestroyed()) {
            View frameLayout = new FrameLayout(this.b);
            frameLayout.setLayoutParams(new LayoutParams(-1, -1));
            frameLayout.addView(this.c.mo1503b(), -1, -1);
            synchronized (this.f5064g) {
                if (this.f5066i) {
                    return;
                }
                this.f5065h = new PopupWindow(frameLayout, 1, 1, false);
                this.f5065h.setOutsideTouchable(true);
                this.f5065h.setClippingEnabled(false);
                C1324b.m7227a("Displaying the 1x1 popup off the screen.");
                try {
                    this.f5065h.showAtLocation(window.getDecorView(), 0, -1, -1);
                } catch (Exception e) {
                    this.f5065h = null;
                }
            }
        }
    }
}
