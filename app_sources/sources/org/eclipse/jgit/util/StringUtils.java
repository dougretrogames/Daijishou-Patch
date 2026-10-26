package org.eclipse.jgit.util;

import java.text.MessageFormat;
import java.util.Collection;
import java.util.Iterator;
import org.apache.http.message.TokenParser;
import org.eclipse.jgit.annotations.Nullable;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.lib.CommitConfig$$ExternalSyntheticBackport0;
import org.eclipse.jgit.transport.SshConstants;

/* INFO: loaded from: classes5.dex */
public final class StringUtils {
    private static final String EMPTY = "";
    private static final long GiB = 1073741824;
    private static final long KiB = 1024;
    private static final char[] LC = new char[91];
    private static final long MiB = 1048576;

    static {
        char c = 0;
        while (true) {
            char[] cArr = LC;
            if (c >= cArr.length) {
                break;
            }
            cArr[c] = c;
            c = (char) (c + 1);
        }
        for (char c2 = 'A'; c2 <= 'Z'; c2 = (char) (c2 + 1)) {
            LC[c2] = (char) (c2 + TokenParser.SP);
        }
    }

    private StringUtils() {
    }

    public static char toLowerCase(char c) {
        return c <= 'Z' ? LC[c] : c;
    }

    public static String toLowerCase(String str) {
        StringBuilder sb = new StringBuilder(str.length());
        for (int i = 0; i < str.length(); i++) {
            sb.append(toLowerCase(str.charAt(i)));
        }
        return sb.toString();
    }

    public static String capitalize(String str) {
        int length;
        return (str == null || (length = str.length()) == 0) ? str : new StringBuilder(length).append(Character.toTitleCase(str.charAt(0))).append(str.substring(1)).toString();
    }

