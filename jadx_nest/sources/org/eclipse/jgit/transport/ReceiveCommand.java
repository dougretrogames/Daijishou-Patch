package org.eclipse.jgit.transport;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.eclipse.jgit.annotations.Nullable;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.lib.AnyObjectId;
import org.eclipse.jgit.lib.ConfigConstants;
import org.eclipse.jgit.lib.ObjectId;
import org.eclipse.jgit.lib.Ref;
import org.eclipse.jgit.lib.RefUpdate;
import org.eclipse.jgit.revwalk.RevCommit;
import org.eclipse.jgit.revwalk.RevObject;
import org.eclipse.jgit.revwalk.RevWalk;

/* JADX INFO: loaded from: classes5.dex */
public class ReceiveCommand {
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$org$eclipse$jgit$lib$RefUpdate$Result;
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$org$eclipse$jgit$transport$ReceiveCommand$Type;
    private boolean customRefLog;
    private Boolean forceRefLog;
    private String message;
    private final String name;
    private final ObjectId newId;
    private final String newSymref;
    private final ObjectId oldId;
    private final String oldSymref;
    private Ref ref;
    private boolean refLogIncludeResult;
    private String refLogMessage;
    private Result status = Result.NOT_ATTEMPTED;
    private Type type;
    private boolean typeIsCorrect;

    public enum Result {
        NOT_ATTEMPTED,
        REJECTED_NOCREATE,
        REJECTED_NODELETE,
        REJECTED_NONFASTFORWARD,
        REJECTED_CURRENT_BRANCH,
        REJECTED_MISSING_OBJECT,
        REJECTED_OTHER_REASON,
        LOCK_FAILURE,
        OK;

        /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
        public static Result[] valuesCustom() {
            Result[] resultArrValuesCustom = values();
            int length = resultArrValuesCustom.length;
            Result[] resultArr = new Result[length];
            System.arraycopy(resultArrValuesCustom, 0, resultArr, 0, length);
            return resultArr;
        }
    }

    public enum Type {
        CREATE,
        UPDATE,
        UPDATE_NONFASTFORWARD,
        DELETE;

        /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
        public static Type[] valuesCustom() {
            Type[] typeArrValuesCustom = values();
            int length = typeArrValuesCustom.length;
            Type[] typeArr = new Type[length];
            System.arraycopy(typeArrValuesCustom, 0, typeArr, 0, length);
            return typeArr;
        }
    }

    static /* synthetic */ int[] $SWITCH_TABLE$org$eclipse$jgit$lib$RefUpdate$Result() {
        int[] iArr = $SWITCH_TABLE$org$eclipse$jgit$lib$RefUpdate$Result;
        if (iArr != null) {
            return iArr;
        }
        int[] iArr2 = new int[RefUpdate.Result.valuesCustom().length];
        try {
            iArr2[RefUpdate.Result.FAST_FORWARD.ordinal()] = 6;
        } catch (NoSuchFieldError unused) {
        }
        try {
            iArr2[RefUpdate.Result.FORCED.ordinal()] = 5;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            iArr2[RefUpdate.Result.IO_FAILURE.ordinal()] = 9;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            iArr2[RefUpdate.Result.LOCK_FAILURE.ordinal()] = 2;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            iArr2[RefUpdate.Result.NEW.ordinal()] = 4;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            iArr2[RefUpdate.Result.NOT_ATTEMPTED.ordinal()] = 1;
        } catch (NoSuchFieldError unused6) {
        }
        try {
            iArr2[RefUpdate.Result.NO_CHANGE.ordinal()] = 3;
        } catch (NoSuchFieldError unused7) {
        }
        try {
            iArr2[RefUpdate.Result.REJECTED.ordinal()] = 7;
        } catch (NoSuchFieldError unused8) {
        }
        try {
            iArr2[RefUpdate.Result.REJECTED_CURRENT_BRANCH.ordinal()] = 8;
        } catch (NoSuchFieldError unused9) {
        }
        try {
            iArr2[RefUpdate.Result.REJECTED_MISSING_OBJECT.ordinal()] = 11;
        } catch (NoSuchFieldError unused10) {
        }
        try {
            iArr2[RefUpdate.Result.REJECTED_OTHER_REASON.ordinal()] = 12;
        } catch (NoSuchFieldError unused11) {
        }
        try {
            iArr2[RefUpdate.Result.RENAMED.ordinal()] = 10;
        } catch (NoSuchFieldError unused12) {
        }
        $SWITCH_TABLE$org$eclipse$jgit$lib$RefUpdate$Result = iArr2;
        return iArr2;
    }

