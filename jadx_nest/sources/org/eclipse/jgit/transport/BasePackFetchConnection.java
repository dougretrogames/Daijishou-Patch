package org.eclipse.jgit.transport;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.MessageFormat;
import java.time.Instant;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.eclipse.jgit.errors.PackProtocolException;
import org.eclipse.jgit.errors.RemoteRepositoryException;
import org.eclipse.jgit.errors.TransportException;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.internal.storage.file.FileRepository$$ExternalSyntheticLambda1;
import org.eclipse.jgit.lib.AnyObjectId;
import org.eclipse.jgit.lib.Config;
import org.eclipse.jgit.lib.ConfigConstants;
import org.eclipse.jgit.lib.MutableObjectId;
import org.eclipse.jgit.lib.NullProgressMonitor;
import org.eclipse.jgit.lib.ObjectDatabase;
import org.eclipse.jgit.lib.ObjectId;
import org.eclipse.jgit.lib.ObjectInserter;
import org.eclipse.jgit.lib.ProgressMonitor;
import org.eclipse.jgit.lib.Ref;
import org.eclipse.jgit.revwalk.RevCommit;
import org.eclipse.jgit.revwalk.RevCommitList;
import org.eclipse.jgit.revwalk.RevFlag;
import org.eclipse.jgit.revwalk.RevObject;
import org.eclipse.jgit.revwalk.RevSort;
import org.eclipse.jgit.revwalk.RevWalk;
import org.eclipse.jgit.revwalk.filter.CommitTimeRevFilter;
import org.eclipse.jgit.revwalk.filter.RevFilter;
import org.eclipse.jgit.util.StringUtils;
import org.eclipse.jgit.util.TemporaryBuffer;

/* JADX INFO: loaded from: classes5.dex */
public abstract class BasePackFetchConnection extends BasePackConnection implements FetchConnection {
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$org$eclipse$jgit$transport$PacketLineIn$AckNackResult = null;
    private static final int MAX_HAVES = 256;
    protected static final int MIN_CLIENT_BUFFER = 2952;
    public static final String OPTION_ALLOW_REACHABLE_SHA1_IN_WANT = "allow-reachable-sha1-in-want";
    public static final String OPTION_ALLOW_TIP_SHA1_IN_WANT = "allow-tip-sha1-in-want";
    public static final String OPTION_FILTER = "filter";
    public static final String OPTION_INCLUDE_TAG = "include-tag";
    public static final String OPTION_MULTI_ACK = "multi_ack";
    public static final String OPTION_MULTI_ACK_DETAILED = "multi_ack_detailed";
    public static final String OPTION_NO_DONE = "no-done";
    public static final String OPTION_NO_PROGRESS = "no-progress";
    public static final String OPTION_OFS_DELTA = "ofs-delta";
    public static final String OPTION_SHALLOW = "shallow";
    public static final String OPTION_SIDE_BAND = "side-band";
    public static final String OPTION_SIDE_BAND_64K = "side-band-64k";
    public static final String OPTION_THIN_PACK = "thin-pack";
    final RevFlag ADVERTISED;
    final RevFlag COMMON;
    final RevFlag REACHABLE;
    private final RevFlag STATE;
    private boolean allowOfsDelta;
    private List<String> deepenNots;
    private Instant deepenSince;
    private Integer depth;
    private final FilterSpec filterSpec;
    private boolean includeTags;
    private String lockMessage;
    private int maxHaves;
    private GitProtocolConstants.MultiAck multiAck;
    private boolean noDone;
    private boolean noProgress;
    private PackLock packLock;
    private PacketLineOut pckState;
    private RevCommitList<RevCommit> reachableCommits;
    private boolean sideband;
    private TemporaryBuffer.Heap state;
    private boolean thinPack;
    private boolean useNegotiationTip;
    private final RevWalk walk;

    static /* synthetic */ String[] lambda$2(int i) {
        return new String[i];
    }

    @Override // org.eclipse.jgit.transport.FetchConnection
    public boolean didFetchIncludeTags() {
        return false;
    }

    @Override // org.eclipse.jgit.transport.FetchConnection
    public boolean didFetchTestConnectivity() {
        return false;
    }

    @Override // org.eclipse.jgit.transport.BasePackConnection, org.eclipse.jgit.transport.BaseConnection, org.eclipse.jgit.transport.Connection
    public /* bridge */ /* synthetic */ String getPeerUserAgent() {
        return super.getPeerUserAgent();
    }

