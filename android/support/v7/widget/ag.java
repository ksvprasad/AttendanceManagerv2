package android.support.v7.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.v7.widget.aw.C0823a;

class ag extends ae {

    class C08251 implements C0823a {
        final /* synthetic */ ag f2371a;

        C08251(ag agVar) {
            this.f2371a = agVar;
        }

        public void mo787a(Canvas canvas, RectF rectF, float f, Paint paint) {
            canvas.drawRoundRect(rectF, f, f, paint);
        }
    }

    ag() {
    }

    public void mo775a() {
        aw.f2510c = new C08251(this);
    }
}
