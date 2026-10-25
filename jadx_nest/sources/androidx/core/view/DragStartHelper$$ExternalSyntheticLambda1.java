package androidx.core.view;

import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class DragStartHelper$$ExternalSyntheticLambda1 implements View.OnTouchListener {
    public final /* synthetic */ DragStartHelper f$0;

    public /* synthetic */ DragStartHelper$$ExternalSyntheticLambda1(DragStartHelper dragStartHelper) {
        this.f$0 = dragStartHelper;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        return this.f$0.onTouch(view, motionEvent);
    }
}
