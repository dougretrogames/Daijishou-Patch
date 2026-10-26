package com.vdurmont.semver4j;

import androidx.exifinterface.media.ExifInterface;
import java.util.Objects;
import org.eclipse.jgit.lib.BranchConfig;
import org.slf4j.Marker;

/* INFO: loaded from: classes4.dex */
public class Semver implements Comparable<Semver> {
    private final String build;
    private final Integer major;
    private final Integer minor;
    private final String originalValue;
    private final Integer patch;
    private final String[] suffixTokens;
    private final SemverType type;
    private final String value;

    public enum SemverType {
        STRICT,
        LOOSE,
        NPM,
        COCOAPODS,
        IVY
    }

    public enum VersionDiff {
        NONE,
        MAJOR,
        MINOR,
        PATCH,
        SUFFIX,
        BUILD
    }

    public Semver(String str) {
        this(str, SemverType.STRICT);
    }

    public Semver(String str, SemverType semverType) {
        String[] strArr;
        char c;
        String[] strArrSplit;
        String str2;
        Integer numValueOf;
        this.originalValue = str;
        this.type = semverType;
        String strTrim = str.trim();
        if (semverType == SemverType.NPM && (strTrim.startsWith("v") || strTrim.startsWith(ExifInterface.GPS_MEASUREMENT_INTERRUPTED))) {
            strTrim = strTrim.substring(1).trim();
        }
        this.value = strTrim;
        String[] strArrSplit2 = hasPreRelease(strTrim) ? strTrim.split("-", 2) : new String[]{strTrim};
        try {
            Integer numValueOf2 = null;
            if (strArrSplit2.length != 1) {
                strArr = strArrSplit2;
                c = 1;
                strArrSplit = strArr[0].split("\\.");
                str2 = null;
            } else {
                if (strArrSplit2[0].endsWith(Marker.ANY_NON_NULL_MARKER)) {
                    throw new SemverException("The build cannot be empty.");
                }
                String[] strArrSplit3 = strArrSplit2[0].split("\\+");
                c = 1;
                String[] strArrSplit4 = strArrSplit3[0].split("\\.");
                strArr = strArrSplit2;
                str2 = strArrSplit3.length == 2 ? strArrSplit3[1] : null;
                strArrSplit = strArrSplit4;
            }
            try {
                this.major = Integer.valueOf(strArrSplit[0]);
                try {
                    numValueOf = Integer.valueOf(strArrSplit[c]);
                } catch (IndexOutOfBoundsException unused) {
                    if (semverType == SemverType.STRICT) {
                        throw new SemverException("Invalid version (no minor version): " + strTrim);
                    }
                    numValueOf = null;
                } catch (NumberFormatException unused2) {
                    if (semverType != SemverType.NPM || (!"x".equalsIgnoreCase(strArrSplit[c]) && !"*".equals(strArrSplit[c]))) {
                        throw new SemverException("Invalid version (no minor version): " + strTrim);
                    }
                    numValueOf = null;
                }
                try {
                    numValueOf2 = Integer.valueOf(strArrSplit[2]);
                } catch (IndexOutOfBoundsException unused3) {
                    if (semverType == SemverType.STRICT) {
                        throw new SemverException("Invalid version (no patch version): " + strTrim);
                    }
                } catch (NumberFormatException unused4) {
                    if (semverType != SemverType.NPM || (!"x".equalsIgnoreCase(strArrSplit[2]) && !"*".equals(strArrSplit[2]))) {
                        throw new SemverException("Invalid version (no patch version): " + strTrim);
                    }
                }
                Integer num = numValueOf2;
                this.minor = numValueOf;
                this.patch = num;
                String[] strArrSplit5 = new String[0];
                try {
                    if (strArr[c].endsWith(Marker.ANY_NON_NULL_MARKER)) {
                        throw new SemverException("The build cannot be empty.");
                    }
                    String[] strArrSplit6 = strArr[c].split("\\+");
                    if (strArrSplit6.length == 2) {
                        strArrSplit5 = strArrSplit6[0].split("\\.");
                        str2 = strArrSplit6[c];
                    } else {
                        strArrSplit5 = strArr[c].split("\\.");
                    }
                    this.suffixTokens = strArrSplit5;
                    this.build = str2;
                    validate(semverType);
                } catch (IndexOutOfBoundsException unused5) {
                }
            } catch (IndexOutOfBoundsException unused6) {
                throw new SemverException("Invalid version (no major version): " + strTrim);
            } catch (NumberFormatException unused7) {
                throw new SemverException("Invalid version (no major version): " + strTrim);
            }
        } catch (IndexOutOfBoundsException unused8) {
            throw new SemverException("The version is invalid: " + strTrim);
        } catch (NumberFormatException unused9) {
            throw new SemverException("The version is invalid: " + strTrim);
        }
    }

