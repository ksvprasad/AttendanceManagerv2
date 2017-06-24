package android.support.p002a.p003a;

import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Region.Op;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.VectorDrawable;
import android.os.Build.VERSION;
import android.support.p002a.p003a.C0028c.C0027b;
import android.support.v4.p004c.p005a.C0314a;
import android.support.v4.p010b.p011a.C0291a;
import android.support.v4.p015g.C0370a;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import java.util.ArrayList;
import java.util.Stack;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

@TargetApi(21)
public class C0038f extends C0023e {
    static final Mode f155b = Mode.SRC_IN;
    private C0036f f156c;
    private PorterDuffColorFilter f157d;
    private ColorFilter f158e;
    private boolean f159f;
    private boolean f160g;
    private ConstantState f161h;
    private final float[] f162i;
    private final Matrix f163j;
    private final Rect f164k;

    private static class C0031d {
        protected C0027b[] f97m = null;
        String f98n;
        int f99o;

        public C0031d(C0031d c0031d) {
            this.f98n = c0031d.f98n;
            this.f99o = c0031d.f99o;
            this.f97m = C0028c.m128a(c0031d.f97m);
        }

        public void m136a(Path path) {
            path.reset();
            if (this.f97m != null) {
                C0027b.m122a(this.f97m, path);
            }
        }

        public boolean mo25a() {
            return false;
        }

        public String m138b() {
            return this.f98n;
        }
    }

    private static class C0032a extends C0031d {
        public C0032a(C0032a c0032a) {
            super(c0032a);
        }

        private void m139a(TypedArray typedArray) {
            String string = typedArray.getString(0);
            if (string != null) {
                this.n = string;
            }
            string = typedArray.getString(1);
            if (string != null) {
                this.m = C0028c.m127a(string);
            }
        }

        public void m140a(Resources resources, AttributeSet attributeSet, Theme theme, XmlPullParser xmlPullParser) {
            if (C0029d.m134a(xmlPullParser, "pathData")) {
                TypedArray b = C0023e.m112b(resources, theme, attributeSet, C0018a.f79d);
                m139a(b);
                b.recycle();
            }
        }

        public boolean mo25a() {
            return true;
        }
    }

    private static class C0033b extends C0031d {
        int f100a = 0;
        float f101b = 0.0f;
        int f102c = 0;
        float f103d = 1.0f;
        int f104e;
        float f105f = 1.0f;
        float f106g = 0.0f;
        float f107h = 1.0f;
        float f108i = 0.0f;
        Cap f109j = Cap.BUTT;
        Join f110k = Join.MITER;
        float f111l = 4.0f;
        private int[] f112p;

        public C0033b(C0033b c0033b) {
            super(c0033b);
            this.f112p = c0033b.f112p;
            this.f100a = c0033b.f100a;
            this.f101b = c0033b.f101b;
            this.f103d = c0033b.f103d;
            this.f102c = c0033b.f102c;
            this.f104e = c0033b.f104e;
            this.f105f = c0033b.f105f;
            this.f106g = c0033b.f106g;
            this.f107h = c0033b.f107h;
            this.f108i = c0033b.f108i;
            this.f109j = c0033b.f109j;
            this.f110k = c0033b.f110k;
            this.f111l = c0033b.f111l;
        }

        private Cap m142a(int i, Cap cap) {
            switch (i) {
                case 0:
                    return Cap.BUTT;
                case 1:
                    return Cap.ROUND;
                case 2:
                    return Cap.SQUARE;
                default:
                    return cap;
            }
        }

        private Join m143a(int i, Join join) {
            switch (i) {
                case 0:
                    return Join.MITER;
                case 1:
                    return Join.ROUND;
                case 2:
                    return Join.BEVEL;
                default:
                    return join;
            }
        }

