package org.eclipse.jgit.transport;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import org.eclipse.jgit.lib.Constants;
import org.eclipse.jgit.util.RawParseUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* INFO: loaded from: classes5.dex */
public class PacketLineOut {
    private boolean flushOnEnd;
    private final byte[] lenbuffer;
    private final boolean logEnabled;
    private final OutputStream out;
    private boolean usingSideband;
    private static final Logger log = LoggerFactory.getLogger((Class<?>) PacketLineOut.class);
    private static final byte[] hexchar = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102};

    public PacketLineOut(OutputStream outputStream) {
        this(outputStream, true);
    }

    public PacketLineOut(OutputStream outputStream, boolean z) {
        this.out = outputStream;
        this.lenbuffer = new byte[5];
        this.flushOnEnd = true;
        this.logEnabled = z;
    }

    public void setFlushOnEnd(boolean z) {
        this.flushOnEnd = z;
    }

    public boolean isUsingSideband() {
        return this.usingSideband;
    }

    public void setUsingSideband(boolean z) {
        this.usingSideband = z;
    }

    public void writeString(String str) throws IOException {
        writePacket(Constants.encode(str));
    }

    public void writePacket(byte[] bArr) throws IOException {
        writePacket(bArr, 0, bArr.length);
    }

    public void writePacket(byte[] bArr, int i, int i2) throws IOException {
        if (this.usingSideband) {
            formatLength(i2 + 5);
            this.out.write(this.lenbuffer, 0, 4);
            this.out.write(1);
        } else {
            formatLength(i2 + 4);
            this.out.write(this.lenbuffer, 0, 4);
        }
        this.out.write(bArr, i, i2);
        if (this.logEnabled) {
            Logger logger = log;
            if (logger.isDebugEnabled()) {
                if (i2 > 0 && bArr[(i + i2) - 1] == 10) {
                    logger.debug("git> " + RawParseUtils.decode(StandardCharsets.UTF_8, bArr, i, i2 - 1) + "\\n");
                } else {
                    logger.debug("git> " + RawParseUtils.decode(StandardCharsets.UTF_8, bArr, i, i2));
                }
            }
        }
    }

    public void writeDelim() throws IOException {
        formatLength(1);
        this.out.write(this.lenbuffer, 0, 4);
        if (this.logEnabled) {
            Logger logger = log;
            if (logger.isDebugEnabled()) {
                logger.debug("git> 0001");
            }
        }
    }

    public void end() throws IOException {
        formatLength(0);
        this.out.write(this.lenbuffer, 0, 4);
        if (this.logEnabled) {
            Logger logger = log;
            if (logger.isDebugEnabled()) {
                logger.debug("git> 0000");
            }
        }
        if (this.flushOnEnd) {
            flush();
        }
    }

    public void flush() throws IOException {
        this.out.flush();
    }

    private void formatLength(int i) {
        formatLength(this.lenbuffer, i);
    }

    static void formatLength(byte[] bArr, int i) {
        int i2 = 3;
        while (i2 >= 0 && i != 0) {
            bArr[i2] = hexchar[i & 15];
            i >>>= 4;
            i2--;
        }
        while (i2 >= 0) {
            bArr[i2] = 48;
            i2--;
        }
    }
}
