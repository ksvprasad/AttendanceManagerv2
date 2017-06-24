package android.support.v4.p012d.p013a;

import android.support.v4.view.C0503d;
import android.support.v4.view.C0535p.C0534e;
import android.view.MenuItem;
import android.view.View;

public interface C0336b extends MenuItem {
    C0336b mo625a(C0503d c0503d);

    C0336b mo626a(C0534e c0534e);

    C0503d mo627a();

    boolean collapseActionView();

    boolean expandActionView();

    View getActionView();

    boolean isActionViewExpanded();

    MenuItem setActionView(int i);

    MenuItem setActionView(View view);

    void setShowAsAction(int i);

    MenuItem setShowAsActionFlags(int i);
}
