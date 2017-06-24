package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.support.v4.view.C0543s;
import android.support.v4.view.ag;
import android.support.v4.view.aw;
import android.support.v4.view.ba;
import android.support.v7.p019b.C0694a.C0683a;
import android.support.v7.p019b.C0694a.C0693k;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;

abstract class C0745a extends ViewGroup {
    protected final C0821a f1940a;
    protected final Context f1941b;
    protected ActionMenuView f1942c;
    protected C0873d f1943d;
    protected int f1944e;
    protected aw f1945f;
    private boolean f1946g;
    private boolean f1947h;

    protected class C0821a implements ba {
        int f2356a;
        final /* synthetic */ C0745a f2357b;
        private boolean f2358c = false;

        protected C0821a(C0745a c0745a) {
            this.f2357b = c0745a;
        }

        public C0821a m4828a(aw awVar, int i) {
            this.f2357b.f1945f = awVar;
            this.f2356a = i;
            return this;
        }

        public void mo98a(View view) {
            super.setVisibility(0);
            this.f2358c = false;
        }

        public void mo99b(View view) {
            if (!this.f2358c) {
                this.f2357b.f1945f = null;
                super.setVisibility(this.f2356a);
            }
        }

        public void mo100c(View view) {
            this.f2358c = true;
        }
    }

    C0745a(Context context) {
        this(context, null);
    }

    C0745a(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    C0745a(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1940a = new C0821a(this);
        TypedValue typedValue = new TypedValue();
        if (!context.getTheme().resolveAttribute(C0683a.actionBarPopupTheme, typedValue, true) || typedValue.resourceId == 0) {
            this.f1941b = context;
        } else {
            this.f1941b = new ContextThemeWrapper(context, typedValue.resourceId);
        }
    }

    protected static int m3937a(int i, int i2, boolean z) {
        return z ? i - i2 : i + i2;
    }

    protected int m3940a(View view, int i, int i2, int i3) {
        view.measure(MeasureSpec.makeMeasureSpec(i, Integer.MIN_VALUE), i2);
        return Math.max(0, (i - view.getMeasuredWidth()) - i3);
    }

    protected int m3941a(View view, int i, int i2, int i3, boolean z) {
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        int i4 = ((i3 - measuredHeight) / 2) + i2;
        if (z) {
            view.layout(i - measuredWidth, i4, i, measuredHeight + i4);
        } else {
            view.layout(i, i4, i + measuredWidth, measuredHeight + i4);
        }
        return z ? -measuredWidth : measuredWidth;
    }

    public aw mo666a(int i, long j) {
        if (this.f1945f != null) {
            this.f1945f.m2734b();
        }
        if (i == 0) {
            if (getVisibility() != 0) {
                ag.m2528c((View) this, 0.0f);
            }
            aw a = ag.m2549q(this).m2727a(1.0f);
            a.m2728a(j);
            a.m2729a(this.f1940a.m4828a(a, i));
            return a;
        }
        a = ag.m2549q(this).m2727a(0.0f);
        a.m2728a(j);
        a.m2729a(this.f1940a.m4828a(a, i));
        return a;
    }

    public boolean mo667a() {
        return this.f1943d != null ? this.f1943d.m5342d() : false;
    }

    public int getAnimatedVisibility() {
        return this.f1945f != null ? this.f1940a.f2356a : getVisibility();
    }

    public int getContentHeight() {
        return this.f1944e;
    }

    protected void onConfigurationChanged(Configuration configuration) {
        if (VERSION.SDK_INT >= 8) {
            super.onConfigurationChanged(configuration);
        }
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(null, C0693k.ActionBar, C0683a.actionBarStyle, 0);
        setContentHeight(obtainStyledAttributes.getLayoutDimension(C0693k.ActionBar_height, 0));
        obtainStyledAttributes.recycle();
        if (this.f1943d != null) {
            this.f1943d.m5328a(configuration);
        }
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        int a = C0543s.m2893a(motionEvent);
        if (a == 9) {
            this.f1947h = false;
        }
        if (!this.f1947h) {
            boolean onHoverEvent = super.onHoverEvent(motionEvent);
            if (a == 9 && !onHoverEvent) {
                this.f1947h = true;
            }
        }
        if (a == 10 || a == 3) {
            this.f1947h = false;
        }
        return true;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int a = C0543s.m2893a(motionEvent);
        if (a == 0) {
            this.f1946g = false;
        }
        if (!this.f1946g) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            if (a == 0 && !onTouchEvent) {
                this.f1946g = true;
            }
        }
        if (a == 1 || a == 3) {
            this.f1946g = false;
        }
        return true;
    }

    public void setContentHeight(int i) {
        this.f1944e = i;
        requestLayout();
    }

    public void setVisibility(int i) {
        if (i != getVisibility()) {
            if (this.f1945f != null) {
                this.f1945f.m2734b();
            }
            super.setVisibility(i);
        }
    }
}
