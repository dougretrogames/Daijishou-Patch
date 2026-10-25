package org.eclipse.jgit.api;

import java.io.IOException;
import java.text.MessageFormat;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.api.errors.InvalidRefNameException;
import org.eclipse.jgit.api.errors.JGitInternalException;
import org.eclipse.jgit.api.errors.RefAlreadyExistsException;
import org.eclipse.jgit.api.errors.RefNotFoundException;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.lib.BranchConfig;
import org.eclipse.jgit.lib.ConfigConstants;
import org.eclipse.jgit.lib.Constants;
import org.eclipse.jgit.lib.ObjectId;
import org.eclipse.jgit.lib.Ref;
import org.eclipse.jgit.lib.RefUpdate;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.lib.StoredConfig;
import org.eclipse.jgit.revwalk.RevCommit;
import org.eclipse.jgit.revwalk.RevWalk;

/* JADX INFO: loaded from: classes5.dex */
public class CreateBranchCommand extends GitCommand<Ref> {
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$org$eclipse$jgit$lib$RefUpdate$Result;
    private boolean force;
    private String name;
    private RevCommit startCommit;
    private String startPoint;
    private SetupUpstreamMode upstreamMode;

    public enum SetupUpstreamMode {
        TRACK,
        NOTRACK,
        SET_UPSTREAM;

