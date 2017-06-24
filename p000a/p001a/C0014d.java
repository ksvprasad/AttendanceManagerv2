package p000a.p001a;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class C0014d {
    private static final Pattern f63a = Pattern.compile("(\\d{1,4})-(\\d\\d)-(\\d\\d)|(\\d{1,4})-(\\d\\d)|(\\d{1,4})");
    private static final Integer f64b = Integer.valueOf("9");
    private static final Pattern f65c = Pattern.compile("(\\d\\d)\\:(\\d\\d)\\:(\\d\\d)\\.(\\d{1,9})|(\\d\\d)\\:(\\d\\d)\\:(\\d\\d)|(\\d\\d)\\:(\\d\\d)|(\\d\\d)");
    private Integer f66d;
    private Integer f67e;
    private Integer f68f;
    private Integer f69g;
    private Integer f70h;
    private Integer f71i;
    private Integer f72j;

    private class C0012a {
        String f60a;
        String f61b;
        final /* synthetic */ C0014d f62c;

        private C0012a(C0014d c0014d) {
            this.f62c = c0014d;
        }

        boolean m90a() {
            return (this.f60a == null || this.f61b == null) ? false : true;
        }

        boolean m91b() {
            return this.f61b == null;
        }

        boolean m92c() {
            return this.f60a == null;
        }
    }

    static final class C0013b extends RuntimeException {
        C0013b(String str) {
            super(str);
        }
    }

    C0014d() {
    }

    private String m93a(Matcher matcher, int... iArr) {
        String str = null;
        for (int group : iArr) {
            str = matcher.group(group);
            if (str != null) {
                break;
            }
        }
        return str;
    }

    private C0012a m94c(String str) {
        C0012a c0012a = new C0012a();
        int b = m100b(str);
        int i = (b <= 0 || b >= str.length()) ? 0 : 1;
        if (i != 0) {
            c0012a.f60a = str.substring(0, b);
            c0012a.f61b = str.substring(b + 1);
        } else if (m95d(str)) {
            c0012a.f61b = str;
        } else {
            c0012a.f60a = str;
        }
        return c0012a;
    }

    private boolean m95d(String str) {
        return str.length() >= 2 ? ":".equals(str.substring(2, 3)) : false;
    }

    private void m96e(String str) {
        Matcher matcher = f63a.matcher(str);
        if (matcher.matches()) {
            String a = m93a(matcher, 1, 4, 6);
            if (a != null) {
                this.f66d = Integer.valueOf(a);
            }
            a = m93a(matcher, 2, 5);
            if (a != null) {
                this.f67e = Integer.valueOf(a);
            }
            String a2 = m93a(matcher, 3);
            if (a2 != null) {
                this.f68f = Integer.valueOf(a2);
                return;
            }
            return;
        }
        throw new C0013b("Unexpected format for date:" + str);
    }

    private void m97f(String str) {
        Matcher matcher = f65c.matcher(str);
        if (matcher.matches()) {
            String a = m93a(matcher, 1, 5, 8, 10);
            if (a != null) {
                this.f69g = Integer.valueOf(a);
            }
            a = m93a(matcher, 2, 6, 9);
            if (a != null) {
                this.f70h = Integer.valueOf(a);
            }
            a = m93a(matcher, 3, 7);
            if (a != null) {
                this.f71i = Integer.valueOf(a);
            }
            String a2 = m93a(matcher, 4);
            if (a2 != null) {
                this.f72j = Integer.valueOf(m98g(a2));
                return;
            }
            return;
        }
        throw new C0013b("Unexpected format for time:" + str);
    }

    private String m98g(String str) {
        StringBuilder stringBuilder = new StringBuilder(str);
        while (stringBuilder.length() < f64b.intValue()) {
            stringBuilder.append("0");
        }
        return stringBuilder.toString();
    }

    C0004a m99a(String str) {
        if (str == null) {
            throw new NullPointerException("DateTime string is null");
        }
        C0012a c = m94c(str.trim());
        if (c.m90a()) {
            m96e(c.f60a);
            m97f(c.f61b);
        } else if (c.m91b()) {
            m96e(c.f60a);
        } else if (c.m92c()) {
            m97f(c.f61b);
        }
        return new C0004a(this.f66d, this.f67e, this.f68f, this.f69g, this.f70h, this.f71i, this.f72j);
    }

    int m100b(String str) {
        int indexOf = str.indexOf(" ");
        return indexOf == -1 ? str.indexOf("T") : indexOf;
    }
}
