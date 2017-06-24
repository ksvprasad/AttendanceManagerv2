package android.support.v7.widget;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.database.DataSetObservable;
import android.os.AsyncTask;
import android.support.v4.p006e.C0338a;
import android.text.TextUtils;
import android.util.Log;
import android.util.Xml;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

class C0880e extends DataSetObservable {
    private static final String f2668a = C0880e.class.getSimpleName();
    private static final Object f2669b = new Object();
    private static final Map<String, C0880e> f2670c = new HashMap();
    private final Object f2671d;
    private final List<C0875a> f2672e;
    private final List<C0877c> f2673f;
    private final Context f2674g;
    private final String f2675h;
    private Intent f2676i;
    private C0876b f2677j;
    private int f2678k;
    private boolean f2679l;
    private boolean f2680m;
    private boolean f2681n;
    private boolean f2682o;
    private C0878d f2683p;

    public final class C0875a implements Comparable<C0875a> {
        public final ResolveInfo f2661a;
        public float f2662b;
        final /* synthetic */ C0880e f2663c;

        public C0875a(C0880e c0880e, ResolveInfo resolveInfo) {
            this.f2663c = c0880e;
            this.f2661a = resolveInfo;
        }

        public int m5348a(C0875a c0875a) {
            return Float.floatToIntBits(c0875a.f2662b) - Float.floatToIntBits(this.f2662b);
        }

        public /* synthetic */ int compareTo(Object obj) {
            return m5348a((C0875a) obj);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            return Float.floatToIntBits(this.f2662b) == Float.floatToIntBits(((C0875a) obj).f2662b);
        }

        public int hashCode() {
            return Float.floatToIntBits(this.f2662b) + 31;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("[");
            stringBuilder.append("resolveInfo:").append(this.f2661a.toString());
            stringBuilder.append("; weight:").append(new BigDecimal((double) this.f2662b));
            stringBuilder.append("]");
            return stringBuilder.toString();
        }
    }

    public interface C0876b {
        void m5349a(Intent intent, List<C0875a> list, List<C0877c> list2);
    }

    public static final class C0877c {
        public final ComponentName f2664a;
        public final long f2665b;
        public final float f2666c;

        public C0877c(ComponentName componentName, long j, float f) {
            this.f2664a = componentName;
            this.f2665b = j;
            this.f2666c = f;
        }

        public C0877c(String str, long j, float f) {
            this(ComponentName.unflattenFromString(str), j, f);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            C0877c c0877c = (C0877c) obj;
            if (this.f2664a == null) {
                if (c0877c.f2664a != null) {
                    return false;
                }
            } else if (!this.f2664a.equals(c0877c.f2664a)) {
                return false;
            }
            return this.f2665b != c0877c.f2665b ? false : Float.floatToIntBits(this.f2666c) == Float.floatToIntBits(c0877c.f2666c);
        }

        public int hashCode() {
            return (((((this.f2664a == null ? 0 : this.f2664a.hashCode()) + 31) * 31) + ((int) (this.f2665b ^ (this.f2665b >>> 32)))) * 31) + Float.floatToIntBits(this.f2666c);
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("[");
            stringBuilder.append("; activity:").append(this.f2664a);
            stringBuilder.append("; time:").append(this.f2665b);
            stringBuilder.append("; weight:").append(new BigDecimal((double) this.f2666c));
            stringBuilder.append("]");
            return stringBuilder.toString();
        }
    }

    public interface C0878d {
        boolean m5350a(C0880e c0880e, Intent intent);
    }

    private final class C0879e extends AsyncTask<Object, Void, Void> {
        final /* synthetic */ C0880e f2667a;

        private C0879e(C0880e c0880e) {
            this.f2667a = c0880e;
        }

