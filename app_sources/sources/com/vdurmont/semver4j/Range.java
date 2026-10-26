package com.vdurmont.semver4j;

import java.util.Objects;

/* INFO: loaded from: classes4.dex */
public class Range {
    protected final RangeOperator op;
    protected final Semver version;

    public Range(Semver semver, RangeOperator rangeOperator) {
        this.version = semver;
        this.op = rangeOperator;
    }

    public Range(String str, RangeOperator rangeOperator) {
        this(new Semver(str, Semver.SemverType.LOOSE), rangeOperator);
    }

    public boolean isSatisfiedBy(String str) {
        return isSatisfiedBy(new Semver(str, this.version.getType()));
    }

    /* INFO: renamed from: com.vdurmont.semver4j.Range$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$vdurmont$semver4j$Range$RangeOperator;

        static {
            int[] iArr = new int[RangeOperator.values().length];
            $SwitchMap$com$vdurmont$semver4j$Range$RangeOperator = iArr;
            try {
                iArr[RangeOperator.EQ.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$vdurmont$semver4j$Range$RangeOperator[RangeOperator.LT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$vdurmont$semver4j$Range$RangeOperator[RangeOperator.LTE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$vdurmont$semver4j$Range$RangeOperator[RangeOperator.GT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$vdurmont$semver4j$Range$RangeOperator[RangeOperator.GTE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public boolean isSatisfiedBy(Semver semver) {
        int i = AnonymousClass1.$SwitchMap$com$vdurmont$semver4j$Range$RangeOperator[this.op.ordinal()];
        if (i == 1) {
            return semver.isEquivalentTo(this.version);
        }
        if (i == 2) {
            return semver.isLowerThan(this.version);
        }
        if (i == 3) {
            return semver.isLowerThan(this.version) || semver.isEquivalentTo(this.version);
        }
        if (i == 4) {
            return semver.isGreaterThan(this.version);
        }
        if (i == 5) {
            return semver.isGreaterThan(this.version) || semver.isEquivalentTo(this.version);
        }
        throw new RuntimeException("Code error. Unknown RangeOperator: " + this.op);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Range)) {
            return false;
        }
        Range range = (Range) obj;
        return Objects.equals(this.version, range.version) && this.op == range.op;
    }

    public int hashCode() {
        return Objects.hash(this.version, this.op);
    }

    public String toString() {
        return this.op.asString() + this.version;
    }

    public enum RangeOperator {
        EQ("="),
        LT("<"),
        LTE("<="),
        GT(">"),
        GTE(">=");

        private final String s;

        RangeOperator(String str) {
            this.s = str;
        }

        public String asString() {
            return this.s;
        }
    }
}
