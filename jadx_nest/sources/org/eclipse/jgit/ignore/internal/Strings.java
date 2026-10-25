package org.eclipse.jgit.ignore.internal;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.apache.commons.codec.language.Soundex;
import org.apache.commons.io.FilenameUtils;
import org.eclipse.jgit.errors.InvalidPatternException;
import org.eclipse.jgit.internal.JGitText;

/* JADX INFO: loaded from: classes5.dex */
public class Strings {
    private static final String DL = "\\p{javaDigit}\\p{javaLetter}";
    static final List<String> POSIX_CHAR_CLASSES = Arrays.asList("alnum", "alpha", "blank", "cntrl", "digit", "graph", "lower", "print", "punct", "space", "upper", "xdigit", "word");
    static final List<String> JAVA_CHAR_CLASSES = Arrays.asList("\\p{Alnum}", "\\p{javaLetter}", "\\p{Blank}", "\\p{Cntrl}", "\\p{javaDigit}", "[\\p{Graph}\\p{javaDigit}\\p{javaLetter}]", "\\p{Ll}", "[\\p{Print}\\p{javaDigit}\\p{javaLetter}]", "\\p{Punct}", "\\p{Space}", "\\p{Lu}", "\\p{XDigit}", "[\\p{javaDigit}\\p{javaLetter}_]");
    static final Pattern UNSUPPORTED = Pattern.compile("\\[\\[[.=]\\w+[.=]\\]\\]");

    enum PatternState {
        LEADING_ASTERISK_ONLY,
        TRAILING_ASTERISK_ONLY,
        COMPLEX,
        NONE;

        /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
        public static PatternState[] valuesCustom() {
            PatternState[] patternStateArrValuesCustom = values();
            int length = patternStateArrValuesCustom.length;
            PatternState[] patternStateArr = new PatternState[length];
            System.arraycopy(patternStateArrValuesCustom, 0, patternStateArr, 0, length);
            return patternStateArr;
        }
    }

    private static boolean escapedByBackslash(char c) {
        return c == '?' || c == '*' || c == '[';
    }

    static char getPathSeparator(Character ch) {
        if (ch == null) {
            return '/';
        }
        return ch.charValue();
    }

    public static String stripTrailing(String str, char c) {
        int length = str.length() - 1;
        while (length >= 0) {
            if (str.charAt(length) != c) {
                return length == str.length() + (-1) ? str : str.substring(0, length + 1);
            }
            length--;
        }
        return "";
    }

    public static String stripTrailingWhitespace(String str) {
        int length = str.length() - 1;
        while (length >= 0) {
            if (!Character.isWhitespace(str.charAt(length))) {
                return length == str.length() + (-1) ? str : str.substring(0, length + 1);
            }
            length--;
        }
        return "";
    }

    public static boolean isDirectoryPattern(String str) {
        for (int length = str.length() - 1; length >= 0; length--) {
            char cCharAt = str.charAt(length);
            if (!Character.isWhitespace(cCharAt)) {
                return cCharAt == '/';
            }
        }
        return false;
    }

