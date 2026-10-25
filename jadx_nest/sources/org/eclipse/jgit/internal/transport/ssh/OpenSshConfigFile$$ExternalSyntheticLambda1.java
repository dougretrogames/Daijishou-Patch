package org.eclipse.jgit.internal.transport.ssh;

import java.util.function.Consumer;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class OpenSshConfigFile$$ExternalSyntheticLambda1 implements Consumer {
    public final /* synthetic */ String f$0;
    public final /* synthetic */ OpenSshConfigFile.HostEntry f$1;

    public /* synthetic */ OpenSshConfigFile$$ExternalSyntheticLambda1(String str, OpenSshConfigFile.HostEntry hostEntry) {
        this.f$0 = str;
        this.f$1 = hostEntry;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        OpenSshConfigFile.lambda$0(this.f$0, this.f$1, (OpenSshConfigFile.HostEntry) obj);
    }
}
