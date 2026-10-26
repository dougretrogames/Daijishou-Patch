package org.eclipse.jgit.transport;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import org.eclipse.jgit.annotations.Nullable;

/* INFO: loaded from: classes5.dex */
public final class LsRefsV2Request {

    @Nullable
    private final String agent;
    private final String clientSID;
    private final boolean peel;
    private final List<String> refPrefixes;
    private final List<String> serverOptions;
    private final boolean symrefs;

    /* synthetic */ LsRefsV2Request(List list, boolean z, boolean z2, String str, List list2, String str2, LsRefsV2RequestIA lsRefsV2RequestIA) {
        this(list, z, z2, str, list2, str2);
    }

    private LsRefsV2Request(List<String> list, boolean z, boolean z2, @Nullable String str, List<String> list2, @Nullable String str2) {
        this.refPrefixes = list;
        this.symrefs = z;
        this.peel = z2;
        this.agent = str;
        this.serverOptions = (List) Objects.requireNonNull(list2);
        this.clientSID = str2;
    }

    public List<String> getRefPrefixes() {
        return this.refPrefixes;
    }

    public boolean getSymrefs() {
        return this.symrefs;
    }

    public boolean getPeel() {
        return this.peel;
    }

    @Nullable
    public String getAgent() {
        return this.agent;
    }

    @Nullable
    public String getClientSID() {
        return this.clientSID;
    }

    public List<String> getServerOptions() {
        return this.serverOptions;
    }

    public static Builder builder() {
        return new Builder(null);
    }

    public static final class Builder {
        private String agent;
        private String clientSID;
        private boolean peel;
        private List<String> refPrefixes;
        private final List<String> serverOptions;
        private boolean symrefs;

        /* synthetic */ Builder(LsRefsV2RequestIA lsRefsV2RequestIA) {
            this();
        }

        private Builder() {
            this.refPrefixes = Collections.emptyList();
            this.serverOptions = new ArrayList();
        }

        public Builder setRefPrefixes(List<String> list) {
            this.refPrefixes = list;
            return this;
        }

        public Builder setSymrefs(boolean z) {
            this.symrefs = z;
            return this;
        }

        public Builder setPeel(boolean z) {
            this.peel = z;
            return this;
        }

        public Builder addServerOption(String str) {
            this.serverOptions.add(str);
            return this;
        }

        public Builder setAgent(@Nullable String str) {
            this.agent = str;
            return this;
        }

        public Builder setClientSID(@Nullable String str) {
            this.clientSID = str;
            return this;
        }

        public LsRefsV2Request build() {
            return new LsRefsV2Request(Collections.unmodifiableList(this.refPrefixes), this.symrefs, this.peel, this.agent, Collections.unmodifiableList(this.serverOptions), this.clientSID, null);
        }
    }
}
