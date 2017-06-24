package android.support.design.widget;

import android.support.v7.widget.C0162n;
import android.view.ViewParent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;

public class C0163t extends C0162n {
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
        if (onCreateInputConnection != null && editorInfo.hintText == null) {
            ViewParent parent = getParent();
            if (parent instanceof TextInputLayout) {
                editorInfo.hintText = ((TextInputLayout) parent).getHint();
            }
        }
        return onCreateInputConnection;
    }
}
