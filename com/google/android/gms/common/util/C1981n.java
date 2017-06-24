package com.google.android.gms.common.util;

import com.google.android.gms.common.internal.C1915m;
import java.util.regex.Pattern;

public class C1981n {
    private static final Pattern f6611a = Pattern.compile("\\$\\{(.*?)\\}");

    public static boolean m11122a(String str) {
        return str == null || C1915m.f6456a.mo1711b((CharSequence) str);
    }
}
