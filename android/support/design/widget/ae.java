package android.support.design.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageButton;

class ae extends ImageButton {
    private int f386a;

    public ae(Context context) {
        this(context, null);
    }

    public ae(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ae(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f386a = getVisibility();
    }

    final void m637a(int i, boolean z) {
        super.setVisibility(i);
        if (z) {
            this.f386a = i;
        }
    }

    final int getUserSetVisibility() {
        return this.f386a;
    }

    public void setVisibility(int i) {
        m637a(i, true);
    }
}