    static /* synthetic */ int[] $SWITCH_TABLE$org$eclipse$jgit$transport$ReceiveCommand$Type() {
        int[] iArr = $SWITCH_TABLE$org$eclipse$jgit$transport$ReceiveCommand$Type;
        if (iArr != null) {
            return iArr;
        }
        int[] iArr2 = new int[Type.valuesCustom().length];
        try {
            iArr2[Type.CREATE.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            iArr2[Type.DELETE.ordinal()] = 4;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            iArr2[Type.UPDATE.ordinal()] = 2;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            iArr2[Type.UPDATE_NONFASTFORWARD.ordinal()] = 3;
        } catch (NoSuchFieldError unused4) {
        }
        $SWITCH_TABLE$org$eclipse$jgit$transport$ReceiveCommand$Type = iArr2;
        return iArr2;
    }

    public static List<ReceiveCommand> filter(Iterable<ReceiveCommand> iterable, Result result) {
        ArrayList arrayList;
        if (iterable instanceof Collection) {
            arrayList = new ArrayList(((Collection) iterable).size());
        } else {
            arrayList = new ArrayList();
        }
        for (ReceiveCommand receiveCommand : iterable) {
            if (receiveCommand.getResult() == result) {
                arrayList.add(receiveCommand);
            }
        }
        return arrayList;
    }

    public static List<ReceiveCommand> filter(List<ReceiveCommand> list, Result result) {
        return filter((Iterable<ReceiveCommand>) list, result);
    }

    public static void abort(Iterable<ReceiveCommand> iterable) {
        for (ReceiveCommand receiveCommand : iterable) {
            if (receiveCommand.getResult() == Result.NOT_ATTEMPTED) {
                receiveCommand.setResult(Result.REJECTED_OTHER_REASON, JGitText.get().transactionAborted);
            }
        }
    }

    public static boolean isTransactionAborted(ReceiveCommand receiveCommand) {
        return receiveCommand.getResult() == Result.REJECTED_OTHER_REASON && receiveCommand.getMessage().equals(JGitText.get().transactionAborted);
    }

    public static ReceiveCommand link(ObjectId objectId, String str, String str2) {
        return new ReceiveCommand(objectId, str, str2);
    }

    public static ReceiveCommand link(@Nullable String str, String str2, String str3) {
        return new ReceiveCommand(str, str2, str3);
    }

    public static ReceiveCommand unlink(String str, ObjectId objectId, String str2) {
        return new ReceiveCommand(str, objectId, str2);
    }

    public ReceiveCommand(ObjectId objectId, ObjectId objectId2, String str) {
        if (objectId == null) {
            throw new IllegalArgumentException(JGitText.get().oldIdMustNotBeNull);
        }
        if (objectId2 == null) {
            throw new IllegalArgumentException(JGitText.get().newIdMustNotBeNull);
        }
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException(JGitText.get().nameMustNotBeNullOrEmpty);
        }
        this.oldId = objectId;
        this.oldSymref = null;
        this.newId = objectId2;
        this.newSymref = null;
        this.name = str;
        this.type = Type.UPDATE;
        if (ObjectId.zeroId().equals((AnyObjectId) objectId)) {
            this.type = Type.CREATE;
        }
        if (ObjectId.zeroId().equals((AnyObjectId) objectId2)) {
            this.type = Type.DELETE;
        }
    }

