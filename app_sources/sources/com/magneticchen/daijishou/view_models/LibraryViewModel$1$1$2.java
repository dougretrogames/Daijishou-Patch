package com.magneticchen.daijishou.view_models;

import java.util.Date;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* INFO: compiled from: LibraryViewModel.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "invoke", "(Ljava/lang/Long;)V"}, k = 3, mv = {1, 9, 0}, xi = 48)
final class LibraryViewModel$1$1$2 extends Lambda<Unit> implements Function1<Long, Unit> {
    final /* synthetic */ Date $newlyDate;
    final /* synthetic */ long $platformId;
    final /* synthetic */ Date $recentDate;
    final /* synthetic */ LibraryViewModel this$0;

    /* WARN: 'super' call moved to the top of the method (can break code semantics) */
    LibraryViewModel$1$1$2(LibraryViewModel libraryViewModel, long j, Date date, Date date2) {
        super(1);
        this.this$0 = libraryViewModel;
        this.$platformId = j;
        this.$recentDate = date;
        this.$newlyDate = date2;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Long l) {
        invoke2(l);
        return Unit.INSTANCE;
    }

    /* INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Long l) {
        LibraryViewModel.invoke$lambda$0$refreshCurrentPlatformStatistics(this.this$0, this.$platformId, this.$recentDate, this.$newlyDate);
    }
}
