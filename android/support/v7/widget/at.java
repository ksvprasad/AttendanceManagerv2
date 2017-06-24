package android.support.v7.widget;

import android.os.Bundle;
import android.support.v4.view.C0124a;
import android.support.v4.view.p016a.C0426c;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;

public class at extends C0124a {
    final RecyclerView f2496a;
    final C0124a f2497c = new C08531(this);

    class C08531 extends C0124a {
        final /* synthetic */ at f2495a;

        C08531(at atVar) {
            this.f2495a = atVar;
        }

        public void mo113a(View view, C0426c c0426c) {
            super.mo113a(view, c0426c);
            if (!this.f2495a.m5125c() && this.f2495a.f2496a.getLayoutManager() != null) {
                this.f2495a.f2496a.getLayoutManager().m4127a(view, c0426c);
            }
        }

        public boolean mo284a(View view, int i, Bundle bundle) {
            return super.mo284a(view, i, bundle) ? true : (this.f2495a.m5125c() || this.f2495a.f2496a.getLayoutManager() == null) ? false : this.f2495a.f2496a.getLayoutManager().m4140a(view, i, bundle);
        }
    }

    public at(RecyclerView recyclerView) {
        this.f2496a = recyclerView;
    }

    private boolean m5125c() {
        return this.f2496a.m334p();
    }

    public void mo113a(View view, C0426c c0426c) {
        super.mo113a(view, c0426c);
        c0426c.m2191a(RecyclerView.class.getName());
        if (!m5125c() && this.f2496a.getLayoutManager() != null) {
            this.f2496a.getLayoutManager().m4109a(c0426c);
        }
    }

    public void mo114a(View view, AccessibilityEvent accessibilityEvent) {
        super.mo114a(view, accessibilityEvent);
        accessibilityEvent.setClassName(RecyclerView.class.getName());
        if ((view instanceof RecyclerView) && !m5125c()) {
            RecyclerView recyclerView = (RecyclerView) view;
            if (recyclerView.getLayoutManager() != null) {
                recyclerView.getLayoutManager().mo708a(accessibilityEvent);
            }
        }
    }

    public boolean mo284a(View view, int i, Bundle bundle) {
        return super.mo284a(view, i, bundle) ? true : (m5125c() || this.f2496a.getLayoutManager() == null) ? false : this.f2496a.getLayoutManager().m4131a(i, bundle);
    }

    C0124a m5129b() {
        return this.f2497c;
    }
}
