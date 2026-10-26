package com.vdurmont.semver4j;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.codec.language.Soundex;
import org.apache.commons.collections4.CollectionUtils;
import org.eclipse.jgit.lib.BranchConfig;
import org.slf4j.Marker;

/* INFO: loaded from: classes4.dex */
public class Requirement {
    protected final RequirementOperator op;
    protected final Range range;
    protected final Requirement req1;
    protected final Requirement req2;
    private static final Pattern IVY_DYNAMIC_PATCH_PATTERN = Pattern.compile("(\\d+)\\.(\\d+)\\.\\+");
    private static final Pattern IVY_DYNAMIC_MINOR_PATTERN = Pattern.compile("(\\d+)\\.\\+");
    private static final Pattern IVY_LATEST_PATTERN = Pattern.compile("latest\\.\\w+");
    private static final Pattern IVY_MATH_BOUNDED_PATTERN = Pattern.compile("(\\[|\\])([\\d\\.]+),([\\d\\.]+)(\\[|\\])");
    private static final Pattern IVY_MATH_LOWER_UNBOUNDED_PATTERN = Pattern.compile("\\(,([\\d\\.]+)(\\[|\\])");
    private static final Pattern IVY_MATH_UPPER_UNBOUNDED_PATTERN = Pattern.compile("(\\[|\\])([\\d\\.]+),\\)");

    protected Requirement(Range range, Requirement requirement, RequirementOperator requirementOperator, Requirement requirement2) {
        this.range = range;
        this.req1 = requirement;
        this.op = requirementOperator;
        this.req2 = requirement2;
    }

    public static Requirement build(Semver semver) {
        return new Requirement(new Range(semver, Range.RangeOperator.EQ), null, null, null);
    }

    public static Requirement buildStrict(String str) {
        return build(new Semver(str, Semver.SemverType.STRICT));
    }

    public static Requirement buildLoose(String str) {
        return build(new Semver(str, Semver.SemverType.LOOSE));
    }

    public static Requirement buildNPM(String str) {
        if (str.isEmpty()) {
            str = "*";
        }
        return buildWithTokenizer(str, Semver.SemverType.NPM);
    }

    public static Requirement buildCocoapods(String str) {
        return buildWithTokenizer(str, Semver.SemverType.COCOAPODS);
    }

    private static Requirement buildWithTokenizer(String str, Semver.SemverType semverType) {
        return evaluateReversePolishNotation(toReversePolishNotation(addParentheses(removeFalsePositiveVersionRanges(Tokenizer.tokenize(str, semverType)))).iterator(), semverType);
    }

    public static Requirement buildIvy(String str) {
        try {
            return buildLoose(str);
        } catch (SemverException unused) {
            Matcher matcher = IVY_DYNAMIC_PATCH_PATTERN.matcher(str);
            if (matcher.find()) {
                int iIntValue = Integer.valueOf(matcher.group(1)).intValue();
                int iIntValue2 = Integer.valueOf(matcher.group(2)).intValue();
                return new Requirement(null, new Requirement(new Range(iIntValue + BranchConfig.LOCAL_REPOSITORY + iIntValue2 + ".0", Range.RangeOperator.GTE), null, null, null), RequirementOperator.AND, new Requirement(new Range(iIntValue + BranchConfig.LOCAL_REPOSITORY + (iIntValue2 + 1) + ".0", Range.RangeOperator.LT), null, null, null));
            }
            Matcher matcher2 = IVY_DYNAMIC_MINOR_PATTERN.matcher(str);
            if (matcher2.find()) {
                int iIntValue3 = Integer.valueOf(matcher2.group(1)).intValue();
                return new Requirement(null, new Requirement(new Range(iIntValue3 + ".0.0", Range.RangeOperator.GTE), null, null, null), RequirementOperator.AND, new Requirement(new Range((iIntValue3 + 1) + ".0.0", Range.RangeOperator.LT), null, null, null));
            }
            if (IVY_LATEST_PATTERN.matcher(str).find()) {
                return new Requirement(new Range("0.0.0", Range.RangeOperator.GTE), null, null, null);
            }
            Matcher matcher3 = IVY_MATH_BOUNDED_PATTERN.matcher(str);
            if (matcher3.find()) {
                return new Requirement(null, new Requirement(new Range(extrapolateVersion(new Semver(matcher3.group(2), Semver.SemverType.LOOSE)), CollectionUtils.DEFAULT_TOSTRING_PREFIX.equals(matcher3.group(1)) ? Range.RangeOperator.GTE : Range.RangeOperator.GT), null, null, null), RequirementOperator.AND, new Requirement(new Range(extrapolateVersion(new Semver(matcher3.group(3), Semver.SemverType.LOOSE)), CollectionUtils.DEFAULT_TOSTRING_SUFFIX.equals(matcher3.group(4)) ? Range.RangeOperator.LTE : Range.RangeOperator.LT), null, null, null));
            }
            Matcher matcher4 = IVY_MATH_LOWER_UNBOUNDED_PATTERN.matcher(str);
            if (matcher4.find()) {
                return new Requirement(new Range(extrapolateVersion(new Semver(matcher4.group(1), Semver.SemverType.LOOSE)), CollectionUtils.DEFAULT_TOSTRING_SUFFIX.equals(matcher4.group(2)) ? Range.RangeOperator.LTE : Range.RangeOperator.LT), null, null, null);
            }
            Matcher matcher5 = IVY_MATH_UPPER_UNBOUNDED_PATTERN.matcher(str);
            if (matcher5.find()) {
                return new Requirement(new Range(extrapolateVersion(new Semver(matcher5.group(2), Semver.SemverType.LOOSE)), CollectionUtils.DEFAULT_TOSTRING_PREFIX.equals(matcher5.group(1)) ? Range.RangeOperator.GTE : Range.RangeOperator.GT), null, null, null);
            }
            throw new SemverException("Invalid requirement");
        }
    }

