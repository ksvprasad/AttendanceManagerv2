package android.support.v7.widget;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.database.DataSetObserver;
import android.graphics.drawable.Drawable;
import android.support.v4.view.C0503d;
import android.support.v4.view.ag;
import android.support.v7.p019b.C0694a.C0688f;
import android.support.v7.p019b.C0694a.C0690h;
import android.support.v7.p019b.C0694a.C0691i;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;

public class ActivityChooserView extends ViewGroup {
    C0503d f2020a;
    private final C0756a f2021b;
    private final C0757b f2022c;
    private final ao f2023d;
    private final FrameLayout f2024e;
    private final ImageView f2025f;
    private final FrameLayout f2026g;
    private final int f2027h;
    private final DataSetObserver f2028i;
    private final OnGlobalLayoutListener f2029j;
    private ap f2030k;
    private OnDismissListener f2031l;
    private boolean f2032m;
    private int f2033n;
    private boolean f2034o;
    private int f2035p;

    public static class InnerLayout extends ao {
        private static final int[] f2012a = new int[]{16842964};

        public InnerLayout(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            bh a = bh.m5209a(context, attributeSet, f2012a);
            setBackgroundDrawable(a.m5213a(0));
            a.m5214a();
        }
    }

    private class C0756a extends BaseAdapter {
        final /* synthetic */ ActivityChooserView f2013a;
        private C0880e f2014b;
        private int f2015c;
        private boolean f2016d;
        private boolean f2017e;
        private boolean f2018f;

        public int m4016a() {
            int i = 0;
            int i2 = this.f2015c;
            this.f2015c = Integer.MAX_VALUE;
            int makeMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
            int makeMeasureSpec2 = MeasureSpec.makeMeasureSpec(0, 0);
            int count = getCount();
            View view = null;
            int i3 = 0;
            while (i < count) {
                view = getView(i, view, null);
                view.measure(makeMeasureSpec, makeMeasureSpec2);
                i3 = Math.max(i3, view.getMeasuredWidth());
                i++;
            }
            this.f2015c = i2;
            return i3;
        }

        public void m4017a(int i) {
            if (this.f2015c != i) {
                this.f2015c = i;
                notifyDataSetChanged();
            }
        }

        public void m4018a(C0880e c0880e) {
            C0880e d = this.f2013a.f2021b.m4023d();
            if (d != null && this.f2013a.isShown()) {
                d.unregisterObserver(this.f2013a.f2028i);
            }
            this.f2014b = c0880e;
            if (c0880e != null && this.f2013a.isShown()) {
                c0880e.registerObserver(this.f2013a.f2028i);
            }
            notifyDataSetChanged();
        }

        public void m4019a(boolean z) {
            if (this.f2018f != z) {
                this.f2018f = z;
                notifyDataSetChanged();
            }
        }

        public void m4020a(boolean z, boolean z2) {
            if (this.f2016d != z || this.f2017e != z2) {
                this.f2016d = z;
                this.f2017e = z2;
                notifyDataSetChanged();
            }
        }

        public ResolveInfo m4021b() {
            return this.f2014b.m5368b();
        }

        public int m4022c() {
            return this.f2014b.m5364a();
        }

        public C0880e m4023d() {
            return this.f2014b;
        }

        public boolean m4024e() {
            return this.f2016d;
        }

        public int getCount() {
            int a = this.f2014b.m5364a();
            if (!(this.f2016d || this.f2014b.m5368b() == null)) {
                a--;
            }
            a = Math.min(a, this.f2015c);
            return this.f2018f ? a + 1 : a;
        }

        public Object getItem(int i) {
            switch (getItemViewType(i)) {
                case 0:
                    if (!(this.f2016d || this.f2014b.m5368b() == null)) {
                        i++;
                    }
                    return this.f2014b.m5366a(i);
                case 1:
                    return null;
                default:
                    throw new IllegalArgumentException();
            }
        }

        public long getItemId(int i) {
            return (long) i;
        }

