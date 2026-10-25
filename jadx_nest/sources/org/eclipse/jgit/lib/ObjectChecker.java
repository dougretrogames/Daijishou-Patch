package org.eclipse.jgit.lib;

import java.text.MessageFormat;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import kotlin.text.Typography;
import org.eclipse.jgit.annotations.Nullable;
import org.eclipse.jgit.errors.CorruptObjectException;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.util.MutableInteger;
import org.eclipse.jgit.util.Paths;
import org.eclipse.jgit.util.RawParseUtils;
import org.eclipse.jgit.util.StringUtils;

/* JADX INFO: loaded from: classes5.dex */
public class ObjectChecker {
    private boolean allowInvalidPersonIdent;
    private boolean macosx;
    private ObjectIdSet skipList;
    private boolean windows;
    public static final byte[] tree = Constants.encodeASCII("tree ");
    public static final byte[] parent = Constants.encodeASCII("parent ");
    public static final byte[] author = Constants.encodeASCII("author ");
    public static final byte[] committer = Constants.encodeASCII("committer ");
    public static final byte[] encoding = Constants.encodeASCII("encoding ");
    public static final byte[] object = Constants.encodeASCII("object ");
    public static final byte[] type = Constants.encodeASCII("type ");
    public static final byte[] tag = Constants.encodeASCII("tag ");
    public static final byte[] tagger = Constants.encodeASCII("tagger ");
    private static final byte[] dotGitmodules = Constants.encodeASCII(Constants.DOT_GIT_MODULES);
    private final MutableObjectId tempId = new MutableObjectId();
    private final MutableInteger bufPtr = new MutableInteger();
    private EnumSet<ErrorType> errors = EnumSet.allOf(ErrorType.class);
    private final List<GitmoduleEntry> gitsubmodules = new ArrayList();

    private static boolean isInvalidOnWindows(byte b) {
        if (b == 34 || b == 42 || b == 58 || b == 60 || b == 92 || b == 124 || b == 62 || b == 63) {
            return true;
        }
        return 1 <= b && b <= 31;
    }

    private static boolean isPositiveDigit(byte b) {
        return 49 <= b && b <= 57;
    }

    private static char toLower(byte b) {
        return (65 > b || b > 90) ? (char) b : (char) (b + 32);
    }

    public void checkBlob(byte[] bArr) throws CorruptObjectException {
    }

    @Nullable
    public BlobObjectChecker newBlobObjectChecker() {
        return null;
    }

    public enum ErrorType {
        NULL_SHA1,
        DUPLICATE_ENTRIES,
        TREE_NOT_SORTED,
        ZERO_PADDED_FILEMODE,
        EMPTY_NAME,
        FULL_PATHNAME,
        HAS_DOT,
        HAS_DOTDOT,
        HAS_DOTGIT,
        BAD_OBJECT_SHA1,
        BAD_PARENT_SHA1,
        BAD_TREE_SHA1,
        MISSING_AUTHOR,
        MISSING_COMMITTER,
        MISSING_OBJECT,
        MISSING_TREE,
        MISSING_TYPE_ENTRY,
        MISSING_TAG_ENTRY,
        BAD_DATE,
        BAD_EMAIL,
        BAD_TIMEZONE,
        MISSING_EMAIL,
        MISSING_SPACE_BEFORE_DATE,
        GITMODULES_BLOB,
        GITMODULES_LARGE,
        GITMODULES_NAME,
        GITMODULES_PARSE,
        GITMODULES_PATH,
        GITMODULES_SYMLINK,
        GITMODULES_URL,
        UNKNOWN_TYPE,
        WIN32_BAD_NAME,
        BAD_UTF8;

        /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
        public static ErrorType[] valuesCustom() {
            ErrorType[] errorTypeArrValuesCustom = values();
            int length = errorTypeArrValuesCustom.length;
            ErrorType[] errorTypeArr = new ErrorType[length];
            System.arraycopy(errorTypeArrValuesCustom, 0, errorTypeArr, 0, length);
            return errorTypeArr;
        }

