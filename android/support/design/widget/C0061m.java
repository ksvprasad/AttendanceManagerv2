package android.support.design.widget;

import android.content.Context;
import android.graphics.Rect;
import android.support.design.widget.CoordinatorLayout.C0078e;
import android.support.v4.view.C0507e;
import android.support.v4.view.ag;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import java.util.List;

abstract class C0061m extends aa<View> {
    private final Rect f268a = new Rect();
    private final Rect f269b = new Rect();
    private int f270c = 0;
    private int f271d;

    public C0061m(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private static int m422c(int i) {
        return i == 0 ? 8388659 : i;
    }

    float mo62a(View view) {
        return 1.0f;
    }

    final int m424a() {
        return this.f270c;
    }

    abstract View mo63a(List<View> list);

    public boolean mo54a(CoordinatorLayout coordinatorLayout, View view, int i, int i2, int i3, int i4) {
        int i5 = view.getLayoutParams().height;
        if (i5 == -1 || i5 == -2) {
            View a = mo63a(coordinatorLayout.m608d(view));
            if (a != null) {
                if (ag.m2552t(a) && !ag.m2552t(view)) {
                    ag.m2521a(view, true);
                    if (ag.m2552t(view)) {
                        view.requestLayout();
                        return true;
                    }
                }
                if (ag.m2503A(a)) {
                    int size = MeasureSpec.getSize(i3);
                    if (size == 0) {
                        size = coordinatorLayout.getHeight();
                    }
                    coordinatorLayout.m593a(view, i, i2, MeasureSpec.makeMeasureSpec(mo64b(a) + (size - a.getMeasuredHeight()), i5 == -1 ? 1073741824 : Integer.MIN_VALUE), i4);
                    return true;
                }
            }
        }
        return false;
    }

    int mo64b(View view) {
        return view.getMeasuredHeight();
    }

    public final void m428b(int i) {
        this.f271d = i;
    }

    protected void mo61b(CoordinatorLayout coordinatorLayout, View view, int i) {
        View a = mo63a(coordinatorLayout.m608d(view));
        if (a != null) {
            C0078e c0078e = (C0078e) view.getLayoutParams();
            Rect rect = this.f268a;
            rect.set(coordinatorLayout.getPaddingLeft() + c0078e.leftMargin, a.getBottom() + c0078e.topMargin, (coordinatorLayout.getWidth() - coordinatorLayout.getPaddingRight()) - c0078e.rightMargin, ((coordinatorLayout.getHeight() + a.getBottom()) - coordinatorLayout.getPaddingBottom()) - c0078e.bottomMargin);
            Rect rect2 = this.f269b;
            C0507e.m2797a(C0061m.m422c(c0078e.f338c), view.getMeasuredWidth(), view.getMeasuredHeight(), rect, rect2, i);
            int c = m430c(a);
            view.layout(rect2.left, rect2.top - c, rect2.right, rect2.bottom - c);
            this.f270c = rect2.top - a.getBottom();
            return;
        }
        super.mo61b(coordinatorLayout, view, i);
        this.f270c = 0;
    }

    final int m430c(View view) {
        return this.f271d == 0 ? 0 : C0152n.m1009a(Math.round(mo62a(view) * ((float) this.f271d)), 0, this.f271d);
    }
}
