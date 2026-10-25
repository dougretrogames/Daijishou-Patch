package org.eclipse.jgit.transport;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.MessageFormat;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.http.message.TokenParser;
import org.eclipse.jgit.errors.NoRemoteRepositoryException;
import org.eclipse.jgit.errors.NotSupportedException;
import org.eclipse.jgit.errors.PackProtocolException;
import org.eclipse.jgit.errors.TooLargeObjectInPackException;
import org.eclipse.jgit.errors.TooLargePackException;
import org.eclipse.jgit.errors.TransportException;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.internal.storage.pack.PackWriter;
import org.eclipse.jgit.lib.AnyObjectId;
import org.eclipse.jgit.lib.ObjectId;
import org.eclipse.jgit.lib.ProgressMonitor;
import org.eclipse.jgit.lib.Ref;
import org.eclipse.jgit.util.io.TimeoutInputStream;

/* JADX INFO: loaded from: classes5.dex */
public abstract class BasePackPushConnection extends BasePackConnection implements PushConnection {
    public static final String CAPABILITY_DELETE_REFS = "delete-refs";
    public static final String CAPABILITY_OFS_DELTA = "ofs-delta";
    public static final String CAPABILITY_PUSH_OPTIONS = "push-options";
    public static final String CAPABILITY_REPORT_STATUS = "report-status";
    public static final String CAPABILITY_SIDE_BAND_64K = "side-band-64k";
    private final boolean atomic;
    private boolean capableAtomic;
    private boolean capableDeleteRefs;
    private boolean capableOfsDelta;
    private boolean capablePushOptions;
    private boolean capableReport;
    private boolean capableSideBand;
    private long packTransferTime;
    private List<String> pushOptions;
    private boolean sentCommand;
    private final boolean thinPack;
    private final boolean useBitmaps;
    private boolean writePack;

    @Override // org.eclipse.jgit.transport.BasePackConnection, org.eclipse.jgit.transport.BaseConnection, org.eclipse.jgit.transport.Connection, java.lang.AutoCloseable
    public /* bridge */ /* synthetic */ void close() {
        super.close();
    }

    @Override // org.eclipse.jgit.transport.BasePackConnection, org.eclipse.jgit.transport.BaseConnection, org.eclipse.jgit.transport.Connection
    public /* bridge */ /* synthetic */ String getPeerUserAgent() {
        return super.getPeerUserAgent();
    }

    public BasePackPushConnection(PackTransport packTransport) {
        super(packTransport);
        this.thinPack = this.transport.isPushThin();
        this.atomic = this.transport.isPushAtomic();
        this.pushOptions = this.transport.getPushOptions();
        this.useBitmaps = this.transport.isPushUseBitmaps();
    }

    @Override // org.eclipse.jgit.transport.PushConnection
    public void push(ProgressMonitor progressMonitor, Map<String, RemoteRefUpdate> map) throws TransportException {
        push(progressMonitor, map, null);
    }

    @Override // org.eclipse.jgit.transport.PushConnection
    public void push(ProgressMonitor progressMonitor, Map<String, RemoteRefUpdate> map, OutputStream outputStream) throws TransportException {
        markStartedOperation();
        doPush(progressMonitor, map, outputStream);
    }

    @Override // org.eclipse.jgit.transport.BasePackConnection
    protected TransportException noRepository(Throwable th) {
        TransportException e;
        try {
            this.transport.openFetch().close();
            e = new TransportException(this.uri, JGitText.get().pushNotPermitted);
        } catch (NoRemoteRepositoryException e2) {
            e = e2;
        } catch (NotSupportedException e3) {
            e = e3;
            e = new TransportException(this.uri, JGitText.get().pushNotPermitted, e);
        } catch (TransportException e4) {
            e = e4;
            e = new TransportException(this.uri, JGitText.get().pushNotPermitted, e);
        }
        e.addSuppressed(th);
        return e;
    }

    protected void doPush(ProgressMonitor progressMonitor, Map<String, RemoteRefUpdate> map, OutputStream outputStream) throws TransportException {
        int i;
        try {
            try {
                writeCommands(map.values(), progressMonitor, outputStream);
                if (this.pushOptions != null && this.capablePushOptions) {
                    transmitOptions();
                }
                if (this.writePack) {
                    writePack(map, progressMonitor);
                }
                if (this.sentCommand) {
                    if (this.capableReport) {
                        readStatusReport(map);
                    }
                    if (this.capableSideBand && (i = this.in.read()) >= 0) {
                        throw new TransportException(this.uri, MessageFormat.format(JGitText.get().expectedEOFReceived, Character.valueOf((char) i)));
                    }
                }
                if (this.in instanceof SideBandInputStream) {
                    ((SideBandInputStream) this.in).drainMessages();
                }
                close();
            } catch (TransportException e) {
                throw e;
            } catch (Exception e2) {
                throw new TransportException(this.uri, e2.getMessage(), e2);
            }
        } catch (Throwable th) {
            if (this.in instanceof SideBandInputStream) {
                ((SideBandInputStream) this.in).drainMessages();
            }
            close();
            throw th;
        }
    }

