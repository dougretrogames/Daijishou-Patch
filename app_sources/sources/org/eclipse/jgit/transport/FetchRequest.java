package org.eclipse.jgit.transport;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import org.eclipse.jgit.annotations.Nullable;
import org.eclipse.jgit.lib.ObjectId;

/* INFO: loaded from: classes5.dex */
abstract class FetchRequest {

    @Nullable
    final String agent;
    final Set<String> clientCapabilities;

    @Nullable
    final String clientSID;
    final Set<ObjectId> clientShallowCommits;
    final List<String> deepenNots;
    final int deepenSince;
    final int depth;
    final FilterSpec filterSpec;
    final Set<ObjectId> wantIds;

    FetchRequest(Set<ObjectId> set, int i, Set<ObjectId> set2, FilterSpec filterSpec, Set<String> set3, int i2, List<String> list, @Nullable String str, @Nullable String str2) {
        this.wantIds = (Set) Objects.requireNonNull(set);
        this.depth = i;
        this.clientShallowCommits = (Set) Objects.requireNonNull(set2);
        this.filterSpec = (FilterSpec) Objects.requireNonNull(filterSpec);
        this.clientCapabilities = (Set) Objects.requireNonNull(set3);
        this.deepenSince = i2;
        this.deepenNots = (List) Objects.requireNonNull(list);
        this.agent = str;
        this.clientSID = str2;
    }

    Set<ObjectId> getWantIds() {
        return this.wantIds;
    }

    int getDepth() {
        return this.depth;
    }

    Set<ObjectId> getClientShallowCommits() {
        return this.clientShallowCommits;
    }

    FilterSpec getFilterSpec() {
        return this.filterSpec;
    }

    Set<String> getClientCapabilities() {
        return this.clientCapabilities;
    }

    int getDeepenSince() {
        return this.deepenSince;
    }

    List<String> getDeepenNots() {
        return this.deepenNots;
    }

    @Nullable
    String getAgent() {
        return this.agent;
    }

    @Nullable
    String getClientSID() {
        return this.clientSID;
    }
}
