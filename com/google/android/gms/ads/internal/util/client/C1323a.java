package com.google.android.gms.ads.internal.util.client;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri.Builder;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings.Secure;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.google.android.gms.ads.C1020b;
import com.google.android.gms.ads.C1032e;
import com.google.android.gms.ads.C1034h;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.p034a.C1009d;
import com.google.android.gms.ads.p034a.C1010e;
import com.google.android.gms.ads.p036e.C1031b;
import com.google.android.gms.common.C1876j;
import com.google.android.gms.common.internal.C1914l;
import com.google.android.gms.common.util.C1979l;
import com.google.android.gms.p031b.id;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;
import java.util.StringTokenizer;

@id
public class C1323a {
    public static final Handler f3964a = new Handler(Looper.getMainLooper());
    private static final String f3965b = C1032e.class.getName();
    private static final String f3966c = C1034h.class.getName();
    private static final String f3967d = C1009d.class.getName();
    private static final String f3968e = C1010e.class.getName();
    private static final String f3969f = C1031b.class.getName();
    private static final String f3970g = C1020b.class.getName();

    public interface C1321a {
        void mo1229a(String str);
    }

    class C13221 implements C1321a {
        final /* synthetic */ C1323a f3963a;

        C13221(C1323a c1323a) {
            this.f3963a = c1323a;
        }

        public void mo1229a(final String str) {
            new Thread(this) {
                final /* synthetic */ C13221 f3962b;

                public void run() {
                    new C1325c().mo1229a(str);
                }
            }.start();
        }
    }

    private void m7207a(ViewGroup viewGroup, AdSizeParcel adSizeParcel, String str, int i, int i2) {
        if (viewGroup.getChildCount() == 0) {
            Context context = viewGroup.getContext();
            View textView = new TextView(context);
            textView.setGravity(17);
            textView.setText(str);
            textView.setTextColor(i);
            textView.setBackgroundColor(i2);
            View frameLayout = new FrameLayout(context);
            frameLayout.setBackgroundColor(i);
            int a = m7208a(context, 3);
            frameLayout.addView(textView, new LayoutParams(adSizeParcel.f3109g - a, adSizeParcel.f3106d - a, 17));
            viewGroup.addView(frameLayout, adSizeParcel.f3109g, adSizeParcel.f3106d);
        }
    }

    public int m7208a(Context context, int i) {
        return m7209a(context.getResources().getDisplayMetrics(), i);
    }

    public int m7209a(DisplayMetrics displayMetrics, int i) {
        return (int) TypedValue.applyDimension(1, (float) i, displayMetrics);
    }

    public String m7210a(Context context) {
        ContentResolver contentResolver = context.getContentResolver();
        String string = contentResolver == null ? null : Secure.getString(contentResolver, "android_id");
        if (string == null || m7219a()) {
            string = "emulator";
        }
        return m7211a(string);
    }

    public String m7211a(String str) {
        int i = 0;
        while (i < 2) {
            try {
                MessageDigest.getInstance("MD5").update(str.getBytes());
                return String.format(Locale.US, "%032X", new Object[]{new BigInteger(1, r1.digest())});
            } catch (NoSuchAlgorithmException e) {
                i++;
            }
        }
        return null;
    }

    String m7212a(String str, String str2, int i) {
        StringTokenizer stringTokenizer = new StringTokenizer(str, str2);
        StringBuilder stringBuilder = new StringBuilder();
        int i2 = i - 1;
        if (i <= 0 || !stringTokenizer.hasMoreElements()) {
            return str;
        }
        stringBuilder.append(stringTokenizer.nextToken());
        while (true) {
            int i3 = i2 - 1;
            if (i2 > 0 && stringTokenizer.hasMoreElements()) {
                stringBuilder.append(".").append(stringTokenizer.nextToken());
                i2 = i3;
            }
        }
        return stringBuilder.toString();
    }