        public String getMessageId() {
            String strName = name();
            StringBuilder sb = new StringBuilder(strName.length());
            int i = 0;
            while (i < strName.length()) {
                char cCharAt = strName.charAt(i);
                if (cCharAt != '_') {
                    sb.append(StringUtils.toLowerCase(cCharAt));
                } else {
                    i++;
                    sb.append(strName.charAt(i));
                }
                i++;
            }
            return sb.toString();
        }
    }

    public ObjectChecker setSkipList(@Nullable ObjectIdSet objectIdSet) {
        this.skipList = objectIdSet;
        return this;
    }

    public ObjectChecker setIgnore(@Nullable Set<ErrorType> set) {
        EnumSet<ErrorType> enumSetAllOf = EnumSet.allOf(ErrorType.class);
        this.errors = enumSetAllOf;
        if (set != null) {
            enumSetAllOf.removeAll(set);
        }
        return this;
    }

    public ObjectChecker setIgnore(ErrorType errorType, boolean z) {
        if (z) {
            this.errors.remove(errorType);
            return this;
        }
        this.errors.add(errorType);
        return this;
    }

    public ObjectChecker setAllowLeadingZeroFileMode(boolean z) {
        return setIgnore(ErrorType.ZERO_PADDED_FILEMODE, z);
    }

    public ObjectChecker setAllowInvalidPersonIdent(boolean z) {
        this.allowInvalidPersonIdent = z;
        return this;
    }

    public ObjectChecker setSafeForWindows(boolean z) {
        this.windows = z;
        return this;
    }

    public ObjectChecker setSafeForMacOS(boolean z) {
        this.macosx = z;
        return this;
    }

    public void check(int i, byte[] bArr) throws CorruptObjectException {
        check(idFor(i, bArr), i, bArr);
    }

    public void check(@Nullable AnyObjectId anyObjectId, int i, byte[] bArr) throws CorruptObjectException {
        if (i == 1) {
            checkCommit(anyObjectId, bArr);
            return;
        }
        if (i == 2) {
            checkTree(anyObjectId, bArr);
            return;
        }
        if (i != 3) {
            if (i == 4) {
                checkTag(anyObjectId, bArr);
                return;
            } else {
                report(ErrorType.UNKNOWN_TYPE, anyObjectId, MessageFormat.format(JGitText.get().corruptObjectInvalidType2, Integer.valueOf(i)));
                return;
            }
        }
        BlobObjectChecker blobObjectCheckerNewBlobObjectChecker = newBlobObjectChecker();
        if (blobObjectCheckerNewBlobObjectChecker == null) {
            checkBlob(bArr);
        } else {
            blobObjectCheckerNewBlobObjectChecker.update(bArr, 0, bArr.length);
            blobObjectCheckerNewBlobObjectChecker.endBlob(anyObjectId);
        }
    }

    private boolean checkId(byte[] bArr) {
        int i = this.bufPtr.value;
        try {
            this.tempId.fromString(bArr, i);
            int i2 = i + 40;
            if (bArr[i2] == 10) {
                this.bufPtr.value = i + 41;
                return true;
            }
            this.bufPtr.value = RawParseUtils.nextLF(bArr, i2);
            return false;
        } catch (IllegalArgumentException unused) {
            this.bufPtr.value = RawParseUtils.nextLF(bArr, i);
            return false;
        }
    }

