package androidx.room;

import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.util.Log;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* INFO: compiled from: MultiInstanceInvalidationService.kt */
/* INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J%\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u000e\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\b0\u0007H\u0016¢\u0006\u0002\u0010\tJ\u001a\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\bH\u0016J\u0018\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u000f"}, d2 = {"androidx/room/MultiInstanceInvalidationService$binder$1", "Landroidx/room/IMultiInstanceInvalidationService$Stub;", "broadcastInvalidation", "", "clientId", "", "tables", "", "", "(I[Ljava/lang/String;)V", "registerCallback", "callback", "Landroidx/room/IMultiInstanceInvalidationCallback;", "name", "unregisterCallback", "room-runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class MultiInstanceInvalidationService$binder$1 extends IMultiInstanceInvalidationService.Stub {
    final /* synthetic */ MultiInstanceInvalidationService this$0;

    MultiInstanceInvalidationService$binder$1(MultiInstanceInvalidationService multiInstanceInvalidationService) {
        this.this$0 = multiInstanceInvalidationService;
    }

    @Override // androidx.room.IMultiInstanceInvalidationService
    public int registerCallback(IMultiInstanceInvalidationCallback callback, String name) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        int i = 0;
        if (name == null) {
            return 0;
        }
        RemoteCallbackList<IMultiInstanceInvalidationCallback> callbackList$room_runtime_release = this.this$0.getCallbackList$room_runtime_release();
        MultiInstanceInvalidationService multiInstanceInvalidationService = this.this$0;
        synchronized (callbackList$room_runtime_release) {
            multiInstanceInvalidationService.setMaxClientId$room_runtime_release(multiInstanceInvalidationService.getMaxClientId() + 1);
            int maxClientId$room_runtime_release = multiInstanceInvalidationService.getMaxClientId();
            if (multiInstanceInvalidationService.getCallbackList$room_runtime_release().register(callback, Integer.valueOf(maxClientId$room_runtime_release))) {
                multiInstanceInvalidationService.getClientNames$room_runtime_release().put(Integer.valueOf(maxClientId$room_runtime_release), name);
                i = maxClientId$room_runtime_release;
            } else {
                multiInstanceInvalidationService.setMaxClientId$room_runtime_release(multiInstanceInvalidationService.getMaxClientId() - 1);
                multiInstanceInvalidationService.getMaxClientId();
            }
        }
        return i;
    }

    @Override // androidx.room.IMultiInstanceInvalidationService
    public void unregisterCallback(IMultiInstanceInvalidationCallback callback, int clientId) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        RemoteCallbackList<IMultiInstanceInvalidationCallback> callbackList$room_runtime_release = this.this$0.getCallbackList$room_runtime_release();
        MultiInstanceInvalidationService multiInstanceInvalidationService = this.this$0;
        synchronized (callbackList$room_runtime_release) {
            multiInstanceInvalidationService.getCallbackList$room_runtime_release().unregister(callback);
            multiInstanceInvalidationService.getClientNames$room_runtime_release().remove(Integer.valueOf(clientId));
        }
    }

    @Override // androidx.room.IMultiInstanceInvalidationService
    public void broadcastInvalidation(int clientId, String[] tables) {
        Intrinsics.checkNotNullParameter(tables, "tables");
        RemoteCallbackList<IMultiInstanceInvalidationCallback> callbackList$room_runtime_release = this.this$0.getCallbackList$room_runtime_release();
        MultiInstanceInvalidationService multiInstanceInvalidationService = this.this$0;
        synchronized (callbackList$room_runtime_release) {
            try {
                String str = multiInstanceInvalidationService.getClientNames$room_runtime_release().get(Integer.valueOf(clientId));
                if (str == null) {
                    Log.w(Room.LOG_TAG, "Remote invalidation client ID not registered");
                    return;
                }
                int iBeginBroadcast = multiInstanceInvalidationService.getCallbackList$room_runtime_release().beginBroadcast();
                for (int i = 0; i < iBeginBroadcast; i++) {
                    try {
                        Object broadcastCookie = multiInstanceInvalidationService.getCallbackList$room_runtime_release().getBroadcastCookie(i);
                        Intrinsics.checkNotNull(broadcastCookie, "null cannot be cast to non-null type kotlin.Int");
                        int iIntValue = ((Integer) broadcastCookie).intValue();
                        String str2 = multiInstanceInvalidationService.getClientNames$room_runtime_release().get(Integer.valueOf(iIntValue));
                        if (clientId != iIntValue && Intrinsics.areEqual(str, str2)) {
                            try {
                                ((IMultiInstanceInvalidationCallback) multiInstanceInvalidationService.getCallbackList$room_runtime_release().getBroadcastItem(i)).onInvalidation(tables);
                            } catch (RemoteException e) {
                                Log.w(Room.LOG_TAG, "Error invoking a remote callback", e);
                            }
                        }
                    } catch (Throwable th) {
                        multiInstanceInvalidationService.getCallbackList$room_runtime_release().finishBroadcast();
                        throw th;
                    }
                }
                multiInstanceInvalidationService.getCallbackList$room_runtime_release().finishBroadcast();
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
