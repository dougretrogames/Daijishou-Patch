package androidx.lifecycle;

import android.app.Activity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ProcessLifecycleOwner.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, d2 = {"androidx/lifecycle/ProcessLifecycleOwner$attach$1$onActivityPreCreated$1", "Landroidx/lifecycle/EmptyActivityLifecycleCallbacks;", "onActivityPostResumed", "", "activity", "Landroid/app/Activity;", "onActivityPostStarted", "lifecycle-process_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ProcessLifecycleOwner$attach$1$onActivityPreCreated$1 extends EmptyActivityLifecycleCallbacks {
    final /* synthetic */ ProcessLifecycleOwner this$0;

    ProcessLifecycleOwner$attach$1$onActivityPreCreated$1(ProcessLifecycleOwner processLifecycleOwner) {
        this.this$0 = processLifecycleOwner;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPostStarted(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.this$0.activityStarted$lifecycle_process_release();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPostResumed(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.this$0.activityResumed$lifecycle_process_release();
    }
}
