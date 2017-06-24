package android.support.v4.view;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;

class az {
    public static void m2748a(final View view, final bc bcVar) {
        AnimatorUpdateListener animatorUpdateListener = null;
        if (bcVar != null) {
            animatorUpdateListener = new AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    bcVar.mo596a(view);
                }
            };
        }
        view.animate().setUpdateListener(animatorUpdateListener);
    }
}
