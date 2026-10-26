package org.eclipse.jgit.internal.diffmergetool;

import org.eclipse.jgit.util.FS;
import org.eclipse.jgit.util.SystemReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* INFO: loaded from: classes5.dex */
public class ToolException extends Exception {
    private static final Logger LOG = LoggerFactory.getLogger((Class<?>) ToolException.class);
    private static final long serialVersionUID = 1;
    private final boolean commandExecutionError;
    private final FS.ExecutionResult result;

    public ToolException() {
        this(null, null, false);
    }

    public ToolException(String str) {
        this(str, null, false);
    }

    public ToolException(String str, FS.ExecutionResult executionResult, boolean z) {
        super(str);
        this.result = executionResult;
        this.commandExecutionError = z;
    }

    public ToolException(String str, Throwable th) {
        super(str, th);
        this.result = null;
        this.commandExecutionError = false;
    }

    public ToolException(Throwable th) {
        super(th);
        this.result = null;
        this.commandExecutionError = false;
    }

    public boolean isResult() {
        return this.result != null;
    }

    public FS.ExecutionResult getResult() {
        return this.result;
    }

    public boolean isCommandExecutionError() {
        return this.commandExecutionError;
    }

    public String getResultStderr() {
        if (this.result == null) {
            return "";
        }
        try {
            return new String(this.result.getStderr().toByteArray(), SystemReader.getInstance().getDefaultCharset());
        } catch (Exception e) {
            LOG.warn("Failed to retrieve standard error output", (Throwable) e);
            return "";
        }
    }

    public String getResultStdout() {
        if (this.result == null) {
            return "";
        }
        try {
            return new String(this.result.getStdout().toByteArray(), SystemReader.getInstance().getDefaultCharset());
        } catch (Exception e) {
            LOG.warn("Failed to retrieve standard output", (Throwable) e);
            return "";
        }
    }
}
