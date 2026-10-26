package org.eclipse.jgit.transport;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.text.MessageFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.http.message.TokenParser;
import org.eclipse.jgit.errors.PackProtocolException;
import org.eclipse.jgit.errors.TransportException;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.lib.ProgressMonitor;
import org.eclipse.jgit.util.IO;
import org.eclipse.jgit.util.RawParseUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* INFO: loaded from: classes5.dex */
public class SideBandInputStream extends InputStream {
    static final int CH_DATA = 1;
    static final int CH_ERROR = 3;
    static final int CH_PROGRESS = 2;
    private int available;
    private int channel;
    private boolean eof;
    private int lastCnt;
    private final Writer messages;
    private final ProgressMonitor monitor;
    private final OutputStream out;
    private final PacketLineIn pckIn;
    private final InputStream rawIn;
    private static final Logger LOG = LoggerFactory.getLogger((Class<?>) SideBandInputStream.class);
    private static Pattern P_UNBOUNDED = Pattern.compile("^([\\w ]+): +(\\d+)(?:, done\\.)? *[\r\n]$");
    private static Pattern P_BOUNDED = Pattern.compile("^([\\w ]+): +\\d+% +\\( *(\\d+)/ *(\\d+)\\)(?:, done\\.)? *[\r\n]$");
    private String progressBuffer = "";
    private String currentTask = "";

    SideBandInputStream(InputStream inputStream, ProgressMonitor progressMonitor, Writer writer, OutputStream outputStream) {
        this.rawIn = inputStream;
        this.pckIn = new PacketLineIn(inputStream);
        this.monitor = progressMonitor;
        this.messages = writer;
        this.out = outputStream;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        needDataPacket();
        if (this.eof) {
            return -1;
        }
        this.available--;
        return this.rawIn.read();
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        int i3;
        int i4 = 0;
        while (i2 > 0) {
            needDataPacket();
            if (this.eof || (i3 = this.rawIn.read(bArr, i, Math.min(i2, this.available))) < 0) {
                break;
            }
            i4 += i3;
            i += i3;
            i2 -= i3;
            this.available -= i3;
        }
        if (this.eof && i4 == 0) {
            return -1;
        }
        return i4;
    }

    private void needDataPacket() throws IOException {
        if (this.eof) {
            return;
        }
        if (this.channel == 1 && this.available > 0) {
            return;
        }
        while (true) {
            int length = this.pckIn.readLength();
            this.available = length;
            if (length == 0) {
                this.eof = true;
                return;
            }
            int i = this.rawIn.read() & 255;
            this.channel = i;
            int i2 = this.available - 5;
            this.available = i2;
            if (i2 != 0) {
                if (i == 1) {
                    return;
                }
                if (i != 2) {
                    if (i == 3) {
                        this.eof = true;
                        throw new TransportException(remote(readString(this.available)));
                    }
                    throw new PackProtocolException(MessageFormat.format(JGitText.get().invalidChannel, Integer.valueOf(this.channel)));
                }
                progress(readString(i2));
            }
        }
    }

    private void progress(String str) throws IOException {
        String strSubstring = this.progressBuffer + str;
        while (true) {
            int iIndexOf = strSubstring.indexOf(10);
            int iIndexOf2 = strSubstring.indexOf(13);
            if (iIndexOf >= 0 && iIndexOf2 >= 0) {
                iIndexOf = Math.min(iIndexOf, iIndexOf2);
            } else if (iIndexOf >= 0) {
                continue;
            } else {
                if (iIndexOf2 < 0) {
                    this.progressBuffer = strSubstring;
                    return;
                }
                iIndexOf = iIndexOf2;
            }
            int i = iIndexOf + 1;
            doProgressLine(strSubstring.substring(0, i));
            strSubstring = strSubstring.substring(i);
        }
    }

    private void doProgressLine(String str) throws IOException {
        Matcher matcher = P_BOUNDED.matcher(str);
        if (matcher.matches()) {
            String strGroup = matcher.group(1);
            if (!this.currentTask.equals(strGroup)) {
                this.currentTask = strGroup;
                this.lastCnt = 0;
                beginTask(Integer.parseInt(matcher.group(3)));
            }
            int i = Integer.parseInt(matcher.group(2));
            this.monitor.update(i - this.lastCnt);
            this.lastCnt = i;
            return;
        }
        Matcher matcher2 = P_UNBOUNDED.matcher(str);
        if (matcher2.matches()) {
            String strGroup2 = matcher2.group(1);
            if (!this.currentTask.equals(strGroup2)) {
                this.currentTask = strGroup2;
                this.lastCnt = 0;
                beginTask(0);
            }
            int i2 = Integer.parseInt(matcher2.group(2));
            this.monitor.update(i2 - this.lastCnt);
            this.lastCnt = i2;
            return;
        }
        this.messages.write(str);
        OutputStream outputStream = this.out;
        if (outputStream != null) {
            outputStream.write(str.getBytes(StandardCharsets.UTF_8));
        }
    }

    private void beginTask(int i) {
        this.monitor.beginTask(remote(this.currentTask), i);
    }

    void drainMessages() {
        if (this.progressBuffer.isEmpty()) {
            return;
        }
        try {
            progress("\n");
        } catch (IOException e) {
            LOG.error(e.getMessage(), (Throwable) e);
        }
    }

    private static String remote(String str) {
        String str2 = JGitText.get().prefixRemote;
        StringBuilder sb = new StringBuilder(str2.length() + str.length() + 1);
        sb.append(str2);
        if (str2.length() > 0 && str2.charAt(str2.length() - 1) != ' ') {
            sb.append(TokenParser.SP);
        }
        sb.append(str);
        return sb.toString();
    }

    private String readString(int i) throws IOException {
        byte[] bArr = new byte[i];
        IO.readFully(this.rawIn, bArr, 0, i);
        return RawParseUtils.decode(StandardCharsets.UTF_8, bArr, 0, i);
    }
}
