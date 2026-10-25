package io.grpc;

import androidx.core.app.NotificationCompat;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.net.URI;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public abstract class NameResolver {

    public static abstract class Factory {
        public abstract String getDefaultScheme();

        public abstract NameResolver newNameResolver(URI uri, Args args);
    }

    public interface Listener {
        void onAddresses(List<EquivalentAddressGroup> list, Attributes attributes);

        void onError(Status status);
    }

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface ResolutionResultAttr {
    }

    public static abstract class ServiceConfigParser {
        public abstract ConfigOrError parseServiceConfig(Map<String, ?> map);
    }

    public abstract String getServiceAuthority();

    public void refresh() {
    }

    public abstract void shutdown();

    public void start(Listener listener) {
        if (listener instanceof Listener2) {
            start((Listener2) listener);
        } else {
            start((Listener2) new AnonymousClass1(listener));
        }
    }

    /* JADX INFO: renamed from: io.grpc.NameResolver$1, reason: invalid class name */
    class AnonymousClass1 extends Listener2 {
        final /* synthetic */ Listener val$listener;

        AnonymousClass1(Listener listener) {
            this.val$listener = listener;
        }

        @Override // io.grpc.NameResolver.Listener2, io.grpc.NameResolver.Listener
        public void onError(Status status) {
            this.val$listener.onError(status);
        }

        @Override // io.grpc.NameResolver.Listener2
        public void onResult(ResolutionResult resolutionResult) {
            this.val$listener.onAddresses(resolutionResult.getAddressesOrError().getValue(), resolutionResult.getAttributes());
        }
    }

    public void start(Listener2 listener2) {
        start((Listener) listener2);
    }

    public static abstract class Listener2 implements Listener {
        @Override // io.grpc.NameResolver.Listener
        public abstract void onError(Status status);

        public abstract void onResult(ResolutionResult resolutionResult);

        @Override // io.grpc.NameResolver.Listener
        @Deprecated
        public final void onAddresses(List<EquivalentAddressGroup> list, Attributes attributes) {
            onResult(ResolutionResult.newBuilder().setAddressesOrError(StatusOr.fromValue(list)).setAttributes(attributes).build());
        }

        public Status onResult2(ResolutionResult resolutionResult) {
            onResult(resolutionResult);
            return Status.OK;
        }
    }

    public static final class Args {

        @Nullable
        private final ChannelLogger channelLogger;

        @Nullable
        private final IdentityHashMap<Key<?>, Object> customArgs;
        private final int defaultPort;

        @Nullable
        private final Executor executor;

        @Nullable
        private final MetricRecorder metricRecorder;

        @Nullable
        private final String overrideAuthority;
        private final ProxyDetector proxyDetector;

        @Nullable
        private final ScheduledExecutorService scheduledExecutorService;
        private final ServiceConfigParser serviceConfigParser;
        private final SynchronizationContext syncContext;

        /* synthetic */ Args(Builder builder, AnonymousClass1 anonymousClass1) {
            this(builder);
        }

        private Args(Builder builder) {
            this.defaultPort = ((Integer) Preconditions.checkNotNull(builder.defaultPort, "defaultPort not set")).intValue();
            this.proxyDetector = (ProxyDetector) Preconditions.checkNotNull(builder.proxyDetector, "proxyDetector not set");
            this.syncContext = (SynchronizationContext) Preconditions.checkNotNull(builder.syncContext, "syncContext not set");
            this.serviceConfigParser = (ServiceConfigParser) Preconditions.checkNotNull(builder.serviceConfigParser, "serviceConfigParser not set");
            this.scheduledExecutorService = builder.scheduledExecutorService;
            this.channelLogger = builder.channelLogger;
            this.executor = builder.executor;
            this.overrideAuthority = builder.overrideAuthority;
            this.metricRecorder = builder.metricRecorder;
            this.customArgs = NameResolver.cloneCustomArgs(builder.customArgs);
        }

        public int getDefaultPort() {
            return this.defaultPort;
        }

        public ProxyDetector getProxyDetector() {
            return this.proxyDetector;
        }

        public SynchronizationContext getSynchronizationContext() {
            return this.syncContext;
        }

        public ScheduledExecutorService getScheduledExecutorService() {
            ScheduledExecutorService scheduledExecutorService = this.scheduledExecutorService;
            if (scheduledExecutorService != null) {
                return scheduledExecutorService;
            }
            throw new IllegalStateException("ScheduledExecutorService not set in Builder");
        }

        public ServiceConfigParser getServiceConfigParser() {
            return this.serviceConfigParser;
        }

        @Nullable
        public <T> T getArg(Key<T> key) {
            IdentityHashMap<Key<?>, Object> identityHashMap = this.customArgs;
            if (identityHashMap != null) {
                return (T) identityHashMap.get(key);
            }
            return null;
        }

        public ChannelLogger getChannelLogger() {
            ChannelLogger channelLogger = this.channelLogger;
            if (channelLogger != null) {
                return channelLogger;
            }
            throw new IllegalStateException("ChannelLogger is not set in Builder");
        }

        @Nullable
        public Executor getOffloadExecutor() {
            return this.executor;
        }

        @Nullable
        public String getOverrideAuthority() {
            return this.overrideAuthority;
        }

        @Nullable
        public MetricRecorder getMetricRecorder() {
            return this.metricRecorder;
        }

        public String toString() {
            return MoreObjects.toStringHelper(this).add("defaultPort", this.defaultPort).add("proxyDetector", this.proxyDetector).add("syncContext", this.syncContext).add("serviceConfigParser", this.serviceConfigParser).add("customArgs", this.customArgs).add("scheduledExecutorService", this.scheduledExecutorService).add("channelLogger", this.channelLogger).add("executor", this.executor).add("overrideAuthority", this.overrideAuthority).add("metricRecorder", this.metricRecorder).toString();
        }

        public Builder toBuilder() {
            Builder builder = new Builder();
            builder.setDefaultPort(this.defaultPort);
            builder.setProxyDetector(this.proxyDetector);
            builder.setSynchronizationContext(this.syncContext);
            builder.setServiceConfigParser(this.serviceConfigParser);
            builder.setScheduledExecutorService(this.scheduledExecutorService);
            builder.setChannelLogger(this.channelLogger);
            builder.setOffloadExecutor(this.executor);
            builder.setOverrideAuthority(this.overrideAuthority);
            builder.setMetricRecorder(this.metricRecorder);
            builder.customArgs = NameResolver.cloneCustomArgs(this.customArgs);
            return builder;
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        public static final class Builder {
            private ChannelLogger channelLogger;
            private IdentityHashMap<Key<?>, Object> customArgs;
            private Integer defaultPort;
            private Executor executor;
            private MetricRecorder metricRecorder;
            private String overrideAuthority;
            private ProxyDetector proxyDetector;
            private ScheduledExecutorService scheduledExecutorService;
            private ServiceConfigParser serviceConfigParser;
            private SynchronizationContext syncContext;

            Builder() {
            }

            public Builder setDefaultPort(int i) {
                this.defaultPort = Integer.valueOf(i);
                return this;
            }

            public Builder setProxyDetector(ProxyDetector proxyDetector) {
                this.proxyDetector = (ProxyDetector) Preconditions.checkNotNull(proxyDetector);
                return this;
            }

            public Builder setSynchronizationContext(SynchronizationContext synchronizationContext) {
                this.syncContext = (SynchronizationContext) Preconditions.checkNotNull(synchronizationContext);
                return this;
            }

            public Builder setScheduledExecutorService(ScheduledExecutorService scheduledExecutorService) {
                this.scheduledExecutorService = (ScheduledExecutorService) Preconditions.checkNotNull(scheduledExecutorService);
                return this;
            }

            public Builder setServiceConfigParser(ServiceConfigParser serviceConfigParser) {
                this.serviceConfigParser = (ServiceConfigParser) Preconditions.checkNotNull(serviceConfigParser);
                return this;
            }

            public Builder setChannelLogger(ChannelLogger channelLogger) {
                this.channelLogger = (ChannelLogger) Preconditions.checkNotNull(channelLogger);
                return this;
            }

            public Builder setOffloadExecutor(Executor executor) {
                this.executor = executor;
                return this;
            }

            public Builder setOverrideAuthority(String str) {
                this.overrideAuthority = str;
                return this;
            }

            public <T> Builder setArg(Key<T> key, T t) {
                Preconditions.checkNotNull(key, "key");
                Preconditions.checkNotNull(t, "value");
                if (this.customArgs == null) {
                    this.customArgs = new IdentityHashMap<>();
                }
                this.customArgs.put(key, t);
                return this;
            }

            public Builder setMetricRecorder(MetricRecorder metricRecorder) {
                this.metricRecorder = metricRecorder;
                return this;
            }

            public Args build() {
                return new Args(this, null);
            }
        }

        public static final class Key<T> {
            private final String debugString;

            private Key(String str) {
                this.debugString = str;
            }

            public String toString() {
                return this.debugString;
            }

            public static <T> Key<T> create(String str) {
                return new Key<>(str);
            }
        }
    }

    public static final class ResolutionResult {
        private final StatusOr<List<EquivalentAddressGroup>> addressesOrError;
        private final Attributes attributes;

        @Nullable
        private final ConfigOrError serviceConfig;

        ResolutionResult(StatusOr<List<EquivalentAddressGroup>> statusOr, Attributes attributes, ConfigOrError configOrError) {
            this.addressesOrError = statusOr;
            this.attributes = (Attributes) Preconditions.checkNotNull(attributes, "attributes");
            this.serviceConfig = configOrError;
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        public Builder toBuilder() {
            return newBuilder().setAddressesOrError(this.addressesOrError).setAttributes(this.attributes).setServiceConfig(this.serviceConfig);
        }

        @Deprecated
        public List<EquivalentAddressGroup> getAddresses() {
            return this.addressesOrError.getValue();
        }

        public StatusOr<List<EquivalentAddressGroup>> getAddressesOrError() {
            return this.addressesOrError;
        }

        public Attributes getAttributes() {
            return this.attributes;
        }

        @Nullable
        public ConfigOrError getServiceConfig() {
            return this.serviceConfig;
        }

        public String toString() {
            MoreObjects.ToStringHelper stringHelper = MoreObjects.toStringHelper(this);
            stringHelper.add("addressesOrError", this.addressesOrError.toString());
            stringHelper.add("attributes", this.attributes);
            stringHelper.add("serviceConfigOrError", this.serviceConfig);
            return stringHelper.toString();
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof ResolutionResult)) {
                return false;
            }
            ResolutionResult resolutionResult = (ResolutionResult) obj;
            return Objects.equal(this.addressesOrError, resolutionResult.addressesOrError) && Objects.equal(this.attributes, resolutionResult.attributes) && Objects.equal(this.serviceConfig, resolutionResult.serviceConfig);
        }

        public int hashCode() {
            return Objects.hashCode(this.addressesOrError, this.attributes, this.serviceConfig);
        }

        public static final class Builder {
            private StatusOr<List<EquivalentAddressGroup>> addresses = StatusOr.fromValue(Collections.emptyList());
            private Attributes attributes = Attributes.EMPTY;

            @Nullable
            private ConfigOrError serviceConfig;

            Builder() {
            }

            @Deprecated
            public Builder setAddresses(List<EquivalentAddressGroup> list) {
                setAddressesOrError(StatusOr.fromValue(list));
                return this;
            }

            public Builder setAddressesOrError(StatusOr<List<EquivalentAddressGroup>> statusOr) {
                this.addresses = (StatusOr) Preconditions.checkNotNull(statusOr, "StatusOr addresses cannot be null.");
                return this;
            }

            public Builder setAttributes(Attributes attributes) {
                this.attributes = attributes;
                return this;
            }

            public Builder setServiceConfig(@Nullable ConfigOrError configOrError) {
                this.serviceConfig = configOrError;
                return this;
            }

            public ResolutionResult build() {
                return new ResolutionResult(this.addresses, this.attributes, this.serviceConfig);
            }
        }
    }

    public static final class ConfigOrError {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final Object config;
        private final Status status;

        public static ConfigOrError fromConfig(Object obj) {
            return new ConfigOrError(obj);
        }

        public static ConfigOrError fromError(Status status) {
            return new ConfigOrError(status);
        }

        private ConfigOrError(Object obj) {
            this.config = Preconditions.checkNotNull(obj, "config");
            this.status = null;
        }

        private ConfigOrError(Status status) {
            this.config = null;
            this.status = (Status) Preconditions.checkNotNull(status, NotificationCompat.CATEGORY_STATUS);
            Preconditions.checkArgument(!status.isOk(), "cannot use OK status: %s", status);
        }

        @Nullable
        public Object getConfig() {
            return this.config;
        }

        @Nullable
        public Status getError() {
            return this.status;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && getClass() == obj.getClass()) {
                ConfigOrError configOrError = (ConfigOrError) obj;
                if (Objects.equal(this.status, configOrError.status) && Objects.equal(this.config, configOrError.config)) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return Objects.hashCode(this.status, this.config);
        }

        public String toString() {
            if (this.config != null) {
                return MoreObjects.toStringHelper(this).add("config", this.config).toString();
            }
            return MoreObjects.toStringHelper(this).add("error", this.status).toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public static IdentityHashMap<Args.Key<?>, Object> cloneCustomArgs(@Nullable IdentityHashMap<Args.Key<?>, Object> identityHashMap) {
        if (identityHashMap != null) {
            return new IdentityHashMap<>(identityHashMap);
        }
        return null;
    }
}