    private void writeCommands(Collection<RemoteRefUpdate> collection, ProgressMonitor progressMonitor, OutputStream outputStream) throws IOException {
        String strEnableCapabilities = enableCapabilities(progressMonitor, outputStream);
        if (this.atomic && !this.capableAtomic) {
            throw new TransportException(this.uri, JGitText.get().atomicPushNotSupported);
        }
        if (this.pushOptions != null && !this.capablePushOptions) {
            throw new TransportException(this.uri, MessageFormat.format(JGitText.get().pushOptionsNotSupported, this.pushOptions.toString()));
        }
        for (RemoteRefUpdate remoteRefUpdate : collection) {
            if (!this.capableDeleteRefs && remoteRefUpdate.isDelete()) {
                remoteRefUpdate.setStatus(RemoteRefUpdate.Status.REJECTED_NODELETE);
            } else {
                StringBuilder sb = new StringBuilder();
                ObjectId expectedOldObjectId = remoteRefUpdate.getExpectedOldObjectId();
                if (expectedOldObjectId == null) {
                    Ref ref = getRef(remoteRefUpdate.getRemoteName());
                    expectedOldObjectId = ref != null ? ref.getObjectId() : null;
                    if (expectedOldObjectId == null) {
                        expectedOldObjectId = ObjectId.zeroId();
                    }
                }
                sb.append(expectedOldObjectId.name());
                sb.append(TokenParser.SP);
                sb.append(remoteRefUpdate.getNewObjectId().name());
                sb.append(TokenParser.SP);
                sb.append(remoteRefUpdate.getRemoteName());
                if (!this.sentCommand) {
                    this.sentCommand = true;
                    sb.append(strEnableCapabilities);
                }
                this.pckOut.writeString(sb.toString());
                remoteRefUpdate.setStatus(RemoteRefUpdate.Status.AWAITING_REPORT);
                if (!remoteRefUpdate.isDelete()) {
                    this.writePack = true;
                }
            }
        }
        if (progressMonitor.isCancelled()) {
            throw new TransportException(this.uri, JGitText.get().pushCancelled);
        }
        this.pckOut.end();
        this.outNeedsEnd = false;
    }

    private void transmitOptions() throws IOException {
        Iterator<String> it = this.pushOptions.iterator();
        while (it.hasNext()) {
            this.pckOut.writeString(it.next());
        }
        this.pckOut.end();
    }

    private String enableCapabilities(ProgressMonitor progressMonitor, OutputStream outputStream) {
        StringBuilder sb = new StringBuilder();
        if (this.atomic) {
            this.capableAtomic = wantCapability(sb, GitProtocolConstants.CAPABILITY_ATOMIC);
        }
        this.capableReport = wantCapability(sb, "report-status");
        this.capableDeleteRefs = wantCapability(sb, "delete-refs");
        this.capableOfsDelta = wantCapability(sb, "ofs-delta");
        if (this.pushOptions != null) {
            this.capablePushOptions = wantCapability(sb, "push-options");
        }
        boolean zWantCapability = wantCapability(sb, "side-band-64k");
        this.capableSideBand = zWantCapability;
        if (zWantCapability) {
            this.in = new SideBandInputStream(this.in, progressMonitor, getMessageWriter(), outputStream);
            this.pckIn = new PacketLineIn(this.in);
        }
        addUserAgentCapability(sb);
        if (sb.length() > 0) {
            sb.setCharAt(0, (char) 0);
        }
        return sb.toString();
    }

