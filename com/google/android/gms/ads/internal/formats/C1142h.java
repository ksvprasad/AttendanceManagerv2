package com.google.android.gms.ads.internal.formats;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.gms.p031b.id;
import java.lang.ref.WeakReference;
import java.util.Map;
import org.json.JSONObject;

@id
public interface C1142h {

    public interface C1136a {
        void mo1055a(C1142h c1142h);

        String mo1064j();

        String mo1065k();

        C1131a mo1066l();
    }

    void mo1083a();

    void mo1084a(MotionEvent motionEvent);

    void mo1085a(View view);

    void mo1086a(View view, Map<String, WeakReference<View>> map);

    void mo1087a(View view, Map<String, WeakReference<View>> map, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3);

    void mo1088a(String str, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3);

    void mo1089b(View view);

    View mo1090e();

    Context mo1091f();
}
