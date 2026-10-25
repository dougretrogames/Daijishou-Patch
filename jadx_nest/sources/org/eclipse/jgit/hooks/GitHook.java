package org.eclipse.jgit.hooks;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.concurrent.Callable;
import org.eclipse.jgit.api.errors.AbortedByHookException;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.util.FS;
import org.eclipse.jgit.util.ProcessResult;
import org.eclipse.jgit.util.SystemReader;
import org.eclipse.jgit.util.io.TeeOutputStream;

/* JADX INFO: loaded from: classes5.dex */
public abstract class GitHook<T> implements Callable<T> {
    private final OutputStream errorStream;
    private final OutputStream outputStream;
    private final Repository repo;

    @Override // java.util.concurrent.Callable
    public abstract T call() throws AbortedByHookException, IOException;

    public abstract String getHookName();

    protected String getStdinArgs() {
        return null;
    }

    protected GitHook(Repository repository, OutputStream outputStream) {
        this(repository, outputStream, null);
    }

    protected GitHook(Repository repository, OutputStream outputStream, OutputStream outputStream2) {
        this.repo = repository;
        this.outputStream = outputStream;
        this.errorStream = outputStream2;
    }

    protected Repository getRepository() {
        return this.repo;
    }

    protected String[] getParameters() {
        return new String[0];
    }

    protected OutputStream getOutputStream() {
        OutputStream outputStream = this.outputStream;
        return outputStream == null ? System.out : outputStream;
    }

    protected OutputStream getErrorStream() {
        OutputStream outputStream = this.errorStream;
        return outputStream == null ? System.err : outputStream;
    }

    protected void doRun() throws AbortedByHookException, IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        TeeOutputStream teeOutputStream = new TeeOutputStream(byteArrayOutputStream, getErrorStream());
        Repository repository = getRepository();
        FS fs = repository.getFS();
        if (fs == null) {
            fs = FS.DETECTED;
        }
        ProcessResult processResultRunHookIfPresent = fs.runHookIfPresent(repository, getHookName(), getParameters(), getOutputStream(), teeOutputStream, getStdinArgs());
        if (processResultRunHookIfPresent.isExecutedWithError()) {
            handleError(new String(byteArrayOutputStream.toByteArray(), SystemReader.getInstance().getDefaultCharset().name()), processResultRunHookIfPresent);
        }
    }

    protected void handleError(String str, ProcessResult processResult) throws AbortedByHookException {
        throw new AbortedByHookException(str, getHookName(), processResult.getExitCode());
    }

    public boolean isNativeHookPresent() {
        FS fs = getRepository().getFS();
        if (fs == null) {
            fs = FS.DETECTED;
        }
        return fs.findHook(getRepository(), getHookName()) != null;
    }
}
