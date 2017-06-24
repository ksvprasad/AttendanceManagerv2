package com.google.android.gms.p031b;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ProtocolVersion;
import org.apache.http.entity.BasicHttpEntity;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicHttpResponse;
import org.apache.http.message.BasicStatusLine;

public class og implements of {
    private final C1838a f6245a;
    private final SSLSocketFactory f6246b;

    public interface C1838a {
        String m10364a(String str);
    }

    public og() {
        this(null);
    }

    public og(C1838a c1838a) {
        this(c1838a, null);
    }

    public og(C1838a c1838a, SSLSocketFactory sSLSocketFactory) {
        this.f6245a = c1838a;
        this.f6246b = sSLSocketFactory;
    }

    private HttpURLConnection m10365a(URL url, jr<?> jrVar) {
        HttpURLConnection a = m10369a(url);
        int r = jrVar.m7734r();
        a.setConnectTimeout(r);
        a.setReadTimeout(r);
        a.setUseCaches(false);
        a.setDoInput(true);
        if ("https".equals(url.getProtocol()) && this.f6246b != null) {
            ((HttpsURLConnection) a).setSSLSocketFactory(this.f6246b);
        }
        return a;
    }

    private static HttpEntity m10366a(HttpURLConnection httpURLConnection) {
        InputStream inputStream;
        HttpEntity basicHttpEntity = new BasicHttpEntity();
        try {
            inputStream = httpURLConnection.getInputStream();
        } catch (IOException e) {
            inputStream = httpURLConnection.getErrorStream();
        }
        basicHttpEntity.setContent(inputStream);
        basicHttpEntity.setContentLength((long) httpURLConnection.getContentLength());
        basicHttpEntity.setContentEncoding(httpURLConnection.getContentEncoding());
        basicHttpEntity.setContentType(httpURLConnection.getContentType());
        return basicHttpEntity;
    }

    static void m10367a(HttpURLConnection httpURLConnection, jr<?> jrVar) {
        switch (jrVar.m7706a()) {
            case -1:
                byte[] k = jrVar.m7727k();
                if (k != null) {
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.addRequestProperty("Content-Type", jrVar.m7726j());
                    DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
                    dataOutputStream.write(k);
                    dataOutputStream.close();
                    return;
                }
                return;
            case 0:
                httpURLConnection.setRequestMethod("GET");
                return;
            case 1:
                httpURLConnection.setRequestMethod("POST");
                og.m10368b(httpURLConnection, jrVar);
                return;
            case 2:
                httpURLConnection.setRequestMethod("PUT");
                og.m10368b(httpURLConnection, jrVar);
                return;
            case 3:
                httpURLConnection.setRequestMethod("DELETE");
                return;
            case 4:
                httpURLConnection.setRequestMethod("HEAD");
                return;
            case 5:
                httpURLConnection.setRequestMethod("OPTIONS");
                return;
            case 6:
                httpURLConnection.setRequestMethod("TRACE");
                return;
            case 7:
                httpURLConnection.setRequestMethod("PATCH");
                og.m10368b(httpURLConnection, jrVar);
                return;
            default:
                throw new IllegalStateException("Unknown method type.");
        }
    }

    private static void m10368b(HttpURLConnection httpURLConnection, jr<?> jrVar) {
        byte[] o = jrVar.mo1485o();
        if (o != null) {
            httpURLConnection.setDoOutput(true);
            httpURLConnection.addRequestProperty("Content-Type", jrVar.m7730n());
            DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
            dataOutputStream.write(o);
            dataOutputStream.close();
        }
    }

    protected HttpURLConnection m10369a(URL url) {
        return (HttpURLConnection) url.openConnection();
    }

    public HttpResponse mo1640a(jr<?> jrVar, Map<String, String> map) {
        String a;
        String c = jrVar.m7718c();
        HashMap hashMap = new HashMap();
        hashMap.putAll(jrVar.mo1484g());
        hashMap.putAll(map);
        if (this.f6245a != null) {
            a = this.f6245a.m10364a(c);
            if (a == null) {
                String str = "URL blocked by rewriter: ";
                a = String.valueOf(c);
                throw new IOException(a.length() != 0 ? str.concat(a) : new String(str));
            }
        }
        a = c;
        HttpURLConnection a2 = m10365a(new URL(a), (jr) jrVar);
        for (String a3 : hashMap.keySet()) {
            a2.addRequestProperty(a3, (String) hashMap.get(a3));
        }
        og.m10367a(a2, (jr) jrVar);
        ProtocolVersion protocolVersion = new ProtocolVersion("HTTP", 1, 1);
        if (a2.getResponseCode() == -1) {
            throw new IOException("Could not retrieve response code from HttpUrlConnection.");
        }
        HttpResponse basicHttpResponse = new BasicHttpResponse(new BasicStatusLine(protocolVersion, a2.getResponseCode(), a2.getResponseMessage()));
        basicHttpResponse.setEntity(og.m10366a(a2));
        for (Entry entry : a2.getHeaderFields().entrySet()) {
            if (entry.getKey() != null) {
                basicHttpResponse.addHeader(new BasicHeader((String) entry.getKey(), (String) ((List) entry.getValue()).get(0)));
            }
        }
        return basicHttpResponse;
    }
}
