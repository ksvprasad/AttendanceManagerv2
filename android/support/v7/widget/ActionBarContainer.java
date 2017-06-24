package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v7.p019b.C0694a.C0688f;
import android.support.v7.p019b.C0694a.C0693k;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;

public class ActionBarContainer extends FrameLayout {
    Drawable f1928a;
    Drawable f1929b;
    Drawable f1930c;
    boolean f1931d;
    boolean f1932e;
    private boolean f1933f;
    private View f1934g;
    private View f1935h;
    private View f1936i;
    private int f1937j;

    public ActionBarContainer(Context context) {
        this(context, null);
    }

    public ActionBarContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setBackgroundDrawable(VERSION.SDK_INT >= 21 ? new C0863c(this) : new C0858b(this));
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0693k.ActionBar);
        this.f1928a = obtainStyledAttributes.getDrawable(C0693k.ActionBar_background);
        this.f1929b = obtainStyledAttributes.getDrawable(C0693k.ActionBar_backgroundStacked);
        this.f1937j = obtainStyledAttributes.getDimensionPixelSize(C0693k.ActionBar_height, -1);
        if (getId() == C0688f.split_action_bar) {
            this.f1931d = true;
            this.f1930c = obtainStyledAttributes.getDrawable(C0693k.ActionBar_backgroundSplit);
        }
        obtainStyledAttributes.recycle();
        boolean z = this.f1931d ? this.f1930c == null : this.f1928a == null && this.f1929b == null;
        setWillNotDraw(z);
    }

    private boolean m3935a(View view) {
        return view == null || view.getVisibility() == 8 || view.getMeasuredHeight() == 0;
    }

    private int m3936b(View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        return layoutParams.bottomMargin + (view.getMeasuredHeight() + layoutParams.topMargin);
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f1928a != null && this.f1928a.isStateful()) {
            this.f1928a.setState(getDrawableState());
        }
        if (this.f1929b != null && this.f1929b.isStateful()) {
            this.f1929b.setState(getDrawableState());
        }
        if (this.f1930c != null && this.f1930c.isStateful()) {
            this.f1930c.setState(getDrawableState());
        }
    }

    public View getTabContainer() {
        return this.f1934g;
    }

    public void jumpDrawablesToCurrentState() {
        if (VERSION.SDK_INT >= 11) {
            super.jumpDrawablesToCurrentState();
            if (this.f1928a != null) {
                this.f1928a.jumpToCurrentState();
            }
            if (this.f1929b != null) {
                this.f1929b.jumpToCurrentState();
            }
            if (this.f1930c != null) {
                this.f1930c.jumpToCurrentState();
            }
        }
    }

    public void onFinishInflate() {
        super.onFinishInflate();
        this.f1935h = findViewById(C0688f.action_bar);
        this.f1936i = findViewById(C0688f.action_context_bar);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.f1933f || super.onInterceptTouchEvent(motionEvent);
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5 = 1;
        super.onLayout(z, i, i2, i3, i4);
        View view = this.f1934g;
        boolean z2 = (view == null || view.getVisibility() == 8) ? false : true;
        if (!(view == null || view.getVisibility() == 8)) {
            int measuredHeight = getMeasuredHeight();
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            view.layout(i, (measuredHeight - view.getMeasuredHeight()) - layoutParams.bottomMargin, i3, measuredHeight - layoutParams.bottomMargin);
        }
        if (!this.f1931d) {
            int i6;
            if (this.f1928a != null) {
                if (this.f1935h.getVisibility() == 0) {
                    this.f1928a.setBounds(this.f1935h.getLeft(), this.f1935h.getTop(), this.f1935h.getRight(), this.f1935h.getBottom());
                } else if (this.f1936i == null || this.f1936i.getVisibility() != 0) {
                    this.f1928a.setBounds(0, 0, 0, 0);
                } else {
                    this.f1928a.setBounds(this.f1936i.getLeft(), this.f1936i.getTop(), this.f1936i.getRight(), this.f1936i.getBottom());
                }
                i6 = 1;
            } else {
                i6 = 0;
            }
            this.f1932e = z2;
            if (!z2 || this.f1929b == null) {
                i5 = i6;
            } else {
                this.f1929b.setBounds(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            }
        } else if (this.f1930c != null) {
            this.f1930c.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
        } else {
            i5 = 0;
        }
        if (i5 != 0) {
            invalidate();
        }
    }

    public void onMeasure(int i, int i2) {
        if (this.f1935h == null && MeasureSpec.getMode(i2) == Integer.MIN_VALUE && this.f1937j >= 0) {
            i2 = MeasureSpec.makeMeasureSpec(Math.min(this.f1937j, MeasureSpec.getSize(i2)), Integer.MIN_VALUE);
        }
        super.onMeasure(i, i2);
        if (this.f1935h != null) {
            int mode = MeasureSpec.getMode(i2);
            if (this.f1934g != null && this.f1934g.getVisibility() != 8 && mode != 1073741824) {
                int b = !m3935a(this.f1935h) ? m3936b(this.f1935h) : !m3935a(this.f1936i) ? m3936b(this.f1936i) : 0;
                setMeasuredDimension(getMeasuredWidth(), Math.min(b + m3936b(this.f1934g), mode == Integer.MIN_VALUE ? MeasureSpec.getSize(i2) : Integer.MAX_VALUE));
            }
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        return true;
    }

    public void setPrimaryBackground(Drawable drawable) {
        boolean z = true;
        if (this.f1928a != null) {
            this.f1928a.setCallback(null);
            unscheduleDrawable(this.f1928a);
        }
        this.f1928a = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.f1935h != null) {
                this.f1928a.setBounds(this.f1935h.getLeft(), this.f1935h.getTop(), this.f1935h.getRight(), this.f1935h.getBottom());
            }
        }
        if (this.f1931d) {
            if (this.f1930c != null) {
                z = false;
            }
        } else if (!(this.f1928a == null && this.f1929b == null)) {
            z = false;
        }
        setWillNotDraw(z);
        invalidate();
    }

    public void setSplitBackground(Drawable drawable) {
        boolean z = true;
        if (this.f1930c != null) {
            this.f1930c.setCallback(null);
            unscheduleDrawable(this.f1930c);
        }
        this.f1930c = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.f1931d && this.f1930c != null) {
                this.f1930c.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            }
        }
        if (this.f1931d) {
            if (this.f1930c != null) {
                z = false;
            }
        } else if (!(this.f1928a == null && this.f1929b == null)) {
            z = false;
        }
        setWillNotDraw(z);
        invalidate();
    }

    public void setStackedBackground(Drawable drawable) {
        boolean z = true;
        if (this.f1929b != null) {
            this.f1929b.setCallback(null);
            unscheduleDrawable(this.f1929b);
        }
        this.f1929b = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.f1932e && this.f1929b != null) {
                this.f1929b.setBounds(this.f1934g.getLeft(), this.f1934g.getTop(), this.f1934g.getRight(), this.f1934g.getBottom());
            }
        }
        if (this.f1931d) {
            if (this.f1930c != null) {
                z = false;
            }
        } else if (!(this.f1928a == null && this.f1929b == null)) {
            z = false;
        }
        setWillNotDraw(z);
        invalidate();
    }

    public void setTabContainer(az azVar) {
        if (this.f1934g != null) {
            removeView(this.f1934g);
        }
        this.f1934g = azVar;
        if (azVar != null) {
            addView(azVar);
            ViewGroup.LayoutParams layoutParams = azVar.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -2;
            azVar.setAllowCollapse(false);
        }
    }

    public void setTransitioning(boolean z) {
        this.f1933f = z;
        setDescendantFocusability(z ? 393216 : 262144);
    }

    public void setVisibility(int i) {
        super.setVisibility(i);
        boolean z = i == 0;
        if (this.f1928a != null) {
            this.f1928a.setVisible(z, false);
        }
        if (this.f1929b != null) {
            this.f1929b.setVisible(z, false);
        }
        if (this.f1930c != null) {
            this.f1930c.setVisible(z, false);
        }
    }

    public ActionMode startActionModeForChild(View view, Callback callback) {
        return null;
    }

    protected boolean verifyDrawable(Drawable drawable) {
        return (drawable == this.f1928a && !this.f1931d) || ((drawable == this.f1929b && this.f1932e) || ((drawable == this.f1930c && this.f1931d) || super.verifyDrawable(drawable)));
    }
}
