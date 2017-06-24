package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v4.p014f.C0365f;
import android.support.v4.view.C0543s;
import android.support.v4.view.ag;
import android.support.v4.view.aw;
import android.support.v4.widget.C0579k;
import android.support.v4.widget.C0589o;
import android.support.v7.p019b.C0694a.C0683a;
import android.support.v7.p019b.C0694a.C0693k;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import java.lang.reflect.Method;

public class ap {
    private static Method f2459a;
    private static Method f2460c;
    private final C0844c f2461A;
    private Runnable f2462B;
    private final Handler f2463C;
    private Rect f2464D;
    private boolean f2465E;
    private int f2466F;
    int f2467b;
    private Context f2468d;
    private PopupWindow f2469e;
    private ListAdapter f2470f;
    private C0841a f2471g;
    private int f2472h;
    private int f2473i;
    private int f2474j;
    private int f2475k;
    private int f2476l;
    private boolean f2477m;
    private int f2478n;
    private boolean f2479o;
    private boolean f2480p;
    private View f2481q;
    private int f2482r;
    private DataSetObserver f2483s;
    private View f2484t;
    private Drawable f2485u;
    private OnItemClickListener f2486v;
    private OnItemSelectedListener f2487w;
    private final C0848g f2488x;
    private final C0847f f2489y;
    private final C0846e f2490z;

    public static abstract class C0715b implements OnTouchListener {
        private final float f1760a;
        private final int f1761b;
        private final int f1762c;
        private final View f1763d;
        private Runnable f1764e;
        private Runnable f1765f;
        private boolean f1766g;
        private boolean f1767h;
        private int f1768i;
        private final int[] f1769j = new int[2];

        private class C0842a implements Runnable {
            final /* synthetic */ C0715b f2452a;

            private C0842a(C0715b c0715b) {
                this.f2452a = c0715b;
            }

            public void run() {
                this.f2452a.f1763d.getParent().requestDisallowInterceptTouchEvent(true);
            }
        }

        private class C0843b implements Runnable {
            final /* synthetic */ C0715b f2453a;

            private C0843b(C0715b c0715b) {
                this.f2453a = c0715b;
            }

            public void run() {
                this.f2453a.m3722e();
            }
        }

        public C0715b(View view) {
            this.f1763d = view;
            this.f1760a = (float) ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
            this.f1761b = ViewConfiguration.getTapTimeout();
            this.f1762c = (this.f1761b + ViewConfiguration.getLongPressTimeout()) / 2;
        }

        private boolean m3715a(MotionEvent motionEvent) {
            View view = this.f1763d;
            if (!view.isEnabled()) {
                return false;
            }
            switch (C0543s.m2893a(motionEvent)) {
                case 0:
                    this.f1768i = motionEvent.getPointerId(0);
                    this.f1767h = false;
                    if (this.f1764e == null) {
                        this.f1764e = new C0842a();
                    }
                    view.postDelayed(this.f1764e, (long) this.f1761b);
                    if (this.f1765f == null) {
                        this.f1765f = new C0843b();
                    }
                    view.postDelayed(this.f1765f, (long) this.f1762c);
                    return false;
                case 1:
                case 3:
                    m3721d();
                    return false;
                case 2:
                    int findPointerIndex = motionEvent.findPointerIndex(this.f1768i);
                    if (findPointerIndex < 0 || C0715b.m3716a(view, motionEvent.getX(findPointerIndex), motionEvent.getY(findPointerIndex), this.f1760a)) {
                        return false;
                    }
                    m3721d();
                    view.getParent().requestDisallowInterceptTouchEvent(true);
                    return true;
                default:
                    return false;
            }
        }

        private static boolean m3716a(View view, float f, float f2, float f3) {
            return f >= (-f3) && f2 >= (-f3) && f < ((float) (view.getRight() - view.getLeft())) + f3 && f2 < ((float) (view.getBottom() - view.getTop())) + f3;
        }

        private boolean m3717a(View view, MotionEvent motionEvent) {
            int[] iArr = this.f1769j;
            view.getLocationOnScreen(iArr);
            motionEvent.offsetLocation((float) (-iArr[0]), (float) (-iArr[1]));
            return true;
        }

