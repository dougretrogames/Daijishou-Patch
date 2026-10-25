package org.eclipse.jgit.transport;

import java.text.MessageFormat;
import org.eclipse.jgit.internal.JGitText;

/* JADX INFO: loaded from: classes5.dex */
public enum TagOpt {
    AUTO_FOLLOW(""),
    NO_TAGS("--no-tags"),
    FETCH_TAGS("--tags");

    private final String option;

    /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
    public static TagOpt[] valuesCustom() {
        TagOpt[] tagOptArrValuesCustom = values();
        int length = tagOptArrValuesCustom.length;
        TagOpt[] tagOptArr = new TagOpt[length];
        System.arraycopy(tagOptArrValuesCustom, 0, tagOptArr, 0, length);
        return tagOptArr;
    }

    TagOpt(String str) {
        this.option = str;
    }

    public String option() {
        return this.option;
    }

    public static TagOpt fromOption(String str) {
        if (str == null || str.length() == 0) {
            return AUTO_FOLLOW;
        }
        for (TagOpt tagOpt : valuesCustom()) {
            if (tagOpt.option().equals(str)) {
                return tagOpt;
            }
        }
        throw new IllegalArgumentException(MessageFormat.format(JGitText.get().invalidTagOption, str));
    }
}
