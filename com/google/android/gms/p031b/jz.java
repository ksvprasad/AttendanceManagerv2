package com.google.android.gms.p031b;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.ActivityManager.RunningTaskInfo;
import android.app.AlertDialog.Builder;
import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Debug;
import android.os.Debug.MemoryInfo;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.os.PowerManager;
import android.os.Process;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.PopupWindow;
import com.google.android.gms.ads.internal.C1181o;
import com.google.android.gms.ads.internal.C1319u;
import com.google.android.gms.ads.internal.ClientApi;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.C1120y;
import com.google.android.gms.ads.internal.util.client.C1323a.C1321a;
import com.google.android.gms.ads.internal.util.client.C1324b;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.p031b.de.C1416a;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.Future;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@id
public class jz {
    public static final Handler f5567a = new jw(Looper.getMainLooper());
    private final Object f5568b = new Object();
    private boolean f5569c = true;
    private String f5570d;
    private boolean f5571e = false;
    private ff f5572f;

    private final class C1658a extends BroadcastReceiver {
        final /* synthetic */ jz f5566a;

        private C1658a(jz jzVar) {
            this.f5566a = jzVar;
        }

        public void onReceive(Context context, Intent intent) {
            if ("android.intent.action.USER_PRESENT".equals(intent.getAction())) {
                this.f5566a.f5569c = true;
            } else if ("android.intent.action.SCREEN_OFF".equals(intent.getAction())) {
                this.f5566a.f5569c = false;
            }
        }
    }

    private JSONArray m9187a(Collection<?> collection) {
        JSONArray jSONArray = new JSONArray();
        for (Object a : collection) {
            m9189a(jSONArray, a);
        }
        return jSONArray;
    }

    private JSONObject m9188a(Bundle bundle) {
        JSONObject jSONObject = new JSONObject();
        for (String str : bundle.keySet()) {
            m9190a(jSONObject, str, bundle.get(str));
        }
        return jSONObject;
    }

    private void m9189a(JSONArray jSONArray, Object obj) {
        if (obj instanceof Bundle) {
            jSONArray.put(m9188a((Bundle) obj));
        } else if (obj instanceof Map) {
            jSONArray.put(m9211a((Map) obj));
        } else if (obj instanceof Collection) {
            jSONArray.put(m9187a((Collection) obj));
        } else if (obj instanceof Object[]) {
            jSONArray.put(m9210a((Object[]) obj));
        } else {
            jSONArray.put(obj);
        }
    }

    private void m9190a(JSONObject jSONObject, String str, Object obj) {
        if (obj instanceof Bundle) {
            jSONObject.put(str, m9188a((Bundle) obj));
        } else if (obj instanceof Map) {
            jSONObject.put(str, m9211a((Map) obj));
        } else if (obj instanceof Collection) {
            if (str == null) {
                str = "null";
            }
            jSONObject.put(str, m9187a((Collection) obj));
        } else if (obj instanceof Object[]) {
            jSONObject.put(str, m9187a(Arrays.asList((Object[]) obj)));
        } else {
            jSONObject.put(str, obj);
        }
    }

    private boolean m9191a(KeyguardManager keyguardManager) {
        return keyguardManager == null ? false : keyguardManager.inKeyguardRestrictedInputMode();
    }

    private boolean m9192a(PowerManager powerManager) {
        return powerManager == null || powerManager.isScreenOn();
    }

