package com.google.android.gms.p031b;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public abstract class mp {
    private static final ExecutorService f5963a = Executors.newFixedThreadPool(2, new nk("GAC_Executor"));

    public static ExecutorService m10005a() {
        return f5963a;
    }
}
