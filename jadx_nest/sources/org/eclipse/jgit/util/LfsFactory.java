package org.eclipse.jgit.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.text.MessageFormat;
import java.util.concurrent.Callable;
import org.eclipse.jgit.annotations.Nullable;
import org.eclipse.jgit.attributes.Attribute;
import org.eclipse.jgit.attributes.Attributes;
import org.eclipse.jgit.hooks.PrePushHook;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.lib.ObjectLoader;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.revwalk.RevCommit;
import org.eclipse.jgit.treewalk.FileTreeIterator;
import org.eclipse.jgit.treewalk.TreeWalk;
import org.eclipse.jgit.treewalk.filter.PathFilter;

/* JADX INFO: loaded from: classes5.dex */
public class LfsFactory {
    private static LfsFactory instance = new LfsFactory();

    public interface LfsInstallCommand extends Callable<Void> {
        LfsInstallCommand setRepository(Repository repository);
    }

    public ObjectLoader applySmudgeFilter(Repository repository, ObjectLoader objectLoader, Attribute attribute) throws IOException {
        return objectLoader;
    }

    @Nullable
    public LfsInstallCommand getInstallCommand() {
        return null;
    }

    @Nullable
    public PrePushHook getPrePushHook(Repository repository, PrintStream printStream) {
        return null;
    }

    public boolean isAvailable() {
        return false;
    }

    public boolean isEnabled(Repository repository) {
        return false;
    }

    protected LfsFactory() {
    }

    public static LfsFactory getInstance() {
        return instance;
    }

    public static void setInstance(LfsFactory lfsFactory) {
        instance = lfsFactory;
    }

    public LfsInputStream applyCleanFilter(Repository repository, InputStream inputStream, long j, Attribute attribute) throws IOException {
        return new LfsInputStream(inputStream, j);
    }

    @Nullable
    public PrePushHook getPrePushHook(Repository repository, PrintStream printStream, PrintStream printStream2) {
        return getPrePushHook(repository, printStream);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r0v4, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.lang.Throwable] */
    public static Attributes getAttributesForPath(Repository repository, String str) throws IOException {
        Attributes attributes;
        ?? r0 = 0;
        r0 = 0;
        try {
            TreeWalk treeWalk = new TreeWalk(repository);
            try {
                treeWalk.addTree(new FileTreeIterator(repository));
                PathFilter pathFilterCreate = PathFilter.create(str);
                treeWalk.setFilter(pathFilterCreate);
                treeWalk.setRecursive(false);
                while (true) {
                    if (!treeWalk.next()) {
                        attributes = null;
                        break;
                    }
                    if (pathFilterCreate.isDone(treeWalk)) {
                        attributes = treeWalk.getAttributes();
                        break;
                    }
                    if (treeWalk.isSubtree()) {
                        treeWalk.enterSubtree();
                    }
                }
                if (attributes != null) {
                    return attributes;
                }
                r0 = JGitText.get().noPathAttributesFound;
                throw new IOException(MessageFormat.format(r0, str));
            } finally {
                treeWalk.close();
            }
        } catch (Throwable th) {
            if (r0 == 0) {
                throw th;
            }
            if (r0 != th) {
                r0.addSuppressed(th);
            }
            throw r0;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r0v4, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.lang.Throwable] */
    public static Attributes getAttributesForPath(Repository repository, String str, RevCommit revCommit) throws IOException {
        Attributes attributes;
        if (revCommit == null) {
            return getAttributesForPath(repository, str);
        }
        ?? r0 = 0;
        r0 = 0;
        try {
            TreeWalk treeWalkForPath = TreeWalk.forPath(repository, str, revCommit.getTree());
            if (treeWalkForPath == null) {
                attributes = null;
            } else {
                try {
                    attributes = treeWalkForPath.getAttributes();
                } finally {
                    if (treeWalkForPath != null) {
                        treeWalkForPath.close();
                    }
                }
            }
            if (attributes != null) {
                return attributes;
            }
            r0 = JGitText.get().noPathAttributesFound;
            throw new IOException(MessageFormat.format(r0, str));
        } catch (Throwable th) {
            if (r0 == 0) {
                throw th;
            }
            if (r0 != th) {
                r0.addSuppressed(th);
            }
            throw r0;
        }
    }

    public static final class LfsInputStream extends InputStream {
        private long length;
        private InputStream stream;

        public LfsInputStream(InputStream inputStream, long j) {
            this.stream = inputStream;
            this.length = j;
        }

        public LfsInputStream(TemporaryBuffer temporaryBuffer) throws IOException {
            this.stream = temporaryBuffer.openInputStreamWithAutoDestroy();
            this.length = temporaryBuffer.length();
        }

        @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.stream.close();
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            return this.stream.read();
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i, int i2) throws IOException {
            return this.stream.read(bArr, i, i2);
        }

        public long getLength() {
            return this.length;
        }
    }
}
