package android.support.v4.view.p016a;

import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.util.List;

class C0444k {

    interface C0437a {
        Object mo347a(int i);

        List<Object> mo348a(String str, int i);

        boolean mo349a(int i, int i2, Bundle bundle);

        Object mo350b(int i);
    }

    public static Object m2270a(final C0437a c0437a) {
        return new AccessibilityNodeProvider() {
            public AccessibilityNodeInfo createAccessibilityNodeInfo(int i) {
                return (AccessibilityNodeInfo) c0437a.mo347a(i);
            }

            public List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText(String str, int i) {
                return c0437a.mo348a(str, i);
            }

            public AccessibilityNodeInfo findFocus(int i) {
                return (AccessibilityNodeInfo) c0437a.mo350b(i);
            }

            public boolean performAction(int i, int i2, Bundle bundle) {
                return c0437a.mo349a(i, i2, bundle);
            }
        };
    }
}
