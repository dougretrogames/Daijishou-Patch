package org.eclipse.jgit.ignore;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import net.lingala.zip4j.util.InternalZipConstants;
import org.eclipse.jgit.annotations.Nullable;
import org.eclipse.jgit.errors.InvalidPatternException;
import org.eclipse.jgit.internal.JGitText;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* INFO: loaded from: classes5.dex */
public class IgnoreNode {
    private static final Logger LOG = LoggerFactory.getLogger((Class<?>) IgnoreNode.class);
    private final List<FastIgnoreRule> rules;

    public enum MatchResult {
        NOT_IGNORED,
        IGNORED,
        CHECK_PARENT,
        CHECK_PARENT_NEGATE_FIRST_MATCH;

        /* INFO: renamed from: values, reason: to resolve conflict with enum method */
        public static MatchResult[] valuesCustom() {
            MatchResult[] matchResultArrValuesCustom = values();
            int length = matchResultArrValuesCustom.length;
            MatchResult[] matchResultArr = new MatchResult[length];
            System.arraycopy(matchResultArrValuesCustom, 0, matchResultArr, 0, length);
            return matchResultArr;
        }
    }

    public IgnoreNode() {
        this(new ArrayList());
    }

    public IgnoreNode(List<FastIgnoreRule> list) {
        this.rules = list;
    }

    public void parse(InputStream inputStream) throws IOException {
        parse(null, inputStream);
    }

    public void parse(String str, InputStream inputStream) throws IOException {
        BufferedReader bufferedReaderAsReader = asReader(inputStream);
        int i = 1;
        while (true) {
            String line = bufferedReaderAsReader.readLine();
            if (line == null) {
                return;
            }
            if (line.length() > 0 && !line.startsWith("#") && !line.equals(InternalZipConstants.ZIP_FILE_SEPARATOR)) {
                FastIgnoreRule fastIgnoreRule = new FastIgnoreRule();
                try {
                    fastIgnoreRule.parse(line);
                } catch (InvalidPatternException e) {
                    if (str != null) {
                        LOG.error(MessageFormat.format(JGitText.get().badIgnorePatternFull, str, Integer.toString(i), e.getPattern(), e.getLocalizedMessage()), (Throwable) e);
                    } else {
                        LOG.error(MessageFormat.format(JGitText.get().badIgnorePattern, e.getPattern()), (Throwable) e);
                    }
                }
                if (!fastIgnoreRule.isEmpty()) {
                    this.rules.add(fastIgnoreRule);
                }
            }
            i++;
        }
    }

    private static BufferedReader asReader(InputStream inputStream) {
        return new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
    }

    public List<FastIgnoreRule> getRules() {
        return Collections.unmodifiableList(this.rules);
    }

    public MatchResult isIgnored(String str, boolean z) {
        Boolean boolCheckIgnored = checkIgnored(str, z);
        if (boolCheckIgnored == null) {
            return MatchResult.CHECK_PARENT;
        }
        return boolCheckIgnored.booleanValue() ? MatchResult.IGNORED : MatchResult.NOT_IGNORED;
    }

    @Nullable
    public Boolean checkIgnored(String str, boolean z) {
        for (int size = this.rules.size() - 1; size > -1; size--) {
            FastIgnoreRule fastIgnoreRule = this.rules.get(size);
            if (fastIgnoreRule.isMatch(str, z, true)) {
                return Boolean.valueOf(fastIgnoreRule.getResult());
            }
        }
        return null;
    }

    public String toString() {
        return this.rules.toString();
    }
}
