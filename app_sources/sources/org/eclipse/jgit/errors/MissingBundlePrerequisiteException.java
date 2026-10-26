package org.eclipse.jgit.errors;

import java.util.Map;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.lib.ObjectId;
import org.eclipse.jgit.transport.URIish;

/* INFO: loaded from: classes5.dex */
public class MissingBundlePrerequisiteException extends TransportException {
    private static final long serialVersionUID = 1;

    private static String format(Map<ObjectId, String> map) {
        StringBuilder sb = new StringBuilder();
        sb.append(JGitText.get().missingPrerequisiteCommits);
        for (Map.Entry<ObjectId, String> entry : map.entrySet()) {
            sb.append("\n  ");
            sb.append(entry.getKey().name());
            if (entry.getValue() != null) {
                sb.append(" ").append(entry.getValue());
            }
        }
        return sb.toString();
    }

    public MissingBundlePrerequisiteException(URIish uRIish, Map<ObjectId, String> map) {
        super(uRIish, format(map));
    }
}
