package org.eclipse.jgit.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitOption;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.List;
import org.eclipse.jgit.errors.CommandFailedException;
import org.eclipse.jgit.treewalk.FileTreeIterator;
import org.eclipse.jgit.treewalk.WorkingTreeIterator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: loaded from: classes5.dex */
public class FS_Win32 extends FS {
    private static final Logger LOG = LoggerFactory.getLogger((Class<?>) FS_Win32.class);

    @Override // org.eclipse.jgit.util.FS
    public boolean canExecute(File file) {
        return false;
    }

    @Override // org.eclipse.jgit.util.FS
    public boolean isCaseSensitive() {
        return false;
    }

    @Override // org.eclipse.jgit.util.FS
    public boolean retryFailedLockFileCommit() {
        return true;
    }

    @Override // org.eclipse.jgit.util.FS
    public boolean setExecute(File file, boolean z) {
        return false;
    }

    @Override // org.eclipse.jgit.util.FS
    public boolean supportsExecute() {
        return false;
    }

    public FS_Win32() {
    }

    protected FS_Win32(FS fs) {
        super(fs);
    }

    @Override // org.eclipse.jgit.util.FS
    public FS newInstance() {
        return new FS_Win32(this);
    }

    @Override // org.eclipse.jgit.util.FS
    public WorkingTreeIterator.Entry[] list(File file, FileTreeIterator.FileModeStrategy fileModeStrategy) {
        if (!Files.isDirectory(file.toPath(), LinkOption.NOFOLLOW_LINKS)) {
            return NO_ENTRIES;
        }
        ArrayList arrayList = new ArrayList();
        try {
            Files.walkFileTree(file.toPath(), EnumSet.noneOf(FileVisitOption.class), 1, new AnonymousClass1(this, supportsExecute(), arrayList, fileModeStrategy));
        } catch (IOException unused) {
        }
        if (arrayList.isEmpty()) {
            return NO_ENTRIES;
        }
        return (WorkingTreeIterator.Entry[]) arrayList.toArray(new WorkingTreeIterator.Entry[0]);
    }

    /* JADX INFO: renamed from: org.eclipse.jgit.util.FS_Win32$1, reason: invalid class name */
    class AnonymousClass1 extends SimpleFileVisitor<Path> {
        private final /* synthetic */ boolean val$checkExecutable;
        private final /* synthetic */ FileTreeIterator.FileModeStrategy val$fileModeStrategy;
        private final /* synthetic */ FS val$fs;
        private final /* synthetic */ List val$result;

        AnonymousClass1(FS fs, boolean z, List list, FileTreeIterator.FileModeStrategy fileModeStrategy) {
            this.val$fs = fs;
            this.val$checkExecutable = z;
            this.val$result = list;
            this.val$fileModeStrategy = fileModeStrategy;
        }

        @Override // java.nio.file.SimpleFileVisitor, java.nio.file.FileVisitor
        public FileVisitResult visitFile(Path path, BasicFileAttributes basicFileAttributes) throws IOException {
            File file = path.toFile();
            this.val$result.add(new FileTreeIterator.FileEntry(file, this.val$fs, new FS.Attributes(this.val$fs, file, true, basicFileAttributes.isDirectory(), this.val$checkExecutable && file.canExecute(), basicFileAttributes.isSymbolicLink(), basicFileAttributes.isRegularFile(), basicFileAttributes.creationTime().toMillis(), basicFileAttributes.lastModifiedTime().toInstant(), basicFileAttributes.size()), this.val$fileModeStrategy));
            return FileVisitResult.CONTINUE;
        }

        @Override // java.nio.file.SimpleFileVisitor, java.nio.file.FileVisitor
        public FileVisitResult visitFileFailed(Path path, IOException iOException) throws IOException {
            return FileVisitResult.CONTINUE;
        }
    }

    @Override // org.eclipse.jgit.util.FS
    protected File discoverGitExe() {
        String str = SystemReader.getInstance().getenv("PATH");
        File fileSearchPath = searchPath(str, "git.exe", "git.cmd");
        if (fileSearchPath == null && searchPath(str, "bash.exe") != null) {
            try {
                String pipe = readPipe(userHome(), new String[]{"bash", "--login", "-c", "which git"}, SystemReader.getInstance().getDefaultCharset().name());
                if (!StringUtils.isEmptyOrNull(pipe)) {
                    return resolve(null, pipe);
                }
            } catch (CommandFailedException e) {
                LOG.warn(e.getMessage());
                return null;
            }
        }
        return fileSearchPath;
    }

    @Override // org.eclipse.jgit.util.FS
    protected File userHomeImpl() {
        String str;
        String str2 = SystemReader.getInstance().getenv("HOME");
        if (str2 != null) {
            return resolve(null, str2);
        }
        String str3 = SystemReader.getInstance().getenv("HOMEDRIVE");
        if (str3 != null && (str = SystemReader.getInstance().getenv("HOMEPATH")) != null) {
            return new File(str3, str);
        }
        String str4 = SystemReader.getInstance().getenv("HOMESHARE");
        if (str4 != null) {
            return new File(str4);
        }
        return super.userHomeImpl();
    }

    @Override // org.eclipse.jgit.util.FS
    public ProcessBuilder runInShell(String str, String[] strArr) {
        ArrayList arrayList = new ArrayList(strArr.length + 3);
        arrayList.add("cmd.exe");
        arrayList.add("/c");
        arrayList.add(str);
        arrayList.addAll(Arrays.asList(strArr));
        ProcessBuilder processBuilder = new ProcessBuilder(new String[0]);
        processBuilder.command(arrayList);
        return processBuilder;
    }

    @Override // org.eclipse.jgit.util.FS
    public FS.Attributes getAttributes(File file) {
        return FileUtils.getFileAttributesBasic(this, file);
    }
}
