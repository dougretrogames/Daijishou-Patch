package org.eclipse.jgit.transport;

/* JADX INFO: loaded from: classes5.dex */
public final class CapabilitiesV2Request {
    /* synthetic */ CapabilitiesV2Request(CapabilitiesV2RequestIA capabilitiesV2RequestIA) {
        this();
    }

    private CapabilitiesV2Request() {
    }

    public static Builder builder() {
        return new Builder(null);
    }

    public static final class Builder {
        /* synthetic */ Builder(CapabilitiesV2RequestIA capabilitiesV2RequestIA) {
            this();
        }

        private Builder() {
        }

        public CapabilitiesV2Request build() {
            return new CapabilitiesV2Request(null);
        }
    }
}
