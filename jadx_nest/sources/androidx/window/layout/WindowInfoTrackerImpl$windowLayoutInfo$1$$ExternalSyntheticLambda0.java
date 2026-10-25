package androidx.window.layout;

import androidx.core.util.Consumer;
import kotlinx.coroutines.channels.Channel;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class WindowInfoTrackerImpl$windowLayoutInfo$1$$ExternalSyntheticLambda0 implements Consumer {
    public final /* synthetic */ Channel f$0;

    public /* synthetic */ WindowInfoTrackerImpl$windowLayoutInfo$1$$ExternalSyntheticLambda0(Channel channel) {
        this.f$0 = channel;
    }

    @Override // androidx.core.util.Consumer
    public final void accept(Object obj) {
        WindowInfoTrackerImpl.AnonymousClass1.m3250invokeSuspend$lambda0(this.f$0, (WindowLayoutInfo) obj);
    }
}
