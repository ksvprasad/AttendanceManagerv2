package android.support.v7.widget;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;

class C0858b extends Drawable {
    final ActionBarContainer f2555a;

    public C0858b(ActionBarContainer actionBarContainer) {
        this.f2555a = actionBarContainer;
    }

    public void draw(Canvas canvas) {
        if (!this.f2555a.f1931d) {
            if (this.f2555a.f1928a != null) {
                this.f2555a.f1928a.draw(canvas);
            }
            if (this.f2555a.f1929b != null && this.f2555a.f1932e) {
                this.f2555a.f1929b.draw(canvas);
            }
        } else if (this.f2555a.f1930c != null) {
            this.f2555a.f1930c.draw(canvas);
        }
    }

    public int getOpacity() {
        return 0;
    }

    public void setAlpha(int i) {
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }
}
