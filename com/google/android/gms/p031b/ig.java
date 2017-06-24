package com.google.android.gms.p031b;

import android.content.Context;
import android.graphics.Color;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.os.Debug.MemoryInfo;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.C1319u;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.SearchAdRequestParcel;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.ads.internal.request.AutoClickProtectionConfigurationParcel;
import com.google.android.gms.ads.internal.reward.mediation.client.RewardItemParcel;
import com.google.android.gms.ads.internal.util.client.C1324b;
import com.google.android.gms.p031b.ip.C1611a;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@id
public final class ig {
    private static final SimpleDateFormat f5188a = new SimpleDateFormat("yyyyMMdd", Locale.US);

    private static Bundle m8890a(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        bundle2.putString("runtime_free", Long.toString(bundle.getLong("runtime_free_memory", -1)));
        bundle2.putString("runtime_max", Long.toString(bundle.getLong("runtime_max_memory", -1)));
        bundle2.putString("runtime_total", Long.toString(bundle.getLong("runtime_total_memory", -1)));
        MemoryInfo memoryInfo = (MemoryInfo) bundle.getParcelable("debug_memory_info");
        if (memoryInfo != null) {
            bundle2.putString("debug_info_dalvik_private_dirty", Integer.toString(memoryInfo.dalvikPrivateDirty));
            bundle2.putString("debug_info_dalvik_pss", Integer.toString(memoryInfo.dalvikPss));
            bundle2.putString("debug_info_dalvik_shared_dirty", Integer.toString(memoryInfo.dalvikSharedDirty));
            bundle2.putString("debug_info_native_private_dirty", Integer.toString(memoryInfo.nativePrivateDirty));
            bundle2.putString("debug_info_native_pss", Integer.toString(memoryInfo.nativePss));
            bundle2.putString("debug_info_native_shared_dirty", Integer.toString(memoryInfo.nativeSharedDirty));
            bundle2.putString("debug_info_other_private_dirty", Integer.toString(memoryInfo.otherPrivateDirty));
            bundle2.putString("debug_info_other_pss", Integer.toString(memoryInfo.otherPss));
            bundle2.putString("debug_info_other_shared_dirty", Integer.toString(memoryInfo.otherSharedDirty));
        }
        return bundle2;
    }

