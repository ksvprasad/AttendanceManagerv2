package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageButton;
import com.google.android.gms.ads.internal.client.C1120y;
import com.google.android.gms.p031b.id;

@id
public class C1212o extends FrameLayout implements OnClickListener {
    private final ImageButton f3560a;
    private final C1200u f3561b;

    public C1212o(Context context, int i, C1200u c1200u) {
        super(context);
        this.f3561b = c1200u;
        setOnClickListener(this);
        this.f3560a = new ImageButton(context);
        this.f3560a.setImageResource(17301527);
        this.f3560a.setBackgroundColor(0);
        this.f3560a.setOnClickListener(this);
        this.f3560a.setPadding(0, 0, 0, 0);
        this.f3560a.setContentDescription("Interstitial close button");
        int a = C1120y.m6293a().m7208a(context, i);
        addView(this.f3560a, new LayoutParams(a, a, 17));
    }

    public void m6732a(boolean z, boolean z2) {
        if (!z2) {
            this.f3560a.setVisibility(0);
        } else if (z) {
            this.f3560a.setVisibility(4);
        } else {
            this.f3560a.setVisibility(8);
        }
    }

    public void onClick(View view) {
        if (this.f3561b != null) {
            this.f3561b.mo1136c();
        }
    }
}
