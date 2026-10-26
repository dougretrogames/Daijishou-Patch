package org.eclipse.jgit.internal.diffmergetool;

import java.io.File;
import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeMap;
import org.eclipse.jgit.attributes.Attributes;
import org.eclipse.jgit.errors.RevisionSyntaxException;
import org.eclipse.jgit.lib.Constants;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.treewalk.FileTreeIterator;
import org.eclipse.jgit.treewalk.TreeWalk;
import org.eclipse.jgit.treewalk.filter.NotIgnoredFilter;
import org.eclipse.jgit.util.FS;

/* INFO: loaded from: classes5.dex */
public class ExternalToolUtils {
    public static final String KEY_DIFF_TOOL = "difftool";
    public static final String KEY_MERGE_TOOL = "mergetool";

    public static String prepareCommand(String str, FileElement fileElement, FileElement fileElement2, FileElement fileElement3, FileElement fileElement4) throws IOException {
        if (fileElement != null) {
            str = fileElement.replaceVariable(str);
        }
        if (fileElement2 != null) {
            str = fileElement2.replaceVariable(str);
        }
        if (fileElement3 != null) {
            str = fileElement3.replaceVariable(str);
        }
        return fileElement4 != null ? fileElement4.replaceVariable(str) : str;
    }

    public static Map<String, String> prepareEnvironment(File file, FileElement fileElement, FileElement fileElement2, FileElement fileElement3, FileElement fileElement4) throws IOException {
        TreeMap treeMap = new TreeMap();
        if (file != null) {
            treeMap.put(Constants.GIT_DIR_KEY, file.getAbsolutePath());
        }
        if (fileElement != null) {
            fileElement.addToEnv(treeMap);
        }
        if (fileElement2 != null) {
            fileElement2.addToEnv(treeMap);
        }
        if (fileElement3 != null) {
            fileElement3.addToEnv(treeMap);
        }
        if (fileElement4 != null) {
            fileElement4.addToEnv(treeMap);
        }
        return treeMap;
    }

    public static String quotePath(String str) {
        if (!str.contains(" ")) {
            return str;
        }
        if (!str.startsWith("\"")) {
            str = "\"" + str;
        }
        return !str.endsWith("\"") ? str + "\"" : str;
    }

    public static boolean isToolAvailable(FS fs, File file, File file2, String str) {
        try {
            return new CommandExecutor(fs, false).checkExecutable(str, file2, prepareEnvironment(file, null, null, null, null));
        } catch (Exception unused) {
            return false;
        }
    }

    public static Set<String> createSortedToolSet(String str, Set<String> set, Set<String> set2) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        if (str != null) {
            LinkedHashSet linkedHashSet2 = new LinkedHashSet();
            LinkedHashSet linkedHashSet3 = new LinkedHashSet();
            linkedHashSet3.addAll(set);
            linkedHashSet3.remove(str);
            linkedHashSet2.addAll(set2);
            linkedHashSet2.remove(str);
            linkedHashSet.add(str);
            linkedHashSet.addAll(linkedHashSet3);
            linkedHashSet.addAll(linkedHashSet2);
            return linkedHashSet;
        }
        linkedHashSet.addAll(set);
        linkedHashSet.addAll(set2);
        return linkedHashSet;
    }

    public static Optional<String> getExternalToolFromAttributes(Repository repository, String str, String str2) throws ToolException {
        Optional<String> optionalEmpty;
        try {
            FileTreeIterator fileTreeIterator = new FileTreeIterator(repository);
            Throwable th = null;
            try {
                TreeWalk treeWalk = new TreeWalk(repository);
                try {
                    treeWalk.addTree(fileTreeIterator);
                    treeWalk.setFilter(new NotIgnoredFilter(0));
                    while (treeWalk.next()) {
                        if (treeWalk.getPathString().equals(str)) {
                            Attributes attributes = treeWalk.getAttributes();
                            if (attributes.containsKey(str2)) {
                                optionalEmpty = Optional.of(attributes.getValue(str2));
                                treeWalk.close();
                                return optionalEmpty;
                            }
                        }
                        if (treeWalk.isSubtree()) {
                            treeWalk.enterSubtree();
                        }
                    }
                    optionalEmpty = Optional.empty();
                    treeWalk.close();
                    return optionalEmpty;
                } catch (Throwable th2) {
                    treeWalk.close();
                    throw th2;
                }
            } catch (Throwable th3) {
                if (0 == 0) {
                    throw th3;
                }
                if (null != th3) {
                    th.addSuppressed(th3);
                }
                throw null;
            }
        } catch (IOException | RevisionSyntaxException e) {
            throw new ToolException(e);
        }
    }
}
