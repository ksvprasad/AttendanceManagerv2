package com.rey.material.p042c;

import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.TextView;
import com.rey.material.C2167a.C2162b;
import java.util.concurrent.atomic.AtomicInteger;

public class C2176d {
    private static final AtomicInteger f7314a = new AtomicInteger(1);

    public static void m12401a(View view, int i) {
        C2176d.m12403a(view, null, 0, i);
    }

    public static void m12402a(View view, Drawable drawable) {
        if (VERSION.SDK_INT >= 16) {
            view.setBackground(drawable);
        } else {
            view.setBackgroundDrawable(drawable);
        }
    }

    public static void m12403a(View view, AttributeSet attributeSet, int i, int i2) {
        TypedArray obtainStyledAttributes = view.getContext().obtainStyledAttributes(attributeSet, C2162b.View, i, i2);
        int i3 = -1;
        int i4 = -1;
        int i5 = -1;
        int i6 = -1;
        int i7 = Integer.MIN_VALUE;
        int i8 = Integer.MIN_VALUE;
        int i9 = -1;
        Object obj = null;
        Object obj2 = null;
        Object obj3 = null;
        Object obj4 = null;
        int indexCount = obtainStyledAttributes.getIndexCount();
        int i10 = 0;
        while (i10 < indexCount) {
            Object obj5;
            int i11;
            int dimensionPixelSize;
            int i12;
            int index = obtainStyledAttributes.getIndex(i10);
            if (index == C2162b.View_android_background) {
                C2176d.m12402a(view, obtainStyledAttributes.getDrawable(index));
                obj5 = obj4;
                obj4 = obj3;
                obj3 = obj2;
                obj2 = obj;
                i11 = i9;
                i9 = i8;
                i8 = i7;
                i7 = i6;
                i6 = i5;
                i5 = i4;
                i4 = i3;
            } else {
                if (index == C2162b.View_android_backgroundTint) {
                    if (VERSION.SDK_INT >= 21) {
                        view.setBackgroundTintList(obtainStyledAttributes.getColorStateList(index));
                        obj5 = obj4;
                        obj4 = obj3;
                        obj3 = obj2;
                        obj2 = obj;
                        i11 = i9;
                        i9 = i8;
                        i8 = i7;
                        i7 = i6;
                        i6 = i5;
                        i5 = i4;
                        i4 = i3;
                    }
                } else if (index == C2162b.View_android_backgroundTintMode) {
                    if (VERSION.SDK_INT >= 21) {
                        switch (obtainStyledAttributes.getInt(index, 3)) {
                            case 3:
                                view.setBackgroundTintMode(Mode.SRC_OVER);
                                break;
                            case 5:
                                view.setBackgroundTintMode(Mode.SRC_IN);
                                break;
                            case 9:
                                view.setBackgroundTintMode(Mode.SRC_ATOP);
                                break;
                            case 14:
                                view.setBackgroundTintMode(Mode.MULTIPLY);
                                break;
                            case 15:
                                view.setBackgroundTintMode(Mode.SCREEN);
                                break;
                            case 16:
                                view.setBackgroundTintMode(Mode.ADD);
                                break;
                        }
                        obj5 = obj4;
                        obj4 = obj3;
                        obj3 = obj2;
                        obj2 = obj;
                        i11 = i9;
                        i9 = i8;
                        i8 = i7;
                        i7 = i6;
                        i6 = i5;
                        i5 = i4;
                        i4 = i3;
                    }
                } else if (index == C2162b.View_android_elevation) {
                    if (VERSION.SDK_INT >= 21) {
                        view.setElevation((float) obtainStyledAttributes.getDimensionPixelOffset(index, 0));
                        obj5 = obj4;
                        obj4 = obj3;
                        obj3 = obj2;
                        obj2 = obj;
                        i11 = i9;
                        i9 = i8;
                        i8 = i7;
                        i7 = i6;
                        i6 = i5;
                        i5 = i4;
                        i4 = i3;
                    }
                } else if (index == C2162b.View_android_padding) {
                    dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(index, -1);
                    obj4 = 1;
                    obj5 = 1;
                    i9 = i8;
                    i8 = i7;
                    i7 = i6;
                    i6 = i5;
                    i5 = i4;
                    i4 = i3;
                    r20 = obj2;
                    obj2 = obj;
                    i11 = dimensionPixelSize;
                    obj3 = r20;
                } else if (index == C2162b.View_android_paddingLeft) {
                    dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(index, -1);
                    r20 = obj4;
                    i12 = 1;
                    obj5 = r20;
                    r21 = obj2;
                    obj2 = obj;
                    i11 = i9;
                    i9 = i8;
                    i8 = i7;
                    i7 = i6;
                    i6 = i5;
                    i5 = i4;
                    i4 = dimensionPixelSize;
                    obj3 = r21;
                } else if (index == C2162b.View_android_paddingTop) {
                    i4 = i3;
                    r20 = obj3;
                    obj3 = obj2;
                    obj2 = obj;
                    i11 = i9;
                    i9 = i8;
                    i8 = i7;
                    i7 = i6;
                    i6 = i5;
                    i5 = obtainStyledAttributes.getDimensionPixelSize(index, -1);
                    obj5 = obj4;
                    obj4 = r20;
                } else if (index == C2162b.View_android_paddingRight) {
                    i12 = obtainStyledAttributes.getDimensionPixelSize(index, -1);
                    obj5 = 1;
                    i5 = i4;
                    i4 = i3;
                    r20 = obj;
                    i11 = i9;
                    i9 = i8;
                    i8 = i7;
                    i7 = i6;
                    i6 = i12;
                    obj4 = obj3;
                    obj3 = obj2;
                    obj2 = r20;
                } else if (index == C2162b.View_android_paddingBottom) {
                    i6 = i5;
                    i5 = i4;
                    i4 = i3;
                    r20 = obj;
                    i11 = i9;
                    i9 = i8;
                    i8 = i7;
                    i7 = obtainStyledAttributes.getDimensionPixelSize(index, -1);
                    obj5 = obj4;
                    obj4 = obj3;
                    obj3 = obj2;
                    obj2 = r20;
                } else if (index == C2162b.View_android_paddingStart) {
                    if (VERSION.SDK_INT >= 17) {
                        i11 = obtainStyledAttributes.getDimensionPixelSize(index, Integer.MIN_VALUE);
                        obj5 = i11 != Integer.MIN_VALUE ? 1 : null;
                        i7 = i6;
                        i6 = i5;
                        i5 = i4;
                        i4 = i3;
                        r20 = i9;
                        i9 = i8;
                        i8 = i11;
                        i11 = r20;
                        r21 = obj4;
                        obj4 = obj3;
                        obj3 = obj2;
                        obj2 = obj5;
                        obj5 = r21;
                    }
                } else if (index == C2162b.View_android_paddingEnd) {
                    if (VERSION.SDK_INT >= 17) {
                        int dimensionPixelSize2 = obtainStyledAttributes.getDimensionPixelSize(index, Integer.MIN_VALUE);
                        obj5 = dimensionPixelSize2 != Integer.MIN_VALUE ? 1 : null;
                        i8 = i7;
                        i7 = i6;
                        i6 = i5;
                        i5 = i4;
                        i4 = i3;
                        r20 = dimensionPixelSize2;
                        obj2 = obj;
                        i11 = i9;
                        i9 = r20;
                        r21 = obj5;
                        obj5 = obj4;
                        obj4 = obj3;
                        obj3 = r21;
                    }
                } else if (index == C2162b.View_android_fadeScrollbars) {
                    view.setScrollbarFadingEnabled(obtainStyledAttributes.getBoolean(index, true));
                    obj5 = obj4;
                    obj4 = obj3;
                    obj3 = obj2;
                    obj2 = obj;
                    i11 = i9;
                    i9 = i8;
                    i8 = i7;
                    i7 = i6;
                    i6 = i5;
                    i5 = i4;
                    i4 = i3;
                } else if (index == C2162b.View_android_fadingEdgeLength) {
                    view.setFadingEdgeLength(obtainStyledAttributes.getDimensionPixelOffset(index, 0));
                    obj5 = obj4;
                    obj4 = obj3;
                    obj3 = obj2;
                    obj2 = obj;
                    i11 = i9;
                    i9 = i8;
                    i8 = i7;
                    i7 = i6;
                    i6 = i5;
                    i5 = i4;
                    i4 = i3;
                } else if (index == C2162b.View_android_minHeight) {
                    view.setMinimumHeight(obtainStyledAttributes.getDimensionPixelSize(index, 0));
                    obj5 = obj4;
                    obj4 = obj3;
                    obj3 = obj2;
                    obj2 = obj;
                    i11 = i9;
                    i9 = i8;
                    i8 = i7;
                    i7 = i6;
                    i6 = i5;
                    i5 = i4;
                    i4 = i3;
                } else if (index == C2162b.View_android_minWidth) {
                    view.setMinimumWidth(obtainStyledAttributes.getDimensionPixelSize(index, 0));
                    obj5 = obj4;
                    obj4 = obj3;
                    obj3 = obj2;
                    obj2 = obj;
                    i11 = i9;
                    i9 = i8;
                    i8 = i7;
                    i7 = i6;
                    i6 = i5;
                    i5 = i4;
                    i4 = i3;
                } else if (index == C2162b.View_android_requiresFadingEdge) {
                    view.setVerticalFadingEdgeEnabled(obtainStyledAttributes.getBoolean(index, true));
                    obj5 = obj4;
                    obj4 = obj3;
                    obj3 = obj2;
                    obj2 = obj;
                    i11 = i9;
                    i9 = i8;
                    i8 = i7;
                    i7 = i6;
                    i6 = i5;
                    i5 = i4;
                    i4 = i3;
                } else if (index == C2162b.View_android_scrollbarDefaultDelayBeforeFade) {
                    if (VERSION.SDK_INT >= 16) {
                        view.setScrollBarDefaultDelayBeforeFade(obtainStyledAttributes.getInteger(index, 0));
                        obj5 = obj4;
                        obj4 = obj3;
                        obj3 = obj2;
                        obj2 = obj;
                        i11 = i9;
                        i9 = i8;
                        i8 = i7;
                        i7 = i6;
                        i6 = i5;
                        i5 = i4;
                        i4 = i3;
                    }
                } else if (index == C2162b.View_android_scrollbarFadeDuration) {
                    if (VERSION.SDK_INT >= 16) {
                        view.setScrollBarFadeDuration(obtainStyledAttributes.getInteger(index, 0));
                        obj5 = obj4;
                        obj4 = obj3;
                        obj3 = obj2;
                        obj2 = obj;
                        i11 = i9;
                        i9 = i8;
                        i8 = i7;
                        i7 = i6;
                        i6 = i5;
                        i5 = i4;
                        i4 = i3;
                    }
                } else if (index == C2162b.View_android_scrollbarSize) {
                    if (VERSION.SDK_INT >= 16) {
                        view.setScrollBarSize(obtainStyledAttributes.getDimensionPixelSize(index, 0));
                        obj5 = obj4;
                        obj4 = obj3;
                        obj3 = obj2;
                        obj2 = obj;
                        i11 = i9;
                        i9 = i8;
                        i8 = i7;
                        i7 = i6;
                        i6 = i5;
                        i5 = i4;
                        i4 = i3;
                    }
                } else if (index == C2162b.View_android_scrollbarStyle) {
                    switch (obtainStyledAttributes.getInteger(index, 0)) {
                        case 0:
                            view.setScrollBarStyle(0);
                            break;
                        case 16777216:
                            view.setScrollBarStyle(16777216);
                            break;
                        case 33554432:
                            view.setScrollBarStyle(33554432);
                            break;
                        case 50331648:
                            view.setScrollBarStyle(50331648);
                            break;
                    }
                    obj5 = obj4;
                    obj4 = obj3;
                    obj3 = obj2;
                    obj2 = obj;
                    i11 = i9;
                    i9 = i8;
                    i8 = i7;
                    i7 = i6;
                    i6 = i5;
                    i5 = i4;
                    i4 = i3;
                } else if (index == C2162b.View_android_soundEffectsEnabled) {
                    view.setSoundEffectsEnabled(obtainStyledAttributes.getBoolean(index, true));
                    obj5 = obj4;
                    obj4 = obj3;
                    obj3 = obj2;
                    obj2 = obj;
                    i11 = i9;
                    i9 = i8;
                    i8 = i7;
                    i7 = i6;
                    i6 = i5;
                    i5 = i4;
                    i4 = i3;
                } else if (index == C2162b.View_android_textAlignment) {
                    if (VERSION.SDK_INT >= 17) {
                        switch (obtainStyledAttributes.getInteger(index, 0)) {
                            case 0:
                                view.setTextAlignment(0);
                                break;
                            case 1:
                                view.setTextAlignment(1);
                                break;
                            case 2:
                                view.setTextAlignment(2);
                                break;
                            case 3:
                                view.setTextAlignment(3);
                                break;
                            case 4:
                                view.setTextAlignment(4);
                                break;
                            case 5:
                                view.setTextAlignment(5);
                                break;
                            case 6:
                                view.setTextAlignment(6);
                                break;
                        }
                        obj5 = obj4;
                        obj4 = obj3;
                        obj3 = obj2;
                        obj2 = obj;
                        i11 = i9;
                        i9 = i8;
                        i8 = i7;
                        i7 = i6;
                        i6 = i5;
                        i5 = i4;
                        i4 = i3;
                    }
                } else if (index == C2162b.View_android_textDirection) {
                    if (VERSION.SDK_INT >= 17) {
                        switch (obtainStyledAttributes.getInteger(index, 0)) {
                            case 0:
                                view.setTextDirection(0);
                                break;
                            case 1:
                                view.setTextDirection(1);
                                break;
                            case 2:
                                view.setTextDirection(2);
                                break;
                            case 3:
                                view.setTextDirection(3);
                                break;
                            case 4:
                                view.setTextDirection(4);
                                break;
                            case 5:
                                view.setTextDirection(5);
                                break;
                        }
                        obj5 = obj4;
                        obj4 = obj3;
                        obj3 = obj2;
                        obj2 = obj;
                        i11 = i9;
                        i9 = i8;
                        i8 = i7;
                        i7 = i6;
                        i6 = i5;
                        i5 = i4;
                        i4 = i3;
                    }
                } else if (index == C2162b.View_android_visibility) {
                    switch (obtainStyledAttributes.getInteger(index, 0)) {
                        case 0:
                            view.setVisibility(0);
                            break;
                        case 1:
                            view.setVisibility(4);
                            break;
                        case 2:
                            view.setVisibility(8);
                            break;
                    }
                    obj5 = obj4;
                    obj4 = obj3;
                    obj3 = obj2;
                    obj2 = obj;
                    i11 = i9;
                    i9 = i8;
                    i8 = i7;
                    i7 = i6;
                    i6 = i5;
                    i5 = i4;
                    i4 = i3;
                } else if (index == C2162b.View_android_layoutDirection) {
                    if (VERSION.SDK_INT >= 17) {
                        switch (obtainStyledAttributes.getInteger(index, 0)) {
                            case 0:
                                view.setLayoutDirection(0);
                                break;
                            case 1:
                                view.setLayoutDirection(1);
                                break;
                            case 2:
                                view.setLayoutDirection(2);
                                break;
                            case 3:
                                view.setLayoutDirection(3);
                                break;
                        }
                        obj5 = obj4;
                        obj4 = obj3;
                        obj3 = obj2;
                        obj2 = obj;
                        i11 = i9;
                        i9 = i8;
                        i8 = i7;
                        i7 = i6;
                        i6 = i5;
                        i5 = i4;
                        i4 = i3;
                    }
                } else if (index == C2162b.View_android_src && (view instanceof ImageView)) {
                    ((ImageView) view).setImageResource(obtainStyledAttributes.getResourceId(index, 0));
                }
                obj5 = obj4;
                obj4 = obj3;
                obj3 = obj2;
                obj2 = obj;
                i11 = i9;
                i9 = i8;
                i8 = i7;
                i7 = i6;
                i6 = i5;
                i5 = i4;
                i4 = i3;
            }
            i10++;
            i3 = i4;
            i4 = i5;
            i5 = i6;
            i6 = i7;
            i7 = i8;
            i8 = i9;
            i9 = i11;
            obj = obj2;
            obj2 = obj3;
            obj3 = obj4;
            obj4 = obj5;
        }
        if (i9 >= 0) {
            view.setPadding(i9, i9, i9, i9);
        } else if (VERSION.SDK_INT < 17) {
            i12 = obj != null ? i7 : i3;
            index = obj2 != null ? i8 : i5;
            if (i12 < 0) {
                i12 = view.getPaddingLeft();
            }
            if (i4 < 0) {
                i4 = view.getPaddingTop();
            }
            if (index < 0) {
                index = view.getPaddingRight();
            }
            if (i6 < 0) {
                i6 = view.getPaddingBottom();
            }
            view.setPadding(i12, i4, index, i6);
        } else {
            if (!(obj3 == null && obj4 == null)) {
                if (obj3 == null) {
                    i3 = view.getPaddingLeft();
                }
                dimensionPixelSize = i4 >= 0 ? i4 : view.getPaddingTop();
                if (obj4 == null) {
                    i5 = view.getPaddingRight();
                }
                view.setPadding(i3, dimensionPixelSize, i5, i6 >= 0 ? i6 : view.getPaddingBottom());
            }
            if (!(obj == null && obj2 == null)) {
                if (obj == null) {
                    i7 = view.getPaddingStart();
                }
                if (i4 < 0) {
                    i4 = view.getPaddingTop();
                }
                if (obj2 == null) {
                    i8 = view.getPaddingEnd();
                }
                if (i6 < 0) {
                    i6 = view.getPaddingBottom();
                }
                view.setPaddingRelative(i7, i4, i8, i6);
            }
        }
        obtainStyledAttributes.recycle();
        if (view instanceof TextView) {
            C2176d.m12405a((TextView) view, attributeSet, i, i2);
        }
    }