        public int getItemViewType(int i) {
            return (this.f2018f && i == getCount() - 1) ? 1 : 0;
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            switch (getItemViewType(i)) {
                case 0:
                    if (view == null || view.getId() != C0688f.list_item) {
                        view = LayoutInflater.from(this.f2013a.getContext()).inflate(C0690h.abc_activity_chooser_view_list_item, viewGroup, false);
                    }
                    PackageManager packageManager = this.f2013a.getContext().getPackageManager();
                    ResolveInfo resolveInfo = (ResolveInfo) getItem(i);
                    ((ImageView) view.findViewById(C0688f.icon)).setImageDrawable(resolveInfo.loadIcon(packageManager));
                    ((TextView) view.findViewById(C0688f.title)).setText(resolveInfo.loadLabel(packageManager));
                    if (this.f2016d && i == 0 && this.f2017e) {
                        ag.m2530c(view, true);
                        return view;
                    }
                    ag.m2530c(view, false);
                    return view;
                case 1:
                    if (view != null && view.getId() == 1) {
                        return view;
                    }
                    view = LayoutInflater.from(this.f2013a.getContext()).inflate(C0690h.abc_activity_chooser_view_list_item, viewGroup, false);
                    view.setId(1);
                    ((TextView) view.findViewById(C0688f.title)).setText(this.f2013a.getContext().getString(C0691i.abc_activity_chooser_view_see_all));
                    return view;
                default:
                    throw new IllegalArgumentException();
            }
        }

        public int getViewTypeCount() {
            return 3;
        }
    }

    private class C0757b implements OnClickListener, OnLongClickListener, OnItemClickListener, OnDismissListener {
        final /* synthetic */ ActivityChooserView f2019a;

        private void m4025a() {
            if (this.f2019a.f2031l != null) {
                this.f2019a.f2031l.onDismiss();
            }
        }

        public void onClick(View view) {
            if (view == this.f2019a.f2026g) {
                this.f2019a.m4037b();
                Intent b = this.f2019a.f2021b.m4023d().m5367b(this.f2019a.f2021b.m4023d().m5365a(this.f2019a.f2021b.m4021b()));
                if (b != null) {
                    b.addFlags(524288);
                    this.f2019a.getContext().startActivity(b);
                }
            } else if (view == this.f2019a.f2024e) {
                this.f2019a.f2032m = false;
                this.f2019a.m4027a(this.f2019a.f2033n);
            } else {
                throw new IllegalArgumentException();
            }
        }

        public void onDismiss() {
            m4025a();
            if (this.f2019a.f2020a != null) {
                this.f2019a.f2020a.m2784a(false);
            }
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            switch (((C0756a) adapterView.getAdapter()).getItemViewType(i)) {
                case 0:
                    this.f2019a.m4037b();
                    if (!this.f2019a.f2032m) {
                        if (!this.f2019a.f2021b.m4024e()) {
                            i++;
                        }
                        Intent b = this.f2019a.f2021b.m4023d().m5367b(i);
                        if (b != null) {
                            b.addFlags(524288);
                            this.f2019a.getContext().startActivity(b);
                            return;
                        }
                        return;
                    } else if (i > 0) {
                        this.f2019a.f2021b.m4023d().m5369c(i);
                        return;
                    } else {
                        return;
                    }
                case 1:
                    this.f2019a.m4027a(Integer.MAX_VALUE);
                    return;
                default:
                    throw new IllegalArgumentException();
            }
        }

        public boolean onLongClick(View view) {
            if (view == this.f2019a.f2026g) {
                if (this.f2019a.f2021b.getCount() > 0) {
                    this.f2019a.f2032m = true;
                    this.f2019a.m4027a(this.f2019a.f2033n);
                }
                return true;
            }
            throw new IllegalArgumentException();
        }
    }

