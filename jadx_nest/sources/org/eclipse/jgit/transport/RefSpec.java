package org.eclipse.jgit.transport;

import java.io.Serializable;
import java.text.MessageFormat;
import java.util.Objects;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import net.lingala.zip4j.util.InternalZipConstants;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.lib.Ref;
import org.slf4j.Marker;

/* INFO: loaded from: classes5.dex */
public class RefSpec implements Serializable {
    public static final String WILDCARD_SUFFIX = "/*";
    private static final long serialVersionUID = 1;
    private WildcardMode allowMismatchedWildcards;
    private String dstName;
    private boolean force;
    private boolean matching;
    private boolean negative;
    private String srcName;
    private boolean wildcard;

    public enum WildcardMode {
        REQUIRE_MATCH,
        ALLOW_MISMATCH;

        /* INFO: renamed from: values, reason: to resolve conflict with enum method */
        public static WildcardMode[] valuesCustom() {
            WildcardMode[] wildcardModeArrValuesCustom = values();
            int length = wildcardModeArrValuesCustom.length;
            WildcardMode[] wildcardModeArr = new WildcardMode[length];
            System.arraycopy(wildcardModeArrValuesCustom, 0, wildcardModeArr, 0, length);
            return wildcardModeArr;
        }
    }

    public static boolean isWildcard(String str) {
        return str != null && str.contains("*");
    }

    public RefSpec() {
        this.matching = false;
        this.force = false;
        this.wildcard = false;
        this.srcName = "HEAD";
        this.dstName = null;
        this.negative = false;
        this.allowMismatchedWildcards = WildcardMode.REQUIRE_MATCH;
    }

    /* WARN: Code duplicated, block: B:52:0x00f5  */
    public RefSpec(String str, WildcardMode wildcardMode) {
        String strSubstring;
        this.allowMismatchedWildcards = wildcardMode;
        if (str.startsWith("^+") || str.startsWith("+^")) {
            throw new IllegalArgumentException(JGitText.get().invalidNegativeAndForce);
        }
        boolean z = true;
        if (str.startsWith(Marker.ANY_NON_NULL_MARKER)) {
            this.force = true;
            strSubstring = str.substring(1);
        } else {
            strSubstring = str;
        }
        if (strSubstring.startsWith("^")) {
            this.negative = true;
            strSubstring = strSubstring.substring(1);
        }
        int iLastIndexOf = strSubstring.lastIndexOf(58);
        if (iLastIndexOf == 0) {
            String strSubstring2 = strSubstring.substring(1);
            if (strSubstring2.isEmpty()) {
                this.wildcard = true;
                this.srcName = "refs/heads/*";
                this.dstName = "refs/heads/*";
            } else {
                if (isWildcard(strSubstring2)) {
                    this.wildcard = true;
                    if (wildcardMode == WildcardMode.REQUIRE_MATCH) {
                        throw new IllegalArgumentException(MessageFormat.format(JGitText.get().invalidWildcards, str));
                    }
                }
                this.dstName = checkValid(strSubstring2);
            }
            if (isNegative()) {
                if (!isNullOrEmpty(this.srcName) && isNullOrEmpty(this.dstName)) {
                    throw new IllegalArgumentException(MessageFormat.format(JGitText.get().invalidRefSpec, str));
                }
                if (isNullOrEmpty(this.srcName) && !isNullOrEmpty(this.dstName)) {
                    throw new IllegalArgumentException(MessageFormat.format(JGitText.get().invalidRefSpec, str));
                }
                if (this.wildcard && wildcardMode == WildcardMode.REQUIRE_MATCH) {
                    throw new IllegalArgumentException(MessageFormat.format(JGitText.get().invalidRefSpec, str));
                }
            }
            this.matching = z;
        }
        if (iLastIndexOf > 0) {
            String strSubstring3 = strSubstring.substring(0, iLastIndexOf);
            String strSubstring4 = strSubstring.substring(iLastIndexOf + 1);
            if (isWildcard(strSubstring3) && isWildcard(strSubstring4)) {
                this.wildcard = true;
            } else if (isWildcard(strSubstring3) || isWildcard(strSubstring4)) {
                this.wildcard = true;
                if (wildcardMode == WildcardMode.REQUIRE_MATCH) {
                    throw new IllegalArgumentException(MessageFormat.format(JGitText.get().invalidWildcards, str));
                }
            }
            this.srcName = checkValid(strSubstring3);
            this.dstName = checkValid(strSubstring4);
        } else {
            if (isWildcard(strSubstring)) {
                if (wildcardMode == WildcardMode.REQUIRE_MATCH) {
                    throw new IllegalArgumentException(MessageFormat.format(JGitText.get().invalidWildcards, str));
                }
                this.wildcard = true;
            }
            this.srcName = checkValid(strSubstring);
        }
        z = false;
        if (isNegative()) {
            if (!isNullOrEmpty(this.srcName)) {
            }
            if (isNullOrEmpty(this.srcName)) {
            }
            if (this.wildcard) {
                throw new IllegalArgumentException(MessageFormat.format(JGitText.get().invalidRefSpec, str));
            }
        }
        this.matching = z;
    }

