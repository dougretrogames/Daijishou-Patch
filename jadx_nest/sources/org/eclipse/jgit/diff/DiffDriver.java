package org.eclipse.jgit.diff;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import org.eclipse.jgit.lib.CommitConfig$$ExternalSyntheticBackport0;

/* JADX INFO: loaded from: classes5.dex */
public enum DiffDriver {
    cpp(CommitConfig$$ExternalSyntheticBackport0.m(new Object[]{"^[ \\t]*[A-Za-z_][A-Za-z_0-9]*:\\s*($|/[/*])"}), CommitConfig$$ExternalSyntheticBackport0.m(new Object[]{"^((::\\s*)?[A-Za-z_].*)$"})),
    dts(CommitConfig$$ExternalSyntheticBackport0.m(new Object[]{";", "="}), CommitConfig$$ExternalSyntheticBackport0.m(new Object[]{"^[ \\t]*((/[ \\t]*\\{|&?[a-zA-Z_]).*)"})),
    java(CommitConfig$$ExternalSyntheticBackport0.m(new Object[]{"^[ \\t]*(catch|do|for|if|instanceof|new|return|switch|throw|while)"}), CommitConfig$$ExternalSyntheticBackport0.m(new Object[]{"^[ \\t]*(([a-z-]+[ \\t]+)*(class|enum|interface|record)[ \\t]+.*)$", "^[ \\t]*(([A-Za-z_<>&\\]\\[][?&<>.,A-Za-z_0-9]*[ \\t]+)+[A-Za-z_][A-Za-z_0-9]*[ \\t]*\\([^;]*)$"})),
    python(CommitConfig$$ExternalSyntheticBackport0.m(new Object[]{"^[ \\t]*((class|(async[ \\t]+)?def)[ \\t].*)$"})),
    rust(CommitConfig$$ExternalSyntheticBackport0.m(new Object[]{"^[\\t ]*((pub(\\([^\\)]+\\))?[\\t ]+)?((async|const|unsafe|extern([\\t ]+\"[^\"]+\"))[\\t ]+)?(struct|enum|union|mod|trait|fn|impl|macro_rules!)[< \\t]+[^;]*)$"}));

    private final List<Pattern> matchPatterns;
    private final List<Pattern> negatePatterns;

    /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
    public static DiffDriver[] valuesCustom() {
        DiffDriver[] diffDriverArrValuesCustom = values();
        int length = diffDriverArrValuesCustom.length;
        DiffDriver[] diffDriverArr = new DiffDriver[length];
        System.arraycopy(diffDriverArrValuesCustom, 0, diffDriverArr, 0, length);
        return diffDriverArr;
    }

    DiffDriver(List list, List list2, int i) {
        if (list != null) {
            this.negatePatterns = (List) list.stream().map(new DiffDriver$$ExternalSyntheticLambda0(i)).collect(Collectors.toList());
        } else {
            this.negatePatterns = null;
        }
        this.matchPatterns = (List) list2.stream().map(new DiffDriver$$ExternalSyntheticLambda1(i)).collect(Collectors.toList());
    }

    DiffDriver(List list) {
        this(null, list, 0);
    }

    DiffDriver(List list, List list2) {
        this(list, list2, 0);
    }

    public List<Pattern> getNegatePatterns() {
        return this.negatePatterns;
    }

    public List<Pattern> getMatchPatterns() {
        return this.matchPatterns;
    }
}
