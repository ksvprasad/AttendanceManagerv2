package android.support.design.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.support.design.C0048a.C0042d;
import android.support.design.C0048a.C0044f;
import android.support.design.C0048a.C0046h;
import android.support.design.C0048a.C0047i;
import android.support.design.widget.C0170v.C0054c;
import android.support.design.widget.C0170v.C0111b;
import android.support.v4.p015g.C0385i.C0382a;
import android.support.v4.p015g.C0385i.C0383b;
import android.support.v4.p015g.C0385i.C0384c;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.C0115f;
import android.support.v4.view.ab;
import android.support.v4.view.ag;
import android.support.v4.widget.C0608x;
import android.support.v7.p018a.C0614a.C0613c;
import android.support.v7.widget.C0893m;
import android.text.Layout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

public class TabLayout extends HorizontalScrollView {
    private static final C0382a<C0114d> f476a = new C0384c(16);
    private final C0382a<C0117f> f477A;
    private final ArrayList<C0114d> f478b;
    private C0114d f479c;
    private final C0113c f480d;
    private int f481e;
    private int f482f;
    private int f483g;
    private int f484h;
    private int f485i;
    private ColorStateList f486j;
    private float f487k;
    private float f488l;
    private final int f489m;
    private int f490n;
    private final int f491o;
    private final int f492p;
    private final int f493q;
    private int f494r;
    private int f495s;
    private int f496t;
    private C0107a f497u;
    private C0170v f498v;
    private ViewPager f499w;
    private ab f500x;
    private DataSetObserver f501y;
    private C0116e f502z;

    class C01061 implements C0054c {
        final /* synthetic */ TabLayout f439a;

        C01061(TabLayout tabLayout) {
            this.f439a = tabLayout;
        }

        public void mo39a(C0170v c0170v) {
            this.f439a.scrollTo(c0170v.m1083c(), 0);
        }
    }

    public interface C0107a {
        void mo110a(C0114d c0114d);

        void mo111b(C0114d c0114d);

        void mo112c(C0114d c0114d);
    }

    private class C0108b extends DataSetObserver {
        final /* synthetic */ TabLayout f440a;

        private C0108b(TabLayout tabLayout) {
            this.f440a = tabLayout;
        }

        public void onChanged() {
            this.f440a.m815c();
        }

        public void onInvalidated() {
            this.f440a.m815c();
        }
    }

    private class C0113c extends LinearLayout {
        final /* synthetic */ TabLayout f448a;
        private int f449b;
        private final Paint f450c;
        private int f451d = -1;
        private float f452e;
        private int f453f = -1;
        private int f454g = -1;
        private C0170v f455h;

        C0113c(TabLayout tabLayout, Context context) {
            this.f448a = tabLayout;
            super(context);
            setWillNotDraw(false);
            this.f450c = new Paint();
        }

        private void m752b(int i, int i2) {
            if (i != this.f453f || i2 != this.f454g) {
                this.f453f = i;
                this.f454g = i2;
                ag.m2532d(this);
            }
        }

        private void m753c() {
            int i;
            int i2;
            View childAt = getChildAt(this.f451d);
            if (childAt == null || childAt.getWidth() <= 0) {
                i = -1;
                i2 = -1;
            } else {
                i2 = childAt.getLeft();
                i = childAt.getRight();
                if (this.f452e > 0.0f && this.f451d < getChildCount() - 1) {
                    View childAt2 = getChildAt(this.f451d + 1);
                    i2 = (int) ((((float) i2) * (1.0f - this.f452e)) + (this.f452e * ((float) childAt2.getLeft())));
                    i = (int) ((((float) i) * (1.0f - this.f452e)) + (((float) childAt2.getRight()) * this.f452e));
                }
            }
            m752b(i2, i);
        }

        void m754a(int i) {
            if (this.f450c.getColor() != i) {
                this.f450c.setColor(i);
                ag.m2532d(this);
            }
        }

        void m755a(int i, float f) {
            if (this.f455h != null && this.f455h.m1082b()) {
                this.f455h.m1085e();
            }
            this.f451d = i;
            this.f452e = f;
            m753c();
        }

