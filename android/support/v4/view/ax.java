package android.support.v4.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.animation.Interpolator;

class ax {
    public static long m2737a(View view) {
        return view.animate().getDuration();
    }

    public static void m2738a(View view, float f) {
        view.animate().alpha(f);
    }

    public static void m2739a(View view, long j) {
        view.animate().setDuration(j);
    }

    public static void m2740a(final View view, final ba baVar) {
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

    public static void m2741a(View view, Interpolator interpolator) {
        view.animate().setInterpolator(interpolator);
    }

    public static void m2742b(View view) {
        view.animate().cancel();
    }

    public static void m2743b(View view, float f) {
        view.animate().translationX(f);
    }

    public static void m2744b(View view, long j) {
        view.animate().setStartDelay(j);
    }

    public static void m2745c(View view) {
        view.animate().start();
    }

    public static void m2746c(View view, float f) {
        view.animate().translationY(f);
    }
}