    public static AdResponseParcel m8891a(Context context, AdRequestInfoParcel adRequestInfoParcel, String str) {
        String optString;
        try {
            String str2;
            JSONObject jSONObject = new JSONObject(str);
            String optString2 = jSONObject.optString("ad_base_url", null);
            Object optString3 = jSONObject.optString("ad_url", null);
            String optString4 = jSONObject.optString("ad_size", null);
            String optString5 = jSONObject.optString("ad_slot_size", optString4);
            boolean z = (adRequestInfoParcel == null || adRequestInfoParcel.f3751m == 0) ? false : true;
            CharSequence optString6 = jSONObject.optString("ad_json", null);
            if (optString6 == null) {
                optString6 = jSONObject.optString("ad_html", null);
            }
            if (optString6 == null) {
                optString6 = jSONObject.optString("body", null);
            }
            long j = -1;
            String optString7 = jSONObject.optString("debug_dialog", null);
            long j2 = jSONObject.has("interstitial_timeout") ? (long) (jSONObject.getDouble("interstitial_timeout") * 1000.0d) : -1;
            optString = jSONObject.optString("orientation", null);
            int i = -1;
            if ("portrait".equals(optString)) {
                i = C1319u.m7185g().mo1465b();
            } else if ("landscape".equals(optString)) {
                i = C1319u.m7185g().mo1463a();
            }
            AdResponseParcel adResponseParcel = null;
            if (!TextUtils.isEmpty(optString6) || TextUtils.isEmpty(optString3)) {
                CharSequence charSequence = optString6;
            } else {
                adResponseParcel = C1605if.m8885a(adRequestInfoParcel, context, adRequestInfoParcel.f3749k.f3957b, optString3, null, null, null, null);
                optString2 = adResponseParcel.f3780b;
                str2 = adResponseParcel.f3781c;
                j = adResponseParcel.f3792n;
            }
            if (str2 == null) {
                return new AdResponseParcel(0);
            }
            long j3;
            String optString8;
            String str3;
            boolean optBoolean;
            JSONArray optJSONArray = jSONObject.optJSONArray("click_urls");
            List list = adResponseParcel == null ? null : adResponseParcel.f3782d;
            if (optJSONArray != null) {
                list = ig.m8895a(optJSONArray, list);
            }
            optJSONArray = jSONObject.optJSONArray("impression_urls");
            List list2 = adResponseParcel == null ? null : adResponseParcel.f3784f;
            if (optJSONArray != null) {
                list2 = ig.m8895a(optJSONArray, list2);
            }
            optJSONArray = jSONObject.optJSONArray("manual_impression_urls");
            List list3 = adResponseParcel == null ? null : adResponseParcel.f3788j;
            if (optJSONArray != null) {
                list3 = ig.m8895a(optJSONArray, list3);
            }
            if (adResponseParcel != null) {
                if (adResponseParcel.f3790l != -1) {
                    i = adResponseParcel.f3790l;
                }
                if (adResponseParcel.f3785g > 0) {
                    j3 = adResponseParcel.f3785g;
                    optString8 = jSONObject.optString("active_view");
                    str3 = null;
                    optBoolean = jSONObject.optBoolean("ad_is_javascript", false);
                    if (optBoolean) {
                        str3 = jSONObject.optString("ad_passback_url", null);
                    }
                    return new AdResponseParcel(adRequestInfoParcel, optString2, str2, list, list2, j3, jSONObject.optBoolean("mediation", false), jSONObject.optLong("mediation_config_cache_time_milliseconds", -1), list3, jSONObject.optLong("refresh_interval_milliseconds", -1), i, optString4, j, optString7, optBoolean, str3, optString8, jSONObject.optBoolean("custom_render_allowed", false), z, adRequestInfoParcel.f3754p, jSONObject.optBoolean("content_url_opted_out", true), jSONObject.optBoolean("prefetch", false), jSONObject.optString("gws_query_id", ""), "height".equals(jSONObject.optString("fluid", "")), jSONObject.optBoolean("native_express", false), RewardItemParcel.m7096a(jSONObject.optJSONArray("rewards")), ig.m8895a(jSONObject.optJSONArray("video_start_urls"), null), ig.m8895a(jSONObject.optJSONArray("video_complete_urls"), null), jSONObject.optBoolean("use_displayed_impression", false), AutoClickProtectionConfigurationParcel.m6890a(jSONObject.optJSONObject("auto_protection_configuration")), adRequestInfoParcel.f3732I, jSONObject.optString("set_cookie", ""), ig.m8895a(jSONObject.optJSONArray("remote_ping_urls"), null), jSONObject.optString("safe_browsing"), jSONObject.optBoolean("render_in_browser", adRequestInfoParcel.f3736M), optString5);
                }
            }
            j3 = j2;
            optString8 = jSONObject.optString("active_view");
            str3 = null;
            optBoolean = jSONObject.optBoolean("ad_is_javascript", false);
            if (optBoolean) {
                str3 = jSONObject.optString("ad_passback_url", null);
            }
            return new AdResponseParcel(adRequestInfoParcel, optString2, str2, list, list2, j3, jSONObject.optBoolean("mediation", false), jSONObject.optLong("mediation_config_cache_time_milliseconds", -1), list3, jSONObject.optLong("refresh_interval_milliseconds", -1), i, optString4, j, optString7, optBoolean, str3, optString8, jSONObject.optBoolean("custom_render_allowed", false), z, adRequestInfoParcel.f3754p, jSONObject.optBoolean("content_url_opted_out", true), jSONObject.optBoolean("prefetch", false), jSONObject.optString("gws_query_id", ""), "height".equals(jSONObject.optString("fluid", "")), jSONObject.optBoolean("native_express", false), RewardItemParcel.m7096a(jSONObject.optJSONArray("rewards")), ig.m8895a(jSONObject.optJSONArray("video_start_urls"), null), ig.m8895a(jSONObject.optJSONArray("video_complete_urls"), null), jSONObject.optBoolean("use_displayed_impression", false), AutoClickProtectionConfigurationParcel.m6890a(jSONObject.optJSONObject("auto_protection_configuration")), adRequestInfoParcel.f3732I, jSONObject.optString("set_cookie", ""), ig.m8895a(jSONObject.optJSONArray("remote_ping_urls"), null), jSONObject.optString("safe_browsing"), jSONObject.optBoolean("render_in_browser", adRequestInfoParcel.f3736M), optString5);
        } catch (JSONException e) {
            String str4 = "Could not parse the inline ad response: ";
            optString = String.valueOf(e.getMessage());
            C1324b.m7234d(optString.length() != 0 ? str4.concat(optString) : new String(str4));
            return new AdResponseParcel(0);
        }
    }

