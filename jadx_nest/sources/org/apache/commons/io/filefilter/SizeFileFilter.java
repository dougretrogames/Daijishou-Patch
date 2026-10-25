package org.apache.commons.io.filefilter;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;

/* JADX INFO: loaded from: classes5.dex */
public class SizeFileFilter extends AbstractFileFilter implements Serializable {
    private static final long serialVersionUID = 7388077430788600069L;
    private final boolean acceptLarger;
    private final long size;

    public SizeFileFilter(long j) {
        this(j, true);
    }

    public SizeFileFilter(long j, boolean z) {
        if (j < 0) {
            throw new IllegalArgumentException("The size must be non-negative");
        }
        this.size = j;
        this.acceptLarger = z;
    }

    @Override // org.apache.commons.io.filefilter.AbstractFileFilter, org.apache.commons.io.filefilter.IOFileFilter, java.io.FileFilter
    public boolean accept(File file) {
        return accept(file != null ? file.length() : 0L);
    }

    private boolean accept(long j) {
        return this.acceptLarger != ((j > this.size ? 1 : (j == this.size ? 0 : -1)) < 0);
    }

    @Override // org.apache.commons.io.filefilter.IOFileFilter, org.apache.commons.io.file.PathFilter
    public FileVisitResult accept(Path path, BasicFileAttributes basicFileAttributes) {
        return get(new SizeFileFilter$$ExternalSyntheticLambda0(this, path));
    }

    /* JADX INFO: renamed from: lambda$accept$0$org-apache-commons-io-filefilter-SizeFileFilter, reason: not valid java name */
    /* synthetic */ FileVisitResult m5581lambda$accept$0$orgapachecommonsiofilefilterSizeFileFilter(Path path) throws IOException {
        return toFileVisitResult(accept(Files.size(path)));
    }

    @Override // org.apache.commons.io.filefilter.AbstractFileFilter
    public String toString() {
        return super.toString() + "(" + (this.acceptLarger ? ">=" : "<") + this.size + ")";
    }

    @Override // org.apache.commons.io.filefilter.AbstractFileFilter, java.nio.file.FileVisitor
    public FileVisitResult visitFile(Path path, BasicFileAttributes basicFileAttributes) throws IOException {
        return toFileVisitResult(accept(Files.size(path)));
    }
}