        public Void m5351a(Object... objArr) {
            int i = 0;
            List list = (List) objArr[0];
            String str = (String) objArr[1];
            try {
                OutputStream openFileOutput = this.f2667a.f2674g.openFileOutput(str, 0);
                XmlSerializer newSerializer = Xml.newSerializer();
                try {
                    newSerializer.setOutput(openFileOutput, null);
                    newSerializer.startDocument("UTF-8", Boolean.valueOf(true));
                    newSerializer.startTag(null, "historical-records");
                    int size = list.size();
                    while (i < size) {
                        C0877c c0877c = (C0877c) list.remove(0);
                        newSerializer.startTag(null, "historical-record");
                        newSerializer.attribute(null, "activity", c0877c.f2664a.flattenToString());
                        newSerializer.attribute(null, "time", String.valueOf(c0877c.f2665b));
                        newSerializer.attribute(null, "weight", String.valueOf(c0877c.f2666c));
                        newSerializer.endTag(null, "historical-record");
                        i++;
                    }
                    newSerializer.endTag(null, "historical-records");
                    newSerializer.endDocument();
                    this.f2667a.f2679l = true;
                    if (openFileOutput != null) {
                        try {
                            openFileOutput.close();
                        } catch (IOException e) {
                        }
                    }
                } catch (Throwable e2) {
                    Log.e(C0880e.f2668a, "Error writing historical recrod file: " + this.f2667a.f2675h, e2);
                    this.f2667a.f2679l = true;
                    if (openFileOutput != null) {
                        try {
                            openFileOutput.close();
                        } catch (IOException e3) {
                        }
                    }
                } catch (Throwable e22) {
                    Log.e(C0880e.f2668a, "Error writing historical recrod file: " + this.f2667a.f2675h, e22);
                    this.f2667a.f2679l = true;
                    if (openFileOutput != null) {
                        try {
                            openFileOutput.close();
                        } catch (IOException e4) {
                        }
                    }
                } catch (Throwable e222) {
                    Log.e(C0880e.f2668a, "Error writing historical recrod file: " + this.f2667a.f2675h, e222);
                    this.f2667a.f2679l = true;
                    if (openFileOutput != null) {
                        try {
                            openFileOutput.close();
                        } catch (IOException e5) {
                        }
                    }
                } catch (Throwable th) {
                    this.f2667a.f2679l = true;
                    if (openFileOutput != null) {
                        try {
                            openFileOutput.close();
                        } catch (IOException e6) {
                        }
                    }
                }
            } catch (Throwable e2222) {
                Log.e(C0880e.f2668a, "Error writing historical recrod file: " + str, e2222);
            }
            return null;
        }

        public /* synthetic */ Object doInBackground(Object[] objArr) {
            return m5351a(objArr);
        }
    }

    private boolean m5353a(C0877c c0877c) {
        boolean add = this.f2673f.add(c0877c);
        if (add) {
            this.f2681n = true;
            m5362i();
            m5357d();
            m5359f();
            notifyChanged();
        }
        return add;
    }

    private void m5357d() {
        if (!this.f2680m) {
            throw new IllegalStateException("No preceding call to #readHistoricalData");
        } else if (this.f2681n) {
            this.f2681n = false;
            if (!TextUtils.isEmpty(this.f2675h)) {
                C0338a.m1827a(new C0879e(), new ArrayList(this.f2673f), this.f2675h);
            }
        }
    }

    private void m5358e() {
        int g = m5360g() | m5361h();
        m5362i();
        if (g != 0) {
            m5359f();
            notifyChanged();
        }
    }

    private boolean m5359f() {
        if (this.f2677j == null || this.f2676i == null || this.f2672e.isEmpty() || this.f2673f.isEmpty()) {
            return false;
        }
        this.f2677j.m5349a(this.f2676i, this.f2672e, Collections.unmodifiableList(this.f2673f));
        return true;
    }

    private boolean m5360g() {
        if (!this.f2682o || this.f2676i == null) {
            return false;
        }
        this.f2682o = false;
        this.f2672e.clear();
        List queryIntentActivities = this.f2674g.getPackageManager().queryIntentActivities(this.f2676i, 0);
        int size = queryIntentActivities.size();
        for (int i = 0; i < size; i++) {
            this.f2672e.add(new C0875a(this, (ResolveInfo) queryIntentActivities.get(i)));
        }
        return true;
    }

    private boolean m5361h() {
        if (!this.f2679l || !this.f2681n || TextUtils.isEmpty(this.f2675h)) {
            return false;
        }
        this.f2679l = false;
        this.f2680m = true;
        m5363j();
        return true;
    }

    private void m5362i() {
        int size = this.f2673f.size() - this.f2678k;
        if (size > 0) {
            this.f2681n = true;
            for (int i = 0; i < size; i++) {
                C0877c c0877c = (C0877c) this.f2673f.remove(0);
            }
        }
    }