    public ReceiveCommand(ObjectId objectId, ObjectId objectId2, String str, Type type) {
        if (objectId == null) {
            throw new IllegalArgumentException(JGitText.get().oldIdMustNotBeNull);
        }
        if (objectId2 == null) {
            throw new IllegalArgumentException(JGitText.get().newIdMustNotBeNull);
        }
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException(JGitText.get().nameMustNotBeNullOrEmpty);
        }
        this.oldId = objectId;
        this.oldSymref = null;
        this.newId = objectId2;
        this.newSymref = null;
        this.name = str;
        int i = $SWITCH_TABLE$org$eclipse$jgit$transport$ReceiveCommand$Type()[type.ordinal()];
        if (i != 1) {
            if (i == 2 || i == 3) {
                if (ObjectId.zeroId().equals((AnyObjectId) objectId2) || ObjectId.zeroId().equals((AnyObjectId) objectId)) {
                    throw new IllegalArgumentException(JGitText.get().updateRequiresOldIdAndNewId);
                }
            } else if (i == 4) {
                if (!ObjectId.zeroId().equals((AnyObjectId) objectId2)) {
                    throw new IllegalArgumentException(JGitText.get().deleteRequiresZeroNewId);
                }
            } else {
                throw new IllegalStateException(JGitText.get().enumValueNotSupported0);
            }
        } else if (!ObjectId.zeroId().equals((AnyObjectId) objectId)) {
            throw new IllegalArgumentException(JGitText.get().createRequiresZeroOldId);
        }
        this.type = type;
    }

    private ReceiveCommand(ObjectId objectId, String str, String str2) {
        if (objectId == null) {
            throw new IllegalArgumentException(JGitText.get().oldIdMustNotBeNull);
        }
        if (str2 == null || str2.isEmpty()) {
            throw new IllegalArgumentException(JGitText.get().nameMustNotBeNullOrEmpty);
        }
        this.oldId = objectId;
        this.oldSymref = null;
        this.newId = ObjectId.zeroId();
        this.newSymref = str;
        this.name = str2;
        if (AnyObjectId.isEqual(ObjectId.zeroId(), objectId)) {
            this.type = Type.CREATE;
        } else if (str != null) {
            this.type = Type.UPDATE;
        } else {
            this.type = Type.DELETE;
        }
        this.typeIsCorrect = true;
    }

    private ReceiveCommand(String str, ObjectId objectId, String str2) {
        if (objectId == null) {
            throw new IllegalArgumentException(JGitText.get().newIdMustNotBeNull);
        }
        if (str2 == null || str2.isEmpty()) {
            throw new IllegalArgumentException(JGitText.get().nameMustNotBeNullOrEmpty);
        }
        this.oldId = ObjectId.zeroId();
        this.oldSymref = str;
        this.newId = objectId;
        this.newSymref = null;
        this.name = str2;
        if (str == null) {
            this.type = Type.CREATE;
        } else if (!AnyObjectId.isEqual(ObjectId.zeroId(), objectId)) {
            this.type = Type.UPDATE;
        } else {
            this.type = Type.DELETE;
        }
        this.typeIsCorrect = true;
    }

    private ReceiveCommand(@Nullable String str, String str2, String str3) {
        if (str3 == null || str3.isEmpty()) {
            throw new IllegalArgumentException(JGitText.get().nameMustNotBeNullOrEmpty);
        }
        this.oldId = ObjectId.zeroId();
        this.oldSymref = str;
        this.newId = ObjectId.zeroId();
        this.newSymref = str2;
        this.name = str3;
        if (str == null) {
            if (str2 == null) {
                throw new IllegalArgumentException(JGitText.get().bothRefTargetsMustNotBeNull);
            }
            this.type = Type.CREATE;
        } else if (str2 != null) {
            this.type = Type.UPDATE;
        } else {
            this.type = Type.DELETE;
        }
        this.typeIsCorrect = true;
    }

    public ObjectId getOldId() {
        return this.oldId;
    }

    @Nullable
    public String getOldSymref() {
        return this.oldSymref;
    }

    public ObjectId getNewId() {
        return this.newId;
    }

    @Nullable
    public String getNewSymref() {
        return this.newSymref;
    }

    public String getRefName() {
        return this.name;
    }

    public Type getType() {
        return this.type;
    }

    public Ref getRef() {
        return this.ref;
    }

    public Result getResult() {
        return this.status;
    }

    public String getMessage() {
        return this.message;
    }

    public void setRefLogMessage(String str, boolean z) {
        this.customRefLog = true;
        if (str == null && !z) {
            disableRefLog();
            return;
        }
        if (str == null && z) {
            this.refLogMessage = "";
            this.refLogIncludeResult = true;
        } else {
            this.refLogMessage = str;
            this.refLogIncludeResult = z;
        }
    }

    public void disableRefLog() {
        this.customRefLog = true;
        this.refLogMessage = null;
        this.refLogIncludeResult = false;
    }

    public void setForceRefLog(boolean z) {
        this.forceRefLog = Boolean.valueOf(z);
    }

    public boolean hasCustomRefLog() {
        return this.customRefLog;
    }

    public boolean isRefLogDisabled() {
        return this.refLogMessage == null;
    }

    @Nullable
    public String getRefLogMessage() {
        return this.refLogMessage;
    }

    public boolean isRefLogIncludingResult() {
        return this.refLogIncludeResult;
    }

    @Nullable
    public Boolean isForceRefLog() {
        return this.forceRefLog;
    }

    public void setResult(Result result) {
        setResult(result, null);
    }

    public void setResult(Result result, String str) {
        this.status = result;
        this.message = str;
    }

    public void updateType(RevWalk revWalk) throws IOException {
        if (this.typeIsCorrect) {
            return;
        }
        if (this.type == Type.UPDATE && !AnyObjectId.isEqual(this.oldId, this.newId)) {
            RevObject any = revWalk.parseAny(this.oldId);
            RevObject any2 = revWalk.parseAny(this.newId);
            if (!(any instanceof RevCommit) || !(any2 instanceof RevCommit) || !revWalk.isMergedInto((RevCommit) any, (RevCommit) any2)) {
                setType(Type.UPDATE_NONFASTFORWARD);
            }
        }
        this.typeIsCorrect = true;
    }

    public void execute(ReceivePack receivePack) {
        try {
            String oldSymref = getOldSymref();
            RefUpdate refUpdateUpdateRef = receivePack.getRepository().updateRef(getRefName(), getNewSymref() != null || (this.type == Type.DELETE && oldSymref != null));
            if (oldSymref != null && (!refUpdateUpdateRef.getRef().isSymbolic() || !refUpdateUpdateRef.getRef().getTarget().getName().equals(oldSymref))) {
                setResult(Result.LOCK_FAILURE);
                return;
            }
            refUpdateUpdateRef.setRefLogIdent(receivePack.getRefLogIdent());
            refUpdateUpdateRef.setRefLogMessage(this.refLogMessage, this.refLogIncludeResult);
            int i = $SWITCH_TABLE$org$eclipse$jgit$transport$ReceiveCommand$Type()[getType().ordinal()];
            if (i != 1 && i != 2 && i != 3) {
                if (i != 4) {
                    return;
                }
                if (!ObjectId.zeroId().equals((AnyObjectId) getOldId())) {
                    refUpdateUpdateRef.setExpectedOldObjectId(getOldId());
                }
                refUpdateUpdateRef.setForceUpdate(true);
                setResult(refUpdateUpdateRef.delete(receivePack.getRevWalk()));
                return;
            }
            refUpdateUpdateRef.setForceUpdate(receivePack.isAllowNonFastForwards());
            refUpdateUpdateRef.setExpectedOldObjectId(getOldId());
            refUpdateUpdateRef.setRefLogMessage(ConfigConstants.CONFIG_PUSH_SECTION, true);
            if (getNewSymref() != null) {
                setResult(refUpdateUpdateRef.link(getNewSymref()));
            } else {
                refUpdateUpdateRef.setNewObjectId(getNewId());
                setResult(refUpdateUpdateRef.update(receivePack.getRevWalk()));
            }
        } catch (IOException e) {
            reject(e);
        }
    }

    void setRef(Ref ref) {
        this.ref = ref;
    }

    void setType(Type type) {
        this.type = type;
    }

    void setTypeFastForwardUpdate() {
        this.type = Type.UPDATE;
        this.typeIsCorrect = true;
    }

    public void setResult(RefUpdate.Result result) {
        switch ($SWITCH_TABLE$org$eclipse$jgit$lib$RefUpdate$Result()[result.ordinal()]) {
            case 1:
                setResult(Result.NOT_ATTEMPTED);
                break;
            case 2:
            case 9:
                setResult(Result.LOCK_FAILURE);
                break;
            case 3:
            case 4:
            case 5:
            case 6:
                setResult(Result.OK);
                break;
            case 7:
                setResult(Result.REJECTED_NONFASTFORWARD);
                break;
            case 8:
                setResult(Result.REJECTED_CURRENT_BRANCH);
                break;
            case 10:
            default:
                setResult(Result.REJECTED_OTHER_REASON, result.name());
                break;
            case 11:
                setResult(Result.REJECTED_MISSING_OBJECT);
                break;
            case 12:
                setResult(Result.REJECTED_OTHER_REASON);
                break;
        }
    }

    void reject(IOException iOException) {
        setResult(Result.REJECTED_OTHER_REASON, MessageFormat.format(JGitText.get().lockError, iOException.getMessage()));
    }

    public String toString() {
        return getType().name() + ": " + getOldId().name() + " " + getNewId().name() + " " + getRefName();
    }
}
