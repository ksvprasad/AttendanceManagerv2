package com.google.android.gms.ads.mediation;

import android.os.Bundle;

public interface C0957b {

    public static class C1332a {
        private int f4015a;

        public Bundle m7265a() {
            Bundle bundle = new Bundle();
            bundle.putInt("capabilities", this.f4015a);
            return bundle;
        }

        public C1332a m7266a(int i) {
            this.f4015a = i;
            return this;
        }
    }

    void onDestroy();

    void onPause();

    void onResume();
}
