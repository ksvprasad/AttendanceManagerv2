package com.google.android.gms.p031b;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import org.json.JSONObject;

@id
public class ha extends Handler {
    private final gz f5009a;

    public ha(Context context) {
        if (context.getApplicationContext() != null) {
            context = context.getApplicationContext();
        }
        this(new hb(context));
    }

    public ha(gz gzVar) {
        this.f5009a = gzVar;
    }

    private void m8705a(JSONObject jSONObject) {
        try {
            this.f5009a.mo1429a(jSONObject.getString("request_id"), jSONObject.getString("base_url"), jSONObject.getString("html"));
        } catch (Exception e) {
        }
    }

    public void handleMessage(Message message) {
        try {
            Bundle data = message.getData();
            if (data != null) {
                JSONObject jSONObject = new JSONObject(data.getString("data"));
                if ("fetch_html".equals(jSONObject.getString("message_name"))) {
                    m8705a(jSONObject);
                }
            }
        } catch (Exception e) {
        }
    }
}