        private void m144a(TypedArray typedArray, XmlPullParser xmlPullParser) {
            this.f112p = null;
            if (C0029d.m134a(xmlPullParser, "pathData")) {
                String string = typedArray.getString(0);
                if (string != null) {
                    this.n = string;
                }
                string = typedArray.getString(2);
                if (string != null) {
                    this.m = C0028c.m127a(string);
                }
                this.f102c = C0029d.m135b(typedArray, xmlPullParser, "fillColor", 1, this.f102c);
                this.f105f = C0029d.m131a(typedArray, xmlPullParser, "fillAlpha", 12, this.f105f);
                this.f109j = m142a(C0029d.m132a(typedArray, xmlPullParser, "strokeLineCap", 8, -1), this.f109j);
                this.f110k = m143a(C0029d.m132a(typedArray, xmlPullParser, "strokeLineJoin", 9, -1), this.f110k);
                this.f111l = C0029d.m131a(typedArray, xmlPullParser, "strokeMiterLimit", 10, this.f111l);
                this.f100a = C0029d.m135b(typedArray, xmlPullParser, "strokeColor", 3, this.f100a);
                this.f103d = C0029d.m131a(typedArray, xmlPullParser, "strokeAlpha", 11, this.f103d);
                this.f101b = C0029d.m131a(typedArray, xmlPullParser, "strokeWidth", 4, this.f101b);
                this.f107h = C0029d.m131a(typedArray, xmlPullParser, "trimPathEnd", 6, this.f107h);
                this.f108i = C0029d.m131a(typedArray, xmlPullParser, "trimPathOffset", 7, this.f108i);
                this.f106g = C0029d.m131a(typedArray, xmlPullParser, "trimPathStart", 5, this.f106g);
            }
        }

        public void m145a(Resources resources, AttributeSet attributeSet, Theme theme, XmlPullParser xmlPullParser) {
            TypedArray b = C0023e.m112b(resources, theme, attributeSet, C0018a.f78c);
            m144a(b, xmlPullParser);
            b.recycle();
        }
    }

    private static class C0034c {
        final ArrayList<Object> f113a = new ArrayList();
        private final Matrix f114b = new Matrix();
        private float f115c = 0.0f;
        private float f116d = 0.0f;
        private float f117e = 0.0f;
        private float f118f = 1.0f;
        private float f119g = 1.0f;
        private float f120h = 0.0f;
        private float f121i = 0.0f;
        private final Matrix f122j = new Matrix();
        private int f123k;
        private int[] f124l;
        private String f125m = null;

        public C0034c(C0034c c0034c, C0370a<String, Object> c0370a) {
            this.f115c = c0034c.f115c;
            this.f116d = c0034c.f116d;
            this.f117e = c0034c.f117e;
            this.f118f = c0034c.f118f;
            this.f119g = c0034c.f119g;
            this.f120h = c0034c.f120h;
            this.f121i = c0034c.f121i;
            this.f124l = c0034c.f124l;
            this.f125m = c0034c.f125m;
            this.f123k = c0034c.f123k;
            if (this.f125m != null) {
                c0370a.put(this.f125m, this);
            }
            this.f122j.set(c0034c.f122j);
            ArrayList arrayList = c0034c.f113a;
            for (int i = 0; i < arrayList.size(); i++) {
                Object obj = arrayList.get(i);
                if (obj instanceof C0034c) {
                    this.f113a.add(new C0034c((C0034c) obj, c0370a));
                } else {
                    C0031d c0033b;
                    if (obj instanceof C0033b) {
                        c0033b = new C0033b((C0033b) obj);
                    } else if (obj instanceof C0032a) {
                        c0033b = new C0032a((C0032a) obj);
                    } else {
                        throw new IllegalStateException("Unknown object in the tree!");
                    }
                    this.f113a.add(c0033b);
                    if (c0033b.f98n != null) {
                        c0370a.put(c0033b.f98n, c0033b);
                    }
                }
            }
        }

        private void m147a(TypedArray typedArray, XmlPullParser xmlPullParser) {
            this.f124l = null;
            this.f115c = C0029d.m131a(typedArray, xmlPullParser, "rotation", 5, this.f115c);
            this.f116d = typedArray.getFloat(1, this.f116d);
            this.f117e = typedArray.getFloat(2, this.f117e);
            this.f118f = C0029d.m131a(typedArray, xmlPullParser, "scaleX", 3, this.f118f);
            this.f119g = C0029d.m131a(typedArray, xmlPullParser, "scaleY", 4, this.f119g);
            this.f120h = C0029d.m131a(typedArray, xmlPullParser, "translateX", 6, this.f120h);
            this.f121i = C0029d.m131a(typedArray, xmlPullParser, "translateY", 7, this.f121i);
            String string = typedArray.getString(0);
            if (string != null) {
                this.f125m = string;
            }
            m149b();
        }

        private void m149b() {
            this.f122j.reset();
            this.f122j.postTranslate(-this.f116d, -this.f117e);
            this.f122j.postScale(this.f118f, this.f119g);
            this.f122j.postRotate(this.f115c, 0.0f, 0.0f);
            this.f122j.postTranslate(this.f120h + this.f116d, this.f121i + this.f117e);
        }