    private void checkPersonIdent(byte[] bArr, @Nullable AnyObjectId anyObjectId) throws CorruptObjectException {
        if (this.allowInvalidPersonIdent) {
            MutableInteger mutableInteger = this.bufPtr;
            mutableInteger.value = RawParseUtils.nextLF(bArr, mutableInteger.value);
            return;
        }
        int iNextLF = RawParseUtils.nextLF(bArr, this.bufPtr.value, Typography.less);
        if (iNextLF == this.bufPtr.value || bArr[iNextLF - 1] != 60) {
            report(ErrorType.MISSING_EMAIL, anyObjectId, JGitText.get().corruptObjectMissingEmail);
            MutableInteger mutableInteger2 = this.bufPtr;
            mutableInteger2.value = RawParseUtils.nextLF(bArr, mutableInteger2.value);
            return;
        }
        int iNextLF2 = RawParseUtils.nextLF(bArr, iNextLF, Typography.greater);
        if (iNextLF2 == iNextLF || bArr[iNextLF2 - 1] != 62) {
            report(ErrorType.BAD_EMAIL, anyObjectId, JGitText.get().corruptObjectBadEmail);
            MutableInteger mutableInteger3 = this.bufPtr;
            mutableInteger3.value = RawParseUtils.nextLF(bArr, mutableInteger3.value);
            return;
        }
        if (iNextLF2 == bArr.length || bArr[iNextLF2] != 32) {
            report(ErrorType.MISSING_SPACE_BEFORE_DATE, anyObjectId, JGitText.get().corruptObjectBadDate);
            MutableInteger mutableInteger4 = this.bufPtr;
            mutableInteger4.value = RawParseUtils.nextLF(bArr, mutableInteger4.value);
            return;
        }
        int i = iNextLF2 + 1;
        RawParseUtils.parseBase10(bArr, i, this.bufPtr);
        if (i == this.bufPtr.value || this.bufPtr.value == bArr.length || bArr[this.bufPtr.value] != 32) {
            report(ErrorType.BAD_DATE, anyObjectId, JGitText.get().corruptObjectBadDate);
            MutableInteger mutableInteger5 = this.bufPtr;
            mutableInteger5.value = RawParseUtils.nextLF(bArr, mutableInteger5.value);
            return;
        }
        int i2 = this.bufPtr.value + 1;
        RawParseUtils.parseBase10(bArr, i2, this.bufPtr);
        if (i2 == this.bufPtr.value) {
            report(ErrorType.BAD_TIMEZONE, anyObjectId, JGitText.get().corruptObjectBadTimezone);
            MutableInteger mutableInteger6 = this.bufPtr;
            mutableInteger6.value = RawParseUtils.nextLF(bArr, mutableInteger6.value);
            return;
        }
        int i3 = this.bufPtr.value;
        if (bArr[i3] == 10) {
            this.bufPtr.value = i3 + 1;
        } else {
            report(ErrorType.BAD_TIMEZONE, anyObjectId, JGitText.get().corruptObjectBadTimezone);
            this.bufPtr.value = RawParseUtils.nextLF(bArr, i3);
        }
    }

    public void checkCommit(byte[] bArr) throws CorruptObjectException {
        checkCommit(idFor(1, bArr), bArr);
    }

    public void checkCommit(@Nullable AnyObjectId anyObjectId, byte[] bArr) throws CorruptObjectException {
        this.bufPtr.value = 0;
        if (!match(bArr, tree)) {
            report(ErrorType.MISSING_TREE, anyObjectId, JGitText.get().corruptObjectNotreeHeader);
        } else if (!checkId(bArr)) {
            report(ErrorType.BAD_TREE_SHA1, anyObjectId, JGitText.get().corruptObjectInvalidTree);
        }
        while (match(bArr, parent)) {
            if (!checkId(bArr)) {
                report(ErrorType.BAD_PARENT_SHA1, anyObjectId, JGitText.get().corruptObjectInvalidParent);
            }
        }
        if (match(bArr, author)) {
            checkPersonIdent(bArr, anyObjectId);
        } else {
            report(ErrorType.MISSING_AUTHOR, anyObjectId, JGitText.get().corruptObjectNoAuthor);
        }
        if (match(bArr, committer)) {
            checkPersonIdent(bArr, anyObjectId);
        } else {
            report(ErrorType.MISSING_COMMITTER, anyObjectId, JGitText.get().corruptObjectNoCommitter);
        }
    }

    public void checkTag(byte[] bArr) throws CorruptObjectException {
        checkTag(idFor(4, bArr), bArr);
    }

