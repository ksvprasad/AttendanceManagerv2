package android.support.v7.p018a;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v7.p019b.C0694a.C0693k;
import android.support.v7.view.C0679b;
import android.support.v7.view.C0679b.C0657a;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;

public abstract class C0614a {

    public static class C0611a extends MarginLayoutParams {
        public int f1411a;

        public C0611a(int i, int i2) {
            super(i, i2);
            this.f1411a = 0;
            this.f1411a = 8388627;
        }

        public C0611a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f1411a = 0;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0693k.ActionBarLayout);
            this.f1411a = obtainStyledAttributes.getInt(C0693k.ActionBarLayout_android_layout_gravity, 0);
            obtainStyledAttributes.recycle();
        }

        public C0611a(C0611a c0611a) {
            super(c0611a);
            this.f1411a = 0;
            this.f1411a = c0611a.f1411a;
        }

        public C0611a(LayoutParams layoutParams) {
            super(layoutParams);
            this.f1411a = 0;
        }
    }

    public interface C0612b {
        void m3231a(boolean z);
    }

    public static abstract class C0613c {
        public abstract Drawable m3232a();

        public abstract CharSequence m3233b();

        public abstract View m3234c();

        public abstract void m3235d();

        public abstract CharSequence m3236e();
    }

    public abstract int mo578a();

    public C0679b mo611a(C0657a c0657a) {
        return null;
    }

    public void mo579a(float f) {
        if (f != 0.0f) {
            throw new UnsupportedOperationException("Setting a non-zero elevation is not supported in this action bar configuration.");
        }
    }

    public void mo580a(Configuration configuration) {
    }

    public abstract void mo581a(CharSequence charSequence);

    public abstract void mo582a(boolean z);

    public boolean mo583a(int i, KeyEvent keyEvent) {
        return false;
    }

    public void mo584b(CharSequence charSequence) {
    }

    public abstract void mo585b(boolean z);

    public abstract boolean mo586b();

    public Context mo587c() {
        return null;
    }

    public void mo588c(boolean z) {
    }

    public int mo613d() {
        return 0;
    }

    public void mo614d(boolean z) {
        if (z) {
            throw new UnsupportedOperationException("Hide on content scroll is not supported in this action bar configuration.");
        }
    }

    public void mo589e(boolean z) {
    }

    public boolean mo590e() {
        return false;
    }

    public void mo591f(boolean z) {
    }

    public boolean mo592f() {
        return false;
    }

    public void mo593g(boolean z) {
    }

    boolean mo594g() {
        return false;
    }

    void mo595h() {
    }
}