    public String m7213a(StackTraceElement[] stackTraceElementArr, String str) {
        String className;
        for (int i = 0; i + 1 < stackTraceElementArr.length; i++) {
            StackTraceElement stackTraceElement = stackTraceElementArr[i];
            String className2 = stackTraceElement.getClassName();
            if ("loadAd".equalsIgnoreCase(stackTraceElement.getMethodName()) && (f3965b.equalsIgnoreCase(className2) || f3966c.equalsIgnoreCase(className2) || f3967d.equalsIgnoreCase(className2) || f3968e.equalsIgnoreCase(className2) || f3969f.equalsIgnoreCase(className2) || f3970g.equalsIgnoreCase(className2))) {
                className = stackTraceElementArr[i + 1].getClassName();
                break;
            }
        }
        className = null;
        if (str != null) {
            CharSequence a = m7212a(str, ".", 3);
            if (!(className == null || className.contains(a))) {
                return className;
            }
        }
        return null;
    }

    public void m7214a(Context context, String str, String str2, Bundle bundle, boolean z) {
        m7215a(context, str, str2, bundle, z, new C13221(this));
    }

    public void m7215a(Context context, String str, String str2, Bundle bundle, boolean z, C1321a c1321a) {
        if (z) {
            Context applicationContext = context.getApplicationContext();
            if (applicationContext == null) {
                applicationContext = context;
            }
            bundle.putString("os", VERSION.RELEASE);
            bundle.putString("api", String.valueOf(VERSION.SDK_INT));
            bundle.putString("appid", applicationContext.getPackageName());
            if (str == null) {
                str = C1876j.m10605b().mo1649b(context) + "." + C1914l.f6455a;
            }
            bundle.putString("js", str);
        }
        Builder appendQueryParameter = new Builder().scheme("https").path("//pagead2.googlesyndication.com/pagead/gen_204").appendQueryParameter("id", str2);
        for (String str3 : bundle.keySet()) {
            appendQueryParameter.appendQueryParameter(str3, bundle.getString(str3));
        }
        c1321a.mo1229a(appendQueryParameter.toString());
    }

    public void m7216a(ViewGroup viewGroup, AdSizeParcel adSizeParcel, String str) {
        m7207a(viewGroup, adSizeParcel, str, -16777216, -1);
    }

    public void m7217a(ViewGroup viewGroup, AdSizeParcel adSizeParcel, String str, String str2) {
        C1324b.m7234d(str2);
        m7207a(viewGroup, adSizeParcel, str, -65536, -16777216);
    }

    public void m7218a(boolean z, HttpURLConnection httpURLConnection, String str) {
        httpURLConnection.setConnectTimeout(60000);
        httpURLConnection.setInstanceFollowRedirects(z);
        httpURLConnection.setReadTimeout(60000);
        if (str != null) {
            httpURLConnection.setRequestProperty("User-Agent", str);
        }
        httpURLConnection.setUseCaches(false);
    }

    public boolean m7219a() {
        return Build.DEVICE.startsWith("generic");
    }

    public int m7220b(Context context, int i) {
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getMetrics(displayMetrics);
        return m7221b(displayMetrics, i);
    }

    public int m7221b(DisplayMetrics displayMetrics, int i) {
        return Math.round(((float) i) / displayMetrics.density);
    }

    public boolean m7222b() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    public boolean m7223b(Context context) {
        return C1876j.m10605b().mo1643a(context) == 0;
    }

    public boolean m7224c(Context context) {
        if (context.getResources().getConfiguration().orientation != 2) {
            return false;
        }
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        return ((int) (((float) displayMetrics.heightPixels) / displayMetrics.density)) < 600;
    }

    public boolean m7225d(Context context) {
        int i;
        int i2;
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        if (C1979l.m11112f()) {
            defaultDisplay.getRealMetrics(displayMetrics);
            i = displayMetrics.heightPixels;
            i2 = displayMetrics.widthPixels;
        } else {
            try {
                i = ((Integer) Display.class.getMethod("getRawHeight", new Class[0]).invoke(defaultDisplay, new Object[0])).intValue();
                i2 = ((Integer) Display.class.getMethod("getRawWidth", new Class[0]).invoke(defaultDisplay, new Object[0])).intValue();
            } catch (Exception e) {
                return false;
            }
        }
        defaultDisplay.getMetrics(displayMetrics);
        boolean z = displayMetrics.heightPixels == i && displayMetrics.widthPixels == i2;
        return z;
    }

    public int m7226e(Context context) {
        int identifier = context.getResources().getIdentifier("navigation_bar_width", "dimen", "android");
        return identifier > 0 ? context.getResources().getDimensionPixelSize(identifier) : 0;
    }
}