        /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
        public static SetupUpstreamMode[] valuesCustom() {
            SetupUpstreamMode[] setupUpstreamModeArrValuesCustom = values();
            int length = setupUpstreamModeArrValuesCustom.length;
            SetupUpstreamMode[] setupUpstreamModeArr = new SetupUpstreamMode[length];
            System.arraycopy(setupUpstreamModeArrValuesCustom, 0, setupUpstreamModeArr, 0, length);
            return setupUpstreamModeArr;
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

    protected CreateBranchCommand(Repository repository) {
        super(repository);
        this.force = false;
        this.startPoint = "HEAD";
    }

    /* JADX WARN: Code duplicated, block: B:48:0x0124 A[Catch: all -> 0x01fd, TryCatch #2 {all -> 0x01fd, blocks: (B:4:0x001e, B:8:0x0039, B:12:0x0040, B:13:0x0055, B:14:0x0056, B:16:0x005e, B:18:0x0068, B:23:0x0074, B:25:0x0078, B:28:0x0091, B:43:0x00fe, B:45:0x011b, B:47:0x011f, B:49:0x0128, B:58:0x0143, B:60:0x0147, B:62:0x0151, B:66:0x015b, B:69:0x0163, B:72:0x016a, B:84:0x0198, B:87:0x01aa, B:89:0x01d4, B:88:0x01c8, B:75:0x0172, B:78:0x0187, B:81:0x0190, B:90:0x01d9, B:91:0x01e4, B:92:0x01e5, B:93:0x01fc, B:48:0x0124, B:29:0x009f, B:26:0x007d, B:31:0x00ae, B:33:0x00b4, B:36:0x00bb, B:38:0x00c5, B:39:0x00d3, B:41:0x00e3, B:42:0x00f1), top: B:110:0x001e, outer: #0 }] */
    /* JADX WARN: Code duplicated, block: B:51:0x0138  */
    /* JADX WARN: Code duplicated, block: B:53:0x013b  */
    /* JADX WARN: Code duplicated, block: B:58:0x0143 A[Catch: all -> 0x01fd, TryCatch #2 {all -> 0x01fd, blocks: (B:4:0x001e, B:8:0x0039, B:12:0x0040, B:13:0x0055, B:14:0x0056, B:16:0x005e, B:18:0x0068, B:23:0x0074, B:25:0x0078, B:28:0x0091, B:43:0x00fe, B:45:0x011b, B:47:0x011f, B:49:0x0128, B:58:0x0143, B:60:0x0147, B:62:0x0151, B:66:0x015b, B:69:0x0163, B:72:0x016a, B:84:0x0198, B:87:0x01aa, B:89:0x01d4, B:88:0x01c8, B:75:0x0172, B:78:0x0187, B:81:0x0190, B:90:0x01d9, B:91:0x01e4, B:92:0x01e5, B:93:0x01fc, B:48:0x0124, B:29:0x009f, B:26:0x007d, B:31:0x00ae, B:33:0x00b4, B:36:0x00bb, B:38:0x00c5, B:39:0x00d3, B:41:0x00e3, B:42:0x00f1), top: B:110:0x001e, outer: #0 }] */
    /* JADX WARN: Code duplicated, block: B:60:0x0147 A[Catch: all -> 0x01fd, TryCatch #2 {all -> 0x01fd, blocks: (B:4:0x001e, B:8:0x0039, B:12:0x0040, B:13:0x0055, B:14:0x0056, B:16:0x005e, B:18:0x0068, B:23:0x0074, B:25:0x0078, B:28:0x0091, B:43:0x00fe, B:45:0x011b, B:47:0x011f, B:49:0x0128, B:58:0x0143, B:60:0x0147, B:62:0x0151, B:66:0x015b, B:69:0x0163, B:72:0x016a, B:84:0x0198, B:87:0x01aa, B:89:0x01d4, B:88:0x01c8, B:75:0x0172, B:78:0x0187, B:81:0x0190, B:90:0x01d9, B:91:0x01e4, B:92:0x01e5, B:93:0x01fc, B:48:0x0124, B:29:0x009f, B:26:0x007d, B:31:0x00ae, B:33:0x00b4, B:36:0x00bb, B:38:0x00c5, B:39:0x00d3, B:41:0x00e3, B:42:0x00f1), top: B:110:0x001e, outer: #0 }] */
    /* JADX WARN: Code duplicated, block: B:62:0x0151 A[Catch: all -> 0x01fd, TRY_LEAVE, TryCatch #2 {all -> 0x01fd, blocks: (B:4:0x001e, B:8:0x0039, B:12:0x0040, B:13:0x0055, B:14:0x0056, B:16:0x005e, B:18:0x0068, B:23:0x0074, B:25:0x0078, B:28:0x0091, B:43:0x00fe, B:45:0x011b, B:47:0x011f, B:49:0x0128, B:58:0x0143, B:60:0x0147, B:62:0x0151, B:66:0x015b, B:69:0x0163, B:72:0x016a, B:84:0x0198, B:87:0x01aa, B:89:0x01d4, B:88:0x01c8, B:75:0x0172, B:78:0x0187, B:81:0x0190, B:90:0x01d9, B:91:0x01e4, B:92:0x01e5, B:93:0x01fc, B:48:0x0124, B:29:0x009f, B:26:0x007d, B:31:0x00ae, B:33:0x00b4, B:36:0x00bb, B:38:0x00c5, B:39:0x00d3, B:41:0x00e3, B:42:0x00f1), top: B:110:0x001e, outer: #0 }] */
    /* JADX WARN: Code duplicated, block: B:66:0x015b A[Catch: all -> 0x01fd, TRY_ENTER, TRY_LEAVE, TryCatch #2 {all -> 0x01fd, blocks: (B:4:0x001e, B:8:0x0039, B:12:0x0040, B:13:0x0055, B:14:0x0056, B:16:0x005e, B:18:0x0068, B:23:0x0074, B:25:0x0078, B:28:0x0091, B:43:0x00fe, B:45:0x011b, B:47:0x011f, B:49:0x0128, B:58:0x0143, B:60:0x0147, B:62:0x0151, B:66:0x015b, B:69:0x0163, B:72:0x016a, B:84:0x0198, B:87:0x01aa, B:89:0x01d4, B:88:0x01c8, B:75:0x0172, B:78:0x0187, B:81:0x0190, B:90:0x01d9, B:91:0x01e4, B:92:0x01e5, B:93:0x01fc, B:48:0x0124, B:29:0x009f, B:26:0x007d, B:31:0x00ae, B:33:0x00b4, B:36:0x00bb, B:38:0x00c5, B:39:0x00d3, B:41:0x00e3, B:42:0x00f1), top: B:110:0x001e, outer: #0 }] */
    /* JADX WARN: Code duplicated, block: B:82:0x0195  */
    /* JADX WARN: Code duplicated, block: B:84:0x0198 A[Catch: all -> 0x01fd, TRY_LEAVE, TryCatch #2 {all -> 0x01fd, blocks: (B:4:0x001e, B:8:0x0039, B:12:0x0040, B:13:0x0055, B:14:0x0056, B:16:0x005e, B:18:0x0068, B:23:0x0074, B:25:0x0078, B:28:0x0091, B:43:0x00fe, B:45:0x011b, B:47:0x011f, B:49:0x0128, B:58:0x0143, B:60:0x0147, B:62:0x0151, B:66:0x015b, B:69:0x0163, B:72:0x016a, B:84:0x0198, B:87:0x01aa, B:89:0x01d4, B:88:0x01c8, B:75:0x0172, B:78:0x0187, B:81:0x0190, B:90:0x01d9, B:91:0x01e4, B:92:0x01e5, B:93:0x01fc, B:48:0x0124, B:29:0x009f, B:26:0x007d, B:31:0x00ae, B:33:0x00b4, B:36:0x00bb, B:38:0x00c5, B:39:0x00d3, B:41:0x00e3, B:42:0x00f1), top: B:110:0x001e, outer: #0 }] */
    /* JADX WARN: Code duplicated, block: B:87:0x01aa A[Catch: all -> 0x01fd, TRY_ENTER, TryCatch #2 {all -> 0x01fd, blocks: (B:4:0x001e, B:8:0x0039, B:12:0x0040, B:13:0x0055, B:14:0x0056, B:16:0x005e, B:18:0x0068, B:23:0x0074, B:25:0x0078, B:28:0x0091, B:43:0x00fe, B:45:0x011b, B:47:0x011f, B:49:0x0128, B:58:0x0143, B:60:0x0147, B:62:0x0151, B:66:0x015b, B:69:0x0163, B:72:0x016a, B:84:0x0198, B:87:0x01aa, B:89:0x01d4, B:88:0x01c8, B:75:0x0172, B:78:0x0187, B:81:0x0190, B:90:0x01d9, B:91:0x01e4, B:92:0x01e5, B:93:0x01fc, B:48:0x0124, B:29:0x009f, B:26:0x007d, B:31:0x00ae, B:33:0x00b4, B:36:0x00bb, B:38:0x00c5, B:39:0x00d3, B:41:0x00e3, B:42:0x00f1), top: B:110:0x001e, outer: #0 }] */
    /* JADX WARN: Code duplicated, block: B:88:0x01c8 A[Catch: all -> 0x01fd, TryCatch #2 {all -> 0x01fd, blocks: (B:4:0x001e, B:8:0x0039, B:12:0x0040, B:13:0x0055, B:14:0x0056, B:16:0x005e, B:18:0x0068, B:23:0x0074, B:25:0x0078, B:28:0x0091, B:43:0x00fe, B:45:0x011b, B:47:0x011f, B:49:0x0128, B:58:0x0143, B:60:0x0147, B:62:0x0151, B:66:0x015b, B:69:0x0163, B:72:0x016a, B:84:0x0198, B:87:0x01aa, B:89:0x01d4, B:88:0x01c8, B:75:0x0172, B:78:0x0187, B:81:0x0190, B:90:0x01d9, B:91:0x01e4, B:92:0x01e5, B:93:0x01fc, B:48:0x0124, B:29:0x009f, B:26:0x007d, B:31:0x00ae, B:33:0x00b4, B:36:0x00bb, B:38:0x00c5, B:39:0x00d3, B:41:0x00e3, B:42:0x00f1), top: B:110:0x001e, outer: #0 }] */
    /* JADX WARN: Code duplicated, block: B:90:0x01d9 A[Catch: all -> 0x01fd, TryCatch #2 {all -> 0x01fd, blocks: (B:4:0x001e, B:8:0x0039, B:12:0x0040, B:13:0x0055, B:14:0x0056, B:16:0x005e, B:18:0x0068, B:23:0x0074, B:25:0x0078, B:28:0x0091, B:43:0x00fe, B:45:0x011b, B:47:0x011f, B:49:0x0128, B:58:0x0143, B:60:0x0147, B:62:0x0151, B:66:0x015b, B:69:0x0163, B:72:0x016a, B:84:0x0198, B:87:0x01aa, B:89:0x01d4, B:88:0x01c8, B:75:0x0172, B:78:0x0187, B:81:0x0190, B:90:0x01d9, B:91:0x01e4, B:92:0x01e5, B:93:0x01fc, B:48:0x0124, B:29:0x009f, B:26:0x007d, B:31:0x00ae, B:33:0x00b4, B:36:0x00bb, B:38:0x00c5, B:39:0x00d3, B:41:0x00e3, B:42:0x00f1), top: B:110:0x001e, outer: #0 }] */
    /* JADX WARN: Code duplicated, block: B:92:0x01e5 A[Catch: all -> 0x01fd, TryCatch #2 {all -> 0x01fd, blocks: (B:4:0x001e, B:8:0x0039, B:12:0x0040, B:13:0x0055, B:14:0x0056, B:16:0x005e, B:18:0x0068, B:23:0x0074, B:25:0x0078, B:28:0x0091, B:43:0x00fe, B:45:0x011b, B:47:0x011f, B:49:0x0128, B:58:0x0143, B:60:0x0147, B:62:0x0151, B:66:0x015b, B:69:0x0163, B:72:0x016a, B:84:0x0198, B:87:0x01aa, B:89:0x01d4, B:88:0x01c8, B:75:0x0172, B:78:0x0187, B:81:0x0190, B:90:0x01d9, B:91:0x01e4, B:92:0x01e5, B:93:0x01fc, B:48:0x0124, B:29:0x009f, B:26:0x007d, B:31:0x00ae, B:33:0x00b4, B:36:0x00bb, B:38:0x00c5, B:39:0x00d3, B:41:0x00e3, B:42:0x00f1), top: B:110:0x001e, outer: #0 }] */
    @Override // org.eclipse.jgit.api.GitCommand, java.util.concurrent.Callable
    public Ref call() throws GitAPIException {
        String str;
        RefUpdate refUpdateUpdateRef;
        RefUpdate.Result resultUpdate;
        int i;
        Ref refFindRef;
        boolean zStartsWith;
        StoredConfig config;
        String remoteName;
        String shortMessage;
        Ref refFindRef2;
        checkCallable();
        processOptions();
        Throwable th = null;
        try {
            RevWalk revWalk = new RevWalk(this.repo);
            try {
                boolean z = this.repo.findRef(new StringBuilder(Constants.R_HEADS).append(this.name).toString()) != null;
                if (!this.force && z) {
                    throw new RefAlreadyExistsException(MessageFormat.format(JGitText.get().refAlreadyExists1, this.name));
                }
                ObjectId startPointObjectId = getStartPointObjectId();
                String name = (this.startPoint == null || (refFindRef2 = this.repo.findRef(this.startPoint)) == null) ? null : refFindRef2.getName();
                if (name == null) {
                    RevCommit revCommit = this.startCommit;
                    if (revCommit != null) {
                        shortMessage = revCommit.getShortMessage();
                    } else {
                        shortMessage = revWalk.parseCommit(this.repo.resolve(getStartPointOrHead())).getShortMessage();
                    }
                    if (z) {
                        str = "branch: Reset start-point to commit " + shortMessage;
                    } else {
                        str = "branch: Created from commit " + shortMessage;
                    }
                } else {
                    if (!name.startsWith(Constants.R_HEADS) && !name.startsWith(Constants.R_REMOTES)) {
                        startPointObjectId = revWalk.peel(revWalk.parseAny(startPointObjectId));
                        if (z) {
                            str = "branch: Reset start-point to tag " + name;
                        } else {
                            str = "branch: Created from tag " + name;
                        }
                    } else if (z) {
                        str = "branch: Reset start-point to branch " + name;
                    } else {
                        str = "branch: Created from branch " + name;
                    }
                    refUpdateUpdateRef = this.repo.updateRef(Constants.R_HEADS + this.name);
                    refUpdateUpdateRef.setNewObjectId(startPointObjectId);
                    refUpdateUpdateRef.setRefLogMessage(str, false);
                    if (!z && this.force) {
                        resultUpdate = refUpdateUpdateRef.forceUpdate();
                    } else {
                        resultUpdate = refUpdateUpdateRef.update();
                    }
                    setCallable(false);
                    i = $SWITCH_TABLE$org$eclipse$jgit$lib$RefUpdate$Result()[resultUpdate.ordinal()];
                    if (i != 3) {
                        if (i != 4) {
                            z = !z;
                        } else if (i != 5 && i != 6) {
                            z = false;
                        }
                    }
                    if (z) {
                        throw new JGitInternalException(MessageFormat.format(JGitText.get().createBranchUnexpectedResult, resultUpdate.name()));
                    }
                    refFindRef = this.repo.findRef(this.name);
                    if (refFindRef != null) {
                        throw new JGitInternalException(JGitText.get().createBranchFailedUnknownReason);
                    }
                    if (name.length() != 0) {
                        if (this.upstreamMode != SetupUpstreamMode.SET_UPSTREAM || this.upstreamMode == SetupUpstreamMode.TRACK) {
                            zStartsWith = true;
                        } else if (this.upstreamMode == SetupUpstreamMode.NOTRACK) {
                            zStartsWith = false;
                        } else {
                            String string = this.repo.getConfig().getString(ConfigConstants.CONFIG_BRANCH_SECTION, null, ConfigConstants.CONFIG_KEY_AUTOSETUPMERGE);
                            if ("false".equals(string)) {
                                zStartsWith = false;
                            } else if (ConfigConstants.CONFIG_KEY_ALWAYS.equals(string)) {
                                zStartsWith = true;
                            } else {
                                zStartsWith = name.startsWith(Constants.R_REMOTES);
                            }
                        }
                        if (zStartsWith) {
                            config = this.repo.getConfig();
                            remoteName = this.repo.getRemoteName(name);
                            if (remoteName != null) {
                                String strShortenRemoteBranchName = this.repo.shortenRemoteBranchName(name);
                                config.setString(ConfigConstants.CONFIG_BRANCH_SECTION, this.name, "remote", remoteName);
                                config.setString(ConfigConstants.CONFIG_BRANCH_SECTION, this.name, "merge", Constants.R_HEADS + strShortenRemoteBranchName);
                            } else {
                                config.setString(ConfigConstants.CONFIG_BRANCH_SECTION, this.name, "remote", BranchConfig.LOCAL_REPOSITORY);
                                config.setString(ConfigConstants.CONFIG_BRANCH_SECTION, this.name, "merge", name);
                            }
                            config.save();
                        }
                    }
                    revWalk.close();
                    return refFindRef;
                }
                name = "";
                refUpdateUpdateRef = this.repo.updateRef(Constants.R_HEADS + this.name);
                refUpdateUpdateRef.setNewObjectId(startPointObjectId);
                refUpdateUpdateRef.setRefLogMessage(str, false);
                if (!z) {
                    resultUpdate = refUpdateUpdateRef.update();
                } else {
                    resultUpdate = refUpdateUpdateRef.update();
                }
                setCallable(false);
                i = $SWITCH_TABLE$org$eclipse$jgit$lib$RefUpdate$Result()[resultUpdate.ordinal()];
                if (i != 3) {
                    if (i != 4) {
                        z = !z;
                    } else if (i != 5) {
                        z = false;
                    }
                }
                if (z) {
                    throw new JGitInternalException(MessageFormat.format(JGitText.get().createBranchUnexpectedResult, resultUpdate.name()));
                }
                refFindRef = this.repo.findRef(this.name);
                if (refFindRef != null) {
                    throw new JGitInternalException(JGitText.get().createBranchFailedUnknownReason);
                }
                if (name.length() != 0) {
                    if (this.upstreamMode != SetupUpstreamMode.SET_UPSTREAM) {
                        zStartsWith = true;
                    } else {
                        zStartsWith = true;
                    }
                    if (zStartsWith) {
                        config = this.repo.getConfig();
                        remoteName = this.repo.getRemoteName(name);
                        if (remoteName != null) {
                            String strShortenRemoteBranchName2 = this.repo.shortenRemoteBranchName(name);
                            config.setString(ConfigConstants.CONFIG_BRANCH_SECTION, this.name, "remote", remoteName);
                            config.setString(ConfigConstants.CONFIG_BRANCH_SECTION, this.name, "merge", Constants.R_HEADS + strShortenRemoteBranchName2);
                        } else {
                            config.setString(ConfigConstants.CONFIG_BRANCH_SECTION, this.name, "remote", BranchConfig.LOCAL_REPOSITORY);
                            config.setString(ConfigConstants.CONFIG_BRANCH_SECTION, this.name, "merge", name);
                        }
                        config.save();
                    }
                }
                revWalk.close();
                return refFindRef;
            } catch (Throwable th2) {
                revWalk.close();
                throw th2;
            }
        } catch (Throwable th3) {
            if (0 == 0) {
                throw th3;
            }
            if (null != th3) {
                try {
                    th.addSuppressed(th3);
                } catch (IOException e) {
                    throw new JGitInternalException(e.getMessage(), e);
                }
            }
            throw null;
        }
    }

    private ObjectId getStartPointObjectId() throws RefNotFoundException, IOException {
        RevCommit revCommit = this.startCommit;
        if (revCommit != null) {
            return revCommit.getId();
        }
        String startPointOrHead = getStartPointOrHead();
        ObjectId objectIdResolve = this.repo.resolve(startPointOrHead);
        if (objectIdResolve != null) {
            return objectIdResolve;
        }
        throw new RefNotFoundException(MessageFormat.format(JGitText.get().refNotResolved, startPointOrHead));
    }

    private String getStartPointOrHead() {
        String str = this.startPoint;
        return str != null ? str : "HEAD";
    }

    private void processOptions() throws InvalidRefNameException {
        String str = this.name;
        if (str != null && Repository.isValidRefName(Constants.R_HEADS + str) && isValidBranchName(this.name)) {
            return;
        }
        String str2 = JGitText.get().branchNameInvalid;
        String str3 = this.name;
        if (str3 == null) {
            str3 = "<null>";
        }
        throw new InvalidRefNameException(MessageFormat.format(str2, str3));
    }

    public static boolean isValidBranchName(String str) {
        if ("HEAD".equals(str)) {
            return false;
        }
        return !str.startsWith("-");
    }

    public CreateBranchCommand setName(String str) {
        checkCallable();
        this.name = str;
        return this;
    }

    public CreateBranchCommand setForce(boolean z) {
        checkCallable();
        this.force = z;
        return this;
    }

    public CreateBranchCommand setStartPoint(String str) {
        checkCallable();
        this.startPoint = str;
        this.startCommit = null;
        return this;
    }

    public CreateBranchCommand setStartPoint(RevCommit revCommit) {
        checkCallable();
        this.startCommit = revCommit;
        this.startPoint = null;
        return this;
    }

    public CreateBranchCommand setUpstreamMode(SetupUpstreamMode setupUpstreamMode) {
        checkCallable();
        this.upstreamMode = setupUpstreamMode;
        return this;
    }
}
