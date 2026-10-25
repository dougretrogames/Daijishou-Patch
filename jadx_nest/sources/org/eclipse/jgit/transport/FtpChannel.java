package org.eclipse.jgit.transport;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collection;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes5.dex */
public interface FtpChannel {

    public interface DirEntry {
        String getFilename();

        long getModifiedTime();

        boolean isDirectory();
    }

    void cd(String str) throws IOException;

    void connect(int i, TimeUnit timeUnit) throws IOException;

    void disconnect();

    InputStream get(String str) throws IOException;

    boolean isConnected();

    Collection<DirEntry> ls(String str) throws IOException;

    void mkdir(String str) throws IOException;

    OutputStream put(String str) throws IOException;

    String pwd() throws IOException;

    void rename(String str, String str2) throws IOException;

    void rm(String str) throws IOException;

    void rmdir(String str) throws IOException;

    public static class FtpException extends IOException {
        public static final int EOF = 1;
        public static final int NO_PERMISSION = 3;
        public static final int NO_SUCH_FILE = 2;
        public static final int OK = 0;
        public static final int PROTOCOL_ERROR = 5;
        public static final int UNSPECIFIED_FAILURE = 4;
        public static final int UNSUPPORTED = 8;
        private static final long serialVersionUID = 7176525179280330876L;
        private final int status;

        public FtpException(String str, int i) {
            super(str);
            this.status = i;
        }

        public FtpException(String str, int i, Throwable th) {
            super(str, th);
            this.status = i;
        }

        public int getStatus() {
            return this.status;
        }
    }

    default void delete(String str) throws IOException {
        try {
            rm(str);
        } catch (FileNotFoundException unused) {
        } catch (FtpException e) {
            if (e.getStatus() != 2) {
                throw e;
            }
        }
    }
}
