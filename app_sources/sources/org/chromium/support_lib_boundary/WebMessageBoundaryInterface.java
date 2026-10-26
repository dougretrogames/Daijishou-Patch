package org.chromium.support_lib_boundary;

import java.lang.reflect.InvocationHandler;
import org.jspecify.annotations.NullMarked;

/* INFO: loaded from: classes5.dex */
@NullMarked
public interface WebMessageBoundaryInterface extends FeatureFlagHolderBoundaryInterface {
    @Deprecated
    String getData();

    InvocationHandler getMessagePayload();

    InvocationHandler[] getPorts();
}
