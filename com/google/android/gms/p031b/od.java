package com.google.android.gms.p031b;

import java.net.URI;
import java.util.Map;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.client.methods.HttpOptions;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpTrace;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

public class od implements of {
    protected final HttpClient f6244a;

    public static final class C1837a extends HttpEntityEnclosingRequestBase {
        public C1837a(String str) {
            setURI(URI.create(str));
        }

        public String getMethod() {
            return "PATCH";
        }
    }

    public od(HttpClient httpClient) {
        this.f6244a = httpClient;
    }

    private static void m10355a(HttpEntityEnclosingRequestBase httpEntityEnclosingRequestBase, jr<?> jrVar) {
        byte[] o = jrVar.mo1485o();
        if (o != null) {
            httpEntityEnclosingRequestBase.setEntity(new ByteArrayEntity(o));
        }
    }

    private static void m10356a(HttpUriRequest httpUriRequest, Map<String, String> map) {
        for (String str : map.keySet()) {
            httpUriRequest.setHeader(str, (String) map.get(str));
        }
    }

    static HttpUriRequest m10357b(jr<?> jrVar, Map<String, String> map) {
        HttpEntityEnclosingRequestBase httpPost;
        switch (jrVar.m7706a()) {
            case -1:
                byte[] k = jrVar.m7727k();
                if (k == null) {
                    return new HttpGet(jrVar.m7718c());
                }
                HttpUriRequest httpPost2 = new HttpPost(jrVar.m7718c());
                httpPost2.addHeader("Content-Type", jrVar.m7726j());
                httpPost2.setEntity(new ByteArrayEntity(k));
                return httpPost2;
            case 0:
                return new HttpGet(jrVar.m7718c());
            case 1:
                httpPost = new HttpPost(jrVar.m7718c());
                httpPost.addHeader("Content-Type", jrVar.m7730n());
                od.m10355a(httpPost, (jr) jrVar);
                return httpPost;
            case 2:
                httpPost = new HttpPut(jrVar.m7718c());
                httpPost.addHeader("Content-Type", jrVar.m7730n());
                od.m10355a(httpPost, (jr) jrVar);
                return httpPost;
            case 3:
                return new HttpDelete(jrVar.m7718c());
            case 4:
                return new HttpHead(jrVar.m7718c());
            case 5:
                return new HttpOptions(jrVar.m7718c());
            case 6:
                return new HttpTrace(jrVar.m7718c());
            case 7:
                httpPost = new C1837a(jrVar.m7718c());
                httpPost.addHeader("Content-Type", jrVar.m7730n());
                od.m10355a(httpPost, (jr) jrVar);
                return httpPost;
            default:
                throw new IllegalStateException("Unknown request method.");
        }
    }

    public HttpResponse mo1640a(jr<?> jrVar, Map<String, String> map) {
        HttpUriRequest b = od.m10357b(jrVar, map);
        od.m10356a(b, (Map) map);
        od.m10356a(b, jrVar.mo1484g());
        m10359a(b);
        HttpParams params = b.getParams();
        int r = jrVar.m7734r();
        HttpConnectionParams.setConnectionTimeout(params, 5000);
        HttpConnectionParams.setSoTimeout(params, r);
        return this.f6244a.execute(b);
    }

    protected void m10359a(HttpUriRequest httpUriRequest) {
    }
}