    public void checkTag(@Nullable AnyObjectId anyObjectId, byte[] bArr) throws CorruptObjectException {
        this.bufPtr.value = 0;
        if (!match(bArr, object)) {
            report(ErrorType.MISSING_OBJECT, anyObjectId, JGitText.get().corruptObjectNoObjectHeader);
        } else if (!checkId(bArr)) {
            report(ErrorType.BAD_OBJECT_SHA1, anyObjectId, JGitText.get().corruptObjectInvalidObject);
        }
        if (!match(bArr, type)) {
            report(ErrorType.MISSING_TYPE_ENTRY, anyObjectId, JGitText.get().corruptObjectNoTypeHeader);
        }
        MutableInteger mutableInteger = this.bufPtr;
        mutableInteger.value = RawParseUtils.nextLF(bArr, mutableInteger.value);
        if (!match(bArr, tag)) {
            report(ErrorType.MISSING_TAG_ENTRY, anyObjectId, JGitText.get().corruptObjectNoTagHeader);
        }
        MutableInteger mutableInteger2 = this.bufPtr;
        mutableInteger2.value = RawParseUtils.nextLF(bArr, mutableInteger2.value);
        if (match(bArr, tagger)) {
            checkPersonIdent(bArr, anyObjectId);
        }
    }

    private static boolean duplicateName(byte[] bArr, int i, int i2) {
        byte[] bArr2;
        int i3;
        int i4;
        int iCompareSameName;
        int length = bArr.length;
        int i5 = i2 + 21;
        while (true) {
            int i6 = 0;
            while (i5 < length) {
                int i7 = i5 + 1;
                byte b = bArr[i5];
                if (32 == b) {
                    int i8 = i7;
                    while (i8 != length) {
                        int i9 = i8 + 1;
                        if (bArr[i8] != 0) {
                            i8 = i9;
                        } else {
                            if (i5 + 2 == i9 || (iCompareSameName = Paths.compareSameName((bArr2 = bArr), (i3 = i), (i4 = i2), bArr, i7, i8, i6)) < 0) {
                                return false;
                            }
                            if (iCompareSameName == 0) {
                                return true;
                            }
                            i5 = i8 + 21;
                            bArr = bArr2;
                            i = i3;
                            i2 = i4;
                        }
                    }
                    return false;
                }
                i6 = (i6 << 3) + (b - 48);
                bArr = bArr;
                i = i;
                i5 = i7;
            }
            return false;
        }
    }

    public void checkTree(byte[] bArr) throws CorruptObjectException {
        checkTree(idFor(2, bArr), bArr);
    }

    public void checkTree(@Nullable AnyObjectId anyObjectId, byte[] bArr) throws CorruptObjectException {
        int i;
        byte[] bArr2;
        int length = bArr.length;
        HashSet hashSet = (this.windows || this.macosx) ? new HashSet() : null;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (i2 < length) {
            int i6 = 0;
            while (true) {
                if (i2 == length) {
                    throw new CorruptObjectException(JGitText.get().corruptObjectTruncatedInMode);
                }
                i = i2 + 1;
                byte b = bArr[i2];
                if (32 == b) {
                    break;
                }
                byte[] bArr3 = bArr;
                if (b < 48 || b > 55) {
                    throw new CorruptObjectException(JGitText.get().corruptObjectInvalidModeChar);
                }
                if (i6 == 0 && b == 48) {
                    report(ErrorType.ZERO_PADDED_FILEMODE, anyObjectId, JGitText.get().corruptObjectInvalidModeStartsZero);
                }
                i6 = (i6 << 3) + (b - 48);
                bArr = bArr3;
                i2 = i;
            }
            if (FileMode.fromBits(i6).getObjectType() == -1) {
                throw new CorruptObjectException(MessageFormat.format(JGitText.get().corruptObjectInvalidMode2, Integer.valueOf(i6)));
            }
            int iScanPathSegment = scanPathSegment(bArr, i, length, anyObjectId);
            if (iScanPathSegment == length || bArr[iScanPathSegment] != 0) {
                throw new CorruptObjectException(JGitText.get().corruptObjectTruncatedInName);
            }
            checkPathSegment2(bArr, i, iScanPathSegment, anyObjectId);
            if (hashSet != null) {
                if (!hashSet.add(normalize(bArr, i, iScanPathSegment))) {
                    report(ErrorType.DUPLICATE_ENTRIES, anyObjectId, JGitText.get().corruptObjectDuplicateEntryNames);
                }
            } else if (duplicateName(bArr, i, iScanPathSegment)) {
                report(ErrorType.DUPLICATE_ENTRIES, anyObjectId, JGitText.get().corruptObjectDuplicateEntryNames);
            }
            if (i3 != 0) {
                bArr2 = bArr;
                if (Paths.compare(bArr2, i3, i4, i5, bArr, i, iScanPathSegment, i6) > 0) {
                    report(ErrorType.TREE_NOT_SORTED, anyObjectId, JGitText.get().corruptObjectIncorrectSorting);
                }
            } else {
                bArr2 = bArr;
            }
            i2 = iScanPathSegment + 21;
            if (i2 > length) {
                throw new CorruptObjectException(JGitText.get().corruptObjectTruncatedInObjectId);
            }
            int i7 = iScanPathSegment + 1;
            if (ObjectId.zeroId().compareTo(bArr2, i7) == 0) {
                report(ErrorType.NULL_SHA1, anyObjectId, JGitText.get().corruptObjectZeroId);
            }
            if (anyObjectId != null && isGitmodules(bArr2, i, iScanPathSegment, anyObjectId)) {
                this.gitsubmodules.add(new GitmoduleEntry(anyObjectId, ObjectId.fromRaw(bArr2, i7)));
            }
            bArr = bArr2;
            i3 = i;
            i4 = iScanPathSegment;
            i5 = i6;
        }
    }

