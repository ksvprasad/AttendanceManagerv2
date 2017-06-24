package android.support.v7.view.menu;

import android.annotation.TargetApi;
import android.content.Context;
import android.support.v4.p012d.p013a.C0336b;
import android.support.v4.view.C0503d.C0502b;
import android.support.v7.view.menu.C0735i.C0731a;
import android.view.ActionProvider;
import android.view.ActionProvider.VisibilityListener;
import android.view.MenuItem;
import android.view.View;

@TargetApi(16)
class C0737j extends C0735i {

    class C0736a extends C0731a implements VisibilityListener {
        C0502b f1903c;
        final /* synthetic */ C0737j f1904d;

        public C0736a(C0737j c0737j, Context context, ActionProvider actionProvider) {
            this.f1904d = c0737j;
            super(c0737j, context, actionProvider);
        }

        public View mo652a(MenuItem menuItem) {
            return this.a.onCreateActionView(menuItem);
        }

        public void mo653a(C0502b c0502b) {
            VisibilityListener visibilityListener;
            this.f1903c = c0502b;
            ActionProvider actionProvider = this.a;
            if (c0502b == null) {
                visibilityListener = null;
            }
            actionProvider.setVisibilityListener(visibilityListener);
        }

        public boolean mo654b() {
            return this.a.overridesItemVisibility();
        }

        public boolean mo655c() {
            return this.a.isVisible();
        }

        public void onActionProviderVisibilityChanged(boolean z) {
            if (this.f1903c != null) {
                this.f1903c.mo643a(z);
            }
        }
    }

    C0737j(Context context, C0336b c0336b) {
        super(context, c0336b);
    }

    C0731a mo656a(ActionProvider actionProvider) {
        return new C0736a(this, this.a, actionProvider);
    }
}
