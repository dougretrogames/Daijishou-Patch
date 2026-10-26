package org.eclipse.jgit.api.errors;

import java.text.MessageFormat;
import java.util.List;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.patch.FormatError;

/* INFO: loaded from: classes5.dex */
public class PatchFormatException extends GitAPIException {
    private static final long serialVersionUID = 1;
    private List<FormatError> errors;

    public PatchFormatException(List<FormatError> list) {
        super(MessageFormat.format(JGitText.get().patchFormatException, list));
        this.errors = list;
    }

    public List<FormatError> getErrors() {
        return this.errors;
    }
}
