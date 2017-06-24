package com.google.firebase.iid;

import android.text.TextUtils;

public class C2121e {
    private static final Object f7111a = new Object();
    private final C2124g f7112b;

    C2121e(C2124g c2124g) {
        this.f7112b = c2124g;
    }

    String m12165a() {
        String str = null;
        synchronized (f7111a) {
            String string = this.f7112b.m12187a().getString("topic_operaion_queue", null);
            if (string != null) {
                String[] split = string.split(",");
                if (split.length > 1 && !TextUtils.isEmpty(split[1])) {
                    str = split[1];
                }
            }
        }
        return str;
    }

    boolean m12166a(String str) {
        boolean z;
        synchronized (f7111a) {
            String string = this.f7112b.m12187a().getString("topic_operaion_queue", "");
            String valueOf = String.valueOf(",");
            String valueOf2 = String.valueOf(str);
            if (string.startsWith(valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf))) {
                valueOf = String.valueOf(",");
                valueOf2 = String.valueOf(str);
                this.f7112b.m12187a().edit().putString("topic_operaion_queue", string.substring((valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf)).length())).apply();
                z = true;
            } else {
                z = false;
            }
        }
        return z;
    }
}
