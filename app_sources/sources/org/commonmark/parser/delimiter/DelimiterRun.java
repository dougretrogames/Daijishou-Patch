package org.commonmark.parser.delimiter;

/* INFO: loaded from: classes5.dex */
public interface DelimiterRun {
    boolean canClose();

    boolean canOpen();

    int length();

    int originalLength();
}
