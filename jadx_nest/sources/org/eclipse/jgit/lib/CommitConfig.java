package org.eclipse.jgit.lib;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.IllegalCharsetNameException;
import java.nio.charset.StandardCharsets;
import java.nio.charset.UnsupportedCharsetException;
import java.text.MessageFormat;
import java.util.Locale;
import kotlin.text.Typography;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.eclipse.jgit.annotations.Nullable;
import org.eclipse.jgit.errors.ConfigInvalidException;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.util.FS;
import org.eclipse.jgit.util.IO;
import org.eclipse.jgit.util.RawParseUtils;
import org.eclipse.jgit.util.StringUtils;

/* JADX INFO: loaded from: classes5.dex */
public class CommitConfig {
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$org$eclipse$jgit$lib$CommitConfig$CleanupMode = null;
    private static final String CUT = " ------------------------ >8 ------------------------\n";
    private boolean autoCommentChar;
    private CleanupMode cleanupMode;
    private char commentCharacter;
    private String commitTemplatePath;
    private String i18nCommitEncoding;
    public static final Config.SectionParser<CommitConfig> KEY = new CommitConfig$$ExternalSyntheticLambda1();
    private static final char[] COMMENT_CHARS = {'#', ';', '@', '!', Typography.dollar, '%', '^', Typography.amp, '|', AbstractJsonLexerKt.COLON};
    private static final Charset DEFAULT_COMMIT_MESSAGE_ENCODING = StandardCharsets.UTF_8;

    /* JADX INFO: renamed from: $r8$lambda$i_uB7aSCdnGaHiqavg-VFoecJCM, reason: not valid java name */
    public static /* synthetic */ CommitConfig m5770$r8$lambda$i_uB7aSCdnGaHiqavgVFoecJCM(Config config) {
        return new CommitConfig(config);
    }

    static /* synthetic */ int[] $SWITCH_TABLE$org$eclipse$jgit$lib$CommitConfig$CleanupMode() {
        int[] iArr = $SWITCH_TABLE$org$eclipse$jgit$lib$CommitConfig$CleanupMode;
        if (iArr != null) {
            return iArr;
        }
        int[] iArr2 = new int[CleanupMode.valuesCustom().length];
        try {
            iArr2[CleanupMode.DEFAULT.ordinal()] = 5;
        } catch (NoSuchFieldError unused) {
        }
        try {
            iArr2[CleanupMode.SCISSORS.ordinal()] = 4;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            iArr2[CleanupMode.STRIP.ordinal()] = 1;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            iArr2[CleanupMode.VERBATIM.ordinal()] = 3;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            iArr2[CleanupMode.WHITESPACE.ordinal()] = 2;
        } catch (NoSuchFieldError unused5) {
        }
        $SWITCH_TABLE$org$eclipse$jgit$lib$CommitConfig$CleanupMode = iArr2;
        return iArr2;
    }

    public enum CleanupMode implements Config.ConfigEnum {
        STRIP,
        WHITESPACE,
        VERBATIM,
        SCISSORS,
        DEFAULT;

        /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
        public static CleanupMode[] valuesCustom() {
            CleanupMode[] cleanupModeArrValuesCustom = values();
            int length = cleanupModeArrValuesCustom.length;
            CleanupMode[] cleanupModeArr = new CleanupMode[length];
            System.arraycopy(cleanupModeArrValuesCustom, 0, cleanupModeArr, 0, length);
            return cleanupModeArr;
        }

        @Override // org.eclipse.jgit.lib.Config.ConfigEnum
        public String toConfigValue() {
            return name().toLowerCase(Locale.ROOT);
        }

        @Override // org.eclipse.jgit.lib.Config.ConfigEnum
        public boolean matchConfigValue(String str) {
            return toConfigValue().equals(str);
        }
    }

    private CommitConfig(Config config) {
        this.commentCharacter = '#';
        this.autoCommentChar = false;
        this.commitTemplatePath = config.getString("commit", null, ConfigConstants.CONFIG_KEY_COMMIT_TEMPLATE);
        this.i18nCommitEncoding = config.getString(ConfigConstants.CONFIG_SECTION_I18N, null, ConfigConstants.CONFIG_KEY_COMMIT_ENCODING);
        this.cleanupMode = (CleanupMode) config.getEnum("commit", null, ConfigConstants.CONFIG_KEY_CLEANUP, CleanupMode.DEFAULT);
        String string = config.getString(ConfigConstants.CONFIG_CORE_SECTION, null, ConfigConstants.CONFIG_KEY_COMMENT_CHAR);
        if (StringUtils.isEmptyOrNull(string)) {
            return;
        }
        if ("auto".equalsIgnoreCase(string)) {
            this.autoCommentChar = true;
            return;
        }
        char cCharAt = string.charAt(0);
        if (cCharAt <= ' ' || cCharAt >= 127) {
            return;
        }
        this.commentCharacter = cCharAt;
    }

