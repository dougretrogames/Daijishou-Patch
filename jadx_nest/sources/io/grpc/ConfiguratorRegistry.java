package io.grpc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* INFO: loaded from: classes4.dex */
final class ConfiguratorRegistry {
    private static ConfiguratorRegistry instance;
    private boolean configFrozen;
    private List<Configurator> configurators = Collections.emptyList();
    private boolean wasConfiguratorsSet;

    ConfiguratorRegistry() {
    }

    public static synchronized ConfiguratorRegistry getDefaultRegistry() {
        if (instance == null) {
            instance = new ConfiguratorRegistry();
        }
        return instance;
    }

    public synchronized void setConfigurators(List<? extends Configurator> list) {
        if (this.configFrozen) {
            throw new IllegalStateException("Configurators are already set");
        }
        this.configurators = Collections.unmodifiableList(new ArrayList(list));
        this.configFrozen = true;
        this.wasConfiguratorsSet = true;
    }

    public synchronized List<Configurator> getConfigurators() {
        this.configFrozen = true;
        return this.configurators;
    }

    public synchronized boolean wasSetConfiguratorsCalled() {
        return this.wasConfiguratorsSet;
    }
}
