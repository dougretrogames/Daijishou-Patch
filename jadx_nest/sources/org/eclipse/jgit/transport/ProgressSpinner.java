package org.eclipse.jgit.transport;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeUnit;
import org.apache.commons.codec.language.Soundex;
import org.apache.http.message.TokenParser;

/* JADX INFO: loaded from: classes5.dex */
public class ProgressSpinner {
    private static final long MIN_REFRESH_MILLIS = 500;
    private static final char[] STATES = {Soundex.SILENT_MARKER, '\\', '|', '/'};
    private String msg;
    private long nextUpdateMillis;
    private final OutputStream out;
    private boolean shown;
    private int state;
    private boolean write = true;

    public ProgressSpinner(OutputStream outputStream) {
        this.out = outputStream;
    }

    public void beginTask(String str, long j, TimeUnit timeUnit) {
        this.msg = str;
        this.state = 0;
        this.shown = false;
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (j > 0) {
            this.nextUpdateMillis = jCurrentTimeMillis + timeUnit.toMillis(j);
        } else {
            send(jCurrentTimeMillis);
        }
    }

    public void update() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis >= this.nextUpdateMillis) {
            send(jCurrentTimeMillis);
            this.state = (this.state + 1) % STATES.length;
        }
    }

    private void send(long j) {
        StringBuilder sb = new StringBuilder(this.msg.length() + 16);
        sb.append(TokenParser.CR).append(this.msg).append("... (");
        sb.append(STATES[this.state]);
        sb.append(")  ");
        this.shown = true;
        write(sb.toString());
        this.nextUpdateMillis = j + MIN_REFRESH_MILLIS;
    }

    public void endTask(String str) {
        if (this.shown) {
            write("\r" + this.msg + "... " + str + "\n");
        }
    }

    private void write(String str) {
        if (this.write) {
            try {
                this.out.write(str.getBytes(StandardCharsets.UTF_8));
                this.out.flush();
            } catch (IOException unused) {
                this.write = false;
            }
        }
    }
}
