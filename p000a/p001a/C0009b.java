package p000a.p001a;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.GregorianCalendar;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class C0009b {
    private static final Pattern f32i = Pattern.compile("\\|[^\\|]*\\|");
    private static final Pattern f33j = Pattern.compile("f{1,9}");
    private static final List<String> f34k = new ArrayList();
    private final String f35a;
    private final Locale f36b;
    private Collection<C0008c> f37c;
    private Collection<C0007b> f38d;
    private final Map<Locale, List<String>> f39e = new LinkedHashMap();
    private final Map<Locale, List<String>> f40f = new LinkedHashMap();
    private final Map<Locale, List<String>> f41g = new LinkedHashMap();
    private final C0006a f42h;

    private final class C0006a {
        List<String> f24a;
        List<String> f25b;
        List<String> f26c;
    }

    private static final class C0007b {
        int f27a;
        int f28b;

        private C0007b() {
        }
    }

    private static final class C0008c {
        int f29a;
        int f30b;
        String f31c;

        private C0008c() {
        }

        public String toString() {
            return "Start:" + this.f29a + " End:" + this.f30b + " '" + this.f31c + "'";
        }
    }

    static {
        f34k.add("YYYY");
        f34k.add("YY");
        f34k.add("MMMM");
        f34k.add("MMM");
        f34k.add("MM");
        f34k.add("M");
        f34k.add("DD");
        f34k.add("D");
        f34k.add("WWWW");
        f34k.add("WWW");
        f34k.add("hh12");
        f34k.add("h12");
        f34k.add("hh");
        f34k.add("h");
        f34k.add("mm");
        f34k.add("m");
        f34k.add("ss");
        f34k.add("s");
        f34k.add("a");
        f34k.add("fffffffff");
        f34k.add("ffffffff");
        f34k.add("fffffff");
        f34k.add("ffffff");
        f34k.add("fffff");
        f34k.add("ffff");
        f34k.add("fff");
        f34k.add("ff");
        f34k.add("f");
    }

    C0009b(String str) {
        this.f35a = str;
        this.f36b = null;
        this.f42h = null;
        m56c();
    }

    private C0008c m41a(int i) {
        C0008c c0008c = null;
        for (C0008c c0008c2 : this.f37c) {
            C0008c c0008c22;
            if (c0008c22.f29a != i) {
                c0008c22 = c0008c;
            }
            c0008c = c0008c22;
        }
        return c0008c;
    }

    private String m42a(Integer num) {
        String a = m43a((Object) num);
        while (a.length() < 9) {
            a = "0" + a;
        }
        return a;
    }

    private String m43a(Object obj) {
        return obj != null ? String.valueOf(obj) : "";
    }

    private String m44a(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 1; i <= str.length(); i++) {
            stringBuilder.append("@");
        }
        return stringBuilder.toString();
    }

    private String m45a(String str, int i) {
        return (!C0017f.m111a(str) || str.length() < i) ? str : str.substring(0, i);
    }

    private String m46a(String str, C0004a c0004a) {
        String str2 = "";
        if ("YYYY".equals(str)) {
            return m43a(c0004a.m21a());
        }
        if ("YY".equals(str)) {
            return m52b(m43a(c0004a.m21a()));
        }
        if ("MMMM".equals(str)) {
            return m51b(Integer.valueOf(c0004a.m27b().intValue()));
        }
        if ("MMM".equals(str)) {
            return m58d(m51b(Integer.valueOf(c0004a.m27b().intValue())));
        }
        if ("MM".equals(str)) {
            return m55c(m43a(c0004a.m27b()));
        }
        if ("M".equals(str)) {
            return m43a(c0004a.m27b());
        }
        if ("DD".equals(str)) {
            return m55c(m43a(c0004a.m31c()));
        }
        if ("D".equals(str)) {
            return m43a(c0004a.m31c());
        }
        if ("WWWW".equals(str)) {
            return m59e(Integer.valueOf(c0004a.m37i().intValue()));
        }
        if ("WWW".equals(str)) {
            return m58d(m59e(Integer.valueOf(c0004a.m37i().intValue())));
        }
        if ("hh".equals(str)) {
            return m55c(m43a(c0004a.m32d()));
        }
        if ("h".equals(str)) {
            return m43a(c0004a.m32d());
        }
        if ("h12".equals(str)) {
            return m43a(m62h(c0004a.m32d()));
        }
        if ("hh12".equals(str)) {
            return m55c(m43a(m62h(c0004a.m32d())));
        }
        if ("a".equals(str)) {
            return m63i(Integer.valueOf(c0004a.m32d().intValue()));
        }
        if ("mm".equals(str)) {
            return m55c(m43a(c0004a.m33e()));
        }
        if ("m".equals(str)) {
            return m43a(c0004a.m33e());
        }
        if ("ss".equals(str)) {
            return m55c(m43a(c0004a.m34f()));
        }
        if ("s".equals(str)) {
            return m43a(c0004a.m34f());
        }
        if (!str.startsWith("f")) {
            throw new IllegalArgumentException("Unknown token in date formatting pattern: " + str);
        } else if (f33j.matcher(str).matches()) {
            return m45a(m42a(c0004a.m35g()), str.length());
        } else {
            throw new IllegalArgumentException("Unknown token in date formatting pattern: " + str);
        }
    }

    private void m47a() {
        Matcher matcher = f32i.matcher(this.f35a);
        while (matcher.find()) {
            C0007b c0007b = new C0007b();
            c0007b.f27a = matcher.start();
            c0007b.f28b = matcher.end() - 1;
            this.f38d.add(c0007b);
        }
    }

    private boolean m48a(C0008c c0008c) {
        for (C0007b c0007b : this.f38d) {
            if (c0007b.f27a <= c0008c.f29a && c0008c.f29a <= c0007b.f28b) {
                return true;
            }
        }
        return false;
    }

    private String m49b() {
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        while (i < this.f35a.length()) {
            String b = m50b(i);
            C0008c a = m41a(i);
            if (a != null) {
                stringBuilder.append(a.f31c);
                i = a.f30b;
            } else if (!"|".equals(b)) {
                stringBuilder.append(b);
            }
            i++;
        }
        return stringBuilder.toString();
    }

    private String m50b(int i) {
        return this.f35a.substring(i, i + 1);
    }

    private String m51b(Integer num) {
        String str = "";
        if (num == null) {
            return str;
        }
        if (this.f42h != null) {
            return m54c(num);
        }
        if (this.f36b != null) {
            return m57d(num);
        }
        throw new IllegalArgumentException("Your date pattern requires either a Locale, or your own custom localizations for text:" + C0017f.m110a(this.f35a));
    }

    private String m52b(String str) {
        return C0017f.m111a(str) ? str.substring(2) : "";
    }

    private void m53b(C0004a c0004a) {
        String str = this.f35a;
        Object obj = str;
        for (String str2 : f34k) {
            Matcher matcher = Pattern.compile(str2).matcher(obj);
            while (matcher.find()) {
                C0008c c0008c = new C0008c();
                c0008c.f29a = matcher.start();
                c0008c.f30b = matcher.end() - 1;
                if (!m48a(c0008c)) {
                    c0008c.f31c = m46a(matcher.group(), c0004a);
                    this.f37c.add(c0008c);
                }
            }
            String replace = obj.replace(str2, m44a(str2));
        }
    }

    private String m54c(Integer num) {
        return (String) this.f42h.f24a.get(num.intValue() - 1);
    }

    private String m55c(String str) {
        return (C0017f.m111a(str) && str.length() == 1) ? "0" + str : str;
    }

    private void m56c() {
        if (!C0017f.m111a(this.f35a)) {
            throw new IllegalArgumentException("DateTime format has no content.");
        }
    }

    private String m57d(Integer num) {
        String str = "";
        if (!this.f39e.containsKey(this.f36b)) {
            List arrayList = new ArrayList();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMMM", this.f36b);
            for (int i = 0; i <= 11; i++) {
                Calendar gregorianCalendar = new GregorianCalendar();
                gregorianCalendar.set(1, 2000);
                gregorianCalendar.set(2, i);
                gregorianCalendar.set(5, 15);
                arrayList.add(simpleDateFormat.format(gregorianCalendar.getTime()));
            }
            this.f39e.put(this.f36b, arrayList);
        }
        return (String) ((List) this.f39e.get(this.f36b)).get(num.intValue() - 1);
    }

    private String m58d(String str) {
        return (!C0017f.m111a(str) || str.length() < 3) ? str : str.substring(0, 3);
    }

    private String m59e(Integer num) {
        String str = "";
        if (num == null) {
            return str;
        }
        if (this.f42h != null) {
            return m60f(num);
        }
        if (this.f36b != null) {
            return m61g(num);
        }
        throw new IllegalArgumentException("Your date pattern requires either a Locale, or your own custom localizations for text:" + C0017f.m110a(this.f35a));
    }

    private String m60f(Integer num) {
        return (String) this.f42h.f25b.get(num.intValue() - 1);
    }

    private String m61g(Integer num) {
        String str = "";
        if (!this.f40f.containsKey(this.f36b)) {
            List arrayList = new ArrayList();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEEE", this.f36b);
            for (int i = 8; i <= 14; i++) {
                Calendar gregorianCalendar = new GregorianCalendar();
                gregorianCalendar.set(1, 2009);
                gregorianCalendar.set(2, 1);
                gregorianCalendar.set(5, i);
                arrayList.add(simpleDateFormat.format(gregorianCalendar.getTime()));
            }
            this.f40f.put(this.f36b, arrayList);
        }
        return (String) ((List) this.f40f.get(this.f36b)).get(num.intValue() - 1);
    }

    private Integer m62h(Integer num) {
        return num != null ? num.intValue() == 0 ? Integer.valueOf(12) : num.intValue() > 12 ? Integer.valueOf(num.intValue() - 12) : num : num;
    }

    private String m63i(Integer num) {
        String str = "";
        if (num == null) {
            return str;
        }
        if (this.f42h != null) {
            return m64j(num);
        }
        if (this.f36b != null) {
            return m65k(num);
        }
        throw new IllegalArgumentException("Your date pattern requires either a Locale, or your own custom localizations for text:" + C0017f.m110a(this.f35a));
    }

    private String m64j(Integer num) {
        String str = "";
        return num.intValue() < 12 ? (String) this.f42h.f26c.get(0) : (String) this.f42h.f26c.get(1);
    }

    private String m65k(Integer num) {
        String str = "";
        if (!this.f41g.containsKey(this.f36b)) {
            List arrayList = new ArrayList();
            arrayList.add(m66l(Integer.valueOf(6)));
            arrayList.add(m66l(Integer.valueOf(18)));
            this.f41g.put(this.f36b, arrayList);
        }
        return num.intValue() < 12 ? (String) ((List) this.f41g.get(this.f36b)).get(0) : (String) ((List) this.f41g.get(this.f36b)).get(1);
    }

    private String m66l(Integer num) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("a", this.f36b);
        Calendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.set(1, 2000);
        gregorianCalendar.set(2, 6);
        gregorianCalendar.set(5, 15);
        gregorianCalendar.set(11, num.intValue());
        return simpleDateFormat.format(gregorianCalendar.getTime());
    }

    String m67a(C0004a c0004a) {
        this.f38d = new ArrayList();
        this.f37c = new ArrayList();
        m47a();
        m53b(c0004a);
        return m49b();
    }
}
