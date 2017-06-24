package com.google.android.gms.p031b;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.C1319u;
import com.google.android.gms.ads.internal.util.client.C1324b;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import java.io.BufferedOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@id
public class ec implements eb {
    private final Context f4529a;
    private final VersionInfoParcel f4530b;

    @id
    static class C1448a {
        private final String f4515a;
        private final String f4516b;

        public C1448a(String str, String str2) {
            this.f4515a = str;
            this.f4516b = str2;
        }

        public String m8007a() {
            return this.f4515a;
        }

        public String m8008b() {
            return this.f4516b;
        }
    }

    @id
    static class C1449b {
        private final String f4517a;
        private final URL f4518b;
        private final ArrayList<C1448a> f4519c;
        private final String f4520d;

        public C1449b(String str, URL url, ArrayList<C1448a> arrayList, String str2) {
            this.f4517a = str;
            this.f4518b = url;
            if (arrayList == null) {
                this.f4519c = new ArrayList();
            } else {
                this.f4519c = arrayList;
            }
            this.f4520d = str2;
        }

        public String m8009a() {
            return this.f4517a;
        }

        public URL m8010b() {
            return this.f4518b;
        }

        public ArrayList<C1448a> m8011c() {
            return this.f4519c;
        }

        public String m8012d() {
            return this.f4520d;
        }
    }

    @id
    class C1450c {
        final /* synthetic */ ec f4521a;
        private final C1451d f4522b;
        private final boolean f4523c;
        private final String f4524d;

        public C1450c(ec ecVar, boolean z, C1451d c1451d, String str) {
            this.f4521a = ecVar;
            this.f4523c = z;
            this.f4522b = c1451d;
            this.f4524d = str;
        }

        public String m8013a() {
            return this.f4524d;
        }

        public C1451d m8014b() {
            return this.f4522b;
        }

        public boolean m8015c() {
            return this.f4523c;
        }
    }

    @id
    static class C1451d {
        private final String f4525a;
        private final int f4526b;
        private final List<C1448a> f4527c;
        private final String f4528d;

        public C1451d(String str, int i, List<C1448a> list, String str2) {
            this.f4525a = str;
            this.f4526b = i;
            if (list == null) {
                this.f4527c = new ArrayList();
            } else {
                this.f4527c = list;
            }
            this.f4528d = str2;
        }

        public String m8016a() {
            return this.f4525a;
        }

        public int m8017b() {
            return this.f4526b;
        }

        public Iterable<C1448a> m8018c() {
            return this.f4527c;
        }

        public String m8019d() {
            return this.f4528d;
        }
    }

    public ec(Context context, VersionInfoParcel versionInfoParcel) {
        this.f4529a = context;
        this.f4530b = versionInfoParcel;
    }

    protected C1449b m8020a(JSONObject jSONObject) {
        URL url;
        String optString = jSONObject.optString("http_request_id");
        String optString2 = jSONObject.optString("url");
        String optString3 = jSONObject.optString("post_body", null);
        try {
            url = new URL(optString2);
        } catch (Throwable e) {
            C1324b.m7231b("Error constructing http request.", e);
            url = null;
        }
        ArrayList arrayList = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("headers");
        if (optJSONArray == null) {
            optJSONArray = new JSONArray();
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                arrayList.add(new C1448a(optJSONObject.optString("key"), optJSONObject.optString("value")));
            }
        }
        return new C1449b(optString, url, arrayList, optString3);
    }

    protected C1450c m8021a(C1449b c1449b) {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) c1449b.m8010b().openConnection();
            C1319u.m7183e().m9219a(this.f4529a, this.f4530b.f3957b, false, httpURLConnection);
            Iterator it = c1449b.m8011c().iterator();
            while (it.hasNext()) {
                C1448a c1448a = (C1448a) it.next();
                httpURLConnection.addRequestProperty(c1448a.m8007a(), c1448a.m8008b());
            }
            if (!TextUtils.isEmpty(c1449b.m8012d())) {
                httpURLConnection.setDoOutput(true);
                byte[] bytes = c1449b.m8012d().getBytes();
                httpURLConnection.setFixedLengthStreamingMode(bytes.length);
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(httpURLConnection.getOutputStream());
                bufferedOutputStream.write(bytes);
                bufferedOutputStream.close();
            }
            List arrayList = new ArrayList();
            if (httpURLConnection.getHeaderFields() != null) {
                for (Entry entry : httpURLConnection.getHeaderFields().entrySet()) {
                    for (String c1448a2 : (List) entry.getValue()) {
                        arrayList.add(new C1448a((String) entry.getKey(), c1448a2));
                    }
                }
            }
            return new C1450c(this, true, new C1451d(c1449b.m8009a(), httpURLConnection.getResponseCode(), arrayList, C1319u.m7183e().m9206a(new InputStreamReader(httpURLConnection.getInputStream()))), null);
        } catch (Exception e) {
            return new C1450c(this, false, null, e.toString());
        }
    }

    protected JSONObject m8022a(C1451d c1451d) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("http_request_id", c1451d.m8016a());
            if (c1451d.m8019d() != null) {
                jSONObject.put("body", c1451d.m8019d());
            }
            JSONArray jSONArray = new JSONArray();
            for (C1448a c1448a : c1451d.m8018c()) {
                jSONArray.put(new JSONObject().put("key", c1448a.m8007a()).put("value", c1448a.m8008b()));
            }
            jSONObject.put("headers", jSONArray);
            jSONObject.put("response_code", c1451d.m8017b());
        } catch (Throwable e) {
            C1324b.m7231b("Error constructing JSON for http response.", e);
        }
        return jSONObject;
    }

    public JSONObject m8023a(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONObject jSONObject2 = new JSONObject();
            Object obj = "";
            try {
                obj = jSONObject.optString("http_request_id");
                C1450c a = m8021a(m8020a(jSONObject));
                if (a.m8015c()) {
                    jSONObject2.put("response", m8022a(a.m8014b()));
                    jSONObject2.put("success", true);
                    return jSONObject2;
                }
                jSONObject2.put("response", new JSONObject().put("http_request_id", obj));
                jSONObject2.put("success", false);
                jSONObject2.put("reason", a.m8013a());
                return jSONObject2;
            } catch (Exception e) {
                try {
                    jSONObject2.put("response", new JSONObject().put("http_request_id", obj));
                    jSONObject2.put("success", false);
                    jSONObject2.put("reason", e.toString());
                    return jSONObject2;
                } catch (JSONException e2) {
                    return jSONObject2;
                }
            }
        } catch (JSONException e3) {
            C1324b.m7230b("The request is not a valid JSON.");
            try {
                return new JSONObject().put("success", false);
            } catch (JSONException e4) {
                return new JSONObject();
            }
        }
    }

    public void mo997a(final la laVar, final Map<String, String> map) {
        jy.m9180a(new Runnable(this) {
            final /* synthetic */ ec f4514c;

            public void run() {
                C1324b.m7227a("Received Http request.");
                final JSONObject a = this.f4514c.m8023a((String) map.get("http_request"));
                if (a == null) {
                    C1324b.m7230b("Response should not be null.");
                } else {
                    jz.f5567a.post(new Runnable(this) {
                        final /* synthetic */ C14471 f4511b;

                        public void run() {
                            laVar.mo1325b("fetchHttpRequestCompleted", a);
                            C1324b.m7227a("Dispatched http response.");
                        }
                    });
                }
            }
        });
    }
}
