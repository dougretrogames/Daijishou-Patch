package com.google.common.base;

/* INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
interface PatternCompiler {
    CommonPattern compile(String pattern);

    boolean isPcreLike();
}
