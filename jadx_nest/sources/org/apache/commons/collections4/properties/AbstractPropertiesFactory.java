package org.apache.commons.collections4.properties;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URI;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.Properties;

/* JADX INFO: loaded from: classes5.dex */
public abstract class AbstractPropertiesFactory<T extends Properties> {
    protected abstract T createProperties();

    public enum PropertyFormat {
        PROPERTIES,
        XML;

        static PropertyFormat toPropertyFormat(String str) {
            return ((String) Objects.requireNonNull(str, "fileName")).endsWith(".xml") ? XML : PROPERTIES;
        }
    }

    protected AbstractPropertiesFactory() {
    }

    public T load(ClassLoader classLoader, String str) throws IOException {
        InputStream resourceAsStream = classLoader.getResourceAsStream(str);
        try {
            T t = (T) load(resourceAsStream, PropertyFormat.toPropertyFormat(str));
            if (resourceAsStream != null) {
                resourceAsStream.close();
            }
            return t;
        } catch (Throwable th) {
            if (resourceAsStream != null) {
                try {
                    resourceAsStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    public T load(File file) throws IOException {
        return (T) load(file.toPath());
    }

    public T load(InputStream inputStream) throws IOException {
        if (inputStream == null) {
            return null;
        }
        T t = (T) createProperties();
        t.load(inputStream);
        return t;
    }

    public T load(InputStream inputStream, PropertyFormat propertyFormat) throws IOException {
        if (inputStream == null) {
            return null;
        }
        T t = (T) createProperties();
        if (propertyFormat == PropertyFormat.XML) {
            t.loadFromXML(inputStream);
            return t;
        }
        t.load(inputStream);
        return t;
    }

    public T load(Path path) throws IOException {
        InputStream inputStreamNewInputStream = Files.newInputStream(path, new OpenOption[0]);
        try {
            T t = (T) load(inputStreamNewInputStream, PropertyFormat.toPropertyFormat(Objects.toString(path.getFileName(), null)));
            if (inputStreamNewInputStream != null) {
                inputStreamNewInputStream.close();
            }
            return t;
        } catch (Throwable th) {
            if (inputStreamNewInputStream != null) {
                try {
                    inputStreamNewInputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    public T load(Reader reader) throws IOException {
        T t = (T) createProperties();
        t.load(reader);
        return t;
    }

    public T load(String str) throws IOException {
        return (T) load(Paths.get(str, new String[0]));
    }

    public T load(URI uri) throws IOException {
        return (T) load(Paths.get(uri));
    }

    public T load(URL url) throws IOException {
        InputStream inputStreamOpenStream = url.openStream();
        try {
            T t = (T) load(inputStreamOpenStream, PropertyFormat.toPropertyFormat(url.getFile()));
            if (inputStreamOpenStream != null) {
                inputStreamOpenStream.close();
            }
            return t;
        } catch (Throwable th) {
            if (inputStreamOpenStream != null) {
                try {
                    inputStreamOpenStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }
}
