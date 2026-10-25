package org.apache.commons.io.filefilter;

import java.io.File;
import java.io.Serializable;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

/* JADX INFO: loaded from: classes5.dex */
public class OrFileFilter extends AbstractFileFilter implements ConditionalFileFilter, Serializable {
    private static final long serialVersionUID = 5767770777065432721L;
    private final List<IOFileFilter> fileFilters;

    public OrFileFilter() {
        this(0);
    }

    private OrFileFilter(ArrayList<IOFileFilter> arrayList) {
        this.fileFilters = (List) Objects.requireNonNull(arrayList, "initialList");
    }

    private OrFileFilter(int i) {
        this((ArrayList<IOFileFilter>) new ArrayList(i));
    }

    public OrFileFilter(IOFileFilter... iOFileFilterArr) {
        this(((IOFileFilter[]) Objects.requireNonNull(iOFileFilterArr, "fileFilters")).length);
        addFileFilter(iOFileFilterArr);
    }

    public OrFileFilter(IOFileFilter iOFileFilter, IOFileFilter iOFileFilter2) {
        this(2);
        addFileFilter(iOFileFilter);
        addFileFilter(iOFileFilter2);
    }

    public OrFileFilter(List<IOFileFilter> list) {
        this((ArrayList<IOFileFilter>) new ArrayList((Collection) Objects.requireNonNull(list, "fileFilters")));
    }

    @Override // org.apache.commons.io.filefilter.AbstractFileFilter, org.apache.commons.io.filefilter.IOFileFilter, java.io.FileFilter
    public boolean accept(File file) {
        return this.fileFilters.stream().anyMatch(new OrFileFilter$$ExternalSyntheticLambda0(file));
    }

    @Override // org.apache.commons.io.filefilter.AbstractFileFilter, org.apache.commons.io.filefilter.IOFileFilter, java.io.FilenameFilter
    public boolean accept(File file, String str) {
        return this.fileFilters.stream().anyMatch(new OrFileFilter$$ExternalSyntheticLambda2(file, str));
    }

    static /* synthetic */ boolean lambda$accept$2(Path path, BasicFileAttributes basicFileAttributes, IOFileFilter iOFileFilter) {
        return iOFileFilter.accept(path, basicFileAttributes) == FileVisitResult.CONTINUE;
    }

    @Override // org.apache.commons.io.filefilter.IOFileFilter, org.apache.commons.io.file.PathFilter
    public FileVisitResult accept(Path path, BasicFileAttributes basicFileAttributes) {
        return toDefaultFileVisitResult(this.fileFilters.stream().anyMatch(new OrFileFilter$$ExternalSyntheticLambda3(path, basicFileAttributes)));
    }

    @Override // org.apache.commons.io.filefilter.ConditionalFileFilter
    public void addFileFilter(IOFileFilter iOFileFilter) {
        this.fileFilters.add((IOFileFilter) Objects.requireNonNull(iOFileFilter, "fileFilter"));
    }

    public void addFileFilter(IOFileFilter... iOFileFilterArr) {
        Stream.of((Object[]) Objects.requireNonNull(iOFileFilterArr, "fileFilters")).forEach(new OrFileFilter$$ExternalSyntheticLambda1(this));
    }

    @Override // org.apache.commons.io.filefilter.ConditionalFileFilter
    public List<IOFileFilter> getFileFilters() {
        return Collections.unmodifiableList(this.fileFilters);
    }

    @Override // org.apache.commons.io.filefilter.ConditionalFileFilter
    public boolean removeFileFilter(IOFileFilter iOFileFilter) {
        return this.fileFilters.remove(iOFileFilter);
    }

    @Override // org.apache.commons.io.filefilter.ConditionalFileFilter
    public void setFileFilters(List<IOFileFilter> list) {
        this.fileFilters.clear();
        this.fileFilters.addAll((Collection) Objects.requireNonNull(list, "fileFilters"));
    }

    @Override // org.apache.commons.io.filefilter.AbstractFileFilter
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("(");
        append(this.fileFilters, sb);
        sb.append(")");
        return sb.toString();
    }
}
