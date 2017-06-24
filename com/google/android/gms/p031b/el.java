package com.google.android.gms.p031b;

import android.content.Context;
import android.graphics.Color;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.google.android.gms.ads.internal.client.C1120y;
import com.google.android.gms.ads.internal.overlay.C1208k;
import com.google.android.gms.ads.internal.util.client.C1324b;
import java.util.Map;
import java.util.WeakHashMap;
import org.json.JSONObject;

@id
public final class el implements eb {
    private final Map<la, Integer> f4543a = new WeakHashMap();
    private boolean f4544b;

    private static int m8048a(Context context, Map<String, String> map, String str, int i) {
        String str2 = (String) map.get(str);
        if (str2 != null) {
            try {
                i = C1120y.m6293a().m7208a(context, Integer.parseInt(str2));
            } catch (NumberFormatException e) {
                C1324b.m7234d(new StringBuilder((String.valueOf(str).length() + 34) + String.valueOf(str2).length()).append("Could not parse ").append(str).append(" in a video GMSG: ").append(str2).toString());
            }
        }
        return i;
    }

    public void mo997a(la laVar, Map<String, String> map) {
        String str = (String) map.get("action");
        if (str == null) {
            C1324b.m7234d("Action missing from video GMSG.");
            return;
        }
        if (C1324b.m7229a(3)) {
            JSONObject jSONObject = new JSONObject(map);
            jSONObject.remove("google.afma.Notify_dt");
            String valueOf = String.valueOf(jSONObject.toString());
            C1324b.m7227a(new StringBuilder((String.valueOf(str).length() + 13) + String.valueOf(valueOf).length()).append("Video GMSG: ").append(str).append(" ").append(valueOf).toString());
        }
        if ("background".equals(str)) {
            valueOf = (String) map.get("color");
            if (TextUtils.isEmpty(valueOf)) {
                C1324b.m7234d("Color parameter missing from color video GMSG.");
                return;
            }
            try {
                int parseColor = Color.parseColor(valueOf);
                kz w = laVar.mo1541w();
                if (w != null) {
                    C1208k a = w.m9388a();
                    if (a != null) {
                        a.setBackgroundColor(parseColor);
                        return;
                    }
                }
                this.f4543a.put(laVar, Integer.valueOf(parseColor));
                return;
            } catch (IllegalArgumentException e) {
                C1324b.m7234d("Invalid color parameter in video GMSG.");
                return;
            }
        }
        kz w2 = laVar.mo1541w();
        if (w2 == null) {
            C1324b.m7234d("Could not get underlay container for a video GMSG.");
            return;
        }
        boolean equals = "new".equals(str);
        boolean equals2 = "position".equals(str);
        int a2;
        int a3;
        if (equals || equals2) {
            int parseInt;
            Context context = laVar.getContext();
            int a4 = el.m8048a(context, map, "x", 0);
            a2 = el.m8048a(context, map, "y", 0);
            a3 = el.m8048a(context, map, "w", -1);
            int a5 = el.m8048a(context, map, "h", -1);
            try {
                parseInt = Integer.parseInt((String) map.get("player"));
            } catch (NumberFormatException e2) {
                parseInt = 0;
            }
            boolean parseBoolean = Boolean.parseBoolean((String) map.get("spherical"));
            if (equals && w2.m9388a() == null) {
                w2.m9390a(a4, a2, a3, a5, parseInt, parseBoolean);
                if (this.f4543a.containsKey(laVar)) {
                    w2.m9388a().setBackgroundColor(((Integer) this.f4543a.get(laVar)).intValue());
                    return;
                }
                return;
            }
            w2.m9389a(a4, a2, a3, a5);
            return;
        }
        C1208k a6 = w2.m9388a();
        if (a6 == null) {
            C1208k.m6696a(laVar);
        } else if ("click".equals(str)) {
            r0 = laVar.getContext();
            a2 = el.m8048a(r0, map, "x", 0);
            a3 = el.m8048a(r0, map, "y", 0);
            long uptimeMillis = SystemClock.uptimeMillis();
            MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 0, (float) a2, (float) a3, 0);
            a6.m6708a(obtain);
            obtain.recycle();
        } else if ("currentTime".equals(str)) {
            valueOf = (String) map.get("time");
            if (valueOf == null) {
                C1324b.m7234d("Time parameter missing from currentTime video GMSG.");
                return;
            }
            try {
                a6.m6706a((int) (Float.parseFloat(valueOf) * 1000.0f));
            } catch (NumberFormatException e3) {
                str = "Could not parse time parameter from currentTime video GMSG: ";
                valueOf = String.valueOf(valueOf);
                C1324b.m7234d(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
            }
        } else if ("hide".equals(str)) {
            a6.setVisibility(4);
        } else if ("load".equals(str)) {
            a6.m6716g();
        } else if ("mimetype".equals(str)) {
            a6.setMimeType((String) map.get("mimetype"));
        } else if ("muted".equals(str)) {
            if (Boolean.parseBoolean((String) map.get("muted"))) {
                a6.m6719j();
            } else {
                a6.m6720k();
            }
        } else if ("pause".equals(str)) {
            a6.m6717h();
        } else if ("play".equals(str)) {
            a6.m6718i();
        } else if ("show".equals(str)) {
            a6.setVisibility(0);
        } else if ("src".equals(str)) {
            a6.m6709a((String) map.get("src"));
        } else if ("touchMove".equals(str)) {
            r0 = laVar.getContext();
            a6.m6705a((float) el.m8048a(r0, map, "dx", 0), (float) el.m8048a(r0, map, "dy", 0));
            if (!this.f4544b) {
                laVar.mo1516i().m6679q();
                this.f4544b = true;
            }
        } else if ("volume".equals(str)) {
            valueOf = (String) map.get("volume");
            if (valueOf == null) {
                C1324b.m7234d("Level parameter missing from volume video GMSG.");
                return;
            }
            try {
                a6.m6704a(Float.parseFloat(valueOf));
            } catch (NumberFormatException e4) {
                str = "Could not parse volume parameter from volume video GMSG: ";
                valueOf = String.valueOf(valueOf);
                C1324b.m7234d(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
            }
        } else if ("watermark".equals(str)) {
            a6.m6721l();
        } else {
            String str2 = "Unknown video action: ";
            valueOf = String.valueOf(str);
            C1324b.m7234d(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
        }
    }
}