    private static List<Tokenizer.Token> addParentheses(List<Tokenizer.Token> list) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new Tokenizer.Token(Tokenizer.TokenType.OPENING, "("));
        for (Tokenizer.Token token : list) {
            if (token.type == Tokenizer.TokenType.OR) {
                arrayList.add(new Tokenizer.Token(Tokenizer.TokenType.CLOSING, ")"));
                arrayList.add(token);
                arrayList.add(new Tokenizer.Token(Tokenizer.TokenType.OPENING, "("));
            } else {
                arrayList.add(token);
            }
        }
        arrayList.add(new Tokenizer.Token(Tokenizer.TokenType.CLOSING, ")"));
        return arrayList;
    }

    private static List<Tokenizer.Token> removeFalsePositiveVersionRanges(List<Tokenizer.Token> list) {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (i < list.size()) {
            Tokenizer.Token token = list.get(i);
            if (thereIsFalsePositiveVersionRange(list, i)) {
                i += 2;
                token = new Tokenizer.Token(Tokenizer.TokenType.VERSION, token.value + Soundex.SILENT_MARKER + list.get(i).value);
            }
            arrayList.add(token);
            i++;
        }
        return arrayList;
    }

    private static boolean thereIsFalsePositiveVersionRange(List<Tokenizer.Token> list, int i) {
        int i2 = i + 2;
        if (i2 >= list.size()) {
            return false;
        }
        Tokenizer.Token[] tokenArr = {list.get(i), list.get(i + 1), list.get(i2)};
        return tokenArr[0].type.equals(Tokenizer.TokenType.VERSION) && tokenArr[2].type.equals(Tokenizer.TokenType.VERSION) && tokenArr[1].type.equals(Tokenizer.TokenType.HYPHEN) && attemptToParse(tokenArr[2].value) == null;
    }

    private static Semver attemptToParse(String str) {
        try {
            return new Semver(str, Semver.SemverType.NPM);
        } catch (SemverException unused) {
            return null;
        }
    }

    private static List<Tokenizer.Token> toReversePolishNotation(List<Tokenizer.Token> list) {
        LinkedList linkedList = new LinkedList();
        Stack stack = new Stack();
        int i = 0;
        while (i < list.size()) {
            Tokenizer.Token token = list.get(i);
            int i2 = AnonymousClass1.$SwitchMap$com$vdurmont$semver4j$Tokenizer$TokenType[token.type.ordinal()];
            if (i2 == 1) {
                linkedList.push(token);
            } else if (i2 == 2) {
                while (((Tokenizer.Token) stack.peek()).type != Tokenizer.TokenType.OPENING) {
                    linkedList.push(stack.pop());
                }
                stack.pop();
                if (stack.size() > 0 && ((Tokenizer.Token) stack.peek()).type.isUnary()) {
                    linkedList.push(stack.pop());
                }
            } else if (token.type.isUnary()) {
                i++;
                linkedList.push(list.get(i));
                linkedList.push(token);
            } else {
                stack.push(token);
            }
            i++;
        }
        while (!stack.isEmpty()) {
            linkedList.push(stack.pop());
        }
        return linkedList;
    }

    private static Requirement evaluateReversePolishNotation(Iterator<Tokenizer.Token> it, Semver.SemverType semverType) {
        RequirementOperator requirementOperator;
        Range.RangeOperator rangeOperator;
        try {
            Tokenizer.Token next = it.next();
            if (next.type == Tokenizer.TokenType.VERSION) {
                if (!"*".equals(next.value) && (semverType != Semver.SemverType.NPM || !"latest".equals(next.value))) {
                    Semver semver = new Semver(next.value, semverType);
                    if (semver.getMinor() != null && semver.getPatch() != null) {
                        return new Requirement(new Range(semver, Range.RangeOperator.EQ), null, null, null);
                    }
                    return tildeRequirement(semver.getValue(), semverType);
                }
                return new Requirement(new Range("0.0.0", Range.RangeOperator.GTE), null, null, null);
            }
            if (next.type == Tokenizer.TokenType.HYPHEN) {
                return hyphenRequirement(it.next().value, it.next().value, semverType);
            }
            if (next.type.isUnary()) {
                Tokenizer.Token next2 = it.next();
                switch (next.type) {
                    case EQ:
                        rangeOperator = Range.RangeOperator.EQ;
                        break;
                    case LT:
                        rangeOperator = Range.RangeOperator.LT;
                        break;
                    case LTE:
                        rangeOperator = Range.RangeOperator.LTE;
                        break;
                    case GT:
                        rangeOperator = Range.RangeOperator.GT;
                        break;
                    case GTE:
                        rangeOperator = Range.RangeOperator.GTE;
                        break;
                    case TILDE:
                        return tildeRequirement(next2.value, semverType);
                    case CARET:
                        return caretRequirement(next2.value, semverType);
                    default:
                        throw new SemverException("Invalid requirement");
                }
                return new Requirement(new Range(next2.value, rangeOperator), null, null, null);
            }
            Requirement requirementEvaluateReversePolishNotation = evaluateReversePolishNotation(it, semverType);
            Requirement requirementEvaluateReversePolishNotation2 = evaluateReversePolishNotation(it, semverType);
            int i = AnonymousClass1.$SwitchMap$com$vdurmont$semver4j$Tokenizer$TokenType[next.type.ordinal()];
            if (i == 10) {
                requirementOperator = RequirementOperator.OR;
            } else if (i == 11) {
                requirementOperator = RequirementOperator.AND;
            } else {
                throw new SemverException("Invalid requirement");
            }
            return new Requirement(null, requirementEvaluateReversePolishNotation2, requirementOperator, requirementEvaluateReversePolishNotation);
        } catch (NoSuchElementException unused) {
            throw new SemverException("Invalid requirement");
        }
    }

    protected static Requirement tildeRequirement(String str, Semver.SemverType semverType) {
        String str2;
        if (semverType != Semver.SemverType.NPM && semverType != Semver.SemverType.COCOAPODS) {
            throw new SemverException("The tilde requirements are only compatible with NPM and Cocoapods.");
        }
        Semver semver = new Semver(str, semverType);
        Requirement requirement = new Requirement(new Range(extrapolateVersion(semver), Range.RangeOperator.GTE), null, null, null);
        int i = AnonymousClass1.$SwitchMap$com$vdurmont$semver4j$Semver$SemverType[semverType.ordinal()];
        if (i != 1) {
            if (i == 2) {
                if (semver.getMinor() != null) {
                    str2 = semver.getMajor() + BranchConfig.LOCAL_REPOSITORY + (semver.getMinor().intValue() + 1) + ".0";
                } else {
                    str2 = (semver.getMajor().intValue() + 1) + ".0.0";
                }
            } else {
                throw new SemverException("The tilde requirements are only compatible with NPM and Cocoapods.");
            }
        } else if (semver.getPatch() != null) {
            str2 = semver.getMajor() + BranchConfig.LOCAL_REPOSITORY + (semver.getMinor().intValue() + 1) + ".0";
        } else {
            if (semver.getMinor() == null) {
                return requirement;
            }
            str2 = (semver.getMajor().intValue() + 1) + ".0.0";
        }
        return new Requirement(null, requirement, RequirementOperator.AND, new Requirement(new Range(str2, Range.RangeOperator.LT), null, null, null));
    }

    protected static Requirement caretRequirement(String str, Semver.SemverType semverType) {
        String str2;
        if (semverType != Semver.SemverType.NPM) {
            throw new SemverException("The caret requirements are only compatible with NPM.");
        }
        Semver semver = new Semver(str, semverType);
        Requirement requirement = new Requirement(new Range(extrapolateVersion(semver), Range.RangeOperator.GTE), null, null, null);
        if (semver.getMajor().intValue() == 0) {
            if (semver.getMinor() == null) {
                str2 = "1.0.0";
            } else if (semver.getMinor().intValue() == 0) {
                if (semver.getPatch() == null) {
                    str2 = "0.1.0";
                } else {
                    str2 = "0.0." + (semver.getPatch().intValue() + 1);
                }
            } else {
                str2 = "0." + (semver.getMinor().intValue() + 1) + ".0";
            }
        } else {
            str2 = (semver.getMajor().intValue() + 1) + ".0.0";
        }
        return new Requirement(null, requirement, RequirementOperator.AND, new Requirement(new Range(str2, Range.RangeOperator.LT), null, null, null));
    }

    protected static Requirement hyphenRequirement(String str, String str2, Semver.SemverType semverType) {
        if (semverType != Semver.SemverType.NPM) {
            throw new SemverException("The hyphen requirements are only compatible with NPM.");
        }
        Semver semverExtrapolateVersion = extrapolateVersion(new Semver(str, semverType));
        Semver semver = new Semver(str2, semverType);
        Range.RangeOperator rangeOperator = Range.RangeOperator.LTE;
        if (semver.getMinor() == null || semver.getPatch() == null) {
            rangeOperator = Range.RangeOperator.LT;
            if (semver.getMinor() == null) {
                semver = extrapolateVersion(semver).withIncMajor();
            } else {
                semver = extrapolateVersion(semver).withIncMinor();
            }
        }
        return new Requirement(null, new Requirement(new Range(semverExtrapolateVersion, Range.RangeOperator.GTE), null, null, null), RequirementOperator.AND, new Requirement(new Range(semver, rangeOperator), null, null, null));
    }

    private static Semver extrapolateVersion(Semver semver) {
        StringBuilder sbAppend = new StringBuilder().append(semver.getMajor()).append(BranchConfig.LOCAL_REPOSITORY).append(semver.getMinor() == null ? 0 : semver.getMinor().intValue()).append(BranchConfig.LOCAL_REPOSITORY).append(semver.getPatch() == null ? 0 : semver.getPatch().intValue());
        boolean z = true;
        for (int i = 0; i < semver.getSuffixTokens().length; i++) {
            if (z) {
                sbAppend.append("-");
                z = false;
            } else {
                sbAppend.append(BranchConfig.LOCAL_REPOSITORY);
            }
            sbAppend.append(semver.getSuffixTokens()[i]);
        }
        if (semver.getBuild() != null) {
            sbAppend.append(Marker.ANY_NON_NULL_MARKER).append(semver.getBuild());
        }
        return new Semver(sbAppend.toString(), semver.getType());
    }

    public boolean isSatisfiedBy(String str) {
        if (this.range != null) {
            return isSatisfiedBy(new Semver(str, this.range.version.getType()));
        }
        return isSatisfiedBy(new Semver(str));
    }

    public boolean isSatisfiedBy(Semver semver) {
        Range range = this.range;
        if (range != null) {
            return range.isSatisfiedBy(semver);
        }
        int i = AnonymousClass1.$SwitchMap$com$vdurmont$semver4j$Requirement$RequirementOperator[this.op.ordinal()];
        if (i != 1) {
            if (i == 2) {
                return this.req1.isSatisfiedBy(semver) || this.req2.isSatisfiedBy(semver);
            }
            throw new RuntimeException("Code error. Unknown RequirementOperator: " + this.op);
        }
        try {
            List<Range> allRanges = getAllRanges(this, new ArrayList());
            Iterator<Range> it = allRanges.iterator();
            while (it.hasNext()) {
                if (!it.next().isSatisfiedBy(semver)) {
                    return false;
                }
            }
            if (semver.getSuffixTokens().length <= 0) {
                return true;
            }
            for (Range range2 : allRanges) {
                if (range2.version != null && range2.version.getSuffixTokens().length > 0) {
                    Semver semver2 = range2.version;
                    if (Objects.equals(semver.getMajor(), semver2.getMajor()) && Objects.equals(semver.getMinor(), semver2.getMinor()) && Objects.equals(semver.getPatch(), semver2.getPatch())) {
                        return true;
                    }
                }
            }
            return false;
        } catch (Exception unused) {
            return this.req1.isSatisfiedBy(semver) && this.req2.isSatisfiedBy(semver);
        }
    }

    /* INFO: renamed from: com.vdurmont.semver4j.Requirement$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$vdurmont$semver4j$Requirement$RequirementOperator;
        static final /* synthetic */ int[] $SwitchMap$com$vdurmont$semver4j$Semver$SemverType;

        static {
            int[] iArr = new int[RequirementOperator.values().length];
            $SwitchMap$com$vdurmont$semver4j$Requirement$RequirementOperator = iArr;
            try {
                iArr[RequirementOperator.AND.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$vdurmont$semver4j$Requirement$RequirementOperator[RequirementOperator.OR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[Semver.SemverType.values().length];
            $SwitchMap$com$vdurmont$semver4j$Semver$SemverType = iArr2;
            try {
                iArr2[Semver.SemverType.COCOAPODS.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$vdurmont$semver4j$Semver$SemverType[Semver.SemverType.NPM.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr3 = new int[Tokenizer.TokenType.values().length];
            $SwitchMap$com$vdurmont$semver4j$Tokenizer$TokenType = iArr3;
            try {
                iArr3[Tokenizer.TokenType.VERSION.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$vdurmont$semver4j$Tokenizer$TokenType[Tokenizer.TokenType.CLOSING.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$vdurmont$semver4j$Tokenizer$TokenType[Tokenizer.TokenType.EQ.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$vdurmont$semver4j$Tokenizer$TokenType[Tokenizer.TokenType.LT.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$vdurmont$semver4j$Tokenizer$TokenType[Tokenizer.TokenType.LTE.ordinal()] = 5;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$vdurmont$semver4j$Tokenizer$TokenType[Tokenizer.TokenType.GT.ordinal()] = 6;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$vdurmont$semver4j$Tokenizer$TokenType[Tokenizer.TokenType.GTE.ordinal()] = 7;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$vdurmont$semver4j$Tokenizer$TokenType[Tokenizer.TokenType.TILDE.ordinal()] = 8;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$com$vdurmont$semver4j$Tokenizer$TokenType[Tokenizer.TokenType.CARET.ordinal()] = 9;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$com$vdurmont$semver4j$Tokenizer$TokenType[Tokenizer.TokenType.OR.ordinal()] = 10;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$com$vdurmont$semver4j$Tokenizer$TokenType[Tokenizer.TokenType.AND.ordinal()] = 11;
            } catch (NoSuchFieldError unused15) {
            }
        }
    }

    private List<Range> getAllRanges(Requirement requirement, List<Range> list) {
        Range range = requirement.range;
        if (range != null) {
            list.add(range);
            return list;
        }
        if (requirement.op == RequirementOperator.AND) {
            getAllRanges(requirement.req1, list);
            getAllRanges(requirement.req2, list);
            return list;
        }
        throw new RuntimeException("OR in AND not allowed");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Requirement)) {
            return false;
        }
        Requirement requirement = (Requirement) obj;
        return Objects.equals(this.range, requirement.range) && Objects.equals(this.req1, requirement.req1) && this.op == requirement.op && Objects.equals(this.req2, requirement.req2);
    }

    public int hashCode() {
        return Objects.hash(this.range, this.req1, this.op, this.req2);
    }

    public String toString() {
        Range range = this.range;
        if (range != null) {
            return range.toString();
        }
        return this.req1 + " " + (this.op == RequirementOperator.OR ? this.op.asString() + " " : "") + this.req2;
    }

    protected enum RequirementOperator {
        AND(""),
        OR("||");

        private final String s;

        RequirementOperator(String str) {
            this.s = str;
        }

        public String asString() {
            return this.s;
        }
    }
}
