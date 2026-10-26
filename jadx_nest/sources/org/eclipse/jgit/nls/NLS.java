package org.eclipse.jgit.nls;

import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* INFO: loaded from: classes5.dex */
public class NLS {
    public static final Locale ROOT_LOCALE = new Locale("", "", "");
    private static final InheritableThreadLocal<NLS> local = new InheritableThreadLocal<>();
    private final Locale locale;
    private final Map<Class, TranslationBundle> map = new ConcurrentHashMap();

    public static void setLocale(Locale locale) {
        local.set(new NLS(locale));
    }

    public static void useJVMDefaultLocale() {
        useJVMDefaultInternal();
    }

    private static NLS useJVMDefaultInternal() {
        NLS nls = new NLS(Locale.getDefault());
        local.set(nls);
        return nls;
    }

    public static <T extends TranslationBundle> T getBundleFor(Class<T> cls) {
        NLS nlsUseJVMDefaultInternal = local.get();
        if (nlsUseJVMDefaultInternal == null) {
            nlsUseJVMDefaultInternal = useJVMDefaultInternal();
        }
        return (T) nlsUseJVMDefaultInternal.get(cls);
    }

    public static void clear() {
        local.remove();
        GlobalBundleCache.clear();
    }

    private NLS(Locale locale) {
        this.locale = locale;
    }

    private <T extends TranslationBundle> T get(Class<T> cls) {
        T t = (T) this.map.get(cls);
        if (t == null) {
            t = (T) GlobalBundleCache.lookupBundle(this.locale, cls);
            T t2 = (T) this.map.putIfAbsent(cls, t);
            if (t2 != null) {
                return t2;
            }
        }
        return t;
    }
}
