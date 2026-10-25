package com.magneticchen.daijishou.view_models;

import androidx.lifecycle.LiveData;
import com.magneticchen.daijishou.daijishou_library_db.PlatformEntity;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: compiled from: LibraryViewModel.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u0001¢\u0006\u0002\b\u000328\u0010\u0004\u001a4\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0007 \b*\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0005¢\u0006\u0002\b\u00030\u0005¢\u0006\u0002\b\u0003H\n¢\u0006\u0002\b\t"}, d2 = {"<anonymous>", "Landroidx/lifecycle/LiveData;", "Lcom/magneticchen/daijishou/daijishou_library_db/PlatformEntity;", "Lkotlin/jvm/JvmSuppressWildcards;", "it", "Lkotlin/Pair;", "", "", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
final class LibraryViewModel$selectedPlatformEntityLiveData$1 extends Lambda<LiveData<PlatformEntity>> implements Function1<Pair<Long, Boolean>, LiveData<PlatformEntity>> {
    final /* synthetic */ LibraryViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LibraryViewModel$selectedPlatformEntityLiveData$1(LibraryViewModel libraryViewModel) {
        super(1);
        this.this$0 = libraryViewModel;
    }

    @Override // kotlin.jvm.functions.Function1
    public final LiveData<PlatformEntity> invoke(Pair<Long, Boolean> pair) {
        Long first = pair.getFirst();
        if (first != null) {
            return this.this$0.daijishouLibraryRepository.getPlatformById(first.longValue());
        }
        return null;
    }
}