        public String m151a() {
            return this.f125m;
        }

        public void m152a(Resources resources, AttributeSet attributeSet, Theme theme, XmlPullParser xmlPullParser) {
            TypedArray b = C0023e.m112b(resources, theme, attributeSet, C0018a.f77b);
            m147a(b, xmlPullParser);
            b.recycle();
        }
    }

    private static class C0035e {
        private static final Matrix f126j = new Matrix();
        float f127a;
        float f128b;
        float f129c;
        float f130d;
        int f131e;
        String f132f;
        final C0370a<String, Object> f133g;
        private final Path f134h;
        private final Path f135i;
        private final Matrix f136k;
        private Paint f137l;
        private Paint f138m;
        private PathMeasure f139n;
        private int f140o;
        private final C0034c f141p;

        public C0035e() {
            this.f136k = new Matrix();
            this.f127a = 0.0f;
            this.f128b = 0.0f;
            this.f129c = 0.0f;
            this.f130d = 0.0f;
            this.f131e = 255;
            this.f132f = null;
            this.f133g = new C0370a();
            this.f141p = new C0034c();
            this.f134h = new Path();
            this.f135i = new Path();
        }

        public C0035e(C0035e c0035e) {
            this.f136k = new Matrix();
            this.f127a = 0.0f;
            this.f128b = 0.0f;
            this.f129c = 0.0f;
            this.f130d = 0.0f;
            this.f131e = 255;
            this.f132f = null;
            this.f133g = new C0370a();
            this.f141p = new C0034c(c0035e.f141p, this.f133g);
            this.f134h = new Path(c0035e.f134h);
            this.f135i = new Path(c0035e.f135i);
            this.f127a = c0035e.f127a;
            this.f128b = c0035e.f128b;
            this.f129c = c0035e.f129c;
            this.f130d = c0035e.f130d;
            this.f140o = c0035e.f140o;
            this.f131e = c0035e.f131e;
            this.f132f = c0035e.f132f;
            if (c0035e.f132f != null) {
                this.f133g.put(c0035e.f132f, this);
            }
        }

        private static float m153a(float f, float f2, float f3, float f4) {
            return (f * f4) - (f2 * f3);
        }

        private float m154a(Matrix matrix) {
            float[] fArr = new float[]{0.0f, 1.0f, 1.0f, 0.0f};
            matrix.mapVectors(fArr);
            float hypot = (float) Math.hypot((double) fArr[0], (double) fArr[1]);
            float hypot2 = (float) Math.hypot((double) fArr[2], (double) fArr[3]);
            float a = C0035e.m153a(fArr[0], fArr[1], fArr[2], fArr[3]);
            hypot = Math.max(hypot, hypot2);
            return hypot > 0.0f ? Math.abs(a) / hypot : 0.0f;
        }

        private void m157a(C0034c c0034c, Matrix matrix, Canvas canvas, int i, int i2, ColorFilter colorFilter) {
            c0034c.f114b.set(matrix);
            c0034c.f114b.preConcat(c0034c.f122j);
            for (int i3 = 0; i3 < c0034c.f113a.size(); i3++) {
                Object obj = c0034c.f113a.get(i3);
                if (obj instanceof C0034c) {
                    m157a((C0034c) obj, c0034c.f114b, canvas, i, i2, colorFilter);
                } else if (obj instanceof C0031d) {
                    m158a(c0034c, (C0031d) obj, canvas, i, i2, colorFilter);
                }
            }
        }

