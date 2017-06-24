package com.daimajia.swipe;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.support.v4.view.C0507e;
import android.support.v4.view.ag;
import android.support.v4.widget.ad;
import android.support.v4.widget.ad.C0064a;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import com.daimajia.swipe.C0944a.C0940a;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class SwipeLayout extends FrameLayout {
    private static final C0932b f2871c = C0932b.Right;
    OnClickListener f2872a;
    OnLongClickListener f2873b;
    private int f2874d;
    private C0932b f2875e;
    private ad f2876f;
    private int f2877g;
    private LinkedHashMap<C0932b, View> f2878h;
    private C0935e f2879i;
    private float[] f2880j;
    private List<C0939i> f2881k;
    private List<C0937g> f2882l;
    private Map<View, ArrayList<C0934d>> f2883m;
    private Map<View, Boolean> f2884n;
    private C0931a f2885o;
    private boolean f2886p;
    private boolean[] f2887q;
    private boolean f2888r;
    private C0064a f2889s;
    private int f2890t;
    private List<C0933c> f2891u;
    private boolean f2892v;
    private float f2893w;
    private float f2894x;
    private Rect f2895y;
    private GestureDetector f2896z;

    class C09271 extends C0064a {
        boolean f2853a = true;
        final /* synthetic */ SwipeLayout f2854b;

        C09271(SwipeLayout swipeLayout) {
            this.f2854b = swipeLayout;
        }

        public int mo67a(View view) {
            return this.f2854b.f2877g;
        }

        public int mo68a(View view, int i, int i2) {
            if (view == this.f2854b.getSurfaceView()) {
                switch (this.f2854b.f2875e) {
                    case Top:
                        return i < this.f2854b.getPaddingTop() ? this.f2854b.getPaddingTop() : i > this.f2854b.getPaddingTop() + this.f2854b.f2877g ? this.f2854b.getPaddingTop() + this.f2854b.f2877g : i;
                    case Bottom:
                        return i < this.f2854b.getPaddingTop() - this.f2854b.f2877g ? this.f2854b.getPaddingTop() - this.f2854b.f2877g : i > this.f2854b.getPaddingTop() ? this.f2854b.getPaddingTop() : i;
                    case Left:
                    case Right:
                        return this.f2854b.getPaddingTop();
                    default:
                        return i;
                }
            }
            View surfaceView = this.f2854b.getSurfaceView();
            int top = surfaceView == null ? 0 : surfaceView.getTop();
            switch (this.f2854b.f2875e) {
                case Top:
                    return this.f2854b.f2879i == C0935e.PullOut ? i > this.f2854b.getPaddingTop() ? this.f2854b.getPaddingTop() : i : top + i2 < this.f2854b.getPaddingTop() ? this.f2854b.getPaddingTop() : top + i2 > this.f2854b.getPaddingTop() + this.f2854b.f2877g ? this.f2854b.getPaddingTop() + this.f2854b.f2877g : i;
                case Bottom:
                    return this.f2854b.f2879i == C0935e.PullOut ? i < this.f2854b.getMeasuredHeight() - this.f2854b.f2877g ? this.f2854b.getMeasuredHeight() - this.f2854b.f2877g : i : top + i2 >= this.f2854b.getPaddingTop() ? this.f2854b.getPaddingTop() : top + i2 <= this.f2854b.getPaddingTop() - this.f2854b.f2877g ? this.f2854b.getPaddingTop() - this.f2854b.f2877g : i;
                case Left:
                case Right:
                    return this.f2854b.getPaddingTop();
                default:
                    return i;
            }
        }

        public void mo70a(View view, float f, float f2) {
            super.mo70a(view, f, f2);
            for (C0939i a : this.f2854b.f2881k) {
                a.mo882a(this.f2854b, f, f2);
            }
            this.f2854b.m5561a(f, f2, this.f2853a);
            this.f2854b.invalidate();
        }

        public void mo71a(View view, int i, int i2, int i3, int i4) {
            View surfaceView = this.f2854b.getSurfaceView();
            if (surfaceView != null) {
                View currentBottomView = this.f2854b.getCurrentBottomView();
                int left = surfaceView.getLeft();
                int right = surfaceView.getRight();
                int top = surfaceView.getTop();
                int bottom = surfaceView.getBottom();
                if (view == surfaceView) {
                    if (this.f2854b.f2879i == C0935e.PullOut && currentBottomView != null) {
                        if (this.f2854b.f2875e == C0932b.Left || this.f2854b.f2875e == C0932b.Right) {
                            currentBottomView.offsetLeftAndRight(i3);
                        } else {
                            currentBottomView.offsetTopAndBottom(i4);
                        }
                    }
                } else if (this.f2854b.getBottomViews().contains(view)) {
                    if (this.f2854b.f2879i == C0935e.PullOut) {
                        surfaceView.offsetLeftAndRight(i3);
                        surfaceView.offsetTopAndBottom(i4);
                    } else {
                        Rect a = this.f2854b.m5539a(this.f2854b.f2875e);
                        if (currentBottomView != null) {
                            currentBottomView.layout(a.left, a.top, a.right, a.bottom);
                        }
                        int left2 = surfaceView.getLeft() + i3;
                        int top2 = surfaceView.getTop() + i4;
                        if (this.f2854b.f2875e == C0932b.Left && left2 < this.f2854b.getPaddingLeft()) {
                            left2 = this.f2854b.getPaddingLeft();
                        } else if (this.f2854b.f2875e == C0932b.Right && left2 > this.f2854b.getPaddingLeft()) {
                            left2 = this.f2854b.getPaddingLeft();
                        } else if (this.f2854b.f2875e == C0932b.Top && top2 < this.f2854b.getPaddingTop()) {
                            top2 = this.f2854b.getPaddingTop();
                        } else if (this.f2854b.f2875e == C0932b.Bottom && top2 > this.f2854b.getPaddingTop()) {
                            top2 = this.f2854b.getPaddingTop();
                        }
                        surfaceView.layout(left2, top2, this.f2854b.getMeasuredWidth() + left2, this.f2854b.getMeasuredHeight() + top2);
                    }
                }
                this.f2854b.m5571b(left, top, right, bottom);
                this.f2854b.m5562a(left, top, i3, i4);
                this.f2854b.invalidate();
            }
        }

        public boolean mo72a(View view, int i) {
            boolean z = true;
            boolean z2 = view == this.f2854b.getSurfaceView() || this.f2854b.getBottomViews().contains(view);
            if (z2) {
                if (this.f2854b.getOpenStatus() != C0936f.Close) {
                    z = false;
                }
                this.f2853a = z;
            }
            return z2;
        }

        public int mo102b(View view) {
            return this.f2854b.f2877g;
        }

        public int mo73b(View view, int i, int i2) {
            if (view == this.f2854b.getSurfaceView()) {
                switch (this.f2854b.f2875e) {
                    case Top:
                    case Bottom:
                        return this.f2854b.getPaddingLeft();
                    case Left:
                        return i < this.f2854b.getPaddingLeft() ? this.f2854b.getPaddingLeft() : i > this.f2854b.getPaddingLeft() + this.f2854b.f2877g ? this.f2854b.getPaddingLeft() + this.f2854b.f2877g : i;
                    case Right:
                        return i > this.f2854b.getPaddingLeft() ? this.f2854b.getPaddingLeft() : i < this.f2854b.getPaddingLeft() - this.f2854b.f2877g ? this.f2854b.getPaddingLeft() - this.f2854b.f2877g : i;
                    default:
                        return i;
                }
            } else if (this.f2854b.getCurrentBottomView() != view) {
                return i;
            } else {
                switch (this.f2854b.f2875e) {
                    case Top:
                    case Bottom:
                        return this.f2854b.getPaddingLeft();
                    case Left:
                        return (this.f2854b.f2879i != C0935e.PullOut || i <= this.f2854b.getPaddingLeft()) ? i : this.f2854b.getPaddingLeft();
                    case Right:
                        return (this.f2854b.f2879i != C0935e.PullOut || i >= this.f2854b.getMeasuredWidth() - this.f2854b.f2877g) ? i : this.f2854b.getMeasuredWidth() - this.f2854b.f2877g;
                    default:
                        return i;
                }
            }
        }
    }

    class C09282 implements OnClickListener {
        final /* synthetic */ SwipeLayout f2855a;

        C09282(SwipeLayout swipeLayout) {
            this.f2855a = swipeLayout;
        }

        public void onClick(View view) {
            this.f2855a.m5556l();
        }
    }

    class C09293 implements OnLongClickListener {
        final /* synthetic */ SwipeLayout f2856a;

        C09293(SwipeLayout swipeLayout) {
            this.f2856a = swipeLayout;
        }

        public boolean onLongClick(View view) {
            this.f2856a.m5557m();
            return true;
        }
    }

    public interface C0931a {
        void m5528a(SwipeLayout swipeLayout, boolean z);
    }

    public enum C0932b {
        Left,
        Top,
        Right,
        Bottom
    }

    public interface C0933c {
        void mo880a(SwipeLayout swipeLayout);
    }

    public interface C0934d {
        void m5530a(View view, C0932b c0932b, float f, int i);
    }

    public enum C0935e {
        LayDown,
        PullOut
    }

    public enum C0936f {
        Middle,
        Open,
        Close
    }

    public interface C0937g {
        boolean m5531a(MotionEvent motionEvent);
    }

    class C0938h extends SimpleOnGestureListener {
        final /* synthetic */ SwipeLayout f2870a;

        C0938h(SwipeLayout swipeLayout) {
            this.f2870a = swipeLayout;
        }

        public boolean onDoubleTap(MotionEvent motionEvent) {
            if (this.f2870a.f2885o != null) {
                View currentBottomView = this.f2870a.getCurrentBottomView();
                View surfaceView = this.f2870a.getSurfaceView();
                if (currentBottomView == null || motionEvent.getX() <= ((float) currentBottomView.getLeft()) || motionEvent.getX() >= ((float) currentBottomView.getRight()) || motionEvent.getY() <= ((float) currentBottomView.getTop()) || motionEvent.getY() >= ((float) currentBottomView.getBottom())) {
                    currentBottomView = surfaceView;
                }
                this.f2870a.f2885o.m5528a(this.f2870a, currentBottomView == surfaceView);
            }
            return true;
        }

        public boolean onSingleTapUp(MotionEvent motionEvent) {
            if (this.f2870a.f2888r && this.f2870a.m5547b(motionEvent)) {
                this.f2870a.m5580i();
            }
            return super.onSingleTapUp(motionEvent);
        }
    }

    public interface C0939i {
        void mo881a(SwipeLayout swipeLayout);

        void mo882a(SwipeLayout swipeLayout, float f, float f2);

        void mo883a(SwipeLayout swipeLayout, int i, int i2);

        void mo884b(SwipeLayout swipeLayout);

        void mo885c(SwipeLayout swipeLayout);

        void mo886d(SwipeLayout swipeLayout);
    }

    public SwipeLayout(Context context) {
        this(context, null);
    }

    public SwipeLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SwipeLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2875e = f2871c;
        this.f2877g = 0;
        this.f2878h = new LinkedHashMap();
        this.f2880j = new float[4];
        this.f2881k = new ArrayList();
        this.f2882l = new ArrayList();
        this.f2883m = new HashMap();
        this.f2884n = new HashMap();
        this.f2886p = true;
        this.f2887q = new boolean[]{true, true, true, true};
        this.f2888r = false;
        this.f2889s = new C09271(this);
        this.f2890t = 0;
        this.f2893w = -1.0f;
        this.f2894x = -1.0f;
        this.f2896z = new GestureDetector(getContext(), new C0938h(this));
        this.f2876f = ad.m3011a((ViewGroup) this, this.f2889s);
        this.f2874d = ViewConfiguration.get(context).getScaledTouchSlop();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0940a.SwipeLayout);
        int i2 = obtainStyledAttributes.getInt(C0940a.SwipeLayout_drag_edge, 2);
        this.f2880j[C0932b.Left.ordinal()] = obtainStyledAttributes.getDimension(C0940a.SwipeLayout_leftEdgeSwipeOffset, 0.0f);
        this.f2880j[C0932b.Right.ordinal()] = obtainStyledAttributes.getDimension(C0940a.SwipeLayout_rightEdgeSwipeOffset, 0.0f);
        this.f2880j[C0932b.Top.ordinal()] = obtainStyledAttributes.getDimension(C0940a.SwipeLayout_topEdgeSwipeOffset, 0.0f);
        this.f2880j[C0932b.Bottom.ordinal()] = obtainStyledAttributes.getDimension(C0940a.SwipeLayout_bottomEdgeSwipeOffset, 0.0f);
        setClickToClose(obtainStyledAttributes.getBoolean(C0940a.SwipeLayout_clickToClose, this.f2888r));
        if ((i2 & 1) == 1) {
            this.f2878h.put(C0932b.Left, null);
        }
        if ((i2 & 4) == 4) {
            this.f2878h.put(C0932b.Top, null);
        }
        if ((i2 & 2) == 2) {
            this.f2878h.put(C0932b.Right, null);
        }
        if ((i2 & 8) == 8) {
            this.f2878h.put(C0932b.Bottom, null);
        }
        this.f2879i = C0935e.values()[obtainStyledAttributes.getInt(C0940a.SwipeLayout_show_mode, C0935e.PullOut.ordinal())];
        obtainStyledAttributes.recycle();
    }

    private int m5538a(float f) {
        return (int) ((getContext().getResources().getDisplayMetrics().density * f) + 0.5f);
    }

    private Rect m5539a(C0932b c0932b) {
        int i;
        int measuredHeight;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        if (c0932b == C0932b.Right) {
            paddingLeft = getMeasuredWidth() - this.f2877g;
        } else if (c0932b == C0932b.Bottom) {
            paddingTop = getMeasuredHeight() - this.f2877g;
        }
        if (c0932b == C0932b.Left || c0932b == C0932b.Right) {
            i = paddingLeft + this.f2877g;
            measuredHeight = getMeasuredHeight() + paddingTop;
        } else {
            i = paddingLeft + getMeasuredWidth();
            measuredHeight = this.f2877g + paddingTop;
        }
        return new Rect(paddingLeft, paddingTop, i, measuredHeight);
    }

    private Rect m5540a(C0935e c0935e, Rect rect) {
        int i = 0;
        View currentBottomView = getCurrentBottomView();
        int i2 = rect.left;
        int i3 = rect.top;
        int i4 = rect.right;
        int i5 = rect.bottom;
        int i6;
        if (c0935e == C0935e.PullOut) {
            if (this.f2875e == C0932b.Left) {
                i2 = rect.left - this.f2877g;
            } else if (this.f2875e == C0932b.Right) {
                i2 = rect.right;
            } else {
                i3 = this.f2875e == C0932b.Top ? rect.top - this.f2877g : rect.bottom;
            }
            if (this.f2875e == C0932b.Left || this.f2875e == C0932b.Right) {
                i5 = rect.bottom;
                if (currentBottomView != null) {
                    i = currentBottomView.getMeasuredWidth();
                }
                i6 = i5;
                i5 = i2;
                i2 = i + i2;
                i = i3;
                i3 = i6;
            } else {
                if (currentBottomView != null) {
                    i = currentBottomView.getMeasuredHeight();
                }
                i6 = i + i3;
                i = i3;
                i3 = i6;
                i5 = i2;
                i2 = rect.right;
            }
        } else if (c0935e != C0935e.LayDown) {
            i = i3;
            i3 = i5;
            i5 = i2;
            i2 = i4;
        } else if (this.f2875e == C0932b.Left) {
            i6 = i5;
            i5 = i2;
            i2 = this.f2877g + i2;
            i = i3;
            i3 = i6;
        } else if (this.f2875e == C0932b.Right) {
            i = i3;
            i3 = i5;
            i5 = i4 - this.f2877g;
            i2 = i4;
        } else if (this.f2875e == C0932b.Top) {
            i5 = i2;
            i2 = i4;
            i6 = i3;
            i3 = this.f2877g + i3;
            i = i6;
        } else {
            i = i5 - this.f2877g;
            i3 = i5;
            i5 = i2;
            i2 = i4;
        }
        return new Rect(i5, i, i2, i3);
    }

    private Rect m5542a(boolean z) {
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        if (z) {
            if (this.f2875e == C0932b.Left) {
                paddingLeft = getPaddingLeft() + this.f2877g;
            } else if (this.f2875e == C0932b.Right) {
                paddingLeft = getPaddingLeft() - this.f2877g;
            } else {
                paddingTop = this.f2875e == C0932b.Top ? getPaddingTop() + this.f2877g : getPaddingTop() - this.f2877g;
            }
        }
        return new Rect(paddingLeft, paddingTop, getMeasuredWidth() + paddingLeft, getMeasuredHeight() + paddingTop);
    }

    private void m5544a(MotionEvent motionEvent) {
        boolean z = true;
        if (!this.f2892v) {
            if (getOpenStatus() == C0936f.Middle) {
                this.f2892v = true;
                return;
            }
            boolean z2;
            boolean z3;
            C0936f openStatus = getOpenStatus();
            float rawX = motionEvent.getRawX() - this.f2893w;
            float rawY = motionEvent.getRawY() - this.f2894x;
            float toDegrees = (float) Math.toDegrees(Math.atan((double) Math.abs(rawY / rawX)));
            if (getOpenStatus() == C0936f.Close) {
                C0932b c0932b;
                if (toDegrees < 45.0f) {
                    if (rawX > 0.0f && m5575d()) {
                        c0932b = C0932b.Left;
                    } else if (rawX < 0.0f && m5576e()) {
                        c0932b = C0932b.Right;
                    } else {
                        return;
                    }
                } else if (rawY > 0.0f && m5577f()) {
                    c0932b = C0932b.Top;
                } else if (rawY < 0.0f && m5578g()) {
                    c0932b = C0932b.Bottom;
                } else {
                    return;
                }
                setCurrentDragEdge(c0932b);
            }
            if (this.f2875e == C0932b.Right) {
                z2 = (openStatus == C0936f.Open && rawX > ((float) this.f2874d)) || (openStatus == C0936f.Close && rawX < ((float) (-this.f2874d)));
                z2 = z2 || openStatus == C0936f.Middle;
                if (toDegrees > 30.0f || !z2) {
                    z2 = true;
                    if (this.f2875e == C0932b.Left) {
                        z3 = (openStatus != C0936f.Open && rawX < ((float) (-this.f2874d))) || (openStatus == C0936f.Close && rawX > ((float) this.f2874d));
                        z3 = z3 || openStatus == C0936f.Middle;
                        if (toDegrees > 30.0f || !z3) {
                            z2 = true;
                        }
                    }
                    if (this.f2875e == C0932b.Top) {
                        z3 = (openStatus != C0936f.Open && rawY < ((float) (-this.f2874d))) || (openStatus == C0936f.Close && rawY > ((float) this.f2874d));
                        z3 = z3 || openStatus == C0936f.Middle;
                        if (toDegrees < 60.0f || !z3) {
                            z2 = true;
                        }
                    }
                    if (this.f2875e == C0932b.Bottom) {
                        z3 = (openStatus != C0936f.Open && rawY > ((float) this.f2874d)) || (openStatus == C0936f.Close && rawY < ((float) (-this.f2874d)));
                        z3 = z3 || openStatus == C0936f.Middle;
                        if (toDegrees < 60.0f || !z3) {
                            z2 = true;
                        }
                    }
                    if (z2) {
                        z = false;
                    }
                    this.f2892v = z;
                }
            }
            z2 = false;
            if (this.f2875e == C0932b.Left) {
                if (openStatus != C0936f.Open) {
                }
                if (!z3) {
                }
                z2 = true;
            }
            if (this.f2875e == C0932b.Top) {
                if (openStatus != C0936f.Open) {
                }
                if (!z3) {
                }
                z2 = true;
            }
            if (this.f2875e == C0932b.Bottom) {
                if (openStatus != C0936f.Open) {
                }
                if (!z3) {
                }
                z2 = true;
            }
            if (z2) {
                z = false;
            }
            this.f2892v = z;
        }
    }

    private boolean m5547b(MotionEvent motionEvent) {
        View surfaceView = getSurfaceView();
        if (surfaceView == null) {
            return false;
        }
        if (this.f2895y == null) {
            this.f2895y = new Rect();
        }
        surfaceView.getHitRect(this.f2895y);
        return this.f2895y.contains((int) motionEvent.getX(), (int) motionEvent.getY());
    }

    private AdapterView getAdapterView() {
        ViewParent parent = getParent();
        return parent instanceof AdapterView ? (AdapterView) parent : null;
    }

    private float getCurrentOffset() {
        return this.f2875e == null ? 0.0f : this.f2880j[this.f2875e.ordinal()];
    }

    private void m5554j() {
        C0936f openStatus = getOpenStatus();
        List<View> bottomViews = getBottomViews();
        View currentBottomView;
        if (openStatus == C0936f.Close) {
            for (View currentBottomView2 : bottomViews) {
                if (!(currentBottomView2 == null || currentBottomView2.getVisibility() == 4)) {
                    currentBottomView2.setVisibility(4);
                }
            }
            return;
        }
        currentBottomView2 = getCurrentBottomView();
        if (currentBottomView2 != null && currentBottomView2.getVisibility() != 0) {
            currentBottomView2.setVisibility(0);
        }
    }

    private boolean m5555k() {
        return getAdapterView() != null;
    }

    private void m5556l() {
        if (getOpenStatus() == C0936f.Close) {
            ViewParent parent = getParent();
            if (parent instanceof AdapterView) {
                AdapterView adapterView = (AdapterView) parent;
                int positionForView = adapterView.getPositionForView(this);
                if (positionForView != -1) {
                    adapterView.performItemClick(adapterView.getChildAt(positionForView - adapterView.getFirstVisiblePosition()), positionForView, adapterView.getAdapter().getItemId(positionForView));
                }
            }
        }
    }

    private boolean m5557m() {
        if (getOpenStatus() != C0936f.Close) {
            return false;
        }
        ViewParent parent = getParent();
        if (!(parent instanceof AdapterView)) {
            return false;
        }
        AdapterView adapterView = (AdapterView) parent;
        int positionForView = adapterView.getPositionForView(this);
        if (positionForView == -1) {
            return false;
        }
        long itemIdAtPosition = adapterView.getItemIdAtPosition(positionForView);
        try {
            Method declaredMethod = AbsListView.class.getDeclaredMethod("performLongPress", new Class[]{View.class, Integer.TYPE, Long.TYPE});
            declaredMethod.setAccessible(true);
            return ((Boolean) declaredMethod.invoke(adapterView, new Object[]{this, Integer.valueOf(positionForView), Long.valueOf(itemIdAtPosition)})).booleanValue();
        } catch (Exception e) {
            e.printStackTrace();
            boolean onItemLongClick = adapterView.getOnItemLongClickListener() != null ? adapterView.getOnItemLongClickListener().onItemLongClick(adapterView, this, positionForView, itemIdAtPosition) : false;
            if (!onItemLongClick) {
                return onItemLongClick;
            }
            adapterView.performHapticFeedback(0);
            return onItemLongClick;
        }
    }

    private void m5558n() {
        View currentBottomView = getCurrentBottomView();
        if (currentBottomView != null) {
            if (this.f2875e == C0932b.Left || this.f2875e == C0932b.Right) {
                this.f2877g = currentBottomView.getMeasuredWidth() - m5538a(getCurrentOffset());
            } else {
                this.f2877g = currentBottomView.getMeasuredHeight() - m5538a(getCurrentOffset());
            }
        }
        if (this.f2879i == C0935e.PullOut) {
            m5560a();
        } else if (this.f2879i == C0935e.LayDown) {
            m5570b();
        }
        m5554j();
    }

    private void setCurrentDragEdge(C0932b c0932b) {
        if (this.f2875e != c0932b) {
            this.f2875e = c0932b;
            m5558n();
        }
    }

    protected Rect m5559a(View view) {
        Rect rect = new Rect(view.getLeft(), view.getTop(), 0, 0);
        View view2 = view;
        while (view2.getParent() != null && view2 != getRootView()) {
            view2 = (View) view2.getParent();
            if (view2 == this) {
                break;
            }
            rect.left += view2.getLeft();
            rect.top += view2.getTop();
        }
        rect.right = rect.left + view.getMeasuredWidth();
        rect.bottom = rect.top + view.getMeasuredHeight();
        return rect;
    }

    void m5560a() {
        Rect a = m5542a(false);
        View surfaceView = getSurfaceView();
        if (surfaceView != null) {
            surfaceView.layout(a.left, a.top, a.right, a.bottom);
            bringChildToFront(surfaceView);
        }
        a = m5540a(C0935e.PullOut, a);
        surfaceView = getCurrentBottomView();
        if (surfaceView != null) {
            surfaceView.layout(a.left, a.top, a.right, a.bottom);
        }
    }

    protected void m5561a(float f, float f2, boolean z) {
        float a = this.f2876f.m3027a();
        View surfaceView = getSurfaceView();
        C0932b c0932b = this.f2875e;
        if (c0932b != null && surfaceView != null) {
            float f3 = z ? 0.25f : 0.75f;
            if (c0932b == C0932b.Left) {
                if (f > a) {
                    m5579h();
                } else if (f < (-a)) {
                    m5580i();
                } else if ((((float) getSurfaceView().getLeft()) * 1.0f) / ((float) this.f2877g) > f3) {
                    m5579h();
                } else {
                    m5580i();
                }
            } else if (c0932b == C0932b.Right) {
                if (f > a) {
                    m5580i();
                } else if (f < (-a)) {
                    m5579h();
                } else if ((((float) (-getSurfaceView().getLeft())) * 1.0f) / ((float) this.f2877g) > f3) {
                    m5579h();
                } else {
                    m5580i();
                }
            } else if (c0932b == C0932b.Top) {
                if (f2 > a) {
                    m5579h();
                } else if (f2 < (-a)) {
                    m5580i();
                } else if ((((float) getSurfaceView().getTop()) * 1.0f) / ((float) this.f2877g) > f3) {
                    m5579h();
                } else {
                    m5580i();
                }
            } else if (c0932b != C0932b.Bottom) {
            } else {
                if (f2 > a) {
                    m5580i();
                } else if (f2 < (-a)) {
                    m5579h();
                } else if ((((float) (-getSurfaceView().getTop())) * 1.0f) / ((float) this.f2877g) > f3) {
                    m5579h();
                } else {
                    m5580i();
                }
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected void m5562a(int r5, int r6, int r7, int r8) {
        /*
        r4 = this;
        r0 = 0;
        r2 = r4.getDragEdge();
        r1 = 1;
        r3 = com.daimajia.swipe.SwipeLayout.C0932b.Left;
        if (r2 != r3) goto L_0x0010;
    L_0x000a:
        if (r7 >= 0) goto L_0x0016;
    L_0x000c:
        r4.m5563a(r5, r6, r0);
        return;
    L_0x0010:
        r3 = com.daimajia.swipe.SwipeLayout.C0932b.Right;
        if (r2 != r3) goto L_0x0018;
    L_0x0014:
        if (r7 > 0) goto L_0x000c;
    L_0x0016:
        r0 = r1;
        goto L_0x000c;
    L_0x0018:
        r3 = com.daimajia.swipe.SwipeLayout.C0932b.Top;
        if (r2 != r3) goto L_0x001f;
    L_0x001c:
        if (r8 >= 0) goto L_0x0016;
    L_0x001e:
        goto L_0x000c;
    L_0x001f:
        r3 = com.daimajia.swipe.SwipeLayout.C0932b.Bottom;
        if (r2 != r3) goto L_0x0016;
    L_0x0023:
        if (r8 <= 0) goto L_0x0016;
    L_0x0025:
        goto L_0x000c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.daimajia.swipe.SwipeLayout.a(int, int, int, int):void");
    }

    protected void m5563a(int i, int i2, boolean z) {
        m5554j();
        C0936f openStatus = getOpenStatus();
        if (!this.f2881k.isEmpty()) {
            this.f2890t++;
            for (C0939i c0939i : this.f2881k) {
                if (this.f2890t == 1) {
                    if (z) {
                        c0939i.mo881a(this);
                    } else {
                        c0939i.mo885c(this);
                    }
                }
                c0939i.mo883a(this, i - getPaddingLeft(), i2 - getPaddingTop());
            }
            if (openStatus == C0936f.Close) {
                for (C0939i c0939i2 : this.f2881k) {
                    c0939i2.mo886d(this);
                }
                this.f2890t = 0;
            }
            if (openStatus == C0936f.Open) {
                View currentBottomView = getCurrentBottomView();
                if (currentBottomView != null) {
                    currentBottomView.setEnabled(true);
                }
                for (C0939i c0939i22 : this.f2881k) {
                    c0939i22.mo884b(this);
                }
                this.f2890t = 0;
            }
        }
    }

    public void m5564a(C0932b c0932b, View view) {
        m5565a(c0932b, view, null);
    }

    public void m5565a(C0932b c0932b, View view, LayoutParams layoutParams) {
        int i;
        if (layoutParams == null) {
            layoutParams = generateDefaultLayoutParams();
        }
        LayoutParams generateLayoutParams = !checkLayoutParams(layoutParams) ? generateLayoutParams(layoutParams) : layoutParams;
        switch (c0932b) {
            case Top:
                i = 48;
                break;
            case Bottom:
                i = 80;
                break;
            case Left:
                i = 3;
                break;
            case Right:
                i = 5;
                break;
            default:
                i = -1;
                break;
        }
        if (generateLayoutParams instanceof FrameLayout.LayoutParams) {
            ((FrameLayout.LayoutParams) generateLayoutParams).gravity = i;
        }
        addView(view, 0, generateLayoutParams);
    }

    public void m5566a(C0933c c0933c) {
        if (this.f2891u == null) {
            this.f2891u = new ArrayList();
        }
        this.f2891u.add(c0933c);
    }

    public void m5567a(C0939i c0939i) {
        this.f2881k.add(c0939i);
    }

    public void m5568a(boolean z, boolean z2) {
        View surfaceView = getSurfaceView();
        View currentBottomView = getCurrentBottomView();
        if (surfaceView != null) {
            Rect a = m5542a(true);
            if (z) {
                this.f2876f.m3032a(surfaceView, a.left, a.top);
            } else {
                int left = a.left - surfaceView.getLeft();
                int top = a.top - surfaceView.getTop();
                surfaceView.layout(a.left, a.top, a.right, a.bottom);
                if (getShowMode() == C0935e.PullOut) {
                    Rect a2 = m5540a(C0935e.PullOut, a);
                    if (currentBottomView != null) {
                        currentBottomView.layout(a2.left, a2.top, a2.right, a2.bottom);
                    }
                }
                if (z2) {
                    m5571b(a.left, a.top, a.right, a.bottom);
                    m5562a(a.left, a.top, left, top);
                } else {
                    m5554j();
                }
            }
            invalidate();
        }
    }

    protected boolean m5569a(View view, Rect rect, C0932b c0932b, int i, int i2, int i3, int i4) {
        if (((Boolean) this.f2884n.get(view)).booleanValue()) {
            return false;
        }
        boolean z;
        int i5 = rect.left;
        int i6 = rect.right;
        int i7 = rect.top;
        int i8 = rect.bottom;
        if (getShowMode() == C0935e.LayDown) {
            if ((c0932b == C0932b.Right && i3 <= i5) || ((c0932b == C0932b.Left && i >= i6) || ((c0932b == C0932b.Top && i2 >= i8) || (c0932b == C0932b.Bottom && i4 <= i7)))) {
                z = true;
            }
            z = false;
        } else {
            if (getShowMode() == C0935e.PullOut && ((c0932b == C0932b.Right && i6 <= getWidth()) || ((c0932b == C0932b.Left && i5 >= getPaddingLeft()) || ((c0932b == C0932b.Top && i7 >= getPaddingTop()) || (c0932b == C0932b.Bottom && i8 <= getHeight()))))) {
                z = true;
            }
            z = false;
        }
        return z;
    }

    public void addView(View view, int i, LayoutParams layoutParams) {
        int intValue;
        try {
            intValue = ((Integer) layoutParams.getClass().getField("gravity").get(layoutParams)).intValue();
        } catch (Exception e) {
            e.printStackTrace();
            intValue = 0;
        }
        if (intValue <= 0) {
            for (Entry entry : this.f2878h.entrySet()) {
                if (entry.getValue() == null) {
                    this.f2878h.put(entry.getKey(), view);
                    break;
                }
            }
        }
        intValue = C0507e.m2796a(intValue, ag.m2540h(this));
        if ((intValue & 3) == 3) {
            this.f2878h.put(C0932b.Left, view);
        }
        if ((intValue & 5) == 5) {
            this.f2878h.put(C0932b.Right, view);
        }
        if ((intValue & 48) == 48) {
            this.f2878h.put(C0932b.Top, view);
        }
        if ((intValue & 80) == 80) {
            this.f2878h.put(C0932b.Bottom, view);
        }
        if (view != null && view.getParent() != this) {
            super.addView(view, i, layoutParams);
        }
    }

    void m5570b() {
        Rect a = m5542a(false);
        View surfaceView = getSurfaceView();
        if (surfaceView != null) {
            surfaceView.layout(a.left, a.top, a.right, a.bottom);
            bringChildToFront(surfaceView);
        }
        a = m5540a(C0935e.LayDown, a);
        surfaceView = getCurrentBottomView();
        if (surfaceView != null) {
            surfaceView.layout(a.left, a.top, a.right, a.bottom);
        }
    }

    protected void m5571b(int i, int i2, int i3, int i4) {
        if (!this.f2883m.isEmpty()) {
            for (Entry entry : this.f2883m.entrySet()) {
                View view = (View) entry.getKey();
                Rect a = m5559a(view);
                if (m5573b(view, a, this.f2875e, i, i2, i3, i4)) {
                    int i5;
                    float f;
                    this.f2884n.put(view, Boolean.valueOf(false));
                    int i6 = 0;
                    float f2 = 0.0f;
                    if (getShowMode() == C0935e.LayDown) {
                        switch (this.f2875e) {
                            case Top:
                                i6 = a.top - i2;
                                f2 = ((float) i6) / ((float) view.getHeight());
                                break;
                            case Bottom:
                                i6 = a.bottom - i4;
                                f2 = ((float) i6) / ((float) view.getHeight());
                                break;
                            case Left:
                                i6 = a.left - i;
                                f2 = ((float) i6) / ((float) view.getWidth());
                                break;
                            case Right:
                                i6 = a.right - i3;
                                f2 = ((float) i6) / ((float) view.getWidth());
                                break;
                        }
                        i5 = i6;
                        f = f2;
                    } else {
                        if (getShowMode() == C0935e.PullOut) {
                            switch (this.f2875e) {
                                case Top:
                                    i6 = a.bottom - getPaddingTop();
                                    i5 = i6;
                                    f = ((float) i6) / ((float) view.getHeight());
                                    break;
                                case Bottom:
                                    i6 = a.top - getHeight();
                                    i5 = i6;
                                    f = ((float) i6) / ((float) view.getHeight());
                                    break;
                                case Left:
                                    i6 = a.right - getPaddingLeft();
                                    i5 = i6;
                                    f = ((float) i6) / ((float) view.getWidth());
                                    break;
                                case Right:
                                    i6 = a.left - getWidth();
                                    i5 = i6;
                                    f = ((float) i6) / ((float) view.getWidth());
                                    break;
                            }
                        }
                        i5 = 0;
                        f = 0.0f;
                    }
                    Iterator it = ((ArrayList) entry.getValue()).iterator();
                    while (it.hasNext()) {
                        ((C0934d) it.next()).m5530a(view, this.f2875e, Math.abs(f), i5);
                        if (Math.abs(f) == 1.0f) {
                            this.f2884n.put(view, Boolean.valueOf(true));
                        }
                    }
                }
                if (m5569a(view, a, this.f2875e, i, i2, i3, i4)) {
                    this.f2884n.put(view, Boolean.valueOf(true));
                    Iterator it2 = ((ArrayList) entry.getValue()).iterator();
                    while (it2.hasNext()) {
                        C0934d c0934d = (C0934d) it2.next();
                        if (this.f2875e == C0932b.Left || this.f2875e == C0932b.Right) {
                            c0934d.m5530a(view, this.f2875e, 1.0f, view.getWidth());
                        } else {
                            c0934d.m5530a(view, this.f2875e, 1.0f, view.getHeight());
                        }
                    }
                }
            }
        }
    }

    public void m5572b(boolean z, boolean z2) {
        View surfaceView = getSurfaceView();
        if (surfaceView != null) {
            if (z) {
                this.f2876f.m3032a(getSurfaceView(), getPaddingLeft(), getPaddingTop());
            } else {
                Rect a = m5542a(false);
                int left = a.left - surfaceView.getLeft();
                int top = a.top - surfaceView.getTop();
                surfaceView.layout(a.left, a.top, a.right, a.bottom);
                if (z2) {
                    m5571b(a.left, a.top, a.right, a.bottom);
                    m5562a(a.left, a.top, left, top);
                } else {
                    m5554j();
                }
            }
            invalidate();
        }
    }

    protected boolean m5573b(View view, Rect rect, C0932b c0932b, int i, int i2, int i3, int i4) {
        int i5 = rect.left;
        int i6 = rect.right;
        int i7 = rect.top;
        int i8 = rect.bottom;
        if (getShowMode() != C0935e.LayDown) {
            if (getShowMode() == C0935e.PullOut) {
                switch (c0932b) {
                    case Top:
                        if (i7 < getPaddingTop() && i8 >= getPaddingTop()) {
                            return true;
                        }
                    case Bottom:
                        if (i7 < getHeight() && i7 >= getPaddingTop()) {
                            return true;
                        }
                    case Left:
                        if (i6 >= getPaddingLeft() && i5 < getPaddingLeft()) {
                            return true;
                        }
                    case Right:
                        if (i5 <= getWidth() && i6 > getWidth()) {
                            return true;
                        }
                    default:
                        break;
                }
            }
        }
        switch (c0932b) {
            case Top:
                if (i2 >= i7 && i2 < i8) {
                    return true;
                }
            case Bottom:
                if (i4 > i7 && i4 <= i8) {
                    return true;
                }
            case Left:
                if (i < i6 && i >= i5) {
                    return true;
                }
            case Right:
                if (i3 > i5 && i3 <= i6) {
                    return true;
                }
        }
        return false;
    }

    public boolean m5574c() {
        return this.f2886p;
    }

    public void computeScroll() {
        super.computeScroll();
        if (this.f2876f.m3033a(true)) {
            ag.m2532d(this);
        }
    }

    public boolean m5575d() {
        View view = (View) this.f2878h.get(C0932b.Left);
        return view != null && view.getParent() == this && view != getSurfaceView() && this.f2887q[C0932b.Left.ordinal()];
    }

    public boolean m5576e() {
        View view = (View) this.f2878h.get(C0932b.Right);
        return view != null && view.getParent() == this && view != getSurfaceView() && this.f2887q[C0932b.Right.ordinal()];
    }

    public boolean m5577f() {
        View view = (View) this.f2878h.get(C0932b.Top);
        return view != null && view.getParent() == this && view != getSurfaceView() && this.f2887q[C0932b.Top.ordinal()];
    }

    public boolean m5578g() {
        View view = (View) this.f2878h.get(C0932b.Bottom);
        return view != null && view.getParent() == this && view != getSurfaceView() && this.f2887q[C0932b.Bottom.ordinal()];
    }

    public List<View> getBottomViews() {
        List arrayList = new ArrayList();
        for (Object obj : C0932b.values()) {
            arrayList.add(this.f2878h.get(obj));
        }
        return arrayList;
    }

    public View getCurrentBottomView() {
        List bottomViews = getBottomViews();
        return this.f2875e.ordinal() < bottomViews.size() ? (View) bottomViews.get(this.f2875e.ordinal()) : null;
    }

    public int getDragDistance() {
        return this.f2877g;
    }

    public C0932b getDragEdge() {
        return this.f2875e;
    }

    public Map<C0932b, View> getDragEdgeMap() {
        return this.f2878h;
    }

    @Deprecated
    public List<C0932b> getDragEdges() {
        return new ArrayList(this.f2878h.keySet());
    }

    public C0936f getOpenStatus() {
        View surfaceView = getSurfaceView();
        if (surfaceView == null) {
            return C0936f.Close;
        }
        int left = surfaceView.getLeft();
        int top = surfaceView.getTop();
        return (left == getPaddingLeft() && top == getPaddingTop()) ? C0936f.Close : (left == getPaddingLeft() - this.f2877g || left == getPaddingLeft() + this.f2877g || top == getPaddingTop() - this.f2877g || top == getPaddingTop() + this.f2877g) ? C0936f.Open : C0936f.Middle;
    }

    public C0935e getShowMode() {
        return this.f2879i;
    }

    public View getSurfaceView() {
        return getChildCount() == 0 ? null : getChildAt(getChildCount() - 1);
    }

    public void m5579h() {
        m5568a(true, true);
    }

    public void m5580i() {
        m5572b(true, true);
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (m5555k()) {
            if (this.f2872a == null) {
                setOnClickListener(new C09282(this));
            }
            if (this.f2873b == null) {
                setOnLongClickListener(new C09293(this));
            }
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!m5574c()) {
            return false;
        }
        if (this.f2888r && getOpenStatus() == C0936f.Open && m5547b(motionEvent)) {
            return true;
        }
        for (C0937g c0937g : this.f2882l) {
            if (c0937g != null && c0937g.m5531a(motionEvent)) {
                return false;
            }
        }
        switch (motionEvent.getAction()) {
            case 0:
                this.f2876f.m3036b(motionEvent);
                this.f2892v = false;
                this.f2893w = motionEvent.getRawX();
                this.f2894x = motionEvent.getRawY();
                if (getOpenStatus() == C0936f.Middle) {
                    this.f2892v = true;
                    break;
                }
                break;
            case 1:
            case 3:
                this.f2892v = false;
                this.f2876f.m3036b(motionEvent);
                break;
            case 2:
                boolean z = this.f2892v;
                m5544a(motionEvent);
                if (this.f2892v) {
                    ViewParent parent = getParent();
                    if (parent != null) {
                        parent.requestDisallowInterceptTouchEvent(true);
                    }
                }
                if (!z && this.f2892v) {
                    return false;
                }
            default:
                this.f2876f.m3036b(motionEvent);
                break;
        }
        return this.f2892v;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        m5558n();
        if (this.f2891u != null) {
            for (int i5 = 0; i5 < this.f2891u.size(); i5++) {
                ((C0933c) this.f2891u.get(i5)).mo880a(this);
            }
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!m5574c()) {
            return super.onTouchEvent(motionEvent);
        }
        int actionMasked = motionEvent.getActionMasked();
        this.f2896z.onTouchEvent(motionEvent);
        switch (actionMasked) {
            case 0:
                this.f2876f.m3036b(motionEvent);
                this.f2893w = motionEvent.getRawX();
                this.f2894x = motionEvent.getRawY();
                break;
            case 1:
            case 3:
                this.f2892v = false;
                this.f2876f.m3036b(motionEvent);
                break;
            case 2:
                break;
            default:
                this.f2876f.m3036b(motionEvent);
                break;
        }
        m5544a(motionEvent);
        if (this.f2892v) {
            getParent().requestDisallowInterceptTouchEvent(true);
            this.f2876f.m3036b(motionEvent);
        }
        return super.onTouchEvent(motionEvent) || this.f2892v || actionMasked == 0;
    }

    protected void onViewRemoved(View view) {
        for (Entry entry : new HashMap(this.f2878h).entrySet()) {
            if (entry.getValue() == view) {
                this.f2878h.remove(entry.getKey());
            }
        }
    }

    public void setBottomSwipeEnabled(boolean z) {
        this.f2887q[C0932b.Bottom.ordinal()] = z;
    }

    public void setClickToClose(boolean z) {
        this.f2888r = z;
    }

    public void setDragDistance(int i) {
        if (i < 0) {
            i = 0;
        }
        this.f2877g = m5538a((float) i);
        requestLayout();
    }

    @Deprecated
    public void setDragEdge(C0932b c0932b) {
        if (getChildCount() >= 2) {
            this.f2878h.put(c0932b, getChildAt(getChildCount() - 2));
        }
        setCurrentDragEdge(c0932b);
    }

    @Deprecated
    public void setDragEdges(List<C0932b> list) {
        int min = Math.min(list.size(), getChildCount() - 1);
        for (int i = 0; i < min; i++) {
            this.f2878h.put((C0932b) list.get(i), getChildAt(i));
        }
        if (list.size() == 0 || list.contains(f2871c)) {
            setCurrentDragEdge(f2871c);
        } else {
            setCurrentDragEdge((C0932b) list.get(0));
        }
    }

    @Deprecated
    public void setDragEdges(C0932b... c0932bArr) {
        setDragEdges(Arrays.asList(c0932bArr));
    }

    public void setLeftSwipeEnabled(boolean z) {
        this.f2887q[C0932b.Left.ordinal()] = z;
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        super.setOnClickListener(onClickListener);
        this.f2872a = onClickListener;
    }

    public void setOnDoubleClickListener(C0931a c0931a) {
        this.f2885o = c0931a;
    }

    public void setOnLongClickListener(OnLongClickListener onLongClickListener) {
        super.setOnLongClickListener(onLongClickListener);
        this.f2873b = onLongClickListener;
    }

    public void setRightSwipeEnabled(boolean z) {
        this.f2887q[C0932b.Right.ordinal()] = z;
    }

    public void setShowMode(C0935e c0935e) {
        this.f2879i = c0935e;
        requestLayout();
    }

    public void setSwipeEnabled(boolean z) {
        this.f2886p = z;
    }

    public void setTopSwipeEnabled(boolean z) {
        this.f2887q[C0932b.Top.ordinal()] = z;
    }
}