    private void m4027a(int i) {
        if (this.f2021b.m4023d() == null) {
            throw new IllegalStateException("No data model. Did you call #setDataModel?");
        }
        getViewTreeObserver().addOnGlobalLayoutListener(this.f2029j);
        boolean z = this.f2026g.getVisibility() == 0;
        int c = this.f2021b.m4022c();
        int i2 = z ? 1 : 0;
        if (i == Integer.MAX_VALUE || c <= i2 + i) {
            this.f2021b.m4019a(false);
            this.f2021b.m4017a(i);
        } else {
            this.f2021b.m4019a(true);
            this.f2021b.m4017a(i - 1);
        }
        ap listPopupWindow = getListPopupWindow();
        if (!listPopupWindow.m5069k()) {
            if (this.f2032m || !z) {
                this.f2021b.m4020a(true, z);
            } else {
                this.f2021b.m4020a(false, false);
            }
            listPopupWindow.m5062f(Math.min(this.f2021b.m4016a(), this.f2027h));
            listPopupWindow.mo874c();
            if (this.f2020a != null) {
                this.f2020a.m2784a(true);
            }
            listPopupWindow.m5071m().setContentDescription(getContext().getString(C0691i.abc_activitychooserview_choose_application));
        }
    }

    private ap getListPopupWindow() {
        if (this.f2030k == null) {
            this.f2030k = new ap(getContext());
            this.f2030k.mo872a(this.f2021b);
            this.f2030k.m5049a((View) this);
            this.f2030k.m5053a(true);
            this.f2030k.m5050a(this.f2022c);
            this.f2030k.m5052a(this.f2022c);
        }
        return this.f2030k;
    }

    public boolean m4036a() {
        if (m4038c() || !this.f2034o) {
            return false;
        }
        this.f2032m = false;
        m4027a(this.f2033n);
        return true;
    }

    public boolean m4037b() {
        if (m4038c()) {
            getListPopupWindow().m5067i();
            ViewTreeObserver viewTreeObserver = getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeGlobalOnLayoutListener(this.f2029j);
            }
        }
        return true;
    }

    public boolean m4038c() {
        return getListPopupWindow().m5069k();
    }

    public C0880e getDataModel() {
        return this.f2021b.m4023d();
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        C0880e d = this.f2021b.m4023d();
        if (d != null) {
            d.registerObserver(this.f2028i);
        }
        this.f2034o = true;
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        C0880e d = this.f2021b.m4023d();
        if (d != null) {
            d.unregisterObserver(this.f2028i);
        }
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.removeGlobalOnLayoutListener(this.f2029j);
        }
        if (m4038c()) {
            m4037b();
        }
        this.f2034o = false;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.f2023d.layout(0, 0, i3 - i, i4 - i2);
        if (!m4038c()) {
            m4037b();
        }
    }

    protected void onMeasure(int i, int i2) {
        View view = this.f2023d;
        if (this.f2026g.getVisibility() != 0) {
            i2 = MeasureSpec.makeMeasureSpec(MeasureSpec.getSize(i2), 1073741824);
        }
        measureChild(view, i, i2);
        setMeasuredDimension(view.getMeasuredWidth(), view.getMeasuredHeight());
    }

    public void setActivityChooserModel(C0880e c0880e) {
        this.f2021b.m4018a(c0880e);
        if (m4038c()) {
            m4037b();
            m4036a();
        }
    }

    public void setDefaultActionButtonContentDescription(int i) {
        this.f2035p = i;
    }

    public void setExpandActivityOverflowButtonContentDescription(int i) {
        this.f2025f.setContentDescription(getContext().getString(i));
    }

    public void setExpandActivityOverflowButtonDrawable(Drawable drawable) {
        this.f2025f.setImageDrawable(drawable);
    }

    public void setInitialActivityCount(int i) {
        this.f2033n = i;
    }

    public void setOnDismissListener(OnDismissListener onDismissListener) {
        this.f2031l = onDismissListener;
    }

    public void setProvider(C0503d c0503d) {
        this.f2020a = c0503d;
    }
}
