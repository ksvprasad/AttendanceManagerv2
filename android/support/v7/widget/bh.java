package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;

public class bh {
    private final Context f2594a;
    private final TypedArray f2595b;

    private bh(Context context, TypedArray typedArray) {
        this.f2594a = context;
        this.f2595b = typedArray;
    }

    public static bh m5209a(Context context, AttributeSet attributeSet, int[] iArr) {
        return new bh(context, context.obtainStyledAttributes(attributeSet, iArr));
    }

    public static bh m5210a(Context context, AttributeSet attributeSet, int[] iArr, int i, int i2) {
        return new bh(context, context.obtainStyledAttributes(attributeSet, iArr, i, i2));
    }

    public float m5211a(int i, float f) {
        return this.f2595b.getFloat(i, f);
    }

    public int m5212a(int i, int i2) {
        return this.f2595b.getInt(i, i2);
    }

    public Drawable m5213a(int i) {
        if (this.f2595b.hasValue(i)) {
            int resourceId = this.f2595b.getResourceId(i, 0);
            if (resourceId != 0) {
                return C0893m.m5425a().m5448a(this.f2594a, resourceId);
            }
        }
        return this.f2595b.getDrawable(i);
    }

    public void m5214a() {
        this.f2595b.recycle();
    }

    public boolean m5215a(int i, boolean z) {
        return this.f2595b.getBoolean(i, z);
    }

    public int m5216b(int i, int i2) {
        return this.f2595b.getColor(i, i2);
    }

    public Drawable m5217b(int i) {
        if (this.f2595b.hasValue(i)) {
            int resourceId = this.f2595b.getResourceId(i, 0);
            if (resourceId != 0) {
                return C0893m.m5425a().m5449a(this.f2594a, resourceId, true);
            }
        }
        return null;
    }

    public int m5218c(int i, int i2) {
        return this.f2595b.getInteger(i, i2);
    }

    public CharSequence m5219c(int i) {
        return this.f2595b.getText(i);
    }

    public int m5220d(int i, int i2) {
        return this.f2595b.getDimensionPixelOffset(i, i2);
    }

    public String m5221d(int i) {
        return this.f2595b.getString(i);
    }

    public int m5222e(int i, int i2) {
        return this.f2595b.getDimensionPixelSize(i, i2);
    }

    public CharSequence[] m5223e(int i) {
        return this.f2595b.getTextArray(i);
    }

    public int m5224f(int i, int i2) {
        return this.f2595b.getLayoutDimension(i, i2);
    }

    public boolean m5225f(int i) {
        return this.f2595b.hasValue(i);
    }

    public int m5226g(int i, int i2) {
        return this.f2595b.getResourceId(i, i2);
    }
}
