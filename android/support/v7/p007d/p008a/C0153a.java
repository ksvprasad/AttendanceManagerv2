package android.support.v7.p007d.p008a;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.support.v4.p004c.p005a.C0314a;

public class C0153a extends Drawable implements Callback {
    private Drawable f650a;

    public C0153a(Drawable drawable) {
        m1010a(drawable);
    }

    public void m1010a(Drawable drawable) {
        if (this.f650a != null) {
            this.f650a.setCallback(null);
        }
        this.f650a = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
    }

    public Drawable m1011b() {
        return this.f650a;
    }

    public void draw(Canvas canvas) {
        this.f650a.draw(canvas);
    }

    public int getChangingConfigurations() {
        return this.f650a.getChangingConfigurations();
    }

    public Drawable getCurrent() {
        return this.f650a.getCurrent();
    }

    public int getIntrinsicHeight() {
        return this.f650a.getIntrinsicHeight();
    }

    public int getIntrinsicWidth() {
        return this.f650a.getIntrinsicWidth();
    }

    public int getMinimumHeight() {
        return this.f650a.getMinimumHeight();
    }

    public int getMinimumWidth() {
        return this.f650a.getMinimumWidth();
    }

    public int getOpacity() {
        return this.f650a.getOpacity();
    }

    public boolean getPadding(Rect rect) {
        return this.f650a.getPadding(rect);
    }

    public int[] getState() {
        return this.f650a.getState();
    }

    public Region getTransparentRegion() {
        return this.f650a.getTransparentRegion();
    }

    public void invalidateDrawable(Drawable drawable) {
        invalidateSelf();
    }

    public boolean isAutoMirrored() {
        return C0314a.m1772b(this.f650a);
    }

    public boolean isStateful() {
        return this.f650a.isStateful();
    }

    public void jumpToCurrentState() {
        C0314a.m1762a(this.f650a);
    }

    protected void onBoundsChange(Rect rect) {
        this.f650a.setBounds(rect);
    }

    protected boolean onLevelChange(int i) {
        return this.f650a.setLevel(i);
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        scheduleSelf(runnable, j);
    }

    public void setAlpha(int i) {
        this.f650a.setAlpha(i);
    }

    public void setAutoMirrored(boolean z) {
        C0314a.m1770a(this.f650a, z);
    }

    public void setChangingConfigurations(int i) {
        this.f650a.setChangingConfigurations(i);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f650a.setColorFilter(colorFilter);
    }

    public void setDither(boolean z) {
        this.f650a.setDither(z);
    }

    public void setFilterBitmap(boolean z) {
        this.f650a.setFilterBitmap(z);
    }

    public void setHotspot(float f, float f2) {
        C0314a.m1763a(this.f650a, f, f2);
    }

    public void setHotspotBounds(int i, int i2, int i3, int i4) {
        C0314a.m1765a(this.f650a, i, i2, i3, i4);
    }

    public boolean setState(int[] iArr) {
        return this.f650a.setState(iArr);
    }

    public void setTint(int i) {
        C0314a.m1764a(this.f650a, i);
    }

    public void setTintList(ColorStateList colorStateList) {
        C0314a.m1766a(this.f650a, colorStateList);
    }

    public void setTintMode(Mode mode) {
        C0314a.m1769a(this.f650a, mode);
    }

    public boolean setVisible(boolean z, boolean z2) {
        return super.setVisible(z, z2) || this.f650a.setVisible(z, z2);
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        unscheduleSelf(runnable);
    }
}
