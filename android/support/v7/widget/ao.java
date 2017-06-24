package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.view.C0507e;
import android.support.v4.view.ag;
import android.support.v7.p019b.C0694a.C0693k;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;

public class ao extends ViewGroup {
    private boolean f166a;
    private int f167b;
    private int f168c;
    private int f169d;
    private int f170e;
    private int f171f;
    private float f172g;
    private boolean f173h;
    private int[] f174i;
    private int[] f175j;
    private Drawable f176k;
    private int f177l;
    private int f178m;
    private int f179n;
    private int f180o;

    public static class C0752a extends MarginLayoutParams {
        public float f1991g;
        public int f1992h;

        public C0752a(int i, int i2) {
            super(i, i2);
            this.f1992h = -1;
            this.f1991g = 0.0f;
        }

        public C0752a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f1992h = -1;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0693k.LinearLayoutCompat_Layout);
            this.f1991g = obtainStyledAttributes.getFloat(C0693k.LinearLayoutCompat_Layout_android_layout_weight, 0.0f);
            this.f1992h = obtainStyledAttributes.getInt(C0693k.LinearLayoutCompat_Layout_android_layout_gravity, -1);
            obtainStyledAttributes.recycle();
        }

        public C0752a(LayoutParams layoutParams) {
            super(layoutParams);
            this.f1992h = -1;
        }
    }

    public ao(Context context) {
        this(context, null);
    }

    public ao(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ao(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f166a = true;
        this.f167b = -1;
        this.f168c = 0;
        this.f170e = 8388659;
        bh a = bh.m5210a(context, attributeSet, C0693k.LinearLayoutCompat, i, 0);
        int a2 = a.m5212a(C0693k.LinearLayoutCompat_android_orientation, -1);
        if (a2 >= 0) {
            setOrientation(a2);
        }
        a2 = a.m5212a(C0693k.LinearLayoutCompat_android_gravity, -1);
        if (a2 >= 0) {
            setGravity(a2);
        }
        boolean a3 = a.m5215a(C0693k.LinearLayoutCompat_android_baselineAligned, true);
        if (!a3) {
            setBaselineAligned(a3);
        }
        this.f172g = a.m5211a(C0693k.LinearLayoutCompat_android_weightSum, -1.0f);
        this.f167b = a.m5212a(C0693k.LinearLayoutCompat_android_baselineAlignedChildIndex, -1);
        this.f173h = a.m5215a(C0693k.LinearLayoutCompat_measureWithLargestChild, false);
        setDividerDrawable(a.m5213a(C0693k.LinearLayoutCompat_divider));
        this.f179n = a.m5212a(C0693k.LinearLayoutCompat_showDividers, 0);
        this.f180o = a.m5222e(C0693k.LinearLayoutCompat_dividerPadding, 0);
        a.m5214a();
    }

    private void m186a(View view, int i, int i2, int i3, int i4) {
        view.layout(i, i2, i + i3, i2 + i4);
    }

    private void m187c(int i, int i2) {
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824);
        for (int i3 = 0; i3 < i; i3++) {
            View b = m199b(i3);
            if (b.getVisibility() != 8) {
                C0752a c0752a = (C0752a) b.getLayoutParams();
                if (c0752a.width == -1) {
                    int i4 = c0752a.height;
                    c0752a.height = b.getMeasuredHeight();
                    measureChildWithMargins(b, makeMeasureSpec, 0, i2, 0);
                    c0752a.height = i4;
                }
            }
        }
    }

    private void m188d(int i, int i2) {
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824);
        for (int i3 = 0; i3 < i; i3++) {
            View b = m199b(i3);
            if (b.getVisibility() != 8) {
                C0752a c0752a = (C0752a) b.getLayoutParams();
                if (c0752a.height == -1) {
                    int i4 = c0752a.width;
                    c0752a.width = b.getMeasuredWidth();
                    measureChildWithMargins(b, i2, 0, makeMeasureSpec, 0);
                    c0752a.width = i4;
                }
            }
        }
    }

    int m189a(View view) {
        return 0;
    }

    int m190a(View view, int i) {
        return 0;
    }

    void m191a(int i, int i2) {
        int i3;
        int i4;
        int i5;
        View b;
        this.f171f = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        Object obj = 1;
        float f = 0.0f;
        int virtualChildCount = getVirtualChildCount();
        int mode = MeasureSpec.getMode(i);
        int mode2 = MeasureSpec.getMode(i2);
        Object obj2 = null;
        Object obj3 = null;
        int i10 = this.f167b;
        boolean z = this.f173h;
        int i11 = Integer.MIN_VALUE;
        int i12 = 0;
        while (i12 < virtualChildCount) {
            Object obj4;
            Object obj5;
            int i13;
            View b2 = m199b(i12);
            if (b2 == null) {
                this.f171f += m205d(i12);
                i3 = i11;
                obj4 = obj3;
                obj5 = obj;
                i4 = i7;
                i13 = i6;
            } else if (b2.getVisibility() == 8) {
                i12 += m190a(b2, i12);
                i3 = i11;
                obj4 = obj3;
                obj5 = obj;
                i4 = i7;
                i13 = i6;
            } else {
                if (m204c(i12)) {
                    this.f171f += this.f178m;
                }
                C0752a c0752a = (C0752a) b2.getLayoutParams();
                float f2 = f + c0752a.f1991g;
                if (mode2 == 1073741824 && c0752a.height == 0 && c0752a.f1991g > 0.0f) {
                    i3 = this.f171f;
                    this.f171f = Math.max(i3, (c0752a.topMargin + i3) + c0752a.bottomMargin);
                    obj3 = 1;
                } else {
                    i3 = Integer.MIN_VALUE;
                    if (c0752a.height == 0 && c0752a.f1991g > 0.0f) {
                        i3 = 0;
                        c0752a.height = -2;
                    }
                    int i14 = i3;
                    m195a(b2, i12, i, 0, i2, f2 == 0.0f ? this.f171f : 0);
                    if (i14 != Integer.MIN_VALUE) {
                        c0752a.height = i14;
                    }
                    i3 = b2.getMeasuredHeight();
                    int i15 = this.f171f;
                    this.f171f = Math.max(i15, (((i15 + i3) + c0752a.topMargin) + c0752a.bottomMargin) + m196b(b2));
                    if (z) {
                        i11 = Math.max(i3, i11);
                    }
                }
                if (i10 >= 0 && i10 == i12 + 1) {
                    this.f168c = this.f171f;
                }
                if (i12 >= i10 || c0752a.f1991g <= 0.0f) {
                    Object obj6;
                    Object obj7 = null;
                    if (mode == 1073741824 || c0752a.width != -1) {
                        obj6 = obj2;
                    } else {
                        obj6 = 1;
                        obj7 = 1;
                    }
                    i4 = c0752a.rightMargin + c0752a.leftMargin;
                    i13 = b2.getMeasuredWidth() + i4;
                    i6 = Math.max(i6, i13);
                    int a = bl.m5300a(i7, ag.m2542j(b2));
                    obj5 = (obj == null || c0752a.width != -1) ? null : 1;
                    if (c0752a.f1991g > 0.0f) {
                        i3 = Math.max(i9, obj7 != null ? i4 : i13);
                        i4 = i8;
                    } else {
                        if (obj7 == null) {
                            i4 = i13;
                        }
                        i4 = Math.max(i8, i4);
                        i3 = i9;
                    }
                    i12 += m190a(b2, i12);
                    obj4 = obj3;
                    i9 = i3;
                    i8 = i4;
                    i13 = i6;
                    i3 = i11;
                    i4 = a;
                    obj2 = obj6;
                    f = f2;
                } else {
                    throw new RuntimeException("A child of LinearLayout with index less than mBaselineAlignedChildIndex has weight > 0, which won't work.  Either remove the weight, or don't set mBaselineAlignedChildIndex.");
                }
            }
            i12++;
            i11 = i3;
            obj3 = obj4;
            obj = obj5;
            i7 = i4;
            i6 = i13;
        }
        if (this.f171f > 0 && m204c(virtualChildCount)) {
            this.f171f += this.f178m;
        }
        if (z && (mode2 == Integer.MIN_VALUE || mode2 == 0)) {
            this.f171f = 0;
            i5 = 0;
            while (i5 < virtualChildCount) {
                b = m199b(i5);
                if (b == null) {
                    this.f171f += m205d(i5);
                    i3 = i5;
                } else if (b.getVisibility() == 8) {
                    i3 = m190a(b, i5) + i5;
                } else {
                    C0752a c0752a2 = (C0752a) b.getLayoutParams();
                    int i16 = this.f171f;
                    this.f171f = Math.max(i16, (c0752a2.bottomMargin + ((i16 + i11) + c0752a2.topMargin)) + m196b(b));
                    i3 = i5;
                }
                i5 = i3 + 1;
            }
        }
        this.f171f += getPaddingTop() + getPaddingBottom();
        int a2 = ag.m2508a(Math.max(this.f171f, getSuggestedMinimumHeight()), i2, 0);
        i5 = (16777215 & a2) - this.f171f;
        int i17;
        if (obj3 != null || (i5 != 0 && f > 0.0f)) {
            if (this.f172g > 0.0f) {
                f = this.f172g;
            }
            this.f171f = 0;
            i11 = 0;
            float f3 = f;
            Object obj8 = obj;
            i17 = i8;
            i16 = i7;
            i9 = i6;
            i15 = i5;
            while (i11 < virtualChildCount) {
                View b3 = m199b(i11);
                if (b3.getVisibility() == 8) {
                    i3 = i17;
                    i5 = i16;
                    i4 = i9;
                    obj5 = obj8;
                } else {
                    float f4;
                    float f5;
                    c0752a2 = (C0752a) b3.getLayoutParams();
                    float f6 = c0752a2.f1991g;
                    if (f6 > 0.0f) {
                        i5 = (int) ((((float) i15) * f6) / f3);
                        f3 -= f6;
                        i15 -= i5;
                        i4 = getChildMeasureSpec(i, ((getPaddingLeft() + getPaddingRight()) + c0752a2.leftMargin) + c0752a2.rightMargin, c0752a2.width);
                        if (c0752a2.height == 0 && mode2 == 1073741824) {
                            if (i5 <= 0) {
                                i5 = 0;
                            }
                            b3.measure(i4, MeasureSpec.makeMeasureSpec(i5, 1073741824));
                        } else {
                            i5 += b3.getMeasuredHeight();
                            if (i5 < 0) {
                                i5 = 0;
                            }
                            b3.measure(i4, MeasureSpec.makeMeasureSpec(i5, 1073741824));
                        }
                        f4 = f3;
                        i12 = i15;
                        i15 = bl.m5300a(i16, ag.m2542j(b3) & -256);
                        f5 = f4;
                    } else {
                        f5 = f3;
                        i12 = i15;
                        i15 = i16;
                    }
                    i16 = c0752a2.leftMargin + c0752a2.rightMargin;
                    i4 = b3.getMeasuredWidth() + i16;
                    i9 = Math.max(i9, i4);
                    Object obj9 = (mode == 1073741824 || c0752a2.width != -1) ? null : 1;
                    if (obj9 == null) {
                        i16 = i4;
                    }
                    i4 = Math.max(i17, i16);
                    obj5 = (obj8 == null || c0752a2.width != -1) ? null : 1;
                    i13 = this.f171f;
                    this.f171f = Math.max(i13, (c0752a2.bottomMargin + ((b3.getMeasuredHeight() + i13) + c0752a2.topMargin)) + m196b(b3));
                    i3 = i4;
                    i4 = i9;
                    f4 = f5;
                    i5 = i15;
                    i15 = i12;
                    f3 = f4;
                }
                i11++;
                i17 = i3;
                i9 = i4;
                obj8 = obj5;
                i16 = i5;
            }
            this.f171f += getPaddingTop() + getPaddingBottom();
            obj = obj8;
            i3 = i17;
            i7 = i16;
            i5 = i9;
        } else {
            i17 = Math.max(i8, i9);
            if (z && mode2 != 1073741824) {
                for (i5 = 0; i5 < virtualChildCount; i5++) {
                    b = m199b(i5);
                    if (!(b == null || b.getVisibility() == 8 || ((C0752a) b.getLayoutParams()).f1991g <= 0.0f)) {
                        b.measure(MeasureSpec.makeMeasureSpec(b.getMeasuredWidth(), 1073741824), MeasureSpec.makeMeasureSpec(i11, 1073741824));
                    }
                }
            }
            i3 = i17;
            i5 = i6;
        }
        if (obj != null || mode == 1073741824) {
            i3 = i5;
        }
        setMeasuredDimension(ag.m2508a(Math.max(i3 + (getPaddingLeft() + getPaddingRight()), getSuggestedMinimumWidth()), i, i7), a2);
        if (obj2 != null) {
            m187c(virtualChildCount, i2);
        }
    }

    void m192a(int i, int i2, int i3, int i4) {
        int paddingLeft = getPaddingLeft();
        int i5 = i3 - i;
        int paddingRight = i5 - getPaddingRight();
        int paddingRight2 = (i5 - paddingLeft) - getPaddingRight();
        int virtualChildCount = getVirtualChildCount();
        int i6 = this.f170e & 8388615;
        switch (this.f170e & 112) {
            case 16:
                i5 = getPaddingTop() + (((i4 - i2) - this.f171f) / 2);
                break;
            case 80:
                i5 = ((getPaddingTop() + i4) - i2) - this.f171f;
                break;
            default:
                i5 = getPaddingTop();
                break;
        }
        int i7 = 0;
        int i8 = i5;
        while (i7 < virtualChildCount) {
            View b = m199b(i7);
            if (b == null) {
                i8 += m205d(i7);
                i5 = i7;
            } else if (b.getVisibility() != 8) {
                int i9;
                int measuredWidth = b.getMeasuredWidth();
                int measuredHeight = b.getMeasuredHeight();
                C0752a c0752a = (C0752a) b.getLayoutParams();
                i5 = c0752a.f1992h;
                if (i5 < 0) {
                    i5 = i6;
                }
                switch (C0507e.m2796a(i5, ag.m2540h(this)) & 7) {
                    case 1:
                        i9 = ((((paddingRight2 - measuredWidth) / 2) + paddingLeft) + c0752a.leftMargin) - c0752a.rightMargin;
                        break;
                    case 5:
                        i9 = (paddingRight - measuredWidth) - c0752a.rightMargin;
                        break;
                    default:
                        i9 = paddingLeft + c0752a.leftMargin;
                        break;
                }
                int i10 = (m204c(i7) ? this.f178m + i8 : i8) + c0752a.topMargin;
                m186a(b, i9, i10 + m189a(b), measuredWidth, measuredHeight);
                i8 = i10 + ((c0752a.bottomMargin + measuredHeight) + m196b(b));
                i5 = m190a(b, i7) + i7;
            } else {
                i5 = i7;
            }
            i7 = i5 + 1;
        }
    }

    void m193a(Canvas canvas) {
        int virtualChildCount = getVirtualChildCount();
        int i = 0;
        while (i < virtualChildCount) {
            View b = m199b(i);
            if (!(b == null || b.getVisibility() == 8 || !m204c(i))) {
                m194a(canvas, (b.getTop() - ((C0752a) b.getLayoutParams()).topMargin) - this.f178m);
            }
            i++;
        }
        if (m204c(virtualChildCount)) {
            int height;
            View b2 = m199b(virtualChildCount - 1);
            if (b2 == null) {
                height = (getHeight() - getPaddingBottom()) - this.f178m;
            } else {
                C0752a c0752a = (C0752a) b2.getLayoutParams();
                height = c0752a.bottomMargin + b2.getBottom();
            }
            m194a(canvas, height);
        }
    }

    void m194a(Canvas canvas, int i) {
        this.f176k.setBounds(getPaddingLeft() + this.f180o, i, (getWidth() - getPaddingRight()) - this.f180o, this.f178m + i);
        this.f176k.draw(canvas);
    }

    void m195a(View view, int i, int i2, int i3, int i4, int i5) {
        measureChildWithMargins(view, i2, i3, i4, i5);
    }

    int m196b(View view) {
        return 0;
    }

    public C0752a mo685b(AttributeSet attributeSet) {
        return new C0752a(getContext(), attributeSet);
    }

    protected C0752a mo686b(LayoutParams layoutParams) {
        return new C0752a(layoutParams);
    }

    View m199b(int i) {
        return getChildAt(i);
    }

    void m200b(int i, int i2) {
        int i3;
        int i4;
        C0752a c0752a;
        this.f171f = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        Object obj = 1;
        float f = 0.0f;
        int virtualChildCount = getVirtualChildCount();
        int mode = MeasureSpec.getMode(i);
        int mode2 = MeasureSpec.getMode(i2);
        Object obj2 = null;
        Object obj3 = null;
        if (this.f174i == null || this.f175j == null) {
            this.f174i = new int[4];
            this.f175j = new int[4];
        }
        int[] iArr = this.f174i;
        int[] iArr2 = this.f175j;
        iArr[3] = -1;
        iArr[2] = -1;
        iArr[1] = -1;
        iArr[0] = -1;
        iArr2[3] = -1;
        iArr2[2] = -1;
        iArr2[1] = -1;
        iArr2[0] = -1;
        boolean z = this.f166a;
        boolean z2 = this.f173h;
        Object obj4 = mode == 1073741824 ? 1 : null;
        int i9 = Integer.MIN_VALUE;
        int i10 = 0;
        while (i10 < virtualChildCount) {
            Object obj5;
            Object obj6;
            int i11;
            int i12;
            View b = m199b(i10);
            if (b == null) {
                this.f171f += m205d(i10);
                i3 = i9;
                obj5 = obj3;
                obj6 = obj;
                i11 = i6;
                i12 = i5;
            } else if (b.getVisibility() == 8) {
                i10 += m190a(b, i10);
                i3 = i9;
                obj5 = obj3;
                obj6 = obj;
                i11 = i6;
                i12 = i5;
            } else {
                Object obj7;
                if (m204c(i10)) {
                    this.f171f += this.f177l;
                }
                C0752a c0752a2 = (C0752a) b.getLayoutParams();
                float f2 = f + c0752a2.f1991g;
                if (mode == 1073741824 && c0752a2.width == 0 && c0752a2.f1991g > 0.0f) {
                    if (obj4 != null) {
                        this.f171f += c0752a2.leftMargin + c0752a2.rightMargin;
                    } else {
                        i3 = this.f171f;
                        this.f171f = Math.max(i3, (c0752a2.leftMargin + i3) + c0752a2.rightMargin);
                    }
                    if (z) {
                        i3 = MeasureSpec.makeMeasureSpec(0, 0);
                        b.measure(i3, i3);
                    } else {
                        obj3 = 1;
                    }
                } else {
                    i3 = Integer.MIN_VALUE;
                    if (c0752a2.width == 0 && c0752a2.f1991g > 0.0f) {
                        i3 = 0;
                        c0752a2.width = -2;
                    }
                    int i13 = i3;
                    m195a(b, i10, i, f2 == 0.0f ? this.f171f : 0, i2, 0);
                    if (i13 != Integer.MIN_VALUE) {
                        c0752a2.width = i13;
                    }
                    i3 = b.getMeasuredWidth();
                    if (obj4 != null) {
                        this.f171f += ((c0752a2.leftMargin + i3) + c0752a2.rightMargin) + m196b(b);
                    } else {
                        int i14 = this.f171f;
                        this.f171f = Math.max(i14, (((i14 + i3) + c0752a2.leftMargin) + c0752a2.rightMargin) + m196b(b));
                    }
                    if (z2) {
                        i9 = Math.max(i3, i9);
                    }
                }
                Object obj8 = null;
                if (mode2 == 1073741824 || c0752a2.height != -1) {
                    obj7 = obj2;
                } else {
                    obj7 = 1;
                    obj8 = 1;
                }
                i11 = c0752a2.bottomMargin + c0752a2.topMargin;
                i12 = b.getMeasuredHeight() + i11;
                int a = bl.m5300a(i6, ag.m2542j(b));
                if (z) {
                    i6 = b.getBaseline();
                    if (i6 != -1) {
                        int i15 = ((((c0752a2.f1992h < 0 ? this.f170e : c0752a2.f1992h) & 112) >> 4) & -2) >> 1;
                        iArr[i15] = Math.max(iArr[i15], i6);
                        iArr2[i15] = Math.max(iArr2[i15], i12 - i6);
                    }
                }
                i6 = Math.max(i5, i12);
                obj6 = (obj == null || c0752a2.height != -1) ? null : 1;
                if (c0752a2.f1991g > 0.0f) {
                    i3 = Math.max(i8, obj8 != null ? i11 : i12);
                    i11 = i7;
                } else {
                    if (obj8 == null) {
                        i11 = i12;
                    }
                    i11 = Math.max(i7, i11);
                    i3 = i8;
                }
                i10 += m190a(b, i10);
                obj5 = obj3;
                i8 = i3;
                i7 = i11;
                i12 = i6;
                i3 = i9;
                i11 = a;
                obj2 = obj7;
                f = f2;
            }
            i10++;
            i9 = i3;
            obj3 = obj5;
            obj = obj6;
            i6 = i11;
            i5 = i12;
        }
        if (this.f171f > 0 && m204c(virtualChildCount)) {
            this.f171f += this.f177l;
        }
        i10 = (iArr[1] == -1 && iArr[0] == -1 && iArr[2] == -1 && iArr[3] == -1) ? i5 : Math.max(i5, Math.max(iArr[3], Math.max(iArr[0], Math.max(iArr[1], iArr[2]))) + Math.max(iArr2[3], Math.max(iArr2[0], Math.max(iArr2[1], iArr2[2]))));
        if (z2 && (mode == Integer.MIN_VALUE || mode == 0)) {
            this.f171f = 0;
            i4 = 0;
            while (i4 < virtualChildCount) {
                View b2 = m199b(i4);
                if (b2 == null) {
                    this.f171f += m205d(i4);
                    i3 = i4;
                } else if (b2.getVisibility() == 8) {
                    i3 = m190a(b2, i4) + i4;
                } else {
                    c0752a = (C0752a) b2.getLayoutParams();
                    if (obj4 != null) {
                        this.f171f = ((c0752a.rightMargin + (c0752a.leftMargin + i9)) + m196b(b2)) + this.f171f;
                        i3 = i4;
                    } else {
                        i11 = this.f171f;
                        this.f171f = Math.max(i11, (c0752a.rightMargin + ((i11 + i9) + c0752a.leftMargin)) + m196b(b2));
                        i3 = i4;
                    }
                }
                i4 = i3 + 1;
            }
        }
        this.f171f += getPaddingLeft() + getPaddingRight();
        int a2 = ag.m2508a(Math.max(this.f171f, getSuggestedMinimumWidth()), i, 0);
        i4 = (16777215 & a2) - this.f171f;
        int i16;
        if (obj3 != null || (i4 != 0 && f > 0.0f)) {
            if (this.f172g > 0.0f) {
                f = this.f172g;
            }
            iArr[3] = -1;
            iArr[2] = -1;
            iArr[1] = -1;
            iArr[0] = -1;
            iArr2[3] = -1;
            iArr2[2] = -1;
            iArr2[1] = -1;
            iArr2[0] = -1;
            this.f171f = 0;
            i9 = 0;
            float f3 = f;
            Object obj9 = obj;
            i16 = i7;
            i15 = i6;
            i14 = i4;
            i7 = -1;
            while (i9 < virtualChildCount) {
                float f4;
                Object obj10;
                View b3 = m199b(i9);
                if (b3 == null) {
                    f4 = f3;
                    i4 = i14;
                    i11 = i7;
                    i14 = i16;
                    obj10 = obj9;
                } else if (b3.getVisibility() == 8) {
                    f4 = f3;
                    i4 = i14;
                    i11 = i7;
                    i14 = i16;
                    obj10 = obj9;
                } else {
                    float f5;
                    c0752a = (C0752a) b3.getLayoutParams();
                    float f6 = c0752a.f1991g;
                    if (f6 > 0.0f) {
                        i4 = (int) ((((float) i14) * f6) / f3);
                        f3 -= f6;
                        i11 = i14 - i4;
                        i14 = getChildMeasureSpec(i2, ((getPaddingTop() + getPaddingBottom()) + c0752a.topMargin) + c0752a.bottomMargin, c0752a.height);
                        if (c0752a.width == 0 && mode == 1073741824) {
                            if (i4 <= 0) {
                                i4 = 0;
                            }
                            b3.measure(MeasureSpec.makeMeasureSpec(i4, 1073741824), i14);
                        } else {
                            i4 += b3.getMeasuredWidth();
                            if (i4 < 0) {
                                i4 = 0;
                            }
                            b3.measure(MeasureSpec.makeMeasureSpec(i4, 1073741824), i14);
                        }
                        i8 = bl.m5300a(i15, ag.m2542j(b3) & -16777216);
                        f5 = f3;
                    } else {
                        i11 = i14;
                        i8 = i15;
                        f5 = f3;
                    }
                    if (obj4 != null) {
                        this.f171f += ((b3.getMeasuredWidth() + c0752a.leftMargin) + c0752a.rightMargin) + m196b(b3);
                    } else {
                        i4 = this.f171f;
                        this.f171f = Math.max(i4, (((b3.getMeasuredWidth() + i4) + c0752a.leftMargin) + c0752a.rightMargin) + m196b(b3));
                    }
                    obj5 = (mode2 == 1073741824 || c0752a.height != -1) ? null : 1;
                    i10 = c0752a.topMargin + c0752a.bottomMargin;
                    i14 = b3.getMeasuredHeight() + i10;
                    i7 = Math.max(i7, i14);
                    i10 = Math.max(i16, obj5 != null ? i10 : i14);
                    obj5 = (obj9 == null || c0752a.height != -1) ? null : 1;
                    if (z) {
                        i12 = b3.getBaseline();
                        if (i12 != -1) {
                            i3 = ((((c0752a.f1992h < 0 ? this.f170e : c0752a.f1992h) & 112) >> 4) & -2) >> 1;
                            iArr[i3] = Math.max(iArr[i3], i12);
                            iArr2[i3] = Math.max(iArr2[i3], i14 - i12);
                        }
                    }
                    f4 = f5;
                    i14 = i10;
                    obj10 = obj5;
                    i15 = i8;
                    i4 = i11;
                    i11 = i7;
                }
                i9++;
                i16 = i14;
                i7 = i11;
                obj9 = obj10;
                i14 = i4;
                f3 = f4;
            }
            this.f171f += getPaddingLeft() + getPaddingRight();
            if (!(iArr[1] == -1 && iArr[0] == -1 && iArr[2] == -1 && iArr[3] == -1)) {
                i7 = Math.max(i7, Math.max(iArr[3], Math.max(iArr[0], Math.max(iArr[1], iArr[2]))) + Math.max(iArr2[3], Math.max(iArr2[0], Math.max(iArr2[1], iArr2[2]))));
            }
            obj = obj9;
            i3 = i16;
            i6 = i15;
            i4 = i7;
        } else {
            i16 = Math.max(i7, i8);
            if (z2 && mode != 1073741824) {
                for (i4 = 0; i4 < virtualChildCount; i4++) {
                    View b4 = m199b(i4);
                    if (!(b4 == null || b4.getVisibility() == 8 || ((C0752a) b4.getLayoutParams()).f1991g <= 0.0f)) {
                        b4.measure(MeasureSpec.makeMeasureSpec(i9, 1073741824), MeasureSpec.makeMeasureSpec(b4.getMeasuredHeight(), 1073741824));
                    }
                }
            }
            i3 = i16;
            i4 = i10;
        }
        if (obj != null || mode2 == 1073741824) {
            i3 = i4;
        }
        setMeasuredDimension((-16777216 & i6) | a2, ag.m2508a(Math.max(i3 + (getPaddingTop() + getPaddingBottom()), getSuggestedMinimumHeight()), i2, i6 << 16));
        if (obj2 != null) {
            m188d(virtualChildCount, i);
        }
    }

    void m201b(int i, int i2, int i3, int i4) {
        int paddingLeft;
        int i5;
        int i6;
        boolean a = bl.m5302a(this);
        int paddingTop = getPaddingTop();
        int i7 = i4 - i2;
        int paddingBottom = i7 - getPaddingBottom();
        int paddingBottom2 = (i7 - paddingTop) - getPaddingBottom();
        int virtualChildCount = getVirtualChildCount();
        i7 = this.f170e & 8388615;
        int i8 = this.f170e & 112;
        boolean z = this.f166a;
        int[] iArr = this.f174i;
        int[] iArr2 = this.f175j;
        switch (C0507e.m2796a(i7, ag.m2540h(this))) {
            case 1:
                paddingLeft = getPaddingLeft() + (((i3 - i) - this.f171f) / 2);
                break;
            case 5:
                paddingLeft = ((getPaddingLeft() + i3) - i) - this.f171f;
                break;
            default:
                paddingLeft = getPaddingLeft();
                break;
        }
        if (a) {
            i5 = -1;
            i6 = virtualChildCount - 1;
        } else {
            i5 = 1;
            i6 = 0;
        }
        int i9 = 0;
        while (i9 < virtualChildCount) {
            int i10 = i6 + (i5 * i9);
            View b = m199b(i10);
            if (b == null) {
                paddingLeft += m205d(i10);
                i7 = i9;
            } else if (b.getVisibility() != 8) {
                int i11;
                int measuredWidth = b.getMeasuredWidth();
                int measuredHeight = b.getMeasuredHeight();
                C0752a c0752a = (C0752a) b.getLayoutParams();
                i7 = (!z || c0752a.height == -1) ? -1 : b.getBaseline();
                int i12 = c0752a.f1992h;
                if (i12 < 0) {
                    i12 = i8;
                }
                switch (i12 & 112) {
                    case 16:
                        i11 = ((((paddingBottom2 - measuredHeight) / 2) + paddingTop) + c0752a.topMargin) - c0752a.bottomMargin;
                        break;
                    case 48:
                        i11 = paddingTop + c0752a.topMargin;
                        if (i7 != -1) {
                            i11 += iArr[1] - i7;
                            break;
                        }
                        break;
                    case 80:
                        i11 = (paddingBottom - measuredHeight) - c0752a.bottomMargin;
                        if (i7 != -1) {
                            i11 -= iArr2[2] - (b.getMeasuredHeight() - i7);
                            break;
                        }
                        break;
                    default:
                        i11 = paddingTop;
                        break;
                }
                paddingLeft = (m204c(i10) ? this.f177l + paddingLeft : paddingLeft) + c0752a.leftMargin;
                m186a(b, paddingLeft + m189a(b), i11, measuredWidth, measuredHeight);
                paddingLeft += (c0752a.rightMargin + measuredWidth) + m196b(b);
                i7 = m190a(b, i10) + i9;
            } else {
                i7 = i9;
            }
            i9 = i7 + 1;
        }
    }

    void m202b(Canvas canvas) {
        int virtualChildCount = getVirtualChildCount();
        boolean a = bl.m5302a(this);
        int i = 0;
        while (i < virtualChildCount) {
            View b = m199b(i);
            if (!(b == null || b.getVisibility() == 8 || !m204c(i))) {
                C0752a c0752a = (C0752a) b.getLayoutParams();
                m203b(canvas, a ? c0752a.rightMargin + b.getRight() : (b.getLeft() - c0752a.leftMargin) - this.f177l);
            }
            i++;
        }
        if (m204c(virtualChildCount)) {
            int paddingLeft;
            View b2 = m199b(virtualChildCount - 1);
            if (b2 == null) {
                paddingLeft = a ? getPaddingLeft() : (getWidth() - getPaddingRight()) - this.f177l;
            } else {
                c0752a = (C0752a) b2.getLayoutParams();
                paddingLeft = a ? (b2.getLeft() - c0752a.leftMargin) - this.f177l : c0752a.rightMargin + b2.getRight();
            }
            m203b(canvas, paddingLeft);
        }
    }

    void m203b(Canvas canvas, int i) {
        this.f176k.setBounds(i, getPaddingTop() + this.f180o, this.f177l + i, (getHeight() - getPaddingBottom()) - this.f180o);
        this.f176k.draw(canvas);
    }

    protected boolean m204c(int i) {
        if (i == 0) {
            return (this.f179n & 1) != 0;
        } else {
            if (i == getChildCount()) {
                return (this.f179n & 4) != 0;
            } else {
                if ((this.f179n & 2) == 0) {
                    return false;
                }
                for (int i2 = i - 1; i2 >= 0; i2--) {
                    if (getChildAt(i2).getVisibility() != 8) {
                        return true;
                    }
                }
                return false;
            }
        }
    }

    protected boolean checkLayoutParams(LayoutParams layoutParams) {
        return layoutParams instanceof C0752a;
    }

    int m205d(int i) {
        return 0;
    }

    protected /* synthetic */ LayoutParams generateDefaultLayoutParams() {
        return mo691j();
    }

    public /* synthetic */ LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return mo685b(attributeSet);
    }

    protected /* synthetic */ LayoutParams generateLayoutParams(LayoutParams layoutParams) {
        return mo686b(layoutParams);
    }

    public int getBaseline() {
        if (this.f167b < 0) {
            return super.getBaseline();
        }
        if (getChildCount() <= this.f167b) {
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout set to an index that is out of bounds.");
        }
        View childAt = getChildAt(this.f167b);
        int baseline = childAt.getBaseline();
        if (baseline != -1) {
            int i;
            int i2 = this.f168c;
            if (this.f169d == 1) {
                i = this.f170e & 112;
                if (i != 48) {
                    switch (i) {
                        case 16:
                            i = i2 + (((((getBottom() - getTop()) - getPaddingTop()) - getPaddingBottom()) - this.f171f) / 2);
                            break;
                        case 80:
                            i = ((getBottom() - getTop()) - getPaddingBottom()) - this.f171f;
                            break;
                    }
                }
            }
            i = i2;
            return (((C0752a) childAt.getLayoutParams()).topMargin + i) + baseline;
        } else if (this.f167b == 0) {
            return -1;
        } else {
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout points to a View that doesn't know how to get its baseline.");
        }
    }

    public int getBaselineAlignedChildIndex() {
        return this.f167b;
    }

    public Drawable getDividerDrawable() {
        return this.f176k;
    }

    public int getDividerPadding() {
        return this.f180o;
    }

    public int getDividerWidth() {
        return this.f177l;
    }

    public int getOrientation() {
        return this.f169d;
    }

    public int getShowDividers() {
        return this.f179n;
    }

    int getVirtualChildCount() {
        return getChildCount();
    }

    public float getWeightSum() {
        return this.f172g;
    }

    protected C0752a mo691j() {
        return this.f169d == 0 ? new C0752a(-2, -2) : this.f169d == 1 ? new C0752a(-1, -2) : null;
    }

    protected void onDraw(Canvas canvas) {
        if (this.f176k != null) {
            if (this.f169d == 1) {
                m193a(canvas);
            } else {
                m202b(canvas);
            }
        }
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (VERSION.SDK_INT >= 14) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setClassName(ao.class.getName());
        }
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (VERSION.SDK_INT >= 14) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            accessibilityNodeInfo.setClassName(ao.class.getName());
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.f169d == 1) {
            m192a(i, i2, i3, i4);
        } else {
            m201b(i, i2, i3, i4);
        }
    }

    protected void onMeasure(int i, int i2) {
        if (this.f169d == 1) {
            m191a(i, i2);
        } else {
            m200b(i, i2);
        }
    }

    public void setBaselineAligned(boolean z) {
        this.f166a = z;
    }

    public void setBaselineAlignedChildIndex(int i) {
        if (i < 0 || i >= getChildCount()) {
            throw new IllegalArgumentException("base aligned child index out of range (0, " + getChildCount() + ")");
        }
        this.f167b = i;
    }

    public void setDividerDrawable(Drawable drawable) {
        boolean z = false;
        if (drawable != this.f176k) {
            this.f176k = drawable;
            if (drawable != null) {
                this.f177l = drawable.getIntrinsicWidth();
                this.f178m = drawable.getIntrinsicHeight();
            } else {
                this.f177l = 0;
                this.f178m = 0;
            }
            if (drawable == null) {
                z = true;
            }
            setWillNotDraw(z);
            requestLayout();
        }
    }

    public void setDividerPadding(int i) {
        this.f180o = i;
    }

    public void setGravity(int i) {
        if (this.f170e != i) {
            int i2 = (8388615 & i) == 0 ? 8388611 | i : i;
            if ((i2 & 112) == 0) {
                i2 |= 48;
            }
            this.f170e = i2;
            requestLayout();
        }
    }

    public void setHorizontalGravity(int i) {
        int i2 = i & 8388615;
        if ((this.f170e & 8388615) != i2) {
            this.f170e = i2 | (this.f170e & -8388616);
            requestLayout();
        }
    }

    public void setMeasureWithLargestChildEnabled(boolean z) {
        this.f173h = z;
    }

    public void setOrientation(int i) {
        if (this.f169d != i) {
            this.f169d = i;
            requestLayout();
        }
    }

    public void setShowDividers(int i) {
        if (i != this.f179n) {
            requestLayout();
        }
        this.f179n = i;
    }

    public void setVerticalGravity(int i) {
        int i2 = i & 112;
        if ((this.f170e & 112) != i2) {
            this.f170e = i2 | (this.f170e & -113);
            requestLayout();
        }
    }

    public void setWeightSum(float f) {
        this.f172g = Math.max(0.0f, f);
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }
}
