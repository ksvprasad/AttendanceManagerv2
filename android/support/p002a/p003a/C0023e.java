package android.support.p002a.p003a;

import android.annotation.TargetApi;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.support.v4.p004c.p005a.C0022o;
import android.support.v4.p004c.p005a.C0314a;
import android.util.AttributeSet;

@TargetApi(21)
abstract class C0023e extends Drawable implements C0022o {
    Drawable f88a;

    C0023e() {
    }

    static TypedArray m112b(Resources resources, Theme theme, AttributeSet attributeSet, int[] iArr) {
        return theme == null ? resources.obtainAttributes(attributeSet, iArr) : theme.obtainStyledAttributes(attributeSet, iArr, 0, 0);
    }

    public void applyTheme(Theme theme) {
        if (this.f88a != null) {
            C0314a.m1767a(this.f88a, theme);
        }
    }

    public void clearColorFilter() {
        if (this.f88a != null) {
            this.f88a.clearColorFilter();
        } else {
            super.clearColorFilter();
        }
    }

    public ColorFilter getColorFilter() {
        return this.f88a != null ? C0314a.m1775e(this.f88a) : null;
    }

    public Drawable getCurrent() {
        return this.f88a != null ? this.f88a.getCurrent() : super.getCurrent();
    }

    public int getLayoutDirection() {
        if (this.f88a != null) {
            C0314a.m1777g(this.f88a);
        }
        return 0;
    }

    public int getMinimumHeight() {
        return this.f88a != null ? this.f88a.getMinimumHeight() : super.getMinimumHeight();
    }

    public int getMinimumWidth() {
        return this.f88a != null ? this.f88a.getMinimumWidth() : super.getMinimumWidth();
    }

    public boolean getPadding(Rect rect) {
        return this.f88a != null ? this.f88a.getPadding(rect) : super.getPadding(rect);
    }

    public int[] getState() {
        return this.f88a != null ? this.f88a.getState() : super.getState();
    }

    public Region getTransparentRegion() {
        return this.f88a != null ? this.f88a.getTransparentRegion() : super.getTransparentRegion();
    }

    public boolean isAutoMirrored() {
        if (this.f88a != null) {
            C0314a.m1772b(this.f88a);
        }
        return false;
    }

    public void jumpToCurrentState() {
        if (this.f88a != null) {
            C0314a.m1762a(this.f88a);
        }
    }

    protected void onBoundsChange(Rect rect) {
        if (this.f88a != null) {
            this.f88a.setBounds(rect);
        } else {
            super.onBoundsChange(rect);
        }
    }

    protected boolean onLevelChange(int i) {
        return this.f88a != null ? this.f88a.setLevel(i) : super.onLevelChange(i);
    }

    public void setAutoMirrored(boolean z) {
        if (this.f88a != null) {
            C0314a.m1770a(this.f88a, z);
        }
    }

    public void setChangingConfigurations(int i) {
        if (this.f88a != null) {
            this.f88a.setChangingConfigurations(i);
        } else {
            super.setChangingConfigurations(i);
        }
    }

    public void setColorFilter(int i, Mode mode) {
        if (this.f88a != null) {
            this.f88a.setColorFilter(i, mode);
        } else {
            super.setColorFilter(i, mode);
        }
    }

    public void setFilterBitmap(boolean z) {
        if (this.f88a != null) {
            this.f88a.setFilterBitmap(z);
        }
    }

    public void setHotspot(float f, float f2) {
        if (this.f88a != null) {
            C0314a.m1763a(this.f88a, f, f2);
        }
    }

    public void setHotspotBounds(int i, int i2, int i3, int i4) {
        if (this.f88a != null) {
            C0314a.m1765a(this.f88a, i, i2, i3, i4);
        }
    }

    public boolean setState(int[] iArr) {
        return this.f88a != null ? this.f88a.setState(iArr) : super.setState(iArr);
    }
}
