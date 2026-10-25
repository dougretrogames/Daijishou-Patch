package org.eclipse.jgit.lib;

/* JADX INFO: loaded from: classes5.dex */
public interface SignatureVerifierFactory {
    SignatureVerifier create();

    GpgConfig.GpgFormat getType();
}
