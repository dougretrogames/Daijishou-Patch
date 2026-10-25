package org.eclipse.jgit.util.io;

import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes5.dex */
public class StreamCopyThread extends Thread {
    private static final int BUFFER_SIZE = 1024;
    private volatile boolean done;
    private final OutputStream dst;
    private final InputStream src;
    private final Object writeLock;

    public StreamCopyThread(InputStream inputStream, OutputStream outputStream) {
        setName(Thread.currentThread().getName() + "-StreamCopy");
        this.src = inputStream;
        this.dst = outputStream;
        this.writeLock = new Object();
    }

    public void halt() throws InterruptedException {
        while (true) {
            join(250L);
            if (!isAlive()) {
                return;
            }
            this.done = true;
            interrupt();
        }
    }

    /* JADX WARN: Code duplicated, block: B:22:0x002d A[Catch: IOException -> 0x0045, all -> 0x0050, TRY_ENTER, TryCatch #1 {all -> 0x0050, blocks: (B:3:0x0002, B:6:0x0008, B:7:0x000a, B:15:0x001e, B:16:0x001f, B:19:0x0024, B:22:0x002d, B:23:0x002f, B:31:0x0042), top: B:47:0x0002 }] */
    /* JADX WARN: Code duplicated, block: B:26:0x003b A[Catch: all -> 0x0040, TryCatch #0 {, blocks: (B:24:0x0030, B:26:0x003b, B:27:0x003e), top: B:45:0x0030 }] */
    /* JADX WARN: Code duplicated, block: B:45:0x0030 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:53:0x0024 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        int i;
        boolean zInterrupted;
        try {
            byte[] bArr = new byte[1024];
            boolean z = false;
            while (true) {
                if (z) {
                    try {
                        synchronized (this.writeLock) {
                            boolean zInterrupted2 = Thread.interrupted();
                            this.dst.flush();
                            if (zInterrupted2) {
                                interrupt();
                            }
                        }
                        z = false;
                        if (!this.done) {
                            break;
                        }
                        try {
                            i = this.src.read(bArr);
                            if (i >= 0) {
                                break;
                            }
                            synchronized (this.writeLock) {
                                zInterrupted = Thread.interrupted();
                                this.dst.write(bArr, 0, i);
                                if (zInterrupted) {
                                    interrupt();
                                }
                            }
                        } catch (InterruptedIOException unused) {
                            z = true;
                        }
                    } catch (IOException unused2) {
                        break;
                    }
                } else {
                    if (!this.done) {
                        break;
                    }
                    i = this.src.read(bArr);
                    if (i >= 0) {
                        break;
                    }
                    synchronized (this.writeLock) {
                        zInterrupted = Thread.interrupted();
                        this.dst.write(bArr, 0, i);
                        if (zInterrupted) {
                            interrupt();
                        }
                    }
                }
            }
            try {
                this.src.close();
            } catch (IOException unused3) {
            }
            try {
                this.dst.close();
            } catch (IOException unused4) {
            }
        } catch (Throwable th) {
            try {
                this.src.close();
            } catch (IOException unused5) {
            }
            try {
                this.dst.close();
                throw th;
            } catch (IOException unused6) {
                throw th;
            }
        }
    }
}
