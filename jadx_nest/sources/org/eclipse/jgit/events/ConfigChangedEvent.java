package org.eclipse.jgit.events;

/* JADX INFO: loaded from: classes5.dex */
public class ConfigChangedEvent extends RepositoryEvent<ConfigChangedListener> {
    @Override // org.eclipse.jgit.events.RepositoryEvent
    public Class<ConfigChangedListener> getListenerType() {
        return ConfigChangedListener.class;
    }

    @Override // org.eclipse.jgit.events.RepositoryEvent
    public void dispatch(ConfigChangedListener configChangedListener) {
        configChangedListener.onConfigChanged(this);
    }
}
