package org.eclipse.jgit.util;

import java.time.format.DateTimeFormatter;
import java.util.function.Function;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes5.dex */
public final /* synthetic */ class GitTimeParser$$ExternalSyntheticLambda0 implements Function {
    public final /* synthetic */ GitTimeParser.ParseableSimpleDateFormat f$0;

    public /* synthetic */ GitTimeParser$$ExternalSyntheticLambda0(GitTimeParser.ParseableSimpleDateFormat parseableSimpleDateFormat) {
        this.f$0 = parseableSimpleDateFormat;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        return DateTimeFormatter.ofPattern(this.f$0.formatStr).withLocale(SystemReader.getInstance().getLocale());
    }
}
