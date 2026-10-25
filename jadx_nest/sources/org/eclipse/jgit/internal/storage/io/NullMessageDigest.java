package org.eclipse.jgit.internal.storage.io;

import java.security.MessageDigest;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes5.dex */
public final class NullMessageDigest extends MessageDigest {
    private static final byte[] digest = new byte[20];
    private static final NullMessageDigest INSTANCE = new NullMessageDigest();

    @Override // java.security.MessageDigestSpi
    protected void engineReset() {
    }

    @Override // java.security.MessageDigestSpi
    protected void engineUpdate(byte b) {
    }

    @Override // java.security.MessageDigestSpi
    protected void engineUpdate(byte[] bArr, int i, int i2) {
    }

    public static MessageDigest getInstance() {
        return INSTANCE;
    }

    private NullMessageDigest() {
        super(AbstractJsonLexerKt.NULL);
    }

    @Override // java.security.MessageDigestSpi
    protected byte[] engineDigest() {
        return digest;
    }
}
