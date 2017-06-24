package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v7.p018a.C0614a.C0613c;
import android.support.v7.p019b.C0694a.C0683a;
import android.support.v7.view.C0704a;
import android.support.v7.widget.ao.C0752a;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.BaseAdapter;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class az extends HorizontalScrollView implements OnItemSelectedListener {
    private static final Interpolator f2545j = new DecelerateInterpolator();
    Runnable f2546a;
    int f2547b;
    int f2548c;
    private C0856b f2549d;
    private ao f2550e;
    private Spinner f2551f;
    private boolean f2552g;
    private int f2553h;
    private int f2554i;

    private class C0855a extends BaseAdapter {
        final /* synthetic */ az f2537a;

        private C0855a(az azVar) {
            this.f2537a = azVar;
        }

        public int getCount() {
            return this.f2537a.f2550e.getChildCount();
        }

        public Object getItem(int i) {
            return ((C0857c) this.f2537a.f2550e.getChildAt(i)).m5167b();
        }

        public long getItemId(int i) {
            return (long) i;
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                return this.f2537a.m5169a((C0613c) getItem(i), true);
            }
            ((C0857c) view).m5166a((C0613c) getItem(i));
            return view;
        }
    }

    private class C0856b implements OnClickListener {
        final /* synthetic */ az f2538a;

        private C0856b(az azVar) {
            this.f2538a = azVar;
        }

        public void onClick(View view) {
            ((C0857c) view).m5167b().m3235d();
            int childCount = this.f2538a.f2550e.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.f2538a.f2550e.getChildAt(i);
                childAt.setSelected(childAt == view);
            }
        }
    }

    private class C0857c extends ao implements OnLongClickListener {
        final /* synthetic */ az f2539a;
        private final int[] f2540b = new int[]{16842964};
        private C0613c f2541c;
        private TextView f2542d;
        private ImageView f2543e;
        private View f2544f;

        public C0857c(az azVar, Context context, C0613c c0613c, boolean z) {
            this.f2539a = azVar;
            super(context, null, C0683a.actionBarTabStyle);
            this.f2541c = c0613c;
            bh a = bh.m5210a(context, null, this.f2540b, C0683a.actionBarTabStyle, 0);
            if (a.m5225f(0)) {
                setBackgroundDrawable(a.m5213a(0));
            }
            a.m5214a();
            if (z) {
                setGravity(8388627);
            }
            m5165a();
        }

        public void m5165a() {
            C0613c c0613c = this.f2541c;
            View c = c0613c.m3234c();
            if (c != null) {
                C0857c parent = c.getParent();
                if (parent != this) {
                    if (parent != null) {
                        parent.removeView(c);
                    }
                    addView(c);
                }
                this.f2544f = c;
                if (this.f2542d != null) {
                    this.f2542d.setVisibility(8);
                }
                if (this.f2543e != null) {
                    this.f2543e.setVisibility(8);
                    this.f2543e.setImageDrawable(null);
                    return;
                }
                return;
            }
            if (this.f2544f != null) {
                removeView(this.f2544f);
                this.f2544f = null;
            }
            Drawable a = c0613c.m3232a();
            CharSequence b = c0613c.m3233b();
            if (a != null) {
                if (this.f2543e == null) {
                    View imageView = new ImageView(getContext());
                    LayoutParams c0752a = new C0752a(-2, -2);
                    c0752a.f1992h = 16;
                    imageView.setLayoutParams(c0752a);
                    addView(imageView, 0);
                    this.f2543e = imageView;
                }
                this.f2543e.setImageDrawable(a);
                this.f2543e.setVisibility(0);
            } else if (this.f2543e != null) {
                this.f2543e.setVisibility(8);
                this.f2543e.setImageDrawable(null);
            }
            boolean z = !TextUtils.isEmpty(b);
            if (z) {
                if (this.f2542d == null) {
                    imageView = new ab(getContext(), null, C0683a.actionBarTabTextStyle);
                    imageView.setEllipsize(TruncateAt.END);
                    c0752a = new C0752a(-2, -2);
                    c0752a.f1992h = 16;
                    imageView.setLayoutParams(c0752a);
                    addView(imageView);
                    this.f2542d = imageView;
                }
                this.f2542d.setText(b);
                this.f2542d.setVisibility(0);
            } else if (this.f2542d != null) {
                this.f2542d.setVisibility(8);
                this.f2542d.setText(null);
            }
            if (this.f2543e != null) {
                this.f2543e.setContentDescription(c0613c.m3236e());
            }
            if (z || TextUtils.isEmpty(c0613c.m3236e())) {
                setOnLongClickListener(null);
                setLongClickable(false);
                return;
            }
            setOnLongClickListener(this);
        }

        public void m5166a(C0613c c0613c) {
            this.f2541c = c0613c;
            m5165a();
        }

        public C0613c m5167b() {
            return this.f2541c;
        }

        public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setClassName(C0613c.class.getName());
        }

        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            if (VERSION.SDK_INT >= 14) {
                accessibilityNodeInfo.setClassName(C0613c.class.getName());
            }
        }

        public boolean onLongClick(View view) {
            int[] iArr = new int[2];
            getLocationOnScreen(iArr);
            Context context = getContext();
            int width = getWidth();
            int height = getHeight();
            int i = context.getResources().getDisplayMetrics().widthPixels;
            Toast makeText = Toast.makeText(context, this.f2541c.m3236e(), 0);
            makeText.setGravity(49, (iArr[0] + (width / 2)) - (i / 2), height);
            makeText.show();
            return true;
        }

        public void onMeasure(int i, int i2) {
            super.onMeasure(i, i2);
            if (this.f2539a.f2547b > 0 && getMeasuredWidth() > this.f2539a.f2547b) {
                super.onMeasure(MeasureSpec.makeMeasureSpec(this.f2539a.f2547b, 1073741824), i2);
            }
        }

        public void setSelected(boolean z) {
            Object obj = isSelected() != z ? 1 : null;
            super.setSelected(z);
            if (obj != null && z) {
                sendAccessibilityEvent(4);
            }
        }
    }

    private C0857c m5169a(C0613c c0613c, boolean z) {
        C0857c c0857c = new C0857c(this, getContext(), c0613c, z);
        if (z) {
            c0857c.setBackgroundDrawable(null);
            c0857c.setLayoutParams(new AbsListView.LayoutParams(-1, this.f2553h));
        } else {
            c0857c.setFocusable(true);
            if (this.f2549d == null) {
                this.f2549d = new C0856b();
            }
            c0857c.setOnClickListener(this.f2549d);
        }
        return c0857c;
    }

    private boolean m5171a() {
        return this.f2551f != null && this.f2551f.getParent() == this;
    }

    private void m5172b() {
        if (!m5171a()) {
            if (this.f2551f == null) {
                this.f2551f = m5174d();
            }
            removeView(this.f2550e);
            addView(this.f2551f, new LayoutParams(-2, -1));
            if (this.f2551f.getAdapter() == null) {
                this.f2551f.setAdapter(new C0855a());
            }
            if (this.f2546a != null) {
                removeCallbacks(this.f2546a);
                this.f2546a = null;
            }
            this.f2551f.setSelection(this.f2554i);
        }
    }

    private boolean m5173c() {
        if (m5171a()) {
            removeView(this.f2551f);
            addView(this.f2550e, new LayoutParams(-2, -1));
            setTabSelected(this.f2551f.getSelectedItemPosition());
        }
        return false;
    }

    private Spinner m5174d() {
        Spinner c0910y = new C0910y(getContext(), null, C0683a.actionDropDownStyle);
        c0910y.setLayoutParams(new C0752a(-2, -1));
        c0910y.setOnItemSelectedListener(this);
        return c0910y;
    }

    public void m5175a(int i) {
        final View childAt = this.f2550e.getChildAt(i);
        if (this.f2546a != null) {
            removeCallbacks(this.f2546a);
        }
        this.f2546a = new Runnable(this) {
            final /* synthetic */ az f2536b;

            public void run() {
                this.f2536b.smoothScrollTo(childAt.getLeft() - ((this.f2536b.getWidth() - childAt.getWidth()) / 2), 0);
                this.f2536b.f2546a = null;
            }
        };
        post(this.f2546a);
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f2546a != null) {
            post(this.f2546a);
        }
    }

    protected void onConfigurationChanged(Configuration configuration) {
        if (VERSION.SDK_INT >= 8) {
            super.onConfigurationChanged(configuration);
        }
        C0704a a = C0704a.m3646a(getContext());
        setContentHeight(a.m3651e());
        this.f2548c = a.m3653g();
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f2546a != null) {
            removeCallbacks(this.f2546a);
        }
    }

    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
        ((C0857c) view).m5167b().m3235d();
    }

    public void onMeasure(int i, int i2) {
        int i3 = 1;
        int mode = MeasureSpec.getMode(i);
        boolean z = mode == 1073741824;
        setFillViewport(z);
        int childCount = this.f2550e.getChildCount();
        if (childCount <= 1 || !(mode == 1073741824 || mode == Integer.MIN_VALUE)) {
            this.f2547b = -1;
        } else {
            if (childCount > 2) {
                this.f2547b = (int) (((float) MeasureSpec.getSize(i)) * 0.4f);
            } else {
                this.f2547b = MeasureSpec.getSize(i) / 2;
            }
            this.f2547b = Math.min(this.f2547b, this.f2548c);
        }
        mode = MeasureSpec.makeMeasureSpec(this.f2553h, 1073741824);
        if (z || !this.f2552g) {
            i3 = 0;
        }
        if (i3 != 0) {
            this.f2550e.measure(0, mode);
            if (this.f2550e.getMeasuredWidth() > MeasureSpec.getSize(i)) {
                m5172b();
            } else {
                m5173c();
            }
        } else {
            m5173c();
        }
        i3 = getMeasuredWidth();
        super.onMeasure(i, mode);
        int measuredWidth = getMeasuredWidth();
        if (z && i3 != measuredWidth) {
            setTabSelected(this.f2554i);
        }
    }

    public void onNothingSelected(AdapterView<?> adapterView) {
    }

    public void setAllowCollapse(boolean z) {
        this.f2552g = z;
    }

    public void setContentHeight(int i) {
        this.f2553h = i;
        requestLayout();
    }

    public void setTabSelected(int i) {
        this.f2554i = i;
        int childCount = this.f2550e.getChildCount();
        int i2 = 0;
        while (i2 < childCount) {
            View childAt = this.f2550e.getChildAt(i2);
            boolean z = i2 == i;
            childAt.setSelected(z);
            if (z) {
                m5175a(i);
            }
            i2++;
        }
        if (this.f2551f != null && i >= 0) {
            this.f2551f.setSelection(i);
        }
    }
}
