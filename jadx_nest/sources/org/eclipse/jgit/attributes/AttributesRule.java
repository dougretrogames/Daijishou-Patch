package org.eclipse.jgit.attributes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import net.lingala.zip4j.util.InternalZipConstants;
import org.eclipse.jgit.errors.InvalidPatternException;
import org.eclipse.jgit.ignore.IMatcher;
import org.eclipse.jgit.ignore.internal.PathMatcher;

/* INFO: loaded from: classes5.dex */
public class AttributesRule {
    private static final String ATTRIBUTES_SPLIT_REGEX = "[ \t\r]";
    private final List<Attribute> attributes;
    private final boolean dirOnly;
    private final IMatcher matcher;
    private final boolean nameOnly;
    private final String pattern;

    private static List<Attribute> parseAttributes(String str) {
        ArrayList arrayList = new ArrayList();
        for (String str2 : str.split(ATTRIBUTES_SPLIT_REGEX)) {
            String strTrim = str2.trim();
            if (strTrim.length() != 0) {
                if (strTrim.startsWith("-")) {
                    if (strTrim.length() > 1) {
                        arrayList.add(new Attribute(strTrim.substring(1), Attribute.State.UNSET));
                    }
                } else if (strTrim.startsWith("!")) {
                    if (strTrim.length() > 1) {
                        arrayList.add(new Attribute(strTrim.substring(1), Attribute.State.UNSPECIFIED));
                    }
                } else {
                    int iIndexOf = strTrim.indexOf(61);
                    if (iIndexOf == -1) {
                        arrayList.add(new Attribute(strTrim, Attribute.State.SET));
                    } else {
                        String strSubstring = strTrim.substring(0, iIndexOf);
                        if (strSubstring.length() > 0) {
                            arrayList.add(new Attribute(strSubstring, strTrim.substring(iIndexOf + 1)));
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    public AttributesRule(String str, String str2) {
        this.attributes = parseAttributes(str2);
        if (str.endsWith(InternalZipConstants.ZIP_FILE_SEPARATOR)) {
            str = str.substring(0, str.length() - 1);
            this.dirOnly = true;
        } else {
            this.dirOnly = false;
        }
        int iIndexOf = str.indexOf(47);
        if (iIndexOf < 0) {
            this.nameOnly = true;
        } else if (iIndexOf == 0) {
            this.nameOnly = false;
        } else {
            this.nameOnly = false;
            str = InternalZipConstants.ZIP_FILE_SEPARATOR + str;
        }
        IMatcher iMatcherCreatePathMatcher = IMatcher.NO_MATCH;
        try {
            iMatcherCreatePathMatcher = PathMatcher.createPathMatcher(str, '/', this.dirOnly);
        } catch (InvalidPatternException unused) {
        }
        this.matcher = iMatcherCreatePathMatcher;
        this.pattern = str;
    }

    public boolean isDirOnly() {
        return this.dirOnly;
    }

    public List<Attribute> getAttributes() {
        return Collections.unmodifiableList(this.attributes);
    }

    public boolean isNameOnly() {
        return this.nameOnly;
    }

    public String getPattern() {
        return this.pattern;
    }

    public boolean isMatch(String str, boolean z) {
        if (str == null || str.length() == 0) {
            return false;
        }
        return this.matcher.matches(str, z, true);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.pattern);
        for (Attribute attribute : this.attributes) {
            sb.append(" ");
            sb.append(attribute);
        }
        return sb.toString();
    }
}
