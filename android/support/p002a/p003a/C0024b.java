package android.support.p002a.p003a;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.Build.VERSION;
import android.support.v4.p004c.p005a.C0314a;
import android.support.v4.p015g.C0370a;
import android.util.AttributeSet;
import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;

@TargetApi(21)
public class C0024b extends C0023e implements Animatable {
    private C0020a f89b;
    private Context f90c;
    private ArgbEvaluator f91d;
    private final Callback f92e;

    class C00191 implements Callback {
        final /* synthetic */ C0024b f82a;

        C00191(C0024b c0024b) {
            this.f82a = c0024b;
        }

        public void invalidateDrawable(Drawable drawable) {
            this.f82a.invalidateSelf();
        }

        public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
            this.f82a.scheduleSelf(runnable, j);
        }

        public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
            this.f82a.unscheduleSelf(runnable);
        }
    }

    private static class C0020a extends ConstantState {
        int f83a;
        C0038f f84b;
        ArrayList<Animator> f85c;
        C0370a<Animator, String> f86d;

        public C0020a(Context context, C0020a c0020a, Callback callback, Resources resources) {
            int i = 0;
            if (c0020a != null) {
                this.f83a = c0020a.f83a;
                if (c0020a.f84b != null) {
                    ConstantState constantState = c0020a.f84b.getConstantState();
                    if (resources != null) {
                        this.f84b = (C0038f) constantState.newDrawable(resources);
                    } else {
                        this.f84b = (C0038f) constantState.newDrawable();
                    }
                    this.f84b = (C0038f) this.f84b.mutate();
                    this.f84b.setCallback(callback);
                    this.f84b.setBounds(c0020a.f84b.getBounds());
                    this.f84b.m185a(false);
                }
                if (c0020a.f85c != null) {
                    int size = c0020a.f85c.size();
                    this.f85c = new ArrayList(size);
                    this.f86d = new C0370a(size);
                    while (i < size) {
                        Animator animator = (Animator) c0020a.f85c.get(i);
                        Animator clone = animator.clone();
                        String str = (String) c0020a.f86d.get(animator);
                        clone.setTarget(this.f84b.m184a(str));
                        this.f85c.add(clone);
                        this.f86d.put(clone, str);
                        i++;
                    }
                }
            }
        }

        public int getChangingConfigurations() {
            return this.f83a;
        }

        public Drawable newDrawable() {
            throw new IllegalStateException("No constant state support for SDK < 23.");
        }

        public Drawable newDrawable(Resources resources) {
            throw new IllegalStateException("No constant state support for SDK < 23.");
        }
    }

    private static class C0021b extends ConstantState {
        private final ConstantState f87a;

        public C0021b(ConstantState constantState) {
            this.f87a = constantState;
        }

        public boolean canApplyTheme() {
            return this.f87a.canApplyTheme();
        }

        public int getChangingConfigurations() {
            return this.f87a.getChangingConfigurations();
        }

        public Drawable newDrawable() {
            C0024b c0024b = new C0024b();
            c0024b.a = this.f87a.newDrawable();
            c0024b.a.setCallback(c0024b.f92e);
            return c0024b;
        }

        public Drawable newDrawable(Resources resources) {
            C0024b c0024b = new C0024b();
            c0024b.a = this.f87a.newDrawable(resources);
            c0024b.a.setCallback(c0024b.f92e);
            return c0024b;
        }

        public Drawable newDrawable(Resources resources, Theme theme) {
            C0024b c0024b = new C0024b();
            c0024b.a = this.f87a.newDrawable(resources, theme);
            c0024b.a.setCallback(c0024b.f92e);
            return c0024b;
        }
    }

    private C0024b() {
        this(null, null, null);
    }

    private C0024b(Context context) {
        this(context, null, null);
    }

    private C0024b(Context context, C0020a c0020a, Resources resources) {
        this.f91d = null;
        this.f92e = new C00191(this);
        this.f90c = context;
        if (c0020a != null) {
            this.f89b = c0020a;
        } else {
            this.f89b = new C0020a(context, c0020a, this.f92e, resources);
        }
    }

    static TypedArray m113a(Resources resources, Theme theme, AttributeSet attributeSet, int[] iArr) {
        return theme == null ? resources.obtainAttributes(attributeSet, iArr) : theme.obtainStyledAttributes(attributeSet, iArr, 0, 0);
    }

    public static C0024b m115a(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
        C0024b c0024b = new C0024b(context);
        c0024b.inflate(resources, xmlPullParser, attributeSet, theme);
        return c0024b;
    }

    private void m116a(Animator animator) {
        if (animator instanceof AnimatorSet) {
            List childAnimations = ((AnimatorSet) animator).getChildAnimations();
            if (childAnimations != null) {
                for (int i = 0; i < childAnimations.size(); i++) {
                    m116a((Animator) childAnimations.get(i));
                }
            }
        }
        if (animator instanceof ObjectAnimator) {
            ObjectAnimator objectAnimator = (ObjectAnimator) animator;
            String propertyName = objectAnimator.getPropertyName();
            if ("fillColor".equals(propertyName) || "strokeColor".equals(propertyName)) {
                if (this.f91d == null) {
                    this.f91d = new ArgbEvaluator();
                }
                objectAnimator.setEvaluator(this.f91d);
            }
        }
    }

    private void m117a(String str, Animator animator) {
        animator.setTarget(this.f89b.f84b.m184a(str));
        if (VERSION.SDK_INT < 21) {
            m116a(animator);
        }
        if (this.f89b.f85c == null) {
            this.f89b.f85c = new ArrayList();
            this.f89b.f86d = new C0370a();
        }
        this.f89b.f85c.add(animator);
        this.f89b.f86d.put(animator, str);
    }

    private boolean m118a() {
        ArrayList arrayList = this.f89b.f85c;
        if (arrayList == null) {
            return false;
        }
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (((Animator) arrayList.get(i)).isRunning()) {
                return true;
            }
        }
        return false;
    }

    public void applyTheme(Theme theme) {
        if (this.a != null) {
            C0314a.m1767a(this.a, theme);
        }
    }

    public boolean canApplyTheme() {
        return this.a != null ? C0314a.m1774d(this.a) : false;
    }

    public /* bridge */ /* synthetic */ void clearColorFilter() {
        super.clearColorFilter();
    }

    public void draw(Canvas canvas) {
        if (this.a != null) {
            this.a.draw(canvas);
            return;
        }
        this.f89b.f84b.draw(canvas);
        if (m118a()) {
            invalidateSelf();
        }
    }

    public int getAlpha() {
        return this.a != null ? C0314a.m1773c(this.a) : this.f89b.f84b.getAlpha();
    }

    public int getChangingConfigurations() {
        return this.a != null ? this.a.getChangingConfigurations() : super.getChangingConfigurations() | this.f89b.f83a;
    }

    public /* bridge */ /* synthetic */ ColorFilter getColorFilter() {
        return super.getColorFilter();
    }

    public ConstantState getConstantState() {
        return this.a != null ? new C0021b(this.a.getConstantState()) : null;
    }

    public /* bridge */ /* synthetic */ Drawable getCurrent() {
        return super.getCurrent();
    }

    public int getIntrinsicHeight() {
        return this.a != null ? this.a.getIntrinsicHeight() : this.f89b.f84b.getIntrinsicHeight();
    }

    public int getIntrinsicWidth() {
        return this.a != null ? this.a.getIntrinsicWidth() : this.f89b.f84b.getIntrinsicWidth();
    }

    public /* bridge */ /* synthetic */ int getLayoutDirection() {
        return super.getLayoutDirection();
    }

    public /* bridge */ /* synthetic */ int getMinimumHeight() {
        return super.getMinimumHeight();
    }

    public /* bridge */ /* synthetic */ int getMinimumWidth() {
        return super.getMinimumWidth();
    }

    public int getOpacity() {
        return this.a != null ? this.a.getOpacity() : this.f89b.f84b.getOpacity();
    }

    public /* bridge */ /* synthetic */ boolean getPadding(Rect rect) {
        return super.getPadding(rect);
    }

    public /* bridge */ /* synthetic */ int[] getState() {
        return super.getState();
    }

    public /* bridge */ /* synthetic */ Region getTransparentRegion() {
        return super.getTransparentRegion();
    }

    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) {
        inflate(resources, xmlPullParser, attributeSet, null);
    }

    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
        if (this.a != null) {
            C0314a.m1768a(this.a, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        int eventType = xmlPullParser.getEventType();
        while (eventType != 1) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                TypedArray a;
                if ("animated-vector".equals(name)) {
                    a = C0024b.m113a(resources, theme, attributeSet, C0018a.f80e);
                    int resourceId = a.getResourceId(0, 0);
                    if (resourceId != 0) {
                        C0038f a2 = C0038f.m177a(resources, resourceId, theme);
                        a2.m185a(false);
                        a2.setCallback(this.f92e);
                        if (this.f89b.f84b != null) {
                            this.f89b.f84b.setCallback(null);
                        }
                        this.f89b.f84b = a2;
                    }
                    a.recycle();
                } else if ("target".equals(name)) {
                    a = resources.obtainAttributes(attributeSet, C0018a.f81f);
                    String string = a.getString(0);
                    int resourceId2 = a.getResourceId(1, 0);
                    if (resourceId2 != 0) {
                        if (this.f90c != null) {
                            m117a(string, AnimatorInflater.loadAnimator(this.f90c, resourceId2));
                        } else {
                            throw new IllegalStateException("Context can't be null when inflating animators");
                        }
                    }
                    a.recycle();
                } else {
                    continue;
                }
            }
            eventType = xmlPullParser.next();
        }
    }

    public /* bridge */ /* synthetic */ boolean isAutoMirrored() {
        return super.isAutoMirrored();
    }

    public boolean isRunning() {
        if (this.a != null) {
            return ((AnimatedVectorDrawable) this.a).isRunning();
        }
        ArrayList arrayList = this.f89b.f85c;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (((Animator) arrayList.get(i)).isRunning()) {
                return true;
            }
        }
        return false;
    }

    public boolean isStateful() {
        return this.a != null ? this.a.isStateful() : this.f89b.f84b.isStateful();
    }

    public /* bridge */ /* synthetic */ void jumpToCurrentState() {
        super.jumpToCurrentState();
    }

    public Drawable mutate() {
        if (this.a != null) {
            this.a.mutate();
            return this;
        }
        throw new IllegalStateException("Mutate() is not supported for older platform");
    }

    protected void onBoundsChange(Rect rect) {
        if (this.a != null) {
            this.a.setBounds(rect);
        } else {
            this.f89b.f84b.setBounds(rect);
        }
    }

    protected boolean onLevelChange(int i) {
        return this.a != null ? this.a.setLevel(i) : this.f89b.f84b.setLevel(i);
    }

    protected boolean onStateChange(int[] iArr) {
        return this.a != null ? this.a.setState(iArr) : this.f89b.f84b.setState(iArr);
    }

    public void setAlpha(int i) {
        if (this.a != null) {
            this.a.setAlpha(i);
        } else {
            this.f89b.f84b.setAlpha(i);
        }
    }

    public /* bridge */ /* synthetic */ void setAutoMirrored(boolean z) {
        super.setAutoMirrored(z);
    }

    public /* bridge */ /* synthetic */ void setChangingConfigurations(int i) {
        super.setChangingConfigurations(i);
    }

    public /* bridge */ /* synthetic */ void setColorFilter(int i, Mode mode) {
        super.setColorFilter(i, mode);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        if (this.a != null) {
            this.a.setColorFilter(colorFilter);
        } else {
            this.f89b.f84b.setColorFilter(colorFilter);
        }
    }

    public /* bridge */ /* synthetic */ void setFilterBitmap(boolean z) {
        super.setFilterBitmap(z);
    }

    public /* bridge */ /* synthetic */ void setHotspot(float f, float f2) {
        super.setHotspot(f, f2);
    }

    public /* bridge */ /* synthetic */ void setHotspotBounds(int i, int i2, int i3, int i4) {
        super.setHotspotBounds(i, i2, i3, i4);
    }

    public /* bridge */ /* synthetic */ boolean setState(int[] iArr) {
        return super.setState(iArr);
    }

    public void setTint(int i) {
        if (this.a != null) {
            C0314a.m1764a(this.a, i);
        } else {
            this.f89b.f84b.setTint(i);
        }
    }

    public void setTintList(ColorStateList colorStateList) {
        if (this.a != null) {
            C0314a.m1766a(this.a, colorStateList);
        } else {
            this.f89b.f84b.setTintList(colorStateList);
        }
    }

    public void setTintMode(Mode mode) {
        if (this.a != null) {
            C0314a.m1769a(this.a, mode);
        } else {
            this.f89b.f84b.setTintMode(mode);
        }
    }

    public boolean setVisible(boolean z, boolean z2) {
        if (this.a != null) {
            return this.a.setVisible(z, z2);
        }
        this.f89b.f84b.setVisible(z, z2);
        return super.setVisible(z, z2);
    }

    public void start() {
        if (this.a != null) {
            ((AnimatedVectorDrawable) this.a).start();
        } else if (!m118a()) {
            ArrayList arrayList = this.f89b.f85c;
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                ((Animator) arrayList.get(i)).start();
            }
            invalidateSelf();
        }
    }

    public void stop() {
        if (this.a != null) {
            ((AnimatedVectorDrawable) this.a).stop();
            return;
        }
        ArrayList arrayList = this.f89b.f85c;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            ((Animator) arrayList.get(i)).end();
        }
    }
}
