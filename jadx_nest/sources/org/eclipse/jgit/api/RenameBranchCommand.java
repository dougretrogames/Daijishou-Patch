package org.eclipse.jgit.api;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.Arrays;
import org.eclipse.jgit.api.errors.DetachedHeadException;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.api.errors.InvalidRefNameException;
import org.eclipse.jgit.api.errors.JGitInternalException;
import org.eclipse.jgit.api.errors.NoHeadException;
import org.eclipse.jgit.api.errors.RefAlreadyExistsException;
import org.eclipse.jgit.api.errors.RefNotFoundException;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.lib.ConfigConstants;
import org.eclipse.jgit.lib.Constants;
import org.eclipse.jgit.lib.ObjectId;
import org.eclipse.jgit.lib.Ref;
import org.eclipse.jgit.lib.RefUpdate;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.lib.StoredConfig;

/* JADX INFO: loaded from: classes5.dex */
public class RenameBranchCommand extends GitCommand<Ref> {
    private String newName;
    private String oldName;

    protected RenameBranchCommand(Repository repository) {
        super(repository);
    }

    @Override // org.eclipse.jgit.api.GitCommand, java.util.concurrent.Callable
    public Ref call() throws GitAPIException {
        String fullBranch;
        String str;
        checkCallable();
        if (this.newName == null) {
            throw new InvalidRefNameException(MessageFormat.format(JGitText.get().branchNameInvalid, "<null>"));
        }
        try {
            if (this.oldName != null) {
                Ref refExactRef = this.repo.exactRef(this.oldName);
                if (refExactRef == null) {
                    refExactRef = this.repo.exactRef(Constants.R_HEADS + this.oldName);
                    Ref refExactRef2 = this.repo.exactRef(Constants.R_REMOTES + this.oldName);
                    if (refExactRef != null && refExactRef2 != null) {
                        throw new RefNotFoundException(MessageFormat.format(JGitText.get().renameBranchFailedAmbiguous, this.oldName, refExactRef.getName(), refExactRef2.getName()));
                    }
                    if (refExactRef == null) {
                        if (refExactRef2 == null) {
                            throw new RefNotFoundException(MessageFormat.format(JGitText.get().refNotResolved, this.oldName));
                        }
                        refExactRef = refExactRef2;
                    }
                }
                fullBranch = refExactRef.getName();
            } else {
                fullBranch = this.repo.getFullBranch();
                if (fullBranch == null) {
                    throw new NoHeadException(JGitText.get().invalidRepositoryStateNoHead);
                }
                if (ObjectId.isId(fullBranch)) {
                    throw new DetachedHeadException();
                }
            }
            if (fullBranch.startsWith(Constants.R_REMOTES)) {
                str = Constants.R_REMOTES + this.newName;
            } else {
                if (!fullBranch.startsWith(Constants.R_HEADS)) {
                    throw new RefNotFoundException(MessageFormat.format(JGitText.get().renameBranchFailedNotABranch, fullBranch));
                }
                str = Constants.R_HEADS + this.newName;
            }
            if (!Repository.isValidRefName(str)) {
                throw new InvalidRefNameException(MessageFormat.format(JGitText.get().branchNameInvalid, str));
            }
            if (this.repo.exactRef(str) != null) {
                throw new RefAlreadyExistsException(MessageFormat.format(JGitText.get().refAlreadyExists1, str));
            }
            RefUpdate.Result resultRename = this.repo.renameRef(fullBranch, str).rename();
            setCallable(false);
            if (RefUpdate.Result.RENAMED != resultRename) {
                throw new JGitInternalException(MessageFormat.format(JGitText.get().renameBranchUnexpectedResult, resultRename.name()));
            }
            if (str.startsWith(Constants.R_HEADS)) {
                String strSubstring = fullBranch.substring(Constants.R_HEADS.length());
                StoredConfig config = this.repo.getConfig();
                for (String str2 : config.getNames(ConfigConstants.CONFIG_BRANCH_SECTION, strSubstring)) {
                    String[] stringList = config.getStringList(ConfigConstants.CONFIG_BRANCH_SECTION, strSubstring, str2);
                    if (stringList.length != 0) {
                        String[] stringList2 = config.getStringList(ConfigConstants.CONFIG_BRANCH_SECTION, this.newName, str2);
                        if (stringList2.length > 0) {
                            String[] strArr = new String[stringList.length + stringList2.length];
                            System.arraycopy(stringList2, 0, strArr, 0, stringList2.length);
                            System.arraycopy(stringList, 0, strArr, stringList2.length, stringList.length);
                            stringList = strArr;
                        }
                        config.setStringList(ConfigConstants.CONFIG_BRANCH_SECTION, this.newName, str2, Arrays.asList(stringList));
                    }
                }
                config.unsetSection(ConfigConstants.CONFIG_BRANCH_SECTION, strSubstring);
                config.save();
            }
            Ref refExactRef3 = this.repo.exactRef(str);
            if (refExactRef3 != null) {
                return refExactRef3;
            }
            throw new JGitInternalException(JGitText.get().renameBranchFailedUnknownReason);
        } catch (IOException e) {
            throw new JGitInternalException(e.getMessage(), e);
        }
    }

    public RenameBranchCommand setNewName(String str) {
        checkCallable();
        this.newName = str;
        return this;
    }

    public RenameBranchCommand setOldName(String str) {
        checkCallable();
        this.oldName = str;
        return this;
    }
}
