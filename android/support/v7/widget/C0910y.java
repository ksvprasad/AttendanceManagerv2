package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.p010b.C0195a;
import android.support.v4.view.ad;
import android.support.v4.view.ag;
import android.support.v7.p019b.C0694a.C0683a;
import android.support.v7.p019b.C0694a.C0690h;
import android.support.v7.p019b.C0694a.C0693k;
import android.support.v7.view.C0706d;
import android.support.v7.widget.ap.C0715b;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.ThemedSpinnerAdapter;

public class C0910y extends Spinner implements ad {
    private static final boolean f2769a = (VERSION.SDK_INT >= 23);
    private static final boolean f2770b = (VERSION.SDK_INT >= 16);
    private static final int[] f2771c = new int[]{16843505};
    private C0893m f2772d;
    private C0883h f2773e;
    private Context f2774f;
    private C0715b f2775g;
    private SpinnerAdapter f2776h;
    private boolean f2777i;
    private C0909b f2778j;
    private int f2779k;
    private final Rect f2780l;

    private static class C0905a implements ListAdapter, SpinnerAdapter {
        private SpinnerAdapter f2758a;
        private ListAdapter f2759b;

        public C0905a(SpinnerAdapter spinnerAdapter, Theme theme) {
            this.f2758a = spinnerAdapter;
            if (spinnerAdapter instanceof ListAdapter) {
                this.f2759b = (ListAdapter) spinnerAdapter;
            }
            if (theme == null) {
                return;
            }
            if (C0910y.f2769a && (spinnerAdapter instanceof ThemedSpinnerAdapter)) {
                ThemedSpinnerAdapter themedSpinnerAdapter = (ThemedSpinnerAdapter) spinnerAdapter;
                if (themedSpinnerAdapter.getDropDownViewTheme() != theme) {
                    themedSpinnerAdapter.setDropDownViewTheme(theme);
                }
            } else if (spinnerAdapter instanceof bd) {
                bd bdVar = (bd) spinnerAdapter;
                if (bdVar.m5204a() == null) {
                    bdVar.m5205a(theme);
                }
            }
        }

        public boolean areAllItemsEnabled() {
            ListAdapter listAdapter = this.f2759b;
            return listAdapter != null ? listAdapter.areAllItemsEnabled() : true;
        }

        public int getCount() {
            return this.f2758a == null ? 0 : this.f2758a.getCount();
        }

        public View getDropDownView(int i, View view, ViewGroup viewGroup) {
            return this.f2758a == null ? null : this.f2758a.getDropDownView(i, view, viewGroup);
        }

        public Object getItem(int i) {
            return this.f2758a == null ? null : this.f2758a.getItem(i);
        }

        public long getItemId(int i) {
            return this.f2758a == null ? -1 : this.f2758a.getItemId(i);
        }

        public int getItemViewType(int i) {
            return 0;
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            return getDropDownView(i, view, viewGroup);
        }

        public int getViewTypeCount() {
            return 1;
        }

        public boolean hasStableIds() {
            return this.f2758a != null && this.f2758a.hasStableIds();
        }

        public boolean isEmpty() {
            return getCount() == 0;
        }

        public boolean isEnabled(int i) {
            ListAdapter listAdapter = this.f2759b;
            return listAdapter != null ? listAdapter.isEnabled(i) : true;
        }

        public void registerDataSetObserver(DataSetObserver dataSetObserver) {
            if (this.f2758a != null) {
                this.f2758a.registerDataSetObserver(dataSetObserver);
            }
        }

