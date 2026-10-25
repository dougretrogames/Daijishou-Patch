package org.eclipse.jgit.errors;

import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
public abstract class TranslationBundleException extends RuntimeException {
    private static final long serialVersionUID = 1;
    private final Class bundleClass;
    private final Locale locale;

    protected TranslationBundleException(String str, Class cls, Locale locale, Exception exc) {
        super(str, exc);
        this.bundleClass = cls;
        this.locale = locale;
    }

    public final Class getBundleClass() {
        return this.bundleClass;
    }

    public final Locale getLocale() {
        return this.locale;
    }
}
