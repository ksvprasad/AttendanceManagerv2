package com.google.android.gms.ads.internal.util.client;

import com.google.android.gms.ads.internal.client.C1120y;
import com.google.android.gms.ads.internal.util.client.C1323a.C1321a;
import com.google.android.gms.p031b.id;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

@id
public class C1325c implements C1321a {
    private final String f3971a;

    public C1325c() {
        this(null);
    }

    public C1325c(String str) {
        this.f3971a = str;
    }

    public void mo1229a(String str) {
        String valueOf;
        HttpURLConnection httpURLConnection;
        try {
            String str2 = "Pinging URL: ";
            valueOf = String.valueOf(str);
            C1324b.m7227a(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            C1120y.m6293a().m7218a(true, httpURLConnection, this.f3971a);
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode < 200 || responseCode >= 300) {
                C1324b.m7234d(new StringBuilder(String.valueOf(str).length() + 65).append("Received non-success response code ").append(responseCode).append(" from pinging URL: ").append(str).toString());
            }
            httpURLConnection.disconnect();
        } catch (IndexOutOfBoundsException e) {
            valueOf = String.valueOf(e.getMessage());
            C1324b.m7234d(new StringBuilder((String.valueOf(str).length() + 32) + String.valueOf(valueOf).length()).append("Error while parsing ping URL: ").append(str).append(". ").append(valueOf).toString());
        } catch (IOException e2) {
            valueOf = String.valueOf(e2.getMessage());
            C1324b.m7234d(new StringBuilder((String.valueOf(str).length() + 27) + String.valueOf(valueOf).length()).append("Error while pinging URL: ").append(str).append(". ").append(valueOf).toString());
        } catch (RuntimeException e3) {
            valueOf = String.valueOf(e3.getMessage());
            C1324b.m7234d(new StringBuilder((String.valueOf(str).length() + 27) + String.valueOf(valueOf).length()).append("Error while pinging URL: ").append(str).append(". ").append(valueOf).toString());
        } catch (Throwable th) {
            httpURLConnection.disconnect();
        }
    }
}
