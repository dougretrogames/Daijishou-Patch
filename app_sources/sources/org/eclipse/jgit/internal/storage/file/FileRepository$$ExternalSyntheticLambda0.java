package org.eclipse.jgit.internal.storage.file;

import org.eclipse.jgit.events.ConfigChangedEvent;
import org.eclipse.jgit.events.ConfigChangedListener;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes5.dex */
public final /* synthetic */ class FileRepository$$ExternalSyntheticLambda0 implements ConfigChangedListener {
    public final /* synthetic */ FileRepository f$0;

    public /* synthetic */ FileRepository$$ExternalSyntheticLambda0(FileRepository fileRepository) {
        this.f$0 = fileRepository;
    }

    @Override // org.eclipse.jgit.events.ConfigChangedListener
    public final void onConfigChanged(ConfigChangedEvent configChangedEvent) {
        this.f$0.fireEvent(configChangedEvent);
    }
}
