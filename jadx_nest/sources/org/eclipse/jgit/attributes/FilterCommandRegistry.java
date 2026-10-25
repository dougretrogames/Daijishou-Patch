package org.eclipse.jgit.attributes;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.eclipse.jgit.lib.Repository;

/* JADX INFO: loaded from: classes5.dex */
public class FilterCommandRegistry {
    private static Map<String, FilterCommandFactory> filterCommandRegistry = new ConcurrentHashMap();

    public static FilterCommandFactory register(String str, FilterCommandFactory filterCommandFactory) {
        return filterCommandRegistry.put(str, filterCommandFactory);
    }

    public static FilterCommandFactory unregister(String str) {
        return filterCommandRegistry.remove(str);
    }

    public static boolean isRegistered(String str) {
        return filterCommandRegistry.containsKey(str);
    }

    public static Set<String> getRegisteredFilterCommands() {
        return filterCommandRegistry.keySet();
    }

    public static FilterCommand createFilterCommand(String str, Repository repository, InputStream inputStream, OutputStream outputStream) throws IOException {
        FilterCommandFactory filterCommandFactory = filterCommandRegistry.get(str);
        if (filterCommandFactory == null) {
            return null;
        }
        return filterCommandFactory.create(repository, inputStream, outputStream);
    }
}
