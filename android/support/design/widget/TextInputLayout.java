package android.support.design.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.DrawableContainer.DrawableContainerState;
import android.graphics.drawable.InsetDrawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.design.C0048a.C0041c;
import android.support.design.C0048a.C0045g;
import android.support.design.C0048a.C0046h;
import android.support.design.C0048a.C0047i;
import android.support.design.widget.C0170v.C0054c;
import android.support.v4.p004c.p005a.C0322i;
import android.support.v4.p010b.C0195a;
import android.support.v4.view.C0124a;
import android.support.v4.view.ag;
import android.support.v4.view.bb;
import android.support.v4.view.p016a.C0426c;
import android.support.v4.widget.Space;
import android.support.v7.widget.C0893m;
import android.support.v7.widget.al;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.AccelerateInterpolator;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

public class TextInputLayout extends LinearLayout {
    private EditText f513a;
    private boolean f514b;
    private CharSequence f515c;
    private Paint f516d;
    private LinearLayout f517e;
    private int f518f;
    private boolean f519g;
    private TextView f520h;
    private int f521i;
    private boolean f522j;
    private CharSequence f523k;
    private boolean f524l;
    private TextView f525m;
    private int f526n;
    private int f527o;
    private int f528p;
    private boolean f529q;
    private ColorStateList f530r;
    private ColorStateList f531s;
    private final C0135d f532t;
    private boolean f533u;
    private C0170v f534v;
    private boolean f535w;

    class C01191 implements TextWatcher {
        final /* synthetic */ TextInputLayout f503a;

        C01191(TextInputLayout textInputLayout) {
            this.f503a = textInputLayout;
        }

        public void afterTextChanged(Editable editable) {
            this.f503a.m868a(true);
            if (this.f503a.f524l) {
                this.f503a.m862a(editable.length());
            }
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    class C01202 extends bb {
        final /* synthetic */ TextInputLayout f504a;

        C01202(TextInputLayout textInputLayout) {
            this.f504a = textInputLayout;
        }

        public void mo98a(View view) {
            view.setVisibility(0);
        }
    }

    class C01224 implements C0054c {
        final /* synthetic */ TextInputLayout f507a;

        C01224(TextInputLayout textInputLayout) {
            this.f507a = textInputLayout;
        }

        public void mo39a(C0170v c0170v) {
            this.f507a.f532t.m921b(c0170v.m1084d());
        }
    }

    static class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR = new C01231();
        CharSequence f508a;

        static class C01231 implements Creator<SavedState> {
            C01231() {
            }

            public SavedState m844a(Parcel parcel) {
                return new SavedState(parcel);
            }

            public SavedState[] m845a(int i) {
                return new SavedState[i];
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return m844a(parcel);
            }

            public /* synthetic */ Object[] newArray(int i) {
                return m845a(i);
            }
        }

        public SavedState(Parcel parcel) {
            super(parcel);
            this.f508a = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "TextInputLayout.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " error=" + this.f508a + "}";
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            TextUtils.writeToParcel(this.f508a, parcel, i);
        }
    }

    private class C0125a extends C0124a {
        final /* synthetic */ TextInputLayout f512a;

        private C0125a(TextInputLayout textInputLayout) {
            this.f512a = textInputLayout;
        }

        public void mo113a(View view, C0426c c0426c) {
            super.mo113a(view, c0426c);
            c0426c.m2191a(TextInputLayout.class.getSimpleName());
            CharSequence i = this.f512a.f532t.m937i();
            if (!TextUtils.isEmpty(i)) {
                c0426c.m2196b(i);
            }
            if (this.f512a.f513a != null) {
                c0426c.m2190a(this.f512a.f513a);
            }
            i = this.f512a.f520h != null ? this.f512a.f520h.getText() : null;
            if (!TextUtils.isEmpty(i)) {
                c0426c.m2198b(true);
                c0426c.m2199c(i);
            }
        }

        public void mo114a(View view, AccessibilityEvent accessibilityEvent) {
            super.mo114a(view, accessibilityEvent);
            accessibilityEvent.setClassName(TextInputLayout.class.getSimpleName());
        }

