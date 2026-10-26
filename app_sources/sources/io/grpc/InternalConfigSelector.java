package io.grpc;

import androidx.core.app.NotificationCompat;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;

/* INFO: loaded from: classes4.dex */
public abstract class InternalConfigSelector {
    public static final Attributes.Key<InternalConfigSelector> KEY = Attributes.Key.create("internal:io.grpc.config-selector");

    public abstract Result selectConfig(LoadBalancer.PickSubchannelArgs pickSubchannelArgs);

    public static final class Result {
        private final Object config;

        @Nullable
        public ClientInterceptor interceptor;
        private final Status status;

        /* synthetic */ Result(Status status, Object obj, ClientInterceptor clientInterceptor, AnonymousClass1 anonymousClass1) {
            this(status, obj, clientInterceptor);
        }

        private Result(Status status, Object obj, ClientInterceptor clientInterceptor) {
            this.status = (Status) Preconditions.checkNotNull(status, NotificationCompat.CATEGORY_STATUS);
            this.config = obj;
            this.interceptor = clientInterceptor;
        }

        public static Result forError(Status status) {
            Preconditions.checkArgument(!status.isOk(), "status is OK");
            return new Result(status, null, null);
        }

        public Status getStatus() {
            return this.status;
        }

        public Object getConfig() {
            return this.config;
        }

        @Nullable
        public ClientInterceptor getInterceptor() {
            return this.interceptor;
        }

        public static Builder newBuilder() {
            return new Builder(null);
        }

        public static final class Builder {
            private Object config;
            private ClientInterceptor interceptor;

            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            private Builder() {
            }

            public Builder setConfig(Object obj) {
                this.config = Preconditions.checkNotNull(obj, "config");
                return this;
            }

            public Builder setInterceptor(ClientInterceptor clientInterceptor) {
                this.interceptor = (ClientInterceptor) Preconditions.checkNotNull(clientInterceptor, "interceptor");
                return this;
            }

            public Result build() {
                Preconditions.checkState(this.config != null, "config is not set");
                return new Result(Status.OK, this.config, this.interceptor, null);
            }
        }
    }
}
