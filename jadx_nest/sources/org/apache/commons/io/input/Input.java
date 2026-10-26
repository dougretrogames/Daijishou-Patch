package org.apache.commons.io.input;

import java.io.IOException;

/* INFO: loaded from: classes5.dex */
class Input {
    Input() {
    }

    static void checkOpen(boolean z) throws IOException {
        if (!z) {
            throw new IOException("Closed");
        }
    }
}
