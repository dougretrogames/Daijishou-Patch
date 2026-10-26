package org.eclipse.jgit.transport;

import org.eclipse.jgit.lib.Config;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes5.dex */
public final /* synthetic */ class DaemonService$$ExternalSyntheticLambda0 implements Config.SectionParser {
    public final /* synthetic */ DaemonService f$0;
    public final /* synthetic */ String f$1;

    public /* synthetic */ DaemonService$$ExternalSyntheticLambda0(DaemonService daemonService, String str) {
        this.f$0 = daemonService;
        this.f$1 = str;
    }

    @Override // org.eclipse.jgit.lib.Config.SectionParser
    public final Object parse(Config config) {
        return this.f$0.m5806lambda$0$orgeclipsejgittransportDaemonService(this.f$1, config);
    }
}
