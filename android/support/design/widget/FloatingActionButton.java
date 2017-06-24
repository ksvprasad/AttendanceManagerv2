package android.support.design.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.design.C0048a.C0042d;
import android.support.design.C0048a.C0046h;
import android.support.design.C0048a.C0047i;
import android.support.design.widget.C0144j.C0082a;
import android.support.design.widget.C0170v.C0054c;
import android.support.design.widget.CoordinatorLayout.C0059b;
import android.support.design.widget.CoordinatorLayout.C0076c;
import android.support.design.widget.CoordinatorLayout.C0078e;
import android.support.design.widget.Snackbar.SnackbarLayout;
import android.support.v4.view.ag;
import android.support.v7.widget.C0893m;
import android.support.v7.widget.C0895p;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.View.MeasureSpec;
import java.util.List;

@C0076c(a = Behavior.class)
public class FloatingActionButton extends ae {
    private ColorStateList f387a;
    private Mode f388b;
    private int f389c;
    private int f390d;
    private int f391e;
    private int f392f;
    private boolean f393g;
    private final Rect f394h;
    private C0895p f395i;
    private C0144j f396j;

    public static class Behavior extends C0059b<FloatingActionButton> {
        private static final boolean f381a = (VERSION.SDK_INT >= 11);
        private C0170v f382b;
        private float f383c;
        private Rect f384d;

        private float m615a(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton) {
            float f = 0.0f;
            List d = coordinatorLayout.m608d((View) floatingActionButton);
            int size = d.size();
            int i = 0;
            while (i < size) {
                View view = (View) d.get(i);
                float min = ((view instanceof SnackbarLayout) && coordinatorLayout.m599a((View) floatingActionButton, view)) ? Math.min(f, ag.m2546n(view) - ((float) view.getHeight())) : f;
                i++;
                f = min;
            }
            return f;
        }

        private boolean m616a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, FloatingActionButton floatingActionButton) {
            if (((C0078e) floatingActionButton.getLayoutParams()).m551a() != appBarLayout.getId()) {
                return false;
            }
            if (floatingActionButton.getUserSetVisibility() != 0) {
                return false;
            }
            if (this.f384d == null) {
                this.f384d = new Rect();
            }
            Rect rect = this.f384d;
            C0180y.m1120b(coordinatorLayout, appBarLayout, rect);
            if (rect.bottom <= appBarLayout.getMinimumHeightForVisibleOverlappingContent()) {
                floatingActionButton.m645b(null, false);
            } else {
                floatingActionButton.m641a(null, false);
            }
            return true;
        }

        private void m617b(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton) {
            int i = 0;
            Rect a = floatingActionButton.f394h;
            if (a != null && a.centerX() > 0 && a.centerY() > 0) {
                C0078e c0078e = (C0078e) floatingActionButton.getLayoutParams();
                int i2 = floatingActionButton.getRight() >= coordinatorLayout.getWidth() - c0078e.rightMargin ? a.right : floatingActionButton.getLeft() <= c0078e.leftMargin ? -a.left : 0;
                if (floatingActionButton.getBottom() >= coordinatorLayout.getBottom() - c0078e.bottomMargin) {
                    i = a.bottom;
                } else if (floatingActionButton.getTop() <= c0078e.topMargin) {
                    i = -a.top;
                }
                floatingActionButton.offsetTopAndBottom(i);
                floatingActionButton.offsetLeftAndRight(i2);
            }
        }

        private void m618d(CoordinatorLayout coordinatorLayout, final FloatingActionButton floatingActionButton, View view) {
            float a = m615a(coordinatorLayout, floatingActionButton);
            if (this.f383c != a) {
                float n = ag.m2546n(floatingActionButton);
                if (this.f382b != null && this.f382b.m1082b()) {
                    this.f382b.m1085e();
                }
                if (!floatingActionButton.isShown() || Math.abs(n - a) <= ((float) floatingActionButton.getHeight()) * 0.667f) {
                    ag.m2524b((View) floatingActionButton, a);
                } else {
                    if (this.f382b == null) {
                        this.f382b = ac.m890a();
                        this.f382b.m1081a(C0127a.f537b);
                        this.f382b.m1080a(new C0054c(this) {
                            final /* synthetic */ Behavior f380b;

                            public void mo39a(C0170v c0170v) {
                                ag.m2524b(floatingActionButton, c0170v.m1084d());
                            }
                        });
                    }
                    this.f382b.m1076a(n, a);
                    this.f382b.m1075a();
                }
                this.f383c = a;
            }
        }

