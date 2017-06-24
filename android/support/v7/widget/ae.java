package android.support.v7.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.aw.C0823a;

class ae implements af {
    final RectF f2370a = new RectF();

    class C08241 implements C0823a {
        final /* synthetic */ ae f2369a;

        C08241(ae aeVar) {
            this.f2369a = aeVar;
        }

        public void mo787a(Canvas canvas, RectF rectF, float f, Paint paint) {
            float f2 = 2.0f * f;
            float width = (rectF.width() - f2) - 1.0f;
            float height = (rectF.height() - f2) - 1.0f;
            if (f >= 1.0f) {
                float f3 = f + 0.5f;
                this.f2369a.f2370a.set(-f3, -f3, f3, f3);
                int save = canvas.save();
                canvas.translate(rectF.left + f3, rectF.top + f3);
                canvas.drawArc(this.f2369a.f2370a, 180.0f, 90.0f, true, paint);
                canvas.translate(width, 0.0f);
                canvas.rotate(90.0f);
                canvas.drawArc(this.f2369a.f2370a, 180.0f, 90.0f, true, paint);
                canvas.translate(height, 0.0f);
                canvas.rotate(90.0f);
                canvas.drawArc(this.f2369a.f2370a, 180.0f, 90.0f, true, paint);
                canvas.translate(width, 0.0f);
                canvas.rotate(90.0f);
                canvas.drawArc(this.f2369a.f2370a, 180.0f, 90.0f, true, paint);
                canvas.restoreToCount(save);
                canvas.drawRect((rectF.left + f3) - 1.0f, rectF.top, 1.0f + (rectF.right - f3), rectF.top + f3, paint);
                canvas.drawRect((rectF.left + f3) - 1.0f, 1.0f + (rectF.bottom - f3), 1.0f + (rectF.right - f3), rectF.bottom, paint);
            }
            canvas.drawRect(rectF.left, Math.max(0.0f, f - 1.0f) + rectF.top, rectF.right, 1.0f + (rectF.bottom - f), paint);
        }
    }

    ae() {
    }

    private aw m4871a(Context context, int i, float f, float f2, float f3) {
        return new aw(context.getResources(), i, f, f2, f3);
    }

    private aw m4872i(ad adVar) {
        return (aw) adVar.mo698c();
    }

    public float mo774a(ad adVar) {
        return m4872i(adVar).m5151c();
    }

    public void mo775a() {
        aw.f2510c = new C08241(this);
    }

    public void mo776a(ad adVar, float f) {
        m4872i(adVar).m5144a(f);
        m4884f(adVar);
    }

    public void mo777a(ad adVar, int i) {
        m4872i(adVar).m5146a(i);
    }

    public void mo778a(ad adVar, Context context, int i, float f, float f2, float f3) {
        Drawable a = m4871a(context, i, f, f2, f3);
        a.m5148a(adVar.mo697b());
        adVar.mo695a(a);
        m4884f(adVar);
    }

    public float mo779b(ad adVar) {
        return m4872i(adVar).m5153d();
    }

    public void mo780b(ad adVar, float f) {
        m4872i(adVar).m5152c(f);
        m4884f(adVar);
    }

    public float mo781c(ad adVar) {
        return m4872i(adVar).m5154e();
    }

    public void mo782c(ad adVar, float f) {
        m4872i(adVar).m5150b(f);
    }

    public float mo783d(ad adVar) {
        return m4872i(adVar).m5143a();
    }

    public float mo784e(ad adVar) {
        return m4872i(adVar).m5149b();
    }

    public void m4884f(ad adVar) {
        Rect rect = new Rect();
        m4872i(adVar).m5147a(rect);
        adVar.mo693a((int) Math.ceil((double) mo779b(adVar)), (int) Math.ceil((double) mo781c(adVar)));
        adVar.mo694a(rect.left, rect.top, rect.right, rect.bottom);
    }

    public void mo785g(ad adVar) {
    }

    public void mo786h(ad adVar) {
        m4872i(adVar).m5148a(adVar.mo697b());
        m4884f(adVar);
    }
}
