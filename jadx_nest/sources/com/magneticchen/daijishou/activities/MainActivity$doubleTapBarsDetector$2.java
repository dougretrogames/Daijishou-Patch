package com.magneticchen.daijishou.activities;

import android.view.GestureDetector;
import android.view.MotionEvent;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* INFO: compiled from: MainActivity.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/view/GestureDetector;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
final class MainActivity$doubleTapBarsDetector$2 extends Lambda<GestureDetector> implements Function0<GestureDetector> {
    final /* synthetic */ MainActivity this$0;

    /* WARN: 'super' call moved to the top of the method (can break code semantics) */
    MainActivity$doubleTapBarsDetector$2(MainActivity mainActivity) {
        super(0);
        this.this$0 = mainActivity;
    }

    /* INFO: renamed from: com.magneticchen.daijishou.activities.MainActivity$doubleTapBarsDetector$2$1, reason: invalid class name */
    /* INFO: compiled from: MainActivity.kt */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/magneticchen/daijishou/activities/MainActivity$doubleTapBarsDetector$2$1", "Landroid/view/GestureDetector$SimpleOnGestureListener;", "onDoubleTap", "", "e", "Landroid/view/MotionEvent;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class AnonymousClass1 extends GestureDetector.SimpleOnGestureListener {
        final /* synthetic */ MainActivity this$0;

        AnonymousClass1(MainActivity mainActivity) {
            this.this$0 = mainActivity;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent e) {
            Intrinsics.checkNotNullParameter(e, "e");
            MainActivity mainActivity = this.this$0;
            mainActivity.lockScreenViaAccessibility(mainActivity);
            return true;
        }
    }

    /* WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final GestureDetector invoke() {
        return new GestureDetector(this.this$0, new AnonymousClass1(this.this$0));
    }
}
