package org.eclipse.jgit.transport;

import java.io.IOException;
import java.io.OutputStream;
import java.time.Duration;
import org.apache.http.message.TokenParser;
import org.eclipse.jgit.lib.BatchingProgressMonitor;
import org.eclipse.jgit.lib.Constants;

/* JADX INFO: loaded from: classes5.dex */
class SideBandProgressMonitor extends BatchingProgressMonitor {
    private final OutputStream out;
    private boolean write = true;

    SideBandProgressMonitor(OutputStream outputStream) {
        this.out = outputStream;
    }

    @Override // org.eclipse.jgit.lib.BatchingProgressMonitor
    protected void onUpdate(String str, int i, Duration duration) {
        StringBuilder sb = new StringBuilder();
        format(sb, str, i, duration);
        sb.append("   \r");
        send(sb);
    }

    @Override // org.eclipse.jgit.lib.BatchingProgressMonitor
    protected void onEndTask(String str, int i, Duration duration) {
        StringBuilder sb = new StringBuilder();
        format(sb, str, i, duration);
        sb.append(", done\n");
        send(sb);
    }

    private void format(StringBuilder sb, String str, int i, Duration duration) {
        sb.append(str);
        sb.append(": ");
        sb.append(i);
        appendDuration(sb, duration);
    }

    @Override // org.eclipse.jgit.lib.BatchingProgressMonitor
    protected void onUpdate(String str, int i, int i2, int i3, Duration duration) {
        StringBuilder sb = new StringBuilder();
        format(sb, str, i, i2, i3, duration);
        sb.append("   \r");
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
        sb.append(str);
        sb.append(": ");
        if (i3 < 100) {
            sb.append(TokenParser.SP);
        }
        if (i3 < 10) {
            sb.append(TokenParser.SP);
        }
        sb.append(i3);
        sb.append("% (");
        sb.append(i);
        sb.append('/');
        sb.append(i2);
        sb.append(')');
        appendDuration(sb, duration);
    }

    private void send(StringBuilder sb) {
        if (this.write) {
            try {
                this.out.write(Constants.encode(sb.toString()));
                this.out.flush();
            } catch (IOException unused) {
                this.write = false;
            }
        }
    }
}
