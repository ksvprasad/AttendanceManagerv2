package com.rey.material.p042c;

import android.graphics.Color;

public class C2173a {
    public static int m12391a(int i, float f) {
        return (Math.round(((float) Color.alpha(i)) * f) << 24) | (16777215 & i);
    }

    public static int m12392a(int i, int i2, float f) {
        return i == i2 ? i2 : f == 0.0f ? i : f != 1.0f ? Color.argb(C2173a.m12393b(Color.alpha(i), Color.alpha(i2), f), C2173a.m12393b(Color.red(i), Color.red(i2), f), C2173a.m12393b(Color.green(i), Color.green(i2), f), C2173a.m12393b(Color.blue(i), Color.blue(i2), f)) : i2;
    }

    private static int m12393b(int i, int i2, float f) {
        return Math.round(((float) i) + (((float) (i2 - i)) * f));
    }
}
