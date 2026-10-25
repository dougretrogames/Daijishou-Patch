package androidx.room;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import androidx.core.app.NotificationCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MultiInstanceInvalidationClient.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\t"}, d2 = {"androidx/room/MultiInstanceInvalidationClient$serviceConnection$1", "Landroid/content/ServiceConnection;", "onServiceConnected", "", "name", "Landroid/content/ComponentName;", NotificationCompat.CATEGORY_SERVICE, "Landroid/os/IBinder;", "onServiceDisconnected", "room-runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class MultiInstanceInvalidationClient$serviceConnection$1 implements ServiceConnection {
    final /* synthetic */ MultiInstanceInvalidationClient this$0;

    MultiInstanceInvalidationClient$serviceConnection$1(MultiInstanceInvalidationClient multiInstanceInvalidationClient) {
        this.this$0 = multiInstanceInvalidationClient;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName name, IBinder service) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(service, "service");
        this.this$0.setService(IMultiInstanceInvalidationService.Stub.asInterface(service));
        this.this$0.getExecutor().execute(this.this$0.getSetUpRunnable());
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName name) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.this$0.getExecutor().execute(this.this$0.getRemoveObserverRunnable());
        this.this$0.setService(null);
    }
}