    @Nullable
    public String getCommitTemplatePath() {
        return this.commitTemplatePath;
    }

    @Nullable
    public String getCommitEncoding() {
        return this.i18nCommitEncoding;
    }

    public char getCommentChar() {
        return this.commentCharacter;
    }

    public char getCommentChar(String str) {
        if (isAutoCommentChar()) {
            char cDetermineCommentChar = determineCommentChar(str);
            if (cDetermineCommentChar > 0) {
                return cDetermineCommentChar;
            }
            return '#';
        }
        return getCommentChar();
    }

    public boolean isAutoCommentChar() {
        return this.autoCommentChar;
    }

    public CleanupMode getCleanupMode() {
        return this.cleanupMode;
    }

    public CleanupMode resolve(CleanupMode cleanupMode, boolean z) {
        if (CleanupMode.DEFAULT != cleanupMode) {
            return cleanupMode;
        }
        CleanupMode cleanupMode2 = getCleanupMode();
        if (CleanupMode.DEFAULT != cleanupMode2) {
            return cleanupMode2;
        }
        if (z) {
            return CleanupMode.STRIP;
        }
        return CleanupMode.WHITESPACE;
    }

    @Nullable
    public String getCommitTemplateContent(Repository repository) throws ConfigInvalidException, IOException {
        File fileResolve;
        if (this.commitTemplatePath == null) {
            return null;
        }
        FS fs = repository.getFS();
        if (this.commitTemplatePath.startsWith("~/")) {
            fileResolve = fs.resolve(fs.userHome(), this.commitTemplatePath.substring(2));
        } else {
            fileResolve = fs.resolve(null, this.commitTemplatePath);
        }
        if (!fileResolve.isAbsolute()) {
            fileResolve = fs.resolve(repository.getWorkTree().getAbsoluteFile(), this.commitTemplatePath);
        }
        return RawParseUtils.decode(getEncoding(), IO.readFully(fileResolve));
    }

    private Charset getEncoding() throws ConfigInvalidException {
        String str = this.i18nCommitEncoding;
        if (str == null) {
            return null;
        }
        try {
            return Charset.forName(str);
        } catch (IllegalCharsetNameException | UnsupportedCharsetException e) {
            throw new ConfigInvalidException(MessageFormat.format(JGitText.get().invalidEncoding, this.i18nCommitEncoding), e);
        }
    }

    public static String cleanText(String str, CleanupMode cleanupMode, char c) {
        boolean z;
        int i = $SWITCH_TABLE$org$eclipse$jgit$lib$CommitConfig$CleanupMode()[cleanupMode.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i == 3) {
                    return str;
                }
                if (i == 4) {
                    String str2 = c + CUT;
                    if (str.startsWith(str2)) {
                        return "";
                    }
                    int iIndexOf = str.indexOf("\n" + str2);
                    if (iIndexOf >= 0) {
                        str = str.substring(0, iIndexOf + 1);
                    }
                } else {
                    throw new IllegalArgumentException("Invalid clean-up mode " + String.valueOf(cleanupMode));
                }
            }
            z = false;
        } else {
            z = true;
        }
        StringBuilder sb = new StringBuilder();
        boolean z2 = true;
        for (String str3 : str.split("\n")) {
            String strM$1 = CommitConfig$$ExternalSyntheticBackport0.m$1(str3);
            if (strM$1.isEmpty()) {
                if (!z2) {
                    sb.append('\n');
                    z2 = true;
                }
            } else if (!z || !isComment(strM$1, c)) {
                sb.append(strM$1).append('\n');
                z2 = false;
            }
        }
        int length = sb.length();
        if (z2 && length > 0) {
            length--;
            sb.setLength(length);
        }
        if (length > 0 && !str.endsWith("\n")) {
            int i2 = length - 1;
            if (sb.charAt(i2) == '\n') {
                sb.setLength(i2);
            }
        }
        return sb.toString();
    }

    private static boolean isComment(String str, char c) {
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            if (!Character.isWhitespace(cCharAt)) {
                return cCharAt == c;
            }
        }
        return false;
    }

    public static char determineCommentChar(String str) {
        if (StringUtils.isEmptyOrNull(str)) {
            return '#';
        }
        boolean[] zArr = new boolean[127];
        for (String str2 : str.split("\n")) {
            int length = str2.length();
            for (int i = 0; i < length; i++) {
                char cCharAt = str2.charAt(i);
                if (!Character.isWhitespace(cCharAt)) {
                    if (cCharAt >= 127) {
                        break;
                    }
                    zArr[cCharAt] = true;
                    break;
                }
            }
        }
        for (char c : COMMENT_CHARS) {
            if (!zArr[c]) {
                return c;
            }
        }
        return (char) 0;
    }
}
