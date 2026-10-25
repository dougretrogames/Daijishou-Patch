package org.eclipse.jgit.api;

import java.io.Closeable;
import java.io.IOException;
import java.io.OutputStream;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import net.lingala.zip4j.util.InternalZipConstants;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.api.errors.JGitInternalException;
import org.eclipse.jgit.errors.IncorrectObjectTypeException;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.lib.Constants;
import org.eclipse.jgit.lib.FileMode;
import org.eclipse.jgit.lib.MutableObjectId;
import org.eclipse.jgit.lib.ObjectId;
import org.eclipse.jgit.lib.ObjectLoader;
import org.eclipse.jgit.lib.ObjectReader;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.revwalk.RevCommit;
import org.eclipse.jgit.revwalk.RevObject;
import org.eclipse.jgit.revwalk.RevTree;
import org.eclipse.jgit.revwalk.RevWalk;
import org.eclipse.jgit.treewalk.TreeWalk;
import org.eclipse.jgit.treewalk.filter.PathFilterGroup;

/* JADX INFO: loaded from: classes5.dex */
public class ArchiveCommand extends GitCommand<OutputStream> {
    private static final Map<String, FormatEntry> formats = new ConcurrentHashMap();
    private String format;
    private Map<String, Object> formatOptions;
    private OutputStream out;
    private List<String> paths;
    private String prefix;
    private String suffix;
    private ObjectId tree;

    public interface Format<T extends Closeable> {
        T createArchiveOutputStream(OutputStream outputStream) throws IOException;

        T createArchiveOutputStream(OutputStream outputStream, Map<String, Object> map) throws IOException;

        void putEntry(T t, ObjectId objectId, String str, FileMode fileMode, ObjectLoader objectLoader) throws IOException;

        Iterable<String> suffixes();
    }

    public static class UnsupportedFormatException extends GitAPIException {
        private static final long serialVersionUID = 1;
        private final String format;

        public UnsupportedFormatException(String str) {
            super(MessageFormat.format(JGitText.get().unsupportedArchiveFormat, str));
            this.format = str;
        }

        public String getFormat() {
            return this.format;
        }
    }

    private static class FormatEntry {
        final Format<?> format;
        final int refcnt;

        public FormatEntry(Format<?> format, int i) {
            format.getClass();
            this.format = format;
            this.refcnt = i;
        }
    }

    private static <K, V> boolean replace(Map<K, V> map, K k, V v, V v2) {
        if (v == null && v2 == null) {
            return true;
        }
        if (v == null) {
            return map.putIfAbsent(k, v2) == null;
        }
        if (v2 == null) {
            return map.remove(k, v);
        }
        return map.replace(k, v, v2);
    }

    public static void registerFormat(String str, Format<?> format) {
        Map<String, FormatEntry> map;
        FormatEntry formatEntry;
        FormatEntry formatEntry2;
        format.getClass();
        do {
            map = formats;
            formatEntry = map.get(str);
            if (formatEntry == null) {
                formatEntry2 = new FormatEntry(format, 1);
            } else {
                if (!formatEntry.format.equals(format)) {
                    throw new JGitInternalException(MessageFormat.format(JGitText.get().archiveFormatAlreadyRegistered, str));
                }
                formatEntry2 = new FormatEntry(formatEntry.format, formatEntry.refcnt + 1);
            }
        } while (!replace(map, str, formatEntry, formatEntry2));
    }

    public static void unregisterFormat(String str) {
        Map<String, FormatEntry> map;
        FormatEntry formatEntry;
        do {
            map = formats;
            formatEntry = map.get(str);
            if (formatEntry == null) {
                throw new JGitInternalException(MessageFormat.format(JGitText.get().archiveFormatAlreadyAbsent, str));
            }
        } while (!replace(map, str, formatEntry, formatEntry.refcnt == 1 ? null : new FormatEntry(formatEntry.format, formatEntry.refcnt - 1)));
    }

    private static Format<?> formatBySuffix(String str) throws UnsupportedFormatException {
        if (str != null) {
            Iterator<FormatEntry> it = formats.values().iterator();
            while (it.hasNext()) {
                Format<?> format = it.next().format;
                Iterator<String> it2 = format.suffixes().iterator();
                while (it2.hasNext()) {
                    if (str.endsWith(it2.next())) {
                        return format;
                    }
                }
            }
        }
        return lookupFormat("tar");
    }

    private static Format<?> lookupFormat(String str) throws UnsupportedFormatException {
        FormatEntry formatEntry = formats.get(str);
        if (formatEntry == null) {
            throw new UnsupportedFormatException(str);
        }
        return formatEntry.format;
    }

    public ArchiveCommand(Repository repository) {
        super(repository);
        this.formatOptions = new HashMap();
        this.paths = new ArrayList();
        setCallable(false);
    }

