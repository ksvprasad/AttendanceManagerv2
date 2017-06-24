package android.support.v7.p018a;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.p019b.C0694a.C0683a;
import android.support.v7.view.C0679b;
import android.support.v7.view.C0679b.C0657a;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup.LayoutParams;

public class C0631l extends Dialog implements C0630e {
    private C0634f f1519a;

    public C0631l(Context context, int i) {
        super(context, C0631l.m3319a(context, i));
        m3320a().mo542a(null);
        m3320a().mo537h();
    }

    private static int m3319a(Context context, int i) {
        if (i != 0) {
            return i;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(C0683a.dialogTheme, typedValue, true);
        return typedValue.resourceId;
    }

    public C0634f m3320a() {
        if (this.f1519a == null) {
            this.f1519a = C0634f.m3342a((Dialog) this, (C0630e) this);
        }
        return this.f1519a;
    }

    public C0679b mo511a(C0657a c0657a) {
        return null;
    }

    public void mo512a(C0679b c0679b) {
    }

    public boolean m3323a(int i) {
        return m3320a().mo556c(i);
    }

    public void addContentView(View view, LayoutParams layoutParams) {
        m3320a().mo552b(view, layoutParams);
    }

    public void mo513b(C0679b c0679b) {
    }

    public View findViewById(int i) {
        return m3320a().mo539a(i);
    }

    public void invalidateOptionsMenu() {
        m3320a().mo558e();
    }

    protected void onCreate(Bundle bundle) {
        m3320a().mo559g();
        super.onCreate(bundle);
        m3320a().mo542a(bundle);
    }

    protected void onStop() {
        super.onStop();
        m3320a().mo555c();
    }

    public void setContentView(int i) {
        m3320a().mo550b(i);
    }

    public void setContentView(View view) {
        m3320a().mo545a(view);
    }

    public void setContentView(View view, LayoutParams layoutParams) {
        m3320a().mo546a(view, layoutParams);
    }

    public void setTitle(int i) {
        super.setTitle(i);
        m3320a().mo533a(getContext().getString(i));
    }

    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        m3320a().mo533a(charSequence);
    }
}
