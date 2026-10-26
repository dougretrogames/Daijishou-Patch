package co.infinum.retromock;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import javax.annotation.Nonnull;
import okio.Okio;

/* INFO: loaded from: classes3.dex */
public final class PassThroughBodyFactory implements BodyFactory {
    @Override // co.infinum.retromock.BodyFactory
    public InputStream create(@Nonnull String str) {
        Preconditions.checkNotNull(str, "Input is null.");
        return Okio.buffer(Okio.source(new ByteArrayInputStream(str.getBytes(StandardCharsets.UTF_8)))).inputStream();
    }
}
