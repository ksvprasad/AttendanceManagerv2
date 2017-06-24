package android.support.design.widget;

import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.support.design.C0048a.C0047i;
import android.support.v4.p014f.C0361e;
import android.support.v4.view.C0507e;
import android.support.v4.view.ag;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.animation.Interpolator;

final class C0135d {
    private static final boolean f560a = (VERSION.SDK_INT < 18);
    private static final Paint f561b = null;
    private boolean f562A;
    private Bitmap f563B;
    private Paint f564C;
    private float f565D;
    private float f566E;
    private float f567F;
    private float f568G;
    private boolean f569H;
    private final TextPaint f570I;
    private Interpolator f571J;
    private Interpolator f572K;
    private float f573L;
    private float f574M;
    private float f575N;
    private int f576O;
    private float f577P;
    private float f578Q;
    private float f579R;
    private int f580S;
    private final View f581c;
    private boolean f582d;
    private float f583e;
    private final Rect f584f;
    private final Rect f585g;
    private final RectF f586h;
    private int f587i = 16;
    private int f588j = 16;
    private float f589k = 15.0f;
    private float f590l = 15.0f;
    private int f591m;
    private int f592n;
    private float f593o;
    private float f594p;
    private float f595q;
    private float f596r;
    private float f597s;
    private float f598t;
    private Typeface f599u;
    private Typeface f600v;
    private Typeface f601w;
    private CharSequence f602x;
    private CharSequence f603y;
    private boolean f604z;

    static {
        if (f561b != null) {
            f561b.setAntiAlias(true);
            f561b.setColor(-65281);
        }
    }

    public C0135d(View view) {
        this.f581c = view;
        this.f570I = new TextPaint(129);
        this.f585g = new Rect();
        this.f584f = new Rect();
        this.f586h = new RectF();
    }

    private static float m898a(float f, float f2, float f3, Interpolator interpolator) {
        if (interpolator != null) {
            f3 = interpolator.getInterpolation(f3);
        }
        return C0127a.m878a(f, f2, f3);
    }

    private static int m899a(int i, int i2, float f) {
        float f2 = 1.0f - f;
        return Color.argb((int) ((((float) Color.alpha(i)) * f2) + (((float) Color.alpha(i2)) * f)), (int) ((((float) Color.red(i)) * f2) + (((float) Color.red(i2)) * f)), (int) ((((float) Color.green(i)) * f2) + (((float) Color.green(i2)) * f)), (int) ((f2 * ((float) Color.blue(i))) + (((float) Color.blue(i2)) * f)));
    }

    private static boolean m900a(float f, float f2) {
        return Math.abs(f - f2) < 0.001f;
    }

    private static boolean m901a(Rect rect, int i, int i2, int i3, int i4) {
        return rect.left == i && rect.top == i2 && rect.right == i3 && rect.bottom == i4;
    }

    private boolean m902b(CharSequence charSequence) {
        int i = 1;
        if (ag.m2540h(this.f581c) != 1) {
            i = 0;
        }
        return (i != 0 ? C0361e.f1094d : C0361e.f1093c).mo270a(charSequence, 0, charSequence.length());
    }

    private void m903c(float f) {
        m904d(f);
        this.f597s = C0135d.m898a(this.f595q, this.f596r, f, this.f571J);
        this.f598t = C0135d.m898a(this.f593o, this.f594p, f, this.f571J);
        m905e(C0135d.m898a(this.f589k, this.f590l, f, this.f572K));
        if (this.f592n != this.f591m) {
            this.f570I.setColor(C0135d.m899a(this.f591m, this.f592n, f));
        } else {
            this.f570I.setColor(this.f592n);
        }
        this.f570I.setShadowLayer(C0135d.m898a(this.f577P, this.f573L, f, null), C0135d.m898a(this.f578Q, this.f574M, f, null), C0135d.m898a(this.f579R, this.f575N, f, null), C0135d.m899a(this.f580S, this.f576O, f));
        ag.m2532d(this.f581c);
    }

