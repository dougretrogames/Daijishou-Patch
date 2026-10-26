package org.eclipse.jgit.transport;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import org.eclipse.jgit.annotations.Nullable;
import org.eclipse.jgit.lib.ObjectId;

/* INFO: loaded from: classes5.dex */
public final class FetchV2Request extends FetchRequest {
    private final boolean doneReceived;
    private final List<String> packfileUriProtocols;
    private final List<ObjectId> peerHas;
    private final List<String> serverOptions;
    private final boolean sidebandAll;
    private final boolean waitForDone;
    private final List<String> wantedRefs;

    FetchV2Request(List<ObjectId> list, List<String> list2, Set<ObjectId> set, Set<ObjectId> set2, int i, List<String> list3, int i2, FilterSpec filterSpec, boolean z, boolean z2, Set<String> set3, @Nullable String str, List<String> list4, boolean z3, List<String> list5, @Nullable String str2) {
        super(set, i2, set2, filterSpec, set3, i, list3, str, str2);
        this.peerHas = (List) Objects.requireNonNull(list);
        this.wantedRefs = (List) Objects.requireNonNull(list2);
        this.doneReceived = z;
        this.waitForDone = z2;
        this.serverOptions = (List) Objects.requireNonNull(list4);
        this.sidebandAll = z3;
        this.packfileUriProtocols = list5;
    }

    List<ObjectId> getPeerHas() {
        return this.peerHas;
    }

    public List<String> getWantedRefs() {
        return this.wantedRefs;
    }

    boolean wasDoneReceived() {
        return this.doneReceived;
    }

    boolean wasWaitForDoneReceived() {
        return this.waitForDone;
    }

    public List<String> getServerOptions() {
        return this.serverOptions;
    }

    boolean getSidebandAll() {
        return this.sidebandAll;
    }

    List<String> getPackfileUriProtocols() {
        return this.packfileUriProtocols;
    }

    static Builder builder() {
        return new Builder(null);
    }

    static final class Builder {

        @Nullable
        String agent;
        final Set<String> clientCapabilities;

        @Nullable
        String clientSID;
        final Set<ObjectId> clientShallowCommits;
        final List<String> deepenNots;
        int deepenSince;
        int depth;
        boolean doneReceived;
        FilterSpec filterSpec;
        final List<String> packfileUriProtocols;
        final List<ObjectId> peerHas;
        final List<String> serverOptions;
        boolean sidebandAll;
        boolean waitForDone;
        final Set<ObjectId> wantIds;
        final List<String> wantedRefs;

        /* synthetic */ Builder(FetchV2RequestIA fetchV2RequestIA) {
            this();
        }

        private Builder() {
            this.peerHas = new ArrayList();
            this.wantedRefs = new ArrayList();
            this.wantIds = new HashSet();
            this.clientShallowCommits = new HashSet();
            this.deepenNots = new ArrayList();
            this.clientCapabilities = new HashSet();
            this.filterSpec = FilterSpec.NO_FILTER;
            this.serverOptions = new ArrayList();
            this.packfileUriProtocols = new ArrayList();
        }

        Builder addPeerHas(ObjectId objectId) {
            this.peerHas.add(objectId);
            return this;
        }

        Builder addWantedRef(String str) {
            this.wantedRefs.add(str);
            return this;
        }

        Builder addClientCapability(String str) {
            this.clientCapabilities.add(str);
            return this;
        }

        Builder addWantId(ObjectId objectId) {
            this.wantIds.add(objectId);
            return this;
        }

        Builder addClientShallowCommit(ObjectId objectId) {
            this.clientShallowCommits.add(objectId);
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

        Builder setFilterSpec(FilterSpec filterSpec) {
            this.filterSpec = (FilterSpec) Objects.requireNonNull(filterSpec);
            return this;
        }

        Builder setDoneReceived() {
            this.doneReceived = true;
            return this;
        }

        Builder setWaitForDone() {
            this.waitForDone = true;
            return this;
        }

        /* INFO: Access modifiers changed from: package-private */
        public Builder setAgent(@Nullable String str) {
            this.agent = str;
            return this;
        }

        /* INFO: Access modifiers changed from: package-private */
        public Builder setClientSID(@Nullable String str) {
            this.clientSID = str;
            return this;
        }

        /* INFO: Access modifiers changed from: package-private */
        public Builder addServerOption(String str) {
            this.serverOptions.add(str);
            return this;
        }

        Builder setSidebandAll(boolean z) {
            this.sidebandAll = z;
            return this;
        }

        Builder addPackfileUriProtocol(String str) {
            this.packfileUriProtocols.add(str);
            return this;
        }

        FetchV2Request build() {
            return new FetchV2Request(this.peerHas, this.wantedRefs, this.wantIds, this.clientShallowCommits, this.deepenSince, this.deepenNots, this.depth, this.filterSpec, this.doneReceived, this.waitForDone, this.clientCapabilities, this.agent, Collections.unmodifiableList(this.serverOptions), this.sidebandAll, Collections.unmodifiableList(this.packfileUriProtocols), this.clientSID);
        }
    }
}
