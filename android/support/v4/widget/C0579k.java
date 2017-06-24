package android.support.v4.widget;

import android.widget.ListView;

public class C0579k extends C0555a {
    private final ListView f1396a;

    public C0579k(ListView listView) {
        super(listView);
        this.f1396a = listView;
    }

    public void mo486a(int i, int i2) {
        C0580l.m3122a(this.f1396a, i2);
    }

    public boolean mo487e(int i) {
        return false;
    }

    public boolean mo488f(int i) {
        ListView listView = this.f1396a;
        int count = listView.getCount();
        if (count == 0) {
            return false;
        }
        int childCount = listView.getChildCount();
        int firstVisiblePosition = listView.getFirstVisiblePosition();
        int i2 = firstVisiblePosition + childCount;
        if (i > 0) {
            if (i2 >= count && listView.getChildAt(childCount - 1).getBottom() <= listView.getHeight()) {
                return false;
            }
        } else if (i >= 0) {
            return false;
        } else {
            if (firstVisiblePosition <= 0 && listView.getChildAt(0).getTop() >= 0) {
                return false;
            }
        }
        return true;
    }
}
