package com.prolificinteractive.materialcalendarview;

import android.animation.Animator;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.TextView;
import com.prolificinteractive.materialcalendarview.p039a.C2138g;

class C2159l {
    private final TextView f7218a;
    private C2138g f7219b;
    private final int f7220c;
    private final int f7221d;
    private final int f7222e;
    private final Interpolator f7223f = new DecelerateInterpolator(2.0f);
    private long f7224g = 0;
    private CalendarDay f7225h = null;

    public C2159l(TextView textView) {
        this.f7218a = textView;
        Resources resources = textView.getResources();
        this.f7220c = 400;
        this.f7221d = resources.getInteger(17694720) / 2;
        this.f7222e = (int) TypedValue.applyDimension(1, 20.0f, resources.getDisplayMetrics());
    }

    private void m12325a(long j, CalendarDay calendarDay, boolean z) {
        this.f7218a.animate().cancel();
        this.f7218a.setTranslationY(0.0f);
        this.f7218a.setAlpha(1.0f);
        this.f7224g = j;
        final CharSequence a = this.f7219b.mo1783a(calendarDay);
        if (z) {
            final int i = (this.f7225h.m12210a(calendarDay) ? 1 : -1) * this.f7222e;
            this.f7218a.animate().translationY((float) (i * -1)).alpha(0.0f).setDuration((long) this.f7221d).setInterpolator(this.f7223f).setListener(new C2141a(this) {
                final /* synthetic */ C2159l f7217c;

                public void onAnimationCancel(Animator animator) {
                    this.f7217c.f7218a.setTranslationY(0.0f);
                    this.f7217c.f7218a.setAlpha(1.0f);
                }

                public void onAnimationEnd(Animator animator) {
                    this.f7217c.f7218a.setText(a);
                    this.f7217c.f7218a.setTranslationY((float) i);
                    this.f7217c.f7218a.animate().translationY(0.0f).alpha(1.0f).setDuration((long) this.f7217c.f7221d).setInterpolator(this.f7217c.f7223f).setListener(new C2141a()).start();
                }
            }).start();
        } else {
            this.f7218a.setText(a);
        }
        this.f7225h = calendarDay;
    }

    public void m12328a(CalendarDay calendarDay) {
        long currentTimeMillis = System.currentTimeMillis();
        if (calendarDay != null) {
            if (TextUtils.isEmpty(this.f7218a.getText()) || currentTimeMillis - this.f7224g < ((long) this.f7220c)) {
                m12325a(currentTimeMillis, calendarDay, false);
            }
            if (!calendarDay.equals(this.f7225h)) {
                m12325a(currentTimeMillis, calendarDay, true);
            }
        }
    }

    public void m12329a(C2138g c2138g) {
        this.f7219b = c2138g;
    }

    public void m12330b(CalendarDay calendarDay) {
        this.f7225h = calendarDay;
    }
}