        private boolean m3719b(MotionEvent motionEvent) {
            boolean z = true;
            View view = this.f1763d;
            ap a = mo620a();
            if (a == null || !a.m5069k()) {
                return false;
            }
            View a2 = a.f2471g;
            if (a2 == null || !a2.isShown()) {
                return false;
            }
            MotionEvent obtainNoHistory = MotionEvent.obtainNoHistory(motionEvent);
            m3720b(view, obtainNoHistory);
            m3717a(a2, obtainNoHistory);
            boolean a3 = a2.m5038a(obtainNoHistory, this.f1768i);
            obtainNoHistory.recycle();
            int a4 = C0543s.m2893a(motionEvent);
            boolean z2 = (a4 == 1 || a4 == 3) ? false : true;
            if (!(a3 && z2)) {
                z = false;
            }
            return z;
        }

        private boolean m3720b(View view, MotionEvent motionEvent) {
            int[] iArr = this.f1769j;
            view.getLocationOnScreen(iArr);
            motionEvent.offsetLocation((float) iArr[0], (float) iArr[1]);
            return true;
        }

        private void m3721d() {
            if (this.f1765f != null) {
                this.f1763d.removeCallbacks(this.f1765f);
            }
            if (this.f1764e != null) {
                this.f1763d.removeCallbacks(this.f1764e);
            }
        }

        private void m3722e() {
            m3721d();
            View view = this.f1763d;
            if (view.isEnabled() && !view.isLongClickable() && mo621b()) {
                view.getParent().requestDisallowInterceptTouchEvent(true);
                long uptimeMillis = SystemClock.uptimeMillis();
                MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                view.onTouchEvent(obtain);
                obtain.recycle();
                this.f1766g = true;
                this.f1767h = true;
            }
        }

        public abstract ap mo620a();

        protected boolean mo621b() {
            ap a = mo620a();
            if (!(a == null || a.m5069k())) {
                a.mo874c();
            }
            return true;
        }

        protected boolean mo858c() {
            ap a = mo620a();
            if (a != null && a.m5069k()) {
                a.m5067i();
            }
            return true;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            boolean b;
            boolean z = this.f1766g;
            if (z) {
                b = this.f1767h ? m3719b(motionEvent) : m3719b(motionEvent) || !mo858c();
            } else {
                boolean z2 = m3715a(motionEvent) && mo621b();
                if (z2) {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                    this.f1763d.onTouchEvent(obtain);
                    obtain.recycle();
                }
                b = z2;
            }
            this.f1766g = b;
            return b || z;
        }
    }

    class C08381 extends C0715b {
        final /* synthetic */ ap f2435a;

        public ap mo620a() {
            return this.f2435a;
        }
    }

    class C08392 implements Runnable {
        final /* synthetic */ ap f2436a;

        C08392(ap apVar) {
            this.f2436a = apVar;
        }

        public void run() {
            View e = this.f2436a.m5059e();
            if (e != null && e.getWindowToken() != null) {
                this.f2436a.mo874c();
            }
        }
    }

    class C08403 implements OnItemSelectedListener {
        final /* synthetic */ ap f2437a;

