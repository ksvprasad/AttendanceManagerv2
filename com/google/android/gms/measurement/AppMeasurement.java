package com.google.android.gms.measurement;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Keep;
import com.google.android.gms.common.internal.C1896c;
import com.google.android.gms.common.util.C1971d;
import com.google.android.gms.measurement.internal.aj;
import java.util.Map;

@Deprecated
public class AppMeasurement {
    private final aj f6653a;

    public static final class C2009a {
        public static final Map<String, String> f6650a = C1971d.m11077a(new String[]{"app_clear_data", "app_exception", "app_uninstall", "app_update", "firebase_campaign", "error", "first_open", "in_app_purchase", "notification_dismiss", "notification_foreground", "notification_open", "notification_receive", "os_update", "session_start", "user_engagement"}, new String[]{"_cd", "_ae", "_ui", "_au", "_cmp", "_err", "_f", "_iap", "_nd", "_nf", "_no", "_nr", "_ou", "_s", "_e"});
    }

    public interface C2010b {
        void m11187a(String str, String str2, Bundle bundle, long j);
    }

    public interface C2011c {
        void m11188a(String str, String str2, Bundle bundle, long j);
    }

    public static final class C2012d {
        public static final Map<String, String> f6651a = C1971d.m11077a(new String[]{"firebase_conversion", "engagement_time_msec", "firebase_error", "error_value", "firebase_event_origin", "message_device_time", "message_id", "message_name", "message_time", "previous_app_version", "previous_os_version", "topic"}, new String[]{"_c", "_et", "_err", "_ev", "_o", "_ndt", "_nmid", "_nmn", "_nmt", "_pv", "_po", "_nt"});
    }

    public static final class C2013e {
        public static final Map<String, String> f6652a = C1971d.m11077a(new String[]{"firebase_last_notification", "first_open_time", "last_deep_link_referrer", "user_id"}, new String[]{"_ln", "_fot", "_ldl", "_id"});
    }

    public AppMeasurement(aj ajVar) {
        C1896c.m10790a((Object) ajVar);
        this.f6653a = ajVar;
    }

    @Keep
    @Deprecated
    public static AppMeasurement getInstance(Context context) {
        return aj.m11458a(context).m11509m();
    }

    @Deprecated
    public void m11189a(String str, Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        if (this.f6653a.m11499d().m11833O() || !"_iap".equals(str)) {
            int b = this.f6653a.m11510n().m11775b(str);
            if (b != 0) {
                this.f6653a.m11510n().m11762a(b, "_ev", this.f6653a.m11510n().m11761a(str, this.f6653a.m11499d().m11852c(), true));
                return;
            }
        }
        this.f6653a.m11508l().m11580a("app", str, bundle, true);
    }
}
