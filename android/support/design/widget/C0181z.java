package android.support.design.widget;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

class C0181z {
    private static final ThreadLocal<Matrix> f714a = new ThreadLocal();
    private static final ThreadLocal<RectF> f715b = new ThreadLocal();
    private static final Matrix f716c = new Matrix();

    public static void m1121a(ViewGroup viewGroup, View view, Rect rect) {
        Matrix matrix;
        Matrix matrix2 = (Matrix) f714a.get();
        if (matrix2 == null) {
            matrix2 = new Matrix();
            f714a.set(matrix2);
            matrix = matrix2;
        } else {
            matrix2.set(f716c);
            matrix = matrix2;
        }
        C0181z.m1122a((ViewParent) viewGroup, view, matrix);
        RectF rectF = (RectF) f715b.get();
        if (rectF == null) {
            rectF = new RectF();
        }
        rectF.set(rect);
        matrix.mapRect(rectF);
        rect.set((int) (rectF.left + 0.5f), (int) (rectF.top + 0.5f), (int) (rectF.right + 0.5f), (int) (rectF.bottom + 0.5f));
    }

    static void m1122a(ViewParent viewParent, View view, Matrix matrix) {
        ViewParent parent = view.getParent();
        if ((parent instanceof View) && parent != viewParent) {
            View view2 = (View) parent;
            C0181z.m1122a(viewParent, view2, matrix);
            matrix.preTranslate((float) (-view2.getScrollX()), (float) (-view2.getScrollY()));
        }
        matrix.preTranslate((float) view.getLeft(), (float) view.getTop());
        if (!view.getMatrix().isIdentity()) {
            matrix.preConcat(view.getMatrix());
        }
    }
}