        public boolean m619a(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, int i) {
            List d = coordinatorLayout.m608d((View) floatingActionButton);
            int size = d.size();
            for (int i2 = 0; i2 < size; i2++) {
                View view = (View) d.get(i2);
                if ((view instanceof AppBarLayout) && m616a(coordinatorLayout, (AppBarLayout) view, floatingActionButton)) {
                    break;
                }
            }
            coordinatorLayout.m592a((View) floatingActionButton, i);
            m617b(coordinatorLayout, floatingActionButton);
            return true;
        }

        public boolean m620a(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, View view) {
            return f381a && (view instanceof SnackbarLayout);
        }

        public boolean m622b(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, View view) {
            if (view instanceof SnackbarLayout) {
                m618d(coordinatorLayout, floatingActionButton, view);
            } else if (view instanceof AppBarLayout) {
                m616a(coordinatorLayout, (AppBarLayout) view, floatingActionButton);
            }
            return false;
        }

        public /* synthetic */ boolean mo65b(CoordinatorLayout coordinatorLayout, View view, View view2) {
            return m620a(coordinatorLayout, (FloatingActionButton) view, view2);
        }

        public void m624c(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, View view) {
            if (view instanceof SnackbarLayout) {
                m618d(coordinatorLayout, floatingActionButton, view);
            }
        }

        public /* synthetic */ boolean mo66c(CoordinatorLayout coordinatorLayout, View view, View view2) {
            return m622b(coordinatorLayout, (FloatingActionButton) view, view2);
        }

