package org.eclipse.jgit.transport;

import java.io.IOException;
import java.util.Map;

/* INFO: loaded from: classes5.dex */
public interface RemoteSession2 extends RemoteSession {
    Process exec(String str, Map<String, String> map, int i) throws IOException;
}