        private void m158a(C0034c c0034c, C0031d c0031d, Canvas canvas, int i, int i2, ColorFilter colorFilter) {
            float f = ((float) i) / this.f129c;
            float f2 = ((float) i2) / this.f130d;
            float min = Math.min(f, f2);
            Matrix b = c0034c.f114b;
            this.f136k.set(b);
            this.f136k.postScale(f, f2);
            f = m154a(b);
            if (f != 0.0f) {
                c0031d.m136a(this.f134h);
                Path path = this.f134h;
                this.f135i.reset();
                if (c0031d.mo25a()) {
                    this.f135i.addPath(path, this.f136k);
                    canvas.clipPath(this.f135i, Op.REPLACE);
                    return;
                }
                Paint paint;
                C0033b c0033b = (C0033b) c0031d;
                if (!(c0033b.f106g == 0.0f && c0033b.f107h == 1.0f)) {
                    float f3 = (c0033b.f106g + c0033b.f108i) % 1.0f;
                    float f4 = (c0033b.f107h + c0033b.f108i) % 1.0f;
                    if (this.f139n == null) {
                        this.f139n = new PathMeasure();
                    }
                    this.f139n.setPath(this.f134h, false);
                    float length = this.f139n.getLength();
                    f3 *= length;
                    f4 *= length;
                    path.reset();
                    if (f3 > f4) {
                        this.f139n.getSegment(f3, length, path, true);
                        this.f139n.getSegment(0.0f, f4, path, true);
                    } else {
                        this.f139n.getSegment(f3, f4, path, true);
                    }
                    path.rLineTo(0.0f, 0.0f);
                }
                this.f135i.addPath(path, this.f136k);
                if (c0033b.f102c != 0) {
                    if (this.f138m == null) {
                        this.f138m = new Paint();
                        this.f138m.setStyle(Style.FILL);
                        this.f138m.setAntiAlias(true);
                    }
                    paint = this.f138m;
                    paint.setColor(C0038f.m181b(c0033b.f102c, c0033b.f105f));
                    paint.setColorFilter(colorFilter);
                    canvas.drawPath(this.f135i, paint);
                }
                if (c0033b.f100a != 0) {
                    if (this.f137l == null) {
                        this.f137l = new Paint();
                        this.f137l.setStyle(Style.STROKE);
                        this.f137l.setAntiAlias(true);
                    }
                    paint = this.f137l;
                    if (c0033b.f110k != null) {
                        paint.setStrokeJoin(c0033b.f110k);
                    }
                    if (c0033b.f109j != null) {
                        paint.setStrokeCap(c0033b.f109j);
                    }
                    paint.setStrokeMiter(c0033b.f111l);
                    paint.setColor(C0038f.m181b(c0033b.f100a, c0033b.f103d));
                    paint.setColorFilter(colorFilter);
                    paint.setStrokeWidth((f * min) * c0033b.f101b);
                    canvas.drawPath(this.f135i, paint);
                }
            }
        }

        public int m162a() {
            return this.f131e;
        }

        public void m163a(float f) {
            m164a((int) (255.0f * f));
        }

        public void m164a(int i) {
            this.f131e = i;
        }

        public void m165a(Canvas canvas, int i, int i2, ColorFilter colorFilter) {
            m157a(this.f141p, f126j, canvas, i, i2, colorFilter);
        }

        public float m166b() {
            return ((float) m162a()) / 255.0f;
        }
    }

    private static class C0036f extends ConstantState {
        int f142a;
        C0035e f143b;
        ColorStateList f144c;
        Mode f145d;
        boolean f146e;
        Bitmap f147f;
        ColorStateList f148g;
        Mode f149h;
        int f150i;
        boolean f151j;
        boolean f152k;
        Paint f153l;

        public C0036f() {
            this.f144c = null;
            this.f145d = C0038f.f155b;
            this.f143b = new C0035e();
        }

        public C0036f(C0036f c0036f) {
            this.f144c = null;
            this.f145d = C0038f.f155b;
            if (c0036f != null) {
                this.f142a = c0036f.f142a;
                this.f143b = new C0035e(c0036f.f143b);
                if (c0036f.f143b.f138m != null) {
                    this.f143b.f138m = new Paint(c0036f.f143b.f138m);
                }
                if (c0036f.f143b.f137l != null) {
                    this.f143b.f137l = new Paint(c0036f.f143b.f137l);
                }
                this.f144c = c0036f.f144c;
                this.f145d = c0036f.f145d;
                this.f146e = c0036f.f146e;
            }
        }

        public Paint m167a(ColorFilter colorFilter) {
            if (!m170a() && colorFilter == null) {
                return null;
            }
            if (this.f153l == null) {
                this.f153l = new Paint();
                this.f153l.setFilterBitmap(true);
            }
            this.f153l.setAlpha(this.f143b.m162a());
            this.f153l.setColorFilter(colorFilter);
            return this.f153l;
        }

        public void m168a(int i, int i2) {
            this.f147f.eraseColor(0);
            this.f143b.m165a(new Canvas(this.f147f), i, i2, null);
        }

        public void m169a(Canvas canvas, ColorFilter colorFilter, Rect rect) {
            canvas.drawBitmap(this.f147f, null, rect, m167a(colorFilter));
        }

