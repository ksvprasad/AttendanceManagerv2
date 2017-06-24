package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.C1896c;
import com.google.android.gms.p031b.ni;

public final class C2096x {
    public static C2095a<Long> f6993A = C2095a.m11974a("measurement.service_client.idle_disconnect_millis", 5000);
    public static C2095a<Boolean> f6994a = C2095a.m11978a("measurement.service_enabled", true);
    public static C2095a<Boolean> f6995b = C2095a.m11978a("measurement.service_client_enabled", true);
    public static C2095a<String> f6996c = C2095a.m11977a("measurement.log_tag", "FA", "FA-SVC");
    public static C2095a<Long> f6997d = C2095a.m11974a("measurement.ad_id_cache_time", 10000);
    public static C2095a<Long> f6998e = C2095a.m11974a("measurement.monitoring.sample_period_millis", 86400000);
    public static C2095a<Long> f6999f = C2095a.m11975a("measurement.config.cache_time", 86400000, 3600000);
    public static C2095a<String> f7000g = C2095a.m11976a("measurement.config.url_scheme", "https");
    public static C2095a<String> f7001h = C2095a.m11976a("measurement.config.url_authority", "app-measurement.com");
    public static C2095a<Integer> f7002i = C2095a.m11972a("measurement.upload.max_bundles", 100);
    public static C2095a<Integer> f7003j = C2095a.m11972a("measurement.upload.max_batch_size", 65536);
    public static C2095a<Integer> f7004k = C2095a.m11972a("measurement.upload.max_bundle_size", 65536);
    public static C2095a<Integer> f7005l = C2095a.m11972a("measurement.upload.max_events_per_bundle", 1000);
    public static C2095a<Integer> f7006m = C2095a.m11972a("measurement.upload.max_events_per_day", 100000);
    public static C2095a<Integer> f7007n = C2095a.m11972a("measurement.upload.max_public_events_per_day", 50000);
    public static C2095a<Integer> f7008o = C2095a.m11972a("measurement.upload.max_conversions_per_day", 500);
    public static C2095a<Integer> f7009p = C2095a.m11972a("measurement.store.max_stored_events_per_app", 100000);
    public static C2095a<String> f7010q = C2095a.m11976a("measurement.upload.url", "https://app-measurement.com/a");
    public static C2095a<Long> f7011r = C2095a.m11974a("measurement.upload.backoff_period", 43200000);
    public static C2095a<Long> f7012s = C2095a.m11974a("measurement.upload.window_interval", 3600000);
    public static C2095a<Long> f7013t = C2095a.m11974a("measurement.upload.interval", 3600000);
    public static C2095a<Long> f7014u = C2095a.m11974a("measurement.upload.stale_data_deletion_interval", 86400000);
    public static C2095a<Long> f7015v = C2095a.m11974a("measurement.upload.initial_upload_delay_time", 15000);
    public static C2095a<Long> f7016w = C2095a.m11974a("measurement.upload.retry_time", 1800000);
    public static C2095a<Integer> f7017x = C2095a.m11972a("measurement.upload.retry_count", 6);
    public static C2095a<Long> f7018y = C2095a.m11974a("measurement.upload.max_queue_time", 2419200000L);
    public static C2095a<Integer> f7019z = C2095a.m11972a("measurement.lifetimevalue.max_currency_tracked", 4);

    public static final class C2095a<V> {
        private final V f6990a;
        private final ni<V> f6991b;
        private final String f6992c;

        private C2095a(String str, ni<V> niVar, V v) {
            C1896c.m10790a((Object) niVar);
            this.f6991b = niVar;
            this.f6990a = v;
            this.f6992c = str;
        }

        static C2095a<Integer> m11972a(String str, int i) {
            return C2095a.m11973a(str, i, i);
        }

        static C2095a<Integer> m11973a(String str, int i, int i2) {
            return new C2095a(str, ni.m10140a(str, Integer.valueOf(i2)), Integer.valueOf(i));
        }

        static C2095a<Long> m11974a(String str, long j) {
            return C2095a.m11975a(str, j, j);
        }

        static C2095a<Long> m11975a(String str, long j, long j2) {
            return new C2095a(str, ni.m10141a(str, Long.valueOf(j2)), Long.valueOf(j));
        }

        static C2095a<String> m11976a(String str, String str2) {
            return C2095a.m11977a(str, str2, str2);
        }

        static C2095a<String> m11977a(String str, String str2, String str3) {
            return new C2095a(str, ni.m10142a(str, str3), str2);
        }

        static C2095a<Boolean> m11978a(String str, boolean z) {
            return C2095a.m11979a(str, z, z);
        }

        static C2095a<Boolean> m11979a(String str, boolean z, boolean z2) {
            return new C2095a(str, ni.m10143a(str, z2), Boolean.valueOf(z));
        }

        public V m11980a(V v) {
            return v != null ? v : this.f6990a;
        }

        public String m11981a() {
            return this.f6992c;
        }

        public V m11982b() {
            return this.f6990a;
        }
    }
}
