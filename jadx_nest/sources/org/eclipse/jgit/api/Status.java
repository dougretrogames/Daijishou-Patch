package org.eclipse.jgit.api;

import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.eclipse.jgit.lib.IndexDiff;

/* JADX INFO: loaded from: classes5.dex */
public class Status {
    private final boolean clean;
    private final IndexDiff diff;
    private final boolean hasUncommittedChanges;

    public Status(IndexDiff indexDiff) {
        this.diff = indexDiff;
        boolean z = false;
        boolean z2 = (indexDiff.getAdded().isEmpty() && indexDiff.getChanged().isEmpty() && indexDiff.getRemoved().isEmpty() && indexDiff.getMissing().isEmpty() && indexDiff.getModified().isEmpty() && indexDiff.getConflicting().isEmpty()) ? false : true;
        this.hasUncommittedChanges = z2;
        if (!z2 && indexDiff.getUntracked().isEmpty()) {
            z = true;
        }
        this.clean = z;
    }

    public boolean isClean() {
        return this.clean;
    }

    public boolean hasUncommittedChanges() {
        return this.hasUncommittedChanges;
    }

    public Set<String> getAdded() {
        return Collections.unmodifiableSet(this.diff.getAdded());
    }

    public Set<String> getChanged() {
        return Collections.unmodifiableSet(this.diff.getChanged());
    }

    public Set<String> getRemoved() {
        return Collections.unmodifiableSet(this.diff.getRemoved());
    }

    public Set<String> getMissing() {
        return Collections.unmodifiableSet(this.diff.getMissing());
    }

    public Set<String> getModified() {
        return Collections.unmodifiableSet(this.diff.getModified());
    }

    public Set<String> getUntracked() {
        return Collections.unmodifiableSet(this.diff.getUntracked());
    }

    public Set<String> getUntrackedFolders() {
        return Collections.unmodifiableSet(this.diff.getUntrackedFolders());
    }

    public Set<String> getConflicting() {
        return Collections.unmodifiableSet(this.diff.getConflicting());
    }

    public Map<String, IndexDiff.StageState> getConflictingStageState() {
        return Collections.unmodifiableMap(this.diff.getConflictingStageStates());
    }

    public Set<String> getIgnoredNotInIndex() {
        return Collections.unmodifiableSet(this.diff.getIgnoredNotInIndex());
    }

    public Set<String> getUncommittedChanges() {
        HashSet hashSet = new HashSet();
        hashSet.addAll(this.diff.getAdded());
        hashSet.addAll(this.diff.getChanged());
        hashSet.addAll(this.diff.getRemoved());
        hashSet.addAll(this.diff.getMissing());
        hashSet.addAll(this.diff.getModified());
        hashSet.addAll(this.diff.getConflicting());
        return hashSet;
    }
}