        public boolean m170a() {
            return this.f143b.m162a() < 255;
        }

        public void m171b(int i, int i2) {
            if (this.f147f == null || !m174c(i, i2)) {
                this.f147f = Bitmap.createBitmap(i, i2, Config.ARGB_8888);
                this.f152k = true;
            }
        }

        public boolean m172b() {
            return !this.f152k && this.f148g == this.f144c && this.f149h == this.f145d && this.f151j == this.f146e && this.f150i == this.f143b.m162a();
        }

        public void m173c() {
            this.f148g = this.f144c;
            this.f149h = this.f145d;
            this.f150i = this.f143b.m162a();
            this.f151j = this.f146e;
            this.f152k = false;
        }

        public boolean m174c(int i, int i2) {
            return i == this.f147f.getWidth() && i2 == this.f147f.getHeight();
        }

        public int getChangingConfigurations() {
            return this.f142a;
        }

        public Drawable newDrawable() {
            return new C0038f();
        }

        public Drawable newDrawable(Resources resources) {
            return new C0038f();
        }
    }

    private static class C0037g extends ConstantState {
        private final ConstantState f154a;

        public C0037g(ConstantState constantState) {
            this.f154a = constantState;
        }

        public boolean canApplyTheme() {
            return this.f154a.canApplyTheme();
        }

        public int getChangingConfigurations() {
            return this.f154a.getChangingConfigurations();
        }

        public Drawable newDrawable() {
            Drawable c0038f = new C0038f();
            c0038f.a = (VectorDrawable) this.f154a.newDrawable();
            return c0038f;
        }

        public Drawable newDrawable(Resources resources) {
            Drawable c0038f = new C0038f();
            c0038f.a = (VectorDrawable) this.f154a.newDrawable(resources);
            return c0038f;
        }

        public Drawable newDrawable(Resources resources, Theme theme) {
            Drawable c0038f = new C0038f();
            c0038f.a = (VectorDrawable) this.f154a.newDrawable(resources, theme);
            return c0038f;
        }
    }

    private C0038f() {
        this.f160g = true;
        this.f162i = new float[9];
        this.f163j = new Matrix();
        this.f164k = new Rect();
        this.f156c = new C0036f();
    }

    private C0038f(C0036f c0036f) {
        this.f160g = true;
        this.f162i = new float[9];
        this.f163j = new Matrix();
        this.f164k = new Rect();
        this.f156c = c0036f;
        this.f157d = m183a(this.f157d, c0036f.f144c, c0036f.f145d);
    }

    private static Mode m176a(int i, Mode mode) {
        switch (i) {
            case 3:
                return Mode.SRC_OVER;
            case 5:
                return Mode.SRC_IN;
            case 9:
                return Mode.SRC_ATOP;
            case 14:
                return Mode.MULTIPLY;
            case 15:
                return Mode.SCREEN;
            case 16:
                return Mode.ADD;
            default:
                return mode;
        }
    }

    public static C0038f m177a(Resources resources, int i, Theme theme) {
        if (VERSION.SDK_INT >= 23) {
            C0038f c0038f = new C0038f();
            c0038f.a = C0291a.m1680a(resources, i, theme);
            c0038f.f161h = new C0037g(c0038f.a.getConstantState());
            return c0038f;
        }
        try {
            int next;
            XmlPullParser xml = resources.getXml(i);
            AttributeSet asAttributeSet = Xml.asAttributeSet(xml);
            do {
                next = xml.next();
                if (next == 2) {
                    break;
                }
            } while (next != 1);
            if (next == 2) {
                return C0038f.m178a(resources, xml, asAttributeSet, theme);
            }
            throw new XmlPullParserException("No start tag found");
        } catch (Throwable e) {
            Log.e("VectorDrawableCompat", "parser error", e);
            return null;
        } catch (Throwable e2) {
            Log.e("VectorDrawableCompat", "parser error", e2);
            return null;
        }
    }

    public static C0038f m178a(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
        C0038f c0038f = new C0038f();
        c0038f.inflate(resources, xmlPullParser, attributeSet, theme);
        return c0038f;
    }

