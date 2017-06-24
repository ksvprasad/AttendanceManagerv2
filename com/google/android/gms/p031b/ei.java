package com.google.android.gms.p031b;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.C1123e;
import com.google.android.gms.ads.internal.C1319u;
import com.google.android.gms.ads.internal.overlay.AdLauncherIntentInfoParcel;
import com.google.android.gms.ads.internal.util.client.C1324b;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@id
public final class ei implements eb {
    private final ed f4537a;
    private final C1123e f4538b;
    private final gp f4539c;

    public static class C1452a {
        private final la f4536a;

        public C1452a(la laVar) {
            this.f4536a = laVar;
        }

        public Intent m8031a(Context context, Map<String, String> map) {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            String str = (String) map.get("u");
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            if (this.f4536a != null) {
                str = C1319u.m7183e().m9205a(this.f4536a, str);
            }
            Uri parse = Uri.parse(str);
            boolean parseBoolean = Boolean.parseBoolean((String) map.get("use_first_package"));
            boolean parseBoolean2 = Boolean.parseBoolean((String) map.get("use_running_process"));
            Uri build = "http".equalsIgnoreCase(parse.getScheme()) ? parse.buildUpon().scheme("https").build() : "https".equalsIgnoreCase(parse.getScheme()) ? parse.buildUpon().scheme("http").build() : null;
            ArrayList arrayList = new ArrayList();
            Intent a = m8033a(parse);
            Intent a2 = m8033a(build);
            ResolveInfo a3 = m8035a(context, a, arrayList);
            if (a3 != null) {
                return m8032a(a, a3);
            }
            if (a2 != null) {
                ResolveInfo a4 = m8034a(context, a2);
                if (a4 != null) {
                    Intent a5 = m8032a(a, a4);
                    if (m8034a(context, a5) != null) {
                        return a5;
                    }
                }
            }
            if (arrayList.size() == 0) {
                return a;
            }
            if (parseBoolean2 && activityManager != null) {
                List<RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
                if (runningAppProcesses != null) {
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        ResolveInfo resolveInfo = (ResolveInfo) it.next();
                        for (RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                            if (runningAppProcessInfo.processName.equals(resolveInfo.activityInfo.packageName)) {
                                return m8032a(a, resolveInfo);
                            }
                        }
                    }
                }
            }
            return parseBoolean ? m8032a(a, (ResolveInfo) arrayList.get(0)) : a;
        }

        public Intent m8032a(Intent intent, ResolveInfo resolveInfo) {
            Intent intent2 = new Intent(intent);
            intent2.setClassName(resolveInfo.activityInfo.packageName, resolveInfo.activityInfo.name);
            return intent2;
        }

        public Intent m8033a(Uri uri) {
            if (uri == null) {
                return null;
            }
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.addFlags(268435456);
            intent.setData(uri);
            intent.setAction("android.intent.action.VIEW");
            return intent;
        }

        public ResolveInfo m8034a(Context context, Intent intent) {
            return m8035a(context, intent, new ArrayList());
        }

        public ResolveInfo m8035a(Context context, Intent intent, ArrayList<ResolveInfo> arrayList) {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                return null;
            }
            ResolveInfo resolveInfo;
            Collection queryIntentActivities = packageManager.queryIntentActivities(intent, 65536);
            ResolveInfo resolveActivity = packageManager.resolveActivity(intent, 65536);
            if (!(queryIntentActivities == null || resolveActivity == null)) {
                for (int i = 0; i < queryIntentActivities.size(); i++) {
                    resolveInfo = (ResolveInfo) queryIntentActivities.get(i);
                    if (resolveActivity != null && resolveActivity.activityInfo.name.equals(resolveInfo.activityInfo.name)) {
                        resolveInfo = resolveActivity;
                        break;
                    }
                }
            }
            resolveInfo = null;
            arrayList.addAll(queryIntentActivities);
            return resolveInfo;
        }
    }

    public ei(ed edVar, C1123e c1123e, gp gpVar) {
        this.f4537a = edVar;
        this.f4538b = c1123e;
        this.f4539c = gpVar;
    }

    private void m8036a(boolean z) {
        if (this.f4539c != null) {
            this.f4539c.m8650a(z);
        }
    }

    private static boolean m8037a(Map<String, String> map) {
        return "1".equals(map.get("custom_close"));
    }

    private static int m8038b(Map<String, String> map) {
        String str = (String) map.get("o");
        if (str != null) {
            if ("p".equalsIgnoreCase(str)) {
                return C1319u.m7185g().mo1465b();
            }
            if ("l".equalsIgnoreCase(str)) {
                return C1319u.m7185g().mo1463a();
            }
            if ("c".equalsIgnoreCase(str)) {
                return C1319u.m7185g().mo1480c();
            }
        }
        return -1;
    }

    private static void m8039b(la laVar, Map<String, String> map) {
        Context context = laVar.getContext();
        if (TextUtils.isEmpty((String) map.get("u"))) {
            C1324b.m7234d("Destination url cannot be empty.");
            return;
        }
        try {
            laVar.mo1519l().m9460a(new AdLauncherIntentInfoParcel(new C1452a(laVar).m8031a(context, (Map) map)));
        } catch (ActivityNotFoundException e) {
            C1324b.m7234d(e.getMessage());
        }
    }

    public void mo997a(la laVar, Map<String, String> map) {
        String str = (String) map.get("a");
        if (str == null) {
            C1324b.m7234d("Action missing from an open GMSG.");
        } else if (this.f4538b == null || this.f4538b.m6301b()) {
            lb l = laVar.mo1519l();
            if ("expand".equalsIgnoreCase(str)) {
                if (laVar.mo1528p()) {
                    C1324b.m7234d("Cannot expand WebView that is already expanded.");
                    return;
                }
                m8036a(false);
                l.m9468a(ei.m8037a((Map) map), ei.m8038b(map));
            } else if ("webapp".equalsIgnoreCase(str)) {
                str = (String) map.get("u");
                m8036a(false);
                if (str != null) {
                    l.m9469a(ei.m8037a((Map) map), ei.m8038b(map), str);
                } else {
                    l.m9470a(ei.m8037a((Map) map), ei.m8038b(map), (String) map.get("html"), (String) map.get("baseurl"));
                }
            } else if ("in_app_purchase".equalsIgnoreCase(str)) {
                str = (String) map.get("product_id");
                String str2 = (String) map.get("report_urls");
                if (this.f4537a == null) {
                    return;
                }
                if (str2 == null || str2.isEmpty()) {
                    this.f4537a.mo978a(str, new ArrayList());
                } else {
                    this.f4537a.mo978a(str, new ArrayList(Arrays.asList(str2.split(" "))));
                }
            } else if ("app".equalsIgnoreCase(str) && "true".equalsIgnoreCase((String) map.get("system_browser"))) {
                m8036a(true);
                ei.m8039b(laVar, map);
            } else {
                m8036a(true);
                str = (String) map.get("u");
                l.m9460a(new AdLauncherIntentInfoParcel((String) map.get("i"), !TextUtils.isEmpty(str) ? C1319u.m7183e().m9205a(laVar, str) : str, (String) map.get("m"), (String) map.get("p"), (String) map.get("c"), (String) map.get("f"), (String) map.get("e")));
            }
        } else {
            this.f4538b.m6300a((String) map.get("u"));
        }
    }
}
