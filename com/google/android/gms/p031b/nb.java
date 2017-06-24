package com.google.android.gms.p031b;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public abstract class nb {
    private static final ExecutorService f6022a = new ThreadPoolExecutor(0, 4, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new nk("GAC_Transform"));

    public static ExecutorService m10089a() {
        return f6022a;
    }
}
