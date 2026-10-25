package androidx.room;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class RoomTrackingLiveData$$ExternalSyntheticLambda1 implements Runnable {
    public final /* synthetic */ RoomTrackingLiveData f$0;

    public /* synthetic */ RoomTrackingLiveData$$ExternalSyntheticLambda1(RoomTrackingLiveData roomTrackingLiveData) {
        this.f$0 = roomTrackingLiveData;
    }

    @Override // java.lang.Runnable
    public final void run() {
        RoomTrackingLiveData.invalidationRunnable$lambda$1(this.f$0);
    }
}
