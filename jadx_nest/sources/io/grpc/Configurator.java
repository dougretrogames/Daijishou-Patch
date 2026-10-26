package io.grpc;

/* INFO: loaded from: classes4.dex */
interface Configurator {
    default void configureChannelBuilder(ManagedChannelBuilder<?> managedChannelBuilder) {
    }

    default void configureServerBuilder(ServerBuilder<?> serverBuilder) {
    }
}
