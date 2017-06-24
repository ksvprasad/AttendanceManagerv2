package android.support.v4.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

class ay {
    public static void m2747a(final View view, final ba baVar) {
        if (baVar != null) {
            view.animate().setListener(new AnimatorListenerAdapter() {
                public void onAnimationCancel(Animator animator) {
                    baVar.mo100c(view);
                }

                public void onAnimationEnd(Animator animator) {
                    baVar.mo99b(view);
                }

                public void onAnimationStart(Animator animator) {
                    baVar.mo98a(view);
                }
            });
        } else {
            view.animate().setListener(null);
        }
    }
}
