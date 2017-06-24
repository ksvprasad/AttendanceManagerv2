package com.google.android.gms.p031b;

import android.os.Process;

class nl implements Runnable {
    private final Runnable f6063a;
    private final int f6064b;

    public nl(Runnable runnable, int i) {
        this.f6063a = runnable;
        this.f6064b = i;
    }

    public void run() {
        Process.setThreadPriority(this.f6064b);
        this.f6063a.run();
    }
}