    public RefSpec(String str) {
        this(str, str.startsWith("^") ? WildcardMode.ALLOW_MISMATCH : WildcardMode.REQUIRE_MATCH);
    }

    private RefSpec(RefSpec refSpec) {
        this.matching = false;
        this.force = refSpec.isForceUpdate();
        this.wildcard = refSpec.isWildcard();
        this.negative = refSpec.isNegative();
        this.srcName = refSpec.getSource();
        this.dstName = refSpec.getDestination();
        this.allowMismatchedWildcards = refSpec.allowMismatchedWildcards;
    }

    public boolean isMatching() {
        return this.matching;
    }

    public boolean isForceUpdate() {
        return this.force;
    }

    public RefSpec setForceUpdate(boolean z) {
        RefSpec refSpec = new RefSpec(this);
        if (z && isNegative()) {
            throw new IllegalArgumentException(JGitText.get().invalidNegativeAndForce);
        }
        refSpec.matching = this.matching;
        refSpec.force = z;
        return refSpec;
    }

    public boolean isWildcard() {
        return this.wildcard;
    }

    public boolean isNegative() {
        return this.negative;
    }

    public String getSource() {
        return this.srcName;
    }

    public RefSpec setSource(String str) {
        RefSpec refSpec = new RefSpec(this);
        String strCheckValid = checkValid(str);
        refSpec.srcName = strCheckValid;
        if (isWildcard(strCheckValid) && refSpec.dstName == null) {
            throw new IllegalStateException(JGitText.get().destinationIsNotAWildcard);
        }
        if (isWildcard(refSpec.srcName) == isWildcard(refSpec.dstName)) {
            return refSpec;
        }
        throw new IllegalStateException(JGitText.get().sourceDestinationMustMatch);
    }

    public String getDestination() {
        return this.dstName;
    }

    public RefSpec setDestination(String str) {
        RefSpec refSpec = new RefSpec(this);
        String strCheckValid = checkValid(str);
        refSpec.dstName = strCheckValid;
        if (isWildcard(strCheckValid) && refSpec.srcName == null) {
            throw new IllegalStateException(JGitText.get().sourceIsNotAWildcard);
        }
        if (isWildcard(refSpec.srcName) == isWildcard(refSpec.dstName)) {
            return refSpec;
        }
        throw new IllegalStateException(JGitText.get().sourceDestinationMustMatch);
    }

    public RefSpec setSourceDestination(String str, String str2) {
        if (isWildcard(str) != isWildcard(str2)) {
            throw new IllegalStateException(JGitText.get().sourceDestinationMustMatch);
        }
        RefSpec refSpec = new RefSpec(this);
        refSpec.wildcard = isWildcard(str);
        refSpec.srcName = str;
        refSpec.dstName = str2;
        return refSpec;
    }

    public boolean matchSource(String str) {
        return match(str, getSource());
    }

    public boolean matchSource(Ref ref) {
        return match(ref.getName(), getSource());
    }

    public boolean matchDestination(String str) {
        return match(str, getDestination());
    }

    public boolean matchDestination(Ref ref) {
        return match(ref.getName(), getDestination());
    }

