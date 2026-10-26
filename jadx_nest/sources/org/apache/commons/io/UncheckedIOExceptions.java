package org.apache.commons.io;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.util.Objects;

/* INFO: loaded from: classes5.dex */
final class UncheckedIOExceptions {
    public static UncheckedIOException create(Object obj) {
        String string = Objects.toString(obj);
        return new UncheckedIOException(string, new IOException(string));
    }

    public static UncheckedIOException wrap(IOException iOException, Object obj) {
        return new UncheckedIOException(Objects.toString(obj), iOException);
    }

    private UncheckedIOExceptions() {
    }
}
