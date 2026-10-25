package org.apache.commons.io.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.SeekableByteChannel;
import java.nio.charset.Charset;
import java.nio.file.CopyOption;
import java.nio.file.DirectoryStream;
import java.nio.file.FileStore;
import java.nio.file.FileVisitOption;
import java.nio.file.FileVisitor;
import java.nio.file.LinkOption;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.FileTime;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.UserPrincipal;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiPredicate;
import java.util.stream.Stream;
import org.apache.commons.io.function.Uncheck;

/* JADX INFO: loaded from: classes5.dex */
public final class FilesUncheck {
    public static long copy(InputStream inputStream, Path path, CopyOption... copyOptionArr) {
        return ((Long) Uncheck.apply(new FilesUncheck$$ExternalSyntheticLambda55(), inputStream, path, copyOptionArr)).longValue();
    }

    public static long copy(Path path, OutputStream outputStream) {
        return ((Long) Uncheck.apply(new FilesUncheck$$ExternalSyntheticLambda8(), path, outputStream)).longValue();
    }

    public static Path copy(Path path, Path path2, CopyOption... copyOptionArr) {
        return (Path) Uncheck.apply(new FilesUncheck$$ExternalSyntheticLambda22(), path, path2, copyOptionArr);
    }

    public static Path createDirectories(Path path, FileAttribute<?>... fileAttributeArr) {
        return (Path) Uncheck.apply(new FilesUncheck$$ExternalSyntheticLambda2(), path, fileAttributeArr);
    }

    public static Path createDirectory(Path path, FileAttribute<?>... fileAttributeArr) {
        return (Path) Uncheck.apply(new FilesUncheck$$ExternalSyntheticLambda33(), path, fileAttributeArr);
    }

    public static Path createFile(Path path, FileAttribute<?>... fileAttributeArr) {
        return (Path) Uncheck.apply(new FilesUncheck$$ExternalSyntheticLambda37(), path, fileAttributeArr);
    }

    public static Path createLink(Path path, Path path2) {
        return (Path) Uncheck.apply(new FilesUncheck$$ExternalSyntheticLambda3(), path, path2);
    }

    public static Path createSymbolicLink(Path path, Path path2, FileAttribute<?>... fileAttributeArr) {
        return (Path) Uncheck.apply(new FilesUncheck$$ExternalSyntheticLambda39(), path, path2, fileAttributeArr);
    }

    public static Path createTempDirectory(Path path, String str, FileAttribute<?>... fileAttributeArr) {
        return (Path) Uncheck.apply(new FilesUncheck$$ExternalSyntheticLambda54(), path, str, fileAttributeArr);
    }

    public static Path createTempDirectory(String str, FileAttribute<?>... fileAttributeArr) {
        return (Path) Uncheck.apply(new FilesUncheck$$ExternalSyntheticLambda46(), str, fileAttributeArr);
    }

    public static Path createTempFile(Path path, String str, String str2, FileAttribute<?>... fileAttributeArr) {
        return (Path) Uncheck.apply(new FilesUncheck$$ExternalSyntheticLambda30(), path, str, str2, fileAttributeArr);
    }

    public static Path createTempFile(String str, String str2, FileAttribute<?>... fileAttributeArr) {
        return (Path) Uncheck.apply(new FilesUncheck$$ExternalSyntheticLambda16(), str, str2, fileAttributeArr);
    }

    public static void delete(Path path) {
        Uncheck.accept(new FilesUncheck$$ExternalSyntheticLambda23(), path);
    }

    public static boolean deleteIfExists(Path path) {
        return ((Boolean) Uncheck.apply(new FilesUncheck$$ExternalSyntheticLambda40(), path)).booleanValue();
    }

    public static Stream<Path> find(Path path, int i, BiPredicate<Path, BasicFileAttributes> biPredicate, FileVisitOption... fileVisitOptionArr) {
        return (Stream) Uncheck.apply(new FilesUncheck$$ExternalSyntheticLambda18(), path, Integer.valueOf(i), biPredicate, fileVisitOptionArr);
    }

    public static Object getAttribute(Path path, String str, LinkOption... linkOptionArr) {
        return Uncheck.apply(new FilesUncheck$$ExternalSyntheticLambda7(), path, str, linkOptionArr);
    }

    public static FileStore getFileStore(Path path) {
        return (FileStore) Uncheck.apply(new FilesUncheck$$ExternalSyntheticLambda44(), path);
    }

