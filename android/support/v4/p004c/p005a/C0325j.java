package android.support.v4.p004c.p005a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.Drawable.ConstantState;

class C0325j extends Drawable implements Callback, C0322i, C0022o {
    static final Mode f1070a = Mode.SRC_IN;
    C0323a f1071b;
    Drawable f1072c;
    private int f1073d;
    private Mode f1074e;
    private boolean f1075f;
    private boolean f1076g;

    protected static abstract class C0323a extends ConstantState {
        int f1066a;
        ConstantState f1067b;
        ColorStateList f1068c = null;
        Mode f1069d = C0325j.f1070a;

        C0323a(C0323a c0323a, Resources resources) {
            if (c0323a != null) {
                this.f1066a = c0323a.f1066a;
                this.f1067b = c0323a.f1067b;
                this.f1068c = c0323a.f1068c;
                this.f1069d = c0323a.f1069d;
            }
        }

        boolean m1806a() {
            return this.f1067b != null;
        }

        public int getChangingConfigurations() {
            return (this.f1067b != null ? this.f1067b.getChangingConfigurations() : 0) | this.f1066a;
        }

        public Drawable newDrawable() {
            return newDrawable(null);
        }

        public abstract Drawable newDrawable(Resources resources);
    }

    private static class C0324b extends C0323a {
        C0324b(C0323a c0323a, Resources resources) {
            super(c0323a, resources);
        }

        public Drawable newDrawable(Resources resources) {
            return new C0325j(this, resources);
        }
    }

    C0325j(Drawable drawable) {
        this.f1071b = mo265b();
        mo263a(drawable);
    }

    C0325j(C0323a c0323a, Resources resources) {
        this.f1071b = c0323a;
        m1807a(resources);
    }

    private void m1807a(Resources resources) {
        if (this.f1071b != null && this.f1071b.f1067b != null) {
            mo263a(mo264a(this.f1071b.f1067b, resources));
        }
    }

    private boolean m1808a(int[] iArr) {
        if (!mo266c()) {
            return false;
        }
        ColorStateList colorStateList = this.f1071b.f1068c;
        Mode mode = this.f1071b.f1069d;
        if (colorStateList == null || mode == null) {
            this.f1075f = false;
            clearColorFilter();
            return false;
        }
        int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
        if (this.f1075f && colorForState == this.f1073d && mode == this.f1074e) {
            return false;
        }
        setColorFilter(colorForState, mode);
        this.f1073d = colorForState;
        this.f1074e = mode;
        this.f1075f = true;
        return true;
    }

    public final Drawable mo262a() {
        return this.f1072c;
    }

    protected Drawable mo264a(ConstantState constantState, Resources resources) {
        return constantState.newDrawable();
    }

    public final void mo263a(Drawable drawable) {
        if (this.f1072c != null) {
            this.f1072c.setCallback(null);
        }
        this.f1072c = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            drawable.setVisible(isVisible(), true);
            drawable.setState(getState());
            drawable.setLevel(getLevel());
            drawable.setBounds(getBounds());
            if (this.f1071b != null) {
                this.f1071b.f1067b = drawable.getConstantState();
            }
        }
        invalidateSelf();
    }

    C0323a mo265b() {
        return new C0324b(this.f1071b, null);
    }

    protected boolean mo266c() {
        return true;
    }

    public void draw(Canvas canvas) {
        this.f1072c.draw(canvas);
    }

    public int getChangingConfigurations() {
        return ((this.f1071b != null ? this.f1071b.getChangingConfigurations() : 0) | super.getChangingConfigurations()) | this.f1072c.getChangingConfigurations();
    }

    public ConstantState getConstantState() {
        if (this.f1071b == null || !this.f1071b.m1806a()) {
            return null;
        }
        this.f1071b.f1066a = getChangingConfigurations();
        return this.f1071b;
    }

    public Drawable getCurrent() {
        return this.f1072c.getCurrent();
    }

    public int getIntrinsicHeight() {
        return this.f1072c.getIntrinsicHeight();
    }

    public int getIntrinsicWidth() {
        return this.f1072c.getIntrinsicWidth();
    }

    public int getMinimumHeight() {
        return this.f1072c.getMinimumHeight();
    }

    public int getMinimumWidth() {
        return this.f1072c.getMinimumWidth();
    }

    public int getOpacity() {
        return this.f1072c.getOpacity();
    }

    public boolean getPadding(Rect rect) {
        return this.f1072c.getPadding(rect);
    }

    public int[] getState() {
        return this.f1072c.getState();
    }

    public Region getTransparentRegion() {
        return this.f1072c.getTransparentRegion();
    }

    public void invalidateDrawable(Drawable drawable) {
        invalidateSelf();
    }

    public boolean isStateful() {
        ColorStateList colorStateList = (!mo266c() || this.f1071b == null) ? null : this.f1071b.f1068c;
        return (colorStateList != null && colorStateList.isStateful()) || this.f1072c.isStateful();
    }

    public Drawable mutate() {
        if (!this.f1076g && super.mutate() == this) {
            this.f1071b = mo265b();
            if (this.f1072c != null) {
                this.f1072c.mutate();
            }
            if (this.f1071b != null) {
                this.f1071b.f1067b = this.f1072c != null ? this.f1072c.getConstantState() : null;
            }
            this.f1076g = true;
        }
        return this;
    }

    protected void onBoundsChange(Rect rect) {
        if (this.f1072c != null) {
            this.f1072c.setBounds(rect);
        }
    }

    protected boolean onLevelChange(int i) {
        return this.f1072c.setLevel(i);
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        scheduleSelf(runnable, j);
    }

    public void setAlpha(int i) {
        this.f1072c.setAlpha(i);
    }

    public void setChangingConfigurations(int i) {
        this.f1072c.setChangingConfigurations(i);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f1072c.setColorFilter(colorFilter);
    }

    public void setDither(boolean z) {
        this.f1072c.setDither(z);
    }

    public void setFilterBitmap(boolean z) {
        this.f1072c.setFilterBitmap(z);
    }

    public boolean setState(int[] iArr) {
        return m1808a(iArr) || this.f1072c.setState(iArr);
    }

    public void setTint(int i) {
        setTintList(ColorStateList.valueOf(i));
    }

    public void setTintList(ColorStateList colorStateList) {
        this.f1071b.f1068c = colorStateList;
        m1808a(getState());
    }

    public void setTintMode(Mode mode) {
        this.f1071b.f1069d = mode;
        m1808a(getState());
    }

    public boolean setVisible(boolean z, boolean z2) {
        return super.setVisible(z, z2) || this.f1072c.setVisible(z, z2);
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        unscheduleSelf(runnable);
    }
}
