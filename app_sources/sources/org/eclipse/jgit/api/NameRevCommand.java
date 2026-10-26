package org.eclipse.jgit.api;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.api.errors.JGitInternalException;
import org.eclipse.jgit.errors.MissingObjectException;
import org.eclipse.jgit.lib.AnyObjectId;
import org.eclipse.jgit.lib.Constants;
import org.eclipse.jgit.lib.ObjectId;
import org.eclipse.jgit.lib.Ref;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.revwalk.FIFORevQueue;
import org.eclipse.jgit.revwalk.RevCommit;
import org.eclipse.jgit.revwalk.RevObject;
import org.eclipse.jgit.revwalk.RevTag;
import org.eclipse.jgit.revwalk.RevWalk;

/* INFO: loaded from: classes5.dex */
public class NameRevCommand extends GitCommand<Map<ObjectId, String>> {
    private static final int COMMIT_TIME_SLOP = 86400;
    private static final int MERGE_COST = 65535;
    private int mergeCost;
    private final List<String> prefixes;
    private List<Ref> refs;
    private final List<ObjectId> revs;
    private final RevWalk walk;

    private static class NameRevCommit extends RevCommit {
        private long cost;
        private int distance;
        private String tip;

        /* synthetic */ NameRevCommit(AnyObjectId anyObjectId, NameRevCommandIA nameRevCommandIA) {
            this(anyObjectId);
        }

        private NameRevCommit(AnyObjectId anyObjectId) {
            super(anyObjectId);
        }

        /* INFO: Access modifiers changed from: private */
        public StringBuilder format() {
            StringBuilder sb = new StringBuilder(this.tip);
            if (this.distance > 0) {
                sb.append('~').append(this.distance);
            }
            return sb;
        }

        @Override // org.eclipse.jgit.revwalk.RevCommit, org.eclipse.jgit.revwalk.RevObject, org.eclipse.jgit.lib.AnyObjectId
        public String toString() {
            StringBuilder sbAppend = new StringBuilder(getClass().getSimpleName()).append(AbstractJsonLexerKt.BEGIN_LIST);
            if (this.tip != null) {
                sbAppend.append((CharSequence) format());
            } else {
                sbAppend.append((Object) null);
            }
            sbAppend.append(AbstractJsonLexerKt.COMMA).append(this.cost).append("] ").append(super.toString());
            return sbAppend.toString();
        }
    }

    protected NameRevCommand(Repository repository) {
        super(repository);
        this.mergeCost = 65535;
        this.prefixes = new ArrayList(2);
        this.revs = new ArrayList(2);
        this.walk = new AnonymousClass1(repository);
    }

    /* INFO: renamed from: org.eclipse.jgit.api.NameRevCommand$1, reason: invalid class name */
    class AnonymousClass1 extends RevWalk {
        AnonymousClass1(Repository repository) {
            super(repository);
        }

        @Override // org.eclipse.jgit.revwalk.RevWalk
        public NameRevCommit createCommit(AnyObjectId anyObjectId) {
            return new NameRevCommit(anyObjectId, null);
        }
    }

    @Override // org.eclipse.jgit.api.GitCommand, java.util.concurrent.Callable
    public Map<ObjectId, String> call() throws GitAPIException {
        try {
            try {
                Map<ObjectId, String> map = new HashMap<>();
                FIFORevQueue fIFORevQueue = new FIFORevQueue();
                List<Ref> list = this.refs;
                if (list != null) {
                    Iterator<Ref> it = list.iterator();
                    while (it.hasNext()) {
                        addRef(it.next(), map, fIFORevQueue);
                    }
                }
                addPrefixes(map, fIFORevQueue);
                int iMinCommitTime = minCommitTime() - COMMIT_TIME_SLOP;
                while (true) {
                    NameRevCommit nameRevCommit = (NameRevCommit) fIFORevQueue.next();
                    if (nameRevCommit == null) {
                        break;
                    }
                    if (nameRevCommit.getCommitTime() >= iMinCommitTime) {
                        int i = 0;
                        while (i < nameRevCommit.getParentCount()) {
                            NameRevCommit nameRevCommit2 = (NameRevCommit) this.walk.parseCommit(nameRevCommit.getParent(i));
                            long j = nameRevCommit.cost + ((long) (i > 0 ? this.mergeCost : 1));
                            if (nameRevCommit2.tip == null || compare(nameRevCommit.tip, j, nameRevCommit2.tip, nameRevCommit2.cost) < 0) {
                                if (i > 0) {
                                    nameRevCommit2.tip = nameRevCommit.format().append('^').append(i + 1).toString();
                                    nameRevCommit2.distance = 0;
                                } else {
                                    nameRevCommit2.tip = nameRevCommit.tip;
                                    nameRevCommit2.distance = nameRevCommit.distance + 1;
                                }
                                nameRevCommit2.cost = j;
                                fIFORevQueue.add(nameRevCommit2);
                            }
                            i++;
                        }
                    }
                    this.walk.close();
                    throw th;
                }
                LinkedHashMap linkedHashMap = new LinkedHashMap(this.revs.size());
                for (ObjectId objectId : this.revs) {
                    RevObject any = this.walk.parseAny(objectId);
                    if (any instanceof NameRevCommit) {
                        NameRevCommit nameRevCommit3 = (NameRevCommit) any;
                        if (nameRevCommit3.tip != null) {
                            linkedHashMap.put(objectId, simplify(nameRevCommit3.format().toString()));
                        }
                    } else {
                        String str = map.get(objectId);
                        if (str != null) {
                            linkedHashMap.put(objectId, simplify(str));
                        }
                    }
                }
                setCallable(false);
                this.walk.close();
                return linkedHashMap;
            } catch (IOException e) {
                throw new JGitInternalException(e.getMessage(), e);
            }
        } catch (Throwable th) {
            this.walk.close();
            throw th;
        }
    }

