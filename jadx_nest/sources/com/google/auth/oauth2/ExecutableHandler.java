package com.google.auth.oauth2;

import java.io.IOException;
import java.util.Map;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes3.dex */
interface ExecutableHandler {

    public interface ExecutableOptions {
        Map<String, String> getEnvironmentMap();

        String getExecutableCommand();

        int getExecutableTimeoutMs();

        @Nullable
        String getOutputFilePath();
    }

    String retrieveTokenFromExecutable(ExecutableOptions executableOptions) throws IOException;
}