    public static FileTime getLastModifiedTime(Path path, LinkOption... linkOptionArr) {
        return (FileTime) Uncheck.apply(new FilesUncheck$$ExternalSyntheticLambda49(), path, linkOptionArr);
    }

    public static UserPrincipal getOwner(Path path, LinkOption... linkOptionArr) {
        return (UserPrincipal) Uncheck.apply(new FilesUncheck$$ExternalSyntheticLambda21(), path, linkOptionArr);
    }

    public static Set<PosixFilePermission> getPosixFilePermissions(Path path, LinkOption... linkOptionArr) {
        return (Set) Uncheck.apply(new FilesUncheck$$ExternalSyntheticLambda14(), path, linkOptionArr);
    }

    public static boolean isHidden(Path path) {
        return ((Boolean) Uncheck.apply(new FilesUncheck$$ExternalSyntheticLambda38(), path)).booleanValue();
    }

    public static boolean isSameFile(Path path, Path path2) {
        return ((Boolean) Uncheck.apply(new FilesUncheck$$ExternalSyntheticLambda47(), path, path2)).booleanValue();
    }

    public static Stream<String> lines(Path path) {
        return (Stream) Uncheck.apply(new FilesUncheck$$ExternalSyntheticLambda45(), path);
    }

    public static Stream<String> lines(Path path, Charset charset) {
        return (Stream) Uncheck.apply(new FilesUncheck$$ExternalSyntheticLambda31(), path, charset);
    }

    public static Stream<Path> list(Path path) {
        return (Stream) Uncheck.apply(new FilesUncheck$$ExternalSyntheticLambda4(), path);
    }

    public static Path move(Path path, Path path2, CopyOption... copyOptionArr) {
        return (Path) Uncheck.apply(new FilesUncheck$$ExternalSyntheticLambda9(), path, path2, copyOptionArr);
    }

    public static BufferedReader newBufferedReader(Path path) {
        return (BufferedReader) Uncheck.apply(new FilesUncheck$$ExternalSyntheticLambda24(), path);
    }

    public static BufferedReader newBufferedReader(Path path, Charset charset) {
        return (BufferedReader) Uncheck.apply(new FilesUncheck$$ExternalSyntheticLambda10(), path, charset);
    }

    public static BufferedWriter newBufferedWriter(Path path, Charset charset, OpenOption... openOptionArr) {
        return (BufferedWriter) Uncheck.apply(new FilesUncheck$$ExternalSyntheticLambda17(), path, charset, openOptionArr);
    }

    public static BufferedWriter newBufferedWriter(Path path, OpenOption... openOptionArr) {
        return (BufferedWriter) Uncheck.apply(new FilesUncheck$$ExternalSyntheticLambda50(), path, openOptionArr);
    }

    public static SeekableByteChannel newByteChannel(Path path, OpenOption... openOptionArr) {
        return (SeekableByteChannel) Uncheck.apply(new FilesUncheck$$ExternalSyntheticLambda32(), path, openOptionArr);
    }

    public static SeekableByteChannel newByteChannel(Path path, Set<? extends OpenOption> set, FileAttribute<?>... fileAttributeArr) {
        return (SeekableByteChannel) Uncheck.apply(new FilesUncheck$$ExternalSyntheticLambda35(), path, set, fileAttributeArr);
    }

    public static DirectoryStream<Path> newDirectoryStream(Path path) {
        return (DirectoryStream) Uncheck.apply(new FilesUncheck$$ExternalSyntheticLambda48(), path);
    }

    public static DirectoryStream<Path> newDirectoryStream(Path path, DirectoryStream.Filter<? super Path> filter) {
        return (DirectoryStream) Uncheck.apply(new FilesUncheck$$ExternalSyntheticLambda13(), path, filter);
    }

    public static DirectoryStream<Path> newDirectoryStream(Path path, String str) {
        return (DirectoryStream) Uncheck.apply(new FilesUncheck$$ExternalSyntheticLambda19(), path, str);
    }

    public static InputStream newInputStream(Path path, OpenOption... openOptionArr) {
        return (InputStream) Uncheck.apply(new FilesUncheck$$ExternalSyntheticLambda42(), path, openOptionArr);
    }

