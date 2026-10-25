package org.eclipse.jgit.transport;

import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.eclipse.jgit.errors.PackProtocolException;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.util.IO;

/* JADX INFO: loaded from: classes5.dex */
public class PushCertificateParser {
    static final String BEGIN_SIGNATURE = "-----BEGIN PGP SIGNATURE-----";
    static final String END_CERT = "push-cert-end";
    static final String END_SIGNATURE = "-----END PGP SIGNATURE-----";
    static final String NONCE = "nonce";
    static final String PUSHEE = "pushee";
    static final String PUSHER = "pusher";
    static final String VERSION = "certificate version";
    private static final String VERSION_0_1 = "0.1";
    private final List<ReceiveCommand> commands;
    private final Repository db;
    private final boolean enabled;
    private final NonceGenerator nonceGenerator;
    private final int nonceSlopLimit;
    private PushCertificate.NonceStatus nonceStatus;
    private String pushee;
    private PushCertificateIdent pusher;
    private boolean received;
    private String receivedNonce;
    private String sentNonce;
    private String signature;
    private String version;

    private interface StringReader {
        String read() throws IOException;
    }

    private static class PacketLineReader implements StringReader {
        private final PacketLineIn pckIn;

        /* synthetic */ PacketLineReader(PacketLineIn packetLineIn, PushCertificateParserIA pushCertificateParserIA) {
            this(packetLineIn);
        }

        private PacketLineReader(PacketLineIn packetLineIn) {
            this.pckIn = packetLineIn;
        }

        @Override // org.eclipse.jgit.transport.PushCertificateParser.StringReader
        public String read() throws IOException {
            return this.pckIn.readString();
        }
    }

    private static class StreamReader implements StringReader {
        private final Reader reader;

        /* synthetic */ StreamReader(Reader reader, PushCertificateParserIA pushCertificateParserIA) {
            this(reader);
        }

        private StreamReader(Reader reader) {
            this.reader = reader;
        }

        @Override // org.eclipse.jgit.transport.PushCertificateParser.StringReader
        public String read() throws IOException {
            String line = IO.readLine(this.reader, 146);
            if (line.isEmpty()) {
                throw new EOFException();
            }
            return line.charAt(line.length() + (-1)) == '\n' ? line.substring(0, line.length() - 1) : line;
        }
    }

    public static PushCertificate fromReader(Reader reader) throws IOException {
        return new PushCertificateParser().parse(reader);
    }

    public static PushCertificate fromString(String str) throws IOException {
        return fromReader(new java.io.StringReader(str));
    }

    public PushCertificateParser(Repository repository, SignedPushConfig signedPushConfig) {
        this.commands = new ArrayList();
        if (signedPushConfig != null) {
            this.nonceSlopLimit = signedPushConfig.getCertNonceSlopLimit();
            this.nonceGenerator = signedPushConfig.getNonceGenerator();
        } else {
            this.nonceSlopLimit = 0;
            this.nonceGenerator = null;
        }
        this.db = repository;
        this.enabled = this.nonceGenerator != null;
    }

    private PushCertificateParser() {
        this.commands = new ArrayList();
        this.db = null;
        this.nonceSlopLimit = 0;
        this.nonceGenerator = null;
        this.enabled = true;
    }

    public PushCertificate parse(Reader reader) throws IOException {
        StreamReader streamReader = new StreamReader(reader, null);
        receiveHeader((StringReader) streamReader, true);
        while (true) {
            try {
                String str = streamReader.read();
                if (str.isEmpty()) {
                    break;
                }
                if (str.equals("-----BEGIN PGP SIGNATURE-----")) {
                    receiveSignature(streamReader);
                    break;
                }
                addCommand(str);
            } catch (EOFException unused) {
            }
        }
        return build();
    }

    public PushCertificate build() throws IOException {
        if (!this.received || !this.enabled) {
            return null;
        }
        try {
            return new PushCertificate(this.version, this.pusher, this.pushee, this.receivedNonce, this.nonceStatus, Collections.unmodifiableList(this.commands), this.signature);
        } catch (IllegalArgumentException e) {
            throw new IOException(e.getMessage(), e);
        }
    }

    public boolean enabled() {
        return this.enabled;
    }

