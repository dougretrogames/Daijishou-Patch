package com.google.auth.oauth2;

import com.google.api.client.json.GenericJson;
import com.google.common.base.Splitter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes3.dex */
final class PluggableAuthHandler implements ExecutableHandler {
    private static final int EXECUTABLE_SUPPORTED_MAX_VERSION = 1;
    private static final int EXIT_CODE_SUCCESS = 0;
    private static final String GOOGLE_EXTERNAL_ACCOUNT_ALLOW_EXECUTABLES = "GOOGLE_EXTERNAL_ACCOUNT_ALLOW_EXECUTABLES";
    private final EnvironmentProvider environmentProvider;
    private InternalProcessBuilder internalProcessBuilder;

    PluggableAuthHandler(EnvironmentProvider environmentProvider) {
        this.environmentProvider = environmentProvider;
    }

    PluggableAuthHandler(EnvironmentProvider environmentProvider, InternalProcessBuilder internalProcessBuilder) {
        this.environmentProvider = environmentProvider;
        this.internalProcessBuilder = internalProcessBuilder;
    }

    @Override // com.google.auth.oauth2.ExecutableHandler
    public String retrieveTokenFromExecutable(ExecutableHandler.ExecutableOptions executableOptions) throws IOException {
        if (!"1".equals(this.environmentProvider.getEnv(GOOGLE_EXTERNAL_ACCOUNT_ALLOW_EXECUTABLES))) {
            throw new PluggableAuthException("PLUGGABLE_AUTH_DISABLED", "Pluggable Auth executables need to be explicitly allowed to run by setting the GOOGLE_EXTERNAL_ACCOUNT_ALLOW_EXECUTABLES environment variable to 1.");
        }
        ExecutableResponse cachedExecutableResponse = getCachedExecutableResponse(executableOptions);
        if (cachedExecutableResponse == null) {
            cachedExecutableResponse = getExecutableResponse(executableOptions);
        }
        if (executableOptions.getOutputFilePath() != null && !executableOptions.getOutputFilePath().isEmpty() && cachedExecutableResponse.isSuccessful() && cachedExecutableResponse.getExpirationTime() == null) {
            throw new PluggableAuthException("INVALID_EXECUTABLE_RESPONSE", "The executable response must contain the `expiration_time` field for successful responses when an output_file has been specified in the configuration.");
        }
        if (cachedExecutableResponse.getVersion() > 1) {
            throw new PluggableAuthException("UNSUPPORTED_VERSION", "The version of the executable response is not supported. " + String.format("The maximum version currently supported is %s.", 1));
        }
        if (!cachedExecutableResponse.isSuccessful()) {
            throw new PluggableAuthException(cachedExecutableResponse.getErrorCode(), cachedExecutableResponse.getErrorMessage());
        }
        if (cachedExecutableResponse.isExpired()) {
            throw new PluggableAuthException("INVALID_RESPONSE", "The executable response is expired.");
        }
        return cachedExecutableResponse.getSubjectToken();
    }

    @Nullable
    ExecutableResponse getCachedExecutableResponse(ExecutableHandler.ExecutableOptions executableOptions) throws PluggableAuthException {
        if (executableOptions.getOutputFilePath() == null || executableOptions.getOutputFilePath().isEmpty()) {
            return null;
        }
        try {
            File file = new File(executableOptions.getOutputFilePath());
            if (!file.isFile() || file.length() <= 0) {
                return null;
            }
            ExecutableResponse executableResponse = new ExecutableResponse((GenericJson) OAuth2Utils.JSON_FACTORY.createJsonParser(new BufferedReader(new InputStreamReader(new FileInputStream(executableOptions.getOutputFilePath()), StandardCharsets.UTF_8))).parseAndClose(GenericJson.class));
            if (executableResponse.isValid()) {
                return executableResponse;
            }
            return null;
        } catch (Exception e) {
            throw new PluggableAuthException("INVALID_OUTPUT_FILE", "The output_file specified contains an invalid or malformed response." + e);
        }
    }

