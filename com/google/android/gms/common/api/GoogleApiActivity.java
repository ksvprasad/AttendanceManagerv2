package com.google.android.gms.common.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.common.C1877b;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.p031b.mq;

public class GoogleApiActivity extends Activity implements OnCancelListener {
    protected int f6330a = 0;

    public static PendingIntent m10552a(Context context, PendingIntent pendingIntent, int i) {
        return m10553a(context, pendingIntent, i, true);
    }

    public static PendingIntent m10553a(Context context, PendingIntent pendingIntent, int i, boolean z) {
        return PendingIntent.getActivity(context, 0, m10556b(context, pendingIntent, i, z), 134217728);
    }

    private void m10554a() {
        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            Log.e("GoogleApiActivity", "Activity started without extras");
            finish();
            return;
        }
        PendingIntent pendingIntent = (PendingIntent) extras.get("pending_intent");
        Integer num = (Integer) extras.get("error_code");
        if (pendingIntent == null && num == null) {
            Log.e("GoogleApiActivity", "Activity started without resolution");
            finish();
        } else if (pendingIntent != null) {
            try {
                startIntentSenderForResult(pendingIntent.getIntentSender(), 1, null, 0, 0, 0);
                this.f6330a = 1;
            } catch (Throwable e) {
                Log.e("GoogleApiActivity", "Failed to launch pendingIntent", e);
                finish();
            }
        } else {
            C1877b.m10617a().m10634b(this, num.intValue(), 2, this);
            this.f6330a = 1;
        }
    }

    private void m10555a(int i, mq mqVar) {
        switch (i) {
            case -1:
                mqVar.m10063b();
                return;
            case 0:
                mqVar.m10064b(new ConnectionResult(13, null), getIntent().getIntExtra("failing_client_id", -1));
                return;
            default:
                return;
        }
    }

    public static Intent m10556b(Context context, PendingIntent pendingIntent, int i, boolean z) {
        Intent intent = new Intent(context, GoogleApiActivity.class);
        intent.putExtra("pending_intent", pendingIntent);
        intent.putExtra("failing_client_id", i);
        intent.putExtra("notify_manager", z);
        return intent;
    }

    protected void m10557a(int i) {
        setResult(i);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 1) {
            boolean booleanExtra = getIntent().getBooleanExtra("notify_manager", true);
            this.f6330a = 0;
            mq a = mq.m10042a();
            m10557a(i2);
            if (booleanExtra) {
                m10555a(i2, a);
            }
        } else if (i == 2) {
            this.f6330a = 0;
            m10557a(i2);
        }
        finish();
    }

    public void onCancel(DialogInterface dialogInterface) {
        this.f6330a = 0;
        setResult(0);
        finish();
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.f6330a = bundle.getInt("resolution");
        }
        if (this.f6330a != 1) {
            m10554a();
        }
    }

    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("resolution", this.f6330a);
        super.onSaveInstanceState(bundle);
    }
}
