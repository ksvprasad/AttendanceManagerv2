package android.support.v7.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import android.support.v4.widget.C0589o;
import android.support.v7.p019b.C0694a.C0693k;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.widget.PopupWindow;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;

public class C0898s extends PopupWindow {
    private static final boolean f2742a = (VERSION.SDK_INT < 21);
    private boolean f2743b;

    public C0898s(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        bh a = bh.m5210a(context, attributeSet, C0693k.PopupWindow, i, 0);
        if (a.m5225f(C0693k.PopupWindow_overlapAnchor)) {
            m5455a(a.m5215a(C0693k.PopupWindow_overlapAnchor, false));
        }
        setBackgroundDrawable(a.m5213a(C0693k.PopupWindow_android_popupBackground));
        a.m5214a();
        if (VERSION.SDK_INT < 14) {
            C0898s.m5454a((PopupWindow) this);
        }
    }

    private static void m5454a(final PopupWindow popupWindow) {
        try {
            final Field declaredField = PopupWindow.class.getDeclaredField("mAnchor");
            declaredField.setAccessible(true);
            Field declaredField2 = PopupWindow.class.getDeclaredField("mOnScrollChangedListener");
            declaredField2.setAccessible(true);
            final OnScrollChangedListener onScrollChangedListener = (OnScrollChangedListener) declaredField2.get(popupWindow);
            declaredField2.set(popupWindow, new OnScrollChangedListener() {
                public void onScrollChanged() {
                    try {
                        WeakReference weakReference = (WeakReference) declaredField.get(popupWindow);
                        if (weakReference != null && weakReference.get() != null) {
                            onScrollChangedListener.onScrollChanged();
                        }
                    } catch (IllegalAccessException e) {
                    }
                }
            });
        } catch (Throwable e) {
            Log.d("AppCompatPopupWindow", "Exception while installing workaround OnScrollChangedListener", e);
        }
    }

    public void m5455a(boolean z) {
        if (f2742a) {
            this.f2743b = z;
        } else {
            C0589o.m3138a((PopupWindow) this, z);
        }
    }

    public void showAsDropDown(View view, int i, int i2) {
        if (f2742a && this.f2743b) {
            i2 -= view.getHeight();
        }
        super.showAsDropDown(view, i, i2);
    }

    @TargetApi(19)
    public void showAsDropDown(View view, int i, int i2, int i3) {
        if (f2742a && this.f2743b) {
            i2 -= view.getHeight();
        }
        super.showAsDropDown(view, i, i2, i3);
    }

    public void update(View view, int i, int i2, int i3, int i4) {
        int height = (f2742a && this.f2743b) ? i2 - view.getHeight() : i2;
        super.update(view, i, height, i3, i4);
    }
}
