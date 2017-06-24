package com.google.android.gms.p031b;

import android.content.Context;
import android.net.Uri;
import android.view.MotionEvent;

public class aj {
    private static final String[] f4122e = new String[]{"/aclk", "/pcs/click"};
    private String f4123a = "googleads.g.doubleclick.net";
    private String f4124b = "/pagead/ads";
    private String f4125c = "ad.doubleclick.net";
    private String[] f4126d = new String[]{".doubleclick.net", ".googleadservices.com", ".googlesyndication.com"};
    private C1165n f4127f;

    public aj(C1165n c1165n) {
        this.f4127f = c1165n;
    }

    private Uri m7428a(Uri uri, Context context, String str, boolean z) {
        try {
            boolean b = m7438b(uri);
            if (b) {
                if (uri.toString().contains("dc_ms=")) {
                    throw new ak("Parameter already exists: dc_ms");
                }
            } else if (uri.getQueryParameter("ms") != null) {
                throw new ak("Query parameter already exists: ms");
            }
            String a = z ? this.f4127f.mo1103a(context, str) : this.f4127f.mo1102a(context);
            return b ? m7430b(uri, "dc_ms", a) : m7429a(uri, "ms", a);
        } catch (UnsupportedOperationException e) {
            throw new ak("Provided Uri is not in a valid state");
        }
    }

    private Uri m7429a(Uri uri, String str, String str2) {
        String uri2 = uri.toString();
        int indexOf = uri2.indexOf("&adurl");
        if (indexOf == -1) {
            indexOf = uri2.indexOf("?adurl");
        }
        return indexOf != -1 ? Uri.parse(new StringBuilder(uri2.substring(0, indexOf + 1)).append(str).append("=").append(str2).append("&").append(uri2.substring(indexOf + 1)).toString()) : uri.buildUpon().appendQueryParameter(str, str2).build();
    }

    private Uri m7430b(Uri uri, String str, String str2) {
        String uri2 = uri.toString();
        int indexOf = uri2.indexOf(";adurl");
        if (indexOf != -1) {
            return Uri.parse(new StringBuilder(uri2.substring(0, indexOf + 1)).append(str).append("=").append(str2).append(";").append(uri2.substring(indexOf + 1)).toString());
        }
        String encodedPath = uri.getEncodedPath();
        int indexOf2 = uri2.indexOf(encodedPath);
        return Uri.parse(new StringBuilder(uri2.substring(0, encodedPath.length() + indexOf2)).append(";").append(str).append("=").append(str2).append(";").append(uri2.substring(encodedPath.length() + indexOf2)).toString());
    }

    public Uri m7431a(Uri uri, Context context) {
        return m7428a(uri, context, null, false);
    }

    public C1165n m7432a() {
        return this.f4127f;
    }

    public void m7433a(MotionEvent motionEvent) {
        this.f4127f.mo1105a(motionEvent);
    }

    public void m7434a(String str) {
        this.f4126d = str.split(",");
    }

    public void m7435a(String str, String str2) {
        this.f4123a = str;
        this.f4124b = str2;
    }

    public boolean m7436a(Uri uri) {
        if (uri == null) {
            throw new NullPointerException();
        }
        try {
            return uri.getHost().equals(this.f4123a) && uri.getPath().equals(this.f4124b);
        } catch (NullPointerException e) {
            return false;
        }
    }

    public Uri m7437b(Uri uri, Context context) {
        try {
            return m7428a(uri, context, uri.getQueryParameter("ai"), true);
        } catch (UnsupportedOperationException e) {
            throw new ak("Provided Uri is not in a valid state");
        }
    }

    public boolean m7438b(Uri uri) {
        if (uri == null) {
            throw new NullPointerException();
        }
        try {
            return uri.getHost().equals(this.f4125c);
        } catch (NullPointerException e) {
            return false;
        }
    }

    public boolean m7439c(Uri uri) {
        if (uri == null) {
            throw new NullPointerException();
        }
        try {
            String host = uri.getHost();
            for (String endsWith : this.f4126d) {
                if (host.endsWith(endsWith)) {
                    return true;
                }
            }
            return false;
        } catch (NullPointerException e) {
            return false;
        }
    }

    public boolean m7440d(Uri uri) {
        if (!m7439c(uri)) {
            return false;
        }
        for (String endsWith : f4122e) {
            if (uri.getPath().endsWith(endsWith)) {
                return true;
            }
        }
        return false;
    }
}
