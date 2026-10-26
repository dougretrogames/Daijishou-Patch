package org.apache.commons.io.filefilter;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.stream.Stream;
import org.apache.commons.io.IOUtils;

/* INFO: loaded from: classes5.dex */
public class EmptyFileFilter extends AbstractFileFilter implements Serializable {
    public static final IOFileFilter EMPTY;
    public static final IOFileFilter NOT_EMPTY;
    private static final long serialVersionUID = 3631422087512832211L;

    static {
        EmptyFileFilter emptyFileFilter = new EmptyFileFilter();
        EMPTY = emptyFileFilter;
        NOT_EMPTY = emptyFileFilter.negate();
    }

    protected EmptyFileFilter() {
    }

    @Override // org.apache.commons.io.filefilter.AbstractFileFilter, org.apache.commons.io.filefilter.IOFileFilter, java.io.FileFilter
    public boolean accept(File file) {
        if (file == null) {
            return true;
        }
        if (file.isDirectory()) {
            return IOUtils.length(file.listFiles()) == 0;
        }
        return file.length() == 0;
    }

    @Override // org.apache.commons.io.filefilter.IOFileFilter, org.apache.commons.io.file.PathFilter
    public FileVisitResult accept(Path path, BasicFileAttributes basicFileAttributes) {
        if (path == null) {
            return toFileVisitResult(true);
        }
        return get(new EmptyFileFilter$$ExternalSyntheticLambda0(this, path));
    }

    /* INFO: renamed from: lambda$accept$0$org-apache-commons-io-filefilter-EmptyFileFilter, reason: not valid java name */
    /* synthetic */ FileVisitResult m5575lambda$accept$0$orgapachecommonsiofilefilterEmptyFileFilter(Path path) throws IOException {
        if (!Files.isDirectory(path, new LinkOption[0])) {
            return toFileVisitResult(Files.size(path) == 0);
        }
        Stream<Path> list = Files.list(path);
        try {
            FileVisitResult fileVisitResult = toFileVisitResult(!list.findFirst().isPresent());
            if (list != null) {
                list.close();
            }
            return fileVisitResult;
        } catch (Throwable th) {
            if (list != null) {
                try {
                    list.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }
}
