package co.infinum.retromock;

import java.io.IOException;
import java.io.InputStream;
import javax.annotation.Nonnull;

/* JADX INFO: loaded from: classes3.dex */
public interface BodyFactory {
    InputStream create(@Nonnull String str) throws IOException;
}
