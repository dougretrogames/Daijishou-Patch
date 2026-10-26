package org.chromium.support_lib_boundary;

import java.util.concurrent.Executor;
import org.jspecify.annotations.NullMarked;

/* INFO: loaded from: classes5.dex */
@NullMarked
public interface WebViewStartUpConfigBoundaryInterface {
    Executor getBackgroundExecutor();

    boolean shouldRunUiThreadStartUpTasks();
}
