package org.eclipse.jgit.transport;

import java.io.IOException;
import java.io.InputStream;
import java.io.UncheckedIOException;
import java.nio.charset.StandardCharsets;
import java.text.MessageFormat;
import java.util.Iterator;
import org.eclipse.jgit.errors.PackProtocolException;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.lib.MutableObjectId;
import org.eclipse.jgit.util.IO;
import org.eclipse.jgit.util.RawParseUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* INFO: loaded from: classes5.dex */
public class PacketLineIn {
    private final InputStream in;
    private long limit;
    private final byte[] lineBuffer;
    private static final Logger log = LoggerFactory.getLogger((Class<?>) PacketLineIn.class);
    private static final String END = new String();
    private static final String DELIM = new String();

    enum AckNackResult {
        NAK,
        ACK,
        ACK_CONTINUE,
        ACK_COMMON,
        ACK_READY;

        /* INFO: renamed from: values, reason: to resolve conflict with enum method */
        public static AckNackResult[] valuesCustom() {
            AckNackResult[] ackNackResultArrValuesCustom = values();
            int length = ackNackResultArrValuesCustom.length;
            AckNackResult[] ackNackResultArr = new AckNackResult[length];
            System.arraycopy(ackNackResultArrValuesCustom, 0, ackNackResultArr, 0, length);
            return ackNackResultArr;
        }
    }

    public static class InputOverLimitIOException extends IOException {
        private static final long serialVersionUID = 1;
    }

    public PacketLineIn(InputStream inputStream) {
        this(inputStream, 0L);
    }

    public PacketLineIn(InputStream inputStream, long j) {
        this.lineBuffer = new byte[1000];
        this.in = inputStream;
        this.limit = j;
    }

    static AckNackResult parseACKv2(String str, MutableObjectId mutableObjectId) throws IOException {
        if ("NAK".equals(str)) {
            return AckNackResult.NAK;
        }
        if (str.startsWith(GitProtocolConstants.PACKET_ACK) && str.length() == 44) {
            mutableObjectId.fromString(str.substring(4, 44));
            return AckNackResult.ACK_COMMON;
        }
        if ("ready".equals(str)) {
            return AckNackResult.ACK_READY;
        }
        if (str.startsWith(GitProtocolConstants.PACKET_ERR)) {
            throw new PackProtocolException(str.substring(4));
        }
        throw new PackProtocolException(MessageFormat.format(JGitText.get().expectedACKNAKGot, str));
    }

    AckNackResult readACK(MutableObjectId mutableObjectId) throws IOException {
        String string = readString();
        if (string.length() == 0) {
            throw new PackProtocolException(JGitText.get().expectedACKNAKFoundEOF);
        }
        if ("NAK".equals(string)) {
            return AckNackResult.NAK;
        }
        if (string.startsWith(GitProtocolConstants.PACKET_ACK)) {
            mutableObjectId.fromString(string.substring(4, 44));
            if (string.length() == 44) {
                return AckNackResult.ACK;
            }
            String strSubstring = string.substring(44);
            int iHashCode = strSubstring.hashCode();
            if (iHashCode != 1024519555) {
                if (iHashCode != 1275499019) {
                    if (iHashCode == 1723796679 && strSubstring.equals(" continue")) {
                        return AckNackResult.ACK_CONTINUE;
                    }
                } else if (strSubstring.equals(" common")) {
                    return AckNackResult.ACK_COMMON;
                }
            } else if (strSubstring.equals(" ready")) {
                return AckNackResult.ACK_READY;
            }
        }
        if (string.startsWith(GitProtocolConstants.PACKET_ERR)) {
            throw new PackProtocolException(string.substring(4));
        }
        throw new PackProtocolException(MessageFormat.format(JGitText.get().expectedACKNAKGot, string));
    }

