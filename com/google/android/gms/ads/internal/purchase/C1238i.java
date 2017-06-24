package com.google.android.gms.ads.internal.purchase;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import com.google.android.gms.ads.internal.C1319u;
import com.google.android.gms.ads.internal.util.client.C1324b;
import com.google.android.gms.p031b.id;
import com.google.android.gms.p031b.jo;
import org.json.JSONException;
import org.json.JSONObject;

@id
public class C1238i {
    public int m6846a(Intent intent) {
        if (intent == null) {
            return 5;
        }
        Object obj = intent.getExtras().get("RESPONSE_CODE");
        if (obj == null) {
            C1324b.m7234d("Intent with no response code, assuming OK (known issue)");
            return 0;
        } else if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        } else {
            if (obj instanceof Long) {
                return (int) ((Long) obj).longValue();
            }
            String str = "Unexpected type for intent response code. ";
            String valueOf = String.valueOf(obj.getClass().getName());
            C1324b.m7234d(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
            return 5;
        }
    }

    public int m6847a(Bundle bundle) {
        Object obj = bundle.get("RESPONSE_CODE");
        if (obj == null) {
            C1324b.m7234d("Bundle with null response code, assuming OK (known issue)");
            return 0;
        } else if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        } else {
            if (obj instanceof Long) {
                return (int) ((Long) obj).longValue();
            }
            String str = "Unexpected type for intent response code. ";
            String valueOf = String.valueOf(obj.getClass().getName());
            C1324b.m7234d(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
            return 5;
        }
    }

    public String m6848a(String str) {
        String str2 = null;
        if (str != null) {
            try {
                str2 = new JSONObject(str).getString("developerPayload");
            } catch (JSONException e) {
                C1324b.m7234d("Fail to parse purchase data");
            }
        }
        return str2;
    }

    public void m6849a(final Context context) {
        ServiceConnection c12371 = new ServiceConnection(this) {
            final /* synthetic */ C1238i f3666b;

            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                boolean z = false;
                C1225b c1225b = new C1225b(context.getApplicationContext(), false);
                c1225b.m6797a(iBinder);
                int a = c1225b.m6793a(3, context.getPackageName(), "inapp");
                jo h = C1319u.m7186h();
                if (a == 0) {
                    z = true;
                }
                h.m9124c(z);
                context.unbindService(this);
                c1225b.m6796a();
            }

            public void onServiceDisconnected(ComponentName componentName) {
            }
        };
        Intent intent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
        intent.setPackage("com.android.vending");
        context.bindService(intent, c12371, 1);
    }

    public void m6850a(Context context, boolean z, GInAppPurchaseManagerInfoParcel gInAppPurchaseManagerInfoParcel) {
        Intent intent = new Intent();
        intent.setClassName(context, "com.google.android.gms.ads.purchase.InAppPurchaseActivity");
        intent.putExtra("com.google.android.gms.ads.internal.purchase.useClientJar", z);
        GInAppPurchaseManagerInfoParcel.m6785a(intent, gInAppPurchaseManagerInfoParcel);
        C1319u.m7183e().m9214a(context, intent);
    }

    public String m6851b(Intent intent) {
        return intent == null ? null : intent.getStringExtra("INAPP_PURCHASE_DATA");
    }

    public String m6852b(String str) {
        String str2 = null;
        if (str != null) {
            try {
                str2 = new JSONObject(str).getString("purchaseToken");
            } catch (JSONException e) {
                C1324b.m7234d("Fail to parse purchase data");
            }
        }
        return str2;
    }

    public String m6853c(Intent intent) {
        return intent == null ? null : intent.getStringExtra("INAPP_DATA_SIGNATURE");
    }
}
