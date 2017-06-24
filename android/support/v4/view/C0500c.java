package android.support.v4.view;

import android.os.Bundle;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;

class C0500c {

    public interface C0406a {
        Object mo303a(View view);

        void mo304a(View view, int i);

        void mo305a(View view, Object obj);

        boolean mo306a(View view, int i, Bundle bundle);

        boolean mo307a(View view, AccessibilityEvent accessibilityEvent);

        boolean mo308a(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent);

        void mo309b(View view, AccessibilityEvent accessibilityEvent);

        void mo310c(View view, AccessibilityEvent accessibilityEvent);

        void mo311d(View view, AccessibilityEvent accessibilityEvent);
    }

    public static Object m2774a(final C0406a c0406a) {
        return new AccessibilityDelegate() {
            public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
                return c0406a.mo307a(view, accessibilityEvent);
            }

            public AccessibilityNodeProvider getAccessibilityNodeProvider(View view) {
                return (AccessibilityNodeProvider) c0406a.mo303a(view);
            }

            public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
                c0406a.mo309b(view, accessibilityEvent);
            }

            public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
                c0406a.mo305a(view, (Object) accessibilityNodeInfo);
            }

            public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
                c0406a.mo310c(view, accessibilityEvent);
            }

            public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
                return c0406a.mo308a(viewGroup, view, accessibilityEvent);
            }

            public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
                return c0406a.mo306a(view, i, bundle);
            }

            public void sendAccessibilityEvent(View view, int i) {
                c0406a.mo304a(view, i);
            }

            public void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
                c0406a.mo311d(view, accessibilityEvent);
            }
        };
    }

    public static Object m2775a(Object obj, View view) {
        return ((AccessibilityDelegate) obj).getAccessibilityNodeProvider(view);
    }

    public static boolean m2776a(Object obj, View view, int i, Bundle bundle) {
        return ((AccessibilityDelegate) obj).performAccessibilityAction(view, i, bundle);
    }
}
