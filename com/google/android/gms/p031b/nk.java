package com.google.android.gms.p031b;

import com.google.android.gms.common.internal.C1896c;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class nk implements ThreadFactory {
    private final String f6059a;
    private final int f6060b;
    private final AtomicInteger f6061c;
    private final ThreadFactory f6062d;

    public nk(String str) {
        this(str, 0);
    }

    public nk(String str, int i) {
        this.f6061c = new AtomicInteger();
        this.f6062d = Executors.defaultThreadFactory();
        this.f6059a = (String) C1896c.m10791a((Object) str, (Object) "Name must not be null");
        this.f6060b = i;
    }

    public Thread newThread(Runnable runnable) {
        Thread newThread = this.f6062d.newThread(new nl(runnable, this.f6060b));
        String str = this.f6059a;
        newThread.setName(new StringBuilder(String.valueOf(str).length() + 13).append(str).append("[").append(this.f6061c.getAndIncrement()).append("]").toString());
        return newThread;
    }
}