    ExecutableResponse getExecutableResponse(ExecutableHandler.ExecutableOptions executableOptions) throws IOException {
        IOException e;
        String str;
        InternalProcessBuilder processBuilder = getProcessBuilder(Splitter.on(" ").splitToList(executableOptions.getExecutableCommand()));
        processBuilder.environment().putAll(executableOptions.getEnvironmentMap());
        processBuilder.redirectErrorStream(true);
        Process processStart = processBuilder.start();
        ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor();
        try {
            try {
                Future futureSubmit = executorServiceNewSingleThreadExecutor.submit(new PluggableAuthHandler$$ExternalSyntheticLambda0(processStart));
                if (!processStart.waitFor(executableOptions.getExecutableTimeoutMs(), TimeUnit.MILLISECONDS)) {
                    throw new PluggableAuthException("TIMEOUT_EXCEEDED", "The executable failed to finish within the timeout specified.");
                }
                int iExitValue = processStart.exitValue();
                if (iExitValue != 0) {
                    throw new PluggableAuthException("EXIT_CODE", String.format("The executable failed with exit code %s.", Integer.valueOf(iExitValue)));
                }
                str = (String) futureSubmit.get();
                try {
                    executorServiceNewSingleThreadExecutor.shutdownNow();
                    ExecutableResponse executableResponse = new ExecutableResponse((GenericJson) OAuth2Utils.JSON_FACTORY.createJsonParser(str).parseAndClose(GenericJson.class));
                    processStart.destroy();
                    return executableResponse;
                } catch (IOException e2) {
                    e = e2;
                    processStart.destroy();
                    if (!executorServiceNewSingleThreadExecutor.isShutdown()) {
                        executorServiceNewSingleThreadExecutor.shutdownNow();
                    }
                    if (e instanceof PluggableAuthException) {
                        throw e;
                    }
                    throw new PluggableAuthException("INVALID_RESPONSE", String.format("The executable returned an invalid response: %s.", str));
                }
            } catch (IOException e3) {
                e = e3;
                str = "";
            }
        } catch (InterruptedException | ExecutionException e4) {
            processStart.destroy();
            throw new PluggableAuthException("INTERRUPTED", String.format("The execution was interrupted: %s.", e4));
        }
    }

    static /* synthetic */ String lambda$getExecutableResponse$0(Process process) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream(), StandardCharsets.UTF_8));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String line = bufferedReader.readLine();
            if (line != null) {
                sb.append(line).append(System.lineSeparator());
            } else {
                return sb.toString().trim();
            }
        }
    }

    InternalProcessBuilder getProcessBuilder(List<String> list) {
        InternalProcessBuilder internalProcessBuilder = this.internalProcessBuilder;
        return internalProcessBuilder != null ? internalProcessBuilder : new DefaultProcessBuilder(new ProcessBuilder(list));
    }

    static abstract class InternalProcessBuilder {
        abstract Map<String, String> environment();

        abstract InternalProcessBuilder redirectErrorStream(boolean z);

        abstract Process start() throws IOException;

        InternalProcessBuilder() {
        }
    }

    static final class DefaultProcessBuilder extends InternalProcessBuilder {
        ProcessBuilder processBuilder;

        DefaultProcessBuilder(ProcessBuilder processBuilder) {
            this.processBuilder = processBuilder;
        }

        @Override // com.google.auth.oauth2.PluggableAuthHandler.InternalProcessBuilder
        Map<String, String> environment() {
            return this.processBuilder.environment();
        }

        @Override // com.google.auth.oauth2.PluggableAuthHandler.InternalProcessBuilder
        InternalProcessBuilder redirectErrorStream(boolean z) {
            this.processBuilder.redirectErrorStream(z);
            return this;
        }

        @Override // com.google.auth.oauth2.PluggableAuthHandler.InternalProcessBuilder
        Process start() throws IOException {
            return this.processBuilder.start();
        }
    }
}
