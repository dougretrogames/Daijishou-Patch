package org.eclipse.jgit.api;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.Collection;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.api.errors.InvalidRefNameException;
import org.eclipse.jgit.api.errors.RefNotFoundException;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.lib.ReflogEntry;
import org.eclipse.jgit.lib.ReflogReader;
import org.eclipse.jgit.lib.Repository;

/* JADX INFO: loaded from: classes5.dex */
public class ReflogCommand extends GitCommand<Collection<ReflogEntry>> {
    private String ref;

    public ReflogCommand(Repository repository) {
        super(repository);
        this.ref = "HEAD";
    }

    public ReflogCommand setRef(String str) {
        checkCallable();
        this.ref = str;
        return this;
    }

    @Override // org.eclipse.jgit.api.GitCommand, java.util.concurrent.Callable
    public Collection<ReflogEntry> call() throws GitAPIException {
        checkCallable();
        try {
            ReflogReader reflogReader = this.repo.getReflogReader(this.ref);
            if (reflogReader == null) {
                throw new RefNotFoundException(MessageFormat.format(JGitText.get().refNotResolved, this.ref));
            }
            return reflogReader.getReverseEntries();
        } catch (IOException e) {
            throw new InvalidRefNameException(MessageFormat.format(JGitText.get().cannotRead, this.ref), e);
        }
    }
}