        C08403(ap apVar) {
            this.f2437a = apVar;
        }

        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
            if (i != -1) {
                C0841a a = this.f2437a.f2471g;
                if (a != null) {
                    a.f2447g = false;
                }
            }
        }

        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    private static class C0841a extends aq {
        private boolean f2447g;
        private boolean f2448h;
        private boolean f2449i;
        private aw f2450j;
        private C0579k f2451k;

        public C0841a(Context context, boolean z) {
            super(context, null, C0683a.dropDownListViewStyle);
            this.f2448h = z;
            setCacheColorHint(0);
        }

        private void m5033a(View view, int i) {
            performItemClick(view, i, getItemIdAtPosition(i));
        }

        private void m5034a(View view, int i, float f, float f2) {
            this.f2449i = true;
            if (VERSION.SDK_INT >= 21) {
                drawableHotspotChanged(f, f2);
            }
            if (!isPressed()) {
                setPressed(true);
            }
            layoutChildren();
            if (this.f != -1) {
                View childAt = getChildAt(this.f - getFirstVisiblePosition());
                if (!(childAt == null || childAt == view || !childAt.isPressed())) {
                    childAt.setPressed(false);
                }
            }
            this.f = i;
            float left = f - ((float) view.getLeft());
            float top = f2 - ((float) view.getTop());
            if (VERSION.SDK_INT >= 21) {
                view.drawableHotspotChanged(left, top);
            }
            if (!view.isPressed()) {
                view.setPressed(true);
            }
            m5027a(i, view, f, f2);
            setSelectorEnabled(false);
            refreshDrawableState();
        }

        private void m5036d() {
            this.f2449i = false;
            setPressed(false);
            drawableStateChanged();
            View childAt = getChildAt(this.f - getFirstVisiblePosition());
            if (childAt != null) {
                childAt.setPressed(false);
            }
            if (this.f2450j != null) {
                this.f2450j.m2734b();
                this.f2450j = null;
            }
        }

        protected boolean mo802a() {
            return this.f2449i || super.mo802a();
        }

        public boolean m5038a(MotionEvent motionEvent, int i) {
            boolean z;
            boolean z2;
            int a = C0543s.m2893a(motionEvent);
            switch (a) {
                case 1:
                    z = false;
                    break;
                case 2:
                    z = true;
                    break;
                case 3:
                    z = false;
                    z2 = false;
                    break;
                default:
                    z = false;
                    z2 = true;
                    break;
            }
            int findPointerIndex = motionEvent.findPointerIndex(i);
            if (findPointerIndex < 0) {
                z = false;
                z2 = false;
            } else {
                int x = (int) motionEvent.getX(findPointerIndex);
                findPointerIndex = (int) motionEvent.getY(findPointerIndex);
                int pointToPosition = pointToPosition(x, findPointerIndex);
                if (pointToPosition == -1) {
                    z2 = z;
                    z = true;
                } else {
                    View childAt = getChildAt(pointToPosition - getFirstVisiblePosition());
                    m5034a(childAt, pointToPosition, (float) x, (float) findPointerIndex);
                    if (a == 1) {
                        m5033a(childAt, pointToPosition);
                    }
                    z = false;
                    z2 = true;
                }
            }
            if (!z2 || r0) {
                m5036d();
            }
            if (z2) {
                if (this.f2451k == null) {
                    this.f2451k = new C0579k(this);
                }
                this.f2451k.m2993a(true);
                this.f2451k.onTouch(this, motionEvent);
            } else if (this.f2451k != null) {
                this.f2451k.m2993a(false);
            }
            return z2;
        }

        public boolean hasFocus() {
            return this.f2448h || super.hasFocus();
        }

        public boolean hasWindowFocus() {
            return this.f2448h || super.hasWindowFocus();
        }

        public boolean isFocused() {
            return this.f2448h || super.isFocused();
        }

        public boolean isInTouchMode() {
            return (this.f2448h && this.f2447g) || super.isInTouchMode();
        }
    }

    private class C0844c implements Runnable {
        final /* synthetic */ ap f2454a;

        private C0844c(ap apVar) {
            this.f2454a = apVar;
        }

        public void run() {
            this.f2454a.m5068j();
        }
    }

    private class C0845d extends DataSetObserver {
        final /* synthetic */ ap f2455a;

        private C0845d(ap apVar) {
            this.f2455a = apVar;
        }

        public void onChanged() {
            if (this.f2455a.m5069k()) {
                this.f2455a.mo874c();
            }
        }

        public void onInvalidated() {
            this.f2455a.m5067i();
        }
    }

    private class C0846e implements OnScrollListener {
        final /* synthetic */ ap f2456a;

