package io.grpc;

import java.util.Iterator;
import java.util.List;

/* INFO: loaded from: classes4.dex */
public final class InternalConfiguratorRegistry {
    private InternalConfiguratorRegistry() {
    }

    public static void setConfigurators(List<InternalConfigurator> list) {
        ConfiguratorRegistry.getDefaultRegistry().setConfigurators(list);
    }

    public static List<?> getConfigurators() {
        return ConfiguratorRegistry.getDefaultRegistry().getConfigurators();
    }

    public static void configureChannelBuilder(ManagedChannelBuilder<?> managedChannelBuilder) {
        Iterator<Configurator> it = ConfiguratorRegistry.getDefaultRegistry().getConfigurators().iterator();
        while (it.hasNext()) {
            it.next().configureChannelBuilder(managedChannelBuilder);
        }
    }

    public static void configureServerBuilder(ServerBuilder<?> serverBuilder) {
        Iterator<Configurator> it = ConfiguratorRegistry.getDefaultRegistry().getConfigurators().iterator();
        while (it.hasNext()) {
            it.next().configureServerBuilder(serverBuilder);
        }
    }

    public static boolean wasSetConfiguratorsCalled() {
        return ConfiguratorRegistry.getDefaultRegistry().wasSetConfiguratorsCalled();
    }
}
