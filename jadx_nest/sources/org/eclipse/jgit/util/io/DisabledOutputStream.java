package org.eclipse.jgit.util.io;

import java.io.IOException;
import java.io.OutputStream;
import org.eclipse.jgit.internal.JGitText;

/* JADX INFO: loaded from: classes5.dex */
public final class DisabledOutputStream extends OutputStream {
    public static final DisabledOutputStream INSTANCE = new DisabledOutputStream();

    private DisabledOutputStream() {
    }

    @Override // java.io.OutputStream
    public void write(int i) throws IOException {
        throw new IllegalStateException(JGitText.get().writingNotPermitted);
    }
}