    public static void m9194b(Runnable runnable) {
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
            runnable.run();
        } else {
            jy.m9180a(runnable);
        }
    }

    private Bitmap m9195c(View view) {
        try {
            int width = view.getWidth();
            int height = view.getHeight();
            if (width == 0 || height == 0) {
                C1324b.m7234d("Width or height of view is zero");
                return null;
            }
            Bitmap createBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Config.RGB_565);
            Canvas canvas = new Canvas(createBitmap);
            view.layout(0, 0, width, height);
            view.draw(canvas);
            return createBitmap;
        } catch (Throwable e) {
            C1324b.m7231b("Fail to capture the webview", e);
            return null;
        }
    }

    private Bitmap m9196d(View view) {
        Bitmap drawingCache;
        Throwable e;
        try {
            boolean isDrawingCacheEnabled = view.isDrawingCacheEnabled();
            view.setDrawingCacheEnabled(true);
            drawingCache = view.getDrawingCache();
            drawingCache = drawingCache != null ? Bitmap.createBitmap(drawingCache) : null;
            try {
                view.setDrawingCacheEnabled(isDrawingCacheEnabled);
            } catch (RuntimeException e2) {
                e = e2;
                C1324b.m7231b("Fail to capture the web view", e);
                return drawingCache;
            }
        } catch (Throwable e3) {
            Throwable th = e3;
            drawingCache = null;
            e = th;
            C1324b.m7231b("Fail to capture the web view", e);
            return drawingCache;
        }
        return drawingCache;
    }

    private boolean m9197m(Context context) {
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        return powerManager == null ? false : powerManager.isScreenOn();
    }

    public Bitmap m9198a(View view) {
        view.setDrawingCacheEnabled(true);
        Bitmap createBitmap = Bitmap.createBitmap(view.getDrawingCache());
        view.setDrawingCacheEnabled(false);
        return createBitmap;
    }

    public DisplayMetrics m9199a(WindowManager windowManager) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics;
    }

    public PopupWindow m9200a(View view, int i, int i2, boolean z) {
        return new PopupWindow(view, i, i2, z);
    }

    public ff m9201a(Context context, VersionInfoParcel versionInfoParcel) {
        ff ffVar;
        synchronized (this.f5568b) {
            if (this.f5572f == null) {
                if (context.getApplicationContext() != null) {
                    context = context.getApplicationContext();
                }
                this.f5572f = new ff(context, versionInfoParcel, (String) cq.f4387b.m7801c());
            }
            ffVar = this.f5572f;
        }
        return ffVar;
    }

    public String m9202a(Context context, View view, AdSizeParcel adSizeParcel) {
        String str = null;
        if (((Boolean) cq.aa.m7801c()).booleanValue()) {
            try {
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("width", adSizeParcel.f3108f);
                jSONObject2.put("height", adSizeParcel.f3105c);
                jSONObject.put("size", jSONObject2);
                jSONObject.put("activity", m9247f(context));
                if (!adSizeParcel.f3107e) {
                    JSONArray jSONArray = new JSONArray();
                    while (view != null) {
                        ViewParent parent = view.getParent();
                        if (parent != null) {
                            int i = -1;
                            if (parent instanceof ViewGroup) {
                                i = ((ViewGroup) parent).indexOfChild(view);
                            }
                            JSONObject jSONObject3 = new JSONObject();
                            jSONObject3.put("type", parent.getClass().getName());
                            jSONObject3.put("index_of_child", i);
                            jSONArray.put(jSONObject3);
                        }
                        View view2 = (parent == null || !(parent instanceof View)) ? null : (View) parent;
                        view = view2;
                    }
                    if (jSONArray.length() > 0) {
                        jSONObject.put("parents", jSONArray);
                    }
                }
                str = jSONObject.toString();
            } catch (Throwable e) {
                C1324b.m7235d("Fail to get view hierarchy json", e);
            }
        }
        return str;
    }

    public String m9203a(Context context, aj ajVar, String str) {
        if (ajVar != null) {
            try {
                Uri parse = Uri.parse(str);
                if (ajVar.m7440d(parse)) {
                    parse = ajVar.m7437b(parse, context);
                }
                str = parse.toString();
            } catch (Exception e) {
            }
        }
        return str;
    }

    public String m9204a(final Context context, String str) {
        String str2;
        synchronized (this.f5568b) {
            if (this.f5570d != null) {
                str2 = this.f5570d;
            } else {
                try {
                    this.f5570d = C1319u.m7185g().mo1478a(context);
                } catch (Exception e) {
                }
                if (TextUtils.isEmpty(this.f5570d)) {
                    if (C1120y.m6293a().m7222b()) {
                        try {
                            this.f5570d = m9239c(context);
                        } catch (Exception e2) {
                            this.f5570d = m9233b();
                        }
                    } else {
                        this.f5570d = null;
                        f5567a.post(new Runnable(this) {
                            final /* synthetic */ jz f5562b;

                            public void run() {
                                synchronized (this.f5562b.f5568b) {
                                    this.f5562b.f5570d = this.f5562b.m9239c(context);
                                    this.f5562b.f5568b.notifyAll();
                                }
                            }
                        });
                        while (this.f5570d == null) {
                            try {
                                this.f5568b.wait();
                            } catch (InterruptedException e3) {
                                this.f5570d = m9233b();
                                String str3 = "Interrupted, use default user agent: ";
                                str2 = String.valueOf(this.f5570d);
                                C1324b.m7234d(str2.length() != 0 ? str3.concat(str2) : new String(str3));
                            }
                        }
                    }
                }
                str2 = String.valueOf(this.f5570d);
                this.f5570d = new StringBuilder((String.valueOf(str2).length() + 11) + String.valueOf(str).length()).append(str2).append(" (Mobile; ").append(str).append(")").toString();
                str2 = this.f5570d;
            }
        }
        return str2;
    }

    public String m9205a(la laVar, String str) {
        return m9203a(laVar.getContext(), laVar.mo1524n(), str);
    }

    public String m9206a(InputStreamReader inputStreamReader) {
        StringBuilder stringBuilder = new StringBuilder(8192);
        char[] cArr = new char[2048];
        while (true) {
            int read = inputStreamReader.read(cArr);
            if (read == -1) {
                return stringBuilder.toString();
            }
            stringBuilder.append(cArr, 0, read);
        }
    }

    public String m9207a(String str) {
        return Uri.parse(str).buildUpon().query(null).build().toString();
    }

    public String m9208a(String str, Map<String, String> map) {
        for (String str2 : map.keySet()) {
            str = str.replaceAll(String.format("(?<!@)((?:@@)*)@%s(?<!@)((?:@@)*)@", new Object[]{str2}), String.format("$1%s$2", new Object[]{Uri.encode((String) map.get(str2))}));
        }
        return str.replaceAll(String.format("(?<!@)((?:@@)*)@%s(?<!@)((?:@@)*)@", new Object[]{"[^@]+"}), String.format("$1%s$2", new Object[]{""})).replaceAll("@@", "@");
    }

    public Map<String, String> m9209a(Uri uri) {
        if (uri == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        for (String str : C1319u.m7185g().mo1467a(uri)) {
            hashMap.put(str, uri.getQueryParameter(str));
        }
        return hashMap;
    }

    JSONArray m9210a(Object[] objArr) {
        JSONArray jSONArray = new JSONArray();
        for (Object a : objArr) {
            m9189a(jSONArray, a);
        }
        return jSONArray;
    }

    public JSONObject m9211a(Map<String, ?> map) {
        String valueOf;
        try {
            JSONObject jSONObject = new JSONObject();
            for (String valueOf2 : map.keySet()) {
                m9190a(jSONObject, valueOf2, map.get(valueOf2));
            }
            return jSONObject;
        } catch (ClassCastException e) {
            String str = "Could not convert map to JSON: ";
            valueOf2 = String.valueOf(e.getMessage());
            throw new JSONException(valueOf2.length() != 0 ? str.concat(valueOf2) : new String(str));
        }
    }

    public void m9212a(Activity activity, OnGlobalLayoutListener onGlobalLayoutListener) {
        Window window = activity.getWindow();
        if (window != null && window.getDecorView() != null && window.getDecorView().getViewTreeObserver() != null) {
            window.getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(onGlobalLayoutListener);
        }
    }

    public void m9213a(Activity activity, OnScrollChangedListener onScrollChangedListener) {
        Window window = activity.getWindow();
        if (window != null && window.getDecorView() != null && window.getDecorView().getViewTreeObserver() != null) {
            window.getDecorView().getViewTreeObserver().addOnScrollChangedListener(onScrollChangedListener);
        }
    }

    public void m9214a(Context context, Intent intent) {
        try {
            context.startActivity(intent);
        } catch (Throwable th) {
            intent.addFlags(268435456);
            context.startActivity(intent);
        }
    }

    public void m9215a(Context context, String str, WebSettings webSettings) {
        webSettings.setUserAgentString(m9204a(context, str));
    }

    public void m9216a(Context context, String str, String str2) {
        List arrayList = new ArrayList();
        arrayList.add(str2);
        m9218a(context, str, arrayList);
    }

    public void m9217a(final Context context, final String str, String str2, Bundle bundle, boolean z) {
        if (z) {
            bundle.putString("device", C1319u.m7183e().m9246e());
            bundle.putString("eids", TextUtils.join(",", cq.m7827a()));
        }
        C1120y.m6293a().m7215a(context, str, str2, bundle, z, new C1321a(this) {
            final /* synthetic */ jz f5565c;

            public void mo1229a(String str) {
                C1319u.m7183e().m9216a(context, str, str);
            }
        });
    }

    public void m9218a(Context context, String str, List<String> list) {
        for (String kiVar : list) {
            Future future = (Future) new ki(context, str, kiVar).mo1107e();
        }
    }

    public void m9219a(Context context, String str, boolean z, HttpURLConnection httpURLConnection) {
        m9220a(context, str, z, httpURLConnection, false);
    }

    public void m9220a(Context context, String str, boolean z, HttpURLConnection httpURLConnection, boolean z2) {
        httpURLConnection.setConnectTimeout(60000);
        httpURLConnection.setInstanceFollowRedirects(z);
        httpURLConnection.setReadTimeout(60000);
        httpURLConnection.setRequestProperty("User-Agent", m9204a(context, str));
        httpURLConnection.setUseCaches(z2);
    }

    public void m9221a(final Context context, final List<String> list) {
        if (!(context instanceof Activity) || TextUtils.isEmpty(af.m7424a((Activity) context))) {
            return;
        }
        if (list == null) {
            jv.m9152e("Cannot ping urls: empty list.");
        } else if (de.m7894a(context)) {
            final de deVar = new de();
            deVar.m7897a(new C1416a(this) {
                final /* synthetic */ jz f5560d;
            });
            deVar.m7898b((Activity) context);
        } else {
            jv.m9152e("Cannot ping url because custom tabs is not supported");
        }
    }

    public void m9222a(Runnable runnable) {
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            runnable.run();
        } else {
            f5567a.post(runnable);
        }
    }

    public void m9223a(List<String> list, String str) {
        for (String kiVar : list) {
            Future future = (Future) new ki(kiVar, str).mo1107e();
        }
    }

    public boolean m9224a() {
        return this.f5569c;
    }

    public boolean m9225a(Context context) {
        Intent intent = new Intent();
        intent.setClassName(context, "com.google.android.gms.ads.AdActivity");
        ResolveInfo resolveActivity = context.getPackageManager().resolveActivity(intent, 65536);
        if (resolveActivity == null || resolveActivity.activityInfo == null) {
            C1324b.m7234d("Could not find com.google.android.gms.ads.AdActivity, please make sure it is declared in AndroidManifest.xml.");
            return false;
        }
        boolean z;
        String str = "com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".";
        if ((resolveActivity.activityInfo.configChanges & 16) == 0) {
            C1324b.m7234d(String.format(str, new Object[]{"keyboard"}));
            z = false;
        } else {
            z = true;
        }
        if ((resolveActivity.activityInfo.configChanges & 32) == 0) {
            C1324b.m7234d(String.format(str, new Object[]{"keyboardHidden"}));
            z = false;
        }
        if ((resolveActivity.activityInfo.configChanges & 128) == 0) {
            C1324b.m7234d(String.format(str, new Object[]{"orientation"}));
            z = false;
        }
        if ((resolveActivity.activityInfo.configChanges & 256) == 0) {
            C1324b.m7234d(String.format(str, new Object[]{"screenLayout"}));
            z = false;
        }
        if ((resolveActivity.activityInfo.configChanges & 512) == 0) {
            C1324b.m7234d(String.format(str, new Object[]{"uiMode"}));
            z = false;
        }
        if ((resolveActivity.activityInfo.configChanges & 1024) == 0) {
            C1324b.m7234d(String.format(str, new Object[]{"screenSize"}));
            z = false;
        }
        if ((resolveActivity.activityInfo.configChanges & 2048) != 0) {
            return z;
        }
        C1324b.m7234d(String.format(str, new Object[]{"smallestScreenSize"}));
        return false;
    }

    public boolean m9226a(PackageManager packageManager, String str, String str2) {
        return packageManager.checkPermission(str2, str) == 0;
    }

    public boolean m9227a(View view, Context context) {
        KeyguardManager keyguardManager = null;
        Context applicationContext = context.getApplicationContext();
        PowerManager powerManager = applicationContext != null ? (PowerManager) applicationContext.getSystemService("power") : null;
        Object systemService = context.getSystemService("keyguard");
        if (systemService != null && (systemService instanceof KeyguardManager)) {
            keyguardManager = (KeyguardManager) systemService;
        }
        return m9228a(view, powerManager, keyguardManager);
    }

    public boolean m9228a(View view, PowerManager powerManager, KeyguardManager keyguardManager) {
        boolean z = C1319u.m7183e().m9224a() || !m9191a(keyguardManager);
        return view.getVisibility() == 0 && view.isShown() && m9192a(powerManager) && z && (!((Boolean) cq.at.m7801c()).booleanValue() || view.getLocalVisibleRect(new Rect()) || view.getGlobalVisibleRect(new Rect()));
    }

    public boolean m9229a(ClassLoader classLoader, Class<?> cls, String str) {
        boolean z = false;
        try {
            z = cls.isAssignableFrom(Class.forName(str, false, classLoader));
        } catch (Throwable th) {
        }
        return z;
    }

    public int[] m9230a(Activity activity) {
        Window window = activity.getWindow();
        if (window == null || window.findViewById(16908290) == null) {
            return m9248f();
        }
        return new int[]{window.findViewById(16908290).getWidth(), window.findViewById(16908290).getHeight()};
    }

    public int m9231b(View view) {
        if (view == null) {
            return -1;
        }
        ViewParent parent = view.getParent();
        while (parent != null && !(parent instanceof AdapterView)) {
            parent = parent.getParent();
        }
        return parent == null ? -1 : ((AdapterView) parent).getPositionForView(view);
    }

    public int m9232b(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            String valueOf = String.valueOf(e);
            C1324b.m7234d(new StringBuilder(String.valueOf(valueOf).length() + 22).append("Could not parse value:").append(valueOf).toString());
            return 0;
        }
    }

    String m9233b() {
        StringBuffer stringBuffer = new StringBuffer(256);
        stringBuffer.append("Mozilla/5.0 (Linux; U; Android");
        if (VERSION.RELEASE != null) {
            stringBuffer.append(" ").append(VERSION.RELEASE);
        }
        stringBuffer.append("; ").append(Locale.getDefault());
        if (Build.DEVICE != null) {
            stringBuffer.append("; ").append(Build.DEVICE);
            if (Build.DISPLAY != null) {
                stringBuffer.append(" Build/").append(Build.DISPLAY);
            }
        }
        stringBuffer.append(") AppleWebKit/533 Version/4.0 Safari/533");
        return stringBuffer.toString();
    }

    public void m9234b(Activity activity, OnScrollChangedListener onScrollChangedListener) {
        Window window = activity.getWindow();
        if (window != null && window.getDecorView() != null && window.getDecorView().getViewTreeObserver() != null) {
            window.getDecorView().getViewTreeObserver().removeOnScrollChangedListener(onScrollChangedListener);
        }
    }

    public void m9235b(Context context, String str, String str2, Bundle bundle, boolean z) {
        if (((Boolean) cq.ax.m7801c()).booleanValue()) {
            m9217a(context, str, str2, bundle, z);
        }
    }

    public boolean m9236b(Context context) {
        if (this.f5571e) {
            return false;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.USER_PRESENT");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        context.getApplicationContext().registerReceiver(new C1658a(), intentFilter);
        this.f5571e = true;
        return true;
    }

    public int[] m9237b(Activity activity) {
        int[] a = m9230a(activity);
        return new int[]{C1120y.m6293a().m7220b((Context) activity, a[0]), C1120y.m6293a().m7220b((Context) activity, a[1])};
    }

    public String m9238c() {
        return UUID.randomUUID().toString();
    }

    protected String m9239c(Context context) {
        return new WebView(context).getSettings().getUserAgentString();
    }

    public boolean m9240c(String str) {
        return TextUtils.isEmpty(str) ? false : str.matches("([^\\s]+(\\.(?i)(jpg|png|gif|bmp|webp))$)");
    }

    public int[] m9241c(Activity activity) {
        Window window = activity.getWindow();
        if (window == null || window.findViewById(16908290) == null) {
            return m9248f();
        }
        return new int[]{window.findViewById(16908290).getTop(), window.findViewById(16908290).getBottom()};
    }

    public Builder m9242d(Context context) {
        return new Builder(context);
    }

    public String m9243d() {
        UUID randomUUID = UUID.randomUUID();
        byte[] toByteArray = BigInteger.valueOf(randomUUID.getLeastSignificantBits()).toByteArray();
        byte[] toByteArray2 = BigInteger.valueOf(randomUUID.getMostSignificantBits()).toByteArray();
        String bigInteger = new BigInteger(1, toByteArray).toString();
        for (int i = 0; i < 2; i++) {
            try {
                MessageDigest instance = MessageDigest.getInstance("MD5");
                instance.update(toByteArray);
                instance.update(toByteArray2);
                Object obj = new byte[8];
                System.arraycopy(instance.digest(), 0, obj, 0, 8);
                bigInteger = new BigInteger(1, obj).toString();
            } catch (NoSuchAlgorithmException e) {
            }
        }
        return bigInteger;
    }

    public int[] m9244d(Activity activity) {
        int[] c = m9241c(activity);
        return new int[]{C1120y.m6293a().m7220b((Context) activity, c[0]), C1120y.m6293a().m7220b((Context) activity, c[1])};
    }

    public ch m9245e(Context context) {
        return new ch(context);
    }

    public String m9246e() {
        String str = Build.MANUFACTURER;
        String str2 = Build.MODEL;
        return str2.startsWith(str) ? str2 : new StringBuilder((String.valueOf(str).length() + 1) + String.valueOf(str2).length()).append(str).append(" ").append(str2).toString();
    }

    public String m9247f(Context context) {
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            if (activityManager == null) {
                return null;
            }
            List runningTasks = activityManager.getRunningTasks(1);
            if (!(runningTasks == null || runningTasks.isEmpty())) {
                RunningTaskInfo runningTaskInfo = (RunningTaskInfo) runningTasks.get(0);
                if (!(runningTaskInfo == null || runningTaskInfo.topActivity == null)) {
                    return runningTaskInfo.topActivity.getClassName();
                }
            }
            return null;
        } catch (Exception e) {
        }
    }

    protected int[] m9248f() {
        return new int[]{0, 0};
    }

    public float m9249g() {
        C1181o a = C1319u.m7199u().m6783a();
        return (a == null || !a.m6585d()) ? 1.0f : a.m6584c();
    }

    public boolean m9250g(Context context) {
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            KeyguardManager keyguardManager = (KeyguardManager) context.getSystemService("keyguard");
            if (activityManager == null || keyguardManager == null) {
                return false;
            }
            List<RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
            if (runningAppProcesses == null) {
                return false;
            }
            for (RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (Process.myPid() == runningAppProcessInfo.pid) {
                    if (runningAppProcessInfo.importance == 100 && !keyguardManager.inKeyguardRestrictedInputMode() && m9197m(context)) {
                        return true;
                    }
                    return false;
                }
            }
            return false;
        } catch (Throwable th) {
            return false;
        }
    }

    public Bitmap m9251h(Context context) {
        if (!(context instanceof Activity)) {
            return null;
        }
        Bitmap d;
        try {
            if (((Boolean) cq.be.m7801c()).booleanValue()) {
                Window window = ((Activity) context).getWindow();
                if (window != null) {
                    d = m9196d(window.getDecorView().getRootView());
                }
                d = null;
            } else {
                d = m9195c(((Activity) context).getWindow().getDecorView());
            }
        } catch (Throwable e) {
            C1324b.m7231b("Fail to capture screen shot", e);
        }
        return d;
    }

    public boolean m9252h() {
        C1181o a = C1319u.m7199u().m6783a();
        return a != null ? a.m6586e() : false;
    }

    public AudioManager m9253i(Context context) {
        return (AudioManager) context.getSystemService("audio");
    }

    public Bundle m9254i() {
        Bundle bundle = new Bundle();
        try {
            Parcelable memoryInfo = new MemoryInfo();
            Debug.getMemoryInfo(memoryInfo);
            bundle.putParcelable("debug_memory_info", memoryInfo);
            Runtime runtime = Runtime.getRuntime();
            bundle.putLong("runtime_free_memory", runtime.freeMemory());
            bundle.putLong("runtime_max_memory", runtime.maxMemory());
            bundle.putLong("runtime_total_memory", runtime.totalMemory());
        } catch (Throwable e) {
            C1324b.m7235d("Unable to gather memory stats", e);
        }
        return bundle;
    }

    public float m9255j(Context context) {
        AudioManager i = m9253i(context);
        if (i == null) {
            return 0.0f;
        }
        int streamMaxVolume = i.getStreamMaxVolume(3);
        return streamMaxVolume != 0 ? ((float) i.getStreamVolume(3)) / ((float) streamMaxVolume) : 0.0f;
    }

    public int m9256k(Context context) {
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        return applicationInfo == null ? 0 : applicationInfo.targetSdkVersion;
    }

    public boolean m9257l(Context context) {
        try {
            context.getClassLoader().loadClass(ClientApi.class.getName());
            return false;
        } catch (ClassNotFoundException e) {
            return true;
        }
    }
}
