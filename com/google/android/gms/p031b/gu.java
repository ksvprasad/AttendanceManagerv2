package com.google.android.gms.p031b;

import com.google.android.gms.ads.internal.util.client.C1324b;
import org.json.JSONObject;

@id
public class gu {
    private final la f4946a;
    private final String f4947b;

    public gu(la laVar) {
        this(laVar, "");
    }

    public gu(la laVar, String str) {
        this.f4946a = laVar;
        this.f4947b = str;
    }

    public void m8633a(int i, int i2, int i3, int i4) {
        try {
            this.f4946a.mo1325b("onSizeChanged", new JSONObject().put("x", i).put("y", i2).put("width", i3).put("height", i4));
        } catch (Throwable e) {
            C1324b.m7231b("Error occured while dispatching size change.", e);
        }
    }

    public void m8634a(int i, int i2, int i3, int i4, float f, int i5) {
        try {
            this.f4946a.mo1325b("onScreenInfoChanged", new JSONObject().put("width", i).put("height", i2).put("maxSizeWidth", i3).put("maxSizeHeight", i4).put("density", (double) f).put("rotation", i5));
        } catch (Throwable e) {
            C1324b.m7231b("Error occured while obtaining screen information.", e);
        }
    }

    public void m8635b(int i, int i2, int i3, int i4) {
        try {
            this.f4946a.mo1325b("onDefaultPositionReceived", new JSONObject().put("x", i).put("y", i2).put("width", i3).put("height", i4));
        } catch (Throwable e) {
            C1324b.m7231b("Error occured while dispatching default position.", e);
        }
    }

    public void m8636b(String str) {
        try {
            this.f4946a.mo1325b("onError", new JSONObject().put("message", str).put("action", this.f4947b));
        } catch (Throwable e) {
            C1324b.m7231b("Error occurred while dispatching error event.", e);
        }
    }

    public void m8637c(String str) {
        try {
            this.f4946a.mo1325b("onReadyEventReceived", new JSONObject().put("js", str));
        } catch (Throwable e) {
            C1324b.m7231b("Error occured while dispatching ready Event.", e);
        }
    }

    public void m8638d(String str) {
        try {
            this.f4946a.mo1325b("onStateChanged", new JSONObject().put("state", str));
        } catch (Throwable e) {
            C1324b.m7231b("Error occured while dispatching state change.", e);
        }
    }
}
