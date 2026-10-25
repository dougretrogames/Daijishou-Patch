package org.eclipse.jgit.transport;

import org.eclipse.jgit.lib.Config;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class BasePackFetchConnection$$ExternalSyntheticLambda0 implements Config.SectionParser {
    @Override // org.eclipse.jgit.lib.Config.SectionParser
    public final Object parse(Config config) {
        return new BasePackFetchConnection.FetchConfig(config);
    }
}