    private void m904d(float f) {
        this.f586h.left = C0135d.m898a((float) this.f584f.left, (float) this.f585g.left, f, this.f571J);
        this.f586h.top = C0135d.m898a(this.f593o, this.f594p, f, this.f571J);
        this.f586h.right = C0135d.m898a((float) this.f584f.right, (float) this.f585g.right, f, this.f571J);
        this.f586h.bottom = C0135d.m898a((float) this.f584f.bottom, (float) this.f585g.bottom, f, this.f571J);
    }

    private void m905e(float f) {
        m906f(f);
        boolean z = f560a && this.f567F != 1.0f;
        this.f562A = z;
        if (this.f562A) {
            m910m();
        }
        ag.m2532d(this.f581c);
    }

    private void m906f(float f) {
        boolean z = true;
        if (this.f602x != null) {
            float width;
            float f2;
            boolean z2;
            if (C0135d.m900a(f, this.f590l)) {
                width = (float) this.f585g.width();
                float f3 = this.f590l;
                this.f567F = 1.0f;
                if (this.f601w != this.f599u) {
                    this.f601w = this.f599u;
                    f2 = width;
                    width = f3;
                    z2 = true;
                } else {
                    f2 = width;
                    width = f3;
                    z2 = false;
                }
            } else {
                f2 = (float) this.f584f.width();
                width = this.f589k;
                if (this.f601w != this.f600v) {
                    this.f601w = this.f600v;
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (C0135d.m900a(f, this.f589k)) {
                    this.f567F = 1.0f;
                } else {
                    this.f567F = f / this.f589k;
                }
            }
            if (f2 > 0.0f) {
                z2 = this.f568G != width || this.f569H || z2;
                this.f568G = width;
                this.f569H = false;
            }
            if (this.f603y == null || r0) {
                this.f570I.setTextSize(this.f568G);
                this.f570I.setTypeface(this.f601w);
                TextPaint textPaint = this.f570I;
                if (this.f567F == 1.0f) {
                    z = false;
                }
                textPaint.setLinearText(z);
                CharSequence ellipsize = TextUtils.ellipsize(this.f602x, this.f570I, f2, TruncateAt.END);
                if (!TextUtils.equals(ellipsize, this.f603y)) {
                    this.f603y = ellipsize;
                    this.f604z = m902b(this.f603y);
                }
            }
        }
    }

    private Typeface m907g(int i) {
        TypedArray obtainStyledAttributes = this.f581c.getContext().obtainStyledAttributes(i, new int[]{16843692});
        try {
            String string = obtainStyledAttributes.getString(0);
            if (string != null) {
                Typeface create = Typeface.create(string, 0);
                return create;
            }
            obtainStyledAttributes.recycle();
            return null;
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    private void m908k() {
        m903c(this.f583e);
    }

    private void m909l() {
        int i = 1;
        float f = 0.0f;
        float f2 = this.f568G;
        m906f(this.f590l);
        float measureText = this.f603y != null ? this.f570I.measureText(this.f603y, 0, this.f603y.length()) : 0.0f;
        int a = C0507e.m2796a(this.f588j, this.f604z ? 1 : 0);
        switch (a & 112) {
            case 48:
                this.f594p = ((float) this.f585g.top) - this.f570I.ascent();
                break;
            case 80:
                this.f594p = (float) this.f585g.bottom;
                break;
            default:
                this.f594p = (((this.f570I.descent() - this.f570I.ascent()) / 2.0f) - this.f570I.descent()) + ((float) this.f585g.centerY());
                break;
        }
        switch (a & 8388615) {
            case 1:
                this.f596r = ((float) this.f585g.centerX()) - (measureText / 2.0f);
                break;
            case 5:
                this.f596r = ((float) this.f585g.right) - measureText;
                break;
            default:
                this.f596r = (float) this.f585g.left;
                break;
        }
        m906f(this.f589k);
        if (this.f603y != null) {
            f = this.f570I.measureText(this.f603y, 0, this.f603y.length());
        }
        int i2 = this.f587i;
        if (!this.f604z) {
            i = 0;
        }
        i2 = C0507e.m2796a(i2, i);
        switch (i2 & 112) {
            case 48:
                this.f593o = ((float) this.f584f.top) - this.f570I.ascent();
                break;
            case 80:
                this.f593o = (float) this.f584f.bottom;
                break;
            default:
                this.f593o = (((this.f570I.descent() - this.f570I.ascent()) / 2.0f) - this.f570I.descent()) + ((float) this.f584f.centerY());
                break;
        }
        switch (i2 & 8388615) {
            case 1:
                this.f595q = ((float) this.f584f.centerX()) - (f / 2.0f);
                break;
            case 5:
                this.f595q = ((float) this.f584f.right) - f;
                break;
            default:
                this.f595q = (float) this.f584f.left;
                break;
        }
        m911n();
        m905e(f2);
    }

    private void m910m() {
        if (this.f563B == null && !this.f584f.isEmpty() && !TextUtils.isEmpty(this.f603y)) {
            m903c(0.0f);
            this.f565D = this.f570I.ascent();
            this.f566E = this.f570I.descent();
            int round = Math.round(this.f570I.measureText(this.f603y, 0, this.f603y.length()));
            int round2 = Math.round(this.f566E - this.f565D);
            if (round > 0 && round2 > 0) {
                this.f563B = Bitmap.createBitmap(round, round2, Config.ARGB_8888);
                new Canvas(this.f563B).drawText(this.f603y, 0, this.f603y.length(), 0.0f, ((float) round2) - this.f570I.descent(), this.f570I);
                if (this.f564C == null) {
                    this.f564C = new Paint(3);
                }
            }
        }
    }

    private void m911n() {
        if (this.f563B != null) {
            this.f563B.recycle();
            this.f563B = null;
        }
    }

    void m912a() {
        boolean z = this.f585g.width() > 0 && this.f585g.height() > 0 && this.f584f.width() > 0 && this.f584f.height() > 0;
        this.f582d = z;
    }

    void m913a(float f) {
        if (this.f589k != f) {
            this.f589k = f;
            m936h();
        }
    }

    void m914a(int i) {
        if (this.f592n != i) {
            this.f592n = i;
            m936h();
        }
    }

    void m915a(int i, int i2, int i3, int i4) {
        if (!C0135d.m901a(this.f584f, i, i2, i3, i4)) {
            this.f584f.set(i, i2, i3, i4);
            this.f569H = true;
            m912a();
        }
    }

    public void m916a(Canvas canvas) {
        int save = canvas.save();
        if (this.f603y != null && this.f582d) {
            float f;
            float f2 = this.f597s;
            float f3 = this.f598t;
            int i = (!this.f562A || this.f563B == null) ? 0 : 1;
            float f4;
            if (i != 0) {
                f = this.f565D * this.f567F;
                f4 = this.f566E * this.f567F;
            } else {
                f = this.f570I.ascent() * this.f567F;
                f4 = this.f570I.descent() * this.f567F;
            }
            if (i != 0) {
                f3 += f;
            }
            if (this.f567F != 1.0f) {
                canvas.scale(this.f567F, this.f567F, f2, f3);
            }
            if (i != 0) {
                canvas.drawBitmap(this.f563B, f2, f3, this.f564C);
            } else {
                canvas.drawText(this.f603y, 0, this.f603y.length(), f2, f3, this.f570I);
            }
        }
        canvas.restoreToCount(save);
    }

    void m917a(Typeface typeface) {
        if (this.f599u != typeface) {
            this.f599u = typeface;
            m936h();
        }
    }

    void m918a(Interpolator interpolator) {
        this.f572K = interpolator;
        m936h();
    }

    void m919a(CharSequence charSequence) {
        if (charSequence == null || !charSequence.equals(this.f602x)) {
            this.f602x = charSequence;
            this.f603y = null;
            m911n();
            m936h();
        }
    }

    int m920b() {
        return this.f587i;
    }

    void m921b(float f) {
        float a = C0152n.m1008a(f, 0.0f, 1.0f);
        if (a != this.f583e) {
            this.f583e = a;
            m908k();
        }
    }

    void m922b(int i) {
        if (this.f591m != i) {
            this.f591m = i;
            m936h();
        }
    }

    void m923b(int i, int i2, int i3, int i4) {
        if (!C0135d.m901a(this.f585g, i, i2, i3, i4)) {
            this.f585g.set(i, i2, i3, i4);
            this.f569H = true;
            m912a();
        }
    }

    void m924b(Typeface typeface) {
        if (this.f600v != typeface) {
            this.f600v = typeface;
            m936h();
        }
    }

    void m925b(Interpolator interpolator) {
        this.f571J = interpolator;
        m936h();
    }

    int m926c() {
        return this.f588j;
    }

    void m927c(int i) {
        if (this.f587i != i) {
            this.f587i = i;
            m936h();
        }
    }

    void m928c(Typeface typeface) {
        this.f600v = typeface;
        this.f599u = typeface;
        m936h();
    }

    Typeface m929d() {
        return this.f599u != null ? this.f599u : Typeface.DEFAULT;
    }

    void m930d(int i) {
        if (this.f588j != i) {
            this.f588j = i;
            m936h();
        }
    }

    Typeface m931e() {
        return this.f600v != null ? this.f600v : Typeface.DEFAULT;
    }

    void m932e(int i) {
        TypedArray obtainStyledAttributes = this.f581c.getContext().obtainStyledAttributes(i, C0047i.TextAppearance);
        if (obtainStyledAttributes.hasValue(C0047i.TextAppearance_android_textColor)) {
            this.f592n = obtainStyledAttributes.getColor(C0047i.TextAppearance_android_textColor, this.f592n);
        }
        if (obtainStyledAttributes.hasValue(C0047i.TextAppearance_android_textSize)) {
            this.f590l = (float) obtainStyledAttributes.getDimensionPixelSize(C0047i.TextAppearance_android_textSize, (int) this.f590l);
        }
        this.f576O = obtainStyledAttributes.getInt(C0047i.TextAppearance_android_shadowColor, 0);
        this.f574M = obtainStyledAttributes.getFloat(C0047i.TextAppearance_android_shadowDx, 0.0f);
        this.f575N = obtainStyledAttributes.getFloat(C0047i.TextAppearance_android_shadowDy, 0.0f);
        this.f573L = obtainStyledAttributes.getFloat(C0047i.TextAppearance_android_shadowRadius, 0.0f);
        obtainStyledAttributes.recycle();
        if (VERSION.SDK_INT >= 16) {
            this.f599u = m907g(i);
        }
        m936h();
    }

    float m933f() {
        return this.f583e;
    }

    void m934f(int i) {
        TypedArray obtainStyledAttributes = this.f581c.getContext().obtainStyledAttributes(i, C0047i.TextAppearance);
        if (obtainStyledAttributes.hasValue(C0047i.TextAppearance_android_textColor)) {
            this.f591m = obtainStyledAttributes.getColor(C0047i.TextAppearance_android_textColor, this.f591m);
        }
        if (obtainStyledAttributes.hasValue(C0047i.TextAppearance_android_textSize)) {
            this.f589k = (float) obtainStyledAttributes.getDimensionPixelSize(C0047i.TextAppearance_android_textSize, (int) this.f589k);
        }
        this.f580S = obtainStyledAttributes.getInt(C0047i.TextAppearance_android_shadowColor, 0);
        this.f578Q = obtainStyledAttributes.getFloat(C0047i.TextAppearance_android_shadowDx, 0.0f);
        this.f579R = obtainStyledAttributes.getFloat(C0047i.TextAppearance_android_shadowDy, 0.0f);
        this.f577P = obtainStyledAttributes.getFloat(C0047i.TextAppearance_android_shadowRadius, 0.0f);
        obtainStyledAttributes.recycle();
        if (VERSION.SDK_INT >= 16) {
            this.f600v = m907g(i);
        }
        m936h();
    }

    float m935g() {
        return this.f590l;
    }

    public void m936h() {
        if (this.f581c.getHeight() > 0 && this.f581c.getWidth() > 0) {
            m909l();
            m908k();
        }
    }

    CharSequence m937i() {
        return this.f602x;
    }

    int m938j() {
        return this.f592n;
    }
}
