package com.google.android.gms.p031b;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.C1122d;
import com.google.android.gms.ads.internal.overlay.C1201d;
import com.google.android.gms.ads.internal.overlay.C1210m;
import com.google.android.gms.ads.internal.util.client.C1324b;
import com.google.android.gms.p031b.aj;
import com.google.android.gms.p031b.ak;
import com.google.android.gms.p031b.ki;
import com.google.android.gms.p031b.la;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Future;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@id
public final class ea {
    public static final eb f4493a = new C14371();
    public static final eb f4494b = new C14448();
    public static final eb f4495c = new C14459();
    public static final eb f4496d = new eb() {
        public void mo997a(la laVar, Map<String, String> map) {
            String str = (String) map.get("u");
            if (str == null) {
                C1324b.m7234d("URL missing from click GMSG.");
                return;
            }
            Uri b;
            Future future;
            Uri parse = Uri.parse(str);
            try {
                aj n = laVar.mo1524n();
                if (n != null && n.m7439c(parse)) {
                    b = n.m7437b(parse, laVar.getContext());
                    future = (Future) new ki(laVar.getContext(), laVar.mo1525o().f3957b, b.toString()).mo1107e();
                }
            } catch (ak e) {
                String str2 = "Unable to append parameter to URL: ";
                str = String.valueOf(str);
                C1324b.m7234d(str.length() != 0 ? str2.concat(str) : new String(str2));
            }
            b = parse;
            future = (Future) new ki(laVar.getContext(), laVar.mo1525o().f3957b, b.toString()).mo1107e();
        }
    };
    public static final eb f4497e = new eb() {
        public void mo997a(la laVar, Map<String, String> map) {
            C1201d i = laVar.mo1516i();
            if (i != null) {
                i.m6653a();
                return;
            }
            i = laVar.mo1517j();
            if (i != null) {
                i.m6653a();
            } else {
                C1324b.m7234d("A GMSG tried to close something that wasn't an overlay.");
            }
        }
    };
    public static final eb f4498f = new eb() {
        private void m7996a(la laVar) {
            C1324b.m7232c("Received support message, responding.");
            boolean z = false;
            C1122d h = laVar.mo1515h();
            if (h != null) {
                C1210m c1210m = h.f3284c;
                if (c1210m != null) {
                    z = c1210m.mo1160a(laVar.getContext());
                }
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("event", "checkSupport");
                jSONObject.put("supports", z);
                laVar.mo1325b("appStreaming", jSONObject);
            } catch (Throwable th) {
            }
        }

        public void mo997a(la laVar, Map<String, String> map) {
            if ("checkSupport".equals(map.get("action"))) {
                m7996a(laVar);
                return;
            }
            C1201d i = laVar.mo1516i();
            if (i != null) {
                i.m6658a(laVar, (Map) map);
            }
        }
    };
    public static final eb f4499g = new C14382();
    public static final eb f4500h = new C14393();
    public static final eb f4501i = new C14404();
    public static final eb f4502j = new C14415();
    public static final eb f4503k = new C14426();
    public static final eb f4504l = new C14437();
    public static final eb f4505m = new el();
    public static final eb f4506n = new en();
    public static final eb f4507o = new er();
    public static final eb f4508p = new dz();
    public static final ej f4509q = new ej();

    class C14371 implements eb {
        C14371() {
        }

        public void mo997a(la laVar, Map<String, String> map) {
        }
    }

    class C14382 implements eb {
        C14382() {
        }

        public void mo997a(la laVar, Map<String, String> map) {
            laVar.mo1507b("1".equals(map.get("custom_close")));
        }
    }

    class C14393 implements eb {
        C14393() {
        }

        public void mo997a(la laVar, Map<String, String> map) {
            String str = (String) map.get("u");
            if (str == null) {
                C1324b.m7234d("URL missing from httpTrack GMSG.");
            } else {
                Future future = (Future) new ki(laVar.getContext(), laVar.mo1525o().f3957b, str).mo1107e();
            }
        }
    }

    class C14404 implements eb {
        C14404() {
        }

        public void mo997a(la laVar, Map<String, String> map) {
            String str = "Received log message: ";
            String valueOf = String.valueOf((String) map.get("string"));
            C1324b.m7232c(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
        }
    }

