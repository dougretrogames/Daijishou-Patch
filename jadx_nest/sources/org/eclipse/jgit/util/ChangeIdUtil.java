package org.eclipse.jgit.util;

import java.util.regex.Pattern;
import org.eclipse.jgit.lib.Constants;
import org.eclipse.jgit.lib.ObjectId;
import org.eclipse.jgit.lib.ObjectInserter;
import org.eclipse.jgit.lib.PersonIdent;

/* INFO: loaded from: classes5.dex */
public class ChangeIdUtil {
    static final String CHANGE_ID = "Change-Id:";
    private static final Pattern issuePattern = Pattern.compile("^(Bug|Issue)[a-zA-Z0-9-]*:.*$");
    private static final Pattern footerPattern = Pattern.compile("(^[a-zA-Z0-9-]+:(?!//).*$)");
    private static final Pattern changeIdPattern = Pattern.compile("(^Change-Id: *I[a-f0-9]{40}$)");
    private static final Pattern includeInFooterPattern = Pattern.compile("^[ \\[].*$");
    private static final Pattern trailingWhitespace = Pattern.compile("\\s+$");

    static String clean(String str) {
        return str.replaceAll("(?i)(?m)^Signed-off-by:.*$\n?", "").replaceAll("(?m)^#.*$\n?", "").replaceAll("(?m)\n\n\n+", "\\\n").replaceAll("\\n*$", "").replaceAll("(?s)\ndiff --git.*", "").trim();
    }

    public static ObjectId computeChangeId(ObjectId objectId, ObjectId objectId2, PersonIdent personIdent, PersonIdent personIdent2, String str) {
        String strClean = clean(str);
        Throwable th = null;
        if (strClean.length() == 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder("tree ");
        sb.append(ObjectId.toString(objectId));
        sb.append("\n");
        if (objectId2 != null) {
            sb.append("parent ");
            sb.append(ObjectId.toString(objectId2));
            sb.append("\n");
        }
        sb.append("author ");
        sb.append(personIdent.toExternalString());
        sb.append("\ncommitter ");
        sb.append(personIdent2.toExternalString());
        sb.append("\n\n");
        sb.append(strClean);
        try {
            ObjectInserter.Formatter formatter = new ObjectInserter.Formatter();
            try {
                return formatter.idFor(1, Constants.encode(sb.toString()));
            } finally {
                formatter.close();
            }
        } catch (Throwable th2) {
            if (0 == 0) {
                throw th2;
            }
            if (null != th2) {
                th.addSuppressed(th2);
            }
            throw null;
        }
    }

    public static String insertId(String str, ObjectId objectId) {
        return insertId(str, objectId, false);
    }

    public static String insertId(String str, ObjectId objectId, boolean z) {
        int iIndexOfChangeId = indexOfChangeId(str, "\n");
        int i = 0;
        if (iIndexOfChangeId > 0) {
            if (!z) {
                return str;
            }
            StringBuilder sb = new StringBuilder(str.substring(0, iIndexOfChangeId));
            sb.append("Change-Id: I");
            sb.append(ObjectId.toString(objectId));
            int iIndexOf = str.indexOf(10, iIndexOfChangeId);
            if (iIndexOf > 0) {
                sb.append(str.substring(iIndexOf));
            }
            return sb.toString();
        }
        String[] strArrSplit = str.split("\n");
        int iIndexOfFirstFooterLine = indexOfFirstFooterLine(strArrSplit);
        int i2 = iIndexOfFirstFooterLine;
        int i3 = i2;
        while (i2 < strArrSplit.length && issuePattern.matcher(strArrSplit[i2]).matches()) {
            i3 = i2 + 1;
            i2 = i3;
        }
        StringBuilder sb2 = new StringBuilder();
        while (i < i3) {
            sb2.append(strArrSplit[i]);
            sb2.append("\n");
            i++;
        }
        if (i3 == strArrSplit.length && i3 == iIndexOfFirstFooterLine) {
            sb2.append("\n");
        }
        sb2.append("Change-Id: I");
        sb2.append(ObjectId.toString(objectId));
        sb2.append("\n");
        while (i < strArrSplit.length) {
            sb2.append(strArrSplit[i]);
            sb2.append("\n");
            i++;
        }
        return sb2.toString();
    }

    public static int indexOfChangeId(String str, String str2) {
        int i;
        String[] strArrSplit = str.split(str2);
        if (strArrSplit.length == 0) {
            return -1;
        }
        int length = strArrSplit.length - 1;
        boolean z = false;
        while (true) {
            if (length < 0) {
                i = 0;
                break;
            }
            if (z || !isEmptyLine(strArrSplit[length])) {
                if (changeIdPattern.matcher(trimRight(strArrSplit[length])).matches()) {
                    i = length;
                    break;
                }
                if (isEmptyLine(strArrSplit[length]) || length == 0) {
                    return -1;
                }
                z = true;
            }
            length--;
        }
        int length2 = 0;
        for (int i2 = 0; i2 < i; i2++) {
            length2 += strArrSplit[i2].length() + str2.length();
        }
        return length2 + strArrSplit[i].indexOf(CHANGE_ID);
    }

    private static boolean isEmptyLine(String str) {
        return str.trim().length() == 0;
    }

    private static String trimRight(String str) {
        return trailingWhitespace.matcher(str).replaceAll("");
    }

    public static int indexOfFirstFooterLine(String[] strArr) {
        int length = strArr.length;
        for (int length2 = strArr.length - 1; length2 > 1; length2--) {
            if (!footerPattern.matcher(strArr[length2]).matches()) {
                if (length != strArr.length && strArr[length2].length() == 0) {
                    break;
                }
                if (length == strArr.length || !includeInFooterPattern.matcher(strArr[length2]).matches()) {
                    return strArr.length;
                }
                length = length2 + 1;
            } else {
                length = length2;
            }
        }
        return length;
    }
}