        public /* synthetic */ void mo85d(CoordinatorLayout coordinatorLayout, View view, View view2) {
            m624c(coordinatorLayout, (FloatingActionButton) view, view2);
        }
    }

    public static abstract class C0085a {
        public void m627a(FloatingActionButton floatingActionButton) {
        }

        public void m628b(FloatingActionButton floatingActionButton) {
        }
    }

    private class C0087b implements C0086p {
        final /* synthetic */ FloatingActionButton f385a;

        private C0087b(FloatingActionButton floatingActionButton) {
            this.f385a = floatingActionButton;
        }

        public float mo86a() {
            return ((float) this.f385a.getSizeDimension()) / 2.0f;
        }

        public void mo87a(int i, int i2, int i3, int i4) {
            this.f385a.f394h.set(i, i2, i3, i4);
            this.f385a.setPadding(this.f385a.f392f + i, this.f385a.f392f + i2, this.f385a.f392f + i3, this.f385a.f392f + i4);
        }

        public void mo88a(Drawable drawable) {
            super.setBackgroundDrawable(drawable);
        }

        public boolean mo89b() {
            return this.f385a.f393g;
        }
    }

    public FloatingActionButton(Context context) {
        this(context, null);
    }

    public FloatingActionButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FloatingActionButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f394h = new Rect();
        C0164u.m1053a(context);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0047i.FloatingActionButton, i, C0046h.Widget_Design_FloatingActionButton);
        this.f387a = obtainStyledAttributes.getColorStateList(C0047i.FloatingActionButton_backgroundTint);
        this.f388b = m639a(obtainStyledAttributes.getInt(C0047i.FloatingActionButton_backgroundTintMode, -1), null);
        this.f390d = obtainStyledAttributes.getColor(C0047i.FloatingActionButton_rippleColor, 0);
        this.f391e = obtainStyledAttributes.getInt(C0047i.FloatingActionButton_fabSize, 0);
        this.f389c = obtainStyledAttributes.getDimensionPixelSize(C0047i.FloatingActionButton_borderWidth, 0);
        float dimension = obtainStyledAttributes.getDimension(C0047i.FloatingActionButton_elevation, 0.0f);
        float dimension2 = obtainStyledAttributes.getDimension(C0047i.FloatingActionButton_pressedTranslationZ, 0.0f);
        this.f393g = obtainStyledAttributes.getBoolean(C0047i.FloatingActionButton_useCompatPadding, false);
        obtainStyledAttributes.recycle();
        this.f395i = new C0895p(this, C0893m.m5425a());
        this.f395i.m5453a(attributeSet, i);
        this.f392f = (getSizeDimension() - ((int) getResources().getDimension(C0042d.design_fab_image_size))) / 2;
        getImpl().mo126a(this.f387a, this.f388b, this.f390d, this.f389c);
        getImpl().m963c(dimension);
        getImpl().m964d(dimension2);
        getImpl().m968g();
    }

    private static int m638a(int i, int i2) {
        int mode = MeasureSpec.getMode(i2);
        int size = MeasureSpec.getSize(i2);
        switch (mode) {
            case Integer.MIN_VALUE:
                return Math.min(i, size);
            case 1073741824:
                return size;
            default:
                return i;
        }
    }

    static Mode m639a(int i, Mode mode) {
        switch (i) {
            case 3:
                return Mode.SRC_OVER;
            case 5:
                return Mode.SRC_IN;
            case 9:
                return Mode.SRC_ATOP;
            case 14:
                return Mode.MULTIPLY;
            case 15:
                return Mode.SCREEN;
            default:
                return mode;
        }
    }

    private void m641a(C0085a c0085a, boolean z) {
        getImpl().mo133b(m647c(c0085a), z);
    }

    private void m645b(C0085a c0085a, boolean z) {
        getImpl().mo129a(m647c(c0085a), z);
    }

    private C0082a m647c(final C0085a c0085a) {
        return c0085a == null ? null : new C0082a(this) {
            final /* synthetic */ FloatingActionButton f378b;

            public void mo83a() {
                c0085a.m627a(this.f378b);
            }

            public void mo84b() {
                c0085a.m628b(this.f378b);
            }
        };
    }

    private C0144j m648c() {
        int i = VERSION.SDK_INT;
        return i >= 21 ? new C0150k(this, new C0087b()) : i >= 14 ? new C0148i(this, new C0087b()) : new C0145h(this, new C0087b());
    }

    private C0144j getImpl() {
        if (this.f396j == null) {
            this.f396j = m648c();
        }
        return this.f396j;
    }

    public void m650a() {
        m651a(null);
    }

    public void m651a(C0085a c0085a) {
        m641a(c0085a, true);
    }

    public void m652b() {
        m653b(null);
    }

    public void m653b(C0085a c0085a) {
        m645b(c0085a, true);
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        getImpl().mo130a(getDrawableState());
    }

    public ColorStateList getBackgroundTintList() {
        return this.f387a;
    }

    public Mode getBackgroundTintMode() {
        return this.f388b;
    }

    public float getCompatElevation() {
        return getImpl().mo122a();
    }

    public Drawable getContentBackground() {
        return getImpl().m967f();
    }

    final int getSizeDimension() {
        switch (this.f391e) {
            case 1:
                return getResources().getDimensionPixelSize(C0042d.design_fab_size_mini);
            default:
                return getResources().getDimensionPixelSize(C0042d.design_fab_size_normal);
        }
    }

    public boolean getUseCompatPadding() {
        return this.f393g;
    }

    @TargetApi(11)
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        getImpl().mo131b();
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        getImpl().m969h();
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getImpl().m970i();
    }

    protected void onMeasure(int i, int i2) {
        int sizeDimension = getSizeDimension();
        sizeDimension = Math.min(m638a(sizeDimension, i), m638a(sizeDimension, i2));
        setMeasuredDimension((this.f394h.left + sizeDimension) + this.f394h.right, (sizeDimension + this.f394h.top) + this.f394h.bottom);
    }

    public void setBackgroundColor(int i) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    public void setBackgroundDrawable(Drawable drawable) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    public void setBackgroundResource(int i) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    public void setBackgroundTintList(ColorStateList colorStateList) {
        if (this.f387a != colorStateList) {
            this.f387a = colorStateList;
            getImpl().mo125a(colorStateList);
        }
    }

    public void setBackgroundTintMode(Mode mode) {
        if (this.f388b != mode) {
            this.f388b = mode;
            getImpl().mo127a(mode);
        }
    }

    public void setCompatElevation(float f) {
        getImpl().m963c(f);
    }

    public void setImageResource(int i) {
        this.f395i.m5452a(i);
    }

    public void setRippleColor(int i) {
        if (this.f390d != i) {
            this.f390d = i;
            getImpl().mo124a(i);
        }
    }

    public void setUseCompatPadding(boolean z) {
        if (this.f393g != z) {
            this.f393g = z;
            getImpl().mo134c();
        }
    }

    public /* bridge */ /* synthetic */ void setVisibility(int i) {
        super.setVisibility(i);
    }
}
