package androidx.leanback.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.app.AppCompatViewInflater;

/* JADX INFO: loaded from: classes.dex */
public class LeanbackAppCompatViewInflater extends AppCompatViewInflater {
    @Override // androidx.appcompat.app.AppCompatViewInflater
    protected View createView(Context context, String str, AttributeSet attributeSet) {
        str.hashCode();
        if (str.equals("androidx.leanback.widget.GuidedActionEditText")) {
            return new GuidedActionAppCompatEditText(context, attributeSet);
        }
        return null;
    }
}
