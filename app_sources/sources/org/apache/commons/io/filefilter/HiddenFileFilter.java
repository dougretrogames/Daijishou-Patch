package org.apache.commons.io.filefilter;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;

/* INFO: loaded from: classes5.dex */
public class HiddenFileFilter extends AbstractFileFilter implements Serializable {
    public static final IOFileFilter HIDDEN;
    public static final IOFileFilter VISIBLE;
    private static final long serialVersionUID = 8930842316112759062L;

    static {
        HiddenFileFilter hiddenFileFilter = new HiddenFileFilter();
        HIDDEN = hiddenFileFilter;
        VISIBLE = hiddenFileFilter.negate();
    }

    protected HiddenFileFilter() {
    }

    @Override // org.apache.commons.io.filefilter.AbstractFileFilter, org.apache.commons.io.filefilter.IOFileFilter, java.io.FileFilter
    public boolean accept(File file) {
        return file == null || file.isHidden();
    }

    @Override // org.apache.commons.io.filefilter.IOFileFilter, org.apache.commons.io.file.PathFilter
    public FileVisitResult accept(Path path, BasicFileAttributes basicFileAttributes) {
        return get(new HiddenFileFilter$$ExternalSyntheticLambda0(this, path));
    }

    /* INFO: renamed from: lambda$accept$0$org-apache-commons-io-filefilter-HiddenFileFilter, reason: not valid java name */
    /* synthetic */ FileVisitResult m5576x3301f0b8(Path path) throws IOException {
        return toFileVisitResult(path == null || Files.isHidden(path));
    }
}
