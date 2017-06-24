package com.google.android.gms.p031b;

import android.text.TextUtils;

@id
public class ct {
    public cs m7844a(cr crVar) {
        if (crVar == null) {
            throw new IllegalArgumentException("CSI configuration can't be null. ");
        } else if (!crVar.m7830a()) {
            jv.m9152e("CsiReporterFactory: CSI is not enabled. No CSI reporter created.");
            return null;
        } else if (crVar.m7832c() == null) {
            throw new IllegalArgumentException("Context can't be null. Please set up context in CsiConfiguration.");
        } else if (!TextUtils.isEmpty(crVar.m7833d())) {
            return new cs(crVar.m7832c(), crVar.m7833d(), crVar.m7831b(), crVar.m7834e());
        } else {
            throw new IllegalArgumentException("AfmaVersion can't be null or empty. Please set up afmaVersion in CsiConfiguration.");
        }
    }
}
