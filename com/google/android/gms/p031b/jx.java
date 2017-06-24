package com.google.android.gms.p031b;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import com.google.android.gms.b.jx.AnonymousClass10;
import com.google.android.gms.b.jx.AnonymousClass11;
import com.google.android.gms.p031b.jx.C1636b;
import com.google.android.gms.p031b.jx.C1640a;
import java.util.concurrent.Future;

@id
public final class jx {

    public interface C1636b {
        void mo1462a(Bundle bundle);
    }

    private static abstract class C1640a extends ju {
        private C1640a() {
        }

        public void mo1109b() {
        }
    }

    class AnonymousClass10 extends C1640a {
        final /* synthetic */ Context f5524a;
        final /* synthetic */ C1636b f5525b;

        AnonymousClass10(Context context, C1636b c1636b) {
            this.f5524a = context;
            this.f5525b = c1636b;
            super();
        }

        public void mo1108a() {
            SharedPreferences a = com.google.android.gms.p031b.jx.m9165a(this.f5524a);
            Bundle bundle = new Bundle();
            bundle.putBoolean("content_url_opted_out", a.getBoolean("content_url_opted_out", true));
            if (this.f5525b != null) {
                this.f5525b.mo1462a(bundle);
            }
        }
    }

    class AnonymousClass11 extends C1640a {
        final /* synthetic */ Context f5526a;
        final /* synthetic */ String f5527b;

        AnonymousClass11(Context context, String str) {
            this.f5526a = context;
            this.f5527b = str;
            super();
        }

        public void mo1108a() {
            Editor edit = com.google.android.gms.p031b.jx.m9165a(this.f5526a).edit();
            edit.putString("content_url_hashes", this.f5527b);
            edit.apply();
        }
    }

    class C16411 extends C1640a {
        final /* synthetic */ Context f5528a;
        final /* synthetic */ boolean f5529b;

        C16411(Context context, boolean z) {
            this.f5528a = context;
            this.f5529b = z;
            super();
        }

        public void mo1108a() {
            Editor edit = jx.m9165a(this.f5528a).edit();
            edit.putBoolean("use_https", this.f5529b);
            edit.apply();
        }
    }

    class C16422 extends C1640a {
        final /* synthetic */ Context f5530a;
        final /* synthetic */ C1636b f5531b;

        C16422(Context context, C1636b c1636b) {
            this.f5530a = context;
            this.f5531b = c1636b;
            super();
        }

        public void mo1108a() {
            SharedPreferences a = jx.m9165a(this.f5530a);
            Bundle bundle = new Bundle();
            bundle.putString("content_url_hashes", a.getString("content_url_hashes", ""));
            if (this.f5531b != null) {
                this.f5531b.mo1462a(bundle);
            }
        }
    }

    class C16433 extends C1640a {
        final /* synthetic */ Context f5532a;
        final /* synthetic */ boolean f5533b;

        C16433(Context context, boolean z) {
            this.f5532a = context;
            this.f5533b = z;
            super();
        }

        public void mo1108a() {
            Editor edit = jx.m9165a(this.f5532a).edit();
            edit.putBoolean("auto_collect_location", this.f5533b);
            edit.apply();
        }
    }

    class C16444 extends C1640a {
        final /* synthetic */ Context f5534a;
        final /* synthetic */ C1636b f5535b;

        C16444(Context context, C1636b c1636b) {
            this.f5534a = context;
            this.f5535b = c1636b;
            super();
        }

        public void mo1108a() {
            SharedPreferences a = jx.m9165a(this.f5534a);
            Bundle bundle = new Bundle();
            bundle.putBoolean("auto_collect_location", a.getBoolean("auto_collect_location", false));
            if (this.f5535b != null) {
                this.f5535b.mo1462a(bundle);
            }
        }
    }

    class C16455 extends C1640a {
        final /* synthetic */ Context f5536a;
        final /* synthetic */ String f5537b;
        final /* synthetic */ long f5538c;

        C16455(Context context, String str, long j) {
            this.f5536a = context;
            this.f5537b = str;
            this.f5538c = j;
            super();
        }

