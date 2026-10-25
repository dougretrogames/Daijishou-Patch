package org.eclipse.jgit.transport;

import androidx.leanback.media.MediaPlayerGlue;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UncheckedIOException;
import java.nio.charset.StandardCharsets;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.eclipse.jgit.annotations.Nullable;
import org.eclipse.jgit.errors.InvalidObjectIdException;
import org.eclipse.jgit.errors.LargeObjectException;
import org.eclipse.jgit.errors.PackProtocolException;
import org.eclipse.jgit.errors.TooLargePackException;
import org.eclipse.jgit.errors.UnpackException;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.internal.storage.file.FileRepository$$ExternalSyntheticLambda1;
import org.eclipse.jgit.internal.submodule.SubmoduleValidator;
import org.eclipse.jgit.internal.transport.connectivity.FullConnectivityChecker;
import org.eclipse.jgit.internal.transport.parser.FirstCommand;
import org.eclipse.jgit.lib.AnyObjectId;
import org.eclipse.jgit.lib.BatchRefUpdate;
import org.eclipse.jgit.lib.Config;
import org.eclipse.jgit.lib.ConfigConstants;
import org.eclipse.jgit.lib.Constants;
import org.eclipse.jgit.lib.GitmoduleEntry;
import org.eclipse.jgit.lib.NullProgressMonitor;
import org.eclipse.jgit.lib.ObjectChecker;
import org.eclipse.jgit.lib.ObjectDatabase;
import org.eclipse.jgit.lib.ObjectId;
import org.eclipse.jgit.lib.ObjectInserter;
import org.eclipse.jgit.lib.PersonIdent;
import org.eclipse.jgit.lib.ProgressMonitor;
import org.eclipse.jgit.lib.Ref;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.revwalk.RevCommit;
import org.eclipse.jgit.revwalk.RevObject;
import org.eclipse.jgit.revwalk.RevWalk;
import org.eclipse.jgit.util.io.InterruptTimer;
import org.eclipse.jgit.util.io.LimitedInputStream;
import org.eclipse.jgit.util.io.TimeoutInputStream;
import org.eclipse.jgit.util.io.TimeoutOutputStream;

/* JADX INFO: loaded from: classes5.dex */
public class ReceivePack {
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$org$eclipse$jgit$transport$ReceiveCommand$Result;
    private StringBuilder advertiseError;
    private AdvertiseRefsHook advertiseRefsHook;
    private Set<ObjectId> advertisedHaves;
    private boolean allowAnyDeletes;
    private boolean allowBranchDeletes;
    private boolean allowCreates;
    private boolean allowNonFastForwards;
    private boolean allowOfsDelta;
    private boolean allowPushOptions;
    private boolean allowReceiveClientSID;
    private boolean atomic;
    private boolean checkReferencedAreReachable;
    private String clientSID;
    private Set<ObjectId> clientShallowCommits;
    private List<ReceiveCommand> commands;
    private final Repository db;
    private Map<String, String> enabledCapabilities;
    private SideBandOutputStream errOut;
    private boolean expectDataAfterPackFooter;
    private long maxCommandBytes;
    private long maxDiscardBytes;
    private long maxObjectSizeLimit;
    private OutputStream msgOut;
    private ObjectChecker objectChecker;
    private OutputStream origOut;
    private PackLock packLock;
    private Long packSize;
    private PackParser parser;
    private PacketLineIn pckIn;
    private PacketLineOut pckOut;
    private PostReceiveHook postReceive;
    private PreReceiveHook preReceive;
    private PushCertificate pushCert;
    private PushCertificateParser pushCertificateParser;
    private List<String> pushOptions;
    private boolean quiet;
    private InputStream rawIn;
    private OutputStream rawOut;
    private RefFilter refFilter;
    private PersonIdent refLogIdent;
    private Map<String, Ref> refs;
    private boolean reportStatus;
    private boolean sideBand;
    private SignedPushConfig signedPushConfig;
    private ReceivedPackStatistics stats;
    private int timeout;
    private TimeoutInputStream timeoutIn;
    private InterruptTimer timer;
    private boolean usePushOptions;
    String userAgent;
    private final RevWalk walk;
    private boolean biDirectionalPipe = true;
    private boolean allowQuiet = true;
    private final MessageOutputWrapper msgOutWrapper = new MessageOutputWrapper();
    private long maxPackSizeLimit = -1;
    protected ConnectivityChecker connectivityChecker = new FullConnectivityChecker();
    private ReceiveCommandErrorHandler receiveCommandErrorHandler = new AnonymousClass1();
    private UnpackErrorHandler unpackErrorHandler = new DefaultUnpackErrorHandler(this, null);

    static /* synthetic */ int[] $SWITCH_TABLE$org$eclipse$jgit$transport$ReceiveCommand$Result() {
        int[] iArr = $SWITCH_TABLE$org$eclipse$jgit$transport$ReceiveCommand$Result;
        if (iArr != null) {
            return iArr;
        }
        int[] iArr2 = new int[ReceiveCommand.Result.valuesCustom().length];
        try {
            iArr2[ReceiveCommand.Result.LOCK_FAILURE.ordinal()] = 8;
        } catch (NoSuchFieldError unused) {
        }
        try {
            iArr2[ReceiveCommand.Result.NOT_ATTEMPTED.ordinal()] = 1;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            iArr2[ReceiveCommand.Result.OK.ordinal()] = 9;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            iArr2[ReceiveCommand.Result.REJECTED_CURRENT_BRANCH.ordinal()] = 5;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            iArr2[ReceiveCommand.Result.REJECTED_MISSING_OBJECT.ordinal()] = 6;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            iArr2[ReceiveCommand.Result.REJECTED_NOCREATE.ordinal()] = 2;
        } catch (NoSuchFieldError unused6) {
        }
        try {
            iArr2[ReceiveCommand.Result.REJECTED_NODELETE.ordinal()] = 3;
        } catch (NoSuchFieldError unused7) {
        }
        try {
            iArr2[ReceiveCommand.Result.REJECTED_NONFASTFORWARD.ordinal()] = 4;
        } catch (NoSuchFieldError unused8) {
        }
        try {
            iArr2[ReceiveCommand.Result.REJECTED_OTHER_REASON.ordinal()] = 7;
        } catch (NoSuchFieldError unused9) {
        }
        $SWITCH_TABLE$org$eclipse$jgit$transport$ReceiveCommand$Result = iArr2;
        return iArr2;
    }

