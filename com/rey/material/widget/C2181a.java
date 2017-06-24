package com.rey.material.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.rey.material.C2167a.C2162b;
import com.rey.material.p041b.C2171a;
import com.rey.material.p041b.C2171a.C2169a;
import com.rey.material.p041b.C2172b;
import com.rey.material.p042c.C2176d;

public final class C2181a implements OnClickListener {
    private OnClickListener f7351a;
    private boolean f7352b = false;

    class C2180a implements Runnable {
        View f7349a;
        final /* synthetic */ C2181a f7350b;

        public C2180a(C2181a c2181a, View view) {
            this.f7350b = c2181a;
            this.f7349a = view;
        }

        public void run() {
            this.f7350b.f7352b = false;
            this.f7350b.m12427c(this.f7349a);
        }
    }

    public static void m12423a(View view) {
        Drawable background = view.getBackground();
        if (background instanceof C2171a) {
            ((C2171a) background).m12382c();
        } else if (background instanceof C2172b) {
            ((C2172b) background).m12390b();
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                C2181a.m12423a(viewGroup.getChildAt(i));
            }
        }
    }

    private Drawable m12426b(View view) {
        Drawable background = view.getBackground();
        return background == null ? null : background instanceof C2171a ? ((C2171a) background).m12377a() : background;
    }

    private void m12427c(View view) {
        if (this.f7351a != null) {
            this.f7351a.onClick(view);
        }
    }

    public void m12428a(OnClickListener onClickListener) {
        this.f7351a = onClickListener;
    }

    public void m12429a(View view, Context context, AttributeSet attributeSet, int i, int i2) {
        if (!view.isInEditMode()) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C2162b.RippleView, i, i2);
            int resourceId = obtainStyledAttributes.getResourceId(C2162b.RippleView_rd_style, 0);
            Drawable drawable = null;
            if (resourceId != 0) {
                drawable = new C2169a(context, resourceId).m12345a(m12426b(view)).m12347a();
            } else if (obtainStyledAttributes.getBoolean(C2162b.RippleView_rd_enable, false)) {
                drawable = new C2169a(context, attributeSet, i, i2).m12345a(m12426b(view)).m12347a();
            }
            obtainStyledAttributes.recycle();
            if (drawable != null) {
                C2176d.m12402a(view, drawable);
            }
        }
    }

    public boolean m12430a(View view, MotionEvent motionEvent) {
        Drawable background = view.getBackground();
        return background != null && (background instanceof C2171a) && ((C2171a) background).onTouch(view, motionEvent);
    }

    public void onClick(View view) {
        long b;
        Drawable background = view.getBackground();
        if (background != null) {
            if (background instanceof C2171a) {
                b = ((C2171a) background).m12381b();
            } else if (background instanceof C2172b) {
                b = ((C2172b) background).m12389a();
            }
            if (b > 0 || view.getHandler() == null || this.f7352b) {
                m12427c(view);
            }
            this.f7352b = true;
            view.getHandler().postDelayed(new C2180a(this, view), b);
            return;
        }
        b = 0;
        if (b > 0) {
        }
        m12427c(view);
    }
}
