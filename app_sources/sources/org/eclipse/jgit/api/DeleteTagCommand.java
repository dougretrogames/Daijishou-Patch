package org.eclipse.jgit.api;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.api.errors.JGitInternalException;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.lib.Ref;
import org.eclipse.jgit.lib.RefUpdate;
import org.eclipse.jgit.lib.Repository;

/* INFO: loaded from: classes5.dex */
public class DeleteTagCommand extends GitCommand<List<String>> {
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$org$eclipse$jgit$lib$RefUpdate$Result;
    private final Set<String> tags;

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

    protected DeleteTagCommand(Repository repository) {
        super(repository);
        this.tags = new HashSet();
    }

    @Override // org.eclipse.jgit.api.GitCommand, java.util.concurrent.Callable
    public List<String> call() throws GitAPIException {
        Ref refFindRef;
        checkCallable();
        ArrayList arrayList = new ArrayList();
        if (!this.tags.isEmpty()) {
            try {
                setCallable(false);
                for (String str : this.tags) {
                    if (str != null && (refFindRef = this.repo.findRef(str)) != null) {
                        String name = refFindRef.getName();
                        RefUpdate refUpdateUpdateRef = this.repo.updateRef(name);
                        refUpdateUpdateRef.setForceUpdate(true);
                        RefUpdate.Result resultDelete = refUpdateUpdateRef.delete();
                        int i = $SWITCH_TABLE$org$eclipse$jgit$lib$RefUpdate$Result()[resultDelete.ordinal()];
                        if (i != 2 && i != 7 && i != 9) {
                            arrayList.add(name);
                        } else {
                            throw new JGitInternalException(MessageFormat.format(JGitText.get().deleteTagUnexpectedResult, resultDelete.name()));
                        }
                    }
                }
            } catch (IOException e) {
                throw new JGitInternalException(e.getMessage(), e);
            }
        }
        return arrayList;
    }

    public DeleteTagCommand setTags(String... strArr) {
        checkCallable();
        this.tags.clear();
        this.tags.addAll(Arrays.asList(strArr));
        return this;
    }
}
