package com.magneticchen.daijishou.utils;

import java.time.LocalDateTime;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalQuery;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class UtilsKt$$ExternalSyntheticLambda0 implements TemporalQuery {
    @Override // java.time.temporal.TemporalQuery
    public final Object queryFrom(TemporalAccessor temporalAccessor) {
        return LocalDateTime.from(temporalAccessor);
    }
}
