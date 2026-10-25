package org.eclipse.jgit.lib;

/* JADX INFO: loaded from: classes5.dex */
public interface SignerFactory {
    Signer create();

    GpgConfig.GpgFormat getType();
}
