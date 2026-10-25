package org.eclipse.jgit.internal.storage.file;

import java.io.File;
import java.io.IOException;
import org.eclipse.jgit.lib.Constants;
import org.eclipse.jgit.transport.PackLock;
import org.eclipse.jgit.util.FS;
import org.eclipse.jgit.util.FileUtils;

/* JADX INFO: loaded from: classes5.dex */
public class PackLockImpl implements PackLock {
    private final File keepFile;

    public PackLockImpl(File file, FS fs) {
        File parentFile = file.getParentFile();
        String name = file.getName();
        this.keepFile = new File(parentFile, name.substring(0, name.length() - 5) + ".keep");
    }

    public boolean lock(String str) throws IOException {
        if (str == null) {
            return false;
        }
        if (!str.endsWith("\n")) {
            str = str + "\n";
        }
        LockFile lockFile = new LockFile(this.keepFile);
        if (!lockFile.lock()) {
            return false;
        }
        lockFile.write(Constants.encode(str));
        return lockFile.commit();
    }

    @Override // org.eclipse.jgit.transport.PackLock
    public void unlock() throws IOException {
        FileUtils.delete(this.keepFile);
    }
}
