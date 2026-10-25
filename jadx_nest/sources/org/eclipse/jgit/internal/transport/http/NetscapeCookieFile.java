package org.eclipse.jgit.internal.transport.http;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.StringReader;
import java.io.Writer;
import java.net.HttpCookie;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.text.MessageFormat;
import java.time.Instant;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.eclipse.jgit.annotations.Nullable;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.internal.storage.file.FileSnapshot;
import org.eclipse.jgit.internal.storage.file.LockFile;
import org.eclipse.jgit.lib.BranchConfig;
import org.eclipse.jgit.lib.Constants;
import org.eclipse.jgit.util.FileUtils;
import org.eclipse.jgit.util.IO;
import org.eclipse.jgit.util.RawParseUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: loaded from: classes5.dex */
public final class NetscapeCookieFile {
    private static final String COLUMN_SEPARATOR = "\t";
    private static final String HTTP_ONLY_PREAMBLE = "#HttpOnly_";
    private static final String LINE_SEPARATOR = "\n";
    private static final int LOCK_ACQUIRE_MAX_RETRY_COUNT = 4;
    private static final int LOCK_ACQUIRE_RETRY_SLEEP = 500;
    private static final Logger LOG = LoggerFactory.getLogger((Class<?>) NetscapeCookieFile.class);
    private Set<HttpCookie> cookies;
    private final Instant createdAt;
    private byte[] hash;
    private final Path path;
    private FileSnapshot snapshot;

    public NetscapeCookieFile(Path path) {
        this(path, Instant.now());
    }

    NetscapeCookieFile(Path path, Instant instant) {
        this.cookies = null;
        this.path = path;
        this.snapshot = FileSnapshot.DIRTY;
        this.createdAt = instant;
    }

    public Path getPath() {
        return this.path;
    }

    public Set<HttpCookie> getCookies(boolean z) {
        if (this.cookies == null || z) {
            try {
                Set<HttpCookie> cookieFile = parseCookieFile(getFileContentIfModified(), this.createdAt);
                Set<HttpCookie> set = this.cookies;
                if (set != null) {
                    this.cookies = mergeCookies(cookieFile, set);
                } else {
                    this.cookies = cookieFile;
                }
                return this.cookies;
            } catch (IOException | IllegalArgumentException e) {
                LOG.warn(MessageFormat.format(JGitText.get().couldNotReadCookieFile, this.path), e);
                if (this.cookies == null) {
                    this.cookies = new LinkedHashSet();
                }
            }
        }
        return this.cookies;
    }

    private static Set<HttpCookie> parseCookieFile(byte[] bArr, Instant instant) throws IOException, IllegalArgumentException {
        String strDecode = RawParseUtils.decode(StandardCharsets.US_ASCII, bArr);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Throwable th = null;
        try {
            BufferedReader bufferedReader = new BufferedReader(new StringReader(strDecode));
            while (true) {
                try {
                    String line = bufferedReader.readLine();
                    if (line != null) {
                        HttpCookie line2 = parseLine(line, instant);
                        if (line2 != null) {
                            linkedHashSet.add(line2);
                        }
                    } else {
                        bufferedReader.close();
                        return linkedHashSet;
                    }
                } catch (Throwable th2) {
                    bufferedReader.close();
                    throw th2;
                }
            }
        } catch (Throwable th3) {
            if (0 == 0) {
                throw th3;
            }
            if (null != th3) {
                th.addSuppressed(th3);
            }
            throw null;
        }
    }

    private static HttpCookie parseLine(String str, Instant instant) {
        if (str.isEmpty() || (str.startsWith("#") && !str.startsWith(HTTP_ONLY_PREAMBLE))) {
            return null;
        }
        String[] strArrSplit = str.split(COLUMN_SEPARATOR, 7);
        if (strArrSplit == null) {
            throw new IllegalArgumentException(MessageFormat.format(JGitText.get().couldNotFindTabInLine, str));
        }
        if (strArrSplit.length < 7) {
            throw new IllegalArgumentException(MessageFormat.format(JGitText.get().couldNotFindSixTabsInLine, Integer.valueOf(strArrSplit.length), str));
        }
        HttpCookie httpCookie = new HttpCookie(strArrSplit[5], strArrSplit[6]);
        String strSubstring = strArrSplit[0];
        if (strSubstring.startsWith(HTTP_ONLY_PREAMBLE)) {
            httpCookie.setHttpOnly(true);
            strSubstring = strSubstring.substring(HTTP_ONLY_PREAMBLE.length());
        }
        if (strSubstring.startsWith(BranchConfig.LOCAL_REPOSITORY)) {
            strSubstring = strSubstring.substring(1);
        }
        httpCookie.setDomain(strSubstring);
        httpCookie.setPath(strArrSplit[2]);
        httpCookie.setSecure(Boolean.parseBoolean(strArrSplit[3]));
        long seconds = Long.parseLong(strArrSplit[4]);
        if (strArrSplit[4].length() == 13) {
            seconds = TimeUnit.MILLISECONDS.toSeconds(seconds);
        }
        long epochSecond = seconds - instant.getEpochSecond();
        if (epochSecond <= 0) {
            return null;
        }
        httpCookie.setMaxAge(epochSecond);
        return httpCookie;
    }