    public static boolean equalsIgnoreCase(String str, String str2) {
        if (References.isSameObject(str, str2)) {
            return true;
        }
        if (str.length() != str2.length()) {
            return false;
        }
        for (int i = 0; i < str.length(); i++) {
            if (toLowerCase(str.charAt(i)) != toLowerCase(str2.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static int compareIgnoreCase(String str, String str2) {
        for (int i = 0; i < str.length() && i < str2.length(); i++) {
            int lowerCase = toLowerCase(str.charAt(i)) - toLowerCase(str2.charAt(i));
            if (lowerCase != 0) {
                return lowerCase;
            }
        }
        return str.length() - str2.length();
    }

    public static int compareWithCase(String str, String str2) {
        for (int i = 0; i < str.length() && i < str2.length(); i++) {
            int iCharAt = str.charAt(i) - str2.charAt(i);
            if (iCharAt != 0) {
                return iCharAt;
            }
        }
        return str.length() - str2.length();
    }

    public static boolean toBoolean(String str) {
        if (str == null) {
            throw new NullPointerException(JGitText.get().expectedBooleanStringValue);
        }
        Boolean booleanOrNull = toBooleanOrNull(str);
        if (booleanOrNull == null) {
            throw new IllegalArgumentException(MessageFormat.format(JGitText.get().notABoolean, str));
        }
        return booleanOrNull.booleanValue();
    }

    public static Boolean toBooleanOrNull(String str) {
        if (str == null) {
            return null;
        }
        if (equalsIgnoreCase(SshConstants.YES, str) || equalsIgnoreCase("true", str) || equalsIgnoreCase("1", str) || equalsIgnoreCase("on", str)) {
            return Boolean.TRUE;
        }
        if (equalsIgnoreCase(SshConstants.NO, str) || equalsIgnoreCase("false", str) || equalsIgnoreCase("0", str) || equalsIgnoreCase("off", str)) {
            return Boolean.FALSE;
        }
        return null;
    }

    public static String join(Collection<String> collection, String str) {
        return join(collection, str, str);
    }

    public static String join(Collection<String> collection, String str, String str2) {
        StringBuilder sb = new StringBuilder();
        int size = collection.size();
        int i = size - 1;
        Iterator<String> it = collection.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            sb.append(it.next());
            if (i2 == size - 2) {
                sb.append(str2);
            } else if (i2 != i) {
                sb.append(str);
            }
            i2++;
        }
        return sb.toString();
    }

    public static String nameWithDotGit(String str) {
        return str.endsWith(".git") ? str : str + ".git";
    }

    public static boolean isEmptyOrNull(String str) {
        return str == null || str.length() == 0;
    }

    public static String replaceLineBreaksWithSpace(String str) {
        int i;
        int length = str.length();
        char[] cArr = new char[length];
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            char cCharAt = str.charAt(i2);
            if (cCharAt != '\n') {
                if (cCharAt == '\r') {
                    int i4 = i2 + 1;
                    if (i4 < length && str.charAt(i4) == '\n') {
                        cArr[i3] = TokenParser.SP;
                        i3++;
                        i2 = i4;
                    } else {
                        i = i3 + 1;
                        cArr[i3] = TokenParser.SP;
                    }
                } else {
                    cArr[i3] = cCharAt;
                    i3++;
                }
                i2++;
            } else {
                i = i3 + 1;
                cArr[i3] = TokenParser.SP;
            }
            i3 = i;
            i2++;
        }
        return new String(cArr, 0, i3);
    }

    /* WARN: Code duplicated, block: B:17:0x0030  */
    /* WARN: Code duplicated, block: B:18:0x0034  */
    /* WARN: Code duplicated, block: B:19:0x0037  */
    public static long parseLongWithSuffix(String str, boolean z) throws StringIndexOutOfBoundsException, NumberFormatException {
        long j;
        long unsignedLong;
        String strM = CommitConfig$$ExternalSyntheticBackport0.m(str);
        if (strM.isEmpty()) {
            throw new StringIndexOutOfBoundsException();
        }
        char cCharAt = strM.charAt(strM.length() - 1);
        if (cCharAt == 'G') {
            j = 1073741824;
        } else if (cCharAt == 'K') {
            j = 1024;
        } else if (cCharAt == 'M') {
            j = 1048576;
        } else if (cCharAt == 'g') {
            j = 1073741824;
        } else if (cCharAt == 'k') {
            j = 1024;
        } else if (cCharAt != 'm') {
            j = 1;
        } else {
            j = 1048576;
        }
        if (j > 1) {
            strM = strM.substring(0, strM.length() - 1).trim();
        }
        if (strM.isEmpty()) {
            throw new StringIndexOutOfBoundsException();
        }
        if (z) {
            unsignedLong = Long.parseUnsignedLong(strM);
            if (unsignedLong < 0) {
                throw new NumberFormatException(MessageFormat.format(JGitText.get().valueExceedsRange, str, Long.class.getSimpleName()));
            }
        } else {
            unsignedLong = Long.parseLong(strM);
        }
        if (j == 1) {
            return unsignedLong;
        }
        try {
            return Math.multiplyExact(j, unsignedLong);
        } catch (ArithmeticException e) {
            NumberFormatException numberFormatException = new NumberFormatException(e.getLocalizedMessage());
            numberFormatException.initCause(e);
            throw numberFormatException;
        }
    }

    public static int parseIntWithSuffix(String str, boolean z) throws StringIndexOutOfBoundsException, NumberFormatException {
        try {
            return Math.toIntExact(parseLongWithSuffix(str, z));
        } catch (ArithmeticException e) {
            NumberFormatException numberFormatException = new NumberFormatException(MessageFormat.format(JGitText.get().valueExceedsRange, str, Integer.class.getSimpleName()));
            numberFormatException.initCause(e);
            throw numberFormatException;
        }
    }

    public static String formatWithSuffix(long j) {
        if (j >= 1073741824 && j % 1073741824 == 0) {
            return String.valueOf(j / 1073741824) + "g";
        }
        if (j >= 1048576 && j % 1048576 == 0) {
            return String.valueOf(j / 1048576) + "m";
        }
        if (j >= 1024 && j % 1024 == 0) {
            return String.valueOf(j / 1024) + "k";
        }
        return String.valueOf(j);
    }

    public static String commonPrefix(@Nullable String... strArr) {
        String str;
        if (strArr == null || strArr.length == 0 || (str = strArr[0]) == null) {
            return "";
        }
        if (strArr.length != 1) {
            for (int i = 0; i < str.length(); i++) {
                char cCharAt = str.charAt(i);
                for (int i2 = 1; i2 < strArr.length; i2++) {
                    String str2 = strArr[i2];
                    if (str2 == null) {
                        return "";
                    }
                    if (str2.length() == i || cCharAt != str2.charAt(i)) {
                        return str2.substring(0, i);
                    }
                }
            }
        }
        return str;
    }
}
