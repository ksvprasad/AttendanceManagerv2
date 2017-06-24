package com.google.android.gms.ads.internal.formats;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.android.gms.ads.internal.C1319u;
import com.google.android.gms.ads.internal.client.C1120y;
import com.google.android.gms.common.internal.C1896c;
import com.google.android.gms.p031b.id;
import java.util.List;

@id
class C1132b extends RelativeLayout {
    private static final float[] f3313a = new float[]{5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f};
    private final RelativeLayout f3314b;
    private AnimationDrawable f3315c;

    public C1132b(Context context, C1131a c1131a) {
        super(context);
        C1896c.m10790a((Object) c1131a);
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        switch (c1131a.m6326g()) {
            case 0:
                layoutParams.addRule(10);
                layoutParams.addRule(9);
                break;
            case 2:
                layoutParams.addRule(12);
                layoutParams.addRule(11);
                break;
            case 3:
                layoutParams.addRule(12);
                layoutParams.addRule(9);
                break;
            default:
                layoutParams.addRule(10);
                layoutParams.addRule(11);
                break;
        }
        Drawable shapeDrawable = new ShapeDrawable(new RoundRectShape(f3313a, null, null));
        shapeDrawable.getPaint().setColor(c1131a.m6322c());
        this.f3314b = new RelativeLayout(context);
        this.f3314b.setLayoutParams(layoutParams);
        C1319u.m7185g().mo1475a(this.f3314b, shapeDrawable);
        layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        if (!TextUtils.isEmpty(c1131a.m6320a())) {
            LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
            View textView = new TextView(context);
            textView.setLayoutParams(layoutParams2);
            textView.setId(1195835393);
            textView.setTypeface(Typeface.DEFAULT);
            textView.setText(c1131a.m6320a());
            textView.setTextColor(c1131a.m6323d());
            textView.setTextSize((float) c1131a.m6324e());
            textView.setPadding(C1120y.m6293a().m7208a(context, 4), 0, C1120y.m6293a().m7208a(context, 4), 0);
            this.f3314b.addView(textView);
            layoutParams.addRule(1, textView.getId());
        }
        View imageView = new ImageView(context);
        imageView.setLayoutParams(layoutParams);
        imageView.setId(1195835394);
        List<Drawable> b = c1131a.m6321b();
        if (b.size() > 1) {
            this.f3315c = new AnimationDrawable();
            for (Drawable addFrame : b) {
                this.f3315c.addFrame(addFrame, c1131a.m6325f());
            }
            C1319u.m7185g().mo1475a(imageView, this.f3315c);
        } else if (b.size() == 1) {
            imageView.setImageDrawable((Drawable) b.get(0));
        }
        this.f3314b.addView(imageView);
        addView(this.f3314b);
    }

    public ViewGroup m6327a() {
        return this.f3314b;
    }

    public void onAttachedToWindow() {
        if (this.f3315c != null) {
            this.f3315c.start();
        }
        super.onAttachedToWindow();
    }
}
