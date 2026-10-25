package androidx.room;

import android.os.RemoteCallbackList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MultiInstanceInvalidationService.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"androidx/room/MultiInstanceInvalidationService$callbackList$1", "Landroid/os/RemoteCallbackList;", "Landroidx/room/IMultiInstanceInvalidationCallback;", "onCallbackDied", "", "callback", "cookie", "", "room-runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class MultiInstanceInvalidationService$callbackList$1 extends RemoteCallbackList<IMultiInstanceInvalidationCallback> {
    final /* synthetic */ MultiInstanceInvalidationService this$0;

    MultiInstanceInvalidationService$callbackList$1(MultiInstanceInvalidationService multiInstanceInvalidationService) {
        this.this$0 = multiInstanceInvalidationService;
    }

    @Override // android.os.RemoteCallbackList
    public void onCallbackDied(IMultiInstanceInvalidationCallback callback, Object cookie) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        Intrinsics.checkNotNullParameter(cookie, "cookie");
        this.this$0.getClientNames$room_runtime_release().remove((Integer) cookie);
    }
}
