package org.jsoup;

/* INFO: loaded from: classes5.dex */
@FunctionalInterface
public interface Progress<ProgressContext> {
    void onProgress(int i, int i2, float f, ProgressContext progresscontext);
}
