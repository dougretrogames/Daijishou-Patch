package org.eclipse.jgit.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.FileStore;
import java.nio.file.FileSystemException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.PosixFilePermission;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import org.eclipse.jgit.annotations.Nullable;
import org.eclipse.jgit.api.errors.JGitInternalException;
import org.eclipse.jgit.errors.CommandFailedException;
import org.eclipse.jgit.errors.ConfigInvalidException;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.lib.BranchConfig;
import org.eclipse.jgit.lib.ConfigConstants;
import org.eclipse.jgit.lib.Repository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: loaded from: classes5.dex */
public class FS_POSIX extends FS {
    private static final String DEFAULT_GIT_LOCATION = "/usr/bin/git";
    private static final int DEFAULT_UMASK = 18;
    private volatile AtomicFileCreation supportsAtomicFileCreation;
    private volatile int umask;
    private static final Logger LOG = LoggerFactory.getLogger((Class<?>) FS_POSIX.class);
    private static final Map<FileStore, Boolean> CAN_HARD_LINK = new ConcurrentHashMap();

    private enum AtomicFileCreation {
        SUPPORTED,
        NOT_SUPPORTED,
        UNDEFINED;

        /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
        public static AtomicFileCreation[] valuesCustom() {
            AtomicFileCreation[] atomicFileCreationArrValuesCustom = values();
            int length = atomicFileCreationArrValuesCustom.length;
            AtomicFileCreation[] atomicFileCreationArr = new AtomicFileCreation[length];
            System.arraycopy(atomicFileCreationArrValuesCustom, 0, atomicFileCreationArr, 0, length);
            return atomicFileCreationArr;
        }
    }

    @Override // org.eclipse.jgit.util.FS
    public boolean retryFailedLockFileCommit() {
        return false;
    }

    @Override // org.eclipse.jgit.util.FS
    public void setHidden(File file, boolean z) throws IOException {
    }

    @Override // org.eclipse.jgit.util.FS
    public boolean supportsExecute() {
        return true;
    }

    protected FS_POSIX() {
        this.umask = -1;
        this.supportsAtomicFileCreation = AtomicFileCreation.UNDEFINED;
    }

    protected FS_POSIX(FS fs) {
        super(fs);
        this.umask = -1;
        this.supportsAtomicFileCreation = AtomicFileCreation.UNDEFINED;
        if (fs instanceof FS_POSIX) {
            this.umask = ((FS_POSIX) fs).umask;
        }
    }

    @Override // org.eclipse.jgit.util.FS
    public FS newInstance() {
        return new FS_POSIX(this);
    }

    public void setUmask(int i) {
        this.umask = i;
    }

    private int umask() {
        int i = this.umask;
        if (i != -1) {
            return i;
        }
        int umask = readUmask();
        this.umask = umask;
        return umask;
    }

