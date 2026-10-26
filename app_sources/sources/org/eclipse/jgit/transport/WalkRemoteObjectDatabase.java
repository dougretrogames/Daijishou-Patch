package org.eclipse.jgit.transport;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import net.lingala.zip4j.util.InternalZipConstants;
import org.eclipse.jgit.errors.TransportException;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.internal.storage.file.RefDirectory;
import org.eclipse.jgit.lib.Constants;
import org.eclipse.jgit.lib.ObjectId;
import org.eclipse.jgit.lib.ObjectIdRef;
import org.eclipse.jgit.lib.ProgressMonitor;
import org.eclipse.jgit.lib.Ref;
import org.eclipse.jgit.util.IO;

/* INFO: loaded from: classes5.dex */
abstract class WalkRemoteObjectDatabase {
    static final String INFO_PACKS = "info/packs";
    static final String INFO_REFS = "../info/refs";
    static final String ROOT_DIR = "../";

    abstract void close();

    abstract Collection<WalkRemoteObjectDatabase> getAlternates() throws IOException;

    abstract Collection<String> getPackNames() throws IOException;

    abstract URIish getURI();

    abstract FileStream open(String str) throws IOException;

    abstract WalkRemoteObjectDatabase openAlternate(String str) throws IOException;

    WalkRemoteObjectDatabase() {
    }

    void deleteFile(String str) throws IOException {
        throw new IOException(MessageFormat.format(JGitText.get().deletingNotSupported, str));
    }

    OutputStream writeFile(String str, ProgressMonitor progressMonitor, String str2) throws IOException {
        throw new IOException(MessageFormat.format(JGitText.get().writingNotSupported, str));
    }

    void writeFile(String str, byte[] bArr) throws IOException {
        Throwable th = null;
        try {
            OutputStream outputStreamWriteFile = writeFile(str, null, null);
            try {
                outputStreamWriteFile.write(bArr);
            } finally {
                if (outputStreamWriteFile != null) {
                    outputStreamWriteFile.close();
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

    void deleteRef(String str) throws IOException {
        deleteFile(ROOT_DIR + str);
    }

    void deleteRefLog(String str) throws IOException {
        deleteFile("../logs/" + str);
    }

    void writeRef(String str, ObjectId objectId) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(41);
        objectId.copyTo(byteArrayOutputStream);
        byteArrayOutputStream.write(10);
        writeFile(ROOT_DIR + str, byteArrayOutputStream.toByteArray());
    }

    void writeInfoPacks(Collection<String> collection) throws IOException {
        StringBuilder sb = new StringBuilder();
        for (String str : collection) {
            sb.append("P ");
            sb.append(str);
            sb.append('\n');
        }
        writeFile(INFO_PACKS, Constants.encodeASCII(sb.toString()));
    }

    BufferedReader openReader(String str) throws IOException {
        return new BufferedReader(new InputStreamReader(open(str).in, StandardCharsets.UTF_8));
    }

    Collection<WalkRemoteObjectDatabase> readAlternates(String str) throws IOException {
        Throwable th = null;
        try {
            BufferedReader bufferedReaderOpenReader = openReader(str);
            try {
                ArrayList arrayList = new ArrayList();
                while (true) {
                    String line = bufferedReaderOpenReader.readLine();
                    if (line != null) {
                        if (!line.endsWith(InternalZipConstants.ZIP_FILE_SEPARATOR)) {
                            line = line + InternalZipConstants.ZIP_FILE_SEPARATOR;
                        }
                        arrayList.add(openAlternate(line));
                    }
                }
                return arrayList;
            } finally {
                if (bufferedReaderOpenReader != null) {
                    bufferedReaderOpenReader.close();
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

    protected void readPackedRefs(Map<String, Ref> map) throws TransportException {
        Throwable th = null;
        try {
            BufferedReader bufferedReaderOpenReader = openReader("../packed-refs");
            try {
                readPackedRefsImpl(map, bufferedReaderOpenReader);
            } finally {
                if (bufferedReaderOpenReader != null) {
                    bufferedReaderOpenReader.close();
                }
            }
        } catch (Throwable th2) {
            if (0 == 0) {
                throw th2;
            }
            if (null != th2) {
                try {
                    th.addSuppressed(th2);
                } catch (FileNotFoundException unused) {
                    return;
                } catch (IOException e) {
                    throw new TransportException(getURI(), JGitText.get().errorInPackedRefs, e);
                }
            }
            throw null;
        }
    }

    private void readPackedRefsImpl(Map<String, Ref> map, BufferedReader bufferedReader) throws IOException {
        Ref unpeeled;
        Ref ref = null;
        boolean zContains = false;
        while (true) {
            String line = bufferedReader.readLine();
            if (line == null) {
                return;
            }
            if (line.charAt(0) == '#') {
                if (line.startsWith(RefDirectory.PACKED_REFS_HEADER)) {
                    zContains = line.substring(RefDirectory.PACKED_REFS_HEADER.length()).contains(RefDirectory.PACKED_REFS_PEELED);
                }
            } else if (line.charAt(0) != '^') {
                int iIndexOf = line.indexOf(32);
                if (iIndexOf < 0) {
                    throw new TransportException(MessageFormat.format(JGitText.get().unrecognizedRef, line));
                }
                ObjectId objectIdFromString = ObjectId.fromString(line.substring(0, iIndexOf));
                String strSubstring = line.substring(iIndexOf + 1);
                if (zContains) {
                    unpeeled = new ObjectIdRef.PeeledNonTag(Ref.Storage.PACKED, strSubstring, objectIdFromString);
                } else {
                    unpeeled = new ObjectIdRef.Unpeeled(Ref.Storage.PACKED, strSubstring, objectIdFromString);
                }
                ref = unpeeled;
                map.put(ref.getName(), ref);
            } else {
                if (ref == null) {
                    throw new TransportException(JGitText.get().peeledLineBeforeRef);
                }
                ObjectIdRef.PeeledTag peeledTag = new ObjectIdRef.PeeledTag(Ref.Storage.PACKED, ref.getName(), ref.getObjectId(), ObjectId.fromString(line.substring(1)));
                map.put(peeledTag.getName(), peeledTag);
                ref = peeledTag;
            }
        }
    }

    static final class FileStream {
        final InputStream in;
        final long length;

        FileStream(InputStream inputStream) {
            this.in = inputStream;
            this.length = -1L;
        }

        FileStream(InputStream inputStream, long j) {
            this.in = inputStream;
            this.length = j;
        }

        byte[] toArray() throws IOException {
            try {
                long j = this.length;
                if (j >= 0) {
                    int i = (int) j;
                    byte[] bArr = new byte[i];
                    IO.readFully(this.in, bArr, 0, i);
                    return bArr;
                }
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                byte[] bArr2 = new byte[2048];
                while (true) {
                    int i2 = this.in.read(bArr2);
                    if (i2 >= 0) {
                        byteArrayOutputStream.write(bArr2, 0, i2);
                    } else {
                        return byteArrayOutputStream.toByteArray();
                    }
                }
            } finally {
                this.in.close();
            }
        }
    }
}
