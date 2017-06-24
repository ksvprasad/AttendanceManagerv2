package android.support.design.internal;

import android.content.Context;
import android.support.v7.view.menu.C0052m;
import android.support.v7.view.menu.C0727f;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

public class NavigationMenuView extends RecyclerView implements C0052m {
    public NavigationMenuView(Context context) {
        this(context, null);
    }

    public NavigationMenuView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NavigationMenuView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setLayoutManager(new LinearLayoutManager(context, 1, false));
    }

    public void mo37a(C0727f c0727f) {
    }

    public int getWindowAnimations() {
        return 0;
    }
}
