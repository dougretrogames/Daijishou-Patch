package androidx.leanback.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import java.util.List;

/* INFO: loaded from: classes.dex */
public class SearchEditText extends StreamingTextView {
    private static final boolean DEBUG = false;
    private static final String TAG = "SearchEditText";
    OnKeyboardDismissListener mKeyboardDismissListener;

    public interface OnKeyboardDismissListener {
        void onKeyboardDismiss();
    }

    @Override // androidx.leanback.widget.StreamingTextView, android.view.View
    public /* bridge */ /* synthetic */ void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
    }

    @Override // androidx.leanback.widget.StreamingTextView
    public /* bridge */ /* synthetic */ void reset() {
        super.reset();
    }

    @Override // androidx.leanback.widget.StreamingTextView, android.widget.TextView
    public /* bridge */ /* synthetic */ void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(callback);
    }

    @Override // androidx.leanback.widget.StreamingTextView
    public /* bridge */ /* synthetic */ void setFinalRecognizedText(CharSequence charSequence) {
        super.setFinalRecognizedText(charSequence);
    }

    @Override // androidx.leanback.widget.StreamingTextView
    public /* bridge */ /* synthetic */ void updateRecognizedText(String str, String str2) {
        super.updateRecognizedText(str, str2);
    }

    @Override // androidx.leanback.widget.StreamingTextView
    public /* bridge */ /* synthetic */ void updateRecognizedText(String str, List list) {
        super.updateRecognizedText(str, (List<Float>) list);
    }

    public SearchEditText(Context context) {
        this(context, null);
    }

    public SearchEditText(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, androidx.leanback.R.style.TextAppearance_Leanback_SearchTextEdit);
    }

    public SearchEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onKeyPreIme(int i, KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 4 && this.mKeyboardDismissListener != null) {
            post(new AnonymousClass1());
        }
        return super.onKeyPreIme(i, keyEvent);
    }

    /* INFO: renamed from: androidx.leanback.widget.SearchEditText$1, reason: invalid class name */
    class AnonymousClass1 implements Runnable {
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (SearchEditText.this.mKeyboardDismissListener != null) {
                SearchEditText.this.mKeyboardDismissListener.onKeyboardDismiss();
            }
        }
    }

    public void setOnKeyboardDismissListener(OnKeyboardDismissListener onKeyboardDismissListener) {
        this.mKeyboardDismissListener = onKeyboardDismissListener;
    }
}
