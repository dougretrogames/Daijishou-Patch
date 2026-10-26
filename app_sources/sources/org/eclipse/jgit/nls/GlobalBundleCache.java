package org.eclipse.jgit.nls;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* INFO: loaded from: classes5.dex */
class GlobalBundleCache {
    private static final Map<Locale, Map<Class, TranslationBundle>> cachedBundles = new HashMap();

    GlobalBundleCache() {
    }

    static synchronized <T extends TranslationBundle> T lookupBundle(Locale locale, Class<T> cls) {
        T tNewInstance;
        try {
            Map<Locale, Map<Class, TranslationBundle>> map = cachedBundles;
            Map map2 = map.get(locale);
            if (map2 == null) {
                map2 = new HashMap();
                map.put(locale, (Map<Class, TranslationBundle>) map2);
            }
            tNewInstance = (T) map2.get(cls);
            if (tNewInstance == null) {
                tNewInstance = cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                tNewInstance.load(locale);
                map2.put(cls, tNewInstance);
            }
        } catch (IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e) {
            throw new Error(e);
        }
        return tNewInstance;
    }

    static void clear() {
        cachedBundles.clear();
    }
}
