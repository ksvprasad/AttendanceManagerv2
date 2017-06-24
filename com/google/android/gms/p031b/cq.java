package com.google.android.gms.p031b;

import android.content.Context;
import com.google.android.gms.ads.internal.C1319u;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

@id
public final class cq {
    public static final cl<String> f4360A = cl.m7797b(0, "gads:looper_for_gms_client:experiment_id");
    public static final cl<Boolean> f4361B = cl.m7795a(0, "gads:looper_for_gms_client:enabled", Boolean.valueOf(true));
    public static final cl<Boolean> f4362C = cl.m7795a(0, "gads:sw_ad_request_service:enabled", Boolean.valueOf(true));
    public static final cl<Boolean> f4363D = cl.m7795a(0, "gads:sw_dynamite:enabled", Boolean.valueOf(true));
    public static final cl<String> f4364E = cl.m7796a(0, "gad:mraid:url_banner", "https://googleads.g.doubleclick.net/mads/static/mad/sdk/native/mraid/v2/mraid_app_banner.js");
    public static final cl<String> f4365F = cl.m7796a(0, "gad:mraid:url_expanded_banner", "https://googleads.g.doubleclick.net/mads/static/mad/sdk/native/mraid/v2/mraid_app_expanded_banner.js");
    public static final cl<String> f4366G = cl.m7796a(0, "gad:mraid:url_interstitial", "https://googleads.g.doubleclick.net/mads/static/mad/sdk/native/mraid/v2/mraid_app_interstitial.js");
    public static final cl<Boolean> f4367H = cl.m7795a(0, "gads:enabled_sdk_csi", Boolean.valueOf(false));
    public static final cl<String> f4368I = cl.m7796a(0, "gads:sdk_csi_server", "https://csi.gstatic.com/csi");
    public static final cl<Boolean> f4369J = cl.m7795a(0, "gads:sdk_csi_write_to_file", Boolean.valueOf(false));
    public static final cl<Boolean> f4370K = cl.m7795a(0, "gads:enable_content_fetching", Boolean.valueOf(true));
    public static final cl<Integer> f4371L = cl.m7793a(0, "gads:content_length_weight", 1);
    public static final cl<Integer> f4372M = cl.m7793a(0, "gads:content_age_weight", 1);
    public static final cl<Integer> f4373N = cl.m7793a(0, "gads:min_content_len", 11);
    public static final cl<Integer> f4374O = cl.m7793a(0, "gads:fingerprint_number", 10);
    public static final cl<Integer> f4375P = cl.m7793a(0, "gads:sleep_sec", 10);
    public static final cl<Boolean> f4376Q = cl.m7795a(0, "gad:app_index_enabled", Boolean.valueOf(true));
    public static final cl<Boolean> f4377R = cl.m7795a(0, "gads:app_index:without_content_info_present:enabled", Boolean.valueOf(true));
    public static final cl<Long> f4378S = cl.m7794a(0, "gads:app_index:timeout_ms", 1000);
    public static final cl<String> f4379T = cl.m7792a(0, "gads:app_index:experiment_id");
    public static final cl<String> f4380U = cl.m7792a(0, "gads:kitkat_interstitial_workaround:experiment_id");
    public static final cl<Boolean> f4381V = cl.m7795a(0, "gads:kitkat_interstitial_workaround:enabled", Boolean.valueOf(true));
    public static final cl<Boolean> f4382W = cl.m7795a(0, "gads:interstitial_follow_url", Boolean.valueOf(true));
    public static final cl<Boolean> f4383X = cl.m7795a(0, "gads:interstitial_follow_url:register_click", Boolean.valueOf(true));
    public static final cl<String> f4384Y = cl.m7792a(0, "gads:interstitial_follow_url:experiment_id");
    public static final cl<Boolean> f4385Z = cl.m7795a(0, "gads:analytics_enabled", Boolean.valueOf(true));
    public static final cl<String> f4386a = cl.m7792a(0, "gads:sdk_core_experiment_id");
    public static final cl<Boolean> aA = cl.m7795a(0, "gads:ad_settings_page_reporting:enabled", Boolean.valueOf(false));
    public static final cl<Boolean> aB = cl.m7795a(0, "gads:adid_info_gmscore_upgrade_reporting:enabled", Boolean.valueOf(false));
    public static final cl<Boolean> aC = cl.m7795a(0, "gads:request_pkg:enabled", Boolean.valueOf(true));
    public static final cl<Boolean> aD = cl.m7795a(0, "gads:gmsg:disable_back_button:enabled", Boolean.valueOf(false));
    public static final cl<Boolean> aE = cl.m7795a(0, "gads:gmsg:video_meta:enabled", Boolean.valueOf(true));
    public static final cl<String> aF = cl.m7792a(0, "gads:gmsg:video_meta:experiment_id");
    public static final cl<Long> aG = cl.m7794a(0, "gads:network:cache_prediction_duration_s", 300);
    public static final cl<Boolean> aH = cl.m7795a(0, "gads:mediation:dynamite_first:admobadapter", Boolean.valueOf(true));
    public static final cl<Boolean> aI = cl.m7795a(0, "gads:mediation:dynamite_first:adurladapter", Boolean.valueOf(true));
    public static final cl<Long> aJ = cl.m7794a(0, "gads:ad_loader:timeout_ms", 60000);
    public static final cl<Long> aK = cl.m7794a(0, "gads:rendering:timeout_ms", 60000);
    public static final cl<Boolean> aL = cl.m7795a(0, "gads:adshield:enable_adshield_instrumentation", Boolean.valueOf(false));
    public static final cl<Long> aM = cl.m7794a(1, "gads:gestures:task_timeout", 2000);
    public static final cl<String> aN = cl.m7792a(1, "gads:gestures:encrypt_size_limit:experiment_id");
    public static final cl<Boolean> aO = cl.m7795a(1, "gads:gestures:encrypt_size_limit:enabled", Boolean.valueOf(true));
    public static final cl<String> aP = cl.m7792a(1, "gads:gestures:cpu:experiment_id");
    public static final cl<Boolean> aQ = cl.m7795a(1, "gads:gestures:cpu_query:enabled", Boolean.valueOf(false));
    public static final cl<Boolean> aR = cl.m7795a(1, "gads:gestures:cpu_click:enabled", Boolean.valueOf(false));
    public static final cl<String> aS = cl.m7792a(1, "gads:gestures:jbk:experiment_id");
    public static final cl<Boolean> aT = cl.m7795a(1, "gads:gestures:jbk_query:enabled", Boolean.valueOf(false));
    public static final cl<Boolean> aU = cl.m7795a(1, "gads:gestures:jbk_click:enabled", Boolean.valueOf(false));
    public static final cl<String> aV = cl.m7792a(1, "gads:gestures:stk:experiment_id");
    public static final cl<Boolean> aW = cl.m7795a(1, "gads:gestures:stk:enabled", Boolean.valueOf(false));
    public static final cl<Boolean> aX = cl.m7795a(0, "gass:client:enabled", Boolean.valueOf(false));
    public static final cl<String> aY = cl.m7792a(0, "gass:client:experiment_id");
    public static final cl<Boolean> aZ = cl.m7795a(0, "gass:enabled", Boolean.valueOf(false));
    public static final cl<Boolean> aa = cl.m7795a(0, "gads:ad_key_enabled", Boolean.valueOf(false));
    public static final cl<Integer> ab = cl.m7793a(0, "gads:webview_cache_version", 0);
    public static final cl<Boolean> ac = cl.m7795a(1, "gads:webview_recycle:enabled", Boolean.valueOf(false));
    public static final cl<String> ad = cl.m7792a(1, "gads:webview_recycle:experiment_id");
    public static final cl<String> ae = cl.m7797b(0, "gads:pan:experiment_id");
    public static final cl<String> af = cl.m7796a(0, "gads:native:engine_url", "//googleads.g.doubleclick.net/mads/static/mad/sdk/native/native_ads.html");
    public static final cl<Boolean> ag = cl.m7795a(0, "gads:ad_manager_creator:enabled", Boolean.valueOf(true));
    public static final cl<Boolean> ah = cl.m7795a(1, "gads:interstitial_ad_pool:enabled", Boolean.valueOf(false));
    public static final cl<Boolean> ai = cl.m7795a(1, "gads:interstitial_ad_pool:enabled_for_rewarded", Boolean.valueOf(false));
    public static final cl<String> aj = cl.m7796a(1, "gads:interstitial_ad_pool:schema", "customTargeting");
    public static final cl<String> ak = cl.m7796a(1, "gads:interstitial_ad_pool:request_exclusions", "com.google.ads.mediation.admob.AdMobAdapter/_ad");
    public static final cl<Integer> al = cl.m7793a(1, "gads:interstitial_ad_pool:max_pools", 3);
    public static final cl<Integer> am = cl.m7793a(1, "gads:interstitial_ad_pool:max_pool_depth", 2);
    public static final cl<Integer> an = cl.m7793a(1, "gads:interstitial_ad_pool:time_limit_sec", 1200);
    public static final cl<String> ao = cl.m7796a(1, "gads:interstitial_ad_pool:ad_unit_exclusions", "(?!)");
    public static final cl<String> ap = cl.m7796a(1, "gads:spherical_video:vertex_shader", "");
    public static final cl<String> aq = cl.m7796a(1, "gads:spherical_video:fragment_shader", "");
    public static final cl<String> ar = cl.m7792a(1, "gads:spherical_video:experiment_id");
    public static final cl<Boolean> as = cl.m7795a(0, "gads:log:verbose_enabled", Boolean.valueOf(false));
    public static final cl<Boolean> at = cl.m7795a(1, "gads:include_local_global_rectangles", Boolean.valueOf(false));
    public static final cl<String> au = cl.m7792a(1, "gads:include_local_global_rectangles:experiment_id");
    public static final cl<Boolean> av = cl.m7795a(0, "gads:device_info_caching:enabled", Boolean.valueOf(true));
    public static final cl<Long> aw = cl.m7794a(0, "gads:device_info_caching_expiry_ms:expiry", 300000);
    public static final cl<Boolean> ax = cl.m7795a(0, "gads:gen204_signals:enabled", Boolean.valueOf(false));
    public static final cl<Boolean> ay = cl.m7795a(0, "gads:webview:error_reporting_enabled", Boolean.valueOf(false));
    public static final cl<Boolean> az = cl.m7795a(0, "gads:adid_reporting:enabled", Boolean.valueOf(false));
    public static final cl<String> f4387b = cl.m7796a(0, "gads:sdk_core_location", "https://googleads.g.doubleclick.net/mads/static/mad/sdk/native/sdk-core-v40.html");
    public static final cl<String> bA = cl.m7792a(0, "gads:afs:csa:experiment_id");
    public static final cl<String> bB = cl.m7796a(0, "gads:afs:csa_webview_gmsg_ad_failed", "gmsg://noAdLoaded");
    public static final cl<String> bC = cl.m7796a(0, "gads:afs:csa_webview_gmsg_script_load_failed", "gmsg://scriptLoadFailed");
    public static final cl<String> bD = cl.m7796a(0, "gads:afs:csa_webview_gmsg_ad_loaded", "gmsg://adResized");
    public static final cl<String> bE = cl.m7796a(0, "gads:afs:csa_webview_static_file_path", "/afs/ads/i/webview.html");
    public static final cl<String> bF = cl.m7796a(0, "gads:afs:csa_webview_custom_domain_param_key", "csa_customDomain");
    public static final cl<Long> bG = cl.m7794a(0, "gads:afs:csa_webview_adshield_timeout_ms", 1000);
    public static final cl<Boolean> bH = cl.m7795a(0, "gads:afs:csa_ad_manager_enabled", Boolean.valueOf(true));
    public static final cl<Boolean> bI = cl.m7795a(0, "gads:safe_browsing:reporting:malicious:enabled", Boolean.valueOf(false));
    public static final cl<Boolean> bJ = cl.m7795a(0, "gads:safe_browsing:reporting:full:enabled", Boolean.valueOf(false));
    public static final cl<Boolean> bK = cl.m7795a(0, "gads:safe_browsing:screenshot:enabled", Boolean.valueOf(false));
    public static final cl<String> bL = cl.m7796a(0, "gads:safe_browsing:reporting:url", "https://sb-ssl.google.com/safebrowsing/clientreport/malware");
    public static final cl<String> bM = cl.m7796a(0, "gads:safe_browsing:api_key", "AIzaSyDRKQ9d6kfsoZT2lUnZcZnBYvH69HExNPE");
    public static final cl<Long> bN = cl.m7794a(0, "gads:safe_browsing:safety_net:delay_ms", 2000);
    public static final cl<String> bO = cl.m7792a(0, "gads:safe_browsing:experiment_id");
    public static final cl<Boolean> bP = cl.m7795a(0, "gads:safe_browsing:debug", Boolean.valueOf(false));
    public static final cl<Boolean> bQ = cl.m7795a(0, "gads:webview_cookie:enabled", Boolean.valueOf(true));
    public static final cl<Boolean> ba = cl.m7795a(0, "gass:enable_int_signal", Boolean.valueOf(true));
    public static final cl<Boolean> bb = cl.m7795a(0, "gads:adid_notification:first_party_check:enabled", Boolean.valueOf(true));
    public static final cl<Boolean> bc = cl.m7795a(0, "gads:edu_device_helper:enabled", Boolean.valueOf(true));
    public static final cl<Boolean> bd = cl.m7795a(0, "gads:support_screen_shot", Boolean.valueOf(true));
    public static final cl<Boolean> be = cl.m7795a(0, "gads:use_get_drawing_cache_for_screenshot:enabled", Boolean.valueOf(true));
    public static final cl<String> bf = cl.m7792a(0, "gads:use_get_drawing_cache_for_screenshot:experiment_id");
    public static final cl<Long> bg = cl.m7794a(0, "gads:js_flags:update_interval", TimeUnit.HOURS.toMillis(12));
    public static final cl<Boolean> bh = cl.m7795a(0, "gads:custom_render:ping_on_ad_rendered", Boolean.valueOf(false));
    public static final cl<Boolean> bi = cl.m7795a(1, "gads:singleton_webview_native", Boolean.valueOf(false));
    public static final cl<String> bj = cl.m7792a(1, "gads:singleton_webview_native:experiment_id");
    public static final cl<Boolean> bk = cl.m7795a(1, "gads:enable_untrack_view_native", Boolean.valueOf(true));
    public static final cl<Boolean> bl = cl.m7795a(1, "gads:reset_listeners_preparead_native", Boolean.valueOf(true));
    public static final cl<Boolean> bm = cl.m7795a(0, "gads:method_tracing:enabled", Boolean.valueOf(false));
    public static final cl<Long> bn = cl.m7794a(0, "gads:method_tracing:duration_ms", 30000);
    public static final cl<Integer> bo = cl.m7793a(0, "gads:method_tracing:count", 5);
    public static final cl<Integer> bp = cl.m7793a(0, "gads:method_tracing:filesize", 134217728);
    public static final cl<Boolean> bq = cl.m7795a(1, "gads:auto_location_for_coarse_permission", Boolean.valueOf(false));
    public static final cl<String> br = cl.m7797b(1, "gads:auto_location_for_coarse_permission:experiment_id");
    public static final cl<Long> bs = cl.m7794a(1, "gads:auto_location_timeout", 2000);
    public static final cl<String> bt = cl.m7797b(1, "gads:auto_location_timeout:experiment_id");
    public static final cl<Long> bu = cl.m7794a(1, "gads:auto_location_interval", -1);
    public static final cl<String> bv = cl.m7797b(1, "gads:auto_location_interval:experiment_id");
    public static final cl<Boolean> bw = cl.m7795a(1, "gads:fetch_app_settings_using_cld:enabled", Boolean.valueOf(false));
    public static final cl<String> bx = cl.m7792a(1, "gads:fetch_app_settings_using_cld:enabled:experiment_id");
    public static final cl<Long> by = cl.m7794a(1, "gads:fetch_app_settings_using_cld:refresh_interval_ms", 7200000);
    public static final cl<String> bz = cl.m7792a(1, "gads:fetch_app_settings_using_cld:refresh_interval_ms:experiment_id");
    public static final cl<Boolean> f4388c = cl.m7795a(0, "gads:request_builder:singleton_webview", Boolean.valueOf(false));
    public static final cl<String> f4389d = cl.m7792a(0, "gads:request_builder:singleton_webview_experiment_id");
    public static final cl<Boolean> f4390e = cl.m7795a(0, "gads:sdk_use_dynamic_module", Boolean.valueOf(true));
    public static final cl<String> f4391f = cl.m7792a(0, "gads:sdk_use_dynamic_module_experiment_id");
    public static final cl<Boolean> f4392g = cl.m7795a(0, "gads:sdk_crash_report_enabled", Boolean.valueOf(false));
    public static final cl<Boolean> f4393h = cl.m7795a(0, "gads:sdk_crash_report_full_stacktrace", Boolean.valueOf(false));
    public static final cl<String> f4394i = cl.m7796a(0, "gads:sdk_crash_report_class_prefix", "com.google.");
    public static final cl<Boolean> f4395j = cl.m7795a(0, "gads:block_autoclicks", Boolean.valueOf(false));
    public static final cl<String> f4396k = cl.m7792a(0, "gads:block_autoclicks_experiment_id");
    public static final cl<String> f4397l = cl.m7797b(0, "gads:prefetch:experiment_id");
    public static final cl<String> f4398m = cl.m7792a(0, "gads:spam_app_context:experiment_id");
    public static final cl<Boolean> f4399n = cl.m7795a(0, "gads:spam_app_context:enabled", Boolean.valueOf(false));
    public static final cl<String> f4400o = cl.m7792a(0, "gads:video_stream_cache:experiment_id");
    public static final cl<Integer> f4401p = cl.m7793a(0, "gads:video_stream_cache:limit_count", 5);
    public static final cl<Integer> f4402q = cl.m7793a(0, "gads:video_stream_cache:limit_space", 8388608);
    public static final cl<Integer> f4403r = cl.m7793a(0, "gads:video_stream_exo_cache:buffer_size", 8388608);
    public static final cl<Long> f4404s = cl.m7794a(0, "gads:video_stream_cache:limit_time_sec", 300);
    public static final cl<Long> f4405t = cl.m7794a(0, "gads:video_stream_cache:notify_interval_millis", 1000);
    public static final cl<Integer> f4406u = cl.m7793a(0, "gads:video_stream_cache:connect_timeout_millis", 10000);
    public static final cl<Boolean> f4407v = cl.m7795a(0, "gads:video:metric_reporting_enabled", Boolean.valueOf(false));
    public static final cl<String> f4408w = cl.m7796a(0, "gads:video:metric_frame_hash_times", "");
    public static final cl<Long> f4409x = cl.m7794a(0, "gads:video:metric_frame_hash_time_leniency", 500);
    public static final cl<String> f4410y = cl.m7797b(0, "gads:spam_ad_id_decorator:experiment_id");
    public static final cl<Boolean> f4411z = cl.m7795a(0, "gads:spam_ad_id_decorator:enabled", Boolean.valueOf(false));

    class C14061 implements Callable<Void> {
        final /* synthetic */ Context f4359a;

        C14061(Context context) {
            this.f4359a = context;
        }

        public Void m7826a() {
            C1319u.m7192n().m7825a(this.f4359a);
            return null;
        }

        public /* synthetic */ Object call() {
            return m7826a();
        }
    }

    public static List<String> m7827a() {
        return C1319u.m7191m().m7810a();
    }

    public static void m7828a(Context context) {
        kl.m9352a(new C14061(context));
    }

    public static List<String> m7829b() {
        return C1319u.m7191m().m7812b();
    }
}
