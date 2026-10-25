package org.eclipse.jgit.internal.storage.file;

/* JADX INFO: loaded from: classes5.dex */
public interface PackObjectSizeIndex {
    long getObjectCount();

    long getSize(int i);

    int getThreshold();
}
