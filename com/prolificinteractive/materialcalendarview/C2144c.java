package com.prolificinteractive.materialcalendarview;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.ShapeDrawable.ShaderFactory;
import android.graphics.drawable.StateListDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Build.VERSION;
import android.text.SpannableString;
import android.text.Spanned;
import android.widget.CheckedTextView;
import com.prolificinteractive.materialcalendarview.C2147e.C2146a;
import com.prolificinteractive.materialcalendarview.p039a.C2136e;
import java.util.List;

@SuppressLint({"ViewConstructor"})
class C2144c extends CheckedTextView {
    private CalendarDay f7190a;
    private int f7191b = -7829368;
    private final int f7192c = getResources().getInteger(17694720);
    private Drawable f7193d = null;
    private Drawable f7194e;
    private C2136e f7195f = C2136e.f7185a;
    private final Rect f7196g = new Rect();

    public C2144c(Context context, CalendarDay calendarDay) {
        super(context);
        m12287a(this.f7191b);
        setGravity(17);
        if (VERSION.SDK_INT >= 17) {
            setTextAlignment(4);
        }
        m12289a(calendarDay);
    }

    private static Drawable m12282a(int i, int i2) {
        Drawable stateListDrawable = new StateListDrawable();
        stateListDrawable.setExitFadeDuration(i2);
        stateListDrawable.addState(new int[]{16842912}, C2144c.m12283b(i));
        if (VERSION.SDK_INT >= 21) {
            stateListDrawable.addState(new int[]{16842919}, C2144c.m12284c(i));
        } else {
            stateListDrawable.addState(new int[]{16842919}, C2144c.m12283b(i));
        }
        stateListDrawable.addState(new int[0], C2144c.m12283b(0));
        return stateListDrawable;
    }

    private static Drawable m12283b(final int i) {
        Drawable shapeDrawable = new ShapeDrawable(new OvalShape());
        shapeDrawable.setShaderFactory(new ShaderFactory() {
            public Shader resize(int i, int i2) {
                return new LinearGradient(0.0f, 0.0f, 0.0f, 0.0f, i, i, TileMode.REPEAT);
            }
        });
        return shapeDrawable;
    }

    @TargetApi(21)
    private static Drawable m12284c(int i) {
        return new RippleDrawable(ColorStateList.valueOf(i), null, C2144c.m12283b(-1));
    }

    private void m12285c() {
        if (this.f7194e != null) {
            setBackgroundDrawable(this.f7194e);
        } else {
            setBackgroundDrawable(C2144c.m12282a(this.f7191b, this.f7192c));
        }
    }

    public String m12286a() {
        return this.f7195f.mo1782a(this.f7190a);
    }

    public void m12287a(int i) {
        this.f7191b = i;
        m12285c();
    }

    public void m12288a(Drawable drawable) {
        this.f7194e = drawable;
        invalidate();
    }

    public void m12289a(CalendarDay calendarDay) {
        this.f7190a = calendarDay;
        setText(m12286a());
    }

    public void m12290a(C2136e c2136e) {
        if (c2136e == null) {
            c2136e = C2136e.f7185a;
        }
        this.f7195f = c2136e;
        CharSequence text = getText();
        Object[] objArr = null;
        if (text instanceof Spanned) {
            objArr = ((Spanned) text).getSpans(0, text.length(), Object.class);
        }
        CharSequence spannableString = new SpannableString(m12286a());
        if (objArr != null) {
            for (Object span : objArr) {
                spannableString.setSpan(span, 0, spannableString.length(), 33);
            }
        }
        setText(spannableString);
    }

    void m12291a(C2147e c2147e) {
        m12294b(c2147e.m12301c());
        m12288a(c2147e.m12299b());
        List<C2146a> d = c2147e.m12302d();
        if (d.isEmpty()) {
            setText(m12286a());
            return;
        }
        String a = m12286a();
        CharSequence spannableString = new SpannableString(m12286a());
        for (C2146a c2146a : d) {
            spannableString.setSpan(c2146a.f7197a, 0, a.length(), 33);
        }
        setText(spannableString);
    }

    protected void m12292a(boolean z, boolean z2, boolean z3) {
        int i = 0;
        boolean z4 = z3 && z2;
        setEnabled(z4);
        if (!(z4 || z)) {
            i = 4;
        }
        setVisibility(i);
    }

    public CalendarDay m12293b() {
        return this.f7190a;
    }

    public void m12294b(Drawable drawable) {
        this.f7193d = drawable;
        invalidate();
    }

    protected void onDraw(Canvas canvas) {
        if (this.f7193d != null) {
            canvas.getClipBounds(this.f7196g);
            this.f7193d.setBounds(this.f7196g);
            this.f7193d.setState(getDrawableState());
            this.f7193d.draw(canvas);
        }
        super.onDraw(canvas);
    }

    public void setEnabled(boolean z) {
        super.setEnabled(z);
    }
}