    private void writePack(Map<String, RemoteRefUpdate> map, ProgressMonitor progressMonitor) throws IOException {
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        Throwable th = null;
        try {
            PackWriter packWriter = new PackWriter(this.transport.getPackConfig(), this.local.newObjectReader());
            try {
                Iterator<Ref> it = getRefs().iterator();
                while (it.hasNext()) {
                    ObjectId objectId = it.next().getObjectId();
                    if (this.local.getObjectDatabase().has(objectId)) {
                        hashSet.add(objectId);
                    }
                }
                hashSet.addAll(this.additionalHaves);
                for (RemoteRefUpdate remoteRefUpdate : map.values()) {
                    if (!ObjectId.zeroId().equals((AnyObjectId) remoteRefUpdate.getNewObjectId())) {
                        hashSet2.add(remoteRefUpdate.getNewObjectId());
                    }
                }
                packWriter.setIndexDisabled(true);
                packWriter.setUseCachedPacks(true);
                packWriter.setUseBitmaps(this.useBitmaps);
                packWriter.setThin(this.thinPack);
                packWriter.setReuseValidatingObjects(false);
                packWriter.setDeltaBaseAsOffset(this.capableOfsDelta);
                packWriter.preparePack(progressMonitor, hashSet2, hashSet);
                OutputStream checkingSideBandOutputStream = this.out;
                if (this.capableSideBand) {
                    checkingSideBandOutputStream = new CheckingSideBandOutputStream(this.in, this.out);
                }
                packWriter.writePack(progressMonitor, progressMonitor, checkingSideBandOutputStream);
                this.packTransferTime = packWriter.getStatistics().getTimeWriting();
            } finally {
                packWriter.close();
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

    private void readStatusReport(Map<String, RemoteRefUpdate> map) throws IOException {
        boolean z;
        int iIndexOf;
        String stringLongTimeout = readStringLongTimeout();
        if (!stringLongTimeout.startsWith("unpack ")) {
            throw new PackProtocolException(this.uri, MessageFormat.format(JGitText.get().unexpectedReportLine, stringLongTimeout));
        }
        String strSubstring = stringLongTimeout.substring("unpack ".length());
        if (strSubstring.startsWith("error Pack exceeds the limit of")) {
            throw new TooLargePackException(this.uri, strSubstring.substring("error ".length()));
        }
        if (strSubstring.startsWith("error Object too large")) {
            throw new TooLargeObjectInPackException(this.uri, strSubstring.substring("error ".length()));
        }
        if (!strSubstring.equals("ok")) {
            throw new TransportException(this.uri, MessageFormat.format(JGitText.get().errorOccurredDuringUnpackingOnTheRemoteEnd, strSubstring));
        }
        for (String str : this.pckIn.readStrings()) {
            if (str.startsWith("ok ")) {
                iIndexOf = str.length();
                z = true;
            } else {
                z = false;
                iIndexOf = str.startsWith("ng ") ? str.indexOf(32, 3) : -1;
            }
            if (iIndexOf == -1) {
                throw new PackProtocolException(MessageFormat.format(JGitText.get().unexpectedReportLine2, this.uri, str));
            }
            String strSubstring2 = str.substring(3, iIndexOf);
            String strSubstring3 = z ? null : str.substring(iIndexOf + 1);
            RemoteRefUpdate remoteRefUpdate = map.get(strSubstring2);
            if (remoteRefUpdate == null) {
                throw new PackProtocolException(MessageFormat.format(JGitText.get().unexpectedRefReport, this.uri, strSubstring2));
            }
            if (z) {
                remoteRefUpdate.setStatus(RemoteRefUpdate.Status.OK);
            } else {
                remoteRefUpdate.setStatus(RemoteRefUpdate.Status.REJECTED_OTHER_REASON);
                remoteRefUpdate.setMessage(strSubstring3);
            }
        }
        for (RemoteRefUpdate remoteRefUpdate2 : map.values()) {
            if (remoteRefUpdate2.getStatus() == RemoteRefUpdate.Status.AWAITING_REPORT) {
                throw new PackProtocolException(MessageFormat.format(JGitText.get().expectedReportForRefNotReceived, this.uri, remoteRefUpdate2.getRemoteName()));
            }
        }
    }

    private String readStringLongTimeout() throws IOException {
        if (this.timeoutIn == null) {
            return this.pckIn.readString();
        }
        int timeout = this.timeoutIn.getTimeout();
        try {
            int iMax = Math.max((int) Math.min(this.packTransferTime, 28800000L), timeout) * 10;
            TimeoutInputStream timeoutInputStream = this.timeoutIn;
            if (iMax < 0) {
                iMax = Integer.MAX_VALUE;
            }
            timeoutInputStream.setTimeout(iMax);
            return this.pckIn.readString();
        } finally {
            this.timeoutIn.setTimeout(timeout);
        }
    }

    public List<String> getPushOptions() {
        return this.pushOptions;
    }

    public boolean isUseBitmaps() {
        return this.useBitmaps;
    }

    private static class CheckingSideBandOutputStream extends OutputStream {
        private final InputStream in;
        private final OutputStream out;

        CheckingSideBandOutputStream(InputStream inputStream, OutputStream outputStream) {
            this.in = inputStream;
            this.out = outputStream;
        }

        @Override // java.io.OutputStream
        public void write(int i) throws IOException {
            write(new byte[]{(byte) i});
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i, int i2) throws IOException {
            try {
                this.out.write(bArr, i, i2);
            } catch (IOException e) {
                throw checkError(e);
            }
        }

        @Override // java.io.OutputStream, java.io.Flushable
        public void flush() throws IOException {
            try {
                this.out.flush();
            } catch (IOException e) {
                throw checkError(e);
            }
        }

        private IOException checkError(IOException iOException) {
            try {
                this.in.read();
            } catch (TransportException e) {
                return e;
            } catch (IOException unused) {
            }
            return iOException;
        }
    }
}