    private void validate(SemverType semverType) {
        if (this.minor == null && semverType == SemverType.STRICT) {
            throw new SemverException("Invalid version (no minor version): " + this.value);
        }
        if (this.patch == null && semverType == SemverType.STRICT) {
            throw new SemverException("Invalid version (no patch version): " + this.value);
        }
    }

    private boolean hasPreRelease(String str) {
        int iIndexOf = this.value.indexOf(Marker.ANY_NON_NULL_MARKER);
        int iIndexOf2 = this.value.indexOf("-");
        if (iIndexOf2 == -1) {
            return false;
        }
        return iIndexOf == -1 || iIndexOf2 < iIndexOf;
    }

    public boolean satisfies(Requirement requirement) {
        return requirement.isSatisfiedBy(this);
    }

    /* INFO: renamed from: com.vdurmont.semver4j.Semver$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$vdurmont$semver4j$Semver$SemverType;

        static {
            int[] iArr = new int[SemverType.values().length];
            $SwitchMap$com$vdurmont$semver4j$Semver$SemverType = iArr;
            try {
                iArr[SemverType.STRICT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$vdurmont$semver4j$Semver$SemverType[SemverType.LOOSE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$vdurmont$semver4j$Semver$SemverType[SemverType.NPM.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$vdurmont$semver4j$Semver$SemverType[SemverType.COCOAPODS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$vdurmont$semver4j$Semver$SemverType[SemverType.IVY.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public boolean satisfies(String str) {
        Requirement requirementBuildStrict;
        int i = AnonymousClass1.$SwitchMap$com$vdurmont$semver4j$Semver$SemverType[this.type.ordinal()];
        if (i == 1) {
            requirementBuildStrict = Requirement.buildStrict(str);
        } else if (i == 2) {
            requirementBuildStrict = Requirement.buildLoose(str);
        } else if (i == 3) {
            requirementBuildStrict = Requirement.buildNPM(str);
        } else if (i == 4) {
            requirementBuildStrict = Requirement.buildCocoapods(str);
        } else if (i == 5) {
            requirementBuildStrict = Requirement.buildIvy(str);
        } else {
            throw new SemverException("Invalid requirement type: " + this.type);
        }
        return satisfies(requirementBuildStrict);
    }

    public boolean isGreaterThan(String str) {
        return isGreaterThan(new Semver(str, getType()));
    }

    public boolean isGreaterThan(Semver semver) {
        int iCompareToIgnoreCase;
        if (getMajor().intValue() > semver.getMajor().intValue()) {
            return true;
        }
        if (getMajor().intValue() < semver.getMajor().intValue()) {
            return false;
        }
        if (this.type == SemverType.NPM && semver.getMinor() == null) {
            return false;
        }
        int iIntValue = semver.getMinor() != null ? semver.getMinor().intValue() : 0;
        if (getMinor() != null && getMinor().intValue() > iIntValue) {
            return true;
        }
        if (getMinor() != null && getMinor().intValue() < iIntValue) {
            return false;
        }
        if (this.type == SemverType.NPM && semver.getPatch() == null) {
            return false;
        }
        int iIntValue2 = semver.getPatch() != null ? semver.getPatch().intValue() : 0;
        if (getPatch() != null && getPatch().intValue() > iIntValue2) {
            return true;
        }
        if (getPatch() != null && getPatch().intValue() < iIntValue2) {
            return false;
        }
        String[] suffixTokens = getSuffixTokens();
        String[] suffixTokens2 = semver.getSuffixTokens();
        if (suffixTokens.length == 0 && suffixTokens2.length > 0) {
            return true;
        }
        if (suffixTokens2.length == 0 && suffixTokens.length > 0) {
            return false;
        }
        for (int i = 0; i < suffixTokens.length && i < suffixTokens2.length; i++) {
            try {
                iCompareToIgnoreCase = Integer.valueOf(suffixTokens[i]).intValue() - Integer.valueOf(suffixTokens2[i]).intValue();
            } catch (NumberFormatException unused) {
                iCompareToIgnoreCase = suffixTokens[i].compareToIgnoreCase(suffixTokens2[i]);
            }
            if (iCompareToIgnoreCase < 0) {
                return false;
            }
            if (iCompareToIgnoreCase > 0) {
                return true;
            }
        }
        return suffixTokens.length > suffixTokens2.length;
    }

    public boolean isGreaterThanOrEqualTo(String str) {
        return isGreaterThanOrEqualTo(new Semver(str, this.type));
    }

    public boolean isGreaterThanOrEqualTo(Semver semver) {
        return isGreaterThan(semver) || isEquivalentTo(semver);
    }

    public boolean isLowerThan(String str) {
        return isLowerThan(new Semver(str, this.type));
    }

    public boolean isLowerThan(Semver semver) {
        return (isGreaterThan(semver) || isEquivalentTo(semver)) ? false : true;
    }

    public boolean isLowerThanOrEqualTo(String str) {
        return isLowerThanOrEqualTo(new Semver(str, this.type));
    }

    public boolean isLowerThanOrEqualTo(Semver semver) {
        return !isGreaterThan(semver);
    }

    public boolean isEquivalentTo(String str) {
        return isEquivalentTo(new Semver(str, this.type));
    }

    public boolean isEquivalentTo(Semver semver) {
        Semver semver2 = getBuild() == null ? this : new Semver(getValue().replace(Marker.ANY_NON_NULL_MARKER + getBuild(), ""));
        if (semver.getBuild() != null) {
            semver = new Semver(semver.getValue().replace(Marker.ANY_NON_NULL_MARKER + semver.getBuild(), ""));
        }
        return semver2.isEqualTo(semver);
    }

    public boolean isEqualTo(String str) {
        return isEqualTo(new Semver(str, this.type));
    }

    public boolean isEqualTo(Semver semver) {
        if (this.type == SemverType.NPM) {
            if (getMajor() != semver.getMajor()) {
                return false;
            }
            if (semver.getMinor() == null || semver.getPatch() == null) {
                return true;
            }
        }
        return equals(semver);
    }

    public boolean isStable() {
        if (getMajor() == null || getMajor().intValue() <= 0) {
            return false;
        }
        return getSuffixTokens() == null || getSuffixTokens().length == 0;
    }

    public VersionDiff diff(String str) {
        return diff(new Semver(str, this.type));
    }

    public VersionDiff diff(Semver semver) {
        if (!Objects.equals(this.major, semver.getMajor())) {
            return VersionDiff.MAJOR;
        }
        if (!Objects.equals(this.minor, semver.getMinor())) {
            return VersionDiff.MINOR;
        }
        if (!Objects.equals(this.patch, semver.getPatch())) {
            return VersionDiff.PATCH;
        }
        if (areSameSuffixes(semver.getSuffixTokens())) {
            return !Objects.equals(this.build, semver.getBuild()) ? VersionDiff.BUILD : VersionDiff.NONE;
        }
        return VersionDiff.SUFFIX;
    }

    private boolean areSameSuffixes(String[] strArr) {
        String[] strArr2 = this.suffixTokens;
        if (strArr2 == null && strArr == null) {
            return true;
        }
        if (strArr2 == null || strArr == null || strArr2.length != strArr.length) {
            return false;
        }
        int i = 0;
        while (true) {
            String[] strArr3 = this.suffixTokens;
            if (i >= strArr3.length) {
                return true;
            }
            if (!strArr3[i].equals(strArr[i])) {
                return false;
            }
            i++;
        }
    }

    public Semver toStrict() {
        Integer num = this.minor;
        Integer numValueOf = Integer.valueOf(num != null ? num.intValue() : 0);
        Integer num2 = this.patch;
        return create(SemverType.STRICT, this.major.intValue(), numValueOf, Integer.valueOf(num2 != null ? num2.intValue() : 0), this.suffixTokens, this.build);
    }

    public Semver withIncMajor() {
        return withIncMajor(1);
    }

    public Semver withIncMajor(int i) {
        return withInc(i, 0, 0);
    }

    public Semver withIncMinor() {
        return withIncMinor(1);
    }

    public Semver withIncMinor(int i) {
        return withInc(0, i, 0);
    }

    public Semver withIncPatch() {
        return withIncPatch(1);
    }

    public Semver withIncPatch(int i) {
        return withInc(0, 0, i);
    }

    private Semver withInc(int i, int i2, int i3) {
        Integer numValueOf = this.minor;
        Integer numValueOf2 = this.patch;
        if (numValueOf != null) {
            numValueOf = Integer.valueOf(numValueOf.intValue() + i2);
        }
        Integer num = numValueOf;
        if (this.patch != null) {
            numValueOf2 = Integer.valueOf(numValueOf2.intValue() + i3);
        }
        return with(this.major.intValue() + i, num, numValueOf2, true, true);
    }

    public Semver withClearedSuffix() {
        return with(this.major.intValue(), this.minor, this.patch, false, true);
    }

    public Semver withClearedBuild() {
        return with(this.major.intValue(), this.minor, this.patch, true, false);
    }

    public Semver withClearedSuffixAndBuild() {
        return with(this.major.intValue(), this.minor, this.patch, false, false);
    }

    public Semver withSuffix(String str) {
        return with(this.major.intValue(), this.minor, this.patch, str.split("\\."), this.build);
    }

    public Semver withBuild(String str) {
        return with(this.major.intValue(), this.minor, this.patch, this.suffixTokens, str);
    }

    public Semver nextMajor() {
        return with(this.major.intValue() + 1, (Integer) 0, (Integer) 0, false, false);
    }

    public Semver nextMinor() {
        return with(this.major.intValue(), Integer.valueOf(this.minor.intValue() + 1), (Integer) 0, false, false);
    }

    public Semver nextPatch() {
        return with(this.major.intValue(), this.minor, Integer.valueOf(this.patch.intValue() + 1), false, false);
    }

    private Semver with(int i, Integer num, Integer num2, boolean z, boolean z2) {
        Integer num3 = this.minor != null ? num : null;
        Integer num4 = this.patch != null ? num2 : null;
        String str = z2 ? this.build : null;
        return create(this.type, i, num3, num4, z ? this.suffixTokens : null, str);
    }

    private Semver with(int i, Integer num, Integer num2, String[] strArr, String str) {
        return create(this.type, i, this.minor != null ? num : null, this.patch != null ? num2 : null, strArr, str);
    }

    private static Semver create(SemverType semverType, int i, Integer num, Integer num2, String[] strArr, String str) {
        StringBuilder sbAppend = new StringBuilder().append(i);
        if (num != null) {
            sbAppend.append(BranchConfig.LOCAL_REPOSITORY).append(num);
        }
        if (num2 != null) {
            sbAppend.append(BranchConfig.LOCAL_REPOSITORY).append(num2);
        }
        if (strArr != null) {
            boolean z = true;
            for (String str2 : strArr) {
                if (z) {
                    sbAppend.append("-");
                    z = false;
                } else {
                    sbAppend.append(BranchConfig.LOCAL_REPOSITORY);
                }
                sbAppend.append(str2);
            }
        }
        if (str != null) {
            sbAppend.append(Marker.ANY_NON_NULL_MARKER).append(str);
        }
        return new Semver(sbAppend.toString(), semverType);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Semver) {
            return this.value.equals(((Semver) obj).value);
        }
        return false;
    }

    public int hashCode() {
        return this.value.hashCode();
    }

    @Override // java.lang.Comparable
    public int compareTo(Semver semver) {
        if (isGreaterThan(semver)) {
            return 1;
        }
        return isLowerThan(semver) ? -1 : 0;
    }

    public String toString() {
        return getValue();
    }

    public String getOriginalValue() {
        return this.originalValue;
    }

    public String getValue() {
        return this.value;
    }

    public Integer getMajor() {
        return this.major;
    }

    public Integer getMinor() {
        return this.minor;
    }

    public Integer getPatch() {
        return this.patch;
    }

    public String[] getSuffixTokens() {
        return this.suffixTokens;
    }

    public String getBuild() {
        return this.build;
    }

    public SemverType getType() {
        return this.type;
    }
}