    public static OutputStream newOutputStream(Path path, OpenOption... openOptionArr) {
        return (OutputStream) Uncheck.apply(new FilesUncheck$$ExternalSyntheticLambda51(), path, openOptionArr);
    }

    public static String probeContentType(Path path) {
        return (String) Uncheck.apply(new FilesUncheck$$ExternalSyntheticLambda29(), path);
    }

    public static byte[] readAllBytes(Path path) {
        return (byte[]) Uncheck.apply(new FilesUncheck$$ExternalSyntheticLambda6(), path);
    }

    public static List<String> readAllLines(Path path) {
        return (List) Uncheck.apply(new FilesUncheck$$ExternalSyntheticLambda11(), path);
    }

    public static List<String> readAllLines(Path path, Charset charset) {
        return (List) Uncheck.apply(new FilesUncheck$$ExternalSyntheticLambda27(), path, charset);
    }

    public static <A extends BasicFileAttributes> A readAttributes(Path path, Class<A> cls, LinkOption... linkOptionArr) {
        return (A) Uncheck.apply(new FilesUncheck$$ExternalSyntheticLambda12(), path, cls, linkOptionArr);
    }

    public static Map<String, Object> readAttributes(Path path, String str, LinkOption... linkOptionArr) {
        return (Map) Uncheck.apply(new FilesUncheck$$ExternalSyntheticLambda52(), path, str, linkOptionArr);
    }

    public static Path readSymbolicLink(Path path) {
        return (Path) Uncheck.apply(new FilesUncheck$$ExternalSyntheticLambda26(), path);
    }

    public static Path setAttribute(Path path, String str, Object obj, LinkOption... linkOptionArr) {
        return (Path) Uncheck.apply(new FilesUncheck$$ExternalSyntheticLambda25(), path, str, obj, linkOptionArr);
    }

    public static Path setLastModifiedTime(Path path, FileTime fileTime) {
        return (Path) Uncheck.apply(new FilesUncheck$$ExternalSyntheticLambda20(), path, fileTime);
    }

    public static Path setOwner(Path path, UserPrincipal userPrincipal) {
        return (Path) Uncheck.apply(new FilesUncheck$$ExternalSyntheticLambda0(), path, userPrincipal);
    }

    public static Path setPosixFilePermissions(Path path, Set<PosixFilePermission> set) {
        return (Path) Uncheck.apply(new FilesUncheck$$ExternalSyntheticLambda36(), path, set);
    }

    public static long size(Path path) {
        return ((Long) Uncheck.apply(new FilesUncheck$$ExternalSyntheticLambda15(), path)).longValue();
    }

    public static Stream<Path> walk(Path path, FileVisitOption... fileVisitOptionArr) {
        return (Stream) Uncheck.apply(new FilesUncheck$$ExternalSyntheticLambda43(), path, fileVisitOptionArr);
    }

    public static Stream<Path> walk(Path path, int i, FileVisitOption... fileVisitOptionArr) {
        return (Stream) Uncheck.apply(new FilesUncheck$$ExternalSyntheticLambda5(), path, Integer.valueOf(i), fileVisitOptionArr);
    }

    public static Path walkFileTree(Path path, FileVisitor<? super Path> fileVisitor) {
        return (Path) Uncheck.apply(new FilesUncheck$$ExternalSyntheticLambda53(), path, fileVisitor);
    }

    public static Path walkFileTree(Path path, Set<FileVisitOption> set, int i, FileVisitor<? super Path> fileVisitor) {
        return (Path) Uncheck.apply(new FilesUncheck$$ExternalSyntheticLambda41(), path, set, Integer.valueOf(i), fileVisitor);
    }

    public static Path write(Path path, byte[] bArr, OpenOption... openOptionArr) {
        return (Path) Uncheck.apply(new FilesUncheck$$ExternalSyntheticLambda1(), path, bArr, openOptionArr);
    }

    public static Path write(Path path, Iterable<? extends CharSequence> iterable, Charset charset, OpenOption... openOptionArr) {
        return (Path) Uncheck.apply(new FilesUncheck$$ExternalSyntheticLambda28(), path, iterable, charset, openOptionArr);
    }

    public static Path write(Path path, Iterable<? extends CharSequence> iterable, OpenOption... openOptionArr) {
        return (Path) Uncheck.apply(new FilesUncheck$$ExternalSyntheticLambda34(), path, iterable, openOptionArr);
    }

    private FilesUncheck() {
    }
}
