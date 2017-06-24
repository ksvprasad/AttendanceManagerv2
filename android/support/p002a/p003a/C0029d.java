package android.support.p002a.p003a;

import android.content.res.TypedArray;
import org.xmlpull.v1.XmlPullParser;

class C0029d {
    public static float m131a(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i, float f) {
        return !C0029d.m134a(xmlPullParser, str) ? f : typedArray.getFloat(i, f);
    }

    public static int m132a(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i, int i2) {
        return !C0029d.m134a(xmlPullParser, str) ? i2 : typedArray.getInt(i, i2);
    }

    public static boolean m133a(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i, boolean z) {
        return !C0029d.m134a(xmlPullParser, str) ? z : typedArray.getBoolean(i, z);
    }

    public static boolean m134a(XmlPullParser xmlPullParser, String str) {
        return xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", str) != null;
    }

    public static int m135b(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i, int i2) {
        return !C0029d.m134a(xmlPullParser, str) ? i2 : typedArray.getColor(i, i2);
    }
}