    public NameRevCommand add(ObjectId objectId) throws JGitInternalException, MissingObjectException {
        checkCallable();
        try {
            this.walk.parseAny(objectId);
            this.revs.add(objectId.copy());
            return this;
        } catch (MissingObjectException e) {
            throw e;
        } catch (IOException e2) {
            throw new JGitInternalException(e2.getMessage(), e2);
        }
    }

    public NameRevCommand add(Iterable<ObjectId> iterable) throws JGitInternalException, MissingObjectException {
        Iterator<ObjectId> it = iterable.iterator();
        while (it.hasNext()) {
            add(it.next());
        }
        return this;
    }

    public NameRevCommand addPrefix(String str) {
        checkCallable();
        this.prefixes.add(str);
        return this;
    }

    public NameRevCommand addAnnotatedTags() {
        checkCallable();
        if (this.refs == null) {
            this.refs = new ArrayList();
        }
        try {
            for (Ref ref : this.repo.getRefDatabase().getRefsByPrefix(Constants.R_TAGS)) {
                ObjectId objectId = ref.getObjectId();
                if (objectId != null && (this.walk.parseAny(objectId) instanceof RevTag)) {
                    addRef(ref);
                }
            }
            return this;
        } catch (IOException e) {
            throw new JGitInternalException(e.getMessage(), e);
        }
    }

    public NameRevCommand addRef(Ref ref) {
        checkCallable();
        if (this.refs == null) {
            this.refs = new ArrayList();
        }
        this.refs.add(ref);
        return this;
    }

    NameRevCommand setMergeCost(int i) {
        this.mergeCost = i;
        return this;
    }

    private void addPrefixes(Map<ObjectId, String> map, FIFORevQueue fIFORevQueue) throws IOException {
        if (!this.prefixes.isEmpty()) {
            Iterator<String> it = this.prefixes.iterator();
            while (it.hasNext()) {
                addPrefix(it.next(), map, fIFORevQueue);
            }
        } else if (this.refs == null) {
            addPrefix(Constants.R_REFS, map, fIFORevQueue);
        }
    }

    private void addPrefix(String str, Map<ObjectId, String> map, FIFORevQueue fIFORevQueue) throws IOException {
        Iterator<Ref> it = this.repo.getRefDatabase().getRefsByPrefix(str).iterator();
        while (it.hasNext()) {
            addRef(it.next(), map, fIFORevQueue);
        }
    }

    private void addRef(Ref ref, Map<ObjectId, String> map, FIFORevQueue fIFORevQueue) throws IOException {
        if (ref.getObjectId() == null) {
            return;
        }
        RevObject any = this.walk.parseAny(ref.getObjectId());
        while (any instanceof RevTag) {
            map.put(any, ref.getName());
            any = ((RevTag) any).getObject();
            this.walk.parseHeaders(any);
        }
        if (any instanceof NameRevCommit) {
            NameRevCommit nameRevCommit = (NameRevCommit) any;
            if (nameRevCommit.tip == null) {
                nameRevCommit.tip = ref.getName();
            }
            fIFORevQueue.add(nameRevCommit);
            return;
        }
        if (map.containsKey(any)) {
            return;
        }
        map.put(any, ref.getName());
    }

    private int minCommitTime() throws IOException {
        Iterator<ObjectId> it = this.revs.iterator();
        int commitTime = Integer.MAX_VALUE;
        while (it.hasNext()) {
            RevObject any = this.walk.parseAny(it.next());
            while (any instanceof RevTag) {
                any = ((RevTag) any).getObject();
                this.walk.parseHeaders(any);
            }
            if (any instanceof RevCommit) {
                RevCommit revCommit = (RevCommit) any;
                if (revCommit.getCommitTime() < commitTime) {
                    commitTime = revCommit.getCommitTime();
                }
            }
        }
        return commitTime;
    }

    private long compare(String str, long j, String str2, long j2) {
        long j3 = j - j2;
        if (j3 != 0 || this.prefixes.isEmpty()) {
            return j3;
        }
        int i = -1;
        int i2 = -1;
        for (int i3 = 0; i3 < this.prefixes.size(); i3++) {
            String str3 = this.prefixes.get(i3);
            if (i < 0 && str.startsWith(str3)) {
                i = i3;
            }
            if (i2 < 0 && str2.startsWith(str3)) {
                i2 = i3;
            }
        }
        return ((long) i) - ((long) i2);
    }

    private static String simplify(String str) {
        if (str.startsWith(Constants.R_HEADS)) {
            return str.substring(Constants.R_HEADS.length());
        }
        if (str.startsWith(Constants.R_TAGS)) {
            return str.substring(Constants.R_TAGS.length());
        }
        return str.startsWith(Constants.R_REFS) ? str.substring(Constants.R_REFS.length()) : str;
    }
}