    public String readString() throws IOException {
        int length = readLength();
        if (length == 0) {
            log.debug("git< 0000");
            return END;
        }
        if (length == 1) {
            log.debug("git< 0001");
            return DELIM;
        }
        int i = length - 4;
        if (i == 0) {
            log.debug("git< ");
            return "";
        }
        byte[] bArr = this.lineBuffer;
        if (i > bArr.length) {
            bArr = new byte[i];
        }
        IO.readFully(this.in, bArr, 0, i);
        if (bArr[length - 5] == 10) {
            i = length - 5;
        }
        String strDecode = RawParseUtils.decode(StandardCharsets.UTF_8, bArr, 0, i);
        log.debug("git< " + strDecode);
        return strDecode;
    }

    public PacketLineInIterator readStrings() throws IOException {
        return new PacketLineInIterator(this);
    }

    public String readStringRaw() throws IOException {
        int length = readLength();
        if (length == 0) {
            log.debug("git< 0000");
            return END;
        }
        int i = length - 4;
        byte[] bArr = this.lineBuffer;
        if (i > bArr.length) {
            bArr = new byte[i];
        }
        IO.readFully(this.in, bArr, 0, i);
        String strDecode = RawParseUtils.decode(StandardCharsets.UTF_8, bArr, 0, i);
        log.debug("git< " + strDecode);
        return strDecode;
    }

    public static boolean isDelimiter(String str) {
        return str == DELIM;
    }

    static String delimiter() {
        return DELIM;
    }

    static String end() {
        return END;
    }

    public static boolean isEnd(String str) {
        return str == END;
    }

    void discardUntilEnd() throws IOException {
        while (true) {
            int length = readLength();
            if (length == 0) {
                return;
            } else {
                IO.skipFully(this.in, length - 4);
            }
        }
    }

    int readLength() throws IOException {
        IO.readFully(this.in, this.lineBuffer, 0, 4);
        try {
            int hexInt16 = RawParseUtils.parseHexInt16(this.lineBuffer, 0);
            if (hexInt16 == 0) {
                return 0;
            }
            if (hexInt16 == 1) {
                return 1;
            }
            if (hexInt16 < 4) {
                throw invalidHeader();
            }
            long j = this.limit;
            if (j == 0) {
                return hexInt16;
            }
            long j2 = hexInt16 - 4;
            if (j < j2) {
                this.limit = -1L;
                try {
                    IO.skipFully(this.in, j2);
                } catch (IOException unused) {
                }
                throw new InputOverLimitIOException();
            }
            this.limit = j2 < j ? j - j2 : -1L;
            return hexInt16;
        } catch (ArrayIndexOutOfBoundsException e) {
            throw invalidHeader(e);
        }
    }

    private IOException invalidHeader() {
        String str = JGitText.get().invalidPacketLineHeader;
        byte[] bArr = this.lineBuffer;
        char c = (char) bArr[0];
        char c2 = (char) bArr[1];
        char c3 = (char) bArr[2];
        return new IOException(MessageFormat.format(str, new StringBuilder().append(c).append(c2).append(c3).append((char) bArr[3]).toString()));
    }

    private IOException invalidHeader(Throwable th) {
        IOException iOExceptionInvalidHeader = invalidHeader();
        iOExceptionInvalidHeader.initCause(th);
        return iOExceptionInvalidHeader;
    }

    public static class PacketLineInIterator implements Iterable<String> {
        private String current;
        private PacketLineIn in;

        PacketLineInIterator(PacketLineIn packetLineIn) throws IOException {
            this.in = packetLineIn;
            this.current = packetLineIn.readString();
        }

        /* INFO: renamed from: org.eclipse.jgit.transport.PacketLineIn$PacketLineInIterator$1, reason: invalid class name */
        class AnonymousClass1 implements Iterator<String> {
            AnonymousClass1() {
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return !PacketLineIn.isEnd(PacketLineInIterator.this.current);
            }

            @Override // java.util.Iterator
            public String next() {
                String str = PacketLineInIterator.this.current;
                try {
                    PacketLineInIterator packetLineInIterator = PacketLineInIterator.this;
                    packetLineInIterator.current = packetLineInIterator.in.readString();
                    return str;
                } catch (IOException e) {
                    throw new UncheckedIOException(e);
                }
            }
        }

        @Override // java.lang.Iterable
        public Iterator<String> iterator() {
            return new AnonymousClass1();
        }
    }
}
