package org.eclipse.jgit.internal.diffmergetool;

/* INFO: loaded from: classes5.dex */
public interface ExternalDiffTool {
    String getCommand();

    String getName();

    String getPath();

    boolean isAvailable();
}