        public void mo115b(View view, AccessibilityEvent accessibilityEvent) {
            super.mo115b(view, accessibilityEvent);
            CharSequence i = this.f512a.f532t.m937i();
            if (!TextUtils.isEmpty(i)) {
                accessibilityEvent.getText().add(i);
            }
        }
    }

    public TextInputLayout(Context context) {
        this(context, null);
    }

    public TextInputLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TextInputLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.f532t = new C0135d(this);
        C0164u.m1053a(context);
        setOrientation(1);
        setWillNotDraw(false);
        setAddStatesFromChildren(true);
        this.f532t.m918a(C0127a.f537b);
        this.f532t.m925b(new AccelerateInterpolator());
        this.f532t.m930d(8388659);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0047i.TextInputLayout, i, C0046h.Widget_Design_TextInputLayout);
        this.f514b = obtainStyledAttributes.getBoolean(C0047i.TextInputLayout_hintEnabled, true);
        setHint(obtainStyledAttributes.getText(C0047i.TextInputLayout_android_hint));
        this.f533u = obtainStyledAttributes.getBoolean(C0047i.TextInputLayout_hintAnimationEnabled, true);
        if (obtainStyledAttributes.hasValue(C0047i.TextInputLayout_android_textColorHint)) {
            ColorStateList colorStateList = obtainStyledAttributes.getColorStateList(C0047i.TextInputLayout_android_textColorHint);
            this.f531s = colorStateList;
            this.f530r = colorStateList;
        }
        if (obtainStyledAttributes.getResourceId(C0047i.TextInputLayout_hintTextAppearance, -1) != -1) {
            setHintTextAppearance(obtainStyledAttributes.getResourceId(C0047i.TextInputLayout_hintTextAppearance, 0));
        }
        this.f521i = obtainStyledAttributes.getResourceId(C0047i.TextInputLayout_errorTextAppearance, 0);
        boolean z = obtainStyledAttributes.getBoolean(C0047i.TextInputLayout_errorEnabled, false);
        boolean z2 = obtainStyledAttributes.getBoolean(C0047i.TextInputLayout_counterEnabled, false);
        setCounterMaxLength(obtainStyledAttributes.getInt(C0047i.TextInputLayout_counterMaxLength, -1));
        this.f527o = obtainStyledAttributes.getResourceId(C0047i.TextInputLayout_counterTextAppearance, 0);
        this.f528p = obtainStyledAttributes.getResourceId(C0047i.TextInputLayout_counterOverflowTextAppearance, 0);
        obtainStyledAttributes.recycle();
        setErrorEnabled(z);
        setCounterEnabled(z2);
        if (ag.m2535e(this) == 0) {
            ag.m2529c((View) this, 1);
        }
        ag.m2517a((View) this, new C0125a());
    }

    private LayoutParams m859a(ViewGroup.LayoutParams layoutParams) {
        LayoutParams layoutParams2 = layoutParams instanceof LayoutParams ? (LayoutParams) layoutParams : new LayoutParams(layoutParams);
        if (this.f514b) {
            if (this.f516d == null) {
                this.f516d = new Paint();
            }
            this.f516d.setTypeface(this.f532t.m929d());
            this.f516d.setTextSize(this.f532t.m935g());
            layoutParams2.topMargin = (int) (-this.f516d.ascent());
        } else {
            layoutParams2.topMargin = 0;
        }
        return layoutParams2;
    }

    private void m860a() {
        ag.m2513a(this.f517e, ag.m2543k(this.f513a), 0, ag.m2544l(this.f513a), this.f513a.getPaddingBottom());
    }

    private void m861a(float f) {
        if (this.f532t.m933f() != f) {
            if (this.f534v == null) {
                this.f534v = ac.m890a();
                this.f534v.m1081a(C0127a.f536a);
                this.f534v.m1077a(200);
                this.f534v.m1080a(new C01224(this));
            }
            this.f534v.m1076a(this.f532t.m933f(), f);
            this.f534v.m1075a();
        }
    }

    private void m862a(int i) {
        boolean z = this.f529q;
        if (this.f526n == -1) {
            this.f525m.setText(String.valueOf(i));
            this.f529q = false;
        } else {
            this.f529q = i > this.f526n;
            if (z != this.f529q) {
                this.f525m.setTextAppearance(getContext(), this.f529q ? this.f528p : this.f527o);
            }
            this.f525m.setText(getContext().getString(C0045g.character_counter_pattern, new Object[]{Integer.valueOf(i), Integer.valueOf(this.f526n)}));
        }
        if (this.f513a != null && z != this.f529q) {
            m868a(false);
            m872b();
        }
    }

    private static void m863a(Drawable drawable) {
        drawable.clearColorFilter();
        if (VERSION.SDK_INT != 21 && VERSION.SDK_INT != 22) {
            return;
        }
        if (drawable instanceof InsetDrawable) {
            m863a(((InsetDrawable) drawable).getDrawable());
        } else if (drawable instanceof C0322i) {
            m863a(((C0322i) drawable).mo262a());
        } else if (drawable instanceof DrawableContainer) {
            DrawableContainerState drawableContainerState = (DrawableContainerState) ((DrawableContainer) drawable).getConstantState();
            if (drawableContainerState != null) {
                int childCount = drawableContainerState.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    m863a(drawableContainerState.getChild(i));
                }
            }
        }
    }

    private void m866a(TextView textView) {
        if (this.f517e != null) {
            this.f517e.removeView(textView);
            int i = this.f518f - 1;
            this.f518f = i;
            if (i == 0) {
                this.f517e.setVisibility(8);
            }
        }
    }

    private void m867a(TextView textView, int i) {
        if (this.f517e == null) {
            this.f517e = new LinearLayout(getContext());
            this.f517e.setOrientation(0);
            addView(this.f517e, -1, -2);
            this.f517e.addView(new Space(getContext()), new LayoutParams(0, 0, 1.0f));
            if (this.f513a != null) {
                m860a();
            }
        }
        this.f517e.setVisibility(0);
        this.f517e.addView(textView, i);
        this.f518f++;
    }

    private void m868a(boolean z) {
        Object obj = 1;
        Object obj2 = (this.f513a == null || TextUtils.isEmpty(this.f513a.getText())) ? null : 1;
        boolean a = m870a(getDrawableState(), 16842908);
        if (TextUtils.isEmpty(getError())) {
            obj = null;
        }
        if (this.f530r != null) {
            this.f532t.m922b(this.f530r.getDefaultColor());
        }
        if (this.f529q && this.f525m != null) {
            this.f532t.m914a(this.f525m.getCurrentTextColor());
        } else if (a && this.f531s != null) {
            this.f532t.m914a(this.f531s.getDefaultColor());
        } else if (this.f530r != null) {
            this.f532t.m914a(this.f530r.getDefaultColor());
        }
        if (obj2 == null && !a && r1 == null) {
            m876c(z);
        } else {
            m873b(z);
        }
    }

    private static boolean m870a(int[] iArr, int i) {
        for (int i2 : iArr) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }

    private void m872b() {
        m875c();
        Drawable background = this.f513a.getBackground();
        if (background != null) {
            if (al.m5020b(background)) {
                background = background.mutate();
            }
            if (this.f522j && this.f520h != null) {
                background.setColorFilter(C0893m.m5421a(this.f520h.getCurrentTextColor(), Mode.SRC_IN));
            } else if (!this.f529q || this.f525m == null) {
                m863a(background);
                this.f513a.refreshDrawableState();
            } else {
                background.setColorFilter(C0893m.m5421a(this.f525m.getCurrentTextColor(), Mode.SRC_IN));
            }
        }
    }

    private void m873b(boolean z) {
        if (this.f534v != null && this.f534v.m1082b()) {
            this.f534v.m1085e();
        }
        if (z && this.f533u) {
            m861a(1.0f);
        } else {
            this.f532t.m921b(1.0f);
        }
    }

    private void m875c() {
        int i = VERSION.SDK_INT;
        if (i == 21 || i == 22) {
            Drawable background = this.f513a.getBackground();
            if (background != null && !this.f535w) {
                Drawable newDrawable = background.getConstantState().newDrawable();
                if (background instanceof DrawableContainer) {
                    this.f535w = C0138g.m941a((DrawableContainer) background, newDrawable.getConstantState());
                }
                if (!this.f535w) {
                    this.f513a.setBackgroundDrawable(newDrawable);
                    this.f535w = true;
                }
            }
        }
    }

    private void m876c(boolean z) {
        if (this.f534v != null && this.f534v.m1082b()) {
            this.f534v.m1085e();
        }
        if (z && this.f533u) {
            m861a(0.0f);
        } else {
            this.f532t.m921b(0.0f);
        }
    }

    private void setEditText(EditText editText) {
        if (this.f513a != null) {
            throw new IllegalArgumentException("We already have an EditText, can only have one");
        }
        if (!(editText instanceof C0163t)) {
            Log.i("TextInputLayout", "EditText added is not a TextInputEditText. Please switch to using that class instead.");
        }
        this.f513a = editText;
        this.f532t.m928c(this.f513a.getTypeface());
        this.f532t.m913a(this.f513a.getTextSize());
        int gravity = this.f513a.getGravity();
        this.f532t.m930d((8388615 & gravity) | 48);
        this.f532t.m927c(gravity);
        this.f513a.addTextChangedListener(new C01191(this));
        if (this.f530r == null) {
            this.f530r = this.f513a.getHintTextColors();
        }
        if (this.f514b && TextUtils.isEmpty(this.f515c)) {
            setHint(this.f513a.getHint());
            this.f513a.setHint(null);
        }
        if (this.f525m != null) {
            m862a(this.f513a.getText().length());
        }
        if (this.f517e != null) {
            m860a();
        }
        m868a(false);
    }

    private void setHintInternal(CharSequence charSequence) {
        this.f515c = charSequence;
        this.f532t.m919a(charSequence);
    }

    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (view instanceof EditText) {
            setEditText((EditText) view);
            super.addView(view, 0, m859a(layoutParams));
            return;
        }
        super.addView(view, i, layoutParams);
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.f514b) {
            this.f532t.m916a(canvas);
        }
    }

    public int getCounterMaxLength() {
        return this.f526n;
    }

    public EditText getEditText() {
        return this.f513a;
    }

    public CharSequence getError() {
        return this.f519g ? this.f523k : null;
    }

    public CharSequence getHint() {
        return this.f514b ? this.f515c : null;
    }

    public Typeface getTypeface() {
        return this.f532t.m929d();
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.f514b && this.f513a != null) {
            int left = this.f513a.getLeft() + this.f513a.getCompoundPaddingLeft();
            int right = this.f513a.getRight() - this.f513a.getCompoundPaddingRight();
            this.f532t.m915a(left, this.f513a.getTop() + this.f513a.getCompoundPaddingTop(), right, this.f513a.getBottom() - this.f513a.getCompoundPaddingBottom());
            this.f532t.m923b(left, getPaddingTop(), right, (i4 - i2) - getPaddingBottom());
            this.f532t.m936h();
        }
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.getSuperState());
            setError(savedState.f508a);
            requestLayout();
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    public Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        if (this.f522j) {
            savedState.f508a = getError();
        }
        return savedState;
    }

    public void refreshDrawableState() {
        super.refreshDrawableState();
        m868a(ag.m2503A(this));
    }

    public void setCounterEnabled(boolean z) {
        if (this.f524l != z) {
            if (z) {
                this.f525m = new TextView(getContext());
                this.f525m.setMaxLines(1);
                try {
                    this.f525m.setTextAppearance(getContext(), this.f527o);
                } catch (Exception e) {
                    this.f525m.setTextAppearance(getContext(), C0046h.TextAppearance_AppCompat_Caption);
                    this.f525m.setTextColor(C0195a.m1227c(getContext(), C0041c.design_textinput_error_color_light));
                }
                m867a(this.f525m, -1);
                if (this.f513a == null) {
                    m862a(0);
                } else {
                    m862a(this.f513a.getText().length());
                }
            } else {
                m866a(this.f525m);
                this.f525m = null;
            }
            this.f524l = z;
        }
    }

    public void setCounterMaxLength(int i) {
        if (this.f526n != i) {
            if (i > 0) {
                this.f526n = i;
            } else {
                this.f526n = -1;
            }
            if (this.f524l) {
                m862a(this.f513a == null ? 0 : this.f513a.getText().length());
            }
        }
    }

    public void setError(final CharSequence charSequence) {
        if (!TextUtils.equals(this.f523k, charSequence)) {
            this.f523k = charSequence;
            if (!this.f519g) {
                if (!TextUtils.isEmpty(charSequence)) {
                    setErrorEnabled(true);
                } else {
                    return;
                }
            }
            boolean A = ag.m2503A(this);
            this.f522j = !TextUtils.isEmpty(charSequence);
            ag.m2549q(this.f520h).m2734b();
            if (this.f522j) {
                this.f520h.setText(charSequence);
                this.f520h.setVisibility(0);
                if (A) {
                    if (ag.m2537f(this.f520h) == 1.0f) {
                        ag.m2528c(this.f520h, 0.0f);
                    }
                    ag.m2549q(this.f520h).m2727a(1.0f).m2728a(200).m2731a(C0127a.f539d).m2729a(new C01202(this)).m2736c();
                }
            } else if (this.f520h.getVisibility() == 0) {
                if (A) {
                    ag.m2549q(this.f520h).m2727a(0.0f).m2728a(200).m2731a(C0127a.f538c).m2729a(new bb(this) {
                        final /* synthetic */ TextInputLayout f506b;

                        public void mo99b(View view) {
                            this.f506b.f520h.setText(charSequence);
                            view.setVisibility(4);
                        }
                    }).m2736c();
                } else {
                    this.f520h.setVisibility(4);
                }
            }
            m872b();
            m868a(true);
        }
    }

    public void setErrorEnabled(boolean z) {
        if (this.f519g != z) {
            if (this.f520h != null) {
                ag.m2549q(this.f520h).m2734b();
            }
            if (z) {
                this.f520h = new TextView(getContext());
                try {
                    this.f520h.setTextAppearance(getContext(), this.f521i);
                } catch (Exception e) {
                    this.f520h.setTextAppearance(getContext(), C0046h.TextAppearance_AppCompat_Caption);
                    this.f520h.setTextColor(C0195a.m1227c(getContext(), C0041c.design_textinput_error_color_light));
                }
                this.f520h.setVisibility(4);
                ag.m2534d(this.f520h, 1);
                m867a(this.f520h, 0);
            } else {
                this.f522j = false;
                m872b();
                m866a(this.f520h);
                this.f520h = null;
            }
            this.f519g = z;
        }
    }

    public void setHint(CharSequence charSequence) {
        if (this.f514b) {
            setHintInternal(charSequence);
            sendAccessibilityEvent(2048);
        }
    }

    public void setHintAnimationEnabled(boolean z) {
        this.f533u = z;
    }

    public void setHintEnabled(boolean z) {
        if (z != this.f514b) {
            this.f514b = z;
            CharSequence hint = this.f513a.getHint();
            if (!this.f514b) {
                if (!TextUtils.isEmpty(this.f515c) && TextUtils.isEmpty(hint)) {
                    this.f513a.setHint(this.f515c);
                }
                setHintInternal(null);
            } else if (!TextUtils.isEmpty(hint)) {
                if (TextUtils.isEmpty(this.f515c)) {
                    setHint(hint);
                }
                this.f513a.setHint(null);
            }
            if (this.f513a != null) {
                this.f513a.setLayoutParams(m859a(this.f513a.getLayoutParams()));
            }
        }
    }

    public void setHintTextAppearance(int i) {
        this.f532t.m932e(i);
        this.f531s = ColorStateList.valueOf(this.f532t.m938j());
        if (this.f513a != null) {
            m868a(false);
            this.f513a.setLayoutParams(m859a(this.f513a.getLayoutParams()));
            this.f513a.requestLayout();
        }
    }

    public void setTypeface(Typeface typeface) {
        this.f532t.m928c(typeface);
    }
}
