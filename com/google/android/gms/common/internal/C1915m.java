package com.google.android.gms.common.internal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class C1915m {
    public static final C1915m f6456a = C1915m.m10845a((CharSequence) "\t\n\u000b\f\r     　 ᠎ ").mo1710a(C1915m.m10844a(' ', ' '));
    public static final C1915m f6457b = C1915m.m10845a((CharSequence) "\t\n\u000b\f\r     　").mo1710a(C1915m.m10844a(' ', ' ')).mo1710a(C1915m.m10844a(' ', ' '));
    public static final C1915m f6458c = C1915m.m10844a('\u0000', '');
    public static final C1915m f6459d;
    public static final C1915m f6460e = C1915m.m10844a('\t', '\r').mo1710a(C1915m.m10844a('\u001c', ' ')).mo1710a(C1915m.m10843a(' ')).mo1710a(C1915m.m10843a('᠎')).mo1710a(C1915m.m10844a(' ', ' ')).mo1710a(C1915m.m10844a(' ', '​')).mo1710a(C1915m.m10844a(' ', ' ')).mo1710a(C1915m.m10843a(' ')).mo1710a(C1915m.m10843a('　'));
    public static final C1915m f6461f = new C19161();
    public static final C1915m f6462g = new C19227();
    public static final C1915m f6463h = new C19238();
    public static final C1915m f6464i = new C19249();
    public static final C1915m f6465j = new C1915m() {
        public boolean mo1709b(char c) {
            return Character.isLowerCase(c);
        }
    };
    public static final C1915m f6466k = C1915m.m10844a('\u0000', '\u001f').mo1710a(C1915m.m10844a('', ''));
    public static final C1915m f6467l = C1915m.m10844a('\u0000', ' ').mo1710a(C1915m.m10844a('', ' ')).mo1710a(C1915m.m10843a('­')).mo1710a(C1915m.m10844a('؀', '؃')).mo1710a(C1915m.m10845a((CharSequence) "۝܏ ឴឵᠎")).mo1710a(C1915m.m10844a(' ', '‏')).mo1710a(C1915m.m10844a(' ', ' ')).mo1710a(C1915m.m10844a(' ', '⁤')).mo1710a(C1915m.m10844a('⁪', '⁯')).mo1710a(C1915m.m10843a('　')).mo1710a(C1915m.m10844a('?', '')).mo1710a(C1915m.m10845a((CharSequence) "﻿￹￺￻"));
    public static final C1915m f6468m = C1915m.m10844a('\u0000', 'ӹ').mo1710a(C1915m.m10843a('־')).mo1710a(C1915m.m10844a('א', 'ת')).mo1710a(C1915m.m10843a('׳')).mo1710a(C1915m.m10843a('״')).mo1710a(C1915m.m10844a('؀', 'ۿ')).mo1710a(C1915m.m10844a('ݐ', 'ݿ')).mo1710a(C1915m.m10844a('฀', '๿')).mo1710a(C1915m.m10844a('Ḁ', '₯')).mo1710a(C1915m.m10844a('℀', '℺')).mo1710a(C1915m.m10844a('ﭐ', '﷿')).mo1710a(C1915m.m10844a('ﹰ', '﻿')).mo1710a(C1915m.m10844a('｡', 'ￜ'));
    public static final C1915m f6469n = new C1915m() {
        public C1915m mo1710a(C1915m c1915m) {
            C1896c.m10790a((Object) c1915m);
            return this;
        }

        public boolean mo1709b(char c) {
            return true;
        }

        public boolean mo1711b(CharSequence charSequence) {
            C1896c.m10790a((Object) charSequence);
            return true;
        }
    };
    public static final C1915m f6470o = new C19172();

    class C19161 extends C1915m {
        C19161() {
        }

        public boolean mo1709b(char c) {
            return Character.isDigit(c);
        }
    }

    class C19172 extends C1915m {
        C19172() {
        }

        public C1915m mo1710a(C1915m c1915m) {
            return (C1915m) C1896c.m10790a((Object) c1915m);
        }

        public boolean mo1709b(char c) {
            return false;
        }

        public boolean mo1711b(CharSequence charSequence) {
            return charSequence.length() == 0;
        }
    }

    class C19183 extends C1915m {
        final /* synthetic */ char f6471p;

        C19183(char c) {
            this.f6471p = c;
        }

        public C1915m mo1710a(C1915m c1915m) {
            return c1915m.mo1709b(this.f6471p) ? c1915m : super.mo1710a(c1915m);
        }

        public boolean mo1709b(char c) {
            return c == this.f6471p;
        }
    }

    class C19194 extends C1915m {
        final /* synthetic */ char f6472p;
        final /* synthetic */ char f6473q;

        C19194(char c, char c2) {
            this.f6472p = c;
            this.f6473q = c2;
        }

        public boolean mo1709b(char c) {
            return c == this.f6472p || c == this.f6473q;
        }
    }

    class C19205 extends C1915m {
        final /* synthetic */ char[] f6474p;

        C19205(char[] cArr) {
            this.f6474p = cArr;
        }

        public boolean mo1709b(char c) {
            return Arrays.binarySearch(this.f6474p, c) >= 0;
        }
    }

    class C19216 extends C1915m {
        final /* synthetic */ char f6475p;
        final /* synthetic */ char f6476q;

        C19216(char c, char c2) {
            this.f6475p = c;
            this.f6476q = c2;
        }

        public boolean mo1709b(char c) {
            return this.f6475p <= c && c <= this.f6476q;
        }
    }

    class C19227 extends C1915m {
        C19227() {
        }

        public boolean mo1709b(char c) {
            return Character.isLetter(c);
        }
    }

    class C19238 extends C1915m {
        C19238() {
        }

        public boolean mo1709b(char c) {
            return Character.isLetterOrDigit(c);
        }
    }

    class C19249 extends C1915m {
        C19249() {
        }

        public boolean mo1709b(char c) {
            return Character.isUpperCase(c);
        }
    }

    private static class C1925a extends C1915m {
        List<C1915m> f6477p;

        C1925a(List<C1915m> list) {
            this.f6477p = list;
        }

        public C1915m mo1710a(C1915m c1915m) {
            List arrayList = new ArrayList(this.f6477p);
            arrayList.add((C1915m) C1896c.m10790a((Object) c1915m));
            return new C1925a(arrayList);
        }

        public boolean mo1709b(char c) {
            for (C1915m b : this.f6477p) {
                if (b.mo1709b(c)) {
                    return true;
                }
            }
            return false;
        }
    }

    static {
        C1915m a = C1915m.m10844a('0', '9');
        C1915m c1915m = a;
        for (char c : "٠۰߀०০੦૦୦௦౦೦൦๐໐༠၀႐០᠐᥆᧐᭐᮰᱀᱐꘠꣐꤀꩐０".toCharArray()) {
            c1915m = c1915m.mo1710a(C1915m.m10844a(c, (char) (c + 9)));
        }
        f6459d = c1915m;
    }

    public static C1915m m10843a(char c) {
        return new C19183(c);
    }

    public static C1915m m10844a(char c, char c2) {
        C1896c.m10798b(c2 >= c);
        return new C19216(c, c2);
    }

    public static C1915m m10845a(CharSequence charSequence) {
        switch (charSequence.length()) {
            case 0:
                return f6470o;
            case 1:
                return C1915m.m10843a(charSequence.charAt(0));
            case 2:
                return new C19194(charSequence.charAt(0), charSequence.charAt(1));
            default:
                char[] toCharArray = charSequence.toString().toCharArray();
                Arrays.sort(toCharArray);
                return new C19205(toCharArray);
        }
    }

    public C1915m mo1710a(C1915m c1915m) {
        return new C1925a(Arrays.asList(new C1915m[]{this, (C1915m) C1896c.m10790a((Object) c1915m)}));
    }

    public abstract boolean mo1709b(char c);

    public boolean mo1711b(CharSequence charSequence) {
        for (int length = charSequence.length() - 1; length >= 0; length--) {
            if (!mo1709b(charSequence.charAt(length))) {
                return false;
            }
        }
        return true;
    }
}