    private void m5363j() {
        try {
            InputStream openFileInput = this.f2674g.openFileInput(this.f2675h);
            try {
                XmlPullParser newPullParser = Xml.newPullParser();
                newPullParser.setInput(openFileInput, "UTF-8");
                int i = 0;
                while (i != 1 && i != 2) {
                    i = newPullParser.next();
                }
                if ("historical-records".equals(newPullParser.getName())) {
                    List list = this.f2673f;
                    list.clear();
                    while (true) {
                        int next = newPullParser.next();
                        if (next == 1) {
                            break;
                        } else if (!(next == 3 || next == 4)) {
                            if ("historical-record".equals(newPullParser.getName())) {
                                list.add(new C0877c(newPullParser.getAttributeValue(null, "activity"), Long.parseLong(newPullParser.getAttributeValue(null, "time")), Float.parseFloat(newPullParser.getAttributeValue(null, "weight"))));
                            } else {
                                throw new XmlPullParserException("Share records file not well-formed.");
                            }
                        }
                    }
                    if (openFileInput != null) {
                        try {
                            openFileInput.close();
                            return;
                        } catch (IOException e) {
                            return;
                        }
                    }
                    return;
                }
                throw new XmlPullParserException("Share records file does not start with historical-records tag.");
            } catch (Throwable e2) {
                Log.e(f2668a, "Error reading historical recrod file: " + this.f2675h, e2);
                if (openFileInput != null) {
                    try {
                        openFileInput.close();
                    } catch (IOException e3) {
                    }
                }
            } catch (Throwable e22) {
                Log.e(f2668a, "Error reading historical recrod file: " + this.f2675h, e22);
                if (openFileInput != null) {
                    try {
                        openFileInput.close();
                    } catch (IOException e4) {
                    }
                }
            } catch (Throwable th) {
                if (openFileInput != null) {
                    try {
                        openFileInput.close();
                    } catch (IOException e5) {
                    }
                }
            }
        } catch (FileNotFoundException e6) {
        }
    }

    public int m5364a() {
        int size;
        synchronized (this.f2671d) {
            m5358e();
            size = this.f2672e.size();
        }
        return size;
    }

    public int m5365a(ResolveInfo resolveInfo) {
        synchronized (this.f2671d) {
            m5358e();
            List list = this.f2672e;
            int size = list.size();
            for (int i = 0; i < size; i++) {
                if (((C0875a) list.get(i)).f2661a == resolveInfo) {
                    return i;
                }
            }
            return -1;
        }
    }

    public ResolveInfo m5366a(int i) {
        ResolveInfo resolveInfo;
        synchronized (this.f2671d) {
            m5358e();
            resolveInfo = ((C0875a) this.f2672e.get(i)).f2661a;
        }
        return resolveInfo;
    }

    public Intent m5367b(int i) {
        synchronized (this.f2671d) {
            if (this.f2676i == null) {
                return null;
            }
            m5358e();
            C0875a c0875a = (C0875a) this.f2672e.get(i);
            ComponentName componentName = new ComponentName(c0875a.f2661a.activityInfo.packageName, c0875a.f2661a.activityInfo.name);
            Intent intent = new Intent(this.f2676i);
            intent.setComponent(componentName);
            if (this.f2683p != null) {
                if (this.f2683p.m5350a(this, new Intent(intent))) {
                    return null;
                }
            }
            m5353a(new C0877c(componentName, System.currentTimeMillis(), 1.0f));
            return intent;
        }
    }

    public ResolveInfo m5368b() {
        synchronized (this.f2671d) {
            m5358e();
            if (this.f2672e.isEmpty()) {
                return null;
            }
            ResolveInfo resolveInfo = ((C0875a) this.f2672e.get(0)).f2661a;
            return resolveInfo;
        }
    }

    public void m5369c(int i) {
        synchronized (this.f2671d) {
            m5358e();
            C0875a c0875a = (C0875a) this.f2672e.get(i);
            C0875a c0875a2 = (C0875a) this.f2672e.get(0);
            m5353a(new C0877c(new ComponentName(c0875a.f2661a.activityInfo.packageName, c0875a.f2661a.activityInfo.name), System.currentTimeMillis(), c0875a2 != null ? (c0875a2.f2662b - c0875a.f2662b) + 5.0f : 1.0f));
        }
    }
}
