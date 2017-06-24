package com.google.android.gms.common.stats;

import com.google.android.gms.p031b.ni;

public final class C1962c {
    public static ni<Integer> f6583a = ni.m10140a("gms:common:stats:max_num_of_events", Integer.valueOf(100));
    public static ni<Integer> f6584b = ni.m10140a("gms:common:stats:max_chunk_size", Integer.valueOf(100));

    public static final class C1960a {
        public static ni<Integer> f6575a = ni.m10140a("gms:common:stats:connections:level", Integer.valueOf(C1963d.f6586b));
        public static ni<String> f6576b = ni.m10142a("gms:common:stats:connections:ignored_calling_processes", "");
        public static ni<String> f6577c = ni.m10142a("gms:common:stats:connections:ignored_calling_services", "");
        public static ni<String> f6578d = ni.m10142a("gms:common:stats:connections:ignored_target_processes", "");
        public static ni<String> f6579e = ni.m10142a("gms:common:stats:connections:ignored_target_services", "com.google.android.gms.auth.GetToken");
        public static ni<Long> f6580f = ni.m10141a("gms:common:stats:connections:time_out_duration", Long.valueOf(600000));
    }

    public static final class C1961b {
        public static ni<Integer> f6581a = ni.m10140a("gms:common:stats:wakeLocks:level", Integer.valueOf(C1963d.f6586b));
        public static ni<Long> f6582b = ni.m10141a("gms:common:stats:wakelocks:time_out_duration", Long.valueOf(600000));
    }
}