    private static Integer m8892a(boolean z) {
        return Integer.valueOf(z ? 1 : 0);
    }

    private static String m8893a(int i) {
        return String.format(Locale.US, "#%06x", new Object[]{Integer.valueOf(16777215 & i)});
    }

    private static String m8894a(NativeAdOptionsParcel nativeAdOptionsParcel) {
        switch (nativeAdOptionsParcel != null ? nativeAdOptionsParcel.f3299c : 0) {
            case 1:
                return "portrait";
            case 2:
                return "landscape";
            default:
                return "any";
        }
    }

    private static List<String> m8895a(JSONArray jSONArray, List<String> list) {
        if (jSONArray == null) {
            return null;
        }
        if (list == null) {
            list = new LinkedList();
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            list.add(jSONArray.getString(i));
        }
        return list;
    }

    static JSONArray m8896a(List<String> list) {
        JSONArray jSONArray = new JSONArray();
        for (String put : list) {
            jSONArray.put(put);
        }
        return jSONArray;
    }

    public static JSONObject m8897a(Context context, AdRequestInfoParcel adRequestInfoParcel, il ilVar, C1611a c1611a, Location location, ci ciVar, String str, List<String> list, Bundle bundle, String str2) {
        String str3;
        String valueOf;
        try {
            Object obj;
            HashMap hashMap = new HashMap();
            if (list.size() > 0) {
                hashMap.put("eid", TextUtils.join(",", list));
            }
            if (adRequestInfoParcel.f3740b != null) {
                hashMap.put("ad_pos", adRequestInfoParcel.f3740b);
            }
            ig.m8900a(hashMap, adRequestInfoParcel.f3741c);
            if (adRequestInfoParcel.f3742d.f3110h != null) {
                obj = null;
                Object obj2 = null;
                for (AdSizeParcel adSizeParcel : adRequestInfoParcel.f3742d.f3110h) {
                    if (!adSizeParcel.f3112j && r3 == null) {
                        hashMap.put("format", adSizeParcel.f3104b);
                        obj2 = 1;
                    }
                    if (adSizeParcel.f3112j && r2 == null) {
                        hashMap.put("fluid", "height");
                        obj = 1;
                    }
                    if (obj2 != null && r2 != null) {
                        break;
                    }
                }
            } else {
                hashMap.put("format", adRequestInfoParcel.f3742d.f3104b);
                if (adRequestInfoParcel.f3742d.f3112j) {
                    hashMap.put("fluid", "height");
                }
            }
            if (adRequestInfoParcel.f3742d.f3108f == -1) {
                hashMap.put("smart_w", "full");
            }
            if (adRequestInfoParcel.f3742d.f3105c == -2) {
                hashMap.put("smart_h", "auto");
            }
            if (adRequestInfoParcel.f3742d.f3110h != null) {
                StringBuilder stringBuilder = new StringBuilder();
                obj = null;
                for (AdSizeParcel adSizeParcel2 : adRequestInfoParcel.f3742d.f3110h) {
                    if (adSizeParcel2.f3112j) {
                        obj = 1;
                    } else {
                        if (stringBuilder.length() != 0) {
                            stringBuilder.append("|");
                        }
                        stringBuilder.append(adSizeParcel2.f3108f == -1 ? (int) (((float) adSizeParcel2.f3109g) / ilVar.f5287r) : adSizeParcel2.f3108f);
                        stringBuilder.append("x");
                        stringBuilder.append(adSizeParcel2.f3105c == -2 ? (int) (((float) adSizeParcel2.f3106d) / ilVar.f5287r) : adSizeParcel2.f3105c);
                    }
                }
                if (obj != null) {
                    if (stringBuilder.length() != 0) {
                        stringBuilder.insert(0, "|");
                    }
                    stringBuilder.insert(0, "320x50");
                }
                hashMap.put("sz", stringBuilder);
            }
            if (adRequestInfoParcel.f3751m != 0) {
                hashMap.put("native_version", Integer.valueOf(adRequestInfoParcel.f3751m));
                if (!adRequestInfoParcel.f3742d.f3113k) {
                    hashMap.put("native_templates", adRequestInfoParcel.f3752n);
                    hashMap.put("native_image_orientation", ig.m8894a(adRequestInfoParcel.f3764z));
                    if (!adRequestInfoParcel.f3724A.isEmpty()) {
                        hashMap.put("native_custom_templates", adRequestInfoParcel.f3724A);
                    }
                }
            }
            hashMap.put("slotname", adRequestInfoParcel.f3743e);
            hashMap.put("pn", adRequestInfoParcel.f3744f.packageName);
            if (adRequestInfoParcel.f3745g != null) {
                hashMap.put("vc", Integer.valueOf(adRequestInfoParcel.f3745g.versionCode));
            }
            hashMap.put("ms", str);
            hashMap.put("seq_num", adRequestInfoParcel.f3747i);
            hashMap.put("session_id", adRequestInfoParcel.f3748j);
            hashMap.put("js", adRequestInfoParcel.f3749k.f3957b);
            ig.m8902a(hashMap, ilVar, c1611a, adRequestInfoParcel.f3738O);
            ig.m8903a(hashMap, str2);
            hashMap.put("platform", Build.MANUFACTURER);
            hashMap.put("submodel", Build.MODEL);
            if (location != null) {
                ig.m8899a(hashMap, location);
            } else if (adRequestInfoParcel.f3741c.f3085a >= 2 && adRequestInfoParcel.f3741c.f3095k != null) {
                ig.m8899a(hashMap, adRequestInfoParcel.f3741c.f3095k);
            }
            if (adRequestInfoParcel.f3739a >= 2) {
                hashMap.put("quality_signals", adRequestInfoParcel.f3750l);
            }
            if (adRequestInfoParcel.f3739a >= 4 && adRequestInfoParcel.f3754p) {
                hashMap.put("forceHttps", Boolean.valueOf(adRequestInfoParcel.f3754p));
            }
            if (bundle != null) {
                hashMap.put("content_info", bundle);
            }
            if (adRequestInfoParcel.f3739a >= 5) {
                hashMap.put("u_sd", Float.valueOf(adRequestInfoParcel.f3758t));
                hashMap.put("sh", Integer.valueOf(adRequestInfoParcel.f3757s));
                hashMap.put("sw", Integer.valueOf(adRequestInfoParcel.f3756r));
            } else {
                hashMap.put("u_sd", Float.valueOf(ilVar.f5287r));
                hashMap.put("sh", Integer.valueOf(ilVar.f5289t));
                hashMap.put("sw", Integer.valueOf(ilVar.f5288s));
            }
            if (adRequestInfoParcel.f3739a >= 6) {
                if (!TextUtils.isEmpty(adRequestInfoParcel.f3759u)) {
                    try {
                        hashMap.put("view_hierarchy", new JSONObject(adRequestInfoParcel.f3759u));
                    } catch (Throwable e) {
                        C1324b.m7235d("Problem serializing view hierarchy to JSON", e);
                    }
                }
                hashMap.put("correlation_id", Long.valueOf(adRequestInfoParcel.f3760v));
            }
            if (adRequestInfoParcel.f3739a >= 7) {
                hashMap.put("request_id", adRequestInfoParcel.f3761w);
            }
            if (adRequestInfoParcel.f3739a >= 11 && adRequestInfoParcel.f3726C != null) {
                hashMap.put("capability", adRequestInfoParcel.f3726C.m6891a());
            }
            if (adRequestInfoParcel.f3739a >= 12 && !TextUtils.isEmpty(adRequestInfoParcel.f3727D)) {
                hashMap.put("anchor", adRequestInfoParcel.f3727D);
            }
            if (adRequestInfoParcel.f3739a >= 13) {
                hashMap.put("android_app_volume", Float.valueOf(adRequestInfoParcel.f3728E));
            }
            if (adRequestInfoParcel.f3739a >= 18) {
                hashMap.put("android_app_muted", Boolean.valueOf(adRequestInfoParcel.f3734K));
            }
            if (adRequestInfoParcel.f3739a >= 14 && adRequestInfoParcel.f3729F > 0) {
                hashMap.put("target_api", Integer.valueOf(adRequestInfoParcel.f3729F));
            }
            if (adRequestInfoParcel.f3739a >= 15) {
                hashMap.put("scroll_index", Integer.valueOf(adRequestInfoParcel.f3730G == -1 ? -1 : adRequestInfoParcel.f3730G));
            }
            if (adRequestInfoParcel.f3739a >= 16) {
                hashMap.put("_activity_context", Boolean.valueOf(adRequestInfoParcel.f3731H));
            }
            if (adRequestInfoParcel.f3739a >= 18) {
                if (!TextUtils.isEmpty(adRequestInfoParcel.f3735L)) {
                    try {
                        hashMap.put("app_settings", new JSONObject(adRequestInfoParcel.f3735L));
                    } catch (Throwable e2) {
                        C1324b.m7235d("Problem creating json from app settings", e2);
                    }
                }
                hashMap.put("render_in_browser", Boolean.valueOf(adRequestInfoParcel.f3736M));
            }
            if (adRequestInfoParcel.f3739a >= 18) {
                hashMap.put("android_num_video_cache_tasks", Integer.valueOf(adRequestInfoParcel.f3737N));
            }
            if (C1324b.m7229a(2)) {
                str3 = "Ad Request JSON: ";
                valueOf = String.valueOf(C1319u.m7183e().m9211a((Map) hashMap).toString(2));
                jv.m9152e(valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3));
            }
            return C1319u.m7183e().m9211a((Map) hashMap);
        } catch (JSONException e3) {
            str3 = "Problem serializing ad request to JSON: ";
            valueOf = String.valueOf(e3.getMessage());
            C1324b.m7234d(valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3));
            return null;
        }
    }

    public static JSONObject m8898a(AdResponseParcel adResponseParcel) {
        JSONObject jSONObject = new JSONObject();
        if (adResponseParcel.f3780b != null) {
            jSONObject.put("ad_base_url", adResponseParcel.f3780b);
        }
        if (adResponseParcel.f3791m != null) {
            jSONObject.put("ad_size", adResponseParcel.f3791m);
        }
        jSONObject.put("native", adResponseParcel.f3798t);
        if (adResponseParcel.f3798t) {
            jSONObject.put("ad_json", adResponseParcel.f3781c);
        } else {
            jSONObject.put("ad_html", adResponseParcel.f3781c);
        }
        if (adResponseParcel.f3793o != null) {
            jSONObject.put("debug_dialog", adResponseParcel.f3793o);
        }
        if (adResponseParcel.f3785g != -1) {
            jSONObject.put("interstitial_timeout", ((double) adResponseParcel.f3785g) / 1000.0d);
        }
        if (adResponseParcel.f3790l == C1319u.m7185g().mo1465b()) {
            jSONObject.put("orientation", "portrait");
        } else if (adResponseParcel.f3790l == C1319u.m7185g().mo1463a()) {
            jSONObject.put("orientation", "landscape");
        }
        if (adResponseParcel.f3782d != null) {
            jSONObject.put("click_urls", ig.m8896a(adResponseParcel.f3782d));
        }
        if (adResponseParcel.f3784f != null) {
            jSONObject.put("impression_urls", ig.m8896a(adResponseParcel.f3784f));
        }
        if (adResponseParcel.f3788j != null) {
            jSONObject.put("manual_impression_urls", ig.m8896a(adResponseParcel.f3788j));
        }
        if (adResponseParcel.f3796r != null) {
            jSONObject.put("active_view", adResponseParcel.f3796r);
        }
        jSONObject.put("ad_is_javascript", adResponseParcel.f3794p);
        if (adResponseParcel.f3795q != null) {
            jSONObject.put("ad_passback_url", adResponseParcel.f3795q);
        }
        jSONObject.put("mediation", adResponseParcel.f3786h);
        jSONObject.put("custom_render_allowed", adResponseParcel.f3797s);
        jSONObject.put("content_url_opted_out", adResponseParcel.f3800v);
        jSONObject.put("prefetch", adResponseParcel.f3801w);
        if (adResponseParcel.f3789k != -1) {
            jSONObject.put("refresh_interval_milliseconds", adResponseParcel.f3789k);
        }
        if (adResponseParcel.f3787i != -1) {
            jSONObject.put("mediation_config_cache_time_milliseconds", adResponseParcel.f3787i);
        }
        if (!TextUtils.isEmpty(adResponseParcel.f3804z)) {
            jSONObject.put("gws_query_id", adResponseParcel.f3804z);
        }
        jSONObject.put("fluid", adResponseParcel.f3765A ? "height" : "");
        jSONObject.put("native_express", adResponseParcel.f3766B);
        if (adResponseParcel.f3768D != null) {
            jSONObject.put("video_start_urls", ig.m8896a(adResponseParcel.f3768D));
        }
        if (adResponseParcel.f3769E != null) {
            jSONObject.put("video_complete_urls", ig.m8896a(adResponseParcel.f3769E));
        }
        if (adResponseParcel.f3767C != null) {
            jSONObject.put("rewards", adResponseParcel.f3767C.m7097a());
        }
        jSONObject.put("use_displayed_impression", adResponseParcel.f3770F);
        jSONObject.put("auto_protection_configuration", adResponseParcel.f3771G);
        jSONObject.put("render_in_browser", adResponseParcel.f3776L);
        return jSONObject;
    }

    private static void m8899a(HashMap<String, Object> hashMap, Location location) {
        HashMap hashMap2 = new HashMap();
        Float valueOf = Float.valueOf(location.getAccuracy() * 1000.0f);
        Long valueOf2 = Long.valueOf(location.getTime() * 1000);
        Long valueOf3 = Long.valueOf((long) (location.getLatitude() * 1.0E7d));
        Long valueOf4 = Long.valueOf((long) (location.getLongitude() * 1.0E7d));
        hashMap2.put("radius", valueOf);
        hashMap2.put("lat", valueOf3);
        hashMap2.put("long", valueOf4);
        hashMap2.put("time", valueOf2);
        hashMap.put("uule", hashMap2);
    }

    private static void m8900a(HashMap<String, Object> hashMap, AdRequestParcel adRequestParcel) {
        String a = jt.m9147a();
        if (a != null) {
            hashMap.put("abf", a);
        }
        if (adRequestParcel.f3086b != -1) {
            hashMap.put("cust_age", f5188a.format(new Date(adRequestParcel.f3086b)));
        }
        if (adRequestParcel.f3087c != null) {
            hashMap.put("extras", adRequestParcel.f3087c);
        }
        if (adRequestParcel.f3088d != -1) {
            hashMap.put("cust_gender", Integer.valueOf(adRequestParcel.f3088d));
        }
        if (adRequestParcel.f3089e != null) {
            hashMap.put("kw", adRequestParcel.f3089e);
        }
        if (adRequestParcel.f3091g != -1) {
            hashMap.put("tag_for_child_directed_treatment", Integer.valueOf(adRequestParcel.f3091g));
        }
        if (adRequestParcel.f3090f) {
            hashMap.put("adtest", "on");
        }
        if (adRequestParcel.f3085a >= 2) {
            if (adRequestParcel.f3092h) {
                hashMap.put("d_imp_hdr", Integer.valueOf(1));
            }
            if (!TextUtils.isEmpty(adRequestParcel.f3093i)) {
                hashMap.put("ppid", adRequestParcel.f3093i);
            }
            if (adRequestParcel.f3094j != null) {
                ig.m8901a((HashMap) hashMap, adRequestParcel.f3094j);
            }
        }
        if (adRequestParcel.f3085a >= 3 && adRequestParcel.f3096l != null) {
            hashMap.put("url", adRequestParcel.f3096l);
        }
        if (adRequestParcel.f3085a >= 5) {
            if (adRequestParcel.f3098n != null) {
                hashMap.put("custom_targeting", adRequestParcel.f3098n);
            }
            if (adRequestParcel.f3099o != null) {
                hashMap.put("category_exclusions", adRequestParcel.f3099o);
            }
            if (adRequestParcel.f3100p != null) {
                hashMap.put("request_agent", adRequestParcel.f3100p);
            }
        }
        if (adRequestParcel.f3085a >= 6 && adRequestParcel.f3101q != null) {
            hashMap.put("request_pkg", adRequestParcel.f3101q);
        }
        if (adRequestParcel.f3085a >= 7) {
            hashMap.put("is_designed_for_families", Boolean.valueOf(adRequestParcel.f3102r));
        }
    }

    private static void m8901a(HashMap<String, Object> hashMap, SearchAdRequestParcel searchAdRequestParcel) {
        Object obj;
        Object obj2 = null;
        if (Color.alpha(searchAdRequestParcel.f3115b) != 0) {
            hashMap.put("acolor", ig.m8893a(searchAdRequestParcel.f3115b));
        }
        if (Color.alpha(searchAdRequestParcel.f3116c) != 0) {
            hashMap.put("bgcolor", ig.m8893a(searchAdRequestParcel.f3116c));
        }
        if (!(Color.alpha(searchAdRequestParcel.f3117d) == 0 || Color.alpha(searchAdRequestParcel.f3118e) == 0)) {
            hashMap.put("gradientto", ig.m8893a(searchAdRequestParcel.f3117d));
            hashMap.put("gradientfrom", ig.m8893a(searchAdRequestParcel.f3118e));
        }
        if (Color.alpha(searchAdRequestParcel.f3119f) != 0) {
            hashMap.put("bcolor", ig.m8893a(searchAdRequestParcel.f3119f));
        }
        hashMap.put("bthick", Integer.toString(searchAdRequestParcel.f3120g));
        switch (searchAdRequestParcel.f3121h) {
            case 0:
                obj = "none";
                break;
            case 1:
                obj = "dashed";
                break;
            case 2:
                obj = "dotted";
                break;
            case 3:
                obj = "solid";
                break;
            default:
                obj = null;
                break;
        }
        if (obj != null) {
            hashMap.put("btype", obj);
        }
        switch (searchAdRequestParcel.f3122i) {
            case 0:
                obj2 = "light";
                break;
            case 1:
                obj2 = "medium";
                break;
            case 2:
                obj2 = "dark";
                break;
        }
        if (obj2 != null) {
            hashMap.put("callbuttoncolor", obj2);
        }
        if (searchAdRequestParcel.f3123j != null) {
            hashMap.put("channel", searchAdRequestParcel.f3123j);
        }
        if (Color.alpha(searchAdRequestParcel.f3124k) != 0) {
            hashMap.put("dcolor", ig.m8893a(searchAdRequestParcel.f3124k));
        }
        if (searchAdRequestParcel.f3125l != null) {
            hashMap.put("font", searchAdRequestParcel.f3125l);
        }
        if (Color.alpha(searchAdRequestParcel.f3126m) != 0) {
            hashMap.put("hcolor", ig.m8893a(searchAdRequestParcel.f3126m));
        }
        hashMap.put("headersize", Integer.toString(searchAdRequestParcel.f3127n));
        if (searchAdRequestParcel.f3128o != null) {
            hashMap.put("q", searchAdRequestParcel.f3128o);
        }
    }

    private static void m8902a(HashMap<String, Object> hashMap, il ilVar, C1611a c1611a, Bundle bundle) {
        hashMap.put("am", Integer.valueOf(ilVar.f5270a));
        hashMap.put("cog", ig.m8892a(ilVar.f5271b));
        hashMap.put("coh", ig.m8892a(ilVar.f5272c));
        if (!TextUtils.isEmpty(ilVar.f5273d)) {
            hashMap.put("carrier", ilVar.f5273d);
        }
        hashMap.put("gl", ilVar.f5274e);
        if (ilVar.f5275f) {
            hashMap.put("simulator", Integer.valueOf(1));
        }
        if (ilVar.f5276g) {
            hashMap.put("is_sidewinder", Integer.valueOf(1));
        }
        hashMap.put("ma", ig.m8892a(ilVar.f5277h));
        hashMap.put("sp", ig.m8892a(ilVar.f5278i));
        hashMap.put("hl", ilVar.f5279j);
        if (!TextUtils.isEmpty(ilVar.f5280k)) {
            hashMap.put("mv", ilVar.f5280k);
        }
        hashMap.put("muv", Integer.valueOf(ilVar.f5281l));
        if (ilVar.f5282m != -2) {
            hashMap.put("cnt", Integer.valueOf(ilVar.f5282m));
        }
        hashMap.put("gnt", Integer.valueOf(ilVar.f5283n));
        hashMap.put("pt", Integer.valueOf(ilVar.f5284o));
        hashMap.put("rm", Integer.valueOf(ilVar.f5285p));
        hashMap.put("riv", Integer.valueOf(ilVar.f5286q));
        Bundle bundle2 = new Bundle();
        bundle2.putString("build", ilVar.f5294y);
        Bundle bundle3 = new Bundle();
        bundle3.putBoolean("is_charging", ilVar.f5291v);
        bundle3.putDouble("battery_level", ilVar.f5290u);
        bundle2.putBundle("battery", bundle3);
        bundle3 = new Bundle();
        bundle3.putInt("active_network_state", ilVar.f5293x);
        bundle3.putBoolean("active_network_metered", ilVar.f5292w);
        if (c1611a != null) {
            Bundle bundle4 = new Bundle();
            bundle4.putInt("predicted_latency_micros", 0);
            bundle4.putLong("predicted_down_throughput_bps", 0);
            bundle4.putLong("predicted_up_throughput_bps", 0);
            bundle3.putBundle("predictions", bundle4);
        }
        bundle2.putBundle("network", bundle3);
        bundle3 = new Bundle();
        bundle3.putBoolean("is_browser_custom_tabs_capable", ilVar.f5295z);
        bundle2.putBundle("browser", bundle3);
        if (bundle != null) {
            bundle2.putBundle("android_mem_info", ig.m8890a(bundle));
        }
        hashMap.put("device", bundle2);
    }

    private static void m8903a(HashMap<String, Object> hashMap, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("doritos", str);
        hashMap.put("pii", bundle);
    }
}