    /* JADX INFO: renamed from: org.eclipse.jgit.transport.ReceivePack$1, reason: invalid class name */
    class AnonymousClass1 implements ReceiveCommandErrorHandler {
        AnonymousClass1() {
        }
    }

    public ReceivePack(Repository repository) {
        this.db = repository;
        RevWalk revWalk = new RevWalk(repository);
        this.walk = revWalk;
        revWalk.setRetainBody(false);
        TransferConfig transferConfig = (TransferConfig) repository.getConfig().get(TransferConfig.KEY);
        this.objectChecker = transferConfig.newReceiveObjectChecker();
        this.allowReceiveClientSID = transferConfig.isAllowReceiveClientSID();
        ReceiveConfig receiveConfig = (ReceiveConfig) repository.getConfig().get(new ReceivePack$$ExternalSyntheticLambda0());
        this.allowCreates = receiveConfig.allowCreates;
        this.allowAnyDeletes = true;
        this.allowBranchDeletes = receiveConfig.allowDeletes;
        this.allowNonFastForwards = receiveConfig.allowNonFastForwards;
        this.allowOfsDelta = receiveConfig.allowOfsDelta;
        this.allowPushOptions = receiveConfig.allowPushOptions;
        this.maxCommandBytes = receiveConfig.maxCommandBytes;
        this.maxDiscardBytes = receiveConfig.maxDiscardBytes;
        this.advertiseRefsHook = AdvertiseRefsHook.DEFAULT;
        this.refFilter = RefFilter.DEFAULT;
        this.advertisedHaves = new HashSet();
        this.clientShallowCommits = new HashSet();
        this.signedPushConfig = receiveConfig.signedPush;
        this.preReceive = PreReceiveHook.NULL;
        this.postReceive = PostReceiveHook.NULL;
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class ReceiveConfig {
        final boolean allowCreates = true;
        final boolean allowDeletes;
        final boolean allowNonFastForwards;
        final boolean allowOfsDelta;
        final boolean allowPushOptions;
        final long maxCommandBytes;
        final long maxDiscardBytes;
        final SignedPushConfig signedPush;

        ReceiveConfig(Config config) {
            this.allowDeletes = !config.getBoolean(ConfigConstants.CONFIG_RECEIVE_SECTION, "denydeletes", false);
            this.allowNonFastForwards = !config.getBoolean(ConfigConstants.CONFIG_RECEIVE_SECTION, "denynonfastforwards", false);
            this.allowOfsDelta = config.getBoolean(ConfigConstants.CONFIG_REPACK_SECTION, "usedeltabaseoffset", true);
            this.allowPushOptions = config.getBoolean(ConfigConstants.CONFIG_RECEIVE_SECTION, "pushoptions", false);
            this.maxCommandBytes = config.getLong(ConfigConstants.CONFIG_RECEIVE_SECTION, "maxCommandBytes", 3145728L);
            this.maxDiscardBytes = config.getLong(ConfigConstants.CONFIG_RECEIVE_SECTION, "maxCommandDiscardBytes", -1L);
            this.signedPush = SignedPushConfig.KEY.parse(config);
        }
    }

    class MessageOutputWrapper extends OutputStream {
        MessageOutputWrapper() {
        }

        @Override // java.io.OutputStream
        public void write(int i) {
            if (ReceivePack.this.msgOut != null) {
                try {
                    ReceivePack.this.msgOut.write(i);
                } catch (IOException unused) {
                }
            }
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i, int i2) {
            if (ReceivePack.this.msgOut != null) {
                try {
                    ReceivePack.this.msgOut.write(bArr, i, i2);
                } catch (IOException unused) {
                }
            }
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr) {
            write(bArr, 0, bArr.length);
        }

        @Override // java.io.OutputStream, java.io.Flushable
        public void flush() {
            if (ReceivePack.this.msgOut != null) {
                try {
                    ReceivePack.this.msgOut.flush();
                } catch (IOException unused) {
                }
            }
        }
    }

    public Repository getRepository() {
        return this.db;
    }

    public RevWalk getRevWalk() {
        return this.walk;
    }

    public Map<String, Ref> getAdvertisedRefs() {
        return this.refs;
    }

    public void setAdvertisedRefs(Map<String, Ref> map, Set<ObjectId> set) throws IOException {
        if (map == null) {
            map = getAllRefs();
        }
        this.refs = map;
        this.refs = this.refFilter.filter(map);
        this.advertisedHaves.clear();
        Ref ref = this.refs.get("HEAD");
        if (ref != null && ref.isSymbolic()) {
            this.refs.remove("HEAD");
        }
        for (Ref ref2 : this.refs.values()) {
            if (ref2.getObjectId() != null) {
                this.advertisedHaves.add(ref2.getObjectId());
            }
        }
        if (set != null) {
            this.advertisedHaves.addAll(set);
        } else {
            this.advertisedHaves.addAll(this.db.getAdditionalHaves());
        }
    }

    public final Set<ObjectId> getAdvertisedObjects() {
        return this.advertisedHaves;
    }

    public boolean isCheckReferencedObjectsAreReachable() {
        return this.checkReferencedAreReachable;
    }

    public void setCheckReferencedObjectsAreReachable(boolean z) {
        this.checkReferencedAreReachable = z;
    }

    public boolean isBiDirectionalPipe() {
        return this.biDirectionalPipe;
    }

    public void setBiDirectionalPipe(boolean z) {
        this.biDirectionalPipe = z;
    }

    public boolean isExpectDataAfterPackFooter() {
        return this.expectDataAfterPackFooter;
    }

    public void setExpectDataAfterPackFooter(boolean z) {
        this.expectDataAfterPackFooter = z;
    }

    public boolean isCheckReceivedObjects() {
        return this.objectChecker != null;
    }

    public void setCheckReceivedObjects(boolean z) {
        if (z && this.objectChecker == null) {
            setObjectChecker(new ObjectChecker());
        } else {
            if (z || this.objectChecker == null) {
                return;
            }
            setObjectChecker(null);
        }
    }

    public void setObjectChecker(ObjectChecker objectChecker) {
        this.objectChecker = objectChecker;
    }

    public boolean isAllowCreates() {
        return this.allowCreates;
    }

    public void setAllowCreates(boolean z) {
        this.allowCreates = z;
    }

    public boolean isAllowDeletes() {
        return this.allowAnyDeletes;
    }

    public void setAllowDeletes(boolean z) {
        this.allowAnyDeletes = z;
    }

    public boolean isAllowBranchDeletes() {
        return this.allowBranchDeletes;
    }

    public void setAllowBranchDeletes(boolean z) {
        this.allowBranchDeletes = z;
    }

    public boolean isAllowNonFastForwards() {
        return this.allowNonFastForwards;
    }

    public void setAllowNonFastForwards(boolean z) {
        this.allowNonFastForwards = z;
    }

    public boolean isAtomic() {
        return this.atomic;
    }

    public void setAtomic(boolean z) {
        this.atomic = z;
    }

    public PersonIdent getRefLogIdent() {
        return this.refLogIdent;
    }

    public void setRefLogIdent(PersonIdent personIdent) {
        this.refLogIdent = personIdent;
    }

    public AdvertiseRefsHook getAdvertiseRefsHook() {
        return this.advertiseRefsHook;
    }

    public RefFilter getRefFilter() {
        return this.refFilter;
    }

    public void setAdvertiseRefsHook(AdvertiseRefsHook advertiseRefsHook) {
        if (advertiseRefsHook != null) {
            this.advertiseRefsHook = advertiseRefsHook;
        } else {
            this.advertiseRefsHook = AdvertiseRefsHook.DEFAULT;
        }
    }

    public void setRefFilter(RefFilter refFilter) {
        if (refFilter == null) {
            refFilter = RefFilter.DEFAULT;
        }
        this.refFilter = refFilter;
    }

    public int getTimeout() {
        return this.timeout;
    }

    public void setTimeout(int i) {
        this.timeout = i;
    }

    public void setMaxCommandBytes(long j) {
        this.maxCommandBytes = j;
    }

    public void setMaxCommandDiscardBytes(long j) {
        this.maxDiscardBytes = j;
    }

    public void setMaxObjectSizeLimit(long j) {
        this.maxObjectSizeLimit = j;
    }

    public void setMaxPackSizeLimit(long j) {
        if (j < 0) {
            throw new IllegalArgumentException(MessageFormat.format(JGitText.get().receivePackInvalidLimit, Long.valueOf(j)));
        }
        this.maxPackSizeLimit = j;
    }

    public boolean isSideBand() throws RequestNotYetReadException {
        checkRequestWasRead();
        return this.enabledCapabilities.containsKey("side-band-64k");
    }

    public boolean isAllowQuiet() {
        return this.allowQuiet;
    }

    public void setAllowQuiet(boolean z) {
        this.allowQuiet = z;
    }

    public boolean isAllowPushOptions() {
        return this.allowPushOptions;
    }

    public void setAllowPushOptions(boolean z) {
        this.allowPushOptions = z;
    }

    public boolean isQuiet() throws RequestNotYetReadException {
        checkRequestWasRead();
        return this.quiet;
    }

    public void setSignedPushConfig(SignedPushConfig signedPushConfig) {
        this.signedPushConfig = signedPushConfig;
    }

    private PushCertificateParser getPushCertificateParser() {
        if (this.pushCertificateParser == null) {
            this.pushCertificateParser = new PushCertificateParser(this.db, this.signedPushConfig);
        }
        return this.pushCertificateParser;
    }

    public String getPeerUserAgent() {
        Map<String, String> map = this.enabledCapabilities;
        if (map == null || map.isEmpty()) {
            return this.userAgent;
        }
        return this.enabledCapabilities.getOrDefault(GitProtocolConstants.OPTION_AGENT, this.userAgent);
    }

    public List<ReceiveCommand> getAllCommands() {
        return Collections.unmodifiableList(this.commands);
    }

    public void setReceiveCommandErrorHandler(ReceiveCommandErrorHandler receiveCommandErrorHandler) {
        this.receiveCommandErrorHandler = receiveCommandErrorHandler;
    }

    public void sendError(String str) {
        if (this.refs == null) {
            if (this.advertiseError == null) {
                this.advertiseError = new StringBuilder();
            }
            this.advertiseError.append(str).append('\n');
            return;
        }
        this.msgOutWrapper.write(Constants.encode("error: " + str + "\n"));
    }

    private void fatalError(String str) {
        SideBandOutputStream sideBandOutputStream = this.errOut;
        if (sideBandOutputStream != null) {
            try {
                sideBandOutputStream.write(Constants.encode(str));
                this.errOut.flush();
                return;
            } catch (IOException unused) {
                return;
            }
        }
        sendError(str);
    }

    public void sendMessage(String str) {
        this.msgOutWrapper.write(Constants.encode(str + "\n"));
    }

    public OutputStream getMessageOutputStream() {
        return this.msgOutWrapper;
    }

    public boolean hasReceivedPack() {
        return this.packSize != null;
    }

    public long getPackSize() {
        Long l = this.packSize;
        if (l != null) {
            return l.longValue();
        }
        throw new IllegalStateException(JGitText.get().packSizeNotSetYet);
    }

    private Set<ObjectId> getClientShallowCommits() {
        return this.clientShallowCommits;
    }

    private boolean hasCommands() {
        return !this.commands.isEmpty();
    }

    private boolean hasError() {
        return this.advertiseError != null;
    }

    protected void init(InputStream inputStream, OutputStream outputStream, OutputStream outputStream2) {
        this.origOut = outputStream;
        this.rawIn = inputStream;
        this.rawOut = outputStream;
        this.msgOut = outputStream2;
        if (this.timeout > 0) {
            this.timer = new InterruptTimer(Thread.currentThread().getName() + "-Timer");
            this.timeoutIn = new TimeoutInputStream(this.rawIn, this.timer);
            TimeoutOutputStream timeoutOutputStream = new TimeoutOutputStream(this.rawOut, this.timer);
            this.timeoutIn.setTimeout(this.timeout * 1000);
            timeoutOutputStream.setTimeout(this.timeout * 1000);
            this.rawIn = this.timeoutIn;
            this.rawOut = timeoutOutputStream;
        }
        this.pckIn = new PacketLineIn(this.rawIn);
        PacketLineOut packetLineOut = new PacketLineOut(this.rawOut);
        this.pckOut = packetLineOut;
        packetLineOut.setFlushOnEnd(false);
        this.enabledCapabilities = new HashMap();
        this.commands = new ArrayList();
    }

    private Map<String, Ref> getAdvertisedOrDefaultRefs() throws IOException {
        if (this.refs == null) {
            setAdvertisedRefs(null, null);
        }
        return this.refs;
    }

    protected void receivePackAndCheckConnectivity() throws LargeObjectException, IOException, SubmoduleValidator.SubmoduleValidationException {
        receivePack();
        if (needCheckConnectivity()) {
            checkSubmodules();
            checkConnectivity();
        }
        this.parser = null;
    }

    private void unlockPack() throws IOException {
        PackLock packLock = this.packLock;
        if (packLock != null) {
            packLock.unlock();
            this.packLock = null;
        }
    }

    public void sendAdvertisedRefs(RefAdvertiser refAdvertiser) throws IOException {
        StringBuilder sb = this.advertiseError;
        if (sb != null) {
            refAdvertiser.writeOne(GitProtocolConstants.PACKET_ERR + String.valueOf(sb));
            return;
        }
        try {
            this.advertiseRefsHook.advertiseRefs(this);
            refAdvertiser.init(this.db);
            refAdvertiser.advertiseCapability("side-band-64k");
            refAdvertiser.advertiseCapability("delete-refs");
            refAdvertiser.advertiseCapability("report-status");
            if (this.allowReceiveClientSID) {
                refAdvertiser.advertiseCapability(GitProtocolConstants.OPTION_SESSION_ID);
            }
            if (this.allowQuiet) {
                refAdvertiser.advertiseCapability(GitProtocolConstants.CAPABILITY_QUIET);
            }
            String advertiseNonce = getPushCertificateParser().getAdvertiseNonce();
            if (advertiseNonce != null) {
                refAdvertiser.advertiseCapability(advertiseNonce);
            }
            if (this.db.getRefDatabase().performsAtomicTransactions()) {
                refAdvertiser.advertiseCapability(GitProtocolConstants.CAPABILITY_ATOMIC);
            }
            if (this.allowOfsDelta) {
                refAdvertiser.advertiseCapability("ofs-delta");
            }
            if (this.allowPushOptions) {
                refAdvertiser.advertiseCapability("push-options");
            }
            refAdvertiser.advertiseCapability(GitProtocolConstants.OPTION_AGENT, UserAgent.get());
            refAdvertiser.send(getAdvertisedOrDefaultRefs().values());
            Iterator<ObjectId> it = this.advertisedHaves.iterator();
            while (it.hasNext()) {
                refAdvertiser.advertiseHave(it.next());
            }
            if (refAdvertiser.isEmpty()) {
                refAdvertiser.advertiseId(ObjectId.zeroId(), "capabilities^{}");
            }
            refAdvertiser.end();
        } catch (ServiceMayNotContinueException e) {
            if (e.getMessage() != null) {
                refAdvertiser.writeOne(GitProtocolConstants.PACKET_ERR + e.getMessage());
                e.setOutput();
            }
            throw e;
        }
    }

    @Nullable
    public ReceivedPackStatistics getReceivedPackStatistics() {
        return this.stats;
    }

    private Map<String, Ref> getAllRefs() {
        try {
            return (Map) this.db.getRefDatabase().getRefs().stream().collect(Collectors.toMap(new FileRepository$$ExternalSyntheticLambda1(), Function.identity()));
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    private void recvCommands() throws IOException {
        PacketLineIn packetLineIn;
        if (this.maxCommandBytes > 0) {
            packetLineIn = new PacketLineIn(this.rawIn, this.maxCommandBytes);
        } else {
            packetLineIn = this.pckIn;
        }
        PushCertificateParser pushCertificateParser = getPushCertificateParser();
        boolean z = true;
        while (true) {
            try {
                try {
                    String string = packetLineIn.readString();
                    if (PacketLineIn.isEnd(string)) {
                        break;
                    }
                    int length = GitProtocolConstants.PACKET_SHALLOW.length() + 40;
                    if (string.length() >= length && string.startsWith(GitProtocolConstants.PACKET_SHALLOW)) {
                        parseShallow(string.substring(GitProtocolConstants.PACKET_SHALLOW.length(), length));
                    } else {
                        if (z) {
                            FirstCommand firstCommandFromLine = FirstCommand.fromLine(string);
                            this.enabledCapabilities = firstCommandFromLine.getCapabilities();
                            string = firstCommandFromLine.getLine();
                            enableCapabilities();
                            if (string.equals("push-cert")) {
                                pushCertificateParser.receiveHeader(packetLineIn, !isBiDirectionalPipe());
                                z = false;
                            } else {
                                z = false;
                            }
                        }
                        if (string.equals(Constants.GPG_SIGNATURE_PREFIX)) {
                            pushCertificateParser.receiveSignature(packetLineIn);
                        } else {
                            ReceiveCommand command = parseCommand(string);
                            if (command.getRefName().equals("HEAD")) {
                                command.setResult(ReceiveCommand.Result.REJECTED_CURRENT_BRANCH);
                            } else {
                                command.setRef(this.refs.get(command.getRefName()));
                            }
                            this.commands.add(command);
                            if (pushCertificateParser.enabled()) {
                                pushCertificateParser.addCommand(command);
                            }
                        }
                    }
                } catch (EOFException e) {
                    if (!this.commands.isEmpty()) {
                        throw e;
                    }
                    return;
                }
            } catch (Throwable th) {
                discardCommands();
                throw th;
            }
        }
        this.pushCert = pushCertificateParser.build();
        if (hasCommands()) {
            readPostCommands(packetLineIn);
        }
    }

    private void discardCommands() {
        if (this.sideBand) {
            long jMax = this.maxDiscardBytes;
            if (jMax < 0) {
                jMax = Math.max(this.maxCommandBytes * 3, 3145728L);
            }
            try {
                new PacketLineIn(this.rawIn, jMax).discardUntilEnd();
            } catch (IOException unused) {
            }
        }
    }

    private void parseShallow(String str) throws PackProtocolException {
        try {
            this.clientShallowCommits.add(ObjectId.fromString(str));
        } catch (InvalidObjectIdException e) {
            throw new PackProtocolException(e.getMessage(), e);
        }
    }

    void readPostCommands(PacketLineIn packetLineIn) throws IOException {
        if (!this.usePushOptions) {
            return;
        }
        this.pushOptions = new ArrayList(4);
        while (true) {
            String string = packetLineIn.readString();
            if (PacketLineIn.isEnd(string)) {
                return;
            } else {
                this.pushOptions.add(string);
            }
        }
    }

    private void enableCapabilities() {
        this.reportStatus = isCapabilityEnabled("report-status");
        this.usePushOptions = isCapabilityEnabled("push-options");
        this.sideBand = isCapabilityEnabled("side-band-64k");
        this.quiet = this.allowQuiet && isCapabilityEnabled(GitProtocolConstants.CAPABILITY_QUIET);
        this.clientSID = this.enabledCapabilities.get(GitProtocolConstants.OPTION_SESSION_ID);
        if (this.sideBand) {
            OutputStream outputStream = this.rawOut;
            this.rawOut = new SideBandOutputStream(1, SideBandOutputStream.MAX_BUF, outputStream);
            this.msgOut = new SideBandOutputStream(2, SideBandOutputStream.MAX_BUF, outputStream);
            this.errOut = new SideBandOutputStream(3, SideBandOutputStream.MAX_BUF, outputStream);
            PacketLineOut packetLineOut = new PacketLineOut(this.rawOut);
            this.pckOut = packetLineOut;
            packetLineOut.setFlushOnEnd(false);
        }
    }

    private boolean isCapabilityEnabled(String str) {
        return this.enabledCapabilities.containsKey(str);
    }

    private void checkRequestWasRead() {
        if (this.enabledCapabilities == null) {
            throw new RequestNotYetReadException();
        }
    }

    private boolean needPack() {
        Iterator<ReceiveCommand> it = this.commands.iterator();
        while (it.hasNext()) {
            if (it.next().getType() != ReceiveCommand.Type.DELETE) {
                return true;
            }
        }
        return false;
    }

    private void receivePack() throws IOException {
        TimeoutInputStream timeoutInputStream = this.timeoutIn;
        if (timeoutInputStream != null) {
            timeoutInputStream.setTimeout(this.timeout * MediaPlayerGlue.FAST_FORWARD_REWIND_STEP);
        }
        NullProgressMonitor nullProgressMonitor = NullProgressMonitor.INSTANCE;
        ProgressMonitor sideBandProgressMonitor = NullProgressMonitor.INSTANCE;
        if (this.sideBand && !this.quiet) {
            sideBandProgressMonitor = new SideBandProgressMonitor(this.msgOut);
        }
        Throwable th = null;
        try {
            ObjectInserter objectInserterNewObjectInserter = this.db.newObjectInserter();
            try {
                String str = "jgit receive-pack";
                if (getRefLogIdent() != null) {
                    str = "jgit receive-pack from " + getRefLogIdent().toExternalString();
                }
                PackParser packParserNewPackParser = objectInserterNewObjectInserter.newPackParser(packInputStream());
                this.parser = packParserNewPackParser;
                boolean z = true;
                packParserNewPackParser.setAllowThin(true);
                this.parser.setNeedNewObjectIds(this.checkReferencedAreReachable);
                this.parser.setNeedBaseObjectIds(this.checkReferencedAreReachable);
                PackParser packParser = this.parser;
                if (this.biDirectionalPipe || isExpectDataAfterPackFooter()) {
                    z = false;
                }
                packParser.setCheckEofAfterPackFooter(z);
                this.parser.setExpectDataAfterPackFooter(isExpectDataAfterPackFooter());
                this.parser.setObjectChecker(this.objectChecker);
                this.parser.setLockMessage(str);
                this.parser.setMaxObjectSizeLimit(this.maxObjectSizeLimit);
                this.packLock = this.parser.parse(nullProgressMonitor, sideBandProgressMonitor);
                this.packSize = Long.valueOf(this.parser.getPackSize());
                this.stats = this.parser.getReceivedPackStatistics();
                objectInserterNewObjectInserter.flush();
                if (objectInserterNewObjectInserter != null) {
                    objectInserterNewObjectInserter.close();
                }
                TimeoutInputStream timeoutInputStream2 = this.timeoutIn;
                if (timeoutInputStream2 != null) {
                    timeoutInputStream2.setTimeout(this.timeout * 1000);
                }
            } catch (Throwable th2) {
                if (objectInserterNewObjectInserter == null) {
                    throw th2;
                }
                objectInserterNewObjectInserter.close();
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

    private InputStream packInputStream() {
        InputStream inputStream = this.rawIn;
        return this.maxPackSizeLimit >= 0 ? new AnonymousClass2(inputStream, this.maxPackSizeLimit) : inputStream;
    }

    /* JADX INFO: renamed from: org.eclipse.jgit.transport.ReceivePack$2, reason: invalid class name */
    class AnonymousClass2 extends LimitedInputStream {
        AnonymousClass2(InputStream inputStream, long j) {
            super(inputStream, j);
        }

        @Override // org.eclipse.jgit.util.io.LimitedInputStream
        protected void limitExceeded() throws TooLargePackException {
            throw new TooLargePackException(this.limit);
        }
    }

    private boolean needCheckConnectivity() {
        return isCheckReceivedObjects() || isCheckReferencedObjectsAreReachable() || !getClientShallowCommits().isEmpty();
    }

    private void checkSubmodules() throws LargeObjectException, IOException, SubmoduleValidator.SubmoduleValidationException {
        ObjectDatabase objectDatabase = this.db.getObjectDatabase();
        ObjectChecker objectChecker = this.objectChecker;
        if (objectChecker == null) {
            return;
        }
        Iterator<GitmoduleEntry> it = objectChecker.getGitsubmodules().iterator();
        while (it.hasNext()) {
            SubmoduleValidator.assertValidGitModulesFile(new String(objectDatabase.open(it.next().getBlobId(), 3).getBytes(), StandardCharsets.UTF_8));
        }
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private void checkConnectivity() throws IOException {
        NullProgressMonitor nullProgressMonitor = NullProgressMonitor.INSTANCE;
        ProgressMonitor progressMonitor = nullProgressMonitor;
        if (this.sideBand && !this.quiet) {
            progressMonitor = nullProgressMonitor;
            SideBandProgressMonitor sideBandProgressMonitor = new SideBandProgressMonitor(this.msgOut);
            sideBandProgressMonitor.setDelayStart(750L, TimeUnit.MILLISECONDS);
            progressMonitor = sideBandProgressMonitor;
        }
        progressMonitor = nullProgressMonitor;
        this.connectivityChecker.checkConnectivity(createConnectivityCheckInfo(), this.advertisedHaves, progressMonitor);
    }

    private ConnectivityChecker.ConnectivityCheckInfo createConnectivityCheckInfo() {
        ConnectivityChecker.ConnectivityCheckInfo connectivityCheckInfo = new ConnectivityChecker.ConnectivityCheckInfo();
        connectivityCheckInfo.setCheckObjects(this.checkReferencedAreReachable);
        connectivityCheckInfo.setCommands(getAllCommands());
        connectivityCheckInfo.setRepository(this.db);
        connectivityCheckInfo.setParser(this.parser);
        connectivityCheckInfo.setWalk(this.walk);
        return connectivityCheckInfo;
    }

    private void validateCommands() {
        for (ReceiveCommand receiveCommand : this.commands) {
            Ref ref = receiveCommand.getRef();
            if (receiveCommand.getResult() == ReceiveCommand.Result.NOT_ATTEMPTED) {
                if (receiveCommand.getType() == ReceiveCommand.Type.DELETE) {
                    if (!isAllowDeletes()) {
                        receiveCommand.setResult(ReceiveCommand.Result.REJECTED_NODELETE);
                    } else if (!isAllowBranchDeletes() && ref.getName().startsWith(Constants.R_HEADS)) {
                        receiveCommand.setResult(ReceiveCommand.Result.REJECTED_NODELETE);
                    }
                }
                if (receiveCommand.getType() == ReceiveCommand.Type.CREATE) {
                    if (!isAllowCreates()) {
                        receiveCommand.setResult(ReceiveCommand.Result.REJECTED_NOCREATE);
                    } else if (ref != null && !isAllowNonFastForwards()) {
                        receiveCommand.setResult(ReceiveCommand.Result.REJECTED_NONFASTFORWARD);
                    } else if (ref != null) {
                        receiveCommand.setResult(ReceiveCommand.Result.REJECTED_OTHER_REASON, JGitText.get().refAlreadyExists);
                    }
                }
                if (receiveCommand.getType() == ReceiveCommand.Type.DELETE && ref != null) {
                    ObjectId objectId = ref.getObjectId();
                    if (objectId == null) {
                        objectId = ObjectId.zeroId();
                    }
                    if (!ObjectId.zeroId().equals((AnyObjectId) receiveCommand.getOldId()) && !objectId.equals((AnyObjectId) receiveCommand.getOldId())) {
                        receiveCommand.setResult(ReceiveCommand.Result.REJECTED_OTHER_REASON, JGitText.get().invalidOldIdSent);
                    }
                }
                if (receiveCommand.getType() == ReceiveCommand.Type.UPDATE) {
                    if (ref == null) {
                        receiveCommand.setResult(ReceiveCommand.Result.REJECTED_OTHER_REASON, JGitText.get().noSuchRef);
                    } else {
                        ObjectId objectId2 = ref.getObjectId();
                        if (objectId2 == null) {
                            receiveCommand.setResult(ReceiveCommand.Result.REJECTED_OTHER_REASON, JGitText.get().cannotUpdateUnbornBranch);
                        } else if (!objectId2.equals((AnyObjectId) receiveCommand.getOldId())) {
                            receiveCommand.setResult(ReceiveCommand.Result.REJECTED_OTHER_REASON, JGitText.get().invalidOldIdSent);
                        } else {
                            try {
                                RevObject any = this.walk.parseAny(receiveCommand.getOldId());
                                try {
                                    RevObject any2 = this.walk.parseAny(receiveCommand.getNewId());
                                    if ((any instanceof RevCommit) && (any2 instanceof RevCommit)) {
                                        try {
                                            if (this.walk.isMergedInto((RevCommit) any, (RevCommit) any2)) {
                                                receiveCommand.setTypeFastForwardUpdate();
                                            } else {
                                                receiveCommand.setType(ReceiveCommand.Type.UPDATE_NONFASTFORWARD);
                                            }
                                        } catch (IOException e) {
                                            this.receiveCommandErrorHandler.handleFastForwardCheckException(receiveCommand, e);
                                        }
                                    } else {
                                        receiveCommand.setType(ReceiveCommand.Type.UPDATE_NONFASTFORWARD);
                                    }
                                    if (receiveCommand.getType() == ReceiveCommand.Type.UPDATE_NONFASTFORWARD && !isAllowNonFastForwards()) {
                                        receiveCommand.setResult(ReceiveCommand.Result.REJECTED_NONFASTFORWARD);
                                    }
                                } catch (IOException e2) {
                                    this.receiveCommandErrorHandler.handleNewIdValidationException(receiveCommand, e2);
                                }
                            } catch (IOException e3) {
                                this.receiveCommandErrorHandler.handleOldIdValidationException(receiveCommand, e3);
                            }
                        }
                    }
                }
                if (!receiveCommand.getRefName().startsWith(Constants.R_REFS) || !Repository.isValidRefName(receiveCommand.getRefName())) {
                    receiveCommand.setResult(ReceiveCommand.Result.REJECTED_OTHER_REASON, JGitText.get().funnyRefname);
                }
            }
        }
    }

    private boolean anyRejects() {
        for (ReceiveCommand receiveCommand : this.commands) {
            if (receiveCommand.getResult() != ReceiveCommand.Result.NOT_ATTEMPTED && receiveCommand.getResult() != ReceiveCommand.Result.OK) {
                return true;
            }
        }
        return false;
    }

    private void failPendingCommands() {
        ReceiveCommand.abort(this.commands);
    }

    protected List<ReceiveCommand> filterCommands(ReceiveCommand.Result result) {
        return ReceiveCommand.filter(this.commands, result);
    }

    protected void executeCommands() {
        ProgressMonitor progressMonitor;
        List<ReceiveCommand> listFilterCommands = filterCommands(ReceiveCommand.Result.NOT_ATTEMPTED);
        if (listFilterCommands.isEmpty()) {
            return;
        }
        NullProgressMonitor nullProgressMonitor = NullProgressMonitor.INSTANCE;
        if (this.sideBand) {
            progressMonitor = nullProgressMonitor;
            SideBandProgressMonitor sideBandProgressMonitor = new SideBandProgressMonitor(this.msgOut);
            sideBandProgressMonitor.setDelayStart(250L, TimeUnit.MILLISECONDS);
            progressMonitor = sideBandProgressMonitor;
        }
        progressMonitor = nullProgressMonitor;
        BatchRefUpdate batchRefUpdateNewBatchUpdate = this.db.getRefDatabase().newBatchUpdate();
        batchRefUpdateNewBatchUpdate.setAllowNonFastForwards(isAllowNonFastForwards());
        batchRefUpdateNewBatchUpdate.setAtomic(isAtomic());
        batchRefUpdateNewBatchUpdate.setRefLogIdent(getRefLogIdent());
        batchRefUpdateNewBatchUpdate.setRefLogMessage(ConfigConstants.CONFIG_PUSH_SECTION, true);
        batchRefUpdateNewBatchUpdate.addCommand(listFilterCommands);
        try {
            batchRefUpdateNewBatchUpdate.setPushCertificate(getPushCertificate());
            batchRefUpdateNewBatchUpdate.execute(this.walk, progressMonitor);
        } catch (IOException e) {
            this.receiveCommandErrorHandler.handleBatchRefUpdateException(listFilterCommands, e);
        }
    }

    /* JADX INFO: renamed from: org.eclipse.jgit.transport.ReceivePack$3, reason: invalid class name */
    class AnonymousClass3 extends Reporter {
        AnonymousClass3() {
        }

        @Override // org.eclipse.jgit.transport.ReceivePack.Reporter
        void sendString(String str) throws IOException {
            if (ReceivePack.this.reportStatus) {
                ReceivePack.this.pckOut.writeString(str + "\n");
            } else if (ReceivePack.this.msgOut != null) {
                ReceivePack.this.msgOut.write(Constants.encode(str + "\n"));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendStatusReport(Throwable th) throws IOException {
        AnonymousClass3 anonymousClass3 = new AnonymousClass3();
        try {
            if (th != null) {
                anonymousClass3.sendString("unpack error " + th.getMessage());
                if (this.reportStatus) {
                    Iterator<ReceiveCommand> it = this.commands.iterator();
                    while (it.hasNext()) {
                        anonymousClass3.sendString("ng " + it.next().getRefName() + " n/a (unpacker error)");
                    }
                }
                if (!this.reportStatus) {
                    return;
                }
            } else {
                if (this.reportStatus) {
                    anonymousClass3.sendString("unpack ok");
                }
                for (ReceiveCommand receiveCommand : this.commands) {
                    if (receiveCommand.getResult() == ReceiveCommand.Result.OK) {
                        if (this.reportStatus) {
                            anonymousClass3.sendString("ok " + receiveCommand.getRefName());
                        }
                    } else {
                        StringBuilder sb = new StringBuilder();
                        if (this.reportStatus) {
                            sb.append("ng ").append(receiveCommand.getRefName()).append(" ");
                        } else {
                            sb.append(" ! [rejected] ").append(receiveCommand.getRefName()).append(" (");
                        }
                        if (receiveCommand.getResult() == ReceiveCommand.Result.REJECTED_MISSING_OBJECT) {
                            if (receiveCommand.getMessage() == null) {
                                sb.append("missing object(s)");
                            } else if (receiveCommand.getMessage().length() == 40) {
                                sb.append("object ");
                                sb.append(receiveCommand.getMessage());
                                sb.append(" missing");
                            } else {
                                sb.append(receiveCommand.getMessage());
                            }
                        } else if (receiveCommand.getMessage() != null) {
                            sb.append(receiveCommand.getMessage());
                        } else {
                            switch ($SWITCH_TABLE$org$eclipse$jgit$transport$ReceiveCommand$Result()[receiveCommand.getResult().ordinal()]) {
                                case 1:
                                    sb.append("server bug; ref not processed");
                                    break;
                                case 2:
                                    sb.append("creation prohibited");
                                    break;
                                case 3:
                                    sb.append("deletion prohibited");
                                    break;
                                case 4:
                                    sb.append("non-fast forward");
                                    break;
                                case 5:
                                    sb.append("branch is currently checked out");
                                    break;
                                case 6:
                                case 9:
                                    throw new AssertionError();
                                case 7:
                                    sb.append("unspecified reason");
                                    break;
                                case 8:
                                    sb.append("failed to lock");
                                    break;
                            }
                        }
                        if (!this.reportStatus) {
                            sb.append(")");
                        }
                        anonymousClass3.sendString(sb.toString());
                    }
                }
                if (!this.reportStatus) {
                    return;
                }
            }
            this.pckOut.end();
        } catch (Throwable th2) {
            if (this.reportStatus) {
                this.pckOut.end();
            }
            throw th2;
        }
    }

    private void close() throws IOException {
        OutputStream outputStream;
        if (this.sideBand) {
            ((SideBandOutputStream) this.msgOut).flushBuffer();
            ((SideBandOutputStream) this.rawOut).flushBuffer();
            PacketLineOut packetLineOut = new PacketLineOut(this.origOut);
            packetLineOut.setFlushOnEnd(false);
            packetLineOut.end();
        }
        if (this.biDirectionalPipe) {
            if (!this.sideBand && (outputStream = this.msgOut) != null) {
                outputStream.flush();
            }
            this.rawOut.flush();
        }
    }

    private void release() throws IOException {
        this.walk.close();
        unlockPack();
        this.timeoutIn = null;
        this.rawIn = null;
        this.rawOut = null;
        this.msgOut = null;
        this.pckIn = null;
        this.pckOut = null;
        this.refs = null;
        this.commands = null;
        InterruptTimer interruptTimer = this.timer;
        if (interruptTimer != null) {
            try {
                interruptTimer.terminate();
            } finally {
                this.timer = null;
            }
        }
    }

    static abstract class Reporter {
        abstract void sendString(String str) throws IOException;

        Reporter() {
        }
    }

    public PushCertificate getPushCertificate() {
        return this.pushCert;
    }

    public void setPushCertificate(PushCertificate pushCertificate) {
        this.pushCert = pushCertificate;
    }

    @Nullable
    public List<String> getPushOptions() {
        if (isAllowPushOptions() && this.usePushOptions) {
            return Collections.unmodifiableList(this.pushOptions);
        }
        return null;
    }

    public void setPushOptions(@Nullable List<String> list) {
        this.usePushOptions = list != null;
        this.pushOptions = list;
    }

    public PreReceiveHook getPreReceiveHook() {
        return this.preReceive;
    }

    public void setPreReceiveHook(PreReceiveHook preReceiveHook) {
        if (preReceiveHook == null) {
            preReceiveHook = PreReceiveHook.NULL;
        }
        this.preReceive = preReceiveHook;
    }

    public PostReceiveHook getPostReceiveHook() {
        return this.postReceive;
    }

    public void setPostReceiveHook(PostReceiveHook postReceiveHook) {
        if (postReceiveHook == null) {
            postReceiveHook = PostReceiveHook.NULL;
        }
        this.postReceive = postReceiveHook;
    }

    public UnpackErrorHandler getUnpackErrorHandler() {
        return this.unpackErrorHandler;
    }

    public void setUnpackErrorHandler(UnpackErrorHandler unpackErrorHandler) {
        this.unpackErrorHandler = unpackErrorHandler;
    }

    public String getClientSID() {
        return this.clientSID;
    }

    public void receive(InputStream inputStream, OutputStream outputStream, OutputStream outputStream2) throws IOException {
        init(inputStream, outputStream, outputStream2);
        try {
            try {
                try {
                    service();
                    try {
                        close();
                    } finally {
                        release();
                    }
                } catch (Throwable th) {
                    try {
                        close();
                        throw th;
                    } finally {
                        release();
                    }
                }
            } catch (PackProtocolException e) {
                fatalError(e.getMessage());
                throw e;
            }
        } catch (PacketLineIn.InputOverLimitIOException e2) {
            String str = JGitText.get().tooManyCommands;
            fatalError(str);
            throw new PackProtocolException(str, e2);
        }
    }

    public void receiveWithExceptionPropagation(InputStream inputStream, OutputStream outputStream, OutputStream outputStream2) throws IOException {
        init(inputStream, outputStream, outputStream2);
        try {
            service();
            try {
                close();
            } finally {
                release();
            }
        } catch (Throwable th) {
            try {
                close();
                throw th;
            } finally {
                release();
            }
        }
    }

    private void service() throws IOException {
        if (isBiDirectionalPipe()) {
            sendAdvertisedRefs(new RefAdvertiser.PacketLineOutRefAdvertiser(this.pckOut));
            this.pckOut.flush();
        } else {
            getAdvertisedOrDefaultRefs();
        }
        if (hasError()) {
            return;
        }
        recvCommands();
        if (hasCommands()) {
            Throwable th = null;
            try {
                PostReceiveExecutor postReceiveExecutor = new PostReceiveExecutor(this, null);
                try {
                    if (needPack()) {
                        try {
                            receivePackAndCheckConnectivity();
                        } catch (IOException | Error | RuntimeException | SubmoduleValidator.SubmoduleValidationException e) {
                            unlockPack();
                            this.unpackErrorHandler.handleUnpackException(e);
                            throw new UnpackException(e);
                        }
                    }
                    try {
                        setAtomic(isCapabilityEnabled(GitProtocolConstants.CAPABILITY_ATOMIC));
                        validateCommands();
                        if (this.atomic && anyRejects()) {
                            failPendingCommands();
                        }
                        this.preReceive.onPreReceive(this, filterCommands(ReceiveCommand.Result.NOT_ATTEMPTED));
                        if (this.atomic && anyRejects()) {
                            failPendingCommands();
                        }
                        executeCommands();
                        unlockPack();
                        sendStatusReport(null);
                        postReceiveExecutor.close();
                        autoGc();
                    } catch (Throwable th2) {
                        unlockPack();
                        throw th2;
                    }
                } catch (Throwable th3) {
                    postReceiveExecutor.close();
                    throw th3;
                }
            } catch (Throwable th4) {
                if (0 == 0) {
                    throw th4;
                }
                if (null == th4) {
                    throw null;
                }
                th.addSuppressed(th4);
            }
        }
    }

    private void autoGc() {
        Repository repository = getRepository();
        if (repository.getConfig().getBoolean(ConfigConstants.CONFIG_RECEIVE_SECTION, ConfigConstants.CONFIG_KEY_AUTOGC, true)) {
            repository.autoGC(NullProgressMonitor.INSTANCE);
        }
    }

    static ReceiveCommand parseCommand(String str) throws PackProtocolException {
        if (str == null || str.length() < 83) {
            throw new PackProtocolException(JGitText.get().errorInvalidProtocolWantedOldNewRef);
        }
        String strSubstring = str.substring(0, 40);
        String strSubstring2 = str.substring(41, 81);
        try {
            ObjectId objectIdFromString = ObjectId.fromString(strSubstring);
            ObjectId objectIdFromString2 = ObjectId.fromString(strSubstring2);
            String strSubstring3 = str.substring(82);
            if (!Repository.isValidRefName(strSubstring3)) {
                throw new PackProtocolException(JGitText.get().errorInvalidProtocolWantedOldNewRef);
            }
            return new ReceiveCommand(objectIdFromString, objectIdFromString2, strSubstring3);
        } catch (InvalidObjectIdException e) {
            throw new PackProtocolException(JGitText.get().errorInvalidProtocolWantedOldNewRef, e);
        }
    }

    private class PostReceiveExecutor implements AutoCloseable {
        /* synthetic */ PostReceiveExecutor(ReceivePack receivePack, ReceivePackIA receivePackIA) {
            this();
        }

        private PostReceiveExecutor() {
        }

        @Override // java.lang.AutoCloseable
        public void close() {
            PostReceiveHook postReceiveHook = ReceivePack.this.postReceive;
            ReceivePack receivePack = ReceivePack.this;
            postReceiveHook.onPostReceive(receivePack, receivePack.filterCommands(ReceiveCommand.Result.OK));
        }
    }

    private class DefaultUnpackErrorHandler implements UnpackErrorHandler {
        /* synthetic */ DefaultUnpackErrorHandler(ReceivePack receivePack, ReceivePackIA receivePackIA) {
            this();
        }

        private DefaultUnpackErrorHandler() {
        }

        @Override // org.eclipse.jgit.transport.UnpackErrorHandler
        public void handleUnpackException(Throwable th) throws IOException {
            ReceivePack.this.sendStatusReport(th);
        }
    }
}