        public void mo1108a() {
            Editor edit = jx.m9165a(this.f5536a).edit();
            edit.putString("app_settings_json", this.f5537b);
            edit.putLong("app_settings_last_update_ms", this.f5538c);
            edit.apply();
        }
    }

    class C16466 extends C1640a {
        final /* synthetic */ Context f5539a;
        final /* synthetic */ C1636b f5540b;

        C16466(Context context, C1636b c1636b) {
            this.f5539a = context;
            this.f5540b = c1636b;
            super();
        }

        public void mo1108a() {
            SharedPreferences a = jx.m9165a(this.f5539a);
            Bundle bundle = new Bundle();
            bundle.putString("app_settings_json", a.getString("app_settings_json", ""));
            bundle.putLong("app_settings_last_update_ms", a.getLong("app_settings_last_update_ms", 0));
            if (this.f5540b != null) {
                this.f5540b.mo1462a(bundle);
            }
        }
    }

    class C16477 extends C1640a {
        final /* synthetic */ Context f5541a;
        final /* synthetic */ C1636b f5542b;

        C16477(Context context, C1636b c1636b) {
            this.f5541a = context;
            this.f5542b = c1636b;
            super();
        }

        public void mo1108a() {
            SharedPreferences a = jx.m9165a(this.f5541a);
            Bundle bundle = new Bundle();
            bundle.putBoolean("use_https", a.getBoolean("use_https", true));
            if (this.f5542b != null) {
                this.f5542b.mo1462a(bundle);
            }
        }
    }

    class C16488 extends C1640a {
        final /* synthetic */ Context f5543a;
        final /* synthetic */ C1636b f5544b;

        C16488(Context context, C1636b c1636b) {
            this.f5543a = context;
            this.f5544b = c1636b;
            super();
        }

        public void mo1108a() {
            SharedPreferences a = jx.m9165a(this.f5543a);
            Bundle bundle = new Bundle();
            bundle.putInt("webview_cache_version", a.getInt("webview_cache_version", 0));
            if (this.f5544b != null) {
                this.f5544b.mo1462a(bundle);
            }
        }
    }

    class C16499 extends C1640a {
        final /* synthetic */ Context f5545a;
        final /* synthetic */ boolean f5546b;

        C16499(Context context, boolean z) {
            this.f5545a = context;
            this.f5546b = z;
            super();
        }

        public void mo1108a() {
            Editor edit = jx.m9165a(this.f5545a).edit();
            edit.putBoolean("content_url_opted_out", this.f5546b);
            edit.apply();
        }
    }

    public static SharedPreferences m9165a(Context context) {
        return context.getSharedPreferences("admob", 0);
    }

    public static Future m9166a(Context context, C1636b c1636b) {
        return (Future) new C16477(context, c1636b).mo1107e();
    }

    public static Future m9167a(Context context, String str) {
        return (Future) new AnonymousClass11(context, str).mo1107e();
    }

    public static Future m9168a(Context context, String str, long j) {
        return (Future) new C16455(context, str, j).mo1107e();
    }

    public static Future m9169a(Context context, boolean z) {
        return (Future) new C16411(context, z).mo1107e();
    }

    public static Future m9170b(Context context, C1636b c1636b) {
        return (Future) new C16488(context, c1636b).mo1107e();
    }

    public static Future m9171b(Context context, boolean z) {
        return (Future) new C16499(context, z).mo1107e();
    }

    public static Future m9172c(Context context, C1636b c1636b) {
        return (Future) new AnonymousClass10(context, c1636b).mo1107e();
    }

    public static Future m9173c(Context context, boolean z) {
        return (Future) new C16433(context, z).mo1107e();
    }

    public static Future m9174d(Context context, C1636b c1636b) {
        return (Future) new C16422(context, c1636b).mo1107e();
    }

    public static Future m9175e(Context context, C1636b c1636b) {
        return (Future) new C16444(context, c1636b).mo1107e();
    }

    public static Future m9176f(Context context, C1636b c1636b) {
        return (Future) new C16466(context, c1636b).mo1107e();
    }
}