    class C14415 implements eb {
        C14415() {
        }

        public void mo997a(la laVar, Map<String, String> map) {
            String str = (String) map.get("ty");
            String str2 = (String) map.get("td");
            try {
                int parseInt = Integer.parseInt((String) map.get("tx"));
                int parseInt2 = Integer.parseInt(str);
                int parseInt3 = Integer.parseInt(str2);
                aj n = laVar.mo1524n();
                if (n != null) {
                    n.m7432a().mo1104a(parseInt, parseInt2, parseInt3);
                }
            } catch (NumberFormatException e) {
                C1324b.m7234d("Could not parse touch parameters from gmsg.");
            }
        }
    }

    class C14426 implements eb {
        C14426() {
        }

        public void mo997a(la laVar, Map<String, String> map) {
            if (((Boolean) cq.aD.m7801c()).booleanValue()) {
                laVar.mo1509c(!Boolean.parseBoolean((String) map.get("disabled")));
            }
        }
    }

    class C14437 implements eb {
        C14437() {
        }

        public void mo997a(la laVar, Map<String, String> map) {
            String str = (String) map.get("action");
            if ("pause".equals(str)) {
                laVar.mo976B();
            } else if ("resume".equals(str)) {
                laVar.mo977C();
            }
        }
    }

    class C14448 implements eb {
        C14448() {
        }

        public void mo997a(la laVar, Map<String, String> map) {
            String str = (String) map.get("urls");
            if (TextUtils.isEmpty(str)) {
                C1324b.m7234d("URLs missing in canOpenURLs GMSG.");
                return;
            }
            String[] split = str.split(",");
            Map hashMap = new HashMap();
            PackageManager packageManager = laVar.getContext().getPackageManager();
            for (String str2 : split) {
                String[] split2 = str2.split(";", 2);
                hashMap.put(str2, Boolean.valueOf(packageManager.resolveActivity(new Intent(split2.length > 1 ? split2[1].trim() : "android.intent.action.VIEW", Uri.parse(split2[0].trim())), 65536) != null));
            }
            laVar.mo1501a("openableURLs", hashMap);
        }
    }

    class C14459 implements eb {
        C14459() {
        }

        public void mo997a(la laVar, Map<String, String> map) {
            PackageManager packageManager = laVar.getContext().getPackageManager();
            try {
                try {
                    JSONArray jSONArray = new JSONObject((String) map.get("data")).getJSONArray("intents");
                    JSONObject jSONObject = new JSONObject();
                    for (int i = 0; i < jSONArray.length(); i++) {
                        try {
                            JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                            String optString = jSONObject2.optString("id");
                            Object optString2 = jSONObject2.optString("u");
                            Object optString3 = jSONObject2.optString("i");
                            Object optString4 = jSONObject2.optString("m");
                            Object optString5 = jSONObject2.optString("p");
                            Object optString6 = jSONObject2.optString("c");
                            jSONObject2.optString("f");
                            jSONObject2.optString("e");
                            Intent intent = new Intent();
                            if (!TextUtils.isEmpty(optString2)) {
                                intent.setData(Uri.parse(optString2));
                            }
                            if (!TextUtils.isEmpty(optString3)) {
                                intent.setAction(optString3);
                            }
                            if (!TextUtils.isEmpty(optString4)) {
                                intent.setType(optString4);
                            }
                            if (!TextUtils.isEmpty(optString5)) {
                                intent.setPackage(optString5);
                            }
                            if (!TextUtils.isEmpty(optString6)) {
                                String[] split = optString6.split("/", 2);
                                if (split.length == 2) {
                                    intent.setComponent(new ComponentName(split[0], split[1]));
                                }
                            }
                            try {
                                jSONObject.put(optString, packageManager.resolveActivity(intent, 65536) != null);
                            } catch (Throwable e) {
                                C1324b.m7231b("Error constructing openable urls response.", e);
                            }
                        } catch (Throwable e2) {
                            C1324b.m7231b("Error parsing the intent data.", e2);
                        }
                    }
                    laVar.mo1325b("openableIntents", jSONObject);
                } catch (JSONException e3) {
                    laVar.mo1325b("openableIntents", new JSONObject());
                }
            } catch (JSONException e4) {
                laVar.mo1325b("openableIntents", new JSONObject());
            }
        }
    }
}
