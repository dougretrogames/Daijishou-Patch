package org.eclipse.jgit.errors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import org.eclipse.jgit.internal.JGitText;

/* INFO: loaded from: classes5.dex */
public class CompoundException extends Exception {
    private static final long serialVersionUID = 1;
    private final List<Throwable> causeList;

    private static String format(Collection<Throwable> collection) {
        StringBuilder sb = new StringBuilder();
        sb.append(JGitText.get().failureDueToOneOfTheFollowing);
        for (Throwable th : collection) {
            sb.append("  ");
            sb.append(th.getMessage());
            sb.append("\n");
        }
        return sb.toString();
    }

    public CompoundException(Collection<Throwable> collection) {
        super(format(collection));
        this.causeList = Collections.unmodifiableList(new ArrayList(collection));
    }

    public List<Throwable> getAllCauses() {
        return this.causeList;
    }
}