    private static void m12404a(AutoCompleteTextView autoCompleteTextView, AttributeSet attributeSet, int i, int i2) {
        TypedArray obtainStyledAttributes = autoCompleteTextView.getContext().obtainStyledAttributes(attributeSet, C2162b.AutoCompleteTextView, i, i2);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i3 = 0; i3 < indexCount; i3++) {
            int index = obtainStyledAttributes.getIndex(i3);
            if (index == C2162b.AutoCompleteTextView_android_completionHint) {
                autoCompleteTextView.setCompletionHint(obtainStyledAttributes.getString(index));
            } else if (index == C2162b.AutoCompleteTextView_android_completionThreshold) {
                autoCompleteTextView.setThreshold(obtainStyledAttributes.getInteger(index, 0));
            } else if (index == C2162b.AutoCompleteTextView_android_dropDownAnchor) {
                autoCompleteTextView.setDropDownAnchor(obtainStyledAttributes.getResourceId(index, 0));
            } else if (index == C2162b.AutoCompleteTextView_android_dropDownHeight) {
                autoCompleteTextView.setDropDownHeight(obtainStyledAttributes.getLayoutDimension(index, -2));
            } else if (index == C2162b.AutoCompleteTextView_android_dropDownWidth) {
                autoCompleteTextView.setDropDownWidth(obtainStyledAttributes.getLayoutDimension(index, -2));
            } else if (index == C2162b.AutoCompleteTextView_android_dropDownHorizontalOffset) {
                autoCompleteTextView.setDropDownHorizontalOffset(obtainStyledAttributes.getDimensionPixelSize(index, 0));
            } else if (index == C2162b.AutoCompleteTextView_android_dropDownVerticalOffset) {
                autoCompleteTextView.setDropDownVerticalOffset(obtainStyledAttributes.getDimensionPixelSize(index, 0));
            } else if (index == C2162b.AutoCompleteTextView_android_popupBackground) {
                autoCompleteTextView.setDropDownBackgroundDrawable(obtainStyledAttributes.getDrawable(index));
            }
        }
        obtainStyledAttributes.recycle();
    }

    private static void m12405a(TextView textView, AttributeSet attributeSet, int i, int i2) {
        int index;
        String str = null;
        int i3 = -1;
        int i4 = -1;
        int i5 = 0;
        float f = 0.0f;
        float f2 = 0.0f;
        float f3 = 0.0f;
        TypedArray obtainStyledAttributes = textView.getContext().obtainStyledAttributes(attributeSet, C2162b.TextViewAppearance, i, i2);
        int resourceId = obtainStyledAttributes.getResourceId(C2162b.TextViewAppearance_android_textAppearance, 0);
        obtainStyledAttributes.recycle();
        obtainStyledAttributes = resourceId != 0 ? textView.getContext().obtainStyledAttributes(resourceId, C2162b.TextAppearance) : null;
        if (obtainStyledAttributes != null) {
            resourceId = obtainStyledAttributes.getIndexCount();
            for (int i6 = 0; i6 < resourceId; i6++) {
                index = obtainStyledAttributes.getIndex(i6);
                if (index == C2162b.TextAppearance_android_textColorHighlight) {
                    textView.setHighlightColor(obtainStyledAttributes.getColor(index, 0));
                } else if (index == C2162b.TextAppearance_android_textColor) {
                    textView.setTextColor(obtainStyledAttributes.getColorStateList(index));
                } else if (index == C2162b.TextAppearance_android_textColorHint) {
                    textView.setHintTextColor(obtainStyledAttributes.getColorStateList(index));
                } else if (index == C2162b.TextAppearance_android_textColorLink) {
                    textView.setLinkTextColor(obtainStyledAttributes.getColorStateList(index));
                } else if (index == C2162b.TextAppearance_android_textSize) {
                    textView.setTextSize(0, (float) obtainStyledAttributes.getDimensionPixelSize(index, 0));
                } else if (index == C2162b.TextAppearance_android_typeface) {
                    i3 = obtainStyledAttributes.getInt(index, -1);
                } else if (index == C2162b.TextAppearance_android_fontFamily) {
                    str = obtainStyledAttributes.getString(index);
                } else if (index == C2162b.TextAppearance_tv_fontFamily) {
                    str = obtainStyledAttributes.getString(index);
                } else if (index == C2162b.TextAppearance_android_textStyle) {
                    i4 = obtainStyledAttributes.getInt(index, -1);
                } else if (index == C2162b.TextAppearance_android_textAllCaps) {
                    if (VERSION.SDK_INT >= 14) {
                        textView.setAllCaps(obtainStyledAttributes.getBoolean(index, false));
                    }
                } else if (index == C2162b.TextAppearance_android_shadowColor) {
                    i5 = obtainStyledAttributes.getInt(index, 0);
                } else if (index == C2162b.TextAppearance_android_shadowDx) {
                    f = obtainStyledAttributes.getFloat(index, 0.0f);
                } else if (index == C2162b.TextAppearance_android_shadowDy) {
                    f2 = obtainStyledAttributes.getFloat(index, 0.0f);
                } else if (index == C2162b.TextAppearance_android_shadowRadius) {
                    f3 = obtainStyledAttributes.getFloat(index, 0.0f);
                } else if (index == C2162b.TextAppearance_android_elegantTextHeight) {
                    if (VERSION.SDK_INT >= 21) {
                        textView.setElegantTextHeight(obtainStyledAttributes.getBoolean(index, false));
                    }
                } else if (index == C2162b.TextAppearance_android_letterSpacing) {
                    if (VERSION.SDK_INT >= 21) {
                        textView.setLetterSpacing(obtainStyledAttributes.getFloat(index, 0.0f));
                    }
                } else if (index == C2162b.TextAppearance_android_fontFeatureSettings && VERSION.SDK_INT >= 21) {
                    textView.setFontFeatureSettings(obtainStyledAttributes.getString(index));
                }
            }
            obtainStyledAttributes.recycle();
        }
        obtainStyledAttributes = textView.getContext().obtainStyledAttributes(attributeSet, C2162b.TextView, i, i2);
        resourceId = obtainStyledAttributes.getIndexCount();
        Drawable drawable = null;
        float f4 = f2;
        Object obj = null;
        int i7 = i5;
        Drawable drawable2 = null;
        int i8 = i3;
        Drawable drawable3 = null;
        float f5 = f3;
        Object obj2 = null;
        float f6 = f;
        Drawable drawable4 = null;
        int i9 = i4;
        Drawable drawable5 = null;
        String str2 = str;
        Drawable drawable6 = null;
        for (int i10 = 0; i10 < resourceId; i10++) {
            index = obtainStyledAttributes.getIndex(i10);
            if (index == C2162b.TextView_android_drawableLeft) {
                drawable = obtainStyledAttributes.getDrawable(index);
                obj = 1;
            } else if (index == C2162b.TextView_android_drawableTop) {
                drawable6 = obtainStyledAttributes.getDrawable(index);
                obj = 1;
            } else if (index == C2162b.TextView_android_drawableRight) {
                drawable3 = obtainStyledAttributes.getDrawable(index);
                obj = 1;
            } else if (index == C2162b.TextView_android_drawableBottom) {
                drawable5 = obtainStyledAttributes.getDrawable(index);
                obj = 1;
            } else if (index == C2162b.TextView_android_drawableStart) {
                drawable2 = obtainStyledAttributes.getDrawable(index);
                obj2 = 1;
            } else if (index == C2162b.TextView_android_drawableEnd) {
                drawable4 = obtainStyledAttributes.getDrawable(index);
                obj2 = 1;
            } else if (index == C2162b.TextView_android_drawablePadding) {
                textView.setCompoundDrawablePadding(obtainStyledAttributes.getDimensionPixelSize(index, 0));
            } else if (index == C2162b.TextView_android_maxLines) {
                textView.setMaxLines(obtainStyledAttributes.getInt(index, -1));
            } else if (index == C2162b.TextView_android_maxHeight) {
                textView.setMaxHeight(obtainStyledAttributes.getDimensionPixelSize(index, -1));
            } else if (index == C2162b.TextView_android_lines) {
                textView.setLines(obtainStyledAttributes.getInt(index, -1));
            } else if (index == C2162b.TextView_android_height) {
                textView.setHeight(obtainStyledAttributes.getDimensionPixelSize(index, -1));
            } else if (index == C2162b.TextView_android_minLines) {
                textView.setMinLines(obtainStyledAttributes.getInt(index, -1));
            } else if (index == C2162b.TextView_android_minHeight) {
                textView.setMinHeight(obtainStyledAttributes.getDimensionPixelSize(index, -1));
            } else if (index == C2162b.TextView_android_maxEms) {
                textView.setMaxEms(obtainStyledAttributes.getInt(index, -1));
            } else if (index == C2162b.TextView_android_maxWidth) {
                textView.setMaxWidth(obtainStyledAttributes.getDimensionPixelSize(index, -1));
            } else if (index == C2162b.TextView_android_ems) {
                textView.setEms(obtainStyledAttributes.getInt(index, -1));
            } else if (index == C2162b.TextView_android_width) {
                textView.setWidth(obtainStyledAttributes.getDimensionPixelSize(index, -1));
            } else if (index == C2162b.TextView_android_minEms) {
                textView.setMinEms(obtainStyledAttributes.getInt(index, -1));
            } else if (index == C2162b.TextView_android_minWidth) {
                textView.setMinWidth(obtainStyledAttributes.getDimensionPixelSize(index, -1));
            } else if (index == C2162b.TextView_android_gravity) {
                textView.setGravity(obtainStyledAttributes.getInt(index, -1));
            } else if (index == C2162b.TextView_android_scrollHorizontally) {
                textView.setHorizontallyScrolling(obtainStyledAttributes.getBoolean(index, false));
            } else if (index == C2162b.TextView_android_includeFontPadding) {
                textView.setIncludeFontPadding(obtainStyledAttributes.getBoolean(index, true));
            } else if (index == C2162b.TextView_android_cursorVisible) {
                textView.setCursorVisible(obtainStyledAttributes.getBoolean(index, true));
            } else if (index == C2162b.TextView_android_textScaleX) {
                textView.setTextScaleX(obtainStyledAttributes.getFloat(index, 1.0f));
            } else if (index == C2162b.TextView_android_shadowColor) {
                i7 = obtainStyledAttributes.getInt(index, 0);
            } else if (index == C2162b.TextView_android_shadowDx) {
                f6 = obtainStyledAttributes.getFloat(index, 0.0f);
            } else if (index == C2162b.TextView_android_shadowDy) {
                f4 = obtainStyledAttributes.getFloat(index, 0.0f);
            } else if (index == C2162b.TextView_android_shadowRadius) {
                f5 = obtainStyledAttributes.getFloat(index, 0.0f);
            } else if (index == C2162b.TextView_android_textColorHighlight) {
                textView.setHighlightColor(obtainStyledAttributes.getColor(index, 0));
            } else if (index == C2162b.TextView_android_textColor) {
                textView.setTextColor(obtainStyledAttributes.getColorStateList(index));
            } else if (index == C2162b.TextView_android_textColorHint) {
                textView.setHintTextColor(obtainStyledAttributes.getColorStateList(index));
            } else if (index == C2162b.TextView_android_textColorLink) {
                textView.setLinkTextColor(obtainStyledAttributes.getColorStateList(index));
            } else if (index == C2162b.TextView_android_textSize) {
                textView.setTextSize(0, (float) obtainStyledAttributes.getDimensionPixelSize(index, 0));
            } else if (index == C2162b.TextView_android_typeface) {
                i8 = obtainStyledAttributes.getInt(index, -1);
            } else if (index == C2162b.TextView_android_textStyle) {
                i9 = obtainStyledAttributes.getInt(index, -1);
            } else if (index == C2162b.TextView_android_fontFamily) {
                str2 = obtainStyledAttributes.getString(index);
            } else if (index == C2162b.TextView_tv_fontFamily) {
                str2 = obtainStyledAttributes.getString(index);
            } else if (index == C2162b.TextView_android_textAllCaps) {
                if (VERSION.SDK_INT >= 14) {
                    textView.setAllCaps(obtainStyledAttributes.getBoolean(index, false));
                }
            } else if (index == C2162b.TextView_android_elegantTextHeight) {
                if (VERSION.SDK_INT >= 21) {
                    textView.setElegantTextHeight(obtainStyledAttributes.getBoolean(index, false));
                }
            } else if (index == C2162b.TextView_android_letterSpacing) {
                if (VERSION.SDK_INT >= 21) {
                    textView.setLetterSpacing(obtainStyledAttributes.getFloat(index, 0.0f));
                }
            } else if (index == C2162b.TextView_android_fontFeatureSettings && VERSION.SDK_INT >= 21) {
                textView.setFontFeatureSettings(obtainStyledAttributes.getString(index));
            }
        }
        obtainStyledAttributes.recycle();
        if (i7 != 0) {
            textView.setShadowLayer(f5, f6, f4, i7);
        }
        if (obj != null) {
            Drawable[] compoundDrawables = textView.getCompoundDrawables();
            if (drawable2 != null) {
                compoundDrawables[0] = drawable2;
            } else if (drawable != null) {
                compoundDrawables[0] = drawable;
            }
            if (drawable6 != null) {
                compoundDrawables[1] = drawable6;
            }
            if (drawable4 != null) {
                compoundDrawables[2] = drawable4;
            } else if (drawable3 != null) {
                compoundDrawables[2] = drawable3;
            }
            if (drawable5 != null) {
                compoundDrawables[3] = drawable5;
            }
            textView.setCompoundDrawablesWithIntrinsicBounds(compoundDrawables[0], compoundDrawables[1], compoundDrawables[2], compoundDrawables[3]);
        }
        if (obj2 != null && VERSION.SDK_INT >= 17) {
            Drawable[] compoundDrawablesRelative = textView.getCompoundDrawablesRelative();
            if (drawable2 != null) {
                compoundDrawablesRelative[0] = drawable2;
            }
            if (drawable4 != null) {
                compoundDrawablesRelative[2] = drawable4;
            }
            textView.setCompoundDrawablesRelativeWithIntrinsicBounds(compoundDrawablesRelative[0], compoundDrawablesRelative[1], compoundDrawablesRelative[2], compoundDrawablesRelative[3]);
        }
        Typeface typeface = null;
        if (str2 != null) {
            typeface = C2175c.m12400a(textView.getContext(), str2, i9);
            if (typeface != null) {
                textView.setTypeface(typeface);
            }
        }
        if (typeface != null) {
            switch (i8) {
                case 1:
                    typeface = Typeface.SANS_SERIF;
                    break;
                case 2:
                    typeface = Typeface.SERIF;
                    break;
                case 3:
                    typeface = Typeface.MONOSPACE;
                    break;
            }
            textView.setTypeface(typeface, i9);
        }
        if (textView instanceof AutoCompleteTextView) {
            C2176d.m12404a((AutoCompleteTextView) textView, attributeSet, i, i2);
        }
    }

    public static boolean m12406a(int[] iArr, int i) {
        if (iArr == null) {
            return false;
        }
        for (int i2 : iArr) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }
}
