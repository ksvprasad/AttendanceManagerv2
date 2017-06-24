package android.support.v7.widget;

import android.content.Context;
import android.os.Build.VERSION;
import android.support.v4.view.aw;
import android.support.v7.p019b.C0694a.C0683a;
import android.support.v7.p019b.C0694a.C0688f;
import android.support.v7.p019b.C0694a.C0690h;
import android.support.v7.p019b.C0694a.C0693k;
import android.support.v7.view.C0679b;
import android.support.v7.view.menu.C0727f;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ActionBarContextView extends C0745a {
    private CharSequence f1948g;
    private CharSequence f1949h;
    private View f1950i;
    private View f1951j;
    private LinearLayout f1952k;
    private TextView f1953l;
    private TextView f1954m;
    private int f1955n;
    private int f1956o;
    private boolean f1957p;
    private int f1958q;

    public ActionBarContextView(Context context) {
        this(context, null);
    }

    public ActionBarContextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0683a.actionModeStyle);
    }

    public ActionBarContextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        bh a = bh.m5210a(context, attributeSet, C0693k.ActionMode, i, 0);
        setBackgroundDrawable(a.m5213a(C0693k.ActionMode_background));
        this.f1955n = a.m5226g(C0693k.ActionMode_titleTextStyle, 0);
        this.f1956o = a.m5226g(C0693k.ActionMode_subtitleTextStyle, 0);
        this.e = a.m5224f(C0693k.ActionMode_height, 0);
        this.f1958q = a.m5226g(C0693k.ActionMode_closeItemLayout, C0690h.abc_action_mode_close_item_material);
        a.m5214a();
    }

    private void m3944e() {
        int i = 8;
        Object obj = 1;
        if (this.f1952k == null) {
            LayoutInflater.from(getContext()).inflate(C0690h.abc_action_bar_title_item, this);
            this.f1952k = (LinearLayout) getChildAt(getChildCount() - 1);
            this.f1953l = (TextView) this.f1952k.findViewById(C0688f.action_bar_title);
            this.f1954m = (TextView) this.f1952k.findViewById(C0688f.action_bar_subtitle);
            if (this.f1955n != 0) {
                this.f1953l.setTextAppearance(getContext(), this.f1955n);
            }
            if (this.f1956o != 0) {
                this.f1954m.setTextAppearance(getContext(), this.f1956o);
            }
        }
        this.f1953l.setText(this.f1948g);
        this.f1954m.setText(this.f1949h);
        Object obj2 = !TextUtils.isEmpty(this.f1948g) ? 1 : null;
        if (TextUtils.isEmpty(this.f1949h)) {
            obj = null;
        }
        this.f1954m.setVisibility(obj != null ? 0 : 8);
        LinearLayout linearLayout = this.f1952k;
        if (!(obj2 == null && obj == null)) {
            i = 0;
        }
        linearLayout.setVisibility(i);
        if (this.f1952k.getParent() == null) {
            addView(this.f1952k);
        }
    }

    public /* bridge */ /* synthetic */ aw mo666a(int i, long j) {
        return super.mo666a(i, j);
    }

    public void m3946a(final C0679b c0679b) {
        if (this.f1950i == null) {
            this.f1950i = LayoutInflater.from(getContext()).inflate(this.f1958q, this, false);
            addView(this.f1950i);
        } else if (this.f1950i.getParent() == null) {
            addView(this.f1950i);
        }
        this.f1950i.findViewById(C0688f.action_mode_close_button).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ ActionBarContextView f1939b;

            public void onClick(View view) {
                c0679b.mo605c();
            }
        });
        C0727f c0727f = (C0727f) c0679b.mo602b();
        if (this.d != null) {
            this.d.m5344f();
        }
        this.d = new C0873d(getContext());
        this.d.m5340c(true);
        LayoutParams layoutParams = new LayoutParams(-2, -1);
        c0727f.m3817a(this.d, this.b);
        this.c = (ActionMenuView) this.d.mo859a((ViewGroup) this);
        this.c.setBackgroundDrawable(null);
        addView(this.c, layoutParams);
    }

    public boolean mo667a() {
        return this.d != null ? this.d.m5342d() : false;
    }

    public void m3948b() {
        if (this.f1950i == null) {
            m3949c();
        }
    }

    public void m3949c() {
        removeAllViews();
        this.f1951j = null;
        this.c = null;
    }

    public boolean m3950d() {
        return this.f1957p;
    }

    protected LayoutParams generateDefaultLayoutParams() {
        return new MarginLayoutParams(-1, -2);
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new MarginLayoutParams(getContext(), attributeSet);
    }

    public /* bridge */ /* synthetic */ int getAnimatedVisibility() {
        return super.getAnimatedVisibility();
    }

    public /* bridge */ /* synthetic */ int getContentHeight() {
        return super.getContentHeight();
    }

    public CharSequence getSubtitle() {
        return this.f1949h;
    }

    public CharSequence getTitle() {
        return this.f1948g;
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.d != null) {
            this.d.m5343e();
            this.d.m5345g();
        }
    }

    public /* bridge */ /* synthetic */ boolean onHoverEvent(MotionEvent motionEvent) {
        return super.onHoverEvent(motionEvent);
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (VERSION.SDK_INT < 14) {
            return;
        }
        if (accessibilityEvent.getEventType() == 32) {
            accessibilityEvent.setSource(this);
            accessibilityEvent.setClassName(getClass().getName());
            accessibilityEvent.setPackageName(getContext().getPackageName());
            accessibilityEvent.setContentDescription(this.f1948g);
            return;
        }
        super.onInitializeAccessibilityEvent(accessibilityEvent);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        boolean a = bl.m5302a(this);
        int paddingRight = a ? (i3 - i) - getPaddingRight() : getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingTop2 = ((i4 - i2) - getPaddingTop()) - getPaddingBottom();
        if (this.f1950i == null || this.f1950i.getVisibility() == 8) {
            i5 = paddingRight;
        } else {
            MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.f1950i.getLayoutParams();
            i5 = a ? marginLayoutParams.rightMargin : marginLayoutParams.leftMargin;
            int i6 = a ? marginLayoutParams.leftMargin : marginLayoutParams.rightMargin;
            i5 = C0745a.m3937a(paddingRight, i5, a);
            i5 = C0745a.m3937a(m3941a(this.f1950i, i5, paddingTop, paddingTop2, a) + i5, i6, a);
        }
        if (!(this.f1952k == null || this.f1951j != null || this.f1952k.getVisibility() == 8)) {
            i5 += m3941a(this.f1952k, i5, paddingTop, paddingTop2, a);
        }
        if (this.f1951j != null) {
            int a2 = m3941a(this.f1951j, i5, paddingTop, paddingTop2, a) + i5;
        }
        i5 = a ? getPaddingLeft() : (i3 - i) - getPaddingRight();
        if (this.c != null) {
            a2 = m3941a(this.c, i5, paddingTop, paddingTop2, !a) + i5;
        }
    }

    protected void onMeasure(int i, int i2) {
        int i3 = 1073741824;
        int i4 = 0;
        if (MeasureSpec.getMode(i) != 1073741824) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used " + "with android:layout_width=\"match_parent\" (or fill_parent)");
        } else if (MeasureSpec.getMode(i2) == 0) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used " + "with android:layout_height=\"wrap_content\"");
        } else {
            int a;
            int size = MeasureSpec.getSize(i);
            int size2 = this.e > 0 ? this.e : MeasureSpec.getSize(i2);
            int paddingTop = getPaddingTop() + getPaddingBottom();
            int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
            int i5 = size2 - paddingTop;
            int makeMeasureSpec = MeasureSpec.makeMeasureSpec(i5, Integer.MIN_VALUE);
            if (this.f1950i != null) {
                a = m3940a(this.f1950i, paddingLeft, makeMeasureSpec, 0);
                MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.f1950i.getLayoutParams();
                paddingLeft = a - (marginLayoutParams.rightMargin + marginLayoutParams.leftMargin);
            }
            if (this.c != null && this.c.getParent() == this) {
                paddingLeft = m3940a(this.c, paddingLeft, makeMeasureSpec, 0);
            }
            if (this.f1952k != null && this.f1951j == null) {
                if (this.f1957p) {
                    this.f1952k.measure(MeasureSpec.makeMeasureSpec(0, 0), makeMeasureSpec);
                    a = this.f1952k.getMeasuredWidth();
                    makeMeasureSpec = a <= paddingLeft ? 1 : 0;
                    if (makeMeasureSpec != 0) {
                        paddingLeft -= a;
                    }
                    this.f1952k.setVisibility(makeMeasureSpec != 0 ? 0 : 8);
                } else {
                    paddingLeft = m3940a(this.f1952k, paddingLeft, makeMeasureSpec, 0);
                }
            }
            if (this.f1951j != null) {
                LayoutParams layoutParams = this.f1951j.getLayoutParams();
                makeMeasureSpec = layoutParams.width != -2 ? 1073741824 : Integer.MIN_VALUE;
                if (layoutParams.width >= 0) {
                    paddingLeft = Math.min(layoutParams.width, paddingLeft);
                }
                if (layoutParams.height == -2) {
                    i3 = Integer.MIN_VALUE;
                }
                this.f1951j.measure(MeasureSpec.makeMeasureSpec(paddingLeft, makeMeasureSpec), MeasureSpec.makeMeasureSpec(layoutParams.height >= 0 ? Math.min(layoutParams.height, i5) : i5, i3));
            }
            if (this.e <= 0) {
                makeMeasureSpec = getChildCount();
                size2 = 0;
                while (i4 < makeMeasureSpec) {
                    paddingLeft = getChildAt(i4).getMeasuredHeight() + paddingTop;
                    if (paddingLeft <= size2) {
                        paddingLeft = size2;
                    }
                    i4++;
                    size2 = paddingLeft;
                }
                setMeasuredDimension(size, size2);
                return;
            }
            setMeasuredDimension(size, size2);
        }
    }

    public /* bridge */ /* synthetic */ boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    public void setContentHeight(int i) {
        this.e = i;
    }

    public void setCustomView(View view) {
        if (this.f1951j != null) {
            removeView(this.f1951j);
        }
        this.f1951j = view;
        if (!(view == null || this.f1952k == null)) {
            removeView(this.f1952k);
            this.f1952k = null;
        }
        if (view != null) {
            addView(view);
        }
        requestLayout();
    }

    public void setSubtitle(CharSequence charSequence) {
        this.f1949h = charSequence;
        m3944e();
    }

    public void setTitle(CharSequence charSequence) {
        this.f1948g = charSequence;
        m3944e();
    }

    public void setTitleOptional(boolean z) {
        if (z != this.f1957p) {
            requestLayout();
        }
        this.f1957p = z;
    }

    public /* bridge */ /* synthetic */ void setVisibility(int i) {
        super.setVisibility(i);
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }
}
