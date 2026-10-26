package org.eclipse.jgit.internal.submodule;

import java.text.MessageFormat;
import org.eclipse.jgit.errors.ConfigInvalidException;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.lib.Config;
import org.eclipse.jgit.lib.ConfigConstants;
import org.eclipse.jgit.lib.ObjectChecker;

/* INFO: loaded from: classes5.dex */
public class SubmoduleValidator {

    public static class SubmoduleValidationException extends Exception {
        private static final long serialVersionUID = 1;
        private final ObjectChecker.ErrorType fsckMessageId;

        SubmoduleValidationException(String str, ObjectChecker.ErrorType errorType) {
            super(str);
            this.fsckMessageId = errorType;
        }

        public ObjectChecker.ErrorType getFsckMessageId() {
            return this.fsckMessageId;
        }
    }

    public static void assertValidSubmoduleName(String str) throws SubmoduleValidationException {
        if (str.contains("/../") || str.contains("\\..\\") || str.startsWith("../") || str.startsWith("..\\") || str.endsWith("/..") || str.endsWith("\\..")) {
            throw new SubmoduleValidationException(MessageFormat.format(JGitText.get().invalidNameContainsDotDot, str), ObjectChecker.ErrorType.GITMODULES_NAME);
        }
        if (str.startsWith("-")) {
            throw new SubmoduleValidationException(MessageFormat.format(JGitText.get().submoduleNameInvalid, str), ObjectChecker.ErrorType.GITMODULES_NAME);
        }
    }

    public static void assertValidSubmoduleUri(String str) throws SubmoduleValidationException {
        if (str.startsWith("-")) {
            throw new SubmoduleValidationException(MessageFormat.format(JGitText.get().submoduleUrlInvalid, str), ObjectChecker.ErrorType.GITMODULES_URL);
        }
    }

    public static void assertValidSubmodulePath(String str) throws SubmoduleValidationException {
        if (str.startsWith("-")) {
            throw new SubmoduleValidationException(MessageFormat.format(JGitText.get().submodulePathInvalid, str), ObjectChecker.ErrorType.GITMODULES_PATH);
        }
    }

    public static void assertValidGitModulesFile(String str) throws SubmoduleValidationException {
        Config config = new Config();
        try {
            config.fromText(str);
            for (String str2 : config.getSubsections(ConfigConstants.CONFIG_SUBMODULE_SECTION)) {
                assertValidSubmoduleName(str2);
                String string = config.getString(ConfigConstants.CONFIG_SUBMODULE_SECTION, str2, "url");
                if (string != null) {
                    assertValidSubmoduleUri(string);
                }
                String string2 = config.getString(ConfigConstants.CONFIG_SUBMODULE_SECTION, str2, "path");
                if (string2 != null) {
                    assertValidSubmodulePath(string2);
                }
            }
        } catch (ConfigInvalidException e) {
            SubmoduleValidationException submoduleValidationException = new SubmoduleValidationException(JGitText.get().invalidGitModules, ObjectChecker.ErrorType.GITMODULES_PARSE);
            submoduleValidationException.initCause(e);
            throw submoduleValidationException;
        }
    }
}
