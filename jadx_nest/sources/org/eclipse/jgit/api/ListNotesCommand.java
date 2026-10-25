package org.eclipse.jgit.api;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.api.errors.JGitInternalException;
import org.eclipse.jgit.lib.Constants;
import org.eclipse.jgit.lib.Ref;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.notes.Note;
import org.eclipse.jgit.notes.NoteMap;
import org.eclipse.jgit.revwalk.RevWalk;

/* JADX INFO: loaded from: classes5.dex */
public class ListNotesCommand extends GitCommand<List<Note>> {
    private String notesRef;

    protected ListNotesCommand(Repository repository) {
        super(repository);
        this.notesRef = Constants.R_NOTES_COMMITS;
    }

    @Override // org.eclipse.jgit.api.GitCommand, java.util.concurrent.Callable
    public List<Note> call() throws GitAPIException {
        checkCallable();
        ArrayList arrayList = new ArrayList();
        NoteMap noteMapNewEmptyMap = NoteMap.newEmptyMap();
        Throwable th = null;
        try {
            RevWalk revWalk = new RevWalk(this.repo);
            try {
                Ref refFindRef = this.repo.findRef(this.notesRef);
                if (refFindRef != null) {
                    noteMapNewEmptyMap = NoteMap.read(revWalk.getObjectReader(), revWalk.parseCommit(refFindRef.getObjectId()));
                }
                Iterator<Note> it = noteMapNewEmptyMap.iterator();
                while (it.hasNext()) {
                    arrayList.add(it.next());
                }
                return arrayList;
            } finally {
                revWalk.close();
            }
        } catch (Throwable th2) {
            if (0 == 0) {
                throw th2;
            }
            if (null != th2) {
                try {
                    th.addSuppressed(th2);
                } catch (IOException e) {
                    throw new JGitInternalException(e.getMessage(), e);
                }
            }
            throw null;
        }
    }

    public ListNotesCommand setNotesRef(String str) {
        checkCallable();
        this.notesRef = str;
        return this;
    }
}
