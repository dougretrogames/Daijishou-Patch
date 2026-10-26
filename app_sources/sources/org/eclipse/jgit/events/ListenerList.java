package org.eclipse.jgit.events;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* INFO: loaded from: classes5.dex */
public class ListenerList {
    private final Map<Class<? extends RepositoryListener>, CopyOnWriteArrayList<ListenerHandle>> lists = new ConcurrentHashMap();

    public ListenerHandle addWorkingTreeModifiedListener(WorkingTreeModifiedListener workingTreeModifiedListener) {
        return addListener(WorkingTreeModifiedListener.class, workingTreeModifiedListener);
    }

    public ListenerHandle addIndexChangedListener(IndexChangedListener indexChangedListener) {
        return addListener(IndexChangedListener.class, indexChangedListener);
    }

    public ListenerHandle addRefsChangedListener(RefsChangedListener refsChangedListener) {
        return addListener(RefsChangedListener.class, refsChangedListener);
    }

    public ListenerHandle addConfigChangedListener(ConfigChangedListener configChangedListener) {
        return addListener(ConfigChangedListener.class, configChangedListener);
    }

    public <T extends RepositoryListener> ListenerHandle addListener(Class<T> cls, T t) {
        ListenerHandle listenerHandle = new ListenerHandle(this, cls, t);
        add(listenerHandle);
        return listenerHandle;
    }

    public void dispatch(RepositoryEvent repositoryEvent) {
        CopyOnWriteArrayList<ListenerHandle> copyOnWriteArrayList = this.lists.get(repositoryEvent.getListenerType());
        if (copyOnWriteArrayList != null) {
            Iterator<ListenerHandle> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                repositoryEvent.dispatch(it.next().listener);
            }
        }
    }

    private void add(ListenerHandle listenerHandle) {
        CopyOnWriteArrayList<ListenerHandle> copyOnWriteArrayListPutIfAbsent;
        CopyOnWriteArrayList<ListenerHandle> copyOnWriteArrayList = this.lists.get(listenerHandle.type);
        if (copyOnWriteArrayList == null && (copyOnWriteArrayListPutIfAbsent = this.lists.putIfAbsent(listenerHandle.type, (copyOnWriteArrayList = new CopyOnWriteArrayList<>()))) != null) {
            copyOnWriteArrayList = copyOnWriteArrayListPutIfAbsent;
        }
        copyOnWriteArrayList.add(listenerHandle);
    }

    void remove(ListenerHandle listenerHandle) {
        CopyOnWriteArrayList<ListenerHandle> copyOnWriteArrayList = this.lists.get(listenerHandle.type);
        if (copyOnWriteArrayList != null) {
            copyOnWriteArrayList.remove(listenerHandle);
        }
    }
}
