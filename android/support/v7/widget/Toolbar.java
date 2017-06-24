package android.support.v7.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.view.C0507e;
import android.support.v4.view.C0528n;
import android.support.v4.view.C0535p;
import android.support.v4.view.C0543s;
import android.support.v4.view.ag;
import android.support.v7.p018a.C0614a.C0611a;
import android.support.v7.p019b.C0694a.C0683a;
import android.support.v7.p019b.C0694a.C0693k;
import android.support.v7.view.C0705c;
import android.support.v7.view.C0712g;
import android.support.v7.view.menu.C0721l;
import android.support.v7.view.menu.C0721l.C0654a;
import android.support.v7.view.menu.C0727f;
import android.support.v7.view.menu.C0727f.C0638a;
import android.support.v7.view.menu.C0730h;
import android.support.v7.view.menu.C0742p;
import android.support.v7.widget.ActionMenuView.C0755e;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public class Toolbar extends ViewGroup {
    private boolean f2311A;
    private final ArrayList<View> f2312B;
    private final ArrayList<View> f2313C;
    private final int[] f2314D;
    private C0665c f2315E;
    private final C0755e f2316F;
    private bi f2317G;
    private C0873d f2318H;
    private C0818a f2319I;
    private C0654a f2320J;
    private C0638a f2321K;
    private boolean f2322L;
    private final Runnable f2323M;
    private final C0893m f2324N;
    View f2325a;
    private ActionMenuView f2326b;
    private TextView f2327c;
    private TextView f2328d;
    private ImageButton f2329e;
    private ImageView f2330f;
    private Drawable f2331g;
    private CharSequence f2332h;
    private ImageButton f2333i;
    private Context f2334j;
    private int f2335k;
    private int f2336l;
    private int f2337m;
    private int f2338n;
    private int f2339o;
    private int f2340p;
    private int f2341q;
    private int f2342r;
    private int f2343s;
    private final ax f2344t;
    private int f2345u;
    private CharSequence f2346v;
    private CharSequence f2347w;
    private int f2348x;
    private int f2349y;
    private boolean f2350z;

    public interface C0665c {
        boolean mo576a(MenuItem menuItem);
    }

    class C08141 implements C0755e {
        final /* synthetic */ Toolbar f2302a;

        C08141(Toolbar toolbar) {
            this.f2302a = toolbar;
        }

        public boolean mo771a(MenuItem menuItem) {
            return this.f2302a.f2315E != null ? this.f2302a.f2315E.mo576a(menuItem) : false;
        }
    }

    class C08152 implements Runnable {
        final /* synthetic */ Toolbar f2303a;

        C08152(Toolbar toolbar) {
            this.f2303a = toolbar;
        }

        public void run() {
            this.f2303a.m4818d();
        }
    }

    class C08163 implements OnClickListener {
        final /* synthetic */ Toolbar f2304a;

        C08163(Toolbar toolbar) {
            this.f2304a = toolbar;
        }

        public void onClick(View view) {
            this.f2304a.m4822h();
        }
    }

    public static class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR = new C08171();
        int f2305a;
        boolean f2306b;

        static class C08171 implements Creator<SavedState> {
            C08171() {
            }

            public SavedState m4773a(Parcel parcel) {
                return new SavedState(parcel);
            }

            public SavedState[] m4774a(int i) {
                return new SavedState[i];
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return m4773a(parcel);
            }

            public /* synthetic */ Object[] newArray(int i) {
                return m4774a(i);
            }
        }

        public SavedState(Parcel parcel) {
            super(parcel);
            this.f2305a = parcel.readInt();
            this.f2306b = parcel.readInt() != 0;
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f2305a);
            parcel.writeInt(this.f2306b ? 1 : 0);
        }
    }

    private class C0818a implements C0721l {
        C0727f f2307a;
        C0730h f2308b;
        final /* synthetic */ Toolbar f2309c;

        private C0818a(Toolbar toolbar) {
            this.f2309c = toolbar;
        }

        public void mo636a(Context context, C0727f c0727f) {
            if (!(this.f2307a == null || this.f2308b == null)) {
                this.f2307a.mo663d(this.f2308b);
            }
            this.f2307a = c0727f;
        }

        public void mo637a(C0727f c0727f, boolean z) {
        }

        public boolean mo638a(C0727f c0727f, C0730h c0730h) {
            this.f2309c.m4805p();
            if (this.f2309c.f2333i.getParent() != this.f2309c) {
                this.f2309c.addView(this.f2309c.f2333i);
            }
            this.f2309c.f2325a = c0730h.getActionView();
            this.f2308b = c0730h;
            if (this.f2309c.f2325a.getParent() != this.f2309c) {
                LayoutParams i = this.f2309c.m4823i();
                i.a = 8388611 | (this.f2309c.f2338n & 112);
                i.f2310b = 2;
                this.f2309c.f2325a.setLayoutParams(i);
                this.f2309c.addView(this.f2309c.f2325a);
            }
            this.f2309c.m4824j();
            this.f2309c.requestLayout();
            c0730h.m3873e(true);
            if (this.f2309c.f2325a instanceof C0705c) {
                ((C0705c) this.f2309c.f2325a).mo648a();
            }
            return true;
        }

        public boolean mo639a(C0742p c0742p) {
            return false;
        }

        public void mo640b(boolean z) {
            Object obj = null;
            if (this.f2308b != null) {
                if (this.f2307a != null) {
                    int size = this.f2307a.size();
                    for (int i = 0; i < size; i++) {
                        if (this.f2307a.getItem(i) == this.f2308b) {
                            obj = 1;
                            break;
                        }
                    }
                }
                if (obj == null) {
                    mo642b(this.f2307a, this.f2308b);
                }
            }
        }

        public boolean mo641b() {
            return false;
        }

        public boolean mo642b(C0727f c0727f, C0730h c0730h) {
            if (this.f2309c.f2325a instanceof C0705c) {
                ((C0705c) this.f2309c.f2325a).mo649b();
            }
            this.f2309c.removeView(this.f2309c.f2325a);
            this.f2309c.removeView(this.f2309c.f2333i);
            this.f2309c.f2325a = null;
            this.f2309c.m4825k();
            this.f2308b = null;
            this.f2309c.requestLayout();
            c0730h.m3873e(false);
            return true;
        }
    }

    public static class C0819b extends C0611a {
        int f2310b;

        public C0819b(int i, int i2) {
            super(i, i2);
            this.f2310b = 0;
            this.a = 8388627;
        }

        public C0819b(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f2310b = 0;
        }

        public C0819b(C0611a c0611a) {
            super(c0611a);
            this.f2310b = 0;
        }

        public C0819b(C0819b c0819b) {
            super((C0611a) c0819b);
            this.f2310b = 0;
            this.f2310b = c0819b.f2310b;
        }

        public C0819b(LayoutParams layoutParams) {
            super(layoutParams);
            this.f2310b = 0;
        }

        public C0819b(MarginLayoutParams marginLayoutParams) {
            super((LayoutParams) marginLayoutParams);
            this.f2310b = 0;
            m4782a(marginLayoutParams);
        }

        void m4782a(MarginLayoutParams marginLayoutParams) {
            this.leftMargin = marginLayoutParams.leftMargin;
            this.topMargin = marginLayoutParams.topMargin;
            this.rightMargin = marginLayoutParams.rightMargin;
            this.bottomMargin = marginLayoutParams.bottomMargin;
        }
    }

    public Toolbar(Context context) {
        this(context, null);
    }

    public Toolbar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0683a.toolbarStyle);
    }

    public Toolbar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2344t = new ax();
        this.f2345u = 8388627;
        this.f2312B = new ArrayList();
        this.f2313C = new ArrayList();
        this.f2314D = new int[2];
        this.f2316F = new C08141(this);
        this.f2323M = new C08152(this);
        bh a = bh.m5210a(getContext(), attributeSet, C0693k.Toolbar, i, 0);
        this.f2336l = a.m5226g(C0693k.Toolbar_titleTextAppearance, 0);
        this.f2337m = a.m5226g(C0693k.Toolbar_subtitleTextAppearance, 0);
        this.f2345u = a.m5218c(C0693k.Toolbar_android_gravity, this.f2345u);
        this.f2338n = 48;
        int d = a.m5220d(C0693k.Toolbar_titleMargins, 0);
        this.f2343s = d;
        this.f2342r = d;
        this.f2341q = d;
        this.f2340p = d;
        d = a.m5220d(C0693k.Toolbar_titleMarginStart, -1);
        if (d >= 0) {
            this.f2340p = d;
        }
        d = a.m5220d(C0693k.Toolbar_titleMarginEnd, -1);
        if (d >= 0) {
            this.f2341q = d;
        }
        d = a.m5220d(C0693k.Toolbar_titleMarginTop, -1);
        if (d >= 0) {
            this.f2342r = d;
        }
        d = a.m5220d(C0693k.Toolbar_titleMarginBottom, -1);
        if (d >= 0) {
            this.f2343s = d;
        }
        this.f2339o = a.m5222e(C0693k.Toolbar_maxButtonHeight, -1);
        d = a.m5220d(C0693k.Toolbar_contentInsetStart, Integer.MIN_VALUE);
        int d2 = a.m5220d(C0693k.Toolbar_contentInsetEnd, Integer.MIN_VALUE);
        this.f2344t.m5159b(a.m5222e(C0693k.Toolbar_contentInsetLeft, 0), a.m5222e(C0693k.Toolbar_contentInsetRight, 0));
        if (!(d == Integer.MIN_VALUE && d2 == Integer.MIN_VALUE)) {
            this.f2344t.m5156a(d, d2);
        }
        this.f2331g = a.m5213a(C0693k.Toolbar_collapseIcon);
        this.f2332h = a.m5219c(C0693k.Toolbar_collapseContentDescription);
        CharSequence c = a.m5219c(C0693k.Toolbar_title);
        if (!TextUtils.isEmpty(c)) {
            setTitle(c);
        }
        c = a.m5219c(C0693k.Toolbar_subtitle);
        if (!TextUtils.isEmpty(c)) {
            setSubtitle(c);
        }
        this.f2334j = getContext();
        setPopupTheme(a.m5226g(C0693k.Toolbar_popupTheme, 0));
        Drawable a2 = a.m5213a(C0693k.Toolbar_navigationIcon);
        if (a2 != null) {
            setNavigationIcon(a2);
        }
        c = a.m5219c(C0693k.Toolbar_navigationContentDescription);
        if (!TextUtils.isEmpty(c)) {
            setNavigationContentDescription(c);
        }
        a2 = a.m5213a(C0693k.Toolbar_logo);
        if (a2 != null) {
            setLogo(a2);
        }
        c = a.m5219c(C0693k.Toolbar_logoDescription);
        if (!TextUtils.isEmpty(c)) {
            setLogoDescription(c);
        }
        if (a.m5225f(C0693k.Toolbar_titleTextColor)) {
            setTitleTextColor(a.m5216b(C0693k.Toolbar_titleTextColor, -1));
        }
        if (a.m5225f(C0693k.Toolbar_subtitleTextColor)) {
            setSubtitleTextColor(a.m5216b(C0693k.Toolbar_subtitleTextColor, -1));
        }
        a.m5214a();
        this.f2324N = C0893m.m5425a();
    }

    private int m4783a(int i) {
        int i2 = i & 112;
        switch (i2) {
            case 16:
            case 48:
            case 80:
                return i2;
            default:
                return this.f2345u & 112;
        }
    }

    private int m4784a(View view, int i) {
        C0819b c0819b = (C0819b) view.getLayoutParams();
        int measuredHeight = view.getMeasuredHeight();
        int i2 = i > 0 ? (measuredHeight - i) / 2 : 0;
        switch (m4783a(c0819b.a)) {
            case 48:
                return getPaddingTop() - i2;
            case 80:
                return (((getHeight() - getPaddingBottom()) - measuredHeight) - c0819b.bottomMargin) - i2;
            default:
                int i3;
                int paddingTop = getPaddingTop();
                int paddingBottom = getPaddingBottom();
                int height = getHeight();
                i2 = (((height - paddingTop) - paddingBottom) - measuredHeight) / 2;
                if (i2 < c0819b.topMargin) {
                    i3 = c0819b.topMargin;
                } else {
                    measuredHeight = (((height - paddingBottom) - measuredHeight) - i2) - paddingTop;
                    i3 = measuredHeight < c0819b.bottomMargin ? Math.max(0, i2 - (c0819b.bottomMargin - measuredHeight)) : i2;
                }
                return i3 + paddingTop;
        }
    }

    private int m4785a(View view, int i, int i2, int i3, int i4, int[] iArr) {
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view.getLayoutParams();
        int i5 = marginLayoutParams.leftMargin - iArr[0];
        int i6 = marginLayoutParams.rightMargin - iArr[1];
        int max = Math.max(0, i5) + Math.max(0, i6);
        iArr[0] = Math.max(0, -i5);
        iArr[1] = Math.max(0, -i6);
        view.measure(getChildMeasureSpec(i, ((getPaddingLeft() + getPaddingRight()) + max) + i2, marginLayoutParams.width), getChildMeasureSpec(i3, (((getPaddingTop() + getPaddingBottom()) + marginLayoutParams.topMargin) + marginLayoutParams.bottomMargin) + i4, marginLayoutParams.height));
        return view.getMeasuredWidth() + max;
    }

    private int m4786a(View view, int i, int[] iArr, int i2) {
        C0819b c0819b = (C0819b) view.getLayoutParams();
        int i3 = c0819b.leftMargin - iArr[0];
        int max = Math.max(0, i3) + i;
        iArr[0] = Math.max(0, -i3);
        i3 = m4784a(view, i2);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(max, i3, max + measuredWidth, view.getMeasuredHeight() + i3);
        return (c0819b.rightMargin + measuredWidth) + max;
    }

    private int m4787a(List<View> list, int[] iArr) {
        int i = iArr[0];
        int i2 = iArr[1];
        int size = list.size();
        int i3 = 0;
        int i4 = 0;
        int i5 = i2;
        int i6 = i;
        while (i3 < size) {
            View view = (View) list.get(i3);
            C0819b c0819b = (C0819b) view.getLayoutParams();
            i6 = c0819b.leftMargin - i6;
            i = c0819b.rightMargin - i5;
            int max = Math.max(0, i6);
            int max2 = Math.max(0, i);
            i6 = Math.max(0, -i6);
            i5 = Math.max(0, -i);
            i3++;
            i4 += (view.getMeasuredWidth() + max) + max2;
        }
        return i4;
    }

    private void m4789a(View view, int i, int i2, int i3, int i4, int i5) {
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view.getLayoutParams();
        int childMeasureSpec = getChildMeasureSpec(i, (((getPaddingLeft() + getPaddingRight()) + marginLayoutParams.leftMargin) + marginLayoutParams.rightMargin) + i2, marginLayoutParams.width);
        int childMeasureSpec2 = getChildMeasureSpec(i3, (((getPaddingTop() + getPaddingBottom()) + marginLayoutParams.topMargin) + marginLayoutParams.bottomMargin) + i4, marginLayoutParams.height);
        int mode = MeasureSpec.getMode(childMeasureSpec2);
        if (mode != 1073741824 && i5 >= 0) {
            if (mode != 0) {
                i5 = Math.min(MeasureSpec.getSize(childMeasureSpec2), i5);
            }
            childMeasureSpec2 = MeasureSpec.makeMeasureSpec(i5, 1073741824);
        }
        view.measure(childMeasureSpec, childMeasureSpec2);
    }

    private void m4790a(View view, boolean z) {
        LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = m4823i();
        } else if (checkLayoutParams(layoutParams)) {
            C0819b c0819b = (C0819b) layoutParams;
        } else {
            layoutParams = m4809a(layoutParams);
        }
        layoutParams.f2310b = 1;
        if (!z || this.f2325a == null) {
            addView(view, layoutParams);
            return;
        }
        view.setLayoutParams(layoutParams);
        this.f2313C.add(view);
    }

    private void m4791a(List<View> list, int i) {
        int i2 = 1;
        int i3 = 0;
        if (ag.m2540h(this) != 1) {
            i2 = 0;
        }
        int childCount = getChildCount();
        int a = C0507e.m2796a(i, ag.m2540h(this));
        list.clear();
        C0819b c0819b;
        if (i2 != 0) {
            for (i3 = childCount - 1; i3 >= 0; i3--) {
                View childAt = getChildAt(i3);
                c0819b = (C0819b) childAt.getLayoutParams();
                if (c0819b.f2310b == 0 && m4792a(childAt) && m4793b(c0819b.a) == a) {
                    list.add(childAt);
                }
            }
            return;
        }
        while (i3 < childCount) {
            View childAt2 = getChildAt(i3);
            c0819b = (C0819b) childAt2.getLayoutParams();
            if (c0819b.f2310b == 0 && m4792a(childAt2) && m4793b(c0819b.a) == a) {
                list.add(childAt2);
            }
            i3++;
        }
    }

    private boolean m4792a(View view) {
        return (view == null || view.getParent() != this || view.getVisibility() == 8) ? false : true;
    }

    private int m4793b(int i) {
        int h = ag.m2540h(this);
        int a = C0507e.m2796a(i, h) & 7;
        switch (a) {
            case 1:
            case 3:
            case 5:
                return a;
            default:
                return h == 1 ? 5 : 3;
        }
    }

    private int m4794b(View view) {
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view.getLayoutParams();
        return C0528n.m2834b(marginLayoutParams) + C0528n.m2833a(marginLayoutParams);
    }

    private int m4795b(View view, int i, int[] iArr, int i2) {
        C0819b c0819b = (C0819b) view.getLayoutParams();
        int i3 = c0819b.rightMargin - iArr[1];
        int max = i - Math.max(0, i3);
        iArr[1] = Math.max(0, -i3);
        i3 = m4784a(view, i2);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(max - measuredWidth, i3, max, view.getMeasuredHeight() + i3);
        return max - (c0819b.leftMargin + measuredWidth);
    }

    private int m4797c(View view) {
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view.getLayoutParams();
        return marginLayoutParams.bottomMargin + marginLayoutParams.topMargin;
    }

    private boolean m4800d(View view) {
        return view.getParent() == this || this.f2313C.contains(view);
    }

    private MenuInflater getMenuInflater() {
        return new C0712g(getContext());
    }

    private void m4801l() {
        if (this.f2330f == null) {
            this.f2330f = new ImageView(getContext());
        }
    }

    private void m4802m() {
        m4803n();
        if (this.f2326b.m4009d() == null) {
            C0727f c0727f = (C0727f) this.f2326b.getMenu();
            if (this.f2319I == null) {
                this.f2319I = new C0818a();
            }
            this.f2326b.setExpandedActionViewsExclusive(true);
            c0727f.m3817a(this.f2319I, this.f2334j);
        }
    }

    private void m4803n() {
        if (this.f2326b == null) {
            this.f2326b = new ActionMenuView(getContext());
            this.f2326b.setPopupTheme(this.f2335k);
            this.f2326b.setOnMenuItemClickListener(this.f2316F);
            this.f2326b.m4001a(this.f2320J, this.f2321K);
            LayoutParams i = m4823i();
            i.a = 8388613 | (this.f2338n & 112);
            this.f2326b.setLayoutParams(i);
            m4790a(this.f2326b, false);
        }
    }

    private void m4804o() {
        if (this.f2329e == null) {
            this.f2329e = new ImageButton(getContext(), null, C0683a.toolbarNavigationButtonStyle);
            LayoutParams i = m4823i();
            i.a = 8388611 | (this.f2338n & 112);
            this.f2329e.setLayoutParams(i);
        }
    }

    private void m4805p() {
        if (this.f2333i == null) {
            this.f2333i = new ImageButton(getContext(), null, C0683a.toolbarNavigationButtonStyle);
            this.f2333i.setImageDrawable(this.f2331g);
            this.f2333i.setContentDescription(this.f2332h);
            LayoutParams i = m4823i();
            i.a = 8388611 | (this.f2338n & 112);
            i.f2310b = 2;
            this.f2333i.setLayoutParams(i);
            this.f2333i.setOnClickListener(new C08163(this));
        }
    }

    private void m4806q() {
        removeCallbacks(this.f2323M);
        post(this.f2323M);
    }

    private boolean m4807r() {
        if (!this.f2322L) {
            return false;
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (m4792a(childAt) && childAt.getMeasuredWidth() > 0 && childAt.getMeasuredHeight() > 0) {
                return false;
            }
        }
        return true;
    }

    public C0819b m4808a(AttributeSet attributeSet) {
        return new C0819b(getContext(), attributeSet);
    }

    protected C0819b m4809a(LayoutParams layoutParams) {
        return layoutParams instanceof C0819b ? new C0819b((C0819b) layoutParams) : layoutParams instanceof C0611a ? new C0819b((C0611a) layoutParams) : layoutParams instanceof MarginLayoutParams ? new C0819b((MarginLayoutParams) layoutParams) : new C0819b(layoutParams);
    }

    public void m4810a(int i, int i2) {
        this.f2344t.m5156a(i, i2);
    }

    public void m4811a(Context context, int i) {
        this.f2336l = i;
        if (this.f2327c != null) {
            this.f2327c.setTextAppearance(context, i);
        }
    }

    public void m4812a(C0727f c0727f, C0873d c0873d) {
        if (c0727f != null || this.f2326b != null) {
            m4803n();
            C0727f d = this.f2326b.m4009d();
            if (d != c0727f) {
                if (d != null) {
                    d.m3827b(this.f2318H);
                    d.m3827b(this.f2319I);
                }
                if (this.f2319I == null) {
                    this.f2319I = new C0818a();
                }
                c0873d.m5341d(true);
                if (c0727f != null) {
                    c0727f.m3817a((C0721l) c0873d, this.f2334j);
                    c0727f.m3817a(this.f2319I, this.f2334j);
                } else {
                    c0873d.mo636a(this.f2334j, null);
                    this.f2319I.mo636a(this.f2334j, null);
                    c0873d.mo640b(true);
                    this.f2319I.mo640b(true);
                }
                this.f2326b.setPopupTheme(this.f2335k);
                this.f2326b.setPresenter(c0873d);
                this.f2318H = c0873d;
            }
        }
    }

    public void m4813a(C0654a c0654a, C0638a c0638a) {
        this.f2320J = c0654a;
        this.f2321K = c0638a;
        if (this.f2326b != null) {
            this.f2326b.m4001a(c0654a, c0638a);
        }
    }

    public boolean m4814a() {
        return getVisibility() == 0 && this.f2326b != null && this.f2326b.m4002a();
    }

    public void m4815b(Context context, int i) {
        this.f2337m = i;
        if (this.f2328d != null) {
            this.f2328d.setTextAppearance(context, i);
        }
    }

    public boolean m4816b() {
        return this.f2326b != null && this.f2326b.m4012g();
    }

    public boolean m4817c() {
        return this.f2326b != null && this.f2326b.m4013h();
    }

    protected boolean checkLayoutParams(LayoutParams layoutParams) {
        return super.checkLayoutParams(layoutParams) && (layoutParams instanceof C0819b);
    }

    public boolean m4818d() {
        return this.f2326b != null && this.f2326b.m4010e();
    }

    public boolean m4819e() {
        return this.f2326b != null && this.f2326b.m4011f();
    }

    public void m4820f() {
        if (this.f2326b != null) {
            this.f2326b.m4014i();
        }
    }

    public boolean m4821g() {
        return (this.f2319I == null || this.f2319I.f2308b == null) ? false : true;
    }

    protected /* synthetic */ LayoutParams generateDefaultLayoutParams() {
        return m4823i();
    }

    public /* synthetic */ LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return m4808a(attributeSet);
    }

    protected /* synthetic */ LayoutParams generateLayoutParams(LayoutParams layoutParams) {
        return m4809a(layoutParams);
    }

    public int getContentInsetEnd() {
        return this.f2344t.m5161d();
    }

    public int getContentInsetLeft() {
        return this.f2344t.m5155a();
    }

    public int getContentInsetRight() {
        return this.f2344t.m5158b();
    }

    public int getContentInsetStart() {
        return this.f2344t.m5160c();
    }

    public Drawable getLogo() {
        return this.f2330f != null ? this.f2330f.getDrawable() : null;
    }

    public CharSequence getLogoDescription() {
        return this.f2330f != null ? this.f2330f.getContentDescription() : null;
    }

    public Menu getMenu() {
        m4802m();
        return this.f2326b.getMenu();
    }

    public CharSequence getNavigationContentDescription() {
        return this.f2329e != null ? this.f2329e.getContentDescription() : null;
    }

    public Drawable getNavigationIcon() {
        return this.f2329e != null ? this.f2329e.getDrawable() : null;
    }

    public Drawable getOverflowIcon() {
        m4802m();
        return this.f2326b.getOverflowIcon();
    }

    public int getPopupTheme() {
        return this.f2335k;
    }

    public CharSequence getSubtitle() {
        return this.f2347w;
    }

    public CharSequence getTitle() {
        return this.f2346v;
    }

    public aj getWrapper() {
        if (this.f2317G == null) {
            this.f2317G = new bi(this, true);
        }
        return this.f2317G;
    }

    public void m4822h() {
        C0730h c0730h = this.f2319I == null ? null : this.f2319I.f2308b;
        if (c0730h != null) {
            c0730h.collapseActionView();
        }
    }

    protected C0819b m4823i() {
        return new C0819b(-2, -2);
    }

    void m4824j() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (!(((C0819b) childAt.getLayoutParams()).f2310b == 2 || childAt == this.f2326b)) {
                removeViewAt(childCount);
                this.f2313C.add(childAt);
            }
        }
    }

    void m4825k() {
        for (int size = this.f2313C.size() - 1; size >= 0; size--) {
            addView((View) this.f2313C.get(size));
        }
        this.f2313C.clear();
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.f2323M);
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        int a = C0543s.m2893a(motionEvent);
        if (a == 9) {
            this.f2311A = false;
        }
        if (!this.f2311A) {
            boolean onHoverEvent = super.onHoverEvent(motionEvent);
            if (a == 9 && !onHoverEvent) {
                this.f2311A = true;
            }
        }
        if (a == 10 || a == 3) {
            this.f2311A = false;
        }
        return true;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        int measuredHeight;
        int measuredWidth;
        Object obj = ag.m2540h(this) == 1 ? 1 : null;
        int width = getWidth();
        int height = getHeight();
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int i8 = width - paddingRight;
        int[] iArr = this.f2314D;
        iArr[1] = 0;
        iArr[0] = 0;
        int p = ag.m2548p(this);
        if (!m4792a(this.f2329e)) {
            i5 = paddingLeft;
        } else if (obj != null) {
            i8 = m4795b(this.f2329e, i8, iArr, p);
            i5 = paddingLeft;
        } else {
            i5 = m4786a(this.f2329e, paddingLeft, iArr, p);
        }
        if (m4792a(this.f2333i)) {
            if (obj != null) {
                i8 = m4795b(this.f2333i, i8, iArr, p);
            } else {
                i5 = m4786a(this.f2333i, i5, iArr, p);
            }
        }
        if (m4792a(this.f2326b)) {
            if (obj != null) {
                i5 = m4786a(this.f2326b, i5, iArr, p);
            } else {
                i8 = m4795b(this.f2326b, i8, iArr, p);
            }
        }
        iArr[0] = Math.max(0, getContentInsetLeft() - i5);
        iArr[1] = Math.max(0, getContentInsetRight() - ((width - paddingRight) - i8));
        i5 = Math.max(i5, getContentInsetLeft());
        i8 = Math.min(i8, (width - paddingRight) - getContentInsetRight());
        if (m4792a(this.f2325a)) {
            if (obj != null) {
                i8 = m4795b(this.f2325a, i8, iArr, p);
            } else {
                i5 = m4786a(this.f2325a, i5, iArr, p);
            }
        }
        if (!m4792a(this.f2330f)) {
            i6 = i8;
            i7 = i5;
        } else if (obj != null) {
            i6 = m4795b(this.f2330f, i8, iArr, p);
            i7 = i5;
        } else {
            i6 = i8;
            i7 = m4786a(this.f2330f, i5, iArr, p);
        }
        boolean a = m4792a(this.f2327c);
        boolean a2 = m4792a(this.f2328d);
        i5 = 0;
        if (a) {
            C0819b c0819b = (C0819b) this.f2327c.getLayoutParams();
            i5 = 0 + (c0819b.bottomMargin + (c0819b.topMargin + this.f2327c.getMeasuredHeight()));
        }
        if (a2) {
            c0819b = (C0819b) this.f2328d.getLayoutParams();
            measuredHeight = (c0819b.bottomMargin + (c0819b.topMargin + this.f2328d.getMeasuredHeight())) + i5;
        } else {
            measuredHeight = i5;
        }
        if (a || a2) {
            int paddingTop2;
            c0819b = (C0819b) (a ? this.f2327c : this.f2328d).getLayoutParams();
            C0819b c0819b2 = (C0819b) (a2 ? this.f2328d : this.f2327c).getLayoutParams();
            Object obj2 = ((!a || this.f2327c.getMeasuredWidth() <= 0) && (!a2 || this.f2328d.getMeasuredWidth() <= 0)) ? null : 1;
            switch (this.f2345u & 112) {
                case 48:
                    paddingTop2 = (c0819b.topMargin + getPaddingTop()) + this.f2342r;
                    break;
                case 80:
                    paddingTop2 = (((height - paddingBottom) - c0819b2.bottomMargin) - this.f2343s) - measuredHeight;
                    break;
                default:
                    paddingTop2 = (((height - paddingTop) - paddingBottom) - measuredHeight) / 2;
                    if (paddingTop2 < c0819b.topMargin + this.f2342r) {
                        i8 = c0819b.topMargin + this.f2342r;
                    } else {
                        measuredHeight = (((height - paddingBottom) - measuredHeight) - paddingTop2) - paddingTop;
                        i8 = measuredHeight < c0819b.bottomMargin + this.f2343s ? Math.max(0, paddingTop2 - ((c0819b2.bottomMargin + this.f2343s) - measuredHeight)) : paddingTop2;
                    }
                    paddingTop2 = paddingTop + i8;
                    break;
            }
            if (obj != null) {
                i8 = (obj2 != null ? this.f2340p : 0) - iArr[1];
                i5 = i6 - Math.max(0, i8);
                iArr[1] = Math.max(0, -i8);
                if (a) {
                    c0819b = (C0819b) this.f2327c.getLayoutParams();
                    measuredWidth = i5 - this.f2327c.getMeasuredWidth();
                    i6 = this.f2327c.getMeasuredHeight() + paddingTop2;
                    this.f2327c.layout(measuredWidth, paddingTop2, i5, i6);
                    paddingTop2 = i6 + c0819b.bottomMargin;
                    i6 = measuredWidth - this.f2341q;
                } else {
                    i6 = i5;
                }
                if (a2) {
                    c0819b = (C0819b) this.f2328d.getLayoutParams();
                    measuredWidth = c0819b.topMargin + paddingTop2;
                    measuredHeight = this.f2328d.getMeasuredHeight() + measuredWidth;
                    this.f2328d.layout(i5 - this.f2328d.getMeasuredWidth(), measuredWidth, i5, measuredHeight);
                    i8 = c0819b.bottomMargin + measuredHeight;
                    i8 = i5 - this.f2341q;
                } else {
                    i8 = i5;
                }
                i6 = obj2 != null ? Math.min(i6, i8) : i5;
            } else {
                i8 = (obj2 != null ? this.f2340p : 0) - iArr[0];
                i7 += Math.max(0, i8);
                iArr[0] = Math.max(0, -i8);
                if (a) {
                    c0819b = (C0819b) this.f2327c.getLayoutParams();
                    i5 = this.f2327c.getMeasuredWidth() + i7;
                    measuredWidth = this.f2327c.getMeasuredHeight() + paddingTop2;
                    this.f2327c.layout(i7, paddingTop2, i5, measuredWidth);
                    i8 = c0819b.bottomMargin + measuredWidth;
                    measuredWidth = i5 + this.f2341q;
                    i5 = i8;
                } else {
                    measuredWidth = i7;
                    i5 = paddingTop2;
                }
                if (a2) {
                    c0819b = (C0819b) this.f2328d.getLayoutParams();
                    i5 += c0819b.topMargin;
                    paddingTop2 = this.f2328d.getMeasuredWidth() + i7;
                    measuredHeight = this.f2328d.getMeasuredHeight() + i5;
                    this.f2328d.layout(i7, i5, paddingTop2, measuredHeight);
                    i8 = c0819b.bottomMargin + measuredHeight;
                    i8 = this.f2341q + paddingTop2;
                } else {
                    i8 = i7;
                }
                if (obj2 != null) {
                    i7 = Math.max(measuredWidth, i8);
                }
            }
        }
        m4791a(this.f2312B, 3);
        int size = this.f2312B.size();
        i5 = i7;
        for (measuredWidth = 0; measuredWidth < size; measuredWidth++) {
            i5 = m4786a((View) this.f2312B.get(measuredWidth), i5, iArr, p);
        }
        m4791a(this.f2312B, 5);
        i7 = this.f2312B.size();
        for (measuredWidth = 0; measuredWidth < i7; measuredWidth++) {
            i6 = m4795b((View) this.f2312B.get(measuredWidth), i6, iArr, p);
        }
        m4791a(this.f2312B, 1);
        measuredWidth = m4787a(this.f2312B, iArr);
        i8 = ((((width - paddingLeft) - paddingRight) / 2) + paddingLeft) - (measuredWidth / 2);
        measuredWidth += i8;
        if (i8 < i5) {
            i8 = i5;
        } else if (measuredWidth > i6) {
            i8 -= measuredWidth - i6;
        }
        paddingLeft = this.f2312B.size();
        measuredWidth = i8;
        for (i5 = 0; i5 < paddingLeft; i5++) {
            measuredWidth = m4786a((View) this.f2312B.get(i5), measuredWidth, iArr, p);
        }
        this.f2312B.clear();
    }

    protected void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int max;
        int i5 = 0;
        int i6 = 0;
        int[] iArr = this.f2314D;
        if (bl.m5302a(this)) {
            i3 = 0;
            i4 = 1;
        } else {
            i3 = 1;
            i4 = 0;
        }
        int i7 = 0;
        if (m4792a(this.f2329e)) {
            m4789a(this.f2329e, i, 0, i2, 0, this.f2339o);
            i7 = this.f2329e.getMeasuredWidth() + m4794b(this.f2329e);
            max = Math.max(0, this.f2329e.getMeasuredHeight() + m4797c(this.f2329e));
            i6 = bl.m5300a(0, ag.m2542j(this.f2329e));
            i5 = max;
        }
        if (m4792a(this.f2333i)) {
            m4789a(this.f2333i, i, 0, i2, 0, this.f2339o);
            i7 = this.f2333i.getMeasuredWidth() + m4794b(this.f2333i);
            i5 = Math.max(i5, this.f2333i.getMeasuredHeight() + m4797c(this.f2333i));
            i6 = bl.m5300a(i6, ag.m2542j(this.f2333i));
        }
        int contentInsetStart = getContentInsetStart();
        int max2 = 0 + Math.max(contentInsetStart, i7);
        iArr[i4] = Math.max(0, contentInsetStart - i7);
        i7 = 0;
        if (m4792a(this.f2326b)) {
            m4789a(this.f2326b, i, max2, i2, 0, this.f2339o);
            i7 = this.f2326b.getMeasuredWidth() + m4794b(this.f2326b);
            i5 = Math.max(i5, this.f2326b.getMeasuredHeight() + m4797c(this.f2326b));
            i6 = bl.m5300a(i6, ag.m2542j(this.f2326b));
        }
        contentInsetStart = getContentInsetEnd();
        max2 += Math.max(contentInsetStart, i7);
        iArr[i3] = Math.max(0, contentInsetStart - i7);
        if (m4792a(this.f2325a)) {
            max2 += m4785a(this.f2325a, i, max2, i2, 0, iArr);
            i5 = Math.max(i5, this.f2325a.getMeasuredHeight() + m4797c(this.f2325a));
            i6 = bl.m5300a(i6, ag.m2542j(this.f2325a));
        }
        if (m4792a(this.f2330f)) {
            max2 += m4785a(this.f2330f, i, max2, i2, 0, iArr);
            i5 = Math.max(i5, this.f2330f.getMeasuredHeight() + m4797c(this.f2330f));
            i6 = bl.m5300a(i6, ag.m2542j(this.f2330f));
        }
        i4 = getChildCount();
        i3 = 0;
        int i8 = i5;
        i5 = i6;
        while (i3 < i4) {
            View childAt = getChildAt(i3);
            if (((C0819b) childAt.getLayoutParams()).f2310b != 0) {
                i7 = i5;
                contentInsetStart = i8;
            } else if (m4792a(childAt)) {
                max2 += m4785a(childAt, i, max2, i2, 0, iArr);
                max = Math.max(i8, childAt.getMeasuredHeight() + m4797c(childAt));
                i7 = bl.m5300a(i5, ag.m2542j(childAt));
                contentInsetStart = max;
            } else {
                i7 = i5;
                contentInsetStart = i8;
            }
            i3++;
            i5 = i7;
            i8 = contentInsetStart;
        }
        contentInsetStart = 0;
        i7 = 0;
        i6 = this.f2342r + this.f2343s;
        max = this.f2340p + this.f2341q;
        if (m4792a(this.f2327c)) {
            m4785a(this.f2327c, i, max2 + max, i2, i6, iArr);
            contentInsetStart = m4794b(this.f2327c) + this.f2327c.getMeasuredWidth();
            i7 = this.f2327c.getMeasuredHeight() + m4797c(this.f2327c);
            i5 = bl.m5300a(i5, ag.m2542j(this.f2327c));
        }
        if (m4792a(this.f2328d)) {
            contentInsetStart = Math.max(contentInsetStart, m4785a(this.f2328d, i, max2 + max, i2, i6 + i7, iArr));
            i7 += this.f2328d.getMeasuredHeight() + m4797c(this.f2328d);
            i5 = bl.m5300a(i5, ag.m2542j(this.f2328d));
        }
        contentInsetStart += max2;
        i7 = Math.max(i8, i7) + (getPaddingTop() + getPaddingBottom());
        contentInsetStart = ag.m2508a(Math.max(contentInsetStart + (getPaddingLeft() + getPaddingRight()), getSuggestedMinimumWidth()), i, -16777216 & i5);
        i7 = ag.m2508a(Math.max(i7, getSuggestedMinimumHeight()), i2, i5 << 16);
        if (m4807r()) {
            i7 = 0;
        }
        setMeasuredDimension(contentInsetStart, i7);
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.getSuperState());
            Menu d = this.f2326b != null ? this.f2326b.m4009d() : null;
            if (!(savedState.f2305a == 0 || this.f2319I == null || d == null)) {
                MenuItem findItem = d.findItem(savedState.f2305a);
                if (findItem != null) {
                    C0535p.m2864b(findItem);
                }
            }
            if (savedState.f2306b) {
                m4806q();
                return;
            }
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    public void onRtlPropertiesChanged(int i) {
        boolean z = true;
        if (VERSION.SDK_INT >= 17) {
            super.onRtlPropertiesChanged(i);
        }
        ax axVar = this.f2344t;
        if (i != 1) {
            z = false;
        }
        axVar.m5157a(z);
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        if (!(this.f2319I == null || this.f2319I.f2308b == null)) {
            savedState.f2305a = this.f2319I.f2308b.getItemId();
        }
        savedState.f2306b = m4816b();
        return savedState;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int a = C0543s.m2893a(motionEvent);
        if (a == 0) {
            this.f2350z = false;
        }
        if (!this.f2350z) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            if (a == 0 && !onTouchEvent) {
                this.f2350z = true;
            }
        }
        if (a == 1 || a == 3) {
            this.f2350z = false;
        }
        return true;
    }

    public void setCollapsible(boolean z) {
        this.f2322L = z;
        requestLayout();
    }

    public void setLogo(int i) {
        setLogo(this.f2324N.m5448a(getContext(), i));
    }

    public void setLogo(Drawable drawable) {
        if (drawable != null) {
            m4801l();
            if (!m4800d(this.f2330f)) {
                m4790a(this.f2330f, true);
            }
        } else if (this.f2330f != null && m4800d(this.f2330f)) {
            removeView(this.f2330f);
            this.f2313C.remove(this.f2330f);
        }
        if (this.f2330f != null) {
            this.f2330f.setImageDrawable(drawable);
        }
    }

    public void setLogoDescription(int i) {
        setLogoDescription(getContext().getText(i));
    }

    public void setLogoDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            m4801l();
        }
        if (this.f2330f != null) {
            this.f2330f.setContentDescription(charSequence);
        }
    }

    public void setNavigationContentDescription(int i) {
        setNavigationContentDescription(i != 0 ? getContext().getText(i) : null);
    }

    public void setNavigationContentDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            m4804o();
        }
        if (this.f2329e != null) {
            this.f2329e.setContentDescription(charSequence);
        }
    }

    public void setNavigationIcon(int i) {
        setNavigationIcon(this.f2324N.m5448a(getContext(), i));
    }

    public void setNavigationIcon(Drawable drawable) {
        if (drawable != null) {
            m4804o();
            if (!m4800d(this.f2329e)) {
                m4790a(this.f2329e, true);
            }
        } else if (this.f2329e != null && m4800d(this.f2329e)) {
            removeView(this.f2329e);
            this.f2313C.remove(this.f2329e);
        }
        if (this.f2329e != null) {
            this.f2329e.setImageDrawable(drawable);
        }
    }

    public void setNavigationOnClickListener(OnClickListener onClickListener) {
        m4804o();
        this.f2329e.setOnClickListener(onClickListener);
    }

    public void setOnMenuItemClickListener(C0665c c0665c) {
        this.f2315E = c0665c;
    }

    public void setOverflowIcon(Drawable drawable) {
        m4802m();
        this.f2326b.setOverflowIcon(drawable);
    }

    public void setPopupTheme(int i) {
        if (this.f2335k != i) {
            this.f2335k = i;
            if (i == 0) {
                this.f2334j = getContext();
            } else {
                this.f2334j = new ContextThemeWrapper(getContext(), i);
            }
        }
    }

    public void setSubtitle(int i) {
        setSubtitle(getContext().getText(i));
    }

    public void setSubtitle(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            if (this.f2328d == null) {
                Context context = getContext();
                this.f2328d = new TextView(context);
                this.f2328d.setSingleLine();
                this.f2328d.setEllipsize(TruncateAt.END);
                if (this.f2337m != 0) {
                    this.f2328d.setTextAppearance(context, this.f2337m);
                }
                if (this.f2349y != 0) {
                    this.f2328d.setTextColor(this.f2349y);
                }
            }
            if (!m4800d(this.f2328d)) {
                m4790a(this.f2328d, true);
            }
        } else if (this.f2328d != null && m4800d(this.f2328d)) {
            removeView(this.f2328d);
            this.f2313C.remove(this.f2328d);
        }
        if (this.f2328d != null) {
            this.f2328d.setText(charSequence);
        }
        this.f2347w = charSequence;
    }

    public void setSubtitleTextColor(int i) {
        this.f2349y = i;
        if (this.f2328d != null) {
            this.f2328d.setTextColor(i);
        }
    }

    public void setTitle(int i) {
        setTitle(getContext().getText(i));
    }

    public void setTitle(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            if (this.f2327c == null) {
                Context context = getContext();
                this.f2327c = new TextView(context);
                this.f2327c.setSingleLine();
                this.f2327c.setEllipsize(TruncateAt.END);
                if (this.f2336l != 0) {
                    this.f2327c.setTextAppearance(context, this.f2336l);
                }
                if (this.f2348x != 0) {
                    this.f2327c.setTextColor(this.f2348x);
                }
            }
            if (!m4800d(this.f2327c)) {
                m4790a(this.f2327c, true);
            }
        } else if (this.f2327c != null && m4800d(this.f2327c)) {
            removeView(this.f2327c);
            this.f2313C.remove(this.f2327c);
        }
        if (this.f2327c != null) {
            this.f2327c.setText(charSequence);
        }
        this.f2346v = charSequence;
    }

    public void setTitleTextColor(int i) {
        this.f2348x = i;
        if (this.f2327c != null) {
            this.f2327c.setTextColor(i);
        }
    }
}
