package org.eclipse.jgit.lib;

import java.io.IOException;
import java.text.MessageFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.TimeoutException;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.eclipse.jgit.annotations.Nullable;
import org.eclipse.jgit.errors.MissingObjectException;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.revwalk.RevWalk;
import org.eclipse.jgit.transport.PushCertificate;
import org.eclipse.jgit.transport.ReceiveCommand;
import org.eclipse.jgit.util.time.ProposedTimestamp;

/* JADX INFO: loaded from: classes5.dex */
public class BatchRefUpdate {
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$org$eclipse$jgit$transport$ReceiveCommand$Type;
    protected static final Duration MAX_WAIT = Duration.ofSeconds(5);
    private boolean allowNonFastForwards;
    private boolean atomic;
    private final List<ReceiveCommand> commands = new ArrayList();
    private boolean forceRefLog;
    private PushCertificate pushCert;
    private List<String> pushOptions;
    private PersonIdent refLogIdent;
    private boolean refLogIncludeResult;
    private String refLogMessage;
    private final RefDatabase refdb;
    private List<ProposedTimestamp> timestamps;

    static /* synthetic */ int[] $SWITCH_TABLE$org$eclipse$jgit$transport$ReceiveCommand$Type() {
        int[] iArr = $SWITCH_TABLE$org$eclipse$jgit$transport$ReceiveCommand$Type;
        if (iArr != null) {
            return iArr;
        }
        int[] iArr2 = new int[ReceiveCommand.Type.valuesCustom().length];
        try {
            iArr2[ReceiveCommand.Type.CREATE.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            iArr2[ReceiveCommand.Type.DELETE.ordinal()] = 4;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            iArr2[ReceiveCommand.Type.UPDATE.ordinal()] = 2;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            iArr2[ReceiveCommand.Type.UPDATE_NONFASTFORWARD.ordinal()] = 3;
        } catch (NoSuchFieldError unused4) {
        }
        $SWITCH_TABLE$org$eclipse$jgit$transport$ReceiveCommand$Type = iArr2;
        return iArr2;
    }

    protected BatchRefUpdate(RefDatabase refDatabase) {
        this.refdb = refDatabase;
        this.atomic = refDatabase.performsAtomicTransactions();
    }

    public boolean isAllowNonFastForwards() {
        return this.allowNonFastForwards;
    }

    public BatchRefUpdate setAllowNonFastForwards(boolean z) {
        this.allowNonFastForwards = z;
        return this;
    }

    public PersonIdent getRefLogIdent() {
        return this.refLogIdent;
    }

    public BatchRefUpdate setRefLogIdent(PersonIdent personIdent) {
        this.refLogIdent = personIdent;
        return this;
    }

    @Nullable
    public String getRefLogMessage() {
        return this.refLogMessage;
    }

    public boolean isRefLogIncludingResult() {
        return this.refLogIncludeResult;
    }

    public BatchRefUpdate setRefLogMessage(String str, boolean z) {
        if (str == null && !z) {
            disableRefLog();
            return this;
        }
        if (str == null && z) {
            this.refLogMessage = "";
            this.refLogIncludeResult = true;
            return this;
        }
        this.refLogMessage = str;
        this.refLogIncludeResult = z;
        return this;
    }

    public BatchRefUpdate disableRefLog() {
        this.refLogMessage = null;
        this.refLogIncludeResult = false;
        return this;
    }

    public BatchRefUpdate setForceRefLog(boolean z) {
        this.forceRefLog = z;
        return this;
    }

    public boolean isRefLogDisabled() {
        return this.refLogMessage == null;
    }

    protected boolean isForceRefLog() {
        return this.forceRefLog;
    }

    public BatchRefUpdate setAtomic(boolean z) {
        this.atomic = z;
        return this;
    }

    public boolean isAtomic() {
        return this.atomic;
    }

    public void setPushCertificate(PushCertificate pushCertificate) {
        this.pushCert = pushCertificate;
    }

    protected PushCertificate getPushCertificate() {
        return this.pushCert;
    }

    public List<ReceiveCommand> getCommands() {
        return Collections.unmodifiableList(this.commands);
    }

    public BatchRefUpdate addCommand(ReceiveCommand receiveCommand) {
        this.commands.add(receiveCommand);
        return this;
    }

    public BatchRefUpdate addCommand(ReceiveCommand... receiveCommandArr) {
        return addCommand(Arrays.asList(receiveCommandArr));
    }

    public BatchRefUpdate addCommand(Collection<ReceiveCommand> collection) {
        this.commands.addAll(collection);
        return this;
    }

    @Nullable
    public List<String> getPushOptions() {
        return this.pushOptions;
    }

    protected void setPushOptions(List<String> list) {
        this.pushOptions = list;
    }

    public List<ProposedTimestamp> getProposedTimestamps() {
        List<ProposedTimestamp> list = this.timestamps;
        if (list != null) {
            return Collections.unmodifiableList(list);
        }
        return Collections.emptyList();
    }

    public BatchRefUpdate addProposedTimestamp(ProposedTimestamp proposedTimestamp) {
        if (this.timestamps == null) {
            this.timestamps = new ArrayList(4);
        }
        this.timestamps.add(proposedTimestamp);
        return this;
    }

    public void execute(RevWalk revWalk, ProgressMonitor progressMonitor, List<String> list) throws IOException {
        if (this.atomic && !this.refdb.performsAtomicTransactions()) {
            for (ReceiveCommand receiveCommand : this.commands) {
                if (receiveCommand.getResult() == ReceiveCommand.Result.NOT_ATTEMPTED) {
                    receiveCommand.setResult(ReceiveCommand.Result.REJECTED_OTHER_REASON, JGitText.get().atomicRefUpdatesNotSupported);
                }
            }
            return;
        }
        if (blockUntilTimestamps(MAX_WAIT)) {
            if (list != null) {
                setPushOptions(list);
            }
            progressMonitor.beginTask(JGitText.get().updatingReferences, this.commands.size());
            ArrayList<ReceiveCommand> arrayList = new ArrayList(this.commands.size());
            for (ReceiveCommand receiveCommand2 : this.commands) {
                try {
                    if (receiveCommand2.getResult() == ReceiveCommand.Result.NOT_ATTEMPTED) {
                        if (isMissing(revWalk, receiveCommand2.getOldId()) || isMissing(revWalk, receiveCommand2.getNewId())) {
                            receiveCommand2.setResult(ReceiveCommand.Result.REJECTED_MISSING_OBJECT);
                        } else {
                            receiveCommand2.updateType(revWalk);
                            int i = $SWITCH_TABLE$org$eclipse$jgit$transport$ReceiveCommand$Type()[receiveCommand2.getType().ordinal()];
                            if (i == 1) {
                                arrayList.add(receiveCommand2);
                            } else if (i == 2 || i == 3) {
                                arrayList.add(receiveCommand2);
                            } else if (i == 4) {
                                RefUpdate refUpdateNewUpdate = newUpdate(receiveCommand2);
                                progressMonitor.update(1);
                                receiveCommand2.setResult(refUpdateNewUpdate.delete(revWalk));
                            }
                        }
                    }
                } catch (IOException e) {
                    receiveCommand2.setResult(ReceiveCommand.Result.REJECTED_OTHER_REASON, MessageFormat.format(JGitText.get().lockError, e.getMessage()));
                }
            }
            if (!arrayList.isEmpty()) {
                for (ReceiveCommand receiveCommand3 : arrayList) {
                    try {
                        try {
                            if (receiveCommand3.getResult() == ReceiveCommand.Result.NOT_ATTEMPTED) {
                                receiveCommand3.updateType(revWalk);
                                int i2 = $SWITCH_TABLE$org$eclipse$jgit$transport$ReceiveCommand$Type()[receiveCommand3.getType().ordinal()];
                                if (i2 == 1 || i2 == 2 || i2 == 3) {
                                    receiveCommand3.setResult(newUpdate(receiveCommand3).update(revWalk));
                                }
                            }
                        } catch (Throwable th) {
                            progressMonitor.update(1);
                            throw th;
                        }
                    } catch (IOException e2) {
                        receiveCommand3.setResult(ReceiveCommand.Result.REJECTED_OTHER_REASON, MessageFormat.format(JGitText.get().lockError, e2.getMessage()));
                    }
                    progressMonitor.update(1);
                }
            }
            progressMonitor.endTask();
        }
    }

    protected RefDatabase getRefDatabase() {
        return this.refdb;
    }

    private static boolean isMissing(RevWalk revWalk, ObjectId objectId) throws IOException {
        if (objectId.equals((AnyObjectId) ObjectId.zeroId())) {
            return false;
        }
        try {
            revWalk.parseAny(objectId);
            return false;
        } catch (MissingObjectException unused) {
            return true;
        }
    }

    protected boolean blockUntilTimestamps(Duration duration) {
        List<ProposedTimestamp> list = this.timestamps;
        if (list == null) {
            return true;
        }
        try {
            ProposedTimestamp.blockUntil(list, duration);
            return true;
        } catch (InterruptedException | TimeoutException unused) {
            String str = JGitText.get().timeIsUncertain;
            for (ReceiveCommand receiveCommand : this.commands) {
                if (receiveCommand.getResult() == ReceiveCommand.Result.NOT_ATTEMPTED) {
                    receiveCommand.setResult(ReceiveCommand.Result.REJECTED_OTHER_REASON, str);
                }
            }
            return false;
        }
    }

    public void execute(RevWalk revWalk, ProgressMonitor progressMonitor) throws IOException {
        execute(revWalk, progressMonitor, null);
    }

    protected static Collection<String> getPrefixes(String str) {
        HashSet hashSet = new HashSet();
        addPrefixesTo(str, hashSet);
        return hashSet;
    }

    protected static void addPrefixesTo(String str, Collection<String> collection) {
        int iIndexOf = str.indexOf(47);
        while (iIndexOf > 0) {
            collection.add(str.substring(0, iIndexOf));
            iIndexOf = str.indexOf(47, iIndexOf + 1);
        }
    }

    protected RefUpdate newUpdate(ReceiveCommand receiveCommand) throws IOException {
        RefUpdate refUpdateNewUpdate = this.refdb.newUpdate(receiveCommand.getRefName(), false);
        if (isRefLogDisabled(receiveCommand)) {
            refUpdateNewUpdate.disableRefLog();
        } else {
            refUpdateNewUpdate.setRefLogIdent(this.refLogIdent);
            refUpdateNewUpdate.setRefLogMessage(getRefLogMessage(receiveCommand), isRefLogIncludingResult(receiveCommand));
            refUpdateNewUpdate.setForceRefLog(isForceRefLog(receiveCommand));
        }
        refUpdateNewUpdate.setPushCertificate(this.pushCert);
        if ($SWITCH_TABLE$org$eclipse$jgit$transport$ReceiveCommand$Type()[receiveCommand.getType().ordinal()] == 4) {
            if (!ObjectId.zeroId().equals((AnyObjectId) receiveCommand.getOldId())) {
                refUpdateNewUpdate.setExpectedOldObjectId(receiveCommand.getOldId());
            }
            refUpdateNewUpdate.setForceUpdate(true);
            return refUpdateNewUpdate;
        }
        refUpdateNewUpdate.setForceUpdate(isAllowNonFastForwards());
        refUpdateNewUpdate.setExpectedOldObjectId(receiveCommand.getOldId());
        refUpdateNewUpdate.setNewObjectId(receiveCommand.getNewId());
        return refUpdateNewUpdate;
    }

    protected boolean isRefLogDisabled(ReceiveCommand receiveCommand) {
        return receiveCommand.hasCustomRefLog() ? receiveCommand.isRefLogDisabled() : isRefLogDisabled();
    }

    protected String getRefLogMessage(ReceiveCommand receiveCommand) {
        return receiveCommand.hasCustomRefLog() ? receiveCommand.getRefLogMessage() : getRefLogMessage();
    }

    protected boolean isRefLogIncludingResult(ReceiveCommand receiveCommand) {
        return receiveCommand.hasCustomRefLog() ? receiveCommand.isRefLogIncludingResult() : isRefLogIncludingResult();
    }

    protected boolean isForceRefLog(ReceiveCommand receiveCommand) {
        Boolean boolIsForceRefLog = receiveCommand.isForceRefLog();
        if (boolIsForceRefLog != null) {
            return boolIsForceRefLog.booleanValue();
        }
        return isForceRefLog();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName()).append(AbstractJsonLexerKt.BEGIN_LIST);
        if (this.commands.isEmpty()) {
            return sb.append(AbstractJsonLexerKt.END_LIST).toString();
        }
        sb.append('\n');
        for (ReceiveCommand receiveCommand : this.commands) {
            sb.append("  ");
            sb.append(receiveCommand);
            sb.append("  (").append(receiveCommand.getResult());
            if (receiveCommand.getMessage() != null) {
                sb.append(": ").append(receiveCommand.getMessage());
            }
            sb.append(")\n");
        }
        return sb.append(AbstractJsonLexerKt.END_LIST).toString();
    }
}
