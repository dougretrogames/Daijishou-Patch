package org.eclipse.jgit.errors;

import java.util.Locale;
import org.apache.commons.collections4.CollectionUtils;

/* JADX INFO: loaded from: classes5.dex */
public class TranslationBundleLoadingException extends TranslationBundleException {
    private static final long serialVersionUID = 1;

    public TranslationBundleLoadingException(Class cls, Locale locale, Exception exc) {
        super("Loading of translation bundle failed for [" + cls.getName() + ", " + locale.toString() + CollectionUtils.DEFAULT_TOSTRING_SUFFIX, cls, locale, exc);
    }
}
