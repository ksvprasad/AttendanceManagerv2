package com.google.android.gms.ads;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.google.android.gms.ads.internal.client.C1120y;
import com.google.android.gms.ads.internal.util.client.C1324b;
import com.google.android.gms.p031b.gx;

public class AdActivity extends Activity {
    private gx f2981a;

    private void m5717a() {
        if (this.f2981a != null) {
            try {
                this.f2981a.mo1145l();
            } catch (Throwable e) {
                C1324b.m7235d("Could not forward setContentViewSet to ad overlay:", e);
            }
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        try {
            this.f2981a.mo1133a(i, i2, intent);
        } catch (Throwable e) {
            C1324b.m7235d("Could not forward onActivityResult to ad overlay:", e);
        }
        super.onActivityResult(i, i2, intent);
    }

    public void onBackPressed() {
        boolean z = true;
        try {
            if (this.f2981a != null) {
                z = this.f2981a.mo1138e();
            }
        } catch (Throwable e) {
            C1324b.m7235d("Could not forward onBackPressed to ad overlay:", e);
        }
        if (z) {
            super.onBackPressed();
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f2981a = C1120y.m6295b().m6292b((Activity) this);
        if (this.f2981a == null) {
            C1324b.m7234d("Could not create ad overlay.");
            finish();
            return;
        }
        try {
            this.f2981a.mo1134a(bundle);
        } catch (Throwable e) {
            C1324b.m7235d("Could not forward onCreate to ad overlay:", e);
            finish();
        }
    }

    protected void onDestroy() {
        try {
            if (this.f2981a != null) {
                this.f2981a.mo1144k();
            }
        } catch (Throwable e) {
            C1324b.m7235d("Could not forward onDestroy to ad overlay:", e);
        }
        super.onDestroy();
    }

    protected void onPause() {
        try {
            if (this.f2981a != null) {
                this.f2981a.mo1142i();
            }
        } catch (Throwable e) {
            C1324b.m7235d("Could not forward onPause to ad overlay:", e);
            finish();
        }
        super.onPause();
    }

    protected void onRestart() {
        super.onRestart();
        try {
            if (this.f2981a != null) {
                this.f2981a.mo1139f();
            }
        } catch (Throwable e) {
            C1324b.m7235d("Could not forward onRestart to ad overlay:", e);
            finish();
        }
    }

    protected void onResume() {
        super.onResume();
        try {
            if (this.f2981a != null) {
                this.f2981a.mo1141h();
            }
        } catch (Throwable e) {
            C1324b.m7235d("Could not forward onResume to ad overlay:", e);
            finish();
        }
    }

    protected void onSaveInstanceState(Bundle bundle) {
        try {
            if (this.f2981a != null) {
                this.f2981a.mo1135b(bundle);
            }
        } catch (Throwable e) {
            C1324b.m7235d("Could not forward onSaveInstanceState to ad overlay:", e);
            finish();
        }
        super.onSaveInstanceState(bundle);
    }

    protected void onStart() {
        super.onStart();
        try {
            if (this.f2981a != null) {
                this.f2981a.mo1140g();
            }
        } catch (Throwable e) {
            C1324b.m7235d("Could not forward onStart to ad overlay:", e);
            finish();
        }
    }

    protected void onStop() {
        try {
            if (this.f2981a != null) {
                this.f2981a.mo1143j();
            }
        } catch (Throwable e) {
            C1324b.m7235d("Could not forward onStop to ad overlay:", e);
            finish();
        }
        super.onStop();
    }

    public void setContentView(int i) {
        super.setContentView(i);
        m5717a();
    }

    public void setContentView(View view) {
        super.setContentView(view);
        m5717a();
    }

    public void setContentView(View view, LayoutParams layoutParams) {
        super.setContentView(view, layoutParams);
        m5717a();
    }
}