        private C0846e(ap apVar) {
            this.f2456a = apVar;
        }

        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }

        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i == 1 && !this.f2456a.m5070l() && this.f2456a.f2469e.getContentView() != null) {
                this.f2456a.f2463C.removeCallbacks(this.f2456a.f2488x);
                this.f2456a.f2488x.run();
            }
        }
    }

    private class C0847f implements OnTouchListener {
        final /* synthetic */ ap f2457a;

        private C0847f(ap apVar) {
            this.f2457a = apVar;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            if (action == 0 && this.f2457a.f2469e != null && this.f2457a.f2469e.isShowing() && x >= 0 && x < this.f2457a.f2469e.getWidth() && y >= 0 && y < this.f2457a.f2469e.getHeight()) {
                this.f2457a.f2463C.postDelayed(this.f2457a.f2488x, 250);
            } else if (action == 1) {
                this.f2457a.f2463C.removeCallbacks(this.f2457a.f2488x);
            }
            return false;
        }
    }

    private class C0848g implements Runnable {
        final /* synthetic */ ap f2458a;

        private C0848g(ap apVar) {
            this.f2458a = apVar;
        }

        public void run() {
            if (this.f2458a.f2471g != null && ag.m2505C(this.f2458a.f2471g) && this.f2458a.f2471g.getCount() > this.f2458a.f2471g.getChildCount() && this.f2458a.f2471g.getChildCount() <= this.f2458a.f2467b) {
                this.f2458a.f2469e.setInputMethodMode(2);
                this.f2458a.mo874c();
            }
        }
    }

    static {
        try {
            f2459a = PopupWindow.class.getDeclaredMethod("setClipToScreenEnabled", new Class[]{Boolean.TYPE});
        } catch (NoSuchMethodException e) {
            Log.i("ListPopupWindow", "Could not find method setClipToScreenEnabled() on PopupWindow. Oh well.");
        }
        try {
            f2460c = PopupWindow.class.getDeclaredMethod("getMaxAvailableHeight", new Class[]{View.class, Integer.TYPE, Boolean.TYPE});
        } catch (NoSuchMethodException e2) {
            Log.i("ListPopupWindow", "Could not find method getMaxAvailableHeight(View, int, boolean) on PopupWindow. Oh well.");
        }
    }

    public ap(Context context) {
        this(context, null, C0683a.listPopupWindowStyle);
    }

    public ap(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public ap(Context context, AttributeSet attributeSet, int i, int i2) {
        this.f2472h = -2;
        this.f2473i = -2;
        this.f2476l = 1002;
        this.f2478n = 0;
        this.f2479o = false;
        this.f2480p = false;
        this.f2467b = Integer.MAX_VALUE;
        this.f2482r = 0;
        this.f2488x = new C0848g();
        this.f2489y = new C0847f();
        this.f2490z = new C0846e();
        this.f2461A = new C0844c();
        this.f2464D = new Rect();
        this.f2468d = context;
        this.f2463C = new Handler(context.getMainLooper());
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0693k.ListPopupWindow, i, i2);
        this.f2474j = obtainStyledAttributes.getDimensionPixelOffset(C0693k.ListPopupWindow_android_dropDownHorizontalOffset, 0);
        this.f2475k = obtainStyledAttributes.getDimensionPixelOffset(C0693k.ListPopupWindow_android_dropDownVerticalOffset, 0);
        if (this.f2475k != 0) {
            this.f2477m = true;
        }
        obtainStyledAttributes.recycle();
        this.f2469e = new C0898s(context, attributeSet, i);
        this.f2469e.setInputMethodMode(1);
        this.f2466F = C0365f.m1860a(this.f2468d.getResources().getConfiguration().locale);
    }

    private int m5039a(View view, int i, boolean z) {
        if (f2460c != null) {
            try {
                return ((Integer) f2460c.invoke(this.f2469e, new Object[]{view, Integer.valueOf(i), Boolean.valueOf(z)})).intValue();
            } catch (Exception e) {
                Log.i("ListPopupWindow", "Could not call getMaxAvailableHeightMethod(View, int, boolean) on PopupWindow. Using the public version.");
            }
        }
        return this.f2469e.getMaxAvailableHeight(view, i);
    }

    private void mo871a() {
        if (this.f2481q != null) {
            ViewParent parent = this.f2481q.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.f2481q);
            }
        }
    }

    private int mo873b() {
        int i;
        int i2;
        int i3;
        int i4;
        boolean z = true;
        LayoutParams layoutParams;
        View view;
        if (this.f2471g == null) {
            Context context = this.f2468d;
            this.f2462B = new C08392(this);
            this.f2471g = new C0841a(context, !this.f2465E);
            if (this.f2485u != null) {
                this.f2471g.setSelector(this.f2485u);
            }
            this.f2471g.setAdapter(this.f2470f);
            this.f2471g.setOnItemClickListener(this.f2486v);
            this.f2471g.setFocusable(true);
            this.f2471g.setFocusableInTouchMode(true);
            this.f2471g.setOnItemSelectedListener(new C08403(this));
            this.f2471g.setOnScrollListener(this.f2490z);
            if (this.f2487w != null) {
                this.f2471g.setOnItemSelectedListener(this.f2487w);
            }
            View view2 = this.f2471g;
            View view3 = this.f2481q;
            if (view3 != null) {
                View linearLayout = new LinearLayout(context);
                linearLayout.setOrientation(1);
                ViewGroup.LayoutParams layoutParams2 = new LayoutParams(-1, 0, 1.0f);
                switch (this.f2482r) {
                    case 0:
                        linearLayout.addView(view3);
                        linearLayout.addView(view2, layoutParams2);
                        break;
                    case 1:
                        linearLayout.addView(view2, layoutParams2);
                        linearLayout.addView(view3);
                        break;
                    default:
                        Log.e("ListPopupWindow", "Invalid hint position " + this.f2482r);
                        break;
                }
                if (this.f2473i >= 0) {
                    i = this.f2473i;
                    i2 = Integer.MIN_VALUE;
                } else {
                    i2 = 0;
                    i = 0;
                }
                view3.measure(MeasureSpec.makeMeasureSpec(i, i2), 0);
                layoutParams = (LayoutParams) view3.getLayoutParams();
                i2 = layoutParams.bottomMargin + (view3.getMeasuredHeight() + layoutParams.topMargin);
                view = linearLayout;
            } else {
                view = view2;
                i2 = 0;
            }
            this.f2469e.setContentView(view);
            i3 = i2;
        } else {
            ViewGroup viewGroup = (ViewGroup) this.f2469e.getContentView();
            view = this.f2481q;
            if (view != null) {
                layoutParams = (LayoutParams) view.getLayoutParams();
                i3 = layoutParams.bottomMargin + (view.getMeasuredHeight() + layoutParams.topMargin);
            } else {
                i3 = 0;
            }
        }
        Drawable background = this.f2469e.getBackground();
        if (background != null) {
            background.getPadding(this.f2464D);
            i2 = this.f2464D.top + this.f2464D.bottom;
            if (this.f2477m) {
                i4 = i2;
            } else {
                this.f2475k = -this.f2464D.top;
                i4 = i2;
            }
        } else {
            this.f2464D.setEmpty();
            i4 = 0;
        }
        if (this.f2469e.getInputMethodMode() != 2) {
            z = false;
        }
        i = m5039a(m5059e(), this.f2475k, z);
        if (this.f2479o || this.f2472h == -1) {
            return i + i4;
        }
        int makeMeasureSpec;
        switch (this.f2473i) {
            case -2:
                makeMeasureSpec = MeasureSpec.makeMeasureSpec(this.f2468d.getResources().getDisplayMetrics().widthPixels - (this.f2464D.left + this.f2464D.right), Integer.MIN_VALUE);
                break;
            case -1:
                makeMeasureSpec = MeasureSpec.makeMeasureSpec(this.f2468d.getResources().getDisplayMetrics().widthPixels - (this.f2464D.left + this.f2464D.right), 1073741824);
                break;
            default:
                makeMeasureSpec = MeasureSpec.makeMeasureSpec(this.f2473i, 1073741824);
                break;
        }
        i2 = this.f2471g.m5025a(makeMeasureSpec, 0, -1, i - i3, -1);
        if (i2 > 0) {
            i3 += i4;
        }
        return i2 + i3;
    }

    private void m5044b(boolean z) {
        if (f2459a != null) {
            try {
                f2459a.invoke(this.f2469e, new Object[]{Boolean.valueOf(z)});
            } catch (Exception e) {
                Log.i("ListPopupWindow", "Could not call setClipToScreenEnabled() on PopupWindow. Oh well.");
            }
        }
    }

    public void m5047a(int i) {
        this.f2482r = i;
    }

    public void m5048a(Drawable drawable) {
        this.f2469e.setBackgroundDrawable(drawable);
    }

    public void m5049a(View view) {
        this.f2484t = view;
    }

    public void m5050a(OnItemClickListener onItemClickListener) {
        this.f2486v = onItemClickListener;
    }

    public void mo872a(ListAdapter listAdapter) {
        if (this.f2483s == null) {
            this.f2483s = new C0845d();
        } else if (this.f2470f != null) {
            this.f2470f.unregisterDataSetObserver(this.f2483s);
        }
        this.f2470f = listAdapter;
        if (this.f2470f != null) {
            listAdapter.registerDataSetObserver(this.f2483s);
        }
        if (this.f2471g != null) {
            this.f2471g.setAdapter(this.f2470f);
        }
    }

    public void m5052a(OnDismissListener onDismissListener) {
        this.f2469e.setOnDismissListener(onDismissListener);
    }

    public void m5053a(boolean z) {
        this.f2465E = z;
        this.f2469e.setFocusable(z);
    }

    public void m5054b(int i) {
        this.f2474j = i;
    }

    public void mo874c() {
        boolean z = true;
        boolean z2 = false;
        int i = -1;
        int b = mo873b();
        boolean l = m5070l();
        C0589o.m3136a(this.f2469e, this.f2476l);
        if (this.f2469e.isShowing()) {
            int i2;
            int width = this.f2473i == -1 ? -1 : this.f2473i == -2 ? m5059e().getWidth() : this.f2473i;
            if (this.f2472h == -1) {
                if (!l) {
                    b = -1;
                }
                if (l) {
                    this.f2469e.setWidth(this.f2473i == -1 ? -1 : 0);
                    this.f2469e.setHeight(0);
                    i2 = b;
                } else {
                    this.f2469e.setWidth(this.f2473i == -1 ? -1 : 0);
                    this.f2469e.setHeight(-1);
                    i2 = b;
                }
            } else {
                i2 = this.f2472h == -2 ? b : this.f2472h;
            }
            PopupWindow popupWindow = this.f2469e;
            if (!(this.f2480p || this.f2479o)) {
                z2 = true;
            }
            popupWindow.setOutsideTouchable(z2);
            popupWindow = this.f2469e;
            View e = m5059e();
            b = this.f2474j;
            int i3 = this.f2475k;
            if (width < 0) {
                width = -1;
            }
            if (i2 >= 0) {
                i = i2;
            }
            popupWindow.update(e, b, i3, width, i);
            return;
        }
        int width2 = this.f2473i == -1 ? -1 : this.f2473i == -2 ? m5059e().getWidth() : this.f2473i;
        if (this.f2472h == -1) {
            b = -1;
        } else if (this.f2472h != -2) {
            b = this.f2472h;
        }
        this.f2469e.setWidth(width2);
        this.f2469e.setHeight(b);
        m5044b(true);
        popupWindow = this.f2469e;
        if (this.f2480p || this.f2479o) {
            z = false;
        }
        popupWindow.setOutsideTouchable(z);
        this.f2469e.setTouchInterceptor(this.f2489y);
        C0589o.m3137a(this.f2469e, m5059e(), this.f2474j, this.f2475k, this.f2478n);
        this.f2471g.setSelection(-1);
        if (!this.f2465E || this.f2471g.isInTouchMode()) {
            m5068j();
        }
        if (!this.f2465E) {
            this.f2463C.post(this.f2461A);
        }
    }

    public void m5056c(int i) {
        this.f2475k = i;
        this.f2477m = true;
    }

    public Drawable m5057d() {
        return this.f2469e.getBackground();
    }

    public void m5058d(int i) {
        this.f2478n = i;
    }

    public View m5059e() {
        return this.f2484t;
    }

    public void m5060e(int i) {
        this.f2473i = i;
    }

    public int m5061f() {
        return this.f2474j;
    }

    public void m5062f(int i) {
        Drawable background = this.f2469e.getBackground();
        if (background != null) {
            background.getPadding(this.f2464D);
            this.f2473i = (this.f2464D.left + this.f2464D.right) + i;
            return;
        }
        m5060e(i);
    }

    public int m5063g() {
        return !this.f2477m ? 0 : this.f2475k;
    }

    public void m5064g(int i) {
        this.f2469e.setInputMethodMode(i);
    }

    public int m5065h() {
        return this.f2473i;
    }

    public void m5066h(int i) {
        C0841a c0841a = this.f2471g;
        if (m5069k() && c0841a != null) {
            c0841a.f2447g = false;
            c0841a.setSelection(i);
            if (VERSION.SDK_INT >= 11 && c0841a.getChoiceMode() != 0) {
                c0841a.setItemChecked(i, true);
            }
        }
    }

    public void m5067i() {
        this.f2469e.dismiss();
        mo871a();
        this.f2469e.setContentView(null);
        this.f2471g = null;
        this.f2463C.removeCallbacks(this.f2488x);
    }

    public void m5068j() {
        C0841a c0841a = this.f2471g;
        if (c0841a != null) {
            c0841a.f2447g = true;
            c0841a.requestLayout();
        }
    }

    public boolean m5069k() {
        return this.f2469e.isShowing();
    }

    public boolean m5070l() {
        return this.f2469e.getInputMethodMode() == 2;
    }

    public ListView m5071m() {
        return this.f2471g;
    }
}
