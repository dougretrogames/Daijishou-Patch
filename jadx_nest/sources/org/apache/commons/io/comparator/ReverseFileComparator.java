package org.apache.commons.io.comparator;

import java.io.File;
import java.io.Serializable;
import java.util.Comparator;
import java.util.Objects;
import org.apache.commons.collections4.CollectionUtils;

/* JADX INFO: loaded from: classes5.dex */
final class ReverseFileComparator extends AbstractFileComparator implements Serializable {
    private static final long serialVersionUID = -4808255005272229056L;
    private final Comparator<File> delegate;

    ReverseFileComparator(Comparator<File> comparator) {
        this.delegate = (Comparator) Objects.requireNonNull(comparator, "delegate");
    }

    @Override // java.util.Comparator
    public int compare(File file, File file2) {
        return this.delegate.compare(file2, file);
    }

    @Override // org.apache.commons.io.comparator.AbstractFileComparator
    public String toString() {
        return super.toString() + CollectionUtils.DEFAULT_TOSTRING_PREFIX + this.delegate.toString() + CollectionUtils.DEFAULT_TOSTRING_SUFFIX;
    }
}
