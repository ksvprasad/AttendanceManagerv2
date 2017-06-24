package android.support.v7.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.p004c.p005a.C0314a;
import android.support.v7.p007d.p008a.C0153a;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.ListView;
import java.lang.reflect.Field;

public class aq extends ListView {
    private static final int[] f2438g = new int[]{0};
    final Rect f2439a = new Rect();
    int f2440b = 0;
    int f2441c = 0;
    int f2442d = 0;
    int f2443e = 0;
    protected int f2444f;
    private Field f2445h;
    private C0849a f2446i;

    private static class C0849a extends C0153a {
        private boolean f2491a = true;

        public C0849a(Drawable drawable) {
            super(drawable);
        }

        void m5072a(boolean z) {
            this.f2491a = z;
        }

        public void draw(Canvas canvas) {
            if (this.f2491a) {
                super.draw(canvas);
            }
        }

        public void setHotspot(float f, float f2) {
            if (this.f2491a) {
                super.setHotspot(f, f2);
            }
        }

        public void setHotspotBounds(int i, int i2, int i3, int i4) {
            if (this.f2491a) {
                super.setHotspotBounds(i, i2, i3, i4);
            }
        }

        public boolean setState(int[] iArr) {
            return this.f2491a ? super.setState(iArr) : false;
        }

        public boolean setVisible(boolean z, boolean z2) {
            return this.f2491a ? super.setVisible(z, z2) : false;
        }
    }

    public aq(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        try {
            this.f2445h = AbsListView.class.getDeclaredField("mIsChildViewEnabled");
            this.f2445h.setAccessible(true);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    public int m5025a(int i, int i2, int i3, int i4, int i5) {
        int listPaddingTop = getListPaddingTop();
        int listPaddingBottom = getListPaddingBottom();
        getListPaddingLeft();
        getListPaddingRight();
        int dividerHeight = getDividerHeight();
        Drawable divider = getDivider();
        ListAdapter adapter = getAdapter();
        if (adapter == null) {
            return listPaddingTop + listPaddingBottom;
        }
        listPaddingBottom += listPaddingTop;
        if (dividerHeight <= 0 || divider == null) {
            dividerHeight = 0;
        }
        int i6 = 0;
        View view = null;
        int i7 = 0;
        int count = adapter.getCount();
        int i8 = 0;
        while (i8 < count) {
            View view2;
            listPaddingTop = adapter.getItemViewType(i8);
            if (listPaddingTop != i7) {
                int i9 = listPaddingTop;
                view2 = null;
                i7 = i9;
            } else {
                view2 = view;
            }
            view = adapter.getView(i8, view2, this);
            LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = generateDefaultLayoutParams();
                view.setLayoutParams(layoutParams);
            }
            view.measure(i, layoutParams.height > 0 ? MeasureSpec.makeMeasureSpec(layoutParams.height, 1073741824) : MeasureSpec.makeMeasureSpec(0, 0));
            view.forceLayout();
            listPaddingTop = (i8 > 0 ? listPaddingBottom + dividerHeight : listPaddingBottom) + view.getMeasuredHeight();
            if (listPaddingTop >= i4) {
                return (i5 < 0 || i8 <= i5 || i6 <= 0 || listPaddingTop == i4) ? i4 : i6;
            } else {
                if (i5 >= 0 && i8 >= i5) {
                    i6 = listPaddingTop;
                }
                i8++;
                listPaddingBottom = listPaddingTop;
            }
        }
        return listPaddingBottom;
    }

    protected void m5026a(int i, View view) {
        boolean z = true;
        Drawable selector = getSelector();
        boolean z2 = (selector == null || i == -1) ? false : true;
        if (z2) {
            selector.setVisible(false, false);
        }
        m5031b(i, view);
        if (z2) {
            Rect rect = this.f2439a;
            float exactCenterX = rect.exactCenterX();
            float exactCenterY = rect.exactCenterY();
            if (getVisibility() != 0) {
                z = false;
            }
            selector.setVisible(z, false);
            C0314a.m1763a(selector, exactCenterX, exactCenterY);
        }
    }

    protected void m5027a(int i, View view, float f, float f2) {
        m5026a(i, view);
        Drawable selector = getSelector();
        if (selector != null && i != -1) {
            C0314a.m1763a(selector, f, f2);
        }
    }

    protected void m5028a(Canvas canvas) {
        if (!this.f2439a.isEmpty()) {
            Drawable selector = getSelector();
            if (selector != null) {
                selector.setBounds(this.f2439a);
                selector.draw(canvas);
            }
        }
    }

    protected boolean mo802a() {
        return false;
    }

    protected void m5030b() {
        Drawable selector = getSelector();
        if (selector != null && m5032c()) {
            selector.setState(getDrawableState());
        }
    }

    protected void m5031b(int i, View view) {
        Rect rect = this.f2439a;
        rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        rect.left -= this.f2440b;
        rect.top -= this.f2441c;
        rect.right += this.f2442d;
        rect.bottom += this.f2443e;
        try {
            boolean z = this.f2445h.getBoolean(this);
            if (view.isEnabled() != z) {
                this.f2445h.set(this, Boolean.valueOf(!z));
                if (i != -1) {
                    refreshDrawableState();
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    protected boolean m5032c() {
        return mo802a() && isPressed();
    }

    protected void dispatchDraw(Canvas canvas) {
        m5028a(canvas);
        super.dispatchDraw(canvas);
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        setSelectorEnabled(true);
        m5030b();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.f2444f = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setSelector(Drawable drawable) {
        this.f2446i = drawable != null ? new C0849a(drawable) : null;
        super.setSelector(this.f2446i);
        Rect rect = new Rect();
        if (drawable != null) {
            drawable.getPadding(rect);
        }
        this.f2440b = rect.left;
        this.f2441c = rect.top;
        this.f2442d = rect.right;
        this.f2443e = rect.bottom;
    }

    protected void setSelectorEnabled(boolean z) {
        if (this.f2446i != null) {
            this.f2446i.m5072a(z);
        }
    }
}
