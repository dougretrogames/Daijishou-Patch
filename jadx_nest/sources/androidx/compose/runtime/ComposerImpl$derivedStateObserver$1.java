package androidx.compose.runtime;

import kotlin.Metadata;
import org.eclipse.jgit.transport.GitProtocolConstants;

/* JADX INFO: compiled from: Composer.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u00020\u00032\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005H\u0016J\u0014\u0010\u0006\u001a\u00020\u00032\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005H\u0016¨\u0006\u0007"}, d2 = {"androidx/compose/runtime/ComposerImpl$derivedStateObserver$1", "Landroidx/compose/runtime/DerivedStateObserver;", GitProtocolConstants.PACKET_DONE, "", "derivedState", "Landroidx/compose/runtime/DerivedState;", "start", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ComposerImpl$derivedStateObserver$1 implements DerivedStateObserver {
    final /* synthetic */ ComposerImpl this$0;

    ComposerImpl$derivedStateObserver$1(ComposerImpl composerImpl) {
        this.this$0 = composerImpl;
    }

    @Override // androidx.compose.runtime.DerivedStateObserver
    public void start(DerivedState<?> derivedState) {
        this.this$0.childrenComposing++;
    }

    @Override // androidx.compose.runtime.DerivedStateObserver
    public void done(DerivedState<?> derivedState) {
        this.this$0.childrenComposing--;
    }
}
