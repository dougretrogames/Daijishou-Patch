package org.eclipse.jgit.treewalk.filter;

import java.io.IOException;
import java.text.MessageFormat;
import org.eclipse.jgit.errors.StopWalkException;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.treewalk.TreeWalk;

/* INFO: loaded from: classes5.dex */
public class TreeFilterMarker {
    private final TreeFilter[] filters;

    public TreeFilterMarker(TreeFilter[] treeFilterArr) {
        if (treeFilterArr.length > 32) {
            throw new IllegalArgumentException(MessageFormat.format(JGitText.get().treeFilterMarkerTooManyFilters, 32, Integer.valueOf(treeFilterArr.length)));
        }
        TreeFilter[] treeFilterArr2 = new TreeFilter[treeFilterArr.length];
        this.filters = treeFilterArr2;
        System.arraycopy(treeFilterArr, 0, treeFilterArr2, 0, treeFilterArr.length);
    }

    public int getMarks(TreeWalk treeWalk) throws IOException {
        int i = 0;
        int i2 = 0;
        while (true) {
            TreeFilter[] treeFilterArr = this.filters;
            if (i >= treeFilterArr.length) {
                return i2;
            }
            TreeFilter treeFilter = treeFilterArr[i];
            if (treeFilter != null) {
                try {
                    if (treeFilter.include(treeWalk)) {
                        i2 |= 1 << i;
                    }
                } catch (StopWalkException unused) {
                    this.filters[i] = null;
                }
            }
            i++;
        }
    }
}
