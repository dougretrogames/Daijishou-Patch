package org.eclipse.jgit.transport;

import org.apache.commons.collections4.CollectionUtils;
import org.eclipse.jgit.lib.AnyObjectId;
import org.eclipse.jgit.lib.ObjectId;
import org.eclipse.jgit.lib.RefUpdate;

/* JADX INFO: loaded from: classes5.dex */
public class TrackingRefUpdate {
    private ReceiveCommand cmd;
    boolean forceUpdate;
    final String localName;
    ObjectId newObjectId;
    ObjectId oldObjectId;
    private final String remoteName;
    private RefUpdate.Result result;

    TrackingRefUpdate(boolean z, String str, String str2, AnyObjectId anyObjectId, AnyObjectId anyObjectId2) {
        this.remoteName = str;
        this.localName = str2;
        this.forceUpdate = z;
        this.oldObjectId = anyObjectId.copy();
        this.newObjectId = anyObjectId2.copy();
    }

    public String getRemoteName() {
        return this.remoteName;
    }

    public String getLocalName() {
        return this.localName;
    }

    public ObjectId getNewObjectId() {
        return this.newObjectId;
    }

    public ObjectId getOldObjectId() {
        return this.oldObjectId;
    }

    public RefUpdate.Result getResult() {
        return this.result;
    }

    void setResult(RefUpdate.Result result) {
        this.result = result;
    }

    public ReceiveCommand asReceiveCommand() {
        if (this.cmd == null) {
            this.cmd = new Command();
        }
        return this.cmd;
    }

    final class Command extends ReceiveCommand {
        private static volatile /* synthetic */ int[] $SWITCH_TABLE$org$eclipse$jgit$transport$ReceiveCommand$Result;
        private static volatile /* synthetic */ int[] $SWITCH_TABLE$org$eclipse$jgit$transport$ReceiveCommand$Type;

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

        Command() {
            super(TrackingRefUpdate.this.oldObjectId, TrackingRefUpdate.this.newObjectId, TrackingRefUpdate.this.localName);
        }

        boolean canForceUpdate() {
            return TrackingRefUpdate.this.forceUpdate;
        }

        @Override // org.eclipse.jgit.transport.ReceiveCommand
        public void setResult(RefUpdate.Result result) {
            TrackingRefUpdate.this.result = result;
            super.setResult(result);
        }

        @Override // org.eclipse.jgit.transport.ReceiveCommand
        public void setResult(ReceiveCommand.Result result) {
            TrackingRefUpdate.this.result = decode(result);
            super.setResult(result);
        }

        @Override // org.eclipse.jgit.transport.ReceiveCommand
        public void setResult(ReceiveCommand.Result result, String str) {
            TrackingRefUpdate.this.result = decode(result);
            super.setResult(result, str);
        }

        private RefUpdate.Result decode(ReceiveCommand.Result result) {
            int i = $SWITCH_TABLE$org$eclipse$jgit$transport$ReceiveCommand$Result()[result.ordinal()];
            if (i == 2 || i == 3 || i == 4) {
                return RefUpdate.Result.REJECTED;
            }
            if (i == 5) {
                return RefUpdate.Result.REJECTED_CURRENT_BRANCH;
            }
            if (i == 6) {
                return RefUpdate.Result.IO_FAILURE;
            }
            if (i == 9) {
                if (AnyObjectId.isEqual(TrackingRefUpdate.this.oldObjectId, TrackingRefUpdate.this.newObjectId)) {
                    return RefUpdate.Result.NO_CHANGE;
                }
                int i2 = $SWITCH_TABLE$org$eclipse$jgit$transport$ReceiveCommand$Type()[getType().ordinal()];
                if (i2 == 1) {
                    return RefUpdate.Result.NEW;
                }
                if (i2 == 2) {
                    return RefUpdate.Result.FAST_FORWARD;
                }
                return RefUpdate.Result.FORCED;
            }
            return RefUpdate.Result.LOCK_FAILURE;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("TrackingRefUpdate[");
        sb.append(this.remoteName);
        sb.append(" -> ");
        sb.append(this.localName);
        if (this.forceUpdate) {
            sb.append(" (forced)");
        }
        sb.append(" ");
        ObjectId objectId = this.oldObjectId;
        sb.append(objectId == null ? "" : objectId.abbreviate(7).name());
        sb.append("..");
        ObjectId objectId2 = this.newObjectId;
        sb.append(objectId2 != null ? objectId2.abbreviate(7).name() : "");
        sb.append(CollectionUtils.DEFAULT_TOSTRING_SUFFIX);
        return sb.toString();
    }
}
