package com.google.api.client.http;

import com.google.api.client.util.StreamingContent;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.GZIPOutputStream;
import org.eclipse.jgit.util.HttpSupport;

/* JADX INFO: loaded from: classes3.dex */
public class GZipEncoding implements HttpEncoding {
    @Override // com.google.api.client.http.HttpEncoding
    public String getName() {
        return HttpSupport.ENCODING_GZIP;
    }

    /* JADX INFO: renamed from: com.google.api.client.http.GZipEncoding$1, reason: invalid class name */
    class AnonymousClass1 extends BufferedOutputStream {
        AnonymousClass1(OutputStream outputStream) {
            super(outputStream);
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            try {
                flush();
            } catch (IOException unused) {
            }
        }
    }

    @Override // com.google.api.client.http.HttpEncoding
    public void encode(StreamingContent streamingContent, OutputStream outputStream) throws IOException {
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(new AnonymousClass1(outputStream));
        streamingContent.writeTo(gZIPOutputStream);
        gZIPOutputStream.close();
    }
}
