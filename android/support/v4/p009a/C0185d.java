package android.support.v4.p009a;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;

class C0185d implements C0183b {
    private TimeInterpolator f718a;

    C0185d() {
    }

    public void mo166a(View view) {
        if (this.f718a == null) {
            this.f718a = new ValueAnimator().getInterpolator();
        }
        view.animate().setInterpolator(this.f718a);
    }
}