    static int count(String str, char c, boolean z) {
        int length = str.length();
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int iIndexOf = str.indexOf(c, i);
            if (iIndexOf == -1) {
                break;
            }
            if (!z || (iIndexOf != 0 && iIndexOf != length - 1)) {
                i2++;
            }
            i = iIndexOf + 1;
        }
        return i2;
    }

    public static List<String> split(String str, char c) {
        int iCount = count(str, c, true);
        if (iCount < 1) {
            throw new IllegalStateException("Pattern must have at least two segments: " + str);
        }
        ArrayList arrayList = new ArrayList(iCount);
        int i = 0;
        while (true) {
            int iIndexOf = str.indexOf(c, i);
            if (iIndexOf == -1) {
                break;
            }
            if (iIndexOf - i > 0) {
                if (i == 1) {
                    arrayList.add(str.substring(i - 1, iIndexOf));
                } else if (iIndexOf == str.length() - 1) {
                    arrayList.add(str.substring(i, iIndexOf + 1));
                } else {
                    arrayList.add(str.substring(i, iIndexOf));
                }
            }
            i = iIndexOf + 1;
        }
        if (i < str.length()) {
            arrayList.add(str.substring(i));
        }
        return arrayList;
    }

    static boolean isWildCard(String str) {
        return str.indexOf(42) != -1 || isComplexWildcard(str);
    }

    private static boolean isComplexWildcard(String str) {
        int i;
        if (str.indexOf(91) != -1 || str.indexOf(63) != -1) {
            return true;
        }
        int iIndexOf = str.indexOf(92);
        return iIndexOf >= 0 && str.length() != (i = iIndexOf + 1) && escapedByBackslash(str.charAt(i));
    }

    static PatternState checkWildCards(String str) {
        if (isComplexWildcard(str)) {
            return PatternState.COMPLEX;
        }
        int iIndexOf = str.indexOf(42);
        if (iIndexOf < 0) {
            return PatternState.NONE;
        }
        if (iIndexOf == str.length() - 1) {
            return PatternState.TRAILING_ASTERISK_ONLY;
        }
        if (str.lastIndexOf(42) == 0) {
            return PatternState.LEADING_ASTERISK_ONLY;
        }
        return PatternState.COMPLEX;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:100:0x016d A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:103:0x0178  */
    /* JADX WARN: Code duplicated, block: B:99:0x016b  */
    static Pattern convertGlob(String str) throws InvalidPatternException {
        if (UNSUPPORTED.matcher(str).find()) {
            throw new InvalidPatternException("Collating symbols [[.a.]] or equivalence class expressions [[=a=]] are not supported", str);
        }
        StringBuilder sb = new StringBuilder(str.length());
        char[] cArr = new char[6];
        int i = 0;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        for (int i2 = 0; i2 < str.length(); i2++) {
            char cCharAt = str.charAt(i2);
            if (cCharAt != '!') {
                if (cCharAt == '$') {
                    if (!z || i > 0) {
                        sb.append(cCharAt);
                    } else {
                        sb.append('\\').append(cCharAt);
                    }
                } else if (cCharAt == ':') {
                    if (i > 0 && lookBehind(sb) == '[' && Character.isLetter(lookAhead(str, i2))) {
                        z2 = true;
                    }
                    sb.append(AbstractJsonLexerKt.COLON);
                } else if (cCharAt != '?') {
                    if (cCharAt != '-') {
                        if (cCharAt != '.') {
                            switch (cCharAt) {
                                case '(':
                                case ')':
                                case '+':
                                    if (!z) {
                                        sb.append(cCharAt);
                                    } else {
                                        sb.append(cCharAt);
                                    }
                                    break;
                                case '*':
                                    if (z || i > 0) {
                                        sb.append(cCharAt);
                                    } else {
                                        sb.append(FilenameUtils.EXTENSION_SEPARATOR).append(cCharAt);
                                    }
                                    break;
                                default:
                                    switch (cCharAt) {
                                        case '[':
                                            if (i > 0) {
                                                if (!z) {
                                                    sb.append('\\');
                                                }
                                                sb.append(AbstractJsonLexerKt.BEGIN_LIST);
                                                z3 = true;
                                            } else {
                                                if (!z) {
                                                    i++;
                                                    z3 = false;
                                                }
                                                sb.append(AbstractJsonLexerKt.BEGIN_LIST);
                                            }
                                            break;
                                        case '\\':
                                            if (i > 0) {
                                                char cLookAhead = lookAhead(str, i2);
                                                if (cLookAhead == ']' || cLookAhead == '[') {
                                                    z3 = true;
                                                }
                                            } else {
                                                char cLookAhead2 = lookAhead(str, i2);
                                                if (cLookAhead2 == '\\' || cLookAhead2 == '[' || cLookAhead2 == '?' || cLookAhead2 == '*' || cLookAhead2 == ' ' || lookBehind(sb) == '\\') {
                                                }
                                            }
                                            sb.append(cCharAt);
                                            break;
                                        case ']':
                                            if (z) {
                                                sb.append(AbstractJsonLexerKt.END_LIST);
                                            } else if (i <= 0) {
                                                sb.append('\\').append(AbstractJsonLexerKt.END_LIST);
                                            } else {
                                                char cLookBehind = lookBehind(sb);
                                                if ((cLookBehind != '[' || z3) && cLookBehind != '^') {
                                                    if (!z2) {
                                                        i--;
                                                        sb.append(AbstractJsonLexerKt.END_LIST);
                                                    } else {
                                                        String strCheckPosixCharClass = checkPosixCharClass(cArr);
                                                        if (strCheckPosixCharClass != null) {
                                                            sb.setLength(sb.length() - 4);
                                                            sb.append(strCheckPosixCharClass);
                                                        }
                                                        reset(cArr);
                                                        z2 = false;
                                                    }
                                                    z3 = false;
                                                } else {
                                                    sb.append('\\');
                                                    sb.append(AbstractJsonLexerKt.END_LIST);
                                                }
                                            }
                                            z3 = true;
                                            break;
                                        default:
                                            switch (cCharAt) {
                                                case '{':
                                                case '|':
                                                case '}':
                                                    break;
                                                default:
                                                    if (z2) {
                                                        setNext(cArr, cCharAt);
                                                    } else {
                                                        sb.append(cCharAt);
                                                    }
                                                    break;
                                            }
                                        case '^':
                                            if (!z) {
                                                sb.append(cCharAt);
                                            } else {
                                                sb.append(cCharAt);
                                            }
                                            break;
                                    }
                                    break;
                            }
                        } else if (z) {
                            sb.append(cCharAt);
                        } else {
                            sb.append('\\').append(FilenameUtils.EXTENSION_SEPARATOR);
                        }
                    } else if (i > 0) {
                        if (lookAhead(str, i2) == ']') {
                            sb.append('\\').append(cCharAt);
                        } else {
                            sb.append(cCharAt);
                        }
                    } else {
                        sb.append(Soundex.SILENT_MARKER);
                    }
                } else if (z || i > 0) {
                    sb.append(cCharAt);
                } else {
                    sb.append(FilenameUtils.EXTENSION_SEPARATOR);
                }
            } else if (i > 0 && lookBehind(sb) == '[') {
                sb.append('^');
            } else {
                sb.append(cCharAt);
            }
            z = cCharAt == '\\';
        }
        if (i > 0) {
            throw new InvalidPatternException("Not closed bracket?", str);
        }
        try {
            return Pattern.compile(sb.toString(), 32);
        } catch (PatternSyntaxException e) {
            throw new InvalidPatternException(MessageFormat.format(JGitText.get().invalidIgnoreRule, str), str, e);
        }
    }

    private static char lookBehind(StringBuilder sb) {
        if (sb.length() > 0) {
            return sb.charAt(sb.length() - 1);
        }
        return (char) 0;
    }

    private static char lookAhead(String str, int i) {
        int i2 = i + 1;
        if (i2 >= str.length()) {
            return (char) 0;
        }
        return str.charAt(i2);
    }

    private static void setNext(char[] cArr, char c) {
        for (int i = 0; i < cArr.length; i++) {
            if (cArr[i] == 0) {
                cArr[i] = c;
                return;
            }
        }
    }

    private static void reset(char[] cArr) {
        for (int i = 0; i < cArr.length; i++) {
            cArr[i] = 0;
        }
    }

    private static String checkPosixCharClass(char[] cArr) {
        int i = 0;
        while (true) {
            List<String> list = POSIX_CHAR_CLASSES;
            if (i >= list.size()) {
                return null;
            }
            String str = list.get(i);
            for (int i2 = 0; i2 < str.length(); i2++) {
                if (cArr[i2] != str.charAt(i2)) {
                    i++;
                }
            }
            return JAVA_CHAR_CLASSES.get(i);
        }
    }

    /* JADX WARN: Code duplicated, block: B:21:0x003f  */
    static String deleteBackslash(String str) {
        if (str.indexOf(92) < 0) {
            return str;
        }
        StringBuilder sb = new StringBuilder(str.length());
        int i = 0;
        while (i < str.length()) {
            char cCharAt = str.charAt(i);
            if (cCharAt == '\\') {
                int i2 = i + 1;
                if (i2 != str.length()) {
                    char cCharAt2 = str.charAt(i2);
                    if (cCharAt2 == '\\') {
                        sb.append(cCharAt);
                        i = i2;
                    } else if (escapedByBackslash(cCharAt2)) {
                        sb.append(cCharAt);
                    }
                }
            } else {
                sb.append(cCharAt);
            }
            i++;
        }
        return sb.toString();
    }
}
