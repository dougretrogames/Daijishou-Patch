package org.eclipse.jgit.api;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.MessageFormat;
import java.util.Iterator;
import org.eclipse.jgit.api.errors.PatchApplyException;
import org.eclipse.jgit.api.errors.PatchFormatException;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.patch.Patch;
import org.eclipse.jgit.patch.PatchApplier;

/* INFO: loaded from: classes5.dex */
public class ApplyCommand extends GitCommand<ApplyResult> {
    private InputStream in;

    ApplyCommand(Repository repository) {
        super(repository);
        if (repository == null) {
            throw new NullPointerException(JGitText.get().repositoryIsRequired);
        }
    }

    public ApplyCommand setPatch(InputStream inputStream) {
        checkCallable();
        this.in = inputStream;
        return this;
    }

    @Override // org.eclipse.jgit.api.GitCommand, java.util.concurrent.Callable
    public ApplyResult call() throws Throwable {
        checkCallable();
        setCallable(false);
        Patch patch = new Patch();
        PatchFormatException patchFormatException = null;
        try {
            InputStream inputStream = this.in;
            try {
                patch.parse(inputStream);
                if (!patch.getErrors().isEmpty()) {
                    patchFormatException = new PatchFormatException(patch.getErrors());
                    throw patchFormatException;
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                ApplyResult applyResult = new ApplyResult();
                try {
                    PatchApplier.Result resultApplyPatch = new PatchApplier(this.repo).applyPatch(patch);
                    if (!resultApplyPatch.getErrors().isEmpty()) {
                        throw new PatchApplyException(MessageFormat.format(JGitText.get().patchApplyException, resultApplyPatch.getErrors()));
                    }
                    Iterator<String> it = resultApplyPatch.getPaths().iterator();
                    while (it.hasNext()) {
                        applyResult.addUpdatedFile(new File(this.repo.getWorkTree(), it.next()));
                    }
                    return applyResult;
                } catch (IOException e) {
                    throw new PatchApplyException(MessageFormat.format(JGitText.get().patchApplyException, e.getMessage(), e));
                }
            } catch (Throwable th) {
                if (inputStream == null) {
                    throw th;
                }
                inputStream.close();
                throw th;
            }
        } catch (Throwable th2) {
            if (patchFormatException == null) {
                throw th2;
            }
            if (patchFormatException != th2) {
                try {
                    patchFormatException.addSuppressed(th2);
                } catch (IOException e2) {
                    throw new PatchApplyException(MessageFormat.format(JGitText.get().patchApplyException, e2.getMessage()), e2);
                }
            }
            throw patchFormatException;
        }
    }
}