    protected void onReceivePack() {
    }

    static /* synthetic */ int[] $SWITCH_TABLE$org$eclipse$jgit$transport$PacketLineIn$AckNackResult() {
        int[] iArr = $SWITCH_TABLE$org$eclipse$jgit$transport$PacketLineIn$AckNackResult;
        if (iArr != null) {
            return iArr;
        }
        int[] iArr2 = new int[PacketLineIn.AckNackResult.valuesCustom().length];
        try {
            iArr2[PacketLineIn.AckNackResult.ACK.ordinal()] = 2;
        } catch (NoSuchFieldError unused) {
        }
        try {
            iArr2[PacketLineIn.AckNackResult.ACK_COMMON.ordinal()] = 4;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            iArr2[PacketLineIn.AckNackResult.ACK_CONTINUE.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            iArr2[PacketLineIn.AckNackResult.ACK_READY.ordinal()] = 5;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            iArr2[PacketLineIn.AckNackResult.NAK.ordinal()] = 1;
        } catch (NoSuchFieldError unused5) {
        }
        $SWITCH_TABLE$org$eclipse$jgit$transport$PacketLineIn$AckNackResult = iArr2;
        return iArr2;
    }

    public BasePackFetchConnection(PackTransport packTransport) {
        super(packTransport);
        this.multiAck = GitProtocolConstants.MultiAck.OFF;
        if (this.local != null) {
            FetchConfig fetchConfig = getFetchConfig();
            this.allowOfsDelta = fetchConfig.allowOfsDelta;
            this.maxHaves = fetchConfig.maxHaves;
            this.useNegotiationTip = fetchConfig.useNegotiationTip;
        } else {
            this.allowOfsDelta = true;
            this.maxHaves = Integer.MAX_VALUE;
            this.useNegotiationTip = false;
        }
        this.includeTags = this.transport.getTagOpt() != TagOpt.NO_TAGS;
        this.thinPack = this.transport.isFetchThin();
        this.filterSpec = this.transport.getFilterSpec();
        this.depth = this.transport.getDepth();
        this.deepenSince = this.transport.getDeepenSince();
        this.deepenNots = this.transport.getDeepenNots();
        if (this.local != null) {
            RevWalk revWalk = new RevWalk(this.local);
            this.walk = revWalk;
            revWalk.setRetainBody(false);
            this.reachableCommits = new RevCommitList<>();
            RevFlag revFlagNewFlag = revWalk.newFlag("REACHABLE");
            this.REACHABLE = revFlagNewFlag;
            RevFlag revFlagNewFlag2 = revWalk.newFlag("COMMON");
            this.COMMON = revFlagNewFlag2;
            this.STATE = revWalk.newFlag("STATE");
            RevFlag revFlagNewFlag3 = revWalk.newFlag("ADVERTISED");
            this.ADVERTISED = revFlagNewFlag3;
            revWalk.carry(revFlagNewFlag2);
            revWalk.carry(revFlagNewFlag);
            revWalk.carry(revFlagNewFlag3);
            return;
        }
        this.walk = null;
        this.REACHABLE = null;
        this.COMMON = null;
        this.STATE = null;
        this.ADVERTISED = null;
    }

    static class FetchConfig {
        final boolean allowOfsDelta;
        final int maxHaves;
        final boolean useNegotiationTip;

        FetchConfig(Config config) {
            this.allowOfsDelta = config.getBoolean(ConfigConstants.CONFIG_REPACK_SECTION, "usedeltabaseoffset", true);
            this.maxHaves = config.getInt("fetch", "maxhaves", Integer.MAX_VALUE);
            this.useNegotiationTip = config.getBoolean("fetch", "usenegotiationtip", false);
        }

        FetchConfig(boolean z, int i) {
            this(z, i, false);
        }

        FetchConfig(boolean z, int i, boolean z2) {
            this.allowOfsDelta = z;
            this.maxHaves = i;
            this.useNegotiationTip = z2;
        }
    }

    @Override // org.eclipse.jgit.transport.FetchConnection
    public final void fetch(ProgressMonitor progressMonitor, Collection<Ref> collection, Set<ObjectId> set) throws TransportException {
        fetch(progressMonitor, collection, set, null);
    }

    @Override // org.eclipse.jgit.transport.FetchConnection
    public final void fetch(ProgressMonitor progressMonitor, Collection<Ref> collection, Set<ObjectId> set, OutputStream outputStream) throws TransportException {
        markStartedOperation();
        doFetch(progressMonitor, collection, set, outputStream);
    }

    @Override // org.eclipse.jgit.transport.FetchConnection
    public void setPackLockMessage(String str) {
        this.lockMessage = str;
    }

    @Override // org.eclipse.jgit.transport.FetchConnection
    public Collection<PackLock> getPackLocks() {
        PackLock packLock = this.packLock;
        if (packLock != null) {
            return Collections.singleton(packLock);
        }
        return Collections.emptyList();
    }

    private void clearState() {
        this.walk.dispose();
        this.reachableCommits = null;
        this.state = null;
        this.pckState = null;
    }

    protected void doFetch(ProgressMonitor progressMonitor, Collection<Ref> collection, Set<ObjectId> set, OutputStream outputStream) throws TransportException {
        boolean zIsEmpty = set.isEmpty();
        boolean z = !zIsEmpty;
        try {
            boolean z2 = true;
            this.noProgress = progressMonitor == NullProgressMonitor.INSTANCE;
            if (!zIsEmpty) {
                markRefsAdvertised();
            }
            markReachable(collection, set, maxTimeWanted(collection, z));
            if (TransferConfig.ProtocolVersion.V2.equals(getProtocolVersion())) {
                this.state = new TemporaryBuffer.Heap(Integer.MAX_VALUE);
                this.pckState = new PacketLineOut(this.state);
                try {
                    doFetchV2(progressMonitor, collection, outputStream, z);
                    return;
                } finally {
                    clearState();
                }
            }
            if (this.statelessRPC) {
                this.state = new TemporaryBuffer.Heap(Integer.MAX_VALUE);
                this.pckState = new PacketLineOut(this.state);
            }
            PacketLineOut packetLineOut = this.statelessRPC ? this.pckState : this.pckOut;
            if (sendWants(collection, packetLineOut, z)) {
                if (this.depth == null && this.deepenSince == null && this.deepenNots.isEmpty()) {
                    z2 = false;
                }
                Set<ObjectId> shallowCommits = this.local.getObjectDatabase().getShallowCommits();
                if (isCapableOf("shallow")) {
                    sendShallow(shallowCommits, packetLineOut);
                } else if (z2) {
                    throw new PackProtocolException(JGitText.get().shallowNotSupported);
                }
                packetLineOut.end();
                this.outNeedsEnd = false;
                negotiate(progressMonitor, z2, shallowCommits);
                clearState();
                receivePack(progressMonitor, outputStream);
            }
        } catch (IOException e) {
            e = e;
            close();
            throw new TransportException(e.getMessage(), e);
        } catch (RuntimeException e2) {
            e = e2;
            close();
            throw new TransportException(e.getMessage(), e);
        } catch (CancelledException unused) {
            close();
        }
    }

    private void doFetchV2(ProgressMonitor progressMonitor, Collection<Ref> collection, OutputStream outputStream, boolean z) throws IOException, CancelledException {
        boolean zSendNextHaveBatch;
        this.sideband = true;
        negotiateBegin();
        this.pckState.writeString("command=fetch");
        String str = UserAgent.get();
        if (str != null && isCapableOf(GitProtocolConstants.OPTION_AGENT)) {
            this.pckState.writeString("agent=" + str);
        }
        HashSet hashSet = new HashSet();
        String capability = getCapability("fetch");
        if (!StringUtils.isEmptyOrNull(capability)) {
            hashSet.addAll(Arrays.asList(capability.split(WalkEncryption.Vals.REGEX_WS)));
        }
        this.pckState.writeDelim();
        Iterator<String> it = getCapabilitiesV2(hashSet).iterator();
        while (it.hasNext()) {
            this.pckState.writeString(it.next());
        }
        if (sendWants(collection, this.pckState, z)) {
            Set<ObjectId> shallowCommits = this.local.getObjectDatabase().getShallowCommits();
            if (hashSet.contains("shallow")) {
                sendShallow(shallowCommits, this.pckState);
            } else if (this.depth != null || this.deepenSince != null || !this.deepenNots.isEmpty()) {
                throw new PackProtocolException(JGitText.get().shallowNotSupported);
            }
            this.outNeedsEnd = false;
            FetchStateV2 fetchStateV2 = new FetchStateV2(null);
            do {
                this.state.writeTo(this.out, progressMonitor);
                zSendNextHaveBatch = sendNextHaveBatch(fetchStateV2, this.pckOut, progressMonitor);
                if (zSendNextHaveBatch) {
                    break;
                }
            } while (!readAcknowledgments(fetchStateV2, this.pckIn, progressMonitor));
            clearState();
            String string = this.pckIn.readString();
            if (zSendNextHaveBatch && string.startsWith(GitProtocolConstants.PACKET_ERR)) {
                throw new RemoteRepositoryException(this.uri, string.substring(4));
            }
            if (GitProtocolConstants.SECTION_SHALLOW_INFO.equals(string)) {
                String strHandleShallowUnshallow = handleShallowUnshallow(shallowCommits, this.pckIn);
                if (!PacketLineIn.isDelimiter(strHandleShallowUnshallow)) {
                    throw new PackProtocolException(MessageFormat.format(JGitText.get().expectedGot, GitProtocolConstants.PACKET_DELIM, strHandleShallowUnshallow));
                }
                string = this.pckIn.readString();
            }
            if (!GitProtocolConstants.SECTION_PACKFILE.equals(string)) {
                throw new PackProtocolException(MessageFormat.format(JGitText.get().expectedGot, GitProtocolConstants.SECTION_PACKFILE, string));
            }
            receivePack(progressMonitor, outputStream);
        }
    }

    private boolean sendNextHaveBatch(FetchStateV2 fetchStateV2, PacketLineOut packetLineOut, ProgressMonitor progressMonitor) throws IOException, CancelledException {
        RevCommit next;
        long j = 0;
        while (j < fetchStateV2.havesToSend && (next = this.walk.next()) != null) {
            packetLineOut.writeString(GitProtocolConstants.PACKET_HAVE + next.getId().name() + "\n");
            j++;
            if (j % 10 == 0 && progressMonitor.isCancelled()) {
                throw new CancelledException(null);
            }
        }
        fetchStateV2.havesTotal += j;
        if (j == 0 || ((fetchStateV2.hadAcks && fetchStateV2.havesWithoutAck > 256) || fetchStateV2.havesTotal > this.maxHaves)) {
            packetLineOut.writeString("done\n");
            packetLineOut.end();
            return true;
        }
        fetchStateV2.havesWithoutAck += j;
        packetLineOut.end();
        fetchStateV2.incHavesToSend(this.statelessRPC);
        return false;
    }

    private boolean readAcknowledgments(FetchStateV2 fetchStateV2, PacketLineIn packetLineIn, ProgressMonitor progressMonitor) throws IOException, CancelledException {
        String string = packetLineIn.readString();
        if (!GitProtocolConstants.SECTION_ACKNOWLEDGMENTS.equals(string)) {
            throw new PackProtocolException(MessageFormat.format(JGitText.get().expectedGot, GitProtocolConstants.SECTION_ACKNOWLEDGMENTS, string));
        }
        MutableObjectId mutableObjectId = new MutableObjectId();
        String string2 = packetLineIn.readString();
        boolean z = false;
        long j = 0;
        while (!PacketLineIn.isEnd(string2) && !PacketLineIn.isDelimiter(string2)) {
            PacketLineIn.AckNackResult aCKv2 = PacketLineIn.parseACKv2(string2, mutableObjectId);
            if (!z) {
                if (aCKv2 == PacketLineIn.AckNackResult.ACK_COMMON) {
                    markCommon(this.walk.parseAny(mutableObjectId), aCKv2, true);
                    fetchStateV2.havesWithoutAck = 0L;
                    fetchStateV2.hadAcks = true;
                } else if (aCKv2 == PacketLineIn.AckNackResult.ACK_READY) {
                    z = true;
                }
            }
            j++;
            if (j % 10 == 0 && progressMonitor.isCancelled()) {
                throw new CancelledException(null);
            }
            string2 = packetLineIn.readString();
        }
        if (z) {
            if (!PacketLineIn.isDelimiter(string2)) {
                throw new PackProtocolException(MessageFormat.format(JGitText.get().expectedGot, GitProtocolConstants.PACKET_DELIM, string2));
            }
        } else if (!PacketLineIn.isEnd(string2)) {
            throw new PackProtocolException(MessageFormat.format(JGitText.get().expectedGot, "0000", string2));
        }
        return z;
    }

    @Override // org.eclipse.jgit.transport.BasePackConnection, org.eclipse.jgit.transport.BaseConnection, org.eclipse.jgit.transport.Connection, java.lang.AutoCloseable
    public void close() {
        RevWalk revWalk = this.walk;
        if (revWalk != null) {
            revWalk.close();
        }
        super.close();
    }

    FetchConfig getFetchConfig() {
        return (FetchConfig) this.local.getConfig().get(new BasePackFetchConnection$$ExternalSyntheticLambda0());
    }

    private int maxTimeWanted(Collection<Ref> collection, boolean z) {
        int commitTime;
        int i = 0;
        if (!z) {
            return 0;
        }
        Iterator<Ref> it = collection.iterator();
        while (it.hasNext()) {
            try {
                RevObject any = this.walk.parseAny(it.next().getObjectId());
                if ((any instanceof RevCommit) && i < (commitTime = ((RevCommit) any).getCommitTime())) {
                    i = commitTime;
                }
            } catch (IOException unused) {
            }
        }
        return i;
    }

    private void markReachable(Collection<Ref> collection, Set<ObjectId> set, int i) throws IOException {
        Collection<Ref> refs;
        if (this.useNegotiationTip) {
            refs = translateToLocalTips(collection);
            if (refs.size() < collection.size()) {
                refs.addAll(this.local.getRefDatabase().getRefs());
            }
        } else {
            refs = this.local.getRefDatabase().getRefs();
        }
        markReachableRefTips(refs);
        Iterator<ObjectId> it = this.local.getAdditionalHaves().iterator();
        while (it.hasNext()) {
            m5801lambda$6$orgeclipsejgittransportBasePackFetchConnection(it.next());
        }
        Iterator<ObjectId> it2 = set.iterator();
        while (it2.hasNext()) {
            m5801lambda$6$orgeclipsejgittransportBasePackFetchConnection(it2.next());
        }
        if (i <= 0) {
            return;
        }
        Date date = new Date(((long) i) * 1000);
        this.walk.sort(RevSort.COMMIT_TIME_DESC);
        this.walk.markStart(this.reachableCommits);
        this.walk.setRevFilter(CommitTimeRevFilter.after(date));
        while (true) {
            RevCommit next = this.walk.next();
            if (next == null) {
                return;
            }
            if (next.has(this.ADVERTISED) && !next.has(this.COMMON)) {
                next.add(this.COMMON);
                next.carry(this.COMMON);
                this.reachableCommits.add(next);
            }
        }
    }

    private Collection<Ref> translateToLocalTips(Collection<Ref> collection) throws IOException {
        return (Collection) this.local.getRefDatabase().exactRef((String[]) ((Set) collection.stream().map(new FileRepository$$ExternalSyntheticLambda1()).collect(Collectors.toSet())).toArray(new BasePackFetchConnection$$ExternalSyntheticLambda1())).values().stream().filter(new BasePackFetchConnection$$ExternalSyntheticLambda2()).collect(Collectors.toList());
    }

    static /* synthetic */ boolean lambda$3(Ref ref) {
        return getRefObjectId(ref) != null;
    }

    private void markReachableRefTips(Collection<Ref> collection) {
        collection.stream().map(new BasePackFetchConnection$$ExternalSyntheticLambda3()).filter(new BasePackFetchConnection$$ExternalSyntheticLambda4()).forEach(new BasePackFetchConnection$$ExternalSyntheticLambda5(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ObjectId getRefObjectId(Ref ref) {
        ObjectId peeledObjectId = ref.getPeeledObjectId();
        return peeledObjectId == null ? ref.getObjectId() : peeledObjectId;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: markReachable, reason: merged with bridge method [inline-methods] */
    public void m5801lambda$6$orgeclipsejgittransportBasePackFetchConnection(ObjectId objectId) {
        try {
            RevCommit commit = this.walk.parseCommit(objectId);
            if (commit.has(this.REACHABLE)) {
                return;
            }
            commit.add(this.REACHABLE);
            this.reachableCommits.add(commit);
        } catch (IOException unused) {
        }
    }

    private boolean sendWants(Collection<Ref> collection, PacketLineOut packetLineOut, boolean z) throws IOException {
        Iterator<Ref> it = collection.iterator();
        boolean z2 = true;
        while (it.hasNext()) {
            ObjectId objectId = it.next().getObjectId();
            if (objectId != null) {
                if (this.transport.getDepth() == null && z) {
                    try {
                        if (this.walk.parseAny(objectId).has(this.REACHABLE)) {
                        }
                    } catch (IOException unused) {
                    }
                }
                StringBuilder sb = new StringBuilder(46);
                sb.append(GitProtocolConstants.PACKET_WANT).append(objectId.name());
                if (z2 && TransferConfig.ProtocolVersion.V0.equals(getProtocolVersion())) {
                    sb.append(enableCapabilities());
                }
                sb.append('\n');
                packetLineOut.writeString(sb.toString());
                z2 = false;
            }
        }
        if (z2) {
            return false;
        }
        if (!this.filterSpec.isNoOp()) {
            packetLineOut.writeString(this.filterSpec.filterLine());
        }
        return true;
    }

    private Set<String> getCapabilitiesV2(Set<String> set) throws TransportException {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        if (this.noProgress) {
            linkedHashSet.add("no-progress");
        }
        if (this.includeTags) {
            linkedHashSet.add("include-tag");
        }
        if (this.allowOfsDelta) {
            linkedHashSet.add("ofs-delta");
        }
        if (this.thinPack) {
            linkedHashSet.add("thin-pack");
        }
        if (this.filterSpec.isNoOp() || set.contains("filter")) {
            return linkedHashSet;
        }
        throw new PackProtocolException(this.uri, JGitText.get().filterRequiresCapability);
    }

    private String enableCapabilities() throws TransportException {
        StringBuilder sb = new StringBuilder();
        if (this.noProgress) {
            wantCapability(sb, "no-progress");
        }
        if (this.includeTags) {
            this.includeTags = wantCapability(sb, "include-tag");
        }
        if (this.allowOfsDelta) {
            wantCapability(sb, "ofs-delta");
        }
        if (wantCapability(sb, "multi_ack_detailed")) {
            this.multiAck = GitProtocolConstants.MultiAck.DETAILED;
            if (this.statelessRPC) {
                this.noDone = wantCapability(sb, "no-done");
            }
        } else if (wantCapability(sb, "multi_ack")) {
            this.multiAck = GitProtocolConstants.MultiAck.CONTINUE;
        } else {
            this.multiAck = GitProtocolConstants.MultiAck.OFF;
        }
        if (this.thinPack) {
            this.thinPack = wantCapability(sb, "thin-pack");
        }
        if (wantCapability(sb, "side-band-64k") || wantCapability(sb, "side-band")) {
            this.sideband = true;
        }
        if (this.statelessRPC && this.multiAck != GitProtocolConstants.MultiAck.DETAILED) {
            throw new PackProtocolException(this.uri, MessageFormat.format(JGitText.get().statelessRPCRequiresOptionToBeEnabled, "multi_ack_detailed"));
        }
        if (!this.filterSpec.isNoOp() && !wantCapability(sb, "filter")) {
            throw new PackProtocolException(this.uri, JGitText.get().filterRequiresCapability);
        }
        addUserAgentCapability(sb);
        return sb.toString();
    }

    private void negotiate(ProgressMonitor progressMonitor, boolean z, Set<ObjectId> set) throws IOException, CancelledException {
        int i;
        MutableObjectId mutableObjectId = new MutableObjectId();
        if (this.statelessRPC) {
            this.state.writeTo(this.out, null);
        }
        negotiateBegin();
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        loop0: while (true) {
            RevCommit next = this.walk.next();
            if (next != null) {
                this.pckOut.writeString(GitProtocolConstants.PACKET_HAVE + next.getId().name() + "\n");
                i2++;
                i3++;
                if ((i2 & 31) == 0) {
                    if (progressMonitor.isCancelled()) {
                        throw new CancelledException(null);
                    }
                    this.pckOut.end();
                    int i5 = i4 + 1;
                    if (i2 != 32 || this.statelessRPC) {
                        while (true) {
                            PacketLineIn.AckNackResult ack = this.pckIn.readACK(mutableObjectId);
                            int i6 = $SWITCH_TABLE$org$eclipse$jgit$transport$PacketLineIn$AckNackResult()[ack.ordinal()];
                            if (i6 != 1) {
                                if (i6 == 2) {
                                    this.multiAck = GitProtocolConstants.MultiAck.OFF;
                                    if (this.statelessRPC) {
                                        this.state.writeTo(this.out, null);
                                    }
                                    z4 = true;
                                    i = 0;
                                    break loop0;
                                }
                                if (i6 == 3 || i6 == 4 || i6 == 5) {
                                    markCommon(this.walk.parseAny(mutableObjectId), ack, this.statelessRPC);
                                    if (ack == PacketLineIn.AckNackResult.ACK_READY) {
                                        z2 = true;
                                        z3 = true;
                                    } else {
                                        z3 = true;
                                    }
                                    z4 = z3;
                                    i3 = 0;
                                }
                                if (progressMonitor.isCancelled()) {
                                    throw new CancelledException(null);
                                }
                            } else if (!this.noDone || !z2) {
                                if (this.statelessRPC) {
                                    this.state.writeTo(this.out, null);
                                }
                                if ((!z3 || i3 <= 256) && i2 < this.maxHaves) {
                                }
                            }
                        }
                    } else {
                        i4 = i5;
                    }
                }
            }
            i = i4;
            break;
        }
        if (progressMonitor.isCancelled()) {
            throw new CancelledException(null);
        }
        if (!z2 || !this.noDone) {
            this.pckOut.writeString("done\n");
            this.pckOut.flush();
        }
        if (!z4) {
            this.multiAck = GitProtocolConstants.MultiAck.OFF;
            i++;
        }
        if (z) {
            String strHandleShallowUnshallow = handleShallowUnshallow(set, this.pckIn);
            if (!PacketLineIn.isEnd(strHandleShallowUnshallow)) {
                throw new PackProtocolException(MessageFormat.format(JGitText.get().expectedGot, "0000", strHandleShallowUnshallow));
            }
        }
        do {
            if (i <= 0 && this.multiAck == GitProtocolConstants.MultiAck.OFF) {
                return;
            }
            i--;
            int i7 = $SWITCH_TABLE$org$eclipse$jgit$transport$PacketLineIn$AckNackResult()[this.pckIn.readACK(mutableObjectId).ordinal()];
            if (i7 == 2) {
                return;
            }
            if (i7 == 3 || i7 == 4 || i7 == 5) {
                this.multiAck = GitProtocolConstants.MultiAck.CONTINUE;
            }
        } while (!progressMonitor.isCancelled());
        throw new CancelledException(null);
    }

    private void negotiateBegin() throws IOException {
        this.walk.resetRetain(this.REACHABLE, this.ADVERTISED);
        this.walk.markStart(this.reachableCommits);
        this.walk.sort(RevSort.COMMIT_TIME_DESC);
        this.walk.setRevFilter(new AnonymousClass1());
    }

    /* JADX INFO: renamed from: org.eclipse.jgit.transport.BasePackFetchConnection$1, reason: invalid class name */
    class AnonymousClass1 extends RevFilter {
        @Override // org.eclipse.jgit.revwalk.filter.RevFilter
        public RevFilter clone() {
            return this;
        }

        @Override // org.eclipse.jgit.revwalk.filter.RevFilter
        public boolean requiresCommitBody() {
            return false;
        }

        AnonymousClass1() {
        }

        @Override // org.eclipse.jgit.revwalk.filter.RevFilter
        public boolean include(RevWalk revWalk, RevCommit revCommit) {
            boolean zHas = revCommit.has(BasePackFetchConnection.this.COMMON);
            if (revCommit.has(BasePackFetchConnection.this.ADVERTISED)) {
                revCommit.add(BasePackFetchConnection.this.COMMON);
            }
            return !zHas;
        }
    }

    private void markRefsAdvertised() {
        for (Ref ref : getRefs()) {
            markAdvertised(ref.getObjectId());
            if (ref.getPeeledObjectId() != null) {
                markAdvertised(ref.getPeeledObjectId());
            }
        }
    }

    private void markAdvertised(AnyObjectId anyObjectId) {
        try {
            this.walk.parseAny(anyObjectId).add(this.ADVERTISED);
        } catch (IOException unused) {
        }
    }

    private void markCommon(RevObject revObject, PacketLineIn.AckNackResult ackNackResult, boolean z) throws IOException {
        if (z && ackNackResult == PacketLineIn.AckNackResult.ACK_COMMON && !revObject.has(this.STATE)) {
            this.pckState.writeString(GitProtocolConstants.PACKET_HAVE + revObject.name() + "\n");
            revObject.add(this.STATE);
        }
        revObject.add(this.COMMON);
        if (revObject instanceof RevCommit) {
            ((RevCommit) revObject).carry(this.COMMON);
        }
    }

    private void receivePack(ProgressMonitor progressMonitor, OutputStream outputStream) throws IOException {
        SideBandInputStream sideBandInputStream;
        onReceivePack();
        InputStream inputStream = this.in;
        Throwable th = null;
        if (this.sideband) {
            sideBandInputStream = new SideBandInputStream(inputStream, progressMonitor, getMessageWriter(), outputStream);
            inputStream = sideBandInputStream;
        } else {
            sideBandInputStream = null;
        }
        try {
            ObjectInserter objectInserterNewObjectInserter = this.local.newObjectInserter();
            try {
                PackParser packParserNewPackParser = objectInserterNewObjectInserter.newPackParser(inputStream);
                packParserNewPackParser.setAllowThin(this.thinPack);
                packParserNewPackParser.setObjectChecker(this.transport.getObjectChecker());
                packParserNewPackParser.setLockMessage(this.lockMessage);
                this.packLock = packParserNewPackParser.parse(progressMonitor);
                objectInserterNewObjectInserter.flush();
                if (objectInserterNewObjectInserter != null) {
                    objectInserterNewObjectInserter.close();
                }
                if (sideBandInputStream != null) {
                    sideBandInputStream.drainMessages();
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
                try {
                    th.addSuppressed(th3);
                } catch (Throwable th4) {
                    if (sideBandInputStream != null) {
                        sideBandInputStream.drainMessages();
                    }
                    throw th4;
                }
            }
            throw null;
        }
    }

    private void sendShallow(Set<ObjectId> set, PacketLineOut packetLineOut) throws IOException {
        Iterator<ObjectId> it = set.iterator();
        while (it.hasNext()) {
            packetLineOut.writeString(GitProtocolConstants.PACKET_SHALLOW + it.next().name());
        }
        Integer num = this.depth;
        if (num != null) {
            packetLineOut.writeString(GitProtocolConstants.PACKET_DEEPEN + String.valueOf(num));
        }
        Instant instant = this.deepenSince;
        if (instant != null) {
            packetLineOut.writeString(GitProtocolConstants.PACKET_DEEPEN_SINCE + instant.getEpochSecond());
        }
        List<String> list = this.deepenNots;
        if (list != null) {
            Iterator<String> it2 = list.iterator();
            while (it2.hasNext()) {
                packetLineOut.writeString(GitProtocolConstants.PACKET_DEEPEN_NOT + it2.next());
            }
        }
    }

    private String handleShallowUnshallow(Set<ObjectId> set, PacketLineIn packetLineIn) throws IOException {
        String string = packetLineIn.readString();
        ObjectDatabase objectDatabase = this.local.getObjectDatabase();
        HashSet hashSet = new HashSet(set);
        while (!PacketLineIn.isDelimiter(string) && !PacketLineIn.isEnd(string)) {
            if (string.startsWith(GitProtocolConstants.PACKET_SHALLOW)) {
                hashSet.add(ObjectId.fromString(string.substring(GitProtocolConstants.PACKET_SHALLOW.length())));
            } else if (string.startsWith(GitProtocolConstants.PACKET_UNSHALLOW)) {
                ObjectId objectIdFromString = ObjectId.fromString(string.substring(GitProtocolConstants.PACKET_UNSHALLOW.length()));
                if (!set.contains(objectIdFromString)) {
                    throw new PackProtocolException(MessageFormat.format(JGitText.get().notShallowedUnshallow, objectIdFromString.name()));
                }
                hashSet.remove(objectIdFromString);
            } else {
                continue;
            }
            string = packetLineIn.readString();
        }
        objectDatabase.setShallowCommits(hashSet);
        return string;
    }

    private static class CancelledException extends Exception {
        private static final long serialVersionUID = 1;

        /* synthetic */ CancelledException(BasePackFetchConnectionIA basePackFetchConnectionIA) {
            this();
        }

        private CancelledException() {
        }
    }

    private static class FetchStateV2 {
        boolean hadAcks;
        long havesToSend;
        long havesTotal;
        long havesWithoutAck;

        /* synthetic */ FetchStateV2(BasePackFetchConnectionIA basePackFetchConnectionIA) {
            this();
        }

        private FetchStateV2() {
            this.havesToSend = 32L;
        }

        void incHavesToSend(boolean z) {
            if (z) {
                long j = this.havesToSend;
                if (j < 16384) {
                    this.havesToSend = j * 2;
                    return;
                } else {
                    this.havesToSend = (j * 11) / 10;
                    return;
                }
            }
            this.havesToSend += 32;
        }
    }
}