    private int scanPathSegment(byte[] bArr, int i, int i2, @Nullable AnyObjectId anyObjectId) throws CorruptObjectException {
        while (i < i2) {
            byte b = bArr[i];
            if (b == 0) {
                break;
            }
            if (b == 47) {
                report(ErrorType.FULL_PATHNAME, anyObjectId, JGitText.get().corruptObjectNameContainsSlash);
            }
            if (this.windows && isInvalidOnWindows(b)) {
                if (b > 31) {
                    throw new CorruptObjectException(String.format(JGitText.get().corruptObjectNameContainsChar, Byte.valueOf(b)));
                }
                throw new CorruptObjectException(String.format(JGitText.get().corruptObjectNameContainsByte, Integer.valueOf(b & 255)));
            }
            i++;
        }
        return i;
    }

    @Nullable
    private ObjectId idFor(int i, byte[] bArr) {
        Throwable th = null;
        if (this.skipList == null) {
            return null;
        }
        try {
            ObjectInserter.Formatter formatter = new ObjectInserter.Formatter();
            try {
                return formatter.idFor(i, bArr);
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

    private void report(ErrorType errorType, @Nullable AnyObjectId anyObjectId, String str) throws CorruptObjectException {
        ObjectIdSet objectIdSet;
        if (this.errors.contains(errorType)) {
            if (anyObjectId == null || (objectIdSet = this.skipList) == null || !objectIdSet.contains(anyObjectId)) {
                if (anyObjectId != null) {
                    throw new CorruptObjectException(errorType, anyObjectId, str);
                }
                throw new CorruptObjectException(str);
            }
        }
    }

    public void checkPath(String str) throws CorruptObjectException {
        byte[] bArrEncode = Constants.encode(str);
        checkPath(bArrEncode, 0, bArrEncode.length);
    }

    public void checkPath(byte[] bArr, int i, int i2) throws CorruptObjectException {
        int i3 = i;
        while (i < i2) {
            if (bArr[i] == 47) {
                checkPathSegment(bArr, i3, i);
                i3 = i + 1;
            }
            i++;
        }
        checkPathSegment(bArr, i3, i2);
    }

    public void checkPathSegment(byte[] bArr, int i, int i2) throws CorruptObjectException {
        int iScanPathSegment = scanPathSegment(bArr, i, i2, null);
        if (iScanPathSegment < i2 && bArr[iScanPathSegment] == 0) {
            throw new CorruptObjectException(JGitText.get().corruptObjectNameContainsNullByte);
        }
        checkPathSegment2(bArr, i, i2, null);
    }

    private void checkPathSegment2(byte[] bArr, int i, int i2, @Nullable AnyObjectId anyObjectId) throws CorruptObjectException {
        if (i == i2) {
            report(ErrorType.EMPTY_NAME, anyObjectId, JGitText.get().corruptObjectNameZeroLength);
            return;
        }
        if (bArr[i] == 46) {
            int i3 = i2 - i;
            if (i3 == 1) {
                report(ErrorType.HAS_DOT, anyObjectId, JGitText.get().corruptObjectNameDot);
            } else if (i3 != 2) {
                if (i3 == 4) {
                    if (isGit(bArr, i + 1)) {
                        report(ErrorType.HAS_DOTGIT, anyObjectId, String.format(JGitText.get().corruptObjectInvalidName, RawParseUtils.decode(bArr, i, i2)));
                    }
                } else if (i3 > 4 && isNormalizedGit(bArr, i + 1, i2)) {
                    report(ErrorType.HAS_DOTGIT, anyObjectId, String.format(JGitText.get().corruptObjectInvalidName, RawParseUtils.decode(bArr, i, i2)));
                }
            } else if (bArr[i + 1] == 46) {
                report(ErrorType.HAS_DOTDOT, anyObjectId, JGitText.get().corruptObjectNameDotDot);
            }
        } else if (isGitTilde1(bArr, i, i2)) {
            report(ErrorType.HAS_DOTGIT, anyObjectId, String.format(JGitText.get().corruptObjectInvalidName, RawParseUtils.decode(bArr, i, i2)));
        }
        if (this.macosx && isMacHFSGit(bArr, i, i2, anyObjectId)) {
            report(ErrorType.HAS_DOTGIT, anyObjectId, String.format(JGitText.get().corruptObjectInvalidNameIgnorableUnicode, RawParseUtils.decode(bArr, i, i2)));
        }
        if (this.windows) {
            int i4 = i2 - 1;
            byte b = bArr[i4];
            if (b == 32 || b == 46) {
                report(ErrorType.WIN32_BAD_NAME, anyObjectId, String.format(JGitText.get().corruptObjectInvalidNameEnd, Character.valueOf((char) bArr[i4])));
            }
            if (i2 - i >= 3) {
                checkNotWindowsDevice(bArr, i, i2, anyObjectId);
            }
        }
    }

    private boolean isMacHFSPath(byte[] bArr, int i, int i2, byte[] bArr2, @Nullable AnyObjectId anyObjectId) throws CorruptObjectException {
        int i3 = 0;
        boolean z = false;
        while (i < i2) {
            byte b = bArr[i];
            if (b == -30) {
                if (!checkTruncatedIgnorableUTF8(bArr, i, i2, anyObjectId)) {
                    return false;
                }
                byte b2 = bArr[i + 1];
                if (b2 == -128) {
                    byte b3 = bArr[i + 2];
                    switch (b3) {
                        default:
                            switch (b3) {
                                case -86:
                                case -85:
                                case -84:
                                case -83:
                                case -82:
                                    break;
                                default:
                                    return false;
                            }
                        case -116:
                        case -115:
                        case -114:
                        case -113:
                            i += 3;
                            z = true;
                            break;
                    }
                } else {
                    if (b2 != -127) {
                        return false;
                    }
                    switch (bArr[i + 2]) {
                        case -86:
                        case -85:
                        case -84:
                        case -83:
                        case -82:
                        case -81:
                            break;
                        default:
                            return false;
                    }
                }
            } else if (b == -17) {
                if (!checkTruncatedIgnorableUTF8(bArr, i, i2, anyObjectId) || bArr[i + 1] != -69 || bArr[i + 2] != -65) {
                    return false;
                }
            } else {
                if (i3 == bArr2.length) {
                    return false;
                }
                i++;
                byte lower = toLower(b);
                int i4 = i3 + 1;
                if (lower != bArr2[i3]) {
                    return false;
                }
                i3 = i4;
            }
            i += 3;
            z = true;
        }
        return i3 == bArr2.length && z;
    }

    private boolean isMacHFSGit(byte[] bArr, int i, int i2, @Nullable AnyObjectId anyObjectId) throws CorruptObjectException {
        return isMacHFSPath(bArr, i, i2, new byte[]{46, 103, 105, 116}, anyObjectId);
    }

    private boolean isMacHFSGitmodules(byte[] bArr, int i, int i2, @Nullable AnyObjectId anyObjectId) throws CorruptObjectException {
        return isMacHFSPath(bArr, i, i2, dotGitmodules, anyObjectId);
    }

    private boolean checkTruncatedIgnorableUTF8(byte[] bArr, int i, int i2, @Nullable AnyObjectId anyObjectId) throws CorruptObjectException {
        if (i + 2 < i2) {
            return true;
        }
        report(ErrorType.BAD_UTF8, anyObjectId, MessageFormat.format(JGitText.get().corruptObjectInvalidNameInvalidUtf8, toHexString(bArr, i, i2)));
        return false;
    }

    private static String toHexString(byte[] bArr, int i, int i2) {
        StringBuilder sb = new StringBuilder("0x");
        while (i < i2) {
            sb.append(String.format("%02x", Byte.valueOf(bArr[i])));
            i++;
        }
        return sb.toString();
    }

    private void checkNotWindowsDevice(byte[] bArr, int i, int i2, @Nullable AnyObjectId anyObjectId) throws CorruptObjectException {
        int i3;
        char lower = toLower(bArr[i]);
        if (lower == 'a') {
            int i4 = i2 - i;
            if (i4 >= 3 && toLower(bArr[i + 1]) == 'u' && toLower(bArr[i + 2]) == 'x') {
                if (i4 == 3 || bArr[i + 3] == 46) {
                    report(ErrorType.WIN32_BAD_NAME, anyObjectId, JGitText.get().corruptObjectInvalidNameAux);
                    return;
                }
                return;
            }
            return;
        }
        if (lower == 'c') {
            int i5 = i2 - i;
            if (i5 >= 3 && toLower(bArr[i + 2]) == 'n' && toLower(bArr[i + 1]) == 'o' && (i5 == 3 || bArr[i + 3] == 46)) {
                report(ErrorType.WIN32_BAD_NAME, anyObjectId, JGitText.get().corruptObjectInvalidNameCon);
            }
            if (i5 >= 4 && toLower(bArr[i + 2]) == 'm' && toLower(bArr[i + 1]) == 'o') {
                int i6 = i + 3;
                if (isPositiveDigit(bArr[i6])) {
                    if (i5 == 4 || bArr[i + 4] == 46) {
                        report(ErrorType.WIN32_BAD_NAME, anyObjectId, String.format(JGitText.get().corruptObjectInvalidNameCom, Character.valueOf((char) bArr[i6])));
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        if (lower == 'l') {
            int i7 = i2 - i;
            if (i7 >= 4 && toLower(bArr[i + 1]) == 'p' && toLower(bArr[i + 2]) == 't') {
                int i8 = i + 3;
                if (isPositiveDigit(bArr[i8])) {
                    if (i7 == 4 || bArr[i + 4] == 46) {
                        report(ErrorType.WIN32_BAD_NAME, anyObjectId, String.format(JGitText.get().corruptObjectInvalidNameLpt, Character.valueOf((char) bArr[i8])));
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        if (lower == 'n') {
            int i9 = i2 - i;
            if (i9 >= 3 && toLower(bArr[i + 1]) == 'u' && toLower(bArr[i + 2]) == 'l') {
                if (i9 == 3 || bArr[i + 3] == 46) {
                    report(ErrorType.WIN32_BAD_NAME, anyObjectId, JGitText.get().corruptObjectInvalidNameNul);
                    return;
                }
                return;
            }
            return;
        }
        if (lower == 'p' && (i3 = i2 - i) >= 3 && toLower(bArr[i + 1]) == 'r' && toLower(bArr[i + 2]) == 'n') {
            if (i3 == 3 || bArr[i + 3] == 46) {
                report(ErrorType.WIN32_BAD_NAME, anyObjectId, JGitText.get().corruptObjectInvalidNamePrn);
            }
        }
    }

    private static boolean isGit(byte[] bArr, int i) {
        return toLower(bArr[i]) == 'g' && toLower(bArr[i + 1]) == 'i' && toLower(bArr[i + 2]) == 't';
    }

    private boolean isGitmodules(byte[] bArr, int i, int i2, @Nullable AnyObjectId anyObjectId) throws CorruptObjectException {
        int i3 = i2 - i;
        if (i3 < 8) {
            return false;
        }
        byte[] bArr2 = dotGitmodules;
        if (i3 == bArr2.length && RawParseUtils.match(bArr, i, bArr2) != -1) {
            return true;
        }
        if (this.macosx && isMacHFSGitmodules(bArr, i, i2, anyObjectId)) {
            return true;
        }
        return this.windows && isNTFSGitmodules(bArr, i, i2);
    }

    private boolean matchLowerCase(byte[] bArr, int i, byte[] bArr2) {
        if (bArr2.length + i > bArr.length) {
            return false;
        }
        int i2 = 0;
        while (i2 < bArr2.length) {
            if (toLower(bArr[i]) != bArr2[i2]) {
                return false;
            }
            i2++;
            i++;
        }
        return true;
    }

    private boolean isNTFSGitmodules(byte[] bArr, int i, int i2) {
        byte b;
        int i3 = i2 - i;
        if (i3 == 11) {
            return matchLowerCase(bArr, i, dotGitmodules);
        }
        if (i3 != 8) {
            return false;
        }
        if (matchLowerCase(bArr, i, new byte[]{103, 105, 116, 109, 111, 100, 126})) {
            i += 6;
        } else {
            byte[] bArr2 = {103, 105, 55, 101, 98, 97};
            int i4 = 0;
            while (i4 < 6) {
                byte lower = (byte) toLower(bArr[i]);
                if (lower == 126) {
                    break;
                }
                if (lower != bArr2[i4]) {
                    return false;
                }
                i4++;
                i++;
            }
        }
        if (i2 - i >= 2 && bArr[i] == 126 && (b = bArr[i + 1]) >= 49 && b <= 57) {
            for (int i5 = i + 2; i5 != i2; i5++) {
                byte b2 = bArr[i5];
                if (b2 >= 48 && b2 <= 57) {
                }
            }
            return true;
        }
        return false;
    }

    private static boolean isGitTilde1(byte[] bArr, int i, int i2) {
        return i2 - i == 5 && toLower(bArr[i]) == 'g' && toLower(bArr[i + 1]) == 'i' && toLower(bArr[i + 2]) == 't' && bArr[i + 3] == 126 && bArr[i + 4] == 49;
    }

    private static boolean isNormalizedGit(byte[] bArr, int i, int i2) {
        int i3;
        if (isGit(bArr, i)) {
            int i4 = i2 - 1;
            int i5 = 0;
            boolean z = false;
            while (true) {
                i3 = i + 2;
                if (i3 >= i4) {
                    break;
                }
                byte b = bArr[i4];
                if (b != 46) {
                    if (b != 32) {
                        break;
                    }
                    z = true;
                } else {
                    i5++;
                }
                i4--;
            }
            if (i4 == i3 && (i5 == 1 || z)) {
                return true;
            }
        }
        return false;
    }

    private boolean match(byte[] bArr, byte[] bArr2) {
        int iMatch = RawParseUtils.match(bArr, this.bufPtr.value, bArr2);
        if (iMatch < 0) {
            return false;
        }
        this.bufPtr.value = iMatch;
        return true;
    }

    private String normalize(byte[] bArr, int i, int i2) {
        String lowerCase = RawParseUtils.decode(bArr, i, i2).toLowerCase(Locale.US);
        return this.macosx ? Normalizer.normalize(lowerCase, Normalizer.Form.NFC) : lowerCase;
    }

    public List<GitmoduleEntry> getGitsubmodules() {
        return this.gitsubmodules;
    }

    public void reset() {
        this.gitsubmodules.clear();
    }
}
