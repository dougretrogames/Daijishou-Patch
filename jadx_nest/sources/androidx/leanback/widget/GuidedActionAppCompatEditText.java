package androidx.leanback.widget;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.autofill.AutofillValue;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.core.widget.TextViewCompat;

/* JADX INFO: loaded from: classes.dex */
public class GuidedActionAppCompatEditText extends AppCompatEditText implements ImeKeyMonitor, GuidedActionAutofillSupport {
    private GuidedActionAutofillSupport.OnAutofillListener mAutofillListener;
    private ImeKeyMonitor.ImeKeyListener mKeyListener;
    private final Drawable mNoPaddingDrawable;
    private final Drawable mSavedBackground;

    @Override // android.widget.TextView, android.view.View
    public int getAutofillType() {
        return 1;
    }

    public GuidedActionAppCompatEditText(Context context) {
        this(context, null);
    }

    public GuidedActionAppCompatEditText(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, android.R.attr.editTextStyle);
    }

    public GuidedActionAppCompatEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSavedBackground = getBackground();
        GuidedActionEditText.NoPaddingDrawable noPaddingDrawable = new GuidedActionEditText.NoPaddingDrawable();
        this.mNoPaddingDrawable = noPaddingDrawable;
        setBackground(noPaddingDrawable);
    }

    @Override // androidx.leanback.widget.ImeKeyMonitor
    public void setImeKeyListener(ImeKeyMonitor.ImeKeyListener imeKeyListener) {
        this.mKeyListener = imeKeyListener;
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onKeyPreIme(int i, KeyEvent keyEvent) {
        ImeKeyMonitor.ImeKeyListener imeKeyListener = this.mKeyListener;
        boolean zOnKeyPreIme = imeKeyListener != null ? imeKeyListener.onKeyPreIme(this, i, keyEvent) : false;
        return !zOnKeyPreIme ? super.onKeyPreIme(i, keyEvent) : zOnKeyPreIme;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName((isFocused() ? AppCompatEditText.class : TextView.class).getName());
    }

    @Override // android.widget.TextView, android.view.View
    protected void onFocusChanged(boolean z, int i, Rect rect) {
        super.onFocusChanged(z, i, rect);
        if (z) {
            setBackground(this.mSavedBackground);
        } else {
            setBackground(this.mNoPaddingDrawable);
        }
        if (z) {
            return;
        }
        setFocusable(false);
    }

    @Override // androidx.leanback.widget.GuidedActionAutofillSupport
    public void setOnAutofillListener(GuidedActionAutofillSupport.OnAutofillListener onAutofillListener) {
        this.mAutofillListener = onAutofillListener;
    }

    @Override // android.widget.TextView, android.view.View
    public void autofill(AutofillValue autofillValue) {
        super.autofill(autofillValue);
        GuidedActionAutofillSupport.OnAutofillListener onAutofillListener = this.mAutofillListener;
        if (onAutofillListener != null) {
            onAutofillListener.onAutofill(this);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatEditText, android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(TextViewCompat.wrapCustomSelectionActionModeCallback(this, callback));
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!isInTouchMode() || isFocusableInTouchMode() || isTextSelectable()) {
            return super.onTouchEvent(motionEvent);
        }
        return false;
    }
}