    private void m179a(TypedArray typedArray, XmlPullParser xmlPullParser) {
        C0036f c0036f = this.f156c;
        C0035e c0035e = c0036f.f143b;
        c0036f.f145d = C0038f.m176a(C0029d.m132a(typedArray, xmlPullParser, "tintMode", 6, -1), Mode.SRC_IN);
        ColorStateList colorStateList = typedArray.getColorStateList(1);
        if (colorStateList != null) {
            c0036f.f144c = colorStateList;
        }
        c0036f.f146e = C0029d.m133a(typedArray, xmlPullParser, "autoMirrored", 5, c0036f.f146e);
        c0035e.f129c = C0029d.m131a(typedArray, xmlPullParser, "viewportWidth", 7, c0035e.f129c);
        c0035e.f130d = C0029d.m131a(typedArray, xmlPullParser, "viewportHeight", 8, c0035e.f130d);
        if (c0035e.f129c <= 0.0f) {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires viewportWidth > 0");
        } else if (c0035e.f130d <= 0.0f) {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires viewportHeight > 0");
        } else {
            c0035e.f127a = typedArray.getDimension(3, c0035e.f127a);
            c0035e.f128b = typedArray.getDimension(2, c0035e.f128b);
            if (c0035e.f127a <= 0.0f) {
                throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires width > 0");
            } else if (c0035e.f128b <= 0.0f) {
                throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires height > 0");
            } else {
                c0035e.m163a(C0029d.m131a(typedArray, xmlPullParser, "alpha", 4, c0035e.m166b()));
                String string = typedArray.getString(0);
                if (string != null) {
                    c0035e.f132f = string;
                    c0035e.f133g.put(string, c0035e);
                }
            }
        }
    }

    private boolean m180a() {
        return false;
    }

    private static int m181b(int i, float f) {
        return (((int) (((float) Color.alpha(i)) * f)) << 24) | (16777215 & i);
    }

    private void m182b(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
        C0036f c0036f = this.f156c;
        C0035e c0035e = c0036f.f143b;
        Stack stack = new Stack();
        stack.push(c0035e.f141p);
        int eventType = xmlPullParser.getEventType();
        Object obj = 1;
        while (eventType != 1) {
            if (eventType == 2) {
                Object obj2;
                String name = xmlPullParser.getName();
                C0034c c0034c = (C0034c) stack.peek();
                if ("path".equals(name)) {
                    C0033b c0033b = new C0033b();
                    c0033b.m145a(resources, attributeSet, theme, xmlPullParser);
                    c0034c.f113a.add(c0033b);
                    if (c0033b.m138b() != null) {
                        c0035e.f133g.put(c0033b.m138b(), c0033b);
                    }
                    obj2 = null;
                    c0036f.f142a = c0033b.o | c0036f.f142a;
                } else if ("clip-path".equals(name)) {
                    C0032a c0032a = new C0032a();
                    c0032a.m140a(resources, attributeSet, theme, xmlPullParser);
                    c0034c.f113a.add(c0032a);
                    if (c0032a.m138b() != null) {
                        c0035e.f133g.put(c0032a.m138b(), c0032a);
                    }
                    c0036f.f142a |= c0032a.o;
                    obj2 = obj;
                } else {
                    if ("group".equals(name)) {
                        C0034c c0034c2 = new C0034c();
                        c0034c2.m152a(resources, attributeSet, theme, xmlPullParser);
                        c0034c.f113a.add(c0034c2);
                        stack.push(c0034c2);
                        if (c0034c2.m151a() != null) {
                            c0035e.f133g.put(c0034c2.m151a(), c0034c2);
                        }
                        c0036f.f142a |= c0034c2.f123k;
                    }
                    obj2 = obj;
                }
                obj = obj2;
            } else if (eventType == 3) {
                if ("group".equals(xmlPullParser.getName())) {
                    stack.pop();
                }
            }
            eventType = xmlPullParser.next();
        }
        if (obj != null) {
            StringBuffer stringBuffer = new StringBuffer();
            if (stringBuffer.length() > 0) {
                stringBuffer.append(" or ");
            }
            stringBuffer.append("path");
            throw new XmlPullParserException("no " + stringBuffer + " defined");
        }
    }

