package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ad;
import android.support.v7.p019b.C0694a.C0683a;
import android.util.AttributeSet;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import android.widget.TextView;

public class C0884i extends Button implements ad {
    private final C0893m f2701a;
    private final C0883h f2702b;
    private final C0822z f2703c;

    public C0884i(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0683a.buttonStyle);
    }

    public C0884i(Context context, AttributeSet attributeSet, int i) {
        super(be.m5206a(context), attributeSet, i);
        this.f2701a = C0893m.m5425a();
        this.f2702b = new C0883h(this, this.f2701a);
        this.f2702b.m5401a(attributeSet, i);
        this.f2703c = C0822z.m4833a((TextView) this);
        this.f2703c.mo773a(attributeSet, i);
        this.f2703c.mo772a();
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f2702b != null) {
            this.f2702b.m5404c();
        }
        if (this.f2703c != null) {
            this.f2703c.mo772a();
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        return this.f2702b != null ? this.f2702b.m5396a() : null;
    }

    public Mode getSupportBackgroundTintMode() {
        return this.f2702b != null ? this.f2702b.m5402b() : null;
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(Button.class.getName());
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(Button.class.getName());
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.f2702b != null) {
            this.f2702b.m5400a(drawable);
        }
    }

    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        if (this.f2702b != null) {
            this.f2702b.m5397a(i);
        }
    }

    public void setSupportAllCaps(boolean z) {
        if (this.f2703c != null) {
            this.f2703c.m4838a(z);
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (this.f2702b != null) {
            this.f2702b.m5398a(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(Mode mode) {
        if (this.f2702b != null) {
            this.f2702b.m5399a(mode);
        }
    }

    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        if (this.f2703c != null) {
            this.f2703c.m4835a(context, i);
        }
    }
}
