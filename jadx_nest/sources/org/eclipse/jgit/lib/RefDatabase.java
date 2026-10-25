package org.eclipse.jgit.lib;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import net.lingala.zip4j.util.InternalZipConstants;
import org.eclipse.jgit.annotations.Nullable;
import org.eclipse.jgit.api.PackRefsCommand;

/* JADX INFO: loaded from: classes5.dex */
public abstract class RefDatabase {
    public static final String ALL = "";
    public static final int MAX_SYMBOLIC_REF_DEPTH = 5;
    protected static final String[] SEARCH_PATH = {"", Constants.R_REFS, Constants.R_TAGS, Constants.R_HEADS, Constants.R_REMOTES};
    protected static final String[] additionalRefsNames = {Constants.MERGE_HEAD, Constants.FETCH_HEAD, Constants.ORIG_HEAD, Constants.CHERRY_PICK_HEAD, Constants.REVERT_HEAD};

    public abstract void close();

    public abstract void create() throws IOException;

    @Nullable
    public abstract Ref exactRef(String str) throws IOException;

    public abstract List<Ref> getAdditionalRefs() throws IOException;

    @Deprecated
    public abstract Map<String, Ref> getRefs(String str) throws IOException;

    public boolean hasFastTipsWithSha1() throws IOException {
        return false;
    }

    public boolean hasVersioning() {
        return false;
    }

    public abstract boolean isNameConflicting(String str) throws IOException;

    public abstract RefRename newRename(String str, String str2) throws IOException;

    public abstract RefUpdate newUpdate(String str, boolean z) throws IOException;

    public void packRefs(ProgressMonitor progressMonitor, PackRefsCommand packRefsCommand) throws IOException {
    }

    public abstract Ref peel(Ref ref) throws IOException;

    public boolean performsAtomicTransactions() {
        return false;
    }

    public void refresh() {
    }

    public Collection<String> getConflictingNames(String str) throws IOException {
        Map<String, Ref> refs = getRefs("");
        int iLastIndexOf = str.lastIndexOf(47);
        while (iLastIndexOf > 0) {
            String strSubstring = str.substring(0, iLastIndexOf);
            if (refs.containsKey(strSubstring)) {
                return Collections.singletonList(strSubstring);
            }
            iLastIndexOf = str.lastIndexOf(47, iLastIndexOf - 1);
        }
        ArrayList arrayList = new ArrayList();
        String str2 = str + InternalZipConstants.ZIP_FILE_SEPARATOR;
        for (String str3 : refs.keySet()) {
            if (str3.startsWith(str2)) {
                arrayList.add(str3);
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    public BatchRefUpdate newBatchUpdate() {
        return new BatchRefUpdate(this);
    }

    @Nullable
    public final Ref findRef(String str) throws IOException {
        String[] strArr = new String[SEARCH_PATH.length];
        int i = 0;
        while (true) {
            String[] strArr2 = SEARCH_PATH;
            if (i < strArr2.length) {
                strArr[i] = strArr2[i] + str;
                i++;
            } else {
                return firstExactRef(strArr);
            }
        }
    }

    public Map<String, Ref> exactRef(String... strArr) throws IOException {
        HashMap map = new HashMap(strArr.length);
        for (String str : strArr) {
            Ref refExactRef = exactRef(str);
            if (refExactRef != null) {
                map.put(str, refExactRef);
            }
        }
        return map;
    }

    @Nullable
    public Ref firstExactRef(String... strArr) throws IOException {
        for (String str : strArr) {
            Ref refExactRef = exactRef(str);
            if (refExactRef != null) {
                return refExactRef;
            }
        }
        return null;
    }

    public List<Ref> getRefs() throws IOException {
        return getRefsByPrefix("");
    }

    public List<Ref> getRefsByPrefix(String str) throws IOException {
        Map<String, Ref> refs;
        List list;
        int iLastIndexOf = str.lastIndexOf(47);
        if (iLastIndexOf == -1) {
            refs = getRefs("");
        } else {
            refs = getRefs(str.substring(0, iLastIndexOf + 1));
        }
        int i = iLastIndexOf + 1;
        if (i == str.length()) {
            list = (List) refs.values().stream().collect(Collectors.toList());
        } else {
            list = (List) refs.entrySet().stream().filter(new RefDatabase$$ExternalSyntheticLambda0(str.substring(i))).map(new RefDatabase$$ExternalSyntheticLambda1()).collect(Collectors.toList());
        }
        return Collections.unmodifiableList(list);
    }

    static /* synthetic */ Ref lambda$1(Map.Entry entry) {
        return (Ref) entry.getValue();
    }

    public List<Ref> getRefsByPrefixWithExclusions(String str, Set<String> set) throws IOException {
        Stream<Ref> stream = getRefs(str).values().stream();
        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            stream = stream.filter(new RefDatabase$$ExternalSyntheticLambda3(it.next()));
        }
        return Collections.unmodifiableList((List) stream.collect(Collectors.toList()));
    }

    static /* synthetic */ boolean lambda$2(String str, Ref ref) {
        return !ref.getName().startsWith(str);
    }

    public List<Ref> getRefsByPrefix(String... strArr) throws IOException {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            arrayList.addAll(getRefsByPrefix(str));
        }
        return Collections.unmodifiableList(arrayList);
    }

    static /* synthetic */ boolean lambda$3(ObjectId objectId, Ref ref) {
        return objectId.equals((AnyObjectId) ref.getObjectId()) || objectId.equals((AnyObjectId) ref.getPeeledObjectId());
    }

    public Set<Ref> getTipsWithSha1(ObjectId objectId) throws IOException {
        return (Set) getRefs().stream().filter(new RefDatabase$$ExternalSyntheticLambda2(objectId)).collect(Collectors.toSet());
    }

    public boolean hasRefs() throws IOException {
        return !getRefs().isEmpty();
    }

    @Nullable
    public static Ref findRef(Map<String, Ref> map, String str) {
        for (String str2 : SEARCH_PATH) {
            Ref ref = map.get(str2 + str);
            if (ref != null) {
                return ref;
            }
        }
        return null;
    }
}