    public String getAdvertiseNonce() {
        String strSentNonce = sentNonce();
        if (strSentNonce == null) {
            return null;
        }
        return "push-cert=" + strSentNonce;
    }

    private String sentNonce() {
        NonceGenerator nonceGenerator;
        if (this.sentNonce == null && (nonceGenerator = this.nonceGenerator) != null) {
            this.sentNonce = nonceGenerator.createNonce(this.db, TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis()));
        }
        return this.sentNonce;
    }

    private static String parseHeader(StringReader stringReader, String str) throws IOException {
        return parseHeader(stringReader.read(), str);
    }

    private static String parseHeader(String str, String str2) throws IOException {
        if (str.isEmpty()) {
            throw new EOFException();
        }
        if (str.length() <= str2.length() || !str.startsWith(str2) || str.charAt(str2.length()) != ' ') {
            throw new PackProtocolException(MessageFormat.format(JGitText.get().pushCertificateInvalidField, str2));
        }
        return str.substring(str2.length() + 1);
    }

    public void receiveHeader(PacketLineIn packetLineIn, boolean z) throws IOException {
        receiveHeader(new PacketLineReader(packetLineIn, null), z);
    }

    private void receiveHeader(StringReader stringReader, boolean z) throws IOException {
        PushCertificate.NonceStatus nonceStatusVerify;
        try {
            String header = parseHeader(stringReader, VERSION);
            this.version = header;
            try {
                this.received = true;
                if (!header.equals(VERSION_0_1)) {
                    throw new PackProtocolException(MessageFormat.format(JGitText.get().pushCertificateInvalidFieldValue, VERSION, this.version));
                }
                String header2 = parseHeader(stringReader, PUSHER);
                PushCertificateIdent pushCertificateIdent = PushCertificateIdent.parse(header2);
                this.pusher = pushCertificateIdent;
                if (pushCertificateIdent == null) {
                    throw new PackProtocolException(MessageFormat.format(JGitText.get().pushCertificateInvalidFieldValue, PUSHER, header2));
                }
                String str = stringReader.read();
                if (str.startsWith(PUSHEE)) {
                    this.pushee = parseHeader(str, PUSHEE);
                    this.receivedNonce = parseHeader(stringReader, NONCE);
                } else {
                    this.receivedNonce = parseHeader(str, NONCE);
                }
                NonceGenerator nonceGenerator = this.nonceGenerator;
                if (nonceGenerator != null) {
                    nonceStatusVerify = nonceGenerator.verify(this.receivedNonce, sentNonce(), this.db, z, this.nonceSlopLimit);
                } else {
                    nonceStatusVerify = PushCertificate.NonceStatus.UNSOLICITED;
                }
                this.nonceStatus = nonceStatusVerify;
                if (!stringReader.read().isEmpty()) {
                    throw new PackProtocolException(JGitText.get().pushCertificateInvalidHeader);
                }
            } catch (EOFException e) {
                throw new PackProtocolException(JGitText.get().pushCertificateInvalidHeader, e);
            }
        } catch (EOFException unused) {
        }
    }

    public void receiveSignature(PacketLineIn packetLineIn) throws IOException {
        PacketLineReader packetLineReader = new PacketLineReader(packetLineIn, null);
        receiveSignature(packetLineReader);
        if (!packetLineReader.read().equals(END_CERT)) {
            throw new PackProtocolException(JGitText.get().pushCertificateInvalidSignature);
        }
    }

    private void receiveSignature(StringReader stringReader) throws IOException {
        this.received = true;
        try {
            StringBuilder sbAppend = new StringBuilder("-----BEGIN PGP SIGNATURE-----").append('\n');
            while (true) {
                String str = stringReader.read();
                if (!str.equals(END_SIGNATURE)) {
                    sbAppend.append(str).append('\n');
                } else {
                    this.signature = sbAppend.append(END_SIGNATURE).append('\n').toString();
                    return;
                }
            }
        } catch (EOFException e) {
            throw new PackProtocolException(JGitText.get().pushCertificateInvalidSignature, e);
        }
    }

    public void addCommand(ReceiveCommand receiveCommand) {
        this.commands.add(receiveCommand);
    }

    public void addCommand(String str) throws PackProtocolException {
        this.commands.add(ReceivePack.parseCommand(str));
    }
}
