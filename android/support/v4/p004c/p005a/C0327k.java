package android.support.v4.p004c.p005a;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.support.v4.p004c.p005a.C0325j.C0323a;

class C0327k extends C0325j {

    private static class C0326a extends C0323a {
        C0326a(C0323a c0323a, Resources resources) {
            super(c0323a, resources);
        }

        public Drawable newDrawable(Resources resources) {
            return new C0327k(this, resources);
        }
    }

    C0327k(Drawable drawable) {
        super(drawable);
    }

    C0327k(C0323a c0323a, Resources resources) {
        super(c0323a, resources);
    }

    protected Drawable mo264a(ConstantState constantState, Resources resources) {
        return constantState.newDrawable(resources);
    }

    C0323a mo265b() {
        return new C0326a(this.b, null);
    }
}
