package org.eclipse.jgit.attributes;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.eclipse.jgit.lib.Repository;

/* JADX INFO: loaded from: classes5.dex */
public interface FilterCommandFactory {
    FilterCommand create(Repository repository, InputStream inputStream, OutputStream outputStream) throws IOException;
}
