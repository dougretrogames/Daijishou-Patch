package co.infinum.retromock;

import java.io.IOException;
import java.io.InputStream;

/* INFO: loaded from: classes3.dex */
final class RetromockBodyFactory {
    private final BodyFactory bodyFactory;
    private final String input;

    RetromockBodyFactory(BodyFactory bodyFactory, String str) {
        this.bodyFactory = bodyFactory;
        this.input = str;
    }

    InputStream createBody() throws IOException {
        return this.bodyFactory.create(this.input);
    }
}
