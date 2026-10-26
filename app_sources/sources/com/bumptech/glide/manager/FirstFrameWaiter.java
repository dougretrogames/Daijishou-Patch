package com.bumptech.glide.manager;

import android.app.Activity;
import android.view.View;
import android.view.ViewTreeObserver;
import com.bumptech.glide.load.resource.bitmap.HardwareConfigState;
import com.bumptech.glide.util.Util;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;

/* INFO: loaded from: classes3.dex */
final class FirstFrameWaiter implements FrameWaiter {
    volatile boolean isFirstFrameSet;
    final Set<Activity> pendingActivities = Collections.newSetFromMap(new WeakHashMap());

    FirstFrameWaiter() {
    }

    @Override // com.bumptech.glide.manager.FrameWaiter
    public void registerSelf(Activity activity) {
        if (!this.isFirstFrameSet && this.pendingActivities.add(activity)) {
            View decorView = activity.getWindow().getDecorView();
            decorView.getViewTreeObserver().addOnDrawListener(new AnonymousClass1(decorView));
        }
    }

    /* INFO: renamed from: com.bumptech.glide.manager.FirstFrameWaiter$1, reason: invalid class name */
    class AnonymousClass1 implements ViewTreeObserver.OnDrawListener {
        final /* synthetic */ View val$view;

        AnonymousClass1(View view) {
            this.val$view = view;
        }

        /* INFO: renamed from: com.bumptech.glide.manager.FirstFrameWaiter$1$1, reason: invalid class name and collision with other inner class name */
        class RunnableC00271 implements Runnable {
            final /* synthetic */ ViewTreeObserver.OnDrawListener val$listener;

            RunnableC00271(ViewTreeObserver.OnDrawListener onDrawListener) {
                this.val$listener = onDrawListener;
            }

            @Override // java.lang.Runnable
            public void run() {
                HardwareConfigState.getInstance().unblockHardwareBitmaps();
                FirstFrameWaiter.this.isFirstFrameSet = true;
                FirstFrameWaiter.removeListener(AnonymousClass1.this.val$view, this.val$listener);
                FirstFrameWaiter.this.pendingActivities.clear();
            }
        }

        @Override // android.view.ViewTreeObserver.OnDrawListener
        public void onDraw() {
            Util.postOnUiThread(new RunnableC00271(this));
        }
    }

    static void removeListener(View view, ViewTreeObserver.OnDrawListener onDrawListener) {
        view.getViewTreeObserver().removeOnDrawListener(onDrawListener);
    }
}
