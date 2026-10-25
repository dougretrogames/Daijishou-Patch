package com.magneticchen.daijishou.retro_achievements;

import java.time.LocalDateTime;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalQuery;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class RetroAchievementsManager$$ExternalSyntheticLambda0 implements TemporalQuery {
    @Override // java.time.temporal.TemporalQuery
    public final Object queryFrom(TemporalAccessor temporalAccessor) {
        return LocalDateTime.from(temporalAccessor);
    }
}
