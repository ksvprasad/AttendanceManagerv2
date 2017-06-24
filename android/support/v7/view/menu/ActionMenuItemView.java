package android.support.v7.view.menu;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.view.ag;
import android.support.v7.p019b.C0694a.C0684b;
import android.support.v7.p019b.C0694a.C0693k;
import android.support.v7.view.menu.C0052m.C0050a;
import android.support.v7.view.menu.C0727f.C0719b;
import android.support.v7.widget.ActionMenuView.C0718a;
import android.support.v7.widget.ab;
import android.support.v7.widget.ap;
import android.support.v7.widget.ap.C0715b;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.Toast;

public class ActionMenuItemView extends ab implements C0050a, C0718a, OnClickListener, OnLongClickListener {
    private C0730h f1774a;
    private CharSequence f1775b;
    private Drawable f1776c;
    private C0719b f1777d;
    private C0715b f1778e;
    private C0717b f1779f;
    private boolean f1780g;
    private boolean f1781h;
    private int f1782i;
    private int f1783j;
    private int f1784k;

    private class C0716a extends C0715b {
        final /* synthetic */ ActionMenuItemView f1770a;

        public C0716a(ActionMenuItemView actionMenuItemView) {
            this.f1770a = actionMenuItemView;
            super(actionMenuItemView);
        }

        public ap mo620a() {
            return this.f1770a.f1779f != null ? this.f1770a.f1779f.mo857a() : null;
        }

        protected boolean mo621b() {
            if (this.f1770a.f1777d == null || !this.f1770a.f1777d.mo624a(this.f1770a.f1774a)) {
                return false;
            }
            ap a = mo620a();
            return a != null && a.m5069k();
        }
    }

    public static abstract class C0717b {
        public abstract ap mo857a();
    }

    public ActionMenuItemView(Context context) {
        this(context, null);
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Resources resources = context.getResources();
        this.f1780g = resources.getBoolean(C0684b.abc_config_allowActionMenuItemTextWithIcon);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0693k.ActionMenuItemView, i, 0);
        this.f1782i = obtainStyledAttributes.getDimensionPixelSize(C0693k.ActionMenuItemView_android_minWidth, 0);
        obtainStyledAttributes.recycle();
        this.f1784k = (int) ((resources.getDisplayMetrics().density * 32.0f) + 0.5f);
        setOnClickListener(this);
        setOnLongClickListener(this);
        this.f1783j = -1;
    }

    private void m3734e() {
        int i = 0;
        int i2 = !TextUtils.isEmpty(this.f1775b) ? 1 : 0;
        if (this.f1776c == null || (this.f1774a.m3881m() && (this.f1780g || this.f1781h))) {
            i = 1;
        }
        setText((i2 & i) != 0 ? this.f1775b : null);
    }

    public void mo27a(C0730h c0730h, int i) {
        this.f1774a = c0730h;
        setIcon(c0730h.getIcon());
        setTitle(c0730h.m3861a((C0050a) this));
        setId(c0730h.getItemId());
        setVisibility(c0730h.isVisible() ? 0 : 8);
        setEnabled(c0730h.isEnabled());
        if (c0730h.hasSubMenu() && this.f1778e == null) {
            this.f1778e = new C0716a(this);
        }
    }

    public boolean mo28a() {
        return true;
    }

    public boolean m3737b() {
        return !TextUtils.isEmpty(getText());
    }

    public boolean mo622c() {
        return m3737b() && this.f1774a.getIcon() == null;
    }

    public boolean mo623d() {
        return m3737b();
    }

    public C0730h getItemData() {
        return this.f1774a;
    }

    public void onClick(View view) {
        if (this.f1777d != null) {
            this.f1777d.mo624a(this.f1774a);
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (VERSION.SDK_INT >= 8) {
            super.onConfigurationChanged(configuration);
        }
        this.f1780g = getContext().getResources().getBoolean(C0684b.abc_config_allowActionMenuItemTextWithIcon);
        m3734e();
    }

    public boolean onLongClick(View view) {
        if (m3737b()) {
            return false;
        }
        int[] iArr = new int[2];
        Rect rect = new Rect();
        getLocationOnScreen(iArr);
        getWindowVisibleDisplayFrame(rect);
        Context context = getContext();
        int width = getWidth();
        int height = getHeight();
        int i = iArr[1] + (height / 2);
        width = (width / 2) + iArr[0];
        if (ag.m2540h(view) == 0) {
            width = context.getResources().getDisplayMetrics().widthPixels - width;
        }
        Toast makeText = Toast.makeText(context, this.f1774a.getTitle(), 0);
        if (i < rect.height()) {
            makeText.setGravity(8388661, width, (iArr[1] + height) - rect.top);
        } else {
            makeText.setGravity(81, 0, height);
        }
        makeText.show();
        return true;
    }

    protected void onMeasure(int i, int i2) {
        boolean b = m3737b();
        if (b && this.f1783j >= 0) {
            super.setPadding(this.f1783j, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
        super.onMeasure(i, i2);
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        int measuredWidth = getMeasuredWidth();
        size = mode == Integer.MIN_VALUE ? Math.min(size, this.f1782i) : this.f1782i;
        if (mode != 1073741824 && this.f1782i > 0 && measuredWidth < size) {
            super.onMeasure(MeasureSpec.makeMeasureSpec(size, 1073741824), i2);
        }
        if (!b && this.f1776c != null) {
            super.setPadding((getMeasuredWidth() - this.f1776c.getBounds().width()) / 2, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return (this.f1774a.hasSubMenu() && this.f1778e != null && this.f1778e.onTouch(this, motionEvent)) ? true : super.onTouchEvent(motionEvent);
    }

    public void setCheckable(boolean z) {
    }

    public void setChecked(boolean z) {
    }

    public void setExpandedFormat(boolean z) {
        if (this.f1781h != z) {
            this.f1781h = z;
            if (this.f1774a != null) {
                this.f1774a.m3876h();
            }
        }
    }

    public void setIcon(Drawable drawable) {
        this.f1776c = drawable;
        if (drawable != null) {
            float f;
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            if (intrinsicWidth > this.f1784k) {
                f = ((float) this.f1784k) / ((float) intrinsicWidth);
                intrinsicWidth = this.f1784k;
                intrinsicHeight = (int) (((float) intrinsicHeight) * f);
            }
            if (intrinsicHeight > this.f1784k) {
                f = ((float) this.f1784k) / ((float) intrinsicHeight);
                intrinsicHeight = this.f1784k;
                intrinsicWidth = (int) (((float) intrinsicWidth) * f);
            }
            drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
        }
        setCompoundDrawables(drawable, null, null, null);
        m3734e();
    }

    public void setItemInvoker(C0719b c0719b) {
        this.f1777d = c0719b;
    }

    public void setPadding(int i, int i2, int i3, int i4) {
        this.f1783j = i;
        super.setPadding(i, i2, i3, i4);
    }

    public void setPopupCallback(C0717b c0717b) {
        this.f1779f = c0717b;
    }

    public void setTitle(CharSequence charSequence) {
        this.f1775b = charSequence;
        setContentDescription(this.f1775b);
        m3734e();
    }
}
