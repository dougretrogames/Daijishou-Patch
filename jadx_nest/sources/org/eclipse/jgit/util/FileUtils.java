package org.eclipse.jgit.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.AtomicMoveNotSupportedException;
import java.nio.file.CopyOption;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.LinkOption;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.FileTime;
import java.nio.file.attribute.PosixFileAttributeView;
import java.nio.file.attribute.PosixFileAttributes;
import java.nio.file.attribute.PosixFilePermission;
import java.text.MessageFormat;
import java.text.Normalizer;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import java.util.Random;
import java.util.regex.Pattern;
import java.util.stream.Stream;
import net.lingala.zip4j.util.InternalZipConstants;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.lib.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* INFO: loaded from: classes5.dex */
public class FileUtils {
    public static final int EMPTY_DIRECTORIES_ONLY = 16;
    public static final int IGNORE_ERRORS = 8;
    public static final int NONE = 0;
    public static final int RECURSIVE = 1;
    public static final int RETRY = 2;
    public static final int SKIP_MISSING = 4;
    private static final Logger LOG = LoggerFactory.getLogger((Class<?>) FileUtils.class);
    private static final Random RNG = new Random();

    @FunctionalInterface
    public interface IOFunction<A, B> {
        B apply(A a) throws Exception;
    }

    public static Path toPath(File file) throws IOException {
        try {
            return file.toPath();
        } catch (InvalidPathException e) {
            throw new IOException(e);
        }
    }

    public static void delete(File file) throws IOException {
        delete(file, 0);
    }

