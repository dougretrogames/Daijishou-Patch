package org.eclipse.jgit.lib;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.text.MessageFormat;
import org.eclipse.jgit.errors.ConfigInvalidException;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.revwalk.RevCommit;
import org.eclipse.jgit.revwalk.RevTree;
import org.eclipse.jgit.revwalk.RevWalk;
import org.eclipse.jgit.treewalk.TreeWalk;
import org.eclipse.jgit.util.RawParseUtils;

/* JADX INFO: loaded from: classes5.dex */
public class BlobBasedConfig extends Config {
    public BlobBasedConfig(Config config, byte[] bArr) throws ConfigInvalidException {
        String strDecode;
        super(config);
        if (isUtf8(bArr)) {
            strDecode = RawParseUtils.decode(StandardCharsets.UTF_8, bArr, 3, bArr.length);
        } else {
            strDecode = RawParseUtils.decode(bArr);
        }
        fromText(strDecode);
    }

    public BlobBasedConfig(Config config, Repository repository, AnyObjectId anyObjectId) throws ConfigInvalidException, IOException {
        this(config, read(repository, anyObjectId));
    }

    private static byte[] read(Repository repository, AnyObjectId anyObjectId) throws IOException {
        Throwable th = null;
        try {
            ObjectReader objectReaderNewObjectReader = repository.newObjectReader();
            try {
                return read(objectReaderNewObjectReader, anyObjectId);
            } finally {
                if (objectReaderNewObjectReader != null) {
                    objectReaderNewObjectReader.close();
                }
            }
        } catch (Throwable th2) {
            if (0 == 0) {
                throw th2;
            }
            if (null != th2) {
                th.addSuppressed(th2);
            }
            throw null;
        }
    }

    private static byte[] read(ObjectReader objectReader, AnyObjectId anyObjectId) throws IOException {
        return objectReader.open(anyObjectId, 3).getCachedBytes(Integer.MAX_VALUE);
    }

    public BlobBasedConfig(Config config, Repository repository, AnyObjectId anyObjectId, String str) throws ConfigInvalidException, IOException {
        this(config, read(repository, anyObjectId, str));
    }

    private static byte[] read(Repository repository, AnyObjectId anyObjectId, String str) throws IOException {
        Throwable th = null;
        try {
            ObjectReader objectReaderNewObjectReader = repository.newObjectReader();
            try {
                TreeWalk treeWalkForPath = TreeWalk.forPath(objectReaderNewObjectReader, str, asTree(objectReaderNewObjectReader, anyObjectId));
                if (treeWalkForPath == null) {
                    throw new FileNotFoundException(MessageFormat.format(JGitText.get().entryNotFoundByPath, str));
                }
                byte[] bArr = read(objectReaderNewObjectReader, treeWalkForPath.getObjectId(0));
                if (objectReaderNewObjectReader != null) {
                    objectReaderNewObjectReader.close();
                }
                return bArr;
            } catch (Throwable th2) {
                if (objectReaderNewObjectReader == null) {
                    throw th2;
                }
                objectReaderNewObjectReader.close();
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
    }

    private static AnyObjectId asTree(ObjectReader objectReader, AnyObjectId anyObjectId) throws IOException {
        if (anyObjectId instanceof RevTree) {
            return anyObjectId;
        }
        if (anyObjectId instanceof RevCommit) {
            RevCommit revCommit = (RevCommit) anyObjectId;
            if (revCommit.getTree() != null) {
                return revCommit.getTree();
            }
        }
        Throwable th = null;
        try {
            RevWalk revWalk = new RevWalk(objectReader);
            try {
                return revWalk.parseTree(anyObjectId).getId();
            } finally {
                revWalk.close();
            }
        } catch (Throwable th2) {
            if (0 == 0) {
                throw th2;
            }
            if (null != th2) {
                th.addSuppressed(th2);
            }
            throw null;
        }
    }
}
