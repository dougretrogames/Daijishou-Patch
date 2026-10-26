package org.eclipse.jgit.api;

import org.eclipse.jgit.lib.Config;
import org.eclipse.jgit.transport.PushConfig;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes5.dex */
public final /* synthetic */ class PushCommand$$ExternalSyntheticLambda0 implements Config.SectionParser {
    @Override // org.eclipse.jgit.lib.Config.SectionParser
    public final Object parse(Config config) {
        return new PushConfig(config);
    }
}