    private byte[] getFileContentIfModified() throws IOException {
        File file = getPath().toFile();
        int i = 0;
        if (!file.exists()) {
            LOG.warn(MessageFormat.format(JGitText.get().missingCookieFile, file.getAbsolutePath()));
            return new byte[0];
        }
        while (true) {
            FileSnapshot fileSnapshot = this.snapshot;
            FileSnapshot fileSnapshotSave = FileSnapshot.save(file);
            try {
                byte[] fully = IO.readFully(file);
                byte[] bArrHash = hash(fully);
                if (Arrays.equals(this.hash, bArrHash)) {
                    if (fileSnapshot.equals(fileSnapshotSave)) {
                        fileSnapshot.setClean(fileSnapshotSave);
                    } else {
                        this.snapshot = fileSnapshotSave;
                    }
                } else {
                    this.snapshot = fileSnapshotSave;
                    this.hash = bArrHash;
                }
                return fully;
            } catch (FileNotFoundException e) {
                throw e;
            } catch (IOException e2) {
                if (FileUtils.isStaleFileHandle(e2) && i < 5) {
                    Logger logger = LOG;
                    if (logger.isDebugEnabled()) {
                        logger.debug(MessageFormat.format(JGitText.get().configHandleIsStale, Integer.valueOf(i)), (Throwable) e2);
                    }
                    i++;
                } else {
                    throw new IOException(MessageFormat.format(JGitText.get().cannotReadFile, getPath()), e2);
                }
            }
        }
        throw new IOException(MessageFormat.format(JGitText.get().cannotReadFile, getPath()), e2);
    }

    private static byte[] hash(byte[] bArr) {
        return Constants.newMessageDigest().digest(bArr);
    }

    public void write(URL url) throws InterruptedException, IOException {
        try {
            byte[] fileContentIfModified = getFileContentIfModified();
            if (fileContentIfModified != null) {
                LOG.debug("Reading the underlying cookie file '{}' as it has been modified since the last access", this.path);
                this.cookies = mergeCookies(parseCookieFile(fileContentIfModified, this.createdAt), this.cookies);
            }
        } catch (FileNotFoundException unused) {
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        Throwable th = null;
        try {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(byteArrayOutputStream, StandardCharsets.US_ASCII);
            try {
                write(outputStreamWriter, this.cookies, url, this.createdAt);
                outputStreamWriter.close();
                LockFile lockFile = new LockFile(this.path.toFile());
                for (int i = 0; i < 4; i++) {
                    if (lockFile.lock()) {
                        try {
                            lockFile.setNeedSnapshot(true);
                            lockFile.write(byteArrayOutputStream.toByteArray());
                            if (lockFile.commit()) {
                                return;
                            } else {
                                throw new IOException(MessageFormat.format(JGitText.get().cannotCommitWriteTo, this.path));
                            }
                        } finally {
                            lockFile.unlock();
                        }
                    }
                    Thread.sleep(500L);
                }
                throw new IOException(MessageFormat.format(JGitText.get().cannotLock, lockFile));
            } catch (Throwable th2) {
                outputStreamWriter.close();
                throw th2;
            }
        } catch (Throwable th3) {
            if (0 == 0) {
                throw th3;
            }
            if (null != th3) {
                th.addSuppressed(th3);
            }
            throw null;
        }
    }

    static void write(Writer writer, Collection<HttpCookie> collection, URL url, Instant instant) throws IOException {
        Iterator<HttpCookie> it = collection.iterator();
        while (it.hasNext()) {
            writeCookie(writer, it.next(), url, instant);
        }
    }

    private static void writeCookie(Writer writer, HttpCookie httpCookie, URL url, Instant instant) throws IOException {
        String str;
        String str2;
        if (httpCookie.getMaxAge() <= 0) {
            return;
        }
        if (!httpCookie.isHttpOnly()) {
            str = "";
        } else {
            str = HTTP_ONLY_PREAMBLE;
        }
        if (httpCookie.getDomain() != null) {
            str2 = str + httpCookie.getDomain();
        } else {
            str2 = str + url.getHost();
        }
        writer.write(str2);
        writer.write(COLUMN_SEPARATOR);
        writer.write("TRUE");
        writer.write(COLUMN_SEPARATOR);
        String path = httpCookie.getPath();
        if (path == null) {
            path = url.getPath();
        }
        writer.write(path);
        writer.write(COLUMN_SEPARATOR);
        writer.write(Boolean.toString(httpCookie.getSecure()).toUpperCase());
        writer.write(COLUMN_SEPARATOR);
        writer.write(String.valueOf(instant.getEpochSecond() + httpCookie.getMaxAge()));
        writer.write(COLUMN_SEPARATOR);
        writer.write(httpCookie.getName());
        writer.write(COLUMN_SEPARATOR);
        writer.write(httpCookie.getValue());
        writer.write(LINE_SEPARATOR);
    }

    static Set<HttpCookie> mergeCookies(Set<HttpCookie> set, @Nullable Set<HttpCookie> set2) {
        LinkedHashSet linkedHashSet = new LinkedHashSet(set);
        if (set2 != null) {
            linkedHashSet.addAll(set2);
        }
        return linkedHashSet;
    }
}
