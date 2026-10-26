package com.google.common.reflect;

import com.google.common.base.Predicate;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes4.dex */
public final /* synthetic */ class ClassPath$$ExternalSyntheticLambda0 implements Predicate {
    @Override // com.google.common.base.Predicate
    public final boolean apply(Object obj) {
        return ((ClassPath.ClassInfo) obj).isTopLevel();
    }
}
