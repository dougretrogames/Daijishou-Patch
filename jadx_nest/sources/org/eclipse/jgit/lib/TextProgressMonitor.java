package org.eclipse.jgit.lib;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import org.apache.http.message.TokenParser;

/* JADX INFO: loaded from: classes5.dex */
public class TextProgressMonitor extends BatchingProgressMonitor {
    private final Writer out;
    private boolean write;

    public TextProgressMonitor() {
        this(new PrintWriter(new OutputStreamWriter(System.err, StandardCharsets.UTF_8)));
    }

    public TextProgressMonitor(Writer writer) {
        this.out = writer;
        this.write = true;
    }

    @Override // org.eclipse.jgit.lib.BatchingProgressMonitor
    protected void onUpdate(String str, int i, Duration duration) {
        StringBuilder sb = new StringBuilder();
        format(sb, str, i, duration);
        send(sb);
    }

    @Override // org.eclipse.jgit.lib.BatchingProgressMonitor
    protected void onEndTask(String str, int i, Duration duration) {
        StringBuilder sb = new StringBuilder();
        format(sb, str, i, duration);
        sb.append("\n");
        send(sb);
    }

    private void format(StringBuilder sb, String str, int i, Duration duration) {
        sb.append("\r");
        sb.append(str);
        sb.append(": ");
        while (sb.length() < 25) {
            sb.append(TokenParser.SP);
        }
        sb.append(i);
        appendDuration(sb, duration);
    }

    @Override // org.eclipse.jgit.lib.BatchingProgressMonitor
    protected void onUpdate(String str, int i, int i2, int i3, Duration duration) {
        StringBuilder sb = new StringBuilder();
        format(sb, str, i, i2, i3, duration);
        send(sb);
    }

    @Override // org.eclipse.jgit.lib.BatchingProgressMonitor
    protected void onEndTask(String str, int i, int i2, int i3, Duration duration) {
        StringBuilder sb = new StringBuilder();
        format(sb, str, i, i2, i3, duration);
        sb.append("\n");
        send(sb);
    }

    private void format(StringBuilder sb, String str, int i, int i2, int i3, Duration duration) {
        sb.append("\r");
        sb.append(str);
        sb.append(": ");
        while (sb.length() < 25) {
            sb.append(TokenParser.SP);
        }
        String strValueOf = String.valueOf(i2);
        String strValueOf2 = String.valueOf(i);
        while (strValueOf2.length() < strValueOf.length()) {
            strValueOf2 = " " + strValueOf2;
        }
        if (i3 < 100) {
            sb.append(TokenParser.SP);
        }
        if (i3 < 10) {
            sb.append(TokenParser.SP);
        }
        sb.append(i3);
        sb.append("% (");
        sb.append(strValueOf2);
        sb.append('/');
        sb.append(strValueOf);
        sb.append(')');
        appendDuration(sb, duration);
    }

    private void send(StringBuilder sb) {
        if (this.write) {
            try {
                this.out.write(sb.toString());
                this.out.flush();
            } catch (IOException unused) {
                this.write = false;
            }
        }
    }
}
