package org.eclipse.jgit.internal.storage.file;

import org.eclipse.jgit.errors.CorruptObjectException;
import org.eclipse.jgit.errors.PackMismatchException;
import org.eclipse.jgit.lib.ObjectId;

/* INFO: loaded from: classes5.dex */
public interface PackReverseIndex {
    public static final byte[] MAGIC = {82, 73, 68, 88};
    public static final int VERSION_1 = 1;

    long findNextOffset(long j, long j2) throws CorruptObjectException;

    ObjectId findObject(long j);

    ObjectId findObjectByPosition(int i);

    int findPosition(long j);

    void verifyPackChecksum(String str) throws PackMismatchException;
}