    PorterDuffColorFilter m183a(PorterDuffColorFilter porterDuffColorFilter, ColorStateList colorStateList, Mode mode) {
        return (colorStateList == null || mode == null) ? null : new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    Object m184a(String str) {
        return this.f156c.f143b.f133g.get(str);
    }

    void m185a(boolean z) {
        this.f160g = z;
    }

    public /* bridge */ /* synthetic */ void applyTheme(Theme theme) {
        super.applyTheme(theme);
    }

    public boolean canApplyTheme() {
        if (this.a != null) {
            C0314a.m1774d(this.a);
        }
        return false;
    }

    public /* bridge */ /* synthetic */ void clearColorFilter() {
        super.clearColorFilter();
    }

    public void draw(Canvas canvas) {
        if (this.a != null) {
            this.a.draw(canvas);
            return;
        }
        copyBounds(this.f164k);
        if (this.f164k.width() > 0 && this.f164k.height() > 0) {
            ColorFilter colorFilter = this.f158e == null ? this.f157d : this.f158e;
            canvas.getMatrix(this.f163j);
            this.f163j.getValues(this.f162i);
            float abs = Math.abs(this.f162i[0]);
            float abs2 = Math.abs(this.f162i[4]);
            float abs3 = Math.abs(this.f162i[1]);
            float abs4 = Math.abs(this.f162i[3]);
            if (!(abs3 == 0.0f && abs4 == 0.0f)) {
                abs2 = 1.0f;
                abs = 1.0f;
            }
            int height = (int) (abs2 * ((float) this.f164k.height()));
            int min = Math.min(2048, (int) (abs * ((float) this.f164k.width())));
            height = Math.min(2048, height);
            if (min > 0 && height > 0) {
                int save = canvas.save();
                canvas.translate((float) this.f164k.left, (float) this.f164k.top);
                if (m180a()) {
                    canvas.translate((float) this.f164k.width(), 0.0f);
                    canvas.scale(-1.0f, 1.0f);
                }
                this.f164k.offsetTo(0, 0);
                this.f156c.m171b(min, height);
                if (!this.f160g) {
                    this.f156c.m168a(min, height);
                } else if (!this.f156c.m172b()) {
                    this.f156c.m168a(min, height);
                    this.f156c.m173c();
                }
                this.f156c.m169a(canvas, colorFilter, this.f164k);
                canvas.restoreToCount(save);
            }
        }
    }

    public int getAlpha() {
        return this.a != null ? C0314a.m1773c(this.a) : this.f156c.f143b.m162a();
    }

    public int getChangingConfigurations() {
        return this.a != null ? this.a.getChangingConfigurations() : super.getChangingConfigurations() | this.f156c.getChangingConfigurations();
    }

    public /* bridge */ /* synthetic */ ColorFilter getColorFilter() {
        return super.getColorFilter();
    }

    public ConstantState getConstantState() {
        if (this.a != null) {
            return new C0037g(this.a.getConstantState());
        }
        this.f156c.f142a = getChangingConfigurations();
        return this.f156c;
    }

    public /* bridge */ /* synthetic */ Drawable getCurrent() {
        return super.getCurrent();
    }

    public int getIntrinsicHeight() {
        return this.a != null ? this.a.getIntrinsicHeight() : (int) this.f156c.f143b.f128b;
    }

    public int getIntrinsicWidth() {
        return this.a != null ? this.a.getIntrinsicWidth() : (int) this.f156c.f143b.f127a;
    }

    public /* bridge */ /* synthetic */ int getLayoutDirection() {
        return super.getLayoutDirection();
    }

    public /* bridge */ /* synthetic */ int getMinimumHeight() {
        return super.getMinimumHeight();
    }

    public /* bridge */ /* synthetic */ int getMinimumWidth() {
        return super.getMinimumWidth();
    }

    public int getOpacity() {
        return this.a != null ? this.a.getOpacity() : -3;
    }

    public /* bridge */ /* synthetic */ boolean getPadding(Rect rect) {
        return super.getPadding(rect);
    }

    public /* bridge */ /* synthetic */ int[] getState() {
        return super.getState();
    }

    public /* bridge */ /* synthetic */ Region getTransparentRegion() {
        return super.getTransparentRegion();
    }

    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) {
        if (this.a != null) {
            this.a.inflate(resources, xmlPullParser, attributeSet);
        } else {
            inflate(resources, xmlPullParser, attributeSet, null);
        }
    }

    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
        if (this.a != null) {
            C0314a.m1768a(this.a, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        C0036f c0036f = this.f156c;
        c0036f.f143b = new C0035e();
        TypedArray b = C0023e.m112b(resources, theme, attributeSet, C0018a.f76a);
        m179a(b, xmlPullParser);
        b.recycle();
        c0036f.f142a = getChangingConfigurations();
        c0036f.f152k = true;
        m182b(resources, xmlPullParser, attributeSet, theme);
        this.f157d = m183a(this.f157d, c0036f.f144c, c0036f.f145d);
    }

    public void invalidateSelf() {
        if (this.a != null) {
            this.a.invalidateSelf();
        } else {
            super.invalidateSelf();
        }
    }

    public /* bridge */ /* synthetic */ boolean isAutoMirrored() {
        return super.isAutoMirrored();
    }

    public boolean isStateful() {
        return this.a != null ? this.a.isStateful() : super.isStateful() || !(this.f156c == null || this.f156c.f144c == null || !this.f156c.f144c.isStateful());
    }

    public /* bridge */ /* synthetic */ void jumpToCurrentState() {
        super.jumpToCurrentState();
    }

    public Drawable mutate() {
        if (this.a != null) {
            this.a.mutate();
        } else if (!this.f159f && super.mutate() == this) {
            this.f156c = new C0036f(this.f156c);
            this.f159f = true;
        }
        return this;
    }

    protected void onBoundsChange(Rect rect) {
        if (this.a != null) {
            this.a.setBounds(rect);
        }
    }

    protected boolean onStateChange(int[] iArr) {
        if (this.a != null) {
            return this.a.setState(iArr);
        }
        C0036f c0036f = this.f156c;
        if (c0036f.f144c == null || c0036f.f145d == null) {
            return false;
        }
        this.f157d = m183a(this.f157d, c0036f.f144c, c0036f.f145d);
        invalidateSelf();
        return true;
    }

    public void scheduleSelf(Runnable runnable, long j) {
        if (this.a != null) {
            this.a.scheduleSelf(runnable, j);
        } else {
            super.scheduleSelf(runnable, j);
        }
    }

    public void setAlpha(int i) {
        if (this.a != null) {
            this.a.setAlpha(i);
        } else if (this.f156c.f143b.m162a() != i) {
            this.f156c.f143b.m164a(i);
            invalidateSelf();
        }
    }

    public /* bridge */ /* synthetic */ void setAutoMirrored(boolean z) {
        super.setAutoMirrored(z);
    }

    public /* bridge */ /* synthetic */ void setChangingConfigurations(int i) {
        super.setChangingConfigurations(i);
    }

    public /* bridge */ /* synthetic */ void setColorFilter(int i, Mode mode) {
        super.setColorFilter(i, mode);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        if (this.a != null) {
            this.a.setColorFilter(colorFilter);
            return;
        }
        this.f158e = colorFilter;
        invalidateSelf();
    }

    public /* bridge */ /* synthetic */ void setFilterBitmap(boolean z) {
        super.setFilterBitmap(z);
    }

    public /* bridge */ /* synthetic */ void setHotspot(float f, float f2) {
        super.setHotspot(f, f2);
    }

    public /* bridge */ /* synthetic */ void setHotspotBounds(int i, int i2, int i3, int i4) {
        super.setHotspotBounds(i, i2, i3, i4);
    }

    public /* bridge */ /* synthetic */ boolean setState(int[] iArr) {
        return super.setState(iArr);
    }

    public void setTint(int i) {
        if (this.a != null) {
            C0314a.m1764a(this.a, i);
        } else {
            setTintList(ColorStateList.valueOf(i));
        }
    }

    public void setTintList(ColorStateList colorStateList) {
        if (this.a != null) {
            C0314a.m1766a(this.a, colorStateList);
            return;
        }
        C0036f c0036f = this.f156c;
        if (c0036f.f144c != colorStateList) {
            c0036f.f144c = colorStateList;
            this.f157d = m183a(this.f157d, colorStateList, c0036f.f145d);
            invalidateSelf();
        }
    }

    public void setTintMode(Mode mode) {
        if (this.a != null) {
            C0314a.m1769a(this.a, mode);
            return;
        }
        C0036f c0036f = this.f156c;
        if (c0036f.f145d != mode) {
            c0036f.f145d = mode;
            this.f157d = m183a(this.f157d, c0036f.f144c, mode);
            invalidateSelf();
        }
    }

    public boolean setVisible(boolean z, boolean z2) {
        return this.a != null ? this.a.setVisible(z, z2) : super.setVisible(z, z2);
    }

    public void unscheduleSelf(Runnable runnable) {
        if (this.a != null) {
            this.a.unscheduleSelf(runnable);
        } else {
            super.unscheduleSelf(runnable);
        }
    }
}
