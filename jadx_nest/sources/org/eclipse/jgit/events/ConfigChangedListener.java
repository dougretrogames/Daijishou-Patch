package org.eclipse.jgit.events;

/* JADX INFO: loaded from: classes5.dex */
public interface ConfigChangedListener extends RepositoryListener {
    void onConfigChanged(ConfigChangedEvent configChangedEvent);
}
