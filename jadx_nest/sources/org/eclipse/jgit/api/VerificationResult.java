package org.eclipse.jgit.api;

import org.eclipse.jgit.lib.SignatureVerifier;
import org.eclipse.jgit.revwalk.RevObject;

/* JADX INFO: loaded from: classes5.dex */
public interface VerificationResult {
    Throwable getException();

    RevObject getObject();

    SignatureVerifier.SignatureVerification getVerification();
}