    public RefSpec expandFromSource(String str) {
        if (this.allowMismatchedWildcards == WildcardMode.REQUIRE_MATCH) {
            return isWildcard() ? new RefSpec(this).expandFromSourceImp(str) : this;
        }
        throw new IllegalStateException(JGitText.get().invalidExpandWildcard);
    }

    private RefSpec expandFromSourceImp(String str) {
        String str2 = this.srcName;
        String str3 = this.dstName;
        this.wildcard = false;
        this.srcName = str;
        this.dstName = expandWildcard(str, str2, str3);
        return this;
    }

    private static boolean isNullOrEmpty(String str) {
        return str == null || str.isEmpty();
    }

    public RefSpec expandFromSource(Ref ref) {
        return expandFromSource(ref.getName());
    }

    public RefSpec expandFromDestination(String str) {
        if (this.allowMismatchedWildcards == WildcardMode.REQUIRE_MATCH) {
            return isWildcard() ? new RefSpec(this).expandFromDstImp(str) : this;
        }
        throw new IllegalStateException(JGitText.get().invalidExpandWildcard);
    }

    private RefSpec expandFromDstImp(String str) {
        String str2 = this.srcName;
        String str3 = this.dstName;
        this.wildcard = false;
        this.srcName = expandWildcard(str, str3, str2);
        this.dstName = str;
        return this;
    }

    public RefSpec expandFromDestination(Ref ref) {
        return expandFromDestination(ref.getName());
    }

    private boolean match(String str, String str2) {
        if (str2 == null) {
            return false;
        }
        if (isWildcard(str2)) {
            int iIndexOf = str2.indexOf(42);
            String strSubstring = str2.substring(0, iIndexOf);
            String strSubstring2 = str2.substring(iIndexOf + 1);
            return str.length() > strSubstring.length() + strSubstring2.length() && str.startsWith(strSubstring) && str.endsWith(strSubstring2);
        }
        return str.equals(str2);
    }

    private static String expandWildcard(String str, String str2, String str3) {
        int iIndexOf = str2.indexOf(42);
        int length = str2.length() - (iIndexOf + 1);
        int iIndexOf2 = str3.indexOf(42);
        String strSubstring = str.substring(iIndexOf, str.length() - length);
        return str3.substring(0, iIndexOf2) + strSubstring + str3.substring(iIndexOf2 + 1);
    }

    private static String checkValid(String str) {
        if (str == null || isValid(str)) {
            return str;
        }
        throw new IllegalArgumentException(MessageFormat.format(JGitText.get().invalidRefSpec, str));
    }

    private static boolean isValid(String str) {
        if (str.startsWith(InternalZipConstants.ZIP_FILE_SEPARATOR) || str.contains("//") || str.endsWith(InternalZipConstants.ZIP_FILE_SEPARATOR)) {
            return false;
        }
        int iIndexOf = str.indexOf(42);
        return iIndexOf == -1 || str.indexOf(42, iIndexOf + 1) <= iIndexOf;
    }

    public int hashCode() {
        int iHashCode = getSource() != null ? getSource().hashCode() : 0;
        return getDestination() != null ? (iHashCode * 31) + getDestination().hashCode() : iHashCode;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof RefSpec)) {
            return false;
        }
        RefSpec refSpec = (RefSpec) obj;
        if (isForceUpdate() != refSpec.isForceUpdate() || isNegative() != refSpec.isNegative()) {
            return false;
        }
        if (isMatching()) {
            return refSpec.isMatching();
        }
        return !refSpec.isMatching() && isWildcard() == refSpec.isWildcard() && Objects.equals(getSource(), refSpec.getSource()) && Objects.equals(getDestination(), refSpec.getDestination());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (isForceUpdate()) {
            sb.append('+');
        }
        if (isNegative()) {
            sb.append('^');
        }
        if (isMatching()) {
            sb.append(AbstractJsonLexerKt.COLON);
        } else {
            if (getSource() != null) {
                sb.append(getSource());
            }
            if (getDestination() != null) {
                sb.append(AbstractJsonLexerKt.COLON);
                sb.append(getDestination());
            }
        }
        return sb.toString();
    }
}