    private <T extends Closeable> OutputStream writeArchive(Format<T> format) {
        Format<T> format2;
        Throwable th = null;
        try {
            try {
                TreeWalk treeWalk = new TreeWalk(this.repo);
                try {
                    RevWalk revWalk = new RevWalk(treeWalk.getObjectReader());
                    try {
                        Closeable closeableCreateArchiveOutputStream = format.createArchiveOutputStream(this.out, this.formatOptions);
                        try {
                            String str = this.prefix;
                            if (str == null) {
                                str = "";
                            }
                            MutableObjectId mutableObjectId = new MutableObjectId();
                            ObjectReader objectReader = treeWalk.getObjectReader();
                            RevObject revObjectPeel = revWalk.peel(revWalk.parseAny(this.tree));
                            treeWalk.reset(getTree(revObjectPeel));
                            if (!this.paths.isEmpty()) {
                                treeWalk.setFilter(PathFilterGroup.createFromStrings(this.paths));
                            }
                            if (str.endsWith(InternalZipConstants.ZIP_FILE_SEPARATOR)) {
                                format2 = format;
                                format2.putEntry(closeableCreateArchiveOutputStream, revObjectPeel, str.replaceAll("[/]+$", InternalZipConstants.ZIP_FILE_SEPARATOR), FileMode.TREE, null);
                            } else {
                                format2 = format;
                            }
                            while (treeWalk.next()) {
                                String str2 = str + treeWalk.getPathString();
                                FileMode fileMode = treeWalk.getFileMode(0);
                                if (treeWalk.isSubtree()) {
                                    treeWalk.enterSubtree();
                                }
                                if (fileMode == FileMode.GITLINK) {
                                    fileMode = FileMode.TREE;
                                }
                                if (fileMode == FileMode.TREE) {
                                    format2.putEntry(closeableCreateArchiveOutputStream, revObjectPeel, str2 + InternalZipConstants.ZIP_FILE_SEPARATOR, fileMode, null);
                                } else {
                                    treeWalk.getObjectId(mutableObjectId, 0);
                                    format2.putEntry(closeableCreateArchiveOutputStream, revObjectPeel, str2, fileMode, objectReader.open(mutableObjectId));
                                }
                            }
                            OutputStream outputStream = this.out;
                            if (closeableCreateArchiveOutputStream != null) {
                                closeableCreateArchiveOutputStream.close();
                            }
                            revWalk.close();
                            treeWalk.close();
                            this.out.close();
                            return outputStream;
                        } catch (Throwable th2) {
                            if (closeableCreateArchiveOutputStream == null) {
                                throw th2;
                            }
                            closeableCreateArchiveOutputStream.close();
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
                        th = th4;
                    } else if (null != th4) {
                        th.addSuppressed(th4);
                    }
                    treeWalk.close();
                    throw th;
                }
            } catch (Throwable th5) {
                if (0 == 0) {
                    throw th5;
                }
                if (null != th5) {
                    try {
                        th.addSuppressed(th5);
                    } catch (Throwable th6) {
                        this.out.close();
                        throw th6;
                    }
                }
                throw null;
            }
        } catch (IOException e) {
            throw new JGitInternalException(JGitText.get().exceptionCaughtDuringExecutionOfArchiveCommand, e);
        }
    }

    @Override // org.eclipse.jgit.api.GitCommand, java.util.concurrent.Callable
    public OutputStream call() throws GitAPIException {
        Format<?> formatLookupFormat;
        checkCallable();
        String str = this.format;
        if (str == null) {
            formatLookupFormat = formatBySuffix(this.suffix);
        } else {
            formatLookupFormat = lookupFormat(str);
        }
        return writeArchive(formatLookupFormat);
    }

    public ArchiveCommand setTree(ObjectId objectId) {
        if (objectId == null) {
            throw new IllegalArgumentException();
        }
        this.tree = objectId;
        setCallable(true);
        return this;
    }

    public ArchiveCommand setPrefix(String str) {
        this.prefix = str;
        return this;
    }

    public ArchiveCommand setFilename(String str) {
        int iIndexOf = str.indexOf(46, str.lastIndexOf(47) + 1);
        if (iIndexOf == -1) {
            this.suffix = "";
            return this;
        }
        this.suffix = str.substring(iIndexOf);
        return this;
    }

    public ArchiveCommand setOutputStream(OutputStream outputStream) {
        this.out = outputStream;
        return this;
    }

    public ArchiveCommand setFormat(String str) {
        this.format = str;
        return this;
    }

    public ArchiveCommand setFormatOptions(Map<String, Object> map) {
        this.formatOptions = map;
        return this;
    }

    public ArchiveCommand setPaths(String... strArr) {
        this.paths = Arrays.asList(strArr);
        return this;
    }

    private RevTree getTree(RevObject revObject) throws IncorrectObjectTypeException {
        if (revObject instanceof RevCommit) {
            return ((RevCommit) revObject).getTree();
        }
        if (!(revObject instanceof RevTree)) {
            throw new IncorrectObjectTypeException(this.tree.toObjectId(), Constants.TYPE_TREE);
        }
        return (RevTree) revObject;
    }
}