    private static int readUmask() {
        String line;
        try {
            Throwable th = null;
            Process processExec = Runtime.getRuntime().exec(new String[]{"sh", "-c", "umask"}, (String[]) null, (File) null);
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(processExec.getInputStream(), SystemReader.getInstance().getDefaultCharset().name()));
                try {
                    if (processExec.waitFor() == 0 && (line = bufferedReader.readLine()) != null && line.matches("0?\\d{3}")) {
                        return Integer.parseInt(line, 8);
                    }
                    return 18;
                } finally {
                    bufferedReader.close();
                }
            } catch (Throwable th2) {
                if (0 == 0) {
                    throw th2;
                }
                if (null != th2) {
                    th.addSuppressed(th2);
                }
                throw null;
            }
        } catch (Exception unused) {
            return 18;
        }
    }

    @Override // org.eclipse.jgit.util.FS
    protected File discoverGitExe() {
        String str = SystemReader.getInstance().getenv("PATH");
        File fileSearchPath = searchPath(str, "git");
        if (!SystemReader.getInstance().isMacOS()) {
            return fileSearchPath;
        }
        if ((fileSearchPath == null || DEFAULT_GIT_LOCATION.equals(fileSearchPath.getPath())) && searchPath(str, "bash") != null) {
            try {
                String pipe = readPipe(userHome(), new String[]{"bash", "--login", "-c", "which git"}, SystemReader.getInstance().getDefaultCharset().name());
                if (!StringUtils.isEmptyOrNull(pipe)) {
                    fileSearchPath = new File(pipe);
                }
            } catch (CommandFailedException e) {
                LOG.warn(e.getMessage());
            }
        }
        if (fileSearchPath == null || !DEFAULT_GIT_LOCATION.equals(fileSearchPath.getPath())) {
            return fileSearchPath;
        }
        try {
            String pipe2 = readPipe(userHome(), new String[]{"xcode-select", "-p"}, SystemReader.getInstance().getDefaultCharset().name());
            if (!StringUtils.isEmptyOrNull(pipe2) && new File(new File(pipe2), DEFAULT_GIT_LOCATION.substring(1)).exists()) {
                return fileSearchPath;
            }
        } catch (CommandFailedException unused) {
        }
        return null;
    }

    @Override // org.eclipse.jgit.util.FS
    public boolean isCaseSensitive() {
        return !SystemReader.getInstance().isMacOS();
    }

    @Override // org.eclipse.jgit.util.FS
    public boolean canExecute(File file) {
        if (!isFile(file)) {
            return false;
        }
        try {
            return Files.getPosixFilePermissions(FileUtils.toPath(file), new LinkOption[0]).contains(PosixFilePermission.OWNER_EXECUTE);
        } catch (IOException unused) {
            return false;
        }
    }

    @Override // org.eclipse.jgit.util.FS
    public boolean setExecute(File file, boolean z) {
        if (!isFile(file)) {
            return false;
        }
        if (!z) {
            return file.setExecutable(false, false);
        }
        try {
            Path path = FileUtils.toPath(file);
            Set<PosixFilePermission> posixFilePermissions = Files.getPosixFilePermissions(path, new LinkOption[0]);
            posixFilePermissions.add(PosixFilePermission.OWNER_EXECUTE);
            int iUmask = umask();
            apply(posixFilePermissions, iUmask, PosixFilePermission.GROUP_EXECUTE, 8);
            apply(posixFilePermissions, iUmask, PosixFilePermission.OTHERS_EXECUTE, 1);
            Files.setPosixFilePermissions(path, posixFilePermissions);
            return true;
        } catch (IOException e) {
            if (Boolean.parseBoolean(SystemReader.getInstance().getProperty("jgit.fs.debug"))) {
                System.err.println(e);
            }
            return false;
        }
    }

    private static void apply(Set<PosixFilePermission> set, int i, PosixFilePermission posixFilePermission, int i2) {
        if ((i & i2) == 0) {
            set.add(posixFilePermission);
        } else {
            set.remove(posixFilePermission);
        }
    }

    @Override // org.eclipse.jgit.util.FS
    public ProcessBuilder runInShell(String str, String[] strArr) {
        ArrayList arrayList = new ArrayList(strArr.length + 5);
        arrayList.add("sh");
        if (SystemReader.getInstance().isMacOS()) {
            arrayList.add("-l");
        }
        arrayList.add("-c");
        arrayList.add(str + " \"$@\"");
        arrayList.add(str);
        arrayList.addAll(Arrays.asList(strArr));
        ProcessBuilder processBuilder = new ProcessBuilder(new String[0]);
        processBuilder.command(arrayList);
        return processBuilder;
    }

    @Override // org.eclipse.jgit.util.FS
    String shellQuote(String str) {
        return QuotedString.BOURNE.quote(str);
    }

    @Override // org.eclipse.jgit.util.FS
    public ProcessResult runHookIfPresent(Repository repository, String str, String[] strArr, OutputStream outputStream, OutputStream outputStream2, String str2) throws JGitInternalException {
        return internalRunHookIfPresent(repository, str, strArr, outputStream, outputStream2, str2);
    }

    @Override // org.eclipse.jgit.util.FS
    public FS.Attributes getAttributes(File file) {
        return FileUtils.getFileAttributesPosix(this, file);
    }

    @Override // org.eclipse.jgit.util.FS
    public File normalize(File file) {
        return FileUtils.normalize(file);
    }

    @Override // org.eclipse.jgit.util.FS
    public String normalize(String str) {
        return FileUtils.normalize(str);
    }

    @Override // org.eclipse.jgit.util.FS
    public boolean supportsAtomicCreateNewFile() {
        AtomicFileCreation atomicFileCreation;
        if (this.supportsAtomicFileCreation == AtomicFileCreation.UNDEFINED) {
            try {
                String string = SystemReader.getInstance().getUserConfig().getString(ConfigConstants.CONFIG_CORE_SECTION, null, ConfigConstants.CONFIG_KEY_SUPPORTSATOMICFILECREATION);
                if (string != null) {
                    if (StringUtils.toBoolean(string)) {
                        atomicFileCreation = AtomicFileCreation.SUPPORTED;
                    } else {
                        atomicFileCreation = AtomicFileCreation.NOT_SUPPORTED;
                    }
                    this.supportsAtomicFileCreation = atomicFileCreation;
                } else {
                    this.supportsAtomicFileCreation = AtomicFileCreation.SUPPORTED;
                }
            } catch (IOException | ConfigInvalidException e) {
                LOG.warn(JGitText.get().assumeAtomicCreateNewFile, e);
                this.supportsAtomicFileCreation = AtomicFileCreation.SUPPORTED;
            }
        }
        return this.supportsAtomicFileCreation == AtomicFileCreation.SUPPORTED;
    }

    @Override // org.eclipse.jgit.util.FS
    public FS.LockToken createNewFileAtomic(File file) throws IOException {
        try {
            Path path = file.toPath();
            Files.createFile(path, new FileAttribute[0]);
            if (supportsAtomicCreateNewFile()) {
                return token(true, null);
            }
            try {
                FileStore fileStore = Files.getFileStore(path);
                try {
                    Map<FileStore, Boolean> map = CAN_HARD_LINK;
                    if (Boolean.FALSE.equals(map.computeIfAbsent(fileStore, new FS_POSIX$$ExternalSyntheticLambda0()))) {
                        return token(true, null);
                    }
                    Path pathCreateLink = Files.createLink(java.nio.file.Paths.get(uniqueLinkPath(file), new String[0]), path);
                    Integer num = (Integer) Files.getAttribute(path, "unix:nlink", new LinkOption[0]);
                    if (num.intValue() > 2) {
                        LOG.warn(MessageFormat.format(JGitText.get().failedAtomicFileCreation, path, num));
                        return token(false, pathCreateLink);
                    }
                    if (num.intValue() < 2) {
                        map.put(fileStore, Boolean.FALSE);
                    }
                    return token(true, pathCreateLink);
                } catch (IllegalArgumentException | SecurityException | UnsupportedOperationException | FileSystemException unused) {
                    CAN_HARD_LINK.put(fileStore, Boolean.FALSE);
                    return token(true, null);
                }
            } catch (SecurityException unused2) {
                return token(true, null);
            }
        } catch (FileAlreadyExistsException | InvalidPathException unused3) {
            return token(false, null);
        }
    }

    private static FS.LockToken token(boolean z, @Nullable Path path) {
        if (path != null && Files.exists(path, new LinkOption[0])) {
            return new FS.LockToken(z, Optional.of(path));
        }
        return new FS.LockToken(z, Optional.empty());
    }

    private static String uniqueLinkPath(File file) {
        UUID uuidRandomUUID = UUID.randomUUID();
        return file.getAbsolutePath() + BranchConfig.LOCAL_REPOSITORY + Long.toHexString(uuidRandomUUID.getMostSignificantBits()) + Long.toHexString(uuidRandomUUID.getLeastSignificantBits());
    }
}
