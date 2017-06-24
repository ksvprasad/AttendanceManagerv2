package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.res.Resources;
import com.google.android.gms.C1004a.C0996b;

public class C1900g {
    private final Resources f6438a;
    private final String f6439b = this.f6438a.getResourcePackageName(C0996b.common_google_play_services_unknown_issue);

    public C1900g(Context context) {
        C1896c.m10790a((Object) context);
        this.f6438a = context.getResources();
    }

    public String m10812a(String str) {
        int identifier = this.f6438a.getIdentifier(str, "string", this.f6439b);
        return identifier == 0 ? null : this.f6438a.getString(identifier);
    }
}
