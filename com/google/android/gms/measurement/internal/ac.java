package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.google.android.gms.common.internal.C1896c;
import com.google.android.gms.common.util.C1970c;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class ac extends C2019b {

    interface C2021a {
        void mo1749a(String str, int i, Throwable th, byte[] bArr, Map<String, List<String>> map);
    }

    private static class C2022b implements Runnable {
        private final C2021a f6728a;
        private final int f6729b;
        private final Throwable f6730c;
        private final byte[] f6731d;
        private final String f6732e;
        private final Map<String, List<String>> f6733f;

        private C2022b(String str, C2021a c2021a, int i, Throwable th, byte[] bArr, Map<String, List<String>> map) {
            C1896c.m10790a((Object) c2021a);
            this.f6728a = c2021a;
            this.f6729b = i;
            this.f6730c = th;
            this.f6731d = bArr;
            this.f6732e = str;
            this.f6733f = map;
        }

        public void run() {
            this.f6728a.mo1749a(this.f6732e, this.f6729b, this.f6730c, this.f6731d, this.f6733f);
        }
    }

    private class C2023c implements Runnable {
        final /* synthetic */ ac f6734a;
        private final URL f6735b;
        private final byte[] f6736c;
        private final C2021a f6737d;
        private final String f6738e;
        private final Map<String, String> f6739f;

        public C2023c(ac acVar, String str, URL url, byte[] bArr, Map<String, String> map, C2021a c2021a) {
            this.f6734a = acVar;
            C1896c.m10792a(str);
            C1896c.m10790a((Object) url);
            C1896c.m10790a((Object) c2021a);
            this.f6735b = url;
            this.f6736c = bArr;
            this.f6737d = c2021a;
            this.f6738e = str;
            this.f6739f = map;
        }

        public void run() {
            OutputStream outputStream;
            Throwable e;
            Map map;
            int i;
            HttpURLConnection httpURLConnection;
            Throwable th;
            Map map2;
            this.f6734a.mo1732i();
            int i2 = 0;
            HttpURLConnection a;
            try {
                this.f6734a.m11315a(this.f6738e);
                a = this.f6734a.m11314a(this.f6735b);
                try {
                    if (this.f6739f != null) {
                        for (Entry entry : this.f6739f.entrySet()) {
                            a.addRequestProperty((String) entry.getKey(), (String) entry.getValue());
                        }
                    }
                    if (this.f6736c != null) {
                        byte[] a2 = this.f6734a.mo1742s().m11774a(this.f6736c);
                        this.f6734a.mo1746w().m11283E().m11250a("Uploading data. size", Integer.valueOf(a2.length));
                        a.setDoOutput(true);
                        a.addRequestProperty("Content-Encoding", "gzip");
                        a.setFixedLengthStreamingMode(a2.length);
                        a.connect();
                        outputStream = a.getOutputStream();
                        try {
                            outputStream.write(a2);
                            outputStream.close();
                        } catch (IOException e2) {
                            e = e2;
                            map = null;
                            i = 0;
                            httpURLConnection = a;
                            if (outputStream != null) {
                                try {
                                    outputStream.close();
                                } catch (IOException e3) {
                                    this.f6734a.mo1746w().m11290f().m11250a("Error closing HTTP compressed POST connection output stream", e3);
                                }
                            }
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                            }
                            this.f6734a.m11320g();
                            this.f6734a.mo1745v().m11424a(new C2022b(this.f6738e, this.f6737d, i, e, null, map));
                        } catch (Throwable th2) {
                            th = th2;
                            map2 = null;
                            if (outputStream != null) {
                                try {
                                    outputStream.close();
                                } catch (IOException e32) {
                                    this.f6734a.mo1746w().m11290f().m11250a("Error closing HTTP compressed POST connection output stream", e32);
                                }
                            }
                            if (a != null) {
                                a.disconnect();
                            }
                            this.f6734a.m11320g();
                            this.f6734a.mo1745v().m11424a(new C2022b(this.f6738e, this.f6737d, i2, null, null, map2));
                            throw th;
                        }
                    }
                    i2 = a.getResponseCode();
                    map2 = a.getHeaderFields();
                } catch (IOException e4) {
                    e = e4;
                    map = null;
                    i = i2;
                    outputStream = null;
                    httpURLConnection = a;
                    if (outputStream != null) {
                        outputStream.close();
                    }
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    this.f6734a.m11320g();
                    this.f6734a.mo1745v().m11424a(new C2022b(this.f6738e, this.f6737d, i, e, null, map));
                } catch (Throwable th3) {
                    th = th3;
                    map2 = null;
                    outputStream = null;
                    if (outputStream != null) {
                        outputStream.close();
                    }
                    if (a != null) {
                        a.disconnect();
                    }
                    this.f6734a.m11320g();
                    this.f6734a.mo1745v().m11424a(new C2022b(this.f6738e, this.f6737d, i2, null, null, map2));
                    throw th;
                }
                try {
                    byte[] a3 = this.f6734a.m11313a(a);
                    if (a != null) {
                        a.disconnect();
                    }
                    this.f6734a.m11320g();
                    this.f6734a.mo1745v().m11424a(new C2022b(this.f6738e, this.f6737d, i2, null, a3, map2));
                } catch (IOException e5) {
                    e = e5;
                    map = map2;
                    i = i2;
                    outputStream = null;
                    httpURLConnection = a;
                    if (outputStream != null) {
                        outputStream.close();
                    }
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    this.f6734a.m11320g();
                    this.f6734a.mo1745v().m11424a(new C2022b(this.f6738e, this.f6737d, i, e, null, map));
                } catch (Throwable th32) {
                    th = th32;
                    outputStream = null;
                    if (outputStream != null) {
                        outputStream.close();
                    }
                    if (a != null) {
                        a.disconnect();
                    }
                    this.f6734a.m11320g();
                    this.f6734a.mo1745v().m11424a(new C2022b(this.f6738e, this.f6737d, i2, null, null, map2));
                    throw th;
                }
            } catch (IOException e6) {
                e = e6;
                map = null;
                i = 0;
                outputStream = null;
                httpURLConnection = null;
                if (outputStream != null) {
                    outputStream.close();
                }
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                this.f6734a.m11320g();
                this.f6734a.mo1745v().m11424a(new C2022b(this.f6738e, this.f6737d, i, e, null, map));
            } catch (Throwable th322) {
                th = th322;
                map2 = null;
                a = null;
                outputStream = null;
                if (outputStream != null) {
                    outputStream.close();
                }
                if (a != null) {
                    a.disconnect();
                }
                this.f6734a.m11320g();
                this.f6734a.mo1745v().m11424a(new C2022b(this.f6738e, this.f6737d, i2, null, null, map2));
                throw th;
            }
        }
    }

    public ac(aj ajVar) {
        super(ajVar);
    }

    private byte[] m11313a(HttpURLConnection httpURLConnection) {
        InputStream inputStream = null;
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            inputStream = httpURLConnection.getInputStream();
            byte[] bArr = new byte[1024];
            while (true) {
                int read = inputStream.read(bArr);
                if (read <= 0) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
            byte[] toByteArray = byteArrayOutputStream.toByteArray();
            return toByteArray;
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }
    }

    protected HttpURLConnection m11314a(URL url) {
        URLConnection openConnection = url.openConnection();
        if (openConnection instanceof HttpURLConnection) {
            HttpURLConnection httpURLConnection = (HttpURLConnection) openConnection;
            httpURLConnection.setDefaultUseCaches(false);
            httpURLConnection.setConnectTimeout((int) mo1748y().m11827I());
            httpURLConnection.setReadTimeout((int) mo1748y().m11828J());
            httpURLConnection.setInstanceFollowRedirects(false);
            httpURLConnection.setDoInput(true);
            return httpURLConnection;
        }
        throw new IOException("Failed to obtain HTTP connection");
    }

    protected void m11315a(String str) {
    }

    public void m11316a(String str, URL url, Map<String, String> map, C2021a c2021a) {
        mo1733j();
        m11273c();
        C1896c.m10790a((Object) url);
        C1896c.m10790a((Object) c2021a);
        mo1745v().m11426b(new C2023c(this, str, url, null, map, c2021a));
    }

    public void m11317a(String str, URL url, byte[] bArr, Map<String, String> map, C2021a c2021a) {
        mo1733j();
        m11273c();
        C1896c.m10790a((Object) url);
        C1896c.m10790a((Object) bArr);
        C1896c.m10790a((Object) c2021a);
        mo1745v().m11426b(new C2023c(this, str, url, bArr, map, c2021a));
    }

    protected void mo1730e() {
    }

    public boolean m11319f() {
        NetworkInfo activeNetworkInfo;
        m11273c();
        try {
            activeNetworkInfo = ((ConnectivityManager) mo1740q().getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (SecurityException e) {
            activeNetworkInfo = null;
        }
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    protected void m11320g() {
    }

    public /* bridge */ /* synthetic */ void mo1731h() {
        super.mo1731h();
    }

    public /* bridge */ /* synthetic */ void mo1732i() {
        super.mo1732i();
    }

    public /* bridge */ /* synthetic */ void mo1733j() {
        super.mo1733j();
    }

    public /* bridge */ /* synthetic */ C2084o mo1734k() {
        return super.mo1734k();
    }

    public /* bridge */ /* synthetic */ C2053d mo1735l() {
        return super.mo1735l();
    }

    public /* bridge */ /* synthetic */ C2098z mo1736m() {
        return super.mo1736m();
    }

    public /* bridge */ /* synthetic */ C2090s mo1737n() {
        return super.mo1737n();
    }

    public /* bridge */ /* synthetic */ C2066e mo1738o() {
        return super.mo1738o();
    }

    public /* bridge */ /* synthetic */ C1970c mo1739p() {
        return super.mo1739p();
    }

    public /* bridge */ /* synthetic */ Context mo1740q() {
        return super.mo1740q();
    }

    public /* bridge */ /* synthetic */ C2088q mo1741r() {
        return super.mo1741r();
    }

    public /* bridge */ /* synthetic */ C2082m mo1742s() {
        return super.mo1742s();
    }

    public /* bridge */ /* synthetic */ ah mo1743t() {
        return super.mo1743t();
    }

    public /* bridge */ /* synthetic */ C2076g mo1744u() {
        return super.mo1744u();
    }

    public /* bridge */ /* synthetic */ ai mo1745v() {
        return super.mo1745v();
    }

    public /* bridge */ /* synthetic */ ab mo1746w() {
        return super.mo1746w();
    }

    public /* bridge */ /* synthetic */ af mo1747x() {
        return super.mo1747x();
    }

    public /* bridge */ /* synthetic */ C2085p mo1748y() {
        return super.mo1748y();
    }
}
