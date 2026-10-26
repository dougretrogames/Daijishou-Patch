package co.infinum.retromock;

import java.io.IOException;
import java.io.InputStream;
import javax.annotation.Nonnull;

/* INFO: loaded from: classes3.dex */
public class NonEmptyBodyFactory implements BodyFactory {
    private final BodyFactory bodyFactory;

    public NonEmptyBodyFactory(BodyFactory bodyFactory) {
        Preconditions.checkNotNull(bodyFactory, "Body factory is null.");
        this.bodyFactory = bodyFactory;
    }

    @Override // co.infinum.retromock.BodyFactory
    public final InputStream create(@Nonnull String str) throws IOException {
        Preconditions.checkNotNull(str, "Input is null.");
        if (str.trim().isEmpty()) {
            return new AnonymousClass1();
        }
        return this.bodyFactory.create(str);
    }

    /* INFO: renamed from: co.infinum.retromock.NonEmptyBodyFactory$1, reason: invalid class name */
    class AnonymousClass1 extends InputStream {
        @Override // java.io.InputStream
        public int read() throws IOException {
            return -1;
        }

        AnonymousClass1() {
        }
    }
}
