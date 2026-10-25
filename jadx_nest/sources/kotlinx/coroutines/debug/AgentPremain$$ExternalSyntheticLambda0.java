package kotlinx.coroutines.debug;

import sun.misc.Signal;
import sun.misc.SignalHandler;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class AgentPremain$$ExternalSyntheticLambda0 implements SignalHandler {
    public final void handle(Signal signal) {
        AgentPremain.installSignalHandler$lambda$1(signal);
    }
}