        void m756a(final int i, int i2) {
            if (this.f455h != null && this.f455h.m1082b()) {
                this.f455h.m1085e();
            }
            Object obj = ag.m2540h(this) == 1 ? 1 : null;
            View childAt = getChildAt(i);
            if (childAt == null) {
                m753c();
                return;
            }
            int i3;
            int i4;
            final int left = childAt.getLeft();
            final int right = childAt.getRight();
            if (Math.abs(i - this.f451d) <= 1) {
                i3 = this.f453f;
                i4 = this.f454g;
            } else {
                int a = this.f448a.m810b(24);
                if (i < this.f451d) {
                    if (obj != null) {
                        i4 = left - a;
                        i3 = i4;
                    } else {
                        i4 = right + a;
                        i3 = i4;
                    }
                } else if (obj != null) {
                    i4 = right + a;
                    i3 = i4;
                } else {
                    i4 = left - a;
                    i3 = i4;
                }
            }
            if (i3 != left || i4 != right) {
                C0170v a2 = ac.m890a();
                this.f455h = a2;
                a2.m1081a(C0127a.f537b);
                a2.m1077a(i2);
                a2.m1076a(0.0f, 1.0f);
                a2.m1080a(new C0054c(this) {
                    final /* synthetic */ C0113c f445e;

                    public void mo39a(C0170v c0170v) {
                        float f = c0170v.m1086f();
                        this.f445e.m752b(C0127a.m879a(i3, left, f), C0127a.m879a(i4, right, f));
                    }
                });
                a2.m1079a(new C0111b(this) {
                    final /* synthetic */ C0113c f447b;

                    public void mo104a(C0170v c0170v) {
                        this.f447b.f451d = i;
                        this.f447b.f452e = 0.0f;
                    }
                });
                a2.m1075a();
            }
        }

        boolean m757a() {
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                if (getChildAt(i).getWidth() <= 0) {
                    return true;
                }
            }
            return false;
        }

        float m758b() {
            return ((float) this.f451d) + this.f452e;
        }

        void m759b(int i) {
            if (this.f449b != i) {
                this.f449b = i;
                ag.m2532d(this);
            }
        }

        public void draw(Canvas canvas) {
            super.draw(canvas);
            if (this.f453f >= 0 && this.f454g > this.f453f) {
                canvas.drawRect((float) this.f453f, (float) (getHeight() - this.f449b), (float) this.f454g, (float) getHeight(), this.f450c);
            }
        }

        protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
            super.onLayout(z, i, i2, i3, i4);
            if (this.f455h == null || !this.f455h.m1082b()) {
                m753c();
                return;
            }
            this.f455h.m1085e();
            m756a(this.f451d, Math.round(((float) this.f455h.m1087g()) * (1.0f - this.f455h.m1086f())));
        }

        protected void onMeasure(int i, int i2) {
            boolean z = false;
            super.onMeasure(i, i2);
            if (MeasureSpec.getMode(i) == 1073741824 && this.f448a.f496t == 1 && this.f448a.f495s == 1) {
                int childCount = getChildCount();
                int i3 = 0;
                int i4 = 0;
                while (i3 < childCount) {
                    View childAt = getChildAt(i3);
                    i3++;
                    i4 = childAt.getVisibility() == 0 ? Math.max(i4, childAt.getMeasuredWidth()) : i4;
                }
                if (i4 > 0) {
                    if (i4 * childCount <= getMeasuredWidth() - (this.f448a.m810b(16) * 2)) {
                        i3 = 0;
                        while (i3 < childCount) {
                            boolean z2;
                            LayoutParams layoutParams = (LayoutParams) getChildAt(i3).getLayoutParams();
                            if (layoutParams.width == i4 && layoutParams.weight == 0.0f) {
                                z2 = z;
                            } else {
                                layoutParams.width = i4;
                                layoutParams.weight = 0.0f;
                                z2 = true;
                            }
                            i3++;
                            z = z2;
                        }
                    } else {
                        this.f448a.f495s = 0;
                        this.f448a.m809a(false);
                        z = true;
                    }
                    if (z) {
                        super.onMeasure(i, i2);
                    }
                }
            }
        }
    }

    public static final class C0114d {
        private Object f456a;
        private Drawable f457b;
        private CharSequence f458c;
        private CharSequence f459d;
        private int f460e;
        private View f461f;
        private TabLayout f462g;
        private C0117f f463h;

        private C0114d() {
            this.f460e = -1;
        }

        private void m766g() {
            if (this.f463h != null) {
                this.f463h.m793a();
            }
        }

        private void m767h() {
            this.f462g = null;
            this.f463h = null;
            this.f456a = null;
            this.f457b = null;
            this.f458c = null;
            this.f459d = null;
            this.f460e = -1;
            this.f461f = null;
        }

        public C0114d m768a(int i) {
            return m770a(LayoutInflater.from(this.f463h.getContext()).inflate(i, this.f463h, false));
        }

        public C0114d m769a(Drawable drawable) {
            this.f457b = drawable;
            m766g();
            return this;
        }

        public C0114d m770a(View view) {
            this.f461f = view;
            m766g();
            return this;
        }

        public C0114d m771a(CharSequence charSequence) {
            this.f458c = charSequence;
            m766g();
            return this;
        }

        public View m772a() {
            return this.f461f;
        }

        public Drawable m773b() {
            return this.f457b;
        }

        void m774b(int i) {
            this.f460e = i;
        }

        public int m775c() {
            return this.f460e;
        }

        public CharSequence m776d() {
            return this.f458c;
        }

        public void m777e() {
            if (this.f462g == null) {
                throw new IllegalArgumentException("Tab not attached to a TabLayout");
            }
            this.f462g.m839b(this);
        }

        public CharSequence m778f() {
            return this.f459d;
        }
    }

    public static class C0116e implements C0115f {
        private final WeakReference<TabLayout> f464a;
        private int f465b;
        private int f466c;

        public C0116e(TabLayout tabLayout) {
            this.f464a = new WeakReference(tabLayout);
        }

        private void m782a() {
            this.f466c = 0;
            this.f465b = 0;
        }

        public void mo107a(int i) {
            this.f465b = this.f466c;
            this.f466c = i;
        }

        public void mo108a(int i, float f, int i2) {
            boolean z = false;
            TabLayout tabLayout = (TabLayout) this.f464a.get();
            if (tabLayout != null) {
                boolean z2 = this.f466c != 2 || this.f465b == 1;
                if (!(this.f466c == 2 && this.f465b == 0)) {
                    z = true;
                }
                tabLayout.m801a(i, f, z2, z);
            }
        }

        public void mo109b(int i) {
            TabLayout tabLayout = (TabLayout) this.f464a.get();
            if (tabLayout != null && tabLayout.getSelectedTabPosition() != i) {
                boolean z = this.f466c == 0 || (this.f466c == 2 && this.f465b == 0);
                tabLayout.m840b(tabLayout.m834a(i), z);
            }
        }
    }

    class C0117f extends LinearLayout implements OnLongClickListener {
        final /* synthetic */ TabLayout f467a;
        private C0114d f468b;
        private TextView f469c;
        private ImageView f470d;
        private View f471e;
        private TextView f472f;
        private ImageView f473g;
        private int f474h = 2;

        public C0117f(TabLayout tabLayout, Context context) {
            this.f467a = tabLayout;
            super(context);
            if (tabLayout.f489m != 0) {
                setBackgroundDrawable(C0893m.m5425a().m5448a(context, tabLayout.f489m));
            }
            ag.m2513a(this, tabLayout.f481e, tabLayout.f482f, tabLayout.f483g, tabLayout.f484h);
            setGravity(17);
            setOrientation(1);
            setClickable(true);
        }

        private float m787a(Layout layout, int i, float f) {
            return layout.getLineWidth(i) * (f / layout.getPaint().getTextSize());
        }

        private void m788a(C0114d c0114d) {
            if (c0114d != this.f468b) {
                this.f468b = c0114d;
                m793a();
            }
        }

        private void m791a(TextView textView, ImageView imageView) {
            Drawable b = this.f468b != null ? this.f468b.m773b() : null;
            CharSequence d = this.f468b != null ? this.f468b.m776d() : null;
            CharSequence f = this.f468b != null ? this.f468b.m778f() : null;
            if (imageView != null) {
                if (b != null) {
                    imageView.setImageDrawable(b);
                    imageView.setVisibility(0);
                    setVisibility(0);
                } else {
                    imageView.setVisibility(8);
                    imageView.setImageDrawable(null);
                }
                imageView.setContentDescription(f);
            }
            boolean z = !TextUtils.isEmpty(d);
            if (textView != null) {
                if (z) {
                    textView.setText(d);
                    textView.setVisibility(0);
                    setVisibility(0);
                } else {
                    textView.setVisibility(8);
                    textView.setText(null);
                }
                textView.setContentDescription(f);
            }
            if (imageView != null) {
                MarginLayoutParams marginLayoutParams = (MarginLayoutParams) imageView.getLayoutParams();
                int a = (z && imageView.getVisibility() == 0) ? this.f467a.m810b(8) : 0;
                if (a != marginLayoutParams.bottomMargin) {
                    marginLayoutParams.bottomMargin = a;
                    imageView.requestLayout();
                }
            }
            if (z || TextUtils.isEmpty(f)) {
                setOnLongClickListener(null);
                setLongClickable(false);
                return;
            }
            setOnLongClickListener(this);
        }

        private void m792b() {
            m788a(null);
            setSelected(false);
        }

        final void m793a() {
            C0114d c0114d = this.f468b;
            View a = c0114d != null ? c0114d.m772a() : null;
            if (a != null) {
                C0117f parent = a.getParent();
                if (parent != this) {
                    if (parent != null) {
                        parent.removeView(a);
                    }
                    addView(a);
                }
                this.f471e = a;
                if (this.f469c != null) {
                    this.f469c.setVisibility(8);
                }
                if (this.f470d != null) {
                    this.f470d.setVisibility(8);
                    this.f470d.setImageDrawable(null);
                }
                this.f472f = (TextView) a.findViewById(16908308);
                if (this.f472f != null) {
                    this.f474h = C0608x.m3225a(this.f472f);
                }
                this.f473g = (ImageView) a.findViewById(16908294);
            } else {
                if (this.f471e != null) {
                    removeView(this.f471e);
                    this.f471e = null;
                }
                this.f472f = null;
                this.f473g = null;
            }
            if (this.f471e == null) {
                if (this.f470d == null) {
                    ImageView imageView = (ImageView) LayoutInflater.from(getContext()).inflate(C0044f.design_layout_tab_icon, this, false);
                    addView(imageView, 0);
                    this.f470d = imageView;
                }
                if (this.f469c == null) {
                    TextView textView = (TextView) LayoutInflater.from(getContext()).inflate(C0044f.design_layout_tab_text, this, false);
                    addView(textView);
                    this.f469c = textView;
                    this.f474h = C0608x.m3225a(this.f469c);
                }
                this.f469c.setTextAppearance(getContext(), this.f467a.f485i);
                if (this.f467a.f486j != null) {
                    this.f469c.setTextColor(this.f467a.f486j);
                }
                m791a(this.f469c, this.f470d);
            } else if (this.f472f != null || this.f473g != null) {
                m791a(this.f472f, this.f473g);
            }
        }

        @TargetApi(14)
        public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setClassName(C0613c.class.getName());
        }

        @TargetApi(14)
        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            accessibilityNodeInfo.setClassName(C0613c.class.getName());
        }

        public boolean onLongClick(View view) {
            int[] iArr = new int[2];
            getLocationOnScreen(iArr);
            Context context = getContext();
            int width = getWidth();
            int height = getHeight();
            int i = context.getResources().getDisplayMetrics().widthPixels;
            Toast makeText = Toast.makeText(context, this.f468b.m778f(), 0);
            makeText.setGravity(49, (iArr[0] + (width / 2)) - (i / 2), height);
            makeText.show();
            return true;
        }

        public void onMeasure(int i, int i2) {
            int i3 = 1;
            int size = MeasureSpec.getSize(i);
            int mode = MeasureSpec.getMode(i);
            int f = this.f467a.getTabMaxWidth();
            if (f > 0 && (mode == 0 || size > f)) {
                i = MeasureSpec.makeMeasureSpec(this.f467a.f490n, Integer.MIN_VALUE);
            }
            super.onMeasure(i, i2);
            if (this.f469c != null) {
                getResources();
                float h = this.f467a.f487k;
                size = this.f474h;
                if (this.f470d != null && this.f470d.getVisibility() == 0) {
                    size = 1;
                } else if (this.f469c != null && this.f469c.getLineCount() > 1) {
                    h = this.f467a.f488l;
                }
                float textSize = this.f469c.getTextSize();
                int lineCount = this.f469c.getLineCount();
                int a = C0608x.m3225a(this.f469c);
                if (h != textSize || (a >= 0 && size != a)) {
                    if (this.f467a.f496t == 1 && h > textSize && lineCount == 1) {
                        Layout layout = this.f469c.getLayout();
                        if (layout == null || m787a(layout, 0, h) > ((float) layout.getWidth())) {
                            i3 = 0;
                        }
                    }
                    if (i3 != 0) {
                        this.f469c.setTextSize(0, h);
                        this.f469c.setMaxLines(size);
                        super.onMeasure(i, i2);
                    }
                }
            }
        }

        public boolean performClick() {
            boolean performClick = super.performClick();
            if (this.f468b == null) {
                return performClick;
            }
            this.f468b.m777e();
            return true;
        }

        public void setSelected(boolean z) {
            Object obj = isSelected() != z ? 1 : null;
            super.setSelected(z);
            if (obj != null && z) {
                sendAccessibilityEvent(4);
                if (this.f469c != null) {
                    this.f469c.setSelected(z);
                }
                if (this.f470d != null) {
                    this.f470d.setSelected(z);
                }
            }
        }
    }

    public static class C0118g implements C0107a {
        private final ViewPager f475a;

        public C0118g(ViewPager viewPager) {
            this.f475a = viewPager;
        }

        public void mo110a(C0114d c0114d) {
            this.f475a.setCurrentItem(c0114d.m775c());
        }

        public void mo111b(C0114d c0114d) {
        }

        public void mo112c(C0114d c0114d) {
        }
    }

    public TabLayout(Context context) {
        this(context, null);
    }

    public TabLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TabLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f478b = new ArrayList();
        this.f490n = Integer.MAX_VALUE;
        this.f477A = new C0383b(12);
        C0164u.m1053a(context);
        setHorizontalScrollBarEnabled(false);
        this.f480d = new C0113c(this, context);
        super.addView(this.f480d, 0, new FrameLayout.LayoutParams(-2, -1));
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0047i.TabLayout, i, C0046h.Widget_Design_TabLayout);
        this.f480d.m759b(obtainStyledAttributes.getDimensionPixelSize(C0047i.TabLayout_tabIndicatorHeight, 0));
        this.f480d.m754a(obtainStyledAttributes.getColor(C0047i.TabLayout_tabIndicatorColor, 0));
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(C0047i.TabLayout_tabPadding, 0);
        this.f484h = dimensionPixelSize;
        this.f483g = dimensionPixelSize;
        this.f482f = dimensionPixelSize;
        this.f481e = dimensionPixelSize;
        this.f481e = obtainStyledAttributes.getDimensionPixelSize(C0047i.TabLayout_tabPaddingStart, this.f481e);
        this.f482f = obtainStyledAttributes.getDimensionPixelSize(C0047i.TabLayout_tabPaddingTop, this.f482f);
        this.f483g = obtainStyledAttributes.getDimensionPixelSize(C0047i.TabLayout_tabPaddingEnd, this.f483g);
        this.f484h = obtainStyledAttributes.getDimensionPixelSize(C0047i.TabLayout_tabPaddingBottom, this.f484h);
        this.f485i = obtainStyledAttributes.getResourceId(C0047i.TabLayout_tabTextAppearance, C0046h.TextAppearance_Design_Tab);
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(this.f485i, C0047i.TextAppearance);
        try {
            this.f487k = (float) obtainStyledAttributes2.getDimensionPixelSize(C0047i.TextAppearance_android_textSize, 0);
            this.f486j = obtainStyledAttributes2.getColorStateList(C0047i.TextAppearance_android_textColor);
            if (obtainStyledAttributes.hasValue(C0047i.TabLayout_tabTextColor)) {
                this.f486j = obtainStyledAttributes.getColorStateList(C0047i.TabLayout_tabTextColor);
            }
            if (obtainStyledAttributes.hasValue(C0047i.TabLayout_tabSelectedTextColor)) {
                this.f486j = m800a(this.f486j.getDefaultColor(), obtainStyledAttributes.getColor(C0047i.TabLayout_tabSelectedTextColor, 0));
            }
            this.f491o = obtainStyledAttributes.getDimensionPixelSize(C0047i.TabLayout_tabMinWidth, -1);
            this.f492p = obtainStyledAttributes.getDimensionPixelSize(C0047i.TabLayout_tabMaxWidth, -1);
            this.f489m = obtainStyledAttributes.getResourceId(C0047i.TabLayout_tabBackground, 0);
            this.f494r = obtainStyledAttributes.getDimensionPixelSize(C0047i.TabLayout_tabContentStart, 0);
            this.f496t = obtainStyledAttributes.getInt(C0047i.TabLayout_tabMode, 1);
            this.f495s = obtainStyledAttributes.getInt(C0047i.TabLayout_tabGravity, 0);
            obtainStyledAttributes.recycle();
            Resources resources = getResources();
            this.f488l = (float) resources.getDimensionPixelSize(C0042d.design_tab_text_size_2line);
            this.f493q = resources.getDimensionPixelSize(C0042d.design_tab_scrollable_min_width);
            m824f();
        } finally {
            obtainStyledAttributes2.recycle();
        }
    }

    private int m797a(int i, float f) {
        int i2 = 0;
        if (this.f496t != 0) {
            return 0;
        }
        View childAt = this.f480d.getChildAt(i);
        View childAt2 = i + 1 < this.f480d.getChildCount() ? this.f480d.getChildAt(i + 1) : null;
        int width = childAt != null ? childAt.getWidth() : 0;
        if (childAt2 != null) {
            i2 = childAt2.getWidth();
        }
        return ((((int) ((((float) (i2 + width)) * f) * 0.5f)) + childAt.getLeft()) + (childAt.getWidth() / 2)) - (getWidth() / 2);
    }

    private static ColorStateList m800a(int i, int i2) {
        r0 = new int[2][];
        int[] iArr = new int[]{SELECTED_STATE_SET, i2};
        r0[1] = EMPTY_STATE_SET;
        iArr[1] = i;
        return new ColorStateList(r0, iArr);
    }

    private void m801a(int i, float f, boolean z, boolean z2) {
        int round = Math.round(((float) i) + f);
        if (round >= 0 && round < this.f480d.getChildCount()) {
            if (z2) {
                this.f480d.m755a(i, f);
            }
            if (this.f498v != null && this.f498v.m1082b()) {
                this.f498v.m1085e();
            }
            scrollTo(m797a(i, f), 0);
            if (z) {
                setSelectedTabView(round);
            }
        }
    }

    private void m802a(C0114d c0114d, int i) {
        c0114d.m774b(i);
        this.f478b.add(i, c0114d);
        int size = this.f478b.size();
        for (int i2 = i + 1; i2 < size; i2++) {
            ((C0114d) this.f478b.get(i2)).m774b(i2);
        }
    }

    private void m805a(C0161s c0161s) {
        C0114d a = m833a();
        if (c0161s.f684a != null) {
            a.m771a(c0161s.f684a);
        }
        if (c0161s.f685b != null) {
            a.m769a(c0161s.f685b);
        }
        if (c0161s.f686c != 0) {
            a.m768a(c0161s.f686c);
        }
        m836a(a);
    }

    private void m806a(ab abVar, boolean z) {
        if (!(this.f500x == null || this.f501y == null)) {
            this.f500x.m1586b(this.f501y);
        }
        this.f500x = abVar;
        if (z && abVar != null) {
            if (this.f501y == null) {
                this.f501y = new C0108b();
            }
            abVar.m1578a(this.f501y);
        }
        m815c();
    }

    private void m807a(View view) {
        if (view instanceof C0161s) {
            m805a((C0161s) view);
            return;
        }
        throw new IllegalArgumentException("Only TabItem instances can be added to TabLayout");
    }

    private void m808a(LayoutParams layoutParams) {
        if (this.f496t == 1 && this.f495s == 0) {
            layoutParams.width = 0;
            layoutParams.weight = 1.0f;
            return;
        }
        layoutParams.width = -2;
        layoutParams.weight = 0.0f;
    }

    private void m809a(boolean z) {
        for (int i = 0; i < this.f480d.getChildCount(); i++) {
            View childAt = this.f480d.getChildAt(i);
            childAt.setMinimumWidth(getTabMinWidth());
            m808a((LayoutParams) childAt.getLayoutParams());
            if (z) {
                childAt.requestLayout();
            }
        }
    }

    private int m810b(int i) {
        return Math.round(getResources().getDisplayMetrics().density * ((float) i));
    }

    private C0117f m814c(C0114d c0114d) {
        C0117f c0117f = this.f477A != null ? (C0117f) this.f477A.mo282a() : null;
        if (c0117f == null) {
            c0117f = new C0117f(this, getContext());
        }
        c0117f.m788a(c0114d);
        c0117f.setFocusable(true);
        c0117f.setMinimumWidth(getTabMinWidth());
        return c0117f;
    }

    private void m815c() {
        m838b();
        if (this.f500x != null) {
            int i;
            int b = this.f500x.mo879b();
            for (i = 0; i < b; i++) {
                m837a(m833a().m771a(this.f500x.mo1801c(i)), false);
            }
            if (this.f499w != null && b > 0) {
                i = this.f499w.getCurrentItem();
                if (i != getSelectedTabPosition() && i < getTabCount()) {
                    m839b(m834a(i));
                    return;
                }
                return;
            }
            return;
        }
        m838b();
    }

    private void m816c(int i) {
        C0117f c0117f = (C0117f) this.f480d.getChildAt(i);
        this.f480d.removeViewAt(i);
        if (c0117f != null) {
            c0117f.m792b();
            this.f477A.mo283a(c0117f);
        }
        requestLayout();
    }

    private void m817c(C0114d c0114d, boolean z) {
        View d = c0114d.f463h;
        this.f480d.addView(d, m822e());
        if (z) {
            d.setSelected(true);
        }
    }

    private void m819d() {
        int size = this.f478b.size();
        for (int i = 0; i < size; i++) {
            ((C0114d) this.f478b.get(i)).m766g();
        }
    }

    private void m820d(int i) {
        if (i != -1) {
            if (getWindowToken() == null || !ag.m2503A(this) || this.f480d.m757a()) {
                m835a(i, 0.0f, true);
                return;
            }
            int scrollX = getScrollX();
            int a = m797a(i, 0.0f);
            if (scrollX != a) {
                if (this.f498v == null) {
                    this.f498v = ac.m890a();
                    this.f498v.m1081a(C0127a.f537b);
                    this.f498v.m1077a(300);
                    this.f498v.m1080a(new C01061(this));
                }
                this.f498v.m1078a(scrollX, a);
                this.f498v.m1075a();
            }
            this.f480d.m756a(i, 300);
        }
    }

    private LayoutParams m822e() {
        LayoutParams layoutParams = new LayoutParams(-2, -1);
        m808a(layoutParams);
        return layoutParams;
    }

    private void m824f() {
        ag.m2513a(this.f480d, this.f496t == 0 ? Math.max(0, this.f494r - this.f481e) : 0, 0, 0, 0);
        switch (this.f496t) {
            case 0:
                this.f480d.setGravity(8388611);
                break;
            case 1:
                this.f480d.setGravity(1);
                break;
        }
        m809a(true);
    }

    private int getDefaultHeight() {
        Object obj;
        int size = this.f478b.size();
        for (int i = 0; i < size; i++) {
            C0114d c0114d = (C0114d) this.f478b.get(i);
            if (c0114d != null && c0114d.m773b() != null && !TextUtils.isEmpty(c0114d.m776d())) {
                obj = 1;
                break;
            }
        }
        obj = null;
        return obj != null ? 72 : 48;
    }

    private float getScrollPosition() {
        return this.f480d.m758b();
    }

    private int getTabMaxWidth() {
        return this.f490n;
    }

    private int getTabMinWidth() {
        return this.f491o != -1 ? this.f491o : this.f496t == 0 ? this.f493q : 0;
    }

    private int getTabScrollRange() {
        return Math.max(0, ((this.f480d.getWidth() - getWidth()) - getPaddingLeft()) - getPaddingRight());
    }

    private void setSelectedTabView(int i) {
        int childCount = this.f480d.getChildCount();
        if (i < childCount && !this.f480d.getChildAt(i).isSelected()) {
            int i2 = 0;
            while (i2 < childCount) {
                this.f480d.getChildAt(i2).setSelected(i2 == i);
                i2++;
            }
        }
    }

    public C0114d m833a() {
        C0114d c0114d = (C0114d) f476a.mo282a();
        if (c0114d == null) {
            c0114d = new C0114d();
        }
        c0114d.f462g = this;
        c0114d.f463h = m814c(c0114d);
        return c0114d;
    }

    public C0114d m834a(int i) {
        return (C0114d) this.f478b.get(i);
    }

    public void m835a(int i, float f, boolean z) {
        m801a(i, f, z, true);
    }

    public void m836a(C0114d c0114d) {
        m837a(c0114d, this.f478b.isEmpty());
    }

    public void m837a(C0114d c0114d, boolean z) {
        if (c0114d.f462g != this) {
            throw new IllegalArgumentException("Tab belongs to a different TabLayout.");
        }
        m817c(c0114d, z);
        m802a(c0114d, this.f478b.size());
        if (z) {
            c0114d.m777e();
        }
    }

    public void addView(View view) {
        m807a(view);
    }

    public void addView(View view, int i) {
        m807a(view);
    }

    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        m807a(view);
    }

    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        m807a(view);
    }

    public void m838b() {
        for (int childCount = this.f480d.getChildCount() - 1; childCount >= 0; childCount--) {
            m816c(childCount);
        }
        Iterator it = this.f478b.iterator();
        while (it.hasNext()) {
            C0114d c0114d = (C0114d) it.next();
            it.remove();
            c0114d.m767h();
            f476a.mo283a(c0114d);
        }
        this.f479c = null;
    }

    void m839b(C0114d c0114d) {
        m840b(c0114d, true);
    }

    void m840b(C0114d c0114d, boolean z) {
        if (this.f479c != c0114d) {
            if (z) {
                int c = c0114d != null ? c0114d.m775c() : -1;
                if (c != -1) {
                    setSelectedTabView(c);
                }
                if ((this.f479c == null || this.f479c.m775c() == -1) && c != -1) {
                    m835a(c, 0.0f, true);
                } else {
                    m820d(c);
                }
            }
            if (!(this.f479c == null || this.f497u == null)) {
                this.f497u.mo111b(this.f479c);
            }
            this.f479c = c0114d;
            if (this.f479c != null && this.f497u != null) {
                this.f497u.mo110a(this.f479c);
            }
        } else if (this.f479c != null) {
            if (this.f497u != null) {
                this.f497u.mo112c(this.f479c);
            }
            m820d(c0114d.m775c());
        }
    }

    public FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return generateDefaultLayoutParams();
    }

    public int getSelectedTabPosition() {
        return this.f479c != null ? this.f479c.m775c() : -1;
    }

    public int getTabCount() {
        return this.f478b.size();
    }

    public int getTabGravity() {
        return this.f495s;
    }

    public int getTabMode() {
        return this.f496t;
    }

    public ColorStateList getTabTextColors() {
        return this.f486j;
    }

    protected void onMeasure(int i, int i2) {
        int i3 = 1;
        int b = (m810b(getDefaultHeight()) + getPaddingTop()) + getPaddingBottom();
        switch (MeasureSpec.getMode(i2)) {
            case Integer.MIN_VALUE:
                i2 = MeasureSpec.makeMeasureSpec(Math.min(b, MeasureSpec.getSize(i2)), 1073741824);
                break;
            case 0:
                i2 = MeasureSpec.makeMeasureSpec(b, 1073741824);
                break;
        }
        b = MeasureSpec.getSize(i);
        if (MeasureSpec.getMode(i) != 0) {
            this.f490n = this.f492p > 0 ? this.f492p : b - m810b(56);
        }
        super.onMeasure(i, i2);
        if (getChildCount() == 1) {
            View childAt = getChildAt(0);
            switch (this.f496t) {
                case 0:
                    if (childAt.getMeasuredWidth() >= getMeasuredWidth()) {
                        b = 0;
                        break;
                    } else {
                        b = 1;
                        break;
                    }
                case 1:
                    if (childAt.getMeasuredWidth() == getMeasuredWidth()) {
                        i3 = 0;
                    }
                    b = i3;
                    break;
                default:
                    b = 0;
                    break;
            }
            if (b != 0) {
                childAt.measure(MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), getChildMeasureSpec(i2, getPaddingTop() + getPaddingBottom(), childAt.getLayoutParams().height));
            }
        }
    }

    public void setOnTabSelectedListener(C0107a c0107a) {
        this.f497u = c0107a;
    }

    public void setSelectedTabIndicatorColor(int i) {
        this.f480d.m754a(i);
    }

    public void setSelectedTabIndicatorHeight(int i) {
        this.f480d.m759b(i);
    }

    public void setTabGravity(int i) {
        if (this.f495s != i) {
            this.f495s = i;
            m824f();
        }
    }

    public void setTabMode(int i) {
        if (i != this.f496t) {
            this.f496t = i;
            m824f();
        }
    }

    public void setTabTextColors(ColorStateList colorStateList) {
        if (this.f486j != colorStateList) {
            this.f486j = colorStateList;
            m819d();
        }
    }

    @Deprecated
    public void setTabsFromPagerAdapter(ab abVar) {
        m806a(abVar, false);
    }

    public void setupWithViewPager(ViewPager viewPager) {
        if (!(this.f499w == null || this.f502z == null)) {
            this.f499w.m2011b(this.f502z);
        }
        if (viewPager != null) {
            ab adapter = viewPager.getAdapter();
            if (adapter == null) {
                throw new IllegalArgumentException("ViewPager does not have a PagerAdapter set");
            }
            this.f499w = viewPager;
            if (this.f502z == null) {
                this.f502z = new C0116e(this);
            }
            this.f502z.m782a();
            viewPager.m2004a(this.f502z);
            setOnTabSelectedListener(new C0118g(viewPager));
            m806a(adapter, true);
            return;
        }
        this.f499w = null;
        setOnTabSelectedListener(null);
        m806a(null, true);
    }

    public boolean shouldDelayChildPressedState() {
        return getTabScrollRange() > 0;
    }
}
