package com.prolificinteractive.materialcalendarview.p039a;

public class C2134a implements C2133h {
    private final CharSequence[] f7183b;

    public C2134a(CharSequence[] charSequenceArr) {
        if (charSequenceArr == null) {
            throw new IllegalArgumentException("Cannot be null");
        } else if (charSequenceArr.length != 7) {
            throw new IllegalArgumentException("Array must contain exactly 7 elements");
        } else {
            this.f7183b = charSequenceArr;
        }
    }

    public CharSequence mo1781a(int i) {
        return this.f7183b[i - 1];
    }
}