        public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
            if (this.f2758a != null) {
                this.f2758a.unregisterDataSetObserver(dataSetObserver);
            }
        }
    }

    private class C0909b extends ap {
        final /* synthetic */ C0910y f2765a;
        private CharSequence f2766c;
        private ListAdapter f2767d;
        private final Rect f2768e = new Rect();

        class C09072 implements OnGlobalLayoutListener {
            final /* synthetic */ C0909b f2762a;

            C09072(C0909b c0909b) {
                this.f2762a = c0909b;
            }

            public void onGlobalLayout() {
                if (this.f2762a.m5467b(this.f2762a.f2765a)) {
                    this.f2762a.mo873b();
                    super.mo874c();
                    return;
                }
                this.f2762a.m5067i();
            }
        }

        public C0909b(final C0910y c0910y, Context context, AttributeSet attributeSet, int i) {
            this.f2765a = c0910y;
            super(context, attributeSet, i);
            m5049a((View) c0910y);
            m5053a(true);
            m5047a(0);
            m5050a(new OnItemClickListener(this) {
                final /* synthetic */ C0909b f2761b;

                public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                    this.f2761b.f2765a.setSelection(i);
                    if (this.f2761b.f2765a.getOnItemClickListener() != null) {
                        this.f2761b.f2765a.performItemClick(view, i, this.f2761b.f2767d.getItemId(i));
                    }
                    this.f2761b.m5067i();
                }
            });
        }

        private boolean m5467b(View view) {
            return ag.m2505C(view) && view.getGlobalVisibleRect(this.f2768e);
        }

        public CharSequence mo871a() {
            return this.f2766c;
        }

        public void mo872a(ListAdapter listAdapter) {
            super.mo872a(listAdapter);
            this.f2767d = listAdapter;
        }

        public void m5470a(CharSequence charSequence) {
            this.f2766c = charSequence;
        }

        void mo873b() {
            int i;
            Drawable d = m5057d();
            if (d != null) {
                d.getPadding(this.f2765a.f2780l);
                i = bl.m5302a(this.f2765a) ? this.f2765a.f2780l.right : -this.f2765a.f2780l.left;
            } else {
                Rect b = this.f2765a.f2780l;
                this.f2765a.f2780l.right = 0;
                b.left = 0;
                i = 0;
            }
            int paddingLeft = this.f2765a.getPaddingLeft();
            int paddingRight = this.f2765a.getPaddingRight();
            int width = this.f2765a.getWidth();
            if (this.f2765a.f2779k == -2) {
                int a = this.f2765a.m5474a((SpinnerAdapter) this.f2767d, m5057d());
                int i2 = (this.f2765a.getContext().getResources().getDisplayMetrics().widthPixels - this.f2765a.f2780l.left) - this.f2765a.f2780l.right;
                if (a <= i2) {
                    i2 = a;
                }
                m5062f(Math.max(i2, (width - paddingLeft) - paddingRight));
            } else if (this.f2765a.f2779k == -1) {
                m5062f((width - paddingLeft) - paddingRight);
            } else {
                m5062f(this.f2765a.f2779k);
            }
            m5054b(bl.m5302a(this.f2765a) ? ((width - paddingRight) - m5065h()) + i : i + paddingLeft);
        }

        public void mo874c() {
            boolean k = m5069k();
            mo873b();
            m5064g(2);
            super.mo874c();
            m5071m().setChoiceMode(1);
            m5066h(this.f2765a.getSelectedItemPosition());
            if (!k) {
                ViewTreeObserver viewTreeObserver = this.f2765a.getViewTreeObserver();
                if (viewTreeObserver != null) {
                    final OnGlobalLayoutListener c09072 = new C09072(this);
                    viewTreeObserver.addOnGlobalLayoutListener(c09072);
                    m5052a(new OnDismissListener(this) {
                        final /* synthetic */ C0909b f2764b;

                        public void onDismiss() {
                            ViewTreeObserver viewTreeObserver = this.f2764b.f2765a.getViewTreeObserver();
                            if (viewTreeObserver != null) {
                                viewTreeObserver.removeGlobalOnLayoutListener(c09072);
                            }
                        }
                    });
                }
            }
        }
    }

    public C0910y(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0683a.spinnerStyle);
    }

    public C0910y(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, -1);
    }

    public C0910y(Context context, AttributeSet attributeSet, int i, int i2) {
        this(context, attributeSet, i, i2, null);
    }

    public C0910y(Context context, AttributeSet attributeSet, int i, int i2, Theme theme) {
        TypedArray obtainStyledAttributes;
        Throwable e;
        final C0909b c0909b;
        bh a;
        CharSequence[] e2;
        SpinnerAdapter arrayAdapter;
        super(context, attributeSet, i);
        this.f2780l = new Rect();
        bh a2 = bh.m5210a(context, attributeSet, C0693k.Spinner, i, 0);
        this.f2772d = C0893m.m5425a();
        this.f2773e = new C0883h(this, this.f2772d);
        if (theme != null) {
            this.f2774f = new C0706d(context, theme);
        } else {
            int g = a2.m5226g(C0693k.Spinner_popupTheme, 0);
            if (g != 0) {
                this.f2774f = new C0706d(context, g);
            } else {
                this.f2774f = !f2769a ? context : null;
            }
        }
        if (this.f2774f != null) {
            if (i2 == -1) {
                if (VERSION.SDK_INT >= 11) {
                    try {
                        obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f2771c, i, 0);
                        try {
                            if (obtainStyledAttributes.hasValue(0)) {
                                i2 = obtainStyledAttributes.getInt(0, 0);
                            }
                            if (obtainStyledAttributes != null) {
                                obtainStyledAttributes.recycle();
                            }
                        } catch (Exception e3) {
                            e = e3;
                            try {
                                Log.i("AppCompatSpinner", "Could not read android:spinnerMode", e);
                                if (obtainStyledAttributes != null) {
                                    obtainStyledAttributes.recycle();
                                }
                                if (i2 == 1) {
                                    c0909b = new C0909b(this, this.f2774f, attributeSet, i);
                                    a = bh.m5210a(this.f2774f, attributeSet, C0693k.Spinner, i, 0);
                                    this.f2779k = a.m5224f(C0693k.Spinner_android_dropDownWidth, -2);
                                    c0909b.m5048a(a.m5213a(C0693k.Spinner_android_popupBackground));
                                    c0909b.m5470a(a2.m5221d(C0693k.Spinner_android_prompt));
                                    a.m5214a();
                                    this.f2778j = c0909b;
                                    this.f2775g = new C0715b(this, this) {
                                        final /* synthetic */ C0910y f2757b;

                                        public ap mo620a() {
                                            return c0909b;
                                        }

                                        public boolean mo621b() {
                                            if (!this.f2757b.f2778j.m5069k()) {
                                                this.f2757b.f2778j.mo874c();
                                            }
                                            return true;
                                        }
                                    };
                                }
                                e2 = a2.m5223e(C0693k.Spinner_android_entries);
                                if (e2 != null) {
                                    arrayAdapter = new ArrayAdapter(context, 17367048, e2);
                                    arrayAdapter.setDropDownViewResource(C0690h.support_simple_spinner_dropdown_item);
                                    setAdapter(arrayAdapter);
                                }
                                a2.m5214a();
                                this.f2777i = true;
                                if (this.f2776h != null) {
                                    setAdapter(this.f2776h);
                                    this.f2776h = null;
                                }
                                this.f2773e.m5401a(attributeSet, i);
                            } catch (Throwable th) {
                                e = th;
                                if (obtainStyledAttributes != null) {
                                    obtainStyledAttributes.recycle();
                                }
                                throw e;
                            }
                        }
                    } catch (Exception e4) {
                        e = e4;
                        obtainStyledAttributes = null;
                        Log.i("AppCompatSpinner", "Could not read android:spinnerMode", e);
                        if (obtainStyledAttributes != null) {
                            obtainStyledAttributes.recycle();
                        }
                        if (i2 == 1) {
                            c0909b = new C0909b(this, this.f2774f, attributeSet, i);
                            a = bh.m5210a(this.f2774f, attributeSet, C0693k.Spinner, i, 0);
                            this.f2779k = a.m5224f(C0693k.Spinner_android_dropDownWidth, -2);
                            c0909b.m5048a(a.m5213a(C0693k.Spinner_android_popupBackground));
                            c0909b.m5470a(a2.m5221d(C0693k.Spinner_android_prompt));
                            a.m5214a();
                            this.f2778j = c0909b;
                            this.f2775g = /* anonymous class already generated */;
                        }
                        e2 = a2.m5223e(C0693k.Spinner_android_entries);
                        if (e2 != null) {
                            arrayAdapter = new ArrayAdapter(context, 17367048, e2);
                            arrayAdapter.setDropDownViewResource(C0690h.support_simple_spinner_dropdown_item);
                            setAdapter(arrayAdapter);
                        }
                        a2.m5214a();
                        this.f2777i = true;
                        if (this.f2776h != null) {
                            setAdapter(this.f2776h);
                            this.f2776h = null;
                        }
                        this.f2773e.m5401a(attributeSet, i);
                    } catch (Throwable th2) {
                        e = th2;
                        obtainStyledAttributes = null;
                        if (obtainStyledAttributes != null) {
                            obtainStyledAttributes.recycle();
                        }
                        throw e;
                    }
                }
                i2 = 1;
            }
            if (i2 == 1) {
                c0909b = new C0909b(this, this.f2774f, attributeSet, i);
                a = bh.m5210a(this.f2774f, attributeSet, C0693k.Spinner, i, 0);
                this.f2779k = a.m5224f(C0693k.Spinner_android_dropDownWidth, -2);
                c0909b.m5048a(a.m5213a(C0693k.Spinner_android_popupBackground));
                c0909b.m5470a(a2.m5221d(C0693k.Spinner_android_prompt));
                a.m5214a();
                this.f2778j = c0909b;
                this.f2775g = /* anonymous class already generated */;
            }
        }
        e2 = a2.m5223e(C0693k.Spinner_android_entries);
        if (e2 != null) {
            arrayAdapter = new ArrayAdapter(context, 17367048, e2);
            arrayAdapter.setDropDownViewResource(C0690h.support_simple_spinner_dropdown_item);
            setAdapter(arrayAdapter);
        }
        a2.m5214a();
        this.f2777i = true;
        if (this.f2776h != null) {
            setAdapter(this.f2776h);
            this.f2776h = null;
        }
        this.f2773e.m5401a(attributeSet, i);
    }

    private int m5474a(SpinnerAdapter spinnerAdapter, Drawable drawable) {
        if (spinnerAdapter == null) {
            return 0;
        }
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
        int makeMeasureSpec2 = MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
        int max = Math.max(0, getSelectedItemPosition());
        int min = Math.min(spinnerAdapter.getCount(), max + 15);
        int max2 = Math.max(0, max - (15 - (min - max)));
        View view = null;
        int i = 0;
        max = 0;
        while (max2 < min) {
            View view2;
            int itemViewType = spinnerAdapter.getItemViewType(max2);
            if (itemViewType != max) {
                view2 = null;
            } else {
                itemViewType = max;
                view2 = view;
            }
            view = spinnerAdapter.getView(max2, view2, this);
            if (view.getLayoutParams() == null) {
                view.setLayoutParams(new LayoutParams(-2, -2));
            }
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            i = Math.max(i, view.getMeasuredWidth());
            max2++;
            max = itemViewType;
        }
        if (drawable == null) {
            return i;
        }
        drawable.getPadding(this.f2780l);
        return (this.f2780l.left + this.f2780l.right) + i;
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f2773e != null) {
            this.f2773e.m5404c();
        }
    }

    public int getDropDownHorizontalOffset() {
        return this.f2778j != null ? this.f2778j.m5061f() : f2770b ? super.getDropDownHorizontalOffset() : 0;
    }

    public int getDropDownVerticalOffset() {
        return this.f2778j != null ? this.f2778j.m5063g() : f2770b ? super.getDropDownVerticalOffset() : 0;
    }

    public int getDropDownWidth() {
        return this.f2778j != null ? this.f2779k : f2770b ? super.getDropDownWidth() : 0;
    }

    public Drawable getPopupBackground() {
        return this.f2778j != null ? this.f2778j.m5057d() : f2770b ? super.getPopupBackground() : null;
    }

    public Context getPopupContext() {
        return this.f2778j != null ? this.f2774f : f2769a ? super.getPopupContext() : null;
    }

    public CharSequence getPrompt() {
        return this.f2778j != null ? this.f2778j.mo871a() : super.getPrompt();
    }

    public ColorStateList getSupportBackgroundTintList() {
        return this.f2773e != null ? this.f2773e.m5396a() : null;
    }

    public Mode getSupportBackgroundTintMode() {
        return this.f2773e != null ? this.f2773e.m5402b() : null;
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f2778j != null && this.f2778j.m5069k()) {
            this.f2778j.m5067i();
        }
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.f2778j != null && MeasureSpec.getMode(i) == Integer.MIN_VALUE) {
            setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), m5474a(getAdapter(), getBackground())), MeasureSpec.getSize(i)), getMeasuredHeight());
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return (this.f2775g == null || !this.f2775g.onTouch(this, motionEvent)) ? super.onTouchEvent(motionEvent) : true;
    }

    public boolean performClick() {
        if (this.f2778j == null) {
            return super.performClick();
        }
        if (!this.f2778j.m5069k()) {
            this.f2778j.mo874c();
        }
        return true;
    }

    public void setAdapter(SpinnerAdapter spinnerAdapter) {
        if (this.f2777i) {
            super.setAdapter(spinnerAdapter);
            if (this.f2778j != null) {
                this.f2778j.mo872a(new C0905a(spinnerAdapter, (this.f2774f == null ? getContext() : this.f2774f).getTheme()));
                return;
            }
            return;
        }
        this.f2776h = spinnerAdapter;
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.f2773e != null) {
            this.f2773e.m5400a(drawable);
        }
    }

    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        if (this.f2773e != null) {
            this.f2773e.m5397a(i);
        }
    }

    public void setDropDownHorizontalOffset(int i) {
        if (this.f2778j != null) {
            this.f2778j.m5054b(i);
        } else if (f2770b) {
            super.setDropDownHorizontalOffset(i);
        }
    }

    public void setDropDownVerticalOffset(int i) {
        if (this.f2778j != null) {
            this.f2778j.m5056c(i);
        } else if (f2770b) {
            super.setDropDownVerticalOffset(i);
        }
    }

    public void setDropDownWidth(int i) {
        if (this.f2778j != null) {
            this.f2779k = i;
        } else if (f2770b) {
            super.setDropDownWidth(i);
        }
    }

    public void setPopupBackgroundDrawable(Drawable drawable) {
        if (this.f2778j != null) {
            this.f2778j.m5048a(drawable);
        } else if (f2770b) {
            super.setPopupBackgroundDrawable(drawable);
        }
    }

    public void setPopupBackgroundResource(int i) {
        setPopupBackgroundDrawable(C0195a.m1224a(getPopupContext(), i));
    }

    public void setPrompt(CharSequence charSequence) {
        if (this.f2778j != null) {
            this.f2778j.m5470a(charSequence);
        } else {
            super.setPrompt(charSequence);
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (this.f2773e != null) {
            this.f2773e.m5398a(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(Mode mode) {
        if (this.f2773e != null) {
            this.f2773e.m5399a(mode);
        }
    }
}
