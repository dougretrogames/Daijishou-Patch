package org.eclipse.jgit.transport;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import org.eclipse.jgit.annotations.Nullable;
import org.eclipse.jgit.lib.ObjectId;

/* INFO: loaded from: classes5.dex */
final class FetchV0Request extends FetchRequest {
    FetchV0Request(Set<ObjectId> set, int i, Set<ObjectId> set2, FilterSpec filterSpec, Set<String> set3, int i2, List<String> list, @Nullable String str, @Nullable String str2) {
        super(set, i, set2, filterSpec, set3, i2, list, str, str2);
    }

    static final class Builder {
        String agent;
        String clientSID;
        int deepenSince;
        int depth;
        final List<String> deepenNots = new ArrayList();
        final Set<ObjectId> wantIds = new HashSet();
        final Set<ObjectId> clientShallowCommits = new HashSet();
        FilterSpec filterSpec = FilterSpec.NO_FILTER;
        final Set<String> clientCaps = new HashSet();

        Builder() {
        }

        Builder addWantId(ObjectId objectId) {
            this.wantIds.add(objectId);
            return this;
        }

        Builder setDepth(int i) {
            this.depth = i;
            return this;
        }

        int getDepth() {
            return this.depth;
        }

        boolean hasDeepenNots() {
            return !this.deepenNots.isEmpty();
        }

        Builder addDeepenNot(String str) {
            this.deepenNots.add(str);
            return this;
        }

        Builder setDeepenSince(int i) {
            this.deepenSince = i;
            return this;
        }

        int getDeepenSince() {
            return this.deepenSince;
        }

        Builder addClientShallowCommit(ObjectId objectId) {
            this.clientShallowCommits.add(objectId);
            return this;
        }

        Builder addClientCapabilities(Collection<String> collection) {
            this.clientCaps.addAll(collection);
            return this;
        }

        Builder setAgent(String str) {
            this.agent = str;
            return this;
        }

        Builder setClientSID(String str) {
            this.clientSID = str;
            return this;
        }

        Builder setFilterSpec(FilterSpec filterSpec) {
            this.filterSpec = (FilterSpec) Objects.requireNonNull(filterSpec);
            return this;
        }

        FetchV0Request build() {
            return new FetchV0Request(this.wantIds, this.depth, this.clientShallowCommits, this.filterSpec, this.clientCaps, this.deepenSince, this.deepenNots, this.agent, this.clientSID);
        }
    }
}
