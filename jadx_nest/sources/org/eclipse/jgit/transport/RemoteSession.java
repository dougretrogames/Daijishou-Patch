package org.eclipse.jgit.transport;

import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public interface RemoteSession {
    void disconnect();

    Process exec(String str, int i) throws IOException;

    default FtpChannel getFtpChannel() {
        return null;
    }
}
