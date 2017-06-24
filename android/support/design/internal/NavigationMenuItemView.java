package android.support.design.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.StateListDrawable;
import android.support.design.C0048a.C0040b;
import android.support.design.C0048a.C0042d;
import android.support.design.C0048a.C0043e;
import android.support.design.C0048a.C0044f;
import android.support.v4.p004c.p005a.C0314a;
import android.support.v4.widget.C0608x;
import android.support.v7.view.menu.C0052m.C0050a;
import android.support.v7.view.menu.C0730h;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewStub;
import android.widget.CheckedTextView;
import android.widget.FrameLayout;

public class NavigationMenuItemView extends C0049a implements C0050a {
    private static final int[] f187c = new int[]{16842912};
    private final int f188d;
    private final CheckedTextView f189e;
    private FrameLayout f190f;
    private C0730h f191g;
    private ColorStateList f192h;

    public NavigationMenuItemView(Context context) {
        this(context, null);
    }

    public NavigationMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NavigationMenuItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setOrientation(0);
        LayoutInflater.from(context).inflate(C0044f.design_navigation_menu_item, this, true);
        this.f188d = context.getResources().getDimensionPixelSize(C0042d.design_navigation_icon_size);
        this.f189e = (CheckedTextView) findViewById(C0043e.design_menu_item_text);
        this.f189e.setDuplicateParentStateEnabled(true);
    }

    private StateListDrawable m209b() {
        TypedValue typedValue = new TypedValue();
        if (!getContext().getTheme().resolveAttribute(C0040b.colorControlHighlight, typedValue, true)) {
            return null;
        }
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(f187c, new ColorDrawable(typedValue.data));
        stateListDrawable.addState(EMPTY_STATE_SET, new ColorDrawable(0));
        return stateListDrawable;
    }

    private void setActionView(View view) {
        if (this.f190f == null) {
            this.f190f = (FrameLayout) ((ViewStub) findViewById(C0043e.design_menu_item_action_area_stub)).inflate();
        }
        this.f190f.removeAllViews();
        if (view != null) {
            this.f190f.addView(view);
        }
    }

    public void mo27a(C0730h c0730h, int i) {
        this.f191g = c0730h;
        setVisibility(c0730h.isVisible() ? 0 : 8);
        if (getBackground() == null) {
            setBackgroundDrawable(m209b());
        }
        setCheckable(c0730h.isCheckable());
        setChecked(c0730h.isChecked());
        setEnabled(c0730h.isEnabled());
        setTitle(c0730h.getTitle());
        setIcon(c0730h.getIcon());
        setActionView(c0730h.getActionView());
    }

    public boolean mo28a() {
        return false;
    }

    public C0730h getItemData() {
        return this.f191g;
    }

    protected int[] onCreateDrawableState(int i) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i + 1);
        if (this.f191g != null && this.f191g.isCheckable() && this.f191g.isChecked()) {
            mergeDrawableStates(onCreateDrawableState, f187c);
        }
        return onCreateDrawableState;
    }

    public void setCheckable(boolean z) {
        refreshDrawableState();
    }

    public void setChecked(boolean z) {
        refreshDrawableState();
        this.f189e.setChecked(z);
    }

    public void setIcon(Drawable drawable) {
        if (drawable != null) {
            ConstantState constantState = drawable.getConstantState();
            if (constantState != null) {
                drawable = constantState.newDrawable();
            }
            drawable = C0314a.m1776f(drawable).mutate();
            drawable.setBounds(0, 0, this.f188d, this.f188d);
            C0314a.m1766a(drawable, this.f192h);
        }
        C0608x.m3226a(this.f189e, drawable, null, null, null);
    }

    void setIconTintList(ColorStateList colorStateList) {
        this.f192h = colorStateList;
        if (this.f191g != null) {
            setIcon(this.f191g.getIcon());
        }
    }

    public void setTextColor(ColorStateList colorStateList) {
        this.f189e.setTextColor(colorStateList);
    }

    public void setTitle(CharSequence charSequence) {
        this.f189e.setText(charSequence);
    }
}
