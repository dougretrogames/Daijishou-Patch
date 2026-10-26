package org.eclipse.jgit.lib;

import org.eclipse.jgit.events.IndexChangedEvent;
import org.eclipse.jgit.events.IndexChangedListener;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes5.dex */
public final /* synthetic */ class Repository$$ExternalSyntheticLambda0 implements IndexChangedListener {
    public final /* synthetic */ Repository f$0;

    public /* synthetic */ Repository$$ExternalSyntheticLambda0(Repository repository) {
        this.f$0 = repository;
    }

    @Override // org.eclipse.jgit.events.IndexChangedListener
    public final void onIndexChanged(IndexChangedEvent indexChangedEvent) {
        this.f$0.m5779lambda$0$orgeclipsejgitlibRepository(indexChangedEvent);
    }
}
