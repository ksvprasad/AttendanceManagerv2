package android.support.v4.p014f;

import java.util.Locale;

public final class C0361e {
    public static final C0353d f1091a = new C0359e(null, false);
    public static final C0353d f1092b = new C0359e(null, true);
    public static final C0353d f1093c = new C0359e(C0357b.f1087a, false);
    public static final C0353d f1094d = new C0359e(C0357b.f1087a, true);
    public static final C0353d f1095e = new C0359e(C0356a.f1084a, false);
    public static final C0353d f1096f = C0360f.f1090a;

    private interface C0355c {
        int mo269a(CharSequence charSequence, int i, int i2);
    }

    private static class C0356a implements C0355c {
        public static final C0356a f1084a = new C0356a(true);
        public static final C0356a f1085b = new C0356a(false);
        private final boolean f1086c;

        private C0356a(boolean z) {
            this.f1086c = z;
        }

        public int mo269a(CharSequence charSequence, int i, int i2) {
            int i3 = i + i2;
            int i4 = 0;
            while (i < i3) {
                switch (C0361e.m1855c(Character.getDirectionality(charSequence.charAt(i)))) {
                    case 0:
                        if (!this.f1086c) {
                            i4 = 1;
                            break;
                        }
                        return 0;
                    case 1:
                        if (this.f1086c) {
                            i4 = 1;
                            break;
                        }
                        return 1;
                    default:
                        break;
                }
                i++;
            }
            return i4 != 0 ? !this.f1086c ? 0 : 1 : 2;
        }
    }

    private static class C0357b implements C0355c {
        public static final C0357b f1087a = new C0357b();

        private C0357b() {
        }

        public int mo269a(CharSequence charSequence, int i, int i2) {
            int i3 = i + i2;
            int i4 = 2;
            while (i < i3 && i4 == 2) {
                i4 = C0361e.m1856d(Character.getDirectionality(charSequence.charAt(i)));
                i++;
            }
            return i4;
        }
    }

    private static abstract class C0358d implements C0353d {
        private final C0355c f1088a;

        public C0358d(C0355c c0355c) {
            this.f1088a = c0355c;
        }

        private boolean m1848b(CharSequence charSequence, int i, int i2) {
            switch (this.f1088a.mo269a(charSequence, i, i2)) {
                case 0:
                    return true;
                case 1:
                    return false;
                default:
                    return mo271a();
            }
        }

        protected abstract boolean mo271a();

        public boolean mo270a(CharSequence charSequence, int i, int i2) {
            if (charSequence != null && i >= 0 && i2 >= 0 && charSequence.length() - i2 >= i) {
                return this.f1088a == null ? mo271a() : m1848b(charSequence, i, i2);
            } else {
                throw new IllegalArgumentException();
            }
        }
    }

    private static class C0359e extends C0358d {
        private final boolean f1089a;

        private C0359e(C0355c c0355c, boolean z) {
            super(c0355c);
            this.f1089a = z;
        }

        protected boolean mo271a() {
            return this.f1089a;
        }
    }

    private static class C0360f extends C0358d {
        public static final C0360f f1090a = new C0360f();

        public C0360f() {
            super(null);
        }

        protected boolean mo271a() {
            return C0365f.m1860a(Locale.getDefault()) == 1;
        }
    }

    private static int m1855c(int i) {
        switch (i) {
            case 0:
                return 1;
            case 1:
            case 2:
                return 0;
            default:
                return 2;
        }
    }

    private static int m1856d(int i) {
        switch (i) {
            case 0:
            case 14:
            case 15:
                return 1;
            case 1:
            case 2:
            case 16:
            case 17:
                return 0;
            default:
                return 2;
        }
    }
}
