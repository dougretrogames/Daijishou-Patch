package kr.motd.maven.os;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes5.dex */
public interface FileOperationProvider {
    InputStream readFile(String str) throws IOException;
}
