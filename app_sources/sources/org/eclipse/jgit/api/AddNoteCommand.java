package org.eclipse.jgit.api;

import java.io.IOException;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.api.errors.JGitInternalException;
import org.eclipse.jgit.lib.CommitBuilder;
import org.eclipse.jgit.lib.Constants;
import org.eclipse.jgit.lib.ObjectId;
import org.eclipse.jgit.lib.ObjectInserter;
import org.eclipse.jgit.lib.PersonIdent;
import org.eclipse.jgit.lib.Ref;
import org.eclipse.jgit.lib.RefUpdate;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.notes.Note;
import org.eclipse.jgit.notes.NoteMap;
import org.eclipse.jgit.revwalk.RevCommit;
import org.eclipse.jgit.revwalk.RevObject;
import org.eclipse.jgit.revwalk.RevWalk;

/* INFO: loaded from: classes5.dex */
public class AddNoteCommand extends GitCommand<Note> {

    /* INFO: renamed from: id, reason: collision with root package name */
    private RevObject f110id;
    private String message;
    private String notesRef;

    protected AddNoteCommand(Repository repository) {
        super(repository);
        this.notesRef = Constants.R_NOTES_COMMITS;
    }

    @Override // org.eclipse.jgit.api.GitCommand, java.util.concurrent.Callable
    public Note call() throws GitAPIException {
        NoteMap noteMap;
        RevCommit revCommit;
        checkCallable();
        NoteMap noteMapNewEmptyMap = NoteMap.newEmptyMap();
        Throwable th = null;
        try {
            RevWalk revWalk = new RevWalk(this.repo);
            try {
                ObjectInserter objectInserterNewObjectInserter = this.repo.newObjectInserter();
                try {
                    Ref refFindRef = this.repo.findRef(this.notesRef);
                    if (refFindRef != null) {
                        RevCommit commit = revWalk.parseCommit(refFindRef.getObjectId());
                        revCommit = commit;
                        noteMap = NoteMap.read(revWalk.getObjectReader(), commit);
                    } else {
                        noteMap = noteMapNewEmptyMap;
                        revCommit = null;
                    }
                    noteMap.set(this.f110id, this.message, objectInserterNewObjectInserter);
                    commitNoteMap(this.repo, this.notesRef, revWalk, noteMap, revCommit, objectInserterNewObjectInserter, "Notes added by 'git notes add'");
                    Note note = noteMap.getNote(this.f110id);
                    if (objectInserterNewObjectInserter != null) {
                        objectInserterNewObjectInserter.close();
                    }
                    revWalk.close();
                    return note;
                } catch (Throwable th2) {
                    if (objectInserterNewObjectInserter == null) {
                        throw th2;
                    }
                    objectInserterNewObjectInserter.close();
                    throw th2;
                }
            } catch (Throwable th3) {
                if (0 == 0) {
                    th = th3;
                } else if (null != th3) {
                    th.addSuppressed(th3);
                }
                revWalk.close();
                throw th;
            }
        } catch (Throwable th4) {
            if (0 == 0) {
                throw th4;
            }
            if (null != th4) {
                try {
                    th.addSuppressed(th4);
                } catch (IOException e) {
                    throw new JGitInternalException(e.getMessage(), e);
                }
            }
            throw null;
        }
    }

    public AddNoteCommand setObjectId(RevObject revObject) {
        checkCallable();
        this.f110id = revObject;
        return this;
    }

    public AddNoteCommand setMessage(String str) {
        checkCallable();
        this.message = str;
        return this;
    }

    static void commitNoteMap(Repository repository, String str, RevWalk revWalk, NoteMap noteMap, RevCommit revCommit, ObjectInserter objectInserter, String str2) throws IOException {
        CommitBuilder commitBuilder = new CommitBuilder();
        commitBuilder.setTreeId(noteMap.writeTree(objectInserter));
        commitBuilder.setAuthor(new PersonIdent(repository));
        commitBuilder.setCommitter(commitBuilder.getAuthor());
        commitBuilder.setMessage(str2);
        if (revCommit != null) {
            commitBuilder.setParentIds(revCommit);
        }
        ObjectId objectIdInsert = objectInserter.insert(commitBuilder);
        objectInserter.flush();
        RefUpdate refUpdateUpdateRef = repository.updateRef(str);
        if (revCommit != null) {
            refUpdateUpdateRef.setExpectedOldObjectId(revCommit);
        } else {
            refUpdateUpdateRef.setExpectedOldObjectId(ObjectId.zeroId());
        }
        refUpdateUpdateRef.setNewObjectId(objectIdInsert);
        refUpdateUpdateRef.update(revWalk);
    }

    public AddNoteCommand setNotesRef(String str) {
        checkCallable();
        this.notesRef = str;
        return this;
    }
}
