package org.eclipse.jgit.nls;

import java.lang.reflect.Field;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import org.eclipse.jgit.errors.TranslationBundleLoadingException;
import org.eclipse.jgit.errors.TranslationStringMissingException;

/* INFO: loaded from: classes5.dex */
public abstract class TranslationBundle {
    private Locale effectiveLocale;
    private ResourceBundle resourceBundle;

    public Locale effectiveLocale() {
        return this.effectiveLocale;
    }

    public ResourceBundle resourceBundle() {
        return this.resourceBundle;
    }

    void load(Locale locale) throws TranslationBundleLoadingException {
        Class<?> cls = getClass();
        try {
            ResourceBundle bundle = ResourceBundle.getBundle(cls.getName(), locale, cls.getClassLoader());
            this.resourceBundle = bundle;
            this.effectiveLocale = bundle.getLocale();
            for (Field field : cls.getFields()) {
                if (field.getType().equals(String.class)) {
                    try {
                        field.set(this, this.resourceBundle.getString(field.getName()));
                    } catch (IllegalAccessException e) {
                        e = e;
                        throw new Error(e);
                    } catch (IllegalArgumentException e2) {
                        e = e2;
                        throw new Error(e);
                    } catch (MissingResourceException e3) {
                        throw new TranslationStringMissingException(cls, locale, field.getName(), e3);
                    }
                }
            }
        } catch (MissingResourceException e4) {
            throw new TranslationBundleLoadingException(cls, locale, e4);
        }
    }
}