    public static void delete(File file, int i) throws IOException {
        int i2;
        boolean writable;
        File[] fileArrListFiles;
        FS fs = FS.DETECTED;
        if ((i & 4) == 0 || fs.exists(file)) {
            if ((i & 1) != 0 && fs.isDirectory(file) && (fileArrListFiles = file.listFiles()) != null) {
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                for (File file2 : fileArrListFiles) {
                    if (file2.isFile()) {
                        arrayList.add(file2);
                    } else {
                        arrayList2.add(file2);
                    }
                }
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    delete((File) it.next(), i);
                }
                Iterator it2 = arrayList2.iterator();
                while (it2.hasNext()) {
                    delete((File) it2.next(), i);
                }
            }
            if ((i & 16) != 0 && !file.isDirectory()) {
                if ((i & 8) == 0) {
                    throw new IOException(MessageFormat.format(JGitText.get().deleteFileFailed, file.getAbsolutePath()));
                }
                return;
            }
            Path path = file.toPath();
            IOException e = null;
            do {
                try {
                    Files.delete(path);
                    return;
                } catch (FileNotFoundException e2) {
                    e = e2;
                    handleDeleteException(file, e, i, 12);
                    return;
                } catch (DirectoryNotEmptyException e3) {
                    handleDeleteException(file, e3, i, 8);
                    return;
                } catch (NoSuchFileException e4) {
                    e = e4;
                    handleDeleteException(file, e, i, 12);
                    return;
                } catch (IOException e5) {
                    writable = !file.canWrite() ? file.setWritable(true) : false;
                    if (!writable) {
                        e = e5;
                    }
                }
            } while (writable);
            if ((i & 2) != 0) {
                for (i2 = 1; i2 < 10; i2++) {
                    try {
                        Thread.sleep(100L);
                    } catch (InterruptedException unused) {
                    }
                    try {
                        Files.deleteIfExists(path);
                        return;
                    } catch (IOException e6) {
                        e = e6;
                    }
                }
            }
            handleDeleteException(file, e, i, 8);
        }
    }

    private static void handleDeleteException(File file, IOException iOException, int i, int i2) throws IOException {
        if (iOException != null && (i & i2) == 0) {
            throw new IOException(MessageFormat.format(JGitText.get().deleteFileFailed, file.getAbsolutePath()), iOException);
        }
    }

    public static void rename(File file, File file2) throws IOException {
        rename(file, file2, StandardCopyOption.REPLACE_EXISTING);
    }

    /* WARN: Code duplicated, block: B:40:0x003d A[SYNTHETIC] */
    /* WARN: Code duplicated, block: B:42:0x000d A[SYNTHETIC] */
    public static void rename(File file, File file2, CopyOption... copyOptionArr) throws IOException {
        int i = FS.DETECTED.retryFailedLockFileCommit() ? 10 : 1;
        IOException e = null;
        while (true) {
            i--;
            if (i >= 0) {
                try {
                    Files.move(toPath(file), toPath(file2), copyOptionArr);
                    return;
                } catch (AtomicMoveNotSupportedException e2) {
                    throw e2;
                } catch (IOException e3) {
                    if (i == 0) {
                        try {
                            if (!file2.delete()) {
                                delete(file2, 17);
                            }
                            Files.move(toPath(file), toPath(file2), copyOptionArr);
                            return;
                        } catch (IOException e4) {
                            e = e4;
                            e.addSuppressed(e3);
                            if (i > 0) {
                                try {
                                    Thread.sleep(100L);
                                } catch (InterruptedException e5) {
                                    throw new IOException(MessageFormat.format(JGitText.get().renameFileFailed, file.getAbsolutePath(), file2.getAbsolutePath()), e5);
                                }
                            }
                        }
                    }
                    if (i > 0) {
                        Thread.sleep(100L);
                    }
                }
            } else {
                throw new IOException(MessageFormat.format(JGitText.get().renameFileFailed, file.getAbsolutePath(), file2.getAbsolutePath()), e);
            }
        }
    }

    public static void mkdir(File file) throws IOException {
        mkdir(file, false);
    }

    public static void mkdir(File file, boolean z) throws IOException {
        if (file.mkdir()) {
            return;
        }
        if (!z || !file.isDirectory()) {
            throw new IOException(MessageFormat.format(JGitText.get().mkDirFailed, file.getAbsolutePath()));
        }
    }

    public static void mkdirs(File file) throws IOException {
        mkdirs(file, false);
    }

    public static void mkdirs(File file, boolean z) throws IOException {
        if (file.mkdirs()) {
            return;
        }
        if (!z || !file.isDirectory()) {
            throw new IOException(MessageFormat.format(JGitText.get().mkDirsFailed, file.getAbsolutePath()));
        }
    }

    public static void createNewFile(File file) throws IOException {
        if (!file.createNewFile()) {
            throw new IOException(MessageFormat.format(JGitText.get().createNewFileFailed, file));
        }
    }

    public static Path createSymLink(File file, String str) throws IOException {
        Path path = toPath(file);
        if (Files.exists(path, LinkOption.NOFOLLOW_LINKS)) {
            BasicFileAttributes attributes = Files.readAttributes(path, (Class<BasicFileAttributes>) BasicFileAttributes.class, LinkOption.NOFOLLOW_LINKS);
            if (attributes.isRegularFile() || attributes.isSymbolicLink()) {
                delete(file);
            } else {
                delete(file, 17);
            }
        }
        if (SystemReader.getInstance().isWindows()) {
            str = str.replace('/', '\\');
        }
        return Files.createSymbolicLink(path, toPath(new File(str)), new FileAttribute[0]);
    }

    public static String readSymLink(File file) throws IOException {
        String string = Files.readSymbolicLink(toPath(file)).toString();
        if (SystemReader.getInstance().isWindows()) {
            return string.replace('\\', '/');
        }
        return SystemReader.getInstance().isMacOS() ? Normalizer.normalize(string, Normalizer.Form.NFC) : string;
    }

    public static File createTempDir(String str, String str2, File file) throws IOException {
        File fileCreateTempFile = File.createTempFile(str, str2, file);
        if (fileCreateTempFile.delete() && fileCreateTempFile.mkdir()) {
            return fileCreateTempFile;
        }
        throw new IOException(JGitText.get().cannotCreateTempDir);
    }

    public static String relativizeNativePath(String str, String str2) {
        return FS.DETECTED.relativize(str, str2);
    }

    public static String relativizeGitPath(String str, String str2) {
        return relativizePath(str, str2, InternalZipConstants.ZIP_FILE_SEPARATOR, false);
    }

    public static String relativizePath(String str, String str2, String str3, boolean z) {
        if (str.equals(str2)) {
            return "";
        }
        String[] strArrSplit = str.split(Pattern.quote(str3));
        String[] strArrSplit2 = str2.split(Pattern.quote(str3));
        int i = 0;
        while (i < strArrSplit.length && i < strArrSplit2.length && ((z && strArrSplit[i].equals(strArrSplit2[i])) || (!z && strArrSplit[i].equalsIgnoreCase(strArrSplit2[i])))) {
            i++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i2 = i; i2 < strArrSplit.length; i2++) {
            sb.append("..").append(str3);
        }
        while (i < strArrSplit2.length) {
            sb.append(strArrSplit2[i]);
            if (i < strArrSplit2.length - 1) {
                sb.append(str3);
            }
            i++;
        }
        return sb.toString();
    }

    public static boolean isStaleFileHandle(IOException iOException) {
        String message = iOException.getMessage();
        return message != null && message.toLowerCase(Locale.ROOT).matches("stale .*file .*handle");
    }

    public static boolean isStaleFileHandleInCausalChain(Throwable th) {
        while (th != null) {
            if ((th instanceof IOException) && isStaleFileHandle((IOException) th)) {
                return true;
            }
            th = th.getCause();
        }
        return false;
    }

    private static void backOff(long j, IOException iOException) throws IOException {
        try {
            Thread.sleep(j);
        } catch (InterruptedException e) {
            InterruptedIOException interruptedIOException = new InterruptedIOException();
            interruptedIOException.initCause(e);
            interruptedIOException.addSuppressed(iOException);
            Thread.currentThread().interrupt();
            throw interruptedIOException;
        }
    }

    public static <T> T readWithRetries(File file, IOFunction<File, ? extends T> iOFunction) throws Exception {
        int i = 0;
        long j = 50;
        while (true) {
            try {
                try {
                    return iOFunction.apply(file);
                } catch (IOException e) {
                    if (isStaleFileHandleInCausalChain(e) && i < 5) {
                        Logger logger = LOG;
                        if (logger.isDebugEnabled()) {
                            logger.debug(MessageFormat.format(JGitText.get().packedRefsHandleIsStale, Integer.valueOf(i)), (Throwable) e);
                        }
                        i++;
                    } else {
                        throw e;
                    }
                }
            } catch (FileNotFoundException e2) {
                if (!file.isFile()) {
                    return null;
                }
                if (j > 1000) {
                    throw e2;
                }
                backOff(j, e2);
                j *= 2;
            }
        }
    }

    static boolean isSymlink(File file) {
        return Files.isSymbolicLink(file.toPath());
    }

    static Instant lastModifiedInstant(Path path) {
        try {
            return Files.getLastModifiedTime(path, LinkOption.NOFOLLOW_LINKS).toInstant();
        } catch (NoSuchFileException unused) {
            LOG.debug("Cannot read lastModifiedInstant since path {} does not exist", path);
            return Instant.EPOCH;
        } catch (IOException e) {
            LOG.error(MessageFormat.format(JGitText.get().readLastModifiedFailed, path), (Throwable) e);
            return Instant.ofEpochMilli(path.toFile().lastModified());
        }
    }

    static BasicFileAttributes fileAttributes(File file) throws IOException {
        return Files.readAttributes(file.toPath(), BasicFileAttributes.class, LinkOption.NOFOLLOW_LINKS);
    }

    static void setLastModified(Path path, Instant instant) throws IOException {
        Files.setLastModifiedTime(path, FileTime.from(instant));
    }

    static boolean exists(File file) {
        return Files.exists(file.toPath(), LinkOption.NOFOLLOW_LINKS);
    }

    static boolean isHidden(File file) throws IOException {
        return Files.isHidden(toPath(file));
    }

    public static void setHidden(File file, boolean z) throws IOException {
        Files.setAttribute(toPath(file), "dos:hidden", Boolean.valueOf(z), LinkOption.NOFOLLOW_LINKS);
    }

    public static long getLength(File file) throws IOException {
        Path path = toPath(file);
        if (Files.isSymbolicLink(path)) {
            return Files.readSymbolicLink(path).toString().getBytes(StandardCharsets.UTF_8).length;
        }
        return Files.size(path);
    }

    static boolean isDirectory(File file) {
        return Files.isDirectory(file.toPath(), LinkOption.NOFOLLOW_LINKS);
    }

    static boolean isFile(File file) {
        return Files.isRegularFile(file.toPath(), LinkOption.NOFOLLOW_LINKS);
    }

    public static boolean hasFiles(Path path) throws IOException {
        Throwable th = null;
        try {
            Stream<Path> list = Files.list(path);
            try {
                return list.findAny().isPresent();
            } finally {
                if (list != null) {
                    list.close();
                }
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
    }

    public static boolean canExecute(File file) {
        if (isFile(file)) {
            return Files.isExecutable(file.toPath());
        }
        return false;
    }

    static FS.Attributes getFileAttributesBasic(FS fs, File file) {
        long size;
        try {
            Path path = toPath(file);
            BasicFileAttributes attributes = ((BasicFileAttributeView) path.getFileSystem().provider().getFileAttributeView(path, BasicFileAttributeView.class, LinkOption.NOFOLLOW_LINKS)).readAttributes();
            boolean zIsDirectory = attributes.isDirectory();
            boolean zCanExecute = fs.supportsExecute() ? file.canExecute() : false;
            boolean zIsSymbolicLink = attributes.isSymbolicLink();
            boolean zIsRegularFile = attributes.isRegularFile();
            long millis = attributes.creationTime().toMillis();
            Instant instant = attributes.lastModifiedTime().toInstant();
            if (attributes.isSymbolicLink()) {
                size = Constants.encode(readSymLink(file)).length;
            } else {
                size = attributes.size();
            }
            return new FS.Attributes(fs, file, true, zIsDirectory, zCanExecute, zIsSymbolicLink, zIsRegularFile, millis, instant, size);
        } catch (IOException unused) {
            return new FS.Attributes(file, fs);
        }
    }

    public static FS.Attributes getFileAttributesPosix(FS fs, File file) {
        FS fs2;
        File file2;
        try {
            Path path = toPath(file);
            PosixFileAttributes attributes = ((PosixFileAttributeView) path.getFileSystem().provider().getFileAttributeView(path, PosixFileAttributeView.class, LinkOption.NOFOLLOW_LINKS)).readAttributes();
            fs2 = fs;
            file2 = file;
            try {
                return new FS.Attributes(fs2, file2, true, attributes.isDirectory(), attributes.permissions().contains(PosixFilePermission.OWNER_EXECUTE), attributes.isSymbolicLink(), attributes.isRegularFile(), attributes.creationTime().toMillis(), attributes.lastModifiedTime().toInstant(), attributes.size());
            } catch (IOException unused) {
                return new FS.Attributes(file2, fs2);
            }
        } catch (IOException unused2) {
            fs2 = fs;
            file2 = file;
        }
    }

    public static File normalize(File file) {
        return SystemReader.getInstance().isMacOS() ? new File(Normalizer.normalize(file.getPath(), Normalizer.Form.NFC)) : file;
    }

    public static String normalize(String str) {
        if (!SystemReader.getInstance().isMacOS()) {
            return str;
        }
        if (str == null) {
            return null;
        }
        return Normalizer.normalize(str, Normalizer.Form.NFC);
    }

    public static File canonicalize(File file) {
        if (file == null) {
            return null;
        }
        try {
            return file.getCanonicalFile();
        } catch (IOException unused) {
            return file;
        }
    }

    public static String pathToString(File file) {
        String path = file.getPath();
        return SystemReader.getInstance().isWindows() ? path.replace('\\', '/') : path;
    }

    public static void touch(Path path) throws IOException {
        FileChannel fileChannelOpen = FileChannel.open(path, StandardOpenOption.CREATE, StandardOpenOption.APPEND, StandardOpenOption.SYNC);
        if (fileChannelOpen != null) {
            fileChannelOpen.close();
        }
        Files.setLastModifiedTime(path, FileTime.from(Instant.now()));
    }

    public static long delay(long j, long j2, long j3) {
        long jMax = Math.max(0L, (j * 3) - j2);
        if (jMax > 0) {
            jMax = RNG.nextInt((int) Math.min(jMax + 1, 2147483647L));
        }
        return Math.max(Math.min(jMax + j2, j3), j2);
    }
}
