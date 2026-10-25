package org.eclipse.jgit.lib;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import org.eclipse.jgit.api.errors.CanceledException;
import org.eclipse.jgit.api.errors.JGitInternalException;
import org.eclipse.jgit.api.errors.UnsupportedSigningFormatException;
import org.eclipse.jgit.transport.CredentialsProvider;

/* JADX INFO: loaded from: classes5.dex */
public interface Signer {
    boolean canLocateSigningKey(Repository repository, GpgConfig gpgConfig, PersonIdent personIdent, String str, CredentialsProvider credentialsProvider) throws CanceledException;

    GpgSignature sign(Repository repository, GpgConfig gpgConfig, byte[] bArr, PersonIdent personIdent, String str, CredentialsProvider credentialsProvider) throws IOException, CanceledException, UnsupportedSigningFormatException;

    default void signObject(Repository repository, GpgConfig gpgConfig, ObjectBuilder objectBuilder, PersonIdent personIdent, String str, CredentialsProvider credentialsProvider) throws IOException, CanceledException, UnsupportedSigningFormatException {
        try {
            objectBuilder.setGpgSignature(sign(repository, gpgConfig, objectBuilder.build(), personIdent, str, credentialsProvider));
        } catch (UnsupportedEncodingException e) {
            throw new JGitInternalException(e.getMessage(), e);
        }
    }
}
